package com.aptiv.commonservices.service.model;

public class MachineDetails {
	/**
	 * @param machineId
	 * @param machineName
	 */
	public MachineDetails(int machineId, String machineName) {
		super();
		this.machineId = machineId;
		this.machineName = machineName;
	}
	private int machineId; 
	private String machineName;
	public int getMachineId() {
		return machineId;
	}
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	} 
}
