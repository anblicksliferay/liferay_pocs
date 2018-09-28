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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skillsException;
import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills;

/**
 * The persistence interface for the WFMS_associate_skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_associate_skillsPersistenceImpl
 * @see WFMS_associate_skillsUtil
 * @generated
 */
@ProviderType
public interface WFMS_associate_skillsPersistence extends BasePersistence<WFMS_associate_skills> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_associate_skillsUtil} to access the WFMS_associate_skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the WFMS_associate_skills in the entity cache if it is enabled.
	*
	* @param wfms_associate_skills the WFMS_associate_skills
	*/
	public void cacheResult(WFMS_associate_skills wfms_associate_skills);

	/**
	* Caches the WFMS_associate_skillses in the entity cache if it is enabled.
	*
	* @param wfms_associate_skillses the WFMS_associate_skillses
	*/
	public void cacheResult(
		java.util.List<WFMS_associate_skills> wfms_associate_skillses);

	/**
	* Creates a new WFMS_associate_skills with the primary key. Does not add the WFMS_associate_skills to the database.
	*
	* @param associate_number the primary key for the new WFMS_associate_skills
	* @return the new WFMS_associate_skills
	*/
	public WFMS_associate_skills create(java.lang.String associate_number);

	/**
	* Removes the WFMS_associate_skills with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associate_number the primary key of the WFMS_associate_skills
	* @return the WFMS_associate_skills that was removed
	* @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	*/
	public WFMS_associate_skills remove(java.lang.String associate_number)
		throws NoSuchWFMS_associate_skillsException;

	public WFMS_associate_skills updateImpl(
		WFMS_associate_skills wfms_associate_skills);

	/**
	* Returns the WFMS_associate_skills with the primary key or throws a {@link NoSuchWFMS_associate_skillsException} if it could not be found.
	*
	* @param associate_number the primary key of the WFMS_associate_skills
	* @return the WFMS_associate_skills
	* @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	*/
	public WFMS_associate_skills findByPrimaryKey(
		java.lang.String associate_number)
		throws NoSuchWFMS_associate_skillsException;

	/**
	* Returns the WFMS_associate_skills with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param associate_number the primary key of the WFMS_associate_skills
	* @return the WFMS_associate_skills, or <code>null</code> if a WFMS_associate_skills with the primary key could not be found
	*/
	public WFMS_associate_skills fetchByPrimaryKey(
		java.lang.String associate_number);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_associate_skills> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_associate_skillses.
	*
	* @return the WFMS_associate_skillses
	*/
	public java.util.List<WFMS_associate_skills> findAll();

	/**
	* Returns a range of all the WFMS_associate_skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skillses
	* @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	* @return the range of WFMS_associate_skillses
	*/
	public java.util.List<WFMS_associate_skills> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_associate_skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skillses
	* @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_associate_skillses
	*/
	public java.util.List<WFMS_associate_skills> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_associate_skills> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_associate_skillses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skillses
	* @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_associate_skillses
	*/
	public java.util.List<WFMS_associate_skills> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_associate_skills> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_associate_skillses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_associate_skillses.
	*
	* @return the number of WFMS_associate_skillses
	*/
	public int countAll();
}