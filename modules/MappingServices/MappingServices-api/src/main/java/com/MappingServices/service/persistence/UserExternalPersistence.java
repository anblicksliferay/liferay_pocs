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

import com.MappingServices.exception.NoSuchUserExternalException;

import com.MappingServices.model.UserExternal;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user external service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.MappingServices.service.persistence.impl.UserExternalPersistenceImpl
 * @see UserExternalUtil
 * @generated
 */
@ProviderType
public interface UserExternalPersistence extends BasePersistence<UserExternal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserExternalUtil} to access the user external persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user externals where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user externals
	*/
	public java.util.List<UserExternal> findByUuid(java.lang.String uuid);

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
	public java.util.List<UserExternal> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<UserExternal> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

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
	public java.util.List<UserExternal> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public UserExternal findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Returns the first user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public UserExternal fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

	/**
	* Returns the last user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public UserExternal findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Returns the last user external in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public UserExternal fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

	/**
	* Returns the user externals before and after the current user external in the ordered set where uuid = &#63;.
	*
	* @param uid the primary key of the current user external
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public UserExternal[] findByUuid_PrevAndNext(long uid,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Removes all the user externals where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of user externals where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user externals
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the matching user externals
	*/
	public java.util.List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber);

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
	public java.util.List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber, int start, int end);

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
	public java.util.List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

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
	public java.util.List<UserExternal> findByPolicyID(
		java.lang.String PolicyNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public UserExternal findByPolicyID_First(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public UserExternal fetchByPolicyID_First(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public UserExternal findByPolicyID_Last(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public UserExternal fetchByPolicyID_Last(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

	/**
	* Returns the user externals before and after the current user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param uid the primary key of the current user external
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public UserExternal[] findByPolicyID_PrevAndNext(long uid,
		java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Removes all the user externals where PolicyNumber = &#63; from the database.
	*
	* @param PolicyNumber the policy number
	*/
	public void removeByPolicyID(java.lang.String PolicyNumber);

	/**
	* Returns the number of user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the number of matching user externals
	*/
	public int countByPolicyID(java.lang.String PolicyNumber);

	/**
	* Returns all the user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the matching user externals
	*/
	public java.util.List<UserExternal> findByPID(java.lang.String PolicyNumber);

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
	public java.util.List<UserExternal> findByPID(
		java.lang.String PolicyNumber, int start, int end);

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
	public java.util.List<UserExternal> findByPID(
		java.lang.String PolicyNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

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
	public java.util.List<UserExternal> findByPID(
		java.lang.String PolicyNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public UserExternal findByPID_First(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Returns the first user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public UserExternal fetchByPID_First(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external
	* @throws NoSuchUserExternalException if a matching user external could not be found
	*/
	public UserExternal findByPID_Last(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Returns the last user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user external, or <code>null</code> if a matching user external could not be found
	*/
	public UserExternal fetchByPID_Last(java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

	/**
	* Returns the user externals before and after the current user external in the ordered set where PolicyNumber = &#63;.
	*
	* @param uid the primary key of the current user external
	* @param PolicyNumber the policy number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public UserExternal[] findByPID_PrevAndNext(long uid,
		java.lang.String PolicyNumber,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException;

	/**
	* Removes all the user externals where PolicyNumber = &#63; from the database.
	*
	* @param PolicyNumber the policy number
	*/
	public void removeByPID(java.lang.String PolicyNumber);

	/**
	* Returns the number of user externals where PolicyNumber = &#63;.
	*
	* @param PolicyNumber the policy number
	* @return the number of matching user externals
	*/
	public int countByPID(java.lang.String PolicyNumber);

	/**
	* Caches the user external in the entity cache if it is enabled.
	*
	* @param userExternal the user external
	*/
	public void cacheResult(UserExternal userExternal);

	/**
	* Caches the user externals in the entity cache if it is enabled.
	*
	* @param userExternals the user externals
	*/
	public void cacheResult(java.util.List<UserExternal> userExternals);

	/**
	* Creates a new user external with the primary key. Does not add the user external to the database.
	*
	* @param uid the primary key for the new user external
	* @return the new user external
	*/
	public UserExternal create(long uid);

	/**
	* Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uid the primary key of the user external
	* @return the user external that was removed
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public UserExternal remove(long uid) throws NoSuchUserExternalException;

	public UserExternal updateImpl(UserExternal userExternal);

	/**
	* Returns the user external with the primary key or throws a {@link NoSuchUserExternalException} if it could not be found.
	*
	* @param uid the primary key of the user external
	* @return the user external
	* @throws NoSuchUserExternalException if a user external with the primary key could not be found
	*/
	public UserExternal findByPrimaryKey(long uid)
		throws NoSuchUserExternalException;

	/**
	* Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uid the primary key of the user external
	* @return the user external, or <code>null</code> if a user external with the primary key could not be found
	*/
	public UserExternal fetchByPrimaryKey(long uid);

	@Override
	public java.util.Map<java.io.Serializable, UserExternal> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user externals.
	*
	* @return the user externals
	*/
	public java.util.List<UserExternal> findAll();

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
	public java.util.List<UserExternal> findAll(int start, int end);

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
	public java.util.List<UserExternal> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator);

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
	public java.util.List<UserExternal> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user externals from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user externals.
	*
	* @return the number of user externals
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}