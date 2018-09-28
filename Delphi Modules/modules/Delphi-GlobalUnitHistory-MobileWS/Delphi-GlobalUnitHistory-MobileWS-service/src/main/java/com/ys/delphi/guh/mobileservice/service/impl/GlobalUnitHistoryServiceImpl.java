/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ys.delphi.guh.mobileservice.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Date;
import java.util.List;

import java.util.ArrayList;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.ys.delphi.guh.mobileservice.service.base.GlobalUnitHistoryServiceBaseImpl;
import com.ys.delphi.guh.mobileservice.service.util.GUHUtils;

/**
 * The implementation of the global unit history remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.delphi.guh.mobileservice.service.GlobalUnitHistoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GlobalUnitHistoryServiceBaseImpl
 * @see com.ys.delphi.guh.mobileservice.service.GlobalUnitHistoryServiceUtil
 */
@ProviderType
public class GlobalUnitHistoryServiceImpl
	extends GlobalUnitHistoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.delphi.guh.mobileservice.service.GlobalUnitHistoryServiceUtil} to access the global unit history remote service.
	 */

	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(GlobalUnitHistoryServiceImpl.class);

	public String scannedBarCodeData(String barCodeData){
		
		boolean error = false ;
		// first get the user id for the logged in user
		long userid = 0 ; 
		try{
			User user = getGuestOrUser();
			userid = user.getUserId();		
			_log.info("GlobalUnitHistoryServiceImpl Mobile WebService");
			_log.info(barCodeData);

			// we will get the list of all the bar codes and their timestamp
			// parse that information and store somewhere
			JSONObject json = JSONFactoryUtil.createJSONObject(barCodeData);
			JSONArray array = json.getJSONArray("machincecodes");
			int size = array.length();
			for(int i=0; i<size; i++){
				JSONArray dataItem = array.getJSONArray(i);
				String barCode = dataItem.getString(0).trim();
				String parsedBarCode = GUHUtils.resolveBarCode(barCode);
//				barCode = barCode.replaceAll("[^0-9a-zA-Z._]", "");
				_log.info("barCode -->" + barCode);
				_log.info("parsedBarCode -->" + parsedBarCode);
				if(parsedBarCode == null){
					parsedBarCode = barCode ;
					insertBarCodeInTrackingTable(userid, barCode);
				}
				String timeStr = dataItem.getString(1);				
				// store the information in the database
				long time = Long.parseLong(timeStr.substring(0, timeStr.indexOf('.')));
				time = time *1000;
				queueBarCode(userid, parsedBarCode, time);
			}
		}
		catch(Exception ex){
			_log.error(ex);
			error = true; 
			
		}
		if(error){
			return "{\"result\": \"Bar Code Data Insert Failed.\"}";
		}
		return "{\"result\": \"Bar Code Data Inserted Sucessfully.\"}";
	}
	
	
	private void queueBarCode(long userId, String barCode, long time) throws Exception{
		_log.info("queueBarCode process");
		try{
			if(checkExistingBarCodeForUser(userId, barCode)){
				updateBarCode(userId, barCode, time);
			}
			else{
				insertBarCode(userId, barCode, 1, time);
			}
		}catch(Exception ex){
			_log.error("error while retireving addBarCodeToSaved");
			_log.error(ex);
		}	
	}
	
	private boolean checkExistingBarCodeForUser(long userId, String barCode)throws Exception{
		
		_log.info("Mobile WS checkExistingBarCodeForUser process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean found = false ; 
		
		String sql = "Select COUNT(*) as BARCODECOUNT From fis_bar_code WHERE USER_ID= ? and BAR_CODE = ? " ;
		_log.info(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 ps.setString(2, barCode);
			 
			 rs = ps.executeQuery();
			 while(rs.next()){				 
				int count = GetterUtil.getInteger(rs.getInt("BARCODECOUNT"));
				if(count>0)
					found = true; 
			 }
		}catch(Exception e){
			_log.error("error while retireving bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 	
		return found ;
	}
	
	private void insertBarCode(long userId, String barCode, int category, long time) throws Exception{
		_log.info("Mobile WS insertBarCode process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT into fis_bar_code (USER_ID, BAR_CODE, CATEGORY, UPDATED_TIME, CREATED_TIME) values (?,?,?,?,?)" ;
		_log.info(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 ps.setString(2, barCode);
			 ps.setLong (3, category);
			 java.sql.Timestamp date = new java.sql.Timestamp(time);
			 ps.setTimestamp (4, date);
			 ps.setTimestamp (5, date);
			 ps.execute();

		}catch(Exception e){
			_log.error("error while inserting bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		} 	
	}
	
	private  void updateBarCode(long userId, String barCode, long time) throws Exception{
		_log.info("Mobile WS updateBarCode process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE fis_bar_code SET UPDATED_TIME = ? WHERE USER_ID= ? and BAR_CODE= ? " ;
		_log.info(sql);
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sql);
			java.sql.Timestamp date = new java.sql.Timestamp(time);
			ps.setTimestamp (1, date);
			ps.setLong(2, userId);
			ps.setString(3, barCode);			 
			ps.executeUpdate();
			 
		}catch(Exception e){
			_log.error("error while updating bar code");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		} 	
	}
	
	private void insertBarCodeInTrackingTable(long userId, String barCode) throws Exception{
		_log.info("Mobile WS insertBarCodeInTrackingTable process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT into fis_bar_code_error (USER_ID, BAR_CODE, SEARCH_TIME) values (?,?,?)" ;
		_log.info(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 ps.setString(2, barCode);
			 java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			 ps.setTimestamp (3, date);
			 ps.execute();

		}catch(Exception e){
			_log.error("error while inserting bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		} 	
	}
}