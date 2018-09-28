package com.aptiv.commonservices.service.model;

public class Site {
	
	private int siteId; 
	
	private String siteName;

	public Site(int siteId, String siteName) {
		this.siteId = siteId; 
		this.siteName = siteName; 
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	
}
