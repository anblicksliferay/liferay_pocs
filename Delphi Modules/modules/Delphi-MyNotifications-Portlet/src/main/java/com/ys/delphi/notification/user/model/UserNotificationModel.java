package com.ys.delphi.notification.user.model;

public class UserNotificationModel {

		private boolean sendEMail = false; 
		private boolean sendSMS = false; 
		private boolean sendPush = false;
		
		public boolean isSendEMail() {
			return sendEMail;
		}
		public void setSendEMail(boolean sendEMail) {
			this.sendEMail = sendEMail;
		}
		public boolean isSendSMS() {
			return sendSMS;
		}
		public void setSendSMS(boolean sendSMS) {
			this.sendSMS = sendSMS;
		}
		public boolean isSendPush() {
			return sendPush;
		}
		public void setSendPush(boolean sendPush) {
			this.sendPush = sendPush;
		} 
		
		public boolean isEnabled(){
			return (sendEMail || sendSMS || sendPush);
		}
		
		public void setDisbaled(){
			sendEMail = false; 
			sendSMS = false; 
			sendPush = false;
		}
		
		public void print(){
			System.out.println("model.isSendEMail() " + sendEMail);
			System.out.println("model.isSendSMS() " + sendSMS);
			System.out.println("model.isSendPush() " + sendPush);
		}
}
