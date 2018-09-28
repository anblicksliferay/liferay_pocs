package com.aptiv.commonservices.service.model;

public class OperationMachineModel {
	/**
	 * @param operationName
	 * @param machineName
	 */
	public OperationMachineModel(String operationName, String machineName) {
		super();
		this.operationName = operationName;
		this.machineName = machineName;
	}
	private String operationName; 
	private String machineName;
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	} 
}
