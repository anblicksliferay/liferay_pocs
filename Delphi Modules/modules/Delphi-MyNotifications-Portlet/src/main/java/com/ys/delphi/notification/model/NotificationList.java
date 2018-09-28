package com.ys.delphi.notification.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class NotificationList implements Serializable{
	private List<Notification> notifications;

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Notification n : notifications){
			sb.append(n.toString()).append(",");
		}
		return sb.toString();
	}
	
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray s = JSONFactoryUtil.createJSONArray();
		for(Notification n : notifications){
			s.put(n.toJSON());
		}
		json.put("notifications", s);
		return json;
	}
	
	public JSONObject toActiveJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray s = JSONFactoryUtil.createJSONArray();
		for(Notification n : notifications){
			if(n.getStatus().equalsIgnoreCase("Active"))
				s.put(n.toJSON());
		}
		json.put("notifications", s);
		return json;
	}
	
}
