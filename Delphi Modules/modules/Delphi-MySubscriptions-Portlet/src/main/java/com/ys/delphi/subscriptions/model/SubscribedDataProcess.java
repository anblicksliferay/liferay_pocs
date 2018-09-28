package com.ys.delphi.subscriptions.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

public class SubscribedDataProcess {

	private String productType;
	private String productFamily;
	private String partNumber;
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
	
	public String getRegion() {
		return region;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSite() {
		return site;
	}
	public void setRegion(String region) {
		this.station = region;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	
	public SubscribedDataProcess(String productType, String productFamily,
			String partNumber, String process, String station,
			String site, String region, String server) {
		super();
		this.productType = productType;
		this.productFamily = productFamily;
		this.partNumber = partNumber;
		this.process = process;
		this.station = station;
		this.site = site;
		this.region = region;
		this.server = server;
	}
	public SubscribedDataProcess() {
		super();
	}
	@Override
	public String toString() {
		return "ProductProcess [productType=" + productType
				+ ", productFamily=" + productFamily + ", partNumber="
				+ partNumber + ", process=" + process + ", station=" + station
				+ ", site=" + site
				+ ", region=" + region
				+ ", server=" + server + "]";
	}
	public JSONArray toJSON() {
		
		JSONArray json = JSONFactoryUtil.createJSONArray();		
		json.put( productType);
		json.put(productFamily);
		json.put(partNumber);
		json.put( process);
		json.put( station);
		json.put( site);
		json.put( region);
		json.put( server);
		return json;
	}
	
	
}
