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

package com.all.ddtiservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.all.ddtiservice.model.location;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the location service. This utility wraps {@link com.all.ddtiservice.service.persistence.impl.locationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see locationPersistence
 * @see com.all.ddtiservice.service.persistence.impl.locationPersistenceImpl
 * @generated
 */
@ProviderType
public class locationUtil {
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
	public static void clearCache(location location) {
		getPersistence().clearCache(location);
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
	public static List<location> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<location> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static location update(location location) {
		return getPersistence().update(location);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static location update(location location,
		ServiceContext serviceContext) {
		return getPersistence().update(location, serviceContext);
	}

	/**
	* Returns all the locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching locations
	*/
	public static List<location> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the locations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of matching locations
	*/
	public static List<location> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the locations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locations
	*/
	public static List<location> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<location> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the locations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching locations
	*/
	public static List<location> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<location> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public static location findByUuid_First(java.lang.String uuid,
		OrderByComparator<location> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	*/
	public static location fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<location> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public static location findByUuid_Last(java.lang.String uuid,
		OrderByComparator<location> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	*/
	public static location fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<location> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the locations before and after the current location in the ordered set where uuid = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public static location[] findByUuid_PrevAndNext(long locationId,
		java.lang.String uuid, OrderByComparator<location> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(locationId, uuid, orderByComparator);
	}

	/**
	* Removes all the locations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching locations
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the location where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchlocationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public static location findByUUID_G(java.lang.String uuid, long groupId)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching location, or <code>null</code> if a matching location could not be found
	*/
	public static location fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching location, or <code>null</code> if a matching location could not be found
	*/
	public static location fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the location where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the location that was removed
	*/
	public static location removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of locations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching locations
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the locations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching locations
	*/
	public static List<location> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the locations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of matching locations
	*/
	public static List<location> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the locations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching locations
	*/
	public static List<location> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<location> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the locations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching locations
	*/
	public static List<location> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<location> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public static location findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<location> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	*/
	public static location fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<location> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public static location findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<location> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	*/
	public static location fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<location> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the locations before and after the current location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public static location[] findByUuid_C_PrevAndNext(long locationId,
		java.lang.String uuid, long companyId,
		OrderByComparator<location> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(locationId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the locations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of locations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching locations
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the location in the entity cache if it is enabled.
	*
	* @param location the location
	*/
	public static void cacheResult(location location) {
		getPersistence().cacheResult(location);
	}

	/**
	* Caches the locations in the entity cache if it is enabled.
	*
	* @param locations the locations
	*/
	public static void cacheResult(List<location> locations) {
		getPersistence().cacheResult(locations);
	}

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public static location create(long locationId) {
		return getPersistence().create(locationId);
	}

	/**
	* Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public static location remove(long locationId)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence().remove(locationId);
	}

	public static location updateImpl(location location) {
		return getPersistence().updateImpl(location);
	}

	/**
	* Returns the location with the primary key or throws a {@link NoSuchlocationException} if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public static location findByPrimaryKey(long locationId)
		throws com.all.ddtiservice.exception.NoSuchlocationException {
		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	* Returns the location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location, or <code>null</code> if a location with the primary key could not be found
	*/
	public static location fetchByPrimaryKey(long locationId) {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	public static java.util.Map<java.io.Serializable, location> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the locations.
	*
	* @return the locations
	*/
	public static List<location> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	*/
	public static List<location> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locations
	*/
	public static List<location> findAll(int start, int end,
		OrderByComparator<location> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of locations
	*/
	public static List<location> findAll(int start, int end,
		OrderByComparator<location> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the locations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of courses associated with the location.
	*
	* @param pk the primary key of the location
	* @return long[] of the primaryKeys of courses associated with the location
	*/
	public static long[] getcoursePrimaryKeys(long pk) {
		return getPersistence().getcoursePrimaryKeys(pk);
	}

	/**
	* Returns all the courses associated with the location.
	*
	* @param pk the primary key of the location
	* @return the courses associated with the location
	*/
	public static List<com.all.ddtiservice.model.course> getcourses(long pk) {
		return getPersistence().getcourses(pk);
	}

	/**
	* Returns a range of all the courses associated with the location.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the location
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of courses associated with the location
	*/
	public static List<com.all.ddtiservice.model.course> getcourses(long pk,
		int start, int end) {
		return getPersistence().getcourses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the courses associated with the location.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the location
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses associated with the location
	*/
	public static List<com.all.ddtiservice.model.course> getcourses(long pk,
		int start, int end,
		OrderByComparator<com.all.ddtiservice.model.course> orderByComparator) {
		return getPersistence().getcourses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of courses associated with the location.
	*
	* @param pk the primary key of the location
	* @return the number of courses associated with the location
	*/
	public static int getcoursesSize(long pk) {
		return getPersistence().getcoursesSize(pk);
	}

	/**
	* Returns <code>true</code> if the course is associated with the location.
	*
	* @param pk the primary key of the location
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the location; <code>false</code> otherwise
	*/
	public static boolean containscourse(long pk, long coursePK) {
		return getPersistence().containscourse(pk, coursePK);
	}

	/**
	* Returns <code>true</code> if the location has any courses associated with it.
	*
	* @param pk the primary key of the location to check for associations with courses
	* @return <code>true</code> if the location has any courses associated with it; <code>false</code> otherwise
	*/
	public static boolean containscourses(long pk) {
		return getPersistence().containscourses(pk);
	}

	/**
	* Adds an association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePK the primary key of the course
	*/
	public static void addcourse(long pk, long coursePK) {
		getPersistence().addcourse(pk, coursePK);
	}

	/**
	* Adds an association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param course the course
	*/
	public static void addcourse(long pk,
		com.all.ddtiservice.model.course course) {
		getPersistence().addcourse(pk, course);
	}

	/**
	* Adds an association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePKs the primary keys of the courses
	*/
	public static void addcourses(long pk, long[] coursePKs) {
		getPersistence().addcourses(pk, coursePKs);
	}

	/**
	* Adds an association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param courses the courses
	*/
	public static void addcourses(long pk,
		List<com.all.ddtiservice.model.course> courses) {
		getPersistence().addcourses(pk, courses);
	}

	/**
	* Clears all associations between the location and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location to clear the associated courses from
	*/
	public static void clearcourses(long pk) {
		getPersistence().clearcourses(pk);
	}

	/**
	* Removes the association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePK the primary key of the course
	*/
	public static void removecourse(long pk, long coursePK) {
		getPersistence().removecourse(pk, coursePK);
	}

	/**
	* Removes the association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param course the course
	*/
	public static void removecourse(long pk,
		com.all.ddtiservice.model.course course) {
		getPersistence().removecourse(pk, course);
	}

	/**
	* Removes the association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePKs the primary keys of the courses
	*/
	public static void removecourses(long pk, long[] coursePKs) {
		getPersistence().removecourses(pk, coursePKs);
	}

	/**
	* Removes the association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param courses the courses
	*/
	public static void removecourses(long pk,
		List<com.all.ddtiservice.model.course> courses) {
		getPersistence().removecourses(pk, courses);
	}

	/**
	* Sets the courses associated with the location, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePKs the primary keys of the courses to be associated with the location
	*/
	public static void setcourses(long pk, long[] coursePKs) {
		getPersistence().setcourses(pk, coursePKs);
	}

	/**
	* Sets the courses associated with the location, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param courses the courses to be associated with the location
	*/
	public static void setcourses(long pk,
		List<com.all.ddtiservice.model.course> courses) {
		getPersistence().setcourses(pk, courses);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static locationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<locationPersistence, locationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(locationPersistence.class);
}