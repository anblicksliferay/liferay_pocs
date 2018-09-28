package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

public class RegionSiteServer implements Serializable{
	private String serverName;
	private String regionName;
	private String siteName;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public RegionSiteServer() {
		super();
		
	}
	
	public RegionSiteServer(String serverName, String regionName,
			String siteName) {
		super();
		this.serverName = serverName;
		this.regionName = regionName;
		this.siteName = siteName;
	}

	@Override
	public String toString() {
		return "RegionSiteServer [serverName=" + serverName + ", regionName="
				+ regionName + ", siteName=" + siteName + "]";
	}

	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("serverName", serverName);
		json.put("regionName", regionName);
		json.put("siteName", siteName);
		
		return json;
	}

}
