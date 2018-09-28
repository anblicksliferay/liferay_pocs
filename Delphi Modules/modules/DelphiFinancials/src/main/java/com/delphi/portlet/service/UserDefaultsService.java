package com.delphi.portlet.service;

import java.util.Map;

public interface UserDefaultsService {
	
	public void updateDefaults(long userId, String pageId, String fieldId, String fieldValue) ; 
	public Map<String, String> fetchUserDefaults(long userId, String pageId); 

}
