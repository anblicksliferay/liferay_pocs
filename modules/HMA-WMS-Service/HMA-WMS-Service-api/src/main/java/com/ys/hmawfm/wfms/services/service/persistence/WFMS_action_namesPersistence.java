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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_namesException;
import com.ys.hmawfm.wfms.services.model.WFMS_action_names;

/**
 * The persistence interface for the WFMS_action_names service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_action_namesPersistenceImpl
 * @see WFMS_action_namesUtil
 * @generated
 */
@ProviderType
public interface WFMS_action_namesPersistence extends BasePersistence<WFMS_action_names> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_action_namesUtil} to access the WFMS_action_names persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the WFMS_action_names in the entity cache if it is enabled.
	*
	* @param wfms_action_names the WFMS_action_names
	*/
	public void cacheResult(WFMS_action_names wfms_action_names);

	/**
	* Caches the WFMS_action_nameses in the entity cache if it is enabled.
	*
	* @param wfms_action_nameses the WFMS_action_nameses
	*/
	public void cacheResult(
		java.util.List<WFMS_action_names> wfms_action_nameses);

	/**
	* Creates a new WFMS_action_names with the primary key. Does not add the WFMS_action_names to the database.
	*
	* @param actionId the primary key for the new WFMS_action_names
	* @return the new WFMS_action_names
	*/
	public WFMS_action_names create(java.lang.String actionId);

	/**
	* Removes the WFMS_action_names with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names that was removed
	* @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	*/
	public WFMS_action_names remove(java.lang.String actionId)
		throws NoSuchWFMS_action_namesException;

	public WFMS_action_names updateImpl(WFMS_action_names wfms_action_names);

	/**
	* Returns the WFMS_action_names with the primary key or throws a {@link NoSuchWFMS_action_namesException} if it could not be found.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names
	* @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	*/
	public WFMS_action_names findByPrimaryKey(java.lang.String actionId)
		throws NoSuchWFMS_action_namesException;

	/**
	* Returns the WFMS_action_names with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names, or <code>null</code> if a WFMS_action_names with the primary key could not be found
	*/
	public WFMS_action_names fetchByPrimaryKey(java.lang.String actionId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_action_names> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_action_nameses.
	*
	* @return the WFMS_action_nameses
	*/
	public java.util.List<WFMS_action_names> findAll();

	/**
	* Returns a range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @return the range of WFMS_action_nameses
	*/
	public java.util.List<WFMS_action_names> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_action_nameses
	*/
	public java.util.List<WFMS_action_names> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_action_names> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_action_nameses
	*/
	public java.util.List<WFMS_action_names> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_action_names> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_action_nameses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_action_nameses.
	*
	* @return the number of WFMS_action_nameses
	*/
	public int countAll();
}