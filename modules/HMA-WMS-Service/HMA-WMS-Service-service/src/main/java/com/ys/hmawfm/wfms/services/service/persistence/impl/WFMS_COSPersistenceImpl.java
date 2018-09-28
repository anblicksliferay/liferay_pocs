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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_COSImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_COSPersistence;

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
 * The persistence implementation for the WFMS_COS service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_COSUtil
 * @generated
 */
@ProviderType
public class WFMS_COSPersistenceImpl extends BasePersistenceImpl<WFMS_COS>
	implements WFMS_COSPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_COSUtil} to access the WFMS_COS persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_COSImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSOICATEID =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAssoicateId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOICATEID =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAssoicateId",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.ASSOICATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSOICATEID = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAssoicateId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAssoicateId(String assoicateId) {
		return findByAssoicateId(assoicateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where assoicateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assoicateId the assoicate ID
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAssoicateId(String assoicateId, int start,
		int end) {
		return findByAssoicateId(assoicateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where assoicateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assoicateId the assoicate ID
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAssoicateId(String assoicateId, int start,
		int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return findByAssoicateId(assoicateId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where assoicateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assoicateId the assoicate ID
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAssoicateId(String assoicateId, int start,
		int end, OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOICATEID;
			finderArgs = new Object[] { assoicateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSOICATEID;
			finderArgs = new Object[] { assoicateId, start, end, orderByComparator };
		}

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!Objects.equals(assoicateId, wfms_cos.getAssoicateId())) {
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindAssoicateId = false;

			if (assoicateId == null) {
				query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_1);
			}
			else if (assoicateId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_3);
			}
			else {
				bindAssoicateId = true;

				query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssoicateId) {
					qPos.add(assoicateId);
				}

				if (!pagination) {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByAssoicateId_First(String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByAssoicateId_First(assoicateId,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assoicateId=");
		msg.append(assoicateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByAssoicateId_First(String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findByAssoicateId(assoicateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByAssoicateId_Last(String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByAssoicateId_Last(assoicateId,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assoicateId=");
		msg.append(assoicateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByAssoicateId_Last(String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countByAssoicateId(assoicateId);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findByAssoicateId(assoicateId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where assoicateId = &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param assoicateId the assoicate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findByAssoicateId_PrevAndNext(String cosId,
		String assoicateId, OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getByAssoicateId_PrevAndNext(session, wfms_cos,
					assoicateId, orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getByAssoicateId_PrevAndNext(session, wfms_cos,
					assoicateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_COS getByAssoicateId_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

		boolean bindAssoicateId = false;

		if (assoicateId == null) {
			query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_1);
		}
		else if (assoicateId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_3);
		}
		else {
			bindAssoicateId = true;

			query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_2);
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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAssoicateId) {
			qPos.add(assoicateId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where assoicateId = &#63; from the database.
	 *
	 * @param assoicateId the assoicate ID
	 */
	@Override
	public void removeByAssoicateId(String assoicateId) {
		for (WFMS_COS wfms_cos : findByAssoicateId(assoicateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countByAssoicateId(String assoicateId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSOICATEID;

		Object[] finderArgs = new Object[] { assoicateId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindAssoicateId = false;

			if (assoicateId == null) {
				query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_1);
			}
			else if (assoicateId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_3);
			}
			else {
				bindAssoicateId = true;

				query.append(_FINDER_COLUMN_ASSOICATEID_ASSOICATEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssoicateId) {
					qPos.add(assoicateId);
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

	private static final String _FINDER_COLUMN_ASSOICATEID_ASSOICATEID_1 = "wfms_cos.assoicateId IS NULL";
	private static final String _FINDER_COLUMN_ASSOICATEID_ASSOICATEID_2 = "wfms_cos.assoicateId = ?";
	private static final String _FINDER_COLUMN_ASSOICATEID_ASSOICATEID_3 = "(wfms_cos.assoicateId IS NULL OR wfms_cos.assoicateId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTION = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAction",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAction",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.ACTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTION = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAction",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where action = &#63;.
	 *
	 * @param action the action
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAction(String action) {
		return findByAction(action, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAction(String action, int start, int end) {
		return findByAction(action, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAction(String action, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return findByAction(action, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByAction(String action, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION;
			finderArgs = new Object[] { action };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTION;
			finderArgs = new Object[] { action, start, end, orderByComparator };
		}

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!Objects.equals(action, wfms_cos.getAction())) {
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_ACTION_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTION_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_ACTION_ACTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAction) {
					qPos.add(action);
				}

				if (!pagination) {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByAction_First(String action,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByAction_First(action, orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("action=");
		msg.append(action);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByAction_First(String action,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findByAction(action, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByAction_Last(String action,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByAction_Last(action, orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("action=");
		msg.append(action);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByAction_Last(String action,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countByAction(action);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findByAction(action, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where action = &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findByAction_PrevAndNext(String cosId, String action,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getByAction_PrevAndNext(session, wfms_cos, action,
					orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getByAction_PrevAndNext(session, wfms_cos, action,
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

	protected WFMS_COS getByAction_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String action,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

		boolean bindAction = false;

		if (action == null) {
			query.append(_FINDER_COLUMN_ACTION_ACTION_1);
		}
		else if (action.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACTION_ACTION_3);
		}
		else {
			bindAction = true;

			query.append(_FINDER_COLUMN_ACTION_ACTION_2);
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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAction) {
			qPos.add(action);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where action = &#63; from the database.
	 *
	 * @param action the action
	 */
	@Override
	public void removeByAction(String action) {
		for (WFMS_COS wfms_cos : findByAction(action, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where action = &#63;.
	 *
	 * @param action the action
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countByAction(String action) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTION;

		Object[] finderArgs = new Object[] { action };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_ACTION_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTION_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_ACTION_ACTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAction) {
					qPos.add(action);
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

	private static final String _FINDER_COLUMN_ACTION_ACTION_1 = "wfms_cos.action IS NULL";
	private static final String _FINDER_COLUMN_ACTION_ACTION_2 = "wfms_cos.action = ?";
	private static final String _FINDER_COLUMN_ACTION_ACTION_3 = "(wfms_cos.action IS NULL OR wfms_cos.action = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_COS = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBycos",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.COSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COS = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycos",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_COS where cosId = &#63; or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	 *
	 * @param cosId the cos ID
	 * @return the matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBycos(String cosId) throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBycos(cosId);

		if (wfms_cos == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cosId=");
			msg.append(cosId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_COSException(msg.toString());
		}

		return wfms_cos;
	}

	/**
	 * Returns the WFMS_COS where cosId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cosId the cos ID
	 * @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBycos(String cosId) {
		return fetchBycos(cosId, true);
	}

	/**
	 * Returns the WFMS_COS where cosId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cosId the cos ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBycos(String cosId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { cosId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_COS,
					finderArgs, this);
		}

		if (result instanceof WFMS_COS) {
			WFMS_COS wfms_cos = (WFMS_COS)result;

			if (!Objects.equals(cosId, wfms_cos.getCosId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindCosId = false;

			if (cosId == null) {
				query.append(_FINDER_COLUMN_COS_COSID_1);
			}
			else if (cosId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COS_COSID_3);
			}
			else {
				bindCosId = true;

				query.append(_FINDER_COLUMN_COS_COSID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCosId) {
					qPos.add(cosId);
				}

				List<WFMS_COS> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_COS, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_COSPersistenceImpl.fetchBycos(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_COS wfms_cos = list.get(0);

					result = wfms_cos;

					cacheResult(wfms_cos);

					if ((wfms_cos.getCosId() == null) ||
							!wfms_cos.getCosId().equals(cosId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_COS,
							finderArgs, wfms_cos);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_COS, finderArgs);

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
			return (WFMS_COS)result;
		}
	}

	/**
	 * Removes the WFMS_COS where cosId = &#63; from the database.
	 *
	 * @param cosId the cos ID
	 * @return the WFMS_COS that was removed
	 */
	@Override
	public WFMS_COS removeBycos(String cosId) throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findBycos(cosId);

		return remove(wfms_cos);
	}

	/**
	 * Returns the number of WFMS_COSs where cosId = &#63;.
	 *
	 * @param cosId the cos ID
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countBycos(String cosId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COS;

		Object[] finderArgs = new Object[] { cosId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindCosId = false;

			if (cosId == null) {
				query.append(_FINDER_COLUMN_COS_COSID_1);
			}
			else if (cosId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COS_COSID_3);
			}
			else {
				bindCosId = true;

				query.append(_FINDER_COLUMN_COS_COSID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCosId) {
					qPos.add(cosId);
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

	private static final String _FINDER_COLUMN_COS_COSID_1 = "wfms_cos.cosId IS NULL";
	private static final String _FINDER_COLUMN_COS_COSID_2 = "wfms_cos.cosId = ?";
	private static final String _FINDER_COLUMN_COS_COSID_3 = "(wfms_cos.cosId IS NULL OR wfms_cos.cosId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypositionIdGetByStaus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypositionIdGetByStaus",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypositionIdGetByStaus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBypositionIdGetByStaus(String status) {
		return findBypositionIdGetByStaus(status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBypositionIdGetByStaus(String status, int start,
		int end) {
		return findBypositionIdGetByStaus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBypositionIdGetByStaus(String status, int start,
		int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return findBypositionIdGetByStaus(status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBypositionIdGetByStaus(String status, int start,
		int end, OrderByComparator<WFMS_COS> orderByComparator,
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

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!Objects.equals(status, wfms_cos.getStatus())) {
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

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
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBypositionIdGetByStaus_First(String status,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBypositionIdGetByStaus_First(status,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBypositionIdGetByStaus_First(String status,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findBypositionIdGetByStaus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBypositionIdGetByStaus_Last(String status,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBypositionIdGetByStaus_Last(status,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBypositionIdGetByStaus_Last(String status,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countBypositionIdGetByStaus(status);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findBypositionIdGetByStaus(status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where status = &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findBypositionIdGetByStaus_PrevAndNext(String cosId,
		String status, OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getBypositionIdGetByStaus_PrevAndNext(session, wfms_cos,
					status, orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getBypositionIdGetByStaus_PrevAndNext(session, wfms_cos,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_COS getBypositionIdGetByStaus_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String status,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBypositionIdGetByStaus(String status) {
		for (WFMS_COS wfms_cos : findBypositionIdGetByStaus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countBypositionIdGetByStaus(String status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

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

	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_1 = "wfms_cos.status IS NULL";
	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_2 = "wfms_cos.status = ?";
	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_3 = "(wfms_cos.status IS NULL OR wfms_cos.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COSIDGETBYPOSID =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycosIdGetByPosId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COSIDGETBYPOSID =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycosIdGetByPosId",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.POSITIONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COSIDGETBYPOSID = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycosIdGetByPosId", new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where positionNumber = &#63;.
	 *
	 * @param positionNumber the position number
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBycosIdGetByPosId(String positionNumber) {
		return findBycosIdGetByPosId(positionNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where positionNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param positionNumber the position number
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBycosIdGetByPosId(String positionNumber,
		int start, int end) {
		return findBycosIdGetByPosId(positionNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where positionNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param positionNumber the position number
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBycosIdGetByPosId(String positionNumber,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return findBycosIdGetByPosId(positionNumber, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where positionNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param positionNumber the position number
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBycosIdGetByPosId(String positionNumber,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COSIDGETBYPOSID;
			finderArgs = new Object[] { positionNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COSIDGETBYPOSID;
			finderArgs = new Object[] {
					positionNumber,
					
					start, end, orderByComparator
				};
		}

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!Objects.equals(positionNumber,
								wfms_cos.getPositionNumber())) {
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindPositionNumber = false;

			if (positionNumber == null) {
				query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_1);
			}
			else if (positionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_3);
			}
			else {
				bindPositionNumber = true;

				query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPositionNumber) {
					qPos.add(positionNumber);
				}

				if (!pagination) {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where positionNumber = &#63;.
	 *
	 * @param positionNumber the position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBycosIdGetByPosId_First(String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBycosIdGetByPosId_First(positionNumber,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("positionNumber=");
		msg.append(positionNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where positionNumber = &#63;.
	 *
	 * @param positionNumber the position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBycosIdGetByPosId_First(String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findBycosIdGetByPosId(positionNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where positionNumber = &#63;.
	 *
	 * @param positionNumber the position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBycosIdGetByPosId_Last(String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBycosIdGetByPosId_Last(positionNumber,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("positionNumber=");
		msg.append(positionNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where positionNumber = &#63;.
	 *
	 * @param positionNumber the position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBycosIdGetByPosId_Last(String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countBycosIdGetByPosId(positionNumber);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findBycosIdGetByPosId(positionNumber, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where positionNumber = &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param positionNumber the position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findBycosIdGetByPosId_PrevAndNext(String cosId,
		String positionNumber, OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getBycosIdGetByPosId_PrevAndNext(session, wfms_cos,
					positionNumber, orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getBycosIdGetByPosId_PrevAndNext(session, wfms_cos,
					positionNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_COS getBycosIdGetByPosId_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

		boolean bindPositionNumber = false;

		if (positionNumber == null) {
			query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_1);
		}
		else if (positionNumber.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_3);
		}
		else {
			bindPositionNumber = true;

			query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_2);
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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPositionNumber) {
			qPos.add(positionNumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where positionNumber = &#63; from the database.
	 *
	 * @param positionNumber the position number
	 */
	@Override
	public void removeBycosIdGetByPosId(String positionNumber) {
		for (WFMS_COS wfms_cos : findBycosIdGetByPosId(positionNumber,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where positionNumber = &#63;.
	 *
	 * @param positionNumber the position number
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countBycosIdGetByPosId(String positionNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COSIDGETBYPOSID;

		Object[] finderArgs = new Object[] { positionNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindPositionNumber = false;

			if (positionNumber == null) {
				query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_1);
			}
			else if (positionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_3);
			}
			else {
				bindPositionNumber = true;

				query.append(_FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPositionNumber) {
					qPos.add(positionNumber);
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

	private static final String _FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_1 = "wfms_cos.positionNumber IS NULL";
	private static final String _FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_2 = "wfms_cos.positionNumber = ?";
	private static final String _FINDER_COLUMN_COSIDGETBYPOSID_POSITIONNUMBER_3 = "(wfms_cos.positionNumber IS NULL OR wfms_cos.positionNumber = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_ASSOCIATEID = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByassociateId",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.ASSOICATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSOCIATEID = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassociateId",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_COS where assoicateId = &#63; or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	 *
	 * @param assoicateId the assoicate ID
	 * @return the matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByassociateId(String assoicateId)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByassociateId(assoicateId);

		if (wfms_cos == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assoicateId=");
			msg.append(assoicateId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_COSException(msg.toString());
		}

		return wfms_cos;
	}

	/**
	 * Returns the WFMS_COS where assoicateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assoicateId the assoicate ID
	 * @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByassociateId(String assoicateId) {
		return fetchByassociateId(assoicateId, true);
	}

	/**
	 * Returns the WFMS_COS where assoicateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assoicateId the assoicate ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByassociateId(String assoicateId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { assoicateId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ASSOCIATEID,
					finderArgs, this);
		}

		if (result instanceof WFMS_COS) {
			WFMS_COS wfms_cos = (WFMS_COS)result;

			if (!Objects.equals(assoicateId, wfms_cos.getAssoicateId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindAssoicateId = false;

			if (assoicateId == null) {
				query.append(_FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_1);
			}
			else if (assoicateId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_3);
			}
			else {
				bindAssoicateId = true;

				query.append(_FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssoicateId) {
					qPos.add(assoicateId);
				}

				List<WFMS_COS> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ASSOCIATEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_COSPersistenceImpl.fetchByassociateId(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_COS wfms_cos = list.get(0);

					result = wfms_cos;

					cacheResult(wfms_cos);

					if ((wfms_cos.getAssoicateId() == null) ||
							!wfms_cos.getAssoicateId().equals(assoicateId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_ASSOCIATEID,
							finderArgs, wfms_cos);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ASSOCIATEID,
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
			return (WFMS_COS)result;
		}
	}

	/**
	 * Removes the WFMS_COS where assoicateId = &#63; from the database.
	 *
	 * @param assoicateId the assoicate ID
	 * @return the WFMS_COS that was removed
	 */
	@Override
	public WFMS_COS removeByassociateId(String assoicateId)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByassociateId(assoicateId);

		return remove(wfms_cos);
	}

	/**
	 * Returns the number of WFMS_COSs where assoicateId = &#63;.
	 *
	 * @param assoicateId the assoicate ID
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countByassociateId(String assoicateId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSOCIATEID;

		Object[] finderArgs = new Object[] { assoicateId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindAssoicateId = false;

			if (assoicateId == null) {
				query.append(_FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_1);
			}
			else if (assoicateId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_3);
			}
			else {
				bindAssoicateId = true;

				query.append(_FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssoicateId) {
					qPos.add(assoicateId);
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

	private static final String _FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_1 = "wfms_cos.assoicateId IS NULL";
	private static final String _FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_2 = "wfms_cos.assoicateId = ?";
	private static final String _FINDER_COLUMN_ASSOCIATEID_ASSOICATEID_3 = "(wfms_cos.assoicateId IS NULL OR wfms_cos.assoicateId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWPOSITIONNUMBER =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynewPositionNumber",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWPOSITIONNUMBER =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBynewPositionNumber", new String[] { String.class.getName() },
			WFMS_COSModelImpl.NEWPOSITIONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NEWPOSITIONNUMBER = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynewPositionNumber", new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where newPositionNumber = &#63;.
	 *
	 * @param newPositionNumber the new position number
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBynewPositionNumber(String newPositionNumber) {
		return findBynewPositionNumber(newPositionNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where newPositionNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param newPositionNumber the new position number
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBynewPositionNumber(String newPositionNumber,
		int start, int end) {
		return findBynewPositionNumber(newPositionNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where newPositionNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param newPositionNumber the new position number
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBynewPositionNumber(String newPositionNumber,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return findBynewPositionNumber(newPositionNumber, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where newPositionNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param newPositionNumber the new position number
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findBynewPositionNumber(String newPositionNumber,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWPOSITIONNUMBER;
			finderArgs = new Object[] { newPositionNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWPOSITIONNUMBER;
			finderArgs = new Object[] {
					newPositionNumber,
					
					start, end, orderByComparator
				};
		}

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!Objects.equals(newPositionNumber,
								wfms_cos.getNewPositionNumber())) {
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindNewPositionNumber = false;

			if (newPositionNumber == null) {
				query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_1);
			}
			else if (newPositionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_3);
			}
			else {
				bindNewPositionNumber = true;

				query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNewPositionNumber) {
					qPos.add(newPositionNumber);
				}

				if (!pagination) {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where newPositionNumber = &#63;.
	 *
	 * @param newPositionNumber the new position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBynewPositionNumber_First(String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBynewPositionNumber_First(newPositionNumber,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("newPositionNumber=");
		msg.append(newPositionNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where newPositionNumber = &#63;.
	 *
	 * @param newPositionNumber the new position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBynewPositionNumber_First(String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findBynewPositionNumber(newPositionNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where newPositionNumber = &#63;.
	 *
	 * @param newPositionNumber the new position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findBynewPositionNumber_Last(String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchBynewPositionNumber_Last(newPositionNumber,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("newPositionNumber=");
		msg.append(newPositionNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where newPositionNumber = &#63;.
	 *
	 * @param newPositionNumber the new position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchBynewPositionNumber_Last(String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countBynewPositionNumber(newPositionNumber);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findBynewPositionNumber(newPositionNumber,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where newPositionNumber = &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param newPositionNumber the new position number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findBynewPositionNumber_PrevAndNext(String cosId,
		String newPositionNumber, OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getBynewPositionNumber_PrevAndNext(session, wfms_cos,
					newPositionNumber, orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getBynewPositionNumber_PrevAndNext(session, wfms_cos,
					newPositionNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_COS getBynewPositionNumber_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

		boolean bindNewPositionNumber = false;

		if (newPositionNumber == null) {
			query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_1);
		}
		else if (newPositionNumber.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_3);
		}
		else {
			bindNewPositionNumber = true;

			query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_2);
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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNewPositionNumber) {
			qPos.add(newPositionNumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where newPositionNumber = &#63; from the database.
	 *
	 * @param newPositionNumber the new position number
	 */
	@Override
	public void removeBynewPositionNumber(String newPositionNumber) {
		for (WFMS_COS wfms_cos : findBynewPositionNumber(newPositionNumber,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where newPositionNumber = &#63;.
	 *
	 * @param newPositionNumber the new position number
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countBynewPositionNumber(String newPositionNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NEWPOSITIONNUMBER;

		Object[] finderArgs = new Object[] { newPositionNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindNewPositionNumber = false;

			if (newPositionNumber == null) {
				query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_1);
			}
			else if (newPositionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_3);
			}
			else {
				bindNewPositionNumber = true;

				query.append(_FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNewPositionNumber) {
					qPos.add(newPositionNumber);
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

	private static final String _FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_1 =
		"wfms_cos.newPositionNumber IS NULL";
	private static final String _FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_2 =
		"wfms_cos.newPositionNumber = ?";
	private static final String _FINDER_COLUMN_NEWPOSITIONNUMBER_NEWPOSITIONNUMBER_3 =
		"(wfms_cos.newPositionNumber IS NULL OR wfms_cos.newPositionNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTAPPROVER =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNextApprover",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NEXTAPPROVER =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNextApprover",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByNextApprover(String nextApprover) {
		return findByNextApprover(nextApprover, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where nextApprover LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextApprover the next approver
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByNextApprover(String nextApprover, int start,
		int end) {
		return findByNextApprover(nextApprover, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where nextApprover LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextApprover the next approver
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByNextApprover(String nextApprover, int start,
		int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return findByNextApprover(nextApprover, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where nextApprover LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextApprover the next approver
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByNextApprover(String nextApprover, int start,
		int end, OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTAPPROVER;
		finderArgs = new Object[] { nextApprover, start, end, orderByComparator };

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!StringUtil.wildcardMatches(
								wfms_cos.getNextApprover(), nextApprover,
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

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
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByNextApprover_First(String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByNextApprover_First(nextApprover,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextApprover=");
		msg.append(nextApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByNextApprover_First(String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findByNextApprover(nextApprover, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByNextApprover_Last(String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByNextApprover_Last(nextApprover,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextApprover=");
		msg.append(nextApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByNextApprover_Last(String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countByNextApprover(nextApprover);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findByNextApprover(nextApprover, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param nextApprover the next approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findByNextApprover_PrevAndNext(String cosId,
		String nextApprover, OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getByNextApprover_PrevAndNext(session, wfms_cos,
					nextApprover, orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getByNextApprover_PrevAndNext(session, wfms_cos,
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

	protected WFMS_COS getByNextApprover_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where nextApprover LIKE &#63; from the database.
	 *
	 * @param nextApprover the next approver
	 */
	@Override
	public void removeByNextApprover(String nextApprover) {
		for (WFMS_COS wfms_cos : findByNextApprover(nextApprover,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where nextApprover LIKE &#63;.
	 *
	 * @param nextApprover the next approver
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countByNextApprover(String nextApprover) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NEXTAPPROVER;

		Object[] finderArgs = new Object[] { nextApprover };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

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

	private static final String _FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_1 = "wfms_cos.nextApprover IS NULL";
	private static final String _FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_2 = "wfms_cos.nextApprover LIKE ?";
	private static final String _FINDER_COLUMN_NEXTAPPROVER_NEXTAPPROVER_3 = "(wfms_cos.nextApprover IS NULL OR wfms_cos.nextApprover LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEOFAPPROVER =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleOfApprover",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER =
		new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, WFMS_COSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleOfApprover",
			new String[] { String.class.getName() },
			WFMS_COSModelImpl.ROLEOFAPPROVER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEOFAPPROVER = new FinderPath(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleOfApprover",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_COSs where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @return the matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByRoleOfApprover(String roleOfApprover) {
		return findByRoleOfApprover(roleOfApprover, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs where roleOfApprover = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleOfApprover the role of approver
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByRoleOfApprover(String roleOfApprover,
		int start, int end) {
		return findByRoleOfApprover(roleOfApprover, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where roleOfApprover = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleOfApprover the role of approver
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByRoleOfApprover(String roleOfApprover,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return findByRoleOfApprover(roleOfApprover, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs where roleOfApprover = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleOfApprover the role of approver
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findByRoleOfApprover(String roleOfApprover,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER;
			finderArgs = new Object[] { roleOfApprover };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEOFAPPROVER;
			finderArgs = new Object[] {
					roleOfApprover,
					
					start, end, orderByComparator
				};
		}

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_COS wfms_cos : list) {
					if (!Objects.equals(roleOfApprover,
								wfms_cos.getRoleOfApprover())) {
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

			query.append(_SQL_SELECT_WFMS_COS_WHERE);

			boolean bindRoleOfApprover = false;

			if (roleOfApprover == null) {
				query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_1);
			}
			else if (roleOfApprover.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_3);
			}
			else {
				bindRoleOfApprover = true;

				query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRoleOfApprover) {
					qPos.add(roleOfApprover);
				}

				if (!pagination) {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WFMS_COS in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByRoleOfApprover_First(String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByRoleOfApprover_First(roleOfApprover,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleOfApprover=");
		msg.append(roleOfApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the first WFMS_COS in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByRoleOfApprover_First(String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		List<WFMS_COS> list = findByRoleOfApprover(roleOfApprover, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS
	 * @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS findByRoleOfApprover_Last(String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByRoleOfApprover_Last(roleOfApprover,
				orderByComparator);

		if (wfms_cos != null) {
			return wfms_cos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleOfApprover=");
		msg.append(roleOfApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_COSException(msg.toString());
	}

	/**
	 * Returns the last WFMS_COS in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	 */
	@Override
	public WFMS_COS fetchByRoleOfApprover_Last(String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		int count = countByRoleOfApprover(roleOfApprover);

		if (count == 0) {
			return null;
		}

		List<WFMS_COS> list = findByRoleOfApprover(roleOfApprover, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param cosId the primary key of the current WFMS_COS
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS[] findByRoleOfApprover_PrevAndNext(String cosId,
		String roleOfApprover, OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = findByPrimaryKey(cosId);

		Session session = null;

		try {
			session = openSession();

			WFMS_COS[] array = new WFMS_COSImpl[3];

			array[0] = getByRoleOfApprover_PrevAndNext(session, wfms_cos,
					roleOfApprover, orderByComparator, true);

			array[1] = wfms_cos;

			array[2] = getByRoleOfApprover_PrevAndNext(session, wfms_cos,
					roleOfApprover, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_COS getByRoleOfApprover_PrevAndNext(Session session,
		WFMS_COS wfms_cos, String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_COS_WHERE);

		boolean bindRoleOfApprover = false;

		if (roleOfApprover == null) {
			query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_1);
		}
		else if (roleOfApprover.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_3);
		}
		else {
			bindRoleOfApprover = true;

			query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_2);
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
			query.append(WFMS_COSModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRoleOfApprover) {
			qPos.add(roleOfApprover);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_cos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_COS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_COSs where roleOfApprover = &#63; from the database.
	 *
	 * @param roleOfApprover the role of approver
	 */
	@Override
	public void removeByRoleOfApprover(String roleOfApprover) {
		for (WFMS_COS wfms_cos : findByRoleOfApprover(roleOfApprover,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @return the number of matching WFMS_COSs
	 */
	@Override
	public int countByRoleOfApprover(String roleOfApprover) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEOFAPPROVER;

		Object[] finderArgs = new Object[] { roleOfApprover };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_COS_WHERE);

			boolean bindRoleOfApprover = false;

			if (roleOfApprover == null) {
				query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_1);
			}
			else if (roleOfApprover.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_3);
			}
			else {
				bindRoleOfApprover = true;

				query.append(_FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRoleOfApprover) {
					qPos.add(roleOfApprover);
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

	private static final String _FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_1 = "wfms_cos.roleOfApprover IS NULL";
	private static final String _FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_2 = "wfms_cos.roleOfApprover = ?";
	private static final String _FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_3 = "(wfms_cos.roleOfApprover IS NULL OR wfms_cos.roleOfApprover = '')";

	public WFMS_COSPersistenceImpl() {
		setModelClass(WFMS_COS.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

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
	 * Caches the WFMS_COS in the entity cache if it is enabled.
	 *
	 * @param wfms_cos the WFMS_COS
	 */
	@Override
	public void cacheResult(WFMS_COS wfms_cos) {
		entityCache.putResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSImpl.class, wfms_cos.getPrimaryKey(), wfms_cos);

		finderCache.putResult(FINDER_PATH_FETCH_BY_COS,
			new Object[] { wfms_cos.getCosId() }, wfms_cos);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ASSOCIATEID,
			new Object[] { wfms_cos.getAssoicateId() }, wfms_cos);

		wfms_cos.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_COSs in the entity cache if it is enabled.
	 *
	 * @param wfms_coses the WFMS_COSs
	 */
	@Override
	public void cacheResult(List<WFMS_COS> wfms_coses) {
		for (WFMS_COS wfms_cos : wfms_coses) {
			if (entityCache.getResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_COSImpl.class, wfms_cos.getPrimaryKey()) == null) {
				cacheResult(wfms_cos);
			}
			else {
				wfms_cos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_COSs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_COSImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_COS.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_COS wfms_cos) {
		entityCache.removeResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSImpl.class, wfms_cos.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_COSModelImpl)wfms_cos, true);
	}

	@Override
	public void clearCache(List<WFMS_COS> wfms_coses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_COS wfms_cos : wfms_coses) {
			entityCache.removeResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_COSImpl.class, wfms_cos.getPrimaryKey());

			clearUniqueFindersCache((WFMS_COSModelImpl)wfms_cos, true);
		}
	}

	protected void cacheUniqueFindersCache(WFMS_COSModelImpl wfms_cosModelImpl) {
		Object[] args = new Object[] { wfms_cosModelImpl.getCosId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_COS, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_COS, args,
			wfms_cosModelImpl, false);

		args = new Object[] { wfms_cosModelImpl.getAssoicateId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_ASSOCIATEID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ASSOCIATEID, args,
			wfms_cosModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_COSModelImpl wfms_cosModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { wfms_cosModelImpl.getCosId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COS, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_COS, args);
		}

		if ((wfms_cosModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COS.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { wfms_cosModelImpl.getOriginalCosId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COS, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_COS, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { wfms_cosModelImpl.getAssoicateId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ASSOCIATEID, args);
		}

		if ((wfms_cosModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ASSOCIATEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_cosModelImpl.getOriginalAssoicateId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ASSOCIATEID, args);
		}
	}

	/**
	 * Creates a new WFMS_COS with the primary key. Does not add the WFMS_COS to the database.
	 *
	 * @param cosId the primary key for the new WFMS_COS
	 * @return the new WFMS_COS
	 */
	@Override
	public WFMS_COS create(String cosId) {
		WFMS_COS wfms_cos = new WFMS_COSImpl();

		wfms_cos.setNew(true);
		wfms_cos.setPrimaryKey(cosId);

		wfms_cos.setCompanyId(companyProvider.getCompanyId());

		return wfms_cos;
	}

	/**
	 * Removes the WFMS_COS with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cosId the primary key of the WFMS_COS
	 * @return the WFMS_COS that was removed
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS remove(String cosId) throws NoSuchWFMS_COSException {
		return remove((Serializable)cosId);
	}

	/**
	 * Removes the WFMS_COS with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_COS
	 * @return the WFMS_COS that was removed
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS remove(Serializable primaryKey)
		throws NoSuchWFMS_COSException {
		Session session = null;

		try {
			session = openSession();

			WFMS_COS wfms_cos = (WFMS_COS)session.get(WFMS_COSImpl.class,
					primaryKey);

			if (wfms_cos == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_COSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_cos);
		}
		catch (NoSuchWFMS_COSException nsee) {
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
	protected WFMS_COS removeImpl(WFMS_COS wfms_cos) {
		wfms_cos = toUnwrappedModel(wfms_cos);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_cos)) {
				wfms_cos = (WFMS_COS)session.get(WFMS_COSImpl.class,
						wfms_cos.getPrimaryKeyObj());
			}

			if (wfms_cos != null) {
				session.delete(wfms_cos);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_cos != null) {
			clearCache(wfms_cos);
		}

		return wfms_cos;
	}

	@Override
	public WFMS_COS updateImpl(WFMS_COS wfms_cos) {
		wfms_cos = toUnwrappedModel(wfms_cos);

		boolean isNew = wfms_cos.isNew();

		WFMS_COSModelImpl wfms_cosModelImpl = (WFMS_COSModelImpl)wfms_cos;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_cos.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_cos.setCreateDate(now);
			}
			else {
				wfms_cos.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wfms_cosModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_cos.setModifiedDate(now);
			}
			else {
				wfms_cos.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_cos.isNew()) {
				session.save(wfms_cos);

				wfms_cos.setNew(false);
			}
			else {
				wfms_cos = (WFMS_COS)session.merge(wfms_cos);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_COSModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { wfms_cosModelImpl.getAssoicateId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOICATEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOICATEID,
				args);

			args = new Object[] { wfms_cosModelImpl.getAction() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION,
				args);

			args = new Object[] { wfms_cosModelImpl.getStatus() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
				args);

			args = new Object[] { wfms_cosModelImpl.getPositionNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COSIDGETBYPOSID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COSIDGETBYPOSID,
				args);

			args = new Object[] { wfms_cosModelImpl.getNewPositionNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NEWPOSITIONNUMBER,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWPOSITIONNUMBER,
				args);

			args = new Object[] { wfms_cosModelImpl.getRoleOfApprover() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEOFAPPROVER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wfms_cosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOICATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_cosModelImpl.getOriginalAssoicateId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOICATEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOICATEID,
					args);

				args = new Object[] { wfms_cosModelImpl.getAssoicateId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSOICATEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOICATEID,
					args);
			}

			if ((wfms_cosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_cosModelImpl.getOriginalAction()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION,
					args);

				args = new Object[] { wfms_cosModelImpl.getAction() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION,
					args);
			}

			if ((wfms_cosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_cosModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
					args);

				args = new Object[] { wfms_cosModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
					args);
			}

			if ((wfms_cosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COSIDGETBYPOSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_cosModelImpl.getOriginalPositionNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COSIDGETBYPOSID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COSIDGETBYPOSID,
					args);

				args = new Object[] { wfms_cosModelImpl.getPositionNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COSIDGETBYPOSID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COSIDGETBYPOSID,
					args);
			}

			if ((wfms_cosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWPOSITIONNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_cosModelImpl.getOriginalNewPositionNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NEWPOSITIONNUMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWPOSITIONNUMBER,
					args);

				args = new Object[] { wfms_cosModelImpl.getNewPositionNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NEWPOSITIONNUMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWPOSITIONNUMBER,
					args);
			}

			if ((wfms_cosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_cosModelImpl.getOriginalRoleOfApprover()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEOFAPPROVER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER,
					args);

				args = new Object[] { wfms_cosModelImpl.getRoleOfApprover() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEOFAPPROVER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER,
					args);
			}
		}

		entityCache.putResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_COSImpl.class, wfms_cos.getPrimaryKey(), wfms_cos, false);

		clearUniqueFindersCache(wfms_cosModelImpl, false);
		cacheUniqueFindersCache(wfms_cosModelImpl);

		wfms_cos.resetOriginalValues();

		return wfms_cos;
	}

	protected WFMS_COS toUnwrappedModel(WFMS_COS wfms_cos) {
		if (wfms_cos instanceof WFMS_COSImpl) {
			return wfms_cos;
		}

		WFMS_COSImpl wfms_cosImpl = new WFMS_COSImpl();

		wfms_cosImpl.setNew(wfms_cos.isNew());
		wfms_cosImpl.setPrimaryKey(wfms_cos.getPrimaryKey());

		wfms_cosImpl.setCosId(wfms_cos.getCosId());
		wfms_cosImpl.setAssoicateId(wfms_cos.getAssoicateId());
		wfms_cosImpl.setNewPositionNumber(wfms_cos.getNewPositionNumber());
		wfms_cosImpl.setAction(wfms_cos.getAction());
		wfms_cosImpl.setReasonCODE(wfms_cos.getReasonCODE());
		wfms_cosImpl.setDescription(wfms_cos.getDescription());
		wfms_cosImpl.setChangeDescription(wfms_cos.getChangeDescription());
		wfms_cosImpl.setNewJobCode(wfms_cos.getNewJobCode());
		wfms_cosImpl.setSameJobCode(wfms_cos.getSameJobCode());
		wfms_cosImpl.setSameLeadership(wfms_cos.getSameLeadership());
		wfms_cosImpl.setSameDept(wfms_cos.getSameDept());
		wfms_cosImpl.setSameMgr(wfms_cos.getSameMgr());
		wfms_cosImpl.setRoutingProcess(wfms_cos.getRoutingProcess());
		wfms_cosImpl.setNotificationTo(wfms_cos.getNotificationTo());
		wfms_cosImpl.setStatus(wfms_cos.getStatus());
		wfms_cosImpl.setType(wfms_cos.getType());
		wfms_cosImpl.setEffectiveDate(wfms_cos.getEffectiveDate());
		wfms_cosImpl.setTeamNumber(wfms_cos.getTeamNumber());
		wfms_cosImpl.setShiftCode(wfms_cos.getShiftCode());
		wfms_cosImpl.setMgrAssociateNumber(wfms_cos.getMgrAssociateNumber());
		wfms_cosImpl.setManpowerCategiry(wfms_cos.getManpowerCategiry());
		wfms_cosImpl.setComments(wfms_cos.getComments());
		wfms_cosImpl.setLeadershipAssignment(wfms_cos.getLeadershipAssignment());
		wfms_cosImpl.setAssociateDateOfHire(wfms_cos.getAssociateDateOfHire());
		wfms_cosImpl.setNewDivision(wfms_cos.getNewDivision());
		wfms_cosImpl.setNewDivisionManager(wfms_cos.getNewDivisionManager());
		wfms_cosImpl.setNewDepartmentName(wfms_cos.getNewDepartmentName());
		wfms_cosImpl.setNewDepartmentNumber(wfms_cos.getNewDepartmentNumber());
		wfms_cosImpl.setNewDepartmentManager(wfms_cos.getNewDepartmentManager());
		wfms_cosImpl.setNewManagerName(wfms_cos.getNewManagerName());
		wfms_cosImpl.setNewManagerTitle(wfms_cos.getNewManagerTitle());
		wfms_cosImpl.setDeleteflagStatus(wfms_cos.getDeleteflagStatus());
		wfms_cosImpl.setRequistionId(wfms_cos.getRequistionId());
		wfms_cosImpl.setCompanyId(wfms_cos.getCompanyId());
		wfms_cosImpl.setScopeGroupId(wfms_cos.getScopeGroupId());
		wfms_cosImpl.setCreatedBy(wfms_cos.getCreatedBy());
		wfms_cosImpl.setCreateDate(wfms_cos.getCreateDate());
		wfms_cosImpl.setModifiedBy(wfms_cos.getModifiedBy());
		wfms_cosImpl.setModifiedDate(wfms_cos.getModifiedDate());
		wfms_cosImpl.setAssociatename(wfms_cos.getAssociatename());
		wfms_cosImpl.setRelatesTo(wfms_cos.getRelatesTo());
		wfms_cosImpl.setNextApprover(wfms_cos.getNextApprover());
		wfms_cosImpl.setRoleOfApprover(wfms_cos.getRoleOfApprover());
		wfms_cosImpl.setApproverList(wfms_cos.getApproverList());
		wfms_cosImpl.setApproverStep(wfms_cos.getApproverStep());
		wfms_cosImpl.setWorkflow(wfms_cos.getWorkflow());
		wfms_cosImpl.setWorkflowStep(wfms_cos.getWorkflowStep());
		wfms_cosImpl.setWorkflowId(wfms_cos.getWorkflowId());
		wfms_cosImpl.setDummy(wfms_cos.getDummy());
		wfms_cosImpl.setRefCosId(wfms_cos.getRefCosId());
		wfms_cosImpl.setSystemGenerated(wfms_cos.getSystemGenerated());
		wfms_cosImpl.setPositionNumber(wfms_cos.getPositionNumber());
		wfms_cosImpl.setCurrentJobCode(wfms_cos.getCurrentJobCode());
		wfms_cosImpl.setCurrentDivision(wfms_cos.getCurrentDivision());
		wfms_cosImpl.setCurrentDivisionManager(wfms_cos.getCurrentDivisionManager());
		wfms_cosImpl.setCurrentDepartmentName(wfms_cos.getCurrentDepartmentName());
		wfms_cosImpl.setCurrentDepartmentNumber(wfms_cos.getCurrentDepartmentNumber());
		wfms_cosImpl.setCurrentDepartmentManager(wfms_cos.getCurrentDepartmentManager());
		wfms_cosImpl.setCurrentManagerName(wfms_cos.getCurrentManagerName());
		wfms_cosImpl.setCurrentManagerTitle(wfms_cos.getCurrentManagerTitle());
		wfms_cosImpl.setCurrentTeamNumber(wfms_cos.getCurrentTeamNumber());
		wfms_cosImpl.setCurrentShiftCode(wfms_cos.getCurrentShiftCode());
		wfms_cosImpl.setCurrentLeadershipAssignment(wfms_cos.getCurrentLeadershipAssignment());
		wfms_cosImpl.setCurrentManpowerRep(wfms_cos.getCurrentManpowerRep());
		wfms_cosImpl.setCurrentManagerAssocNumber(wfms_cos.getCurrentManagerAssocNumber());
		wfms_cosImpl.setSortApprovedList(wfms_cos.getSortApprovedList());
		wfms_cosImpl.setDuplicateApprovedList(wfms_cos.getDuplicateApprovedList());
		wfms_cosImpl.setDuplicateApprovedListStartIndex(wfms_cos.getDuplicateApprovedListStartIndex());
		wfms_cosImpl.setDuplicateApprovedListEndIndex(wfms_cos.getDuplicateApprovedListEndIndex());
		wfms_cosImpl.setAnnounced(wfms_cos.getAnnounced());
		wfms_cosImpl.setCurrentPositionText(wfms_cos.getCurrentPositionText());
		wfms_cosImpl.setDuplicateCounter(wfms_cos.getDuplicateCounter());

		return wfms_cosImpl;
	}

	/**
	 * Returns the WFMS_COS with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_COS
	 * @return the WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_COSException {
		WFMS_COS wfms_cos = fetchByPrimaryKey(primaryKey);

		if (wfms_cos == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_COSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_cos;
	}

	/**
	 * Returns the WFMS_COS with the primary key or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	 *
	 * @param cosId the primary key of the WFMS_COS
	 * @return the WFMS_COS
	 * @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS findByPrimaryKey(String cosId)
		throws NoSuchWFMS_COSException {
		return findByPrimaryKey((Serializable)cosId);
	}

	/**
	 * Returns the WFMS_COS with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_COS
	 * @return the WFMS_COS, or <code>null</code> if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_COSImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_COS wfms_cos = (WFMS_COS)serializable;

		if (wfms_cos == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_cos = (WFMS_COS)session.get(WFMS_COSImpl.class, primaryKey);

				if (wfms_cos != null) {
					cacheResult(wfms_cos);
				}
				else {
					entityCache.putResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_COSImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_COSImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_cos;
	}

	/**
	 * Returns the WFMS_COS with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cosId the primary key of the WFMS_COS
	 * @return the WFMS_COS, or <code>null</code> if a WFMS_COS with the primary key could not be found
	 */
	@Override
	public WFMS_COS fetchByPrimaryKey(String cosId) {
		return fetchByPrimaryKey((Serializable)cosId);
	}

	@Override
	public Map<Serializable, WFMS_COS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_COS> map = new HashMap<Serializable, WFMS_COS>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_COS wfms_cos = fetchByPrimaryKey(primaryKey);

			if (wfms_cos != null) {
				map.put(primaryKey, wfms_cos);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_COSImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_COS)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_COS_WHERE_PKS_IN);

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

			for (WFMS_COS wfms_cos : (List<WFMS_COS>)q.list()) {
				map.put(wfms_cos.getPrimaryKeyObj(), wfms_cos);

				cacheResult(wfms_cos);

				uncachedPrimaryKeys.remove(wfms_cos.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_COSModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_COSImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_COSs.
	 *
	 * @return the WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_COSs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @return the range of WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findAll(int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_COSs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_COSs
	 * @param end the upper bound of the range of WFMS_COSs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_COSs
	 */
	@Override
	public List<WFMS_COS> findAll(int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
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

		List<WFMS_COS> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_COS>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_COS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_COS;

				if (pagination) {
					sql = sql.concat(WFMS_COSModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_COS>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the WFMS_COSs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_COS wfms_cos : findAll()) {
			remove(wfms_cos);
		}
	}

	/**
	 * Returns the number of WFMS_COSs.
	 *
	 * @return the number of WFMS_COSs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_COS);

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
		return WFMS_COSModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_COS persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_COSImpl.class.getName());
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
	private static final String _SQL_SELECT_WFMS_COS = "SELECT wfms_cos FROM WFMS_COS wfms_cos";
	private static final String _SQL_SELECT_WFMS_COS_WHERE_PKS_IN = "SELECT wfms_cos FROM WFMS_COS wfms_cos WHERE cosId IN (";
	private static final String _SQL_SELECT_WFMS_COS_WHERE = "SELECT wfms_cos FROM WFMS_COS wfms_cos WHERE ";
	private static final String _SQL_COUNT_WFMS_COS = "SELECT COUNT(wfms_cos) FROM WFMS_COS wfms_cos";
	private static final String _SQL_COUNT_WFMS_COS_WHERE = "SELECT COUNT(wfms_cos) FROM WFMS_COS wfms_cos WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_cos.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_COS exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_COS exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_COSPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}