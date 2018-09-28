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

package com.ys.hmawfm.wfms.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_and_reasoncodeException;
import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;

/**
 * The persistence interface for the WFMS_action_and_reasoncode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_action_and_reasoncodePersistenceImpl
 * @see WFMS_action_and_reasoncodeUtil
 * @generated
 */
@ProviderType
public interface WFMS_action_and_reasoncodePersistence extends BasePersistence<WFMS_action_and_reasoncode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_action_and_reasoncodeUtil} to access the WFMS_action_and_reasoncode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the WFMS_action_and_reasoncode where aarId = &#63; or throws a {@link NoSuchWFMS_action_and_reasoncodeException} if it could not be found.
	*
	* @param aarId the aar ID
	* @return the matching WFMS_action_and_reasoncode
	* @throws NoSuchWFMS_action_and_reasoncodeException if a matching WFMS_action_and_reasoncode could not be found
	*/
	public WFMS_action_and_reasoncode findByreasoncode(java.lang.String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException;

	/**
	* Returns the WFMS_action_and_reasoncode where aarId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param aarId the aar ID
	* @return the matching WFMS_action_and_reasoncode, or <code>null</code> if a matching WFMS_action_and_reasoncode could not be found
	*/
	public WFMS_action_and_reasoncode fetchByreasoncode(java.lang.String aarId);

	/**
	* Returns the WFMS_action_and_reasoncode where aarId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param aarId the aar ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_action_and_reasoncode, or <code>null</code> if a matching WFMS_action_and_reasoncode could not be found
	*/
	public WFMS_action_and_reasoncode fetchByreasoncode(
		java.lang.String aarId, boolean retrieveFromCache);

	/**
	* Removes the WFMS_action_and_reasoncode where aarId = &#63; from the database.
	*
	* @param aarId the aar ID
	* @return the WFMS_action_and_reasoncode that was removed
	*/
	public WFMS_action_and_reasoncode removeByreasoncode(java.lang.String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException;

	/**
	* Returns the number of WFMS_action_and_reasoncodes where aarId = &#63;.
	*
	* @param aarId the aar ID
	* @return the number of matching WFMS_action_and_reasoncodes
	*/
	public int countByreasoncode(java.lang.String aarId);

	/**
	* Caches the WFMS_action_and_reasoncode in the entity cache if it is enabled.
	*
	* @param wfms_action_and_reasoncode the WFMS_action_and_reasoncode
	*/
	public void cacheResult(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode);

	/**
	* Caches the WFMS_action_and_reasoncodes in the entity cache if it is enabled.
	*
	* @param wfms_action_and_reasoncodes the WFMS_action_and_reasoncodes
	*/
	public void cacheResult(
		java.util.List<WFMS_action_and_reasoncode> wfms_action_and_reasoncodes);

	/**
	* Creates a new WFMS_action_and_reasoncode with the primary key. Does not add the WFMS_action_and_reasoncode to the database.
	*
	* @param aarId the primary key for the new WFMS_action_and_reasoncode
	* @return the new WFMS_action_and_reasoncode
	*/
	public WFMS_action_and_reasoncode create(java.lang.String aarId);

	/**
	* Removes the WFMS_action_and_reasoncode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aarId the primary key of the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode that was removed
	* @throws NoSuchWFMS_action_and_reasoncodeException if a WFMS_action_and_reasoncode with the primary key could not be found
	*/
	public WFMS_action_and_reasoncode remove(java.lang.String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException;

	public WFMS_action_and_reasoncode updateImpl(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode);

	/**
	* Returns the WFMS_action_and_reasoncode with the primary key or throws a {@link NoSuchWFMS_action_and_reasoncodeException} if it could not be found.
	*
	* @param aarId the primary key of the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode
	* @throws NoSuchWFMS_action_and_reasoncodeException if a WFMS_action_and_reasoncode with the primary key could not be found
	*/
	public WFMS_action_and_reasoncode findByPrimaryKey(java.lang.String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException;

	/**
	* Returns the WFMS_action_and_reasoncode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aarId the primary key of the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode, or <code>null</code> if a WFMS_action_and_reasoncode with the primary key could not be found
	*/
	public WFMS_action_and_reasoncode fetchByPrimaryKey(java.lang.String aarId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_action_and_reasoncode> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_action_and_reasoncodes.
	*
	* @return the WFMS_action_and_reasoncodes
	*/
	public java.util.List<WFMS_action_and_reasoncode> findAll();

	/**
	* Returns a range of all the WFMS_action_and_reasoncodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_and_reasoncodes
	* @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	* @return the range of WFMS_action_and_reasoncodes
	*/
	public java.util.List<WFMS_action_and_reasoncode> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_action_and_reasoncodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_and_reasoncodes
	* @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_action_and_reasoncodes
	*/
	public java.util.List<WFMS_action_and_reasoncode> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_action_and_reasoncode> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_action_and_reasoncodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_and_reasoncodes
	* @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_action_and_reasoncodes
	*/
	public java.util.List<WFMS_action_and_reasoncode> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_action_and_reasoncode> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_action_and_reasoncodes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_action_and_reasoncodes.
	*
	* @return the number of WFMS_action_and_reasoncodes
	*/
	public int countAll();
}