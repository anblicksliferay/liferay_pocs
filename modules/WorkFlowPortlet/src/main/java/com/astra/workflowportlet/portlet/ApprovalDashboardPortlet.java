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
			"javax.portlet.display-name= Approval DashBoard",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/ApprovalDashBoard.jsp",
			"javax.portlet.name=" + WorkFlowPortletKeys.ApprovalDashBoard,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)


public class ApprovalDashboardPortlet extends MVCPortlet {
	

}