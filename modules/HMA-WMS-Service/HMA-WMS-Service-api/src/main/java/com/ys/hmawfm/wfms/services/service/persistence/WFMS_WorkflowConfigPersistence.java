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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;

/**
 * The persistence interface for the WFMS_WorkflowConfig service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_WorkflowConfigPersistenceImpl
 * @see WFMS_WorkflowConfigUtil
 * @generated
 */
@ProviderType
public interface WFMS_WorkflowConfigPersistence extends BasePersistence<WFMS_WorkflowConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_WorkflowConfigUtil} to access the WFMS_WorkflowConfig persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the WFMS_WorkflowConfig where configKey = &#63; or throws a {@link NoSuchWFMS_WorkflowConfigException} if it could not be found.
	*
	* @param configKey the config key
	* @return the matching WFMS_WorkflowConfig
	* @throws NoSuchWFMS_WorkflowConfigException if a matching WFMS_WorkflowConfig could not be found
	*/
	public WFMS_WorkflowConfig findByConfigKey(java.lang.String configKey)
		throws NoSuchWFMS_WorkflowConfigException;

	/**
	* Returns the WFMS_WorkflowConfig where configKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param configKey the config key
	* @return the matching WFMS_WorkflowConfig, or <code>null</code> if a matching WFMS_WorkflowConfig could not be found
	*/
	public WFMS_WorkflowConfig fetchByConfigKey(java.lang.String configKey);

	/**
	* Returns the WFMS_WorkflowConfig where configKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param configKey the config key
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_WorkflowConfig, or <code>null</code> if a matching WFMS_WorkflowConfig could not be found
	*/
	public WFMS_WorkflowConfig fetchByConfigKey(java.lang.String configKey,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_WorkflowConfig where configKey = &#63; from the database.
	*
	* @param configKey the config key
	* @return the WFMS_WorkflowConfig that was removed
	*/
	public WFMS_WorkflowConfig removeByConfigKey(java.lang.String configKey)
		throws NoSuchWFMS_WorkflowConfigException;

	/**
	* Returns the number of WFMS_WorkflowConfigs where configKey = &#63;.
	*
	* @param configKey the config key
	* @return the number of matching WFMS_WorkflowConfigs
	*/
	public int countByConfigKey(java.lang.String configKey);

	/**
	* Caches the WFMS_WorkflowConfig in the entity cache if it is enabled.
	*
	* @param wfms_WorkflowConfig the WFMS_WorkflowConfig
	*/
	public void cacheResult(WFMS_WorkflowConfig wfms_WorkflowConfig);

	/**
	* Caches the WFMS_WorkflowConfigs in the entity cache if it is enabled.
	*
	* @param wfms_WorkflowConfigs the WFMS_WorkflowConfigs
	*/
	public void cacheResult(
		java.util.List<WFMS_WorkflowConfig> wfms_WorkflowConfigs);

	/**
	* Creates a new WFMS_WorkflowConfig with the primary key. Does not add the WFMS_WorkflowConfig to the database.
	*
	* @param wfcId the primary key for the new WFMS_WorkflowConfig
	* @return the new WFMS_WorkflowConfig
	*/
	public WFMS_WorkflowConfig create(long wfcId);

	/**
	* Removes the WFMS_WorkflowConfig with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig that was removed
	* @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	public WFMS_WorkflowConfig remove(long wfcId)
		throws NoSuchWFMS_WorkflowConfigException;

	public WFMS_WorkflowConfig updateImpl(
		WFMS_WorkflowConfig wfms_WorkflowConfig);

	/**
	* Returns the WFMS_WorkflowConfig with the primary key or throws a {@link NoSuchWFMS_WorkflowConfigException} if it could not be found.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig
	* @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	public WFMS_WorkflowConfig findByPrimaryKey(long wfcId)
		throws NoSuchWFMS_WorkflowConfigException;

	/**
	* Returns the WFMS_WorkflowConfig with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig, or <code>null</code> if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	public WFMS_WorkflowConfig fetchByPrimaryKey(long wfcId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_WorkflowConfig> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_WorkflowConfigs.
	*
	* @return the WFMS_WorkflowConfigs
	*/
	public java.util.List<WFMS_WorkflowConfig> findAll();

	/**
	* Returns a range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @return the range of WFMS_WorkflowConfigs
	*/
	public java.util.List<WFMS_WorkflowConfig> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_WorkflowConfigs
	*/
	public java.util.List<WFMS_WorkflowConfig> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_WorkflowConfig> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_WorkflowConfigs
	*/
	public java.util.List<WFMS_WorkflowConfig> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_WorkflowConfig> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_WorkflowConfigs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_WorkflowConfigs.
	*
	* @return the number of WFMS_WorkflowConfigs
	*/
	public int countAll();
}