package com.aptiv.commonservices.service.model;

public class AreaDetails {
	private int areaId;
	private String areaCode;
	private String areaName;
	private String areaType; 
	/**
	 * @param areaId
	 * @param areaCode
	 * @param areaName
	 */
	public AreaDetails(int areaId, String areaCode, String areaName) {
		super();
		this.areaId = areaId;
		this.areaCode = areaCode;
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	} 
}
