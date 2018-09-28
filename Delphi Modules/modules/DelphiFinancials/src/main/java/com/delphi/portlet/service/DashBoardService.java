package com.delphi.portlet.service;

import com.delphi.portlet.model.CategoryExpense;
import com.delphi.portlet.model.DailyRevenueExpenseTracker;
import com.delphi.portlet.model.DashBoardQuery;
import com.delphi.portlet.model.DivisionProduct;
import com.delphi.portlet.model.RevenueExpenseTracker;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.SortedSet;

public interface DashBoardService extends Serializable {	

	public Calendar getStartDate();
	
	public Calendar getTodaysDate();
	
	public List<DivisionProduct> getDivisionProductList(DashBoardQuery query,boolean isDivsion);

	public RevenueExpenseTracker getRevenueExpenseTrackerList(DashBoardQuery query);
	
	public List<CategoryExpense> getCategoryExpenseList(DashBoardQuery query);
	public List<DailyRevenueExpenseTracker> getDailyRevenueExpenseTrackerList(DashBoardQuery query);
	public SortedSet<DailyRevenueExpenseTracker> getMonthlyRevenueExpenseTrackerList(DashBoardQuery query);
	public List<DailyRevenueExpenseTracker> getYearlyRevenueExpenseTrackerList(DashBoardQuery query);
}
