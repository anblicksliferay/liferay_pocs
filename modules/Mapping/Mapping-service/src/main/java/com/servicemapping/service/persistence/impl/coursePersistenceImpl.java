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

package com.servicemapping.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.servicemapping.exception.NoSuchcourseException;

import com.servicemapping.model.course;
import com.servicemapping.model.impl.courseImpl;
import com.servicemapping.model.impl.courseModelImpl;

import com.servicemapping.service.persistence.coursePersistence;
import com.servicemapping.service.persistence.locationPersistence;
import com.servicemapping.service.persistence.registrationDetailsPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see coursePersistence
 * @see com.servicemapping.service.persistence.courseUtil
 * @generated
 */
@ProviderType
public class coursePersistenceImpl extends BasePersistenceImpl<course>
	implements coursePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link courseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = courseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			courseModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the courses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching courses
	 */
	@Override
	public List<course> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<course> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<course> findByUuid(String uuid, int start, int end,
		OrderByComparator<course> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<course> findByUuid(String uuid, int start, int end,
		OrderByComparator<course> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<course> list = null;

		if (retrieveFromCache) {
			list = (List<course>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (course course : list) {
					if (!Objects.equals(uuid, course.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(courseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<course>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws NoSuchcourseException if a matching course could not be found
	 */
	@Override
	public course findByUuid_First(String uuid,
		OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException {
		course course = fetchByUuid_First(uuid, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public course fetchByUuid_First(String uuid,
		OrderByComparator<course> orderByComparator) {
		List<course> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course
	 * @throws NoSuchcourseException if a matching course could not be found
	 */
	@Override
	public course findByUuid_Last(String uuid,
		OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException {
		course course = fetchByUuid_Last(uuid, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public course fetchByUuid_Last(String uuid,
		OrderByComparator<course> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<course> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course[] findByUuid_PrevAndNext(long courseId, String uuid,
		OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException {
		course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			course[] array = new courseImpl[3];

			array[0] = getByUuid_PrevAndNext(session, course, uuid,
					orderByComparator, true);

			array[1] = course;

			array[2] = getByUuid_PrevAndNext(session, course, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected course getByUuid_PrevAndNext(Session session, course course,
		String uuid, OrderByComparator<course> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(courseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (course course : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching courses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "course.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "course.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(course.uuid IS NULL OR course.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			courseModelImpl.UUID_COLUMN_BITMASK |
			courseModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the course where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchcourseException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching course
	 * @throws NoSuchcourseException if a matching course could not be found
	 */
	@Override
	public course findByUUID_G(String uuid, long groupId)
		throws NoSuchcourseException {
		course course = fetchByUUID_G(uuid, groupId);

		if (course == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchcourseException(msg.toString());
		}

		return course;
	}

	/**
	 * Returns the course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public course fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public course fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof course) {
			course course = (course)result;

			if (!Objects.equals(uuid, course.getUuid()) ||
					(groupId != course.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<course> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					course course = list.get(0);

					result = course;

					cacheResult(course);

					if ((course.getUuid() == null) ||
							!course.getUuid().equals(uuid) ||
							(course.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, course);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (course)result;
		}
	}

	/**
	 * Removes the course where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the course that was removed
	 */
	@Override
	public course removeByUUID_G(String uuid, long groupId)
		throws NoSuchcourseException {
		course course = findByUUID_G(uuid, groupId);

		return remove(course);
	}

	/**
	 * Returns the number of courses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching courses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "course.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "course.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(course.uuid IS NULL OR course.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "course.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, courseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			courseModelImpl.UUID_COLUMN_BITMASK |
			courseModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the courses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching courses
	 */
	@Override
	public List<course> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<course> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<course> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<course> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<course> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<course> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<course> list = null;

		if (retrieveFromCache) {
			list = (List<course>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (course course : list) {
					if (!Objects.equals(uuid, course.getUuid()) ||
							(companyId != course.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(courseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<course>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public course findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException {
		course course = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public course fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<course> orderByComparator) {
		List<course> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException {
		course course = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public course fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<course> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<course> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public course[] findByUuid_C_PrevAndNext(long courseId, String uuid,
		long companyId, OrderByComparator<course> orderByComparator)
		throws NoSuchcourseException {
		course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			course[] array = new courseImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, course, uuid,
					companyId, orderByComparator, true);

			array[1] = course;

			array[2] = getByUuid_C_PrevAndNext(session, course, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected course getByUuid_C_PrevAndNext(Session session, course course,
		String uuid, long companyId,
		OrderByComparator<course> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(courseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (course course : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching courses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "course.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "course.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(course.uuid IS NULL OR course.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "course.companyId = ?";

	public coursePersistenceImpl() {
		setModelClass(course.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course
	 */
	@Override
	public void cacheResult(course course) {
		entityCache.putResult(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseImpl.class, course.getPrimaryKey(), course);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { course.getUuid(), course.getGroupId() }, course);

		course.resetOriginalValues();
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	@Override
	public void cacheResult(List<course> courses) {
		for (course course : courses) {
			if (entityCache.getResult(courseModelImpl.ENTITY_CACHE_ENABLED,
						courseImpl.class, course.getPrimaryKey()) == null) {
				cacheResult(course);
			}
			else {
				course.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all courses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(courseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(course course) {
		entityCache.removeResult(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseImpl.class, course.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((courseModelImpl)course, true);
	}

	@Override
	public void clearCache(List<course> courses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (course course : courses) {
			entityCache.removeResult(courseModelImpl.ENTITY_CACHE_ENABLED,
				courseImpl.class, course.getPrimaryKey());

			clearUniqueFindersCache((courseModelImpl)course, true);
		}
	}

	protected void cacheUniqueFindersCache(courseModelImpl courseModelImpl) {
		Object[] args = new Object[] {
				courseModelImpl.getUuid(), courseModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			courseModelImpl, false);
	}

	protected void clearUniqueFindersCache(courseModelImpl courseModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					courseModelImpl.getUuid(), courseModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((courseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					courseModelImpl.getOriginalUuid(),
					courseModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public course create(long courseId) {
		course course = new courseImpl();

		course.setNew(true);
		course.setPrimaryKey(courseId);

		String uuid = PortalUUIDUtil.generate();

		course.setUuid(uuid);

		course.setCompanyId(companyProvider.getCompanyId());

		return course;
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchcourseException if a course with the primary key could not be found
	 */
	@Override
	public course remove(long courseId) throws NoSuchcourseException {
		return remove((Serializable)courseId);
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchcourseException if a course with the primary key could not be found
	 */
	@Override
	public course remove(Serializable primaryKey) throws NoSuchcourseException {
		Session session = null;

		try {
			session = openSession();

			course course = (course)session.get(courseImpl.class, primaryKey);

			if (course == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(course);
		}
		catch (NoSuchcourseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected course removeImpl(course course) {
		course = toUnwrappedModel(course);

		courseTolocationTableMapper.deleteLeftPrimaryKeyTableMappings(course.getPrimaryKey());

		courseToregistrationDetailsTableMapper.deleteLeftPrimaryKeyTableMappings(course.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(course)) {
				course = (course)session.get(courseImpl.class,
						course.getPrimaryKeyObj());
			}

			if (course != null) {
				session.delete(course);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (course != null) {
			clearCache(course);
		}

		return course;
	}

	@Override
	public course updateImpl(course course) {
		course = toUnwrappedModel(course);

		boolean isNew = course.isNew();

		courseModelImpl courseModelImpl = (courseModelImpl)course;

		if (Validator.isNull(course.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			course.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (course.getCreateDate() == null)) {
			if (serviceContext == null) {
				course.setCreateDate(now);
			}
			else {
				course.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!courseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				course.setModifiedDate(now);
			}
			else {
				course.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (course.isNew()) {
				session.save(course);

				course.setNew(false);
			}
			else {
				course = (course)session.merge(course);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!courseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { courseModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					courseModelImpl.getUuid(), courseModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { courseModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseModelImpl.getOriginalUuid(),
						courseModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						courseModelImpl.getUuid(),
						courseModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(courseModelImpl.ENTITY_CACHE_ENABLED,
			courseImpl.class, course.getPrimaryKey(), course, false);

		clearUniqueFindersCache(courseModelImpl, false);
		cacheUniqueFindersCache(courseModelImpl);

		course.resetOriginalValues();

		return course;
	}

	protected course toUnwrappedModel(course course) {
		if (course instanceof courseImpl) {
			return course;
		}

		courseImpl courseImpl = new courseImpl();

		courseImpl.setNew(course.isNew());
		courseImpl.setPrimaryKey(course.getPrimaryKey());

		courseImpl.setUuid(course.getUuid());
		courseImpl.setCourseId(course.getCourseId());
		courseImpl.setCourseName(course.getCourseName());
		courseImpl.setFee(course.getFee());
		courseImpl.setStartDate(course.getStartDate());
		courseImpl.setEndDate(course.getEndDate());
		courseImpl.setMaxseats(course.getMaxseats());
		courseImpl.setGroupId(course.getGroupId());
		courseImpl.setCompanyId(course.getCompanyId());
		courseImpl.setUserId(course.getUserId());
		courseImpl.setUserName(course.getUserName());
		courseImpl.setCreateDate(course.getCreateDate());
		courseImpl.setModifiedDate(course.getModifiedDate());

		return courseImpl;
	}

	/**
	 * Returns the course with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course
	 * @throws NoSuchcourseException if a course with the primary key could not be found
	 */
	@Override
	public course findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcourseException {
		course course = fetchByPrimaryKey(primaryKey);

		if (course == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or throws a {@link NoSuchcourseException} if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws NoSuchcourseException if a course with the primary key could not be found
	 */
	@Override
	public course findByPrimaryKey(long courseId) throws NoSuchcourseException {
		return findByPrimaryKey((Serializable)courseId);
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 */
	@Override
	public course fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(courseModelImpl.ENTITY_CACHE_ENABLED,
				courseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		course course = (course)serializable;

		if (course == null) {
			Session session = null;

			try {
				session = openSession();

				course = (course)session.get(courseImpl.class, primaryKey);

				if (course != null) {
					cacheResult(course);
				}
				else {
					entityCache.putResult(courseModelImpl.ENTITY_CACHE_ENABLED,
						courseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(courseModelImpl.ENTITY_CACHE_ENABLED,
					courseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 */
	@Override
	public course fetchByPrimaryKey(long courseId) {
		return fetchByPrimaryKey((Serializable)courseId);
	}

	@Override
	public Map<Serializable, course> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, course> map = new HashMap<Serializable, course>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			course course = fetchByPrimaryKey(primaryKey);

			if (course != null) {
				map.put(primaryKey, course);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(courseModelImpl.ENTITY_CACHE_ENABLED,
					courseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (course)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COURSE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (course course : (List<course>)q.list()) {
				map.put(course.getPrimaryKeyObj(), course);

				cacheResult(course);

				uncachedPrimaryKeys.remove(course.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(courseModelImpl.ENTITY_CACHE_ENABLED,
					courseImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the courses.
	 *
	 * @return the courses
	 */
	@Override
	public List<course> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<course> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<course> findAll(int start, int end,
		OrderByComparator<course> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<course> findAll(int start, int end,
		OrderByComparator<course> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<course> list = null;

		if (retrieveFromCache) {
			list = (List<course>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE;

				if (pagination) {
					sql = sql.concat(courseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<course>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the courses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (course course : findAll()) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of locations associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return long[] of the primaryKeys of locations associated with the course
	 */
	@Override
	public long[] getlocationPrimaryKeys(long pk) {
		long[] pks = courseTolocationTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the locations associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the locations associated with the course
	 */
	@Override
	public List<com.servicemapping.model.location> getlocations(long pk) {
		return getlocations(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<com.servicemapping.model.location> getlocations(long pk,
		int start, int end) {
		return getlocations(pk, start, end, null);
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
	@Override
	public List<com.servicemapping.model.location> getlocations(long pk,
		int start, int end,
		OrderByComparator<com.servicemapping.model.location> orderByComparator) {
		return courseTolocationTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of locations associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the number of locations associated with the course
	 */
	@Override
	public int getlocationsSize(long pk) {
		long[] pks = courseTolocationTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the location is associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @param locationPK the primary key of the location
	 * @return <code>true</code> if the location is associated with the course; <code>false</code> otherwise
	 */
	@Override
	public boolean containslocation(long pk, long locationPK) {
		return courseTolocationTableMapper.containsTableMapping(pk, locationPK);
	}

	/**
	 * Returns <code>true</code> if the course has any locations associated with it.
	 *
	 * @param pk the primary key of the course to check for associations with locations
	 * @return <code>true</code> if the course has any locations associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containslocations(long pk) {
		if (getlocationsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locationPK the primary key of the location
	 */
	@Override
	public void addlocation(long pk, long locationPK) {
		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseTolocationTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, locationPK);
		}
		else {
			courseTolocationTableMapper.addTableMapping(course.getCompanyId(),
				pk, locationPK);
		}
	}

	/**
	 * Adds an association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param location the location
	 */
	@Override
	public void addlocation(long pk, com.servicemapping.model.location location) {
		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseTolocationTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, location.getPrimaryKey());
		}
		else {
			courseTolocationTableMapper.addTableMapping(course.getCompanyId(),
				pk, location.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locationPKs the primary keys of the locations
	 */
	@Override
	public void addlocations(long pk, long[] locationPKs) {
		long companyId = 0;

		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseTolocationTableMapper.addTableMappings(companyId, pk, locationPKs);
	}

	/**
	 * Adds an association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locations the locations
	 */
	@Override
	public void addlocations(long pk,
		List<com.servicemapping.model.location> locations) {
		addlocations(pk,
			ListUtil.toLongArray(locations,
				com.servicemapping.model.location.LOCATION_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the course and its locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course to clear the associated locations from
	 */
	@Override
	public void clearlocations(long pk) {
		courseTolocationTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locationPK the primary key of the location
	 */
	@Override
	public void removelocation(long pk, long locationPK) {
		courseTolocationTableMapper.deleteTableMapping(pk, locationPK);
	}

	/**
	 * Removes the association between the course and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param location the location
	 */
	@Override
	public void removelocation(long pk,
		com.servicemapping.model.location location) {
		courseTolocationTableMapper.deleteTableMapping(pk,
			location.getPrimaryKey());
	}

	/**
	 * Removes the association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locationPKs the primary keys of the locations
	 */
	@Override
	public void removelocations(long pk, long[] locationPKs) {
		courseTolocationTableMapper.deleteTableMappings(pk, locationPKs);
	}

	/**
	 * Removes the association between the course and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locations the locations
	 */
	@Override
	public void removelocations(long pk,
		List<com.servicemapping.model.location> locations) {
		removelocations(pk,
			ListUtil.toLongArray(locations,
				com.servicemapping.model.location.LOCATION_ID_ACCESSOR));
	}

	/**
	 * Sets the locations associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locationPKs the primary keys of the locations to be associated with the course
	 */
	@Override
	public void setlocations(long pk, long[] locationPKs) {
		Set<Long> newlocationPKsSet = SetUtil.fromArray(locationPKs);
		Set<Long> oldlocationPKsSet = SetUtil.fromArray(courseTolocationTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removelocationPKsSet = new HashSet<Long>(oldlocationPKsSet);

		removelocationPKsSet.removeAll(newlocationPKsSet);

		courseTolocationTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removelocationPKsSet));

		newlocationPKsSet.removeAll(oldlocationPKsSet);

		long companyId = 0;

		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseTolocationTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newlocationPKsSet));
	}

	/**
	 * Sets the locations associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param locations the locations to be associated with the course
	 */
	@Override
	public void setlocations(long pk,
		List<com.servicemapping.model.location> locations) {
		try {
			long[] locationPKs = new long[locations.size()];

			for (int i = 0; i < locations.size(); i++) {
				com.servicemapping.model.location location = locations.get(i);

				locationPKs[i] = location.getPrimaryKey();
			}

			setlocations(pk, locationPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	/**
	 * Returns the primaryKeys of registration detailses associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return long[] of the primaryKeys of registration detailses associated with the course
	 */
	@Override
	public long[] getregistrationDetailsPrimaryKeys(long pk) {
		long[] pks = courseToregistrationDetailsTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the registration detailses associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the registration detailses associated with the course
	 */
	@Override
	public List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		long pk) {
		return getregistrationDetailses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		long pk, int start, int end) {
		return getregistrationDetailses(pk, start, end, null);
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
	@Override
	public List<com.servicemapping.model.registrationDetails> getregistrationDetailses(
		long pk, int start, int end,
		OrderByComparator<com.servicemapping.model.registrationDetails> orderByComparator) {
		return courseToregistrationDetailsTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of registration detailses associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the number of registration detailses associated with the course
	 */
	@Override
	public int getregistrationDetailsesSize(long pk) {
		long[] pks = courseToregistrationDetailsTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the registration details is associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailsPK the primary key of the registration details
	 * @return <code>true</code> if the registration details is associated with the course; <code>false</code> otherwise
	 */
	@Override
	public boolean containsregistrationDetails(long pk,
		long registrationDetailsPK) {
		return courseToregistrationDetailsTableMapper.containsTableMapping(pk,
			registrationDetailsPK);
	}

	/**
	 * Returns <code>true</code> if the course has any registration detailses associated with it.
	 *
	 * @param pk the primary key of the course to check for associations with registration detailses
	 * @return <code>true</code> if the course has any registration detailses associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsregistrationDetailses(long pk) {
		if (getregistrationDetailsesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailsPK the primary key of the registration details
	 */
	@Override
	public void addregistrationDetails(long pk, long registrationDetailsPK) {
		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseToregistrationDetailsTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, registrationDetailsPK);
		}
		else {
			courseToregistrationDetailsTableMapper.addTableMapping(course.getCompanyId(),
				pk, registrationDetailsPK);
		}
	}

	/**
	 * Adds an association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetails the registration details
	 */
	@Override
	public void addregistrationDetails(long pk,
		com.servicemapping.model.registrationDetails registrationDetails) {
		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseToregistrationDetailsTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, registrationDetails.getPrimaryKey());
		}
		else {
			courseToregistrationDetailsTableMapper.addTableMapping(course.getCompanyId(),
				pk, registrationDetails.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailsPKs the primary keys of the registration detailses
	 */
	@Override
	public void addregistrationDetailses(long pk, long[] registrationDetailsPKs) {
		long companyId = 0;

		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseToregistrationDetailsTableMapper.addTableMappings(companyId, pk,
			registrationDetailsPKs);
	}

	/**
	 * Adds an association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailses the registration detailses
	 */
	@Override
	public void addregistrationDetailses(long pk,
		List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		addregistrationDetailses(pk,
			ListUtil.toLongArray(registrationDetailses,
				com.servicemapping.model.registrationDetails.REGISTRATION_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the course and its registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course to clear the associated registration detailses from
	 */
	@Override
	public void clearregistrationDetailses(long pk) {
		courseToregistrationDetailsTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailsPK the primary key of the registration details
	 */
	@Override
	public void removeregistrationDetails(long pk, long registrationDetailsPK) {
		courseToregistrationDetailsTableMapper.deleteTableMapping(pk,
			registrationDetailsPK);
	}

	/**
	 * Removes the association between the course and the registration details. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetails the registration details
	 */
	@Override
	public void removeregistrationDetails(long pk,
		com.servicemapping.model.registrationDetails registrationDetails) {
		courseToregistrationDetailsTableMapper.deleteTableMapping(pk,
			registrationDetails.getPrimaryKey());
	}

	/**
	 * Removes the association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailsPKs the primary keys of the registration detailses
	 */
	@Override
	public void removeregistrationDetailses(long pk,
		long[] registrationDetailsPKs) {
		courseToregistrationDetailsTableMapper.deleteTableMappings(pk,
			registrationDetailsPKs);
	}

	/**
	 * Removes the association between the course and the registration detailses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailses the registration detailses
	 */
	@Override
	public void removeregistrationDetailses(long pk,
		List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		removeregistrationDetailses(pk,
			ListUtil.toLongArray(registrationDetailses,
				com.servicemapping.model.registrationDetails.REGISTRATION_ID_ACCESSOR));
	}

	/**
	 * Sets the registration detailses associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailsPKs the primary keys of the registration detailses to be associated with the course
	 */
	@Override
	public void setregistrationDetailses(long pk, long[] registrationDetailsPKs) {
		Set<Long> newregistrationDetailsPKsSet = SetUtil.fromArray(registrationDetailsPKs);
		Set<Long> oldregistrationDetailsPKsSet = SetUtil.fromArray(courseToregistrationDetailsTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeregistrationDetailsPKsSet = new HashSet<Long>(oldregistrationDetailsPKsSet);

		removeregistrationDetailsPKsSet.removeAll(newregistrationDetailsPKsSet);

		courseToregistrationDetailsTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeregistrationDetailsPKsSet));

		newregistrationDetailsPKsSet.removeAll(oldregistrationDetailsPKsSet);

		long companyId = 0;

		course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseToregistrationDetailsTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newregistrationDetailsPKsSet));
	}

	/**
	 * Sets the registration detailses associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param registrationDetailses the registration detailses to be associated with the course
	 */
	@Override
	public void setregistrationDetailses(long pk,
		List<com.servicemapping.model.registrationDetails> registrationDetailses) {
		try {
			long[] registrationDetailsPKs = new long[registrationDetailses.size()];

			for (int i = 0; i < registrationDetailses.size(); i++) {
				com.servicemapping.model.registrationDetails registrationDetails =
					registrationDetailses.get(i);

				registrationDetailsPKs[i] = registrationDetails.getPrimaryKey();
			}

			setregistrationDetailses(pk, registrationDetailsPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return courseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the course persistence.
	 */
	public void afterPropertiesSet() {
		courseTolocationTableMapper = TableMapperFactory.getTableMapper("DDTI_location_course",
				"companyId", "courseId", "locationId", this, locationPersistence);

		courseToregistrationDetailsTableMapper = TableMapperFactory.getTableMapper("DDTI_registrationDetails_course",
				"companyId", "courseId", "registrationId", this,
				registrationDetailsPersistence);
	}

	public void destroy() {
		entityCache.removeCache(courseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("DDTI_location_course");
		TableMapperFactory.removeTableMapper("DDTI_registrationDetails_course");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = locationPersistence.class)
	protected locationPersistence locationPersistence;
	protected TableMapper<course, com.servicemapping.model.location> courseTolocationTableMapper;
	@BeanReference(type = registrationDetailsPersistence.class)
	protected registrationDetailsPersistence registrationDetailsPersistence;
	protected TableMapper<course, com.servicemapping.model.registrationDetails> courseToregistrationDetailsTableMapper;
	private static final String _SQL_SELECT_COURSE = "SELECT course FROM course course";
	private static final String _SQL_SELECT_COURSE_WHERE_PKS_IN = "SELECT course FROM course course WHERE courseId IN (";
	private static final String _SQL_SELECT_COURSE_WHERE = "SELECT course FROM course course WHERE ";
	private static final String _SQL_COUNT_COURSE = "SELECT COUNT(course) FROM course course";
	private static final String _SQL_COUNT_COURSE_WHERE = "SELECT COUNT(course) FROM course course WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "course.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No course exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No course exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(coursePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}