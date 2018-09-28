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

import com.ddt.exception.NoSuchNewsAshokException;

import com.ddt.model.NewsAshok;
import com.ddt.model.impl.NewsAshokImpl;
import com.ddt.model.impl.NewsAshokModelImpl;

import com.ddt.service.persistence.NewsAshokPersistence;

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
 * The persistence implementation for the news ashok service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsAshokPersistence
 * @see com.ddt.service.persistence.NewsAshokUtil
 * @generated
 */
@ProviderType
public class NewsAshokPersistenceImpl extends BasePersistenceImpl<NewsAshok>
	implements NewsAshokPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewsAshokUtil} to access the news ashok persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewsAshokImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokModelImpl.FINDER_CACHE_ENABLED, NewsAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokModelImpl.FINDER_CACHE_ENABLED, NewsAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokModelImpl.FINDER_CACHE_ENABLED, NewsAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokModelImpl.FINDER_CACHE_ENABLED, NewsAshokImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			NewsAshokModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the news ashoks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching news ashoks
	 */
	@Override
	public List<NewsAshok> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news ashoks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of news ashoks
	 * @param end the upper bound of the range of news ashoks (not inclusive)
	 * @return the range of matching news ashoks
	 */
	@Override
	public List<NewsAshok> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the news ashoks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of news ashoks
	 * @param end the upper bound of the range of news ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news ashoks
	 */
	@Override
	public List<NewsAshok> findByUuid(String uuid, int start, int end,
		OrderByComparator<NewsAshok> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news ashoks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of news ashoks
	 * @param end the upper bound of the range of news ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching news ashoks
	 */
	@Override
	public List<NewsAshok> findByUuid(String uuid, int start, int end,
		OrderByComparator<NewsAshok> orderByComparator,
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

		List<NewsAshok> list = null;

		if (retrieveFromCache) {
			list = (List<NewsAshok>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NewsAshok newsAshok : list) {
					if (!Objects.equals(uuid, newsAshok.getUuid())) {
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

			query.append(_SQL_SELECT_NEWSASHOK_WHERE);

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
				query.append(NewsAshokModelImpl.ORDER_BY_JPQL);
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
					list = (List<NewsAshok>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NewsAshok>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first news ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news ashok
	 * @throws NoSuchNewsAshokException if a matching news ashok could not be found
	 */
	@Override
	public NewsAshok findByUuid_First(String uuid,
		OrderByComparator<NewsAshok> orderByComparator)
		throws NoSuchNewsAshokException {
		NewsAshok newsAshok = fetchByUuid_First(uuid, orderByComparator);

		if (newsAshok != null) {
			return newsAshok;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewsAshokException(msg.toString());
	}

	/**
	 * Returns the first news ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news ashok, or <code>null</code> if a matching news ashok could not be found
	 */
	@Override
	public NewsAshok fetchByUuid_First(String uuid,
		OrderByComparator<NewsAshok> orderByComparator) {
		List<NewsAshok> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news ashok
	 * @throws NoSuchNewsAshokException if a matching news ashok could not be found
	 */
	@Override
	public NewsAshok findByUuid_Last(String uuid,
		OrderByComparator<NewsAshok> orderByComparator)
		throws NoSuchNewsAshokException {
		NewsAshok newsAshok = fetchByUuid_Last(uuid, orderByComparator);

		if (newsAshok != null) {
			return newsAshok;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewsAshokException(msg.toString());
	}

	/**
	 * Returns the last news ashok in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news ashok, or <code>null</code> if a matching news ashok could not be found
	 */
	@Override
	public NewsAshok fetchByUuid_Last(String uuid,
		OrderByComparator<NewsAshok> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NewsAshok> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the news ashoks before and after the current news ashok in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current news ashok
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news ashok
	 * @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator<NewsAshok> orderByComparator)
		throws NoSuchNewsAshokException {
		NewsAshok newsAshok = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NewsAshok[] array = new NewsAshokImpl[3];

			array[0] = getByUuid_PrevAndNext(session, newsAshok, uuid,
					orderByComparator, true);

			array[1] = newsAshok;

			array[2] = getByUuid_PrevAndNext(session, newsAshok, uuid,
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

	protected NewsAshok getByUuid_PrevAndNext(Session session,
		NewsAshok newsAshok, String uuid,
		OrderByComparator<NewsAshok> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEWSASHOK_WHERE);

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
			query.append(NewsAshokModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(newsAshok);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NewsAshok> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the news ashoks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (NewsAshok newsAshok : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(newsAshok);
		}
	}

	/**
	 * Returns the number of news ashoks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching news ashoks
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NEWSASHOK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "newsAshok.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "newsAshok.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(newsAshok.uuid IS NULL OR newsAshok.uuid = '')";

	public NewsAshokPersistenceImpl() {
		setModelClass(NewsAshok.class);
	}

	/**
	 * Caches the news ashok in the entity cache if it is enabled.
	 *
	 * @param newsAshok the news ashok
	 */
	@Override
	public void cacheResult(NewsAshok newsAshok) {
		entityCache.putResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokImpl.class, newsAshok.getPrimaryKey(), newsAshok);

		newsAshok.resetOriginalValues();
	}

	/**
	 * Caches the news ashoks in the entity cache if it is enabled.
	 *
	 * @param newsAshoks the news ashoks
	 */
	@Override
	public void cacheResult(List<NewsAshok> newsAshoks) {
		for (NewsAshok newsAshok : newsAshoks) {
			if (entityCache.getResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
						NewsAshokImpl.class, newsAshok.getPrimaryKey()) == null) {
				cacheResult(newsAshok);
			}
			else {
				newsAshok.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all news ashoks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NewsAshokImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news ashok.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NewsAshok newsAshok) {
		entityCache.removeResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokImpl.class, newsAshok.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NewsAshok> newsAshoks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NewsAshok newsAshok : newsAshoks) {
			entityCache.removeResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
				NewsAshokImpl.class, newsAshok.getPrimaryKey());
		}
	}

	/**
	 * Creates a new news ashok with the primary key. Does not add the news ashok to the database.
	 *
	 * @param id the primary key for the new news ashok
	 * @return the new news ashok
	 */
	@Override
	public NewsAshok create(long id) {
		NewsAshok newsAshok = new NewsAshokImpl();

		newsAshok.setNew(true);
		newsAshok.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		newsAshok.setUuid(uuid);

		return newsAshok;
	}

	/**
	 * Removes the news ashok with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news ashok
	 * @return the news ashok that was removed
	 * @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok remove(long id) throws NoSuchNewsAshokException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the news ashok with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news ashok
	 * @return the news ashok that was removed
	 * @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok remove(Serializable primaryKey)
		throws NoSuchNewsAshokException {
		Session session = null;

		try {
			session = openSession();

			NewsAshok newsAshok = (NewsAshok)session.get(NewsAshokImpl.class,
					primaryKey);

			if (newsAshok == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsAshokException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(newsAshok);
		}
		catch (NoSuchNewsAshokException nsee) {
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
	protected NewsAshok removeImpl(NewsAshok newsAshok) {
		newsAshok = toUnwrappedModel(newsAshok);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsAshok)) {
				newsAshok = (NewsAshok)session.get(NewsAshokImpl.class,
						newsAshok.getPrimaryKeyObj());
			}

			if (newsAshok != null) {
				session.delete(newsAshok);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (newsAshok != null) {
			clearCache(newsAshok);
		}

		return newsAshok;
	}

	@Override
	public NewsAshok updateImpl(NewsAshok newsAshok) {
		newsAshok = toUnwrappedModel(newsAshok);

		boolean isNew = newsAshok.isNew();

		NewsAshokModelImpl newsAshokModelImpl = (NewsAshokModelImpl)newsAshok;

		if (Validator.isNull(newsAshok.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			newsAshok.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (newsAshok.isNew()) {
				session.save(newsAshok);

				newsAshok.setNew(false);
			}
			else {
				newsAshok = (NewsAshok)session.merge(newsAshok);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NewsAshokModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((newsAshokModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsAshokModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { newsAshokModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
			NewsAshokImpl.class, newsAshok.getPrimaryKey(), newsAshok, false);

		newsAshok.resetOriginalValues();

		return newsAshok;
	}

	protected NewsAshok toUnwrappedModel(NewsAshok newsAshok) {
		if (newsAshok instanceof NewsAshokImpl) {
			return newsAshok;
		}

		NewsAshokImpl newsAshokImpl = new NewsAshokImpl();

		newsAshokImpl.setNew(newsAshok.isNew());
		newsAshokImpl.setPrimaryKey(newsAshok.getPrimaryKey());

		newsAshokImpl.setUuid(newsAshok.getUuid());
		newsAshokImpl.setId(newsAshok.getId());
		newsAshokImpl.setNewscontent(newsAshok.getNewscontent());

		return newsAshokImpl;
	}

	/**
	 * Returns the news ashok with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the news ashok
	 * @return the news ashok
	 * @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsAshokException {
		NewsAshok newsAshok = fetchByPrimaryKey(primaryKey);

		if (newsAshok == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsAshokException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return newsAshok;
	}

	/**
	 * Returns the news ashok with the primary key or throws a {@link NoSuchNewsAshokException} if it could not be found.
	 *
	 * @param id the primary key of the news ashok
	 * @return the news ashok
	 * @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok findByPrimaryKey(long id) throws NoSuchNewsAshokException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news ashok with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news ashok
	 * @return the news ashok, or <code>null</code> if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
				NewsAshokImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		NewsAshok newsAshok = (NewsAshok)serializable;

		if (newsAshok == null) {
			Session session = null;

			try {
				session = openSession();

				newsAshok = (NewsAshok)session.get(NewsAshokImpl.class,
						primaryKey);

				if (newsAshok != null) {
					cacheResult(newsAshok);
				}
				else {
					entityCache.putResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
						NewsAshokImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
					NewsAshokImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return newsAshok;
	}

	/**
	 * Returns the news ashok with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news ashok
	 * @return the news ashok, or <code>null</code> if a news ashok with the primary key could not be found
	 */
	@Override
	public NewsAshok fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, NewsAshok> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, NewsAshok> map = new HashMap<Serializable, NewsAshok>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			NewsAshok newsAshok = fetchByPrimaryKey(primaryKey);

			if (newsAshok != null) {
				map.put(primaryKey, newsAshok);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
					NewsAshokImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (NewsAshok)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_NEWSASHOK_WHERE_PKS_IN);

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

			for (NewsAshok newsAshok : (List<NewsAshok>)q.list()) {
				map.put(newsAshok.getPrimaryKeyObj(), newsAshok);

				cacheResult(newsAshok);

				uncachedPrimaryKeys.remove(newsAshok.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(NewsAshokModelImpl.ENTITY_CACHE_ENABLED,
					NewsAshokImpl.class, primaryKey, nullModel);
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
	 * Returns all the news ashoks.
	 *
	 * @return the news ashoks
	 */
	@Override
	public List<NewsAshok> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news ashoks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news ashoks
	 * @param end the upper bound of the range of news ashoks (not inclusive)
	 * @return the range of news ashoks
	 */
	@Override
	public List<NewsAshok> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news ashoks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news ashoks
	 * @param end the upper bound of the range of news ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news ashoks
	 */
	@Override
	public List<NewsAshok> findAll(int start, int end,
		OrderByComparator<NewsAshok> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news ashoks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news ashoks
	 * @param end the upper bound of the range of news ashoks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of news ashoks
	 */
	@Override
	public List<NewsAshok> findAll(int start, int end,
		OrderByComparator<NewsAshok> orderByComparator,
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

		List<NewsAshok> list = null;

		if (retrieveFromCache) {
			list = (List<NewsAshok>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NEWSASHOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSASHOK;

				if (pagination) {
					sql = sql.concat(NewsAshokModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NewsAshok>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NewsAshok>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the news ashoks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NewsAshok newsAshok : findAll()) {
			remove(newsAshok);
		}
	}

	/**
	 * Returns the number of news ashoks.
	 *
	 * @return the number of news ashoks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NEWSASHOK);

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
		return NewsAshokModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news ashok persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NewsAshokImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_NEWSASHOK = "SELECT newsAshok FROM NewsAshok newsAshok";
	private static final String _SQL_SELECT_NEWSASHOK_WHERE_PKS_IN = "SELECT newsAshok FROM NewsAshok newsAshok WHERE id_ IN (";
	private static final String _SQL_SELECT_NEWSASHOK_WHERE = "SELECT newsAshok FROM NewsAshok newsAshok WHERE ";
	private static final String _SQL_COUNT_NEWSASHOK = "SELECT COUNT(newsAshok) FROM NewsAshok newsAshok";
	private static final String _SQL_COUNT_NEWSASHOK_WHERE = "SELECT COUNT(newsAshok) FROM NewsAshok newsAshok WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "newsAshok.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NewsAshok exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NewsAshok exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(NewsAshokPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "id"
			});
}