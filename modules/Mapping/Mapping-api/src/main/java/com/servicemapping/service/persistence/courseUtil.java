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

package com.servicemapping.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.servicemapping.model.course;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link com.servicemapping.service.persistence.impl.coursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see coursePersistence
 * @see com.servicemapping.service.persistence.impl.coursePersistenceImpl
 * @generated
 */
@ProviderType
public class courseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(course course) {
		getPersistence().clearCache(course);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<course> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<course> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static course update(course course) {
		return getPersistence().update(course);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static course update(course course, ServiceContext serviceContext) {
		return getPersistence().update(course, serviceContext);
	}

	/**
	* Returns all the courses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching courses
	*/
	public static List<course> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the courses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	*/
	public static List<course> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the courses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	*/
	public static List<course> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<course> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the courses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching courses
	*/
	public static List<course> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<course> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public static course findByUuid_First(java.lang.String uuid,
		OrderByComparator<course> orderByComparator)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public static course fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<course> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public static course findByUuid_Last(java.lang.String uuid,
		OrderByComparator<course> orderByComparator)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public static course fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<course> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the courses before and after the current course in the ordered set where uuid = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public static course[] findByUuid_PrevAndNext(long courseId,
		java.lang.String uuid, OrderByComparator<course> orderByComparator)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence()
				   .findByUuid_PrevAndNext(courseId, uuid, orderByComparator);
	}

	/**
	* Removes all the courses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of courses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching courses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the course where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchcourseException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public static course findByUUID_G(java.lang.String uuid, long groupId)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static course fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static course fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the course where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the course that was removed
	*/
	public static course removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of courses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching courses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the courses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching courses
	*/
	public static List<course> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the courses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	*/
	public static List<course> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the courses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	*/
	public static List<course> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<course> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the courses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching courses
	*/
	public static List<course> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<course> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public static course findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<course> orderByComparator)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public static course fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<course> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public static course findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<course> orderByComparator)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public static course fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<course> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the courses before and after the current course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public static course[] findByUuid_C_PrevAndNext(long courseId,
		java.lang.String uuid, long companyId,
		OrderByComparator<course> orderByComparator)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(courseId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the courses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of courses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching courses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public static void cacheResult(course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public static void cacheResult(List<course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static course create(long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public static course remove(long courseId)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence().remove(courseId);
	}

	public static course updateImpl(course course) {
		return getPersistence().updateImpl(course);
	}

	/**
	* Returns the course with the primary key or throws a {@link NoSuchcourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public static course findByPrimaryKey(long courseId)
		throws com.servicemapping.exception.NoSuchcourseException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	*/
	public static course fetchByPrimaryKey(long courseId) {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	public static java.util.Map<java.io.Serializable, course> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the courses.
	*
	* @return the courses
	*/
	public static List<course> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	*/
	public static List<course> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	*/
	public static List<course> findAll(int start, int end,
		OrderByComparator<course> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of courses
	*/
	public static List<course> findAll(int start, int end,
		OrderByComparator<course> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the courses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of locations associated with the course.
	*
	* @param pk the primary key of the course
	* @return long[] of the primaryKeys of locations associated with the course
	*/
	public static long[] getlocationPrimaryKeys(long pk) {
		return getPersistence().getlocationPrimaryKeys(pk);
	}

	/**
	* Returns all the locations associated with the course.
	*
	* @param pk the primary key of the course
	* @return the locations associated with the course
	*/
	public static List<com.servicemapping.model.location> getlocations(long pk) {
		return getPersistence().getlocations(pk);
	}

	/**
	* Returns a range of all the locations associated with the course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the course
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of locations associated with the course
	*/
	public static List<com.servicemapping.model.location> getlocations(
		long pk, int start, int end) {
		return getPersistence().getlocations(pk, start, end);
	}

	/**
	* Returns an ordered range of all the locations associated with the course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the course
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locations associated with the course
	*/
	public static List<com.servicemapping.model.location> getlocations(
		long pk, int start, int end,
		OrderByComparator<com.servicemapping.model.location> orderByComparator) {
		return getPersistence().getlocations(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of locations associated with the course.
	*
	* @param pk the primary key of the course
	* @return the number of locations associated with the course
	*/
	public static int getlocationsSize(long pk) {
		return getPersistence().getlocationsSize(pk);
	}

	/**
	* Returns <code>true</code> if the location is associated with the course.
	*
	* @param pk the primary key of the course
	* @param locationPK the primary key of the location
	* @return <code>true</code> if the location is associated with the course; <code>false</code> otherwise
	*/
	public static boolean containslocation(long pk, long locationPK) {
		return getPersistence().containslocation(pk, locationPK);
	}

	/**
	* Returns <code>true</code> if the course has any locations associated with it.
	*
	* @param pk the primary key of the course to check for associations with locations
	* @return <code>true</code> if the course has any locations associated with it; <code>false</code> otherwise
	*/
	public static boolean containslocations(long pk) {
		return getPersistence().containslocations(pk);
	}

	/**
	* Adds an association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPK the primary key of the location
	*/
	public static void addlocation(long pk, long locationPK) {
		getPersistence().addlocation(pk, locationPK);
	}

	/**
	* Adds an association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param location the location
	*/
	public static void addlocation(long pk,
		com.servicemapping.model.location location) {
		getPersistence().addlocation(pk, location);
	}

	/**
	* Adds an association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPKs the primary keys of the locations
	*/
	public static void addlocations(long pk, long[] locationPKs) {
		getPersistence().addlocations(pk, locationPKs);
	}

	/**
	* Adds an association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locations the locations
	*/
	public static void addlocations(long pk,
		List<com.servicemapping.model.location> locations) {
		getPersistence().addlocations(pk, locations);
	}

	/**
	* Clears all associations between the course and its locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course to clear the associated locations from
	*/
	public static void clearlocations(long pk) {
		getPersistence().clearlocations(pk);
	}

	/**
	* Removes the association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPK the primary key of the location
	*/
	public static void removelocation(long pk, long locationPK) {
		getPersistence().removelocation(pk, locationPK);
	}

	/**
	* Removes the association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param location the location
	*/
	public static void removelocation(long pk,
		com.servicemapping.model.location location) {
		getPersistence().removelocation(pk, location);
	}

	/**
	* Removes the association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPKs the primary keys of the locations
	*/
	public static void removelocations(long pk, long[] locationPKs) {
		getPersistence().removelocations(pk, locationPKs);
	}

	/**
	* Removes the association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locations the locations
	*/
	public static void removelocations(long pk,
		List<com.servicemapping.model.location> locations) {
		getPersistence().removelocations(pk, locations);
	}

	/**
	* Sets the locations associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPKs the primary keys of the locations to be associated with the course
	*/
	public static void setlocations(long pk, long[] locationPKs) {
		getPersistence().setlocations(pk, locationPKs);
	}

	/**
	* Sets the locations associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locations the locations to be associated with the course
	*/
	public static void setlocations(long pk,
		List<com.servicemapping.model.location> locations) {
		getPersistence().setlocations(pk, locations);
	}

	/**
	* Returns the primaryKeys of registration detailses associated with the course.
	*
	* @param pk the primary key of the course
	* @return long[] of the primaryKeys of registration detailses associated with the course
	*/
	public static long[] getregistrationDetailsPrimaryKeys(long pk) {
		return getPersistence().getregistrationDetailsPrimaryKeys(pk);
	}

	/**
	* Returns all the registration detailses associated with the course.
	*
	* @param pk the primary key of the course
	* @return the registration detailses associated with the course
	*/
	public static List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		long pk) {
		return getPersistence().getregistrationDetailses(pk);
	}

	/**
	* Returns a range of all the registration detailses associated with the course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the course
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of registration detailses associated with the course
	*/
	public static List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		long pk, int start, int end) {
		return getPersistence().getregistrationDetailses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the registration detailses associated with the course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link courseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the course
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of registration detailses associated with the course
	*/
	public static List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		long pk, int start, int end,
		OrderByComparator<com.servicemapping.model.registrationDetails> orderByComparator) {
		return getPersistence()
				   .getregistrationDetailses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of registration detailses associated with the course.
	*
	* @param pk the primary key of the course
	* @return the number of registration detailses associated with the course
	*/
	public static int getregistrationDetailsesSize(long pk) {
		return getPersistence().getregistrationDetailsesSize(pk);
	}

	/**
	* Returns <code>true</code> if the registration details is associated with the course.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPK the primary key of the registration details
	* @return <code>true</code> if the registration details is associated with the course; <code>false</code> otherwise
	*/
	public static boolean containsregistrationDetails(long pk,
		long registrationDetailsPK) {
		return getPersistence()
				   .containsregistrationDetails(pk, registrationDetailsPK);
	}

	/**
	* Returns <code>true</code> if the course has any registration detailses associated with it.
	*
	* @param pk the primary key of the course to check for associations with registration detailses
	* @return <code>true</code> if the course has any registration detailses associated with it; <code>false</code> otherwise
	*/
	public static boolean containsregistrationDetailses(long pk) {
		return getPersistence().containsregistrationDetailses(pk);
	}

	/**
	* Adds an association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPK the primary key of the registration details
	*/
	public static void addregistrationDetails(long pk,
		long registrationDetailsPK) {
		getPersistence().addregistrationDetails(pk, registrationDetailsPK);
	}

	/**
	* Adds an association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetails the registration details
	*/
	public static void addregistrationDetails(long pk,
		com.servicemapping.model.registrationDetails registrationDetails) {
		getPersistence().addregistrationDetails(pk, registrationDetails);
	}

	/**
	* Adds an association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPKs the primary keys of the registration detailses
	*/
	public static void addregistrationDetailses(long pk,
		long[] registrationDetailsPKs) {
		getPersistence().addregistrationDetailses(pk, registrationDetailsPKs);
	}

	/**
	* Adds an association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailses the registration detailses
	*/
	public static void addregistrationDetailses(long pk,
		List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		getPersistence().addregistrationDetailses(pk, registrationDetailses);
	}

	/**
	* Clears all associations between the course and its registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course to clear the associated registration detailses from
	*/
	public static void clearregistrationDetailses(long pk) {
		getPersistence().clearregistrationDetailses(pk);
	}

	/**
	* Removes the association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPK the primary key of the registration details
	*/
	public static void removeregistrationDetails(long pk,
		long registrationDetailsPK) {
		getPersistence().removeregistrationDetails(pk, registrationDetailsPK);
	}

	/**
	* Removes the association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetails the registration details
	*/
	public static void removeregistrationDetails(long pk,
		com.servicemapping.model.registrationDetails registrationDetails) {
		getPersistence().removeregistrationDetails(pk, registrationDetails);
	}

	/**
	* Removes the association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPKs the primary keys of the registration detailses
	*/
	public static void removeregistrationDetailses(long pk,
		long[] registrationDetailsPKs) {
		getPersistence().removeregistrationDetailses(pk, registrationDetailsPKs);
	}

	/**
	* Removes the association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailses the registration detailses
	*/
	public static void removeregistrationDetailses(long pk,
		List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		getPersistence().removeregistrationDetailses(pk, registrationDetailses);
	}

	/**
	* Sets the registration detailses associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPKs the primary keys of the registration detailses to be associated with the course
	*/
	public static void setregistrationDetailses(long pk,
		long[] registrationDetailsPKs) {
		getPersistence().setregistrationDetailses(pk, registrationDetailsPKs);
	}

	/**
	* Sets the registration detailses associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailses the registration detailses to be associated with the course
	*/
	public static void setregistrationDetailses(long pk,
		List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		getPersistence().setregistrationDetailses(pk, registrationDetailses);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static coursePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<coursePersistence, coursePersistence> _serviceTracker =
		ServiceTrackerFactory.open(coursePersistence.class);
}