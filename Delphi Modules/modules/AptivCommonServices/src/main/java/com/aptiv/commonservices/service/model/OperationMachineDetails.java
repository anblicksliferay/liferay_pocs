package com.aptiv.commonservices.service.model;

public class OperationMachineDetails {

	
	@Override
	public String toString() {
		return "OperationMachineDetails [operationId=" + operationId + ", machineId=" + machineId + ", operationName="
				+ operationName + ", machineName=" + machineName + ", segmentId=" + segmentId + "]";
	}

	/**
	 * @param operationId
	 * @param machineId
	 * @param operationName
	 * @param machineName
	 * @param segmentId
	 */
	public OperationMachineDetails(int operationId, int machineId, String operationName, String machineName,
			int segmentId) {
		super();
		this.operationId = operationId;
		this.machineId = machineId;
		this.operationName = operationName;
		this.machineName = machineName;
		this.segmentId = segmentId;
	}

	private int operationId; 
	
	private int machineId; 

	private String operationName; 
	
	private String machineName;
	
	private int segmentId; 
	
	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}

	public int getOperationId() {
		return operationId;
	}

	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}


}
