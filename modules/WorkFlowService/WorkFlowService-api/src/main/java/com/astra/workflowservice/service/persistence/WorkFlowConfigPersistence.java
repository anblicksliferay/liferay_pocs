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

package com.astra.workflowservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.astra.workflowservice.exception.NoSuchWorkFlowConfigException;
import com.astra.workflowservice.model.WorkFlowConfig;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the work flow config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.workflowservice.service.persistence.impl.WorkFlowConfigPersistenceImpl
 * @see WorkFlowConfigUtil
 * @generated
 */
@ProviderType
public interface WorkFlowConfigPersistence extends BasePersistence<WorkFlowConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkFlowConfigUtil} to access the work flow config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the work flow configs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the work flow configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public WorkFlowConfig findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException;

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public WorkFlowConfig fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public WorkFlowConfig findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException;

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public WorkFlowConfig fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns the work flow configs before and after the current work flow config in the ordered set where uuid = &#63;.
	*
	* @param WfcId the primary key of the current work flow config
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work flow config
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public WorkFlowConfig[] findByUuid_PrevAndNext(long WfcId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException;

	/**
	* Removes all the work flow configs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of work flow configs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching work flow configs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns an ordered range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching work flow configs
	*/
	public java.util.List<WorkFlowConfig> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public WorkFlowConfig findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException;

	/**
	* Returns the first work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public WorkFlowConfig fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config
	* @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	*/
	public WorkFlowConfig findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException;

	/**
	* Returns the last work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	public WorkFlowConfig fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns the work flow configs before and after the current work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param WfcId the primary key of the current work flow config
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work flow config
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public WorkFlowConfig[] findByUuid_C_PrevAndNext(long WfcId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException;

	/**
	* Removes all the work flow configs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of work flow configs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching work flow configs
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the work flow config in the entity cache if it is enabled.
	*
	* @param workFlowConfig the work flow config
	*/
	public void cacheResult(WorkFlowConfig workFlowConfig);

	/**
	* Caches the work flow configs in the entity cache if it is enabled.
	*
	* @param workFlowConfigs the work flow configs
	*/
	public void cacheResult(java.util.List<WorkFlowConfig> workFlowConfigs);

	/**
	* Creates a new work flow config with the primary key. Does not add the work flow config to the database.
	*
	* @param WfcId the primary key for the new work flow config
	* @return the new work flow config
	*/
	public WorkFlowConfig create(long WfcId);

	/**
	* Removes the work flow config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config that was removed
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public WorkFlowConfig remove(long WfcId)
		throws NoSuchWorkFlowConfigException;

	public WorkFlowConfig updateImpl(WorkFlowConfig workFlowConfig);

	/**
	* Returns the work flow config with the primary key or throws a {@link NoSuchWorkFlowConfigException} if it could not be found.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config
	* @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	*/
	public WorkFlowConfig findByPrimaryKey(long WfcId)
		throws NoSuchWorkFlowConfigException;

	/**
	* Returns the work flow config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config, or <code>null</code> if a work flow config with the primary key could not be found
	*/
	public WorkFlowConfig fetchByPrimaryKey(long WfcId);

	@Override
	public java.util.Map<java.io.Serializable, WorkFlowConfig> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the work flow configs.
	*
	* @return the work flow configs
	*/
	public java.util.List<WorkFlowConfig> findAll();

	/**
	* Returns a range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of work flow configs
	*/
	public java.util.List<WorkFlowConfig> findAll(int start, int end);

	/**
	* Returns an ordered range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of work flow configs
	*/
	public java.util.List<WorkFlowConfig> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator);

	/**
	* Returns an ordered range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of work flow configs
	*/
	public java.util.List<WorkFlowConfig> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFlowConfig> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the work flow configs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of work flow configs.
	*
	* @return the number of work flow configs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}