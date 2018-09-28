package com.leykart.portlet;

import com.leykart.constants.LeyKartPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=return-and-cancellation-policy Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/return-and-cancellation-policy.jsp",
		"javax.portlet.name=return-and-cancellation-policy" ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Return_Cancellation extends MVCPortlet {
}