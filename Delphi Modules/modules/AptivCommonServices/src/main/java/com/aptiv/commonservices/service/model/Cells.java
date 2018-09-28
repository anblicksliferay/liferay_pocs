package com.aptiv.commonservices.service.model;

public class Cells {

	/**
	 * @param cellId
	 * @param cellName
	 */
	public Cells(int cellId, String cellName) {
		super();
		this.cellId = cellId;
		this.cellName = cellName;
	}

	private int cellId;

	private String cellName;

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

}
