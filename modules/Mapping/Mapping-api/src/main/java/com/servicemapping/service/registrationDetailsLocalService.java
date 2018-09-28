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

package com.servicemapping.service;

import aQute.bnd.annotation.ProviderType;

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

import com.servicemapping.model.registrationDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for registrationDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsLocalServiceUtil
 * @see com.servicemapping.service.base.registrationDetailsLocalServiceBaseImpl
 * @see com.servicemapping.service.impl.registrationDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface registrationDetailsLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link registrationDetailsLocalServiceUtil} to access the registration details local service. Add custom service methods to {@link com.servicemapping.service.impl.registrationDetailsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hascourseregistrationDetails(long courseId,
		long registrationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hascourseregistrationDetailses(long courseId);

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
	* Adds the registration details to the database. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public registrationDetails addregistrationDetails(
		registrationDetails registrationDetails);

	/**
	* Creates a new registration details with the primary key. Does not add the registration details to the database.
	*
	* @param registrationId the primary key for the new registration details
	* @return the new registration details
	*/
	public registrationDetails createregistrationDetails(long registrationId);

	/**
	* Deletes the registration details from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public registrationDetails deleteregistrationDetails(
		registrationDetails registrationDetails);

	/**
	* Deletes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details that was removed
	* @throws PortalException if a registration details with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public registrationDetails deleteregistrationDetails(long registrationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public registrationDetails fetchregistrationDetails(long registrationId);

	/**
	* Returns the registration details matching the UUID and group.
	*
	* @param uuid the registration details's UUID
	* @param groupId the primary key of the group
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public registrationDetails fetchregistrationDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the registration details with the primary key.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details
	* @throws PortalException if a registration details with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public registrationDetails getregistrationDetails(long registrationId)
		throws PortalException;

	/**
	* Returns the registration details matching the UUID and group.
	*
	* @param uuid the registration details's UUID
	* @param groupId the primary key of the group
	* @return the matching registration details
	* @throws PortalException if a matching registration details could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public registrationDetails getregistrationDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the registration details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public registrationDetails updateregistrationDetails(
		registrationDetails registrationDetails);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getcourseregistrationDetailsesCount(long courseId);

	/**
	* Returns the number of registration detailses.
	*
	* @return the number of registration detailses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getregistrationDetailsesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<registrationDetails> getcourseregistrationDetailses(
		long courseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<registrationDetails> getcourseregistrationDetailses(
		long courseId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<registrationDetails> getcourseregistrationDetailses(
		long courseId, int start, int end,
		OrderByComparator<registrationDetails> orderByComparator);

	/**
	* Returns a range of all the registration detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @return the range of registration detailses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<registrationDetails> getregistrationDetailses(int start, int end);

	/**
	* Returns all the registration detailses matching the UUID and company.
	*
	* @param uuid the UUID of the registration detailses
	* @param companyId the primary key of the company
	* @return the matching registration detailses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<registrationDetails> getregistrationDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of registration detailses matching the UUID and company.
	*
	* @param uuid the UUID of the registration detailses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching registration detailses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<registrationDetails> getregistrationDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<registrationDetails> orderByComparator);

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

	/**
	* Returns the courseIds of the courses associated with the registration details.
	*
	* @param registrationId the registrationId of the registration details
	* @return long[] the courseIds of courses associated with the registration details
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getcoursePrimaryKeys(long registrationId);

	public void addcourseregistrationDetails(long courseId,
		registrationDetails registrationDetails);

	public void addcourseregistrationDetails(long courseId, long registrationId);

	public void addcourseregistrationDetailses(long courseId,
		List<registrationDetails> registrationDetailses);

	public void addcourseregistrationDetailses(long courseId,
		long[] registrationIds);

	public void clearcourseregistrationDetailses(long courseId);

	public void deletecourseregistrationDetails(long courseId,
		registrationDetails registrationDetails);

	public void deletecourseregistrationDetails(long courseId,
		long registrationId);

	public void deletecourseregistrationDetailses(long courseId,
		List<registrationDetails> registrationDetailses);

	public void deletecourseregistrationDetailses(long courseId,
		long[] registrationIds);

	public void setcourseregistrationDetailses(long courseId,
		long[] registrationIds);
}