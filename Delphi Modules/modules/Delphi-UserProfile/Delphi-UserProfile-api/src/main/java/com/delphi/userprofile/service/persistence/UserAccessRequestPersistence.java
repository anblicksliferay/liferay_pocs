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

package com.delphi.userprofile.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.delphi.userprofile.exception.NoSuchUserAccessRequestException;
import com.delphi.userprofile.model.UserAccessRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user access request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.delphi.userprofile.service.persistence.impl.UserAccessRequestPersistenceImpl
 * @see UserAccessRequestUtil
 * @generated
 */
@ProviderType
public interface UserAccessRequestPersistence extends BasePersistence<UserAccessRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserAccessRequestUtil} to access the user access request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user access requests where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the user access requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the user access requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns an ordered range of all the user access requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the first user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the last user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the last user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where uuid = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public UserAccessRequest[] findByUuid_PrevAndNext(long requestId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Removes all the user access requests where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of user access requests where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user access requests
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the user access requests where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid_C(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of all the user access requests where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

	/**
	* Returns an ordered range of all the user access requests where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns an ordered range of all the user access requests where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the first user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the last user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the last user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public UserAccessRequest[] findByUuid_C_PrevAndNext(long requestId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Removes all the user access requests where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of user access requests where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user access requests
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the user access requests where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUserId(long userId);

	/**
	* Returns a range of all the user access requests where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUserId(long userId,
		int start, int end);

	/**
	* Returns an ordered range of all the user access requests where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns an ordered range of all the user access requests where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the first user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the last user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the last user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where userId = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public UserAccessRequest[] findByUserId_PrevAndNext(long requestId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Removes all the user access requests where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of user access requests where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user access requests
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the user access requests where activeState = &#63;.
	*
	* @param activeState the active state
	* @return the matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByActiveState(int activeState);

	/**
	* Returns a range of all the user access requests where activeState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activeState the active state
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByActiveState(
		int activeState, int start, int end);

	/**
	* Returns an ordered range of all the user access requests where activeState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activeState the active state
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByActiveState(
		int activeState, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns an ordered range of all the user access requests where activeState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activeState the active state
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user access requests
	*/
	public java.util.List<UserAccessRequest> findByActiveState(
		int activeState, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByActiveState_First(int activeState,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the first user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByActiveState_First(int activeState,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the last user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public UserAccessRequest findByActiveState_Last(int activeState,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the last user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public UserAccessRequest fetchByActiveState_Last(int activeState,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where activeState = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public UserAccessRequest[] findByActiveState_PrevAndNext(long requestId,
		int activeState,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException;

	/**
	* Removes all the user access requests where activeState = &#63; from the database.
	*
	* @param activeState the active state
	*/
	public void removeByActiveState(int activeState);

	/**
	* Returns the number of user access requests where activeState = &#63;.
	*
	* @param activeState the active state
	* @return the number of matching user access requests
	*/
	public int countByActiveState(int activeState);

	/**
	* Caches the user access request in the entity cache if it is enabled.
	*
	* @param userAccessRequest the user access request
	*/
	public void cacheResult(UserAccessRequest userAccessRequest);

	/**
	* Caches the user access requests in the entity cache if it is enabled.
	*
	* @param userAccessRequests the user access requests
	*/
	public void cacheResult(
		java.util.List<UserAccessRequest> userAccessRequests);

	/**
	* Creates a new user access request with the primary key. Does not add the user access request to the database.
	*
	* @param requestId the primary key for the new user access request
	* @return the new user access request
	*/
	public UserAccessRequest create(long requestId);

	/**
	* Removes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request that was removed
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public UserAccessRequest remove(long requestId)
		throws NoSuchUserAccessRequestException;

	public UserAccessRequest updateImpl(UserAccessRequest userAccessRequest);

	/**
	* Returns the user access request with the primary key or throws a {@link NoSuchUserAccessRequestException} if it could not be found.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public UserAccessRequest findByPrimaryKey(long requestId)
		throws NoSuchUserAccessRequestException;

	/**
	* Returns the user access request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request, or <code>null</code> if a user access request with the primary key could not be found
	*/
	public UserAccessRequest fetchByPrimaryKey(long requestId);

	@Override
	public java.util.Map<java.io.Serializable, UserAccessRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user access requests.
	*
	* @return the user access requests
	*/
	public java.util.List<UserAccessRequest> findAll();

	/**
	* Returns a range of all the user access requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of user access requests
	*/
	public java.util.List<UserAccessRequest> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user access requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user access requests
	*/
	public java.util.List<UserAccessRequest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator);

	/**
	* Returns an ordered range of all the user access requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user access requests
	*/
	public java.util.List<UserAccessRequest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user access requests from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user access requests.
	*
	* @return the number of user access requests
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}