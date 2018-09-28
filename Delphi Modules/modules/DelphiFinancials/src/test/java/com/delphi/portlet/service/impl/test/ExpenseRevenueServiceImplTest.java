package com.delphi.portlet.service.impl.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.reflect.Method;
import java.util.Date;
import org.junit.Test;
import com.delphi.portlet.service.impl.ExpenseRevenueServiceImpl;

public class ExpenseRevenueServiceImplTest {
	Class<ExpenseRevenueServiceImpl> _expenseRevenueServiceImpl=ExpenseRevenueServiceImpl.class;
	
	@Test
	public void testGetFormattedDate() {
		try{
		    Method method =_expenseRevenueServiceImpl.getDeclaredMethod("getFormattedDate",new Class[] {Integer.TYPE,String.class,Integer.TYPE});
		    method.setAccessible(true);
		    Date actualDate =(Date) method.invoke(new ExpenseRevenueServiceImpl(),new Object[] {2,"January",2018});
		    String expected="Tue Jan 02 00:00:00 GMT 2018";
		    String actual=actualDate.toString().trim();
		    assertEquals(expected,actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMonth() {
		try{
		    Method method =_expenseRevenueServiceImpl.getDeclaredMethod("getMonth",new Class[] {String.class});
		    method.setAccessible(true);
		    int actual =(int) method.invoke(new ExpenseRevenueServiceImpl(),new Object[] {"January"});
		    int expected=1;
		    assertEquals(expected,actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateDateId() {
		try{
		    Method method =_expenseRevenueServiceImpl.getDeclaredMethod("createDateId",new Class[] {Integer.TYPE,String.class,Integer.TYPE});
		    method.setAccessible(true);
		    int actual =(int) method.invoke(new ExpenseRevenueServiceImpl(),new Object[] {2,"January",2018});
		    int expected=1022018;
		   assertEquals(expected,actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
