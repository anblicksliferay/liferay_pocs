package com.al.servicemandi.contact.portlet;

import java.io.IOException;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.al.servicemandi.util.ContactUtil;
import com.liferay.petra.content.ContentUtil;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;

/**
 * @author Ashok Leyland
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.servicemandi",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Contact Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ServicemandiContactPortlet extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(ServicemandiContactPortlet.class);

	public void contactUs(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		 try{
		      CaptchaUtil.check(actionRequest);
		      }catch(Exception e){
		            if (e instanceof CaptchaTextException || e instanceof CaptchaMaxChallengesException ){
		            	SessionMessages.add(actionRequest,
		    					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		                  SessionErrors.add(actionRequest, e.getClass(), e);
		                  return;
		                 
		            }else{
		                 logger.info("Captcha verification success::");
		            }
		           
		      }
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long logoId = 0;
		String layoutSetLogo = StringPool.BLANK;
		String portalURL = PortalUtil.getPortalURL(actionRequest);
		
		LayoutSet siblingLayoutSet = null;
		try {
			siblingLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
					themeDisplay.getScopeGroupId(), false);
			
			if (siblingLayoutSet.isLogo()) {
				logoId = siblingLayoutSet.getLogoId();
				}
				
				StringBundler sb = new StringBundler(5);
				String imagePath=PortalUtil.getPathImage();
				sb.append(portalURL);
				sb.append(imagePath);
				sb.append("/layout_set_logo?img_id=");
				sb.append(logoId);
				sb.append("&t=");
				sb.append(WebServerServletTokenUtil.getToken(logoId));
				
				layoutSetLogo = sb.toString();
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		
		String name = ParamUtil.getString(actionRequest, "name", StringPool.BLANK);
		String number = ParamUtil.get(actionRequest, "contact", "0");
		String email = ParamUtil.getString(actionRequest, "email", StringPool.BLANK);
		
		String emailIcon = themeDisplay.getPathThemeImages()+"/email-icon.png";
		String phoneIcon = themeDisplay.getPathThemeImages()+"/phone-icon.png";
		
		String contactUsBody = ContentUtil.get(ServicemandiContactPortlet.class.getClassLoader(), "/template/contact_us_mail4.tmpl", true);
		String thanksBody = ContentUtil.get(ServicemandiContactPortlet.class.getClassLoader(), "/template/thanks_mail4.tmpl", true);

		
		contactUsBody = StringUtil.replace(contactUsBody, new String[] { "[$PORTAL_URL$]","[$LOGO$]","[$NAME$]","[$MOBILE$]","[$EMAIL$]","[$EMAIL_ICON$]","[$PHONE_ICON$]" }, new String[] {portalURL, layoutSetLogo ,name, number ,email,emailIcon,phoneIcon});
		thanksBody = StringUtil.replace(thanksBody, new String[] { "[$PORTAL_URL$]","[$LOGO$]","[$NAME$]","[$EMAIL_ICON$]","[$PHONE_ICON$]"}, new String[] { portalURL, layoutSetLogo ,name,emailIcon,phoneIcon});
		
		actionRequest.setAttribute("mailSuccess", false);
		try {
			logger.info("Sending Mail...");
			ContactUtil.sendEmail(email, contactUsBody, thanksBody);
			logger.info("Mail has been sent");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
			actionRequest.setAttribute("mailSuccess", true);			
			/*String mailSentUrl = portalURL + "/web" + themeDisplay.getScopeGroup().getFriendlyURL()+"/mail-sent?mailSent=true";
			actionResponse.sendRedirect(mailSentUrl);*/
		} catch (AddressException e) {
			logger.error(e.getMessage());
			
			 actionRequest.setAttribute("mailSuccess", false);
		} /*catch (IOException e) {
			logger.error(e.getMessage());
			
			 SessionErrors.add(actionRequest, "error");
		}*/

	}
	

    @Override
    public void serveResource(ResourceRequest resourceRequest,
                ResourceResponse resourceResponse)
          throws  IOException, PortletException {

          try {
                CaptchaUtil.serveImage(resourceRequest, resourceResponse);
          }
          catch (Exception e) {
                logger.error(e);
          }
    }

/*	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		boolean mail = ParamUtil.get(httpRequest, "mailSent", false);
		if (mail) {
			include("/success.jsp", renderRequest, renderResponse);
		} else {
			include("/view.jsp", renderRequest, renderResponse);
		}
	}*/

}
