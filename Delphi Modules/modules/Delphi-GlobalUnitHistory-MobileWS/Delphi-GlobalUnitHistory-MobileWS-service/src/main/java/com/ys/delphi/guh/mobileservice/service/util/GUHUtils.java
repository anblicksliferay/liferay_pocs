package com.ys.delphi.guh.mobileservice.service.util;

import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

public class GUHUtils{
	
	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(GUHUtils.class);

	public static String resolveBarCode(String barCode){
		// create the segments of the barcode 
		List<String> barCodeSegments = segmentBarCode(barCode);
		String match = checkBarCodesInHBaseDatabase(barCodeSegments);
		_log.info("Found a match for the bar code " + barCode+ " --> " + match);
		return match; 
	}
	
	private static List<String> segmentBarCode(String barCode){
		List<String> barCodeSegments = new ArrayList<String>();
		List<String> barCodeSegmentsAfterRules = new ArrayList<String>();

		// check if [)> 06 exist ASCII 29
		if(barCode.startsWith("[)>\u001e06")){
			_log.info("barCode contains header ");
			barCode = barCode.substring(6, barCode.length());
			if(barCode.contains("\u001D")){
				_log.info("barCode contains \u001D  ");
				barCodeSegments = Arrays.asList(barCode.split("\u001D")); 
			}
			else if (barCode.contains("|")){
				_log.info("barCode contains |  ");
				barCodeSegments = Arrays.asList(barCode.split("\\|")); 
			}
			else{
				barCodeSegments.add(barCode);
			}
		}
		else if(barCode.contains("|")){ 
			_log.info("barCode doesn't contain header but barCode contains | ");
			barCodeSegments = Arrays.asList(barCode.split("\\|")); 
		}
		else{
			_log.info("barCode doesn't contain header");
			barCodeSegments.add(barCode);
		}
		
		// apply rules for all the segments
		for(String row:barCodeSegments){
			applyRules(row,barCodeSegmentsAfterRules);
		}
			
		return barCodeSegmentsAfterRules ; 
	}
	
	private static void applyRules(String segment, List<String> finalBarCodeToCheck){
		// if bar code segment starts with T, S, 1T, or 1S then add 2 entries for them
		if(segment.startsWith("T")){
			finalBarCodeToCheck.add(segment.substring(1,segment.length()));
		}
		if(segment.startsWith("1T")){
			finalBarCodeToCheck.add(segment.substring(2,segment.length()));
		}
		if(segment.startsWith("S")){
			finalBarCodeToCheck.add(segment.substring(1,segment.length()));
		}
		if(segment.startsWith("1S")){
			finalBarCodeToCheck.add(segment.substring(2,segment.length()));
		}
		
		finalBarCodeToCheck.add(segment);
	}

	
	private static String checkBarCodesInHBaseDatabase(List<String> barCodesToCheck){

		StringBuilder sb = new StringBuilder();
		for(String barcode: barCodesToCheck){
			if(barcode.isEmpty()){
				continue;
			}
			if(sb.length() > 0) sb.append(",");
			sb.append("'").append(barcode).append("'") ;
		}
		String query = "select /*+INDEX(FIS_ARCHIVE INDEX_FIS_UNIT)*/ distinct \"fis_unit\" from fis_archive where \"fis_unit\" in (" + sb.toString() + ")" ; 
		
		_log.info("query to be fired  checkBarCodesInHBaseDatabase --> " + query);

		String match  = null ;
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		 try{
			delphiConn = DelphiHbaseServerConnection.getConnection();
			delphiStmt = delphiConn.prepareStatement(query);			
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				match = GetterUtil.getString(delphiRS.getString("fis_unit"));
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		}		
		
		return match;
	}

}