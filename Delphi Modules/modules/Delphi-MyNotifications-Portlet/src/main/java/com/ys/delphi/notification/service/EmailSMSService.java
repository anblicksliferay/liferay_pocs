package com.ys.delphi.notification.service;

import com.ys.delphi.notification.model.FisAlarm;

public interface EmailSMSService {
	public void sendEmail(long userId, String subName,String subDesc,FisAlarm fisAlarm) throws Exception;
	public void sendSMS(long userId, String subName,String subDesc,FisAlarm fisAlarm) throws Exception;
	public void sendPush(long userId, String subName,String subDesc,FisAlarm fisAlarm) throws Exception;

}
