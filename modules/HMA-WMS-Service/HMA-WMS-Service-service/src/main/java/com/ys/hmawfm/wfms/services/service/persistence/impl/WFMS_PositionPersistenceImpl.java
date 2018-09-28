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
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_PositionPersistence;

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
 * The persistence implementation for the WFMS_Position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_PositionPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_PositionUtil
 * @generated
 */
@ProviderType
public class WFMS_PositionPersistenceImpl extends BasePersistenceImpl<WFMS_Position>
	implements WFMS_PositionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_PositionUtil} to access the WFMS_Position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_PositionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REFPOSID = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrefPosId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFPOSID =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrefPosId", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.REFPOSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REFPOSID = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrefPosId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where refPosId = &#63;.
	 *
	 * @param refPosId the ref pos ID
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByrefPosId(String refPosId) {
		return findByrefPosId(refPosId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where refPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param refPosId the ref pos ID
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByrefPosId(String refPosId, int start,
		int end) {
		return findByrefPosId(refPosId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where refPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param refPosId the ref pos ID
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByrefPosId(String refPosId, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByrefPosId(refPosId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where refPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param refPosId the ref pos ID
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByrefPosId(String refPosId, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFPOSID;
			finderArgs = new Object[] { refPosId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REFPOSID;
			finderArgs = new Object[] { refPosId, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(refPosId, wfms_Position.getRefPosId())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindRefPosId = false;

			if (refPosId == null) {
				query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_1);
			}
			else if (refPosId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_3);
			}
			else {
				bindRefPosId = true;

				query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRefPosId) {
					qPos.add(refPosId);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where refPosId = &#63;.
	 *
	 * @param refPosId the ref pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByrefPosId_First(String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByrefPosId_First(refPosId,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("refPosId=");
		msg.append(refPosId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where refPosId = &#63;.
	 *
	 * @param refPosId the ref pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByrefPosId_First(String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByrefPosId(refPosId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where refPosId = &#63;.
	 *
	 * @param refPosId the ref pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByrefPosId_Last(String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByrefPosId_Last(refPosId,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("refPosId=");
		msg.append(refPosId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where refPosId = &#63;.
	 *
	 * @param refPosId the ref pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByrefPosId_Last(String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByrefPosId(refPosId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByrefPosId(refPosId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where refPosId = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param refPosId the ref pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByrefPosId_PrevAndNext(String pId,
		String refPosId, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByrefPosId_PrevAndNext(session, wfms_Position,
					refPosId, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByrefPosId_PrevAndNext(session, wfms_Position,
					refPosId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByrefPosId_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindRefPosId = false;

		if (refPosId == null) {
			query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_1);
		}
		else if (refPosId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_3);
		}
		else {
			bindRefPosId = true;

			query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRefPosId) {
			qPos.add(refPosId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where refPosId = &#63; from the database.
	 *
	 * @param refPosId the ref pos ID
	 */
	@Override
	public void removeByrefPosId(String refPosId) {
		for (WFMS_Position wfms_Position : findByrefPosId(refPosId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where refPosId = &#63;.
	 *
	 * @param refPosId the ref pos ID
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByrefPosId(String refPosId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REFPOSID;

		Object[] finderArgs = new Object[] { refPosId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindRefPosId = false;

			if (refPosId == null) {
				query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_1);
			}
			else if (refPosId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_3);
			}
			else {
				bindRefPosId = true;

				query.append(_FINDER_COLUMN_REFPOSID_REFPOSID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRefPosId) {
					qPos.add(refPosId);
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

	private static final String _FINDER_COLUMN_REFPOSID_REFPOSID_1 = "wfms_Position.refPosId IS NULL";
	private static final String _FINDER_COLUMN_REFPOSID_REFPOSID_2 = "wfms_Position.refPosId = ?";
	private static final String _FINDER_COLUMN_REFPOSID_REFPOSID_3 = "(wfms_Position.refPosId IS NULL OR wfms_Position.refPosId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DUMMY = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydummy",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydummy", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.DUMMY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DUMMY = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydummy",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBydummy(String dummy) {
		return findBydummy(dummy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where dummy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBydummy(String dummy, int start, int end) {
		return findBydummy(dummy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where dummy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBydummy(String dummy, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return findBydummy(dummy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where dummy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBydummy(String dummy, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY;
			finderArgs = new Object[] { dummy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DUMMY;
			finderArgs = new Object[] { dummy, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(dummy, wfms_Position.getDummy())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindDummy = false;

			if (dummy == null) {
				query.append(_FINDER_COLUMN_DUMMY_DUMMY_1);
			}
			else if (dummy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DUMMY_DUMMY_3);
			}
			else {
				bindDummy = true;

				query.append(_FINDER_COLUMN_DUMMY_DUMMY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDummy) {
					qPos.add(dummy);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findBydummy_First(String dummy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchBydummy_First(dummy,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dummy=");
		msg.append(dummy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchBydummy_First(String dummy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findBydummy(dummy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findBydummy_Last(String dummy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchBydummy_Last(dummy, orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dummy=");
		msg.append(dummy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchBydummy_Last(String dummy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countBydummy(dummy);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findBydummy(dummy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where dummy = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findBydummy_PrevAndNext(String pId, String dummy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getBydummy_PrevAndNext(session, wfms_Position, dummy,
					orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getBydummy_PrevAndNext(session, wfms_Position, dummy,
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

	protected WFMS_Position getBydummy_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String dummy,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindDummy = false;

		if (dummy == null) {
			query.append(_FINDER_COLUMN_DUMMY_DUMMY_1);
		}
		else if (dummy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DUMMY_DUMMY_3);
		}
		else {
			bindDummy = true;

			query.append(_FINDER_COLUMN_DUMMY_DUMMY_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDummy) {
			qPos.add(dummy);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where dummy = &#63; from the database.
	 *
	 * @param dummy the dummy
	 */
	@Override
	public void removeBydummy(String dummy) {
		for (WFMS_Position wfms_Position : findBydummy(dummy,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countBydummy(String dummy) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DUMMY;

		Object[] finderArgs = new Object[] { dummy };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindDummy = false;

			if (dummy == null) {
				query.append(_FINDER_COLUMN_DUMMY_DUMMY_1);
			}
			else if (dummy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DUMMY_DUMMY_3);
			}
			else {
				bindDummy = true;

				query.append(_FINDER_COLUMN_DUMMY_DUMMY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDummy) {
					qPos.add(dummy);
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

	private static final String _FINDER_COLUMN_DUMMY_DUMMY_1 = "wfms_Position.dummy IS NULL";
	private static final String _FINDER_COLUMN_DUMMY_DUMMY_2 = "wfms_Position.dummy = ?";
	private static final String _FINDER_COLUMN_DUMMY_DUMMY_3 = "(wfms_Position.dummy IS NULL OR wfms_Position.dummy = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBER = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNumber",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNumber", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.NUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBER = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where number = &#63;.
	 *
	 * @param number the number
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNumber(String number) {
		return findByNumber(number, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNumber(String number, int start, int end) {
		return findByNumber(number, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNumber(String number, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return findByNumber(number, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNumber(String number, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER;
			finderArgs = new Object[] { number };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMBER;
			finderArgs = new Object[] { number, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(number, wfms_Position.getNumber())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByNumber_First(String number,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByNumber_First(number,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("number=");
		msg.append(number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByNumber_First(String number,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByNumber(number, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByNumber_Last(String number,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByNumber_Last(number,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("number=");
		msg.append(number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByNumber_Last(String number,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByNumber(number);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByNumber(number, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where number = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByNumber_PrevAndNext(String pId, String number,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByNumber_PrevAndNext(session, wfms_Position, number,
					orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByNumber_PrevAndNext(session, wfms_Position, number,
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

	protected WFMS_Position getByNumber_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String number,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindNumber = false;

		if (number == null) {
			query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
		}
		else if (number.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
		}
		else {
			bindNumber = true;

			query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNumber) {
			qPos.add(number);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where number = &#63; from the database.
	 *
	 * @param number the number
	 */
	@Override
	public void removeByNumber(String number) {
		for (WFMS_Position wfms_Position : findByNumber(number,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where number = &#63;.
	 *
	 * @param number the number
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByNumber(String number) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBER;

		Object[] finderArgs = new Object[] { number };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
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

	private static final String _FINDER_COLUMN_NUMBER_NUMBER_1 = "wfms_Position.number IS NULL";
	private static final String _FINDER_COLUMN_NUMBER_NUMBER_2 = "wfms_Position.number = ?";
	private static final String _FINDER_COLUMN_NUMBER_NUMBER_3 = "(wfms_Position.number IS NULL OR wfms_Position.number = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategory", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCategory(String category) {
		return findByCategory(category, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCategory(String category, int start,
		int end) {
		return findByCategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCategory(String category, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByCategory(category, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCategory(String category, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { category, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(category, wfms_Position.getCategory())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByCategory_First(String category,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByCategory_First(category,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByCategory_First(String category,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByCategory(category, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByCategory_Last(String category,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByCategory_Last(category,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByCategory_Last(String category,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByCategory(category);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByCategory(category, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where category = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByCategory_PrevAndNext(String pId,
		String category, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByCategory_PrevAndNext(session, wfms_Position,
					category, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByCategory_PrevAndNext(session, wfms_Position,
					category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByCategory_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String category,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	@Override
	public void removeByCategory(String category) {
		for (WFMS_Position wfms_Position : findByCategory(category,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByCategory(String category) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { category };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_1 = "wfms_Position.category IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 = "wfms_Position.category = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 = "(wfms_Position.category IS NULL OR wfms_Position.category = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSOCIATENUMBER =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAssociateNumber",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATENUMBER =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAssociateNumber", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.ASSOCIATENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSOCIATENUMBER = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAssociateNumber", new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where associateNumber = &#63;.
	 *
	 * @param associateNumber the associate number
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByAssociateNumber(String associateNumber) {
		return findByAssociateNumber(associateNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where associateNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param associateNumber the associate number
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByAssociateNumber(String associateNumber,
		int start, int end) {
		return findByAssociateNumber(associateNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where associateNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param associateNumber the associate number
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByAssociateNumber(String associateNumber,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByAssociateNumber(associateNumber, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where associateNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param associateNumber the associate number
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByAssociateNumber(String associateNumber,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATENUMBER;
			finderArgs = new Object[] { associateNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSOCIATENUMBER;
			finderArgs = new Object[] {
					associateNumber,
					
					start, end, orderByComparator
				};
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(associateNumber,
								wfms_Position.getAssociateNumber())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindAssociateNumber = false;

			if (associateNumber == null) {
				query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_1);
			}
			else if (associateNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_3);
			}
			else {
				bindAssociateNumber = true;

				query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssociateNumber) {
					qPos.add(associateNumber);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where associateNumber = &#63;.
	 *
	 * @param associateNumber the associate number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByAssociateNumber_First(String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByAssociateNumber_First(associateNumber,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("associateNumber=");
		msg.append(associateNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where associateNumber = &#63;.
	 *
	 * @param associateNumber the associate number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByAssociateNumber_First(String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByAssociateNumber(associateNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where associateNumber = &#63;.
	 *
	 * @param associateNumber the associate number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByAssociateNumber_Last(String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByAssociateNumber_Last(associateNumber,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("associateNumber=");
		msg.append(associateNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where associateNumber = &#63;.
	 *
	 * @param associateNumber the associate number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByAssociateNumber_Last(String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByAssociateNumber(associateNumber);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByAssociateNumber(associateNumber,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where associateNumber = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param associateNumber the associate number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByAssociateNumber_PrevAndNext(String pId,
		String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByAssociateNumber_PrevAndNext(session, wfms_Position,
					associateNumber, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByAssociateNumber_PrevAndNext(session, wfms_Position,
					associateNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByAssociateNumber_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindAssociateNumber = false;

		if (associateNumber == null) {
			query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_1);
		}
		else if (associateNumber.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_3);
		}
		else {
			bindAssociateNumber = true;

			query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAssociateNumber) {
			qPos.add(associateNumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where associateNumber = &#63; from the database.
	 *
	 * @param associateNumber the associate number
	 */
	@Override
	public void removeByAssociateNumber(String associateNumber) {
		for (WFMS_Position wfms_Position : findByAssociateNumber(
				associateNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where associateNumber = &#63;.
	 *
	 * @param associateNumber the associate number
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByAssociateNumber(String associateNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSOCIATENUMBER;

		Object[] finderArgs = new Object[] { associateNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindAssociateNumber = false;

			if (associateNumber == null) {
				query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_1);
			}
			else if (associateNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_3);
			}
			else {
				bindAssociateNumber = true;

				query.append(_FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssociateNumber) {
					qPos.add(associateNumber);
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

	private static final String _FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_1 =
		"wfms_Position.associateNumber IS NULL";
	private static final String _FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_2 =
		"wfms_Position.associateNumber = ?";
	private static final String _FINDER_COLUMN_ASSOCIATENUMBER_ASSOCIATENUMBER_3 =
		"(wfms_Position.associateNumber IS NULL OR wfms_Position.associateNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTOGENERATEREQ =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByautoGenerateReq",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTOGENERATEREQ =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByautoGenerateReq", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.AUTOGENERATEREQ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTOGENERATEREQ = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByautoGenerateReq", new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where autoGenerateReq = &#63;.
	 *
	 * @param autoGenerateReq the auto generate req
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByautoGenerateReq(String autoGenerateReq) {
		return findByautoGenerateReq(autoGenerateReq, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where autoGenerateReq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByautoGenerateReq(String autoGenerateReq,
		int start, int end) {
		return findByautoGenerateReq(autoGenerateReq, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where autoGenerateReq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByautoGenerateReq(String autoGenerateReq,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByautoGenerateReq(autoGenerateReq, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where autoGenerateReq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByautoGenerateReq(String autoGenerateReq,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTOGENERATEREQ;
			finderArgs = new Object[] { autoGenerateReq };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTOGENERATEREQ;
			finderArgs = new Object[] {
					autoGenerateReq,
					
					start, end, orderByComparator
				};
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(autoGenerateReq,
								wfms_Position.getAutoGenerateReq())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindAutoGenerateReq = false;

			if (autoGenerateReq == null) {
				query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_1);
			}
			else if (autoGenerateReq.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_3);
			}
			else {
				bindAutoGenerateReq = true;

				query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAutoGenerateReq) {
					qPos.add(autoGenerateReq);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByautoGenerateReq_First(String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByautoGenerateReq_First(autoGenerateReq,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("autoGenerateReq=");
		msg.append(autoGenerateReq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByautoGenerateReq_First(String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByautoGenerateReq(autoGenerateReq, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByautoGenerateReq_Last(String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByautoGenerateReq_Last(autoGenerateReq,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("autoGenerateReq=");
		msg.append(autoGenerateReq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	 *
	 * @param autoGenerateReq the auto generate req
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByautoGenerateReq_Last(String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByautoGenerateReq(autoGenerateReq);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByautoGenerateReq(autoGenerateReq,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param autoGenerateReq the auto generate req
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByautoGenerateReq_PrevAndNext(String pId,
		String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByautoGenerateReq_PrevAndNext(session, wfms_Position,
					autoGenerateReq, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByautoGenerateReq_PrevAndNext(session, wfms_Position,
					autoGenerateReq, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByautoGenerateReq_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindAutoGenerateReq = false;

		if (autoGenerateReq == null) {
			query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_1);
		}
		else if (autoGenerateReq.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_3);
		}
		else {
			bindAutoGenerateReq = true;

			query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAutoGenerateReq) {
			qPos.add(autoGenerateReq);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where autoGenerateReq = &#63; from the database.
	 *
	 * @param autoGenerateReq the auto generate req
	 */
	@Override
	public void removeByautoGenerateReq(String autoGenerateReq) {
		for (WFMS_Position wfms_Position : findByautoGenerateReq(
				autoGenerateReq, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where autoGenerateReq = &#63;.
	 *
	 * @param autoGenerateReq the auto generate req
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByautoGenerateReq(String autoGenerateReq) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTOGENERATEREQ;

		Object[] finderArgs = new Object[] { autoGenerateReq };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindAutoGenerateReq = false;

			if (autoGenerateReq == null) {
				query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_1);
			}
			else if (autoGenerateReq.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_3);
			}
			else {
				bindAutoGenerateReq = true;

				query.append(_FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAutoGenerateReq) {
					qPos.add(autoGenerateReq);
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

	private static final String _FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_1 =
		"wfms_Position.autoGenerateReq IS NULL";
	private static final String _FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_2 =
		"wfms_Position.autoGenerateReq = ?";
	private static final String _FINDER_COLUMN_AUTOGENERATEREQ_AUTOGENERATEREQ_3 =
		"(wfms_Position.autoGenerateReq IS NULL OR wfms_Position.autoGenerateReq = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBY =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatedBy",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreatedBy", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.CREATEDBY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBY = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreatedBy",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCreatedBy(String createdBy) {
		return findByCreatedBy(createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCreatedBy(String createdBy, int start,
		int end) {
		return findByCreatedBy(createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCreatedBy(String createdBy, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByCreatedBy(createdBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByCreatedBy(String createdBy, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator,
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

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(createdBy, wfms_Position.getCreatedBy())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

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
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByCreatedBy_First(String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByCreatedBy_First(createdBy,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByCreatedBy_First(String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByCreatedBy(createdBy, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByCreatedBy_Last(String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByCreatedBy_Last(createdBy,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByCreatedBy_Last(String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByCreatedBy(createdBy);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByCreatedBy(createdBy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where createdBy = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByCreatedBy_PrevAndNext(String pId,
		String createdBy, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByCreatedBy_PrevAndNext(session, wfms_Position,
					createdBy, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByCreatedBy_PrevAndNext(session, wfms_Position,
					createdBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByCreatedBy_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 */
	@Override
	public void removeByCreatedBy(String createdBy) {
		for (WFMS_Position wfms_Position : findByCreatedBy(createdBy,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByCreatedBy(String createdBy) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDBY;

		Object[] finderArgs = new Object[] { createdBy };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_1 = "wfms_Position.createdBy IS NULL";
	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_2 = "wfms_Position.createdBy = ?";
	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_3 = "(wfms_Position.createdBy IS NULL OR wfms_Position.createdBy = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITION = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByposition", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.PID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITION = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByposition",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_Position where pId = &#63; or throws a {@link NoSuchWFMS_PositionException} if it could not be found.
	 *
	 * @param pId the p ID
	 * @return the matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByposition(String pId)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByposition(pId);

		if (wfms_Position == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pId=");
			msg.append(pId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_PositionException(msg.toString());
		}

		return wfms_Position;
	}

	/**
	 * Returns the WFMS_Position where pId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pId the p ID
	 * @return the matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByposition(String pId) {
		return fetchByposition(pId, true);
	}

	/**
	 * Returns the WFMS_Position where pId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pId the p ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByposition(String pId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { pId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_POSITION,
					finderArgs, this);
		}

		if (result instanceof WFMS_Position) {
			WFMS_Position wfms_Position = (WFMS_Position)result;

			if (!Objects.equals(pId, wfms_Position.getPId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindPId = false;

			if (pId == null) {
				query.append(_FINDER_COLUMN_POSITION_PID_1);
			}
			else if (pId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITION_PID_3);
			}
			else {
				bindPId = true;

				query.append(_FINDER_COLUMN_POSITION_PID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPId) {
					qPos.add(pId);
				}

				List<WFMS_Position> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_PositionPersistenceImpl.fetchByposition(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_Position wfms_Position = list.get(0);

					result = wfms_Position;

					cacheResult(wfms_Position);

					if ((wfms_Position.getPId() == null) ||
							!wfms_Position.getPId().equals(pId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION,
							finderArgs, wfms_Position);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION,
					finderArgs);

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
			return (WFMS_Position)result;
		}
	}

	/**
	 * Removes the WFMS_Position where pId = &#63; from the database.
	 *
	 * @param pId the p ID
	 * @return the WFMS_Position that was removed
	 */
	@Override
	public WFMS_Position removeByposition(String pId)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByposition(pId);

		return remove(wfms_Position);
	}

	/**
	 * Returns the number of WFMS_Positions where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByposition(String pId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITION;

		Object[] finderArgs = new Object[] { pId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindPId = false;

			if (pId == null) {
				query.append(_FINDER_COLUMN_POSITION_PID_1);
			}
			else if (pId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITION_PID_3);
			}
			else {
				bindPId = true;

				query.append(_FINDER_COLUMN_POSITION_PID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPId) {
					qPos.add(pId);
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

	private static final String _FINDER_COLUMN_POSITION_PID_1 = "wfms_Position.pId IS NULL";
	private static final String _FINDER_COLUMN_POSITION_PID_2 = "wfms_Position.pId = ?";
	private static final String _FINDER_COLUMN_POSITION_PID_3 = "(wfms_Position.pId IS NULL OR wfms_Position.pId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypositionIdGetByStaus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypositionIdGetByStaus",
			new String[] { String.class.getName() },
			WFMS_PositionModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypositionIdGetByStaus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBypositionIdGetByStaus(String status) {
		return findBypositionIdGetByStaus(status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBypositionIdGetByStaus(String status,
		int start, int end) {
		return findBypositionIdGetByStaus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBypositionIdGetByStaus(String status,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findBypositionIdGetByStaus(status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findBypositionIdGetByStaus(String status,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(status, wfms_Position.getStatus())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findBypositionIdGetByStaus_First(String status,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchBypositionIdGetByStaus_First(status,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchBypositionIdGetByStaus_First(String status,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findBypositionIdGetByStaus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findBypositionIdGetByStaus_Last(String status,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchBypositionIdGetByStaus_Last(status,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchBypositionIdGetByStaus_Last(String status,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countBypositionIdGetByStaus(status);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findBypositionIdGetByStaus(status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where status = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findBypositionIdGetByStaus_PrevAndNext(String pId,
		String status, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getBypositionIdGetByStaus_PrevAndNext(session,
					wfms_Position, status, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getBypositionIdGetByStaus_PrevAndNext(session,
					wfms_Position, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getBypositionIdGetByStaus_PrevAndNext(
		Session session, WFMS_Position wfms_Position, String status,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBypositionIdGetByStaus(String status) {
		for (WFMS_Position wfms_Position : findBypositionIdGetByStaus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countBypositionIdGetByStaus(String status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_1 = "wfms_Position.status IS NULL";
	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_2 = "wfms_Position.status = ?";
	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_3 = "(wfms_Position.status IS NULL OR wfms_Position.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKFLOWID =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByworkflowId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByworkflowId", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.WORKFLOWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOWID = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByworkflowId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByworkflowId(String workflowId) {
		return findByworkflowId(workflowId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByworkflowId(String workflowId, int start,
		int end) {
		return findByworkflowId(workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByworkflowId(String workflowId, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByworkflowId(workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByworkflowId(String workflowId, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID;
			finderArgs = new Object[] { workflowId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKFLOWID;
			finderArgs = new Object[] { workflowId, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(workflowId,
								wfms_Position.getWorkflowId())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindWorkflowId = false;

			if (workflowId == null) {
				query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_1);
			}
			else if (workflowId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_3);
			}
			else {
				bindWorkflowId = true;

				query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWorkflowId) {
					qPos.add(workflowId);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByworkflowId_First(String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByworkflowId_First(workflowId,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workflowId=");
		msg.append(workflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByworkflowId_First(String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByworkflowId(workflowId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByworkflowId_Last(String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByworkflowId_Last(workflowId,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workflowId=");
		msg.append(workflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByworkflowId_Last(String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByworkflowId(workflowId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByworkflowId(workflowId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where workflowId = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByworkflowId_PrevAndNext(String pId,
		String workflowId, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByworkflowId_PrevAndNext(session, wfms_Position,
					workflowId, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByworkflowId_PrevAndNext(session, wfms_Position,
					workflowId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByworkflowId_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindWorkflowId = false;

		if (workflowId == null) {
			query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_1);
		}
		else if (workflowId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_3);
		}
		else {
			bindWorkflowId = true;

			query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWorkflowId) {
			qPos.add(workflowId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByworkflowId(String workflowId) {
		for (WFMS_Position wfms_Position : findByworkflowId(workflowId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByworkflowId(String workflowId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKFLOWID;

		Object[] finderArgs = new Object[] { workflowId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindWorkflowId = false;

			if (workflowId == null) {
				query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_1);
			}
			else if (workflowId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_3);
			}
			else {
				bindWorkflowId = true;

				query.append(_FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWorkflowId) {
					qPos.add(workflowId);
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

	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_1 = "wfms_Position.workflowId IS NULL";
	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2 = "wfms_Position.workflowId = ?";
	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_3 = "(wfms_Position.workflowId IS NULL OR wfms_Position.workflowId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTNAME =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTNAME =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentName", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.DEPARTMENTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTNAME = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByDepartmentName(String departmentName) {
		return findByDepartmentName(departmentName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where departmentName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentName the department name
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByDepartmentName(String departmentName,
		int start, int end) {
		return findByDepartmentName(departmentName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where departmentName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentName the department name
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByDepartmentName(String departmentName,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByDepartmentName(departmentName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where departmentName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentName the department name
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByDepartmentName(String departmentName,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTNAME;
			finderArgs = new Object[] { departmentName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTNAME;
			finderArgs = new Object[] {
					departmentName,
					
					start, end, orderByComparator
				};
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(departmentName,
								wfms_Position.getDepartmentName())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindDepartmentName = false;

			if (departmentName == null) {
				query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_1);
			}
			else if (departmentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3);
			}
			else {
				bindDepartmentName = true;

				query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDepartmentName) {
					qPos.add(departmentName);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByDepartmentName_First(String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByDepartmentName_First(departmentName,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentName=");
		msg.append(departmentName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByDepartmentName_First(String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByDepartmentName(departmentName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByDepartmentName_Last(String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByDepartmentName_Last(departmentName,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentName=");
		msg.append(departmentName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByDepartmentName_Last(String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByDepartmentName(departmentName);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByDepartmentName(departmentName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where departmentName = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param departmentName the department name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByDepartmentName_PrevAndNext(String pId,
		String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByDepartmentName_PrevAndNext(session, wfms_Position,
					departmentName, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByDepartmentName_PrevAndNext(session, wfms_Position,
					departmentName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByDepartmentName_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindDepartmentName = false;

		if (departmentName == null) {
			query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_1);
		}
		else if (departmentName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3);
		}
		else {
			bindDepartmentName = true;

			query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDepartmentName) {
			qPos.add(departmentName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where departmentName = &#63; from the database.
	 *
	 * @param departmentName the department name
	 */
	@Override
	public void removeByDepartmentName(String departmentName) {
		for (WFMS_Position wfms_Position : findByDepartmentName(
				departmentName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByDepartmentName(String departmentName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENTNAME;

		Object[] finderArgs = new Object[] { departmentName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindDepartmentName = false;

			if (departmentName == null) {
				query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_1);
			}
			else if (departmentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3);
			}
			else {
				bindDepartmentName = true;

				query.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDepartmentName) {
					qPos.add(departmentName);
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

	private static final String _FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_1 = "wfms_Position.departmentName IS NULL";
	private static final String _FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2 = "wfms_Position.departmentName = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3 = "(wfms_Position.departmentName IS NULL OR wfms_Position.departmentName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTSTO =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReportsTo",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTO =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReportsTo", new String[] { String.class.getName() },
			WFMS_PositionModelImpl.REPORTSTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTSTO = new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReportsTo",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where reportsTo = &#63;.
	 *
	 * @param reportsTo the reports to
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByReportsTo(String reportsTo) {
		return findByReportsTo(reportsTo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where reportsTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportsTo the reports to
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByReportsTo(String reportsTo, int start,
		int end) {
		return findByReportsTo(reportsTo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where reportsTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportsTo the reports to
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByReportsTo(String reportsTo, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByReportsTo(reportsTo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where reportsTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportsTo the reports to
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByReportsTo(String reportsTo, int start,
		int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTO;
			finderArgs = new Object[] { reportsTo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTSTO;
			finderArgs = new Object[] { reportsTo, start, end, orderByComparator };
		}

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!Objects.equals(reportsTo, wfms_Position.getReportsTo())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindReportsTo = false;

			if (reportsTo == null) {
				query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_1);
			}
			else if (reportsTo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_3);
			}
			else {
				bindReportsTo = true;

				query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReportsTo) {
					qPos.add(reportsTo);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where reportsTo = &#63;.
	 *
	 * @param reportsTo the reports to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByReportsTo_First(String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByReportsTo_First(reportsTo,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportsTo=");
		msg.append(reportsTo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where reportsTo = &#63;.
	 *
	 * @param reportsTo the reports to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByReportsTo_First(String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByReportsTo(reportsTo, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where reportsTo = &#63;.
	 *
	 * @param reportsTo the reports to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByReportsTo_Last(String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByReportsTo_Last(reportsTo,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportsTo=");
		msg.append(reportsTo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where reportsTo = &#63;.
	 *
	 * @param reportsTo the reports to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByReportsTo_Last(String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByReportsTo(reportsTo);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByReportsTo(reportsTo, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where reportsTo = &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param reportsTo the reports to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByReportsTo_PrevAndNext(String pId,
		String reportsTo, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByReportsTo_PrevAndNext(session, wfms_Position,
					reportsTo, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByReportsTo_PrevAndNext(session, wfms_Position,
					reportsTo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByReportsTo_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindReportsTo = false;

		if (reportsTo == null) {
			query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_1);
		}
		else if (reportsTo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_3);
		}
		else {
			bindReportsTo = true;

			query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReportsTo) {
			qPos.add(reportsTo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where reportsTo = &#63; from the database.
	 *
	 * @param reportsTo the reports to
	 */
	@Override
	public void removeByReportsTo(String reportsTo) {
		for (WFMS_Position wfms_Position : findByReportsTo(reportsTo,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where reportsTo = &#63;.
	 *
	 * @param reportsTo the reports to
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByReportsTo(String reportsTo) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTSTO;

		Object[] finderArgs = new Object[] { reportsTo };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindReportsTo = false;

			if (reportsTo == null) {
				query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_1);
			}
			else if (reportsTo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_3);
			}
			else {
				bindReportsTo = true;

				query.append(_FINDER_COLUMN_REPORTSTO_REPORTSTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReportsTo) {
					qPos.add(reportsTo);
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

	private static final String _FINDER_COLUMN_REPORTSTO_REPORTSTO_1 = "wfms_Position.reportsTo IS NULL";
	private static final String _FINDER_COLUMN_REPORTSTO_REPORTSTO_2 = "wfms_Position.reportsTo = ?";
	private static final String _FINDER_COLUMN_REPORTSTO_REPORTSTO_3 = "(wfms_Position.reportsTo IS NULL OR wfms_Position.reportsTo = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTAPPROVER =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNextApprover",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NEXTAPPROVER =
		new FinderPath(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNextApprover",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Positions where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @return the matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNextApprover(String nextApprover) {
		return findByNextApprover(nextApprover, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions where nextApprover LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextApprover the next approver
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNextApprover(String nextApprover,
		int start, int end) {
		return findByNextApprover(nextApprover, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where nextApprover LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextApprover the next approver
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNextApprover(String nextApprover,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return findByNextApprover(nextApprover, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions where nextApprover LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextApprover the next approver
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findByNextApprover(String nextApprover,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTAPPROVER;
		finderArgs = new Object[] { nextApprover, start, end, orderByComparator };

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position wfms_Position : list) {
					if (!StringUtil.wildcardMatches(
								wfms_Position.getNextApprover(), nextApprover,
								CharPool.UNDERLINE, CharPool.PERCENT,
								CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

			boolean bindNextApprover = false;

			if (nextApprover == null) {
				query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_1);
			}
			else if (nextApprover.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_3);
			}
			else {
				bindNextApprover = true;

				query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNextApprover) {
					qPos.add(nextApprover);
				}

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByNextApprover_First(String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByNextApprover_First(nextApprover,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextApprover=");
		msg.append(nextApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByNextApprover_First(String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator) {
		List<WFMS_Position> list = findByNextApprover(nextApprover, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position findByNextApprover_Last(String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByNextApprover_Last(nextApprover,
				orderByComparator);

		if (wfms_Position != null) {
			return wfms_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextApprover=");
		msg.append(nextApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_PositionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	 */
	@Override
	public WFMS_Position fetchByNextApprover_Last(String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator) {
		int count = countByNextApprover(nextApprover);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position> list = findByNextApprover(nextApprover, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param pId the primary key of the current WFMS_Position
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position[] findByNextApprover_PrevAndNext(String pId,
		String nextApprover, OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = findByPrimaryKey(pId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position[] array = new WFMS_PositionImpl[3];

			array[0] = getByNextApprover_PrevAndNext(session, wfms_Position,
					nextApprover, orderByComparator, true);

			array[1] = wfms_Position;

			array[2] = getByNextApprover_PrevAndNext(session, wfms_Position,
					nextApprover, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position getByNextApprover_PrevAndNext(Session session,
		WFMS_Position wfms_Position, String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE);

		boolean bindNextApprover = false;

		if (nextApprover == null) {
			query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_1);
		}
		else if (nextApprover.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_3);
		}
		else {
			bindNextApprover = true;

			query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_2);
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
			query.append(WFMS_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNextApprover) {
			qPos.add(nextApprover);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Positions where nextApprover LIKE &#63; from the database.
	 *
	 * @param nextApprover the next approver
	 */
	@Override
	public void removeByNextApprover(String nextApprover) {
		for (WFMS_Position wfms_Position : findByNextApprover(nextApprover,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @return the number of matching WFMS_Positions
	 */
	@Override
	public int countByNextApprover(String nextApprover) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NEXTAPPROVER;

		Object[] finderArgs = new Object[] { nextApprover };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_WHERE);

			boolean bindNextApprover = false;

			if (nextApprover == null) {
				query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_1);
			}
			else if (nextApprover.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_3);
			}
			else {
				bindNextApprover = true;

				query.append(_FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNextApprover) {
					qPos.add(nextApprover);
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

	private static final String _FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_1 = "wfms_Position.nextApprover IS NULL";
	private static final String _FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_2 = "wfms_Position.nextApprover LIKE ?";
	private static final String _FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_3 = "(wfms_Position.nextApprover IS NULL OR wfms_Position.nextApprover LIKE '')";

	public WFMS_PositionPersistenceImpl() {
		setModelClass(WFMS_Position.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("active", "active_");
			dbColumnNames.put("number", "number_");
			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the WFMS_Position in the entity cache if it is enabled.
	 *
	 * @param wfms_Position the WFMS_Position
	 */
	@Override
	public void cacheResult(WFMS_Position wfms_Position) {
		entityCache.putResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionImpl.class, wfms_Position.getPrimaryKey(),
			wfms_Position);

		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION,
			new Object[] { wfms_Position.getPId() }, wfms_Position);

		wfms_Position.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_Positions in the entity cache if it is enabled.
	 *
	 * @param wfms_Positions the WFMS_Positions
	 */
	@Override
	public void cacheResult(List<WFMS_Position> wfms_Positions) {
		for (WFMS_Position wfms_Position : wfms_Positions) {
			if (entityCache.getResult(
						WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_PositionImpl.class, wfms_Position.getPrimaryKey()) == null) {
				cacheResult(wfms_Position);
			}
			else {
				wfms_Position.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_Positions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_PositionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_Position.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_Position wfms_Position) {
		entityCache.removeResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionImpl.class, wfms_Position.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_PositionModelImpl)wfms_Position, true);
	}

	@Override
	public void clearCache(List<WFMS_Position> wfms_Positions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_Position wfms_Position : wfms_Positions) {
			entityCache.removeResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_PositionImpl.class, wfms_Position.getPrimaryKey());

			clearUniqueFindersCache((WFMS_PositionModelImpl)wfms_Position, true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_PositionModelImpl wfms_PositionModelImpl) {
		Object[] args = new Object[] { wfms_PositionModelImpl.getPId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_POSITION, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION, args,
			wfms_PositionModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_PositionModelImpl wfms_PositionModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { wfms_PositionModelImpl.getPId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION, args);
		}

		if ((wfms_PositionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITION.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { wfms_PositionModelImpl.getOriginalPId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION, args);
		}
	}

	/**
	 * Creates a new WFMS_Position with the primary key. Does not add the WFMS_Position to the database.
	 *
	 * @param pId the primary key for the new WFMS_Position
	 * @return the new WFMS_Position
	 */
	@Override
	public WFMS_Position create(String pId) {
		WFMS_Position wfms_Position = new WFMS_PositionImpl();

		wfms_Position.setNew(true);
		wfms_Position.setPrimaryKey(pId);

		wfms_Position.setCompanyId(companyProvider.getCompanyId());

		return wfms_Position;
	}

	/**
	 * Removes the WFMS_Position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pId the primary key of the WFMS_Position
	 * @return the WFMS_Position that was removed
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position remove(String pId) throws NoSuchWFMS_PositionException {
		return remove((Serializable)pId);
	}

	/**
	 * Removes the WFMS_Position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_Position
	 * @return the WFMS_Position that was removed
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position remove(Serializable primaryKey)
		throws NoSuchWFMS_PositionException {
		Session session = null;

		try {
			session = openSession();

			WFMS_Position wfms_Position = (WFMS_Position)session.get(WFMS_PositionImpl.class,
					primaryKey);

			if (wfms_Position == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_PositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_Position);
		}
		catch (NoSuchWFMS_PositionException nsee) {
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
	protected WFMS_Position removeImpl(WFMS_Position wfms_Position) {
		wfms_Position = toUnwrappedModel(wfms_Position);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_Position)) {
				wfms_Position = (WFMS_Position)session.get(WFMS_PositionImpl.class,
						wfms_Position.getPrimaryKeyObj());
			}

			if (wfms_Position != null) {
				session.delete(wfms_Position);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_Position != null) {
			clearCache(wfms_Position);
		}

		return wfms_Position;
	}

	@Override
	public WFMS_Position updateImpl(WFMS_Position wfms_Position) {
		wfms_Position = toUnwrappedModel(wfms_Position);

		boolean isNew = wfms_Position.isNew();

		WFMS_PositionModelImpl wfms_PositionModelImpl = (WFMS_PositionModelImpl)wfms_Position;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_Position.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_Position.setCreateDate(now);
			}
			else {
				wfms_Position.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wfms_PositionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_Position.setModifiedDate(now);
			}
			else {
				wfms_Position.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_Position.isNew()) {
				session.save(wfms_Position);

				wfms_Position.setNew(false);
			}
			else {
				wfms_Position = (WFMS_Position)session.merge(wfms_Position);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_PositionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { wfms_PositionModelImpl.getRefPosId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REFPOSID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFPOSID,
				args);

			args = new Object[] { wfms_PositionModelImpl.getDummy() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DUMMY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY,
				args);

			args = new Object[] { wfms_PositionModelImpl.getNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
				args);

			args = new Object[] { wfms_PositionModelImpl.getCategory() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
				args);

			args = new Object[] { wfms_PositionModelImpl.getAssociateNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATENUMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATENUMBER,
				args);

			args = new Object[] { wfms_PositionModelImpl.getAutoGenerateReq() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTOGENERATEREQ, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTOGENERATEREQ,
				args);

			args = new Object[] { wfms_PositionModelImpl.getCreatedBy() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
				args);

			args = new Object[] { wfms_PositionModelImpl.getStatus() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
				args);

			args = new Object[] { wfms_PositionModelImpl.getWorkflowId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID,
				args);

			args = new Object[] { wfms_PositionModelImpl.getDepartmentName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTNAME,
				args);

			args = new Object[] { wfms_PositionModelImpl.getReportsTo() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTSTO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTO,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFPOSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalRefPosId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REFPOSID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFPOSID,
					args);

				args = new Object[] { wfms_PositionModelImpl.getRefPosId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REFPOSID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFPOSID,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalDummy()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DUMMY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY,
					args);

				args = new Object[] { wfms_PositionModelImpl.getDummy() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DUMMY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
					args);

				args = new Object[] { wfms_PositionModelImpl.getNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMBER,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalCategory()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { wfms_PositionModelImpl.getCategory() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalAssociateNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATENUMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATENUMBER,
					args);

				args = new Object[] { wfms_PositionModelImpl.getAssociateNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATENUMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATENUMBER,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTOGENERATEREQ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalAutoGenerateReq()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTOGENERATEREQ,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTOGENERATEREQ,
					args);

				args = new Object[] { wfms_PositionModelImpl.getAutoGenerateReq() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTOGENERATEREQ,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTOGENERATEREQ,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalCreatedBy()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
					args);

				args = new Object[] { wfms_PositionModelImpl.getCreatedBy() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
					args);

				args = new Object[] { wfms_PositionModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalWorkflowId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID,
					args);

				args = new Object[] { wfms_PositionModelImpl.getWorkflowId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalDepartmentName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTNAME,
					args);

				args = new Object[] { wfms_PositionModelImpl.getDepartmentName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTNAME,
					args);
			}

			if ((wfms_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_PositionModelImpl.getOriginalReportsTo()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTSTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTO,
					args);

				args = new Object[] { wfms_PositionModelImpl.getReportsTo() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTSTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTSTO,
					args);
			}
		}

		entityCache.putResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_PositionImpl.class, wfms_Position.getPrimaryKey(),
			wfms_Position, false);

		clearUniqueFindersCache(wfms_PositionModelImpl, false);
		cacheUniqueFindersCache(wfms_PositionModelImpl);

		wfms_Position.resetOriginalValues();

		return wfms_Position;
	}

	protected WFMS_Position toUnwrappedModel(WFMS_Position wfms_Position) {
		if (wfms_Position instanceof WFMS_PositionImpl) {
			return wfms_Position;
		}

		WFMS_PositionImpl wfms_PositionImpl = new WFMS_PositionImpl();

		wfms_PositionImpl.setNew(wfms_Position.isNew());
		wfms_PositionImpl.setPrimaryKey(wfms_Position.getPrimaryKey());

		wfms_PositionImpl.setPId(wfms_Position.getPId());
		wfms_PositionImpl.setCompanyId(wfms_Position.getCompanyId());
		wfms_PositionImpl.setScopeGroupId(wfms_Position.getScopeGroupId());
		wfms_PositionImpl.setCreatedBy(wfms_Position.getCreatedBy());
		wfms_PositionImpl.setCreateDate(wfms_Position.getCreateDate());
		wfms_PositionImpl.setModifiedBy(wfms_Position.getModifiedBy());
		wfms_PositionImpl.setModifiedDate(wfms_Position.getModifiedDate());
		wfms_PositionImpl.setActive(wfms_Position.isActive());
		wfms_PositionImpl.setNumber(wfms_Position.getNumber());
		wfms_PositionImpl.setDescription(wfms_Position.getDescription());
		wfms_PositionImpl.setStatus(wfms_Position.getStatus());
		wfms_PositionImpl.setReportsTo(wfms_Position.getReportsTo());
		wfms_PositionImpl.setAutoGenerateReq(wfms_Position.getAutoGenerateReq());
		wfms_PositionImpl.setCritical(wfms_Position.isCritical());
		wfms_PositionImpl.setDivision(wfms_Position.getDivision());
		wfms_PositionImpl.setDepartmentName(wfms_Position.getDepartmentName());
		wfms_PositionImpl.setDepartmentNumber(wfms_Position.getDepartmentNumber());
		wfms_PositionImpl.setLine(wfms_Position.getLine());
		wfms_PositionImpl.setLadder(wfms_Position.getLadder());
		wfms_PositionImpl.setMpCatBugdet(wfms_Position.getMpCatBugdet());
		wfms_PositionImpl.setMpCatFilledWith(wfms_Position.getMpCatFilledWith());
		wfms_PositionImpl.setPositionClass(wfms_Position.getPositionClass());
		wfms_PositionImpl.setType(wfms_Position.getType());
		wfms_PositionImpl.setLevel(wfms_Position.getLevel());
		wfms_PositionImpl.setLeadershipAssignment(wfms_Position.getLeadershipAssignment());
		wfms_PositionImpl.setCategory(wfms_Position.getCategory());
		wfms_PositionImpl.setSubCategory(wfms_Position.getSubCategory());
		wfms_PositionImpl.setWorkforceCategory(wfms_Position.getWorkforceCategory());
		wfms_PositionImpl.setEmpCategory(wfms_Position.getEmpCategory());
		wfms_PositionImpl.setEmpCategoryDesc(wfms_Position.getEmpCategoryDesc());
		wfms_PositionImpl.setYearEst(wfms_Position.getYearEst());
		wfms_PositionImpl.setReasonsFor(wfms_Position.getReasonsFor());
		wfms_PositionImpl.setReavailuationDate(wfms_Position.getReavailuationDate());
		wfms_PositionImpl.setAssociateNumber(wfms_Position.getAssociateNumber());
		wfms_PositionImpl.setAssociateName(wfms_Position.getAssociateName());
		wfms_PositionImpl.setAssociateTitle(wfms_Position.getAssociateTitle());
		wfms_PositionImpl.setComments(wfms_Position.getComments());
		wfms_PositionImpl.setTypicalJobTitle(wfms_Position.getTypicalJobTitle());
		wfms_PositionImpl.setMinJobKnowHow(wfms_Position.getMinJobKnowHow());
		wfms_PositionImpl.setDuties(wfms_Position.getDuties());
		wfms_PositionImpl.setTasksPerformed(wfms_Position.getTasksPerformed());
		wfms_PositionImpl.setLengthOfService(wfms_Position.getLengthOfService());
		wfms_PositionImpl.setDegree(wfms_Position.getDegree());
		wfms_PositionImpl.setReqSkills(wfms_Position.getReqSkills());
		wfms_PositionImpl.setDesiredSkills(wfms_Position.getDesiredSkills());
		wfms_PositionImpl.setEnvironment(wfms_Position.getEnvironment());
		wfms_PositionImpl.setWeeklyOvertime(wfms_Position.getWeeklyOvertime());
		wfms_PositionImpl.setFrequencyOfTravel(wfms_Position.getFrequencyOfTravel());
		wfms_PositionImpl.setHistory(wfms_Position.getHistory());
		wfms_PositionImpl.setOther(wfms_Position.getOther());
		wfms_PositionImpl.setDepartmentManager(wfms_Position.getDepartmentManager());
		wfms_PositionImpl.setDivisionManager(wfms_Position.getDivisionManager());
		wfms_PositionImpl.setRelatesTo(wfms_Position.getRelatesTo());
		wfms_PositionImpl.setNextApprover(wfms_Position.getNextApprover());
		wfms_PositionImpl.setWorkflow(wfms_Position.getWorkflow());
		wfms_PositionImpl.setWorkflowStep(wfms_Position.getWorkflowStep());
		wfms_PositionImpl.setWorkflowId(wfms_Position.getWorkflowId());
		wfms_PositionImpl.setDummy(wfms_Position.getDummy());
		wfms_PositionImpl.setRefPosId(wfms_Position.getRefPosId());
		wfms_PositionImpl.setIsmodify(wfms_Position.isIsmodify());
		wfms_PositionImpl.setDisapproveComments(wfms_Position.getDisapproveComments());

		return wfms_PositionImpl;
	}

	/**
	 * Returns the WFMS_Position with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Position
	 * @return the WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_PositionException {
		WFMS_Position wfms_Position = fetchByPrimaryKey(primaryKey);

		if (wfms_Position == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_PositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_Position;
	}

	/**
	 * Returns the WFMS_Position with the primary key or throws a {@link NoSuchWFMS_PositionException} if it could not be found.
	 *
	 * @param pId the primary key of the WFMS_Position
	 * @return the WFMS_Position
	 * @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position findByPrimaryKey(String pId)
		throws NoSuchWFMS_PositionException {
		return findByPrimaryKey((Serializable)pId);
	}

	/**
	 * Returns the WFMS_Position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Position
	 * @return the WFMS_Position, or <code>null</code> if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_PositionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_Position wfms_Position = (WFMS_Position)serializable;

		if (wfms_Position == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_Position = (WFMS_Position)session.get(WFMS_PositionImpl.class,
						primaryKey);

				if (wfms_Position != null) {
					cacheResult(wfms_Position);
				}
				else {
					entityCache.putResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_PositionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_PositionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_Position;
	}

	/**
	 * Returns the WFMS_Position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pId the primary key of the WFMS_Position
	 * @return the WFMS_Position, or <code>null</code> if a WFMS_Position with the primary key could not be found
	 */
	@Override
	public WFMS_Position fetchByPrimaryKey(String pId) {
		return fetchByPrimaryKey((Serializable)pId);
	}

	@Override
	public Map<Serializable, WFMS_Position> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_Position> map = new HashMap<Serializable, WFMS_Position>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_Position wfms_Position = fetchByPrimaryKey(primaryKey);

			if (wfms_Position != null) {
				map.put(primaryKey, wfms_Position);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_PositionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_Position)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_POSITION_WHERE_PKS_IN);

		for (int i = 0; i < uncachedPrimaryKeys.size(); i++) {
			query.append(StringPool.QUESTION);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				qPos.add((String)primaryKey);
			}

			for (WFMS_Position wfms_Position : (List<WFMS_Position>)q.list()) {
				map.put(wfms_Position.getPrimaryKeyObj(), wfms_Position);

				cacheResult(wfms_Position);

				uncachedPrimaryKeys.remove(wfms_Position.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_PositionModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_PositionImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_Positions.
	 *
	 * @return the WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @return the range of WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findAll(int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Positions
	 * @param end the upper bound of the range of WFMS_Positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_Positions
	 */
	@Override
	public List<WFMS_Position> findAll(int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
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

		List<WFMS_Position> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_POSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_POSITION;

				if (pagination) {
					sql = sql.concat(WFMS_PositionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the WFMS_Positions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_Position wfms_Position : findAll()) {
			remove(wfms_Position);
		}
	}

	/**
	 * Returns the number of WFMS_Positions.
	 *
	 * @return the number of WFMS_Positions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_POSITION);

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
		return WFMS_PositionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_Position persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_PositionImpl.class.getName());
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
	private static final String _SQL_SELECT_WFMS_POSITION = "SELECT wfms_Position FROM WFMS_Position wfms_Position";
	private static final String _SQL_SELECT_WFMS_POSITION_WHERE_PKS_IN = "SELECT wfms_Position FROM WFMS_Position wfms_Position WHERE pId IN (";
	private static final String _SQL_SELECT_WFMS_POSITION_WHERE = "SELECT wfms_Position FROM WFMS_Position wfms_Position WHERE ";
	private static final String _SQL_COUNT_WFMS_POSITION = "SELECT COUNT(wfms_Position) FROM WFMS_Position wfms_Position";
	private static final String _SQL_COUNT_WFMS_POSITION_WHERE = "SELECT COUNT(wfms_Position) FROM WFMS_Position wfms_Position WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_Position.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_Position exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_Position exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_PositionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active", "number", "type"
			});
}