package com.leykart.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.leykart.constants.LeyKartPortletKeys;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.ContentUtil;

/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LeyKart Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LeyKartPortletKeys.LeyKart,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LeyKartPortlet extends MVCPortlet {
	 @Override
	    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException{
	        String cmd = ParamUtil.getString(resourceRequest, "cmd");
	        String Message = Email(cmd);
	        if(Message.equalsIgnoreCase("success")){
	        	JSONObject json = JSONFactoryUtil.createJSONObject();
	            json.put("path", "Success");
	            PrintWriter writer1 = resourceResponse.getWriter();
	            writer1.print(json);
	        }
	 }
	public static String Email(String emailAddress){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		String body = ContentUtil.get("/content/emailbody.tmpl", true);
		body = StringUtil.replace(body, new String[] { "[$NAME$]","[$EMAIL$]","[$PASS$]" }, new String[] { emailAddress});
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