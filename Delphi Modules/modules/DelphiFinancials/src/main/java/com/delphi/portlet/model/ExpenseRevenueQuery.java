package com.delphi.portlet.model;

import java.io.Serializable;

public class ExpenseRevenueQuery implements Serializable {
	private static final long serialVersionUID = 7322450007246914692L;
	private String month;
	private int year;
	private int expenseId;
	private int siteId;
	public ExpenseRevenueQuery(String month, int year, int expenseId, int siteId) {
		super();
		this.month = month;
		this.year = year;
		this.expenseId = expenseId;
		this.siteId = siteId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public int getSiteId() {
		return siteId;
	}
	@Override
	public String toString() {
		return "ExpenseRevenueQuery [month=" + month + ", year=" + year
				+ ", expenseId=" + expenseId + ", siteId=" + siteId + "]";
	}
	
}
