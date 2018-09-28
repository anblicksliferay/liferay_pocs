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
 * Provides a wrapper for {@link courseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see courseLocalService
 * @generated
 */
@ProviderType
public class courseLocalServiceWrapper implements courseLocalService,
	ServiceWrapper<courseLocalService> {
	public courseLocalServiceWrapper(courseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	@Override
	public boolean haslocationcourse(long locationId, long courseId) {
		return _courseLocalService.haslocationcourse(locationId, courseId);
	}

	@Override
	public boolean haslocationcourses(long locationId) {
		return _courseLocalService.haslocationcourses(locationId);
	}

	@Override
	public boolean hasregistrationDetailscourse(long registrationId,
		long courseId) {
		return _courseLocalService.hasregistrationDetailscourse(registrationId,
			courseId);
	}

	@Override
	public boolean hasregistrationDetailscourses(long registrationId) {
		return _courseLocalService.hasregistrationDetailscourses(registrationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _courseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _courseLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _courseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the course to the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was added
	*/
	@Override
	public com.servicemapping.model.course addcourse(
		com.servicemapping.model.course course) {
		return _courseLocalService.addcourse(course);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	@Override
	public com.servicemapping.model.course createcourse(long courseId) {
		return _courseLocalService.createcourse(courseId);
	}

	/**
	* Deletes the course from the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was removed
	*/
	@Override
	public com.servicemapping.model.course deletecourse(
		com.servicemapping.model.course course) {
		return _courseLocalService.deletecourse(course);
	}

	/**
	* Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws PortalException if a course with the primary key could not be found
	*/
	@Override
	public com.servicemapping.model.course deletecourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseLocalService.deletecourse(courseId);
	}

	@Override
	public com.servicemapping.model.course fetchcourse(long courseId) {
		return _courseLocalService.fetchcourse(courseId);
	}

	/**
	* Returns the course matching the UUID and group.
	*
	* @param uuid the course's UUID
	* @param groupId the primary key of the group
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	@Override
	public com.servicemapping.model.course fetchcourseByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _courseLocalService.fetchcourseByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the course with the primary key.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws PortalException if a course with the primary key could not be found
	*/
	@Override
	public com.servicemapping.model.course getcourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseLocalService.getcourse(courseId);
	}

	/**
	* Returns the course matching the UUID and group.
	*
	* @param uuid the course's UUID
	* @param groupId the primary key of the group
	* @return the matching course
	* @throws PortalException if a matching course could not be found
	*/
	@Override
	public com.servicemapping.model.course getcourseByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseLocalService.getcourseByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was updated
	*/
	@Override
	public com.servicemapping.model.course updatecourse(
		com.servicemapping.model.course course) {
		return _courseLocalService.updatecourse(course);
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	@Override
	public int getcoursesCount() {
		return _courseLocalService.getcoursesCount();
	}

	@Override
	public int getlocationcoursesCount(long locationId) {
		return _courseLocalService.getlocationcoursesCount(locationId);
	}

	@Override
	public int getregistrationDetailscoursesCount(long registrationId) {
		return _courseLocalService.getregistrationDetailscoursesCount(registrationId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _courseLocalService.getOSGiServiceIdentifier();
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
		return _courseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	*/
	@Override
	public java.util.List<com.servicemapping.model.course> getcourses(
		int start, int end) {
		return _courseLocalService.getcourses(start, end);
	}

	/**
	* Returns all the courses matching the UUID and company.
	*
	* @param uuid the UUID of the courses
	* @param companyId the primary key of the company
	* @return the matching courses, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.servicemapping.model.course> getcoursesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _courseLocalService.getcoursesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of courses matching the UUID and company.
	*
	* @param uuid the UUID of the courses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching courses, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.servicemapping.model.course> getcoursesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.course> orderByComparator) {
		return _courseLocalService.getcoursesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.servicemapping.model.course> getlocationcourses(
		long locationId) {
		return _courseLocalService.getlocationcourses(locationId);
	}

	@Override
	public java.util.List<com.servicemapping.model.course> getlocationcourses(
		long locationId, int start, int end) {
		return _courseLocalService.getlocationcourses(locationId, start, end);
	}

	@Override
	public java.util.List<com.servicemapping.model.course> getlocationcourses(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.course> orderByComparator) {
		return _courseLocalService.getlocationcourses(locationId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.servicemapping.model.course> getregistrationDetailscourses(
		long registrationId) {
		return _courseLocalService.getregistrationDetailscourses(registrationId);
	}

	@Override
	public java.util.List<com.servicemapping.model.course> getregistrationDetailscourses(
		long registrationId, int start, int end) {
		return _courseLocalService.getregistrationDetailscourses(registrationId,
			start, end);
	}

	@Override
	public java.util.List<com.servicemapping.model.course> getregistrationDetailscourses(
		long registrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.course> orderByComparator) {
		return _courseLocalService.getregistrationDetailscourses(registrationId,
			start, end, orderByComparator);
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
		return _courseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the locationIds of the locations associated with the course.
	*
	* @param courseId the courseId of the course
	* @return long[] the locationIds of locations associated with the course
	*/
	@Override
	public long[] getlocationPrimaryKeys(long courseId) {
		return _courseLocalService.getlocationPrimaryKeys(courseId);
	}

	/**
	* Returns the registrationIds of the registration detailses associated with the course.
	*
	* @param courseId the courseId of the course
	* @return long[] the registrationIds of registration detailses associated with the course
	*/
	@Override
	public long[] getregistrationDetailsPrimaryKeys(long courseId) {
		return _courseLocalService.getregistrationDetailsPrimaryKeys(courseId);
	}

	@Override
	public void addlocationcourse(long locationId,
		com.servicemapping.model.course course) {
		_courseLocalService.addlocationcourse(locationId, course);
	}

	@Override
	public void addlocationcourse(long locationId, long courseId) {
		_courseLocalService.addlocationcourse(locationId, courseId);
	}

	@Override
	public void addlocationcourses(long locationId,
		java.util.List<com.servicemapping.model.course> courses) {
		_courseLocalService.addlocationcourses(locationId, courses);
	}

	@Override
	public void addlocationcourses(long locationId, long[] courseIds) {
		_courseLocalService.addlocationcourses(locationId, courseIds);
	}

	@Override
	public void addregistrationDetailscourse(long registrationId,
		com.servicemapping.model.course course) {
		_courseLocalService.addregistrationDetailscourse(registrationId, course);
	}

	@Override
	public void addregistrationDetailscourse(long registrationId, long courseId) {
		_courseLocalService.addregistrationDetailscourse(registrationId,
			courseId);
	}

	@Override
	public void addregistrationDetailscourses(long registrationId,
		java.util.List<com.servicemapping.model.course> courses) {
		_courseLocalService.addregistrationDetailscourses(registrationId,
			courses);
	}

	@Override
	public void addregistrationDetailscourses(long registrationId,
		long[] courseIds) {
		_courseLocalService.addregistrationDetailscourses(registrationId,
			courseIds);
	}

	@Override
	public void clearlocationcourses(long locationId) {
		_courseLocalService.clearlocationcourses(locationId);
	}

	@Override
	public void clearregistrationDetailscourses(long registrationId) {
		_courseLocalService.clearregistrationDetailscourses(registrationId);
	}

	@Override
	public void deletelocationcourse(long locationId,
		com.servicemapping.model.course course) {
		_courseLocalService.deletelocationcourse(locationId, course);
	}

	@Override
	public void deletelocationcourse(long locationId, long courseId) {
		_courseLocalService.deletelocationcourse(locationId, courseId);
	}

	@Override
	public void deletelocationcourses(long locationId,
		java.util.List<com.servicemapping.model.course> courses) {
		_courseLocalService.deletelocationcourses(locationId, courses);
	}

	@Override
	public void deletelocationcourses(long locationId, long[] courseIds) {
		_courseLocalService.deletelocationcourses(locationId, courseIds);
	}

	@Override
	public void deleteregistrationDetailscourse(long registrationId,
		com.servicemapping.model.course course) {
		_courseLocalService.deleteregistrationDetailscourse(registrationId,
			course);
	}

	@Override
	public void deleteregistrationDetailscourse(long registrationId,
		long courseId) {
		_courseLocalService.deleteregistrationDetailscourse(registrationId,
			courseId);
	}

	@Override
	public void deleteregistrationDetailscourses(long registrationId,
		java.util.List<com.servicemapping.model.course> courses) {
		_courseLocalService.deleteregistrationDetailscourses(registrationId,
			courses);
	}

	@Override
	public void deleteregistrationDetailscourses(long registrationId,
		long[] courseIds) {
		_courseLocalService.deleteregistrationDetailscourses(registrationId,
			courseIds);
	}

	@Override
	public void setlocationcourses(long locationId, long[] courseIds) {
		_courseLocalService.setlocationcourses(locationId, courseIds);
	}

	@Override
	public void setregistrationDetailscourses(long registrationId,
		long[] courseIds) {
		_courseLocalService.setregistrationDetailscourses(registrationId,
			courseIds);
	}

	@Override
	public courseLocalService getWrappedService() {
		return _courseLocalService;
	}

	@Override
	public void setWrappedService(courseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	private courseLocalService _courseLocalService;
}