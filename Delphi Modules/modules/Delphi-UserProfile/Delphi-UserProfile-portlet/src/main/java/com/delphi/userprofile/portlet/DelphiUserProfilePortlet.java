package com.delphi.userprofile.portlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

//import com.aptiv.commonservices.service.AreaCellService;
//import com.aptiv.commonservices.service.impl.AreaCellServiceImpl;
import com.delphi.subscriptions.model.RegionSiteServerList;
import com.delphi.subscriptions.service.MySubscriptionService;
import com.delphi.subscriptions.service.impl.MySubscriptionsImpl;
import com.delphi.userprofile.exception.NoSuchUserAccessRequestException;
import com.delphi.userprofile.exception.NoSuchUserProfileException;
import com.delphi.userprofile.model.UserAccessRequest;
import com.delphi.userprofile.model.UserProfile;
import com.delphi.userprofile.service.UserAccessRequestLocalServiceUtil;
import com.delphi.userprofile.service.UserProfileLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
/**
 * @author wesk
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.header-portlet-javascript=/js/main.js", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Delphi User Profile Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/user/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DelphiUserProfilePortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(DelphiUserProfilePortlet.class);
	private MySubscriptionService subscriptionService = new MySubscriptionsImpl();
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();
		long userId = user.getUserId();
		long trueUserId = themeDisplay.getRealUserId(); 
		long companyId = themeDisplay.getCompanyId(); 
		
		_log.info("userId:"+userId+" trueUserId:"+trueUserId);
		
		UserProfile userProfile = null;
		RegionSiteServerList regionSiteServerList = null;
	      
		try {
			_log.info("in regionSiteServerList portlet doView");
			regionSiteServerList = subscriptionService.getRegionSiteServerList();
			renderRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());
			_log.info("in DelphiUserProfie portlet doView");
			
			userProfile = loadProfile(userId, trueUserId);
			renderRequest.setAttribute("userProfile", userProfile);
			
			List <UserAccessRequest> userAccessRequests = UserAccessRequestLocalServiceUtil.findUserAccessRequestsByUserId(userId);
			String jsonRequestHistory = gatherRequestHistory(userAccessRequests);
			renderRequest.setAttribute("requestStatuses", jsonRequestHistory);

			Set<Locale> locales = LanguageUtil.getAvailableLocales();
			renderRequest.setAttribute("locales", locales);
			
			renderRequest.setAttribute("userIsDelphiSuperAdmin", checkForUserRole( trueUserId, companyId, "Delphi Super Admin") );
			
			
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
		_log.info("serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();

		long userId = user.getUserId();
		long trueUserId = themeDisplay.getRealUserId(); 
		long companyId = themeDisplay.getCompanyId(); 

		UserProfile userProfile = null;

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("msg", "update was successful");
		
		try{
			userProfile = loadProfile(userId, trueUserId);
			
			if(cmd.equalsIgnoreCase("phone")){
				processPhoneUpdate(resourceRequest, resourceResponse, 
									user, cmd, context );
			} else if(cmd.equalsIgnoreCase("contact-info")){
				userProfile.setCommunicationPreferences(context);
				UserProfileLocalServiceUtil.updateUserProfile(userProfile);
			} else if(cmd.equalsIgnoreCase("location")){
				userProfile = setLocationValues(userProfile, context);
				
				_log.info("-User Info Change " + userProfile.getLanguage() +" : "+user.getLanguageId());
				
				if(!userProfile.getTimezone().equalsIgnoreCase(user.getTimeZoneId())){
					_log.info("--Timezone Change");
					user.setTimeZoneId(userProfile.getLanguage());
					//UserLocalServiceUtil.updateUser(user);
				}
				
				if(!userProfile.getLanguage().equalsIgnoreCase(user.getLanguageId())){
					_log.info("--Language Change");
					user.setLanguageId(userProfile.getLanguage());
					//UserLocalServiceUtil.updateUser(user);
					json.put("msg", "user language changed|"+userProfile.getLanguage());
				}

				JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
				userProfile.setLanguage(jsonRequestContext.getString("language"));
				UserProfileLocalServiceUtil.updateUserProfile(userProfile);
				UserLocalServiceUtil.updateUser(user);
				
			} else if(cmd.equalsIgnoreCase("workhours")){
				userProfile.setWorkHours(context);
				UserProfileLocalServiceUtil.updateUserProfile(userProfile);
			} else if(cmd.equalsIgnoreCase("jobrole")){
				userProfile.setJobrole(context);
				UserProfileLocalServiceUtil.updateUserProfile(userProfile);
			} else if(cmd.equalsIgnoreCase("activities")){
				userProfile.setInterests(context);
				UserProfileLocalServiceUtil.updateUserProfile(userProfile);
			} else if(cmd.equalsIgnoreCase("portlets")){
				userProfile.setPortlets(context);
				UserProfileLocalServiceUtil.updateUserProfile(userProfile);
			} else if(cmd.equalsIgnoreCase("accessRequest")){

				JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
				json.put("accessRequestSection", jsonRequestContext.getString("requestSection"));
				json.put("requestAccessName", jsonRequestContext.getString("requestAccessName"));
				
				addUserAccessRequest(userId, trueUserId, context, "", 1);
				
				json.put("msg", "accessRequest returned");
				
			} else if(cmd.equalsIgnoreCase("adminAccessCommand")){
				
				JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
				json.put("accessRequestSection", jsonRequestContext.getString("requestSection"));
				json.put("requestAccessName", jsonRequestContext.getString("requestAccessName"));
				json.put("requestAccessValue", jsonRequestContext.getString("requestAccessValue"));
				
				if(	checkForUserRole( trueUserId, companyId, "Delphi Super Admin") ||
					checkForUserRole( trueUserId, companyId, "Delphi Admin") ){

					addUserAccessRequest( userId, trueUserId, context, 
							jsonRequestContext.getString("requestAccessValue").toLowerCase(), 0 );
					
					completeAdminAccessCommand( userId, companyId, context );
					
					json.put("msg", "Admin accessRequest returned");
					
				} else {
					json.put("msg", "Admin accessRequest denied. You do not have access to make this change");
				}
				
			}
			
		}catch(Exception e){
			System.out.println("update/list error");
			System.out.println(e);
			JSONObject error = JSONFactoryUtil.createJSONObject();
			error.put("error", "update/list was unsuccessful");
			writeJSON(resourceRequest, resourceResponse, error);
		}
		
		writeJSON(resourceRequest, resourceResponse, json);
	}
	
	private void completeAdminAccessCommand(long userId, long companyId, String context)
			throws PortalException{

		JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);

		String requestAccessName = jsonRequestContext.getString("requestAccessName");
		String requestAccessValue = jsonRequestContext.getString("requestAccessValue");
		
		_log.info("completeAdminAccessCommand with requestAccessValue:" + requestAccessValue + " requestAccessName:"+requestAccessName);
		
		if(requestAccessValue.equalsIgnoreCase("Grant")){
			assignUserToUserGroup(companyId, userId, requestAccessName);
		}else if(requestAccessValue.equalsIgnoreCase("Deny")){
			deleteUserToUserGroup(companyId, userId, requestAccessName);
		}
	}

	private static void assignUserToUserGroup(long companyId, long userId, String userAccessRequestGroup)
			throws PortalException{
		
		_log.info("assignUserToUserGroup:"+userAccessRequestGroup);
		
		UserGroup group = null;
		if(userAccessRequestGroup.equalsIgnoreCase("Delphi Super Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Super Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Delphi Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Revenue & Expense")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Viewer");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Enter Financial Data")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Admin");
		}else{
			return;
		}

		UserGroupLocalServiceUtil.addUserUserGroup(userId, group.getUserGroupId() );
	}
	
	private static void deleteUserToUserGroup(long companyId, long userId, String userAccessRequestGroup)
			throws PortalException{

		_log.info("deleteUserToUserGroup:"+userAccessRequestGroup);
		
		UserGroup group = null;
		if(userAccessRequestGroup.equalsIgnoreCase("Delphi Super Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Super Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Delphi Admin")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Delphi Admin");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Revenue & Expense")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Viewer");
		}else if(userAccessRequestGroup.equalsIgnoreCase("Enter Financial Data")){
			group = UserGroupLocalServiceUtil.getUserGroup(companyId,"Financial Admin");
		}else{
			return;
		}

		UserGroupLocalServiceUtil.deleteUserUserGroup( userId, group.getUserGroupId() );
	}

	private UserProfile loadProfile(long userId, long trueUserId)
			throws NoSuchUserProfileException, SystemException{
		
		UserProfile userProfile = null;
		
		try{
			userProfile = UserProfileLocalServiceUtil.findUserProfileByUserId(userId);
		} catch(NoSuchUserProfileException noSuchUserProfile){
			userProfile = UserProfileLocalServiceUtil.createNewUserProfile(userId, trueUserId);
		} catch(Exception ex){
			_log.error(ex);
		}
		return userProfile;
	}

	private UserAccessRequest addUserAccessRequest(long userId, long trueUserId,
			String context, String responseComment, int activeState)
			throws NoSuchUserAccessRequestException, SystemException, JSONException{

		JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
		UserAccessRequest userAccessRequest = null;
		
		userAccessRequest = UserAccessRequestLocalServiceUtil.createNewUserAccessRequest(userId, trueUserId);

		userAccessRequest.setPortletAccess(jsonRequestContext.getString("requestAccessName"));
		userAccessRequest.setRequestType(jsonRequestContext.getString("requestSection"));
		userAccessRequest.setResponseType("");
		userAccessRequest.setResponseComment(responseComment);

		userAccessRequest.setActiveState(activeState);
		
		UserAccessRequestLocalServiceUtil.updateUserAccessRequest(userAccessRequest);
		
		return userAccessRequest;
	}
	
	private UserProfile setLocationValues(UserProfile userProfile, String context)
			throws JSONException{

		JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);

		String selectedSite = jsonRequestContext.getString("site");
		String selectedLanguage = jsonRequestContext.getString("language");
		String selectedTimezone = jsonRequestContext.getString("timeZone");
		String resultingLanguage = "en_US";
		String resultingTimezone = "UTC";
		
		if(selectedLanguage.equals("")){
			
			if(selectedSite.equals("Braga")){
				// Braga [Spanish] (WEST UTC +01:00)
				resultingLanguage = "es_ES";
			} else if(selectedSite.equals("Chennai")){
				// Chennai [English] (IST UTC +05:30)
				resultingLanguage = "en_US";
			} else if(selectedSite.equals("Gdansk")){
				//Gdansk [English] (CEST UTC +02:00)
				resultingLanguage = "en_US";
			} else if(selectedSite.equals("Jambeiro")){
				//Jambeiro [Spanish] (BRT UTC -03:00)
				resultingLanguage = "es_ES";
			} else if(selectedSite.equals("Kokomo")){
				//[English] (EST UTC -05:00)
				resultingLanguage = "en_US";
			} else if(selectedSite.equals("Macedonia")){
				//[English] (CEST UTC +02:00)
				resultingLanguage = "en_US";
			} else if(selectedSite.equals("Matamoros")){
				//[Spanish] (CDT UTC -05:00)
				resultingLanguage = "es_ES";
			} else if(selectedSite.equals("Oberghausen")){
				//[German] (CEST UTC +02:00)
				resultingLanguage = "de_DE";
			} else if(selectedSite.equals("Reynosa")){
				//[Spanish] (CDT UTC -0500)
				resultingLanguage = "es_ES";
			} else if(selectedSite.equals("Singapore")){
				//[Chinese] (SGT TC +08:00)
				resultingLanguage = "zh_CN";
			} else if(selectedSite.equals("St. Aubin")){
				//[English] (CEST UTC +02:00)
				resultingLanguage = "en_US";
			} else if(selectedSite.equals("Suzhou")){
				//Suzhou [Chinese] (CST UTC +08:00)
				resultingLanguage = "zh_CN";
			} else if(selectedSite.equals("Szombathley")){
				//Szombathley [Hungarian] (CEST UTC +02:00)
				resultingLanguage = "hu_HU";
			}
			
		} else {
			resultingLanguage = selectedLanguage;
		}

		if(selectedTimezone.equals("")){
			
			if(selectedSite.equals("Braga")){
				// Braga [Spanish] (WEST UTC +01:00)
				resultingTimezone = "Europe/Lisbon";
			} else if(selectedSite.equals("Chennai")){
				// Chennai [English] (IST UTC +05:30)
				resultingTimezone = "Asia/Calcutta";
			} else if(selectedSite.equals("Gdansk")){
				//Gdansk [English] (CEST UTC +02:00)
				resultingTimezone = "Europe/Paris";
			} else if(selectedSite.equals("Jambeiro")){
				//Jambeiro [Spanish] (BRT UTC -03:00)
				resultingTimezone = "America/Sao_Paulo";
			} else if(selectedSite.equals("Kokomo")){
				//[English] (EST UTC -05:00)
				resultingTimezone = "America/Chicago";
			} else if(selectedSite.equals("Macedonia")){
				//[English] (CEST UTC +02:00)
				resultingTimezone = "Europe/Paris";
			} else if(selectedSite.equals("Matamoros")){
				//[Spanish] (CDT UTC -05:00)
				resultingTimezone = "America/Chicago";
			} else if(selectedSite.equals("Oberghausen")){
				//[German] (CEST UTC +02:00)
				resultingTimezone = "Europe/Paris";
			} else if(selectedSite.equals("Reynosa")){
				//[Spanish] (CDT UTC -0500)
				resultingTimezone = "America/Chicago";
			} else if(selectedSite.equals("Singapore")){
				//[Chinese] (SGT TC +08:00)
				resultingTimezone = "Asia/Shanghai";
			} else if(selectedSite.equals("St. Aubin")){
				//[English] (CEST UTC +02:00)
				resultingTimezone = "Europe/Paris";
			} else if(selectedSite.equals("Suzhou")){
				//Suzhou [Chinese] (CST UTC +08:00)
				resultingTimezone = "Asia/Shanghai";
			} else if(selectedSite.equals("Szombathley")){
				//Szombathley [Hungarian] (CEST UTC +02:00)
				resultingTimezone = "Europe/Paris";
			}
			
		} else {
			resultingTimezone = selectedTimezone;
		}
		
		_log.info("Storing language as: "+resultingLanguage);
		_log.info("Storing timeZone as: "+resultingTimezone);
		
		userProfile.setRegion(jsonRequestContext.getString("region"));
		userProfile.setSite(jsonRequestContext.getString("site"));
		userProfile.setDivision(jsonRequestContext.getString("division"));
		userProfile.setTimezone(resultingTimezone);
		userProfile.setLanguage(resultingLanguage);
		
		return userProfile;
	}
	
	
	private String gatherRequestHistory(List<UserAccessRequest> userAccessRequests) throws IOException{
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		for(UserAccessRequest userAccessRequest:userAccessRequests){
			json.put(userAccessRequest.getRequestType()+"-"+userAccessRequest.getPortletAccess(), userAccessRequest.getResponseComment());
		}
		
		return json.toJSONString();
	}
			
	private void processPhoneUpdate(ResourceRequest resourceRequest,  ResourceResponse resourceResponse,
			User user, String cmd, String context) throws IOException{

		try{
			JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
			String phoneNumber = jsonRequestContext.getString("phoneNumber");
			
			List<Phone> phones = user.getPhones();
			boolean primaryExists = false;
			
			_log.info("Received phoneNumber of:"+phoneNumber);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			
			for(Phone phone:phones){
				if(phone.isPrimary()){
					primaryExists = true;
					phone.setNumber(phoneNumber);
					_log.info("Setting phoneNumber based on found Phone of:"+phoneNumber);
					PhoneLocalServiceUtil.updatePhone(phone);
					break;
				}
			}
			
			if(!primaryExists){
				PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), phoneNumber, "", 11008, true, new ServiceContext());
			}
			
			json = JSONFactoryUtil.createJSONObject();
			json.put("success", "message returned");
			json.put("phoneNumber", phoneNumber);

			writeJSON(resourceRequest, resourceResponse, json);
			
		} catch(Exception e) {
			JSONObject jsonError = JSONFactoryUtil.createJSONObject();
			jsonError.put("error", "Update Phone was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, jsonError);
		}
		
	}
	
	private static boolean checkForUserRole(long trueUserId, long companyId, String roleName)
			throws PortalException{

		_log.info(	"RoleLocalServiceUtil.hasUserRole("+trueUserId+
							", "+companyId+", 'Delphi Super Admin', true) returns: "+
							RoleLocalServiceUtil.hasUserRole(trueUserId, companyId, roleName, true));
		
		return RoleLocalServiceUtil.hasUserRole(trueUserId, companyId, roleName, true);
	}	

}