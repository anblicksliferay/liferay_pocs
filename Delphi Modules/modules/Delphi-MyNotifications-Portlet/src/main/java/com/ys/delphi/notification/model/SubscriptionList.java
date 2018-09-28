package com.ys.delphi.notification.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionList implements Serializable {

	private static final long serialVersionUID = 1818631427897600808L;
	private List<Long> userList;
	private List<String> subscriptionNameList;
	private List<String> subscriptionDescList;
	private List<Integer> emailSMSNotificationList;
	private List<Integer> subscriptionIdList;

	
	
	public List<Integer> getSubscriptionIdList() {
		return subscriptionIdList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public List<Integer> getEmailSMSNotificationList() {
		return emailSMSNotificationList;
	}


	public void add(long userId, String subscriptionName, String subscriptionDesc,int emailSMSNotification, int  subscriptionId){
		userList.add(userId);
		subscriptionNameList.add(subscriptionName);
		subscriptionDescList.add(subscriptionDesc);
		emailSMSNotificationList.add(emailSMSNotification);
		subscriptionIdList.add(subscriptionId);
	}
	
	
	public SubscriptionList() {
		userList = new ArrayList<Long>();
		subscriptionNameList = new ArrayList<String>();
		subscriptionDescList = new ArrayList<String>();
		emailSMSNotificationList = new ArrayList<Integer>();
		subscriptionIdList = new ArrayList<Integer>();
	}


	public List<Long> getUserList() {
		return userList;
	}


	


	public List<String> getSubscriptionNameList() {
		return subscriptionNameList;
	}


	public List<String> getSubscriptionDescList() {
		return subscriptionDescList;
	}
  public boolean isEmpty(){
	  return subscriptionIdList.isEmpty();
  }
	public int size(){
		return subscriptionIdList.size();
	}
	
	
}
