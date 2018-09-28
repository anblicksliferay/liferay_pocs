package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

public class ExpenseDetail implements Serializable, Comparable<ExpenseDetail>{


	private static final long serialVersionUID = -8402945116280642863L;
	
	private double taget;
    private double actual;
    private int reId; // make -1 if does not exit
    private Day day;
    
    private String updatedBy;
    
	public double getTaget() {
		return taget;
	}
	public void setTaget(double taget) {
		this.taget = taget;
	}
	public double getActual() {
		return actual;
	}
	public void setActual(double actual) {
		this.actual = actual;
	}
	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "ExpenseDetail [taget=" + taget + ", actual=" + actual
				+ ", reId=" + reId + ", day=" + day + ", updatedBy="
				+ updatedBy + "]";
	}
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("taget", taget);
		json.put("actual", actual);
		json.put("reId", reId);
		json.put("day", day.toJSON());		
		return json;
	}
	@Override
	public int compareTo(ExpenseDetail o) {		
		return this.day.compareTo(o.getDay());
	}
}
