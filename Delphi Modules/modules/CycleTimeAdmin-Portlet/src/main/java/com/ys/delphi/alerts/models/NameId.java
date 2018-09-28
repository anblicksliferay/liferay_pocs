package com.ys.delphi.alerts.models;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

public class NameId implements Serializable,Comparable<NameId> {

	private static final long serialVersionUID = -2155297218575997408L;

	private Integer id;
	private String name;

	public NameId(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NameId [id=" + id + ", name=" + name + "]";
	}
	public JSONObject toJSON(){		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", id);
		json.put("name", name);	
		return json;
	}

	@Override
	public int compareTo(NameId o) {
		return this.id.compareTo(o.getId());
	}
}
