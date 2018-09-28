package com.delphi.portlet.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import com.delphi.portlet.model.ExpenseCatagory;
import com.delphi.portlet.model.ExpenseDetail;
import com.delphi.portlet.service.impl.DashBoardServiceMock;

public class DashBoardServiceMockTest {
	Class<DashBoardServiceMock> _dashBoardServiceMock=DashBoardServiceMock.class;
	
	@Test
	public void testGetAllSites() {
		try{
		    Method method =_dashBoardServiceMock.getDeclaredMethod("getAllSites");
	        List<com.delphi.portlet.model.Site> actual =(List) method.invoke(new DashBoardServiceMock());
	        assertNull(actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testShowRandomInteger() {
		try{
		    Method method =_dashBoardServiceMock.getDeclaredMethod("showRandomInteger",new Class[] {Integer.TYPE,Integer.TYPE});
		    method.setAccessible(true);
		    int actual =(int) method.invoke(new DashBoardServiceMock(), new Object[]  {10,20});
	        assertTrue( 10 <= actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateMonthlyExpense() {
		try{
		    Method method =_dashBoardServiceMock.getDeclaredMethod("createMonthlyExpense",new Class[] {Calendar.class});
		    method.setAccessible(true);
		    Calendar c=Calendar.getInstance();
		    ExpenseDetail actual =(ExpenseDetail) method.invoke(new DashBoardServiceMock(), new Object[]  {c});
		    assertNotNull(actual);
	        assertEquals(c.getTime(),actual.getDay().getDate());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateExpenseCatagoryList() {
		try{
		    Method method =_dashBoardServiceMock.getDeclaredMethod("createExpenseCatagoryList",new Class[] {});
		    method.setAccessible(true);
		    List<ExpenseCatagory> actual =(List) method.invoke(new DashBoardServiceMock(), new Object[]  {});
	        assertEquals(6,actual.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetStartDate() {
		try{
		    Method method =_dashBoardServiceMock.getDeclaredMethod("getStartDate",new Class[] {});
	        List<com.delphi.portlet.model.Site> actual =(List) method.invoke(new DashBoardServiceMock(), new Object[]  {});
	        assertNull(actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
