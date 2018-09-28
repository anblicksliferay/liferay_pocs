package com.ys.delphi.subscriptions.model;

import java.util.List;

public class SubscriptionUpdate {
	private long userId;
	private String subscriptionName;
	private String subscriptionType;
	private String subscriptionDesc;
	//private int infoEmail;
	private int infoNotify;
	//private int infoSMS;
	//private int warningEmail;
	private int warningNotify;
	//private int warningSMS;
	//private int criticalEmail;
	private int criticalNotify;
	//private int criticalSMS;
	private List<String> productType;
	private List<String> productFamily;
	private List<String> partNumber;
	private List<String> processNames;
	private List<String> stationNames;
	private List<String> regionNames;
	private List<String> siteNames;
	private List<String> serverNames;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public String getSubscriptionDesc() {
		return subscriptionDesc;
	}
	public void setSubscriptionDesc(String subscriptionDesc) {
		this.subscriptionDesc = subscriptionDesc;
	}
	public int getInfoNofity() {
		return infoNotify;
	}
	public void setInfoNotify(int infoNotify) {
		this.infoNotify = infoNotify;
	}
	
	public int getWarningNotify() {
		return warningNotify;
	}
	public void setWarningNotify(int warningNotify) {
		this.warningNotify = warningNotify;
	}
	public int getCriticalNotify() {
		return criticalNotify;
	}
	public void setCriticalNotify(int criticalNotify) {
		this.criticalNotify = criticalNotify;
	}
	public List<String> getProductType() {
		return productType;
	}
	public void setProductType(List<String> productType) {
		this.productType = productType;
	}
	public List<String> getProductFamily() {
		return productFamily;
	}
	public void setProductFamily(List<String> productFamily) {
		this.productFamily = productFamily;
	}
	public List<String> getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(List<String> partNumber) {
		this.partNumber = partNumber;
	}
	public List<String>  getProcessNames() {
		return processNames;
	}
	public void setProcessNames(List<String>  processNames) {
		this.processNames = processNames;
	}
	public List<String> getStationNames() {
		return stationNames;
	}
	public void setStation(List<String> stationNames) {
		this.stationNames = stationNames;
	}
		
	public List<String> getRegionNames() {
		return regionNames;
	}
	public void setRegionNames(List<String> regionNames) {
		this.regionNames = regionNames;
	}
	public List<String> getSiteNames() {
		return siteNames;
	}
	public void setSiteNames(List<String> siteNames) {
		this.siteNames = siteNames;
	}
	
	public List<String> getServerNames() {
		return serverNames;
	}
	public void setServerNames(List<String> serverNames) {
		this.serverNames = serverNames;
	}

	@Override
	public String toString() {
		return "CycleTimeUpdate [partNumber=" + partNumber + ", process="
				+ processNames + ", station=" + stationNames + ", serverNames="
				+ serverNames + "]";
	}
	public SubscriptionUpdate(long userId, String subscriptionName, String subscriptionType, String subscriptionDesc,int infoNotify, int warningNotify,  int criticalNotify, 
			List<String> productType, List<String> productFamily, List<String> partNumber,List<String> processNames,List<String> stationNames,List<String> regionNames,List<String> siteNames,List<String> serverNames) {
		super();
		this.userId = userId;
		this.subscriptionName = subscriptionName;
		this.subscriptionType = subscriptionType;
		this.subscriptionDesc = subscriptionDesc;
		this.infoNotify = infoNotify;
		this.warningNotify = warningNotify;
		this.criticalNotify = criticalNotify;
		this.productType = productType;
		this.productFamily = productFamily;
		this.partNumber = partNumber;
		this.processNames = processNames;
		this.stationNames = stationNames;
		this.regionNames = regionNames;
		this.siteNames = siteNames;
		this.serverNames = serverNames;
		
	}
	
}
