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

package com.leykartservice.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.leykartservice.exception.NoSuchTestmonialsException;

import com.leykartservice.model.Testmonials;
import com.leykartservice.model.impl.TestmonialsImpl;
import com.leykartservice.model.impl.TestmonialsModelImpl;

import com.leykartservice.service.persistence.TestmonialsPersistence;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

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
 * The persistence implementation for the testmonials service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestmonialsPersistence
 * @see com.leykartservice.service.persistence.TestmonialsUtil
 * @generated
 */
@ProviderType
public class TestmonialsPersistenceImpl extends BasePersistenceImpl<Testmonials>
	implements TestmonialsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TestmonialsUtil} to access the testmonials persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TestmonialsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, TestmonialsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, TestmonialsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, TestmonialsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, TestmonialsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TestmonialsModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the testmonialses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testmonialses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @return the range of matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testmonialses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid(String uuid, int start, int end,
		OrderByComparator<Testmonials> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the testmonialses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid(String uuid, int start, int end,
		OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Testmonials> list = null;

		if (retrieveFromCache) {
			list = (List<Testmonials>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Testmonials testmonials : list) {
					if (!Objects.equals(uuid, testmonials.getUuid())) {
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

			query.append(_SQL_SELECT_TESTMONIALS_WHERE);

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
				query.append(TestmonialsModelImpl.ORDER_BY_JPQL);
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
					list = (List<Testmonials>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Testmonials>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first testmonials in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testmonials
	 * @throws NoSuchTestmonialsException if a matching testmonials could not be found
	 */
	@Override
	public Testmonials findByUuid_First(String uuid,
		OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = fetchByUuid_First(uuid, orderByComparator);

		if (testmonials != null) {
			return testmonials;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestmonialsException(msg.toString());
	}

	/**
	 * Returns the first testmonials in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testmonials, or <code>null</code> if a matching testmonials could not be found
	 */
	@Override
	public Testmonials fetchByUuid_First(String uuid,
		OrderByComparator<Testmonials> orderByComparator) {
		List<Testmonials> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last testmonials in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testmonials
	 * @throws NoSuchTestmonialsException if a matching testmonials could not be found
	 */
	@Override
	public Testmonials findByUuid_Last(String uuid,
		OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = fetchByUuid_Last(uuid, orderByComparator);

		if (testmonials != null) {
			return testmonials;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestmonialsException(msg.toString());
	}

	/**
	 * Returns the last testmonials in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testmonials, or <code>null</code> if a matching testmonials could not be found
	 */
	@Override
	public Testmonials fetchByUuid_Last(String uuid,
		OrderByComparator<Testmonials> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Testmonials> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testmonialses before and after the current testmonials in the ordered set where uuid = &#63;.
	 *
	 * @param testmonialsId the primary key of the current testmonials
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next testmonials
	 * @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials[] findByUuid_PrevAndNext(long testmonialsId,
		String uuid, OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = findByPrimaryKey(testmonialsId);

		Session session = null;

		try {
			session = openSession();

			Testmonials[] array = new TestmonialsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, testmonials, uuid,
					orderByComparator, true);

			array[1] = testmonials;

			array[2] = getByUuid_PrevAndNext(session, testmonials, uuid,
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

	protected Testmonials getByUuid_PrevAndNext(Session session,
		Testmonials testmonials, String uuid,
		OrderByComparator<Testmonials> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTMONIALS_WHERE);

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
			query.append(TestmonialsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(testmonials);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Testmonials> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the testmonialses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Testmonials testmonials : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(testmonials);
		}
	}

	/**
	 * Returns the number of testmonialses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching testmonialses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTMONIALS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "testmonials.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "testmonials.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(testmonials.uuid IS NULL OR testmonials.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, TestmonialsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, TestmonialsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TestmonialsModelImpl.UUID_COLUMN_BITMASK |
			TestmonialsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the testmonialses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testmonialses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @return the range of matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testmonialses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Testmonials> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the testmonialses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching testmonialses
	 */
	@Override
	public List<Testmonials> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Testmonials> orderByComparator,
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

		List<Testmonials> list = null;

		if (retrieveFromCache) {
			list = (List<Testmonials>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Testmonials testmonials : list) {
					if (!Objects.equals(uuid, testmonials.getUuid()) ||
							(companyId != testmonials.getCompanyId())) {
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

			query.append(_SQL_SELECT_TESTMONIALS_WHERE);

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
				query.append(TestmonialsModelImpl.ORDER_BY_JPQL);
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
					list = (List<Testmonials>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Testmonials>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testmonials
	 * @throws NoSuchTestmonialsException if a matching testmonials could not be found
	 */
	@Override
	public Testmonials findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (testmonials != null) {
			return testmonials;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestmonialsException(msg.toString());
	}

	/**
	 * Returns the first testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testmonials, or <code>null</code> if a matching testmonials could not be found
	 */
	@Override
	public Testmonials fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator) {
		List<Testmonials> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testmonials
	 * @throws NoSuchTestmonialsException if a matching testmonials could not be found
	 */
	@Override
	public Testmonials findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (testmonials != null) {
			return testmonials;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestmonialsException(msg.toString());
	}

	/**
	 * Returns the last testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testmonials, or <code>null</code> if a matching testmonials could not be found
	 */
	@Override
	public Testmonials fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Testmonials> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testmonialses before and after the current testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param testmonialsId the primary key of the current testmonials
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next testmonials
	 * @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials[] findByUuid_C_PrevAndNext(long testmonialsId,
		String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = findByPrimaryKey(testmonialsId);

		Session session = null;

		try {
			session = openSession();

			Testmonials[] array = new TestmonialsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, testmonials, uuid,
					companyId, orderByComparator, true);

			array[1] = testmonials;

			array[2] = getByUuid_C_PrevAndNext(session, testmonials, uuid,
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

	protected Testmonials getByUuid_C_PrevAndNext(Session session,
		Testmonials testmonials, String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TESTMONIALS_WHERE);

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
			query.append(TestmonialsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(testmonials);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Testmonials> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the testmonialses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Testmonials testmonials : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(testmonials);
		}
	}

	/**
	 * Returns the number of testmonialses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching testmonialses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TESTMONIALS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "testmonials.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "testmonials.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(testmonials.uuid IS NULL OR testmonials.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "testmonials.companyId = ?";

	public TestmonialsPersistenceImpl() {
		setModelClass(Testmonials.class);

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
	 * Caches the testmonials in the entity cache if it is enabled.
	 *
	 * @param testmonials the testmonials
	 */
	@Override
	public void cacheResult(Testmonials testmonials) {
		entityCache.putResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsImpl.class, testmonials.getPrimaryKey(), testmonials);

		testmonials.resetOriginalValues();
	}

	/**
	 * Caches the testmonialses in the entity cache if it is enabled.
	 *
	 * @param testmonialses the testmonialses
	 */
	@Override
	public void cacheResult(List<Testmonials> testmonialses) {
		for (Testmonials testmonials : testmonialses) {
			if (entityCache.getResult(
						TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
						TestmonialsImpl.class, testmonials.getPrimaryKey()) == null) {
				cacheResult(testmonials);
			}
			else {
				testmonials.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all testmonialses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TestmonialsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the testmonials.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Testmonials testmonials) {
		entityCache.removeResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsImpl.class, testmonials.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Testmonials> testmonialses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Testmonials testmonials : testmonialses) {
			entityCache.removeResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
				TestmonialsImpl.class, testmonials.getPrimaryKey());
		}
	}

	/**
	 * Creates a new testmonials with the primary key. Does not add the testmonials to the database.
	 *
	 * @param testmonialsId the primary key for the new testmonials
	 * @return the new testmonials
	 */
	@Override
	public Testmonials create(long testmonialsId) {
		Testmonials testmonials = new TestmonialsImpl();

		testmonials.setNew(true);
		testmonials.setPrimaryKey(testmonialsId);

		String uuid = PortalUUIDUtil.generate();

		testmonials.setUuid(uuid);

		testmonials.setCompanyId(companyProvider.getCompanyId());

		return testmonials;
	}

	/**
	 * Removes the testmonials with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testmonialsId the primary key of the testmonials
	 * @return the testmonials that was removed
	 * @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials remove(long testmonialsId)
		throws NoSuchTestmonialsException {
		return remove((Serializable)testmonialsId);
	}

	/**
	 * Removes the testmonials with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the testmonials
	 * @return the testmonials that was removed
	 * @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials remove(Serializable primaryKey)
		throws NoSuchTestmonialsException {
		Session session = null;

		try {
			session = openSession();

			Testmonials testmonials = (Testmonials)session.get(TestmonialsImpl.class,
					primaryKey);

			if (testmonials == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestmonialsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testmonials);
		}
		catch (NoSuchTestmonialsException nsee) {
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
	protected Testmonials removeImpl(Testmonials testmonials) {
		testmonials = toUnwrappedModel(testmonials);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(testmonials)) {
				testmonials = (Testmonials)session.get(TestmonialsImpl.class,
						testmonials.getPrimaryKeyObj());
			}

			if (testmonials != null) {
				session.delete(testmonials);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (testmonials != null) {
			clearCache(testmonials);
		}

		return testmonials;
	}

	@Override
	public Testmonials updateImpl(Testmonials testmonials) {
		testmonials = toUnwrappedModel(testmonials);

		boolean isNew = testmonials.isNew();

		TestmonialsModelImpl testmonialsModelImpl = (TestmonialsModelImpl)testmonials;

		if (Validator.isNull(testmonials.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			testmonials.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (testmonials.getCreateDate() == null)) {
			if (serviceContext == null) {
				testmonials.setCreateDate(now);
			}
			else {
				testmonials.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!testmonialsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				testmonials.setModifiedDate(now);
			}
			else {
				testmonials.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (testmonials.isNew()) {
				session.save(testmonials);

				testmonials.setNew(false);
			}
			else {
				testmonials = (Testmonials)session.merge(testmonials);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TestmonialsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { testmonialsModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					testmonialsModelImpl.getUuid(),
					testmonialsModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((testmonialsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testmonialsModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { testmonialsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((testmonialsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testmonialsModelImpl.getOriginalUuid(),
						testmonialsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						testmonialsModelImpl.getUuid(),
						testmonialsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
			TestmonialsImpl.class, testmonials.getPrimaryKey(), testmonials,
			false);

		testmonials.resetOriginalValues();

		return testmonials;
	}

	protected Testmonials toUnwrappedModel(Testmonials testmonials) {
		if (testmonials instanceof TestmonialsImpl) {
			return testmonials;
		}

		TestmonialsImpl testmonialsImpl = new TestmonialsImpl();

		testmonialsImpl.setNew(testmonials.isNew());
		testmonialsImpl.setPrimaryKey(testmonials.getPrimaryKey());

		testmonialsImpl.setUuid(testmonials.getUuid());
		testmonialsImpl.setTestmonialsId(testmonials.getTestmonialsId());
		testmonialsImpl.setFullname(testmonials.getFullname());
		testmonialsImpl.setImagepath(testmonials.getImagepath());
		testmonialsImpl.setMessage(testmonials.getMessage());
		testmonialsImpl.setCompanyId(testmonials.getCompanyId());
		testmonialsImpl.setUserId(testmonials.getUserId());
		testmonialsImpl.setUserName(testmonials.getUserName());
		testmonialsImpl.setCreateDate(testmonials.getCreateDate());
		testmonialsImpl.setModifiedDate(testmonials.getModifiedDate());

		return testmonialsImpl;
	}

	/**
	 * Returns the testmonials with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the testmonials
	 * @return the testmonials
	 * @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestmonialsException {
		Testmonials testmonials = fetchByPrimaryKey(primaryKey);

		if (testmonials == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestmonialsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return testmonials;
	}

	/**
	 * Returns the testmonials with the primary key or throws a {@link NoSuchTestmonialsException} if it could not be found.
	 *
	 * @param testmonialsId the primary key of the testmonials
	 * @return the testmonials
	 * @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials findByPrimaryKey(long testmonialsId)
		throws NoSuchTestmonialsException {
		return findByPrimaryKey((Serializable)testmonialsId);
	}

	/**
	 * Returns the testmonials with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the testmonials
	 * @return the testmonials, or <code>null</code> if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
				TestmonialsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Testmonials testmonials = (Testmonials)serializable;

		if (testmonials == null) {
			Session session = null;

			try {
				session = openSession();

				testmonials = (Testmonials)session.get(TestmonialsImpl.class,
						primaryKey);

				if (testmonials != null) {
					cacheResult(testmonials);
				}
				else {
					entityCache.putResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
						TestmonialsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
					TestmonialsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return testmonials;
	}

	/**
	 * Returns the testmonials with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param testmonialsId the primary key of the testmonials
	 * @return the testmonials, or <code>null</code> if a testmonials with the primary key could not be found
	 */
	@Override
	public Testmonials fetchByPrimaryKey(long testmonialsId) {
		return fetchByPrimaryKey((Serializable)testmonialsId);
	}

	@Override
	public Map<Serializable, Testmonials> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Testmonials> map = new HashMap<Serializable, Testmonials>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Testmonials testmonials = fetchByPrimaryKey(primaryKey);

			if (testmonials != null) {
				map.put(primaryKey, testmonials);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
					TestmonialsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Testmonials)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TESTMONIALS_WHERE_PKS_IN);

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

			for (Testmonials testmonials : (List<Testmonials>)q.list()) {
				map.put(testmonials.getPrimaryKeyObj(), testmonials);

				cacheResult(testmonials);

				uncachedPrimaryKeys.remove(testmonials.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TestmonialsModelImpl.ENTITY_CACHE_ENABLED,
					TestmonialsImpl.class, primaryKey, nullModel);
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
	 * Returns all the testmonialses.
	 *
	 * @return the testmonialses
	 */
	@Override
	public List<Testmonials> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testmonialses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @return the range of testmonialses
	 */
	@Override
	public List<Testmonials> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the testmonialses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of testmonialses
	 */
	@Override
	public List<Testmonials> findAll(int start, int end,
		OrderByComparator<Testmonials> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the testmonialses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of testmonialses
	 * @param end the upper bound of the range of testmonialses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of testmonialses
	 */
	@Override
	public List<Testmonials> findAll(int start, int end,
		OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Testmonials> list = null;

		if (retrieveFromCache) {
			list = (List<Testmonials>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TESTMONIALS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTMONIALS;

				if (pagination) {
					sql = sql.concat(TestmonialsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Testmonials>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Testmonials>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the testmonialses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Testmonials testmonials : findAll()) {
			remove(testmonials);
		}
	}

	/**
	 * Returns the number of testmonialses.
	 *
	 * @return the number of testmonialses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTMONIALS);

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

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TestmonialsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the testmonials persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TestmonialsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TESTMONIALS = "SELECT testmonials FROM Testmonials testmonials";
	private static final String _SQL_SELECT_TESTMONIALS_WHERE_PKS_IN = "SELECT testmonials FROM Testmonials testmonials WHERE testmonialsId IN (";
	private static final String _SQL_SELECT_TESTMONIALS_WHERE = "SELECT testmonials FROM Testmonials testmonials WHERE ";
	private static final String _SQL_COUNT_TESTMONIALS = "SELECT COUNT(testmonials) FROM Testmonials testmonials";
	private static final String _SQL_COUNT_TESTMONIALS_WHERE = "SELECT COUNT(testmonials) FROM Testmonials testmonials WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testmonials.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Testmonials exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Testmonials exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TestmonialsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}