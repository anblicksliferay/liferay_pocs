package com.ys.delphi.subscriptions.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.ys.delphi.subscriptions.model.SubscriptionData;
import com.ys.delphi.subscriptions.service.MySubscriptionService;
import com.ys.delphi.subscriptions.service.impl.MySubscriptionsImpl;

public class SubscriptionDenormalizerUtil {
	private static Log _log = LogFactoryUtil.getLog(SubscriptionDenormalizerUtil.class);

	private MySubscriptionService subscriptionService = new MySubscriptionsImpl();

	// when a new subscription is added 
	public void addDenomalizedDataForSubscription(long subscriptionId){
		try{
			List<SubscriptionData> originalList = subscriptionService.getSubscriptionDataForSubscription(subscriptionId);
			List<SubscriptionData> transformedList =  new ArrayList<SubscriptionData>() ;

			// processing each entry
			for(SubscriptionData sed: originalList){

				List<SubscriptionData> transformedData = getTransformedData(sed); 
				// add to the same transformedList 
				transformedList.addAll(transformedData);
			}
			// save the transformed data
			subscriptionService.saveSubscriptionTransformedData(transformedList);
		}
		catch(Exception ex){
			_log.error("The explodeSubscriptions process failed.");
			_log.error(ex);
		}
	}
	
	private List<SubscriptionData> getTransformedData (SubscriptionData data) throws Exception{
		// Logic for creation of query for Hbase
		_log.debug("starting transformation for -> " + data.getSubscriptionId());		
		
		// If no field contains All then no transformation needed. 
		if(!data.isGeneric()){
			_log.debug("Data is not generic.");
			_log.debug(data.toString());

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
		_log.debug("Data is generic.");
		_log.debug(data.toString());
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
		_log.debug("Number of rows in transformed data - " + td.size());

		return td;
	}

}
