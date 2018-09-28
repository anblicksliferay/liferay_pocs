package com.aptiv.commonservices.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
//import java.sql.Connection;
import java.util.List;

import com.aptiv.commonservices.dao.AreaAndCellServiceDao;
import com.aptiv.commonservices.service.model.AreaDetails;
import com.aptiv.commonservices.service.model.CellDetails;
import com.aptiv.commonservices.service.model.Cells;
import com.aptiv.commonservices.service.model.MachineDetails;
import com.aptiv.commonservices.service.model.OperationDetails;
import com.aptiv.commonservices.service.model.OperationMachineDetails;
import com.aptiv.commonservices.service.model.OperationMachineUIDetails;
import com.aptiv.commonservices.service.model.Site;
import com.aptiv.commonservices.util.OracleJDBCConnection;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

public class AreaAndCellServiceDaoImpl implements AreaAndCellServiceDao {

	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(AreaAndCellServiceDaoImpl.class);

	@Override
	public List<Site> loadSites(int regionId) {
		Connection connection = null;
		PreparedStatement loadSitesPreparedStatement = null;
		ResultSet loadSitesResultSet = null;
		String siteId = null;
		String siteName = null;
		List<Site> sites = new ArrayList<Site>();
		String query = "SELECT SITE_ID, SITE_NAME FROM AI_SITE_MASTER WHERE REGION_ID = " + regionId;
		_log.debug("query to be fired  for loadSites --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadSitesPreparedStatement = connection.prepareStatement(query);
			loadSitesResultSet = loadSitesPreparedStatement.executeQuery();
			while (loadSitesResultSet.next()) {
				loadSitesResultSet.toString();
				siteId = GetterUtil.getString(loadSitesResultSet.getString("SITE_ID"));
				siteName = GetterUtil.getString(loadSitesResultSet.getString("SITE_NAME"));
				if (!(siteId.isEmpty() && siteName.isEmpty())) {
					Site site = new Site(Integer.parseInt(siteId), siteName);
					sites.add(site);
				}
			}
			return sites;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

	@Override
	public boolean addAreaEntity(int siteId, String areaType, String areaName, String areaCode) {
		String insertSQL = "INSERT INTO AI_AREA"
				+ "(SITE_ID, AREA_CODE, AREA_NAME, AREA_TYPE, ACTIVE, LAST_UPDATED_BY, LAST_UPDATED_ON) VALUES "
				+ "(?,?,?,?,?,?,?)";
		System.out.println("Reached into DaoImpl");
		PreparedStatement addAreaPreparedStatement = null;
		Connection connection = null;
		try {
			System.out.println("Reached into DaoImpl 88");
			connection = OracleJDBCConnection.getConnection();
			addAreaPreparedStatement = connection.prepareStatement(insertSQL);
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
			addAreaPreparedStatement.setInt(1, siteId);
			addAreaPreparedStatement.setString(2, areaCode);
			addAreaPreparedStatement.setString(3, areaName);
			addAreaPreparedStatement.setString(4, areaType);
			addAreaPreparedStatement.setString(5, "Yes");
			addAreaPreparedStatement.setString(6, "Sarath");
			addAreaPreparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			if (addAreaPreparedStatement.execute()) {
				return true;
			}
			if (!addAreaPreparedStatement.execute()) {
				System.out.println("Not possible execution. ");
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AreaDetails> loadAllAreaDetails(int siteId) {
		// SELECT AREA_ID, AREA_CODE, AREA_NAME, AREA_TYPE FROM AI_AREA where SITE_ID =
		Connection connection = null;
		PreparedStatement loadAllAreaDetailsPreparedStatement = null;
		ResultSet loadAllAreaDetailsResultSet = null;
		int areaId = (Integer) null;
		String areaCode = null;
		String areaName = null;
		String areaType = null;
		List<AreaDetails> allAreaDetailsList = new ArrayList<AreaDetails>();
		String query = "SELECT AREA_ID, AREA_CODE, AREA_NAME FROM AI_AREA where SITE_ID = " + siteId;
		_log.debug("query to be fired  for loadAreaDetails --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadAllAreaDetailsPreparedStatement = connection.prepareStatement(query);
			loadAllAreaDetailsResultSet = loadAllAreaDetailsPreparedStatement.executeQuery();
			while (loadAllAreaDetailsResultSet.next()) {
				loadAllAreaDetailsResultSet.toString();
				areaId = Integer.valueOf(GetterUtil.getString(loadAllAreaDetailsResultSet.getString("AREA_ID")));
				areaCode = GetterUtil.getString(loadAllAreaDetailsResultSet.getString("AREA_CODE"));
				areaName = GetterUtil.getString(loadAllAreaDetailsResultSet.getString("AREA_NAME"));
				areaType = GetterUtil.getString(loadAllAreaDetailsResultSet.getString("AREA_TYPE"));
				if (!(areaCode.isEmpty() && areaName.isEmpty())) {
					AreaDetails areaDetails = new AreaDetails(areaId, areaCode, areaName);
					allAreaDetailsList.add(areaDetails);
				}
			}
			return allAreaDetailsList;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

	@Override
	public List<CellDetails> loadCellDetails(int siteId) {
		// select CELL_ID, CELL_NAME from AI_CELLS where AREA_ID =
		Connection connection = null;
		PreparedStatement loadCellsPreparedStatement = null;
		ResultSet loadCellsDetailsResultSet = null;
		int cellId;
		int segmentId;
		int cellSegmentMapId;
		int areaId;
		String cellName = null;
		String areaName = null;
		List<CellDetails> cellDetailsList = new ArrayList<CellDetails>();
		String query = "select acsm.SEGMENT_ID, acsm.CELL_SEGMENT_MAP_ID, ac.CELL_ID, ac.CELL_NAME, aa.AREA_ID, aa.AREA_NAME from AI_CELL_SEGMENT_MAP acsm, AI_CELLS ac, AI_AREA aa where acsm.CELL_ID = ac.CELL_ID and ac.AREA_ID = aa.AREA_ID and aa.SITE_ID ="
				+ siteId;
		_log.debug("query to be fired  for loadCells --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadCellsPreparedStatement = connection.prepareStatement(query);
			loadCellsDetailsResultSet = loadCellsPreparedStatement.executeQuery();
			while (loadCellsDetailsResultSet.next()) {
				loadCellsDetailsResultSet.toString();
				cellId = Integer.valueOf(GetterUtil.getString(loadCellsDetailsResultSet.getString("CELL_ID")));
				areaId = Integer.valueOf(GetterUtil.getString(loadCellsDetailsResultSet.getString("CELL_ID")));
				segmentId = Integer.valueOf(GetterUtil.getString(loadCellsDetailsResultSet.getString("SEGMENT_ID")));
				cellSegmentMapId = Integer
						.valueOf(GetterUtil.getString(loadCellsDetailsResultSet.getString("CELL_SEGMENT_MAP_ID")));
				cellName = GetterUtil.getString(loadCellsDetailsResultSet.getString("CELL_NAME"));
				areaName = GetterUtil.getString(loadCellsDetailsResultSet.getString("AREA_NAME"));
				if (!cellName.isEmpty()) {
					CellDetails areaDetails = new CellDetails(areaId, segmentId, cellSegmentMapId, cellId, cellName,
							areaName);
					cellDetailsList.add(areaDetails);
				}
			}
			return cellDetailsList;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

	@Override
	public boolean addCellEntity(int areaId, String toBeDecided) {
		// TODO Auto-generated method stub
		return false;
	}

	private List<OperationMachineDetails> loadOperationMachineDetails(int siteId) {
		// Operation-map -> server-machine-id : (operation-id, operation-name,
		// segment-id) pairs.
		HashMap<Integer, OperationDetails> operationMap = loadOperationMap(siteId);
		// System.out.println("#######################Printing the operation-map
		// now.############################");
		// for (int keyOperation : operationMap.keySet()) {
		// System.out.println("Server-machine-id" + keyOperation + "Operation-name" +
		// operationMap.get(keyOperation));
		// }
		// Machine-map -> server-machine-id : (machine-id, machine-name) pairs.
		HashMap<Integer, MachineDetails> machineMap = loadMachineMap(siteId);
		// System.out.println("#######################Printing the machine-map
		// now.############################");
		// for (int keyMachine : machineMap.keySet()) {
		// System.out.println("Server-machine-id" + keyMachine + "Machine-name" +
		// operationMap.get(keyMachine));
		// }
		// This contains the following : operationId, machineId, operationName,
		// machineName, segmentId POJO
		ArrayList<OperationMachineDetails> operationMachineResultList = new ArrayList<OperationMachineDetails>();
		for (int keyOperation : operationMap.keySet()) {
			if (machineMap.containsKey(keyOperation)) {
				operationMachineResultList.add(new OperationMachineDetails(
						operationMap.get(keyOperation).getOperationId(), machineMap.get(keyOperation).getMachineId(),
						operationMap.get(keyOperation).getOperationName(),
						machineMap.get(keyOperation).getMachineName(), operationMap.get(keyOperation).getSegmentId()));
			}
		}
		// Getting the state of the
		for (OperationMachineDetails opMachineModel : operationMachineResultList) {
			opMachineModel.toString();
		}
		return operationMachineResultList;
	}

	@Override
	public List<OperationMachineUIDetails> loadOperationMachineUIDetails(int siteId) {
		List<OperationMachineDetails> operationMachineDetails = loadOperationMachineDetails(siteId); 
		List<CellDetails> cellDetails = loadCellDetails(siteId); 
		return null;
	}

	/**
	 * Returns the server-machine-id : (machine-id, machine-name) pair for the given
	 * site-id.
	 * 
	 * @param siteId
	 * @return
	 */
	private HashMap<Integer, MachineDetails> loadMachineMap(int siteId) {
		Connection connection = null;
		PreparedStatement loadMachineMapPreparedStatement = null;
		ResultSet loadMachineMapResultSet = null;
		int serverMachineId;
		int machineId;
		String machineName = null;
		HashMap<Integer, MachineDetails> machineMap = new HashMap<Integer, MachineDetails>();
		String query = "select AI_MACHINE_MASTER.MACHINE_NAME, AI_SERVER_MACHINE_MAP.SERVER_MACHINE_ID, AI_MACHINE_MASTER.MACHINE_ID from AI_SERVER_MACHINE_MAP INNER JOIN AI_MACHINE_MASTER ON AI_MACHINE_MASTER.MACHINE_ID = AI_SERVER_MACHINE_MAP.MACHINE_ID WHERE AI_SERVER_MACHINE_MAP.SERVER_MACHINE_ID IN ( select AI_OPERATION_MACHINE_MAP.SERVER_MACHINE_ID FROM AI_OPERATION_MACHINE_MAP INNER JOIN AI_OPERATION_MASTER ON AI_OPERATION_MACHINE_MAP.OPERATION_ID = AI_OPERATION_MASTER.OPERATION_ID WHERE AI_OPERATION_MASTER.OPERATION_ID IN (select AI_OPERATION_MASTER.OPERATION_ID from AI_OPERATION_MASTER INNER JOIN AI_SITE_MASTER ON AI_OPERATION_MASTER.SITE_ID = AI_SITE_MASTER.SITE_ID where AI_SITE_MASTER.SITE_ID = "
				+ siteId + ")) order by AI_SERVER_MACHINE_MAP.SERVER_MACHINE_ID asc";
		_log.debug("query to be fired  for loadAreaType --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadMachineMapPreparedStatement = connection.prepareStatement(query);
			loadMachineMapResultSet = loadMachineMapPreparedStatement.executeQuery();
			while (loadMachineMapResultSet.next()) {
				loadMachineMapResultSet.toString();
				serverMachineId = Integer
						.valueOf(GetterUtil.getString(loadMachineMapResultSet.getString("SERVER_MACHINE_ID")));
				machineName = GetterUtil.getString(loadMachineMapResultSet.getString("MACHINE_NAME"));
				machineId = Integer.valueOf(GetterUtil.getString(loadMachineMapResultSet.getString("MACHINE_ID")));
				if (!machineName.isEmpty()) {
					machineMap.put(serverMachineId, new MachineDetails(machineId, machineName));
				}
			}
			return machineMap;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

	/**
	 * Returns the server-machine-id : (operation-id, operation-name, segment-id)
	 * pair for the given site-id.
	 * 
	 * @param siteId
	 * @return
	 */
	private HashMap<Integer, OperationDetails> loadOperationMap(int siteId) {
		Connection connection = null;
		PreparedStatement loadOperationMapPreparedStatement = null;
		ResultSet loadOperationMapResultSet = null;
		int serverMachineId;
		int segmentId;
		int operationId;
		String operationName = null;
		HashMap<Integer, OperationDetails> operationMap = new HashMap<Integer, OperationDetails>();
		String query = "select AI_OPERATION_MACHINE_MAP.SEGMENT_ID, AI_OPERATION_MACHINE_MAP.SERVER_MACHINE_ID, AI_OPERATION_MASTER.OPERATION_NAME, AI_OPERATION_MASTER.OPERATION_ID FROM AI_OPERATION_MACHINE_MAP INNER JOIN AI_OPERATION_MASTER ON AI_OPERATION_MACHINE_MAP.OPERATION_ID = AI_OPERATION_MASTER.OPERATION_ID WHERE AI_OPERATION_MASTER.OPERATION_ID IN ( select AI_OPERATION_MASTER.OPERATION_ID from AI_OPERATION_MASTER INNER JOIN AI_SITE_MASTER ON AI_OPERATION_MASTER.SITE_ID = AI_SITE_MASTER.SITE_ID where AI_SITE_MASTER.SITE_ID = "
				+ siteId + ")";
		_log.debug("query to be fired  for loadAreaType --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadOperationMapPreparedStatement = connection.prepareStatement(query);
			loadOperationMapResultSet = loadOperationMapPreparedStatement.executeQuery();
			while (loadOperationMapResultSet.next()) {
				loadOperationMapResultSet.toString();
				segmentId = Integer.valueOf(GetterUtil.getString(loadOperationMapResultSet.getString("SEGMENT_ID")));
				serverMachineId = Integer
						.valueOf(GetterUtil.getString(loadOperationMapResultSet.getString("SERVER_MACHINE_ID")));
				operationName = GetterUtil.getString(loadOperationMapResultSet.getString("OPERATION_NAME"));
				operationId = Integer
						.valueOf(GetterUtil.getString(loadOperationMapResultSet.getString("OPERATION_ID")));
				if (!operationName.isEmpty()) {
					operationMap.put(serverMachineId, new OperationDetails(segmentId, operationId, operationName));
				}
			}
			return operationMap;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

	@Override
	public List<String> loadAreaType(int siteId) {
		Connection connection = null;
		PreparedStatement loadAreaTypePreparedStatement = null;
		ResultSet loadAreaTypeResultSet = null;
		String areaType = null;
		List<String> areaTypes = new ArrayList<String>();
		String query = "SELECT DISTINCT AREA_TYPE FROM AI_AREA WHERE SITE_ID = " + siteId;
		_log.debug("query to be fired  for loadAreaType --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadAreaTypePreparedStatement = connection.prepareStatement(query);
			loadAreaTypeResultSet = loadAreaTypePreparedStatement.executeQuery();
			while (loadAreaTypeResultSet.next()) {
				loadAreaTypeResultSet.toString();
				areaType = GetterUtil.getString(loadAreaTypeResultSet.getString("AREA_TYPE"));
				if (!areaType.isEmpty()) {
					areaTypes.add(areaType);
				}
			}
			return areaTypes;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

	@Override
	public List<Cells> loadCells(int areaId) {

		Connection connection = null;
		PreparedStatement loadCells = null;
		ResultSet loadCellsResultSet = null;
		int cellId;
		String cellName = null;
		List<Cells> cellsList = new ArrayList<Cells>();

		String query = "select CELL_ID, CELL_NAME from AI_CELLS where AREA_ID = " + areaId;
		_log.debug("query to be fired  for loadAreaType --> " + query);
		try {
			connection = OracleJDBCConnection.getConnection();
			loadCells = connection.prepareStatement(query);
			loadCellsResultSet = loadCells.executeQuery();
			while (loadCellsResultSet.next()) {
				loadCellsResultSet.toString();
				cellId = Integer.valueOf(GetterUtil.getString(loadCellsResultSet.getString("CELL_ID")));
				cellName = GetterUtil.getString(loadCellsResultSet.getString("CELL_NAME"));
				if (!cellName.isEmpty()) {
					cellsList.add(new Cells(cellId, cellName));
				}
			}
			return cellsList;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return null;
	}

}
