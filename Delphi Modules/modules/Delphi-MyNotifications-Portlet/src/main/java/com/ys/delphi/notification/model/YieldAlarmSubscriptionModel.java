package com.ys.delphi.notification.model;

public class YieldAlarmSubscriptionModel {
	
	private String productType;
	private String productFamily;
	private String process;
	private String station;
	private String region;
	private String site;
	private String server;
	

	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductFamily() {
		return productFamily;
	}
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	
}
