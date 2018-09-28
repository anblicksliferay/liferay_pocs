package com.ys.delphi.notification.model;

import java.io.Serializable;

import org.joda.time.DateTime;

public class NotificationQuery implements Serializable {

	private static final long serialVersionUID = -8475484767343554613L;
	private long userId;
	private DateTime startDate;
	private DateTime endDate;
	private RegionSiteServer regionSiteServer;
	private int days;

	public long getUserId() {
		return userId;
	}

	public RegionSiteServer getRegionSiteServer() {
		return regionSiteServer;
	}

	public NotificationQuery(long userId, DateTime startDate, DateTime endDate,
			RegionSiteServer regionSiteServer, int days) {
		super();
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.regionSiteServer = regionSiteServer;
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	@Override
	public String toString() {
		return "NotificationQuery [userId=" + userId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", regionSiteServer="
				+ regionSiteServer + ", days=" + days + "]";
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public boolean isEmpty() {
		return (userId > 0) && (startDate != null) && (endDate != null)
				&& (regionSiteServer != null);
	}

}
