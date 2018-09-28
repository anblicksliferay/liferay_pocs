package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyRevenueExpenseTracker implements Comparable<DailyRevenueExpenseTracker> {
	private double actualExepnse;
	private double targetExpense;
	private double actualRevenue;
	private double targetRevenue;
	private Calendar cal;
	static private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
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
	public void setCal(Calendar cal) {
		this.cal = cal;
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
	public Calendar getCal() {
		return cal;
	}
	@Override
	public String toString() {
		return "DailyRevenueExpenseTracker [actualExepnse=" + actualExepnse
				+ ", targetExpense=" + targetExpense + ", actualRevenue="
				+ actualRevenue + ", targetRevenue=" + targetRevenue + ", cal="
				+ cal + "]";
	}
	
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("actualExepnse", actualExepnse);
		json.put("targetExpense", targetExpense);
		json.put("actualRevenue", actualRevenue);
		json.put("targetRevenue", targetRevenue);
		String d = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) < 10 ? "0"+cal.get(Calendar.MONTH): cal.get(Calendar.MONTH))+"-"+(cal.get(Calendar.DATE) < 10 ? "0"+cal.get(Calendar.DATE): cal.get(Calendar.DATE));
		json.put("date",sdf.format(cal.getTime()));
		return json;
	}
	@Override
	public int compareTo(DailyRevenueExpenseTracker o) {
		return cal.compareTo(o.getCal());
	}
	

}
