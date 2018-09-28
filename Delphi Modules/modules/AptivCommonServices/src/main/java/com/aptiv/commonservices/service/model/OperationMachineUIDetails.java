package com.aptiv.commonservices.service.model;

public class OperationMachineUIDetails {
	private int operationId; 
	private String operationName; 
	private int machineId; 
	private String machineName; 
	private int segmentId; 
	private int cellId; 
	private boolean checked; 
	/**
	 * @param operationId
	 * @param operationName
	 * @param machineId
	 * @param machineName
	 * @param segmentId
	 * @param cellId
	 * @param checked
	 */
	public OperationMachineUIDetails(int operationId, String operationName, int machineId, String machineName,
			int segmentId, int cellId, boolean checked) {
		super();
		this.operationId = operationId;
		this.operationName = operationName;
		this.machineId = machineId;
		this.machineName = machineName;
		this.segmentId = segmentId;
		this.cellId = cellId;
		this.checked = checked;
	}
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public int getMachineId() {
		return machineId;
	}
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	@Override
	public String toString() {
		return "OperationMachineUIDetails [operationId=" + operationId + ", operationName=" + operationName
				+ ", machineId=" + machineId + ", machineName=" + machineName + ", segmentId=" + segmentId + ", cellId="
				+ cellId + ", checked=" + checked + "]";
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
	public int getCellId() {
		return cellId;
	}
	public void setCellId(int cellId) {
		this.cellId = cellId;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
