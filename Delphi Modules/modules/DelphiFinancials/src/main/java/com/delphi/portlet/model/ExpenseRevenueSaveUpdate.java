package com.delphi.portlet.model;

import java.io.Serializable;

public class ExpenseRevenueSaveUpdate implements Serializable {

	private static final long serialVersionUID = -4402426510644312462L;
	
	private int reId;
	private int rpdpId;

	private int expenceCatogoryId;
	private int day;
	private String month;
	private int year;
	private Boolean isHoliday;	
	private Double expected;
	private Double actual;
	private String updatedBy;
	public ExpenseRevenueSaveUpdate(int reId, int rpdpId,Double expected, Double actual,Boolean isHoliday,
			String updatedBy) {
		super();
		this.reId = reId;
		this.rpdpId = rpdpId;
		this.expected = expected;
		this.actual = actual;
		this.isHoliday = isHoliday;
		this.updatedBy = updatedBy;
	}
	public ExpenseRevenueSaveUpdate(int rpdpId, int expenceCatogoryId, int day,
			String month, int year, Boolean isHoliday, Double expected,
			Double actual, String updatedBy) {
		super();
		this.rpdpId = rpdpId;
		this.expenceCatogoryId = expenceCatogoryId;
		this.day = day;
		this.month = month;
		this.year = year;
		this.isHoliday = isHoliday;
		this.expected = expected;
		this.actual = actual;
		this.updatedBy = updatedBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getReId() {
		return reId;
	}
	public int getRpdpId() {
		return rpdpId;
	}
	public int getExpenceCatogoryId() {
		return expenceCatogoryId;
	}
	public int getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public Boolean isHoliday() {
		return isHoliday;
	}
	public Double getExpected() {
		return expected;
	}
	public Double getActual() {
		return actual;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	@Override
	public String toString() {
		return "ExpenseRevenueSaveUpdate [reId=" + reId + ", rpdpId=" + rpdpId
				+ ", expenceCatogoryId=" + expenceCatogoryId + ", day=" + day
				+ ", month=" + month + ", year=" + year + ", isHoliday="
				+ isHoliday + ", expected=" + expected + ", actual=" + actual
				+ ", updatedBy=" + updatedBy + "]";
	}

	
}
