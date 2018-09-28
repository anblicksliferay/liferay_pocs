package com.aptiv.guh.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.util.Date;

public class FisEvent {
	private String routeKey;
	private String productFamily;
	private String partNumber;
	private String productType;
	private String event;
	private String process;
	private String station;
	private String status;
	private String data;
	private Date eventDate;
	private Long eventDateInMillis;
	private String formattedEventDate;
	private String parents;
	private String children;
	private String serverName;
	private String location;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getParents() {
		return parents;
	}

	public void setParents(String parents) {
		this.parents = parents;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getFormattedEventDate() {
		return formattedEventDate;
	}

	public void setFormattedEventDate(String formattedEventDate) {
		this.formattedEventDate = formattedEventDate;
	}

	public Long getEventDateInMillis() {
		return eventDateInMillis;
	}

	public void setEventDateInMillis(Long eventDateInMillis) {
		this.eventDateInMillis = eventDateInMillis;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getRouteKey() {
		return routeKey;
	}

	public void setRouteKey(String routeKey) {
		this.routeKey = routeKey;
	}

	public String getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public FisEvent() {
		super();
	}
	
	public FisEvent(String routeKey,String productFamily,String partNumber,String productType,String event,String process,String station,String status,String data, Date eventDate, String formattedEventDate, String parents, String children, String serverName, String location){
		this.routeKey = routeKey;
		this.productFamily = productFamily;
		this.partNumber = partNumber;
		this.productType = productType;
		this.event = event;
		this.process = process;
		this.station = station;
		this.status = status;
		this.data = data;
		this.eventDate = eventDate;
		this.formattedEventDate = formattedEventDate;
		this.parents = parents; 
		this.children = children; 
		this.serverName = serverName;
		if(serverName !=null){
			int index = serverName.indexOf('.') ; 
			if(index > 0){
				this.serverName = serverName.substring(0,index);
			}
		}
		this.location = location; 
	}
	
	@Override
	public String toString() {
		return "FisEvent [productType=" + productType
				+ ", productFamily=" + productFamily + ", partNumber="
				+ partNumber + ", process=" + process + ", station=" + station
				+ ", event=" + event
				+ ", routeKey=" + routeKey
				+ ", parents=" + parents
				+ ", children=" + children
				+ ", status=" + status
				+ ", serverName=" + serverName
				+ ", location=" + location
				+ ", data=" + data
				+ ", eventDate=" + eventDate
				+ ", eventDateInMillis=" + eventDateInMillis
				+ ", formattedEventDate=" + formattedEventDate
				+ "]";
	}
	
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();		
		json.put( "eventDate"			, eventDate);
		json.put( "partNumber"			, partNumber);
		json.put( "process"				, process);
		json.put( "station"				, station);
		json.put( "status"				, status);
		json.put( "data"				, data);
		json.put( "productFamily"		, productFamily);
		json.put( "productType"			, productType);
		json.put( "routeKey"			, routeKey);
		json.put( "parents"			    , parents);
		json.put( "children"			, children);
		json.put( "serverName"			, serverName);
		json.put( "location"			, location);
		json.put( "eventDateInMillis"	, eventDateInMillis);
		json.put( "formattedEventDate"	, formattedEventDate);
		return json;
	}
}
