package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Region implements Serializable{

	private static final long serialVersionUID = 5374097651073318239L;

	private NameId nameId;
	private List<Site> sites;

	

	public NameId getNameId() {
		return nameId;
	}

	public void setNameId(NameId nameId) {
		this.nameId = nameId;
	}


	

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Region [");
		sb.append(nameId.toString());
		if(sites != null){
			for(Site ed : sites){
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
		if(sites != null){
			for(Site ed : sites){
				jsonArray.put(ed.toJSON());
			}
		}
		json.put("sites", jsonArray);
		return json;
	}
	
	
}
