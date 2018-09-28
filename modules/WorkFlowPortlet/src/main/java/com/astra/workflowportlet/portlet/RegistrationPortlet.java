package com.astra.workflowportlet.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.astra.workflowportlet.constants.WorkFlowPortletKeys;
import com.astra.workflowservice.model.Registration;
import com.astra.workflowservice.service.RegistrationLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Astra",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name= Registration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/Registration.jsp",
		"javax.portlet.name=" + WorkFlowPortletKeys.Registration,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RegistrationPortlet extends MVCPortlet {
	public void addTrainee(ActionRequest request,ActionResponse response) throws IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Long id=CounterLocalServiceUtil.increment(Registration.class.getName());
		Registration createRegistration = RegistrationLocalServiceUtil.createRegistration(id);
		createRegistration.setFirstname(ParamUtil.getString(request,"fname"));
		createRegistration.setLastname(ParamUtil.getString(request,"lname"));
		createRegistration.setEmail(ParamUtil.getString(request,"email"));
		createRegistration.setCourse(ParamUtil.getString(request, "course"));
		createRegistration.setLocation(ParamUtil.getString(request,"loc"));
		createRegistration.setStatus("Pending");
		createRegistration.setComments("In Process Waiting for Approval");
		createRegistration.setWorkflowId("Astra_Registration");
		createRegistration.setWorkflowstepnumber("0");
		createRegistration.setCurrentApprover("Senior Developer");
	   	createRegistration.setCompanyId(themeDisplay.getUser().getCompanyId());
	   	createRegistration.setUserId(themeDisplay.getUser().getUserId());
	   	createRegistration.setUserName(themeDisplay.getUser().getFullName());
	   	createRegistration.setCreateDate(new Date());
	   	createRegistration.setModifiedDate(new Date());
	   	Registration addRegistration = RegistrationLocalServiceUtil.addRegistration(createRegistration);
	   	System.out.println("Registered data :"+addRegistration.toString());	
	   	if(Validator.isNotNull(addRegistration)){
	   		response.sendRedirect("/group/astra/viewstatus");
	   	}
	}
	
}