package com.ys.delphi.notification.service;

import java.util.List;

import com.ys.delphi.notification.model.SubscriptionData;

public interface SubscriptionService {
	public List<SubscriptionData> getAllSubscriptionData() throws Exception;
	public List<SubscriptionData> getSubscriptionTransformedData(long subscriptionId, String whereClause) throws Exception;
	public int saveSubscriptionTransformedData(List<SubscriptionData> transformedData) throws Exception;
	public void cleanTransformedDataTable() throws Exception;
}
