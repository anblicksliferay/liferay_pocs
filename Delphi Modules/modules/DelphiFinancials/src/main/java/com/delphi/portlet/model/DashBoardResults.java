package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.delphi.portlet.model.CategoryExpense;

import java.util.List;

public class DashBoardResults {
  private List<ExpenseCatagory> expenseCatagory;

	public List<ExpenseCatagory> getExpenseCatagory() {
		return expenseCatagory;
	}
	
	public void setExpenseCatagory(List<ExpenseCatagory> expenseCatagory) {
		this.expenseCatagory = expenseCatagory;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" DashBoardResults [");
		if(expenseCatagory != null){
			for(ExpenseCatagory ed : expenseCatagory){
				sb.append("\n"+ed.toString());
			}
		}	
		sb.append(" ]");
		return sb.toString();
	}
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray  = 	JSONFactoryUtil.createJSONArray();
		if(expenseCatagory != null){
			for(ExpenseCatagory ed : expenseCatagory){
				jsonArray.put(ed.toJSON());
			}
		}
		json.put("categories", jsonArray);
		return json;
	}
	
}
