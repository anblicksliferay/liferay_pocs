package com.leykart.portlet;

import com.leykart.constants.LeyKartPortletKeys;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.ContentUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=enquiry Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/enquiry.jsp",
		"javax.portlet.name=enquiry portlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class enquiry extends MVCPortlet {
	public void EnquiryForm(ActionRequest request,ActionResponse response){
		String firstName =request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String mail =request.getParameter("mail");
		Email(firstName,mail);
		
	}
	public static String Email(String firstname,String emailAddress){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		String body = ContentUtil.get("/content/emailbody.tmpl", true);
		body = StringUtil.replace(body, new String[] { "[$NAME$]","[$EMAIL$]","[$PASS$]" }, new String[] { firstname,emailAddress,""});
		try {
	    		fromAddress = new InternetAddress("kranthi.k1009@gmail.com");
	    		toAddress = new InternetAddress(emailAddress);
	    		MailMessage mailMessage = new MailMessage();
	    		mailMessage.setTo(toAddress);
	    		mailMessage.setFrom(fromAddress);
	    		mailMessage.setSubject("Thanks For Subscribtion");
	    		mailMessage.setBody(body);
				mailMessage.setHTMLFormat(true);
	    		MailServiceUtil.sendEmail(mailMessage);
	    		System.out.println("Send mail with Plain Text");
		} catch (AddressException e) {
		    	e.printStackTrace();
		}
		return "Success";
				
	}
}