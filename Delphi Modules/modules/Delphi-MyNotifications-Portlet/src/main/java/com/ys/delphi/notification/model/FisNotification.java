package com.ys.delphi.notification.model;

import java.io.Serializable;

import org.joda.time.DateTime;

public class FisNotification implements Serializable {

	private static final long serialVersionUID = 6131087154070509034L;
	
	private long userId;
	private long subscriptionId;
	private String subscriptionName;
	private String alarmId;
	private RegionSiteServer regionSiteServer;
	private String partNumber;
	private String process;
	private String station;
	private DateTime eventTimeUTC;
	private DateTime eventTimeLocal;	
	private String alarmLevel;
	private double deviation;
	private String alertType;
	private boolean isAlarmActive;
	private DateTime alarmStartTime;
	private DateTime notificationStartTime;
	
	public FisNotification(long userId, long subscriptionId,
			String subscriptionName, String alarmId,
			RegionSiteServer regionSiteServer, String partNumber,
			String process, String station, DateTime eventTimeUTC,
			DateTime eventTimeLocal, String alarmLevel, double deviation,
			String alertType, boolean isAlarmActive, DateTime alarmStartTime,
			DateTime notificationStartTime) {
		super();
		this.userId = userId;
		this.subscriptionId = subscriptionId;
		this.subscriptionName = subscriptionName;
		this.alarmId = alarmId;
		this.regionSiteServer = regionSiteServer;
		this.partNumber = partNumber;
		this.process = process;
		this.station = station;
		this.eventTimeUTC = eventTimeUTC;
		this.eventTimeLocal = eventTimeLocal;
		this.alarmLevel = alarmLevel;
		this.deviation = deviation;
		this.alertType = alertType;
		this.isAlarmActive = isAlarmActive;
		this.alarmStartTime = alarmStartTime;
		this.notificationStartTime = notificationStartTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getUserId() {
		return userId;
	}
	public long getSubscriptionId() {
		return subscriptionId;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public String getAlarmId() {
		return alarmId;
	}
	public RegionSiteServer getRegionSiteServer() {
		return regionSiteServer;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public String getProcess() {
		return process;
	}
	public String getStation() {
		return station;
	}
	public DateTime getEventTimeUTC() {
		return eventTimeUTC;
	}
	public DateTime getEventTimeLocal() {
		return eventTimeLocal;
	}
	public String getAlarmLevel() {
		return alarmLevel;
	}
	public double getDeviation() {
		return deviation;
	}
	public String getAlertType() {
		return alertType;
	}
	public boolean isAlarmActive() {
		return isAlarmActive;
	}
	public DateTime getAlarmStartTime() {
		return alarmStartTime;
	}
	public DateTime getNotificationStartTime() {
		return notificationStartTime;
	}
	@Override
	public String toString() {
		return "FisNotification [userId=" + userId + ", subscriptionId="
				+ subscriptionId + ", subscriptionName=" + subscriptionName
				+ ", alarmId=" + alarmId + ", regionSiteServer="
				+ regionSiteServer + ", partNumber=" + partNumber
				+ ", process=" + process + ", station=" + station
				+ ", eventTimeUTC=" + eventTimeUTC + ", eventTimeLocal="
				+ eventTimeLocal + ", alarmLevel=" + alarmLevel
				+ ", deviation=" + deviation + ", alertType=" + alertType
				+ ", isAlarmActive=" + isAlarmActive + ", alarmStartTime="
				+ alarmStartTime + ", notificationStartTime="
				+ notificationStartTime + "]";
	}

}
