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

import com.all.ddtiservice.model.course;

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
 * Provides the local service interface for course. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see courseLocalServiceUtil
 * @see com.all.ddtiservice.service.base.courseLocalServiceBaseImpl
 * @see com.all.ddtiservice.service.impl.courseLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface courseLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link courseLocalServiceUtil} to access the course local service. Add custom service methods to {@link com.all.ddtiservice.service.impl.courseLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean haslocationcourse(long locationId, long courseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean haslocationcourses(long locationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasregistrationDetailscourse(long registrationId,
		long courseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasregistrationDetailscourses(long registrationId);

	/**
	* Adds the course to the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public course addcourse(course course);

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public course createcourse(long courseId);

	/**
	* Deletes the course from the database. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public course deletecourse(course course);

	/**
	* Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws PortalException if a course with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public course deletecourse(long courseId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public course fetchcourse(long courseId);

	/**
	* Returns the course matching the UUID and group.
	*
	* @param uuid the course's UUID
	* @param groupId the primary key of the group
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public course fetchcourseByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the course with the primary key.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws PortalException if a course with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public course getcourse(long courseId) throws PortalException;

	/**
	* Returns the course matching the UUID and group.
	*
	* @param uuid the course's UUID
	* @param groupId the primary key of the group
	* @return the matching course
	* @throws PortalException if a matching course could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public course getcourseByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	/**
	* Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param course the course
	* @return the course that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public course updatecourse(course course);

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
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getcoursesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getlocationcoursesCount(long locationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getregistrationDetailscoursesCount(long registrationId);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getcourses(int start, int end);

	/**
	* Returns all the courses matching the UUID and company.
	*
	* @param uuid the UUID of the courses
	* @param companyId the primary key of the company
	* @return the matching courses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getcoursesByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getcoursesByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<course> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getlocationcourses(long locationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getlocationcourses(long locationId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getlocationcourses(long locationId, int start, int end,
		OrderByComparator<course> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getregistrationDetailscourses(long registrationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getregistrationDetailscourses(long registrationId,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<course> getregistrationDetailscourses(long registrationId,
		int start, int end, OrderByComparator<course> orderByComparator);

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
	* Returns the locationIds of the locations associated with the course.
	*
	* @param courseId the courseId of the course
	* @return long[] the locationIds of locations associated with the course
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getlocationPrimaryKeys(long courseId);

	/**
	* Returns the registrationIds of the registration detailses associated with the course.
	*
	* @param courseId the courseId of the course
	* @return long[] the registrationIds of registration detailses associated with the course
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getregistrationDetailsPrimaryKeys(long courseId);

	public void addlocationcourse(long locationId, course course);

	public void addlocationcourse(long locationId, long courseId);

	public void addlocationcourses(long locationId, List<course> courses);

	public void addlocationcourses(long locationId, long[] courseIds);

	public void addregistrationDetailscourse(long registrationId, course course);

	public void addregistrationDetailscourse(long registrationId, long courseId);

	public void addregistrationDetailscourses(long registrationId,
		List<course> courses);

	public void addregistrationDetailscourses(long registrationId,
		long[] courseIds);

	public void clearlocationcourses(long locationId);

	public void clearregistrationDetailscourses(long registrationId);

	public void deletelocationcourse(long locationId, course course);

	public void deletelocationcourse(long locationId, long courseId);

	public void deletelocationcourses(long locationId, List<course> courses);

	public void deletelocationcourses(long locationId, long[] courseIds);

	public void deleteregistrationDetailscourse(long registrationId,
		course course);

	public void deleteregistrationDetailscourse(long registrationId,
		long courseId);

	public void deleteregistrationDetailscourses(long registrationId,
		List<course> courses);

	public void deleteregistrationDetailscourses(long registrationId,
		long[] courseIds);

	public void setlocationcourses(long locationId, long[] courseIds);

	public void setregistrationDetailscourses(long registrationId,
		long[] courseIds);
}