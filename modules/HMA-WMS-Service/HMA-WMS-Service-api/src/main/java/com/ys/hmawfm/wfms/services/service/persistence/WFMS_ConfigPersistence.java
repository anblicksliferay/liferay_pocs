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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;

/**
 * The persistence interface for the WFMS_Configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_ConfigPersistenceImpl
 * @see WFMS_ConfigUtil
 * @generated
 */
@ProviderType
public interface WFMS_ConfigPersistence extends BasePersistence<WFMS_Config> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_ConfigUtil} to access the WFMS_Configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the WFMS_Configuration where configKey = &#63; or throws a {@link NoSuchWFMS_ConfigException} if it could not be found.
	*
	* @param configKey the config key
	* @return the matching WFMS_Configuration
	* @throws NoSuchWFMS_ConfigException if a matching WFMS_Configuration could not be found
	*/
	public WFMS_Config findByConfigKey(java.lang.String configKey)
		throws NoSuchWFMS_ConfigException;

	/**
	* Returns the WFMS_Configuration where configKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param configKey the config key
	* @return the matching WFMS_Configuration, or <code>null</code> if a matching WFMS_Configuration could not be found
	*/
	public WFMS_Config fetchByConfigKey(java.lang.String configKey);

	/**
	* Returns the WFMS_Configuration where configKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param configKey the config key
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Configuration, or <code>null</code> if a matching WFMS_Configuration could not be found
	*/
	public WFMS_Config fetchByConfigKey(java.lang.String configKey,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_Configuration where configKey = &#63; from the database.
	*
	* @param configKey the config key
	* @return the WFMS_Configuration that was removed
	*/
	public WFMS_Config removeByConfigKey(java.lang.String configKey)
		throws NoSuchWFMS_ConfigException;

	/**
	* Returns the number of WFMS_Configurations where configKey = &#63;.
	*
	* @param configKey the config key
	* @return the number of matching WFMS_Configurations
	*/
	public int countByConfigKey(java.lang.String configKey);

	/**
	* Caches the WFMS_Configuration in the entity cache if it is enabled.
	*
	* @param wfms_Config the WFMS_Configuration
	*/
	public void cacheResult(WFMS_Config wfms_Config);

	/**
	* Caches the WFMS_Configurations in the entity cache if it is enabled.
	*
	* @param wfms_Configs the WFMS_Configurations
	*/
	public void cacheResult(java.util.List<WFMS_Config> wfms_Configs);

	/**
	* Creates a new WFMS_Configuration with the primary key. Does not add the WFMS_Configuration to the database.
	*
	* @param configId the primary key for the new WFMS_Configuration
	* @return the new WFMS_Configuration
	*/
	public WFMS_Config create(long configId);

	/**
	* Removes the WFMS_Configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration that was removed
	* @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	*/
	public WFMS_Config remove(long configId) throws NoSuchWFMS_ConfigException;

	public WFMS_Config updateImpl(WFMS_Config wfms_Config);

	/**
	* Returns the WFMS_Configuration with the primary key or throws a {@link NoSuchWFMS_ConfigException} if it could not be found.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration
	* @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	*/
	public WFMS_Config findByPrimaryKey(long configId)
		throws NoSuchWFMS_ConfigException;

	/**
	* Returns the WFMS_Configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration, or <code>null</code> if a WFMS_Configuration with the primary key could not be found
	*/
	public WFMS_Config fetchByPrimaryKey(long configId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_Config> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_Configurations.
	*
	* @return the WFMS_Configurations
	*/
	public java.util.List<WFMS_Config> findAll();

	/**
	* Returns a range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @return the range of WFMS_Configurations
	*/
	public java.util.List<WFMS_Config> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Configurations
	*/
	public java.util.List<WFMS_Config> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Config> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Configurations
	*/
	public java.util.List<WFMS_Config> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Config> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_Configurations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_Configurations.
	*
	* @return the number of WFMS_Configurations
	*/
	public int countAll();
}