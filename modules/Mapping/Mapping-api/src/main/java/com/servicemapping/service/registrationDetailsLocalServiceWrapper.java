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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link registrationDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsLocalService
 * @generated
 */
@ProviderType
public class registrationDetailsLocalServiceWrapper
	implements registrationDetailsLocalService,
		ServiceWrapper<registrationDetailsLocalService> {
	public registrationDetailsLocalServiceWrapper(
		registrationDetailsLocalService registrationDetailsLocalService) {
		_registrationDetailsLocalService = registrationDetailsLocalService;
	}

	@Override
	public boolean hascourseregistrationDetails(long courseId,
		long registrationId) {
		return _registrationDetailsLocalService.hascourseregistrationDetails(courseId,
			registrationId);
	}

	@Override
	public boolean hascourseregistrationDetailses(long courseId) {
		return _registrationDetailsLocalService.hascourseregistrationDetailses(courseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _registrationDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registrationDetailsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _registrationDetailsLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _registrationDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the registration details to the database. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was added
	*/
	@Override
	public com.servicemapping.model.registrationDetails addregistrationDetails(
		com.servicemapping.model.registrationDetails registrationDetails) {
		return _registrationDetailsLocalService.addregistrationDetails(registrationDetails);
	}

	/**
	* Creates a new registration details with the primary key. Does not add the registration details to the database.
	*
	* @param registrationId the primary key for the new registration details
	* @return the new registration details
	*/
	@Override
	public com.servicemapping.model.registrationDetails createregistrationDetails(
		long registrationId) {
		return _registrationDetailsLocalService.createregistrationDetails(registrationId);
	}

	/**
	* Deletes the registration details from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was removed
	*/
	@Override
	public com.servicemapping.model.registrationDetails deleteregistrationDetails(
		com.servicemapping.model.registrationDetails registrationDetails) {
		return _registrationDetailsLocalService.deleteregistrationDetails(registrationDetails);
	}

	/**
	* Deletes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details that was removed
	* @throws PortalException if a registration details with the primary key could not be found
	*/
	@Override
	public com.servicemapping.model.registrationDetails deleteregistrationDetails(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationDetailsLocalService.deleteregistrationDetails(registrationId);
	}

	@Override
	public com.servicemapping.model.registrationDetails fetchregistrationDetails(
		long registrationId) {
		return _registrationDetailsLocalService.fetchregistrationDetails(registrationId);
	}

	/**
	* Returns the registration details matching the UUID and group.
	*
	* @param uuid the registration details's UUID
	* @param groupId the primary key of the group
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	@Override
	public com.servicemapping.model.registrationDetails fetchregistrationDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _registrationDetailsLocalService.fetchregistrationDetailsByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the registration details with the primary key.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details
	* @throws PortalException if a registration details with the primary key could not be found
	*/
	@Override
	public com.servicemapping.model.registrationDetails getregistrationDetails(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationDetailsLocalService.getregistrationDetails(registrationId);
	}

	/**
	* Returns the registration details matching the UUID and group.
	*
	* @param uuid the registration details's UUID
	* @param groupId the primary key of the group
	* @return the matching registration details
	* @throws PortalException if a matching registration details could not be found
	*/
	@Override
	public com.servicemapping.model.registrationDetails getregistrationDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationDetailsLocalService.getregistrationDetailsByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the registration details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was updated
	*/
	@Override
	public com.servicemapping.model.registrationDetails updateregistrationDetails(
		com.servicemapping.model.registrationDetails registrationDetails) {
		return _registrationDetailsLocalService.updateregistrationDetails(registrationDetails);
	}

	@Override
	public int getcourseregistrationDetailsesCount(long courseId) {
		return _registrationDetailsLocalService.getcourseregistrationDetailsesCount(courseId);
	}

	/**
	* Returns the number of registration detailses.
	*
	* @return the number of registration detailses
	*/
	@Override
	public int getregistrationDetailsesCount() {
		return _registrationDetailsLocalService.getregistrationDetailsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _registrationDetailsLocalService.getOSGiServiceIdentifier();
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
		return _registrationDetailsLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _registrationDetailsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _registrationDetailsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.servicemapping.model.registrationDetails> getcourseregistrationDetailses(
		long courseId) {
		return _registrationDetailsLocalService.getcourseregistrationDetailses(courseId);
	}

	@Override
	public java.util.List<com.servicemapping.model.registrationDetails> getcourseregistrationDetailses(
		long courseId, int start, int end) {
		return _registrationDetailsLocalService.getcourseregistrationDetailses(courseId,
			start, end);
	}

	@Override
	public java.util.List<com.servicemapping.model.registrationDetails> getcourseregistrationDetailses(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.registrationDetails> orderByComparator) {
		return _registrationDetailsLocalService.getcourseregistrationDetailses(courseId,
			start, end, orderByComparator);
	}

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
	@Override
	public java.util.List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		int start, int end) {
		return _registrationDetailsLocalService.getregistrationDetailses(start,
			end);
	}

	/**
	* Returns all the registration detailses matching the UUID and company.
	*
	* @param uuid the UUID of the registration detailses
	* @param companyId the primary key of the company
	* @return the matching registration detailses, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.servicemapping.model.registrationDetails> getregistrationDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _registrationDetailsLocalService.getregistrationDetailsesByUuidAndCompanyId(uuid,
			companyId);
	}

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
	@Override
	public java.util.List<com.servicemapping.model.registrationDetails> getregistrationDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.registrationDetails> orderByComparator) {
		return _registrationDetailsLocalService.getregistrationDetailsesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
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
		return _registrationDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _registrationDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Returns the courseIds of the courses associated with the registration details.
	*
	* @param registrationId the registrationId of the registration details
	* @return long[] the courseIds of courses associated with the registration details
	*/
	@Override
	public long[] getcoursePrimaryKeys(long registrationId) {
		return _registrationDetailsLocalService.getcoursePrimaryKeys(registrationId);
	}

	@Override
	public void addcourseregistrationDetails(long courseId,
		com.servicemapping.model.registrationDetails registrationDetails) {
		_registrationDetailsLocalService.addcourseregistrationDetails(courseId,
			registrationDetails);
	}

	@Override
	public void addcourseregistrationDetails(long courseId, long registrationId) {
		_registrationDetailsLocalService.addcourseregistrationDetails(courseId,
			registrationId);
	}

	@Override
	public void addcourseregistrationDetailses(long courseId,
		java.util.List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		_registrationDetailsLocalService.addcourseregistrationDetailses(courseId,
			registrationDetailses);
	}

	@Override
	public void addcourseregistrationDetailses(long courseId,
		long[] registrationIds) {
		_registrationDetailsLocalService.addcourseregistrationDetailses(courseId,
			registrationIds);
	}

	@Override
	public void clearcourseregistrationDetailses(long courseId) {
		_registrationDetailsLocalService.clearcourseregistrationDetailses(courseId);
	}

	@Override
	public void deletecourseregistrationDetails(long courseId,
		com.servicemapping.model.registrationDetails registrationDetails) {
		_registrationDetailsLocalService.deletecourseregistrationDetails(courseId,
			registrationDetails);
	}

	@Override
	public void deletecourseregistrationDetails(long courseId,
		long registrationId) {
		_registrationDetailsLocalService.deletecourseregistrationDetails(courseId,
			registrationId);
	}

	@Override
	public void deletecourseregistrationDetailses(long courseId,
		java.util.List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		_registrationDetailsLocalService.deletecourseregistrationDetailses(courseId,
			registrationDetailses);
	}

	@Override
	public void deletecourseregistrationDetailses(long courseId,
		long[] registrationIds) {
		_registrationDetailsLocalService.deletecourseregistrationDetailses(courseId,
			registrationIds);
	}

	@Override
	public void setcourseregistrationDetailses(long courseId,
		long[] registrationIds) {
		_registrationDetailsLocalService.setcourseregistrationDetailses(courseId,
			registrationIds);
	}

	@Override
	public registrationDetailsLocalService getWrappedService() {
		return _registrationDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		registrationDetailsLocalService registrationDetailsLocalService) {
		_registrationDetailsLocalService = registrationDetailsLocalService;
	}

	private registrationDetailsLocalService _registrationDetailsLocalService;
}