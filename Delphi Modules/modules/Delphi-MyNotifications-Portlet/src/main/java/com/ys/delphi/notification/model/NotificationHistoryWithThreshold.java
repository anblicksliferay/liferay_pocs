package com.ys.delphi.notification.model;

import org.joda.time.LocalTime;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class NotificationHistoryWithThreshold {
	private static final long serialVersionUID = -3298141932019501197L;
	private String date;
	private String time;
	private long cycleTime;
	private long threshold ;
	private long manualThreshold;
	private String alertLevel; 
	private long eventTS; 

	public long getEventTS() {
		return eventTS;
	}

	public void setEventTS(long eventTS) {
		this.eventTS = eventTS;
	}

	public long getManualThreshold() {
		return manualThreshold;
	}

	public void setManualThreshold(long manualThreshold) {
		this.manualThreshold = manualThreshold;
	}

	public String getAlertLevel() {
		return alertLevel;
	}

	public void setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
	}

	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();

		json.put("datetime", date +" "+ time);
		json.put("Cycletime", Long.toString(cycleTime));
		json.put("Threshold", Long.toString(threshold));
		json.put("Blank", Long.toString(threshold));
		json.put("Info", Double.toString(threshold*1.1));
		json.put("Warning", Double.toString(threshold*1.2));
		json.put("Critical", Double.toString(threshold*1.3));
		json.put("ManualThreshold", Long.toString(manualThreshold));
		json.put("alertLevel", alertLevel);
		
		return json;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public NotificationHistoryWithThreshold(String date, String time, long cycleTime, long threshold) {
		super();
		this.date = date;
		this.time = time;
		this.cycleTime = cycleTime;
		this.threshold = threshold ;
	}

	public long getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(long cycleTime) {
		this.cycleTime = cycleTime;
	}

	public long getThreshold() {
		return threshold;
	}

	public void setThreshold(long threshold) {
		this.threshold = threshold;
	}

	@Override
	public String toString() {
		return "NotificationHistory [date=" + date + ", time=" + time
				+ ", cycleTime=" + cycleTime + ", threshold=" + threshold +"]";
	}
}
