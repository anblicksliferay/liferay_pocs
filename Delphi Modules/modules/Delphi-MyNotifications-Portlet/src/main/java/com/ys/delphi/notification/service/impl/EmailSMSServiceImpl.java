package com.ys.delphi.notification.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.mail.internet.InternetAddress;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.push.notifications.service.PushNotificationsDeviceServiceUtil;
import com.liferay.util.ContentUtil;
import com.ys.delphi.notification.model.ChangeOverHistory;
import com.ys.delphi.notification.model.FisAlarm;
import com.ys.delphi.notification.model.NotificationHistory;
import com.ys.delphi.notification.model.YieldAlarmThresholdModel;
import com.ys.delphi.notification.service.EmailSMSService;
import com.ys.delphi.notification.service.NotificationService;
import com.ys.delphi.notification.service.YieldAlarmService;

public class EmailSMSServiceImpl implements EmailSMSService {
	private static Log _log = LogFactoryUtil.getLog(EmailSMSServiceImpl.class);
	private NotificationService notificationService = new NotificationServiceImpl();

	private String fromAddress = PropsUtil.get("mail.session.mail.smtp.from.address");
	private String myNotifictationUrl=PropsUtil.get("notification.url");
	private static String CYCLETIME_ALERT="CYCLETIME ALERT";
	private static String CHANGEOVER_ALERT="CHANGEOVER ALERT";
	private static String DOWNTIME_ALERT="DOWNTIME ALERT";
	private static String YIELD_ALERT="YIELD ALERT";

	private static  DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	private static String CRITICAL="Critical";
	private static String WARNING = "Warn";
	private static String USERNAME="SanchezLI3";
	private static String PASSWORD ="dfgFEaIefBIBeW";
	private static String APIID="3604333";	
	private static String FROM="14156369196";
	
	@Override
	public void sendEmail(long userId, String subName,String subDesc,FisAlarm fisAlarm) throws Exception {
		_log.debug("sendEmail,userId :"+userId+", subName : "+subName+" , subDesc : "+subDesc);
		_log.debug(fisAlarm.toString());
		if(!fisAlarm.isAlarmActive()){
			_log.info("Alarm is inactive, sms/email was not sent");
			return;
		}
		
		InternetAddress fromAddress = null; 
		InternetAddress toAddress = null; 
		MailMessage mailMessage = null;
		String subject = StringPool.BLANK;
		String body= StringPool.BLANK;
		try { 
			User user = UserLocalServiceUtil.getUser(userId);
		 if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
			 List<NotificationHistory>  notificationHistories = notificationService.getNotificationHistory(fisAlarm.getServerName(),
						fisAlarm.getStation(), fisAlarm.getProcess(), fisAlarm.getPartNumber());
			 fisAlarm.setHistory(notificationHistories);
			 }else if(fisAlarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
				 ChangeOverHistory changeOverHistory = notificationService.getChangeOverHistory(fisAlarm.getServerName(), fisAlarm.getStation(), fisAlarm.getProcess(), fisAlarm.getEventTimeUTC());
				 fisAlarm.setChangeOverHistory(changeOverHistory);
			 }
		
		if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
			body= createCycleTimeAlertBody(fisAlarm);
		}else if(fisAlarm.getAlertType().equalsIgnoreCase(DOWNTIME_ALERT)){
			body = createDownTimeAlertBody(fisAlarm);
		}else if(fisAlarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
			body = createChangeOverAlertBody(fisAlarm);
		}
		else if(fisAlarm.getAlertType().equalsIgnoreCase(YIELD_ALERT)){
			body = createYieldAlertBody(fisAlarm, subName, user.getTimeZoneId());
		}
		
			fromAddress = new InternetAddress(this.fromAddress);			
				toAddress = new InternetAddress(user.getEmailAddress()); 
				mailMessage = new MailMessage(); 
				mailMessage.setTo(toAddress); 
				mailMessage.setFrom(fromAddress); 
				if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
					subject = fisAlarm.getAlarmLevel()+"- Cycle Time Alert - "+subName+"- "+fisAlarm.getStation()+StringPool.SPACE+fisAlarm.getProcess()+StringPool.SPACE+fisAlarm.getPartNumber()+StringPool.SPACE+subDesc;
				}else if(fisAlarm.getAlertType().equalsIgnoreCase(DOWNTIME_ALERT)){
					subject = fisAlarm.getAlarmLevel()+"- Down Time Alert - "+subName+"- "+fisAlarm.getStation()+StringPool.SPACE+fisAlarm.getProcess()+StringPool.SPACE+fisAlarm.getPartNumber()+StringPool.SPACE+subDesc;
				}else if(fisAlarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
					subject = fisAlarm.getAlarmLevel()+"-Change Over Alert - "+subName+"- "+subDesc;
				}else {
					subject = fisAlarm.getAlarmLevel()+"-Yield Alert - "+subName+"- "+subDesc;
				}
				mailMessage.setSubject(subject); 
				mailMessage.setBody(body); 
				mailMessage.setHTMLFormat(true); 
				MailServiceUtil.sendEmail(mailMessage); 
				_log.debug("email sent to " + user.getEmailAddress()+" with subject : "+subject);
						
			 
		}catch (Exception e) { 
			_log.error(e.getMessage());
			e.printStackTrace(); 
			throw new Exception(e);
		}  
	

	}
	
	private String calculateStartCycleTime(BigDecimal threshold,double deviation){		
		try{
			double cycleTimeInMilli = threshold.longValue()+(threshold.longValue()*deviation)/100;
			long cycleTimeInSec= (long)(cycleTimeInMilli / 1000);
			long sec = cycleTimeInSec %60;
			long minute= Math.floorDiv(cycleTimeInSec, 60);
			return minute+":"+sec;
		}catch(Exception e){
			_log.error(e.getMessage());
			e.printStackTrace();
		}		
		return StringPool.BLANK;
	}

	private static String cycleTimeBody = ContentUtil.get("/content/email-notification-cycletime.html", true);
	private String createCycleTimeAlertBody(FisAlarm fisAlarm){
		String body = cycleTimeBody;
		try{
		StringBuilder historyRows = new StringBuilder();	
		String now= StringPool.BLANK;		
		int count = 0;
		List<NotificationHistory> history = fisAlarm.getHistory();
		for(int i =0; i< history.size();i++){			
			NotificationHistory n = history.get(i);
			now = (count ==0 )? "now":"n-"+count;
			historyRows.append("<tr>").append("<td>").append(now).append("</td>")
			.append("<td>").append(n.getCycleTime().getMinuteOfHour()+":"+n.getCycleTime().getSecondOfMinute()).append("</td>")
			.append("<td>").append(calcualteDeviation(fisAlarm.getThresholdDuration(), n.getCycleTime())).append("</td>")
			.append("<td>").append(n.getTime()).append("</td>");
			if(i > 0  && n.getDate().equalsIgnoreCase(history.get(i-1).getDate())){
				historyRows.append("<td>").append("</td>");
			}else{
				historyRows.append("<td>").append(n.getDate()).append("</td>");
			}
			
			historyRows.append("</tr>");
			count++;
		}
		
		String serverName =fisAlarm.getServerName();
		 if(serverName.indexOf('.') > -1){
			 serverName =serverName.substring(0,serverName.indexOf('.')); 
		 }
		String[] dateTime = fisAlarm.getEventTimeLocal().split(" ");
		_log.debug("0 :"+dateTime[0]);
		_log.debug("1 :"+dateTime[1]);
		
		String 	thresholdInString = covertToMMSS(fisAlarm.getThresholdDuration());
		_log.debug("thresholdInString : "+thresholdInString);
		
		String startCycleTime = calculateStartCycleTime(fisAlarm.getThresholdDuration(), fisAlarm.getDeviation());
		body = replaceAll(body, new String[] { "$notifications-link","$Threshold","$StartTime","$startDate","$History", "$Server","$Station","$Process","$PartNumber","$Region","$Site","$StartCycleTime","$StartDeviation"}, 
				new String[] { this.myNotifictationUrl,  thresholdInString, dateTime[1] ,dateTime[0] , historyRows.toString(),
				serverName,fisAlarm.getStation(),fisAlarm.getProcess(),fisAlarm.getPartNumber(),fisAlarm.getRegion(),fisAlarm.getLocation(),startCycleTime,Math.round(fisAlarm.getDeviation())+"%"}); 
		}catch(Exception e){
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return body;
	}
	private String calcualteDeviation(BigDecimal threshold,LocalTime cycleTime){
		double deviation = 0;
		try{
			double cycleTimeInSec = cycleTime.getMillisOfDay();
			deviation  = ((cycleTimeInSec - threshold.longValue())*100.0)/threshold.longValue();			
		}catch(Exception e){
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return Long.toString(Math.round(deviation))+"%";
	}
	private static String downTimeBody = ContentUtil.get("/content/email-notification-downtime.html", true);
	private String createDownTimeAlertBody(FisAlarm fisAlarm){
		String serverName =fisAlarm.getServerName();
		 if(serverName.indexOf('.') > -1){
			 serverName =serverName.substring(0,serverName.indexOf('.')); 
		 }
		String body = downTimeBody;
		
		body = replaceAll(body, new String[] {"$notifications-link","$Date", "$Server","$Station","$Process","$PartNumber","$Region","$Site"}, 
				new String[] {this.myNotifictationUrl, fisAlarm.getEventTimeLocal(),
				serverName,fisAlarm.getStation(),fisAlarm.getProcess(),fisAlarm.getPartNumber(),fisAlarm.getRegion(),fisAlarm.getLocation()}); 
		
		return body;
	}
	private static String changeOverBody = ContentUtil.get("/content/email-notification-changeover.html", true);
	private String createChangeOverAlertBody(FisAlarm fisAlarm){
		String body = changeOverBody;
		
		ChangeOverHistory changeOverHistory = fisAlarm.getChangeOverHistory();
		
		String fromPartNumber= GetterUtil.getString(changeOverHistory.getPartNumber(),StringPool.BLANK);
		String toPartNumber= GetterUtil.getString(fisAlarm.getPartNumber(),StringPool.BLANK);
		String fromType= GetterUtil.getString(changeOverHistory.getProductType(),StringPool.BLANK);
		String toType= GetterUtil.getString(fisAlarm.getProductType(),StringPool.BLANK);
		String fromFamily= GetterUtil.getString(changeOverHistory.getProductFamily(),StringPool.BLANK);
		String toFamily=  GetterUtil.getString(fisAlarm.getProductFamily(),StringPool.BLANK);
		
		DateTime localStartDate = DateTime.parse(fisAlarm.getEventTimeLocal(),fmt);
		DateTime localEndDate = localStartDate.plus(changeOverHistory.getCycleTime().longValue());
		
		_log.debug("createChangeOverAlertBody , localStartDate : "+localStartDate.toString());
		_log.debug("createChangeOverAlertBody , localEndDate : "+localEndDate.toString());
		
		String startTime= localStartDate.toLocalTime().toString(DateTimeFormat.forPattern("HH:mm:ss"));
		String startDate= localStartDate.toLocalDate().toString(DateTimeFormat.forPattern("MM/dd/yyyy"));
		String endTime="-";
		String endDate="-";
		if(!fisAlarm.isAlarmActive()){
			endTime= localEndDate.toLocalTime().toString(DateTimeFormat.forPattern("HH:mm:ss"));
			endDate= localEndDate.toLocalDate().toString(DateTimeFormat.forPattern("MM/dd/yyyy"));
		}
		
		
		LocalTime duration = LocalTime.fromMillisOfDay(changeOverHistory.getCycleTime().longValue());
		String serverName =fisAlarm.getServerName();
		 if(serverName.indexOf('.') > -1){
			 serverName =serverName.substring(0,serverName.indexOf('.')); 
		 }
		 
		String totalTime = (duration.getHourOfDay() < 10?"0"+duration.getHourOfDay() : duration.getHourOfDay())
				+":"+(duration.getMinuteOfHour() <10?"0"+duration.getMinuteOfHour() : duration.getMinuteOfHour())
				+":"+(duration.getSecondOfMinute() < 10 ? "0"+ duration.getSecondOfMinute(): duration.getSecondOfMinute());
		String totalDays =new Duration(changeOverHistory.getCycleTime().longValue()).getStandardDays() +" days";
		
		body = replaceAll(body, 
				new String[] {"$TotalDays","$FromType","$ToType","$FromFamily","$ToFamily","$FromPart","$StartTime","$StartDate","$ToPart","$EndTime","$EndDate","$TotalTime","$notifications-link", "$Server","$Station","$Process","$Region","$Site"}, 
				new String[] {totalDays,   fromType,     toType,   fromFamily,toFamily,    fromPartNumber,startTime,  startDate,  toPartNumber,endTime,endDate,totalTime,this.myNotifictationUrl, serverName,fisAlarm.getStation(),fisAlarm.getProcess(),fisAlarm.getRegion(),fisAlarm.getLocation()}); 
		
		return body;
	}

	private static String yieldBody = ContentUtil.get("/content/email-notification-yield.html", true);
	private String createYieldAlertBody(FisAlarm fisAlarm, String subName, String userTimeZone) throws NumberFormatException, Exception{

		String body = yieldBody;
		String thresholdStr = getThresholdInformation(fisAlarm);
		String sDate = convertDateToUserTimeZone(fisAlarm.getEventTimeLocal(), userTimeZone);
		
	     body = replaceAll(body, new String[] {"$notifications-link","$SubscriptionName", "$Level", "$Threshold" , "$TimeDate"}, 
				new String[] {this.myNotifictationUrl, subName,  fisAlarm.getAlarmLevel() ,thresholdStr,  sDate}); 
		
	     return body;
	}
	
	private static String getThresholdInformation(FisAlarm fisAlarm){
		String thresholdStr = "" ; 
		try{
			YieldAlarmService yieldAlarmService = new YieldAlarmServiceImpl();
			YieldAlarmThresholdModel model =  yieldAlarmService.fetchThresholdStandardDeviation(Long.parseLong(fisAlarm.getAlarmId()), fisAlarm.getEventTimeUTC());
			double threshold = model.getThreshold();
			double sd = model.getStandardDeviation();
			DecimalFormat newFormat = new DecimalFormat("#.#");
			double info =  Double.valueOf(newFormat.format(threshold - sd));
			double warn = Double.valueOf(newFormat.format(threshold - (1.5*sd))); 
			double error =  Double.valueOf(newFormat.format(threshold - (2*sd))); 
			
			if(fisAlarm.getAlarmLevel().equalsIgnoreCase(CRITICAL)){
				thresholdStr = Double.toString(error) ; 
			}else if (fisAlarm.getAlarmLevel().equalsIgnoreCase(WARNING)){
				thresholdStr = Double.toString(warn) ; 
			}
			else{
				thresholdStr = Double.toString(info) ; 
			}
		}
		catch(Exception ex){
		}
		return thresholdStr ; 
	}
	private static String convertDateToUserTimeZone(String time, String userTimeZone){
		String sDate = time ; 
		try{
			 String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		     SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		     TimeZone utc = TimeZone.getTimeZone("UTC");
		     formatter.setTimeZone(utc);
		     Date date = formatter.parse(time);
		     String NEW_DATE_FORMAT = "HH:mm:ss (z) yyyy-MM-dd"; 
		     SimpleDateFormat userSdf = new SimpleDateFormat(NEW_DATE_FORMAT);
		     TimeZone userTz = TimeZone.getTimeZone(userTimeZone);
		     userSdf.setTimeZone(userTz);
		     sDate = userSdf.format(date);
		}
		catch(Exception ex){	
		}
	     return sDate ; 
	}
	
	private static String covertToMMSS(BigDecimal bigDecimal){		
		if(bigDecimal== null){
			return "00:00";
		}
		LocalTime localTime = LocalTime.fromMillisOfDay(bigDecimal.longValue());
		
		return (localTime.getMinuteOfHour() <10?"0"+localTime.getMinuteOfHour() : localTime.getMinuteOfHour())
				+":"+(localTime.getSecondOfMinute() < 10 ? "0"+ localTime.getSecondOfMinute(): localTime.getSecondOfMinute());
		
	}
	
	private String replaceAll(String str, String [] old, String [] rep){
		String newString = str;
		
		for(int i =0; i< old.length;i++){
			_log.debug(old[i] +" - " +rep[i]);
			newString = newString.replace(old[i], rep[i]);
		}
		
		return newString;
		
	}


	@Override
	public void sendSMS(long userId, String subName, String subDesc,
			FisAlarm fisAlarm) throws Exception {
		_log.debug("sendSMS,userId :"+userId+", subName : "+subName+" , subDesc : "+subDesc);
		_log.debug(fisAlarm.toString());
		String number= StringPool.BLANK;
		try{
		User user = UserLocalServiceUtil.getUser(userId);
		List<Phone> phones = user.getPhones();
		if(phones == null || phones.size()==0){
			_log.error("User deos not have any phone number");
			return;
		}
		number = phones.get(0).getNumber();
		_log.debug("number :"+number);
		 String alertLevel =fisAlarm.getAlarmLevel().substring(0, fisAlarm.getAlarmLevel().length() < 4 ? fisAlarm.getAlarmLevel().length()  :4).toUpperCase(); 
		 _log.debug("alertLevel : "+alertLevel);
		 String subNameShort = subName.substring(0, (subName.length() < 44 ? subName.length(): 44));
		 _log.debug("subNameShort : "+subNameShort);
		 
		 // for Yield Alarm lets send message now.
		 if(fisAlarm.getAlertType().equalsIgnoreCase(YIELD_ALERT)){
			sendMessage(number, buildSMSPushBodyForYieldAlert(subName,fisAlarm, user ));
			return ; 
		 }
		 
		 // for rest of the alerts code below 
		 String stationName = fisAlarm.getStation().substring(0,(fisAlarm.getStation().length() < 10 ? fisAlarm.getStation().length(): 10));
		 _log.debug("stationName : "+stationName);
		 String processName = fisAlarm.getProcess().substring(0, (fisAlarm.getProcess().length() < 12 ? fisAlarm.getProcess().length(): 12));
		 _log.debug("processName : "+processName);
		 String serverName =fisAlarm.getServerName();
		 if(serverName.indexOf('.') > -1){
			 serverName =serverName.substring(0,serverName.indexOf('.')); 
		 }else{
			 serverName = serverName.substring(0,(serverName.length() < 10 ? serverName.length(): 10));
		 }
		 _log.debug("serverName : "+serverName);
		 
		 
		 if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
			 List<NotificationHistory>  notificationHistories = notificationService.getNotificationHistory(fisAlarm.getServerName(),
						fisAlarm.getStation(), fisAlarm.getProcess(), fisAlarm.getPartNumber());
			 fisAlarm.setHistory(notificationHistories);
			 }else if(fisAlarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
				 ChangeOverHistory changeOverHistory = notificationService.getChangeOverHistory(fisAlarm.getServerName(), fisAlarm.getStation(), fisAlarm.getProcess(), fisAlarm.getEventTimeUTC());
				 fisAlarm.setChangeOverHistory(changeOverHistory);
			 }
		StringBuilder sb = new StringBuilder();
		
		
		if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
			sb.append(alertLevel).append("-").append("CycleTime-");			
			sb.append(subNameShort).append("-");			
			sb.append(serverName).append("-");			
			sb.append(stationName).append("-");			
			sb.append(processName).append("-");			
			sb.append("PN").append(fisAlarm.getPartNumber()).append("-");			
			sb.append("TR").append(covertToMMSS(fisAlarm.getThresholdDuration())).append("-");			
			sb.append("Start ").append(fisAlarm.getEventTimeLocal()).append(" ");			
			
			List<NotificationHistory> history = fisAlarm.getHistory();
			if(history!=null && history.size()>0){
				NotificationHistory n = history.get(0);
				sb.append("Actual ");
				if(n.getCycleTime().getMinuteOfHour() < 10){
					sb.append("0").append(n.getCycleTime().getMinuteOfHour());
				}else {
					sb.append(n.getCycleTime().getMinuteOfHour());
				}
				sb.append(":");
				
				if(n.getCycleTime().getSecondOfMinute() <10){
					sb.append("0").append(n.getCycleTime().getSecondOfMinute());
				}else {
					sb.append(n.getCycleTime().getSecondOfMinute());
				}
				
			}
			
		}else if(fisAlarm.getAlertType().equalsIgnoreCase(DOWNTIME_ALERT)){
			sb.append(alertLevel).append("-").append("DownTime ");
			if(fisAlarm.getAlarmLevel().equalsIgnoreCase(CRITICAL)){
				sb.append("120min+");
			}else if(fisAlarm.getAlarmLevel().equalsIgnoreCase(WARNING)){
				sb.append("60min+");
			}else{
				sb.append("30min+");
			}
			sb.append(subNameShort).append("-");
			sb.append(serverName).append("-");
			sb.append(stationName).append("-");
			sb.append(processName).append("-");
			sb.append("PN").append(fisAlarm.getPartNumber()).append("-");
			sb.append("Start ").append(fisAlarm.getEventTimeLocal()).append(" ");
		}else if(fisAlarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
			sb.append("INFO-ChangeOver60min+");
			sb.append(subNameShort).append("-");
			sb.append(serverName).append("-");
			sb.append(stationName).append("-");
			sb.append(processName).append("-");
			sb.append("FPN").append(fisAlarm.getChangeOverHistory().getPartNumber()).append("-");
			sb.append("TPN").append(fisAlarm.getPartNumber()).append("-");
			sb.append("St ").append(fisAlarm.getEventTimeLocal()).append(" ");
		}
		
		_log.debug("SMS content : "+sb.toString());
		sendMessage(number, sb.toString());
		}catch(Exception e){
			_log.error(e.getMessage());
			e.printStackTrace();
			throw new Exception (e);
		}
		
	}
	private  void  sendMessage(String number, String message) throws Exception {
		 number = number.replaceAll("[^0-9]", "");
		_log.debug("sending SMS  to  "+number+", message: "+message);
		try{
		ClickatellHttp click = new ClickatellHttp(USERNAME, APIID, PASSWORD);
		ClickatellHttp.Message response = click.sendMessage(number, message);
		_log.debug("SMS sent to  "+number+", message: "+message+"status : "+response);
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
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

	@Override
	public void sendPush(long userId, String subName, String subDesc, FisAlarm fisAlarm) throws Exception {
		_log.debug("sendEmail,userId :"+userId+", subName : "+subName+" , subDesc : "+subDesc);
		_log.debug(fisAlarm.toString());
		long[] user = new long[1];
		user[0] = userId;
		try{
			User localuser = UserLocalServiceUtil.getUser(userId);
			String payload = preparePayloadForPushNotification(localuser, subName, subDesc, fisAlarm);			
			_log.debug("Sending push notification payload is --> " + payload);

			PrincipalThreadLocal.setName(localuser.getScreenName());
			PermissionChecker permissionChecker =PermissionCheckerFactoryUtil.create(localuser);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
			PushNotificationsDeviceServiceUtil.sendPushNotification(user, payload);				
		}
		catch(Exception exc){
			exc.printStackTrace();
			_log.error(exc);
		}
	}
	
	private String preparePayloadForPushNotification(User user, String subName, String subDesc,
			FisAlarm fisAlarm) throws Exception {
		 StringBuilder sb = new StringBuilder();

		 if(fisAlarm.getAlertType().equalsIgnoreCase(YIELD_ALERT)){
			sb.append(buildSMSPushBodyForYieldAlert(subName, fisAlarm, user ));
		 }
		 else{
			 String alertLevel =fisAlarm.getAlarmLevel().substring(0, fisAlarm.getAlarmLevel().length() < 4 ? fisAlarm.getAlarmLevel().length()  :4).toUpperCase(); 
			 String subNameShort = subName.substring(0, (subName.length() < 44 ? subName.length(): 44));
			 String stationName = fisAlarm.getStation().substring(0,(fisAlarm.getStation().length() < 10 ? fisAlarm.getStation().length(): 10));
			 String processName = fisAlarm.getProcess().substring(0, (fisAlarm.getProcess().length() < 12 ? fisAlarm.getProcess().length(): 12));
			 String serverName =fisAlarm.getServerName();
			 if(serverName.indexOf('.') > -1){
				 serverName =serverName.substring(0,serverName.indexOf('.')); 
			 }else{
				 serverName = serverName.substring(0,(serverName.length() < 10 ? serverName.length(): 10));
			 }
	
			 if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
				sb.append(alertLevel).append("-").append("CycleTime-");			
				sb.append(subNameShort).append("-");			
				sb.append(serverName).append("-");			
				sb.append(stationName).append("-");			
				sb.append(processName).append("-");			
				sb.append("PN").append(fisAlarm.getPartNumber()).append("-");			
				sb.append("TR").append(covertToMMSS(fisAlarm.getThresholdDuration())).append("-");			
				sb.append("Start ").append(fisAlarm.getEventTimeLocal()).append(" ");			
				
				List<NotificationHistory> history = fisAlarm.getHistory();
				if(history!=null && history.size()>0){
					NotificationHistory n = history.get(0);
					sb.append("Actual ");
					if(n.getCycleTime().getMinuteOfHour() < 10){
						sb.append("0").append(n.getCycleTime().getMinuteOfHour());
					}else {
						sb.append(n.getCycleTime().getMinuteOfHour());
					}
					sb.append(":");
					
					if(n.getCycleTime().getSecondOfMinute() <10){
						sb.append("0").append(n.getCycleTime().getSecondOfMinute());
					}else {
						sb.append(n.getCycleTime().getSecondOfMinute());
					}
					
				}
				
			 }else if(fisAlarm.getAlertType().equalsIgnoreCase(DOWNTIME_ALERT)){
				sb.append(alertLevel).append("-").append("DownTime ");
				if(fisAlarm.getAlarmLevel().equalsIgnoreCase(CRITICAL)){
					sb.append("120min+");
				}else if(fisAlarm.getAlarmLevel().equalsIgnoreCase(WARNING)){
					sb.append("60min+");
				}else{
					sb.append("30min+");
				}
				sb.append(subNameShort).append("-");
				sb.append(serverName).append("-");
				sb.append(stationName).append("-");
				sb.append(processName).append("-");
				sb.append("PN").append(fisAlarm.getPartNumber()).append("-");
				sb.append("Start ").append(fisAlarm.getEventTimeLocal()).append(" ");
			 }else{
				sb.append("INFO-ChangeOver60min+");
				sb.append(subNameShort).append("-");
				sb.append(serverName).append("-");
				sb.append(stationName).append("-");
				sb.append(processName).append("-");
				sb.append("FPN").append(fisAlarm.getChangeOverHistory().getPartNumber()).append("-");
				sb.append("TPN").append(fisAlarm.getPartNumber()).append("-");
				sb.append("St ").append(fisAlarm.getEventTimeLocal()).append(" ");
			}
		}
		String msg = sb.toString();
		String finalMsg = null ; 
		if(fisAlarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
			finalMsg = "🕒 " ;
		}
		else if(fisAlarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
			finalMsg = "⚙ " ;
		}
		else if(fisAlarm.getAlertType().equalsIgnoreCase(DOWNTIME_ALERT)){
			finalMsg = "⬇️ " ;
		}
		else{
			finalMsg = "%️ " ;
		}
		finalMsg = finalMsg + msg ; 
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("body", finalMsg);
		json.put("message", finalMsg);
		return json.toString();
	}
	
	private String buildSMSPushBodyForYieldAlert(String subName, FisAlarm fisAlarm, User user){
		StringBuilder sb = new StringBuilder();	
		 String alertLevel =fisAlarm.getAlarmLevel().substring(0, fisAlarm.getAlarmLevel().length() < 4 ? fisAlarm.getAlarmLevel().length()  :4).toUpperCase(); 
		 String subNameShort = subName.substring(0, (subName.length() < 44 ? subName.length(): 44));
		sb.append(alertLevel).append("-").append("% Alert-");			
		sb.append(subNameShort).append("-");
		sb.append("Yield fell below ").append(alertLevel) ; 
		sb.append(" threshold ").append(getThresholdInformation(fisAlarm));
		sb.append(" at ").append(convertDateToUserTimeZone(fisAlarm.getEventTimeLocal(), user.getTimeZoneId()));		
		return sb.toString();
	}

}
