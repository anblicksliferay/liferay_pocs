package com.delphi.userprofile.notification.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.delphi.userprofile.model.UserProfile;
import com.delphi.userprofile.notification.model.UserNotificationModel;
import com.delphi.userprofile.service.UserProfileLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class UserExternalNotificationUtils {
	private static Log _log = LogFactoryUtil.getLog(UserExternalNotificationUtils.class);
	public static final int SYSTEM_TYPE = 1; 
	public static final int SITE_TYPE = 2; 
	public static final int ALERT_NOTIFICATION_TYPE = 3; 
	
	private static String EMPTY ="";
	
		public UserNotificationModel isSendNotification(long userId, String notificationType, String site){
			
			int type = checkNotificationType(notificationType);
			
			UserNotificationModel notificationModel = new UserNotificationModel();
			try{
				// first fetch the UserProfile
				UserProfile userProfile = null ; 
				try{
					userProfile = UserProfileLocalServiceUtil.findUserProfileByUserId(userId);
				}
				catch(Exception ex){
					// could not find the user profile go with default settings
				}
				
				if(type == SITE_TYPE){
					if(userProfile == null || userProfile.getSite() == null){
						notificationModel.setDisbaled();
						return notificationModel; 
					}
					else{
						if(!userProfile.getSite().equalsIgnoreCase(site)){
							// sites are different
							notificationModel.setDisbaled();
							return  notificationModel; 
						}
					}
				}
				
				// first check communication preference
				validateCommunicationPreference(userProfile, notificationModel, type);
				// if preference is yes
				if(notificationModel.isEnabled())
				{
					// then figure out based on work preferences
					validateWorkHours(userProfile, notificationModel, type);
				}				
			}
			catch(Exception ex){
				_log.error("Fail to calculate User Preference for user id -"+ userId);
				notificationModel.setDisbaled();// making disabled as default
			}

			return notificationModel;
		}
		
		private void validateCommunicationPreference(UserProfile userProfile, UserNotificationModel notificationModel,int type) throws Exception{
			// check basic details on communication preference
			//  in case userProfile is null or userProfile communication preference is null or empty
			if(userProfile == null || userProfile.getCommunicationPreferences() == null || userProfile.getCommunicationPreferences().equalsIgnoreCase("{}")){
				setDefaultCommunicationPreference(userProfile, notificationModel, type);
			}else{ // user profile object is present and have some value in communication preference
				JSONObject json = JSONFactoryUtil.createJSONObject(userProfile.getCommunicationPreferences());	
				switch (type) {
		            case SYSTEM_TYPE:  
		            	notificationModel.setSendEMail(true);
		            	notificationModel.setSendSMS(json.getBoolean("smsSystemAlerts"));
		            	notificationModel.setSendPush(json.getBoolean("pushSystemAlerts"));
		            	break;
		            case SITE_TYPE: 
		            	notificationModel.setSendEMail(true);
		            	notificationModel.setSendSMS(json.getBoolean("smsSiteAlerts"));
		            	notificationModel.setSendPush(json.getBoolean("pushSiteAlerts"));
		            	break;
		            case ALERT_NOTIFICATION_TYPE:  
		            	notificationModel.setSendEMail(true);
		            	notificationModel.setSendSMS(true);
		            	notificationModel.setSendPush(true);
		            	break;
		            default: 
		                break;
				}
			}
		}
		
		private void setDefaultCommunicationPreference(UserProfile userProfile, UserNotificationModel notificationModel,int type){
			switch (type) {
	            case SYSTEM_TYPE:  
	            	notificationModel.setSendEMail(true);
	            	notificationModel.setSendSMS(false);
	            	notificationModel.setSendPush(false);
	            	break;
	            case SITE_TYPE: 
	            	notificationModel.setSendEMail(true);
	            	notificationModel.setSendSMS(false);
	            	notificationModel.setSendPush(false);
	            	break;
	            case ALERT_NOTIFICATION_TYPE:  
	            	notificationModel.setSendEMail(true);
	            	notificationModel.setSendSMS(true);
	            	notificationModel.setSendPush(true);
	            	break;
	            default: 
	                break;
			}
			
		}
		
		
		private void validateWorkHours(UserProfile userProfile, UserNotificationModel notificationModel,int type) throws Exception{
			if(userProfile == null || userProfile.getWorkHours() == null || userProfile.getWorkHours().equalsIgnoreCase("{}")){
				// if work hour preference is not found then don't do anything
				return; 
			}else{ 
				JSONObject json = JSONFactoryUtil.createJSONObject(userProfile.getWorkHours());	
				// first check vacation
				boolean isOnVacation = json.getBoolean("vacation-toggle") ;
				User user = UserLocalServiceUtil.getUser(userProfile.getUserId());
				String timezone =  user.getTimeZoneId();
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyyMMdd|HHmm|EEEE");
				df.setTimeZone(TimeZone.getTimeZone(timezone));
				String userLocalDate =  df.format(date); 
				String[] data = userLocalDate.split("\\|");
				int todayDate = Integer.parseInt(data[0]);
				
				if(isOnVacation){
					boolean toPresent = !(json.getString("vacationTo").equalsIgnoreCase(EMPTY));
					boolean fromPresent = !(json.getString("vacationFrom").equalsIgnoreCase(EMPTY));

					if(!toPresent && !fromPresent){
						// case 1 : to and from data is missing means person is on vacation turn off notifications
						notificationModel.setDisbaled();
						return ; 
					}else if(!toPresent && fromPresent){
						// case 2 : to missing means person is on vacation from a particular date check if today is more than that
						int vacationFrom = Integer.parseInt(json.getString("vacationFrom")) ;
						if(todayDate >= vacationFrom){
							notificationModel.setDisbaled();
							return ; 
						}
					}else if(toPresent && !fromPresent){
						// case 3 : from is missing means person is on vacation till a particular date check if today is less than that
						int vacationTo = Integer.parseInt(json.getString("vacationTo")) ;
						if( todayDate <= vacationTo){
							notificationModel.setDisbaled();
							return ; 
						}
					}else if(toPresent && fromPresent){
						//  case 4: both present check the range
						int vacationTo = Integer.parseInt(json.getString("vacationTo")) ;
						int vacationFrom = Integer.parseInt(json.getString("vacationFrom")) ;
						// logic to check today falls between vacationTo and vacationFrom
						if(todayDate >= vacationFrom &&  todayDate <= vacationTo){
							// turn off notifications
							notificationModel.setDisbaled();
							return ; 
						}
					}
				}
				// means person is not on vacation lets check the work hours
				
				// if work hours set to always on then just return no need to check for work hours
				if(json.getString("workHoursSelectionType").equalsIgnoreCase("on")){
					return ; 
				}
				else{
					// then check based on work hours
					String day =  data[2].toLowerCase();
					if(json.getString(day+"-to").equals(EMPTY) ||  json.getString(day+"-from").equals(EMPTY)){
						// turn off notifications
						notificationModel.setDisbaled();
						return ; 
					}
					int toHour = Integer.parseInt(json.getString(day+"-to")) ;
					int fromHour = Integer.parseInt(json.getString(day+"-from")) ;
					int hour = Integer.parseInt(data[1]) ;
					
					if(hour >= fromHour && hour <= toHour){
						// don't disable
						return ; 
					}
					notificationModel.setDisbaled();
				}
			}
		}
		
		private int checkNotificationType(String notificationType){
			int type = 0; 
			
			if(notificationType.equalsIgnoreCase("System"))
				type = SYSTEM_TYPE ; 
			else if(notificationType.equalsIgnoreCase("Site"))
				type = SITE_TYPE ; 
			else  if(notificationType.equalsIgnoreCase("Notification"))
				type = ALERT_NOTIFICATION_TYPE ;
			
			return type; 
		}
}
