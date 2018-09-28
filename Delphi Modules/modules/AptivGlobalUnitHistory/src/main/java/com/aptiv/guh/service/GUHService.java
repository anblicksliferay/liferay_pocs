package com.aptiv.guh.service;


import com.aptiv.guh.model.FisEvent;

import com.aptiv.guh.model.FisBarCode;

import java.util.List;

public interface GUHService {
	
	public String getEventListForPartNumber(String processQuery, List<FisEvent> eventList) throws Exception;	
	public List<FisBarCode> getBarCodes(long userId, int category) throws Exception;
	public List<FisBarCode> getViewedBarCodesForToday(long userId) throws Exception;
	public List<FisBarCode> getViewedBarCodesForLastWeek(long userId) throws Exception;
	public void queueBarCode(long userId, String barCode) throws Exception;
	public void viewBarCode(long userId, String barCode) throws Exception;
	public void addBarCodeToSaved(long userId, String barCode) throws Exception;
	public void deleteBarCode(long userId, String barCode) throws Exception;
	public String getParents(String barCode) throws Exception;
	public String getChildren(String barCode) throws Exception;
	public void insertBarCodeInTrackingTable(long userId, String barCode) throws Exception;

}
