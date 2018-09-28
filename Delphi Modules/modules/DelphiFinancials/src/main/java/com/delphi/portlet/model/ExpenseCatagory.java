package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.List;
import java.util.SortedSet;

public class ExpenseCatagory implements Serializable {

	private static final long serialVersionUID = 5374097651073318239L;

	private NameId nameId;
	private SortedSet<Division> divisions;

	

	public NameId getNameId() {
		return nameId;
	}

	public void setNameId(NameId nameId) {
		this.nameId = nameId;
	}


	public SortedSet<Division> getDivisions() {
		return divisions;
	}

	public void setDivisions(SortedSet<Division> divisions) {
		this.divisions = divisions;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" ExpenseCatagory [");
		sb.append(nameId.toString());
		if(divisions != null){
			for(Division ed : divisions){
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
		if(divisions != null){
			for(Division ed : divisions){
				jsonArray.put(ed.toJSON());
			}
		}
		json.put("divisions", jsonArray);
		return json;
	}
	
	
}
