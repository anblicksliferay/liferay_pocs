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

package com.ys.hmawfm.wfms.services.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException;
import com.ys.hmawfm.wfms.services.model.WFMS_NotificationEngine;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_NotificationEngineImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_NotificationEngineModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_NotificationEnginePersistence;

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
 * The persistence implementation for the WFMS_NotificationEngine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NotificationEnginePersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_NotificationEngineUtil
 * @generated
 */
@ProviderType
public class WFMS_NotificationEnginePersistenceImpl extends BasePersistenceImpl<WFMS_NotificationEngine>
	implements WFMS_NotificationEnginePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_NotificationEngineUtil} to access the WFMS_NotificationEngine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_NotificationEngineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
			new String[] { String.class.getName() },
			WFMS_NotificationEngineModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_NotificationEngines where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByTitle(String title) {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_NotificationEngines where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @return the range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByTitle(String title, int start,
		int end) {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByTitle(String title, int start,
		int end, OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return findByTitle(title, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByTitle(String title, int start,
		int end, OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<WFMS_NotificationEngine> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_NotificationEngine>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_NotificationEngine wfms_NotificationEngine : list) {
					if (!Objects.equals(title,
								wfms_NotificationEngine.getTitle())) {
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

			query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
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
	 * Returns the first WFMS_NotificationEngine in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByTitle_First(String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByTitle_First(title,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the first WFMS_NotificationEngine in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByTitle_First(String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		List<WFMS_NotificationEngine> list = findByTitle(title, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByTitle_Last(String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByTitle_Last(title,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByTitle_Last(String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<WFMS_NotificationEngine> list = findByTitle(title, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where title = &#63;.
	 *
	 * @param templateId the primary key of the current WFMS_NotificationEngine
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine[] findByTitle_PrevAndNext(long templateId,
		String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			WFMS_NotificationEngine[] array = new WFMS_NotificationEngineImpl[3];

			array[0] = getByTitle_PrevAndNext(session, wfms_NotificationEngine,
					title, orderByComparator, true);

			array[1] = wfms_NotificationEngine;

			array[2] = getByTitle_PrevAndNext(session, wfms_NotificationEngine,
					title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_NotificationEngine getByTitle_PrevAndNext(Session session,
		WFMS_NotificationEngine wfms_NotificationEngine, String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
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

		query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

		boolean bindTitle = false;

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else if (title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_NotificationEngine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_NotificationEngine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_NotificationEngines where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeByTitle(String title) {
		for (WFMS_NotificationEngine wfms_NotificationEngine : findByTitle(
				title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_NotificationEngine);
		}
	}

	/**
	 * Returns the number of WFMS_NotificationEngines where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching WFMS_NotificationEngines
	 */
	@Override
	public int countByTitle(String title) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLE;

		Object[] finderArgs = new Object[] { title };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "wfms_NotificationEngine.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "wfms_NotificationEngine.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(wfms_NotificationEngine.title IS NULL OR wfms_NotificationEngine.title = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENT = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContent",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT =
		new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContent",
			new String[] { String.class.getName() },
			WFMS_NotificationEngineModelImpl.CONTENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENT = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContent",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_NotificationEngines where content = &#63;.
	 *
	 * @param content the content
	 * @return the matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContent(String content) {
		return findByContent(content, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_NotificationEngines where content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @return the range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContent(String content,
		int start, int end) {
		return findByContent(content, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContent(String content,
		int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return findByContent(content, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContent(String content,
		int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT;
			finderArgs = new Object[] { content };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENT;
			finderArgs = new Object[] { content, start, end, orderByComparator };
		}

		List<WFMS_NotificationEngine> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_NotificationEngine>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_NotificationEngine wfms_NotificationEngine : list) {
					if (!Objects.equals(content,
								wfms_NotificationEngine.getContent())) {
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

			query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindContent = false;

			if (content == null) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_1);
			}
			else if (content.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_3);
			}
			else {
				bindContent = true;

				query.append(_FINDER_COLUMN_CONTENT_CONTENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContent) {
					qPos.add(content);
				}

				if (!pagination) {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
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
	 * Returns the first WFMS_NotificationEngine in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByContent_First(String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByContent_First(content,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content=");
		msg.append(content);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the first WFMS_NotificationEngine in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByContent_First(String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		List<WFMS_NotificationEngine> list = findByContent(content, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByContent_Last(String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByContent_Last(content,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content=");
		msg.append(content);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByContent_Last(String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		int count = countByContent(content);

		if (count == 0) {
			return null;
		}

		List<WFMS_NotificationEngine> list = findByContent(content, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where content = &#63;.
	 *
	 * @param templateId the primary key of the current WFMS_NotificationEngine
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine[] findByContent_PrevAndNext(
		long templateId, String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			WFMS_NotificationEngine[] array = new WFMS_NotificationEngineImpl[3];

			array[0] = getByContent_PrevAndNext(session,
					wfms_NotificationEngine, content, orderByComparator, true);

			array[1] = wfms_NotificationEngine;

			array[2] = getByContent_PrevAndNext(session,
					wfms_NotificationEngine, content, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_NotificationEngine getByContent_PrevAndNext(
		Session session, WFMS_NotificationEngine wfms_NotificationEngine,
		String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
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

		query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

		boolean bindContent = false;

		if (content == null) {
			query.append(_FINDER_COLUMN_CONTENT_CONTENT_1);
		}
		else if (content.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CONTENT_CONTENT_3);
		}
		else {
			bindContent = true;

			query.append(_FINDER_COLUMN_CONTENT_CONTENT_2);
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
			query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindContent) {
			qPos.add(content);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_NotificationEngine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_NotificationEngine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_NotificationEngines where content = &#63; from the database.
	 *
	 * @param content the content
	 */
	@Override
	public void removeByContent(String content) {
		for (WFMS_NotificationEngine wfms_NotificationEngine : findByContent(
				content, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_NotificationEngine);
		}
	}

	/**
	 * Returns the number of WFMS_NotificationEngines where content = &#63;.
	 *
	 * @param content the content
	 * @return the number of matching WFMS_NotificationEngines
	 */
	@Override
	public int countByContent(String content) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENT;

		Object[] finderArgs = new Object[] { content };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindContent = false;

			if (content == null) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_1);
			}
			else if (content.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_3);
			}
			else {
				bindContent = true;

				query.append(_FINDER_COLUMN_CONTENT_CONTENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContent) {
					qPos.add(content);
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

	private static final String _FINDER_COLUMN_CONTENT_CONTENT_1 = "wfms_NotificationEngine.content IS NULL";
	private static final String _FINDER_COLUMN_CONTENT_CONTENT_2 = "wfms_NotificationEngine.content = ?";
	private static final String _FINDER_COLUMN_CONTENT_CONTENT_3 = "(wfms_NotificationEngine.content IS NULL OR wfms_NotificationEngine.content = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTTYPE =
		new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContentType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTTYPE =
		new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContentType",
			new String[] { String.class.getName() },
			WFMS_NotificationEngineModelImpl.CONTENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENTTYPE = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContentType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_NotificationEngines where contentType = &#63;.
	 *
	 * @param contentType the content type
	 * @return the matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContentType(String contentType) {
		return findByContentType(contentType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_NotificationEngines where contentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contentType the content type
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @return the range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContentType(String contentType,
		int start, int end) {
		return findByContentType(contentType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where contentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contentType the content type
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContentType(String contentType,
		int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return findByContentType(contentType, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where contentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contentType the content type
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByContentType(String contentType,
		int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTTYPE;
			finderArgs = new Object[] { contentType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTTYPE;
			finderArgs = new Object[] { contentType, start, end, orderByComparator };
		}

		List<WFMS_NotificationEngine> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_NotificationEngine>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_NotificationEngine wfms_NotificationEngine : list) {
					if (!Objects.equals(contentType,
								wfms_NotificationEngine.getContentType())) {
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

			query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindContentType = false;

			if (contentType == null) {
				query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_1);
			}
			else if (contentType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_3);
			}
			else {
				bindContentType = true;

				query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContentType) {
					qPos.add(contentType);
				}

				if (!pagination) {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
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
	 * Returns the first WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	 *
	 * @param contentType the content type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByContentType_First(String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByContentType_First(contentType,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contentType=");
		msg.append(contentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the first WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	 *
	 * @param contentType the content type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByContentType_First(
		String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		List<WFMS_NotificationEngine> list = findByContentType(contentType, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	 *
	 * @param contentType the content type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByContentType_Last(String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByContentType_Last(contentType,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contentType=");
		msg.append(contentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	 *
	 * @param contentType the content type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByContentType_Last(String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		int count = countByContentType(contentType);

		if (count == 0) {
			return null;
		}

		List<WFMS_NotificationEngine> list = findByContentType(contentType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	 *
	 * @param templateId the primary key of the current WFMS_NotificationEngine
	 * @param contentType the content type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine[] findByContentType_PrevAndNext(
		long templateId, String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			WFMS_NotificationEngine[] array = new WFMS_NotificationEngineImpl[3];

			array[0] = getByContentType_PrevAndNext(session,
					wfms_NotificationEngine, contentType, orderByComparator,
					true);

			array[1] = wfms_NotificationEngine;

			array[2] = getByContentType_PrevAndNext(session,
					wfms_NotificationEngine, contentType, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_NotificationEngine getByContentType_PrevAndNext(
		Session session, WFMS_NotificationEngine wfms_NotificationEngine,
		String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
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

		query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

		boolean bindContentType = false;

		if (contentType == null) {
			query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_1);
		}
		else if (contentType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_3);
		}
		else {
			bindContentType = true;

			query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_2);
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
			query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindContentType) {
			qPos.add(contentType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_NotificationEngine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_NotificationEngine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_NotificationEngines where contentType = &#63; from the database.
	 *
	 * @param contentType the content type
	 */
	@Override
	public void removeByContentType(String contentType) {
		for (WFMS_NotificationEngine wfms_NotificationEngine : findByContentType(
				contentType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_NotificationEngine);
		}
	}

	/**
	 * Returns the number of WFMS_NotificationEngines where contentType = &#63;.
	 *
	 * @param contentType the content type
	 * @return the number of matching WFMS_NotificationEngines
	 */
	@Override
	public int countByContentType(String contentType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENTTYPE;

		Object[] finderArgs = new Object[] { contentType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindContentType = false;

			if (contentType == null) {
				query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_1);
			}
			else if (contentType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_3);
			}
			else {
				bindContentType = true;

				query.append(_FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContentType) {
					qPos.add(contentType);
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

	private static final String _FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_1 = "wfms_NotificationEngine.contentType IS NULL";
	private static final String _FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_2 = "wfms_NotificationEngine.contentType = ?";
	private static final String _FINDER_COLUMN_CONTENTTYPE_CONTENTTYPE_3 = "(wfms_NotificationEngine.contentType IS NULL OR wfms_NotificationEngine.contentType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBY =
		new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreatedBy",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY =
		new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreatedBy",
			new String[] { String.class.getName() },
			WFMS_NotificationEngineModelImpl.CREATEDBY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBY = new FinderPath(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreatedBy",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_NotificationEngines where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByCreatedBy(String createdBy) {
		return findByCreatedBy(createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_NotificationEngines where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @return the range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByCreatedBy(String createdBy,
		int start, int end) {
		return findByCreatedBy(createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByCreatedBy(String createdBy,
		int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return findByCreatedBy(createdBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findByCreatedBy(String createdBy,
		int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY;
			finderArgs = new Object[] { createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBY;
			finderArgs = new Object[] { createdBy, start, end, orderByComparator };
		}

		List<WFMS_NotificationEngine> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_NotificationEngine>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_NotificationEngine wfms_NotificationEngine : list) {
					if (!Objects.equals(createdBy,
								wfms_NotificationEngine.getCreatedBy())) {
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

			query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindCreatedBy = false;

			if (createdBy == null) {
				query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_1);
			}
			else if (createdBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_3);
			}
			else {
				bindCreatedBy = true;

				query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatedBy) {
					qPos.add(createdBy);
				}

				if (!pagination) {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
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
	 * Returns the first WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByCreatedBy_First(String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByCreatedBy_First(createdBy,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the first WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByCreatedBy_First(String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		List<WFMS_NotificationEngine> list = findByCreatedBy(createdBy, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByCreatedBy_Last(String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByCreatedBy_Last(createdBy,
				orderByComparator);

		if (wfms_NotificationEngine != null) {
			return wfms_NotificationEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_NotificationEngineException(msg.toString());
	}

	/**
	 * Returns the last WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByCreatedBy_Last(String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		int count = countByCreatedBy(createdBy);

		if (count == 0) {
			return null;
		}

		List<WFMS_NotificationEngine> list = findByCreatedBy(createdBy,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	 *
	 * @param templateId the primary key of the current WFMS_NotificationEngine
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine[] findByCreatedBy_PrevAndNext(
		long templateId, String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			WFMS_NotificationEngine[] array = new WFMS_NotificationEngineImpl[3];

			array[0] = getByCreatedBy_PrevAndNext(session,
					wfms_NotificationEngine, createdBy, orderByComparator, true);

			array[1] = wfms_NotificationEngine;

			array[2] = getByCreatedBy_PrevAndNext(session,
					wfms_NotificationEngine, createdBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_NotificationEngine getByCreatedBy_PrevAndNext(
		Session session, WFMS_NotificationEngine wfms_NotificationEngine,
		String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
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

		query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE);

		boolean bindCreatedBy = false;

		if (createdBy == null) {
			query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_1);
		}
		else if (createdBy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_3);
		}
		else {
			bindCreatedBy = true;

			query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);
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
			query.append(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreatedBy) {
			qPos.add(createdBy);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_NotificationEngine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_NotificationEngine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_NotificationEngines where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 */
	@Override
	public void removeByCreatedBy(String createdBy) {
		for (WFMS_NotificationEngine wfms_NotificationEngine : findByCreatedBy(
				createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_NotificationEngine);
		}
	}

	/**
	 * Returns the number of WFMS_NotificationEngines where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching WFMS_NotificationEngines
	 */
	@Override
	public int countByCreatedBy(String createdBy) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDBY;

		Object[] finderArgs = new Object[] { createdBy };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_NOTIFICATIONENGINE_WHERE);

			boolean bindCreatedBy = false;

			if (createdBy == null) {
				query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_1);
			}
			else if (createdBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_3);
			}
			else {
				bindCreatedBy = true;

				query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatedBy) {
					qPos.add(createdBy);
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

	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_1 = "wfms_NotificationEngine.createdBy IS NULL";
	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_2 = "wfms_NotificationEngine.createdBy = ?";
	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_3 = "(wfms_NotificationEngine.createdBy IS NULL OR wfms_NotificationEngine.createdBy = '')";

	public WFMS_NotificationEnginePersistenceImpl() {
		setModelClass(WFMS_NotificationEngine.class);
	}

	/**
	 * Caches the WFMS_NotificationEngine in the entity cache if it is enabled.
	 *
	 * @param wfms_NotificationEngine the WFMS_NotificationEngine
	 */
	@Override
	public void cacheResult(WFMS_NotificationEngine wfms_NotificationEngine) {
		entityCache.putResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			wfms_NotificationEngine.getPrimaryKey(), wfms_NotificationEngine);

		wfms_NotificationEngine.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_NotificationEngines in the entity cache if it is enabled.
	 *
	 * @param wfms_NotificationEngines the WFMS_NotificationEngines
	 */
	@Override
	public void cacheResult(
		List<WFMS_NotificationEngine> wfms_NotificationEngines) {
		for (WFMS_NotificationEngine wfms_NotificationEngine : wfms_NotificationEngines) {
			if (entityCache.getResult(
						WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_NotificationEngineImpl.class,
						wfms_NotificationEngine.getPrimaryKey()) == null) {
				cacheResult(wfms_NotificationEngine);
			}
			else {
				wfms_NotificationEngine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_NotificationEngines.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_NotificationEngineImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_NotificationEngine.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_NotificationEngine wfms_NotificationEngine) {
		entityCache.removeResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			wfms_NotificationEngine.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<WFMS_NotificationEngine> wfms_NotificationEngines) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_NotificationEngine wfms_NotificationEngine : wfms_NotificationEngines) {
			entityCache.removeResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_NotificationEngineImpl.class,
				wfms_NotificationEngine.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_NotificationEngine with the primary key. Does not add the WFMS_NotificationEngine to the database.
	 *
	 * @param templateId the primary key for the new WFMS_NotificationEngine
	 * @return the new WFMS_NotificationEngine
	 */
	@Override
	public WFMS_NotificationEngine create(long templateId) {
		WFMS_NotificationEngine wfms_NotificationEngine = new WFMS_NotificationEngineImpl();

		wfms_NotificationEngine.setNew(true);
		wfms_NotificationEngine.setPrimaryKey(templateId);

		wfms_NotificationEngine.setCompanyId(companyProvider.getCompanyId());

		return wfms_NotificationEngine;
	}

	/**
	 * Removes the WFMS_NotificationEngine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the WFMS_NotificationEngine
	 * @return the WFMS_NotificationEngine that was removed
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine remove(long templateId)
		throws NoSuchWFMS_NotificationEngineException {
		return remove((Serializable)templateId);
	}

	/**
	 * Removes the WFMS_NotificationEngine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_NotificationEngine
	 * @return the WFMS_NotificationEngine that was removed
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine remove(Serializable primaryKey)
		throws NoSuchWFMS_NotificationEngineException {
		Session session = null;

		try {
			session = openSession();

			WFMS_NotificationEngine wfms_NotificationEngine = (WFMS_NotificationEngine)session.get(WFMS_NotificationEngineImpl.class,
					primaryKey);

			if (wfms_NotificationEngine == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_NotificationEngineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_NotificationEngine);
		}
		catch (NoSuchWFMS_NotificationEngineException nsee) {
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
	protected WFMS_NotificationEngine removeImpl(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		wfms_NotificationEngine = toUnwrappedModel(wfms_NotificationEngine);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_NotificationEngine)) {
				wfms_NotificationEngine = (WFMS_NotificationEngine)session.get(WFMS_NotificationEngineImpl.class,
						wfms_NotificationEngine.getPrimaryKeyObj());
			}

			if (wfms_NotificationEngine != null) {
				session.delete(wfms_NotificationEngine);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_NotificationEngine != null) {
			clearCache(wfms_NotificationEngine);
		}

		return wfms_NotificationEngine;
	}

	@Override
	public WFMS_NotificationEngine updateImpl(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		wfms_NotificationEngine = toUnwrappedModel(wfms_NotificationEngine);

		boolean isNew = wfms_NotificationEngine.isNew();

		WFMS_NotificationEngineModelImpl wfms_NotificationEngineModelImpl = (WFMS_NotificationEngineModelImpl)wfms_NotificationEngine;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_NotificationEngine.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_NotificationEngine.setCreateDate(now);
			}
			else {
				wfms_NotificationEngine.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!wfms_NotificationEngineModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_NotificationEngine.setModifiedDate(now);
			}
			else {
				wfms_NotificationEngine.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_NotificationEngine.isNew()) {
				session.save(wfms_NotificationEngine);

				wfms_NotificationEngine.setNew(false);
			}
			else {
				wfms_NotificationEngine = (WFMS_NotificationEngine)session.merge(wfms_NotificationEngine);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_NotificationEngineModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					wfms_NotificationEngineModelImpl.getTitle()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
				args);

			args = new Object[] { wfms_NotificationEngineModelImpl.getContent() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT,
				args);

			args = new Object[] {
					wfms_NotificationEngineModelImpl.getContentType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENTTYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTTYPE,
				args);

			args = new Object[] { wfms_NotificationEngineModelImpl.getCreatedBy() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wfms_NotificationEngineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_NotificationEngineModelImpl.getOriginalTitle()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { wfms_NotificationEngineModelImpl.getTitle() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}

			if ((wfms_NotificationEngineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_NotificationEngineModelImpl.getOriginalContent()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT,
					args);

				args = new Object[] {
						wfms_NotificationEngineModelImpl.getContent()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT,
					args);
			}

			if ((wfms_NotificationEngineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_NotificationEngineModelImpl.getOriginalContentType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENTTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTTYPE,
					args);

				args = new Object[] {
						wfms_NotificationEngineModelImpl.getContentType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENTTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTTYPE,
					args);
			}

			if ((wfms_NotificationEngineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_NotificationEngineModelImpl.getOriginalCreatedBy()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
					args);

				args = new Object[] {
						wfms_NotificationEngineModelImpl.getCreatedBy()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
					args);
			}
		}

		entityCache.putResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NotificationEngineImpl.class,
			wfms_NotificationEngine.getPrimaryKey(), wfms_NotificationEngine,
			false);

		wfms_NotificationEngine.resetOriginalValues();

		return wfms_NotificationEngine;
	}

	protected WFMS_NotificationEngine toUnwrappedModel(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		if (wfms_NotificationEngine instanceof WFMS_NotificationEngineImpl) {
			return wfms_NotificationEngine;
		}

		WFMS_NotificationEngineImpl wfms_NotificationEngineImpl = new WFMS_NotificationEngineImpl();

		wfms_NotificationEngineImpl.setNew(wfms_NotificationEngine.isNew());
		wfms_NotificationEngineImpl.setPrimaryKey(wfms_NotificationEngine.getPrimaryKey());

		wfms_NotificationEngineImpl.setTemplateId(wfms_NotificationEngine.getTemplateId());
		wfms_NotificationEngineImpl.setCompanyId(wfms_NotificationEngine.getCompanyId());
		wfms_NotificationEngineImpl.setScopeGroupId(wfms_NotificationEngine.getScopeGroupId());
		wfms_NotificationEngineImpl.setCreatedBy(wfms_NotificationEngine.getCreatedBy());
		wfms_NotificationEngineImpl.setCreateDate(wfms_NotificationEngine.getCreateDate());
		wfms_NotificationEngineImpl.setModifiedBy(wfms_NotificationEngine.getModifiedBy());
		wfms_NotificationEngineImpl.setModifiedDate(wfms_NotificationEngine.getModifiedDate());
		wfms_NotificationEngineImpl.setTitle(wfms_NotificationEngine.getTitle());
		wfms_NotificationEngineImpl.setContent(wfms_NotificationEngine.getContent());
		wfms_NotificationEngineImpl.setContentType(wfms_NotificationEngine.getContentType());
		wfms_NotificationEngineImpl.setComments(wfms_NotificationEngine.getComments());
		wfms_NotificationEngineImpl.setTimesUsed(wfms_NotificationEngine.getTimesUsed());

		return wfms_NotificationEngineImpl;
	}

	/**
	 * Returns the WFMS_NotificationEngine with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_NotificationEngine
	 * @return the WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_NotificationEngineException {
		WFMS_NotificationEngine wfms_NotificationEngine = fetchByPrimaryKey(primaryKey);

		if (wfms_NotificationEngine == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_NotificationEngineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_NotificationEngine;
	}

	/**
	 * Returns the WFMS_NotificationEngine with the primary key or throws a {@link NoSuchWFMS_NotificationEngineException} if it could not be found.
	 *
	 * @param templateId the primary key of the WFMS_NotificationEngine
	 * @return the WFMS_NotificationEngine
	 * @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine findByPrimaryKey(long templateId)
		throws NoSuchWFMS_NotificationEngineException {
		return findByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns the WFMS_NotificationEngine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_NotificationEngine
	 * @return the WFMS_NotificationEngine, or <code>null</code> if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_NotificationEngineImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_NotificationEngine wfms_NotificationEngine = (WFMS_NotificationEngine)serializable;

		if (wfms_NotificationEngine == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_NotificationEngine = (WFMS_NotificationEngine)session.get(WFMS_NotificationEngineImpl.class,
						primaryKey);

				if (wfms_NotificationEngine != null) {
					cacheResult(wfms_NotificationEngine);
				}
				else {
					entityCache.putResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_NotificationEngineImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_NotificationEngineImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_NotificationEngine;
	}

	/**
	 * Returns the WFMS_NotificationEngine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the WFMS_NotificationEngine
	 * @return the WFMS_NotificationEngine, or <code>null</code> if a WFMS_NotificationEngine with the primary key could not be found
	 */
	@Override
	public WFMS_NotificationEngine fetchByPrimaryKey(long templateId) {
		return fetchByPrimaryKey((Serializable)templateId);
	}

	@Override
	public Map<Serializable, WFMS_NotificationEngine> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_NotificationEngine> map = new HashMap<Serializable, WFMS_NotificationEngine>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_NotificationEngine wfms_NotificationEngine = fetchByPrimaryKey(primaryKey);

			if (wfms_NotificationEngine != null) {
				map.put(primaryKey, wfms_NotificationEngine);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_NotificationEngineImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_NotificationEngine)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE_PKS_IN);

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

			for (WFMS_NotificationEngine wfms_NotificationEngine : (List<WFMS_NotificationEngine>)q.list()) {
				map.put(wfms_NotificationEngine.getPrimaryKeyObj(),
					wfms_NotificationEngine);

				cacheResult(wfms_NotificationEngine);

				uncachedPrimaryKeys.remove(wfms_NotificationEngine.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_NotificationEngineModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_NotificationEngineImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_NotificationEngines.
	 *
	 * @return the WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_NotificationEngines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @return the range of WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findAll(int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_NotificationEngines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_NotificationEngines
	 * @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_NotificationEngines
	 */
	@Override
	public List<WFMS_NotificationEngine> findAll(int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
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

		List<WFMS_NotificationEngine> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_NotificationEngine>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_NOTIFICATIONENGINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_NOTIFICATIONENGINE;

				if (pagination) {
					sql = sql.concat(WFMS_NotificationEngineModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_NotificationEngine>)QueryUtil.list(q,
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
	 * Removes all the WFMS_NotificationEngines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_NotificationEngine wfms_NotificationEngine : findAll()) {
			remove(wfms_NotificationEngine);
		}
	}

	/**
	 * Returns the number of WFMS_NotificationEngines.
	 *
	 * @return the number of WFMS_NotificationEngines
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_NOTIFICATIONENGINE);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return WFMS_NotificationEngineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_NotificationEngine persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_NotificationEngineImpl.class.getName());
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
	private static final String _SQL_SELECT_WFMS_NOTIFICATIONENGINE = "SELECT wfms_NotificationEngine FROM WFMS_NotificationEngine wfms_NotificationEngine";
	private static final String _SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE_PKS_IN =
		"SELECT wfms_NotificationEngine FROM WFMS_NotificationEngine wfms_NotificationEngine WHERE templateId IN (";
	private static final String _SQL_SELECT_WFMS_NOTIFICATIONENGINE_WHERE = "SELECT wfms_NotificationEngine FROM WFMS_NotificationEngine wfms_NotificationEngine WHERE ";
	private static final String _SQL_COUNT_WFMS_NOTIFICATIONENGINE = "SELECT COUNT(wfms_NotificationEngine) FROM WFMS_NotificationEngine wfms_NotificationEngine";
	private static final String _SQL_COUNT_WFMS_NOTIFICATIONENGINE_WHERE = "SELECT COUNT(wfms_NotificationEngine) FROM WFMS_NotificationEngine wfms_NotificationEngine WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_NotificationEngine.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_NotificationEngine exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_NotificationEngine exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_NotificationEnginePersistenceImpl.class);
}