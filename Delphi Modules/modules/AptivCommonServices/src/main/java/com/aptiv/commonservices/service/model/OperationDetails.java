package com.aptiv.commonservices.service.model;

public class OperationDetails {
	/**
	 * @param segmentId
	 * @param operationId
	 * @param operationName
	 */
	public OperationDetails(int segmentId, int operationId, String operationName) {
		super();
		this.segmentId = segmentId;
		this.operationId = operationId;
		this.operationName = operationName;
	}
	private int segmentId; 
	private int operationId; 
	private String operationName;
	public int getSegmentId() {
		return segmentId;
	}
	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	} 
	
}
