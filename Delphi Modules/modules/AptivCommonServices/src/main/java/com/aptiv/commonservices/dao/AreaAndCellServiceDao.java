package com.aptiv.commonservices.dao;

import java.util.List;

import com.aptiv.commonservices.service.model.AreaDetails;
import com.aptiv.commonservices.service.model.CellDetails;
import com.aptiv.commonservices.service.model.Cells;
import com.aptiv.commonservices.service.model.OperationMachineDetails;
import com.aptiv.commonservices.service.model.OperationMachineUIDetails;
import com.aptiv.commonservices.service.model.Site;

public interface AreaAndCellServiceDao {
	public List<Site> loadSites(int regionId);

	public List<String> loadAreaType(int siteId);

	public boolean addAreaEntity(int siteId, String areaType, String areaName, String areaCode);

	public List<CellDetails> loadCellDetails(int areaId);

	public boolean addCellEntity(int areaId, String toBeDecided);

	public List<AreaDetails> loadAllAreaDetails(int siteId);

	public List<OperationMachineUIDetails> loadOperationMachineUIDetails(int siteId);

	public List<Cells> loadCells(int areaId);
}
