package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class RevenueExpenseTracker {
	
	private double actualExepnse;
	private double targetExpense;
	private double actualRevenue;
	private double targetRevenue;
	private double mtdExepnse;
	private double mtdRevenue;
	
	
	
	public double getMtdExepnse() {
		return mtdExepnse;
	}
	public void setMtdExepnse(double mtdExepnse) {
		this.mtdExepnse = mtdExepnse;
	}
	public double getMtdRevenue() {
		return mtdRevenue;
	}
	public void setMtdRevenue(double mtdRevenue) {
		this.mtdRevenue = mtdRevenue;
	}
	public void setActualExepnse(double actualExepnse) {
		this.actualExepnse = actualExepnse;
	}
	public void setTargetExpense(double targetExpense) {
		this.targetExpense = targetExpense;
	}
	public void setActualRevenue(double actualRevenue) {
		this.actualRevenue = actualRevenue;
	}
	public void setTargetRevenue(double targetRevenue) {
		this.targetRevenue = targetRevenue;
	}
	
	public double getActualExepnse() {
		return actualExepnse;
	}
	public double getTargetExpense() {
		return targetExpense;
	}
	public double getActualRevenue() {
		return actualRevenue;
	}
	public double getTargetRevenue() {
		return targetRevenue;
	}
	
	@Override
	public String toString() {
		return "RevenueExpenseTracker [actualExepnse=" + actualExepnse
				+ ", targetExpense=" + targetExpense + ", actualRevenue="
				+ actualRevenue + ", targetRevenue=" + targetRevenue
				+ ", mtdExepnse=" + mtdExepnse
				+ ", mtdRevenue=" + mtdRevenue + "]";
	}
	
	
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("mtdExepnse", mtdExepnse);
		json.put("mtdRevenue", mtdRevenue);
		json.put("actualExepnse", actualExepnse);
		json.put("targetExpense", targetExpense);
		json.put("actualRevenue", actualRevenue);
		json.put("targetRevenue", targetRevenue);
		return json;
	}
	
}
