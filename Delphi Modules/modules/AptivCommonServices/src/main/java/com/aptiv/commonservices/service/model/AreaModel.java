package com.aptiv.commonservices.service.model;

public class AreaModel {

	private int intVariable;
	private String stringVariable;
	
	public AreaModel() {
		
	}

	public AreaModel(int intVariable, String stringVariable) {
		super();
		this.intVariable = intVariable;
		this.stringVariable = stringVariable;
	}

	public int getIntVariable() {
		return intVariable;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setIntVariable(int intVariable) {
		this.intVariable = intVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}

}
