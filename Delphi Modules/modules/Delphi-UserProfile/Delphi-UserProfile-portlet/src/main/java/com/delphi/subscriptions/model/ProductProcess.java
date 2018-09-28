package com.delphi.subscriptions.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

public class ProductProcess {	
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
	
	public ProductProcess(String productType, String productFamily,
			String partNumber, String process, String station, String region, String site, String server) {
		super();
		this.productType = productType;
		this.productFamily = productFamily;
		this.partNumber = partNumber;
		this.process = process;
		this.station = station;
		this.region = region;
		this.site = site;
		this.server = server;
		
	}
	public ProductProcess() {
		super();
	}
	@Override
	public String toString() {
		return "ProductProcess [productType=" + productType
				+ ", productFamily=" + productFamily + ", partNumber="
				+ partNumber + ", process=" + process + ", station=" + station +  ", region=" + region + ", site=" + site + ", server=" + server + "]";
				
	}
	public JSONArray toJSON() {
		
		JSONArray json = JSONFactoryUtil.createJSONArray();		
		json.put( productType);
		json.put(productFamily);
		json.put(partNumber);
		json.put( process);
		json.put( station);
		json.put(region);
		json.put(site);
		json.put( server);
		return json;
	}
	
	
}
