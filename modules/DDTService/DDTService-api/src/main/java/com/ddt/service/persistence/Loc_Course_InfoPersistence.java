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

package com.ddt.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.ddt.exception.NoSuchLoc_Course_InfoException;

import com.ddt.model.Loc_Course_Info;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the loc_ course_ info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ddt.service.persistence.impl.Loc_Course_InfoPersistenceImpl
 * @see Loc_Course_InfoUtil
 * @generated
 */
@ProviderType
public interface Loc_Course_InfoPersistence extends BasePersistence<Loc_Course_Info> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Loc_Course_InfoUtil} to access the loc_ course_ info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the loc_ course_ infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the loc_ course_ infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @return the range of matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the loc_ course_ infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns an ordered range of all the loc_ course_ infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns the loc_ course_ infos before and after the current loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current loc_ course_ info
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public Loc_Course_Info[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Removes all the loc_ course_ infos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of loc_ course_ infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching loc_ course_ infos
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @return the range of matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns an ordered range of all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public Loc_Course_Info fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns the loc_ course_ infos before and after the current loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param id the primary key of the current loc_ course_ info
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public Loc_Course_Info[] findByUuid_C_PrevAndNext(long id,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Removes all the loc_ course_ infos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching loc_ course_ infos
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the loc_ course_ info in the entity cache if it is enabled.
	*
	* @param loc_Course_Info the loc_ course_ info
	*/
	public void cacheResult(Loc_Course_Info loc_Course_Info);

	/**
	* Caches the loc_ course_ infos in the entity cache if it is enabled.
	*
	* @param loc_Course_Infos the loc_ course_ infos
	*/
	public void cacheResult(java.util.List<Loc_Course_Info> loc_Course_Infos);

	/**
	* Creates a new loc_ course_ info with the primary key. Does not add the loc_ course_ info to the database.
	*
	* @param id the primary key for the new loc_ course_ info
	* @return the new loc_ course_ info
	*/
	public Loc_Course_Info create(long id);

	/**
	* Removes the loc_ course_ info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info that was removed
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public Loc_Course_Info remove(long id)
		throws NoSuchLoc_Course_InfoException;

	public Loc_Course_Info updateImpl(Loc_Course_Info loc_Course_Info);

	/**
	* Returns the loc_ course_ info with the primary key or throws a {@link NoSuchLoc_Course_InfoException} if it could not be found.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public Loc_Course_Info findByPrimaryKey(long id)
		throws NoSuchLoc_Course_InfoException;

	/**
	* Returns the loc_ course_ info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info, or <code>null</code> if a loc_ course_ info with the primary key could not be found
	*/
	public Loc_Course_Info fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Loc_Course_Info> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the loc_ course_ infos.
	*
	* @return the loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findAll();

	/**
	* Returns a range of all the loc_ course_ infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @return the range of loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findAll(int start, int end);

	/**
	* Returns an ordered range of all the loc_ course_ infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator);

	/**
	* Returns an ordered range of all the loc_ course_ infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of loc_ course_ infos
	*/
	public java.util.List<Loc_Course_Info> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loc_Course_Info> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the loc_ course_ infos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of loc_ course_ infos.
	*
	* @return the number of loc_ course_ infos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}