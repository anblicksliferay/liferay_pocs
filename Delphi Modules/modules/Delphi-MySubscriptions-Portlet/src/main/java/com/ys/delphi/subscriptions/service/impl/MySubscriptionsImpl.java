package com.ys.delphi.subscriptions.service.impl;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ys.delphi.subscriptions.model.ProductProcess;
import com.ys.delphi.subscriptions.model.ProductProcessQuery;
import com.ys.delphi.subscriptions.model.RegionSiteServer;
import com.ys.delphi.subscriptions.model.RegionSiteServerList;
import com.ys.delphi.subscriptions.model.SubscribedDataProcess;
import com.ys.delphi.subscriptions.model.Subscription;
import com.ys.delphi.subscriptions.model.SubscriptionData;
import com.ys.delphi.subscriptions.model.SubscriptionUpdate;
import com.ys.delphi.subscriptions.service.MySubscriptionService;
import com.ys.delphi.subscriptions.util.DelphiHbaseServerConnection;
import com.ys.delphi.subscriptions.util.SubscriptionDenormalizerUtil;
import com.ys.delphi.yieldalarm.YieldAlarmThresholdCalculator;
import com.ys.delphi.yieldalarm.dao.YieldAlarmDAO;
import com.ys.delphi.yieldalarm.model.YieldAlarmThresholdModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.StringUtil;

public class MySubscriptionsImpl implements MySubscriptionService{
	
	private static Log _log = LogFactoryUtil.getLog(MySubscriptionsImpl.class);
	

	@Override
	public RegionSiteServerList getRegionSiteServerList() throws Exception {
		// TODO Auto-generated method stub
		_log.debug("getRegionSiteList");
		RegionSiteServerList  regionSiteList = new RegionSiteServerList();
		List<RegionSiteServer> regionSiteServers = new ArrayList<RegionSiteServer>();
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
		delphiConn = DelphiHbaseServerConnection.getConnection();
		delphiStmt = delphiConn.prepareStatement("Select distinct RN, LOC, SV From FIS_PART_THRESHOLDS");
		
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				RegionSiteServer rs = new RegionSiteServer( delphiRS.getString("SV"), delphiRS.getString("RN"), delphiRS.getString("LOC"));
				regionSiteServers.add(rs);
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		}finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}
		
		regionSiteList.setRegiosSitesSerevers(regionSiteServers);
		return regionSiteList;
	}

	@Override
	public List<Subscription> getSubscriptions(long userId) throws Exception {
		List<Subscription> mySubscriptions = new ArrayList<Subscription>();
		_log.debug("addSubscription process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "Select * From fis_subscriptions_catalog WHERE USER_ID=" + userId;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 String desc = "";
				 if(!rs.getString("SUB_DESC").isEmpty()){
					 desc = rs.getString("SUB_DESC");
				 }
				 mySubscriptions.add(new Subscription(rs.getInt("SUBSCRIPTION_ID"), rs.getString("SUB_NAME"),  rs.getString("SUB_TYPE"), desc, rs.getInt("SUB_LEVEL_INFO_NOTIFY"), rs.getInt("SUB_LEVEL_WARN_NOTIFY"), rs.getInt("SUB_LEVEL_CRIT_NOTIFY"),rs.getBoolean("NOTIFICATION_ON_OFF"))); 
			 }
		}catch(Exception e){
			_log.error("error while retireving Subscriptions");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 
		
		return mySubscriptions;
	}
	
	@Override
	public List<ProductProcess> getProductProcessList(ProductProcessQuery processQuery) throws Exception {
		_log.debug(processQuery);
		List<ProductProcess> productProcesses = new ArrayList<ProductProcess>();		
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
		
		delphiConn = DelphiHbaseServerConnection.getConnection();
		if(processQuery.getServerName().equalsIgnoreCase("All")){
			delphiStmt = delphiConn.prepareStatement("Select PT,PF,PN,PR,SN,RN,LOC,substr(SV,1,instr(SV,'.')-1) as SV From FIS_PART_THRESHOLDS Where RN ='"+processQuery.getRegionName()+"' And LOC ='"+processQuery.getSiteName()+"'");
		}else{
			delphiStmt = delphiConn.prepareStatement("Select PT,PF,PN,PR,SN,RN,LOC,substr(SV,1,instr(SV,'.')-1) as SV From FIS_PART_THRESHOLDS Where RN ='"+processQuery.getRegionName()+"' And LOC ='"+processQuery.getSiteName()+"' AND SV ='"+processQuery.getServerName()+"'");
		}
		_log.debug(delphiStmt);
		
		
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				ProductProcess prdProcess = new ProductProcess( delphiRS.getString("PT"), delphiRS.getString("PF"), delphiRS.getString("PN"), delphiRS.getString("PR"), delphiRS.getString("SN"),delphiRS.getString("RN"),delphiRS.getString("LOC"), delphiRS.getString("SV"));
				productProcesses.add(prdProcess);
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}
		
		return productProcesses;
	}
	
	@Override
	public List<SubscribedDataProcess> getSubscriptionList(String sqlQuery) throws Exception {
		//thsi will pull data from table fis_subscriptions
		_log.debug("getSubscriptionList process called....sqlQuery is:"+sqlQuery);
		List<SubscribedDataProcess> subscribedDataProcess = new ArrayList<SubscribedDataProcess>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String finalQuery = "select * from fis_subscriptions where subscription_Id ="+sqlQuery ;
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(finalQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				SubscribedDataProcess subDataProcess = new SubscribedDataProcess( rs.getString("PRODUCT_TYPE"), rs.getString("PRODUCT_FAMILY"), rs.getString("PART_NUMBER"), rs.getString("PROCESS"), rs.getString("STATION"), rs.getString("REGION"), rs.getString("LOCATION"), rs.getString("SERVER"));
				subscribedDataProcess.add(subDataProcess);
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DataAccess.cleanUp(con, ps, rs);
		}
		
		return subscribedDataProcess;
	}
	@Override
	public void updateSubscription(SubscriptionUpdate subscriptionUpdate, long subscriptionId) throws Exception{
		_log.debug("updateSubscription process called....");
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		YieldAlarmThresholdModel yieldAlarmThresholdModel = null ; 

		if(subscriptionUpdate.getSubscriptionType().equalsIgnoreCase("Yield")){
			YieldAlarmThresholdCalculator calc = new YieldAlarmThresholdCalculator();
			yieldAlarmThresholdModel = calc.calculateYieldAlarmThreshold(subscriptionUpdate);
			if(yieldAlarmThresholdModel == null ) {
				throw new Exception ("Failed to calculate threshold for subscription"); 
			}
		}
		String strSql = "delete from fis_subscriptions where SUBSCRIPTION_ID =" + subscriptionId;
		String strSql2 = "delete from fis_subscription_expanded where SUBSCRIPTION_ID =" + subscriptionId;

		try{
			//delete records from fis_subscriptions
			con = DataAccess.getConnection();
			ps = con.prepareStatement(strSql);
			ps2 = con.prepareStatement(strSql2);
			con.setAutoCommit(false);
			
			ps.executeUpdate();
			ps2.executeUpdate();

			// clean up the prepared statement
			DataAccess.cleanUp(ps);
			DataAccess.cleanUp(ps2);

			//update record in fis_subscriptions_catalog
			StringBuffer sqlQuery = new StringBuffer("update fis_subscriptions_catalog set SUB_NAME='");
					 sqlQuery.append(subscriptionUpdate.getSubscriptionName());
			sqlQuery.append("',SUB_DESC='");
			sqlQuery.append(subscriptionUpdate.getSubscriptionDesc());
			sqlQuery.append("',SUB_TYPE='");
			sqlQuery.append(subscriptionUpdate.getSubscriptionType());
			sqlQuery.append("',SUB_LEVEL_INFO_NOTIFY=");
			sqlQuery.append(subscriptionUpdate.getInfoNofity());
			sqlQuery.append(",SUB_LEVEL_WARN_NOTIFY=");
			sqlQuery.append(subscriptionUpdate.getWarningNotify());
			sqlQuery.append(",SUB_LEVEL_CRIT_NOTIFY=");
			sqlQuery.append(subscriptionUpdate.getCriticalNotify());
			sqlQuery.append(",UPDATED_TIME=");
		
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			sqlQuery.append("?");
			
			sqlQuery.append(" where SUBSCRIPTION_ID="+subscriptionId);
			_log.debug(sqlQuery);
			
			 ps = con.prepareStatement(sqlQuery.toString());
			 ps.setTimestamp(1, date);
			 ps.executeUpdate();
			 
			 // clean up the prepared statement
			 DataAccess.cleanUp(ps);
			 
			//insert record in fis_subscriptions
			 List<String> lstPartNumber = subscriptionUpdate.getPartNumber();
			 List<String> lstRegion = subscriptionUpdate.getRegionNames();
			 List<String> lstLocation = subscriptionUpdate.getSiteNames();
			 List<String> lstServer = subscriptionUpdate.getServerNames();
			 List<String> lstProductType = subscriptionUpdate.getProductType();
			 List<String> lstProductFamily = subscriptionUpdate.getProductFamily();
			 List<String> lstProcess = subscriptionUpdate.getProcessNames();
			 List<String> lstStation = subscriptionUpdate.getStationNames();
			 
			 String currentDate = date.toString();
			 String insertSQL = "INSERT INTO fis_subscriptions (SUBSCRIPTION_ID, REGION, LOCATION, SERVER, PRODUCT_TYPE, PRODUCT_FAMILY, PART_NUMBER, PROCESS, STATION, CREATED_TIME) values(?,?,?,?,?,?,?,?,?,?)";
			 _log.debug(insertSQL);
			 ps = con.prepareStatement(insertSQL);
			 
			 int batchSize = 100;
			 
			 for(int i=0; i <lstPartNumber.size();i++ ){
				 
				ps.setLong(1, subscriptionId);
				ps.setString(2, lstRegion.get(i).replaceAll("[^\\w\\s]",""));
				ps.setString(3, lstLocation.get(i).replaceAll("[^\\w\\s]",""));
				ps.setString(4, lstServer.get(i).replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "") );
				ps.setString(5, lstProductType.get(i).replaceAll("[^\\w\\s]",""));
				ps.setString(6, lstProductFamily.get(i).replaceAll("[^\\w\\s]",""));
				ps.setString(7, lstPartNumber.get(i).replaceAll("[^\\w\\s]",""));
				ps.setString(8, lstProcess.get(i).replaceAll("[^\\w\\s]",""));
				ps.setString(9, lstStation.get(i).replaceAll("[^\\w\\s]",""));
				
				ps.setTimestamp(10, date);
				ps.addBatch();
				if(i % batchSize == 0){
					ps.executeBatch();
				}
				
			 }
			 
			 ps.executeBatch();
			 con.commit();
			 
			if(subscriptionUpdate.getSubscriptionType().equalsIgnoreCase("Yield")){
				YieldAlarmDAO yieldAlarmDAO = new  YieldAlarmDAO();
				yieldAlarmThresholdModel.setSubscriptionId(subscriptionId) ;
				yieldAlarmDAO.saveYieldAlarmThreshold(yieldAlarmThresholdModel);
			}else{
				 // We should also update the fis_subscription_expanded table 
				 SubscriptionDenormalizerUtil normalizer = new SubscriptionDenormalizerUtil();
				 normalizer.addDenomalizedDataForSubscription(subscriptionId);
			}
		}catch(Exception e){
			_log.error("error while updating adding SubscriptionCatalog");
			_log.error(e);
		} finally{
			DataAccess.cleanUp(con, ps, rs);
			DataAccess.cleanUp(ps2);
		}
	}
	
	@Override
	public void deleteSubscription(long subscriptionId) throws Exception{
		_log.debug("delete subscription process called....");
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;

		//ResultSet rset = null;
		String deleteFromCatalog = "delete from fis_subscriptions_catalog where subscription_Id ="+subscriptionId ;
		String deleteFromSubscription = "delete from fis_subscriptions where subscription_Id ="+subscriptionId ;
		String deleteFromSubscriptionExpanded = "delete from fis_subscription_expanded where subscription_Id ="+subscriptionId ;
		String deleteFromYieldThreshold = "delete from yield_alarm_threshold where subscription_Id ="+subscriptionId ;

		con = DataAccess.getConnection();
		int i=0;
		try{
			ps = con.prepareStatement(deleteFromCatalog);
			i = ps.executeUpdate();
			if(i>0){
				try{
					ps1 = con.prepareStatement(deleteFromSubscription);
					ps1.executeUpdate();
				}catch(Exception e){
					_log.error("error while deleting data from fis_subscriptions table");
					_log.error(e);
				}
				try{
					ps2 = con.prepareStatement(deleteFromSubscriptionExpanded);
					ps2.executeUpdate();
				}catch(Exception e){
					_log.error("error while deleting data from fis_subscription_expanded table");
					_log.error(e);
				}
				try{
					ps3 = con.prepareStatement(deleteFromYieldThreshold);
					ps3.executeUpdate();
				}catch(Exception e){
					_log.error("error while deleting data from yield_alarm_threshold table");
					_log.error(e);
				}
			}
		}catch(Exception e){
			_log.error("error while deleting data from fis_subscriptions_catalog table");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(ps1);
			DataAccess.cleanUp(ps2);			
			DataAccess.cleanUp(ps3);
			DataAccess.cleanUp(con, ps);
		}
	}
	
	@Override
	public void addSubscription(SubscriptionUpdate subscriptionUpdate) throws Exception{
		_log.debug("addSubscription process called....");
		Connection con = null;
		PreparedStatement ps = null;
		long subscriptionId = 0;
		YieldAlarmThresholdModel yieldAlarmThresholdModel = null ; 
		if(subscriptionUpdate.getSubscriptionType().equalsIgnoreCase("Yield")){
			YieldAlarmThresholdCalculator calc = new YieldAlarmThresholdCalculator();
			yieldAlarmThresholdModel = calc.calculateYieldAlarmThreshold(subscriptionUpdate);
			if(yieldAlarmThresholdModel == null ) {
				throw new Exception ("Failed to calculate threshold for subscription"); 
			}
		}
		try{
			StringBuffer sqlQuery = new StringBuffer("insert into fis_subscriptions_catalog (USER_ID, SUB_NAME, SUB_DESC, SUB_TYPE, SUB_LEVEL_INFO_NOTIFY, SUB_LEVEL_WARN_NOTIFY, SUB_LEVEL_CRIT_NOTIFY, CREATED_TIME) values (");
			sqlQuery.append(subscriptionUpdate.getUserId());
			sqlQuery.append(",'");
			sqlQuery.append(subscriptionUpdate.getSubscriptionName());
			sqlQuery.append("','");
			sqlQuery.append(subscriptionUpdate.getSubscriptionDesc());
			sqlQuery.append("','");
			sqlQuery.append(subscriptionUpdate.getSubscriptionType());
			sqlQuery.append("',");
			sqlQuery.append(subscriptionUpdate.getInfoNofity());
			sqlQuery.append(",");
			
			sqlQuery.append(subscriptionUpdate.getWarningNotify());
			sqlQuery.append(",");
			
			sqlQuery.append(subscriptionUpdate.getCriticalNotify());
			sqlQuery.append(",");
			
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			sqlQuery.append("?");
			//sqlQuery.append(date.toString());
			sqlQuery.append(")");
			_log.debug(sqlQuery);
			
			//sqlQuery.
			con = DataAccess.getConnection();
			CallableStatement cs = null ; 
			try{
				 String query = "BEGIN "+ sqlQuery.toString()+" returning SUBSCRIPTION_ID into ?; END;";
				 cs = con.prepareCall(query);
				 cs.setTimestamp(1, date);
				 cs.registerOutParameter(2, 2);
				 cs.execute();
				 subscriptionId = cs.getInt(2);
			
			 }catch(Exception e){
					_log.error("error while updating adding SubscriptionCatalog");
					_log.error(e);
			 } 
			DataAccess.cleanUp(cs);
			 _log.debug("Primary key retrieved is:"+subscriptionId);
			 
			 List<String> lstPartNumber = subscriptionUpdate.getPartNumber();
			 List<String> lstRegion = subscriptionUpdate.getRegionNames();
			 List<String> lstLocation = subscriptionUpdate.getSiteNames();
			 List<String> lstServer = subscriptionUpdate.getServerNames();
			 List<String> lstProductType = subscriptionUpdate.getProductType();
			 List<String> lstProductFamily = subscriptionUpdate.getProductFamily();
			 List<String> lstProcess = subscriptionUpdate.getProcessNames();
			 List<String> lstStation = subscriptionUpdate.getStationNames();
			 
			 String insertSQL = "INSERT INTO fis_subscriptions (SUBSCRIPTION_ID, REGION, LOCATION, SERVER, PRODUCT_TYPE, PRODUCT_FAMILY, PART_NUMBER, PROCESS, STATION, CREATED_TIME) values(?,?,?,?,?,?,?,?,?,?)";
			 _log.debug(insertSQL);
			 ps = con.prepareStatement(insertSQL);
			 con.setAutoCommit(false);
			 int batchSize = 1000;
			 
			 for(int i=0; i <lstPartNumber.size();i++ ){
				 _log.debug("i value:" + i);
				 
				 try{
					 
					 ps.setLong(1, subscriptionId);
					ps.setString(2, lstRegion.get(i).replaceAll("[^\\w\\s]",""));
					ps.setString(3,lstLocation.get(i).replaceAll("[^\\w\\s]",""));
					ps.setString(4,lstServer.get(i).replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", ""));
					ps.setString(5,lstProductType.get(i).replaceAll("[^\\w\\s]",""));
					ps.setString(6,lstProductFamily.get(i).replaceAll("[^\\w\\s]",""));
					ps.setString(7,lstPartNumber.get(i).replaceAll("[^\\w\\s]",""));
					ps.setString(8,lstProcess.get(i).replaceAll("[^\\w\\s]","") );
					ps.setString(9,lstStation.get(i).replaceAll("[^\\w\\s]",""));
					ps.setTimestamp(10, date);
					ps.addBatch();
					//ps.executeUpdate();
					if(i % batchSize == 0){
						ps.executeBatch();
						//_log.error("Inserting batch record in fis_subscriptions, total row inserted::"+i);
					}
					
				}catch(Exception e){
					_log.error("error while updating adding Subscriptions");
					_log.error(e);
				}
			 }
			 
			 ps.executeBatch();
			 con.commit();
			 _log.debug("Outside for loop:");
			 
			DataAccess.cleanUp(con, ps);
		}
		catch(Exception ex){
			_log.error(ex);
		}
		finally{
			DataAccess.cleanUp(con, ps);
		}
	
		if(subscriptionUpdate.getSubscriptionType().equalsIgnoreCase("Yield")){
			YieldAlarmDAO yieldAlarmDAO = new  YieldAlarmDAO();
			yieldAlarmThresholdModel.setSubscriptionId(subscriptionId) ;
			yieldAlarmDAO.saveYieldAlarmThreshold(yieldAlarmThresholdModel);
		}else{
			 // We should also update the fis_subscription_expanded table 
			 SubscriptionDenormalizerUtil normalizer = new SubscriptionDenormalizerUtil();
			 normalizer.addDenomalizedDataForSubscription(subscriptionId);
		}
	}

	@Override
	public void updateOnOffNotification(long subscriptionId,
			boolean onOffNotificaiton) throws Exception {
		 int notifcationStaus = onOffNotificaiton? 1: 0;
		_log.debug("updateOnOffNotification , subscriptionId : "+subscriptionId+" ,onOffNotificaiton : "+onOffNotificaiton);
		Connection con = null;
		PreparedStatement ps = null;
		
		String deleteFromCatalog = "Update fis_subscriptions_catalog SET NOTIFICATION_ON_OFF= ? where subscription_Id = ? " ;
		try{
			con = DataAccess.getConnection();		
			ps = con.prepareStatement(deleteFromCatalog);
			ps.setInt(1, notifcationStaus);
			ps.setLong(2, subscriptionId);
			ps.executeUpdate();			
		}catch(Exception e){
			_log.error("error while deleting data from fis_subscriptions_catalog table");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		}
	}
	
	@Override
	public void updateAllOnOffNotification(long userId,
			boolean onOffNotificaiton) throws Exception {
		 int notifcationStaus = onOffNotificaiton? 1: 0;
		_log.debug("updateAllOnOffNotification , userId : "+userId+" ,onOffNotificaiton : "+onOffNotificaiton);
		Connection con = null;
		PreparedStatement ps = null;
		
		String deleteFromCatalog = "Update fis_subscriptions_catalog SET NOTIFICATION_ON_OFF= ? where user_id =? " ;
		try{
			con = DataAccess.getConnection();		
			ps = con.prepareStatement(deleteFromCatalog);
			ps.setInt(1, notifcationStaus);
			ps.setLong(2, userId);
			ps.executeUpdate();			
		}catch(Exception e){
			_log.error("error while deleting data from fis_subscriptions_catalog table");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		}
	}
	
	@Override
	public boolean isAlertNameDuplicate(long userId,String alertName) throws Exception {
		
		boolean retValue = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String finalQuery = "select * from fis_subscriptions_catalog where user_id =? and upper(sub_name)=?";
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(finalQuery);
			ps.setLong(1, userId);
			ps.setString(2, alertName.toUpperCase());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				retValue = true;
				break; 
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DataAccess.cleanUp(con, ps, rs);
		}
		
		return retValue;
	}
	
	@Override
	public List<SubscriptionData> getSubscriptionDataForSubscription(long subscriptionId) throws Exception{
		List<SubscriptionData> mySubscriptions = new ArrayList<SubscriptionData>();
		_log.debug("Service Layer getSubscriptionDataForSubscription");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select SUBSCRIPTION_ID, REGION, LOCATION,SERVER,PRODUCT_TYPE,PRODUCT_FAMILY,PART_NUMBER,PROCESS,STATION from fis_subscriptions where SUBSCRIPTION_ID = ?" ;
		_log.debug(sql);
		
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, subscriptionId);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 SubscriptionData subscription = new SubscriptionData();
				 subscription.setSubscriptionId(rs.getLong("SUBSCRIPTION_ID"));
				 subscription.setRegion(rs.getString("REGION"));
				 subscription.setSite(rs.getString("LOCATION"));
				 subscription.setServer(rs.getString("SERVER"));
				 subscription.setProductType(rs.getString("PRODUCT_TYPE"));
				 subscription.setProductFamily(rs.getString("PRODUCT_FAMILY"));
				 subscription.setPartNumber(rs.getString("PART_NUMBER"));
				 subscription.setProcess(rs.getString("PROCESS"));
				 subscription.setStation(rs.getString("STATION"));
				 mySubscriptions.add(subscription); 
			 }
		}catch(Exception e){
			_log.error("error while retireving getSubscriptionDataForSubscription");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		} 
		return mySubscriptions; 
	}
	
	@Override
	public List<SubscriptionData> getSubscriptionTransformedData(long subscriptionId, String whereClause) throws Exception{
		_log.debug("Subscription Service getSubscriptionTransformedData ");
		List<SubscriptionData> transformedDataLst = new ArrayList<SubscriptionData>();

		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
			String query = null ; 
			if(whereClause == null || whereClause.isEmpty()){
				query = "Select PT,PF,PN,PR,SN,RN,LOC,substr(SV,1,instr(SV,'.')-1) as SV From FIS_PART_THRESHOLDS ";
			}
			else{
				query = "Select PT,PF,PN,PR,SN,RN,LOC,substr(SV,1,instr(SV,'.')-1) as SV From FIS_PART_THRESHOLDS Where " + whereClause;
			}
			_log.debug(query);
			delphiConn = DelphiHbaseServerConnection.getConnection();
			delphiStmt = delphiConn.prepareStatement(query);
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				SubscriptionData std = new SubscriptionData();
				std.setSubscriptionId(subscriptionId);
				std.setRegion(delphiRS.getString("RN"));
				std.setSite(delphiRS.getString("LOC"));
				std.setServer(delphiRS.getString("SV"));
				std.setProductType(delphiRS.getString("PT"));
				std.setProductFamily(delphiRS.getString("PF"));
				std.setPartNumber(delphiRS.getString("PN"));
				std.setProcess(delphiRS.getString("PR"));
				std.setStation(delphiRS.getString("SN"));
				transformedDataLst.add(std);
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}
		return transformedDataLst;
	}

	@Override
	public int saveSubscriptionTransformedData(List<SubscriptionData> transformedData) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String insertSQL = "INSERT INTO fis_subscription_expanded (SUBSCRIPTION_ID, REGION, LOCATION, SERVER, PRODUCT_TYPE, PRODUCT_FAMILY, PART_NUMBER, PROCESS, STATION, CREATED_TIME) values(?,?,?,?,?,?,?,?,?,?)";

		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(insertSQL);
			con.setAutoCommit(false);
		 
			for(SubscriptionData std: transformedData){
				ps.setLong(1, std.getSubscriptionId());
				ps.setString(2, std.getRegion());
				ps.setString(3,std.getSite());
				ps.setString(4,std.getServer());
				ps.setString(5,std.getProductType());
				ps.setString(6,std.getProductFamily());
				ps.setString(7,std.getPartNumber());
				ps.setString(8,std.getProcess());
				ps.setString(9,std.getStation());
				ps.setTimestamp(10, date);
				ps.addBatch();
			}
			int[] count = ps.executeBatch();
			con.commit();
			return count.length ; 
		}
		catch(Exception e){
				_log.error("error while updating saveSubscriptionTransformedData");
				_log.error(e);
		}
		finally{
			DataAccess.cleanUp(con,ps);
		}
		return 0; 
	}

	@Override
	public boolean isUserPushDeviceRegistered(long userId) throws Exception {
		boolean retValue = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String finalQuery = "select * from  PUSHNOTIFICATIONSDEVICE where userid =? ";
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(finalQuery);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				retValue = true;
				break; 
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DataAccess.cleanUp(con, ps, rs);
		}
		
		return retValue;
	}

	@Override
	public String getUserCommunicationPreference(long userId) throws Exception {
		String commPreference = null ;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String finalQuery = "select communicationpreferences from delphi_userprofile where userid = ?   ";
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(finalQuery);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				commPreference = (rs.getString("communicationpreferences"));
			}
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DataAccess.cleanUp(con, ps, rs);
		}
		return commPreference ;
	}
}
