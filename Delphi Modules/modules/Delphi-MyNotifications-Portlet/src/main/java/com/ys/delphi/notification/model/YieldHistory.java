package com.ys.delphi.notification.model;

import java.text.DecimalFormat;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class YieldHistory {
	
	private long subscriptionId; 
	private double threshold; 
	private double standardDeviation ;
	private double currentYield ;
	private double deviation ; 
	
	public double getDeviation() {
		return deviation;
	}

	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}

	public YieldHistory(long subscriptionId, double threshold, double standardDeviation, double currentYield, double deviation){
		this.subscriptionId = subscriptionId ; 
		this.threshold = threshold ; 
		this.standardDeviation = standardDeviation ; 
		this.currentYield = currentYield ; 
		this.deviation = deviation; 
	}
	
	public long getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public double getCurrentYield() {
		return currentYield;
	}
	public void setCurrentYield(double currentYield) {
		this.currentYield = currentYield;
	}
	
	public JSONObject toJSON() {
		DecimalFormat newFormat = new DecimalFormat("#.#");
		double info =  Double.valueOf(newFormat.format(threshold - standardDeviation));
		double warn = Double.valueOf(newFormat.format(threshold - (1.5*standardDeviation))); 
		double error =  Double.valueOf(newFormat.format(threshold - (2*standardDeviation)));   
		double triggeringYield = Double.valueOf(newFormat.format((100 - deviation)*threshold/100)); 
		
		JSONObject detail = JSONFactoryUtil.createJSONObject();
		
		detail.put("meanYield", Double.toString(threshold));
		detail.put("standardDeviation", Double.toString(standardDeviation));
		detail.put("currentYield", Double.toString(currentYield));
		detail.put("triggeringYield", Double.toString(triggeringYield));
		detail.put("yieldInfoValue", Double.toString(info));
		detail.put("yieldWarnValue", Double.toString(warn));
		detail.put("yieldCritValue", Double.toString(error));
		
		return detail;
	}
	
}
