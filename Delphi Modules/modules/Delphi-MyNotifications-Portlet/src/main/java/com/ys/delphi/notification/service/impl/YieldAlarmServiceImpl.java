package com.ys.delphi.notification.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ys.delphi.notification.model.YieldAlarmSubscriptionModel;
import com.ys.delphi.notification.model.YieldAlarmThresholdModel;
import com.ys.delphi.notification.model.YieldHistory;
import com.ys.delphi.notification.service.YieldAlarmService;

public class YieldAlarmServiceImpl implements YieldAlarmService{
	private static Log _log = LogFactoryUtil.getLog(YieldAlarmServiceImpl.class);

	private double calculateCurrentYield(long subscriptionId, int sampleSize) throws Exception {
		//  fetch the subscription model 
		List<YieldAlarmSubscriptionModel> subscriptionModels = fetchSubscriptionModel(subscriptionId);
		return calculateCurrentYield(subscriptionModels, sampleSize);
	}
	
	
	private List<YieldAlarmSubscriptionModel> fetchSubscriptionModel(long id){
		List<YieldAlarmSubscriptionModel> subscriptionModels = new ArrayList<YieldAlarmSubscriptionModel>();
		_log.info("fetchSubscriptionModel");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select SUBSCRIPTION_ID, REGION, LOCATION,SERVER,PRODUCT_TYPE,PRODUCT_FAMILY,PROCESS,STATION from fis_subscriptions where subscription_id = ? " ;
		_log.info(sql);
		
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, id);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 YieldAlarmSubscriptionModel subscription = new YieldAlarmSubscriptionModel();
				 subscription.setServer(rs.getString("SERVER"));
				 subscription.setSite(rs.getString("LOCATION"));
				 subscription.setProcess(rs.getString("PROCESS"));
				 subscription.setStation(rs.getString("STATION"));
				 subscription.setProductFamily(rs.getString("PRODUCT_FAMILY"));
				 subscription.setProductType(rs.getString("PRODUCT_TYPE"));
				 subscriptionModels.add(subscription); 
			 }
		}catch(Exception e){
			_log.error("error while retireving getAllSubscriptionData");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		} 
		return subscriptionModels; 	
		
	}
	
	private double calculateCurrentYield(List<YieldAlarmSubscriptionModel>  subModel, int count) throws Exception{
		boolean first = true; 
		StringBuilder sb = new StringBuilder("select  event, status from ( ");
		for(YieldAlarmSubscriptionModel model: subModel){
			if(first){
				first = false; 
			}
			else{
				sb.append(" UNION ALL ");
			}
			sb.append(getSubClause(model));
		}
		sb.append(") order by event desc limit ").append(count);
		String finalQuery = sb.toString(); 
		_log.error(finalQuery);
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int good = 0 ; 
		int total = 0 ; 
		double yield = 0.0 ;  
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			ps = connection.prepareStatement(finalQuery);
			rs = ps.executeQuery();
			
			while(rs.next()){	
				total ++; 
				int status = 0 ;
				if(subModel.size() > 1){
					status = rs.getInt("status");
				}
				else{
					status = rs.getInt("fis_status");
				}
				good = good + status ; 
			}
		}
		catch (Exception e1) {
			_log.error(e1);
			e1.printStackTrace();
			throw new Exception(e1);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
		if(total > 0 ){
			yield = ((double)good) * 100/ ((double)total) ; 
		}
		DecimalFormat newFormat = new DecimalFormat("#.#");
		double yieldDecimal =  Double.valueOf(newFormat.format(yield));
		return yieldDecimal ; 
	}
	
	private String getSubClause(YieldAlarmSubscriptionModel model) {
		StringBuilder sb = new StringBuilder(" \"fis_event_utc\" as event, \"fis_status\" as status from FIS_ARCHIVE_60DAY where  ");
		StringBuilder indexString = new StringBuilder("select ");
		boolean process = false; 
		boolean station = false; 
		boolean productType = false; 
		boolean productFamily = false ;
		boolean server = false; 

		if(model.getSite() != null && !model.getSite().equalsIgnoreCase("ALL")){
			sb.append( " \"fis_location\"='").append(model.getSite()).append("'");
		}
		if(model.getProcess() != null && !model.getProcess().equalsIgnoreCase("ALL")){
			sb.append( " and  \"fis_process\"='").append(model.getProcess()).append("'");
			process = true; 
		}
		if(model.getStation() != null && !model.getStation().equalsIgnoreCase("ALL")){
			sb.append( " and  \"fis_station\"='").append(model.getStation()).append("'");
			station = true; 
		}
		if(model.getProductFamily() != null && !model.getProductFamily().equalsIgnoreCase("ALL")){
			sb.append( " and  \"fis_familyproduct\"='").append(model.getProductFamily()).append("'");
			productFamily = true; 
		}
		if(model.getProductType() != null && !model.getProductType().equalsIgnoreCase("ALL")){
			sb.append( " and  \"fis_producttype\"='").append(model.getProductType()).append("'");
			productType = true; 
		}
		
		if(model.getServer() != null && !model.getServer().equalsIgnoreCase("ALL")){
			sb.append( " and  SERVERNAME like '").append(model.getServer()).append("%'");
			server = true; 
		}
		
		if(process){
			indexString.append(" /*+ INDEX(FIS_ARCHIVE_60DAY IX_FIS_ARCHIVE_60DAY1) */ ") ;
		}else if(station){
			indexString.append(" /*+ INDEX(FIS_ARCHIVE_60DAY IX_FIS_ARCHIVE_60DAY2) */ ") ;
		}else if(productType){
			indexString.append(" /*+ INDEX(FIS_ARCHIVE_60DAY IX_FIS_ARCHIVE_60DAY3) */ ") ;
		}else if(productFamily){
			indexString.append(" /*+ INDEX(FIS_ARCHIVE_60DAY IX_FIS_ARCHIVE_60DAY4) */ ") ;
		}else if(server){
			indexString.append(" /*+ INDEX(FIS_ARCHIVE_60DAY IX_FIS_ARCHIVE_60DAY5) */ ") ;
		}
		
		return indexString.toString() + sb.toString();
	}

	public YieldAlarmThresholdModel fetchThresholdStandardDeviation(long subscriptionId, String startTime) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		YieldAlarmThresholdModel model = new YieldAlarmThresholdModel();
		model.setSubscriptionId(subscriptionId);
		_log.error("Start Time is --> " + startTime);
		// as of now could not find a way to convert startDate to date as is in Oracle
		// date format - 2017-10-08 14:28:28.0
		
		if(startTime != null && startTime.endsWith(".0")){
			startTime = startTime.substring(0, startTime.lastIndexOf(".0"));
		}
		_log.error("Start Time is --> " + startTime);
		String sql = "select THRESHOLD, STANDARD_DEVIATION, SAMPLE_SIZE from YIELD_ALARM_THRESHOLD where SUBSCRIPTION_ID = ?  and CREATED_TIME <  TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss') order by CREATED_TIME desc  fetch first 1 row only" ;
		_log.error(sql);
		
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, subscriptionId);
			 ps.setString(2, startTime);

			 rs = ps.executeQuery();
			 while(rs.next()){
				 model.setThreshold(rs.getDouble("THRESHOLD"));
				 model.setStandardDeviation(rs.getDouble("STANDARD_DEVIATION"));
				 model.setSampleCount(rs.getInt("SAMPLE_SIZE"));
			 }
		}catch(Exception e){
			_log.error("error while retireving getAllSubscriptionData");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 
		return model; 	
	}


	@Override
	public YieldHistory getYieldHistory(long subscriptionId, double deviation, String startTime) throws Exception {
		YieldAlarmThresholdModel thresholdData = fetchThresholdStandardDeviation(subscriptionId, startTime);
		double currentYield = calculateCurrentYield(subscriptionId, thresholdData.getSampleCount());
		YieldHistory history = new YieldHistory(subscriptionId, thresholdData.getThreshold(), thresholdData.getStandardDeviation(), currentYield, deviation);
		return history;
	}
}
