package com.ys.hmawfm.pi.portlets;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AccountingApp",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=PIProcessing Portlet",
			"javax.portlet.init-param.view-template=/html/piprocessing/view.jsp",
			"javax.portlet.name=PIProcessing",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)

public class PIProcessing extends MVCPortlet {
@Override
public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {	
	super.doView(renderRequest, renderResponse);
}
}