package com.mappingportlet.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.MappingServices.model.UserExternal;
import com.MappingServices.service.UserExternalLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Mapping",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CoursesPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view1.jsp",
		"javax.portlet.name=CoursesPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Courses extends MVCPortlet {
	/*@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("hello");
		 try {
			 List<UserExternal> findByPolicyID = UserExternalLocalServiceUtil.findByPolicyID("333");
			 System.out.println(findByPolicyID);
	}
			       catch (Exception e) {		     
	}
	 }*/
}