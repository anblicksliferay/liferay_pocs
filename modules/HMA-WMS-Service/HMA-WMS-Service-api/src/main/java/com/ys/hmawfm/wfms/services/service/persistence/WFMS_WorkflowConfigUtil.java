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

package com.ys.hmawfm.wfms.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_WorkflowConfig service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_WorkflowConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfigPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_WorkflowConfigPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigUtil {
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
	public static void clearCache(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		getPersistence().clearCache(wfms_WorkflowConfig);
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
	public static List<WFMS_WorkflowConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_WorkflowConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_WorkflowConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_WorkflowConfig> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_WorkflowConfig update(
		WFMS_WorkflowConfig wfms_WorkflowConfig) {
		return getPersistence().update(wfms_WorkflowConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_WorkflowConfig update(
		WFMS_WorkflowConfig wfms_WorkflowConfig, ServiceContext serviceContext) {
		return getPersistence().update(wfms_WorkflowConfig, serviceContext);
	}

	/**
	* Returns the WFMS_WorkflowConfig where configKey = &#63; or throws a {@link NoSuchWFMS_WorkflowConfigException} if it could not be found.
	*
	* @param configKey the config key
	* @return the matching WFMS_WorkflowConfig
	* @throws NoSuchWFMS_WorkflowConfigException if a matching WFMS_WorkflowConfig could not be found
	*/
	public static WFMS_WorkflowConfig findByConfigKey(
		java.lang.String configKey)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException {
		return getPersistence().findByConfigKey(configKey);
	}

	/**
	* Returns the WFMS_WorkflowConfig where configKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param configKey the config key
	* @return the matching WFMS_WorkflowConfig, or <code>null</code> if a matching WFMS_WorkflowConfig could not be found
	*/
	public static WFMS_WorkflowConfig fetchByConfigKey(
		java.lang.String configKey) {
		return getPersistence().fetchByConfigKey(configKey);
	}

	/**
	* Returns the WFMS_WorkflowConfig where configKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param configKey the config key
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_WorkflowConfig, or <code>null</code> if a matching WFMS_WorkflowConfig could not be found
	*/
	public static WFMS_WorkflowConfig fetchByConfigKey(
		java.lang.String configKey, boolean retrieveFromCache) {
		return getPersistence().fetchByConfigKey(configKey, retrieveFromCache);
	}

	/**
	* Removes the WFMS_WorkflowConfig where configKey = &#63; from the database.
	*
	* @param configKey the config key
	* @return the WFMS_WorkflowConfig that was removed
	*/
	public static WFMS_WorkflowConfig removeByConfigKey(
		java.lang.String configKey)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException {
		return getPersistence().removeByConfigKey(configKey);
	}

	/**
	* Returns the number of WFMS_WorkflowConfigs where configKey = &#63;.
	*
	* @param configKey the config key
	* @return the number of matching WFMS_WorkflowConfigs
	*/
	public static int countByConfigKey(java.lang.String configKey) {
		return getPersistence().countByConfigKey(configKey);
	}

	/**
	* Caches the WFMS_WorkflowConfig in the entity cache if it is enabled.
	*
	* @param wfms_WorkflowConfig the WFMS_WorkflowConfig
	*/
	public static void cacheResult(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		getPersistence().cacheResult(wfms_WorkflowConfig);
	}

	/**
	* Caches the WFMS_WorkflowConfigs in the entity cache if it is enabled.
	*
	* @param wfms_WorkflowConfigs the WFMS_WorkflowConfigs
	*/
	public static void cacheResult(
		List<WFMS_WorkflowConfig> wfms_WorkflowConfigs) {
		getPersistence().cacheResult(wfms_WorkflowConfigs);
	}

	/**
	* Creates a new WFMS_WorkflowConfig with the primary key. Does not add the WFMS_WorkflowConfig to the database.
	*
	* @param wfcId the primary key for the new WFMS_WorkflowConfig
	* @return the new WFMS_WorkflowConfig
	*/
	public static WFMS_WorkflowConfig create(long wfcId) {
		return getPersistence().create(wfcId);
	}

	/**
	* Removes the WFMS_WorkflowConfig with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig that was removed
	* @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	public static WFMS_WorkflowConfig remove(long wfcId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException {
		return getPersistence().remove(wfcId);
	}

	public static WFMS_WorkflowConfig updateImpl(
		WFMS_WorkflowConfig wfms_WorkflowConfig) {
		return getPersistence().updateImpl(wfms_WorkflowConfig);
	}

	/**
	* Returns the WFMS_WorkflowConfig with the primary key or throws a {@link NoSuchWFMS_WorkflowConfigException} if it could not be found.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig
	* @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	public static WFMS_WorkflowConfig findByPrimaryKey(long wfcId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException {
		return getPersistence().findByPrimaryKey(wfcId);
	}

	/**
	* Returns the WFMS_WorkflowConfig with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig, or <code>null</code> if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	public static WFMS_WorkflowConfig fetchByPrimaryKey(long wfcId) {
		return getPersistence().fetchByPrimaryKey(wfcId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_WorkflowConfig> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_WorkflowConfigs.
	*
	* @return the WFMS_WorkflowConfigs
	*/
	public static List<WFMS_WorkflowConfig> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @return the range of WFMS_WorkflowConfigs
	*/
	public static List<WFMS_WorkflowConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_WorkflowConfigs
	*/
	public static List<WFMS_WorkflowConfig> findAll(int start, int end,
		OrderByComparator<WFMS_WorkflowConfig> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_WorkflowConfigs
	*/
	public static List<WFMS_WorkflowConfig> findAll(int start, int end,
		OrderByComparator<WFMS_WorkflowConfig> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_WorkflowConfigs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_WorkflowConfigs.
	*
	* @return the number of WFMS_WorkflowConfigs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WFMS_WorkflowConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_WorkflowConfigPersistence, WFMS_WorkflowConfigPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_WorkflowConfigPersistence.class);
}