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

package com.ys.hmawfm.wfms.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WFMS_WorkflowConfigLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfigLocalService
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigLocalServiceWrapper
	implements WFMS_WorkflowConfigLocalService,
		ServiceWrapper<WFMS_WorkflowConfigLocalService> {
	public WFMS_WorkflowConfigLocalServiceWrapper(
		WFMS_WorkflowConfigLocalService wfms_WorkflowConfigLocalService) {
		_wfms_WorkflowConfigLocalService = wfms_WorkflowConfigLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _wfms_WorkflowConfigLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_WorkflowConfigLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _wfms_WorkflowConfigLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_WorkflowConfigLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_WorkflowConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig addNewConfig(
		java.lang.String createdBy, java.lang.String configKey,
		java.lang.String configLabel, java.lang.String contentType,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_WorkflowConfigLocalService.addNewConfig(createdBy,
			configKey, configLabel, contentType, content);
	}

	/**
	* Adds the WFMS_WorkflowConfig to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_WorkflowConfig the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig addWFMS_WorkflowConfig(
		com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig wfms_WorkflowConfig) {
		return _wfms_WorkflowConfigLocalService.addWFMS_WorkflowConfig(wfms_WorkflowConfig);
	}

	/**
	* Creates a new WFMS_WorkflowConfig with the primary key. Does not add the WFMS_WorkflowConfig to the database.
	*
	* @param wfcId the primary key for the new WFMS_WorkflowConfig
	* @return the new WFMS_WorkflowConfig
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig createWFMS_WorkflowConfig(
		long wfcId) {
		return _wfms_WorkflowConfigLocalService.createWFMS_WorkflowConfig(wfcId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig deleteConfig(
		long configId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException {
		return _wfms_WorkflowConfigLocalService.deleteConfig(configId);
	}

	/**
	* Deletes the WFMS_WorkflowConfig from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_WorkflowConfig the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig deleteWFMS_WorkflowConfig(
		com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig wfms_WorkflowConfig) {
		return _wfms_WorkflowConfigLocalService.deleteWFMS_WorkflowConfig(wfms_WorkflowConfig);
	}

	/**
	* Deletes the WFMS_WorkflowConfig with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig that was removed
	* @throws PortalException if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig deleteWFMS_WorkflowConfig(
		long wfcId) throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_WorkflowConfigLocalService.deleteWFMS_WorkflowConfig(wfcId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig fetchWFMS_WorkflowConfig(
		long wfcId) {
		return _wfms_WorkflowConfigLocalService.fetchWFMS_WorkflowConfig(wfcId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig getByConfigId(
		long configId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_WorkflowConfigLocalService.getByConfigId(configId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig getByConfigKey(
		java.lang.String configKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_WorkflowConfigLocalService.getByConfigKey(configKey);
	}

	/**
	* Returns the WFMS_WorkflowConfig with the primary key.
	*
	* @param wfcId the primary key of the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig
	* @throws PortalException if a WFMS_WorkflowConfig with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig getWFMS_WorkflowConfig(
		long wfcId) throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_WorkflowConfigLocalService.getWFMS_WorkflowConfig(wfcId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig updateConfig(
		long configId, java.lang.String modifiedBy, java.lang.String configKey,
		java.lang.String configLabel, java.lang.String contentType,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_WorkflowConfigLocalService.updateConfig(configId,
			modifiedBy, configKey, configLabel, contentType, content);
	}

	/**
	* Updates the WFMS_WorkflowConfig in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_WorkflowConfig the WFMS_WorkflowConfig
	* @return the WFMS_WorkflowConfig that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig updateWFMS_WorkflowConfig(
		com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig wfms_WorkflowConfig) {
		return _wfms_WorkflowConfigLocalService.updateWFMS_WorkflowConfig(wfms_WorkflowConfig);
	}

	/**
	* Returns the number of WFMS_WorkflowConfigs.
	*
	* @return the number of WFMS_WorkflowConfigs
	*/
	@Override
	public int getWFMS_WorkflowConfigsCount() {
		return _wfms_WorkflowConfigLocalService.getWFMS_WorkflowConfigsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_WorkflowConfigLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _wfms_WorkflowConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _wfms_WorkflowConfigLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _wfms_WorkflowConfigLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_WorkflowConfigLocalService.getAll();
	}

	/**
	* Returns a range of all the WFMS_WorkflowConfigs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_WorkflowConfigs
	* @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	* @return the range of WFMS_WorkflowConfigs
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig> getWFMS_WorkflowConfigs(
		int start, int end) {
		return _wfms_WorkflowConfigLocalService.getWFMS_WorkflowConfigs(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _wfms_WorkflowConfigLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _wfms_WorkflowConfigLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_WorkflowConfigLocalService getWrappedService() {
		return _wfms_WorkflowConfigLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_WorkflowConfigLocalService wfms_WorkflowConfigLocalService) {
		_wfms_WorkflowConfigLocalService = wfms_WorkflowConfigLocalService;
	}

	private WFMS_WorkflowConfigLocalService _wfms_WorkflowConfigLocalService;
}