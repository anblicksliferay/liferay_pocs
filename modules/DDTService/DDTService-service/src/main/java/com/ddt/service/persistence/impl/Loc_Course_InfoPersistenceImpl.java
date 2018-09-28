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

package com.ddt.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.ddt.exception.NoSuchLoc_Course_InfoException;

import com.ddt.model.Loc_Course_Info;
import com.ddt.model.impl.Loc_Course_InfoImpl;
import com.ddt.model.impl.Loc_Course_InfoModelImpl;

import com.ddt.service.persistence.Loc_Course_InfoPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

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
 * The persistence implementation for the loc_ course_ info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_InfoPersistence
 * @see com.ddt.service.persistence.Loc_Course_InfoUtil
 * @generated
 */
@ProviderType
public class Loc_Course_InfoPersistenceImpl extends BasePersistenceImpl<Loc_Course_Info>
	implements Loc_Course_InfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Loc_Course_InfoUtil} to access the loc_ course_ info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Loc_Course_InfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED,
			Loc_Course_InfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED,
			Loc_Course_InfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED,
			Loc_Course_InfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED,
			Loc_Course_InfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			Loc_Course_InfoModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the loc_ course_ infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loc_ course_ infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @return the range of matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loc_ course_ infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid(String uuid, int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loc_ course_ infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid(String uuid, int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator,
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

		List<Loc_Course_Info> list = null;

		if (retrieveFromCache) {
			list = (List<Loc_Course_Info>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Loc_Course_Info loc_Course_Info : list) {
					if (!Objects.equals(uuid, loc_Course_Info.getUuid())) {
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

			query.append(_SQL_SELECT_LOC_COURSE_INFO_WHERE);

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
				query.append(Loc_Course_InfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Loc_Course_Info>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loc_Course_Info>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first loc_ course_ info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info findByUuid_First(String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = fetchByUuid_First(uuid,
				orderByComparator);

		if (loc_Course_Info != null) {
			return loc_Course_Info;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoc_Course_InfoException(msg.toString());
	}

	/**
	 * Returns the first loc_ course_ info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info fetchByUuid_First(String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		List<Loc_Course_Info> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loc_ course_ info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info findByUuid_Last(String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = fetchByUuid_Last(uuid,
				orderByComparator);

		if (loc_Course_Info != null) {
			return loc_Course_Info;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoc_Course_InfoException(msg.toString());
	}

	/**
	 * Returns the last loc_ course_ info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info fetchByUuid_Last(String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Loc_Course_Info> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loc_ course_ infos before and after the current loc_ course_ info in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current loc_ course_ info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Loc_Course_Info[] array = new Loc_Course_InfoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, loc_Course_Info, uuid,
					orderByComparator, true);

			array[1] = loc_Course_Info;

			array[2] = getByUuid_PrevAndNext(session, loc_Course_Info, uuid,
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

	protected Loc_Course_Info getByUuid_PrevAndNext(Session session,
		Loc_Course_Info loc_Course_Info, String uuid,
		OrderByComparator<Loc_Course_Info> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOC_COURSE_INFO_WHERE);

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
			query.append(Loc_Course_InfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(loc_Course_Info);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loc_Course_Info> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loc_ course_ infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Loc_Course_Info loc_Course_Info : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loc_Course_Info);
		}
	}

	/**
	 * Returns the number of loc_ course_ infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loc_ course_ infos
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOC_COURSE_INFO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "loc_Course_Info.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "loc_Course_Info.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(loc_Course_Info.uuid IS NULL OR loc_Course_Info.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED,
			Loc_Course_InfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED,
			Loc_Course_InfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			Loc_Course_InfoModelImpl.UUID_COLUMN_BITMASK |
			Loc_Course_InfoModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @return the range of matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Loc_Course_Info> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator,
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

		List<Loc_Course_Info> list = null;

		if (retrieveFromCache) {
			list = (List<Loc_Course_Info>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Loc_Course_Info loc_Course_Info : list) {
					if (!Objects.equals(uuid, loc_Course_Info.getUuid()) ||
							(companyId != loc_Course_Info.getCompanyId())) {
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

			query.append(_SQL_SELECT_LOC_COURSE_INFO_WHERE);

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
				query.append(Loc_Course_InfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Loc_Course_Info>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loc_Course_Info>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (loc_Course_Info != null) {
			return loc_Course_Info;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoc_Course_InfoException(msg.toString());
	}

	/**
	 * Returns the first loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		List<Loc_Course_Info> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (loc_Course_Info != null) {
			return loc_Course_Info;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoc_Course_InfoException(msg.toString());
	}

	/**
	 * Returns the last loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	 */
	@Override
	public Loc_Course_Info fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Loc_Course_Info> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loc_ course_ infos before and after the current loc_ course_ info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current loc_ course_ info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info[] findByUuid_C_PrevAndNext(long id, String uuid,
		long companyId, OrderByComparator<Loc_Course_Info> orderByComparator)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Loc_Course_Info[] array = new Loc_Course_InfoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, loc_Course_Info, uuid,
					companyId, orderByComparator, true);

			array[1] = loc_Course_Info;

			array[2] = getByUuid_C_PrevAndNext(session, loc_Course_Info, uuid,
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

	protected Loc_Course_Info getByUuid_C_PrevAndNext(Session session,
		Loc_Course_Info loc_Course_Info, String uuid, long companyId,
		OrderByComparator<Loc_Course_Info> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOC_COURSE_INFO_WHERE);

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
			query.append(Loc_Course_InfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(loc_Course_Info);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loc_Course_Info> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loc_ course_ infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Loc_Course_Info loc_Course_Info : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loc_Course_Info);
		}
	}

	/**
	 * Returns the number of loc_ course_ infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loc_ course_ infos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOC_COURSE_INFO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "loc_Course_Info.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "loc_Course_Info.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(loc_Course_Info.uuid IS NULL OR loc_Course_Info.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "loc_Course_Info.companyId = ?";

	public Loc_Course_InfoPersistenceImpl() {
		setModelClass(Loc_Course_Info.class);
	}

	/**
	 * Caches the loc_ course_ info in the entity cache if it is enabled.
	 *
	 * @param loc_Course_Info the loc_ course_ info
	 */
	@Override
	public void cacheResult(Loc_Course_Info loc_Course_Info) {
		entityCache.putResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoImpl.class, loc_Course_Info.getPrimaryKey(),
			loc_Course_Info);

		loc_Course_Info.resetOriginalValues();
	}

	/**
	 * Caches the loc_ course_ infos in the entity cache if it is enabled.
	 *
	 * @param loc_Course_Infos the loc_ course_ infos
	 */
	@Override
	public void cacheResult(List<Loc_Course_Info> loc_Course_Infos) {
		for (Loc_Course_Info loc_Course_Info : loc_Course_Infos) {
			if (entityCache.getResult(
						Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
						Loc_Course_InfoImpl.class,
						loc_Course_Info.getPrimaryKey()) == null) {
				cacheResult(loc_Course_Info);
			}
			else {
				loc_Course_Info.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loc_ course_ infos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Loc_Course_InfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loc_ course_ info.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Loc_Course_Info loc_Course_Info) {
		entityCache.removeResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoImpl.class, loc_Course_Info.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Loc_Course_Info> loc_Course_Infos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Loc_Course_Info loc_Course_Info : loc_Course_Infos) {
			entityCache.removeResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
				Loc_Course_InfoImpl.class, loc_Course_Info.getPrimaryKey());
		}
	}

	/**
	 * Creates a new loc_ course_ info with the primary key. Does not add the loc_ course_ info to the database.
	 *
	 * @param id the primary key for the new loc_ course_ info
	 * @return the new loc_ course_ info
	 */
	@Override
	public Loc_Course_Info create(long id) {
		Loc_Course_Info loc_Course_Info = new Loc_Course_InfoImpl();

		loc_Course_Info.setNew(true);
		loc_Course_Info.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		loc_Course_Info.setUuid(uuid);

		loc_Course_Info.setCompanyId(companyProvider.getCompanyId());

		return loc_Course_Info;
	}

	/**
	 * Removes the loc_ course_ info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the loc_ course_ info
	 * @return the loc_ course_ info that was removed
	 * @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info remove(long id)
		throws NoSuchLoc_Course_InfoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the loc_ course_ info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loc_ course_ info
	 * @return the loc_ course_ info that was removed
	 * @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info remove(Serializable primaryKey)
		throws NoSuchLoc_Course_InfoException {
		Session session = null;

		try {
			session = openSession();

			Loc_Course_Info loc_Course_Info = (Loc_Course_Info)session.get(Loc_Course_InfoImpl.class,
					primaryKey);

			if (loc_Course_Info == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoc_Course_InfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loc_Course_Info);
		}
		catch (NoSuchLoc_Course_InfoException nsee) {
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
	protected Loc_Course_Info removeImpl(Loc_Course_Info loc_Course_Info) {
		loc_Course_Info = toUnwrappedModel(loc_Course_Info);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loc_Course_Info)) {
				loc_Course_Info = (Loc_Course_Info)session.get(Loc_Course_InfoImpl.class,
						loc_Course_Info.getPrimaryKeyObj());
			}

			if (loc_Course_Info != null) {
				session.delete(loc_Course_Info);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loc_Course_Info != null) {
			clearCache(loc_Course_Info);
		}

		return loc_Course_Info;
	}

	@Override
	public Loc_Course_Info updateImpl(Loc_Course_Info loc_Course_Info) {
		loc_Course_Info = toUnwrappedModel(loc_Course_Info);

		boolean isNew = loc_Course_Info.isNew();

		Loc_Course_InfoModelImpl loc_Course_InfoModelImpl = (Loc_Course_InfoModelImpl)loc_Course_Info;

		if (Validator.isNull(loc_Course_Info.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			loc_Course_Info.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (loc_Course_Info.getCreateDate() == null)) {
			if (serviceContext == null) {
				loc_Course_Info.setCreateDate(now);
			}
			else {
				loc_Course_Info.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!loc_Course_InfoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				loc_Course_Info.setModifiedDate(now);
			}
			else {
				loc_Course_Info.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (loc_Course_Info.isNew()) {
				session.save(loc_Course_Info);

				loc_Course_Info.setNew(false);
			}
			else {
				loc_Course_Info = (Loc_Course_Info)session.merge(loc_Course_Info);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Loc_Course_InfoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((loc_Course_InfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loc_Course_InfoModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { loc_Course_InfoModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((loc_Course_InfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loc_Course_InfoModelImpl.getOriginalUuid(),
						loc_Course_InfoModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						loc_Course_InfoModelImpl.getUuid(),
						loc_Course_InfoModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
			Loc_Course_InfoImpl.class, loc_Course_Info.getPrimaryKey(),
			loc_Course_Info, false);

		loc_Course_Info.resetOriginalValues();

		return loc_Course_Info;
	}

	protected Loc_Course_Info toUnwrappedModel(Loc_Course_Info loc_Course_Info) {
		if (loc_Course_Info instanceof Loc_Course_InfoImpl) {
			return loc_Course_Info;
		}

		Loc_Course_InfoImpl loc_Course_InfoImpl = new Loc_Course_InfoImpl();

		loc_Course_InfoImpl.setNew(loc_Course_Info.isNew());
		loc_Course_InfoImpl.setPrimaryKey(loc_Course_Info.getPrimaryKey());

		loc_Course_InfoImpl.setUuid(loc_Course_Info.getUuid());
		loc_Course_InfoImpl.setId(loc_Course_Info.getId());
		loc_Course_InfoImpl.setLocationId(loc_Course_Info.getLocationId());
		loc_Course_InfoImpl.setCouserId(loc_Course_Info.getCouserId());
		loc_Course_InfoImpl.setLocationName(loc_Course_Info.getLocationName());
		loc_Course_InfoImpl.setCouserName(loc_Course_Info.getCouserName());
		loc_Course_InfoImpl.setMaxSeats(loc_Course_Info.getMaxSeats());
		loc_Course_InfoImpl.setToDate(loc_Course_Info.getToDate());
		loc_Course_InfoImpl.setFromDate(loc_Course_Info.getFromDate());
		loc_Course_InfoImpl.setFees(loc_Course_Info.getFees());
		loc_Course_InfoImpl.setCompanyId(loc_Course_Info.getCompanyId());
		loc_Course_InfoImpl.setUserId(loc_Course_Info.getUserId());
		loc_Course_InfoImpl.setUserName(loc_Course_Info.getUserName());
		loc_Course_InfoImpl.setCreateDate(loc_Course_Info.getCreateDate());
		loc_Course_InfoImpl.setModifiedDate(loc_Course_Info.getModifiedDate());

		return loc_Course_InfoImpl;
	}

	/**
	 * Returns the loc_ course_ info with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loc_ course_ info
	 * @return the loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoc_Course_InfoException {
		Loc_Course_Info loc_Course_Info = fetchByPrimaryKey(primaryKey);

		if (loc_Course_Info == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoc_Course_InfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loc_Course_Info;
	}

	/**
	 * Returns the loc_ course_ info with the primary key or throws a {@link NoSuchLoc_Course_InfoException} if it could not be found.
	 *
	 * @param id the primary key of the loc_ course_ info
	 * @return the loc_ course_ info
	 * @throws NoSuchLoc_Course_InfoException if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info findByPrimaryKey(long id)
		throws NoSuchLoc_Course_InfoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the loc_ course_ info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loc_ course_ info
	 * @return the loc_ course_ info, or <code>null</code> if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
				Loc_Course_InfoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Loc_Course_Info loc_Course_Info = (Loc_Course_Info)serializable;

		if (loc_Course_Info == null) {
			Session session = null;

			try {
				session = openSession();

				loc_Course_Info = (Loc_Course_Info)session.get(Loc_Course_InfoImpl.class,
						primaryKey);

				if (loc_Course_Info != null) {
					cacheResult(loc_Course_Info);
				}
				else {
					entityCache.putResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
						Loc_Course_InfoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
					Loc_Course_InfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loc_Course_Info;
	}

	/**
	 * Returns the loc_ course_ info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the loc_ course_ info
	 * @return the loc_ course_ info, or <code>null</code> if a loc_ course_ info with the primary key could not be found
	 */
	@Override
	public Loc_Course_Info fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Loc_Course_Info> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Loc_Course_Info> map = new HashMap<Serializable, Loc_Course_Info>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Loc_Course_Info loc_Course_Info = fetchByPrimaryKey(primaryKey);

			if (loc_Course_Info != null) {
				map.put(primaryKey, loc_Course_Info);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
					Loc_Course_InfoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Loc_Course_Info)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOC_COURSE_INFO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Loc_Course_Info loc_Course_Info : (List<Loc_Course_Info>)q.list()) {
				map.put(loc_Course_Info.getPrimaryKeyObj(), loc_Course_Info);

				cacheResult(loc_Course_Info);

				uncachedPrimaryKeys.remove(loc_Course_Info.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Loc_Course_InfoModelImpl.ENTITY_CACHE_ENABLED,
					Loc_Course_InfoImpl.class, primaryKey, nullModel);
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
	 * Returns all the loc_ course_ infos.
	 *
	 * @return the loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loc_ course_ infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @return the range of loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loc_ course_ infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findAll(int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loc_ course_ infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loc_ course_ infos
	 * @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loc_ course_ infos
	 */
	@Override
	public List<Loc_Course_Info> findAll(int start, int end,
		OrderByComparator<Loc_Course_Info> orderByComparator,
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

		List<Loc_Course_Info> list = null;

		if (retrieveFromCache) {
			list = (List<Loc_Course_Info>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOC_COURSE_INFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOC_COURSE_INFO;

				if (pagination) {
					sql = sql.concat(Loc_Course_InfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Loc_Course_Info>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Loc_Course_Info>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the loc_ course_ infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Loc_Course_Info loc_Course_Info : findAll()) {
			remove(loc_Course_Info);
		}
	}

	/**
	 * Returns the number of loc_ course_ infos.
	 *
	 * @return the number of loc_ course_ infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOC_COURSE_INFO);

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
		return Loc_Course_InfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the loc_ course_ info persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Loc_Course_InfoImpl.class.getName());
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
	private static final String _SQL_SELECT_LOC_COURSE_INFO = "SELECT loc_Course_Info FROM Loc_Course_Info loc_Course_Info";
	private static final String _SQL_SELECT_LOC_COURSE_INFO_WHERE_PKS_IN = "SELECT loc_Course_Info FROM Loc_Course_Info loc_Course_Info WHERE id_ IN (";
	private static final String _SQL_SELECT_LOC_COURSE_INFO_WHERE = "SELECT loc_Course_Info FROM Loc_Course_Info loc_Course_Info WHERE ";
	private static final String _SQL_COUNT_LOC_COURSE_INFO = "SELECT COUNT(loc_Course_Info) FROM Loc_Course_Info loc_Course_Info";
	private static final String _SQL_COUNT_LOC_COURSE_INFO_WHERE = "SELECT COUNT(loc_Course_Info) FROM Loc_Course_Info loc_Course_Info WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loc_Course_Info.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Loc_Course_Info exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Loc_Course_Info exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Loc_Course_InfoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "id"
			});
}