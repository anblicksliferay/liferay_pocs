package com.delphi.userprofile.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.delphi.userprofile.exception.NoSuchUserProfileException;
import com.delphi.userprofile.model.UserProfile;
import com.delphi.userprofile.service.UserProfileLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author wesk
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Delphi User Profile Theme Helper",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/themehelper/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DelphiUserProfileThemeHelper extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(DelphiUserProfileThemeHelper.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = themeDisplay.getUser();
		long userId = user.getUserId();
		long trueUserId = themeDisplay.getRealUserId(); 
		
		_log.debug("DelphiUserProfileThemeHelper:"+userId+" trueUserId:"+trueUserId);
		
		UserProfile userProfile = null;
	      
		try {
			userProfile = loadProfile(userId, trueUserId);
			
			renderRequest.setAttribute("userProfilePortlets", userProfile.getPortlets());

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
	
		_log.debug("DelphiUserProfileThemeHelper Banner Check");

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LayoutSet layoutSet = themeDisplay.getLayoutSet();
		
		String settings = layoutSet.getSettings();
		String bannerJSON = settings.substring(settings.indexOf("[")+1,settings.indexOf("]"));
		
		writeJSON(resourceRequest, resourceResponse, bannerJSON);
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
}