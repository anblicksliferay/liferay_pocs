package com.delphi.userprofile.notification.utils;

import java.util.List;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.push.notifications.service.PushNotificationsDeviceServiceUtil;

public class EMailSMSPushSender {
	
	private static Log _log = LogFactoryUtil.getLog(EMailSMSPushSender.class);
	private static String USERNAME="SanchezLI3";
	private static String PASSWORD ="dfgFEaIefBIBeW";
	private static String APIID="3604333";	
	private static String FROM="14156369196";	
	private static String fromAddress = PropsUtil.get("mail.session.mail.smtp.from.address");


	public void sendEMail(User user, String message, String subject){

		try{
			String toAddress = user.getEmailAddress();
			InternetAddress to = new InternetAddress(toAddress);
			InternetAddress from = new InternetAddress(fromAddress);
			MailMessage mailMessage = new MailMessage(from,subject,
					message, true);
			mailMessage.setTo(to);
			MailServiceUtil.sendEmail(mailMessage);
		}
		catch(Exception ex){
			_log.error(ex);
		}
	}
	
	public void sendSMS(User user, String message){
		try{
			List<Phone> phones = user.getPhones();
			if(phones == null || phones.size()==0){
				_log.error("User deos not have any phone number");
				return;
			}
			String number = phones.get(0).getNumber();
	
			number = number.replaceAll("[^0-9]", "");
			_log.debug("sending SMS  to  "+number+", message: "+message);
			try{
			ClickatellHttp click = new ClickatellHttp(USERNAME, APIID, PASSWORD);
			ClickatellHttp.Message response = click.sendMessage(number, message);
			_log.debug("SMS sent to  "+number+", message: "+message+"status : "+response);
			}catch(Exception e){
				_log.error(e);
				//send using email
				
				InternetAddress toAddress = new InternetAddress("sms@messaging.clickatell.com"); 
				MailMessage mailMessage = new MailMessage(); 
				mailMessage.setTo(toAddress); 
				mailMessage.setFrom(toAddress); 
				StringBuffer sb = new StringBuffer();
				sb.append("api_id: 3604461").append("\n");
				sb.append("user: ").append(USERNAME).append("\n");
				sb.append("password: ").append(PASSWORD).append("\n");
				sb.append("mo: 1").append("\n");
				sb.append("from: ").append(FROM).append("\n");
				sb.append("to: ").append(number).append("\n");
				sb.append("text: ").append(message).append("\n");
	
				mailMessage.setBody(sb.toString()); 
				mailMessage.setHTMLFormat(false); 
				MailServiceUtil.sendEmail(mailMessage); 
				_log.debug("SMS sent using email to  "+number+", message: "+message);
			}
		}
		catch(Exception ex){
			_log.error(ex);
			ex.printStackTrace();
		}
	}
	
	public void sendPush(User user, String message){

		try{
			long[] userId = new long[1];
			userId[0] = user.getUserId();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("body", message);
			json.put("message", message);
			PrincipalThreadLocal.setName(user.getScreenName());
			PermissionChecker permissionChecker =PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
			PushNotificationsDeviceServiceUtil.sendPushNotification(userId, json.toString());				
		}
		catch(Exception ex){
			_log.error(ex);
		}
		
	}
}
