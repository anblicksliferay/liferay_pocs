package com.ys.delphi.guh.service.impl;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.ys.delphi.guh.model.FisEvent;
import com.ys.delphi.guh.model.FisBarCode;

import com.ys.delphi.guh.service.GUHService;
import com.ys.delphi.guh.util.DelphiHbaseServerConnection;
import com.ys.delphi.guh.util.GUHConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class GUHServiceImpl implements GUHService {

	private static final String STATUS_PASS = "PASS";
	private static final String STATUS_SCRAP = "SCRAP";
	private static final String STATUS_REWORK = "REWORK";
	private static final String BAD_KEYWORD = "BAD";
	private static final String GOOD_KEYWORD = "GOOD";
	private static final String SCRAP_KEYWORD = "SCRAP";
	private static final String UNSCRAP_KEYWORD = "UNSCRAP";
//	private static final String REWORK = "REWORK";
	private static Log _log = LogFactoryUtil.getLog(GUHServiceImpl.class);
	private static  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat finalFormatter = new SimpleDateFormat("yyMMdd.HHmmss");
	private static String previousStatus = STATUS_PASS;
	
	@Override
	public String getEventListForPartNumber(String partNumber, List<FisEvent> fisEvents) throws Exception {

		_log.debug("The partnumber entered is "+partNumber);
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
		delphiConn = DelphiHbaseServerConnection.getConnection();
		delphiStmt = delphiConn.prepareStatement("select /*+INDEX(FIS_ARCHIVE INDEX_FIS_UNIT)*/ \"fis_routekey\", \"fis_process\",\"fis_producttype\", \"fis_familyproduct\", \"fis_partnumber\", \"fis_station\", \"fis_event\", \"fis_descriptiontable\", \"SERVERNAME\", \"fis_location\" from fis_archive where \"fis_unit\" ='"+partNumber+"'");
		_log.debug(delphiStmt);
		boolean firstTime = true;
		String parents = " "; 
		String children = " "; 
		String server = null ;
		
					delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				if(firstTime){ // get the parent child data only once
					parents = getParents(partNumber);
					children = getChildren(partNumber);
					firstTime = false ;
				}
				 String routeKey = GetterUtil.getString(delphiRS.getString("fis_routekey"));
				 String productFamily= GetterUtil.getString(delphiRS.getString("fis_familyproduct"));
				 String fisPartNumber= GetterUtil.getString(delphiRS.getString("fis_partnumber"));
				 String productType= GetterUtil.getString(delphiRS.getString("fis_producttype"));
				 String event= GetterUtil.getString(delphiRS.getString("fis_event"));
				 String process = GetterUtil.getString(delphiRS.getString("fis_process"));
				 String station = GetterUtil.getString(delphiRS.getString("fis_station"));
				 String data = GetterUtil.getString(delphiRS.getString("fis_descriptiontable"));
				 String serverName = GetterUtil.getString(delphiRS.getString("SERVERNAME"));
				 if(server == null){
					 server = serverName ; 
				 }
				 else{
					 if(!server.equalsIgnoreCase(serverName)){
						 fisEvents.clear();
						 return "Multiple" ; 
					 }
				 }
				 String location = GetterUtil.getString(delphiRS.getString("fis_location"));
				 _log.debug("data before manipulation is "+data);
				 int starting = 0;
				 int occurrence = 0;
				 List<String> entries = new ArrayList<>();
				 List<String> keys = new ArrayList<>();
				 for(int len=0;len<data.length();len++){
					 if(data.charAt(len)=='|'){
						 occurrence++;
						 if(occurrence%2==0){
							 entries.add(data.substring(starting, len)+"|-|");
							 starting = len;
						 }else{ //add all potential keys
							 keys.add(starting ==0 ? data.substring(starting, len) : data.substring(starting+1, len));
						 }
					 }
				 }
				 if(starting<data.length()){
					 entries.add(data.substring(starting,data.length())+"|-|");
				 }
				 String finalData = "";
				 for(String entry : entries){
					 finalData+=entry; 
				 }
				 String status = deriveStatus(keys);
				 Date eventDate = formatter.parse(event);
				 String formattedEventDate = finalFormatter.format(eventDate);
				FisEvent fisEvent = new FisEvent(routeKey,productFamily,fisPartNumber,productType,event,process,station,status,finalData, eventDate, formattedEventDate, parents,children, serverName, location); //all the attributes should be passed to the constructor
				fisEvent.setEventDateInMillis(fisEvent.getEventDate().getTime());
				_log.debug("The fisEvent created is "+fisEvent.toString());
				fisEvents.add(fisEvent);
				Collections.sort(fisEvents, 
                        (o1, o2) -> o2.getEventDate().compareTo(o1.getEventDate()));
			}
			previousStatus = STATUS_PASS;
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}		
		
		return "Success";
	}

	private String deriveStatus(List<String> keys) {
		String returnValue = previousStatus;
		if(keys.stream().anyMatch(x -> Objects.equals(x, BAD_KEYWORD))){
			returnValue = STATUS_REWORK;
			previousStatus = STATUS_REWORK;
	 	} else if(keys.stream().anyMatch(x -> Objects.equals(x, UNSCRAP_KEYWORD))){
			returnValue = STATUS_REWORK;
			previousStatus = STATUS_REWORK;
		}else if(keys.stream().anyMatch(x -> Objects.equals(x, SCRAP_KEYWORD))){
			returnValue = STATUS_SCRAP;
			previousStatus = STATUS_SCRAP;
		} else if(keys.stream().anyMatch(x -> Objects.equals(x, GOOD_KEYWORD))){
			returnValue = STATUS_PASS;
			previousStatus = STATUS_PASS;
		}
		
		return returnValue;
	}

	@Override
	public List<FisBarCode> getBarCodes(long userId, int category) throws Exception{
		List<FisBarCode> myBarCodes = new ArrayList<FisBarCode>();
		_log.debug("getBarCodes process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "Select BAR_CODE , CATEGORY From fis_bar_code WHERE USER_ID=" + userId + " and CATEGORY=" + category + " order by UPDATED_TIME asc" ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 FisBarCode barCode = new FisBarCode();
				 barCode.setBarCode(GetterUtil.getString(rs.getString("BAR_CODE")));
				 barCode.setCategory(GetterUtil.getInteger(rs.getInt("CATEGORY")));
				 myBarCodes.add(barCode); 
			 }
		}catch(Exception e){
			_log.error("error while retireving bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 	
		return myBarCodes;
	}
	
	@Override
	public void queueBarCode(long userId, String barCode) throws Exception{
		_log.debug("queueBarCode process ->" + barCode);
		if(!StringUtils.isEmpty(barCode)){
			barCode = barCode.trim();
			try{
				if(checkExistingBarCodeForUser(userId, barCode)){
					updateBarCode(userId, barCode);
				}
				else{
					insertBarCode(userId, barCode, GUHConstants.QUEUED);
				}
			}catch(Exception ex){
				_log.error("error while retireving addBarCodeToSaved");
				_log.error(ex);
			}
		}
	}
	
	@Override
	public void viewBarCode(long userId, String barCode) throws Exception{
		_log.debug("viewBarCode process ->" + barCode);
		if(!StringUtils.isEmpty(barCode)){
			barCode = barCode.trim();		
			try{
				int category = getExistingBarCodeCategoryForUser(userId, barCode);
				if(category == 0){
					insertBarCode(userId, barCode, GUHConstants.VIEWED);
				}
				else if (category == GUHConstants.SAVED) {
					updateBarCode(userId, barCode);
				}
				else{
					updateBarCode(userId, barCode, GUHConstants.VIEWED);
				}
			}catch(Exception ex){
				_log.error("error while retireving viewBarCode");
				_log.error(ex);
			}	
		}
	}
	@Override
	public void addBarCodeToSaved(long userId, String barCode) throws Exception{
		_log.debug("addBarCodeToSaved process ->" + barCode);
		if(!StringUtils.isEmpty(barCode)){
			barCode = barCode.trim();
			try{
				if(checkExistingBarCodeForUser(userId, barCode)){
					updateBarCode(userId, barCode, GUHConstants.SAVED);
				}
				else{
					insertBarCode(userId, barCode, GUHConstants.SAVED);
				}
			}catch(Exception ex){
				_log.error("error while retireving addBarCodeToSaved");
				_log.error(ex);
			}
		}
	}
	
	private boolean checkExistingBarCodeForUser(long userId, String barCode)throws Exception{
		
		_log.debug("checkExistingBarCodeForUser process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean found = false ; 
		
		String sql = "Select COUNT(*) as BARCODECOUNT From fis_bar_code WHERE USER_ID= ? and BAR_CODE = ? " ;
		_log.debug(sql);
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
	
	private int getExistingBarCodeCategoryForUser(long userId, String barCode)throws Exception{
		
		_log.debug("getExistingBarCodeCategoryForUser process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean found = false ; 
		int category = 0 ; 
		
		String sql = "Select category as category From fis_bar_code WHERE USER_ID= ? and BAR_CODE = ? " ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 ps.setString(2, barCode);
			 
			 rs = ps.executeQuery();
			 while(rs.next()){				 
				category = GetterUtil.getInteger(rs.getInt("category"));
			 }
		}catch(Exception e){
			_log.error("error while retireving bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 	
		return category ;
	}
	
	private void insertBarCode(long userId, String barCode, int category) throws Exception{
		_log.debug("insertBarCode process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT into fis_bar_code (USER_ID, BAR_CODE, CATEGORY, UPDATED_TIME, CREATED_TIME) values (?,?,?,?,?)" ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 ps.setString(2, barCode);
			 ps.setLong (3, category);
			 java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
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
	
	private  void updateBarCode(long userId, String barCode, int category) throws Exception{
		_log.debug("updateBarCode process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE fis_bar_code SET category= ? , UPDATED_TIME = ? WHERE USER_ID= ? and BAR_CODE= ? " ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sql);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			String  timeStamp = date.toString();
			ps.setLong(1, category); 
			ps.setTimestamp (2, date);
			ps.setLong(3, userId);
			ps.setString(4, barCode);			 
			ps.executeUpdate();
			 
		}catch(Exception e){
			_log.error("error while updating bar code");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		} 	
	}
	
	
	private  void updateBarCode(long userId, String barCode) throws Exception{
		_log.debug("updateBarCode process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE fis_bar_code SET UPDATED_TIME = ? WHERE USER_ID= ? and BAR_CODE= ? " ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sql);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
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
	
	public String getParents(String barCode) throws Exception{
		_log.debug("getParents -> " + barCode);
		StringBuilder returnStr = new StringBuilder();
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
			delphiConn = DelphiHbaseServerConnection.getConnection();
			delphiStmt = delphiConn.prepareStatement("select /*+ INDEX(fis_ins_del_list INDEX_CHILD) */ \"fis_ins_unit_parent\" from fis_ins_del_list where \"fis_ins_unit_child\" ='"+barCode+"' and \"fis_isdel_unit\" = false" );
			_log.debug(delphiStmt);
			 delphiRS = delphiStmt.executeQuery();
			 boolean first = true ; 
			 while (delphiRS.next()) {
				 String parent = GetterUtil.getString(delphiRS.getString("fis_ins_unit_parent"));
				 if(first){
					 first = false ;
				 }
				 else{
					 returnStr.append(",");
				 }
				 returnStr.append(parent);
			 }
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}
		 
		return returnStr.toString();
	}
	public String getChildren(String barCode) throws Exception{
		_log.debug("getChildren -> " + barCode);
		StringBuilder returnStr = new StringBuilder();

		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
			delphiConn = DelphiHbaseServerConnection.getConnection();
			delphiStmt = delphiConn.prepareStatement("select /*+ INDEX(fis_ins_del_list INDEX_PARENT) */ \"fis_ins_unit_child\" from fis_ins_del_list where \"fis_ins_unit_parent\" ='"+barCode+"' and \"fis_isdel_unit\" = false" );
			_log.debug(delphiStmt);
			 delphiRS = delphiStmt.executeQuery();
			 boolean first = true ; 
			 while (delphiRS.next()) {
				 String child = GetterUtil.getString(delphiRS.getString("fis_ins_unit_child"));
				 if(first){
					 first = false ;
				 }
				 else{
					 returnStr.append(",");
				 }
				 returnStr.append(child);
			 }
		}catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}		
		 
		return returnStr.toString();
	}
	
	@Override
	public void deleteBarCode(long userId, String barCode) throws Exception{
		_log.debug("deleteBarCode process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "delete from fis_bar_code where user_id = ? and bar_code = ? " ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setString(2, barCode);			 
			ps.executeUpdate();
			 
		}catch(Exception e){
			_log.error("error while updating bar code");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps);
		} 			
	}
	@Override
	public List<FisBarCode> getViewedBarCodesForToday(long userId) throws Exception{
		List<FisBarCode> myBarCodes = new ArrayList<FisBarCode>();
		_log.debug("getViewedBarCodesForToday process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select BAR_CODE , CATEGORY From fis_bar_code WHERE USER_ID=" + userId + " and CATEGORY= 2 and UPDATED_TIME > sysdate - 1 order by UPDATED_TIME asc" ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 FisBarCode barCode = new FisBarCode();
				 barCode.setBarCode(GetterUtil.getString(rs.getString("BAR_CODE")));
				 barCode.setCategory(GetterUtil.getInteger(rs.getInt("CATEGORY")));
				 myBarCodes.add(barCode); 
			 }
		}catch(Exception e){
			_log.error("error while retireving bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 	
		return myBarCodes;
	}
	@Override
	public List<FisBarCode> getViewedBarCodesForLastWeek(long userId) throws Exception{
		List<FisBarCode> myBarCodes = new ArrayList<FisBarCode>();
		_log.debug("getViewedBarCodesForLastWeek process");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select BAR_CODE , CATEGORY From fis_bar_code WHERE USER_ID=" + userId + " and CATEGORY= 2 and UPDATED_TIME > sysdate - 7  and UPDATED_TIME < sysdate - 1 order by UPDATED_TIME asc" ;
		_log.debug(sql);
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 FisBarCode barCode = new FisBarCode();
				 barCode.setBarCode(GetterUtil.getString(rs.getString("BAR_CODE")));
				 barCode.setCategory(GetterUtil.getInteger(rs.getInt("CATEGORY")));
				 myBarCodes.add(barCode); 
			 }
		}catch(Exception e){
			_log.error("error while retireving bar codes");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con, ps, rs);
		} 	
		return myBarCodes;	
	}
	@Override
	public void insertBarCodeInTrackingTable(long userId, String barCode) throws Exception{
		_log.debug("insertBarCodeInTrackingTable process");
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT into fis_bar_code_error (USER_ID, BAR_CODE, SEARCH_TIME) values (?,?,?)" ;
		_log.debug(sql);
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
