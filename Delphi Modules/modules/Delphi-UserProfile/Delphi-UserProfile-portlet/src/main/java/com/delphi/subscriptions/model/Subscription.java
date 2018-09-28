package com.delphi.subscriptions.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class Subscription {
	
	private int subscriptionID;
	private String subscriptionName;
	private String subscriptionType;
	private String subscriptionDesc;
	private int subscriptionInfo;
	private int subscriptionWarning;
	private int subscriptionCritical;
	private boolean onOffNotification;
	
	
	public int getSubscriptionID() {
		return subscriptionID;
	}
	public void setSubscriptionID(int subscriptionID) {
		this.subscriptionID = subscriptionID;
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
	public int getSubscriptionInfo() {
		return subscriptionInfo;
	}
	public void setSubscriptionInfo(int subscriptionInfo) {
		this.subscriptionInfo = subscriptionInfo;
	}
	public int getSubscriptionWarning() {
		return subscriptionWarning;
	}
	public void setSubscriptionWarning(int subscriptionWarning) {
		this.subscriptionWarning = subscriptionWarning;
	}
	public int getSubscriptionCritical() {
		return subscriptionCritical;
	}
	public void setSubscriptionCritical(int subscriptionCritical) {
		this.subscriptionCritical = subscriptionCritical;
	}
	public boolean isOnOffNotification() {
		return onOffNotification;
	}
	public void setOnOffNotification(boolean onOffNotification) {
		this.onOffNotification = onOffNotification;
	}
	public Subscription(int subscriptionID, String subscriptionName,
			String subscriptionType, String subscriptionDesc, int subscriptionInfo, int subscriptionWarning, int subscriptionCritical,boolean onOffNotification) {
		super();
		this.subscriptionID = subscriptionID;
		this.subscriptionName = subscriptionName;
		this.subscriptionType = subscriptionType;
		this.subscriptionDesc = subscriptionDesc;
		this.subscriptionInfo = subscriptionInfo;
		this.subscriptionWarning = subscriptionWarning;
		this.subscriptionCritical = subscriptionCritical;
		this.onOffNotification = onOffNotification;
	}
	
	public Subscription(int subscriptionID, String subscriptionName,
			String subscriptionType, String subscriptionDesc, int subscriptionInfo, int subscriptionWarning, int subscriptionCritical) {
		super();
		this.subscriptionID = subscriptionID;
		this.subscriptionName = subscriptionName;
		this.subscriptionType = subscriptionType;
		this.subscriptionDesc = subscriptionDesc;
		this.subscriptionInfo = subscriptionInfo;
		this.subscriptionWarning = subscriptionWarning;
		this.subscriptionCritical = subscriptionCritical;		
	}
	
	@Override
	public String toString() {
		return "Subscription [subscriptionID=" + subscriptionID
				+ ", subscriptionName=" + subscriptionName
				+ ", subscriptionType=" + subscriptionType
				+ ", subscriptionDesc=" + subscriptionDesc
				+ ", subscriptionInfo=" + subscriptionInfo
				+ ", subscriptionWarning=" + subscriptionWarning
				+ ", subscriptionCritical=" + subscriptionCritical
				+ ", onOffNotification=" + onOffNotification + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("subscriptionID", subscriptionID);
		json.put("subscriptionType", subscriptionType);
		json.put("subscriptionInfo", subscriptionInfo);
		json.put("subscriptionWarning", subscriptionWarning);
		json.put("subscriptionCritical", subscriptionCritical);
		json.put("subscriptionName", subscriptionName);
		json.put("subscriptionDesc", subscriptionDesc);
		json.put("onOffNotification", onOffNotification);
		
		return json;
	}
	
}
