package com.aptiv.commonservices.service;

import java.util.List;

import com.aptiv.commonservices.service.model.AreaDetails;
import com.aptiv.commonservices.service.model.CellDetails;
import com.aptiv.commonservices.service.model.Cells;
import com.aptiv.commonservices.service.model.OperationMachineUIDetails;
import com.aptiv.commonservices.service.model.Site;

/**
 * @author sarath_local
 *
 */
public interface AreaAndCellService {
	
	/**
	 * Loads the list of sites for the given instance.
	 * #########This method is done implementing.##########This method is needed (public).###########
	 * @return List of sites.
	 */
	public List<Site> loadSites(int regionId);
	
	/**
	 * @param siteId
	 * Loads areaId, areaType, areaName for given SiteId.#######This method is needed (public). ######## 
	 * #########This method is done implementing.##########
	 * @return
	 */
	public List<AreaDetails> loadAllAreaDetails(int siteId); 
	
	/**
	 * @param siteId
	 * @param areaType
	 * @param areaName
	 * @param areaCode
	 * Adds new area-entity to the DB
	 * #########This method is not done implementing. This method is needed (public). ########
	 * @return true / false
	 */
	public boolean addAreaEntity(int siteId, String areaType, String areaName, String areaCode);
	
	/**
	 * TODO
	 * Loads the list of following: areaId, segmentId, cellSegmentMapId, cellId, cellName, areaName
	 * #########This method is done implementing. This is needed public (or maybe just cellName is good. It also serves as a helper method. )##########
	 * @param areaId
	 * @return List of cell-details. 
	 */
	public List<CellDetails> loadCellDetails(int siteId);
	
	/**
	 * Loads the following details : (cellName, cellId) for a given areaId. 
	 * @param areaId
	 * @return
	 */
	public List<Cells> loadCells(int areaId);
	
	/**
	 * TODO 
	 * This method is not yet implemented. 
	 * @param areaId
	 * @param toBeDecided
	 * @return
	 */
	public boolean addCellEntity(int areaId, String toBeDecided); 
	
	/**
	 * Returns the operation-name : machine-name details for a given site-id. This method is to be public.
	 * @param siteId
	 * @return
	 */
	public List<OperationMachineUIDetails> loadOperationMachineUIDetails(int siteId);

	/**
	 * Loads the list of area types for a given site-id. 
	 * #############This method is written, but not used. ############# This needs to be deleted in the future.
	 * @return List of area-types. 
	 */
	public List<String> loadAreaType(int siteId); 
}
