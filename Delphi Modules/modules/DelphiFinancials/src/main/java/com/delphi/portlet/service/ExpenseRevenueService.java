package com.delphi.portlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.delphi.portlet.model.ExpenseCatagory;
import com.delphi.portlet.model.ExpenseRevenueQuery;
import com.delphi.portlet.model.ExpenseRevenueResult;
import com.delphi.portlet.model.ExpenseRevenueSaveUpdate;
import com.delphi.portlet.model.NameId;

import java.io.Serializable;
import java.util.List;

public interface ExpenseRevenueService extends Serializable {	
	public ExpenseRevenueResult getExpenseRevenue(ExpenseRevenueQuery q) throws SystemException, PortalException;
	
	public void saveOrUpdateExpenseRevenue(List<ExpenseRevenueSaveUpdate> l) throws Exception;
	
	public List<NameId> getRegions();
	
	public List<NameId> getSites();
	
	public List<NameId> getExpenseCatagories();
	
/*	public List<NameId> getDivisons(int regionId, int siteId,int expenseId);	

	public List<NameId> getProductLine(int regionId, int siteId,int expenseId, int divisionId);*/
	
	public ExpenseCatagory getExpenseRevenueMetaData(int siteId ) throws Exception;
	
	public void savePartialExpenseRevenueData(int siteId, String month, int year, String partialData) throws Exception;
	public void deletePartialExpenseRevenueData(int siteId, String month, int year) throws Exception;
	public String getPartialExpenseRevenueData(int siteId, String month, int year) throws Exception;
	
}
