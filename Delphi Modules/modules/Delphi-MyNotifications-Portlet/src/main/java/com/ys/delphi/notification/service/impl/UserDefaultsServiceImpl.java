package com.ys.delphi.notification.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ys.delphi.notification.service.UserDefaultsService;

public class UserDefaultsServiceImpl implements UserDefaultsService {
	private static Log _log = LogFactoryUtil.getLog(UserDefaultsServiceImpl.class);

	@Override
	public void updateDefaults(long userId, String pageId, String fieldId, String fieldValue){
		
		String updateSQL = "UPDATE USERDATA SET FIELDVALUE = ? , CREATEDATE = ? where ID = ? and PAGEID = ?  and FIELDID = ? ";
		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(updateSQL);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setString(1, fieldValue);
			ps.setTimestamp(2, date);
			ps.setLong(3, userId);
			ps.setString(4, pageId);
			ps.setString(5, fieldId);
			int count = ps.executeUpdate();
			if(count == 0){
				saveDefaults(userId, pageId, fieldId, fieldValue);
			}
		}catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps);
		}			
	}
	
	public void saveDefaults(long userId, String pageId, String fieldId, String fieldValue) throws Exception {
		String insertSQL = "INSERT INTO  USERDATA (ID, PAGEID, FIELDID, FIELDVALUE,CREATEDATE) VALUES (?, ? , ? , ? , ? )";
		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(insertSQL);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setLong(1, userId);
			ps.setString(2, pageId);
			ps.setString(3, fieldId);
			ps.setString(4, fieldValue);
			ps.setTimestamp(5, date);
			ps.execute();
		}catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps);
		}	
	}

	@Override
	public Map<String, String> fetchUserDefaults(long userId, String pageId) {
		Map<String, String> defaultModelMap = new HashMap<String, String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "Select FIELDID, FIELDVALUE From USERDATA WHERE ID= ? and PAGEID = ? " ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 ps.setString(2, pageId);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 String filedId = rs.getString("FIELDID");
				 String fieldValue = rs.getString("FIELDVALUE");
				 defaultModelMap.put(filedId, fieldValue);
			 }
		}catch(Exception e){
			_log.error("error while retireving user defaults");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 
		
		return defaultModelMap;
	}

}
