package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Day implements Serializable,Comparable<Day> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1920125357471816925L;
	private int id;
	private Date date;
	private boolean isWeekend;
	private boolean isHoliday;
	
	
	public Day() {
		super();
	}

	public Day(int id, Date date, boolean isWeekend, boolean isHoliday) {
		super();
		this.id = id;
		this.date = date;
		this.isWeekend = isWeekend;
		this.isHoliday = isHoliday;
	}

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	public boolean isHoliday() {
		return isHoliday;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	@Override
	public String toString() {
		return "Day [id=" + id + ", date=" + date + ", isWeekend=" + isWeekend
				+ ", isHoliday=" + isHoliday + "]";
	}
	public String getFormattedDate(){
		String d = "";
		
		if(date !=null){
			d = formatter.format(date);
		}
		return d;
		
	}
	
	public String getDayofWeek(){
		String d = "";
		SimpleDateFormat newDateFormat = new SimpleDateFormat("EEEE");
		if(date !=null){
			
			d = newDateFormat.format(date);
		}
		return d;
	}
	public JSONObject toJSON(){
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", id);
		json.put("date", formatter.format(date));
		json.put("isWeekend", isWeekend);
		json.put("isHoliday", isHoliday);		
		return json;
	}

	@Override
	public int compareTo(Day o) {		
		return this.date.compareTo(o.getDate());
	}

}
