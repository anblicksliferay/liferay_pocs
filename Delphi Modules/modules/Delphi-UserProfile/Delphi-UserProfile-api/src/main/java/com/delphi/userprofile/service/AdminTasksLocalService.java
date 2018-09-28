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

import com.delphi.userprofile.model.AdminTasks;
import com.delphi.userprofile.service.persistence.AdminTasksPK;

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
 * Provides the local service interface for AdminTasks. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasksLocalServiceUtil
 * @see com.delphi.userprofile.service.base.AdminTasksLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.impl.AdminTasksLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AdminTasksLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdminTasksLocalServiceUtil} to access the admin tasks local service. Add custom service methods to {@link com.delphi.userprofile.service.impl.AdminTasksLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the admin tasks to the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AdminTasks addAdminTasks(AdminTasks adminTasks);

	/**
	* Creates a new admin tasks with the primary key. Does not add the admin tasks to the database.
	*
	* @param adminTasksPK the primary key for the new admin tasks
	* @return the new admin tasks
	*/
	public AdminTasks createAdminTasks(AdminTasksPK adminTasksPK);

	/**
	* Deletes the admin tasks from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public AdminTasks deleteAdminTasks(AdminTasks adminTasks);

	/**
	* Deletes the admin tasks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks that was removed
	* @throws PortalException if a admin tasks with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public AdminTasks deleteAdminTasks(AdminTasksPK adminTasksPK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AdminTasks fetchAdminTasks(AdminTasksPK adminTasksPK);

	/**
	* Returns the admin tasks with the matching UUID and company.
	*
	* @param uuid the admin tasks's UUID
	* @param companyId the primary key of the company
	* @return the matching admin tasks, or <code>null</code> if a matching admin tasks could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AdminTasks fetchAdminTasksByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns the admin tasks with the primary key.
	*
	* @param adminTasksPK the primary key of the admin tasks
	* @return the admin tasks
	* @throws PortalException if a admin tasks with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AdminTasks getAdminTasks(AdminTasksPK adminTasksPK)
		throws PortalException;

	/**
	* Returns the admin tasks with the matching UUID and company.
	*
	* @param uuid the admin tasks's UUID
	* @param companyId the primary key of the company
	* @return the matching admin tasks
	* @throws PortalException if a matching admin tasks could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AdminTasks getAdminTasksByUuidAndCompanyId(java.lang.String uuid,
		long companyId) throws PortalException;

	/**
	* Updates the admin tasks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminTasks the admin tasks
	* @return the admin tasks that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AdminTasks updateAdminTasks(AdminTasks adminTasks);

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
	* Returns the number of admin taskses.
	*
	* @return the number of admin taskses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAdminTasksesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.AdminTasksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AdminTasks> getAdminTaskses(int start, int end);

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