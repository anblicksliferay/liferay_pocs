package com.mappingportlet.portlet;

import java.io.File;
import java.util.Date;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.MappingServices.model.UserExternal;
import com.MappingServices.service.UserExternalLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.ContentUtil;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Mapping",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UserPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=UserPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserPortlet extends MVCPortlet {
	public static void Email(String Firstname,String emailAddress, String password){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		File file = new File("E:\\text.pdf");
        String fileName = "text.pdf"; 
		String body = ContentUtil.get("/content/emailbody.tmpl", true);
		body = StringUtil.replace(body, new String[] { "[$NAME$]","[$EMAIL$]","[$PASS$]" }, new String[] { Firstname,emailAddress,password});
		try {
	    		fromAddress = new InternetAddress("kranthi.k1009@gmail.com");
	    		toAddress = new InternetAddress(emailAddress);
	    		MailMessage mailMessage = new MailMessage();
	    		mailMessage.setTo(toAddress);
	    		mailMessage.setFrom(fromAddress);
	    		mailMessage.setSubject("AshokLeyland_Creditals");
	    		mailMessage.setBody(body);
	    		mailMessage.addFileAttachment(file, fileName);
				mailMessage.setHTMLFormat(true);
	    		MailServiceUtil.sendEmail(mailMessage);
	    		System.out.println("Send mail with Plain Text");
		} catch (AddressException e) {
		    	e.printStackTrace();
		}
				
	}

	public void addUser(ActionRequest request,ActionResponse response) throws PortalException, SystemException {
		try {
			String FirstName = ParamUtil.getString(request,"fname");
			String LastName = ParamUtil.getString(request,"lname");
			String EmailId = ParamUtil.getString(request,"email");
			String Location = ParamUtil.getString(request,"loc");
			System.out.println(FirstName+"  "+LastName+"  "+EmailId+"  "+Location);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long creatorUserId = themeDisplay.getUserId(); 
			long companyId = themeDisplay.getCompanyId(); 
			boolean autoPassword = true;
			String password1 = "";
			String password2 = "";
			boolean autoScreenName = true;
			String screenName = "";
			String emailAddress = EmailId;
			long facebookId = 0;
			String openId = "";
			Locale locale = themeDisplay.getLocale();
			String firstName = FirstName;
			String middleName = "";
			String lastName = LastName;
			int prefixId = 0;
			int suffixId = 0;
			boolean male = true;    
			int birthdayMonth = Integer.parseInt("01");
			int birthdayDay = Integer.parseInt("01");
			int birthdayYear = Integer.parseInt("2000");
			String jobTitle = "";
			long[] groupIds = null;
			long[] organizationIds = null;
			long[] roleIds = null;
			long[] userGroupIds = null;
			boolean sendEmail = false;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			User user = UserLocalServiceUtil.addUser(creatorUserId,companyId,autoPassword,password1,password2,autoScreenName,screenName,emailAddress,facebookId,
			openId,locale,firstName,middleName,lastName,prefixId,suffixId,male,birthdayMonth,birthdayDay,birthdayYear,jobTitle,groupIds,organizationIds,roleIds,
		    userGroupIds,sendEmail,serviceContext);	
			UserExternal userext = UserExternalLocalServiceUtil.createUserExternal(user.getUserId());
			//userext.setLocation(Location);
			userext.setCreateDate(new Date());
			userext.setModifiedDate(new Date());
			UserExternalLocalServiceUtil.addUserExternal(userext);			
			user.setPassword("AAAAoAAB9ADl1uwMuVMMRw4qEyujmUJM1rA2DoqFADnM0uqV");			
			UserLocalServiceUtil.updateUser(user);
			Email(firstName,emailAddress,"test1");
			System.out.println("hello111");	
			response.setRenderParameter("mvcPath","/msg.jsp");
		} catch (Exception e) {
		}
	}
}