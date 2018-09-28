package com.ys.delphi.notification.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.Portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.ys.delphi.notification.model.ChangeOverHistory;
import com.ys.delphi.notification.model.NotificationHistory;
import com.ys.delphi.notification.model.NotificationHistoryWithThreshold;
import com.ys.delphi.notification.model.NotificationList;
import com.ys.delphi.notification.model.NotificationQuery;
import com.ys.delphi.notification.model.RegionSiteServer;
import com.ys.delphi.notification.model.RegionSiteServerList;
import com.ys.delphi.notification.model.YieldHistory;
import com.ys.delphi.notification.service.NotificationService;
import com.ys.delphi.notification.service.UserDefaultsService;
import com.ys.delphi.notification.service.YieldAlarmService;
import com.ys.delphi.notification.service.impl.NotificationServiceImpl;
import com.ys.delphi.notification.service.impl.UserDefaultsServiceImpl;
import com.ys.delphi.notification.service.impl.YieldAlarmServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.joda.time.DateTime;

/**
 * Portlet implementation class MyNotificationPortlet
 */


import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"javax.portlet.display-name=Delphi-MyNotifications-Portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/mynotification/view.jsp",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyNotificationPortlet extends MVCPortlet {
	private NotificationService notificationService = new NotificationServiceImpl();
	private static Log _log = LogFactoryUtil.getLog(MyNotificationPortlet.class);
	private static String CHANGEOVER_ALERT="CHANGEOVER ALERT";
	private static String DOWNTIME_ALERT="DOWNTIME ALERT";
	private static String YIELD_ALERT="YIELD ALERT";
	private static String PAGEID = "DelphiMyNotification" ; 
	private UserDefaultsService userDefaultService = new UserDefaultsServiceImpl() ;

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		RegionSiteServerList regionSiteServerList = null;
		
		try {			
			regionSiteServerList = notificationService.getRegionSiteServerList();
			renderRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}	
		setUserDefault(renderRequest);
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher(getInitParameter("view-template"));		
		prd.include(renderRequest, renderResponse);
	}
	
	
	private void setUserDefault(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long userId = user.getUserId();

		Map<String, String> model = userDefaultService.fetchUserDefaults(userId,PAGEID);
		renderRequest.setAttribute("userDefaultModel", model);	
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		
		_log.debug("My Notifications -- in the serverresource");
		
		try{
			if(cmdType.equalsIgnoreCase("storeDefault")){
				ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				User user = themeDisplay.getUser();
				//String userName = user.getFullName();
				long userId = user.getUserId();
				try{
					JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
					String id = jsonRequestContext.getString("fieldid");
					String value = jsonRequestContext.getString("fieldvalue");
					userDefaultService.updateDefaults(userId, PAGEID, id, value);
					JSONObject returnObject = JSONFactoryUtil.createJSONObject();
					returnObject.put("data", "storeDefault request completed sucessfully" );
					writeJSON(resourceRequest, resourceResponse, returnObject);
				}
				catch(Exception ex){
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("error", "storeDefault Unsuccessful");
					writeJSON(resourceRequest, resourceResponse, json);
				}
			}
			else if(cmd.equalsIgnoreCase("list")){
				
				User user = PortalUtil.getUser(resourceRequest);
				NotificationQuery notificationQuery = createNotificationQuery(user.getUserId(), context);
				String regionName = notificationQuery.getRegionSiteServer().getRegionName();
				if ( regionName == null )
					regionName = "All";
				
				String siteName = notificationQuery.getRegionSiteServer().getSiteName();
				String serverName = notificationQuery.getRegionSiteServer().getServerName();
				userDefaultService.updateDefaults(user.getUserId(), PAGEID, "region", regionName);
				userDefaultService.updateDefaults(user.getUserId(), PAGEID, "site", siteName);
				userDefaultService.updateDefaults(user.getUserId(), PAGEID, "server", serverName);

				NotificationList notificationList = notificationService.getNotifications( notificationQuery);			
				writeJSON(resourceRequest, resourceResponse,notificationList.toJSON());			
			
			} else if(cmd.equalsIgnoreCase("history")){
				
				JSONObject json = JSONFactoryUtil.createJSONObject(context);	
				String server = json.getString("serverName");
				String station = json.getString("station");
				String process = json.getString("process");
				String partNumber = json.getString("partNumber");
				String alertType = json.getString("alertType");

				_log.debug("history json");
				_log.debug(json);
				
				if(alertType.equalsIgnoreCase(YIELD_ALERT)){
					String subscriptionIdStr = json.getString("alarmId");
					long subscriptionId = Long.parseLong(subscriptionIdStr);
					String deviation = json.getString("deviation");
					deviation = deviation.substring(0, deviation.length()-1);
					double value = Double.valueOf(deviation);
					String startTimeUTC = json.getString("startTimeUTC");
					YieldAlarmService yieldService = new YieldAlarmServiceImpl();
					YieldHistory history = yieldService.getYieldHistory(subscriptionId, value,startTimeUTC);
					json.put("detail", history.toJSON());					
					writeJSON(resourceRequest, resourceResponse,json);
					
				} else if(alertType.equalsIgnoreCase(CHANGEOVER_ALERT)){
					
					String startTimeUTC = json.getString("startTimeUTC");
					_log.debug("startTimeUTC : "+startTimeUTC);
					ChangeOverHistory changeOverHistory = notificationService.getChangeOverHistory(server, station, process,startTimeUTC );
					json = JSONFactoryUtil.createJSONObject();
					json.put("detail", changeOverHistory.toJSON());

					addProductTypeProductFamily(server, station, process, partNumber,json);
					writeJSON(resourceRequest, resourceResponse,json);
					
				} else if(alertType.equalsIgnoreCase(DOWNTIME_ALERT)){
					
					String alarmId = json.getString("alarmId");
					String startTimeUTC = json.getString("startTimeUTC");
					_log.debug("alarmId : "+alarmId);
					_log.debug("startTimeUTC : "+startTimeUTC);
					json = JSONFactoryUtil.createJSONObject();

					try {
						String downTimeDuration = notificationService.getInactiveDownTimeDuration(alarmId, startTimeUTC);
						json.put("detail", downTimeDuration);
					}
					catch(Exception ex) {
					}
					addProductTypeProductFamily(server, station, process, partNumber,json);
					writeJSON(resourceRequest, resourceResponse,json);
					
				} else {

					int duration = json.getInt("duration");
					
					List<NotificationHistoryWithThreshold> notificationHistories =  notificationService.getNotificationHistoryWithThreshold(server, station, process, partNumber, duration);
					JSONObject jsonObj = notificationListWithThresholdJSON(notificationHistories,duration) ; 
					addProductTypeProductFamily(server, station, process, partNumber,jsonObj);
					writeJSON(resourceRequest, resourceResponse,jsonObj);
				}
			}
		
		}catch(Exception e){
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("error", "update/list was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}
	
	private void addProductTypeProductFamily(String server, String station, String process, String partNumber, JSONObject json) {
		try {
			String[] productTypeFamily = notificationService.getProductTypeProductFamiliy(server, station, process, partNumber);
			json.put("productType", productTypeFamily[0] );
			json.put("productFamily", productTypeFamily[1]);
		}
		catch(Exception ex) {
		}
	}
	
	private JSONObject notificationListJSON(List<NotificationHistory> notificationHistories){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray s = JSONFactoryUtil.createJSONArray();
		for(NotificationHistory n : notificationHistories){
			s.put(n.toJSON());
		}
		json.put("detail", s);
		return json;
	}
	
	private JSONObject notificationListWithThresholdJSON(List<NotificationHistoryWithThreshold> notificationHistories,int duration){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray s = JSONFactoryUtil.createJSONArray();
		for(NotificationHistoryWithThreshold n : notificationHistories){
			s.put(n.toJSON());
		}
		json.put("detail", s);
		json.put("hours", duration);
		json.put("productType", "TestProductTypeCT");
		json.put("productFamily", "TestProductFamilyCT");

		return json;
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
			
			int numOfDays = json.getInt("numOfDays");
			DateTime endDate = DateTime.now();
			DateTime startDate = null;
			if(numOfDays < 0){
				endDate = null;
				startDate =null;
			}else{
				startDate = endDate.minusDays(numOfDays);
			}
			
			notificationQuery = new NotificationQuery(userId, startDate, endDate, regionSiteServer,numOfDays);
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}
		return notificationQuery;

	}
}