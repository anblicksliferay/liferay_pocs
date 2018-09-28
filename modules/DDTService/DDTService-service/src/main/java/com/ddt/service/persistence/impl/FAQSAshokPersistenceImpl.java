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

import com.ddt.exception.NoSuchFAQSAshokException;

import com.ddt.model.FAQSAshok;
import com.ddt.model.impl.FAQSAshokImpl;
import com.ddt.model.impl.FAQSAshokModelImpl;

import com.ddt.service.persistence.FAQSAshokPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the f a q s ashok service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FAQSAshokPersistence
 * @see com.ddt.service.persistence.FAQSAshokUtil
 * @generated
 */
@ProviderType
public class FAQSAshokPersistenceImpl extends BasePersistenceImpl<FAQSAshok>
	implements FAQSAshokPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FAQSAshokUtil} to access the f a q s ashok persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FAQSAshokImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokModelImpl.FINDER_CACHE_ENABLED, FAQSAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokModelImpl.FINDER_CACHE_ENABLED, FAQSAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokModelImpl.FINDER_CACHE_ENABLED, FAQSAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokModelImpl.FINDER_CACHE_ENABLED, FAQSAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FAQSAshokModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the f a q s ashoks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q s ashoks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q s ashoks
	 * @param end the upper bound of the range of f a q s ashoks (not inclusive)
	 * @return the range of matching f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q s ashoks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q s ashoks
	 * @param end the upper bound of the range of f a q s ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findByUuid(String uuid, int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the f a q s ashoks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q s ashoks
	 * @param end the upper bound of the range of f a q s ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findByUuid(String uuid, int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator,
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

		List<FAQSAshok> list = null;

		if (retrieveFromCache) {
			list = (List<FAQSAshok>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FAQSAshok faqsAshok : list) {
					if (!Objects.equals(uuid, faqsAshok.getUuid())) {
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

			query.append(_SQL_SELECT_FAQSASHOK_WHERE);

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
				query.append(FAQSAshokModelImpl.ORDER_BY_JPQL);
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
					list = (List<FAQSAshok>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FAQSAshok>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first f a q s ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q s ashok
	 * @throws NoSuchFAQSAshokException if a matching f a q s ashok could not be found
	 */
	@Override
	public FAQSAshok findByUuid_First(String uuid,
		OrderByComparator<FAQSAshok> orderByComparator)
		throws NoSuchFAQSAshokException {
		FAQSAshok faqsAshok = fetchByUuid_First(uuid, orderByComparator);

		if (faqsAshok != null) {
			return faqsAshok;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFAQSAshokException(msg.toString());
	}

	/**
	 * Returns the first f a q s ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q s ashok, or <code>null</code> if a matching f a q s ashok could not be found
	 */
	@Override
	public FAQSAshok fetchByUuid_First(String uuid,
		OrderByComparator<FAQSAshok> orderByComparator) {
		List<FAQSAshok> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last f a q s ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q s ashok
	 * @throws NoSuchFAQSAshokException if a matching f a q s ashok could not be found
	 */
	@Override
	public FAQSAshok findByUuid_Last(String uuid,
		OrderByComparator<FAQSAshok> orderByComparator)
		throws NoSuchFAQSAshokException {
		FAQSAshok faqsAshok = fetchByUuid_Last(uuid, orderByComparator);

		if (faqsAshok != null) {
			return faqsAshok;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFAQSAshokException(msg.toString());
	}

	/**
	 * Returns the last f a q s ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q s ashok, or <code>null</code> if a matching f a q s ashok could not be found
	 */
	@Override
	public FAQSAshok fetchByUuid_Last(String uuid,
		OrderByComparator<FAQSAshok> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FAQSAshok> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the f a q s ashoks before and after the current f a q s ashok in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current f a q s ashok
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q s ashok
	 * @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator<FAQSAshok> orderByComparator)
		throws NoSuchFAQSAshokException {
		FAQSAshok faqsAshok = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQSAshok[] array = new FAQSAshokImpl[3];

			array[0] = getByUuid_PrevAndNext(session, faqsAshok, uuid,
					orderByComparator, true);

			array[1] = faqsAshok;

			array[2] = getByUuid_PrevAndNext(session, faqsAshok, uuid,
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

	protected FAQSAshok getByUuid_PrevAndNext(Session session,
		FAQSAshok faqsAshok, String uuid,
		OrderByComparator<FAQSAshok> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQSASHOK_WHERE);

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
			query.append(FAQSAshokModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(faqsAshok);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQSAshok> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the f a q s ashoks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FAQSAshok faqsAshok : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(faqsAshok);
		}
	}

	/**
	 * Returns the number of f a q s ashoks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching f a q s ashoks
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQSASHOK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "faqsAshok.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "faqsAshok.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(faqsAshok.uuid IS NULL OR faqsAshok.uuid = '')";

	public FAQSAshokPersistenceImpl() {
		setModelClass(FAQSAshok.class);
	}

	/**
	 * Caches the f a q s ashok in the entity cache if it is enabled.
	 *
	 * @param faqsAshok the f a q s ashok
	 */
	@Override
	public void cacheResult(FAQSAshok faqsAshok) {
		entityCache.putResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokImpl.class, faqsAshok.getPrimaryKey(), faqsAshok);

		faqsAshok.resetOriginalValues();
	}

	/**
	 * Caches the f a q s ashoks in the entity cache if it is enabled.
	 *
	 * @param faqsAshoks the f a q s ashoks
	 */
	@Override
	public void cacheResult(List<FAQSAshok> faqsAshoks) {
		for (FAQSAshok faqsAshok : faqsAshoks) {
			if (entityCache.getResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
						FAQSAshokImpl.class, faqsAshok.getPrimaryKey()) == null) {
				cacheResult(faqsAshok);
			}
			else {
				faqsAshok.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all f a q s ashoks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FAQSAshokImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the f a q s ashok.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQSAshok faqsAshok) {
		entityCache.removeResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokImpl.class, faqsAshok.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FAQSAshok> faqsAshoks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FAQSAshok faqsAshok : faqsAshoks) {
			entityCache.removeResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
				FAQSAshokImpl.class, faqsAshok.getPrimaryKey());
		}
	}

	/**
	 * Creates a new f a q s ashok with the primary key. Does not add the f a q s ashok to the database.
	 *
	 * @param id the primary key for the new f a q s ashok
	 * @return the new f a q s ashok
	 */
	@Override
	public FAQSAshok create(long id) {
		FAQSAshok faqsAshok = new FAQSAshokImpl();

		faqsAshok.setNew(true);
		faqsAshok.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		faqsAshok.setUuid(uuid);

		return faqsAshok;
	}

	/**
	 * Removes the f a q s ashok with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the f a q s ashok
	 * @return the f a q s ashok that was removed
	 * @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok remove(long id) throws NoSuchFAQSAshokException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the f a q s ashok with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the f a q s ashok
	 * @return the f a q s ashok that was removed
	 * @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok remove(Serializable primaryKey)
		throws NoSuchFAQSAshokException {
		Session session = null;

		try {
			session = openSession();

			FAQSAshok faqsAshok = (FAQSAshok)session.get(FAQSAshokImpl.class,
					primaryKey);

			if (faqsAshok == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFAQSAshokException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faqsAshok);
		}
		catch (NoSuchFAQSAshokException nsee) {
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
	protected FAQSAshok removeImpl(FAQSAshok faqsAshok) {
		faqsAshok = toUnwrappedModel(faqsAshok);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(faqsAshok)) {
				faqsAshok = (FAQSAshok)session.get(FAQSAshokImpl.class,
						faqsAshok.getPrimaryKeyObj());
			}

			if (faqsAshok != null) {
				session.delete(faqsAshok);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (faqsAshok != null) {
			clearCache(faqsAshok);
		}

		return faqsAshok;
	}

	@Override
	public FAQSAshok updateImpl(FAQSAshok faqsAshok) {
		faqsAshok = toUnwrappedModel(faqsAshok);

		boolean isNew = faqsAshok.isNew();

		FAQSAshokModelImpl faqsAshokModelImpl = (FAQSAshokModelImpl)faqsAshok;

		if (Validator.isNull(faqsAshok.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			faqsAshok.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (faqsAshok.isNew()) {
				session.save(faqsAshok);

				faqsAshok.setNew(false);
			}
			else {
				faqsAshok = (FAQSAshok)session.merge(faqsAshok);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FAQSAshokModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqsAshokModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqsAshokModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { faqsAshokModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
			FAQSAshokImpl.class, faqsAshok.getPrimaryKey(), faqsAshok, false);

		faqsAshok.resetOriginalValues();

		return faqsAshok;
	}

	protected FAQSAshok toUnwrappedModel(FAQSAshok faqsAshok) {
		if (faqsAshok instanceof FAQSAshokImpl) {
			return faqsAshok;
		}

		FAQSAshokImpl faqsAshokImpl = new FAQSAshokImpl();

		faqsAshokImpl.setNew(faqsAshok.isNew());
		faqsAshokImpl.setPrimaryKey(faqsAshok.getPrimaryKey());

		faqsAshokImpl.setUuid(faqsAshok.getUuid());
		faqsAshokImpl.setId(faqsAshok.getId());
		faqsAshokImpl.setFAQSContent(faqsAshok.getFAQSContent());

		return faqsAshokImpl;
	}

	/**
	 * Returns the f a q s ashok with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q s ashok
	 * @return the f a q s ashok
	 * @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFAQSAshokException {
		FAQSAshok faqsAshok = fetchByPrimaryKey(primaryKey);

		if (faqsAshok == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFAQSAshokException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return faqsAshok;
	}

	/**
	 * Returns the f a q s ashok with the primary key or throws a {@link NoSuchFAQSAshokException} if it could not be found.
	 *
	 * @param id the primary key of the f a q s ashok
	 * @return the f a q s ashok
	 * @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok findByPrimaryKey(long id) throws NoSuchFAQSAshokException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the f a q s ashok with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q s ashok
	 * @return the f a q s ashok, or <code>null</code> if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
				FAQSAshokImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FAQSAshok faqsAshok = (FAQSAshok)serializable;

		if (faqsAshok == null) {
			Session session = null;

			try {
				session = openSession();

				faqsAshok = (FAQSAshok)session.get(FAQSAshokImpl.class,
						primaryKey);

				if (faqsAshok != null) {
					cacheResult(faqsAshok);
				}
				else {
					entityCache.putResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
						FAQSAshokImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
					FAQSAshokImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return faqsAshok;
	}

	/**
	 * Returns the f a q s ashok with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the f a q s ashok
	 * @return the f a q s ashok, or <code>null</code> if a f a q s ashok with the primary key could not be found
	 */
	@Override
	public FAQSAshok fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, FAQSAshok> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FAQSAshok> map = new HashMap<Serializable, FAQSAshok>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FAQSAshok faqsAshok = fetchByPrimaryKey(primaryKey);

			if (faqsAshok != null) {
				map.put(primaryKey, faqsAshok);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
					FAQSAshokImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FAQSAshok)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FAQSASHOK_WHERE_PKS_IN);

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

			for (FAQSAshok faqsAshok : (List<FAQSAshok>)q.list()) {
				map.put(faqsAshok.getPrimaryKeyObj(), faqsAshok);

				cacheResult(faqsAshok);

				uncachedPrimaryKeys.remove(faqsAshok.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FAQSAshokModelImpl.ENTITY_CACHE_ENABLED,
					FAQSAshokImpl.class, primaryKey, nullModel);
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
	 * Returns all the f a q s ashoks.
	 *
	 * @return the f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q s ashoks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q s ashoks
	 * @param end the upper bound of the range of f a q s ashoks (not inclusive)
	 * @return the range of f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q s ashoks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q s ashoks
	 * @param end the upper bound of the range of f a q s ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findAll(int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the f a q s ashoks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q s ashoks
	 * @param end the upper bound of the range of f a q s ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of f a q s ashoks
	 */
	@Override
	public List<FAQSAshok> findAll(int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator,
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

		List<FAQSAshok> list = null;

		if (retrieveFromCache) {
			list = (List<FAQSAshok>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FAQSASHOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQSASHOK;

				if (pagination) {
					sql = sql.concat(FAQSAshokModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FAQSAshok>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FAQSAshok>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the f a q s ashoks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FAQSAshok faqsAshok : findAll()) {
			remove(faqsAshok);
		}
	}

	/**
	 * Returns the number of f a q s ashoks.
	 *
	 * @return the number of f a q s ashoks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQSASHOK);

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
		return FAQSAshokModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the f a q s ashok persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FAQSAshokImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FAQSASHOK = "SELECT faqsAshok FROM FAQSAshok faqsAshok";
	private static final String _SQL_SELECT_FAQSASHOK_WHERE_PKS_IN = "SELECT faqsAshok FROM FAQSAshok faqsAshok WHERE id_ IN (";
	private static final String _SQL_SELECT_FAQSASHOK_WHERE = "SELECT faqsAshok FROM FAQSAshok faqsAshok WHERE ";
	private static final String _SQL_COUNT_FAQSASHOK = "SELECT COUNT(faqsAshok) FROM FAQSAshok faqsAshok";
	private static final String _SQL_COUNT_FAQSASHOK_WHERE = "SELECT COUNT(faqsAshok) FROM FAQSAshok faqsAshok WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faqsAshok.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FAQSAshok exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FAQSAshok exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FAQSAshokPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "id"
			});
}