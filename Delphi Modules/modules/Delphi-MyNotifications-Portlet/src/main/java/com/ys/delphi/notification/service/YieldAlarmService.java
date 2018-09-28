package com.ys.delphi.notification.service;

import com.ys.delphi.notification.model.YieldAlarmThresholdModel;
import com.ys.delphi.notification.model.YieldHistory;

public interface YieldAlarmService {
	public YieldHistory getYieldHistory(long subscriptionId, double deviation, String startTime) throws Exception;
	public YieldAlarmThresholdModel fetchThresholdStandardDeviation(long subscriptionId, String startTime) throws Exception ;

}
