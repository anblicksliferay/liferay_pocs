package com.al.servicemandi.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

public class ContactUtil {
public static void sendEmail(String email, String contactUsBody, String thanksBody) throws AddressException{
		MailMessage thanksMailMessage = new MailMessage();
		String fromEmail = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		
		thanksMailMessage.setHTMLFormat(true);
		thanksMailMessage.setFrom(new InternetAddress(fromEmail));
		thanksMailMessage.setTo(new InternetAddress(email));
		thanksMailMessage.setSubject("ServiceMandi Contact");
		thanksMailMessage.setBody(thanksBody);
		MailServiceUtil.sendEmail(thanksMailMessage);
		
		MailMessage contactRequestMailMessage = new MailMessage();
		
		contactRequestMailMessage.setHTMLFormat(true);
		contactRequestMailMessage.setFrom(new InternetAddress(fromEmail));
		contactRequestMailMessage.setTo(new InternetAddress(fromEmail));
		contactRequestMailMessage.setSubject("Contact Request");
		contactRequestMailMessage.setBody(contactUsBody);
		MailServiceUtil.sendEmail(contactRequestMailMessage);

}
}
