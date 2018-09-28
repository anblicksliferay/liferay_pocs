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

package com.astra.workflowservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkFlowConfigLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFlowConfigLocalService
 * @generated
 */
@ProviderType
public class WorkFlowConfigLocalServiceWrapper
	implements WorkFlowConfigLocalService,
		ServiceWrapper<WorkFlowConfigLocalService> {
	public WorkFlowConfigLocalServiceWrapper(
		WorkFlowConfigLocalService workFlowConfigLocalService) {
		_workFlowConfigLocalService = workFlowConfigLocalService;
	}

	/**
	* Adds the work flow config to the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowConfig the work flow config
	* @return the work flow config that was added
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig addWorkFlowConfig(
		com.astra.workflowservice.model.WorkFlowConfig workFlowConfig) {
		return _workFlowConfigLocalService.addWorkFlowConfig(workFlowConfig);
	}

	/**
	* Creates a new work flow config with the primary key. Does not add the work flow config to the database.
	*
	* @param WfcId the primary key for the new work flow config
	* @return the new work flow config
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig createWorkFlowConfig(
		long WfcId) {
		return _workFlowConfigLocalService.createWorkFlowConfig(WfcId);
	}

	/**
	* Deletes the work flow config from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowConfig the work flow config
	* @return the work flow config that was removed
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig deleteWorkFlowConfig(
		com.astra.workflowservice.model.WorkFlowConfig workFlowConfig) {
		return _workFlowConfigLocalService.deleteWorkFlowConfig(workFlowConfig);
	}

	/**
	* Deletes the work flow config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config that was removed
	* @throws PortalException if a work flow config with the primary key could not be found
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig deleteWorkFlowConfig(
		long WfcId) throws com.liferay.portal.kernel.exception.PortalException {
		return _workFlowConfigLocalService.deleteWorkFlowConfig(WfcId);
	}

	@Override
	public com.astra.workflowservice.model.WorkFlowConfig fetchWorkFlowConfig(
		long WfcId) {
		return _workFlowConfigLocalService.fetchWorkFlowConfig(WfcId);
	}

	/**
	* Returns the work flow config with the matching UUID and company.
	*
	* @param uuid the work flow config's UUID
	* @param companyId the primary key of the company
	* @return the matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig fetchWorkFlowConfigByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _workFlowConfigLocalService.fetchWorkFlowConfigByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the work flow config with the primary key.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config
	* @throws PortalException if a work flow config with the primary key could not be found
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig getWorkFlowConfig(
		long WfcId) throws com.liferay.portal.kernel.exception.PortalException {
		return _workFlowConfigLocalService.getWorkFlowConfig(WfcId);
	}

	/**
	* Returns the work flow config with the matching UUID and company.
	*
	* @param uuid the work flow config's UUID
	* @param companyId the primary key of the company
	* @return the matching work flow config
	* @throws PortalException if a matching work flow config could not be found
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig getWorkFlowConfigByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workFlowConfigLocalService.getWorkFlowConfigByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the work flow config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workFlowConfig the work flow config
	* @return the work flow config that was updated
	*/
	@Override
	public com.astra.workflowservice.model.WorkFlowConfig updateWorkFlowConfig(
		com.astra.workflowservice.model.WorkFlowConfig workFlowConfig) {
		return _workFlowConfigLocalService.updateWorkFlowConfig(workFlowConfig);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _workFlowConfigLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workFlowConfigLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _workFlowConfigLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _workFlowConfigLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workFlowConfigLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workFlowConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of work flow configs.
	*
	* @return the number of work flow configs
	*/
	@Override
	public int getWorkFlowConfigsCount() {
		return _workFlowConfigLocalService.getWorkFlowConfigsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _workFlowConfigLocalService.getOSGiServiceIdentifier();
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
		return _workFlowConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.workflowservice.model.impl.WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workFlowConfigLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.workflowservice.model.impl.WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workFlowConfigLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the work flow configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.workflowservice.model.impl.WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work flow configs
	* @param end the upper bound of the range of work flow configs (not inclusive)
	* @return the range of work flow configs
	*/
	@Override
	public java.util.List<com.astra.workflowservice.model.WorkFlowConfig> getWorkFlowConfigs(
		int start, int end) {
		return _workFlowConfigLocalService.getWorkFlowConfigs(start, end);
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
		return _workFlowConfigLocalService.dynamicQueryCount(dynamicQuery);
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
		return _workFlowConfigLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WorkFlowConfigLocalService getWrappedService() {
		return _workFlowConfigLocalService;
	}

	@Override
	public void setWrappedService(
		WorkFlowConfigLocalService workFlowConfigLocalService) {
		_workFlowConfigLocalService = workFlowConfigLocalService;
	}

	private WorkFlowConfigLocalService _workFlowConfigLocalService;
}