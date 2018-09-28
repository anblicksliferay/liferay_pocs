package com.delphi.subscriptions.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.delphi.subscriptions.model.RegionSiteServer;
import com.delphi.subscriptions.model.RegionSiteServerList;
import com.delphi.subscriptions.service.MySubscriptionService;
import com.delphi.subscriptions.util.DelphiHbaseServerConnection;

public class MySubscriptionsImpl implements MySubscriptionService{
	
	private static Log _log = LogFactoryUtil.getLog(MySubscriptionsImpl.class);
	
	@Override
	public RegionSiteServerList getRegionSiteServerList() throws Exception {
		// TODO Auto-generated method stub
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
