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

import com.astra.workflowservice.model.WorkFlowConfig;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for WorkFlowConfig. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFlowConfigLocalServiceUtil
 * @see com.astra.workflowservice.service.base.WorkFlowConfigLocalServiceBaseImpl
 * @see com.astra.workflowservice.service.impl.WorkFlowConfigLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WorkFlowConfigLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkFlowConfigLocalServiceUtil} to access the work flow config local service. Add custom service methods to {@link com.astra.workflowservice.service.impl.WorkFlowConfigLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the work flow config to the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowConfig the work flow config
	* @return the work flow config that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WorkFlowConfig addWorkFlowConfig(WorkFlowConfig workFlowConfig);

	/**
	* Creates a new work flow config with the primary key. Does not add the work flow config to the database.
	*
	* @param WfcId the primary key for the new work flow config
	* @return the new work flow config
	*/
	public WorkFlowConfig createWorkFlowConfig(long WfcId);

	/**
	* Deletes the work flow config from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowConfig the work flow config
	* @return the work flow config that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public WorkFlowConfig deleteWorkFlowConfig(WorkFlowConfig workFlowConfig);

	/**
	* Deletes the work flow config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config that was removed
	* @throws PortalException if a work flow config with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public WorkFlowConfig deleteWorkFlowConfig(long WfcId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkFlowConfig fetchWorkFlowConfig(long WfcId);

	/**
	* Returns the work flow config with the matching UUID and company.
	*
	* @param uuid the work flow config's UUID
	* @param companyId the primary key of the company
	* @return the matching work flow config, or <code>null</code> if a matching work flow config could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkFlowConfig fetchWorkFlowConfigByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns the work flow config with the primary key.
	*
	* @param WfcId the primary key of the work flow config
	* @return the work flow config
	* @throws PortalException if a work flow config with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkFlowConfig getWorkFlowConfig(long WfcId)
		throws PortalException;

	/**
	* Returns the work flow config with the matching UUID and company.
	*
	* @param uuid the work flow config's UUID
	* @param companyId the primary key of the company
	* @return the matching work flow config
	* @throws PortalException if a matching work flow config could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkFlowConfig getWorkFlowConfigByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Updates the work flow config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workFlowConfig the work flow config
	* @return the work flow config that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WorkFlowConfig updateWorkFlowConfig(WorkFlowConfig workFlowConfig);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of work flow configs.
	*
	* @return the number of work flow configs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWorkFlowConfigsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkFlowConfig> getWorkFlowConfigs(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}