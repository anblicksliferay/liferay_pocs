package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

public class FisAlarm implements Serializable {
	private static Log _log = LogFactoryUtil.getLog(FisAlarm.class);
	private static final long serialVersionUID = 178279459763870391L;
	private String alarmId;
    private String serverName;	
	private String partNumber;
	private String process;
	private String station;
	private String eventTimeUTC;
	private String eventTimeLocal;	
	private String alarmLevel;
	private double deviation;
	private String alertType;
	private long count;
	private boolean isAlarmActive;
	private DateTime alarmStartTime;
	private BigDecimal thresholdDuration;
	private String region;
	private String location;
	private String productType = StringPool.BLANK;
	private String productFamily = StringPool.BLANK;
	
	
	private ChangeOverHistory changeOverHistory;
	
	private List<NotificationHistory> history;
	
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("alarmId",alarmId);
		json.put("serverName",serverName);
		json.put("partNumber",partNumber);
		json.put("process",process);
		json.put("station",station);
		json.put("eventTimeUTC",eventTimeUTC);
		json.put("eventTimeLocal",eventTimeLocal);
		json.put("alarmLevel",alarmLevel);
		json.put("deviation",deviation);
		json.put("alertType",alertType);
		json.put("count",count);
		json.put("isAlarmActive",isAlarmActive);
		json.put("alarmStartTime",alarmStartTime.toString());
		json.put("thresholdDuration",thresholdDuration.longValue());
		json.put("region",region);
		json.put("location",location);
		json.put("productType ",productType );
		json.put("productFamily ",productFamily );

		return json;
	}
	
	
	public BigDecimal getThresholdDuration() {
		return thresholdDuration;
	}
	public void setThresholdDuration(BigDecimal thresholdDuration) {
		this.thresholdDuration = thresholdDuration;
	}
	
	
	public String getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getEventTimeUTC() {
		return eventTimeUTC;
	}
	public void setEventTimeUTC(String eventTimeUTC) {
		this.eventTimeUTC = eventTimeUTC;
	}
	
	public String getEventTimeLocal() {
		return eventTimeLocal;
	}
	public String getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	public double getDeviation() {
		return deviation;
	}
	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public boolean isAlarmActive() {
		return isAlarmActive;
	}
	public void setAlarmActive(boolean isAlarmActive) {
		this.isAlarmActive = isAlarmActive;
	}
	public DateTime getAlarmStartTime() {
		return alarmStartTime;
	}
	public void setAlarmStartTime(DateTime alarmStartTime) {
		this.alarmStartTime = alarmStartTime;
	}


	
	public ChangeOverHistory getChangeOverHistory() {
		return changeOverHistory;
	}
	public void setChangeOverHistory(ChangeOverHistory changeOverHistory) {
		this.changeOverHistory = changeOverHistory;
	}
	public List<NotificationHistory> getHistory() {
		return history;
	}
	public void setHistory(List<NotificationHistory> history) {
		this.history = history;
	}
	
	
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProductType() {
		return productType;
	}
	public String getProductFamily() {
		return productFamily;
	}
	public FisAlarm(String context) {		
		JSONObject json = null;
		try {
			json = JSONFactoryUtil.createJSONObject(context);
		
		
		this.alarmId=json.getString("alarmId");
		this.serverName=json.getString("serverName");
		this.partNumber=json.getString("partNumber");
		this.process=json.getString("process");
		this.station=json.getString("station");
		this.eventTimeUTC=json.getString("eventTimeUTC");
		this.eventTimeLocal=json.getString("eventTimeLocal");
		this.alarmLevel=json.getString("alarmLevel");
		this.deviation=json.getDouble("deviation");
		this.alertType=json.getString("alertType");
		this.count=json.getInt("count");
		this.isAlarmActive=json.getBoolean("isAlarmActive");
		this.alarmStartTime= DateTime.parse(json.getString("alarmStartTime"));
		this.thresholdDuration= BigDecimal.valueOf(json.getDouble("thresholdDuration"));
		this.region=json.getString("region");
		this.location=json.getString("location");
		this.productType =json.getString("productType ");
		this.productFamily =json.getString("productFamily ");
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public FisAlarm(String alarmId, String serverName, String partNumber,
			String process, String station, String eventTimeUTC,
			String eventTimeLocal, String alarmLevel, double deviation,
			String alertType, long count, boolean isAlarmActive,
			DateTime alarmStartTime, BigDecimal thresholdDuration,
			String region, String location, String productType,
			String productFamily) {
		super();
		this.alarmId = alarmId;
		this.serverName = serverName;
		this.partNumber = partNumber;
		this.process = process;
		this.station = station;
		this.eventTimeUTC = eventTimeUTC;
		this.eventTimeLocal = eventTimeLocal;
		this.alarmLevel = alarmLevel;
		this.deviation = deviation;
		this.alertType = alertType;
		this.count = count;
		this.isAlarmActive = isAlarmActive;
		this.alarmStartTime = alarmStartTime;
		this.thresholdDuration = thresholdDuration;
		this.region = region;
		this.location = location;
		this.productType = productType;
		this.productFamily = productFamily;		
	}
	@Override
	public String toString() {
		return "FisAlarm [alarmId=" + alarmId + ", serverName=" + serverName
				+ ", partNumber=" + partNumber + ", process=" + process
				+ ", station=" + station + ", eventTimeUTC=" + eventTimeUTC
				+ ", eventTimeLocal=" + eventTimeLocal + ", alarmLevel="
				+ alarmLevel + ", deviation=" + deviation + ", alertType="
				+ alertType + ", count=" + count + ", isAlarmActive="
				+ isAlarmActive + ", alarmStartTime=" + alarmStartTime
				+ ", thresholdDuration=" + thresholdDuration + ", region="
				+ region + ", location=" + location + ", productType="
				+ productType + ", productFamily=" + productFamily
				+ ", changeOverHistory=" + changeOverHistory + ", history="
				+ history + "]";
	}
	
	
	
	
	
}
