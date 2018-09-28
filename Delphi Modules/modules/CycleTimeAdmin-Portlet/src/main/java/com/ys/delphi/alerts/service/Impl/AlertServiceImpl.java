package com.ys.delphi.alerts.service.Impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.ys.delphi.alerts.models.CycleTimeUpdate;
import com.ys.delphi.alerts.models.ProductProcess;
import com.ys.delphi.alerts.models.ProductProcessQuery;
import com.ys.delphi.alerts.models.RegionSiteServer;
import com.ys.delphi.alerts.models.RegionSiteServerList;
import com.ys.delphi.alerts.service.AlertService;
import com.ys.delphi.alerts.util.DelphiHbaseServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class AlertServiceImpl implements AlertService {

	private static Log _log = LogFactoryUtil.getLog(AlertServiceImpl.class);
	
	@Override
	public List<ProductProcess> getProductProcessList(ProductProcessQuery processQuery) throws Exception {
		_log.info(processQuery);
		List<ProductProcess> productProcesses = new ArrayList<ProductProcess>();
		
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		
		try{
			delphiConn = DelphiHbaseServerConnection.getConnection();
			if(processQuery.getServerName().equalsIgnoreCase("All")){
				delphiStmt = delphiConn.prepareStatement("Select * From FIS_PART_THRESHOLDS Where RN ='"+processQuery.getRegionName()+"' And LOC ='"+processQuery.getSiteName()+"'");
			}else{
				delphiStmt = delphiConn.prepareStatement("Select * From FIS_PART_THRESHOLDS Where RN ='"+processQuery.getRegionName()+"' And LOC ='"+processQuery.getSiteName()+"' AND SV ='"+processQuery.getServerName()+"'");
			}
			_log.info(delphiStmt);
		
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				String productType = GetterUtil.getString(delphiRS.getString("PT"));
				String productFamily= GetterUtil.getString(delphiRS.getString("PF"));
				String partNumber= GetterUtil.getString(delphiRS.getString("PN"));
				String process= GetterUtil.getString(delphiRS.getString("PR"));
				String station= GetterUtil.getString(delphiRS.getString("SN"));
				String region= GetterUtil.getString(delphiRS.getString("RN"));
				String site= GetterUtil.getString(delphiRS.getString("LOC"));
				String server= GetterUtil.getString(delphiRS.getString("SV"));
				
				int defaultCycleTime = GetterUtil.getInteger(delphiRS.getBigDecimal("T"));
				int customCycleTime = GetterUtil.getInteger(delphiRS.getBigDecimal("M"));
				ProductProcess prdProcess = new ProductProcess(productType, productFamily, partNumber, process, station, region, site, server, defaultCycleTime, customCycleTime);
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
	public void updateProductProcess(CycleTimeUpdate cycleTimeUpdate) throws Exception{
		_log.info("updateProductProcess");
		Connection delphiConn = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		
		try{
			delphiConn = DelphiHbaseServerConnection.getConnection();
			if(cycleTimeUpdate!=null && cycleTimeUpdate.getServerNames().size() > 0){
				for(String serverName : cycleTimeUpdate.getServerNames()){
					String upsertSQL = "UPSERT INTO FIS_PART_THRESHOLDS(PN,PR,SN,SV,M) values('"+cycleTimeUpdate.getPartNumber()+"','"+cycleTimeUpdate.getProcess()+"','"+cycleTimeUpdate.getStation()+"','"+serverName+"',"+cycleTimeUpdate.getCustomCycleTime()+")";
					_log.info(upsertSQL);
					delphiStmt = delphiConn.prepareStatement(upsertSQL);
					delphiStmt.executeUpdate();
					delphiConn.commit();
				}
			}
		}catch(Exception e){
			_log.error("error while updating CycleTime");
			_log.error(e);
		}finally{
			DelphiHbaseServerConnection.close(delphiConn, delphiStmt, delphiRS);
		} 
	}

	@Override
	public RegionSiteServerList getRegionSiteServerList() throws Exception{
		_log.info("getRegionSiteList");
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
	
}