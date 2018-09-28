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

package com.servicemapping.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.servicemapping.exception.NoSuchregistrationDetailsException;

import com.servicemapping.model.impl.registrationDetailsImpl;
import com.servicemapping.model.impl.registrationDetailsModelImpl;
import com.servicemapping.model.registrationDetails;

import com.servicemapping.service.persistence.coursePersistence;
import com.servicemapping.service.persistence.registrationDetailsPersistence;

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
 * The persistence implementation for the registration details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsPersistence
 * @see com.servicemapping.service.persistence.registrationDetailsUtil
 * @generated
 */
@ProviderType
public class registrationDetailsPersistenceImpl extends BasePersistenceImpl<registrationDetails>
	implements registrationDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link registrationDetailsUtil} to access the registration details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = registrationDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			registrationDetailsModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the registration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @return the range of matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid(String uuid, int start,
		int end, OrderByComparator<registrationDetails> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid(String uuid, int start,
		int end, OrderByComparator<registrationDetails> orderByComparator,
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

		List<registrationDetails> list = null;

		if (retrieveFromCache) {
			list = (List<registrationDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (registrationDetails registrationDetails : list) {
					if (!Objects.equals(uuid, registrationDetails.getUuid())) {
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

			query.append(_SQL_SELECT_REGISTRATIONDETAILS_WHERE);

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
				query.append(registrationDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<registrationDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<registrationDetails>)QueryUtil.list(q,
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
	 * Returns the first registration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration details
	 * @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	 */
	@Override
	public registrationDetails findByUuid_First(String uuid,
		OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = fetchByUuid_First(uuid,
				orderByComparator);

		if (registrationDetails != null) {
			return registrationDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchregistrationDetailsException(msg.toString());
	}

	/**
	 * Returns the first registration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration details, or <code>null</code> if a matching registration details could not be found
	 */
	@Override
	public registrationDetails fetchByUuid_First(String uuid,
		OrderByComparator<registrationDetails> orderByComparator) {
		List<registrationDetails> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration details
	 * @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	 */
	@Override
	public registrationDetails findByUuid_Last(String uuid,
		OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = fetchByUuid_Last(uuid,
				orderByComparator);

		if (registrationDetails != null) {
			return registrationDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchregistrationDetailsException(msg.toString());
	}

	/**
	 * Returns the last registration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration details, or <code>null</code> if a matching registration details could not be found
	 */
	@Override
	public registrationDetails fetchByUuid_Last(String uuid,
		OrderByComparator<registrationDetails> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<registrationDetails> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration detailses before and after the current registration details in the ordered set where uuid = &#63;.
	 *
	 * @param registrationId the primary key of the current registration details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration details
	 * @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails[] findByUuid_PrevAndNext(long registrationId,
		String uuid, OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = findByPrimaryKey(registrationId);

		Session session = null;

		try {
			session = openSession();

			registrationDetails[] array = new registrationDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, registrationDetails,
					uuid, orderByComparator, true);

			array[1] = registrationDetails;

			array[2] = getByUuid_PrevAndNext(session, registrationDetails,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected registrationDetails getByUuid_PrevAndNext(Session session,
		registrationDetails registrationDetails, String uuid,
		OrderByComparator<registrationDetails> orderByComparator,
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

		query.append(_SQL_SELECT_REGISTRATIONDETAILS_WHERE);

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
			query.append(registrationDetailsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(registrationDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<registrationDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (registrationDetails registrationDetails : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(registrationDetails);
		}
	}

	/**
	 * Returns the number of registration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching registration detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REGISTRATIONDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "registrationDetails.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "registrationDetails.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(registrationDetails.uuid IS NULL OR registrationDetails.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			registrationDetailsModelImpl.UUID_COLUMN_BITMASK |
			registrationDetailsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the registration details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchregistrationDetailsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration details
	 * @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	 */
	@Override
	public registrationDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = fetchByUUID_G(uuid, groupId);

		if (registrationDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchregistrationDetailsException(msg.toString());
		}

		return registrationDetails;
	}

	/**
	 * Returns the registration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	 */
	@Override
	public registrationDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the registration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	 */
	@Override
	public registrationDetails fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof registrationDetails) {
			registrationDetails registrationDetails = (registrationDetails)result;

			if (!Objects.equals(uuid, registrationDetails.getUuid()) ||
					(groupId != registrationDetails.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_REGISTRATIONDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<registrationDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					registrationDetails registrationDetails = list.get(0);

					result = registrationDetails;

					cacheResult(registrationDetails);

					if ((registrationDetails.getUuid() == null) ||
							!registrationDetails.getUuid().equals(uuid) ||
							(registrationDetails.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, registrationDetails);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

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
			return (registrationDetails)result;
		}
	}

	/**
	 * Removes the registration details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the registration details that was removed
	 */
	@Override
	public registrationDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = findByUUID_G(uuid, groupId);

		return remove(registrationDetails);
	}

	/**
	 * Returns the number of registration detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching registration detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_REGISTRATIONDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "registrationDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "registrationDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(registrationDetails.uuid IS NULL OR registrationDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "registrationDetails.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED,
			registrationDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			registrationDetailsModelImpl.UUID_COLUMN_BITMASK |
			registrationDetailsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the registration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @return the range of matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<registrationDetails> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching registration detailses
	 */
	@Override
	public List<registrationDetails> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<registrationDetails> orderByComparator,
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

		List<registrationDetails> list = null;

		if (retrieveFromCache) {
			list = (List<registrationDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (registrationDetails registrationDetails : list) {
					if (!Objects.equals(uuid, registrationDetails.getUuid()) ||
							(companyId != registrationDetails.getCompanyId())) {
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

			query.append(_SQL_SELECT_REGISTRATIONDETAILS_WHERE);

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
				query.append(registrationDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<registrationDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<registrationDetails>)QueryUtil.list(q,
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
	 * Returns the first registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration details
	 * @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	 */
	@Override
	public registrationDetails findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (registrationDetails != null) {
			return registrationDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchregistrationDetailsException(msg.toString());
	}

	/**
	 * Returns the first registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration details, or <code>null</code> if a matching registration details could not be found
	 */
	@Override
	public registrationDetails fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator) {
		List<registrationDetails> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration details
	 * @throws NoSuchregistrationDetailsException if a matching registration details could not be found
	 */
	@Override
	public registrationDetails findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (registrationDetails != null) {
			return registrationDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchregistrationDetailsException(msg.toString());
	}

	/**
	 * Returns the last registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration details, or <code>null</code> if a matching registration details could not be found
	 */
	@Override
	public registrationDetails fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<registrationDetails> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration detailses before and after the current registration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param registrationId the primary key of the current registration details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration details
	 * @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails[] findByUuid_C_PrevAndNext(long registrationId,
		String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = findByPrimaryKey(registrationId);

		Session session = null;

		try {
			session = openSession();

			registrationDetails[] array = new registrationDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, registrationDetails,
					uuid, companyId, orderByComparator, true);

			array[1] = registrationDetails;

			array[2] = getByUuid_C_PrevAndNext(session, registrationDetails,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected registrationDetails getByUuid_C_PrevAndNext(Session session,
		registrationDetails registrationDetails, String uuid, long companyId,
		OrderByComparator<registrationDetails> orderByComparator,
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

		query.append(_SQL_SELECT_REGISTRATIONDETAILS_WHERE);

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
			query.append(registrationDetailsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(registrationDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<registrationDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (registrationDetails registrationDetails : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(registrationDetails);
		}
	}

	/**
	 * Returns the number of registration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching registration detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_REGISTRATIONDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "registrationDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "registrationDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(registrationDetails.uuid IS NULL OR registrationDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "registrationDetails.companyId = ?";

	public registrationDetailsPersistenceImpl() {
		setModelClass(registrationDetails.class);

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
	 * Caches the registration details in the entity cache if it is enabled.
	 *
	 * @param registrationDetails the registration details
	 */
	@Override
	public void cacheResult(registrationDetails registrationDetails) {
		entityCache.putResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsImpl.class, registrationDetails.getPrimaryKey(),
			registrationDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				registrationDetails.getUuid(), registrationDetails.getGroupId()
			}, registrationDetails);

		registrationDetails.resetOriginalValues();
	}

	/**
	 * Caches the registration detailses in the entity cache if it is enabled.
	 *
	 * @param registrationDetailses the registration detailses
	 */
	@Override
	public void cacheResult(List<registrationDetails> registrationDetailses) {
		for (registrationDetails registrationDetails : registrationDetailses) {
			if (entityCache.getResult(
						registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
						registrationDetailsImpl.class,
						registrationDetails.getPrimaryKey()) == null) {
				cacheResult(registrationDetails);
			}
			else {
				registrationDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all registration detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(registrationDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the registration details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(registrationDetails registrationDetails) {
		entityCache.removeResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsImpl.class, registrationDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((registrationDetailsModelImpl)registrationDetails,
			true);
	}

	@Override
	public void clearCache(List<registrationDetails> registrationDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (registrationDetails registrationDetails : registrationDetailses) {
			entityCache.removeResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
				registrationDetailsImpl.class,
				registrationDetails.getPrimaryKey());

			clearUniqueFindersCache((registrationDetailsModelImpl)registrationDetails,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		registrationDetailsModelImpl registrationDetailsModelImpl) {
		Object[] args = new Object[] {
				registrationDetailsModelImpl.getUuid(),
				registrationDetailsModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			registrationDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		registrationDetailsModelImpl registrationDetailsModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					registrationDetailsModelImpl.getUuid(),
					registrationDetailsModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((registrationDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					registrationDetailsModelImpl.getOriginalUuid(),
					registrationDetailsModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new registration details with the primary key. Does not add the registration details to the database.
	 *
	 * @param registrationId the primary key for the new registration details
	 * @return the new registration details
	 */
	@Override
	public registrationDetails create(long registrationId) {
		registrationDetails registrationDetails = new registrationDetailsImpl();

		registrationDetails.setNew(true);
		registrationDetails.setPrimaryKey(registrationId);

		String uuid = PortalUUIDUtil.generate();

		registrationDetails.setUuid(uuid);

		registrationDetails.setCompanyId(companyProvider.getCompanyId());

		return registrationDetails;
	}

	/**
	 * Removes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationId the primary key of the registration details
	 * @return the registration details that was removed
	 * @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails remove(long registrationId)
		throws NoSuchregistrationDetailsException {
		return remove((Serializable)registrationId);
	}

	/**
	 * Removes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the registration details
	 * @return the registration details that was removed
	 * @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails remove(Serializable primaryKey)
		throws NoSuchregistrationDetailsException {
		Session session = null;

		try {
			session = openSession();

			registrationDetails registrationDetails = (registrationDetails)session.get(registrationDetailsImpl.class,
					primaryKey);

			if (registrationDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchregistrationDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(registrationDetails);
		}
		catch (NoSuchregistrationDetailsException nsee) {
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
	protected registrationDetails removeImpl(
		registrationDetails registrationDetails) {
		registrationDetails = toUnwrappedModel(registrationDetails);

		registrationDetailsTocourseTableMapper.deleteLeftPrimaryKeyTableMappings(registrationDetails.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(registrationDetails)) {
				registrationDetails = (registrationDetails)session.get(registrationDetailsImpl.class,
						registrationDetails.getPrimaryKeyObj());
			}

			if (registrationDetails != null) {
				session.delete(registrationDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (registrationDetails != null) {
			clearCache(registrationDetails);
		}

		return registrationDetails;
	}

	@Override
	public registrationDetails updateImpl(
		registrationDetails registrationDetails) {
		registrationDetails = toUnwrappedModel(registrationDetails);

		boolean isNew = registrationDetails.isNew();

		registrationDetailsModelImpl registrationDetailsModelImpl = (registrationDetailsModelImpl)registrationDetails;

		if (Validator.isNull(registrationDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			registrationDetails.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (registrationDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				registrationDetails.setCreateDate(now);
			}
			else {
				registrationDetails.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!registrationDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				registrationDetails.setModifiedDate(now);
			}
			else {
				registrationDetails.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (registrationDetails.isNew()) {
				session.save(registrationDetails);

				registrationDetails.setNew(false);
			}
			else {
				registrationDetails = (registrationDetails)session.merge(registrationDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!registrationDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { registrationDetailsModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					registrationDetailsModelImpl.getUuid(),
					registrationDetailsModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((registrationDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						registrationDetailsModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { registrationDetailsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((registrationDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						registrationDetailsModelImpl.getOriginalUuid(),
						registrationDetailsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						registrationDetailsModelImpl.getUuid(),
						registrationDetailsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
			registrationDetailsImpl.class, registrationDetails.getPrimaryKey(),
			registrationDetails, false);

		clearUniqueFindersCache(registrationDetailsModelImpl, false);
		cacheUniqueFindersCache(registrationDetailsModelImpl);

		registrationDetails.resetOriginalValues();

		return registrationDetails;
	}

	protected registrationDetails toUnwrappedModel(
		registrationDetails registrationDetails) {
		if (registrationDetails instanceof registrationDetailsImpl) {
			return registrationDetails;
		}

		registrationDetailsImpl registrationDetailsImpl = new registrationDetailsImpl();

		registrationDetailsImpl.setNew(registrationDetails.isNew());
		registrationDetailsImpl.setPrimaryKey(registrationDetails.getPrimaryKey());

		registrationDetailsImpl.setUuid(registrationDetails.getUuid());
		registrationDetailsImpl.setRegistrationId(registrationDetails.getRegistrationId());
		registrationDetailsImpl.setFirstName(registrationDetails.getFirstName());
		registrationDetailsImpl.setLastName(registrationDetails.getLastName());
		registrationDetailsImpl.setSurName(registrationDetails.getSurName());
		registrationDetailsImpl.setAddress(registrationDetails.getAddress());
		registrationDetailsImpl.setContactNumber(registrationDetails.getContactNumber());
		registrationDetailsImpl.setGender(registrationDetails.isGender());
		registrationDetailsImpl.setImagepath(registrationDetails.getImagepath());
		registrationDetailsImpl.setGroupId(registrationDetails.getGroupId());
		registrationDetailsImpl.setCompanyId(registrationDetails.getCompanyId());
		registrationDetailsImpl.setUserId(registrationDetails.getUserId());
		registrationDetailsImpl.setUserName(registrationDetails.getUserName());
		registrationDetailsImpl.setCreateDate(registrationDetails.getCreateDate());
		registrationDetailsImpl.setModifiedDate(registrationDetails.getModifiedDate());

		return registrationDetailsImpl;
	}

	/**
	 * Returns the registration details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the registration details
	 * @return the registration details
	 * @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchregistrationDetailsException {
		registrationDetails registrationDetails = fetchByPrimaryKey(primaryKey);

		if (registrationDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchregistrationDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return registrationDetails;
	}

	/**
	 * Returns the registration details with the primary key or throws a {@link NoSuchregistrationDetailsException} if it could not be found.
	 *
	 * @param registrationId the primary key of the registration details
	 * @return the registration details
	 * @throws NoSuchregistrationDetailsException if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails findByPrimaryKey(long registrationId)
		throws NoSuchregistrationDetailsException {
		return findByPrimaryKey((Serializable)registrationId);
	}

	/**
	 * Returns the registration details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the registration details
	 * @return the registration details, or <code>null</code> if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
				registrationDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		registrationDetails registrationDetails = (registrationDetails)serializable;

		if (registrationDetails == null) {
			Session session = null;

			try {
				session = openSession();

				registrationDetails = (registrationDetails)session.get(registrationDetailsImpl.class,
						primaryKey);

				if (registrationDetails != null) {
					cacheResult(registrationDetails);
				}
				else {
					entityCache.putResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
						registrationDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
					registrationDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return registrationDetails;
	}

	/**
	 * Returns the registration details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the registration details
	 * @return the registration details, or <code>null</code> if a registration details with the primary key could not be found
	 */
	@Override
	public registrationDetails fetchByPrimaryKey(long registrationId) {
		return fetchByPrimaryKey((Serializable)registrationId);
	}

	@Override
	public Map<Serializable, registrationDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, registrationDetails> map = new HashMap<Serializable, registrationDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			registrationDetails registrationDetails = fetchByPrimaryKey(primaryKey);

			if (registrationDetails != null) {
				map.put(primaryKey, registrationDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
					registrationDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (registrationDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_REGISTRATIONDETAILS_WHERE_PKS_IN);

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

			for (registrationDetails registrationDetails : (List<registrationDetails>)q.list()) {
				map.put(registrationDetails.getPrimaryKeyObj(),
					registrationDetails);

				cacheResult(registrationDetails);

				uncachedPrimaryKeys.remove(registrationDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(registrationDetailsModelImpl.ENTITY_CACHE_ENABLED,
					registrationDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the registration detailses.
	 *
	 * @return the registration detailses
	 */
	@Override
	public List<registrationDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @return the range of registration detailses
	 */
	@Override
	public List<registrationDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registration detailses
	 */
	@Override
	public List<registrationDetails> findAll(int start, int end,
		OrderByComparator<registrationDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of registration detailses
	 */
	@Override
	public List<registrationDetails> findAll(int start, int end,
		OrderByComparator<registrationDetails> orderByComparator,
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

		List<registrationDetails> list = null;

		if (retrieveFromCache) {
			list = (List<registrationDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REGISTRATIONDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGISTRATIONDETAILS;

				if (pagination) {
					sql = sql.concat(registrationDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<registrationDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<registrationDetails>)QueryUtil.list(q,
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
	 * Removes all the registration detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (registrationDetails registrationDetails : findAll()) {
			remove(registrationDetails);
		}
	}

	/**
	 * Returns the number of registration detailses.
	 *
	 * @return the number of registration detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REGISTRATIONDETAILS);

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

	/**
	 * Returns the primaryKeys of courses associated with the registration details.
	 *
	 * @param pk the primary key of the registration details
	 * @return long[] of the primaryKeys of courses associated with the registration details
	 */
	@Override
	public long[] getcoursePrimaryKeys(long pk) {
		long[] pks = registrationDetailsTocourseTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the courses associated with the registration details.
	 *
	 * @param pk the primary key of the registration details
	 * @return the courses associated with the registration details
	 */
	@Override
	public List<com.servicemapping.model.course> getcourses(long pk) {
		return getcourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the courses associated with the registration details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the registration details
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @return the range of courses associated with the registration details
	 */
	@Override
	public List<com.servicemapping.model.course> getcourses(long pk, int start,
		int end) {
		return getcourses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the courses associated with the registration details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the registration details
	 * @param start the lower bound of the range of registration detailses
	 * @param end the upper bound of the range of registration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of courses associated with the registration details
	 */
	@Override
	public List<com.servicemapping.model.course> getcourses(long pk, int start,
		int end,
		OrderByComparator<com.servicemapping.model.course> orderByComparator) {
		return registrationDetailsTocourseTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of courses associated with the registration details.
	 *
	 * @param pk the primary key of the registration details
	 * @return the number of courses associated with the registration details
	 */
	@Override
	public int getcoursesSize(long pk) {
		long[] pks = registrationDetailsTocourseTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the course is associated with the registration details.
	 *
	 * @param pk the primary key of the registration details
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the registration details; <code>false</code> otherwise
	 */
	@Override
	public boolean containscourse(long pk, long coursePK) {
		return registrationDetailsTocourseTableMapper.containsTableMapping(pk,
			coursePK);
	}

	/**
	 * Returns <code>true</code> if the registration details has any courses associated with it.
	 *
	 * @param pk the primary key of the registration details to check for associations with courses
	 * @return <code>true</code> if the registration details has any courses associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containscourses(long pk) {
		if (getcoursesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param coursePK the primary key of the course
	 */
	@Override
	public void addcourse(long pk, long coursePK) {
		registrationDetails registrationDetails = fetchByPrimaryKey(pk);

		if (registrationDetails == null) {
			registrationDetailsTocourseTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, coursePK);
		}
		else {
			registrationDetailsTocourseTableMapper.addTableMapping(registrationDetails.getCompanyId(),
				pk, coursePK);
		}
	}

	/**
	 * Adds an association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param course the course
	 */
	@Override
	public void addcourse(long pk, com.servicemapping.model.course course) {
		registrationDetails registrationDetails = fetchByPrimaryKey(pk);

		if (registrationDetails == null) {
			registrationDetailsTocourseTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, course.getPrimaryKey());
		}
		else {
			registrationDetailsTocourseTableMapper.addTableMapping(registrationDetails.getCompanyId(),
				pk, course.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param coursePKs the primary keys of the courses
	 */
	@Override
	public void addcourses(long pk, long[] coursePKs) {
		long companyId = 0;

		registrationDetails registrationDetails = fetchByPrimaryKey(pk);

		if (registrationDetails == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = registrationDetails.getCompanyId();
		}

		registrationDetailsTocourseTableMapper.addTableMappings(companyId, pk,
			coursePKs);
	}

	/**
	 * Adds an association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param courses the courses
	 */
	@Override
	public void addcourses(long pk,
		List<com.servicemapping.model.course> courses) {
		addcourses(pk,
			ListUtil.toLongArray(courses,
				com.servicemapping.model.course.COURSE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the registration details and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details to clear the associated courses from
	 */
	@Override
	public void clearcourses(long pk) {
		registrationDetailsTocourseTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param coursePK the primary key of the course
	 */
	@Override
	public void removecourse(long pk, long coursePK) {
		registrationDetailsTocourseTableMapper.deleteTableMapping(pk, coursePK);
	}

	/**
	 * Removes the association between the registration details and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param course the course
	 */
	@Override
	public void removecourse(long pk, com.servicemapping.model.course course) {
		registrationDetailsTocourseTableMapper.deleteTableMapping(pk,
			course.getPrimaryKey());
	}

	/**
	 * Removes the association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param coursePKs the primary keys of the courses
	 */
	@Override
	public void removecourses(long pk, long[] coursePKs) {
		registrationDetailsTocourseTableMapper.deleteTableMappings(pk, coursePKs);
	}

	/**
	 * Removes the association between the registration details and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param courses the courses
	 */
	@Override
	public void removecourses(long pk,
		List<com.servicemapping.model.course> courses) {
		removecourses(pk,
			ListUtil.toLongArray(courses,
				com.servicemapping.model.course.COURSE_ID_ACCESSOR));
	}

	/**
	 * Sets the courses associated with the registration details, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param coursePKs the primary keys of the courses to be associated with the registration details
	 */
	@Override
	public void setcourses(long pk, long[] coursePKs) {
		Set<Long> newcoursePKsSet = SetUtil.fromArray(coursePKs);
		Set<Long> oldcoursePKsSet = SetUtil.fromArray(registrationDetailsTocourseTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removecoursePKsSet = new HashSet<Long>(oldcoursePKsSet);

		removecoursePKsSet.removeAll(newcoursePKsSet);

		registrationDetailsTocourseTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removecoursePKsSet));

		newcoursePKsSet.removeAll(oldcoursePKsSet);

		long companyId = 0;

		registrationDetails registrationDetails = fetchByPrimaryKey(pk);

		if (registrationDetails == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = registrationDetails.getCompanyId();
		}

		registrationDetailsTocourseTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newcoursePKsSet));
	}

	/**
	 * Sets the courses associated with the registration details, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the registration details
	 * @param courses the courses to be associated with the registration details
	 */
	@Override
	public void setcourses(long pk,
		List<com.servicemapping.model.course> courses) {
		try {
			long[] coursePKs = new long[courses.size()];

			for (int i = 0; i < courses.size(); i++) {
				com.servicemapping.model.course course = courses.get(i);

				coursePKs[i] = course.getPrimaryKey();
			}

			setcourses(pk, coursePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return registrationDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the registration details persistence.
	 */
	public void afterPropertiesSet() {
		registrationDetailsTocourseTableMapper = TableMapperFactory.getTableMapper("DDTI_registrationDetails_course",
				"companyId", "registrationId", "courseId", this,
				coursePersistence);
	}

	public void destroy() {
		entityCache.removeCache(registrationDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("DDTI_registrationDetails_course");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = coursePersistence.class)
	protected coursePersistence coursePersistence;
	protected TableMapper<registrationDetails, com.servicemapping.model.course> registrationDetailsTocourseTableMapper;
	private static final String _SQL_SELECT_REGISTRATIONDETAILS = "SELECT registrationDetails FROM registrationDetails registrationDetails";
	private static final String _SQL_SELECT_REGISTRATIONDETAILS_WHERE_PKS_IN = "SELECT registrationDetails FROM registrationDetails registrationDetails WHERE registrationId IN (";
	private static final String _SQL_SELECT_REGISTRATIONDETAILS_WHERE = "SELECT registrationDetails FROM registrationDetails registrationDetails WHERE ";
	private static final String _SQL_COUNT_REGISTRATIONDETAILS = "SELECT COUNT(registrationDetails) FROM registrationDetails registrationDetails";
	private static final String _SQL_COUNT_REGISTRATIONDETAILS_WHERE = "SELECT COUNT(registrationDetails) FROM registrationDetails registrationDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "registrationDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No registrationDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No registrationDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(registrationDetailsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}