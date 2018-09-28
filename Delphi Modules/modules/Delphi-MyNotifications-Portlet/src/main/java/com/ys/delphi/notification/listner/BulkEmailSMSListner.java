package com.ys.delphi.notification.listner;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.ys.delphi.notification.model.FisAlarm;
import com.ys.delphi.notification.service.EmailSMSService;
import com.ys.delphi.notification.service.impl.EmailSMSServiceImpl;
import com.ys.delphi.notification.user.model.UserNotificationModel;
import com.ys.delphi.notification.user.utils.UserExternalNotificationUtils;

@Component(
		  immediate = true, 
		  service = BulkEmailSMSListner.class
		)
public class BulkEmailSMSListner implements MessageListener {
	private static Log _log = LogFactoryUtil.getLog(BulkEmailSMSListner.class);
	private EmailSMSService emailSMSService = new EmailSMSServiceImpl();
	String smsFlag = PropsUtil.get("send.sms.notification");	
	private UserExternalNotificationUtils notificationUtil = new UserExternalNotificationUtils();
	
	@Override
	public void receive(Message msg) throws MessageListenerException {
		
		boolean sendSMS = false;
		boolean sendEmail = false;
		boolean sendPush = false; 
		
		
		 long userId = msg.getLong("userId");		 
		 String subName =  msg.getString("subName");
		 String subDesc =  msg.getString("subDesc");
		 String context =  msg.getString("fisAlarm");
		 
		 int emailSMSNotification = msg.getInteger("emailSMSNotification");
		 
		 
		 _log.debug("userId : "+userId );
		 _log.debug("subName : "+subName );
		 _log.debug("subDesc : "+subDesc );
		 _log.debug("emailSMSNotification : "+emailSMSNotification );
		 _log.debug("context : "+context );
		
		 
		 FisAlarm fisAlarm = new FisAlarm(context);
		 
		 switch (emailSMSNotification) {
		     case 1:  	sendEmail = true;
		                break;
	         case 2:  	sendSMS = true;
			  			break;
	         case 3:  	sendEmail = true;
			  			sendSMS = true; 
			  			break;
	         case 4:  	sendPush = true;
			  			break;
	         case 5:  	sendEmail = true;
			  			sendPush = true;
			  			break;
	         case 6:  	sendSMS = true; 			  			
			  			sendPush = true;
			  			break;
	         case 7:  	sendEmail = true;
			  			sendSMS = true; 
			  			sendPush = true;
			  			break;
	         default:
	                  break;
		 }
	
		 _log.debug("sendEmail :"+sendEmail);
		 _log.debug("sendSMS :"+sendSMS);
		 _log.debug("sendPush :"+sendPush);
		 
		 try {
			 UserNotificationModel model = null ; 
			 if(sendEmail || sendSMS || sendPush){
				 model = notificationUtil.isSendNotification(userId, "Notification", null) ; 
			 }
			 if(sendEmail && model.isSendEMail()){
				 emailSMSService.sendEmail(userId, subName, subDesc, fisAlarm);
			 }
			 if(sendSMS && model.isSendSMS() && smsFlag !=null && smsFlag.equalsIgnoreCase("true") ){
				 emailSMSService.sendSMS(userId, subName, subDesc, fisAlarm);
			 }
			 if(sendPush && model.isSendPush()){
				 emailSMSService.sendPush(userId, subName, subDesc, fisAlarm);
			 }
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		 
	}
	
	@Activate
	@Modified
	  protected void activate(Map<String,Object> properties) throws SchedulerException {

	    // create a new trigger definition for the job.
	    String listenerClass = getClass().getName();
	    DestinationConfiguration destinationConfiguration = DestinationConfiguration.createParallelDestinationConfiguration("liferay/bulk/mail/destination");
	    Destination destination = DestinationFactoryUtil.createDestination(destinationConfiguration);
	    destination.register(this);
	    MessageBusUtil.addDestination(destination);
	  }

	  /**
	   * deactivate: Called when OSGi is deactivating the component.
	   */
	  /*@Deactivate
	  protected void deactivate() {
		  MessageBusUtil.unregisterMessageListener("liferay/bulk/mail/destination", this);
		  MessageBusUtil.removeDestination("liferay/bulk/mail/destination");
	  }*/
}
