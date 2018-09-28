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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Requisition_AuditException;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_Requisition_AuditPersistence;

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
 * The persistence implementation for the WFMS_Requisition_Audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_AuditPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_Requisition_AuditUtil
 * @generated
 */
@ProviderType
public class WFMS_Requisition_AuditPersistenceImpl extends BasePersistenceImpl<WFMS_Requisition_Audit>
	implements WFMS_Requisition_AuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_Requisition_AuditUtil} to access the WFMS_Requisition_Audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_Requisition_AuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REQIDFORAUDIT =
		new FinderPath(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReqIdForAudit",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQIDFORAUDIT =
		new FinderPath(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReqIdForAudit",
			new String[] { String.class.getName() },
			WFMS_Requisition_AuditModelImpl.REQID_COLUMN_BITMASK |
			WFMS_Requisition_AuditModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REQIDFORAUDIT = new FinderPath(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReqIdForAudit",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisition_Audits where reqId = &#63;.
	 *
	 * @param reqId the req ID
	 * @return the matching WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findByReqIdForAudit(String reqId) {
		return findByReqIdForAudit(reqId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the WFMS_Requisition_Audits where reqId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reqId the req ID
	 * @param start the lower bound of the range of WFMS_Requisition_Audits
	 * @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	 * @return the range of matching WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findByReqIdForAudit(String reqId,
		int start, int end) {
		return findByReqIdForAudit(reqId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisition_Audits where reqId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reqId the req ID
	 * @param start the lower bound of the range of WFMS_Requisition_Audits
	 * @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findByReqIdForAudit(String reqId,
		int start, int end,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator) {
		return findByReqIdForAudit(reqId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisition_Audits where reqId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reqId the req ID
	 * @param start the lower bound of the range of WFMS_Requisition_Audits
	 * @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findByReqIdForAudit(String reqId,
		int start, int end,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQIDFORAUDIT;
			finderArgs = new Object[] { reqId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REQIDFORAUDIT;
			finderArgs = new Object[] { reqId, start, end, orderByComparator };
		}

		List<WFMS_Requisition_Audit> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition_Audit>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition_Audit wfms_Requisition_Audit : list) {
					if (!Objects.equals(reqId, wfms_Requisition_Audit.getReqId())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_AUDIT_WHERE);

			boolean bindReqId = false;

			if (reqId == null) {
				query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_1);
			}
			else if (reqId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_3);
			}
			else {
				bindReqId = true;

				query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_Requisition_AuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReqId) {
					qPos.add(reqId);
				}

				if (!pagination) {
					list = (List<WFMS_Requisition_Audit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition_Audit>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	 *
	 * @param reqId the req ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition_Audit
	 * @throws NoSuchWFMS_Requisition_AuditException if a matching WFMS_Requisition_Audit could not be found
	 */
	@Override
	public WFMS_Requisition_Audit findByReqIdForAudit_First(String reqId,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator)
		throws NoSuchWFMS_Requisition_AuditException {
		WFMS_Requisition_Audit wfms_Requisition_Audit = fetchByReqIdForAudit_First(reqId,
				orderByComparator);

		if (wfms_Requisition_Audit != null) {
			return wfms_Requisition_Audit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reqId=");
		msg.append(reqId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_Requisition_AuditException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	 *
	 * @param reqId the req ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition_Audit, or <code>null</code> if a matching WFMS_Requisition_Audit could not be found
	 */
	@Override
	public WFMS_Requisition_Audit fetchByReqIdForAudit_First(String reqId,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator) {
		List<WFMS_Requisition_Audit> list = findByReqIdForAudit(reqId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	 *
	 * @param reqId the req ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition_Audit
	 * @throws NoSuchWFMS_Requisition_AuditException if a matching WFMS_Requisition_Audit could not be found
	 */
	@Override
	public WFMS_Requisition_Audit findByReqIdForAudit_Last(String reqId,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator)
		throws NoSuchWFMS_Requisition_AuditException {
		WFMS_Requisition_Audit wfms_Requisition_Audit = fetchByReqIdForAudit_Last(reqId,
				orderByComparator);

		if (wfms_Requisition_Audit != null) {
			return wfms_Requisition_Audit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reqId=");
		msg.append(reqId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_Requisition_AuditException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	 *
	 * @param reqId the req ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition_Audit, or <code>null</code> if a matching WFMS_Requisition_Audit could not be found
	 */
	@Override
	public WFMS_Requisition_Audit fetchByReqIdForAudit_Last(String reqId,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator) {
		int count = countByReqIdForAudit(reqId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition_Audit> list = findByReqIdForAudit(reqId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisition_Audits before and after the current WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	 *
	 * @param reqaId the primary key of the current WFMS_Requisition_Audit
	 * @param reqId the req ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition_Audit
	 * @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit[] findByReqIdForAudit_PrevAndNext(
		String reqaId, String reqId,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator)
		throws NoSuchWFMS_Requisition_AuditException {
		WFMS_Requisition_Audit wfms_Requisition_Audit = findByPrimaryKey(reqaId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition_Audit[] array = new WFMS_Requisition_AuditImpl[3];

			array[0] = getByReqIdForAudit_PrevAndNext(session,
					wfms_Requisition_Audit, reqId, orderByComparator, true);

			array[1] = wfms_Requisition_Audit;

			array[2] = getByReqIdForAudit_PrevAndNext(session,
					wfms_Requisition_Audit, reqId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition_Audit getByReqIdForAudit_PrevAndNext(
		Session session, WFMS_Requisition_Audit wfms_Requisition_Audit,
		String reqId,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator,
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

		query.append(_SQL_SELECT_WFMS_REQUISITION_AUDIT_WHERE);

		boolean bindReqId = false;

		if (reqId == null) {
			query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_1);
		}
		else if (reqId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_3);
		}
		else {
			bindReqId = true;

			query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_2);
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
			query.append(WFMS_Requisition_AuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReqId) {
			qPos.add(reqId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition_Audit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition_Audit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisition_Audits where reqId = &#63; from the database.
	 *
	 * @param reqId the req ID
	 */
	@Override
	public void removeByReqIdForAudit(String reqId) {
		for (WFMS_Requisition_Audit wfms_Requisition_Audit : findByReqIdForAudit(
				reqId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition_Audit);
		}
	}

	/**
	 * Returns the number of WFMS_Requisition_Audits where reqId = &#63;.
	 *
	 * @param reqId the req ID
	 * @return the number of matching WFMS_Requisition_Audits
	 */
	@Override
	public int countByReqIdForAudit(String reqId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REQIDFORAUDIT;

		Object[] finderArgs = new Object[] { reqId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_AUDIT_WHERE);

			boolean bindReqId = false;

			if (reqId == null) {
				query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_1);
			}
			else if (reqId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_3);
			}
			else {
				bindReqId = true;

				query.append(_FINDER_COLUMN_REQIDFORAUDIT_REQID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReqId) {
					qPos.add(reqId);
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

	private static final String _FINDER_COLUMN_REQIDFORAUDIT_REQID_1 = "wfms_Requisition_Audit.reqId IS NULL";
	private static final String _FINDER_COLUMN_REQIDFORAUDIT_REQID_2 = "wfms_Requisition_Audit.reqId = ?";
	private static final String _FINDER_COLUMN_REQIDFORAUDIT_REQID_3 = "(wfms_Requisition_Audit.reqId IS NULL OR wfms_Requisition_Audit.reqId = '')";

	public WFMS_Requisition_AuditPersistenceImpl() {
		setModelClass(WFMS_Requisition_Audit.class);

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
	 * Caches the WFMS_Requisition_Audit in the entity cache if it is enabled.
	 *
	 * @param wfms_Requisition_Audit the WFMS_Requisition_Audit
	 */
	@Override
	public void cacheResult(WFMS_Requisition_Audit wfms_Requisition_Audit) {
		entityCache.putResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			wfms_Requisition_Audit.getPrimaryKey(), wfms_Requisition_Audit);

		wfms_Requisition_Audit.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_Requisition_Audits in the entity cache if it is enabled.
	 *
	 * @param wfms_Requisition_Audits the WFMS_Requisition_Audits
	 */
	@Override
	public void cacheResult(
		List<WFMS_Requisition_Audit> wfms_Requisition_Audits) {
		for (WFMS_Requisition_Audit wfms_Requisition_Audit : wfms_Requisition_Audits) {
			if (entityCache.getResult(
						WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_Requisition_AuditImpl.class,
						wfms_Requisition_Audit.getPrimaryKey()) == null) {
				cacheResult(wfms_Requisition_Audit);
			}
			else {
				wfms_Requisition_Audit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_Requisition_Audits.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_Requisition_AuditImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_Requisition_Audit.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_Requisition_Audit wfms_Requisition_Audit) {
		entityCache.removeResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			wfms_Requisition_Audit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WFMS_Requisition_Audit> wfms_Requisition_Audits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_Requisition_Audit wfms_Requisition_Audit : wfms_Requisition_Audits) {
			entityCache.removeResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_Requisition_AuditImpl.class,
				wfms_Requisition_Audit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_Requisition_Audit with the primary key. Does not add the WFMS_Requisition_Audit to the database.
	 *
	 * @param reqaId the primary key for the new WFMS_Requisition_Audit
	 * @return the new WFMS_Requisition_Audit
	 */
	@Override
	public WFMS_Requisition_Audit create(String reqaId) {
		WFMS_Requisition_Audit wfms_Requisition_Audit = new WFMS_Requisition_AuditImpl();

		wfms_Requisition_Audit.setNew(true);
		wfms_Requisition_Audit.setPrimaryKey(reqaId);

		return wfms_Requisition_Audit;
	}

	/**
	 * Removes the WFMS_Requisition_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reqaId the primary key of the WFMS_Requisition_Audit
	 * @return the WFMS_Requisition_Audit that was removed
	 * @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit remove(String reqaId)
		throws NoSuchWFMS_Requisition_AuditException {
		return remove((Serializable)reqaId);
	}

	/**
	 * Removes the WFMS_Requisition_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_Requisition_Audit
	 * @return the WFMS_Requisition_Audit that was removed
	 * @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit remove(Serializable primaryKey)
		throws NoSuchWFMS_Requisition_AuditException {
		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition_Audit wfms_Requisition_Audit = (WFMS_Requisition_Audit)session.get(WFMS_Requisition_AuditImpl.class,
					primaryKey);

			if (wfms_Requisition_Audit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_Requisition_AuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_Requisition_Audit);
		}
		catch (NoSuchWFMS_Requisition_AuditException nsee) {
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
	protected WFMS_Requisition_Audit removeImpl(
		WFMS_Requisition_Audit wfms_Requisition_Audit) {
		wfms_Requisition_Audit = toUnwrappedModel(wfms_Requisition_Audit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_Requisition_Audit)) {
				wfms_Requisition_Audit = (WFMS_Requisition_Audit)session.get(WFMS_Requisition_AuditImpl.class,
						wfms_Requisition_Audit.getPrimaryKeyObj());
			}

			if (wfms_Requisition_Audit != null) {
				session.delete(wfms_Requisition_Audit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_Requisition_Audit != null) {
			clearCache(wfms_Requisition_Audit);
		}

		return wfms_Requisition_Audit;
	}

	@Override
	public WFMS_Requisition_Audit updateImpl(
		WFMS_Requisition_Audit wfms_Requisition_Audit) {
		wfms_Requisition_Audit = toUnwrappedModel(wfms_Requisition_Audit);

		boolean isNew = wfms_Requisition_Audit.isNew();

		WFMS_Requisition_AuditModelImpl wfms_Requisition_AuditModelImpl = (WFMS_Requisition_AuditModelImpl)wfms_Requisition_Audit;

		Session session = null;

		try {
			session = openSession();

			if (wfms_Requisition_Audit.isNew()) {
				session.save(wfms_Requisition_Audit);

				wfms_Requisition_Audit.setNew(false);
			}
			else {
				wfms_Requisition_Audit = (WFMS_Requisition_Audit)session.merge(wfms_Requisition_Audit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_Requisition_AuditModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					wfms_Requisition_AuditModelImpl.getReqId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REQIDFORAUDIT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQIDFORAUDIT,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wfms_Requisition_AuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQIDFORAUDIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_Requisition_AuditModelImpl.getOriginalReqId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REQIDFORAUDIT,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQIDFORAUDIT,
					args);

				args = new Object[] { wfms_Requisition_AuditModelImpl.getReqId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REQIDFORAUDIT,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQIDFORAUDIT,
					args);
			}
		}

		entityCache.putResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Requisition_AuditImpl.class,
			wfms_Requisition_Audit.getPrimaryKey(), wfms_Requisition_Audit,
			false);

		wfms_Requisition_Audit.resetOriginalValues();

		return wfms_Requisition_Audit;
	}

	protected WFMS_Requisition_Audit toUnwrappedModel(
		WFMS_Requisition_Audit wfms_Requisition_Audit) {
		if (wfms_Requisition_Audit instanceof WFMS_Requisition_AuditImpl) {
			return wfms_Requisition_Audit;
		}

		WFMS_Requisition_AuditImpl wfms_Requisition_AuditImpl = new WFMS_Requisition_AuditImpl();

		wfms_Requisition_AuditImpl.setNew(wfms_Requisition_Audit.isNew());
		wfms_Requisition_AuditImpl.setPrimaryKey(wfms_Requisition_Audit.getPrimaryKey());

		wfms_Requisition_AuditImpl.setReqaId(wfms_Requisition_Audit.getReqaId());
		wfms_Requisition_AuditImpl.setReqId(wfms_Requisition_Audit.getReqId());
		wfms_Requisition_AuditImpl.setUserId(wfms_Requisition_Audit.getUserId());
		wfms_Requisition_AuditImpl.setCreatedBy(wfms_Requisition_Audit.getCreatedBy());
		wfms_Requisition_AuditImpl.setCreateDate(wfms_Requisition_Audit.getCreateDate());
		wfms_Requisition_AuditImpl.setChange(wfms_Requisition_Audit.getChange());
		wfms_Requisition_AuditImpl.setComments(wfms_Requisition_Audit.getComments());

		return wfms_Requisition_AuditImpl;
	}

	/**
	 * Returns the WFMS_Requisition_Audit with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Requisition_Audit
	 * @return the WFMS_Requisition_Audit
	 * @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_Requisition_AuditException {
		WFMS_Requisition_Audit wfms_Requisition_Audit = fetchByPrimaryKey(primaryKey);

		if (wfms_Requisition_Audit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_Requisition_AuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_Requisition_Audit;
	}

	/**
	 * Returns the WFMS_Requisition_Audit with the primary key or throws a {@link NoSuchWFMS_Requisition_AuditException} if it could not be found.
	 *
	 * @param reqaId the primary key of the WFMS_Requisition_Audit
	 * @return the WFMS_Requisition_Audit
	 * @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit findByPrimaryKey(String reqaId)
		throws NoSuchWFMS_Requisition_AuditException {
		return findByPrimaryKey((Serializable)reqaId);
	}

	/**
	 * Returns the WFMS_Requisition_Audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Requisition_Audit
	 * @return the WFMS_Requisition_Audit, or <code>null</code> if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_Requisition_AuditImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_Requisition_Audit wfms_Requisition_Audit = (WFMS_Requisition_Audit)serializable;

		if (wfms_Requisition_Audit == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_Requisition_Audit = (WFMS_Requisition_Audit)session.get(WFMS_Requisition_AuditImpl.class,
						primaryKey);

				if (wfms_Requisition_Audit != null) {
					cacheResult(wfms_Requisition_Audit);
				}
				else {
					entityCache.putResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_Requisition_AuditImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Requisition_AuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_Requisition_Audit;
	}

	/**
	 * Returns the WFMS_Requisition_Audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reqaId the primary key of the WFMS_Requisition_Audit
	 * @return the WFMS_Requisition_Audit, or <code>null</code> if a WFMS_Requisition_Audit with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition_Audit fetchByPrimaryKey(String reqaId) {
		return fetchByPrimaryKey((Serializable)reqaId);
	}

	@Override
	public Map<Serializable, WFMS_Requisition_Audit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_Requisition_Audit> map = new HashMap<Serializable, WFMS_Requisition_Audit>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_Requisition_Audit wfms_Requisition_Audit = fetchByPrimaryKey(primaryKey);

			if (wfms_Requisition_Audit != null) {
				map.put(primaryKey, wfms_Requisition_Audit);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Requisition_AuditImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_Requisition_Audit)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_REQUISITION_AUDIT_WHERE_PKS_IN);

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

			for (WFMS_Requisition_Audit wfms_Requisition_Audit : (List<WFMS_Requisition_Audit>)q.list()) {
				map.put(wfms_Requisition_Audit.getPrimaryKeyObj(),
					wfms_Requisition_Audit);

				cacheResult(wfms_Requisition_Audit);

				uncachedPrimaryKeys.remove(wfms_Requisition_Audit.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_Requisition_AuditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Requisition_AuditImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_Requisition_Audits.
	 *
	 * @return the WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisition_Audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Requisition_Audits
	 * @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	 * @return the range of WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisition_Audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Requisition_Audits
	 * @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisition_Audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Requisition_Audits
	 * @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_Requisition_Audits
	 */
	@Override
	public List<WFMS_Requisition_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_Requisition_Audit> orderByComparator,
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

		List<WFMS_Requisition_Audit> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition_Audit>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_REQUISITION_AUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_REQUISITION_AUDIT;

				if (pagination) {
					sql = sql.concat(WFMS_Requisition_AuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_Requisition_Audit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition_Audit>)QueryUtil.list(q,
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
	 * Removes all the WFMS_Requisition_Audits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_Requisition_Audit wfms_Requisition_Audit : findAll()) {
			remove(wfms_Requisition_Audit);
		}
	}

	/**
	 * Returns the number of WFMS_Requisition_Audits.
	 *
	 * @return the number of WFMS_Requisition_Audits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_REQUISITION_AUDIT);

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
		return WFMS_Requisition_AuditModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_Requisition_Audit persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_Requisition_AuditImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_REQUISITION_AUDIT = "SELECT wfms_Requisition_Audit FROM WFMS_Requisition_Audit wfms_Requisition_Audit";
	private static final String _SQL_SELECT_WFMS_REQUISITION_AUDIT_WHERE_PKS_IN = "SELECT wfms_Requisition_Audit FROM WFMS_Requisition_Audit wfms_Requisition_Audit WHERE reqaId IN (";
	private static final String _SQL_SELECT_WFMS_REQUISITION_AUDIT_WHERE = "SELECT wfms_Requisition_Audit FROM WFMS_Requisition_Audit wfms_Requisition_Audit WHERE ";
	private static final String _SQL_COUNT_WFMS_REQUISITION_AUDIT = "SELECT COUNT(wfms_Requisition_Audit) FROM WFMS_Requisition_Audit wfms_Requisition_Audit";
	private static final String _SQL_COUNT_WFMS_REQUISITION_AUDIT_WHERE = "SELECT COUNT(wfms_Requisition_Audit) FROM WFMS_Requisition_Audit wfms_Requisition_Audit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_Requisition_Audit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_Requisition_Audit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_Requisition_Audit exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_Requisition_AuditPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"change"
			});
}