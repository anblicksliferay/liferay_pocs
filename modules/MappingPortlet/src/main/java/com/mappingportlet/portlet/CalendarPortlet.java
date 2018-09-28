package com.mappingportlet.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Mapping",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CalendarPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view2.jsp",
		"javax.portlet.name=CalendarPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CalendarPortlet extends MVCPortlet {
        public void addUser(ActionRequest request,ActionResponse response)
        	throws IOException, PortletException, PortalException {
        	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        	long siteid = themeDisplay.getSiteGroupId();
        	long calendarid=getCalendar(siteid);
        	addevent(request,calendarid);
        }
        public void addevent(ActionRequest request, long calendarid) throws PortalException {
        	  String ex = "\"en_US\"";
        	  CalendarBooking calendarBooking = null;	      
        	      ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        	      try {
        	      com.liferay.calendar.model.Calendar cal = CalendarLocalServiceUtil.getCalendar(calendarid);
        	      calendarBooking  = CalendarBookingLocalServiceUtil.createCalendarBooking(CounterLocalServiceUtil.increment(CalendarBooking.class.getName()));
        	      calendarBooking.setCalendarBookingId(CounterLocalServiceUtil.increment(CalendarBooking.class.getName()));
        	      calendarBooking.setUserName("");
        	      calendarBooking.setCompanyId(themeDisplay.getCompanyId());
    	          calendarBooking.setUserId(themeDisplay.getUserId());
    	          calendarBooking.setGroupId(themeDisplay.getSiteGroupId());
    	          calendarBooking.setStartTime(1521822720000L);
    	          calendarBooking.setEndTime(1521828900000L);
    	          calendarBooking.setTitle("<?xml version='1.0' encoding='UTF-8'?><root available-locales="+ex+" default-locale="+ex+"><Title language-id="+ex+">interview</Title></root>");
    	          calendarBooking.setDescription("<?xml version='1.0' encoding='UTF-8'?><root available-locales="+ex+" default-locale="+ex+"><Description language-id="+ex+">Basis of Java</Description></root>");
    	          calendarBooking.setCreateDate(new Date());
    	          calendarBooking.setCalendarId(cal.getCalendarId());
    	          calendarBooking.setCalendarResourceId(cal.getCalendarResourceId());
    	          calendarBooking.setResourceBlockId(cal.getResourceBlockId());
    	          calendarBooking= CalendarBookingLocalServiceUtil.addCalendarBooking(calendarBooking);	 
    	          calendarBooking.setParentCalendarBookingId(calendarBooking.getCalendarBookingId());
    	          CalendarBookingLocalServiceUtil.updateCalendarBooking(calendarBooking);        	          
        	} catch (Exception e) {
        	}
        	                
        	}
		public static long getCalendar(long siteid){	    	
	    List<Calendar> calendars = CalendarLocalServiceUtil.getCalendars(0, CalendarLocalServiceUtil.getCalendarsCount());
	    for(Calendar cal : calendars){
	    	if(cal.getGroupId()==siteid){
	    		return cal.getCalendarId();
	    	}
	    }
	    return 0L;
	    }
	
}