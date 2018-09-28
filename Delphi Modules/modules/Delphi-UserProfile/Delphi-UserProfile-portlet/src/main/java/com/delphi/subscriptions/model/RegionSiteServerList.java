package com.delphi.subscriptions.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

public class RegionSiteServerList {
private List<RegionSiteServer> regiosSitesSerevers;

	
	public List<RegionSiteServer> getRegiosSitesSerevers() {
		return regiosSitesSerevers;
	}
	public void setRegiosSitesSerevers(List<RegionSiteServer> regiosSitesSerevers) {
		this.regiosSitesSerevers = regiosSitesSerevers;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(RegionSiteServer r : regiosSitesSerevers){
			sb.append(r.toString()).append(",");
		}
		return sb.toString();
	}
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray s = JSONFactoryUtil.createJSONArray();
		for(RegionSiteServer r : regiosSitesSerevers){
			s.put(r.toJSON());
		}
		json.put("regionSitesServers", s);
		return json;
	}

}
