package com.delphi.subscriptions.model;

public class ProductProcessQuery {
	private String regionName;
	private String siteName;
	private String serverName;
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
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	@Override
	public String toString() {
		return "ProductProcessQuery [regionName=" + regionName + ", siteName="
				+ siteName + ", serverName=" + serverName + "]";
	}
	
	public ProductProcessQuery() {
		super();
	}
	public ProductProcessQuery(String regionName, String siteName,
			String serverName) {
		super();
		this.regionName = regionName;
		this.siteName = siteName;
		this.serverName = serverName;
	}	
}
