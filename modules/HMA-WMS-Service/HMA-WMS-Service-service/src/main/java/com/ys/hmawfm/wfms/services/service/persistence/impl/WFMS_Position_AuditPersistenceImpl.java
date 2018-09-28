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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Position_AuditException;
import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Position_AuditImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Position_AuditModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_Position_AuditPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the WFMS_Position_Audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position_AuditPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_Position_AuditUtil
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditPersistenceImpl extends BasePersistenceImpl<WFMS_Position_Audit>
	implements WFMS_Position_AuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_Position_AuditUtil} to access the WFMS_Position_Audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_Position_AuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSIDFORAUDIT =
		new FinderPath(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPosIdForAudit",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSIDFORAUDIT =
		new FinderPath(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPosIdForAudit",
			new String[] { String.class.getName() },
			WFMS_Position_AuditModelImpl.PID_COLUMN_BITMASK |
			WFMS_Position_AuditModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSIDFORAUDIT = new FinderPath(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPosIdForAudit",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Position_Audits where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @return the matching WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findByPosIdForAudit(String pId) {
		return findByPosIdForAudit(pId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_Position_Audits where pId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pId the p ID
	 * @param start the lower bound of the range of WFMS_Position_Audits
	 * @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	 * @return the range of matching WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findByPosIdForAudit(String pId, int start,
		int end) {
		return findByPosIdForAudit(pId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Position_Audits where pId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pId the p ID
	 * @param start the lower bound of the range of WFMS_Position_Audits
	 * @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findByPosIdForAudit(String pId, int start,
		int end, OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return findByPosIdForAudit(pId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Position_Audits where pId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pId the p ID
	 * @param start the lower bound of the range of WFMS_Position_Audits
	 * @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findByPosIdForAudit(String pId, int start,
		int end, OrderByComparator<WFMS_Position_Audit> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSIDFORAUDIT;
			finderArgs = new Object[] { pId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSIDFORAUDIT;
			finderArgs = new Object[] { pId, start, end, orderByComparator };
		}

		List<WFMS_Position_Audit> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position_Audit>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Position_Audit wfms_Position_Audit : list) {
					if (!Objects.equals(pId, wfms_Position_Audit.getPId())) {
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

			query.append(_SQL_SELECT_WFMS_POSITION_AUDIT_WHERE);

			boolean bindPId = false;

			if (pId == null) {
				query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_1);
			}
			else if (pId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_3);
			}
			else {
				bindPId = true;

				query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_Position_AuditModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<WFMS_Position_Audit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position_Audit>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Position_Audit in the ordered set where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position_Audit
	 * @throws NoSuchWFMS_Position_AuditException if a matching WFMS_Position_Audit could not be found
	 */
	@Override
	public WFMS_Position_Audit findByPosIdForAudit_First(String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator)
		throws NoSuchWFMS_Position_AuditException {
		WFMS_Position_Audit wfms_Position_Audit = fetchByPosIdForAudit_First(pId,
				orderByComparator);

		if (wfms_Position_Audit != null) {
			return wfms_Position_Audit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pId=");
		msg.append(pId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_Position_AuditException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Position_Audit in the ordered set where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Position_Audit, or <code>null</code> if a matching WFMS_Position_Audit could not be found
	 */
	@Override
	public WFMS_Position_Audit fetchByPosIdForAudit_First(String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		List<WFMS_Position_Audit> list = findByPosIdForAudit(pId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Position_Audit in the ordered set where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position_Audit
	 * @throws NoSuchWFMS_Position_AuditException if a matching WFMS_Position_Audit could not be found
	 */
	@Override
	public WFMS_Position_Audit findByPosIdForAudit_Last(String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator)
		throws NoSuchWFMS_Position_AuditException {
		WFMS_Position_Audit wfms_Position_Audit = fetchByPosIdForAudit_Last(pId,
				orderByComparator);

		if (wfms_Position_Audit != null) {
			return wfms_Position_Audit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pId=");
		msg.append(pId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_Position_AuditException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Position_Audit in the ordered set where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Position_Audit, or <code>null</code> if a matching WFMS_Position_Audit could not be found
	 */
	@Override
	public WFMS_Position_Audit fetchByPosIdForAudit_Last(String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		int count = countByPosIdForAudit(pId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Position_Audit> list = findByPosIdForAudit(pId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Position_Audits before and after the current WFMS_Position_Audit in the ordered set where pId = &#63;.
	 *
	 * @param paId the primary key of the current WFMS_Position_Audit
	 * @param pId the p ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Position_Audit
	 * @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit[] findByPosIdForAudit_PrevAndNext(String paId,
		String pId, OrderByComparator<WFMS_Position_Audit> orderByComparator)
		throws NoSuchWFMS_Position_AuditException {
		WFMS_Position_Audit wfms_Position_Audit = findByPrimaryKey(paId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Position_Audit[] array = new WFMS_Position_AuditImpl[3];

			array[0] = getByPosIdForAudit_PrevAndNext(session,
					wfms_Position_Audit, pId, orderByComparator, true);

			array[1] = wfms_Position_Audit;

			array[2] = getByPosIdForAudit_PrevAndNext(session,
					wfms_Position_Audit, pId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Position_Audit getByPosIdForAudit_PrevAndNext(
		Session session, WFMS_Position_Audit wfms_Position_Audit, String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator,
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

		query.append(_SQL_SELECT_WFMS_POSITION_AUDIT_WHERE);

		boolean bindPId = false;

		if (pId == null) {
			query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_1);
		}
		else if (pId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_3);
		}
		else {
			bindPId = true;

			query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_2);
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
			query.append(WFMS_Position_AuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPId) {
			qPos.add(pId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Position_Audit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Position_Audit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Position_Audits where pId = &#63; from the database.
	 *
	 * @param pId the p ID
	 */
	@Override
	public void removeByPosIdForAudit(String pId) {
		for (WFMS_Position_Audit wfms_Position_Audit : findByPosIdForAudit(
				pId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Position_Audit);
		}
	}

	/**
	 * Returns the number of WFMS_Position_Audits where pId = &#63;.
	 *
	 * @param pId the p ID
	 * @return the number of matching WFMS_Position_Audits
	 */
	@Override
	public int countByPosIdForAudit(String pId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSIDFORAUDIT;

		Object[] finderArgs = new Object[] { pId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_POSITION_AUDIT_WHERE);

			boolean bindPId = false;

			if (pId == null) {
				query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_1);
			}
			else if (pId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_3);
			}
			else {
				bindPId = true;

				query.append(_FINDER_COLUMN_POSIDFORAUDIT_PID_2);
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

	private static final String _FINDER_COLUMN_POSIDFORAUDIT_PID_1 = "wfms_Position_Audit.pId IS NULL";
	private static final String _FINDER_COLUMN_POSIDFORAUDIT_PID_2 = "wfms_Position_Audit.pId = ?";
	private static final String _FINDER_COLUMN_POSIDFORAUDIT_PID_3 = "(wfms_Position_Audit.pId IS NULL OR wfms_Position_Audit.pId = '')";

	public WFMS_Position_AuditPersistenceImpl() {
		setModelClass(WFMS_Position_Audit.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("change", "change_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the WFMS_Position_Audit in the entity cache if it is enabled.
	 *
	 * @param wfms_Position_Audit the WFMS_Position_Audit
	 */
	@Override
	public void cacheResult(WFMS_Position_Audit wfms_Position_Audit) {
		entityCache.putResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class, wfms_Position_Audit.getPrimaryKey(),
			wfms_Position_Audit);

		wfms_Position_Audit.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_Position_Audits in the entity cache if it is enabled.
	 *
	 * @param wfms_Position_Audits the WFMS_Position_Audits
	 */
	@Override
	public void cacheResult(List<WFMS_Position_Audit> wfms_Position_Audits) {
		for (WFMS_Position_Audit wfms_Position_Audit : wfms_Position_Audits) {
			if (entityCache.getResult(
						WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_Position_AuditImpl.class,
						wfms_Position_Audit.getPrimaryKey()) == null) {
				cacheResult(wfms_Position_Audit);
			}
			else {
				wfms_Position_Audit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_Position_Audits.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_Position_AuditImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_Position_Audit.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_Position_Audit wfms_Position_Audit) {
		entityCache.removeResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class, wfms_Position_Audit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WFMS_Position_Audit> wfms_Position_Audits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_Position_Audit wfms_Position_Audit : wfms_Position_Audits) {
			entityCache.removeResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_Position_AuditImpl.class,
				wfms_Position_Audit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_Position_Audit with the primary key. Does not add the WFMS_Position_Audit to the database.
	 *
	 * @param paId the primary key for the new WFMS_Position_Audit
	 * @return the new WFMS_Position_Audit
	 */
	@Override
	public WFMS_Position_Audit create(String paId) {
		WFMS_Position_Audit wfms_Position_Audit = new WFMS_Position_AuditImpl();

		wfms_Position_Audit.setNew(true);
		wfms_Position_Audit.setPrimaryKey(paId);

		return wfms_Position_Audit;
	}

	/**
	 * Removes the WFMS_Position_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paId the primary key of the WFMS_Position_Audit
	 * @return the WFMS_Position_Audit that was removed
	 * @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit remove(String paId)
		throws NoSuchWFMS_Position_AuditException {
		return remove((Serializable)paId);
	}

	/**
	 * Removes the WFMS_Position_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_Position_Audit
	 * @return the WFMS_Position_Audit that was removed
	 * @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit remove(Serializable primaryKey)
		throws NoSuchWFMS_Position_AuditException {
		Session session = null;

		try {
			session = openSession();

			WFMS_Position_Audit wfms_Position_Audit = (WFMS_Position_Audit)session.get(WFMS_Position_AuditImpl.class,
					primaryKey);

			if (wfms_Position_Audit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_Position_AuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_Position_Audit);
		}
		catch (NoSuchWFMS_Position_AuditException nsee) {
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
	protected WFMS_Position_Audit removeImpl(
		WFMS_Position_Audit wfms_Position_Audit) {
		wfms_Position_Audit = toUnwrappedModel(wfms_Position_Audit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_Position_Audit)) {
				wfms_Position_Audit = (WFMS_Position_Audit)session.get(WFMS_Position_AuditImpl.class,
						wfms_Position_Audit.getPrimaryKeyObj());
			}

			if (wfms_Position_Audit != null) {
				session.delete(wfms_Position_Audit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_Position_Audit != null) {
			clearCache(wfms_Position_Audit);
		}

		return wfms_Position_Audit;
	}

	@Override
	public WFMS_Position_Audit updateImpl(
		WFMS_Position_Audit wfms_Position_Audit) {
		wfms_Position_Audit = toUnwrappedModel(wfms_Position_Audit);

		boolean isNew = wfms_Position_Audit.isNew();

		WFMS_Position_AuditModelImpl wfms_Position_AuditModelImpl = (WFMS_Position_AuditModelImpl)wfms_Position_Audit;

		Session session = null;

		try {
			session = openSession();

			if (wfms_Position_Audit.isNew()) {
				session.save(wfms_Position_Audit);

				wfms_Position_Audit.setNew(false);
			}
			else {
				wfms_Position_Audit = (WFMS_Position_Audit)session.merge(wfms_Position_Audit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_Position_AuditModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { wfms_Position_AuditModelImpl.getPId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSIDFORAUDIT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSIDFORAUDIT,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wfms_Position_AuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSIDFORAUDIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_Position_AuditModelImpl.getOriginalPId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSIDFORAUDIT,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSIDFORAUDIT,
					args);

				args = new Object[] { wfms_Position_AuditModelImpl.getPId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSIDFORAUDIT,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSIDFORAUDIT,
					args);
			}
		}

		entityCache.putResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Position_AuditImpl.class, wfms_Position_Audit.getPrimaryKey(),
			wfms_Position_Audit, false);

		wfms_Position_Audit.resetOriginalValues();

		return wfms_Position_Audit;
	}

	protected WFMS_Position_Audit toUnwrappedModel(
		WFMS_Position_Audit wfms_Position_Audit) {
		if (wfms_Position_Audit instanceof WFMS_Position_AuditImpl) {
			return wfms_Position_Audit;
		}

		WFMS_Position_AuditImpl wfms_Position_AuditImpl = new WFMS_Position_AuditImpl();

		wfms_Position_AuditImpl.setNew(wfms_Position_Audit.isNew());
		wfms_Position_AuditImpl.setPrimaryKey(wfms_Position_Audit.getPrimaryKey());

		wfms_Position_AuditImpl.setPaId(wfms_Position_Audit.getPaId());
		wfms_Position_AuditImpl.setPId(wfms_Position_Audit.getPId());
		wfms_Position_AuditImpl.setUserId(wfms_Position_Audit.getUserId());
		wfms_Position_AuditImpl.setAssociateId(wfms_Position_Audit.getAssociateId());
		wfms_Position_AuditImpl.setChange(wfms_Position_Audit.getChange());
		wfms_Position_AuditImpl.setFromPId(wfms_Position_Audit.getFromPId());
		wfms_Position_AuditImpl.setComments(wfms_Position_Audit.getComments());
		wfms_Position_AuditImpl.setCreatedBy(wfms_Position_Audit.getCreatedBy());
		wfms_Position_AuditImpl.setCreateDate(wfms_Position_Audit.getCreateDate());

		return wfms_Position_AuditImpl;
	}

	/**
	 * Returns the WFMS_Position_Audit with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Position_Audit
	 * @return the WFMS_Position_Audit
	 * @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_Position_AuditException {
		WFMS_Position_Audit wfms_Position_Audit = fetchByPrimaryKey(primaryKey);

		if (wfms_Position_Audit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_Position_AuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_Position_Audit;
	}

	/**
	 * Returns the WFMS_Position_Audit with the primary key or throws a {@link NoSuchWFMS_Position_AuditException} if it could not be found.
	 *
	 * @param paId the primary key of the WFMS_Position_Audit
	 * @return the WFMS_Position_Audit
	 * @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit findByPrimaryKey(String paId)
		throws NoSuchWFMS_Position_AuditException {
		return findByPrimaryKey((Serializable)paId);
	}

	/**
	 * Returns the WFMS_Position_Audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Position_Audit
	 * @return the WFMS_Position_Audit, or <code>null</code> if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_Position_AuditImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_Position_Audit wfms_Position_Audit = (WFMS_Position_Audit)serializable;

		if (wfms_Position_Audit == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_Position_Audit = (WFMS_Position_Audit)session.get(WFMS_Position_AuditImpl.class,
						primaryKey);

				if (wfms_Position_Audit != null) {
					cacheResult(wfms_Position_Audit);
				}
				else {
					entityCache.putResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_Position_AuditImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Position_AuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_Position_Audit;
	}

	/**
	 * Returns the WFMS_Position_Audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paId the primary key of the WFMS_Position_Audit
	 * @return the WFMS_Position_Audit, or <code>null</code> if a WFMS_Position_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Position_Audit fetchByPrimaryKey(String paId) {
		return fetchByPrimaryKey((Serializable)paId);
	}

	@Override
	public Map<Serializable, WFMS_Position_Audit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_Position_Audit> map = new HashMap<Serializable, WFMS_Position_Audit>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_Position_Audit wfms_Position_Audit = fetchByPrimaryKey(primaryKey);

			if (wfms_Position_Audit != null) {
				map.put(primaryKey, wfms_Position_Audit);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Position_AuditImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_Position_Audit)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_POSITION_AUDIT_WHERE_PKS_IN);

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

			for (WFMS_Position_Audit wfms_Position_Audit : (List<WFMS_Position_Audit>)q.list()) {
				map.put(wfms_Position_Audit.getPrimaryKeyObj(),
					wfms_Position_Audit);

				cacheResult(wfms_Position_Audit);

				uncachedPrimaryKeys.remove(wfms_Position_Audit.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_Position_AuditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Position_AuditImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_Position_Audits.
	 *
	 * @return the WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Position_Audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Position_Audits
	 * @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	 * @return the range of WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Position_Audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Position_Audits
	 * @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Position_Audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Position_Audits
	 * @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_Position_Audits
	 */
	@Override
	public List<WFMS_Position_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator,
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

		List<WFMS_Position_Audit> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Position_Audit>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_POSITION_AUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_POSITION_AUDIT;

				if (pagination) {
					sql = sql.concat(WFMS_Position_AuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_Position_Audit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Position_Audit>)QueryUtil.list(q,
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
	 * Removes all the WFMS_Position_Audits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_Position_Audit wfms_Position_Audit : findAll()) {
			remove(wfms_Position_Audit);
		}
	}

	/**
	 * Returns the number of WFMS_Position_Audits.
	 *
	 * @return the number of WFMS_Position_Audits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_POSITION_AUDIT);

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
		return WFMS_Position_AuditModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_Position_Audit persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_Position_AuditImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_POSITION_AUDIT = "SELECT wfms_Position_Audit FROM WFMS_Position_Audit wfms_Position_Audit";
	private static final String _SQL_SELECT_WFMS_POSITION_AUDIT_WHERE_PKS_IN = "SELECT wfms_Position_Audit FROM WFMS_Position_Audit wfms_Position_Audit WHERE paId IN (";
	private static final String _SQL_SELECT_WFMS_POSITION_AUDIT_WHERE = "SELECT wfms_Position_Audit FROM WFMS_Position_Audit wfms_Position_Audit WHERE ";
	private static final String _SQL_COUNT_WFMS_POSITION_AUDIT = "SELECT COUNT(wfms_Position_Audit) FROM WFMS_Position_Audit wfms_Position_Audit";
	private static final String _SQL_COUNT_WFMS_POSITION_AUDIT_WHERE = "SELECT COUNT(wfms_Position_Audit) FROM WFMS_Position_Audit wfms_Position_Audit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_Position_Audit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_Position_Audit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_Position_Audit exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_Position_AuditPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"change"
			});
}