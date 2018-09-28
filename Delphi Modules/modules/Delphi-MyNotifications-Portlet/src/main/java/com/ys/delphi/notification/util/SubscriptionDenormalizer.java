package com.ys.delphi.notification.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimerTask;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.ys.delphi.notification.consumer.FISAlarmConsumer;
import com.ys.delphi.notification.model.SubscriptionData;
import com.ys.delphi.notification.service.SubscriptionService;
import com.ys.delphi.notification.service.impl.SubscriptionServiceImpl;


public class SubscriptionDenormalizer {
	private static Log _log = LogFactoryUtil.getLog(SubscriptionDenormalizer.class);
	private SubscriptionService subscriptionService = new SubscriptionServiceImpl();

	public void explodeSubscriptions(){
		try{
			Calendar cal = Calendar.getInstance();
			long startTime = cal.getTimeInMillis(); 
			// read information from fis_subscription table in order
			List<SubscriptionData> originalList = getOriginalData();
			// processing each entry
			Map<Long,List> transformedMap = new HashMap<Long,List>();
			for(SubscriptionData sed: originalList){
				if(transformedMap.get(sed.getSubscriptionId()) == null ){
					List<SubscriptionData> updatedList = new ArrayList<SubscriptionData>();
					transformedMap.put(sed.getSubscriptionId(), updatedList);
				}
				// get the transformed data for each entry
				List<SubscriptionData> transformedData = getTransformedData(sed); 
				// add to the same transformedList in map
				transformedMap.get(sed.getSubscriptionId()).addAll(transformedData);
			}
			// wipe out the denormalized table and pause the kafka consumer process
			pauseKafkaConsumer();
			deleteDenomalizedData();
			Set<Long> keySet = transformedMap.keySet() ; 
			// insert and commit the map 
			for(Long key: keySet){
				List<SubscriptionData> transformedData = transformedMap.get(key);
				insertDataInTable(transformedData); 
			}
					
			// resume the consumer process
			resumeKafkaConsumer();
			
			Calendar cal2 = Calendar.getInstance();
			long endTime = cal2.getTimeInMillis(); 
			long timeTaken = endTime - startTime ; 
			_log.info("Time taken by the explode process is -> " + timeTaken);
		}
		catch(Exception ex){
			_log.error("The explodeSubscriptions process failed.");
			_log.error(ex);
		}
	}
	
	private List<SubscriptionData> getOriginalData () throws Exception{
		_log.debug("Fetching original normalized data");		
		List<SubscriptionData> originalList = subscriptionService.getAllSubscriptionData() ; 
		return originalList;
	}
	
	private SubscriptionData testDataGenerator(long subId, String reg, String site, String ser, String pt, String pf, String pn, String pr, String sn){
		SubscriptionData data = new SubscriptionData();
		data.setSubscriptionId(subId);
		data.setRegion(reg);
		data.setSite(site);
		data.setServer(ser);
		data.setProductType(pt);
		data.setProductFamily(pf);
		data.setPartNumber(pn);
		data.setProcess(pr);
		data.setStation(sn);
		
		return data;
	}
	
	private List<SubscriptionData> getTransformedData (SubscriptionData data) throws Exception{
		// Logic for creation of query for Hbase
		_log.debug("starting transformation for -> " + data.getSubscriptionId());		
		
		// If no field contains All then no transformation needed. 
		if(!data.isGeneric()){
			SubscriptionData transData = new SubscriptionData();
			transData.setSubscriptionId(data.getSubscriptionId());
			transData.setRegion(data.getRegion());
			transData.setProductType(data.getProductType());
			transData.setProductFamily(data.getProductFamily());
			transData.setSite(data.getSite());
			transData.setPartNumber(data.getPartNumber());
			transData.setProcess(data.getProcess());
			transData.setServer(data.getServer());
			transData.setStation(data.getStation());
			
			List<SubscriptionData> lst = new ArrayList<SubscriptionData>() ;
			lst.add(transData);
			return lst;
		}
		
		StringBuilder query = new StringBuilder();
		
		if(!data.getRegion().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("RN='").append(data.getRegion()).append("'"); 
		}
		if(!data.getSite().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("LOC='").append(data.getSite()).append("'"); 
		}
		if(!data.getServer().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("SV like '").append(data.getServer()).append("%'"); 
		}
		if(!data.getProductType().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("PT='").append(data.getProductType()).append("'");
		}
		if(!data.getProductFamily().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("PF='").append(data.getProductFamily()).append("'");
		}
		if(!data.getPartNumber().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("PN='").append(data.getPartNumber()).append("'");
		}
		if(!data.getProcess().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("PR='").append(data.getProcess()).append("'");
		}
		if(!data.getStation().equalsIgnoreCase("ALL")){
			if(query.length() > 0) query.append(" and ");
			query.append("SN='").append(data.getStation()).append("'") ; 
		}
		
		// Call HBase and return the result set 
		List<SubscriptionData> td = subscriptionService.getSubscriptionTransformedData(data.getSubscriptionId(), query.toString());
		return td;
	}
	
	private void insertDataInTable(List<SubscriptionData> transformedDataList) throws Exception{
		// Oracle DB call to insert the data in oracle database
		if(!transformedDataList.isEmpty()){
			_log.debug("saving transformation for -> " + transformedDataList.get(0).getSubscriptionId());		
			int count = subscriptionService.saveSubscriptionTransformedData(transformedDataList);
			_log.debug("Inserted entries for subscription " + count );
		}
	}

	private void deleteDenomalizedData() throws Exception{
		_log.debug("Going to delete complete denormalized data ");
		subscriptionService.cleanTransformedDataTable();
	}
	private void resumeKafkaConsumer(){
		_log.debug("Going to start kafka consumer ");		
		long offset = getOffsetFromFile();
		FISAlarmConsumer consumer = FISAlarmConsumer.getInstance(offset);
		consumer.resumeConsumer();;
	}
	private void pauseKafkaConsumer(){
		_log.debug("Going to pause kafka consumer ");
		long offset = getOffsetFromFile();
		FISAlarmConsumer consumer = FISAlarmConsumer.getInstance(offset);
		consumer.pauseConsumer();
	}
	
	 private String FILE_NAME= PropsUtil.get("kafka.offset.file");
	 private long getOffsetFromFile(){
			long offset = 0;
			Properties props = new Properties();
		    InputStream is = null;
		    _log.debug("Offset fileName : "+FILE_NAME);
			try {			
				File f = new File(FILE_NAME);
				 is = new FileInputStream( f );
				 props.load( is );		
				 offset = Long.parseLong(props.getProperty("offset"));
				 _log.debug("getOffsetFromFile, offset : " + offset);
			} catch (Exception io) {
				_log.error(io.getMessage());
				io.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			return offset;
		}
	
}
