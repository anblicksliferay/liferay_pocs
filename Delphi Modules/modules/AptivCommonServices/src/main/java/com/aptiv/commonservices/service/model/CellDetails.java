package com.aptiv.commonservices.service.model;

public class CellDetails {
	
	/**
	 * @param areaId
	 * @param segmentId
	 * @param cellSegmentMapId
	 * @param cellId
	 * @param cellName
	 * @param areaName
	 */
	public CellDetails(int areaId, int segmentId, int cellSegmentMapId, int cellId, String cellName, String areaName) {
		super();
		this.areaId = areaId;
		this.segmentId = segmentId;
		this.cellSegmentMapId = cellSegmentMapId;
		this.cellId = cellId;
		this.cellName = cellName;
		this.areaName = areaName;
	}
	private int areaId; 
	private int segmentId; 
	private int cellSegmentMapId; 
	private int cellId; 
	private String cellName;
	private String areaName; 
	public int getCellId() {
		return cellId;
	}
	public void setCellId(int cellId) {
		this.cellId = cellId;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getSegmentId() {
		return segmentId;
	}
	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getCellSegmentMapId() {
		return cellSegmentMapId;
	}
	public void setCellSegmentMapId(int cellSegmentMapId) {
		this.cellSegmentMapId = cellSegmentMapId;
	}

}
