package com.ys.delphi.alerts.service;



import com.ys.delphi.alerts.models.CycleTimeUpdate;
import com.ys.delphi.alerts.models.ProductProcess;
import com.ys.delphi.alerts.models.ProductProcessQuery;
import com.ys.delphi.alerts.models.RegionSiteServerList;

import java.util.List;

public interface AlertService {
	
	public List<ProductProcess> getProductProcessList(ProductProcessQuery processQuery) throws Exception;
	public void updateProductProcess(CycleTimeUpdate cycleTimeUpdate) throws Exception;
	public RegionSiteServerList getRegionSiteServerList() throws Exception;
	
}
