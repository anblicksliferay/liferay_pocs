package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class DivisionProduct {
	private String name;
	private int id;
	private double actualExepnse;
	private double targetExpense;
	private double actualRevenue;
	private double targetRevenue;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
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
		return "DivisionProduct [name=" + name + ", id=" + id
				+ ", actualExepnse=" + actualExepnse + ", targetExpense="
				+ targetExpense + ", actualRevenue=" + actualRevenue
				+ ", targetRevenue=" + targetRevenue + "]";
	}
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("name", name);
		json.put("id", id);
		json.put("actualExepnse", actualExepnse);
		json.put("targetExpense", targetExpense);
		json.put("actualRevenue", actualRevenue);
		json.put("targetRevenue", targetRevenue);
		return json;
	}
	
}
