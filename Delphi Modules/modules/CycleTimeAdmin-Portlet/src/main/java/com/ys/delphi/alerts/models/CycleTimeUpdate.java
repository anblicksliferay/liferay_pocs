package com.ys.delphi.alerts.models;

import java.util.List;

public class CycleTimeUpdate {
	private String partNumber;
	private String process;
	private String station;
	private List<String> serverNames;
	private int customCycleTime;
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
	public List<String> getServerNames() {
		return serverNames;
	}
	public void setServerNames(List<String> serverNames) {
		this.serverNames = serverNames;
	}
	public int getCustomCycleTime() {
		return customCycleTime;
	}
	public void setCustomCycleTime(int customCycleTime) {
		this.customCycleTime = customCycleTime;
	}
	@Override
	public String toString() {
		return "CycleTimeUpdate [partNumber=" + partNumber + ", process="
				+ process + ", station=" + station + ", serverNames="
				+ serverNames + ", customCycleTime=" + customCycleTime + "]";
	}
	public CycleTimeUpdate(String partNumber, String process, String station,
			List<String> serverNames, int customCycleTime) {
		super();
		this.partNumber = partNumber;
		this.process = process;
		this.station = station;
		this.serverNames = serverNames;
		this.customCycleTime = customCycleTime;
	}
	
}
