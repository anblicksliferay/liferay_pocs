package com.leykart.portlet;

import com.leykart.constants.LeyKartPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Terms_Conditions Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/Terms_Conditions.jsp",
		"javax.portlet.name=Terms_Conditions Portlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Terms_Conditions extends MVCPortlet {
}