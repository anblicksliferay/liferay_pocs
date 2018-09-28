package com.configure;

import com.ddt.service.TestimonialAshokLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true, 
		property={"com.liferay.portlet.display-category=AshokLeyLand",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.init-param.template-path=/", 
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user", 
				"javax.portlet.init-param.view-template=/configureportlet/view.jsp", 
				"javax.portlet.display-name=ConfigurePortlet Portlet"
				}, 
		service={Portlet.class})
public class ConfigurePortlet extends MVCPortlet
		{
		  
		  public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		    throws IOException, PortletException
		  {	 
			 
		    super.doView(renderRequest, renderResponse);
		  }
		  
		  public void deleteProfile(ActionRequest actionRequest, ActionResponse actionResponse) {
		    long userId = Long.parseLong(actionRequest.getParameter("userid"));
		    _log.info("deleteProfile Id passed is:" + userId);
		    _log.info("inside delete");
		    try {
		      TestimonialAshokLocalServiceUtil.deleteTestimonialAshok(userId);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
		  
		  public void editProfile(ActionRequest actionRequest, ActionResponse actionResponse) { String userId = actionRequest.getParameter("editid");
		    _log.info("editProfile Id passed is:" + userId);
		    _log.info("inside editProfile");
		    try {
		      actionRequest.setAttribute("editid", userId);
		      actionResponse.setRenderParameter("jspPage", "/configureportlet/addAndEdit.jsp");
		    } catch (Exception e) {
		      e.printStackTrace();
		      _log.error(e);
		    }
		  }
		  
		
		
		  public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		    throws IOException, PortletException
		  {
		    String cmd = ParamUtil.getString(resourceRequest, "cmd");
		    String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		    String context = ParamUtil.getString(resourceRequest, "context");
		    _log.debug("My Notifications -- in the serverresource");
		    if (cmd.equalsIgnoreCase("list")) {
		      ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
		      User user = themeDisplay.getUser();     
		      long userId = user.getUserId();
		      try
		      {
		        JSONObject returnObject = JSONFactoryUtil.createJSONObject();
		        returnObject.put("data", "storeDefault request completed sucessfully");
		        writeJSON(resourceRequest, resourceResponse, returnObject);
		      }
		      catch (Exception ex) {
		        JSONObject json = JSONFactoryUtil.createJSONObject();
		        json.put("error", "storeDefault Unsuccessful");
		        writeJSON(resourceRequest, resourceResponse, json);
		      }
		    }
		  }
		  
		  private static Log _log = LogFactoryUtil.getLog(ConfigurePortlet.class);
}
