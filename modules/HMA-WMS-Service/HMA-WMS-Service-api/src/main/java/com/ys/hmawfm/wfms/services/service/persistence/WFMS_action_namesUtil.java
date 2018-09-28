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

import com.ys.hmawfm.wfms.services.model.WFMS_action_names;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_action_names service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_action_namesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_namesPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_action_namesPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_action_namesUtil {
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
	public static void clearCache(WFMS_action_names wfms_action_names) {
		getPersistence().clearCache(wfms_action_names);
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
	public static List<WFMS_action_names> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_action_names> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_action_names> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_action_names> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_action_names update(WFMS_action_names wfms_action_names) {
		return getPersistence().update(wfms_action_names);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_action_names update(
		WFMS_action_names wfms_action_names, ServiceContext serviceContext) {
		return getPersistence().update(wfms_action_names, serviceContext);
	}

	/**
	* Caches the WFMS_action_names in the entity cache if it is enabled.
	*
	* @param wfms_action_names the WFMS_action_names
	*/
	public static void cacheResult(WFMS_action_names wfms_action_names) {
		getPersistence().cacheResult(wfms_action_names);
	}

	/**
	* Caches the WFMS_action_nameses in the entity cache if it is enabled.
	*
	* @param wfms_action_nameses the WFMS_action_nameses
	*/
	public static void cacheResult(List<WFMS_action_names> wfms_action_nameses) {
		getPersistence().cacheResult(wfms_action_nameses);
	}

	/**
	* Creates a new WFMS_action_names with the primary key. Does not add the WFMS_action_names to the database.
	*
	* @param actionId the primary key for the new WFMS_action_names
	* @return the new WFMS_action_names
	*/
	public static WFMS_action_names create(java.lang.String actionId) {
		return getPersistence().create(actionId);
	}

	/**
	* Removes the WFMS_action_names with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names that was removed
	* @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	*/
	public static WFMS_action_names remove(java.lang.String actionId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_namesException {
		return getPersistence().remove(actionId);
	}

	public static WFMS_action_names updateImpl(
		WFMS_action_names wfms_action_names) {
		return getPersistence().updateImpl(wfms_action_names);
	}

	/**
	* Returns the WFMS_action_names with the primary key or throws a {@link NoSuchWFMS_action_namesException} if it could not be found.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names
	* @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	*/
	public static WFMS_action_names findByPrimaryKey(java.lang.String actionId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_namesException {
		return getPersistence().findByPrimaryKey(actionId);
	}

	/**
	* Returns the WFMS_action_names with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names, or <code>null</code> if a WFMS_action_names with the primary key could not be found
	*/
	public static WFMS_action_names fetchByPrimaryKey(java.lang.String actionId) {
		return getPersistence().fetchByPrimaryKey(actionId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_action_names> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_action_nameses.
	*
	* @return the WFMS_action_nameses
	*/
	public static List<WFMS_action_names> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @return the range of WFMS_action_nameses
	*/
	public static List<WFMS_action_names> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_action_nameses
	*/
	public static List<WFMS_action_names> findAll(int start, int end,
		OrderByComparator<WFMS_action_names> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_action_nameses
	*/
	public static List<WFMS_action_names> findAll(int start, int end,
		OrderByComparator<WFMS_action_names> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_action_nameses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_action_nameses.
	*
	* @return the number of WFMS_action_nameses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WFMS_action_namesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_action_namesPersistence, WFMS_action_namesPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_action_namesPersistence.class);
}