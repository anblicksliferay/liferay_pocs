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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NA_SupportException;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;

/**
 * The persistence interface for the WFMS_NA_Support service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_NA_SupportPersistenceImpl
 * @see WFMS_NA_SupportUtil
 * @generated
 */
@ProviderType
public interface WFMS_NA_SupportPersistence extends BasePersistence<WFMS_NA_Support> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_NA_SupportUtil} to access the WFMS_NA_Support persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; or throws a {@link NoSuchWFMS_NA_SupportException} if it could not be found.
	*
	* @param ASSOCIATE_NUMBER the associate_number
	* @return the matching WFMS_NA_Support
	* @throws NoSuchWFMS_NA_SupportException if a matching WFMS_NA_Support could not be found
	*/
	public WFMS_NA_Support findBynaSupport(java.lang.String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException;

	/**
	* Returns the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ASSOCIATE_NUMBER the associate_number
	* @return the matching WFMS_NA_Support, or <code>null</code> if a matching WFMS_NA_Support could not be found
	*/
	public WFMS_NA_Support fetchBynaSupport(java.lang.String ASSOCIATE_NUMBER);

	/**
	* Returns the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ASSOCIATE_NUMBER the associate_number
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_NA_Support, or <code>null</code> if a matching WFMS_NA_Support could not be found
	*/
	public WFMS_NA_Support fetchBynaSupport(java.lang.String ASSOCIATE_NUMBER,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; from the database.
	*
	* @param ASSOCIATE_NUMBER the associate_number
	* @return the WFMS_NA_Support that was removed
	*/
	public WFMS_NA_Support removeBynaSupport(java.lang.String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException;

	/**
	* Returns the number of WFMS_NA_Supports where ASSOCIATE_NUMBER = &#63;.
	*
	* @param ASSOCIATE_NUMBER the associate_number
	* @return the number of matching WFMS_NA_Supports
	*/
	public int countBynaSupport(java.lang.String ASSOCIATE_NUMBER);

	/**
	* Caches the WFMS_NA_Support in the entity cache if it is enabled.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	*/
	public void cacheResult(WFMS_NA_Support wfms_na_Support);

	/**
	* Caches the WFMS_NA_Supports in the entity cache if it is enabled.
	*
	* @param wfms_na_Supports the WFMS_NA_Supports
	*/
	public void cacheResult(java.util.List<WFMS_NA_Support> wfms_na_Supports);

	/**
	* Creates a new WFMS_NA_Support with the primary key. Does not add the WFMS_NA_Support to the database.
	*
	* @param ASSOCIATE_NUMBER the primary key for the new WFMS_NA_Support
	* @return the new WFMS_NA_Support
	*/
	public WFMS_NA_Support create(java.lang.String ASSOCIATE_NUMBER);

	/**
	* Removes the WFMS_NA_Support with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support that was removed
	* @throws NoSuchWFMS_NA_SupportException if a WFMS_NA_Support with the primary key could not be found
	*/
	public WFMS_NA_Support remove(java.lang.String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException;

	public WFMS_NA_Support updateImpl(WFMS_NA_Support wfms_na_Support);

	/**
	* Returns the WFMS_NA_Support with the primary key or throws a {@link NoSuchWFMS_NA_SupportException} if it could not be found.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support
	* @throws NoSuchWFMS_NA_SupportException if a WFMS_NA_Support with the primary key could not be found
	*/
	public WFMS_NA_Support findByPrimaryKey(java.lang.String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException;

	/**
	* Returns the WFMS_NA_Support with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support, or <code>null</code> if a WFMS_NA_Support with the primary key could not be found
	*/
	public WFMS_NA_Support fetchByPrimaryKey(java.lang.String ASSOCIATE_NUMBER);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_NA_Support> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_NA_Supports.
	*
	* @return the WFMS_NA_Supports
	*/
	public java.util.List<WFMS_NA_Support> findAll();

	/**
	* Returns a range of all the WFMS_NA_Supports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NA_Supports
	* @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	* @return the range of WFMS_NA_Supports
	*/
	public java.util.List<WFMS_NA_Support> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_NA_Supports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NA_Supports
	* @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_NA_Supports
	*/
	public java.util.List<WFMS_NA_Support> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NA_Support> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_NA_Supports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NA_Supports
	* @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_NA_Supports
	*/
	public java.util.List<WFMS_NA_Support> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NA_Support> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_NA_Supports from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_NA_Supports.
	*
	* @return the number of WFMS_NA_Supports
	*/
	public int countAll();
}