package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class CategoryExpense {
	private int id;
	private double actualExepnse;
	private double targetRevenue;
	private double mtdTarget;

	@Override
	public String toString() {
		return "CategoryExpense [id=" + id + ", actualExepnse=" + actualExepnse
				+ ", targetRevenue=" + targetRevenue + ", mtdTarget="
				+ mtdTarget + "]";
	}

	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();

		json.put("id", id);
		json.put("actualExepnse", actualExepnse);
		json.put("targetRevenue", targetRevenue);
		json.put("mtdTarget", mtdTarget);
		return json;
	}

	public int getId() {
		return id;
	}

	public double getActualExepnse() {
		return actualExepnse;
	}

	public double getTargetRevenue() {
		return targetRevenue;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public void setActualExepnse(double actualExepnse) {
		this.actualExepnse = actualExepnse;
	}

	public void setTargetRevenue(double targetRevenue) {
		this.targetRevenue = targetRevenue;
	}

	public double getMtdTarget() {
		return mtdTarget;
	}

	public void setMtdTarget(double mtdTarget) {
		this.mtdTarget = mtdTarget;
	}

	
	
}
