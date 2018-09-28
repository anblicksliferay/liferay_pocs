package com.delphi.portlet.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DashBoardQuery {
	private Date startDate;
	private Date endDate;
	private int expenseId;
	private int siteId;
	private int regionId;
	private int divisionId;
	private int productLineId;
	
	
	
	public DashBoardQuery(Date startDate, Date endDate, int expenseId, int regionId, int siteId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.expenseId = expenseId;
		this.regionId = regionId;
		this.siteId = siteId;
	}

	
	public DashBoardQuery(Date startDate, Date endDate, int expenseId, int regionId, int siteId, int divisionId, int productLineId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.expenseId = expenseId;
		this.siteId = siteId;
		this.regionId = regionId;
		this.divisionId = divisionId;
		this.productLineId = productLineId;
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
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getDivisionId() {
		return divisionId;
	}

	public int getProductLineId() {
		return productLineId;
	}


	@Override
	public String toString() {
		return "DashBoardQuery [startDate=" + startDate + ", endDate="
				+ endDate + ", expenseId=" + expenseId + ", siteId=" + siteId
				+ ", regionId=" + regionId + ", divisionId=" + divisionId
				+ ", productLineId=" + productLineId + "]";
	}
}
