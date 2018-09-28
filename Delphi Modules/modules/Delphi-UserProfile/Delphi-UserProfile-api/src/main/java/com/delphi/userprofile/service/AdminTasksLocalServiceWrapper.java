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

package com.delphi.userprofile.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdminTasksLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasksLocalService
 * @generated
 */
@ProviderType
public class AdminTasksLocalServiceWrapper implements AdminTasksLocalService,
	ServiceWrapper<AdminTasksLocalService> {
	public AdminTasksLocalServiceWrapper(
		AdminTasksLocalService adminTasksLocalService) {
		_adminTasksLocalService = adminTasksLocalService;
	}

	/**
	* Adds the admin tasks to the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was added
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks addAdminTasks(
		com.delphi.userprofile.model.AdminTasks adminTasks) {
		return _adminTasksLocalService.addAdminTasks(adminTasks);
	}

	/**
	* Creates a new admin tasks with the primary key. Does not add the admin tasks to the database.
	*
	* @param adminTasksPK the primary key for the new admin tasks
	* @return the new admin tasks
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks createAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK) {
		return _adminTasksLocalService.createAdminTasks(adminTasksPK);
	}

	/**
	* Deletes the admin tasks from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was removed
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks deleteAdminTasks(
		com.delphi.userprofile.model.AdminTasks adminTasks) {
		return _adminTasksLocalService.deleteAdminTasks(adminTasks);
	}

	/**
	* Deletes the admin tasks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks that was removed
	* @throws PortalException if a admin tasks with the primary key could not be found
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks deleteAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminTasksLocalService.deleteAdminTasks(adminTasksPK);
	}

	@Override
	public com.delphi.userprofile.model.AdminTasks fetchAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK) {
		return _adminTasksLocalService.fetchAdminTasks(adminTasksPK);
	}

	/**
	* Returns the admin tasks with the matching UUID and company.
	*
	* @param uuid the admin tasks's UUID
	* @param companyId the primary key of the company
	* @return the matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks fetchAdminTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _adminTasksLocalService.fetchAdminTasksByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the admin tasks with the primary key.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks
	* @throws PortalException if a admin tasks with the primary key could not be found
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks getAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminTasksLocalService.getAdminTasks(adminTasksPK);
	}

	/**
	* Returns the admin tasks with the matching UUID and company.
	*
	* @param uuid the admin tasks's UUID
	* @param companyId the primary key of the company
	* @return the matching admin tasks
	* @throws PortalException if a matching admin tasks could not be found
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks getAdminTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminTasksLocalService.getAdminTasksByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the admin tasks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was updated
	*/
	@Override
	public com.delphi.userprofile.model.AdminTasks updateAdminTasks(
		com.delphi.userprofile.model.AdminTasks adminTasks) {
		return _adminTasksLocalService.updateAdminTasks(adminTasks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _adminTasksLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adminTasksLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _adminTasksLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _adminTasksLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminTasksLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminTasksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of admin taskses.
	*
	* @return the number of admin taskses
	*/
	@Override
	public int getAdminTasksesCount() {
		return _adminTasksLocalService.getAdminTasksesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _adminTasksLocalService.getOSGiServiceIdentifier();
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
		return _adminTasksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _adminTasksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _adminTasksLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the admin taskses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin taskses
	* @param end the upper bound of the range of admin taskses (not inclusive)
	* @return the range of admin taskses
	*/
	@Override
	public java.util.List<com.delphi.userprofile.model.AdminTasks> getAdminTaskses(
		int start, int end) {
		return _adminTasksLocalService.getAdminTaskses(start, end);
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
		return _adminTasksLocalService.dynamicQueryCount(dynamicQuery);
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
		return _adminTasksLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public AdminTasksLocalService getWrappedService() {
		return _adminTasksLocalService;
	}

	@Override
	public void setWrappedService(AdminTasksLocalService adminTasksLocalService) {
		_adminTasksLocalService = adminTasksLocalService;
	}

	private AdminTasksLocalService _adminTasksLocalService;
}