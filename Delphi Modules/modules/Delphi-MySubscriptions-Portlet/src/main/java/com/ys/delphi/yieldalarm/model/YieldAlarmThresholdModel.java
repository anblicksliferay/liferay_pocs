package com.ys.delphi.yieldalarm.model;

import java.text.DecimalFormat;

public class YieldAlarmThresholdModel {

	private long subscriptionId; 
	private double threshold; 
	private int sampleCount; 
	private double standardDeviation ;
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
		DecimalFormat newFormat = new DecimalFormat("#.#");
		double twoDecimal =  Double.valueOf(newFormat.format(threshold));
		this.threshold = twoDecimal;
	}
	public int getSampleCount() {
		return sampleCount;
	}
	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		DecimalFormat newFormat = new DecimalFormat("#.#");
		double twoDecimal =  Double.valueOf(newFormat.format(standardDeviation));
		this.standardDeviation = twoDecimal;
	} 
	public String toString(){
		return "subscriptionId=" + subscriptionId + ", threshold=" + threshold + ", sampleCount=" + sampleCount + ", standardDeviation="+standardDeviation ; 
	}
	
}
