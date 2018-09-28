package com.delphi.portlet.model.service;

import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

import com.delphi.portlet.DelphiFinancialsAdminPortlet;
import com.delphi.portlet.model.DashBoardQuery;
import com.delphi.portlet.service.DashBoardService;
import com.delphi.portlet.service.impl.DashBoardServiceImpl;
import com.delphi.util.DelphiFinancialConstants;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;


public class DashBoardServiceTest {
	Class<DashBoardServiceImpl> _dashBoardServiceImpl = DashBoardServiceImpl.class;
	
	@Test
    public void justAnExample() {
		
		DashBoardService dbService = new DashBoardServiceImpl(); 
//		String str = DelphiFinancialConstants.DIVISION_PRODUCTLINE_FIELD; 
		
//		DelphiFinancialConstants delphiFinancialConstants = new DelphiFinancialConstants(); 
		assertTrue(1 == 1);
        System.out.println("This test method should be run");
    }
	
	@Test
    public void testGetTodaysDate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		    Method met = _dashBoardServiceImpl.getDeclaredMethod("getTodaysDate", new Class[] {});
	        met.setAccessible(true);
	        Calendar expected =(Calendar) met.invoke(new DashBoardServiceImpl(), new Object[]  {});
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
//		    assertEquals(expected, cal);
    }
	@Test
	public void testGetMonth() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		 Method met = _dashBoardServiceImpl.getDeclaredMethod("getMonth", new Class[] { String.class});
	       met.setAccessible(true);
	       int actuals =(int) met.invoke(new DashBoardServiceImpl(), new Object[]  {"February"});
           System.out.println("actuals>>"+actuals);
	       assertEquals(1, actuals);
	}
}
