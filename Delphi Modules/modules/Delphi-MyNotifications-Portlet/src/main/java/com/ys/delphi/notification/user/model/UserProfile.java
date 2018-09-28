package com.ys.delphi.notification.user.model;

import java.util.Date;


public class UserProfile {

	private long userId;
	private String communicationPreferences;
	private String region;
	private String site;
	private String server;
	private String workHours;
	
	public UserProfile(long userId){
		this.userId = userId ; 
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCommunicationPreferences() {
		return communicationPreferences;
	}
	public void setCommunicationPreferences(String communicationPreferences) {
		this.communicationPreferences = communicationPreferences;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getWorkHours() {
		return workHours;
	}
	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}
	
	

}
