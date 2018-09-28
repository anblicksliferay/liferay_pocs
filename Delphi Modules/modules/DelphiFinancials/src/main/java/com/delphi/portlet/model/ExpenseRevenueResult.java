package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;


public class ExpenseRevenueResult implements Serializable {

	private static final long serialVersionUID = -665460844575553348L;
	
	ExpenseCatagory expenseCatagory;

	private String month;
	private int year;
	private int expenseId;
	private int siteId;
	
	public ExpenseCatagory getExpenseCatagory() {
		return expenseCatagory;
	}
	public void setExpenseCatagory(ExpenseCatagory expenseCatagory) {
		this.expenseCatagory = expenseCatagory;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "ExpenseRevenueResult [expenseCatagory=" + expenseCatagory.toString()
				+ ", month=" + month + ", year=" + year + ", expenseId="
				+ expenseId + ", siteId=" + siteId + "]";
	}

	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("month", month);
		json.put("year", year);
		json.put("expenseId", expenseId);
		json.put("expenseCatagory", expenseCatagory.toJSON());
		return json;
	}
	
	

}
