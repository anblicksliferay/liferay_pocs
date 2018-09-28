package com.ys.delphi.notification.service;


import java.util.List;

import com.liferay.portal.kernel.json.JSONObject;
import com.ys.delphi.notification.model.ChangeOverHistory;
import com.ys.delphi.notification.model.FisAlarm;
import com.ys.delphi.notification.model.KafkaMessage;
import com.ys.delphi.notification.model.NotificationHistory;
import com.ys.delphi.notification.model.NotificationHistoryWithThreshold;
import com.ys.delphi.notification.model.NotificationList;
import com.ys.delphi.notification.model.NotificationQuery;
import com.ys.delphi.notification.model.RegionSiteServerList;
import com.ys.delphi.notification.model.SubscriptionList;

public interface NotificationService {
	public NotificationList getNotifications(NotificationQuery notificationQuery) throws Exception;
	public RegionSiteServerList getRegionSiteServerList() throws Exception;
	public FisAlarm getFisAlarm(KafkaMessage kafkaMessage) throws Exception;
	public void saveFisNotification(FisAlarm alarm,SubscriptionList subscriptionList) throws Exception;
	public SubscriptionList getSubscriberUserList(FisAlarm alarm) throws Exception;
	public List<NotificationHistory> getNotificationHistory(String server,String station,String process, String partNumber ) throws Exception;
	public ChangeOverHistory getChangeOverHistory(String server,
			String station, String process, String eventTimeUTC) throws Exception;
	public void inActiveFisNotification(String alarmId,String startTime) throws Exception;
	public String getInactiveDownTimeDuration(String alarmId, String eventTimeUTC) throws Exception;
	public JSONObject getActiveNotificationCount(NotificationQuery notificationQuery) throws Exception;
	public NotificationList getActiveNotificationsForLast3Days(NotificationQuery notificationQuery) throws Exception;
	public List<NotificationHistoryWithThreshold> getNotificationHistoryWithThreshold(String server,String station,String process, String partNumber,  int duration) throws Exception;
	public void inactivateNotificationsAfter30Days() throws Exception ; 
	public String[] getProductTypeProductFamiliy(String server,String station,String process, String partNumber) throws Exception;

}
