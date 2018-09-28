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

import com.all.ddtiservice.model.registrationDetails;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the registration details service. This utility wraps {@link com.all.ddtiservice.service.persistence.impl.registrationDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsPersistence
 * @see com.all.ddtiservice.service.persistence.impl.registrationDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class registrationDetailsUtil {
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
	public static void clearCache(registrationDetails registrationDetails) {
		getPersistence().clearCache(registrationDetails);
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
	public static List<registrationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<registrationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<registrationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static registrationDetails update(
		registrationDetails registrationDetails) {
		return getPersistence().update(registrationDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static registrationDetails update(
		registrationDetails registrationDetails, ServiceContext serviceContext) {
		return getPersistence().update(registrationDetails, serviceContext);
	}

	/**
	* Returns all the registration detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching registration detailses
	*/
	public static List<registrationDetails> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the registration detailses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @return the range of matching registration detailses
	*/
	public static List<registrationDetails> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the registration detailses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching registration detailses
	*/
	public static List<registrationDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the registration detailses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching registration detailses
	*/
	public static List<registrationDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<registrationDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public static registrationDetails findByUuid_First(java.lang.String uuid,
		OrderByComparator<registrationDetails> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static registrationDetails fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public static registrationDetails findByUuid_Last(java.lang.String uuid,
		OrderByComparator<registrationDetails> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static registrationDetails fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the registration detailses before and after the current registration details in the ordered set where uuid = &#63;.
	*
	* @param registrationId the primary key of the current registration details
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next registration details
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public static registrationDetails[] findByUuid_PrevAndNext(
		long registrationId, java.lang.String uuid,
		OrderByComparator<registrationDetails> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(registrationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the registration detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of registration detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching registration detailses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the registration details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchregistrationDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public static registrationDetails findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the registration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static registrationDetails fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the registration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static registrationDetails fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the registration details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the registration details that was removed
	*/
	public static registrationDetails removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of registration detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching registration detailses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching registration detailses
	*/
	public static List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @return the range of matching registration detailses
	*/
	public static List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching registration detailses
	*/
	public static List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching registration detailses
	*/
	public static List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<registrationDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public static registrationDetails findByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static registrationDetails fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public static registrationDetails findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<registrationDetails> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static registrationDetails fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the registration detailses before and after the current registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param registrationId the primary key of the current registration details
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next registration details
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public static registrationDetails[] findByUuid_C_PrevAndNext(
		long registrationId, java.lang.String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(registrationId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the registration detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching registration detailses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the registration details in the entity cache if it is enabled.
	*
	* @param registrationDetails the registration details
	*/
	public static void cacheResult(registrationDetails registrationDetails) {
		getPersistence().cacheResult(registrationDetails);
	}

	/**
	* Caches the registration detailses in the entity cache if it is enabled.
	*
	* @param registrationDetailses the registration detailses
	*/
	public static void cacheResult(
		List<registrationDetails> registrationDetailses) {
		getPersistence().cacheResult(registrationDetailses);
	}

	/**
	* Creates a new registration details with the primary key. Does not add the registration details to the database.
	*
	* @param registrationId the primary key for the new registration details
	* @return the new registration details
	*/
	public static registrationDetails create(long registrationId) {
		return getPersistence().create(registrationId);
	}

	/**
	* Removes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details that was removed
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public static registrationDetails remove(long registrationId)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence().remove(registrationId);
	}

	public static registrationDetails updateImpl(
		registrationDetails registrationDetails) {
		return getPersistence().updateImpl(registrationDetails);
	}

	/**
	* Returns the registration details with the primary key or throws a {@link NoSuchregistrationDetailsException} if it could not be found.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public static registrationDetails findByPrimaryKey(long registrationId)
		throws com.all.ddtiservice.exception.NoSuchregistrationDetailsException {
		return getPersistence().findByPrimaryKey(registrationId);
	}

	/**
	* Returns the registration details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details, or <code>null</code> if a registration details with the primary key could not be found
	*/
	public static registrationDetails fetchByPrimaryKey(long registrationId) {
		return getPersistence().fetchByPrimaryKey(registrationId);
	}

	public static java.util.Map<java.io.Serializable, registrationDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the registration detailses.
	*
	* @return the registration detailses
	*/
	public static List<registrationDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the registration detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @return the range of registration detailses
	*/
	public static List<registrationDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the registration detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of registration detailses
	*/
	public static List<registrationDetails> findAll(int start, int end,
		OrderByComparator<registrationDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the registration detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of registration detailses
	*/
	public static List<registrationDetails> findAll(int start, int end,
		OrderByComparator<registrationDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the registration detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of registration detailses.
	*
	* @return the number of registration detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of courses associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @return long[] of the primaryKeys of courses associated with the registration details
	*/
	public static long[] getcoursePrimaryKeys(long pk) {
		return getPersistence().getcoursePrimaryKeys(pk);
	}

	/**
	* Returns all the courses associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @return the courses associated with the registration details
	*/
	public static List<com.all.ddtiservice.model.course> getcourses(long pk) {
		return getPersistence().getcourses(pk);
	}

	/**
	* Returns a range of all the courses associated with the registration details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the registration details
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @return the range of courses associated with the registration details
	*/
	public static List<com.all.ddtiservice.model.course> getcourses(long pk,
		int start, int end) {
		return getPersistence().getcourses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the courses associated with the registration details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the registration details
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses associated with the registration details
	*/
	public static List<com.all.ddtiservice.model.course> getcourses(long pk,
		int start, int end,
		OrderByComparator<com.all.ddtiservice.model.course> orderByComparator) {
		return getPersistence().getcourses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of courses associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @return the number of courses associated with the registration details
	*/
	public static int getcoursesSize(long pk) {
		return getPersistence().getcoursesSize(pk);
	}

	/**
	* Returns <code>true</code> if the course is associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the registration details; <code>false</code> otherwise
	*/
	public static boolean containscourse(long pk, long coursePK) {
		return getPersistence().containscourse(pk, coursePK);
	}

	/**
	* Returns <code>true</code> if the registration details has any courses associated with it.
	*
	* @param pk the primary key of the registration details to check for associations with courses
	* @return <code>true</code> if the registration details has any courses associated with it; <code>false</code> otherwise
	*/
	public static boolean containscourses(long pk) {
		return getPersistence().containscourses(pk);
	}

	/**
	* Adds an association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePK the primary key of the course
	*/
	public static void addcourse(long pk, long coursePK) {
		getPersistence().addcourse(pk, coursePK);
	}

	/**
	* Adds an association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param course the course
	*/
	public static void addcourse(long pk,
		com.all.ddtiservice.model.course course) {
		getPersistence().addcourse(pk, course);
	}

	/**
	* Adds an association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePKs the primary keys of the courses
	*/
	public static void addcourses(long pk, long[] coursePKs) {
		getPersistence().addcourses(pk, coursePKs);
	}

	/**
	* Adds an association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param courses the courses
	*/
	public static void addcourses(long pk,
		List<com.all.ddtiservice.model.course> courses) {
		getPersistence().addcourses(pk, courses);
	}

	/**
	* Clears all associations between the registration details and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details to clear the associated courses from
	*/
	public static void clearcourses(long pk) {
		getPersistence().clearcourses(pk);
	}

	/**
	* Removes the association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePK the primary key of the course
	*/
	public static void removecourse(long pk, long coursePK) {
		getPersistence().removecourse(pk, coursePK);
	}

	/**
	* Removes the association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param course the course
	*/
	public static void removecourse(long pk,
		com.all.ddtiservice.model.course course) {
		getPersistence().removecourse(pk, course);
	}

	/**
	* Removes the association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePKs the primary keys of the courses
	*/
	public static void removecourses(long pk, long[] coursePKs) {
		getPersistence().removecourses(pk, coursePKs);
	}

	/**
	* Removes the association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param courses the courses
	*/
	public static void removecourses(long pk,
		List<com.all.ddtiservice.model.course> courses) {
		getPersistence().removecourses(pk, courses);
	}

	/**
	* Sets the courses associated with the registration details, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePKs the primary keys of the courses to be associated with the registration details
	*/
	public static void setcourses(long pk, long[] coursePKs) {
		getPersistence().setcourses(pk, coursePKs);
	}

	/**
	* Sets the courses associated with the registration details, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param courses the courses to be associated with the registration details
	*/
	public static void setcourses(long pk,
		List<com.all.ddtiservice.model.course> courses) {
		getPersistence().setcourses(pk, courses);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static registrationDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<registrationDetailsPersistence, registrationDetailsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(registrationDetailsPersistence.class);
}