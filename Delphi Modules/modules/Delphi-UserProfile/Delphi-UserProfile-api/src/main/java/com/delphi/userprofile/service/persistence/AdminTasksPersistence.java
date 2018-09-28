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

import com.delphi.userprofile.exception.NoSuchAdminTasksException;
import com.delphi.userprofile.model.AdminTasks;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the admin tasks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.delphi.userprofile.service.persistence.impl.AdminTasksPersistenceImpl
 * @see AdminTasksUtil
 * @generated
 */
@ProviderType
public interface AdminTasksPersistence extends BasePersistence<AdminTasks> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdminTasksUtil} to access the admin tasks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the admin taskses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching admin taskses
	*/
	public java.util.List<AdminTasks> findByUuid(java.lang.String uuid);

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
	public java.util.List<AdminTasks> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<AdminTasks> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

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
	public java.util.List<AdminTasks> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public AdminTasks findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator)
		throws NoSuchAdminTasksException;

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public AdminTasks fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public AdminTasks findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator)
		throws NoSuchAdminTasksException;

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public AdminTasks fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

	/**
	* Returns the admin taskses before and after the current admin tasks in the ordered set where uuid = &#63;.
	*
	* @param adminTasksPK the primary key of the current admin tasks
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin tasks
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public AdminTasks[] findByUuid_PrevAndNext(AdminTasksPK adminTasksPK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator)
		throws NoSuchAdminTasksException;

	/**
	* Removes all the admin taskses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of admin taskses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching admin taskses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching admin taskses
	*/
	public java.util.List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

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
	public java.util.List<AdminTasks> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public AdminTasks findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator)
		throws NoSuchAdminTasksException;

	/**
	* Returns the first admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public AdminTasks fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks
	* @throws NoSuchAdminTasksException if a matching admin tasks could not be found
	*/
	public AdminTasks findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator)
		throws NoSuchAdminTasksException;

	/**
	* Returns the last admin tasks in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public AdminTasks fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

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
	public AdminTasks[] findByUuid_C_PrevAndNext(AdminTasksPK adminTasksPK,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator)
		throws NoSuchAdminTasksException;

	/**
	* Removes all the admin taskses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of admin taskses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching admin taskses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the admin tasks in the entity cache if it is enabled.
	*
	* @param adminTasks the admin tasks
	*/
	public void cacheResult(AdminTasks adminTasks);

	/**
	* Caches the admin taskses in the entity cache if it is enabled.
	*
	* @param adminTaskses the admin taskses
	*/
	public void cacheResult(java.util.List<AdminTasks> adminTaskses);

	/**
	* Creates a new admin tasks with the primary key. Does not add the admin tasks to the database.
	*
	* @param adminTasksPK the primary key for the new admin tasks
	* @return the new admin tasks
	*/
	public AdminTasks create(AdminTasksPK adminTasksPK);

	/**
	* Removes the admin tasks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks that was removed
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public AdminTasks remove(AdminTasksPK adminTasksPK)
		throws NoSuchAdminTasksException;

	public AdminTasks updateImpl(AdminTasks adminTasks);

	/**
	* Returns the admin tasks with the primary key or throws a {@link NoSuchAdminTasksException} if it could not be found.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks
	* @throws NoSuchAdminTasksException if a admin tasks with the primary key could not be found
	*/
	public AdminTasks findByPrimaryKey(AdminTasksPK adminTasksPK)
		throws NoSuchAdminTasksException;

	/**
	* Returns the admin tasks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks, or <code>null</code> if a admin tasks with the primary key could not be found
	*/
	public AdminTasks fetchByPrimaryKey(AdminTasksPK adminTasksPK);

	@Override
	public java.util.Map<java.io.Serializable, AdminTasks> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the admin taskses.
	*
	* @return the admin taskses
	*/
	public java.util.List<AdminTasks> findAll();

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
	public java.util.List<AdminTasks> findAll(int start, int end);

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
	public java.util.List<AdminTasks> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator);

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
	public java.util.List<AdminTasks> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminTasks> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the admin taskses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of admin taskses.
	*
	* @return the number of admin taskses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}