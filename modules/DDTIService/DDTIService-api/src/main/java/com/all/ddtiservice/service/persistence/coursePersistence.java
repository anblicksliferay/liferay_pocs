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

package com.all.ddtiservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.all.ddtiservice.exception.NoSuchcourseException;
import com.all.ddtiservice.model.course;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.all.ddtiservice.service.persistence.impl.coursePersistenceImpl
 * @see courseUtil
 * @generated
 */
@ProviderType
public interface coursePersistence extends BasePersistence<course> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link courseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the courses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching courses
	*/
	public java.util.List<course> findByUuid(java.lang.String uuid);

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
	public java.util.List<course> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<course> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

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
	public java.util.List<course> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public course findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException;

	/**
	* Returns the first course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public course fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

	/**
	* Returns the last course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public course findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException;

	/**
	* Returns the last course in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public course fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

	/**
	* Returns the courses before and after the current course in the ordered set where uuid = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public course[] findByUuid_PrevAndNext(long courseId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException;

	/**
	* Removes all the courses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of courses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching courses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the course where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchcourseException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public course findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchcourseException;

	/**
	* Returns the course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public course fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public course fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the course where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the course that was removed
	*/
	public course removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchcourseException;

	/**
	* Returns the number of courses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching courses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the courses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching courses
	*/
	public java.util.List<course> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<course> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<course> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

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
	public java.util.List<course> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public course findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException;

	/**
	* Returns the first course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public course fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

	/**
	* Returns the last course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchcourseException if a matching course could not be found
	*/
	public course findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException;

	/**
	* Returns the last course in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public course fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

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
	public course[] findByUuid_C_PrevAndNext(long courseId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException;

	/**
	* Removes all the courses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of courses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching courses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public void cacheResult(course course);

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public void cacheResult(java.util.List<course> courses);

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public course create(long courseId);

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public course remove(long courseId) throws NoSuchcourseException;

	public course updateImpl(course course);

	/**
	* Returns the course with the primary key or throws a {@link NoSuchcourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws NoSuchcourseException if a course with the primary key could not be found
	*/
	public course findByPrimaryKey(long courseId) throws NoSuchcourseException;

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	*/
	public course fetchByPrimaryKey(long courseId);

	@Override
	public java.util.Map<java.io.Serializable, course> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the courses.
	*
	* @return the courses
	*/
	public java.util.List<course> findAll();

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
	public java.util.List<course> findAll(int start, int end);

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
	public java.util.List<course> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator);

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
	public java.util.List<course> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<course> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the courses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of locations associated with the course.
	*
	* @param pk the primary key of the course
	* @return long[] of the primaryKeys of locations associated with the course
	*/
	public long[] getlocationPrimaryKeys(long pk);

	/**
	* Returns all the locations associated with the course.
	*
	* @param pk the primary key of the course
	* @return the locations associated with the course
	*/
	public java.util.List<com.all.ddtiservice.model.location> getlocations(
		long pk);

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
	public java.util.List<com.all.ddtiservice.model.location> getlocations(
		long pk, int start, int end);

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
	public java.util.List<com.all.ddtiservice.model.location> getlocations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.location> orderByComparator);

	/**
	* Returns the number of locations associated with the course.
	*
	* @param pk the primary key of the course
	* @return the number of locations associated with the course
	*/
	public int getlocationsSize(long pk);

	/**
	* Returns <code>true</code> if the location is associated with the course.
	*
	* @param pk the primary key of the course
	* @param locationPK the primary key of the location
	* @return <code>true</code> if the location is associated with the course; <code>false</code> otherwise
	*/
	public boolean containslocation(long pk, long locationPK);

	/**
	* Returns <code>true</code> if the course has any locations associated with it.
	*
	* @param pk the primary key of the course to check for associations with locations
	* @return <code>true</code> if the course has any locations associated with it; <code>false</code> otherwise
	*/
	public boolean containslocations(long pk);

	/**
	* Adds an association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPK the primary key of the location
	*/
	public void addlocation(long pk, long locationPK);

	/**
	* Adds an association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param location the location
	*/
	public void addlocation(long pk, com.all.ddtiservice.model.location location);

	/**
	* Adds an association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPKs the primary keys of the locations
	*/
	public void addlocations(long pk, long[] locationPKs);

	/**
	* Adds an association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locations the locations
	*/
	public void addlocations(long pk,
		java.util.List<com.all.ddtiservice.model.location> locations);

	/**
	* Clears all associations between the course and its locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course to clear the associated locations from
	*/
	public void clearlocations(long pk);

	/**
	* Removes the association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPK the primary key of the location
	*/
	public void removelocation(long pk, long locationPK);

	/**
	* Removes the association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param location the location
	*/
	public void removelocation(long pk,
		com.all.ddtiservice.model.location location);

	/**
	* Removes the association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPKs the primary keys of the locations
	*/
	public void removelocations(long pk, long[] locationPKs);

	/**
	* Removes the association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locations the locations
	*/
	public void removelocations(long pk,
		java.util.List<com.all.ddtiservice.model.location> locations);

	/**
	* Sets the locations associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locationPKs the primary keys of the locations to be associated with the course
	*/
	public void setlocations(long pk, long[] locationPKs);

	/**
	* Sets the locations associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param locations the locations to be associated with the course
	*/
	public void setlocations(long pk,
		java.util.List<com.all.ddtiservice.model.location> locations);

	/**
	* Returns the primaryKeys of registration detailses associated with the course.
	*
	* @param pk the primary key of the course
	* @return long[] of the primaryKeys of registration detailses associated with the course
	*/
	public long[] getregistrationDetailsPrimaryKeys(long pk);

	/**
	* Returns all the registration detailses associated with the course.
	*
	* @param pk the primary key of the course
	* @return the registration detailses associated with the course
	*/
	public java.util.List<com.all.ddtiservice.model.registrationDetails> getregistrationDetailses(
		long pk);

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
	public java.util.List<com.all.ddtiservice.model.registrationDetails> getregistrationDetailses(
		long pk, int start, int end);

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
	public java.util.List<com.all.ddtiservice.model.registrationDetails> getregistrationDetailses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.registrationDetails> orderByComparator);

	/**
	* Returns the number of registration detailses associated with the course.
	*
	* @param pk the primary key of the course
	* @return the number of registration detailses associated with the course
	*/
	public int getregistrationDetailsesSize(long pk);

	/**
	* Returns <code>true</code> if the registration details is associated with the course.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPK the primary key of the registration details
	* @return <code>true</code> if the registration details is associated with the course; <code>false</code> otherwise
	*/
	public boolean containsregistrationDetails(long pk,
		long registrationDetailsPK);

	/**
	* Returns <code>true</code> if the course has any registration detailses associated with it.
	*
	* @param pk the primary key of the course to check for associations with registration detailses
	* @return <code>true</code> if the course has any registration detailses associated with it; <code>false</code> otherwise
	*/
	public boolean containsregistrationDetailses(long pk);

	/**
	* Adds an association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPK the primary key of the registration details
	*/
	public void addregistrationDetails(long pk, long registrationDetailsPK);

	/**
	* Adds an association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetails the registration details
	*/
	public void addregistrationDetails(long pk,
		com.all.ddtiservice.model.registrationDetails registrationDetails);

	/**
	* Adds an association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPKs the primary keys of the registration detailses
	*/
	public void addregistrationDetailses(long pk, long[] registrationDetailsPKs);

	/**
	* Adds an association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailses the registration detailses
	*/
	public void addregistrationDetailses(long pk,
		java.util.List<com.all.ddtiservice.model.registrationDetails> registrationDetailses);

	/**
	* Clears all associations between the course and its registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course to clear the associated registration detailses from
	*/
	public void clearregistrationDetailses(long pk);

	/**
	* Removes the association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPK the primary key of the registration details
	*/
	public void removeregistrationDetails(long pk, long registrationDetailsPK);

	/**
	* Removes the association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetails the registration details
	*/
	public void removeregistrationDetails(long pk,
		com.all.ddtiservice.model.registrationDetails registrationDetails);

	/**
	* Removes the association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPKs the primary keys of the registration detailses
	*/
	public void removeregistrationDetailses(long pk,
		long[] registrationDetailsPKs);

	/**
	* Removes the association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailses the registration detailses
	*/
	public void removeregistrationDetailses(long pk,
		java.util.List<com.all.ddtiservice.model.registrationDetails> registrationDetailses);

	/**
	* Sets the registration detailses associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailsPKs the primary keys of the registration detailses to be associated with the course
	*/
	public void setregistrationDetailses(long pk, long[] registrationDetailsPKs);

	/**
	* Sets the registration detailses associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the course
	* @param registrationDetailses the registration detailses to be associated with the course
	*/
	public void setregistrationDetailses(long pk,
		java.util.List<com.all.ddtiservice.model.registrationDetails> registrationDetailses);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}