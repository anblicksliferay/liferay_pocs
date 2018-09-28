package com.aptiv.commonservices.service.impl;

import java.util.List;

import com.aptiv.commonservices.dao.AreaAndCellServiceDao;
import com.aptiv.commonservices.dao.impl.AreaAndCellServiceDaoImpl;
import com.aptiv.commonservices.service.AreaAndCellService;
import com.aptiv.commonservices.service.model.AreaDetails;
import com.aptiv.commonservices.service.model.CellDetails;
import com.aptiv.commonservices.service.model.Cells;
import com.aptiv.commonservices.service.model.OperationMachineUIDetails;
import com.aptiv.commonservices.service.model.Site;

public class AreaAndCellServiceImpl implements AreaAndCellService{

	AreaAndCellServiceDao areaAndCellServiceDao = new AreaAndCellServiceDaoImpl();
	
	@Override
	public List<Site> loadSites(int regionId) {
		return areaAndCellServiceDao.loadSites(regionId);
	}

	@Override
	public boolean addAreaEntity(int siteId, String areaType, String areaName, String areaCode) {
		return areaAndCellServiceDao.addAreaEntity(siteId, areaType, areaName, areaCode);
	}

	@Override
	public List<CellDetails> loadCellDetails(int siteId) {
		return areaAndCellServiceDao.loadCellDetails(siteId); 
	}

	@Override
	public boolean addCellEntity(int areaId, String toBeDecided) {
		return false;
	}

	@Override
	public List<AreaDetails> loadAllAreaDetails(int siteId) {
		return areaAndCellServiceDao.loadAllAreaDetails(siteId);
	}

	@Override
	public List<OperationMachineUIDetails> loadOperationMachineUIDetails(int siteId) {
		return areaAndCellServiceDao.loadOperationMachineUIDetails(siteId);
	}

	@Override
	public List<String> loadAreaType(int siteId) {
		return areaAndCellServiceDao.loadAreaType(siteId);
	}

	@Override
	public List<Cells> loadCells(int areaId) {
		return areaAndCellServiceDao.loadCells(areaId); 
	}

}
