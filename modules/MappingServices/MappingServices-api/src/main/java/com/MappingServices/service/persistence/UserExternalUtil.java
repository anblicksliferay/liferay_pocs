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

package com.MappingServices.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.MappingServices.model.UserExternal;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user external service. This utility wraps {@link com.MappingServices.service.persistence.impl.UserExternalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalPersistence
 * @see com.MappingServices.service.persistence.impl.UserExternalPersistenceImpl
 * @generated
 */
@ProviderType
public class UserExternalUtil {
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
	public static void clearCache(UserExternal userExternal) {
		getPersistence().clearCache(userExternal);
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
	public static List<UserExternal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserExternal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserExternal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserExternal update(UserExternal userExternal) {
		return getPersistence().update(userExternal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserExternal update(UserExternal userExternal,
		ServiceContext serviceContext) {
		return getPersistence().update(userExternal, serviceContext);
	}

	/**
	* Returns all the user externals where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user externals
	*/
	public static List<UserExternal> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the user externals where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @return the range of matching user externals
	*/
	public static List<UserExternal> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the user externals where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user externals
	*/
	public static List<UserExternal> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user externals where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user externals
	*/
	public static List<UserExternal> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public static UserExternal findByUuid_First(java.lang.String uuid,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public static UserExternal fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public static UserExternal findByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public static UserExternal fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user externals before and after the current user external in the ordered set where uuid = &#63;.
	*
	* @param uid the primary key of the current user external
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public static UserExternal[] findByUuid_PrevAndNext(long uid,
		java.lang.String uuid, OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence()
				   .findByUuid_PrevAndNext(uid, uuid, orderByComparator);
	}

	/**
	* Removes all the user externals where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user externals where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user externals
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the matching user externals
	*/
	public static List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber) {
		return getPersistence().findByPolicyID(PolicyNumber);
	}

	/**
	* Returns a range of all the user externals where PolicyNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PolicyNumber the policy number
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @return the range of matching user externals
	*/
	public static List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber, int start, int end) {
		return getPersistence().findByPolicyID(PolicyNumber, start, end);
	}

	/**
	* Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PolicyNumber the policy number
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user externals
	*/
	public static List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber, int start, int end,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence()
				   .findByPolicyID(PolicyNumber, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PolicyNumber the policy number
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user externals
	*/
	public static List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber, int start, int end,
		OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPolicyID(PolicyNumber, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public static UserExternal findByPolicyID_First(
		java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence()
				   .findByPolicyID_First(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public static UserExternal fetchByPolicyID_First(
		java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence()
				   .fetchByPolicyID_First(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public static UserExternal findByPolicyID_Last(
		java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence()
				   .findByPolicyID_Last(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public static UserExternal fetchByPolicyID_Last(
		java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence()
				   .fetchByPolicyID_Last(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the user externals before and after the current user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param uid the primary key of the current user external
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public static UserExternal[] findByPolicyID_PrevAndNext(long uid,
		java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence()
				   .findByPolicyID_PrevAndNext(uid, PolicyNumber,
			orderByComparator);
	}

	/**
	* Removes all the user externals where PolicyNumber = &#63; from the database.
	*
	* @param PolicyNumber the policy number
	*/
	public static void removeByPolicyID(java.lang.String PolicyNumber) {
		getPersistence().removeByPolicyID(PolicyNumber);
	}

	/**
	* Returns the number of user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the number of matching user externals
	*/
	public static int countByPolicyID(java.lang.String PolicyNumber) {
		return getPersistence().countByPolicyID(PolicyNumber);
	}

	/**
	* Returns all the user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the matching user externals
	*/
	public static List<UserExternal> findByPID(java.lang.String PolicyNumber) {
		return getPersistence().findByPID(PolicyNumber);
	}

	/**
	* Returns a range of all the user externals where PolicyNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PolicyNumber the policy number
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @return the range of matching user externals
	*/
	public static List<UserExternal> findByPID(java.lang.String PolicyNumber,
		int start, int end) {
		return getPersistence().findByPID(PolicyNumber, start, end);
	}

	/**
	* Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PolicyNumber the policy number
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user externals
	*/
	public static List<UserExternal> findByPID(java.lang.String PolicyNumber,
		int start, int end, OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence()
				   .findByPID(PolicyNumber, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PolicyNumber the policy number
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user externals
	*/
	public static List<UserExternal> findByPID(java.lang.String PolicyNumber,
		int start, int end, OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPID(PolicyNumber, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public static UserExternal findByPID_First(java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence().findByPID_First(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public static UserExternal fetchByPID_First(java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence().fetchByPID_First(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public static UserExternal findByPID_Last(java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence().findByPID_Last(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public static UserExternal fetchByPID_Last(java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence().fetchByPID_Last(PolicyNumber, orderByComparator);
	}

	/**
	* Returns the user externals before and after the current user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param uid the primary key of the current user external
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public static UserExternal[] findByPID_PrevAndNext(long uid,
		java.lang.String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence()
				   .findByPID_PrevAndNext(uid, PolicyNumber, orderByComparator);
	}

	/**
	* Removes all the user externals where PolicyNumber = &#63; from the database.
	*
	* @param PolicyNumber the policy number
	*/
	public static void removeByPID(java.lang.String PolicyNumber) {
		getPersistence().removeByPID(PolicyNumber);
	}

	/**
	* Returns the number of user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the number of matching user externals
	*/
	public static int countByPID(java.lang.String PolicyNumber) {
		return getPersistence().countByPID(PolicyNumber);
	}

	/**
	* Caches the user external in the entity cache if it is enabled.
	*
	* @param userExternal the user external
	*/
	public static void cacheResult(UserExternal userExternal) {
		getPersistence().cacheResult(userExternal);
	}

	/**
	* Caches the user externals in the entity cache if it is enabled.
	*
	* @param userExternals the user externals
	*/
	public static void cacheResult(List<UserExternal> userExternals) {
		getPersistence().cacheResult(userExternals);
	}

	/**
	* Creates a new user external with the primary key. Does not add the user external to the database.
	*
	* @param uid the primary key for the new user external
	* @return the new user external
	*/
	public static UserExternal create(long uid) {
		return getPersistence().create(uid);
	}

	/**
	* Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uid the primary key of the user external
	* @return the user external that was removed
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public static UserExternal remove(long uid)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence().remove(uid);
	}

	public static UserExternal updateImpl(UserExternal userExternal) {
		return getPersistence().updateImpl(userExternal);
	}

	/**
	* Returns the user external with the primary key or throws a {@link NoSuchUserExternalException} if it could not be found.
	*
	* @param uid the primary key of the user external
	* @return the user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public static UserExternal findByPrimaryKey(long uid)
		throws com.MappingServices.exception.NoSuchUserExternalException {
		return getPersistence().findByPrimaryKey(uid);
	}

	/**
	* Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uid the primary key of the user external
	* @return the user external, or <code>null</code> if a user external with the primary key could not be found
	*/
	public static UserExternal fetchByPrimaryKey(long uid) {
		return getPersistence().fetchByPrimaryKey(uid);
	}

	public static java.util.Map<java.io.Serializable, UserExternal> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user externals.
	*
	* @return the user externals
	*/
	public static List<UserExternal> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user externals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @return the range of user externals
	*/
	public static List<UserExternal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user externals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user externals
	*/
	public static List<UserExternal> findAll(int start, int end,
		OrderByComparator<UserExternal> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user externals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user externals
	*/
	public static List<UserExternal> findAll(int start, int end,
		OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user externals from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user externals.
	*
	* @return the number of user externals
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserExternalPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserExternalPersistence, UserExternalPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserExternalPersistence.class);
}