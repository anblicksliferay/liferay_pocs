package com.delphi.portlet.service.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;
import com.delphi.portlet.service.impl.DashBoardServiceImpl;


public class DashBoardServiceImplTest {
	Class<DashBoardServiceImpl> _dashBoardServiceImpl = DashBoardServiceImpl.class;
	
	/*@Test
    public void justAnExample() {
		
		DashBoardService dbService = new DashBoardServiceImpl(); 
//		String str = DelphiFinancialConstants.DIVISION_PRODUCTLINE_FIELD; 
		
//		DelphiFinancialConstants delphiFinancialConstants = new DelphiFinancialConstants(); 
		assertEquals(1 , 1);
        System.out.println("This test method should be run");
    }*/
	
	@Test
    public void testGetTodaysDate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		    Method met = _dashBoardServiceImpl.getDeclaredMethod("getTodaysDate");
	        met.setAccessible(true);
	        Calendar returnedValue =(Calendar) met.invoke(new DashBoardServiceImpl());
	        TimeZone obj = TimeZone.getTimeZone("CST");
			
	        Calendar expectedValue = Calendar.getInstance();  
	        expectedValue.setTime(new Date());
	        expectedValue.setTimeZone(obj);
	        if(expectedValue.getTime().getHours() < 8)
	        	expectedValue.add(Calendar.DATE, -2);
			else
				expectedValue.add(Calendar.DATE, -1);
	        
//		    assertEquals(returnedValue.getTime(),expectedValue.getTime());
    }
	
	@Test
	public void testGetMonth() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		 Method met = _dashBoardServiceImpl.getDeclaredMethod("getMonth", new Class[] { String.class});
	       met.setAccessible(true);
	       int actuals =(int) met.invoke(new DashBoardServiceImpl(), new Object[]  {"February"});
	       assertEquals(1, actuals);
	}
}
