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

import com.delphi.userprofile.model.AdminTasks;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the admin tasks service. This utility wraps {@link com.delphi.userprofile.service.persistence.impl.AdminTasksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasksPersistence
 * @see com.delphi.userprofile.service.persistence.impl.AdminTasksPersistenceImpl
 * @generated
 */
@ProviderType
public class AdminTasksUtil {
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
	public static void clearCache(AdminTasks adminTasks) {
		getPersistence().clearCache(adminTasks);
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
	public static List<AdminTasks> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdminTasks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdminTasks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AdminTasks update(AdminTasks adminTasks) {
		return getPersistence().update(adminTasks);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AdminTasks update(AdminTasks adminTasks,
		ServiceContext serviceContext) {
		return getPersistence().update(adminTasks, serviceContext);
	}

	/**
	* Returns all the admin taskses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching admin taskses
	*/
	public static List<AdminTasks> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the admin taskses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @return the range of matching admin taskses
	*/
	public static List<AdminTasks> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the admin taskses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin taskses
	*/
	public static List<AdminTasks> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin taskses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching admin taskses
	*/
	public static List<AdminTasks> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<AdminTasks> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public static AdminTasks findByUuid_First(java.lang.String uuid,
		OrderByComparator<AdminTasks> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public static AdminTasks fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public static AdminTasks findByUuid_Last(java.lang.String uuid,
		OrderByComparator<AdminTasks> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public static AdminTasks fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the admin taskses before and after the current admin tasks in the ordered set where uuid = &#63;.
	*
	* @param adminTasksPK the primary key of the current admin tasks
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin tasks
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public static AdminTasks[] findByUuid_PrevAndNext(
		AdminTasksPK adminTasksPK, java.lang.String uuid,
		OrderByComparator<AdminTasks> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence()
				   .findByUuid_PrevAndNext(adminTasksPK, uuid, orderByComparator);
	}

	/**
	* Removes all the admin taskses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of admin taskses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching admin taskses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching admin taskses
	*/
	public static List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @return the range of matching admin taskses
	*/
	public static List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin taskses
	*/
	public static List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching admin taskses
	*/
	public static List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AdminTasks> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public static AdminTasks findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AdminTasks> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public static AdminTasks fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public static AdminTasks findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AdminTasks> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public static AdminTasks fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the admin taskses before and after the current admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param adminTasksPK the primary key of the current admin tasks
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin tasks
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public static AdminTasks[] findByUuid_C_PrevAndNext(
		AdminTasksPK adminTasksPK, java.lang.String uuid, long companyId,
		OrderByComparator<AdminTasks> orderByComparator)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(adminTasksPK, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the admin taskses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching admin taskses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the admin tasks in the entity cache if it is enabled.
	*
	* @param adminTasks the admin tasks
	*/
	public static void cacheResult(AdminTasks adminTasks) {
		getPersistence().cacheResult(adminTasks);
	}

	/**
	* Caches the admin taskses in the entity cache if it is enabled.
	*
	* @param adminTaskses the admin taskses
	*/
	public static void cacheResult(List<AdminTasks> adminTaskses) {
		getPersistence().cacheResult(adminTaskses);
	}

	/**
	* Creates a new admin tasks with the primary key. Does not add the admin tasks to the database.
	*
	* @param adminTasksPK the primary key for the new admin tasks
	* @return the new admin tasks
	*/
	public static AdminTasks create(AdminTasksPK adminTasksPK) {
		return getPersistence().create(adminTasksPK);
	}

	/**
	* Removes the admin tasks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks that was removed
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public static AdminTasks remove(AdminTasksPK adminTasksPK)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence().remove(adminTasksPK);
	}

	public static AdminTasks updateImpl(AdminTasks adminTasks) {
		return getPersistence().updateImpl(adminTasks);
	}

	/**
	* Returns the admin tasks with the primary key or throws a {@link NoSuchAdminTasksException} if it could not be found.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public static AdminTasks findByPrimaryKey(AdminTasksPK adminTasksPK)
		throws com.delphi.userprofile.exception.NoSuchAdminTasksException {
		return getPersistence().findByPrimaryKey(adminTasksPK);
	}

	/**
	* Returns the admin tasks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks, or <code>null</code> if a admin tasks with the primary key could not be found
	*/
	public static AdminTasks fetchByPrimaryKey(AdminTasksPK adminTasksPK) {
		return getPersistence().fetchByPrimaryKey(adminTasksPK);
	}

	public static java.util.Map<java.io.Serializable, AdminTasks> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the admin taskses.
	*
	* @return the admin taskses
	*/
	public static List<AdminTasks> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the admin taskses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @return the range of admin taskses
	*/
	public static List<AdminTasks> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the admin taskses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of admin taskses
	*/
	public static List<AdminTasks> findAll(int start, int end,
		OrderByComparator<AdminTasks> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin taskses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of admin taskses
	*/
	public static List<AdminTasks> findAll(int start, int end,
		OrderByComparator<AdminTasks> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the admin taskses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of admin taskses.
	*
	* @return the number of admin taskses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AdminTasksPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AdminTasksPersistence, AdminTasksPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AdminTasksPersistence.class);
}