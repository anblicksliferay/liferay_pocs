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

package com.all.ddtiservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for course. This utility wraps
 * {@link com.all.ddtiservice.service.impl.courseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see courseLocalService
 * @see com.all.ddtiservice.service.base.courseLocalServiceBaseImpl
 * @see com.all.ddtiservice.service.impl.courseLocalServiceImpl
 * @generated
 */
@ProviderType
public class courseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.all.ddtiservice.service.impl.courseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean haslocationcourse(long locationId, long courseId) {
		return getService().haslocationcourse(locationId, courseId);
	}

	public static boolean haslocationcourses(long locationId) {
		return getService().haslocationcourses(locationId);
	}

	public static boolean hasregistrationDetailscourse(long registrationId,
		long courseId) {
		return getService()
				   .hasregistrationDetailscourse(registrationId, courseId);
	}

	public static boolean hasregistrationDetailscourses(long registrationId) {
		return getService().hasregistrationDetailscourses(registrationId);
	}

	/**
	* Adds the course to the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was added
	*/
	public static com.all.ddtiservice.model.course addcourse(
		com.all.ddtiservice.model.course course) {
		return getService().addcourse(course);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static com.all.ddtiservice.model.course createcourse(long courseId) {
		return getService().createcourse(courseId);
	}

	/**
	* Deletes the course from the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was removed
	*/
	public static com.all.ddtiservice.model.course deletecourse(
		com.all.ddtiservice.model.course course) {
		return getService().deletecourse(course);
	}

	/**
	* Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws PortalException if a course with the primary key could not be found
	*/
	public static com.all.ddtiservice.model.course deletecourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletecourse(courseId);
	}

	public static com.all.ddtiservice.model.course fetchcourse(long courseId) {
		return getService().fetchcourse(courseId);
	}

	/**
	* Returns the course matching the UUID and group.
	*
	* @param uuid the course's UUID
	* @param groupId the primary key of the group
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static com.all.ddtiservice.model.course fetchcourseByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchcourseByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the course with the primary key.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws PortalException if a course with the primary key could not be found
	*/
	public static com.all.ddtiservice.model.course getcourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getcourse(courseId);
	}

	/**
	* Returns the course matching the UUID and group.
	*
	* @param uuid the course's UUID
	* @param groupId the primary key of the group
	* @return the matching course
	* @throws PortalException if a matching course could not be found
	*/
	public static com.all.ddtiservice.model.course getcourseByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getcourseByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was updated
	*/
	public static com.all.ddtiservice.model.course updatecourse(
		com.all.ddtiservice.model.course course) {
		return getService().updatecourse(course);
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
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	public static int getcoursesCount() {
		return getService().getcoursesCount();
	}

	public static int getlocationcoursesCount(long locationId) {
		return getService().getlocationcoursesCount(locationId);
	}

	public static int getregistrationDetailscoursesCount(long registrationId) {
		return getService().getregistrationDetailscoursesCount(registrationId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	*/
	public static java.util.List<com.all.ddtiservice.model.course> getcourses(
		int start, int end) {
		return getService().getcourses(start, end);
	}

	/**
	* Returns all the courses matching the UUID and company.
	*
	* @param uuid the UUID of the courses
	* @param companyId the primary key of the company
	* @return the matching courses, or an empty list if no matches were found
	*/
	public static java.util.List<com.all.ddtiservice.model.course> getcoursesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getcoursesByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.all.ddtiservice.model.course> getcoursesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.course> orderByComparator) {
		return getService()
				   .getcoursesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	public static java.util.List<com.all.ddtiservice.model.course> getlocationcourses(
		long locationId) {
		return getService().getlocationcourses(locationId);
	}

	public static java.util.List<com.all.ddtiservice.model.course> getlocationcourses(
		long locationId, int start, int end) {
		return getService().getlocationcourses(locationId, start, end);
	}

	public static java.util.List<com.all.ddtiservice.model.course> getlocationcourses(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.course> orderByComparator) {
		return getService()
				   .getlocationcourses(locationId, start, end, orderByComparator);
	}

	public static java.util.List<com.all.ddtiservice.model.course> getregistrationDetailscourses(
		long registrationId) {
		return getService().getregistrationDetailscourses(registrationId);
	}

	public static java.util.List<com.all.ddtiservice.model.course> getregistrationDetailscourses(
		long registrationId, int start, int end) {
		return getService()
				   .getregistrationDetailscourses(registrationId, start, end);
	}

	public static java.util.List<com.all.ddtiservice.model.course> getregistrationDetailscourses(
		long registrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.course> orderByComparator) {
		return getService()
				   .getregistrationDetailscourses(registrationId, start, end,
			orderByComparator);
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

	/**
	* Returns the locationIds of the locations associated with the course.
	*
	* @param courseId the courseId of the course
	* @return long[] the locationIds of locations associated with the course
	*/
	public static long[] getlocationPrimaryKeys(long courseId) {
		return getService().getlocationPrimaryKeys(courseId);
	}

	/**
	* Returns the registrationIds of the registration detailses associated with the course.
	*
	* @param courseId the courseId of the course
	* @return long[] the registrationIds of registration detailses associated with the course
	*/
	public static long[] getregistrationDetailsPrimaryKeys(long courseId) {
		return getService().getregistrationDetailsPrimaryKeys(courseId);
	}

	public static void addlocationcourse(long locationId,
		com.all.ddtiservice.model.course course) {
		getService().addlocationcourse(locationId, course);
	}

	public static void addlocationcourse(long locationId, long courseId) {
		getService().addlocationcourse(locationId, courseId);
	}

	public static void addlocationcourses(long locationId,
		java.util.List<com.all.ddtiservice.model.course> courses) {
		getService().addlocationcourses(locationId, courses);
	}

	public static void addlocationcourses(long locationId, long[] courseIds) {
		getService().addlocationcourses(locationId, courseIds);
	}

	public static void addregistrationDetailscourse(long registrationId,
		com.all.ddtiservice.model.course course) {
		getService().addregistrationDetailscourse(registrationId, course);
	}

	public static void addregistrationDetailscourse(long registrationId,
		long courseId) {
		getService().addregistrationDetailscourse(registrationId, courseId);
	}

	public static void addregistrationDetailscourses(long registrationId,
		java.util.List<com.all.ddtiservice.model.course> courses) {
		getService().addregistrationDetailscourses(registrationId, courses);
	}

	public static void addregistrationDetailscourses(long registrationId,
		long[] courseIds) {
		getService().addregistrationDetailscourses(registrationId, courseIds);
	}

	public static void clearlocationcourses(long locationId) {
		getService().clearlocationcourses(locationId);
	}

	public static void clearregistrationDetailscourses(long registrationId) {
		getService().clearregistrationDetailscourses(registrationId);
	}

	public static void deletelocationcourse(long locationId,
		com.all.ddtiservice.model.course course) {
		getService().deletelocationcourse(locationId, course);
	}

	public static void deletelocationcourse(long locationId, long courseId) {
		getService().deletelocationcourse(locationId, courseId);
	}

	public static void deletelocationcourses(long locationId,
		java.util.List<com.all.ddtiservice.model.course> courses) {
		getService().deletelocationcourses(locationId, courses);
	}

	public static void deletelocationcourses(long locationId, long[] courseIds) {
		getService().deletelocationcourses(locationId, courseIds);
	}

	public static void deleteregistrationDetailscourse(long registrationId,
		com.all.ddtiservice.model.course course) {
		getService().deleteregistrationDetailscourse(registrationId, course);
	}

	public static void deleteregistrationDetailscourse(long registrationId,
		long courseId) {
		getService().deleteregistrationDetailscourse(registrationId, courseId);
	}

	public static void deleteregistrationDetailscourses(long registrationId,
		java.util.List<com.all.ddtiservice.model.course> courses) {
		getService().deleteregistrationDetailscourses(registrationId, courses);
	}

	public static void deleteregistrationDetailscourses(long registrationId,
		long[] courseIds) {
		getService().deleteregistrationDetailscourses(registrationId, courseIds);
	}

	public static void setlocationcourses(long locationId, long[] courseIds) {
		getService().setlocationcourses(locationId, courseIds);
	}

	public static void setregistrationDetailscourses(long registrationId,
		long[] courseIds) {
		getService().setregistrationDetailscourses(registrationId, courseIds);
	}

	public static courseLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<courseLocalService, courseLocalService> _serviceTracker =
		ServiceTrackerFactory.open(courseLocalService.class);
}