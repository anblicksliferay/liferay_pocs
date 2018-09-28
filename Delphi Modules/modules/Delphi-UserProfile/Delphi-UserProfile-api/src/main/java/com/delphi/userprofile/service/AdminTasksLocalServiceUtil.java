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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AdminTasks. This utility wraps
 * {@link com.delphi.userprofile.service.impl.AdminTasksLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasksLocalService
 * @see com.delphi.userprofile.service.base.AdminTasksLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.impl.AdminTasksLocalServiceImpl
 * @generated
 */
@ProviderType
public class AdminTasksLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.delphi.userprofile.service.impl.AdminTasksLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the admin tasks to the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was added
	*/
	public static com.delphi.userprofile.model.AdminTasks addAdminTasks(
		com.delphi.userprofile.model.AdminTasks adminTasks) {
		return getService().addAdminTasks(adminTasks);
	}

	/**
	* Creates a new admin tasks with the primary key. Does not add the admin tasks to the database.
	*
	* @param adminTasksPK the primary key for the new admin tasks
	* @return the new admin tasks
	*/
	public static com.delphi.userprofile.model.AdminTasks createAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK) {
		return getService().createAdminTasks(adminTasksPK);
	}

	/**
	* Deletes the admin tasks from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was removed
	*/
	public static com.delphi.userprofile.model.AdminTasks deleteAdminTasks(
		com.delphi.userprofile.model.AdminTasks adminTasks) {
		return getService().deleteAdminTasks(adminTasks);
	}

	/**
	* Deletes the admin tasks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks that was removed
	* @throws PortalException if a admin tasks with the primary key could not be found
	*/
	public static com.delphi.userprofile.model.AdminTasks deleteAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAdminTasks(adminTasksPK);
	}

	public static com.delphi.userprofile.model.AdminTasks fetchAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK) {
		return getService().fetchAdminTasks(adminTasksPK);
	}

	/**
	* Returns the admin tasks with the matching UUID and company.
	*
	* @param uuid the admin tasks's UUID
	* @param companyId the primary key of the company
	* @return the matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	public static com.delphi.userprofile.model.AdminTasks fetchAdminTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().fetchAdminTasksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the admin tasks with the primary key.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks
	* @throws PortalException if a admin tasks with the primary key could not be found
	*/
	public static com.delphi.userprofile.model.AdminTasks getAdminTasks(
		com.delphi.userprofile.service.persistence.AdminTasksPK adminTasksPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAdminTasks(adminTasksPK);
	}

	/**
	* Returns the admin tasks with the matching UUID and company.
	*
	* @param uuid the admin tasks's UUID
	* @param companyId the primary key of the company
	* @return the matching admin tasks
	* @throws PortalException if a matching admin tasks could not be found
	*/
	public static com.delphi.userprofile.model.AdminTasks getAdminTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAdminTasksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the admin tasks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was updated
	*/
	public static com.delphi.userprofile.model.AdminTasks updateAdminTasks(
		com.delphi.userprofile.model.AdminTasks adminTasks) {
		return getService().updateAdminTasks(adminTasks);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of admin taskses.
	*
	* @return the number of admin taskses
	*/
	public static int getAdminTasksesCount() {
		return getService().getAdminTasksesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<com.delphi.userprofile.model.AdminTasks> getAdminTaskses(
		int start, int end) {
		return getService().getAdminTaskses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AdminTasksLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AdminTasksLocalService, AdminTasksLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AdminTasksLocalService.class);
}