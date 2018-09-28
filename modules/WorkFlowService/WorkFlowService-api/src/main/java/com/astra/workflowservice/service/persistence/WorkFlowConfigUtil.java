/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.astra.workflowservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.astra.workflowservice.model.WorkFlowConfig;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the work flow config service. This utility wraps {@link com.astra.workflowservice.service.persistence.impl.WorkFlowConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFlowConfigPersistence
 * @see com.astra.workflowservice.service.persistence.impl.WorkFlowConfigPersistenceImpl
 * @generated
 */
@ProviderType
public class WorkFlowConfigUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(WorkFlowConfig workFlowConfig) {
		getPersistence().clearCache(workFlowConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkFlowConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkFlowConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkFlowConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkFlowConfig update(WorkFlowConfig workFlowConfig) {
		return getPersistence().update(workFlowConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkFlowConfig update(WorkFlowConfig workFlowConfig,
		ServiceContext serviceContext) {
		return getPersistence().update(workFlowConfig, serviceContext);
	}

	/**
	* Returns all the work flow configs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the work flow configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public static WorkFlowConfig findByUuid_First(java.lang.String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public static WorkFlowConfig fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public static WorkFlowConfig findByUuid_Last(java.lang.String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public static WorkFlowConfig fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the work flow configs before and after the current work flow config in the ordered set where uuid = &#63;.
	*
	* @param WfcId the primary key of the current work flow config
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work flow config
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public static WorkFlowConfig[] findByUuid_PrevAndNext(long WfcId,
		java.lang.String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence()
				   .findByUuid_PrevAndNext(WfcId, uuid, orderByComparator);
	}

	/**
	* Removes all the work flow configs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of work flow configs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching work flow configs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching work flow configs
	*/
	public static List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public static WorkFlowConfig findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<WorkFlowConfig> orderByComparator)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public static WorkFlowConfig fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public static WorkFlowConfig findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<WorkFlowConfig> orderByComparator)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public static WorkFlowConfig fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the work flow configs before and after the current work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param WfcId the primary key of the current work flow config
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work flow config
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public static WorkFlowConfig[] findByUuid_C_PrevAndNext(long WfcId,
		java.lang.String uuid, long companyId,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(WfcId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the work flow configs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching work flow configs
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the work flow config in the entity cache if it is enabled.
	*
	* @param workFlowConfig the work flow config
	*/
	public static void cacheResult(WorkFlowConfig workFlowConfig) {
		getPersistence().cacheResult(workFlowConfig);
	}

	/**
	* Caches the work flow configs in the entity cache if it is enabled.
	*
	* @param workFlowConfigs the work flow configs
	*/
	public static void cacheResult(List<WorkFlowConfig> workFlowConfigs) {
		getPersistence().cacheResult(workFlowConfigs);
	}

	/**
	* Creates a new work flow config with the primary key. Does not add the work flow config to the database.
	*
	* @param WfcId the primary key for the new work flow config
	* @return the new work flow config
	*/
	public static WorkFlowConfig create(long WfcId) {
		return getPersistence().create(WfcId);
	}

	/**
	* Removes the work flow config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config that was removed
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public static WorkFlowConfig remove(long WfcId)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence().remove(WfcId);
	}

	public static WorkFlowConfig updateImpl(WorkFlowConfig workFlowConfig) {
		return getPersistence().updateImpl(workFlowConfig);
	}

	/**
	* Returns the work flow config with the primary key or throws a {@link NoSuchWorkFlowConfigException} if it could not be found.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public static WorkFlowConfig findByPrimaryKey(long WfcId)
		throws com.astra.workflowservice.exception.NoSuchWorkFlowConfigException {
		return getPersistence().findByPrimaryKey(WfcId);
	}

	/**
	* Returns the work flow config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config, or <code>null</code> if a work flow config with the primary key could not be found
	*/
	public static WorkFlowConfig fetchByPrimaryKey(long WfcId) {
		return getPersistence().fetchByPrimaryKey(WfcId);
	}

	public static java.util.Map<java.io.Serializable, WorkFlowConfig> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the work flow configs.
	*
	* @return the work flow configs
	*/
	public static List<WorkFlowConfig> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of work flow configs
	*/
	public static List<WorkFlowConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of work flow configs
	*/
	public static List<WorkFlowConfig> findAll(int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of work flow configs
	*/
	public static List<WorkFlowConfig> findAll(int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the work flow configs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of work flow configs.
	*
	* @return the number of work flow configs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WorkFlowConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkFlowConfigPersistence, WorkFlowConfigPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WorkFlowConfigPersistence.class);
}