package com.test.portlet.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author krant
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Rolesportlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/roleview.jsp",
		"javax.portlet.name=Rolesportlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Rolesportlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String ex = "\"en_US\"";
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<Role> SiteRoles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
			System.out.println(SiteRoles.size());
			System.out.println(themeDisplay.getCompanyId());
			int flag =1;
			for(Role role : SiteRoles){
				if(role.getName().equals("chandramouli")){
					flag=0;
					System.out.println("Role Already Exists...");
					break;
				}				
            }
			if(flag==1){				
				Map<Locale, String> titlemap = null;
				Map<Locale, String> descriptionmap = null;
				try {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
					RoleLocalServiceUtil.addRole(themeDisplay.getUserId(), "", 0L, "chandramouli", titlemap, descriptionmap, 1, "", serviceContext);
				} catch (PortalException e) {
					e.printStackTrace();
				}
				
			}
	}
}