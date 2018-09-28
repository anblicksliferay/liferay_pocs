package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

public class Notification implements Serializable {

	private static final long serialVersionUID = -4775970687544345846L;
	private String alarmId;
	private int subId;
	private String name;
	private String partNumber;
	private String process;
	private String station;
	private String level;
	private String duration;
	private String status;
	private String alertType;
	private double deviation;
	private String date;
	private String startTimeUTC;
	private String server;
	private String threshold;
	private String desc;
	private String region;
	private String location = StringPool.BLANK;
	private String productType = StringPool.BLANK;
	private String productFamily = StringPool.BLANK;

	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("alarmId", alarmId);
		json.put("startTimeUTC", startTimeUTC);
		json.put("partNumber", partNumber);
		json.put("process", process);
		json.put("station", station);

		json.put("name", name);
		json.put("level", level);
		json.put("status", status);

		json.put("alertType", alertType);
		json.put("deviation", Math.round(deviation) + "%");
		json.put("date", date);
		json.put("duration", duration);
		json.put("server", server);
		json.put("threshold", threshold);
		json.put("regionName", region);
		json.put("siteName", location);
		json.put("productType", productType);
		json.put("productFamily", productFamily);
		json.put("description", desc);
		json.put("subId", subId);
		return json;
	}

	public String getLocation() {
		return location;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public String getRegion() {
		return region;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
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

	public String getLevel() {
		return level;
	}

	public String getDuration() {
		return duration;
	}

	public String getStatus() {
		return status;
	}

	public String getAlertType() {
		return alertType;
	}

	public double getDeviation() {
		return deviation;
	}

	public String getServer() {
		return server;
	}

	public String getThreshold() {
		return threshold;
	}

	public Notification(String name, String partNumber,  String process, String station, String level,
			String duration, String status, String alertType, double deviation, String date, String server,
			String threshold, int subId, String region, String location,String startTimeUTC,String alarmId) {
		super();
		this.partNumber = partNumber;
		this.process=process;
		this.name = name;
		this.station = station;
		this.level = level;
		this.duration = duration;
		this.status = status;
		this.alertType = alertType;
		this.deviation = deviation;
		this.date = date;
		this.server = server;
		this.threshold = threshold;
		this.subId = subId;
		this.region = region;
		this.location = location;
		this.startTimeUTC=startTimeUTC;
		this.alarmId=alarmId;
		
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public int getSubId() {
		return subId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDate() {
		return date;
	}

	
	public String getStartTimeUTC() {
		return startTimeUTC;
	}

	@Override
	public String toString() {
		return "Notification [alarmId=" + alarmId + ", subId=" + subId
				+ ", name=" + name + ", partNumber=" + partNumber
				+ ", process=" + process + ", station=" + station + ", level="
				+ level + ", duration=" + duration + ", status=" + status
				+ ", alertType=" + alertType + ", deviation=" + deviation
				+ ", date=" + date + ", startTimeUTC=" + startTimeUTC
				+ ", server=" + server + ", threshold=" + threshold + ", desc="
				+ desc + ", region=" + region + ", location=" + location
				+ ", productType=" + productType + ", productFamily="
				+ productFamily + "]";
	}

}