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

import com.delphi.userprofile.exception.NoSuchUserProfileException;
import com.delphi.userprofile.model.UserProfile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.delphi.userprofile.service.persistence.impl.UserProfilePersistenceImpl
 * @see UserProfileUtil
 * @generated
 */
@ProviderType
public interface UserProfilePersistence extends BasePersistence<UserProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserProfileUtil} to access the user profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user profiles
	*/
	public java.util.List<UserProfile> findByUuid(java.lang.String uuid);

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
	public java.util.List<UserProfile> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<UserProfile> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

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
	public java.util.List<UserProfile> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Returns the first user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

	/**
	* Returns the last user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Returns the last user profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

	/**
	* Returns the user profiles before and after the current user profile in the ordered set where uuid = &#63;.
	*
	* @param profileId the primary key of the current user profile
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public UserProfile[] findByUuid_PrevAndNext(long profileId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Removes all the user profiles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of user profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user profiles
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the user profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user profiles
	*/
	public java.util.List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

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
	public java.util.List<UserProfile> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Returns the first user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

	/**
	* Returns the last user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Returns the last user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

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
	public UserProfile[] findByUuid_C_PrevAndNext(long profileId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Removes all the user profiles where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of user profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user profiles
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the user profiles where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @return the matching user profiles
	*/
	public java.util.List<UserProfile> findByJobRole(java.lang.String jobrole);

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
	public java.util.List<UserProfile> findByJobRole(java.lang.String jobrole,
		int start, int end);

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
	public java.util.List<UserProfile> findByJobRole(java.lang.String jobrole,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

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
	public java.util.List<UserProfile> findByJobRole(java.lang.String jobrole,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByJobRole_First(java.lang.String jobrole,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Returns the first user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByJobRole_First(java.lang.String jobrole,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

	/**
	* Returns the last user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByJobRole_Last(java.lang.String jobrole,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Returns the last user profile in the ordered set where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByJobRole_Last(java.lang.String jobrole,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

	/**
	* Returns the user profiles before and after the current user profile in the ordered set where jobrole = &#63;.
	*
	* @param profileId the primary key of the current user profile
	* @param jobrole the jobrole
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public UserProfile[] findByJobRole_PrevAndNext(long profileId,
		java.lang.String jobrole,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException;

	/**
	* Removes all the user profiles where jobrole = &#63; from the database.
	*
	* @param jobrole the jobrole
	*/
	public void removeByJobRole(java.lang.String jobrole);

	/**
	* Returns the number of user profiles where jobrole = &#63;.
	*
	* @param jobrole the jobrole
	* @return the number of matching user profiles
	*/
	public int countByJobRole(java.lang.String jobrole);

	/**
	* Returns the user profile where userId = &#63; or throws a {@link NoSuchUserProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user profile
	* @throws NoSuchUserProfileException if a matching user profile could not be found
	*/
	public UserProfile findByUserId(long userId)
		throws NoSuchUserProfileException;

	/**
	* Returns the user profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByUserId(long userId);

	/**
	* Returns the user profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	public UserProfile fetchByUserId(long userId, boolean retrieveFromCache);

	/**
	* Removes the user profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the user profile that was removed
	*/
	public UserProfile removeByUserId(long userId)
		throws NoSuchUserProfileException;

	/**
	* Returns the number of user profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user profiles
	*/
	public int countByUserId(long userId);

	/**
	* Caches the user profile in the entity cache if it is enabled.
	*
	* @param userProfile the user profile
	*/
	public void cacheResult(UserProfile userProfile);

	/**
	* Caches the user profiles in the entity cache if it is enabled.
	*
	* @param userProfiles the user profiles
	*/
	public void cacheResult(java.util.List<UserProfile> userProfiles);

	/**
	* Creates a new user profile with the primary key. Does not add the user profile to the database.
	*
	* @param profileId the primary key for the new user profile
	* @return the new user profile
	*/
	public UserProfile create(long profileId);

	/**
	* Removes the user profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile that was removed
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public UserProfile remove(long profileId) throws NoSuchUserProfileException;

	public UserProfile updateImpl(UserProfile userProfile);

	/**
	* Returns the user profile with the primary key or throws a {@link NoSuchUserProfileException} if it could not be found.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile
	* @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	*/
	public UserProfile findByPrimaryKey(long profileId)
		throws NoSuchUserProfileException;

	/**
	* Returns the user profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile, or <code>null</code> if a user profile with the primary key could not be found
	*/
	public UserProfile fetchByPrimaryKey(long profileId);

	@Override
	public java.util.Map<java.io.Serializable, UserProfile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user profiles.
	*
	* @return the user profiles
	*/
	public java.util.List<UserProfile> findAll();

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
	public java.util.List<UserProfile> findAll(int start, int end);

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
	public java.util.List<UserProfile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator);

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
	public java.util.List<UserProfile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user profiles from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user profiles.
	*
	* @return the number of user profiles
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}