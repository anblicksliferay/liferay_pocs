package com.delphi.userprofile.portlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.delphi.subscriptions.model.RegionSiteServerList;
import com.delphi.subscriptions.service.MySubscriptionService;
import com.delphi.subscriptions.service.impl.MySubscriptionsImpl;
import com.delphi.userprofile.model.UserAccessRequest;
import com.delphi.userprofile.model.UserProfile;
import com.delphi.userprofile.notification.model.UserNotificationModel;
import com.delphi.userprofile.notification.utils.EMailSMSPushSender;
import com.delphi.userprofile.notification.utils.UserExternalNotificationUtils;
import com.delphi.userprofile.service.UserAccessRequestLocalServiceUtil;
import com.delphi.userprofile.service.UserProfileLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author wesk
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.header-portlet-css=/css/admin-main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Delphi User Profile Admin Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DelphiUserProfileAdminPortlet extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(DelphiUserProfileAdminPortlet.class);
	private MySubscriptionService subscriptionService = new MySubscriptionsImpl();
	private final static long MILLIS_PER_DAY = 24 * 3600 * 1000;
	private UserExternalNotificationUtils notificationUtils = new UserExternalNotificationUtils();
	private EMailSMSPushSender notificationSender = new EMailSMSPushSender();
	private static String SYSTEM_ALERT_SUBJECT = "Aptiv AI- System Alert Message";
	private static String DELPHI_EMI = "Aptiv AI- ";
	private static String SITE_ALERT_SUBJECT = " Site Alert Message";
	private static String ALERT_FOOTER = "You received this email because you have used the Aptiv Intelligence portal within the last 45 days.";
	private static String GAP_STRING = "<br /><br /><br />";


	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId(); 
		User user = themeDisplay.getUser();

		long userId = user.getUserId();
		
		_log.info(userId);
		int countUser = UserLocalServiceUtil.getUsersCount();
		RegionSiteServerList regionSiteServerList = null;
		List <User> usersList = UserLocalServiceUtil.getUsers(0, countUser);
		
		try {
			_log.info("in regionSiteServerList portlet doView");
			regionSiteServerList = subscriptionService.getRegionSiteServerList();
			
			renderRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());
			_log.info("in DelphiAdminUserProfie portlet doView");
			
			renderRequest.setAttribute("siteUsers", usersList);
			
			List <UserAccessRequest> userAccessRequests = UserAccessRequestLocalServiceUtil.findUserAccessRequestByActiveState(1);
			List <UserAccessRequest> availableAccessRequests = new ArrayList<UserAccessRequest>();
					
			boolean superAccess = checkForDelphiSuperAdminAccess(userId, companyId);
			
			for(UserAccessRequest userAccessRequest : userAccessRequests){
				//if(userAccessRequest.getPortletAccess()=="Delphi Super Admin") continue; 
				if(!superAccess && 
						( userAccessRequest.getPortletAccess().equalsIgnoreCase("Delphi Admin") ||
						  userAccessRequest.getPortletAccess().equalsIgnoreCase("Delphi Super Admin") )) continue; 
				availableAccessRequests.add(userAccessRequest);
			}
			
			renderRequest.setAttribute("userAccessRequest", availableAccessRequests);
			
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		
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
		_log.info("admin serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		long userId = user.getUserId();

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("msg", "update was successful");
		
		try{

			long companyId = themeDisplay.getCompanyId(); 
			
			if(cmd.equalsIgnoreCase("accessRequestResponseChoice")){
				processUserAccessRequest( companyId, userId, context, cmdType );
				json.put("msg", "accessRequest updated");
			}else if(cmd.equalsIgnoreCase("systemSiteMessage")){
				sendSystemSiteMessage( userId, context );
				json.put("msg", "system or site  message sent");
			}
			
		}catch(Exception e){
			_log.error("serverResource error seen");
			_log.error(e);
			
			JSONObject error = JSONFactoryUtil.createJSONObject();
			error.put("error", "update/list was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, error);
		}
		
		writeJSON(resourceRequest, resourceResponse, json);
	}

	private static void processUserAccessRequest(long companyId, long userId, String context, String cmdType )
			throws PortalException{

		JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
		
		//TODO: Process user group/role/permissions changes
		
		UserAccessRequest userAccessRequest = UserAccessRequestLocalServiceUtil.getUserAccessRequest( jsonRequestContext.getInt("accessRequestId") );

		userAccessRequest.setActiveState(0);
		userAccessRequest.setResponseComment(cmdType);
		userAccessRequest.setResponseUser(userId);
		userAccessRequest.setModifiedDate(new Date());

		UserAccessRequestLocalServiceUtil.updateUserAccessRequest(userAccessRequest);
		
		if(cmdType.equalsIgnoreCase("grant")){
			assignUserToUserGroup(companyId, userAccessRequest.getUserId(),userAccessRequest.getPortletAccess());
		}else if(cmdType.equalsIgnoreCase("deny") || cmdType.equalsIgnoreCase("clear")){
			removeUserFromUserGroup(companyId, userAccessRequest.getUserId(),userAccessRequest.getPortletAccess());
		}
	}

	private static void assignUserToUserGroup(long companyId, long userId, String userAccessRequestGroup)
			throws PortalException{

		UserGroup group = null;
		if(userAccessRequestGroup.equalsIgnoreCase("Delphi Super Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Super Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Delphi Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Revenue & Expense")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Viewer");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Enter Financial Data")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Admin");
		}

		UserGroupLocalServiceUtil.addUserUserGroup(userId, group.getUserGroupId() );
	}
	
	private static void removeUserFromUserGroup(long companyId, long userId, String userAccessRequestGroup)
			throws PortalException{

		UserGroup group = null;
		if(userAccessRequestGroup.equalsIgnoreCase("Delphi Super Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Super Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Delphi Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Revenue & Expense")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Viewer");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Enter Financial Data")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Admin");
		}

		UserGroupLocalServiceUtil.deleteUserUserGroup(userId, group.getUserGroupId() );
	}
	
	private static boolean checkForDelphiSuperAdminAccess(long userId, long companyId)
			throws PortalException{

		_log.info(	"RoleLocalServiceUtil.hasUserRole("+userId+
							", "+companyId+", 'Delphi Super Admin', true) returns: "+
							RoleLocalServiceUtil.hasUserRole(userId, companyId, "Delphi Super Admin", true));
		
		return RoleLocalServiceUtil.hasUserRole(userId, companyId, "Delphi Super Admin", true);
	}
	
	public void deleteProfile(ActionRequest actionRequest, ActionResponse actionResponse){
		long userId = Long.parseLong(actionRequest.getParameter("userid"));
		_log.info("deleteProfile Id passed is:" + userId);
		_log.info("inside delete");
		try {
			UserLocalServiceUtil.deleteUser(userId);
			//TODO Remove Subscriptions, User Access, etc.
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void renderUserProfile(ActionRequest actionRequest, ActionResponse actionResponse){
		long userId = Long.parseLong(actionRequest.getParameter("profileId"));
		_log.info("renderUserProfile Id passed is:" + userId);
	}
	
	private void sendSystemSiteMessage(long userId, String context) throws PortalException{
		JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
		boolean systemAlert = jsonRequestContext.getBoolean("systemalert");
		boolean siteAlert= jsonRequestContext.getBoolean("sitealert");
		String messageText= jsonRequestContext.getString("messagetext");
		String siteName= jsonRequestContext.getString("sitename");
		User userData=UserLocalServiceUtil.getUser(userId);
		String loginUserEmail=userData.getEmailAddress();
		String loginUserName=userData.getFirstName()+" "+userData.getLastName();
		String senderInfo="<br><br>Sent By: "+loginUserEmail+"<br>User Name: "+loginUserName;
		if(systemAlert){
			sendSystemNotification(messageText,senderInfo);
		}else if(siteAlert){
			sendSiteNotification(siteName, messageText,senderInfo);
		}
	}
	public void sendAlertMessage(ActionRequest actionRequest, ActionResponse actionResponse){
		boolean portalBanner= ParamUtil.getBoolean(actionRequest, "portalbanner");
		String messageText= ParamUtil.getString(actionRequest, "messagetext");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(portalBanner){
			String color = ParamUtil.getString(actionRequest, "colorValue");
			setBanner(messageText, color, themeDisplay);
		}
	}

	private void setBanner(String messageText, String color, ThemeDisplay themeDisplay){
		LayoutSet layoutSet = themeDisplay.getLayoutSet();
		
		messageText = messageText.replace("\n", "<br/>").replace("\r", "<br/>");
		
		boolean activeBanner = (messageText.trim().equals(""))?false:true;
		
		JSONObject json = JSONFactoryUtil.createJSONObject();

		json.put("showAlert", activeBanner);
		json.put("messageText", messageText);
		json.put("messageColor", color);
		
		String bannerTemplate = "bannerDisplay=["+json.toJSONString()+"]"
								+ "\njavascript="+
								"\nlfr-theme:regular:display-footer=false\nlfr-theme:regular:pages-icon=Custom Field\n"+
								"lfr-theme:regular:use-global-footer=false\nshowSiteName=true\n";
		
		layoutSet.setSettings(bannerTemplate);
		
		LayoutSetLocalServiceUtil.updateLayoutSet(layoutSet);
	}
	
	private void sendSystemNotification(String messageText,String senderInfo){

		if(messageText.trim().equals("")) return;
		try{
			// fetch list of all the users in the system 
			List<User> userList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for(User user: userList){
				// first check if that user logged in last 30 days
				Date date = user.getLastLoginDate();

				if(date == null){
					continue; 
				}
				Date now = new Date();
				long msDiff= now.getTime() - date.getTime();
				long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY));
				_log.info("daysDiff  " + user.getUserId() + " --> "+ daysDiff );

				if(daysDiff < 45){
					UserNotificationModel model = notificationUtils.isSendNotification(user.getUserId(), "System", null);
					_log.info("User logged in in last 45 days user  " + user.getUserId() + " printing model " );
					if(model.isSendEMail()){
						String emailMessage = messageText + senderInfo + GAP_STRING + ALERT_FOOTER ; 
						_log.info("Sending system mail to " + user.getUserId());
						notificationSender.sendEMail(user, emailMessage, SYSTEM_ALERT_SUBJECT);
					}
					if(model.isSendSMS()){
						_log.info("Sending system sms to " + user.getUserId());
						notificationSender.sendSMS(user, messageText);
					}
					if(model.isSendPush()){
						_log.info("Sending system push to " + user.getUserId());
						notificationSender.sendPush(user, messageText);
					}
				}
			}
		}
		catch(Exception ex){
			_log.error(ex);
		}
	}
	
	private void sendSiteNotification(String site, String messageText, String senderInfo){

		if(messageText.trim().equals("")) return;

		try{
			// fetch list of all the users in the system 
			List<User> userList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for(User user: userList){
				// first check if that user logged in last 30 days
				Date date = user.getLastLoginDate();
				if(date == null)
					continue; 
				Date now = new Date();
				long msDiff= now.getTime() - date.getTime();
				long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY));
				_log.info("daysDiff  " + user.getUserId() + " --> "+ daysDiff );

				if(daysDiff < 45){
					UserNotificationModel model = notificationUtils.isSendNotification(user.getUserId(), "Site", site);
					_log.info("User logged in in last 45 days user  " + user.getUserId() + " printing model " );
					if(model.isSendEMail()){
						_log.info("Sending site email to " + user.getUserId());
						String emailMessage = messageText + senderInfo + GAP_STRING +  ALERT_FOOTER ; 
						String emailSubject = DELPHI_EMI + site + SITE_ALERT_SUBJECT ;
						notificationSender.sendEMail(user, emailMessage, emailSubject);
					}
					if(model.isSendSMS()){
						_log.info("Sending site sms to " + user.getUserId());
						notificationSender.sendSMS(user, messageText);
					}
					if(model.isSendPush()){
						_log.info("Sending site push to " + user.getUserId());
						notificationSender.sendPush(user, messageText);
					}							
				}		
			}
		}
		catch(Exception ex){
			_log.error(ex);
		}

	}

	private static final String _PORTAL_IMPERSONATION_DEFAULT_URL =
		PropsUtil.get(PropsKeys.PORTAL_IMPERSONATION_DEFAULT_URL);
}