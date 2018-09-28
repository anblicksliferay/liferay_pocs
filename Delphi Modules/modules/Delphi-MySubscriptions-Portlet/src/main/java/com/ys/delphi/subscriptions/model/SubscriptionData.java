package com.ys.delphi.subscriptions.model;

public class SubscriptionData {
	
	private long subscriptionId;
	private String productType;
	private String productFamily;
	private String partNumber;
	private String process;
	private String station;
	private String region;
	private String site;
	private String server;
	
	public long getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
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
	
	public boolean isGeneric(){
		sanitizeData();
		if(this.region.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.site.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.server.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.station.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.process.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.partNumber.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.productFamily.equalsIgnoreCase("ALL")){
			return true; 
		}
		if(this.productType.equalsIgnoreCase("ALL")){
			return true; 
		}
		return false ;
	}
	private void sanitizeData(){
		if(this.region == null  || this.region.equalsIgnoreCase("null")){
			this.region = "ALL";
		}
		if(this.site == null || this.site.equalsIgnoreCase("null")){
			this.site = "ALL"; 
		}
		if(this.server == null || this.server.equalsIgnoreCase("null")){
			this.server = "ALL"; 
		}
		if(this.station == null || this.station.equalsIgnoreCase("null")){
			this.station = "ALL";
		}
		if(this.process == null || this.process.equalsIgnoreCase("null")){
			this.process = "ALL";
		}
		if(this.partNumber == null || this.partNumber.equalsIgnoreCase("null")){
			this.partNumber = "ALL";
		}
		if(this.productFamily == null || this.productFamily.equalsIgnoreCase("null")){
			this.productFamily = "ALL"; 
		}
		if(this.productType == null || this.productType.equalsIgnoreCase("null")){
			this.productType = "ALL";
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("SubscriptionData region=").append(region).append(",")
		.append("site=").append(site).append(",")  
		.append("server=").append(server).append(",")  
		.append("station=").append(station).append(",")  
		.append("process=").append(process).append(",")  
		.append("partNumber=").append(partNumber).append(",")  
		.append("productFamily=").append(productFamily).append(",")  
		.append("productType=").append(productType) ; 

		return sb.toString();
	}
}
