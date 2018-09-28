package com.ys.delphi.notification.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.ys.delphi.notification.model.NotificationList;
import com.ys.delphi.notification.model.NotificationQuery;
import com.ys.delphi.notification.model.RegionSiteServer;
import com.ys.delphi.notification.service.NotificationService;
import com.ys.delphi.notification.service.impl.NotificationServiceImpl;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"model.class.name=com.ys.delphi.notification.portlet.MyMiniNotificationPortlet",
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/css/mini-main.css", 
		"javax.portlet.display-name=Delphi-MyMiniNotifications-Portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/mynotification/mini.jsp",
		"com.liferay.portlet.header-portlet-javascript=/js/mini-main.js",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyMiniNotificationPortlet extends MVCPortlet {
	
	private NotificationService notificationService = new NotificationServiceImpl();
	private static Log _log = LogFactoryUtil.getLog(MyMiniNotificationPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
			
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher(getInitParameter("view-template"));		
		prd.include(renderRequest, renderResponse);
	}
 
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {		
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		_log.debug("serveResource for mini command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		try{
			if(cmd.equalsIgnoreCase("count")){
				User user = PortalUtil.getUser(resourceRequest);
				NotificationQuery notificationQuery = createNotificationQuery(user.getUserId(), context);	
				JSONObject jsonNotificationCount = notificationService.getActiveNotificationCount(notificationQuery);

				writeJSON(resourceRequest, resourceResponse, jsonNotificationCount);			
			}else if(cmd.equalsIgnoreCase("list")){
				User user = PortalUtil.getUser(resourceRequest);
				NotificationQuery notificationQuery = createNotificationQuery(user.getUserId(), context);		
				NotificationList notificationList = notificationService.getActiveNotificationsForLast3Days(notificationQuery);			
					writeJSON(resourceRequest, resourceResponse,notificationList.toJSON());	
			}
		}catch(Exception e){
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("error", "get user notification list failed");
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}

	private NotificationQuery createNotificationQuery(long userId, String context) {
		NotificationQuery notificationQuery = null;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			String regionName = json.getString("regionName");
			String siteName = json.getString("siteName");
			String serverName = json.getString("serverName");
			
			RegionSiteServer regionSiteServer = new RegionSiteServer();
			regionSiteServer.setRegionName(regionName.trim().equalsIgnoreCase("All")? StringPool.BLANK:regionName.trim());
			regionSiteServer.setSiteName(siteName.trim().equalsIgnoreCase("All")? StringPool.BLANK:siteName.trim());
			regionSiteServer.setServerName(serverName.trim().equalsIgnoreCase("All")? StringPool.BLANK:serverName.trim());
			
			notificationQuery = new NotificationQuery(userId, null, null, regionSiteServer,0);
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}
		return notificationQuery;

	}
	

}
