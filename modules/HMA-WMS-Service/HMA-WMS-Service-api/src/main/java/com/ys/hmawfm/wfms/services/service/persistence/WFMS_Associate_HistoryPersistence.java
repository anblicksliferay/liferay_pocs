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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Associate_HistoryException;
import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;

/**
 * The persistence interface for the WFMS_Associate_History service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_Associate_HistoryPersistenceImpl
 * @see WFMS_Associate_HistoryUtil
 * @generated
 */
@ProviderType
public interface WFMS_Associate_HistoryPersistence extends BasePersistence<WFMS_Associate_History> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_Associate_HistoryUtil} to access the WFMS_Associate_History persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the WFMS_Associate_History in the entity cache if it is enabled.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	*/
	public void cacheResult(WFMS_Associate_History wfms_Associate_History);

	/**
	* Caches the WFMS_Associate_Histories in the entity cache if it is enabled.
	*
	* @param wfms_Associate_Histories the WFMS_Associate_Histories
	*/
	public void cacheResult(
		java.util.List<WFMS_Associate_History> wfms_Associate_Histories);

	/**
	* Creates a new WFMS_Associate_History with the primary key. Does not add the WFMS_Associate_History to the database.
	*
	* @param assocHistoryId the primary key for the new WFMS_Associate_History
	* @return the new WFMS_Associate_History
	*/
	public WFMS_Associate_History create(int assocHistoryId);

	/**
	* Removes the WFMS_Associate_History with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History that was removed
	* @throws NoSuchWFMS_Associate_HistoryException if a WFMS_Associate_History with the primary key could not be found
	*/
	public WFMS_Associate_History remove(int assocHistoryId)
		throws NoSuchWFMS_Associate_HistoryException;

	public WFMS_Associate_History updateImpl(
		WFMS_Associate_History wfms_Associate_History);

	/**
	* Returns the WFMS_Associate_History with the primary key or throws a {@link NoSuchWFMS_Associate_HistoryException} if it could not be found.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History
	* @throws NoSuchWFMS_Associate_HistoryException if a WFMS_Associate_History with the primary key could not be found
	*/
	public WFMS_Associate_History findByPrimaryKey(int assocHistoryId)
		throws NoSuchWFMS_Associate_HistoryException;

	/**
	* Returns the WFMS_Associate_History with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History, or <code>null</code> if a WFMS_Associate_History with the primary key could not be found
	*/
	public WFMS_Associate_History fetchByPrimaryKey(int assocHistoryId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_Associate_History> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_Associate_Histories.
	*
	* @return the WFMS_Associate_Histories
	*/
	public java.util.List<WFMS_Associate_History> findAll();

	/**
	* Returns a range of all the WFMS_Associate_Histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Associate_Histories
	* @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	* @return the range of WFMS_Associate_Histories
	*/
	public java.util.List<WFMS_Associate_History> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_Associate_Histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Associate_Histories
	* @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Associate_Histories
	*/
	public java.util.List<WFMS_Associate_History> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Associate_History> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_Associate_Histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Associate_Histories
	* @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Associate_Histories
	*/
	public java.util.List<WFMS_Associate_History> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Associate_History> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_Associate_Histories from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_Associate_Histories.
	*
	* @return the number of WFMS_Associate_Histories
	*/
	public int countAll();
}