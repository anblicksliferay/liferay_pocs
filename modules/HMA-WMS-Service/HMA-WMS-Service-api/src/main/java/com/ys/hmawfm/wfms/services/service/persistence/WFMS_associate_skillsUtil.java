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

import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_associate_skills service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_associate_skillsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skillsPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_associate_skillsPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_associate_skillsUtil {
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
	public static void clearCache(WFMS_associate_skills wfms_associate_skills) {
		getPersistence().clearCache(wfms_associate_skills);
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
	public static List<WFMS_associate_skills> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_associate_skills> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_associate_skills> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_associate_skills> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_associate_skills update(
		WFMS_associate_skills wfms_associate_skills) {
		return getPersistence().update(wfms_associate_skills);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_associate_skills update(
		WFMS_associate_skills wfms_associate_skills,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_associate_skills, serviceContext);
	}

	/**
	* Caches the WFMS_associate_skills in the entity cache if it is enabled.
	*
	* @param wfms_associate_skills the WFMS_associate_skills
	*/
	public static void cacheResult(WFMS_associate_skills wfms_associate_skills) {
		getPersistence().cacheResult(wfms_associate_skills);
	}

	/**
	* Caches the WFMS_associate_skillses in the entity cache if it is enabled.
	*
	* @param wfms_associate_skillses the WFMS_associate_skillses
	*/
	public static void cacheResult(
		List<WFMS_associate_skills> wfms_associate_skillses) {
		getPersistence().cacheResult(wfms_associate_skillses);
	}

	/**
	* Creates a new WFMS_associate_skills with the primary key. Does not add the WFMS_associate_skills to the database.
	*
	* @param associate_number the primary key for the new WFMS_associate_skills
	* @return the new WFMS_associate_skills
	*/
	public static WFMS_associate_skills create(
		java.lang.String associate_number) {
		return getPersistence().create(associate_number);
	}

	/**
	* Removes the WFMS_associate_skills with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associate_number the primary key of the WFMS_associate_skills
	* @return the WFMS_associate_skills that was removed
	* @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	*/
	public static WFMS_associate_skills remove(
		java.lang.String associate_number)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skillsException {
		return getPersistence().remove(associate_number);
	}

	public static WFMS_associate_skills updateImpl(
		WFMS_associate_skills wfms_associate_skills) {
		return getPersistence().updateImpl(wfms_associate_skills);
	}

	/**
	* Returns the WFMS_associate_skills with the primary key or throws a {@link NoSuchWFMS_associate_skillsException} if it could not be found.
	*
	* @param associate_number the primary key of the WFMS_associate_skills
	* @return the WFMS_associate_skills
	* @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	*/
	public static WFMS_associate_skills findByPrimaryKey(
		java.lang.String associate_number)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skillsException {
		return getPersistence().findByPrimaryKey(associate_number);
	}

	/**
	* Returns the WFMS_associate_skills with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param associate_number the primary key of the WFMS_associate_skills
	* @return the WFMS_associate_skills, or <code>null</code> if a WFMS_associate_skills with the primary key could not be found
	*/
	public static WFMS_associate_skills fetchByPrimaryKey(
		java.lang.String associate_number) {
		return getPersistence().fetchByPrimaryKey(associate_number);
	}

	public static java.util.Map<java.io.Serializable, WFMS_associate_skills> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_associate_skillses.
	*
	* @return the WFMS_associate_skillses
	*/
	public static List<WFMS_associate_skills> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_associate_skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skillses
	* @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	* @return the range of WFMS_associate_skillses
	*/
	public static List<WFMS_associate_skills> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_associate_skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skillses
	* @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_associate_skillses
	*/
	public static List<WFMS_associate_skills> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_associate_skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skillses
	* @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_associate_skillses
	*/
	public static List<WFMS_associate_skills> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_associate_skillses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_associate_skillses.
	*
	* @return the number of WFMS_associate_skillses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WFMS_associate_skillsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_associate_skillsPersistence, WFMS_associate_skillsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_associate_skillsPersistence.class);
}