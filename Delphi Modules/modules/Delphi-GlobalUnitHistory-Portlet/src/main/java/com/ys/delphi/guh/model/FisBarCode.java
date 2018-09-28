package com.ys.delphi.guh.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class FisBarCode {

	private String barCode;
	private int category;
	
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}	

	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();		
		json.put( "category"			, category);
		json.put( "barCode"				, barCode);
		return json;
	}
	
}
