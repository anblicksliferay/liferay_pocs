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

import com.ys.hmawfm.wfms.services.model.WFMS_Config;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_Configuration service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_ConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_ConfigPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_ConfigPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_ConfigUtil {
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
	public static void clearCache(WFMS_Config wfms_Config) {
		getPersistence().clearCache(wfms_Config);
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
	public static List<WFMS_Config> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_Config> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_Config> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_Config> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_Config update(WFMS_Config wfms_Config) {
		return getPersistence().update(wfms_Config);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_Config update(WFMS_Config wfms_Config,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_Config, serviceContext);
	}

	/**
	* Returns the WFMS_Configuration where configKey = &#63; or throws a {@link NoSuchWFMS_ConfigException} if it could not be found.
	*
	* @param configKey the config key
	* @return the matching WFMS_Configuration
	* @throws NoSuchWFMS_ConfigException if a matching WFMS_Configuration could not be found
	*/
	public static WFMS_Config findByConfigKey(java.lang.String configKey)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException {
		return getPersistence().findByConfigKey(configKey);
	}

	/**
	* Returns the WFMS_Configuration where configKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param configKey the config key
	* @return the matching WFMS_Configuration, or <code>null</code> if a matching WFMS_Configuration could not be found
	*/
	public static WFMS_Config fetchByConfigKey(java.lang.String configKey) {
		return getPersistence().fetchByConfigKey(configKey);
	}

	/**
	* Returns the WFMS_Configuration where configKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param configKey the config key
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Configuration, or <code>null</code> if a matching WFMS_Configuration could not be found
	*/
	public static WFMS_Config fetchByConfigKey(java.lang.String configKey,
		boolean retrieveFromCache) {
		return getPersistence().fetchByConfigKey(configKey, retrieveFromCache);
	}

	/**
	* Removes the WFMS_Configuration where configKey = &#63; from the database.
	*
	* @param configKey the config key
	* @return the WFMS_Configuration that was removed
	*/
	public static WFMS_Config removeByConfigKey(java.lang.String configKey)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException {
		return getPersistence().removeByConfigKey(configKey);
	}

	/**
	* Returns the number of WFMS_Configurations where configKey = &#63;.
	*
	* @param configKey the config key
	* @return the number of matching WFMS_Configurations
	*/
	public static int countByConfigKey(java.lang.String configKey) {
		return getPersistence().countByConfigKey(configKey);
	}

	/**
	* Caches the WFMS_Configuration in the entity cache if it is enabled.
	*
	* @param wfms_Config the WFMS_Configuration
	*/
	public static void cacheResult(WFMS_Config wfms_Config) {
		getPersistence().cacheResult(wfms_Config);
	}

	/**
	* Caches the WFMS_Configurations in the entity cache if it is enabled.
	*
	* @param wfms_Configs the WFMS_Configurations
	*/
	public static void cacheResult(List<WFMS_Config> wfms_Configs) {
		getPersistence().cacheResult(wfms_Configs);
	}

	/**
	* Creates a new WFMS_Configuration with the primary key. Does not add the WFMS_Configuration to the database.
	*
	* @param configId the primary key for the new WFMS_Configuration
	* @return the new WFMS_Configuration
	*/
	public static WFMS_Config create(long configId) {
		return getPersistence().create(configId);
	}

	/**
	* Removes the WFMS_Configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration that was removed
	* @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	*/
	public static WFMS_Config remove(long configId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException {
		return getPersistence().remove(configId);
	}

	public static WFMS_Config updateImpl(WFMS_Config wfms_Config) {
		return getPersistence().updateImpl(wfms_Config);
	}

	/**
	* Returns the WFMS_Configuration with the primary key or throws a {@link NoSuchWFMS_ConfigException} if it could not be found.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration
	* @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	*/
	public static WFMS_Config findByPrimaryKey(long configId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException {
		return getPersistence().findByPrimaryKey(configId);
	}

	/**
	* Returns the WFMS_Configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration, or <code>null</code> if a WFMS_Configuration with the primary key could not be found
	*/
	public static WFMS_Config fetchByPrimaryKey(long configId) {
		return getPersistence().fetchByPrimaryKey(configId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_Config> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_Configurations.
	*
	* @return the WFMS_Configurations
	*/
	public static List<WFMS_Config> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @return the range of WFMS_Configurations
	*/
	public static List<WFMS_Config> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Configurations
	*/
	public static List<WFMS_Config> findAll(int start, int end,
		OrderByComparator<WFMS_Config> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Configurations
	*/
	public static List<WFMS_Config> findAll(int start, int end,
		OrderByComparator<WFMS_Config> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_Configurations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_Configurations.
	*
	* @return the number of WFMS_Configurations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WFMS_ConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_ConfigPersistence, WFMS_ConfigPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_ConfigPersistence.class);
}