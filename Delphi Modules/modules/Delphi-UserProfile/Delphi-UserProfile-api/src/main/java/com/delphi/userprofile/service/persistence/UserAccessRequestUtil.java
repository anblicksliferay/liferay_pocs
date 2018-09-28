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

import com.delphi.userprofile.model.UserAccessRequest;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user access request service. This utility wraps {@link com.delphi.userprofile.service.persistence.impl.UserAccessRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequestPersistence
 * @see com.delphi.userprofile.service.persistence.impl.UserAccessRequestPersistenceImpl
 * @generated
 */
@ProviderType
public class UserAccessRequestUtil {
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
	public static void clearCache(UserAccessRequest userAccessRequest) {
		getPersistence().clearCache(userAccessRequest);
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
	public static List<UserAccessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserAccessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserAccessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserAccessRequest update(UserAccessRequest userAccessRequest) {
		return getPersistence().update(userAccessRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserAccessRequest update(
		UserAccessRequest userAccessRequest, ServiceContext serviceContext) {
		return getPersistence().update(userAccessRequest, serviceContext);
	}

	/**
	* Returns all the user access requests where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user access requests
	*/
	public static List<UserAccessRequest> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<UserAccessRequest> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<UserAccessRequest> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<UserAccessRequest> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByUuid_First(java.lang.String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where uuid = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public static UserAccessRequest[] findByUuid_PrevAndNext(long requestId,
		java.lang.String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByUuid_PrevAndNext(requestId, uuid, orderByComparator);
	}

	/**
	* Removes all the user access requests where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user access requests where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user access requests
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the user access requests where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user access requests
	*/
	public static List<UserAccessRequest> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<UserAccessRequest> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<UserAccessRequest> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<UserAccessRequest> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static UserAccessRequest[] findByUuid_C_PrevAndNext(long requestId,
		java.lang.String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(requestId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the user access requests where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of user access requests where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user access requests
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the user access requests where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user access requests
	*/
	public static List<UserAccessRequest> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

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
	public static List<UserAccessRequest> findByUserId(long userId, int start,
		int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static List<UserAccessRequest> findByUserId(long userId, int start,
		int end, OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

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
	public static List<UserAccessRequest> findByUserId(long userId, int start,
		int end, OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByUserId_First(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByUserId_First(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByUserId_Last(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByUserId_Last(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where userId = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public static UserAccessRequest[] findByUserId_PrevAndNext(long requestId,
		long userId, OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByUserId_PrevAndNext(requestId, userId,
			orderByComparator);
	}

	/**
	* Removes all the user access requests where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of user access requests where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user access requests
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the user access requests where activeState = &#63;.
	*
	* @param activeState the active state
	* @return the matching user access requests
	*/
	public static List<UserAccessRequest> findByActiveState(int activeState) {
		return getPersistence().findByActiveState(activeState);
	}

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
	public static List<UserAccessRequest> findByActiveState(int activeState,
		int start, int end) {
		return getPersistence().findByActiveState(activeState, start, end);
	}

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
	public static List<UserAccessRequest> findByActiveState(int activeState,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .findByActiveState(activeState, start, end, orderByComparator);
	}

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
	public static List<UserAccessRequest> findByActiveState(int activeState,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByActiveState(activeState, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByActiveState_First(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByActiveState_First(activeState, orderByComparator);
	}

	/**
	* Returns the first user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByActiveState_First(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .fetchByActiveState_First(activeState, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request
	* @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	*/
	public static UserAccessRequest findByActiveState_Last(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByActiveState_Last(activeState, orderByComparator);
	}

	/**
	* Returns the last user access request in the ordered set where activeState = &#63;.
	*
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static UserAccessRequest fetchByActiveState_Last(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence()
				   .fetchByActiveState_Last(activeState, orderByComparator);
	}

	/**
	* Returns the user access requests before and after the current user access request in the ordered set where activeState = &#63;.
	*
	* @param requestId the primary key of the current user access request
	* @param activeState the active state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public static UserAccessRequest[] findByActiveState_PrevAndNext(
		long requestId, int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence()
				   .findByActiveState_PrevAndNext(requestId, activeState,
			orderByComparator);
	}

	/**
	* Removes all the user access requests where activeState = &#63; from the database.
	*
	* @param activeState the active state
	*/
	public static void removeByActiveState(int activeState) {
		getPersistence().removeByActiveState(activeState);
	}

	/**
	* Returns the number of user access requests where activeState = &#63;.
	*
	* @param activeState the active state
	* @return the number of matching user access requests
	*/
	public static int countByActiveState(int activeState) {
		return getPersistence().countByActiveState(activeState);
	}

	/**
	* Caches the user access request in the entity cache if it is enabled.
	*
	* @param userAccessRequest the user access request
	*/
	public static void cacheResult(UserAccessRequest userAccessRequest) {
		getPersistence().cacheResult(userAccessRequest);
	}

	/**
	* Caches the user access requests in the entity cache if it is enabled.
	*
	* @param userAccessRequests the user access requests
	*/
	public static void cacheResult(List<UserAccessRequest> userAccessRequests) {
		getPersistence().cacheResult(userAccessRequests);
	}

	/**
	* Creates a new user access request with the primary key. Does not add the user access request to the database.
	*
	* @param requestId the primary key for the new user access request
	* @return the new user access request
	*/
	public static UserAccessRequest create(long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	* Removes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request that was removed
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public static UserAccessRequest remove(long requestId)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence().remove(requestId);
	}

	public static UserAccessRequest updateImpl(
		UserAccessRequest userAccessRequest) {
		return getPersistence().updateImpl(userAccessRequest);
	}

	/**
	* Returns the user access request with the primary key or throws a {@link NoSuchUserAccessRequestException} if it could not be found.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request
	* @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	*/
	public static UserAccessRequest findByPrimaryKey(long requestId)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException {
		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	* Returns the user access request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request, or <code>null</code> if a user access request with the primary key could not be found
	*/
	public static UserAccessRequest fetchByPrimaryKey(long requestId) {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	public static java.util.Map<java.io.Serializable, UserAccessRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user access requests.
	*
	* @return the user access requests
	*/
	public static List<UserAccessRequest> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserAccessRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserAccessRequest> findAll(int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserAccessRequest> findAll(int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user access requests from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user access requests.
	*
	* @return the number of user access requests
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserAccessRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserAccessRequestPersistence, UserAccessRequestPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserAccessRequestPersistence.class);
}