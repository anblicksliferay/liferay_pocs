package com.ys.delphi.yieldalarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import com.ys.delphi.subscriptions.util.DelphiHbaseServerConnection;
import com.ys.delphi.yieldalarm.model.YieldAlarmDataPointModel;
import com.ys.delphi.yieldalarm.model.YieldAlarmSubscriptionModel;
import com.ys.delphi.yieldalarm.model.YieldAlarmThresholdModel;

public class YieldAlarmDAO {
	private static Log _log = LogFactoryUtil.getLog(YieldAlarmDAO.class);

	public List<Long>  fetchAllYieldAlarmSubscription() {
		_log.info("YieldAlarmDAO fetchAllYieldAlarmSubscription");
		List<Long> subscriptions = new ArrayList<Long>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select SUBSCRIPTION_ID from fis_subscriptions_catalog where SUB_TYPE = ?" ;
		_log.info(sql);
		
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setString(1, "Yield");

			 rs = ps.executeQuery();
			 while(rs.next()){
				 subscriptions.add(rs.getLong("SUBSCRIPTION_ID"));
			 }
		}catch(Exception e){
			_log.error("error while retireving getAllSubscriptionData");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		} 
		return subscriptions; 
	}
	
	public List<YieldAlarmSubscriptionModel> fetchSubscriptionModel(long id){
		List<YieldAlarmSubscriptionModel> subscriptionModels = new ArrayList<YieldAlarmSubscriptionModel>();
//		generateTestData(subscriptionModels);
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
	
	public List<YieldAlarmDataPointModel> fetchYieldAlarmDatapoints(List<YieldAlarmSubscriptionModel>  subModel) throws Exception{
		
		long start = Calendar.getInstance().getTimeInMillis();
		List<YieldAlarmDataPointModel> dataPointModel = new ArrayList<YieldAlarmDataPointModel>();
		boolean first = true; 
		StringBuilder sb = new StringBuilder("select  date, hour,count(status) as total, sum (status) as good from ( ");
		for(YieldAlarmSubscriptionModel model: subModel){
			if(first){
				first = false; 
			}
			else{
				sb.append(" UNION ALL ");
			}
			sb.append(getSubClause(model));
		}
		sb.append(") group by date , hour");
		String finalQuery = sb.toString(); 
		_log.info(finalQuery);
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			ps = connection.prepareStatement(finalQuery);
			rs = ps.executeQuery();
			
			while(rs.next()){	
				String date ; 
				int hour ; 
				if(subModel.size() == 1){
					date =  GetterUtil.getString(rs.getString("fis_date_utc"));
					hour = rs.getInt("fis_hour_utc");
				}
				else{
					date =  GetterUtil.getString(rs.getString("date"));
					hour = rs.getInt("hour");
				}
				int good = rs.getInt("good");
				int total = rs.getInt("total");
				YieldAlarmDataPointModel yadpm = new YieldAlarmDataPointModel(date, hour, good, total);
				dataPointModel.add(yadpm);
			}
		}
		catch (Exception e1) {
			_log.error(e1);
			e1.printStackTrace();
			throw new Exception(e1);
		} finally {
				DelphiHbaseServerConnection.close(connection, ps, rs);
		}
		long end = Calendar.getInstance().getTimeInMillis();
		_log.info("------------- Total Time for calculation of Yield Alarm Threshold - "+ (end-start) + " ---------------");

		return dataPointModel ; 
	}
	
	
	public String getSubClause(YieldAlarmSubscriptionModel model) {
		StringBuilder sb = new StringBuilder(" \"fis_date_utc\" as date, \"fis_hour_utc\" as hour, \"fis_status\" as status from FIS_ARCHIVE_60DAY where \"fis_event_utc\" > CURRENT_DATE() - 30 ");
		StringBuilder indexString = new StringBuilder("select ");
		boolean process = false; 
		boolean station = false; 
		boolean productType = false; 
		boolean productFamily = false ;
		boolean server = false; 
		
		if(model.getSite() != null && !model.getSite().equalsIgnoreCase("ALL")){
			sb.append( " and  \"fis_location\"='").append(model.getSite()).append("'");
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
	
	public void saveYieldAlarmThreshold(YieldAlarmThresholdModel  thresholdModel){
		Connection con = null;
		PreparedStatement ps = null;
		String insertSQL = "insert INTO YIELD_ALARM_THRESHOLD (SUBSCRIPTION_ID, THRESHOLD, SAMPLE_SIZE,STANDARD_DEVIATION, CREATED_TIME) values (?,?,?,?,?) ";
		_log.info(insertSQL);
		_log.info(thresholdModel.toString());

		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(insertSQL);
			ps.setLong(1,thresholdModel.getSubscriptionId() );
			ps.setDouble(2, thresholdModel.getThreshold());
			ps.setInt(3, thresholdModel.getSampleCount());
			ps.setDouble(4, thresholdModel.getStandardDeviation());
			ps.setTimestamp(5, date);
			ps.execute();
		}
		catch(Exception e){
				_log.error("error while updating saveYieldAlarmThreshold");
				_log.error(e);
		}
		finally{
			DataAccess.cleanUp(con,ps);
		}
	}
}
