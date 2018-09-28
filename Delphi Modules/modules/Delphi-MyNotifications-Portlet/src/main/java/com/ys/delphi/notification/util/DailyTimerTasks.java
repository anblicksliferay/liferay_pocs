package com.ys.delphi.notification.util;

import java.util.TimerTask;

import com.ys.delphi.notification.service.NotificationService;
import com.ys.delphi.notification.service.impl.NotificationServiceImpl;

public class DailyTimerTasks extends TimerTask {

	@Override
	public void run() {
		SubscriptionDenormalizer denorm = new SubscriptionDenormalizer();
		try { 
			denorm.explodeSubscriptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Also lets delete the notifications older than 30 days
		NotificationService notificationService = new NotificationServiceImpl();
		try {
			notificationService.inactivateNotificationsAfter30Days();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}