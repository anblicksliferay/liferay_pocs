package com.astra.workflowportlet.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.astra.workflowportlet.constants.WorkFlowPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=Astra",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name= ViewStatus",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + WorkFlowPortletKeys.ViewStatus,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)

public class ViewStatusPortlet extends MVCPortlet {
	/* @Override
	    public void serveResource(ResourceRequest resourceRequest,
	            ResourceResponse resourceResponse) throws IOException,PortletException {
	        String cmd = ParamUtil.getString(resourceRequest, "cmd");
	     if(cmd.equalsIgnoreCase("getRegistrationData")) {  
		List<Registration> registrations = RegistrationLocalServiceUtil.getRegistrations(0, RegistrationLocalServiceUtil.getRegistrationsCount());
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (Registration registration : registrations) {
        	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        	jsonObject.put("Name", registration.getFirstname()+" "+registration.getLastname());
			jsonObject.put("Course", registration.getCourse());
			jsonObject.put("Status", registration.getStatus());
			jsonObject.put("Comments", registration.getComments());
			jsonArray.put(jsonObject);
		}
		PrintWriter writer1 = resourceResponse.getWriter();
        writer1.print(jsonArray);
		System.out.println("Registration data :"+jsonArray.toString());
	     }
		
	}
*/
}
