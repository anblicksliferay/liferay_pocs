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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_routing_and_approversException;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;

/**
 * The persistence interface for the WFMS_routing_and_approvers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_routing_and_approversPersistenceImpl
 * @see WFMS_routing_and_approversUtil
 * @generated
 */
@ProviderType
public interface WFMS_routing_and_approversPersistence extends BasePersistence<WFMS_routing_and_approvers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_routing_and_approversUtil} to access the WFMS_routing_and_approvers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the WFMS_routing_and_approvers where rapId = &#63; or throws a {@link NoSuchWFMS_routing_and_approversException} if it could not be found.
	*
	* @param rapId the rap ID
	* @return the matching WFMS_routing_and_approvers
	* @throws NoSuchWFMS_routing_and_approversException if a matching WFMS_routing_and_approvers could not be found
	*/
	public WFMS_routing_and_approvers findByrouting(java.lang.String rapId)
		throws NoSuchWFMS_routing_and_approversException;

	/**
	* Returns the WFMS_routing_and_approvers where rapId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rapId the rap ID
	* @return the matching WFMS_routing_and_approvers, or <code>null</code> if a matching WFMS_routing_and_approvers could not be found
	*/
	public WFMS_routing_and_approvers fetchByrouting(java.lang.String rapId);

	/**
	* Returns the WFMS_routing_and_approvers where rapId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rapId the rap ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_routing_and_approvers, or <code>null</code> if a matching WFMS_routing_and_approvers could not be found
	*/
	public WFMS_routing_and_approvers fetchByrouting(java.lang.String rapId,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_routing_and_approvers where rapId = &#63; from the database.
	*
	* @param rapId the rap ID
	* @return the WFMS_routing_and_approvers that was removed
	*/
	public WFMS_routing_and_approvers removeByrouting(java.lang.String rapId)
		throws NoSuchWFMS_routing_and_approversException;

	/**
	* Returns the number of WFMS_routing_and_approverses where rapId = &#63;.
	*
	* @param rapId the rap ID
	* @return the number of matching WFMS_routing_and_approverses
	*/
	public int countByrouting(java.lang.String rapId);

	/**
	* Caches the WFMS_routing_and_approvers in the entity cache if it is enabled.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	*/
	public void cacheResult(
		WFMS_routing_and_approvers wfms_routing_and_approvers);

	/**
	* Caches the WFMS_routing_and_approverses in the entity cache if it is enabled.
	*
	* @param wfms_routing_and_approverses the WFMS_routing_and_approverses
	*/
	public void cacheResult(
		java.util.List<WFMS_routing_and_approvers> wfms_routing_and_approverses);

	/**
	* Creates a new WFMS_routing_and_approvers with the primary key. Does not add the WFMS_routing_and_approvers to the database.
	*
	* @param rapId the primary key for the new WFMS_routing_and_approvers
	* @return the new WFMS_routing_and_approvers
	*/
	public WFMS_routing_and_approvers create(java.lang.String rapId);

	/**
	* Removes the WFMS_routing_and_approvers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was removed
	* @throws NoSuchWFMS_routing_and_approversException if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	public WFMS_routing_and_approvers remove(java.lang.String rapId)
		throws NoSuchWFMS_routing_and_approversException;

	public WFMS_routing_and_approvers updateImpl(
		WFMS_routing_and_approvers wfms_routing_and_approvers);

	/**
	* Returns the WFMS_routing_and_approvers with the primary key or throws a {@link NoSuchWFMS_routing_and_approversException} if it could not be found.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers
	* @throws NoSuchWFMS_routing_and_approversException if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	public WFMS_routing_and_approvers findByPrimaryKey(java.lang.String rapId)
		throws NoSuchWFMS_routing_and_approversException;

	/**
	* Returns the WFMS_routing_and_approvers with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers, or <code>null</code> if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	public WFMS_routing_and_approvers fetchByPrimaryKey(java.lang.String rapId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_routing_and_approvers> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_routing_and_approverses.
	*
	* @return the WFMS_routing_and_approverses
	*/
	public java.util.List<WFMS_routing_and_approvers> findAll();

	/**
	* Returns a range of all the WFMS_routing_and_approverses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_routing_and_approverses
	* @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	* @return the range of WFMS_routing_and_approverses
	*/
	public java.util.List<WFMS_routing_and_approvers> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_routing_and_approverses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_routing_and_approverses
	* @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_routing_and_approverses
	*/
	public java.util.List<WFMS_routing_and_approvers> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_routing_and_approvers> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_routing_and_approverses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_routing_and_approverses
	* @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_routing_and_approverses
	*/
	public java.util.List<WFMS_routing_and_approvers> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_routing_and_approvers> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_routing_and_approverses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_routing_and_approverses.
	*
	* @return the number of WFMS_routing_and_approverses
	*/
	public int countAll();
}