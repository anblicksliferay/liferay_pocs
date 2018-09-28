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

import com.ddt.model.Loc_Course_Info;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the loc_ course_ info service. This utility wraps {@link com.ddt.service.persistence.impl.Loc_Course_InfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_InfoPersistence
 * @see com.ddt.service.persistence.impl.Loc_Course_InfoPersistenceImpl
 * @generated
 */
@ProviderType
public class Loc_Course_InfoUtil {
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
	public static void clearCache(Loc_Course_Info loc_Course_Info) {
		getPersistence().clearCache(loc_Course_Info);
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
	public static List<Loc_Course_Info> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Loc_Course_Info> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Loc_Course_Info> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Loc_Course_Info update(Loc_Course_Info loc_Course_Info) {
		return getPersistence().update(loc_Course_Info);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Loc_Course_Info update(Loc_Course_Info loc_Course_Info,
		ServiceContext serviceContext) {
		return getPersistence().update(loc_Course_Info, serviceContext);
	}

	/**
	* Returns all the loc_ course_ infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching loc_ course_ infos
	*/
	public static List<Loc_Course_Info> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Loc_Course_Info> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Loc_Course_Info> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Loc_Course_Info> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info findByUuid_First(java.lang.String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the loc_ course_ infos before and after the current loc_ course_ info in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current loc_ course_ info
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public static Loc_Course_Info[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the loc_ course_ infos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of loc_ course_ infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching loc_ course_ infos
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching loc_ course_ infos
	*/
	public static List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Loc_Course_Info> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Loc_Course_Info> orderByComparator)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Loc_Course_Info> orderByComparator)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public static Loc_Course_Info fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static Loc_Course_Info[] findByUuid_C_PrevAndNext(long id,
		java.lang.String uuid, long companyId,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(id, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the loc_ course_ infos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching loc_ course_ infos
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the loc_ course_ info in the entity cache if it is enabled.
	*
	* @param loc_Course_Info the loc_ course_ info
	*/
	public static void cacheResult(Loc_Course_Info loc_Course_Info) {
		getPersistence().cacheResult(loc_Course_Info);
	}

	/**
	* Caches the loc_ course_ infos in the entity cache if it is enabled.
	*
	* @param loc_Course_Infos the loc_ course_ infos
	*/
	public static void cacheResult(List<Loc_Course_Info> loc_Course_Infos) {
		getPersistence().cacheResult(loc_Course_Infos);
	}

	/**
	* Creates a new loc_ course_ info with the primary key. Does not add the loc_ course_ info to the database.
	*
	* @param id the primary key for the new loc_ course_ info
	* @return the new loc_ course_ info
	*/
	public static Loc_Course_Info create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the loc_ course_ info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info that was removed
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public static Loc_Course_Info remove(long id)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence().remove(id);
	}

	public static Loc_Course_Info updateImpl(Loc_Course_Info loc_Course_Info) {
		return getPersistence().updateImpl(loc_Course_Info);
	}

	/**
	* Returns the loc_ course_ info with the primary key or throws a {@link NoSuchLoc_Course_InfoException} if it could not be found.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info
	* @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	*/
	public static Loc_Course_Info findByPrimaryKey(long id)
		throws com.ddt.exception.NoSuchLoc_Course_InfoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the loc_ course_ info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info, or <code>null</code> if a loc_ course_ info with the primary key could not be found
	*/
	public static Loc_Course_Info fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Loc_Course_Info> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the loc_ course_ infos.
	*
	* @return the loc_ course_ infos
	*/
	public static List<Loc_Course_Info> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Loc_Course_Info> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Loc_Course_Info> findAll(int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Loc_Course_Info> findAll(int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the loc_ course_ infos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loc_ course_ infos.
	*
	* @return the number of loc_ course_ infos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static Loc_Course_InfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Loc_Course_InfoPersistence, Loc_Course_InfoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Loc_Course_InfoPersistence.class);
}