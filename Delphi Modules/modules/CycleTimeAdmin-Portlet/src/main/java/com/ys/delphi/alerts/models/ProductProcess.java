package com.ys.delphi.alerts.models;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

public class ProductProcess {	

	private String region;
	private String site;
	private String server;
	private String productType;
	private String productFamily;
	private String partNumber;
	private String process;
	private String station;
	private int defaultCycleTime;
	private int customCycleTime;

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
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
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
	public int getDefaultCycleTime() {
		return defaultCycleTime;
	}
	public void setDefaultCycleTime(int defaultCycleTime) {
		this.defaultCycleTime = defaultCycleTime;
	}
	public int getCustomCycleTime() {
		return customCycleTime;
	}
	public void setCustomCycleTime(int customCycleTime) {
		this.customCycleTime = customCycleTime;
	}
	public ProductProcess(String productType, String productFamily,
			String partNumber, String process, String station,
			String region, String site, String server,
			int defaultCycleTime, int customCycleTime) {
		super();
		this.productType = productType;
		this.productFamily = productFamily;
		this.partNumber = partNumber;
		this.process = process;
		this.station = station;
		this.region = region;
		this.site = site;
		this.server = server;
		this.defaultCycleTime = defaultCycleTime;
		this.customCycleTime = customCycleTime;
	}
	public ProductProcess() {
		super();
	}
	@Override
	public String toString() {
		return "ProductProcess [productType=" + productType
				+ ", productFamily=" + productFamily + ", partNumber="
				+ partNumber + ", process=" + process + ", station=" + station
				+ ", region=" + region + ", site=" + site + ", server=" + server
				+ ", defaultCycleTime=" + defaultCycleTime
				+ ", customCycleTime=" + customCycleTime + "]";
	}
	public JSONObject toJSON() {
		
		JSONObject json = JSONFactoryUtil.createJSONObject();		
		json.put("region",region);				
		json.put("site",site);				
		json.put("server",server);		
		json.put("productType",productType);
		json.put("productFamily",productFamily);
		json.put("partNumber",partNumber);
		json.put("process",process);
		json.put("station",station);
		json.put("defaultCycleTime",defaultCycleTime/1000);//convert to mili seconds
		json.put("customCycleTime",customCycleTime/1000);//convert to mili seconds
		return json;
	}
	
	
}
