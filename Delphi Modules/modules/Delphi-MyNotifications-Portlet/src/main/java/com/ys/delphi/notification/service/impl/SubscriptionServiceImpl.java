package com.ys.delphi.notification.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ys.delphi.notification.model.SubscriptionData;
import com.ys.delphi.notification.service.SubscriptionService;
import com.ys.delphi.notification.service.impl.DelphiHbaseServerConnection;

public class SubscriptionServiceImpl implements SubscriptionService{
	private static Log _log = LogFactoryUtil.getLog(SubscriptionServiceImpl.class);

	@Override
	public List<SubscriptionData> getAllSubscriptionData() throws Exception{
		List<SubscriptionData> mySubscriptions = new ArrayList<SubscriptionData>();
		_log.debug("Service Layer getAllSubscriptionData");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select SUBSCRIPTION_ID, REGION, LOCATION,SERVER,PRODUCT_TYPE,PRODUCT_FAMILY,PART_NUMBER,PROCESS,STATION from fis_subscriptions" ;
		_log.debug(sql);
		
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
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
			_log.error("error while retireving getAllSubscriptionData");
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
	public int saveSubscriptionTransformedData(List<SubscriptionData> transformedData) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
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
			DataAccess.cleanUp(con,ps,rs);
		}
		return 0; 
	}
	
	public void cleanTransformedDataTable() throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String deleteSQL = "truncate table fis_subscription_expanded";

		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(deleteSQL);
			ps.execute();
		}
		catch(Exception e){
				_log.error("error while  cleanTransformedDataTable");
				_log.error(e);
		}
		finally{
			DataAccess.cleanUp(con,ps);
		}
	}

}
