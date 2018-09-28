package com.delphi.portlet.service.impl;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.delphi.portlet.model.CategoryExpense;
import com.delphi.portlet.model.DailyRevenueExpenseTracker;
import com.delphi.portlet.model.DashBoardQuery;
import com.delphi.portlet.model.DivisionProduct;
import com.delphi.portlet.model.RevenueExpenseTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;

public class DashBoardServiceImpl implements com.delphi.portlet.service.DashBoardService {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactoryUtil.getLog(DashBoardServiceImpl.class);
	
		

	@Override
	public Calendar getStartDate() {
		Calendar cal = Calendar.getInstance();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 con = DataAccess.getConnection();
			 ps = con.prepareStatement("select min(dm.dateVal) as min from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0");
			 rs = ps.executeQuery();
			if(rs.next()){
				cal.setTime(rs.getDate("min"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
		return cal;
	}

	@Override
    public Calendar getTodaysDate() {
    	Calendar currentdate = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("HH");
		TimeZone obj = TimeZone.getTimeZone("CST");
		formatter.setTimeZone(obj);
		int hour = Integer.parseInt(formatter.format(currentdate.getTime()));
		Date todaysDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(todaysDate);
		if(hour < 8){
			cal.add(Calendar.DATE, -2);
		}else{
			cal.add(Calendar.DATE, -1);
		}
		logger.debug("Today's Date:: "+ sdf.format(cal.getTime()));
		return cal;
	}
	
	
	@Override
	public List<DivisionProduct> getDivisionProductList(DashBoardQuery query,
			boolean isDivsion) {
		List<DivisionProduct> divisionProducts = new ArrayList<DivisionProduct>();
		StringBuffer select  = new StringBuffer("Select sum(expected) as totalExpected, sum(actual) as totalActual, ");
		if(isDivsion){
			select.append("rm.divisionId  as dpId , dim.divisionShortName  as name");
		}else{
			select.append("rm.productlineId as dpId, plm.productlineShortName as name ");
		}
		select.append("  from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm  , ");
		if(isDivsion){
			select.append("Division_Master dim ");
		}else{
			select.append("Product_Line_Master plm ");
		}
		select.append(" where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0 and ");
		if(isDivsion){
			select.append("dim.divisionId = rm.divisionId and");
		}else{
			select.append("plm.productlineId = rm.productlineId and");
		}
		if(query.getRegionId() > 0){
			select.append(" rm.regionId = ").append(query.getRegionId()).append(" and ");
		}
		if(query.getSiteId() > 0){
			select.append(" rm.siteId = ").append(query.getSiteId()).append(" and ");
		}
		if(query.getDivisionId() > 0){
			select.append(" rm.divisionId = ").append(query.getDivisionId()).append(" and ");
		}
		if(query.getProductLineId() > 0){
			select.append(" rm.productlineId = ").append(query.getProductLineId()).append(" and ");
		}
		//addDate(select, query);
		select.append(" dm.dateVal between ? and ? ").append(" and ");
		
		
		//get Revenue		
				StringBuffer revenueQuery = new StringBuffer(select.toString());
				revenueQuery.append("re.expenseId = 1");
				if(isDivsion){
					revenueQuery.append(" group by rm.divisionId, dim.divisionShortName ");
				}else{
					revenueQuery.append(" group by rm.productlineId, plm.productlineShortName ");
				}
				//get Expense				
				StringBuffer expenseQuery = new StringBuffer(select.toString());
				if(query.getExpenseId() == -1){
					expenseQuery.append("re.expenseId != 1");
				}else{
					expenseQuery.append("re.expenseId = ").append(query.getExpenseId());
				}
				if(isDivsion){
					expenseQuery.append(" group by rm.divisionId, dim.divisionShortName ");
				}else{
					expenseQuery.append(" group by rm.productlineId, plm.productlineShortName ");
				}
		
		logger.debug("getDivisionProductList expense query : "+expenseQuery.toString());
		logger.debug("getDivisionProductList revenue query : "+revenueQuery.toString());
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(expenseQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getModifiedEndDate(query).getTime()));
			 rs = ps.executeQuery();
			DivisionProduct divisionProduct= null;
			while(rs.next()){				
				divisionProduct = new DivisionProduct();
				divisionProduct.setName(rs.getString("name"));
				divisionProduct.setId(rs.getInt("dpId"));	
				divisionProduct.setActualExepnse(rs.getDouble("totalActual"));
				divisionProduct.setTargetExpense(rs.getDouble("totalExpected"));
				divisionProducts.add(divisionProduct);
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(revenueQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getModifiedEndDate(query).getTime()));
			rs = ps.executeQuery();
			divisionProduct = null;
			while(rs.next()){
				int id = rs.getInt("dpId");
				logger.debug("searching for id : "+id);
				for(int i = 0; i < divisionProducts.size(); i++){
					if(divisionProducts.get(i).getId() == id){
						divisionProduct = divisionProducts.get(i);
						break;
					}
				}				
				divisionProduct.setActualRevenue(rs.getDouble("totalActual"));
				divisionProduct.setTargetRevenue(rs.getDouble("totalExpected"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
				
		logger.debug("size of divisionProducts before return : "+divisionProducts.size());
		return divisionProducts;
	}


	@Override
	public RevenueExpenseTracker getRevenueExpenseTrackerList(DashBoardQuery query) {
		RevenueExpenseTracker revenueExpense = new RevenueExpenseTracker();
		StringBuffer select  = new StringBuffer("Select sum(expected) as totalExpected, sum(actual) as totalActual from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0 and ");
		if(query.getRegionId() > 0){
			select.append(" rm.regionId = ").append(query.getRegionId()).append(" and ");
		}
		if(query.getSiteId() > 0){
			select.append(" rm.siteId = ").append(query.getSiteId()).append(" and ");
		}
		if(query.getDivisionId() > 0){
			select.append(" rm.divisionId = ").append(query.getDivisionId()).append(" and ");
		}
		if(query.getProductLineId() > 0){
			select.append(" rm.productlineId = ").append(query.getProductLineId()).append(" and ");
		}
		//get target for period
		StringBuffer selectForPeriodQuery = new StringBuffer(select.toString());
		
		//selectForPeriodQuery.append(" dm.dateVal between ").append("'").append(sdf.format(query.getStartDate())).append("'").append(" and ").append("'").append(sdf.format(query.getEndDate())).append("' and ");
		selectForPeriodQuery.append(" dm.dateVal between ? and ?").append(" and ");
		
		StringBuffer expenseForPeriodQuery = new StringBuffer(selectForPeriodQuery.toString());
		StringBuffer revenueForPeriodQuery = new StringBuffer(selectForPeriodQuery.toString());
		revenueForPeriodQuery.append("re.expenseId = 1 ");
		
		select.append(" dm.dateVal between ? and ? ").append(" and ");
	//	addDate(select, query);
		
		//get Revenue		
		StringBuffer revenueQuery = new StringBuffer(select.toString());
		revenueQuery.append(" re.expenseId = 1");
		
		//get Expense		
		StringBuffer expenseQuery = new StringBuffer(select.toString());
		if(query.getExpenseId() == -1){
			expenseForPeriodQuery.append(" re.expenseId != 1");
			expenseQuery.append(" re.expenseId != 1");
		}else{
			expenseForPeriodQuery.append(" re.expenseId = ").append(query.getExpenseId());
			expenseQuery.append(" re.expenseId = ").append(query.getExpenseId());
		}
		
		logger.debug("getRevenueExpenseTrackerList Revenue query : "+revenueQuery.toString());
		logger.debug("getRevenueExpenseTrackerList expenseQuery  : "+expenseQuery.toString());
		logger.debug("getRevenueExpenseTrackerList revenueForPeriodQuery : "+revenueForPeriodQuery.toString());
		logger.debug("getRevenueExpenseTrackerList expenseForPeriodQuery  : "+expenseForPeriodQuery.toString());
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(expenseQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getModifiedEndDate(query).getTime()));
			 rs = ps.executeQuery();
			if(rs.next()){
				revenueExpense.setActualExepnse(rs.getDouble("totalActual"));
				revenueExpense.setTargetExpense(rs.getDouble("totalExpected"));
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(revenueQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getModifiedEndDate(query).getTime()));
			rs = ps.executeQuery();
			if(rs.next()){
				revenueExpense.setActualRevenue(rs.getDouble("totalActual"));
				revenueExpense.setTargetRevenue(rs.getDouble("totalExpected"));
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(expenseForPeriodQuery.toString());
			ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			ps.setDate(2, new java.sql.Date(query.getEndDate().getTime()));
			rs = ps.executeQuery();
			if(rs.next()){
				revenueExpense.setMtdExepnse(rs.getDouble("totalExpected"));
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(revenueForPeriodQuery.toString());
			ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			ps.setDate(2, new java.sql.Date(query.getEndDate().getTime()));
			rs = ps.executeQuery();
			if(rs.next()){
				revenueExpense.setMtdRevenue(rs.getDouble("totalExpected"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
		
		return revenueExpense;
	}


	@Override
	public List<CategoryExpense> getCategoryExpenseList(DashBoardQuery query) {
		List<CategoryExpense> categoryExpenses = new ArrayList<CategoryExpense>(4);
		StringBuffer select  = new StringBuffer("Select expenseId, sum(expected) as totalExpected, sum(actual) as totalActual from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0  and ");
		if(query.getRegionId() > 0){
			select.append(" rm.regionId = ").append(query.getRegionId()).append(" and ");
		}
		if(query.getSiteId() > 0){
			select.append(" rm.siteId = ").append(query.getSiteId()).append(" and ");
		}
		if(query.getDivisionId() > 0){
			select.append(" rm.divisionId = ").append(query.getDivisionId()).append(" and ");
		}
		if(query.getProductLineId() > 0){
			select.append(" rm.productlineId = ").append(query.getProductLineId()).append(" and ");
		}
		
		//get target for period
		StringBuffer selectForPeriodQuery = new StringBuffer(select.toString());
		
		selectForPeriodQuery.append(" dm.dateVal between ? and ? ").append(" and ");
		//selectForPeriodQuery.append(" dm.dateVal between ").append("'").append(sdf.format(query.getStartDate())).append("'").append(" and ").append("'").append(sdf.format(query.getEndDate())).append("' and ");
		selectForPeriodQuery.append("  re.expenseId != 1");
		selectForPeriodQuery.append(" group by re.expenseId");
		
		
		select.append(" dm.dateVal between ? and ? ").append(" and ");
		//addDate(select, query);	
		select.append("  re.expenseId != 1");
		select.append(" group by re.expenseId");
		
		logger.debug("getCategoryExpenseList query : "+ select.toString());
		logger.debug("getCategoryExpenseList selectForPeriodQuery : "+ selectForPeriodQuery.toString());
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(select.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getModifiedEndDate(query).getTime()));
			 rs = ps.executeQuery();
			CategoryExpense categoryExpense = null;
			while(rs.next()){				
				categoryExpense = new CategoryExpense();
				categoryExpense.setId(rs.getInt("expenseId"));
				categoryExpense.setActualExepnse(rs.getDouble("totalActual"));
				categoryExpense.setTargetRevenue(rs.getDouble("totalExpected"));
				categoryExpenses.add(categoryExpense);
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(selectForPeriodQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(query.getEndDate().getTime()));
			rs = ps.executeQuery();
			while(rs.next()){	
				int id = rs.getInt("expenseId");
				for(int i = 0; i<categoryExpenses.size();i++){
					if(categoryExpenses.get(i).getId() == id){
						categoryExpense = categoryExpenses.get(i);
						break;
					}
				}
				categoryExpense.setMtdTarget(rs.getDouble("totalExpected"));
				//logger.debug(categoryExpense);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
		
		return categoryExpenses;
	}


	@Override
	public List<DailyRevenueExpenseTracker> getDailyRevenueExpenseTrackerList(DashBoardQuery query) {
		List<DailyRevenueExpenseTracker> dailyRevenueExpenseTrackers = new ArrayList<DailyRevenueExpenseTracker>();
		StringBuffer select  = new StringBuffer("Select sum(expected) as expected, sum(actual) as actual ,dm.dateVal as dateVal   from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0 and ");
		if(query.getRegionId() > 0){
			select.append(" rm.regionId = ").append(query.getRegionId()).append(" and ");
		}
		if(query.getSiteId() > 0){
			select.append(" rm.siteId = ").append(query.getSiteId()).append(" and ");
		}
		if(query.getDivisionId() > 0){
			select.append(" rm.divisionId = ").append(query.getDivisionId()).append(" and ");
		}
		if(query.getProductLineId() > 0){
			select.append(" rm.productLineId = ").append(query.getProductLineId()).append(" and ");
		}
		select.append(" dm.dateVal between ? and ? ").append(" and ");
		//addEndOfMonth(select, query);
		
		//get Revenue
		
		StringBuffer revenueQuery = new StringBuffer(select.toString());
		revenueQuery.append(" re.expenseId = 1");
		//get Expense
		
		StringBuffer expenseQuery = new StringBuffer(select.toString());
		if(query.getExpenseId() == -1){
			expenseQuery.append(" re.expenseId != 1");
		}else{
			expenseQuery.append(" re.expenseId = ").append(query.getExpenseId());
		}
		expenseQuery.append(" group by dm.dateVal  order by dm.dateVal ASC");
		revenueQuery.append(" group by dm.dateVal  order by dm.dateVal ASC");
		
		logger.debug("getDailyRevenueExpenseTrackerList Revenue query : "+revenueQuery.toString());
		logger.debug("getDailyRevenueExpenseTrackerList expenseQuery  : "+expenseQuery.toString());
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(expenseQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getEndOfMonth(query).getTime()));
			 rs = ps.executeQuery();
			DailyRevenueExpenseTracker dailyRevenueExpenseTracker = null;
			Calendar cal  = null;
			while(rs.next()){				
				dailyRevenueExpenseTracker = new DailyRevenueExpenseTracker();
				dailyRevenueExpenseTracker.setActualExepnse(rs.getDouble("actual"));
				dailyRevenueExpenseTracker.setTargetExpense(rs.getDouble("expected"));
				cal = Calendar.getInstance();
				Date date = new Date(rs.getTimestamp("dateVal").getTime());				
				cal.setTime(date);
				//logger.debug(rs.getTimestamp("date").getTime());
				dailyRevenueExpenseTracker.setCal(cal);					
				dailyRevenueExpenseTrackers.add(dailyRevenueExpenseTracker);
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(revenueQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getEndOfMonth(query).getTime()));
			rs = ps.executeQuery();
			dailyRevenueExpenseTracker = null;
			cal  = null;
			while(rs.next()){
				cal = Calendar.getInstance();
				Date date = new Date(rs.getTimestamp("dateVal").getTime());				
				cal.setTime(date);
				for(int i = 0; i < dailyRevenueExpenseTrackers.size(); i++){
					if(dailyRevenueExpenseTrackers.get(i).getCal().equals(cal)){
						dailyRevenueExpenseTracker = dailyRevenueExpenseTrackers.get(i);
						break;
					}
				}
				dailyRevenueExpenseTracker.setActualRevenue(rs.getDouble("actual"));
				dailyRevenueExpenseTracker.setTargetRevenue(rs.getDouble("expected"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
		
		return dailyRevenueExpenseTrackers;
	}


	@Override
	public SortedSet<DailyRevenueExpenseTracker> getMonthlyRevenueExpenseTrackerList(
			DashBoardQuery query) {
		SortedSet<DailyRevenueExpenseTracker> dailyRevenueExpenseTrackers = new TreeSet<DailyRevenueExpenseTracker>();
		StringBuffer select  = new StringBuffer("Select  sum(expected) as totalExpected, sum(actual) as totalActual ,dm.monthName as month, dm.year as year   from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0 and ");
		if(query.getRegionId() > 0){
			select.append(" rm.regionId = ").append(query.getRegionId()).append(" and ");
		}
		if(query.getSiteId() > 0){
			select.append(" rm.siteId = ").append(query.getSiteId()).append(" and ");
		}
		if(query.getDivisionId() > 0){
			select.append(" rm.divisionId = ").append(query.getDivisionId()).append(" and ");
		}
		if(query.getProductLineId() > 0){
			select.append(" rm.productLineId = ").append(query.getProductLineId()).append(" and ");
		}
		//addEndOfMonth(select, query);
		select.append(" dm.dateVal between ? and ? ").append(" and ");
		
		
		//get Revenue
		
		StringBuffer revenueQuery = new StringBuffer(select.toString());
		revenueQuery.append(" re.expenseId = 1 ");
		
		//get Expense
		
		StringBuffer expenseQuery = new StringBuffer(select.toString());
		if(query.getExpenseId() == -1){
			expenseQuery.append(" re.expenseId != 1 ");
			
		}else{
			expenseQuery.append( "re.expenseId = ").append(query.getExpenseId());
		}
		
		
		expenseQuery.append(" group by dm.year, dm.monthName  ");
		revenueQuery.append(" group by dm.year, dm.monthName  ");
		
		logger.debug("getMonthlyRevenueExpenseTrackerList Revenue query : "+revenueQuery.toString());
		logger.debug("getMonthlyRevenueExpenseTrackerList expenseQuery  : "+expenseQuery.toString());
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(expenseQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getEndOfMonth(query).getTime()));
			 rs = ps.executeQuery();
			DailyRevenueExpenseTracker dailyRevenueExpenseTracker = null;
			Calendar cal  = null;
			while(rs.next()){				
				dailyRevenueExpenseTracker = new DailyRevenueExpenseTracker();
				dailyRevenueExpenseTracker.setActualExepnse(rs.getDouble("totalActual"));
				dailyRevenueExpenseTracker.setTargetExpense(rs.getDouble("totalExpected"));
				cal = Calendar.getInstance();
				int  month =getMonth( rs.getString("month"));
				int year = rs.getInt("year");
				cal.set(year, month, 1);
				dailyRevenueExpenseTracker.setCal(cal);				
				dailyRevenueExpenseTrackers.add(dailyRevenueExpenseTracker);
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(revenueQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getEndOfMonth(query).getTime()));
			rs = ps.executeQuery();
			dailyRevenueExpenseTracker = null;
			cal  = null;
			while(rs.next()){
				int  month =getMonth( rs.getString("month"));
				logger.debug("month : "+month);
				int year = rs.getInt("year");
				
				Iterator<DailyRevenueExpenseTracker> iterator = dailyRevenueExpenseTrackers.iterator();
				while(iterator.hasNext()){
					DailyRevenueExpenseTracker d  = iterator.next();
					cal = d.getCal();
					if((cal.get(Calendar.YEAR) == year) && (cal.get(Calendar.MONTH) == month)){
						dailyRevenueExpenseTracker = d;
						break;
					}
				}				
				if(dailyRevenueExpenseTracker == null){
					logger.debug("month: "+month + "year : "+year);
				}
				//logger.debug(dailyRevenueExpenseTracker);
				dailyRevenueExpenseTracker.setActualRevenue(rs.getDouble("totalActual"));
				dailyRevenueExpenseTracker.setTargetRevenue(rs.getDouble("totalExpected"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
		
		return dailyRevenueExpenseTrackers;
	}


	@Override
	public List<DailyRevenueExpenseTracker> getYearlyRevenueExpenseTrackerList(
			DashBoardQuery query) {
		List<DailyRevenueExpenseTracker> dailyRevenueExpenseTrackers = new ArrayList<DailyRevenueExpenseTracker>();
		StringBuffer select  = new StringBuffer("Select  sum(expected) as totalExpected, sum(actual) as totalActual , dm.year as year   from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0 and ");
		if(query.getRegionId() > 0){
			select.append(" rm.regionId = ").append(query.getRegionId()).append(" and ");
		}
		if(query.getSiteId() > 0){
			select.append(" rm.siteId = ").append(query.getSiteId()).append(" and ");
		}
		if(query.getDivisionId() > 0){
			select.append(" rm.divisionId = ").append(query.getDivisionId()).append(" and ");
		}
		if(query.getProductLineId() > 0){
			select.append(" rm.productLineId = ").append(query.getProductLineId()).append(" and ");
		}
		select.append(" dm.dateVal between ? and ? ").append(" and ");
		//addEndOfMonth(select, query);
		
		//get Revenue
		
		StringBuffer revenueQuery = new StringBuffer(select.toString());
		revenueQuery.append(" re.expenseId = 1 ");
	
		//get Expense
		
		StringBuffer expenseQuery = new StringBuffer(select.toString());
		if(query.getExpenseId() == -1){
			expenseQuery.append(" re.expenseId != 1 ");
			
		}else{
			expenseQuery.append( "re.expenseId = ").append(query.getExpenseId());
		}
		expenseQuery.append(" group by dm.year  order by dm.year ASC");
		revenueQuery.append(" group by dm.year  order by dm.year ASC");
		
		logger.debug("getYearlyRevenueExpenseTrackerList Revenue query : "+revenueQuery.toString());
		logger.debug("getYearlyRevenueExpenseTrackerList expenseQuery  : "+expenseQuery.toString());
		
		Connection con = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(expenseQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getEndOfMonth(query).getTime()));
			 rs = ps.executeQuery();
			DailyRevenueExpenseTracker dailyRevenueExpenseTracker = null;
			Calendar cal  = null;
			while(rs.next()){				
				dailyRevenueExpenseTracker = new DailyRevenueExpenseTracker();
				dailyRevenueExpenseTracker.setActualExepnse(rs.getDouble("totalActual"));
				dailyRevenueExpenseTracker.setTargetExpense(rs.getDouble("totalExpected"));
				cal = Calendar.getInstance();
				int year = rs.getInt("year");
				cal.set(year, 0, 1);
				dailyRevenueExpenseTracker.setCal(cal);				
				dailyRevenueExpenseTrackers.add(dailyRevenueExpenseTracker);
			}
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(ps);
			ps = con.prepareStatement(revenueQuery.toString());
			 ps.setDate(1, new java.sql.Date(query.getStartDate().getTime()));
			 ps.setDate(2, new java.sql.Date(getEndOfMonth(query).getTime()));
			rs = ps.executeQuery();
			dailyRevenueExpenseTracker = null;
			cal  = null;
			while(rs.next()){
				int year = rs.getInt("year");
				for(int i = 0; i < dailyRevenueExpenseTrackers.size(); i++){
					if(dailyRevenueExpenseTrackers.get(i).getCal().get(Calendar.YEAR)==year){
						dailyRevenueExpenseTracker = dailyRevenueExpenseTrackers.get(i);
						break;
					}
				}
				if(dailyRevenueExpenseTracker == null){
					logger.debug("year : "+year);
				}
				dailyRevenueExpenseTracker.setActualRevenue(rs.getDouble("totalActual"));
				dailyRevenueExpenseTracker.setTargetRevenue(rs.getDouble("totalExpected"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		}
		
		return dailyRevenueExpenseTrackers;
	}
	private static String[] months = new DateFormatSymbols().getMonths();
	private int getMonth(String name){
		
		for(int j = 0; j < months.length; j++){
			if(name.equalsIgnoreCase(months[j])){
				return j;
			}
		}
		return -1;
	}
	
	private Date getEndOfMonth(DashBoardQuery query){
		Calendar today = getTodaysDate();
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(query.getEndDate());
		
		if(endDate.after(today)){
			endDate.set(Calendar.DATE, endDate.getMaximum(Calendar.DATE));
		}
		return endDate.getTime();
		//select.append(" dm.dateVal between ").append("'").append(sdf.format(query.getStartDate())).append("'").append(" and ").append("'").append(sdf.format(endDate.getTime())).append("' and ");
	}
	
	private Date getModifiedEndDate(DashBoardQuery query){
		Calendar today = getTodaysDate();
		
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(query.getEndDate());
		
		if((endDate.get(Calendar.YEAR) == today. get(Calendar.YEAR))
				&&  (endDate.get(Calendar.MONTH) == today. get(Calendar.MONTH))
				&&  endDate.get(Calendar.DATE) == endDate.getMaximum(Calendar.DATE)){
			endDate = today;
		}
		logger.debug("endDate : "+sdf.format(endDate.getTime()));
		return endDate.getTime();
	}

}
