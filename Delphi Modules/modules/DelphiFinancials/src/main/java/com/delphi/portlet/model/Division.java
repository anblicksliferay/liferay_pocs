package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.SortedSet;

public class Division implements Serializable,Comparable<Division> {

	private static final long serialVersionUID = 3804160302366334567L;
	private NameId nameId;
	private SortedSet<ProductLine> productLines;
	
	public NameId getNameId() {
		return nameId;
	}
	public void setNameId(NameId nameId) {
		this.nameId = nameId;
	}
	
		
	public SortedSet<ProductLine> getProductLines() {
		return productLines;
	}
	public void setProductLines(SortedSet<ProductLine> productLines) {
		this.productLines = productLines;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Division [");
		sb.append(nameId.toString());
		if(productLines != null){
			for(ProductLine ed : productLines){
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
		if(productLines != null){
			for(ProductLine ed : productLines){
				jsonArray.put(ed.toJSON());
			}
		}
		json.put("productLines", jsonArray);
		return json;
	}
	@Override
	public int compareTo(Division o) {
		return this.nameId.compareTo(o.getNameId());
	}

}
