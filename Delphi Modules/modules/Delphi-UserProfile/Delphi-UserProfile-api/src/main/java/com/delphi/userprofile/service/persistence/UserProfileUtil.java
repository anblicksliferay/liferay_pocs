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

import com.delphi.userprofile.model.UserProfile;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user profile service. This utility wraps {@link com.delphi.userprofile.service.persistence.impl.UserProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfilePersistence
 * @see com.delphi.userprofile.service.persistence.impl.UserProfilePersistenceImpl
 * @generated
 */
@ProviderType
public class UserProfileUtil {
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
	public static void clearCache(UserProfile userProfile) {
		getPersistence().clearCache(userProfile);
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
	public static List<UserProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserProfile update(UserProfile userProfile) {
		return getPersistence().update(userProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserProfile update(UserProfile userProfile,
		ServiceContext serviceContext) {
		return getPersistence().update(userProfile, serviceContext);
	}

	/**
	* Returns all the user profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user profiles
	*/
	public static List<UserProfile> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the user profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @return the range of matching user profiles
	*/
	public static List<UserProfile> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the user profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user profiles
	*/
	public static List<UserProfile> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user profiles
	*/
	public static List<UserProfile> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByUuid_First(java.lang.String uuid,
		OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user profiles before and after the current user profile in the ordered set where uuid = &#63;.
	*
	* @param profileId the primary key of the current user profile
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public static UserProfile[] findByUuid_PrevAndNext(long profileId,
		java.lang.String uuid, OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence()
				   .findByUuid_PrevAndNext(profileId, uuid, orderByComparator);
	}

	/**
	* Removes all the user profiles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user profiles
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the user profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user profiles
	*/
	public static List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the user profiles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @return the range of matching user profiles
	*/
	public static List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the user profiles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user profiles
	*/
	public static List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user profiles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user profiles
	*/
	public static List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the user profiles before and after the current user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param profileId the primary key of the current user profile
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public static UserProfile[] findByUuid_C_PrevAndNext(long profileId,
		java.lang.String uuid, long companyId,
		OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(profileId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the user profiles where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of user profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user profiles
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the user profiles where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @return the matching user profiles
	*/
	public static List<UserProfile> findByJobRole(java.lang.String jobrole) {
		return getPersistence().findByJobRole(jobrole);
	}

	/**
	* Returns a range of all the user profiles where jobrole = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobrole the jobrole
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @return the range of matching user profiles
	*/
	public static List<UserProfile> findByJobRole(java.lang.String jobrole,
		int start, int end) {
		return getPersistence().findByJobRole(jobrole, start, end);
	}

	/**
	* Returns an ordered range of all the user profiles where jobrole = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobrole the jobrole
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user profiles
	*/
	public static List<UserProfile> findByJobRole(java.lang.String jobrole,
		int start, int end, OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence()
				   .findByJobRole(jobrole, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user profiles where jobrole = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobrole the jobrole
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user profiles
	*/
	public static List<UserProfile> findByJobRole(java.lang.String jobrole,
		int start, int end, OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByJobRole(jobrole, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByJobRole_First(java.lang.String jobrole,
		OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().findByJobRole_First(jobrole, orderByComparator);
	}

	/**
	* Returns the first user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByJobRole_First(java.lang.String jobrole,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence().fetchByJobRole_First(jobrole, orderByComparator);
	}

	/**
	* Returns the last user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByJobRole_Last(java.lang.String jobrole,
		OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().findByJobRole_Last(jobrole, orderByComparator);
	}

	/**
	* Returns the last user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByJobRole_Last(java.lang.String jobrole,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence().fetchByJobRole_Last(jobrole, orderByComparator);
	}

	/**
	* Returns the user profiles before and after the current user profile in the ordered set where jobrole = &#63;.
	*
	* @param profileId the primary key of the current user profile
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public static UserProfile[] findByJobRole_PrevAndNext(long profileId,
		java.lang.String jobrole,
		OrderByComparator<UserProfile> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence()
				   .findByJobRole_PrevAndNext(profileId, jobrole,
			orderByComparator);
	}

	/**
	* Removes all the user profiles where jobrole = &#63; from the database.
	*
	* @param jobrole the jobrole
	*/
	public static void removeByJobRole(java.lang.String jobrole) {
		getPersistence().removeByJobRole(jobrole);
	}

	/**
	* Returns the number of user profiles where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @return the number of matching user profiles
	*/
	public static int countByJobRole(java.lang.String jobrole) {
		return getPersistence().countByJobRole(jobrole);
	}

	/**
	* Returns the user profile where userId = &#63; or throws a {@link NoSuchUserProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public static UserProfile findByUserId(long userId)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the user profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the user profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public static UserProfile fetchByUserId(long userId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the user profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the user profile that was removed
	*/
	public static UserProfile removeByUserId(long userId)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of user profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user profiles
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the user profile in the entity cache if it is enabled.
	*
	* @param userProfile the user profile
	*/
	public static void cacheResult(UserProfile userProfile) {
		getPersistence().cacheResult(userProfile);
	}

	/**
	* Caches the user profiles in the entity cache if it is enabled.
	*
	* @param userProfiles the user profiles
	*/
	public static void cacheResult(List<UserProfile> userProfiles) {
		getPersistence().cacheResult(userProfiles);
	}

	/**
	* Creates a new user profile with the primary key. Does not add the user profile to the database.
	*
	* @param profileId the primary key for the new user profile
	* @return the new user profile
	*/
	public static UserProfile create(long profileId) {
		return getPersistence().create(profileId);
	}

	/**
	* Removes the user profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile that was removed
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public static UserProfile remove(long profileId)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().remove(profileId);
	}

	public static UserProfile updateImpl(UserProfile userProfile) {
		return getPersistence().updateImpl(userProfile);
	}

	/**
	* Returns the user profile with the primary key or throws a {@link NoSuchUserProfileException} if it could not be found.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public static UserProfile findByPrimaryKey(long profileId)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException {
		return getPersistence().findByPrimaryKey(profileId);
	}

	/**
	* Returns the user profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile, or <code>null</code> if a user profile with the primary key could not be found
	*/
	public static UserProfile fetchByPrimaryKey(long profileId) {
		return getPersistence().fetchByPrimaryKey(profileId);
	}

	public static java.util.Map<java.io.Serializable, UserProfile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user profiles.
	*
	* @return the user profiles
	*/
	public static List<UserProfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @return the range of user profiles
	*/
	public static List<UserProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user profiles
	*/
	public static List<UserProfile> findAll(int start, int end,
		OrderByComparator<UserProfile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user profiles
	*/
	public static List<UserProfile> findAll(int start, int end,
		OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user profiles from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user profiles.
	*
	* @return the number of user profiles
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserProfilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserProfilePersistence, UserProfilePersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserProfilePersistence.class);
}