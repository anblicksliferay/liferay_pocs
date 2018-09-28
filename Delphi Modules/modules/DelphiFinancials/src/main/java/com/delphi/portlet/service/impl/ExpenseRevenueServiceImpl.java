package com.delphi.portlet.service.impl;

import com.delphi.portlet.model.Day;
import com.delphi.portlet.model.ExpenseCatagory;
import com.delphi.portlet.model.ExpenseDetail;
import com.delphi.portlet.model.ExpenseRevenueQuery;
import com.delphi.portlet.model.ExpenseRevenueResult;
import com.delphi.portlet.model.ExpenseRevenueSaveUpdate;
import com.delphi.portlet.model.NameId;
import com.delphi.portlet.service.ExpenseRevenueService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExpenseRevenueServiceImpl implements ExpenseRevenueService {
	private static Log logger = LogFactoryUtil
			.getLog(ExpenseRevenueServiceImpl.class);
	private static final long serialVersionUID = -2695483005186625763L;
	private static String REVENUE_EXPENSE ="com.ys.delphi.model.RevenueExpense";

	@Override
	public ExpenseCatagory getExpenseRevenueMetaData(int siteId)
			throws Exception {
		logger.info("getExpenseRevenueMetaData siteId = "+siteId);
		ExpenseCatagory expenseCatagory = new ExpenseCatagory();
		expenseCatagory.setNameId(new NameId(1, ""));
		com.delphi.portlet.model.ProductLine productLine = null;
		com.delphi.portlet.model.Division division = null;

		SortedSet<com.delphi.portlet.model.Division> divisions = new TreeSet<com.delphi.portlet.model.Division>();
		expenseCatagory.setDivisions(divisions);

		int divisionId = 0;
		String divisionShortName = "";
		int productlineId = 0;
		String productlineShortName = "";
		int rpdpId = 0;

		StringBuffer sb = new StringBuffer(
				"select rm.divisionId as divisionId, dim.divisionShortName as divisionShortName, rm.productlineId as productlineId , plm.productlineShortName as productlineShortName, rm.rpdpId as rpdpId ");
		sb.append("	from RPDP_Mapping rm, Division_Master dim ,Product_Line_Master plm");
		sb.append("	where dim.divisionId = rm.divisionId and  plm.productlineId = rm.productlineId  and  rm.siteId = ?");

		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, siteId);
			rs = ps.executeQuery();			
			while (rs.next()) {
				divisionId = rs.getInt("divisionId");
				divisionShortName = rs.getString("divisionShortName");
				productlineId = rs.getInt("productlineId");
				productlineShortName = rs.getString("productlineShortName");
				rpdpId = rs.getInt("rpdpId");

				divisionId = rs.getInt("divisionId");
				divisionShortName = rs.getString("divisionShortName");
				productlineId = rs.getInt("productlineId");
				productlineShortName = rs.getString("productlineShortName");

				division = getDivision(divisions, divisionId);
				if (division == null) {
					division = new com.delphi.portlet.model.Division();
					division.setNameId(new NameId(divisionId, divisionShortName));
					divisions.add(division);
				}
				productLine = getProductLine(division, productlineId);
				if (productLine == null) {
					productLine = new com.delphi.portlet.model.ProductLine();
					productLine.setNameId(new NameId(productlineId,
							productlineShortName));
					productLine.setRpdpId(rpdpId);
					division.getProductLines().add(productLine);
				}

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con, ps, rs);
		}
		//logger.info("getExpenseRevenueMetaData , "+expenseCatagory);
		return expenseCatagory;
	}

	
	@Override
	public ExpenseRevenueResult getExpenseRevenue(ExpenseRevenueQuery q) {
		logger.info("getExpenseRevenue , q = "+q);
		ExpenseRevenueResult result = new ExpenseRevenueResult();
		result.setYear(q.getYear());
		result.setExpenseId(q.getExpenseId());
		result.setMonth(q.getMonth());
		result.setSiteId(q.getSiteId());
		ExpenseCatagory ec = new ExpenseCatagory();
		ec.setNameId(new NameId(q.getExpenseId(), ""));
		result.setExpenseCatagory(ec);

		SortedSet<com.delphi.portlet.model.Division> divisions = new TreeSet<com.delphi.portlet.model.Division>();
		ec.setDivisions(divisions);

		int divisionId = 0;
		String divisionShortName = "";
		int productlineId = 0;
		String productlineShortName = "";
		Date dateVal = null;
		int rpdpId = 0;
		int reId = 0;
		double expected = 0;
		double actual = 0;
		boolean isHoliday = false;
		boolean isWeekend = false;
		int dateId = 0;

		StringBuffer sb = new StringBuffer(
				"select rm.divisionId as divisionId, dim.divisionShortName as divisionShortName, expected, actual, rm.productlineId as productlineId , plm.productlineShortName as productlineShortName, dm.dateVal as dateVal ,dm.dayOfWeek as dayOfWeek ,re.rpdpId as rpdpId ,re.reId as reId, re.isHoliday as isHoliday, dm.isWeekend as isWeekend ,dm.dateId as dateId");
		sb.append("	from Revenue_Expense re, RPDP_Mapping rm, Date_Master dm  , Division_Master dim ,Product_Line_Master plm");
		sb.append("	where re.rpdpId  = rm.rpdpId  and dm.dateId = re.dateId and dm.isGenericDom = 0 and dim.divisionId = rm.divisionId and  plm.productlineId = rm.productlineId and ");
		sb.append("	dm.monthName=? and  dm.year= ? and rm.siteId = ? and re.expenseId = ?");

		logger.info("sb : "+sb.toString() );
		Day day = null;
		ExpenseDetail expenseDetail = null;
		com.delphi.portlet.model.ProductLine productLine = null;
		com.delphi.portlet.model.Division division = null;
		SortedSet<ExpenseDetail> expenseDetails = null;
		PreparedStatement reveneExpensePrepStmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			reveneExpensePrepStmt = con.prepareStatement(sb.toString());
			reveneExpensePrepStmt.setString(1, q.getMonth());
			reveneExpensePrepStmt.setInt(2, q.getYear());
			reveneExpensePrepStmt.setInt(3, q.getSiteId());
			reveneExpensePrepStmt.setInt(4, q.getExpenseId());

			rs = reveneExpensePrepStmt.executeQuery();
			while (rs.next()) {
				divisionId = rs.getInt("divisionId");
				divisionShortName = rs.getString("divisionShortName");
				productlineId = rs.getInt("productlineId");
				productlineShortName = rs.getString("productlineShortName");
				dateVal = new Date(rs.getTimestamp("dateVal").getTime());
				rpdpId = rs.getInt("rpdpId");
				reId = rs.getInt("reId");
				expected = rs.getDouble("expected");
				actual = rs.getDouble("actual");
				isHoliday = (rs.getInt("isHoliday") > 0 ? true : false);
				isWeekend = (rs.getInt("isWeekend") > 0 ? true : false);
				dateId = rs.getInt("dateId");

				day = new Day(dateId, dateVal, isWeekend, isHoliday);
				expenseDetail = new ExpenseDetail();
				expenseDetail.setActual(actual);
				expenseDetail.setDay(day);
				expenseDetail.setReId(reId);
				expenseDetail.setTaget(expected);

				division = getDivision(divisions, divisionId);
				if (division == null) {
					division = new com.delphi.portlet.model.Division();
					division.setNameId(new NameId(divisionId, divisionShortName));
					divisions.add(division);
				}
				productLine = getProductLine(division, productlineId);
				if (productLine == null) {
					productLine = new com.delphi.portlet.model.ProductLine();

					productLine.setNameId(new NameId(productlineId,
							productlineShortName));
					productLine.setRpdpId(rpdpId);
					expenseDetails = new TreeSet<ExpenseDetail>();
					productLine.setExpenseDetails(expenseDetails);
					division.getProductLines().add(productLine);
				}
				productLine.getExpenseDetails().add(expenseDetail);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con, reveneExpensePrepStmt, rs);
		}
		// logger.info(result.getExpenseCatagory());
		return result;
	}

	private com.delphi.portlet.model.Division getDivision(
			SortedSet<com.delphi.portlet.model.Division> divisions,
			int id) {
		for (com.delphi.portlet.model.Division d : divisions) {
			if (d.getNameId().getId() == id) {
				return d;
			}
		}

		return null;
	}

	private com.delphi.portlet.model.ProductLine getProductLine(
			com.delphi.portlet.model.Division division,
			int productlineId) {
		if (division.getProductLines() == null) {
			SortedSet<com.delphi.portlet.model.ProductLine> productLines = new TreeSet<com.delphi.portlet.model.ProductLine>();
			division.setProductLines(productLines);
			return null;
		}
		for (com.delphi.portlet.model.ProductLine p : division
				.getProductLines()) {
			if (p.getNameId().getId() == productlineId) {
				return p;
			}
		}
		return null;

	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	private void checkOrcreateDates(String month, int year) throws Exception {
		logger.info("creating monthly rows for "+month+" "+year);
		Calendar mycal = new GregorianCalendar(year, getMonth(month) -1, 1);
		int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
		String dateMasterInsertSQL = "INSERT INTO  Date_Master VALUES(? , ? , ? , ? , ? , ? , ?, ? , ? , ?)";
		
		Connection con = null;
		PreparedStatement psDate = null;
		PreparedStatement dmPS = null;
		ResultSet rs = null;
		int dateId = createDateId(0, month,year);
		
		String monthDisplayName = month.substring(0, 3) + " " + year;
		
		String dateMasterSelectSQL = "Select count(*) as count from Date_Master where monthDisplayName = ?";
		
		int [] batchInsertStatus= null;
		
		try {
			con = DataAccess.getConnection();
			con.setAutoCommit(false);
			
			dmPS = con.prepareStatement(dateMasterSelectSQL);
			dmPS.setString(1, monthDisplayName);
			rs = dmPS.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("count");
				if(count == 0 ){
					logger.info(month+" "+year + " does NOT exist in the date_master");
				}else if(count >= daysInMonth ){
					logger.info(month+" "+year + " exist in the date_master");
					return;
				}else {
					logger.error("Please check date master table as there are less than expect row for:"+monthDisplayName+  " , count = "+ count);
					throw new Exception("date-master table count not correct");
				}
							
			}
			logger.info("isDateExist :  false");			
			
			psDate = con.prepareStatement(dateMasterInsertSQL);
			//For Generic Dom
			Date dateval = getFormattedDate(0, month,year);	
			psDate.setInt(1, dateId);
			psDate.setDate(2, new java.sql.Date(dateval.getTime()));
			psDate.setString(3, month);
			psDate.setString(4, monthDisplayName);
			psDate.setInt(5, year);
			psDate.setString(6, "");
			psDate.setInt(7, 0);
			psDate.setInt(8, 1);
			psDate.setTimestamp(9, getCurrentTimeStamp());
			psDate.setTimestamp(10, getCurrentTimeStamp());
			psDate.addBatch();		
			
		
			for(int i=1; i<=daysInMonth;i++){
				String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dateval);
				 dateId = createDateId(i, month,year);
				 dateval = getFormattedDate(i, month,year);
				int isWeekend = 0;
				if (dayOfWeek.equalsIgnoreCase("Saturday")
						|| dayOfWeek.equalsIgnoreCase("Sunday")) {
					isWeekend = 1;
				}
				
				psDate.setInt(1, dateId);
				psDate.setDate(2, new java.sql.Date(dateval.getTime()));
				psDate.setString(3, month);
				psDate.setString(4, monthDisplayName);
				psDate.setInt(5, year);
				psDate.setString(6, dayOfWeek);
				psDate.setInt(7, isWeekend);
				psDate.setInt(8, 0);
				psDate.setTimestamp(9, getCurrentTimeStamp());
				psDate.setTimestamp(10, getCurrentTimeStamp());
				psDate.addBatch();
			}
			
			batchInsertStatus =  psDate.executeBatch();
			logger.info("Size of batchInsertStatus for date master : "+ batchInsertStatus.length);
			con.commit();
		} catch (Exception e) {
			if(con != null){
				con.rollback();
			}
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		}  finally {
			DataAccess.cleanUp(con, psDate);
			DataAccess.cleanUp(con, dmPS,rs);
		}
		
		
		
	}
	public void saveExpenseRevenue(
			List<ExpenseRevenueSaveUpdate> expenseRevenueSaveUpdates)
			throws Exception {
		logger.info("saveExpenseRevenue , expenseRevenueSaveUpdates size :  "+expenseRevenueSaveUpdates.size());
		if (expenseRevenueSaveUpdates == null
				|| expenseRevenueSaveUpdates.size() < 2) {
			logger.error("expenseRevenueSaveUpdates is either null or less than 2");
			throw new Exception(
					"expenseRevenueSaveUpdates is either null or less than 2");
		}
		Connection con = null;
		PreparedStatement psRevenueExpense = null;
		int dateId = 0;
		int [] batchInsertStatus= null;
		ExpenseRevenueSaveUpdate firstRecord = expenseRevenueSaveUpdates.get(0);		
		
		String RevenueExpenseInsertSQL = "INSERT INTO Revenue_Expense(reId,dateId,rpdpId,expenseId,expected,actual,isHoliday,updatedBy,createDate,modifiedDate) VALUES(?,? , ? , ? , ? , ? , ?, ? , ? , ?)";

		double totalTarget = 0;
		double totalActual = 0;
		try {
			con = DataAccess.getConnection();	
			con.setAutoCommit(false);
			checkOrcreateDates(firstRecord.getMonth(),firstRecord.getYear());
			psRevenueExpense = con.prepareStatement(RevenueExpenseInsertSQL);
			
			for (ExpenseRevenueSaveUpdate er : expenseRevenueSaveUpdates) {
				dateId = createDateId(er.getDay(), er.getMonth(),er.getYear());	
				
				psRevenueExpense.setLong(1, CounterLocalServiceUtil.increment(REVENUE_EXPENSE));
				psRevenueExpense.setInt(2, dateId);
				psRevenueExpense.setInt(3, er.getRpdpId());
				psRevenueExpense.setInt(4, er.getExpenceCatogoryId());
				psRevenueExpense.setDouble(5,
						er.getExpected() == null ? 0 : er.getExpected());				
				psRevenueExpense.setDouble(6,
						er.getActual() == null ? 0 : er.getActual());
				psRevenueExpense.setInt(7,
						er.isHoliday() == null ? 0 : (er.isHoliday() ? 1 : 0));
				psRevenueExpense.setString(8, er.getUpdatedBy());
				psRevenueExpense.setTimestamp(9, getCurrentTimeStamp());
				psRevenueExpense.setTimestamp(10, getCurrentTimeStamp());
				psRevenueExpense.addBatch();

				totalTarget += (er.getExpected() == null ? 0 : er.getExpected());
				totalActual += (er.getActual() == null ? 0 : er.getActual());
			}
			// add Total

			dateId = createDateId(0, firstRecord.getMonth(),
					firstRecord.getYear());
			psRevenueExpense.setLong(1, CounterLocalServiceUtil.increment(REVENUE_EXPENSE));
			psRevenueExpense.setInt(2, dateId);
			psRevenueExpense.setInt(3, firstRecord.getRpdpId());
			psRevenueExpense.setInt(4, firstRecord.getExpenceCatogoryId());
			psRevenueExpense.setDouble(5, totalTarget);			
			psRevenueExpense.setDouble(6, totalActual);
			psRevenueExpense.setInt(7, 0);
			psRevenueExpense.setString(8, "");
			psRevenueExpense.setTimestamp(9, getCurrentTimeStamp());
			psRevenueExpense.setTimestamp(10, getCurrentTimeStamp());
			psRevenueExpense.addBatch();
			
			batchInsertStatus = psRevenueExpense.executeBatch();
			logger.info("Size of batchInsertStatus for revenue Expense :  "+ batchInsertStatus.length);
			con.commit();
		} catch (Exception e) {
			if(con != null){
				con.rollback();
			}
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		}  finally {
			DataAccess.cleanUp(con, psRevenueExpense);
		}

	}

	private void updateExpenseRevenue(
			ExpenseRevenueSaveUpdate expenseRevenueSaveUpdate) throws Exception {
		StringBuffer updateSQL = new StringBuffer("UPDATE Revenue_Expense Set ");
		if (expenseRevenueSaveUpdate.getActual() != null) {
			updateSQL.append("actual =")
					.append(expenseRevenueSaveUpdate.getActual()).append(" , ");
		}
		if (expenseRevenueSaveUpdate.getExpected() != null) {
			updateSQL.append("expected =")
					.append(expenseRevenueSaveUpdate.getExpected())
					.append(" , ");
			;
		}
		updateSQL.append(" updatedBy= ?, modifiedDate= ? WHERE reId = ?");
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataAccess.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(updateSQL.toString());
			ps.setString(1, expenseRevenueSaveUpdate.getUpdatedBy());
			ps.setTimestamp(2, getCurrentTimeStamp());
			ps.setInt(3, expenseRevenueSaveUpdate.getReId());
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if(con != null){
				con.rollback();
			}
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			DataAccess.cleanUp(con, ps);
		}
	}

	@Override
	public void saveOrUpdateExpenseRevenue(
			List<ExpenseRevenueSaveUpdate> expenseRevenueSaveUpdates)
			throws Exception {
		if (expenseRevenueSaveUpdates == null
				|| expenseRevenueSaveUpdates.size() == 0) {
			logger.error("expenseRevenueSaveUpdates is null or blank");

		} else if (expenseRevenueSaveUpdates.size() == 1) {
			updateExpenseRevenue(expenseRevenueSaveUpdates.get(0));
		} else {
			saveExpenseRevenue(expenseRevenueSaveUpdates);
		}

	}

	@Override
	public List<NameId> getRegions() {
		List<NameId> regions = new ArrayList<NameId>();
		
			StringBuffer sb = new StringBuffer(" Select regionId as regionId, regionName as  regionName from Region_Master ");
			
			PreparedStatement ps = null;
			Connection con = null;
			ResultSet rs = null;
			try {
				con = DataAccess.getConnection();
				ps = con.prepareStatement(sb.toString());
				rs = ps.executeQuery();			
				while (rs.next()) { 
					NameId id = new NameId(rs.getInt("regionId"), rs.getString("regionName"));
					regions.add(id);
				}
			}catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}  finally {
				DataAccess.cleanUp(con, ps,rs);
			}
		return regions;
	}

	@Override
	public List<NameId> getSites() {
		List<NameId> sites = new ArrayList<NameId>();
		StringBuffer sb = new StringBuffer(" Select siteId as siteId, siteName as  siteName  from Site_Master ");
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sb.toString());
			rs = ps.executeQuery();			
			while (rs.next()) { 
				NameId id = new NameId(rs.getInt("siteId"), rs.getString("siteName"));
				sites.add(id);
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps,rs);
		}
		return sites;
	}

	private Date getFormattedDate(int day, String month, int year)
			throws ParseException {
		int monthNumber = getMonth(month);
		if (day == 0)
			day = 1;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = DATE_FORMAT.parse(year + "-" + monthNumber + "-" + day
				+ " " + 00 + ":" + 00 + ":" + 00);
		return date;
	}

	private int getMonth(String month) {
		int monthVal = 0;
		try {
			Date date = new SimpleDateFormat("MMM").parse(month);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			monthVal = cal.get(Calendar.MONTH);
			// logger.info(monthVal);
		} catch (ParseException pe) {
			logger.error(pe);
		}
		return monthVal + 1;
	}

	private int createDateId(int day, String month, int year) {
		int dateId = 0;
		if (day == 0) {
			// if day is 0 the create a generic date id
			dateId = Integer.parseInt(String.valueOf(getMonth(month))
					+ String.valueOf(year));
		} else {
			if (day > 0 && day < 10) {
				dateId = Integer.parseInt(String.valueOf(getMonth(month))
						+ String.valueOf(0) + String.valueOf(day)
						+ String.valueOf(year));
			} else if (day >= 10) {
				dateId = Integer.parseInt(String.valueOf(getMonth(month))
						+ String.valueOf(day) + String.valueOf(year));
			}
		}
		//logger.info(dateId);
		return dateId;
	}

	@Override
	public List<NameId> getExpenseCatagories() {
		List<NameId> catagoryNames = new ArrayList<NameId>();
		StringBuffer sb = new StringBuffer(" Select expenseId as expenseId, expenseName as  expenseName  from Expense_Categories_Master ");
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(sb.toString());
			rs = ps.executeQuery();			
			while (rs.next()) { 
				NameId id = new NameId(rs.getInt("expenseId"), rs.getString("expenseName"));
				catagoryNames.add(id);
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps,rs);
		}

		return catagoryNames;
	}


	@Override
	public void savePartialExpenseRevenueData(int siteId, String month, int year, String partialData)
			throws Exception {
		// first delete any existing data
		deletePartialExpenseRevenueData(siteId, month, year);
		
		String partialInsertSQL = "INSERT INTO  REVENUE_EXPENSE_PARTIAL (SITE_ID, MONTH, YEAR, DATA) VALUES (? , ? , ? , ? )";
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(partialInsertSQL);
			ps.setInt(1, siteId);
			ps.setString(2, month);
			ps.setInt(3, year);
			ps.setString(4, partialData);
			rs = ps.executeQuery();			
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps,rs);
		}		
	}


	@Override
	public void deletePartialExpenseRevenueData(int siteId, String month, int year) throws Exception {
		String partialDeleteSQL = "DELETE FROM  REVENUE_EXPENSE_PARTIAL WHERE site_id = ? and month = ? and year = ?";
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(partialDeleteSQL);
			ps.setInt(1, siteId);
			ps.setString(2, month);
			ps.setInt(3, year);
			rs = ps.executeQuery();			
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps,rs);
		}		
		
	}


	@Override
	public String getPartialExpenseRevenueData(int siteId, String month, int year) throws Exception {
		String partialSelectSQL = "Select data FROM  REVENUE_EXPENSE_PARTIAL WHERE site_id = ? and month = ? and year = ?";
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(partialSelectSQL);
			ps.setInt(1, siteId);
			ps.setString(2, month);
			ps.setInt(3, year);
			rs = ps.executeQuery();	
			while (rs.next()) { 
				String partialData = rs.getString("data");
				return partialData ;
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}  finally {
			DataAccess.cleanUp(con, ps,rs);
		}		
		return null ; 
	}

}
