package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class NotificationDetail implements Serializable{
	
	private static final long serialVersionUID = -1546582027032493803L;
	private String regionName;
	private String siteName;
	private String productType;
	private String productFamily;
	private String description;
	private List<NotificationHistory> history;
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductFamily() {
		return productFamily;
	}
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NotificationDetail [regionName=")
		.append(regionName).append(", siteName=")
		.append(siteName).append(", productType=").append(productType)
		.append(", productFamily=").append(productFamily).append(", description=").append(description);
		
		sb.append(", history=");
		for(NotificationHistory h:history){
			sb.append(h.toString());
		}
		sb.append("]");
		return sb.toString();
	}
	
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("regionName", regionName);
		json.put("siteName", siteName);
		json.put("productType", productType);
		json.put("productFamily",productFamily);
		json.put("description",description);
		
		JSONArray his = JSONFactoryUtil.createJSONArray();
		for(NotificationHistory h:history){
			his.put(h.toJSON());
		}
		json.put("history", his);
		return json;
	}
	public NotificationDetail(String regionName, String siteName,
			String productType, String productFamily, String description,
			List<NotificationHistory> history) {
		super();
		this.regionName = regionName;
		this.siteName = siteName;
		this.productType = productType;
		this.productFamily = productFamily;
		this.description = description;
		this.history = history;
	}
	public NotificationDetail() {
		super();
	}
	public List<NotificationHistory> getHistory() {
		return history;
	}
	public void setHistory(List<NotificationHistory> history) {
		this.history = history;
	}
	
}
