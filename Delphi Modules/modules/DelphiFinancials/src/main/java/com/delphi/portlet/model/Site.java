package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Site implements Serializable {

	private static final long serialVersionUID = 5374097651073318239L;

	private NameId nameId;
	private List<ExpenseCatagory> catagories;

	

	public NameId getNameId() {
		return nameId;
	}

	public void setNameId(NameId nameId) {
		this.nameId = nameId;
	}
	public List<ExpenseCatagory> getCatagories() {
		return catagories;
	}

	public void setCatagories(List<ExpenseCatagory> catagories) {
		this.catagories = catagories;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Sites [");
		sb.append(nameId.toString());
		if(catagories != null){
			for(ExpenseCatagory ed : catagories){
				sb.append("\n"+ed.toString());
			}
		}	
		sb.append(" ]");
		return sb.toString();
	}
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", nameId.getId());
		json.put("name", nameId.getName());
		JSONArray jsonArray  = 	JSONFactoryUtil.createJSONArray();
		if(catagories != null){
			for(ExpenseCatagory ed : catagories){
				jsonArray.put(ed.toJSON());
			}
		}
		json.put("catagories", jsonArray);
		return json;
	}
	
	
}
