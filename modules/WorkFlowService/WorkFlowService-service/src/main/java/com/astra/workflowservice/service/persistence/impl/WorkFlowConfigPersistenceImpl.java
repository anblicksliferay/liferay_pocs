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

package com.astra.workflowservice.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.workflowservice.exception.NoSuchWorkFlowConfigException;
import com.astra.workflowservice.model.WorkFlowConfig;
import com.astra.workflowservice.model.impl.WorkFlowConfigImpl;
import com.astra.workflowservice.model.impl.WorkFlowConfigModelImpl;
import com.astra.workflowservice.service.persistence.WorkFlowConfigPersistence;

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
 * The persistence implementation for the work flow config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFlowConfigPersistence
 * @see com.astra.workflowservice.service.persistence.WorkFlowConfigUtil
 * @generated
 */
@ProviderType
public class WorkFlowConfigPersistenceImpl extends BasePersistenceImpl<WorkFlowConfig>
	implements WorkFlowConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkFlowConfigUtil} to access the work flow config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkFlowConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED,
			WorkFlowConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED,
			WorkFlowConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED,
			WorkFlowConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED,
			WorkFlowConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			WorkFlowConfigModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the work flow configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work flow configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @return the range of matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work flow configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid(String uuid, int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work flow configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid(String uuid, int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator,
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

		List<WorkFlowConfig> list = null;

		if (retrieveFromCache) {
			list = (List<WorkFlowConfig>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFlowConfig workFlowConfig : list) {
					if (!Objects.equals(uuid, workFlowConfig.getUuid())) {
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

			query.append(_SQL_SELECT_WORKFLOWCONFIG_WHERE);

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
				query.append(WorkFlowConfigModelImpl.ORDER_BY_JPQL);
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
					list = (List<WorkFlowConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkFlowConfig>)QueryUtil.list(q,
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
	 * Returns the first work flow config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work flow config
	 * @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig findByUuid_First(String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = fetchByUuid_First(uuid,
				orderByComparator);

		if (workFlowConfig != null) {
			return workFlowConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkFlowConfigException(msg.toString());
	}

	/**
	 * Returns the first work flow config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work flow config, or <code>null</code> if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig fetchByUuid_First(String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		List<WorkFlowConfig> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work flow config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work flow config
	 * @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig findByUuid_Last(String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = fetchByUuid_Last(uuid, orderByComparator);

		if (workFlowConfig != null) {
			return workFlowConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkFlowConfigException(msg.toString());
	}

	/**
	 * Returns the last work flow config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work flow config, or <code>null</code> if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig fetchByUuid_Last(String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkFlowConfig> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work flow configs before and after the current work flow config in the ordered set where uuid = &#63;.
	 *
	 * @param WfcId the primary key of the current work flow config
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work flow config
	 * @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig[] findByUuid_PrevAndNext(long WfcId, String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = findByPrimaryKey(WfcId);

		Session session = null;

		try {
			session = openSession();

			WorkFlowConfig[] array = new WorkFlowConfigImpl[3];

			array[0] = getByUuid_PrevAndNext(session, workFlowConfig, uuid,
					orderByComparator, true);

			array[1] = workFlowConfig;

			array[2] = getByUuid_PrevAndNext(session, workFlowConfig, uuid,
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

	protected WorkFlowConfig getByUuid_PrevAndNext(Session session,
		WorkFlowConfig workFlowConfig, String uuid,
		OrderByComparator<WorkFlowConfig> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKFLOWCONFIG_WHERE);

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
			query.append(WorkFlowConfigModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(workFlowConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkFlowConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work flow configs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkFlowConfig workFlowConfig : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workFlowConfig);
		}
	}

	/**
	 * Returns the number of work flow configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work flow configs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKFLOWCONFIG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "workFlowConfig.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "workFlowConfig.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(workFlowConfig.uuid IS NULL OR workFlowConfig.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED,
			WorkFlowConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED,
			WorkFlowConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			WorkFlowConfigModelImpl.UUID_COLUMN_BITMASK |
			WorkFlowConfigModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the work flow configs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @return the range of matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<WorkFlowConfig> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work flow configs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator,
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

		List<WorkFlowConfig> list = null;

		if (retrieveFromCache) {
			list = (List<WorkFlowConfig>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFlowConfig workFlowConfig : list) {
					if (!Objects.equals(uuid, workFlowConfig.getUuid()) ||
							(companyId != workFlowConfig.getCompanyId())) {
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

			query.append(_SQL_SELECT_WORKFLOWCONFIG_WHERE);

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
				query.append(WorkFlowConfigModelImpl.ORDER_BY_JPQL);
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
					list = (List<WorkFlowConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkFlowConfig>)QueryUtil.list(q,
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
	 * Returns the first work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work flow config
	 * @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (workFlowConfig != null) {
			return workFlowConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkFlowConfigException(msg.toString());
	}

	/**
	 * Returns the first work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work flow config, or <code>null</code> if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		List<WorkFlowConfig> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work flow config
	 * @throws NoSuchWorkFlowConfigException if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (workFlowConfig != null) {
			return workFlowConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkFlowConfigException(msg.toString());
	}

	/**
	 * Returns the last work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work flow config, or <code>null</code> if a matching work flow config could not be found
	 */
	@Override
	public WorkFlowConfig fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<WorkFlowConfig> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work flow configs before and after the current work flow config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param WfcId the primary key of the current work flow config
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work flow config
	 * @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig[] findByUuid_C_PrevAndNext(long WfcId, String uuid,
		long companyId, OrderByComparator<WorkFlowConfig> orderByComparator)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = findByPrimaryKey(WfcId);

		Session session = null;

		try {
			session = openSession();

			WorkFlowConfig[] array = new WorkFlowConfigImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, workFlowConfig, uuid,
					companyId, orderByComparator, true);

			array[1] = workFlowConfig;

			array[2] = getByUuid_C_PrevAndNext(session, workFlowConfig, uuid,
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

	protected WorkFlowConfig getByUuid_C_PrevAndNext(Session session,
		WorkFlowConfig workFlowConfig, String uuid, long companyId,
		OrderByComparator<WorkFlowConfig> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WORKFLOWCONFIG_WHERE);

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
			query.append(WorkFlowConfigModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(workFlowConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkFlowConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work flow configs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (WorkFlowConfig workFlowConfig : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workFlowConfig);
		}
	}

	/**
	 * Returns the number of work flow configs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work flow configs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WORKFLOWCONFIG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "workFlowConfig.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "workFlowConfig.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(workFlowConfig.uuid IS NULL OR workFlowConfig.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "workFlowConfig.companyId = ?";

	public WorkFlowConfigPersistenceImpl() {
		setModelClass(WorkFlowConfig.class);

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
	 * Caches the work flow config in the entity cache if it is enabled.
	 *
	 * @param workFlowConfig the work flow config
	 */
	@Override
	public void cacheResult(WorkFlowConfig workFlowConfig) {
		entityCache.putResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigImpl.class, workFlowConfig.getPrimaryKey(),
			workFlowConfig);

		workFlowConfig.resetOriginalValues();
	}

	/**
	 * Caches the work flow configs in the entity cache if it is enabled.
	 *
	 * @param workFlowConfigs the work flow configs
	 */
	@Override
	public void cacheResult(List<WorkFlowConfig> workFlowConfigs) {
		for (WorkFlowConfig workFlowConfig : workFlowConfigs) {
			if (entityCache.getResult(
						WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
						WorkFlowConfigImpl.class, workFlowConfig.getPrimaryKey()) == null) {
				cacheResult(workFlowConfig);
			}
			else {
				workFlowConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all work flow configs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkFlowConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work flow config.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkFlowConfig workFlowConfig) {
		entityCache.removeResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigImpl.class, workFlowConfig.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkFlowConfig> workFlowConfigs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkFlowConfig workFlowConfig : workFlowConfigs) {
			entityCache.removeResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
				WorkFlowConfigImpl.class, workFlowConfig.getPrimaryKey());
		}
	}

	/**
	 * Creates a new work flow config with the primary key. Does not add the work flow config to the database.
	 *
	 * @param WfcId the primary key for the new work flow config
	 * @return the new work flow config
	 */
	@Override
	public WorkFlowConfig create(long WfcId) {
		WorkFlowConfig workFlowConfig = new WorkFlowConfigImpl();

		workFlowConfig.setNew(true);
		workFlowConfig.setPrimaryKey(WfcId);

		String uuid = PortalUUIDUtil.generate();

		workFlowConfig.setUuid(uuid);

		workFlowConfig.setCompanyId(companyProvider.getCompanyId());

		return workFlowConfig;
	}

	/**
	 * Removes the work flow config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param WfcId the primary key of the work flow config
	 * @return the work flow config that was removed
	 * @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig remove(long WfcId)
		throws NoSuchWorkFlowConfigException {
		return remove((Serializable)WfcId);
	}

	/**
	 * Removes the work flow config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work flow config
	 * @return the work flow config that was removed
	 * @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig remove(Serializable primaryKey)
		throws NoSuchWorkFlowConfigException {
		Session session = null;

		try {
			session = openSession();

			WorkFlowConfig workFlowConfig = (WorkFlowConfig)session.get(WorkFlowConfigImpl.class,
					primaryKey);

			if (workFlowConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkFlowConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workFlowConfig);
		}
		catch (NoSuchWorkFlowConfigException nsee) {
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
	protected WorkFlowConfig removeImpl(WorkFlowConfig workFlowConfig) {
		workFlowConfig = toUnwrappedModel(workFlowConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workFlowConfig)) {
				workFlowConfig = (WorkFlowConfig)session.get(WorkFlowConfigImpl.class,
						workFlowConfig.getPrimaryKeyObj());
			}

			if (workFlowConfig != null) {
				session.delete(workFlowConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workFlowConfig != null) {
			clearCache(workFlowConfig);
		}

		return workFlowConfig;
	}

	@Override
	public WorkFlowConfig updateImpl(WorkFlowConfig workFlowConfig) {
		workFlowConfig = toUnwrappedModel(workFlowConfig);

		boolean isNew = workFlowConfig.isNew();

		WorkFlowConfigModelImpl workFlowConfigModelImpl = (WorkFlowConfigModelImpl)workFlowConfig;

		if (Validator.isNull(workFlowConfig.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workFlowConfig.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (workFlowConfig.getCreateDate() == null)) {
			if (serviceContext == null) {
				workFlowConfig.setCreateDate(now);
			}
			else {
				workFlowConfig.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!workFlowConfigModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workFlowConfig.setModifiedDate(now);
			}
			else {
				workFlowConfig.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (workFlowConfig.isNew()) {
				session.save(workFlowConfig);

				workFlowConfig.setNew(false);
			}
			else {
				workFlowConfig = (WorkFlowConfig)session.merge(workFlowConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WorkFlowConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { workFlowConfigModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					workFlowConfigModelImpl.getUuid(),
					workFlowConfigModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((workFlowConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workFlowConfigModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { workFlowConfigModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((workFlowConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workFlowConfigModelImpl.getOriginalUuid(),
						workFlowConfigModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						workFlowConfigModelImpl.getUuid(),
						workFlowConfigModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WorkFlowConfigImpl.class, workFlowConfig.getPrimaryKey(),
			workFlowConfig, false);

		workFlowConfig.resetOriginalValues();

		return workFlowConfig;
	}

	protected WorkFlowConfig toUnwrappedModel(WorkFlowConfig workFlowConfig) {
		if (workFlowConfig instanceof WorkFlowConfigImpl) {
			return workFlowConfig;
		}

		WorkFlowConfigImpl workFlowConfigImpl = new WorkFlowConfigImpl();

		workFlowConfigImpl.setNew(workFlowConfig.isNew());
		workFlowConfigImpl.setPrimaryKey(workFlowConfig.getPrimaryKey());

		workFlowConfigImpl.setUuid(workFlowConfig.getUuid());
		workFlowConfigImpl.setWfcId(workFlowConfig.getWfcId());
		workFlowConfigImpl.setConfigKey(workFlowConfig.getConfigKey());
		workFlowConfigImpl.setContent(workFlowConfig.getContent());
		workFlowConfigImpl.setCompanyId(workFlowConfig.getCompanyId());
		workFlowConfigImpl.setUserId(workFlowConfig.getUserId());
		workFlowConfigImpl.setUserName(workFlowConfig.getUserName());
		workFlowConfigImpl.setCreateDate(workFlowConfig.getCreateDate());
		workFlowConfigImpl.setModifiedDate(workFlowConfig.getModifiedDate());

		return workFlowConfigImpl;
	}

	/**
	 * Returns the work flow config with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the work flow config
	 * @return the work flow config
	 * @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkFlowConfigException {
		WorkFlowConfig workFlowConfig = fetchByPrimaryKey(primaryKey);

		if (workFlowConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkFlowConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workFlowConfig;
	}

	/**
	 * Returns the work flow config with the primary key or throws a {@link NoSuchWorkFlowConfigException} if it could not be found.
	 *
	 * @param WfcId the primary key of the work flow config
	 * @return the work flow config
	 * @throws NoSuchWorkFlowConfigException if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig findByPrimaryKey(long WfcId)
		throws NoSuchWorkFlowConfigException {
		return findByPrimaryKey((Serializable)WfcId);
	}

	/**
	 * Returns the work flow config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work flow config
	 * @return the work flow config, or <code>null</code> if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
				WorkFlowConfigImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WorkFlowConfig workFlowConfig = (WorkFlowConfig)serializable;

		if (workFlowConfig == null) {
			Session session = null;

			try {
				session = openSession();

				workFlowConfig = (WorkFlowConfig)session.get(WorkFlowConfigImpl.class,
						primaryKey);

				if (workFlowConfig != null) {
					cacheResult(workFlowConfig);
				}
				else {
					entityCache.putResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
						WorkFlowConfigImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
					WorkFlowConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workFlowConfig;
	}

	/**
	 * Returns the work flow config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param WfcId the primary key of the work flow config
	 * @return the work flow config, or <code>null</code> if a work flow config with the primary key could not be found
	 */
	@Override
	public WorkFlowConfig fetchByPrimaryKey(long WfcId) {
		return fetchByPrimaryKey((Serializable)WfcId);
	}

	@Override
	public Map<Serializable, WorkFlowConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WorkFlowConfig> map = new HashMap<Serializable, WorkFlowConfig>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WorkFlowConfig workFlowConfig = fetchByPrimaryKey(primaryKey);

			if (workFlowConfig != null) {
				map.put(primaryKey, workFlowConfig);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
					WorkFlowConfigImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WorkFlowConfig)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORKFLOWCONFIG_WHERE_PKS_IN);

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

			for (WorkFlowConfig workFlowConfig : (List<WorkFlowConfig>)q.list()) {
				map.put(workFlowConfig.getPrimaryKeyObj(), workFlowConfig);

				cacheResult(workFlowConfig);

				uncachedPrimaryKeys.remove(workFlowConfig.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WorkFlowConfigModelImpl.ENTITY_CACHE_ENABLED,
					WorkFlowConfigImpl.class, primaryKey, nullModel);
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
	 * Returns all the work flow configs.
	 *
	 * @return the work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work flow configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @return the range of work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work flow configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findAll(int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work flow configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFlowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work flow configs
	 * @param end the upper bound of the range of work flow configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of work flow configs
	 */
	@Override
	public List<WorkFlowConfig> findAll(int start, int end,
		OrderByComparator<WorkFlowConfig> orderByComparator,
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

		List<WorkFlowConfig> list = null;

		if (retrieveFromCache) {
			list = (List<WorkFlowConfig>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORKFLOWCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFLOWCONFIG;

				if (pagination) {
					sql = sql.concat(WorkFlowConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkFlowConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkFlowConfig>)QueryUtil.list(q,
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
	 * Removes all the work flow configs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkFlowConfig workFlowConfig : findAll()) {
			remove(workFlowConfig);
		}
	}

	/**
	 * Returns the number of work flow configs.
	 *
	 * @return the number of work flow configs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKFLOWCONFIG);

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
		return WorkFlowConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work flow config persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WorkFlowConfigImpl.class.getName());
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
	private static final String _SQL_SELECT_WORKFLOWCONFIG = "SELECT workFlowConfig FROM WorkFlowConfig workFlowConfig";
	private static final String _SQL_SELECT_WORKFLOWCONFIG_WHERE_PKS_IN = "SELECT workFlowConfig FROM WorkFlowConfig workFlowConfig WHERE WfcId IN (";
	private static final String _SQL_SELECT_WORKFLOWCONFIG_WHERE = "SELECT workFlowConfig FROM WorkFlowConfig workFlowConfig WHERE ";
	private static final String _SQL_COUNT_WORKFLOWCONFIG = "SELECT COUNT(workFlowConfig) FROM WorkFlowConfig workFlowConfig";
	private static final String _SQL_COUNT_WORKFLOWCONFIG_WHERE = "SELECT COUNT(workFlowConfig) FROM WorkFlowConfig workFlowConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workFlowConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkFlowConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkFlowConfig exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WorkFlowConfigPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}