package com.ys.delphi.subscriptions.service;


import java.util.List;
import com.ys.delphi.subscriptions.model.RegionSiteServerList;
import com.ys.delphi.subscriptions.model.Subscription;
import com.ys.delphi.subscriptions.model.SubscriptionData;
import com.ys.delphi.subscriptions.model.ProductProcessQuery;
import com.ys.delphi.subscriptions.model.ProductProcess;
import com.ys.delphi.subscriptions.model.SubscriptionUpdate;
import com.ys.delphi.subscriptions.model.SubscribedDataProcess;

public interface MySubscriptionService {
	
	public RegionSiteServerList getRegionSiteServerList() throws Exception;
	public List<Subscription> getSubscriptions(long userId) throws Exception;
	public List<ProductProcess> getProductProcessList(ProductProcessQuery processQuery) throws Exception;
	public void addSubscription(SubscriptionUpdate subscriptionUpdate) throws Exception;
	public List<SubscribedDataProcess> getSubscriptionList(String sqlQuery) throws Exception;
	public void updateSubscription(SubscriptionUpdate subscriptionUpdate, long subscriptionId) throws Exception;
	public void deleteSubscription(long subscriptionId) throws Exception;
	public void updateOnOffNotification(long subscriptionId, boolean onOffNotificaiton) throws Exception;
	public void updateAllOnOffNotification(long userId, boolean onOffNotificaiton) throws Exception;
	public boolean isAlertNameDuplicate (long userId,String alertName) throws Exception;
	
	public List<SubscriptionData> getSubscriptionDataForSubscription(long subscriptionId) throws Exception;
	public List<SubscriptionData> getSubscriptionTransformedData(long subscriptionId, String whereClause) throws Exception;
	public int saveSubscriptionTransformedData(List<SubscriptionData> transformedData) throws Exception;
	public boolean isUserPushDeviceRegistered(long userId) throws Exception;
	public String getUserCommunicationPreference(long userId) throws Exception;

}
