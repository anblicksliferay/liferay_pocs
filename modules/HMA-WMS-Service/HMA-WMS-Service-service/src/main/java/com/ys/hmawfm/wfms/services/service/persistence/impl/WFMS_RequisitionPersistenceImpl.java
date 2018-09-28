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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_RequisitionPersistence;

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
 * The persistence implementation for the WFMS_Requisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_RequisitionPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_RequisitionUtil
 * @generated
 */
@ProviderType
public class WFMS_RequisitionPersistenceImpl extends BasePersistenceImpl<WFMS_Requisition>
	implements WFMS_RequisitionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_RequisitionUtil} to access the WFMS_Requisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_RequisitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus_Pid_Colllection",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatus_Pid_Colllection",
			new String[] { String.class.getName(), String.class.getName() },
			WFMS_RequisitionModelImpl.STATUS_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS_PID_COLLLECTION = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatus_Pid_Colllection",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByStatus_Pid_Colllection(String status,
		String rId) {
		return findByStatus_Pid_Colllection(status, rId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByStatus_Pid_Colllection(String status,
		String rId, int start, int end) {
		return findByStatus_Pid_Colllection(status, rId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByStatus_Pid_Colllection(String status,
		String rId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findByStatus_Pid_Colllection(status, rId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByStatus_Pid_Colllection(String status,
		String rId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION;
			finderArgs = new Object[] { status, rId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION;
			finderArgs = new Object[] { status, rId, start, end, orderByComparator };
		}

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(status, wfms_Requisition.getStatus()) ||
							!Objects.equals(rId, wfms_Requisition.getRId())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_2);
			}

			boolean bindRId = false;

			if (rId == null) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_1);
			}
			else if (rId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_3);
			}
			else {
				bindRId = true;

				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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

				if (bindRId) {
					qPos.add(rId);
				}

				if (!pagination) {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByStatus_Pid_Colllection_First(String status,
		String rId, OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByStatus_Pid_Colllection_First(status,
				rId, orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", rId=");
		msg.append(rId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByStatus_Pid_Colllection_First(String status,
		String rId, OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findByStatus_Pid_Colllection(status, rId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByStatus_Pid_Colllection_Last(String status,
		String rId, OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByStatus_Pid_Colllection_Last(status,
				rId, orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", rId=");
		msg.append(rId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByStatus_Pid_Colllection_Last(String status,
		String rId, OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countByStatus_Pid_Colllection(status, rId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findByStatus_Pid_Colllection(status, rId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param status the status
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findByStatus_Pid_Colllection_PrevAndNext(
		String rwfId, String status, String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getByStatus_Pid_Colllection_PrevAndNext(session,
					wfms_Requisition, status, rId, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getByStatus_Pid_Colllection_PrevAndNext(session,
					wfms_Requisition, status, rId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition getByStatus_Pid_Colllection_PrevAndNext(
		Session session, WFMS_Requisition wfms_Requisition, String status,
		String rId, OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_2);
		}

		boolean bindRId = false;

		if (rId == null) {
			query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_1);
		}
		else if (rId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_3);
		}
		else {
			bindRId = true;

			query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_2);
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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (bindRId) {
			qPos.add(rId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where status = &#63; and rId = &#63; from the database.
	 *
	 * @param status the status
	 * @param rId the r ID
	 */
	@Override
	public void removeByStatus_Pid_Colllection(String status, String rId) {
		for (WFMS_Requisition wfms_Requisition : findByStatus_Pid_Colllection(
				status, rId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where status = &#63; and rId = &#63;.
	 *
	 * @param status the status
	 * @param rId the r ID
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countByStatus_Pid_Colllection(String status, String rId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS_PID_COLLLECTION;

		Object[] finderArgs = new Object[] { status, rId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_2);
			}

			boolean bindRId = false;

			if (rId == null) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_1);
			}
			else if (rId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_3);
			}
			else {
				bindRId = true;

				query.append(_FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_2);
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

				if (bindRId) {
					qPos.add(rId);
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

	private static final String _FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_1 = "wfms_Requisition.status IS NULL AND ";
	private static final String _FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_2 = "wfms_Requisition.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_PID_COLLLECTION_STATUS_3 = "(wfms_Requisition.status IS NULL OR wfms_Requisition.status = '') AND ";
	private static final String _FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_1 = "wfms_Requisition.rId IS NULL";
	private static final String _FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_2 = "wfms_Requisition.rId = ?";
	private static final String _FINDER_COLUMN_STATUS_PID_COLLLECTION_RID_3 = "(wfms_Requisition.rId IS NULL OR wfms_Requisition.rId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_REQUISITION = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByrequisition", new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.RWFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUISITION = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrequisition",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_Requisition where rwfId = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	 *
	 * @param rwfId the rwf ID
	 * @return the matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByrequisition(String rwfId)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByrequisition(rwfId);

		if (wfms_Requisition == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rwfId=");
			msg.append(rwfId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_RequisitionException(msg.toString());
		}

		return wfms_Requisition;
	}

	/**
	 * Returns the WFMS_Requisition where rwfId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rwfId the rwf ID
	 * @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByrequisition(String rwfId) {
		return fetchByrequisition(rwfId, true);
	}

	/**
	 * Returns the WFMS_Requisition where rwfId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rwfId the rwf ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByrequisition(String rwfId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { rwfId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_REQUISITION,
					finderArgs, this);
		}

		if (result instanceof WFMS_Requisition) {
			WFMS_Requisition wfms_Requisition = (WFMS_Requisition)result;

			if (!Objects.equals(rwfId, wfms_Requisition.getRwfId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindRwfId = false;

			if (rwfId == null) {
				query.append(_FINDER_COLUMN_REQUISITION_RWFID_1);
			}
			else if (rwfId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REQUISITION_RWFID_3);
			}
			else {
				bindRwfId = true;

				query.append(_FINDER_COLUMN_REQUISITION_RWFID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRwfId) {
					qPos.add(rwfId);
				}

				List<WFMS_Requisition> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_REQUISITION,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_RequisitionPersistenceImpl.fetchByrequisition(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_Requisition wfms_Requisition = list.get(0);

					result = wfms_Requisition;

					cacheResult(wfms_Requisition);

					if ((wfms_Requisition.getRwfId() == null) ||
							!wfms_Requisition.getRwfId().equals(rwfId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_REQUISITION,
							finderArgs, wfms_Requisition);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_REQUISITION,
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
			return (WFMS_Requisition)result;
		}
	}

	/**
	 * Removes the WFMS_Requisition where rwfId = &#63; from the database.
	 *
	 * @param rwfId the rwf ID
	 * @return the WFMS_Requisition that was removed
	 */
	@Override
	public WFMS_Requisition removeByrequisition(String rwfId)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByrequisition(rwfId);

		return remove(wfms_Requisition);
	}

	/**
	 * Returns the number of WFMS_Requisitions where rwfId = &#63;.
	 *
	 * @param rwfId the rwf ID
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countByrequisition(String rwfId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REQUISITION;

		Object[] finderArgs = new Object[] { rwfId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindRwfId = false;

			if (rwfId == null) {
				query.append(_FINDER_COLUMN_REQUISITION_RWFID_1);
			}
			else if (rwfId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REQUISITION_RWFID_3);
			}
			else {
				bindRwfId = true;

				query.append(_FINDER_COLUMN_REQUISITION_RWFID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRwfId) {
					qPos.add(rwfId);
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

	private static final String _FINDER_COLUMN_REQUISITION_RWFID_1 = "wfms_Requisition.rwfId IS NULL";
	private static final String _FINDER_COLUMN_REQUISITION_RWFID_2 = "wfms_Requisition.rwfId = ?";
	private static final String _FINDER_COLUMN_REQUISITION_RWFID_3 = "(wfms_Requisition.rwfId IS NULL OR wfms_Requisition.rwfId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITION = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByposition", new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITION = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByposition",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_Requisition where rId = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	 *
	 * @param rId the r ID
	 * @return the matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByposition(String rId)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByposition(rId);

		if (wfms_Requisition == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rId=");
			msg.append(rId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_RequisitionException(msg.toString());
		}

		return wfms_Requisition;
	}

	/**
	 * Returns the WFMS_Requisition where rId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rId the r ID
	 * @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByposition(String rId) {
		return fetchByposition(rId, true);
	}

	/**
	 * Returns the WFMS_Requisition where rId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rId the r ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByposition(String rId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { rId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_POSITION,
					finderArgs, this);
		}

		if (result instanceof WFMS_Requisition) {
			WFMS_Requisition wfms_Requisition = (WFMS_Requisition)result;

			if (!Objects.equals(rId, wfms_Requisition.getRId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindRId = false;

			if (rId == null) {
				query.append(_FINDER_COLUMN_POSITION_RID_1);
			}
			else if (rId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITION_RID_3);
			}
			else {
				bindRId = true;

				query.append(_FINDER_COLUMN_POSITION_RID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRId) {
					qPos.add(rId);
				}

				List<WFMS_Requisition> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_RequisitionPersistenceImpl.fetchByposition(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_Requisition wfms_Requisition = list.get(0);

					result = wfms_Requisition;

					cacheResult(wfms_Requisition);

					if ((wfms_Requisition.getRId() == null) ||
							!wfms_Requisition.getRId().equals(rId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION,
							finderArgs, wfms_Requisition);
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
			return (WFMS_Requisition)result;
		}
	}

	/**
	 * Removes the WFMS_Requisition where rId = &#63; from the database.
	 *
	 * @param rId the r ID
	 * @return the WFMS_Requisition that was removed
	 */
	@Override
	public WFMS_Requisition removeByposition(String rId)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByposition(rId);

		return remove(wfms_Requisition);
	}

	/**
	 * Returns the number of WFMS_Requisitions where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countByposition(String rId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITION;

		Object[] finderArgs = new Object[] { rId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindRId = false;

			if (rId == null) {
				query.append(_FINDER_COLUMN_POSITION_RID_1);
			}
			else if (rId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITION_RID_3);
			}
			else {
				bindRId = true;

				query.append(_FINDER_COLUMN_POSITION_RID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRId) {
					qPos.add(rId);
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

	private static final String _FINDER_COLUMN_POSITION_RID_1 = "wfms_Requisition.rId IS NULL";
	private static final String _FINDER_COLUMN_POSITION_RID_2 = "wfms_Requisition.rId = ?";
	private static final String _FINDER_COLUMN_POSITION_RID_3 = "(wfms_Requisition.rId IS NULL OR wfms_Requisition.rId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONNUMBER =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypositionnumber",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONNUMBER =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypositionnumber",
			new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.NUMBER_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONNUMBER = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypositionnumber",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where Number = &#63;.
	 *
	 * @param Number the number
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionnumber(String Number) {
		return findBypositionnumber(Number, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where Number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Number the number
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionnumber(String Number,
		int start, int end) {
		return findBypositionnumber(Number, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where Number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Number the number
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionnumber(String Number,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findBypositionnumber(Number, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where Number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param Number the number
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionnumber(String Number,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONNUMBER;
			finderArgs = new Object[] { Number };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONNUMBER;
			finderArgs = new Object[] { Number, start, end, orderByComparator };
		}

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(Number, wfms_Requisition.getNumber())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindNumber = false;

			if (Number == null) {
				query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_1);
			}
			else if (Number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(Number);
				}

				if (!pagination) {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where Number = &#63;.
	 *
	 * @param Number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionnumber_First(String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionnumber_First(Number,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Number=");
		msg.append(Number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where Number = &#63;.
	 *
	 * @param Number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionnumber_First(String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findBypositionnumber(Number, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where Number = &#63;.
	 *
	 * @param Number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionnumber_Last(String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionnumber_Last(Number,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Number=");
		msg.append(Number);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where Number = &#63;.
	 *
	 * @param Number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionnumber_Last(String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countBypositionnumber(Number);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findBypositionnumber(Number, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where Number = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param Number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findBypositionnumber_PrevAndNext(String rwfId,
		String Number, OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getBypositionnumber_PrevAndNext(session,
					wfms_Requisition, Number, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getBypositionnumber_PrevAndNext(session,
					wfms_Requisition, Number, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition getBypositionnumber_PrevAndNext(
		Session session, WFMS_Requisition wfms_Requisition, String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

		boolean bindNumber = false;

		if (Number == null) {
			query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_1);
		}
		else if (Number.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_3);
		}
		else {
			bindNumber = true;

			query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_2);
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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNumber) {
			qPos.add(Number);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where Number = &#63; from the database.
	 *
	 * @param Number the number
	 */
	@Override
	public void removeBypositionnumber(String Number) {
		for (WFMS_Requisition wfms_Requisition : findBypositionnumber(Number,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where Number = &#63;.
	 *
	 * @param Number the number
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countBypositionnumber(String Number) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONNUMBER;

		Object[] finderArgs = new Object[] { Number };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindNumber = false;

			if (Number == null) {
				query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_1);
			}
			else if (Number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_POSITIONNUMBER_NUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(Number);
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

	private static final String _FINDER_COLUMN_POSITIONNUMBER_NUMBER_1 = "wfms_Requisition.Number IS NULL";
	private static final String _FINDER_COLUMN_POSITIONNUMBER_NUMBER_2 = "wfms_Requisition.Number = ?";
	private static final String _FINDER_COLUMN_POSITIONNUMBER_NUMBER_3 = "(wfms_Requisition.Number IS NULL OR wfms_Requisition.Number = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONID =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypositionId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypositionId",
			new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONID = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypositionId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionId(String rId) {
		return findBypositionId(rId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where rId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rId the r ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionId(String rId, int start,
		int end) {
		return findBypositionId(rId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where rId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rId the r ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionId(String rId, int start,
		int end, OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findBypositionId(rId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where rId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rId the r ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionId(String rId, int start,
		int end, OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID;
			finderArgs = new Object[] { rId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONID;
			finderArgs = new Object[] { rId, start, end, orderByComparator };
		}

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(rId, wfms_Requisition.getRId())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindRId = false;

			if (rId == null) {
				query.append(_FINDER_COLUMN_POSITIONID_RID_1);
			}
			else if (rId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONID_RID_3);
			}
			else {
				bindRId = true;

				query.append(_FINDER_COLUMN_POSITIONID_RID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRId) {
					qPos.add(rId);
				}

				if (!pagination) {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionId_First(String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionId_First(rId,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rId=");
		msg.append(rId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionId_First(String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findBypositionId(rId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionId_Last(String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionId_Last(rId,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rId=");
		msg.append(rId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionId_Last(String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countBypositionId(rId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findBypositionId(rId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where rId = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param rId the r ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findBypositionId_PrevAndNext(String rwfId,
		String rId, OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getBypositionId_PrevAndNext(session, wfms_Requisition,
					rId, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getBypositionId_PrevAndNext(session, wfms_Requisition,
					rId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition getBypositionId_PrevAndNext(Session session,
		WFMS_Requisition wfms_Requisition, String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

		boolean bindRId = false;

		if (rId == null) {
			query.append(_FINDER_COLUMN_POSITIONID_RID_1);
		}
		else if (rId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_POSITIONID_RID_3);
		}
		else {
			bindRId = true;

			query.append(_FINDER_COLUMN_POSITIONID_RID_2);
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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRId) {
			qPos.add(rId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where rId = &#63; from the database.
	 *
	 * @param rId the r ID
	 */
	@Override
	public void removeBypositionId(String rId) {
		for (WFMS_Requisition wfms_Requisition : findBypositionId(rId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where rId = &#63;.
	 *
	 * @param rId the r ID
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countBypositionId(String rId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONID;

		Object[] finderArgs = new Object[] { rId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindRId = false;

			if (rId == null) {
				query.append(_FINDER_COLUMN_POSITIONID_RID_1);
			}
			else if (rId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONID_RID_3);
			}
			else {
				bindRId = true;

				query.append(_FINDER_COLUMN_POSITIONID_RID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRId) {
					qPos.add(rId);
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

	private static final String _FINDER_COLUMN_POSITIONID_RID_1 = "wfms_Requisition.rId IS NULL";
	private static final String _FINDER_COLUMN_POSITIONID_RID_2 = "wfms_Requisition.rId = ?";
	private static final String _FINDER_COLUMN_POSITIONID_RID_3 = "(wfms_Requisition.rId IS NULL OR wfms_Requisition.rId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypositionIdGetByStaus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypositionIdGetByStaus",
			new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.STATUS_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypositionIdGetByStaus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionIdGetByStaus(String status) {
		return findBypositionIdGetByStaus(status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionIdGetByStaus(String status,
		int start, int end) {
		return findBypositionIdGetByStaus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionIdGetByStaus(String status,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findBypositionIdGetByStaus(status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBypositionIdGetByStaus(String status,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
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

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(status, wfms_Requisition.getStatus())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionIdGetByStaus_First(String status,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionIdGetByStaus_First(status,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionIdGetByStaus_First(String status,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findBypositionIdGetByStaus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionIdGetByStaus_Last(String status,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionIdGetByStaus_Last(status,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionIdGetByStaus_Last(String status,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countBypositionIdGetByStaus(status);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findBypositionIdGetByStaus(status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where status = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findBypositionIdGetByStaus_PrevAndNext(
		String rwfId, String status,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getBypositionIdGetByStaus_PrevAndNext(session,
					wfms_Requisition, status, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getBypositionIdGetByStaus_PrevAndNext(session,
					wfms_Requisition, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition getBypositionIdGetByStaus_PrevAndNext(
		Session session, WFMS_Requisition wfms_Requisition, String status,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBypositionIdGetByStaus(String status) {
		for (WFMS_Requisition wfms_Requisition : findBypositionIdGetByStaus(
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countBypositionIdGetByStaus(String status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

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

	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_1 = "wfms_Requisition.status IS NULL";
	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_2 = "wfms_Requisition.status = ?";
	private static final String _FINDER_COLUMN_POSITIONIDGETBYSTAUS_STATUS_3 = "(wfms_Requisition.status IS NULL OR wfms_Requisition.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DUMMY = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydummy",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydummy",
			new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.DUMMY_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DUMMY = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydummy",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBydummy(String dummy) {
		return findBydummy(dummy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where dummy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBydummy(String dummy, int start, int end) {
		return findBydummy(dummy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where dummy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBydummy(String dummy, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findBydummy(dummy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where dummy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dummy the dummy
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findBydummy(String dummy, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
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

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(dummy, wfms_Requisition.getDummy())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBydummy_First(String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBydummy_First(dummy,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dummy=");
		msg.append(dummy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBydummy_First(String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findBydummy(dummy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBydummy_Last(String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBydummy_Last(dummy,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dummy=");
		msg.append(dummy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBydummy_Last(String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countBydummy(dummy);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findBydummy(dummy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where dummy = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param dummy the dummy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findBydummy_PrevAndNext(String rwfId,
		String dummy, OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getBydummy_PrevAndNext(session, wfms_Requisition, dummy,
					orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getBydummy_PrevAndNext(session, wfms_Requisition, dummy,
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

	protected WFMS_Requisition getBydummy_PrevAndNext(Session session,
		WFMS_Requisition wfms_Requisition, String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where dummy = &#63; from the database.
	 *
	 * @param dummy the dummy
	 */
	@Override
	public void removeBydummy(String dummy) {
		for (WFMS_Requisition wfms_Requisition : findBydummy(dummy,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where dummy = &#63;.
	 *
	 * @param dummy the dummy
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countBydummy(String dummy) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DUMMY;

		Object[] finderArgs = new Object[] { dummy };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

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

	private static final String _FINDER_COLUMN_DUMMY_DUMMY_1 = "wfms_Requisition.dummy IS NULL";
	private static final String _FINDER_COLUMN_DUMMY_DUMMY_2 = "wfms_Requisition.dummy = ?";
	private static final String _FINDER_COLUMN_DUMMY_DUMMY_3 = "(wfms_Requisition.dummy IS NULL OR wfms_Requisition.dummy = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKFLOWID =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByworkflowId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByworkflowId",
			new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.WORKFLOWID_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOWID = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByworkflowId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByworkflowId(String workflowId) {
		return findByworkflowId(workflowId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByworkflowId(String workflowId,
		int start, int end) {
		return findByworkflowId(workflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByworkflowId(String workflowId,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findByworkflowId(workflowId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where workflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workflowId the workflow ID
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByworkflowId(String workflowId,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
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

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(workflowId,
								wfms_Requisition.getWorkflowId())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByworkflowId_First(String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByworkflowId_First(workflowId,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workflowId=");
		msg.append(workflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByworkflowId_First(String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findByworkflowId(workflowId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByworkflowId_Last(String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByworkflowId_Last(workflowId,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workflowId=");
		msg.append(workflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByworkflowId_Last(String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countByworkflowId(workflowId);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findByworkflowId(workflowId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where workflowId = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param workflowId the workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findByworkflowId_PrevAndNext(String rwfId,
		String workflowId, OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getByworkflowId_PrevAndNext(session, wfms_Requisition,
					workflowId, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getByworkflowId_PrevAndNext(session, wfms_Requisition,
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

	protected WFMS_Requisition getByworkflowId_PrevAndNext(Session session,
		WFMS_Requisition wfms_Requisition, String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where workflowId = &#63; from the database.
	 *
	 * @param workflowId the workflow ID
	 */
	@Override
	public void removeByworkflowId(String workflowId) {
		for (WFMS_Requisition wfms_Requisition : findByworkflowId(workflowId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where workflowId = &#63;.
	 *
	 * @param workflowId the workflow ID
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countByworkflowId(String workflowId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKFLOWID;

		Object[] finderArgs = new Object[] { workflowId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

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

	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_1 = "wfms_Requisition.workflowId IS NULL";
	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_2 = "wfms_Requisition.workflowId = ?";
	private static final String _FINDER_COLUMN_WORKFLOWID_WORKFLOWID_3 = "(wfms_Requisition.workflowId IS NULL OR wfms_Requisition.workflowId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITIONASSOCIATE = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypositionassociate",
			new String[] { String.class.getName(), String.class.getName() },
			WFMS_RequisitionModelImpl.NUMBER_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.ASSOCIATENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONASSOCIATE = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypositionassociate",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	 *
	 * @param Number the number
	 * @param associatenumber the associatenumber
	 * @return the matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findBypositionassociate(String Number,
		String associatenumber) throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchBypositionassociate(Number,
				associatenumber);

		if (wfms_Requisition == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Number=");
			msg.append(Number);

			msg.append(", associatenumber=");
			msg.append(associatenumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_RequisitionException(msg.toString());
		}

		return wfms_Requisition;
	}

	/**
	 * Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Number the number
	 * @param associatenumber the associatenumber
	 * @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionassociate(String Number,
		String associatenumber) {
		return fetchBypositionassociate(Number, associatenumber, true);
	}

	/**
	 * Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Number the number
	 * @param associatenumber the associatenumber
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchBypositionassociate(String Number,
		String associatenumber, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { Number, associatenumber };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
					finderArgs, this);
		}

		if (result instanceof WFMS_Requisition) {
			WFMS_Requisition wfms_Requisition = (WFMS_Requisition)result;

			if (!Objects.equals(Number, wfms_Requisition.getNumber()) ||
					!Objects.equals(associatenumber,
						wfms_Requisition.getAssociatenumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindNumber = false;

			if (Number == null) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_1);
			}
			else if (Number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_2);
			}

			boolean bindAssociatenumber = false;

			if (associatenumber == null) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_1);
			}
			else if (associatenumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_3);
			}
			else {
				bindAssociatenumber = true;

				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(Number);
				}

				if (bindAssociatenumber) {
					qPos.add(associatenumber);
				}

				List<WFMS_Requisition> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_RequisitionPersistenceImpl.fetchBypositionassociate(String, String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_Requisition wfms_Requisition = list.get(0);

					result = wfms_Requisition;

					cacheResult(wfms_Requisition);

					if ((wfms_Requisition.getNumber() == null) ||
							!wfms_Requisition.getNumber().equals(Number) ||
							(wfms_Requisition.getAssociatenumber() == null) ||
							!wfms_Requisition.getAssociatenumber()
												 .equals(associatenumber)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
							finderArgs, wfms_Requisition);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
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
			return (WFMS_Requisition)result;
		}
	}

	/**
	 * Removes the WFMS_Requisition where Number = &#63; and associatenumber = &#63; from the database.
	 *
	 * @param Number the number
	 * @param associatenumber the associatenumber
	 * @return the WFMS_Requisition that was removed
	 */
	@Override
	public WFMS_Requisition removeBypositionassociate(String Number,
		String associatenumber) throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findBypositionassociate(Number,
				associatenumber);

		return remove(wfms_Requisition);
	}

	/**
	 * Returns the number of WFMS_Requisitions where Number = &#63; and associatenumber = &#63;.
	 *
	 * @param Number the number
	 * @param associatenumber the associatenumber
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countBypositionassociate(String Number, String associatenumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONASSOCIATE;

		Object[] finderArgs = new Object[] { Number, associatenumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindNumber = false;

			if (Number == null) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_1);
			}
			else if (Number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_2);
			}

			boolean bindAssociatenumber = false;

			if (associatenumber == null) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_1);
			}
			else if (associatenumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_3);
			}
			else {
				bindAssociatenumber = true;

				query.append(_FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(Number);
				}

				if (bindAssociatenumber) {
					qPos.add(associatenumber);
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

	private static final String _FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_1 = "wfms_Requisition.Number IS NULL AND ";
	private static final String _FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_2 = "wfms_Requisition.Number = ? AND ";
	private static final String _FINDER_COLUMN_POSITIONASSOCIATE_NUMBER_3 = "(wfms_Requisition.Number IS NULL OR wfms_Requisition.Number = '') AND ";
	private static final String _FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_1 =
		"wfms_Requisition.associatenumber IS NULL";
	private static final String _FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_2 =
		"wfms_Requisition.associatenumber = ?";
	private static final String _FINDER_COLUMN_POSITIONASSOCIATE_ASSOCIATENUMBER_3 =
		"(wfms_Requisition.associatenumber IS NULL OR wfms_Requisition.associatenumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTAPPROVE =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNextApprove",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NEXTAPPROVE =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNextApprove",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where nextapprove LIKE &#63;.
	 *
	 * @param nextapprove the nextapprove
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByNextApprove(String nextapprove) {
		return findByNextApprove(nextapprove, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where nextapprove LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextapprove the nextapprove
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByNextApprove(String nextapprove,
		int start, int end) {
		return findByNextApprove(nextapprove, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where nextapprove LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextapprove the nextapprove
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByNextApprove(String nextapprove,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findByNextApprove(nextapprove, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where nextapprove LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nextapprove the nextapprove
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByNextApprove(String nextapprove,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTAPPROVE;
		finderArgs = new Object[] { nextapprove, start, end, orderByComparator };

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!StringUtil.wildcardMatches(
								wfms_Requisition.getNextapprove(), nextapprove,
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

			boolean bindNextapprove = false;

			if (nextapprove == null) {
				query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_1);
			}
			else if (nextapprove.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_3);
			}
			else {
				bindNextapprove = true;

				query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNextapprove) {
					qPos.add(nextapprove);
				}

				if (!pagination) {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	 *
	 * @param nextapprove the nextapprove
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByNextApprove_First(String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByNextApprove_First(nextapprove,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextapprove=");
		msg.append(nextapprove);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	 *
	 * @param nextapprove the nextapprove
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByNextApprove_First(String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findByNextApprove(nextapprove, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	 *
	 * @param nextapprove the nextapprove
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByNextApprove_Last(String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByNextApprove_Last(nextapprove,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextapprove=");
		msg.append(nextapprove);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	 *
	 * @param nextapprove the nextapprove
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByNextApprove_Last(String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countByNextApprove(nextapprove);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findByNextApprove(nextapprove, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param nextapprove the nextapprove
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findByNextApprove_PrevAndNext(String rwfId,
		String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getByNextApprove_PrevAndNext(session, wfms_Requisition,
					nextapprove, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getByNextApprove_PrevAndNext(session, wfms_Requisition,
					nextapprove, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition getByNextApprove_PrevAndNext(Session session,
		WFMS_Requisition wfms_Requisition, String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

		boolean bindNextapprove = false;

		if (nextapprove == null) {
			query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_1);
		}
		else if (nextapprove.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_3);
		}
		else {
			bindNextapprove = true;

			query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_2);
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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNextapprove) {
			qPos.add(nextapprove);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where nextapprove LIKE &#63; from the database.
	 *
	 * @param nextapprove the nextapprove
	 */
	@Override
	public void removeByNextApprove(String nextapprove) {
		for (WFMS_Requisition wfms_Requisition : findByNextApprove(
				nextapprove, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where nextapprove LIKE &#63;.
	 *
	 * @param nextapprove the nextapprove
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countByNextApprove(String nextapprove) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NEXTAPPROVE;

		Object[] finderArgs = new Object[] { nextapprove };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

			boolean bindNextapprove = false;

			if (nextapprove == null) {
				query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_1);
			}
			else if (nextapprove.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_3);
			}
			else {
				bindNextapprove = true;

				query.append(_FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNextapprove) {
					qPos.add(nextapprove);
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

	private static final String _FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_1 = "wfms_Requisition.nextapprove IS NULL";
	private static final String _FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_2 = "wfms_Requisition.nextapprove LIKE ?";
	private static final String _FINDER_COLUMN_NEXTAPPROVE_NEXTAPPROVE_3 = "(wfms_Requisition.nextapprove IS NULL OR wfms_Requisition.nextapprove LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEOFAPPROVER =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRoleOfApprover",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER =
		new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED,
			WFMS_RequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleOfApprover",
			new String[] { String.class.getName() },
			WFMS_RequisitionModelImpl.ROLEOFAPPROVER_COLUMN_BITMASK |
			WFMS_RequisitionModelImpl.RID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEOFAPPROVER = new FinderPath(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleOfApprover",
			new String[] { String.class.getName() });

	/**
	 * Returns all the WFMS_Requisitions where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @return the matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByRoleOfApprover(String roleOfApprover) {
		return findByRoleOfApprover(roleOfApprover, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions where roleOfApprover = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleOfApprover the role of approver
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByRoleOfApprover(String roleOfApprover,
		int start, int end) {
		return findByRoleOfApprover(roleOfApprover, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where roleOfApprover = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleOfApprover the role of approver
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByRoleOfApprover(String roleOfApprover,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findByRoleOfApprover(roleOfApprover, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions where roleOfApprover = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleOfApprover the role of approver
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findByRoleOfApprover(String roleOfApprover,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
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

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WFMS_Requisition wfms_Requisition : list) {
					if (!Objects.equals(roleOfApprover,
								wfms_Requisition.getRoleOfApprover())) {
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

			query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
				query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Returns the first WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByRoleOfApprover_First(String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByRoleOfApprover_First(roleOfApprover,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleOfApprover=");
		msg.append(roleOfApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the first WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByRoleOfApprover_First(String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		List<WFMS_Requisition> list = findByRoleOfApprover(roleOfApprover, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition findByRoleOfApprover_Last(String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByRoleOfApprover_Last(roleOfApprover,
				orderByComparator);

		if (wfms_Requisition != null) {
			return wfms_Requisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleOfApprover=");
		msg.append(roleOfApprover);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWFMS_RequisitionException(msg.toString());
	}

	/**
	 * Returns the last WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	 */
	@Override
	public WFMS_Requisition fetchByRoleOfApprover_Last(String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		int count = countByRoleOfApprover(roleOfApprover);

		if (count == 0) {
			return null;
		}

		List<WFMS_Requisition> list = findByRoleOfApprover(roleOfApprover,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	 *
	 * @param rwfId the primary key of the current WFMS_Requisition
	 * @param roleOfApprover the role of approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition[] findByRoleOfApprover_PrevAndNext(String rwfId,
		String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = findByPrimaryKey(rwfId);

		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition[] array = new WFMS_RequisitionImpl[3];

			array[0] = getByRoleOfApprover_PrevAndNext(session,
					wfms_Requisition, roleOfApprover, orderByComparator, true);

			array[1] = wfms_Requisition;

			array[2] = getByRoleOfApprover_PrevAndNext(session,
					wfms_Requisition, roleOfApprover, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WFMS_Requisition getByRoleOfApprover_PrevAndNext(
		Session session, WFMS_Requisition wfms_Requisition,
		String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE);

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
			query.append(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wfms_Requisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WFMS_Requisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WFMS_Requisitions where roleOfApprover = &#63; from the database.
	 *
	 * @param roleOfApprover the role of approver
	 */
	@Override
	public void removeByRoleOfApprover(String roleOfApprover) {
		for (WFMS_Requisition wfms_Requisition : findByRoleOfApprover(
				roleOfApprover, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions where roleOfApprover = &#63;.
	 *
	 * @param roleOfApprover the role of approver
	 * @return the number of matching WFMS_Requisitions
	 */
	@Override
	public int countByRoleOfApprover(String roleOfApprover) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEOFAPPROVER;

		Object[] finderArgs = new Object[] { roleOfApprover };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_REQUISITION_WHERE);

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

	private static final String _FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_1 = "wfms_Requisition.roleOfApprover IS NULL";
	private static final String _FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_2 = "wfms_Requisition.roleOfApprover = ?";
	private static final String _FINDER_COLUMN_ROLEOFAPPROVER_ROLEOFAPPROVER_3 = "(wfms_Requisition.roleOfApprover IS NULL OR wfms_Requisition.roleOfApprover = '')";

	public WFMS_RequisitionPersistenceImpl() {
		setModelClass(WFMS_Requisition.class);
	}

	/**
	 * Caches the WFMS_Requisition in the entity cache if it is enabled.
	 *
	 * @param wfms_Requisition the WFMS_Requisition
	 */
	@Override
	public void cacheResult(WFMS_Requisition wfms_Requisition) {
		entityCache.putResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, wfms_Requisition.getPrimaryKey(),
			wfms_Requisition);

		finderCache.putResult(FINDER_PATH_FETCH_BY_REQUISITION,
			new Object[] { wfms_Requisition.getRwfId() }, wfms_Requisition);

		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION,
			new Object[] { wfms_Requisition.getRId() }, wfms_Requisition);

		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
			new Object[] {
				wfms_Requisition.getNumber(),
				wfms_Requisition.getAssociatenumber()
			}, wfms_Requisition);

		wfms_Requisition.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_Requisitions in the entity cache if it is enabled.
	 *
	 * @param wfms_Requisitions the WFMS_Requisitions
	 */
	@Override
	public void cacheResult(List<WFMS_Requisition> wfms_Requisitions) {
		for (WFMS_Requisition wfms_Requisition : wfms_Requisitions) {
			if (entityCache.getResult(
						WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_RequisitionImpl.class,
						wfms_Requisition.getPrimaryKey()) == null) {
				cacheResult(wfms_Requisition);
			}
			else {
				wfms_Requisition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_Requisitions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_RequisitionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_Requisition.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_Requisition wfms_Requisition) {
		entityCache.removeResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, wfms_Requisition.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_RequisitionModelImpl)wfms_Requisition,
			true);
	}

	@Override
	public void clearCache(List<WFMS_Requisition> wfms_Requisitions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_Requisition wfms_Requisition : wfms_Requisitions) {
			entityCache.removeResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_RequisitionImpl.class, wfms_Requisition.getPrimaryKey());

			clearUniqueFindersCache((WFMS_RequisitionModelImpl)wfms_Requisition,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_RequisitionModelImpl wfms_RequisitionModelImpl) {
		Object[] args = new Object[] { wfms_RequisitionModelImpl.getRwfId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_REQUISITION, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_REQUISITION, args,
			wfms_RequisitionModelImpl, false);

		args = new Object[] { wfms_RequisitionModelImpl.getRId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_POSITION, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION, args,
			wfms_RequisitionModelImpl, false);

		args = new Object[] {
				wfms_RequisitionModelImpl.getNumber(),
				wfms_RequisitionModelImpl.getAssociatenumber()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_POSITIONASSOCIATE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE, args,
			wfms_RequisitionModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_RequisitionModelImpl wfms_RequisitionModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { wfms_RequisitionModelImpl.getRwfId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUISITION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_REQUISITION, args);
		}

		if ((wfms_RequisitionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REQUISITION.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_RequisitionModelImpl.getOriginalRwfId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUISITION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_REQUISITION, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { wfms_RequisitionModelImpl.getRId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION, args);
		}

		if ((wfms_RequisitionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITION.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_RequisitionModelImpl.getOriginalRId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					wfms_RequisitionModelImpl.getNumber(),
					wfms_RequisitionModelImpl.getAssociatenumber()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONASSOCIATE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
				args);
		}

		if ((wfms_RequisitionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITIONASSOCIATE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_RequisitionModelImpl.getOriginalNumber(),
					wfms_RequisitionModelImpl.getOriginalAssociatenumber()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONASSOCIATE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITIONASSOCIATE,
				args);
		}
	}

	/**
	 * Creates a new WFMS_Requisition with the primary key. Does not add the WFMS_Requisition to the database.
	 *
	 * @param rwfId the primary key for the new WFMS_Requisition
	 * @return the new WFMS_Requisition
	 */
	@Override
	public WFMS_Requisition create(String rwfId) {
		WFMS_Requisition wfms_Requisition = new WFMS_RequisitionImpl();

		wfms_Requisition.setNew(true);
		wfms_Requisition.setPrimaryKey(rwfId);

		wfms_Requisition.setCompanyId(companyProvider.getCompanyId());

		return wfms_Requisition;
	}

	/**
	 * Removes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rwfId the primary key of the WFMS_Requisition
	 * @return the WFMS_Requisition that was removed
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition remove(String rwfId)
		throws NoSuchWFMS_RequisitionException {
		return remove((Serializable)rwfId);
	}

	/**
	 * Removes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_Requisition
	 * @return the WFMS_Requisition that was removed
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition remove(Serializable primaryKey)
		throws NoSuchWFMS_RequisitionException {
		Session session = null;

		try {
			session = openSession();

			WFMS_Requisition wfms_Requisition = (WFMS_Requisition)session.get(WFMS_RequisitionImpl.class,
					primaryKey);

			if (wfms_Requisition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_RequisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_Requisition);
		}
		catch (NoSuchWFMS_RequisitionException nsee) {
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
	protected WFMS_Requisition removeImpl(WFMS_Requisition wfms_Requisition) {
		wfms_Requisition = toUnwrappedModel(wfms_Requisition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_Requisition)) {
				wfms_Requisition = (WFMS_Requisition)session.get(WFMS_RequisitionImpl.class,
						wfms_Requisition.getPrimaryKeyObj());
			}

			if (wfms_Requisition != null) {
				session.delete(wfms_Requisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_Requisition != null) {
			clearCache(wfms_Requisition);
		}

		return wfms_Requisition;
	}

	@Override
	public WFMS_Requisition updateImpl(WFMS_Requisition wfms_Requisition) {
		wfms_Requisition = toUnwrappedModel(wfms_Requisition);

		boolean isNew = wfms_Requisition.isNew();

		WFMS_RequisitionModelImpl wfms_RequisitionModelImpl = (WFMS_RequisitionModelImpl)wfms_Requisition;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_Requisition.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_Requisition.setCreateDate(now);
			}
			else {
				wfms_Requisition.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wfms_RequisitionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_Requisition.setModifiedDate(now);
			}
			else {
				wfms_Requisition.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_Requisition.isNew()) {
				session.save(wfms_Requisition);

				wfms_Requisition.setNew(false);
			}
			else {
				wfms_Requisition = (WFMS_Requisition)session.merge(wfms_Requisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_RequisitionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					wfms_RequisitionModelImpl.getStatus(),
					wfms_RequisitionModelImpl.getRId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS_PID_COLLLECTION,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION,
				args);

			args = new Object[] { wfms_RequisitionModelImpl.getNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONNUMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONNUMBER,
				args);

			args = new Object[] { wfms_RequisitionModelImpl.getRId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
				args);

			args = new Object[] { wfms_RequisitionModelImpl.getStatus() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
				args);

			args = new Object[] { wfms_RequisitionModelImpl.getDummy() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DUMMY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY,
				args);

			args = new Object[] { wfms_RequisitionModelImpl.getWorkflowId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID,
				args);

			args = new Object[] { wfms_RequisitionModelImpl.getRoleOfApprover() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEOFAPPROVER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalStatus(),
						wfms_RequisitionModelImpl.getOriginalRId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS_PID_COLLLECTION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION,
					args);

				args = new Object[] {
						wfms_RequisitionModelImpl.getStatus(),
						wfms_RequisitionModelImpl.getRId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS_PID_COLLLECTION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS_PID_COLLLECTION,
					args);
			}

			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONNUMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONNUMBER,
					args);

				args = new Object[] { wfms_RequisitionModelImpl.getNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONNUMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONNUMBER,
					args);
			}

			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalRId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
					args);

				args = new Object[] { wfms_RequisitionModelImpl.getRId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
					args);
			}

			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
					args);

				args = new Object[] { wfms_RequisitionModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDGETBYSTAUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONIDGETBYSTAUS,
					args);
			}

			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalDummy()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DUMMY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY,
					args);

				args = new Object[] { wfms_RequisitionModelImpl.getDummy() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DUMMY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DUMMY,
					args);
			}

			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalWorkflowId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID,
					args);

				args = new Object[] { wfms_RequisitionModelImpl.getWorkflowId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWID,
					args);
			}

			if ((wfms_RequisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wfms_RequisitionModelImpl.getOriginalRoleOfApprover()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEOFAPPROVER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER,
					args);

				args = new Object[] {
						wfms_RequisitionModelImpl.getRoleOfApprover()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEOFAPPROVER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEOFAPPROVER,
					args);
			}
		}

		entityCache.putResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_RequisitionImpl.class, wfms_Requisition.getPrimaryKey(),
			wfms_Requisition, false);

		clearUniqueFindersCache(wfms_RequisitionModelImpl, false);
		cacheUniqueFindersCache(wfms_RequisitionModelImpl);

		wfms_Requisition.resetOriginalValues();

		return wfms_Requisition;
	}

	protected WFMS_Requisition toUnwrappedModel(
		WFMS_Requisition wfms_Requisition) {
		if (wfms_Requisition instanceof WFMS_RequisitionImpl) {
			return wfms_Requisition;
		}

		WFMS_RequisitionImpl wfms_RequisitionImpl = new WFMS_RequisitionImpl();

		wfms_RequisitionImpl.setNew(wfms_Requisition.isNew());
		wfms_RequisitionImpl.setPrimaryKey(wfms_Requisition.getPrimaryKey());

		wfms_RequisitionImpl.setRwfId(wfms_Requisition.getRwfId());
		wfms_RequisitionImpl.setRId(wfms_Requisition.getRId());
		wfms_RequisitionImpl.setCompanyId(wfms_Requisition.getCompanyId());
		wfms_RequisitionImpl.setScopeGroupId(wfms_Requisition.getScopeGroupId());
		wfms_RequisitionImpl.setCreateDate(wfms_Requisition.getCreateDate());
		wfms_RequisitionImpl.setModifiedDate(wfms_Requisition.getModifiedDate());
		wfms_RequisitionImpl.setApprovedDate(wfms_Requisition.getApprovedDate());
		wfms_RequisitionImpl.setCreatedBy(wfms_Requisition.getCreatedBy());
		wfms_RequisitionImpl.setNumber(wfms_Requisition.getNumber());
		wfms_RequisitionImpl.setAssociatenumber(wfms_Requisition.getAssociatenumber());
		wfms_RequisitionImpl.setAssociatename(wfms_Requisition.getAssociatename());
		wfms_RequisitionImpl.setStatus(wfms_Requisition.getStatus());
		wfms_RequisitionImpl.setPostingType(wfms_Requisition.getPostingType());
		wfms_RequisitionImpl.setTeamNumber(wfms_Requisition.getTeamNumber());
		wfms_RequisitionImpl.setAssociatetype(wfms_Requisition.getAssociatetype());
		wfms_RequisitionImpl.setShiftAssign(wfms_Requisition.getShiftAssign());
		wfms_RequisitionImpl.setHowAvailable(wfms_Requisition.getHowAvailable());
		wfms_RequisitionImpl.setWhoReplaced(wfms_Requisition.getWhoReplaced());
		wfms_RequisitionImpl.setDateneeded(wfms_Requisition.getDateneeded());
		wfms_RequisitionImpl.setContactperson(wfms_Requisition.getContactperson());
		wfms_RequisitionImpl.setContactphonenumber(wfms_Requisition.getContactphonenumber());
		wfms_RequisitionImpl.setTaleonumber(wfms_Requisition.getTaleonumber());
		wfms_RequisitionImpl.setOther(wfms_Requisition.getOther());
		wfms_RequisitionImpl.setComments(wfms_Requisition.getComments());
		wfms_RequisitionImpl.setDeleteflagStatus(wfms_Requisition.getDeleteflagStatus());
		wfms_RequisitionImpl.setDummy(wfms_Requisition.getDummy());
		wfms_RequisitionImpl.setWorkflowId(wfms_Requisition.getWorkflowId());
		wfms_RequisitionImpl.setNextapprove(wfms_Requisition.getNextapprove());
		wfms_RequisitionImpl.setRoleOfApprover(wfms_Requisition.getRoleOfApprover());
		wfms_RequisitionImpl.setRelatesTo(wfms_Requisition.getRelatesTo());
		wfms_RequisitionImpl.setWorkflow(wfms_Requisition.getWorkflow());
		wfms_RequisitionImpl.setWorkflowStep(wfms_Requisition.getWorkflowStep());
		wfms_RequisitionImpl.setApproverStep(wfms_Requisition.getApproverStep());
		wfms_RequisitionImpl.setRefReqId(wfms_Requisition.getRefReqId());
		wfms_RequisitionImpl.setDisapproveComments(wfms_Requisition.getDisapproveComments());

		return wfms_RequisitionImpl;
	}

	/**
	 * Returns the WFMS_Requisition with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Requisition
	 * @return the WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_RequisitionException {
		WFMS_Requisition wfms_Requisition = fetchByPrimaryKey(primaryKey);

		if (wfms_Requisition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_RequisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_Requisition;
	}

	/**
	 * Returns the WFMS_Requisition with the primary key or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	 *
	 * @param rwfId the primary key of the WFMS_Requisition
	 * @return the WFMS_Requisition
	 * @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition findByPrimaryKey(String rwfId)
		throws NoSuchWFMS_RequisitionException {
		return findByPrimaryKey((Serializable)rwfId);
	}

	/**
	 * Returns the WFMS_Requisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Requisition
	 * @return the WFMS_Requisition, or <code>null</code> if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_RequisitionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_Requisition wfms_Requisition = (WFMS_Requisition)serializable;

		if (wfms_Requisition == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_Requisition = (WFMS_Requisition)session.get(WFMS_RequisitionImpl.class,
						primaryKey);

				if (wfms_Requisition != null) {
					cacheResult(wfms_Requisition);
				}
				else {
					entityCache.putResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_RequisitionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_RequisitionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_Requisition;
	}

	/**
	 * Returns the WFMS_Requisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rwfId the primary key of the WFMS_Requisition
	 * @return the WFMS_Requisition, or <code>null</code> if a WFMS_Requisition with the primary key could not be found
	 */
	@Override
	public WFMS_Requisition fetchByPrimaryKey(String rwfId) {
		return fetchByPrimaryKey((Serializable)rwfId);
	}

	@Override
	public Map<Serializable, WFMS_Requisition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_Requisition> map = new HashMap<Serializable, WFMS_Requisition>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_Requisition wfms_Requisition = fetchByPrimaryKey(primaryKey);

			if (wfms_Requisition != null) {
				map.put(primaryKey, wfms_Requisition);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_RequisitionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_Requisition)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_REQUISITION_WHERE_PKS_IN);

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

			for (WFMS_Requisition wfms_Requisition : (List<WFMS_Requisition>)q.list()) {
				map.put(wfms_Requisition.getPrimaryKeyObj(), wfms_Requisition);

				cacheResult(wfms_Requisition);

				uncachedPrimaryKeys.remove(wfms_Requisition.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_RequisitionModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_RequisitionImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_Requisitions.
	 *
	 * @return the WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @return the range of WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findAll(int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Requisitions
	 * @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_Requisitions
	 */
	@Override
	public List<WFMS_Requisition> findAll(int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
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

		List<WFMS_Requisition> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Requisition>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_REQUISITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_REQUISITION;

				if (pagination) {
					sql = sql.concat(WFMS_RequisitionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Requisition>)QueryUtil.list(q,
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
	 * Removes all the WFMS_Requisitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_Requisition wfms_Requisition : findAll()) {
			remove(wfms_Requisition);
		}
	}

	/**
	 * Returns the number of WFMS_Requisitions.
	 *
	 * @return the number of WFMS_Requisitions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_REQUISITION);

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
		return WFMS_RequisitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_Requisition persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_RequisitionImpl.class.getName());
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
	private static final String _SQL_SELECT_WFMS_REQUISITION = "SELECT wfms_Requisition FROM WFMS_Requisition wfms_Requisition";
	private static final String _SQL_SELECT_WFMS_REQUISITION_WHERE_PKS_IN = "SELECT wfms_Requisition FROM WFMS_Requisition wfms_Requisition WHERE rwfId IN (";
	private static final String _SQL_SELECT_WFMS_REQUISITION_WHERE = "SELECT wfms_Requisition FROM WFMS_Requisition wfms_Requisition WHERE ";
	private static final String _SQL_COUNT_WFMS_REQUISITION = "SELECT COUNT(wfms_Requisition) FROM WFMS_Requisition wfms_Requisition";
	private static final String _SQL_COUNT_WFMS_REQUISITION_WHERE = "SELECT COUNT(wfms_Requisition) FROM WFMS_Requisition wfms_Requisition WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_Requisition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_Requisition exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_Requisition exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_RequisitionPersistenceImpl.class);
}