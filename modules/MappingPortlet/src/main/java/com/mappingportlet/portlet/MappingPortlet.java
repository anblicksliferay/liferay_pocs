package com.mappingportlet.portlet;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.mappingportlet.constants.MappingPortletKeys;
import com.servicemapping.model.location;
import com.servicemapping.service.locationLocalServiceUtil;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Mapping",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MappingPortlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view1.jsp",
		"javax.portlet.name=" + MappingPortletKeys.Mapping,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MappingPortlet extends MVCPortlet {
	public void addLocation(ActionRequest actionRequest, ActionResponse actionResponse) {
		 
		  try {
		   	String locationName =actionRequest.getParameter("locationName");
		    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    Long id=CounterLocalServiceUtil.increment(location.class.getName());
		   	location _location=locationLocalServiceUtil.createlocation(CounterLocalServiceUtil.increment());
		   	_location.setLocationName(locationName);
		   	_location.setGroupId(themeDisplay.getUser().getGroupId());
		   	_location.setCompanyId(themeDisplay.getUser().getCompanyId());
		   	_location.setUserId(themeDisplay.getUser().getUserId());
		   	_location.setUserName(themeDisplay.getUser().getFullName());
		   	_location.setCreateDate(new Date());
		   	_location.setModifiedDate(new Date());
		       locationLocalServiceUtil.addlocation(_location);
		  }
		       catch (Exception e) {		     
		   }
		 }
}