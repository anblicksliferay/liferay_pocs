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
			"javax.portlet.display-name= Manage Approval",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/ManageApproval.jsp",
			"javax.portlet.name=" + WorkFlowPortletKeys.ManageApproval,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)


public class ManageApprovalPortlet extends MVCPortlet {

}
