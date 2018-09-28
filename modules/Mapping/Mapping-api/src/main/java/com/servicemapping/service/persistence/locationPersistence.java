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

package com.servicemapping.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.servicemapping.exception.NoSuchlocationException;

import com.servicemapping.model.location;

/**
 * The persistence interface for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.servicemapping.service.persistence.impl.locationPersistenceImpl
 * @see locationUtil
 * @generated
 */
@ProviderType
public interface locationPersistence extends BasePersistence<location> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link locationUtil} to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching locations
	*/
	public java.util.List<location> findByUuid(java.lang.String uuid);

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
	public java.util.List<location> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<location> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

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
	public java.util.List<location> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public location findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator)
		throws NoSuchlocationException;

	/**
	* Returns the first location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	*/
	public location fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

	/**
	* Returns the last location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public location findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator)
		throws NoSuchlocationException;

	/**
	* Returns the last location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	*/
	public location fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

	/**
	* Returns the locations before and after the current location in the ordered set where uuid = &#63;.
	*
	* @param locationId the primary key of the current location
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next location
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public location[] findByUuid_PrevAndNext(long locationId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator)
		throws NoSuchlocationException;

	/**
	* Removes all the locations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching locations
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the location where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchlocationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public location findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchlocationException;

	/**
	* Returns the location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching location, or <code>null</code> if a matching location could not be found
	*/
	public location fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the location where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching location, or <code>null</code> if a matching location could not be found
	*/
	public location fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the location where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the location that was removed
	*/
	public location removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchlocationException;

	/**
	* Returns the number of locations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching locations
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the locations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching locations
	*/
	public java.util.List<location> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<location> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<location> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

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
	public java.util.List<location> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public location findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator)
		throws NoSuchlocationException;

	/**
	* Returns the first location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching location, or <code>null</code> if a matching location could not be found
	*/
	public location fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

	/**
	* Returns the last location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location
	* @throws NoSuchlocationException if a matching location could not be found
	*/
	public location findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator)
		throws NoSuchlocationException;

	/**
	* Returns the last location in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching location, or <code>null</code> if a matching location could not be found
	*/
	public location fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

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
	public location[] findByUuid_C_PrevAndNext(long locationId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator)
		throws NoSuchlocationException;

	/**
	* Removes all the locations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of locations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching locations
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the location in the entity cache if it is enabled.
	*
	* @param location the location
	*/
	public void cacheResult(location location);

	/**
	* Caches the locations in the entity cache if it is enabled.
	*
	* @param locations the locations
	*/
	public void cacheResult(java.util.List<location> locations);

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public location create(long locationId);

	/**
	* Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public location remove(long locationId) throws NoSuchlocationException;

	public location updateImpl(location location);

	/**
	* Returns the location with the primary key or throws a {@link NoSuchlocationException} if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public location findByPrimaryKey(long locationId)
		throws NoSuchlocationException;

	/**
	* Returns the location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location, or <code>null</code> if a location with the primary key could not be found
	*/
	public location fetchByPrimaryKey(long locationId);

	@Override
	public java.util.Map<java.io.Serializable, location> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the locations.
	*
	* @return the locations
	*/
	public java.util.List<location> findAll();

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
	public java.util.List<location> findAll(int start, int end);

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
	public java.util.List<location> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

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
	public java.util.List<location> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the locations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of courses associated with the location.
	*
	* @param pk the primary key of the location
	* @return long[] of the primaryKeys of courses associated with the location
	*/
	public long[] getcoursePrimaryKeys(long pk);

	/**
	* Returns all the courses associated with the location.
	*
	* @param pk the primary key of the location
	* @return the courses associated with the location
	*/
	public java.util.List<com.servicemapping.model.course> getcourses(long pk);

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
	public java.util.List<com.servicemapping.model.course> getcourses(long pk,
		int start, int end);

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
	public java.util.List<com.servicemapping.model.course> getcourses(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.course> orderByComparator);

	/**
	* Returns the number of courses associated with the location.
	*
	* @param pk the primary key of the location
	* @return the number of courses associated with the location
	*/
	public int getcoursesSize(long pk);

	/**
	* Returns <code>true</code> if the course is associated with the location.
	*
	* @param pk the primary key of the location
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the location; <code>false</code> otherwise
	*/
	public boolean containscourse(long pk, long coursePK);

	/**
	* Returns <code>true</code> if the location has any courses associated with it.
	*
	* @param pk the primary key of the location to check for associations with courses
	* @return <code>true</code> if the location has any courses associated with it; <code>false</code> otherwise
	*/
	public boolean containscourses(long pk);

	/**
	* Adds an association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePK the primary key of the course
	*/
	public void addcourse(long pk, long coursePK);

	/**
	* Adds an association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param course the course
	*/
	public void addcourse(long pk, com.servicemapping.model.course course);

	/**
	* Adds an association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePKs the primary keys of the courses
	*/
	public void addcourses(long pk, long[] coursePKs);

	/**
	* Adds an association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param courses the courses
	*/
	public void addcourses(long pk,
		java.util.List<com.servicemapping.model.course> courses);

	/**
	* Clears all associations between the location and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location to clear the associated courses from
	*/
	public void clearcourses(long pk);

	/**
	* Removes the association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePK the primary key of the course
	*/
	public void removecourse(long pk, long coursePK);

	/**
	* Removes the association between the location and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param course the course
	*/
	public void removecourse(long pk, com.servicemapping.model.course course);

	/**
	* Removes the association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePKs the primary keys of the courses
	*/
	public void removecourses(long pk, long[] coursePKs);

	/**
	* Removes the association between the location and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param courses the courses
	*/
	public void removecourses(long pk,
		java.util.List<com.servicemapping.model.course> courses);

	/**
	* Sets the courses associated with the location, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param coursePKs the primary keys of the courses to be associated with the location
	*/
	public void setcourses(long pk, long[] coursePKs);

	/**
	* Sets the courses associated with the location, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the location
	* @param courses the courses to be associated with the location
	*/
	public void setcourses(long pk,
		java.util.List<com.servicemapping.model.course> courses);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}