package com.ys.delphi.notification.model;

import java.io.Serializable;

import org.joda.time.DateTime;

public class KafkaMessage implements Serializable {

	private static final long serialVersionUID = -2590959328801323629L;
	private String alarmId;
	private DateTime alarmStartTime;

	public KafkaMessage(String alarmId, DateTime alarmStartTime) {
		super();
		this.alarmId = alarmId;
		this.alarmStartTime = alarmStartTime;

	}

	public String getAlarmId() {
		return alarmId;
	}

	public DateTime getAlarmStartTime() {
		return alarmStartTime;

	}

	@Override
	public String toString() {
		return "KafkaMessage [alarmId=" + alarmId + ", alarmStartTime="
				+ alarmStartTime + "]";
	}
}