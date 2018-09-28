package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

import org.joda.time.LocalTime;

public class NotificationHistory implements Serializable {

	private static final long serialVersionUID = -3298141932019501197L;
	private String date;
	private String time;
	private LocalTime cycleTime;
	
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("cycleTime",(cycleTime.getMinuteOfHour() < 10 ? "0"+cycleTime.getMinuteOfHour() : cycleTime.getMinuteOfHour() )+ ":"
						+ (cycleTime.getSecondOfMinute() < 10 ? "0"+cycleTime.getSecondOfMinute():cycleTime.getSecondOfMinute()));
		json.put("time", time);
		json.put("date", date);
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

	public LocalTime getCycleTime() {
		return cycleTime;
	}

	public NotificationHistory(String date, String time, LocalTime cycleTime) {
		super();
		this.date = date;
		this.time = time;
		this.cycleTime = cycleTime;
	}

	@Override
	public String toString() {
		return "NotificationHistory [date=" + date + ", time=" + time
				+ ", cycleTime=" + cycleTime + "]";
	}

}
