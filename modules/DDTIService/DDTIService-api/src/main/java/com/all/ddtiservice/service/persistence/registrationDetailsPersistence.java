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

import com.all.ddtiservice.exception.NoSuchregistrationDetailsException;
import com.all.ddtiservice.model.registrationDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the registration details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.all.ddtiservice.service.persistence.impl.registrationDetailsPersistenceImpl
 * @see registrationDetailsUtil
 * @generated
 */
@ProviderType
public interface registrationDetailsPersistence extends BasePersistence<registrationDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link registrationDetailsUtil} to access the registration details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the registration detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching registration detailses
	*/
	public java.util.List<registrationDetails> findByUuid(java.lang.String uuid);

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
	public java.util.List<registrationDetails> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<registrationDetails> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

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
	public java.util.List<registrationDetails> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public registrationDetails findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException;

	/**
	* Returns the first registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public registrationDetails fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

	/**
	* Returns the last registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public registrationDetails findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException;

	/**
	* Returns the last registration details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public registrationDetails fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

	/**
	* Returns the registration detailses before and after the current registration details in the ordered set where uuid = &#63;.
	*
	* @param registrationId the primary key of the current registration details
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next registration details
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public registrationDetails[] findByUuid_PrevAndNext(long registrationId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException;

	/**
	* Removes all the registration detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of registration detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching registration detailses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the registration details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchregistrationDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public registrationDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchregistrationDetailsException;

	/**
	* Returns the registration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public registrationDetails fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the registration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public registrationDetails fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache);

	/**
	* Removes the registration details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the registration details that was removed
	*/
	public registrationDetails removeByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchregistrationDetailsException;

	/**
	* Returns the number of registration detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching registration detailses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching registration detailses
	*/
	public java.util.List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId);

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
	public java.util.List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

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
	public java.util.List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

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
	public java.util.List<registrationDetails> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public registrationDetails findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException;

	/**
	* Returns the first registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public registrationDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

	/**
	* Returns the last registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details
	* @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	*/
	public registrationDetails findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException;

	/**
	* Returns the last registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public registrationDetails fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

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
	public registrationDetails[] findByUuid_C_PrevAndNext(long registrationId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException;

	/**
	* Removes all the registration detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of registration detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching registration detailses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the registration details in the entity cache if it is enabled.
	*
	* @param registrationDetails the registration details
	*/
	public void cacheResult(registrationDetails registrationDetails);

	/**
	* Caches the registration detailses in the entity cache if it is enabled.
	*
	* @param registrationDetailses the registration detailses
	*/
	public void cacheResult(
		java.util.List<registrationDetails> registrationDetailses);

	/**
	* Creates a new registration details with the primary key. Does not add the registration details to the database.
	*
	* @param registrationId the primary key for the new registration details
	* @return the new registration details
	*/
	public registrationDetails create(long registrationId);

	/**
	* Removes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details that was removed
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public registrationDetails remove(long registrationId)
		throws NoSuchregistrationDetailsException;

	public registrationDetails updateImpl(
		registrationDetails registrationDetails);

	/**
	* Returns the registration details with the primary key or throws a {@link NoSuchregistrationDetailsException} if it could not be found.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details
	* @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	*/
	public registrationDetails findByPrimaryKey(long registrationId)
		throws NoSuchregistrationDetailsException;

	/**
	* Returns the registration details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details, or <code>null</code> if a registration details with the primary key could not be found
	*/
	public registrationDetails fetchByPrimaryKey(long registrationId);

	@Override
	public java.util.Map<java.io.Serializable, registrationDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the registration detailses.
	*
	* @return the registration detailses
	*/
	public java.util.List<registrationDetails> findAll();

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
	public java.util.List<registrationDetails> findAll(int start, int end);

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
	public java.util.List<registrationDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator);

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
	public java.util.List<registrationDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<registrationDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the registration detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of registration detailses.
	*
	* @return the number of registration detailses
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of courses associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @return long[] of the primaryKeys of courses associated with the registration details
	*/
	public long[] getcoursePrimaryKeys(long pk);

	/**
	* Returns all the courses associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @return the courses associated with the registration details
	*/
	public java.util.List<com.all.ddtiservice.model.course> getcourses(long pk);

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
	public java.util.List<com.all.ddtiservice.model.course> getcourses(
		long pk, int start, int end);

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
	public java.util.List<com.all.ddtiservice.model.course> getcourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.course> orderByComparator);

	/**
	* Returns the number of courses associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @return the number of courses associated with the registration details
	*/
	public int getcoursesSize(long pk);

	/**
	* Returns <code>true</code> if the course is associated with the registration details.
	*
	* @param pk the primary key of the registration details
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the registration details; <code>false</code> otherwise
	*/
	public boolean containscourse(long pk, long coursePK);

	/**
	* Returns <code>true</code> if the registration details has any courses associated with it.
	*
	* @param pk the primary key of the registration details to check for associations with courses
	* @return <code>true</code> if the registration details has any courses associated with it; <code>false</code> otherwise
	*/
	public boolean containscourses(long pk);

	/**
	* Adds an association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePK the primary key of the course
	*/
	public void addcourse(long pk, long coursePK);

	/**
	* Adds an association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param course the course
	*/
	public void addcourse(long pk, com.all.ddtiservice.model.course course);

	/**
	* Adds an association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePKs the primary keys of the courses
	*/
	public void addcourses(long pk, long[] coursePKs);

	/**
	* Adds an association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param courses the courses
	*/
	public void addcourses(long pk,
		java.util.List<com.all.ddtiservice.model.course> courses);

	/**
	* Clears all associations between the registration details and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details to clear the associated courses from
	*/
	public void clearcourses(long pk);

	/**
	* Removes the association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePK the primary key of the course
	*/
	public void removecourse(long pk, long coursePK);

	/**
	* Removes the association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param course the course
	*/
	public void removecourse(long pk, com.all.ddtiservice.model.course course);

	/**
	* Removes the association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePKs the primary keys of the courses
	*/
	public void removecourses(long pk, long[] coursePKs);

	/**
	* Removes the association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param courses the courses
	*/
	public void removecourses(long pk,
		java.util.List<com.all.ddtiservice.model.course> courses);

	/**
	* Sets the courses associated with the registration details, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param coursePKs the primary keys of the courses to be associated with the registration details
	*/
	public void setcourses(long pk, long[] coursePKs);

	/**
	* Sets the courses associated with the registration details, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the registration details
	* @param courses the courses to be associated with the registration details
	*/
	public void setcourses(long pk,
		java.util.List<com.all.ddtiservice.model.course> courses);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}