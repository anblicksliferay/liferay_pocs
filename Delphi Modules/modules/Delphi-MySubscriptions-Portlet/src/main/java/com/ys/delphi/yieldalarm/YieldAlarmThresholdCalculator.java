package com.ys.delphi.yieldalarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ys.delphi.subscriptions.model.SubscriptionUpdate;
import com.ys.delphi.yieldalarm.dao.YieldAlarmDAO;
import com.ys.delphi.yieldalarm.model.YieldAlarmDataPointModel;
import com.ys.delphi.yieldalarm.model.YieldAlarmSubscriptionModel;
import com.ys.delphi.yieldalarm.model.YieldAlarmThresholdModel;

public class YieldAlarmThresholdCalculator {
	
	private static Log _log = LogFactoryUtil.getLog(YieldAlarmThresholdCalculator.class);

	private YieldAlarmDAO yieldAlarmDAO = new  YieldAlarmDAO();
	
	public void calculateYieldAlarmThreshold(){
		Calendar cal = Calendar.getInstance();
		long startTime = cal.getTimeInMillis(); 
		
		// fetch all yield alarm subscription
		List<Long> subscriptionList = yieldAlarmDAO.fetchAllYieldAlarmSubscription();
		// for each subscription calculate yield alarm
		for(Long id: subscriptionList){
			calculateYieldAlarmThresholdSubscriptionId(id);
		}

		Calendar cal2 = Calendar.getInstance();
		long endTime = cal2.getTimeInMillis(); 
		long timeTaken = endTime - startTime ; 
		_log.info("Time taken by the calculateYieldAlarmThreshold -> " + timeTaken);

	}
	
	public void calculateYieldAlarmThresholdSubscriptionId(long subscriptionId) {
		try{
			List<YieldAlarmSubscriptionModel> subscriptionModel = yieldAlarmDAO.fetchSubscriptionModel (subscriptionId);
			List<YieldAlarmDataPointModel> dataPointModel = yieldAlarmDAO.fetchYieldAlarmDatapoints(subscriptionModel);
			if(dataPointModel.size() == 0 ) // no data point found 
				return ;
			YieldAlarmThresholdModel threshold = calculateThresholdBasedOnDataPoints(subscriptionId, dataPointModel);
			yieldAlarmDAO.saveYieldAlarmThreshold(threshold);
		}
		catch(Exception ex){
			_log.error(ex);
			ex.printStackTrace();
		}
	}
	
	public YieldAlarmThresholdModel calculateYieldAlarmThreshold(SubscriptionUpdate subscriptionUpdate) {
		YieldAlarmThresholdModel threshold = null ;
		try{
			List<YieldAlarmSubscriptionModel> subscriptionModel = createSubscriptionModel (subscriptionUpdate);
			List<YieldAlarmDataPointModel> dataPointModel = yieldAlarmDAO.fetchYieldAlarmDatapoints(subscriptionModel);
			if(dataPointModel.size() == 0 ) // no data point found 
				return null ;
			threshold = calculateThresholdBasedOnDataPoints(0, dataPointModel);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return threshold ;
	}
	
	private List<YieldAlarmSubscriptionModel> createSubscriptionModel(SubscriptionUpdate subscriptionUpdate){

		List<YieldAlarmSubscriptionModel>  modelLst = new ArrayList<YieldAlarmSubscriptionModel>();;
		try {
			List<String> productType  = subscriptionUpdate.getProductType();
			List<String>  productFamily = subscriptionUpdate.getProductFamily();
			List<String>  processNames = subscriptionUpdate.getProcessNames();
			List<String>  stationNames = subscriptionUpdate.getStationNames();
			List<String> regionNames = subscriptionUpdate.getRegionNames();
			List<String> siteNames = subscriptionUpdate.getSiteNames();
			List<String> serverNames = subscriptionUpdate.getServerNames();
			int count = productType.size();
			for(int i=0; i< count; i++){
				YieldAlarmSubscriptionModel model = new YieldAlarmSubscriptionModel();
				model.setProcess(processNames.get(i).replaceAll("[^\\w\\s]",""));
				model.setServer(serverNames.get(i).replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", ""));
				model.setStation(stationNames.get(i).replaceAll("[^\\w\\s]",""));
				model.setProductFamily(productFamily.get(i).replaceAll("[^\\w\\s]",""));
				model.setProductType(productType.get(i).replaceAll("[^\\w\\s]",""));
				model.setSite(siteNames.get(i).replaceAll("[^\\w\\s]",""));
				model.setRegion(regionNames.get(i).replaceAll("[^\\w\\s]",""));
				modelLst.add(model);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return modelLst;
	}
	public YieldAlarmThresholdModel calculateYieldAlarmThreshold(List<YieldAlarmSubscriptionModel> subscriptionModel) {
		YieldAlarmThresholdModel threshold = null ; 
		try{
			List<YieldAlarmDataPointModel> dataPointModel = yieldAlarmDAO.fetchYieldAlarmDatapoints(subscriptionModel);
			if(dataPointModel.size() == 0 ) // no data point found 
				return null;
			threshold = calculateThresholdBasedOnDataPoints(0, dataPointModel);
		}
		catch(Exception ex){
			_log.error(ex);
			ex.printStackTrace();
		}
		return threshold ; 
	}
	
	private YieldAlarmThresholdModel calculateThresholdBasedOnDataPoints(long subscriptionId, List<YieldAlarmDataPointModel> dataPoints){
		YieldAlarmThresholdModel yieldAlarmThresholdModel = new YieldAlarmThresholdModel();
		SummaryStatistics stat = new SummaryStatistics();
		int totalSamples = 0; 
		for(YieldAlarmDataPointModel pointModel: dataPoints){
			stat.addValue(pointModel.getYield());
			totalSamples = totalSamples + pointModel.getTotal();
		}
		double mean = stat.getMean() ; 
		double sd = stat.getStandardDeviation();
		int count = 0 ; 
		_log.info("YieldAlarmThresholdCalculator size of datapoint = " + dataPoints.size());
		_log.info("YieldAlarmThresholdCalculator  totalSamples = " + totalSamples);

		if(dataPoints.size() != 0){
			count = totalSamples/dataPoints.size();
		}
		yieldAlarmThresholdModel.setSubscriptionId(subscriptionId);
		yieldAlarmThresholdModel.setStandardDeviation(sd*100);
		yieldAlarmThresholdModel.setThreshold(mean*100);
		yieldAlarmThresholdModel.setSampleCount(count);
		return yieldAlarmThresholdModel ; 
	}
}
