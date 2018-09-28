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

package com.delphi.userprofile.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.delphi.userprofile.exception.NoSuchUserAccessRequestException;
import com.delphi.userprofile.model.UserAccessRequest;
import com.delphi.userprofile.model.impl.UserAccessRequestImpl;
import com.delphi.userprofile.model.impl.UserAccessRequestModelImpl;
import com.delphi.userprofile.service.persistence.UserAccessRequestPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

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
 * The persistence implementation for the user access request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequestPersistence
 * @see com.delphi.userprofile.service.persistence.UserAccessRequestUtil
 * @generated
 */
@ProviderType
public class UserAccessRequestPersistenceImpl extends BasePersistenceImpl<UserAccessRequest>
	implements UserAccessRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserAccessRequestUtil} to access the user access request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserAccessRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserAccessRequestModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user access requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user access requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @return the range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user access requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user access requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
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

		List<UserAccessRequest> list = null;

		if (retrieveFromCache) {
			list = (List<UserAccessRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccessRequest userAccessRequest : list) {
					if (!Objects.equals(uuid, userAccessRequest.getUuid())) {
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

			query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

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
				query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserAccessRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
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
	 * Returns the first user access request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByUuid_First(String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByUuid_First(uuid,
				orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the first user access request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByUuid_First(String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		List<UserAccessRequest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user access request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByUuid_Last(String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByUuid_Last(uuid,
				orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the last user access request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByUuid_Last(String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserAccessRequest> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user access requests before and after the current user access request in the ordered set where uuid = &#63;.
	 *
	 * @param requestId the primary key of the current user access request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user access request
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest[] findByUuid_PrevAndNext(long requestId,
		String uuid, OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			UserAccessRequest[] array = new UserAccessRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userAccessRequest, uuid,
					orderByComparator, true);

			array[1] = userAccessRequest;

			array[2] = getByUuid_PrevAndNext(session, userAccessRequest, uuid,
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

	protected UserAccessRequest getByUuid_PrevAndNext(Session session,
		UserAccessRequest userAccessRequest, String uuid,
		OrderByComparator<UserAccessRequest> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

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
			query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userAccessRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserAccessRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user access requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserAccessRequest userAccessRequest : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userAccessRequest);
		}
	}

	/**
	 * Returns the number of user access requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user access requests
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERACCESSREQUEST_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userAccessRequest.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userAccessRequest.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userAccessRequest.uuid IS NULL OR userAccessRequest.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			UserAccessRequestModelImpl.UUID_COLUMN_BITMASK |
			UserAccessRequestModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user access requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user access requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @return the range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user access requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user access requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
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

		List<UserAccessRequest> list = null;

		if (retrieveFromCache) {
			list = (List<UserAccessRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccessRequest userAccessRequest : list) {
					if (!Objects.equals(uuid, userAccessRequest.getUuid()) ||
							(companyId != userAccessRequest.getCompanyId())) {
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

			query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

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
				query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserAccessRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
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
	 * Returns the first user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the first user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		List<UserAccessRequest> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the last user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserAccessRequest> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user access requests before and after the current user access request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param requestId the primary key of the current user access request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user access request
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest[] findByUuid_C_PrevAndNext(long requestId,
		String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			UserAccessRequest[] array = new UserAccessRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, userAccessRequest,
					uuid, companyId, orderByComparator, true);

			array[1] = userAccessRequest;

			array[2] = getByUuid_C_PrevAndNext(session, userAccessRequest,
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

	protected UserAccessRequest getByUuid_C_PrevAndNext(Session session,
		UserAccessRequest userAccessRequest, String uuid, long companyId,
		OrderByComparator<UserAccessRequest> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

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
			query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userAccessRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserAccessRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user access requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserAccessRequest userAccessRequest : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userAccessRequest);
		}
	}

	/**
	 * Returns the number of user access requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user access requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERACCESSREQUEST_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userAccessRequest.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userAccessRequest.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userAccessRequest.uuid IS NULL OR userAccessRequest.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userAccessRequest.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			UserAccessRequestModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user access requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user access requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @return the range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user access requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUserId(long userId, int start,
		int end, OrderByComparator<UserAccessRequest> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user access requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByUserId(long userId, int start,
		int end, OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UserAccessRequest> list = null;

		if (retrieveFromCache) {
			list = (List<UserAccessRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccessRequest userAccessRequest : list) {
					if ((userId != userAccessRequest.getUserId())) {
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

			query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
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
	 * Returns the first user access request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByUserId_First(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByUserId_First(userId,
				orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the first user access request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByUserId_First(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		List<UserAccessRequest> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user access request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByUserId_Last(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByUserId_Last(userId,
				orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the last user access request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByUserId_Last(long userId,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserAccessRequest> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user access requests before and after the current user access request in the ordered set where userId = &#63;.
	 *
	 * @param requestId the primary key of the current user access request
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user access request
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest[] findByUserId_PrevAndNext(long requestId,
		long userId, OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			UserAccessRequest[] array = new UserAccessRequestImpl[3];

			array[0] = getByUserId_PrevAndNext(session, userAccessRequest,
					userId, orderByComparator, true);

			array[1] = userAccessRequest;

			array[2] = getByUserId_PrevAndNext(session, userAccessRequest,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccessRequest getByUserId_PrevAndNext(Session session,
		UserAccessRequest userAccessRequest, long userId,
		OrderByComparator<UserAccessRequest> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userAccessRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserAccessRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user access requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (UserAccessRequest userAccessRequest : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userAccessRequest);
		}
	}

	/**
	 * Returns the number of user access requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user access requests
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERACCESSREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userAccessRequest.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVESTATE =
		new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActiveState",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATE =
		new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED,
			UserAccessRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActiveState",
			new String[] { Integer.class.getName() },
			UserAccessRequestModelImpl.ACTIVESTATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVESTATE = new FinderPath(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActiveState",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the user access requests where activeState = &#63;.
	 *
	 * @param activeState the active state
	 * @return the matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByActiveState(int activeState) {
		return findByActiveState(activeState, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user access requests where activeState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activeState the active state
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @return the range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByActiveState(int activeState,
		int start, int end) {
		return findByActiveState(activeState, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user access requests where activeState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activeState the active state
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByActiveState(int activeState,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return findByActiveState(activeState, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the user access requests where activeState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activeState the active state
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user access requests
	 */
	@Override
	public List<UserAccessRequest> findByActiveState(int activeState,
		int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATE;
			finderArgs = new Object[] { activeState };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVESTATE;
			finderArgs = new Object[] { activeState, start, end, orderByComparator };
		}

		List<UserAccessRequest> list = null;

		if (retrieveFromCache) {
			list = (List<UserAccessRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccessRequest userAccessRequest : list) {
					if ((activeState != userAccessRequest.getActiveState())) {
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

			query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

			query.append(_FINDER_COLUMN_ACTIVESTATE_ACTIVESTATE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activeState);

				if (!pagination) {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
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
	 * Returns the first user access request in the ordered set where activeState = &#63;.
	 *
	 * @param activeState the active state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByActiveState_First(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByActiveState_First(activeState,
				orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activeState=");
		msg.append(activeState);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the first user access request in the ordered set where activeState = &#63;.
	 *
	 * @param activeState the active state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByActiveState_First(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		List<UserAccessRequest> list = findByActiveState(activeState, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user access request in the ordered set where activeState = &#63;.
	 *
	 * @param activeState the active state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request
	 * @throws NoSuchUserAccessRequestException if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest findByActiveState_Last(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByActiveState_Last(activeState,
				orderByComparator);

		if (userAccessRequest != null) {
			return userAccessRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activeState=");
		msg.append(activeState);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAccessRequestException(msg.toString());
	}

	/**
	 * Returns the last user access request in the ordered set where activeState = &#63;.
	 *
	 * @param activeState the active state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user access request, or <code>null</code> if a matching user access request could not be found
	 */
	@Override
	public UserAccessRequest fetchByActiveState_Last(int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		int count = countByActiveState(activeState);

		if (count == 0) {
			return null;
		}

		List<UserAccessRequest> list = findByActiveState(activeState,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user access requests before and after the current user access request in the ordered set where activeState = &#63;.
	 *
	 * @param requestId the primary key of the current user access request
	 * @param activeState the active state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user access request
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest[] findByActiveState_PrevAndNext(long requestId,
		int activeState, OrderByComparator<UserAccessRequest> orderByComparator)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			UserAccessRequest[] array = new UserAccessRequestImpl[3];

			array[0] = getByActiveState_PrevAndNext(session, userAccessRequest,
					activeState, orderByComparator, true);

			array[1] = userAccessRequest;

			array[2] = getByActiveState_PrevAndNext(session, userAccessRequest,
					activeState, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccessRequest getByActiveState_PrevAndNext(Session session,
		UserAccessRequest userAccessRequest, int activeState,
		OrderByComparator<UserAccessRequest> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE);

		query.append(_FINDER_COLUMN_ACTIVESTATE_ACTIVESTATE_2);

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
			query.append(UserAccessRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(activeState);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userAccessRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserAccessRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user access requests where activeState = &#63; from the database.
	 *
	 * @param activeState the active state
	 */
	@Override
	public void removeByActiveState(int activeState) {
		for (UserAccessRequest userAccessRequest : findByActiveState(
				activeState, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userAccessRequest);
		}
	}

	/**
	 * Returns the number of user access requests where activeState = &#63;.
	 *
	 * @param activeState the active state
	 * @return the number of matching user access requests
	 */
	@Override
	public int countByActiveState(int activeState) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVESTATE;

		Object[] finderArgs = new Object[] { activeState };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERACCESSREQUEST_WHERE);

			query.append(_FINDER_COLUMN_ACTIVESTATE_ACTIVESTATE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activeState);

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

	private static final String _FINDER_COLUMN_ACTIVESTATE_ACTIVESTATE_2 = "userAccessRequest.activeState = ?";

	public UserAccessRequestPersistenceImpl() {
		setModelClass(UserAccessRequest.class);
	}

	/**
	 * Caches the user access request in the entity cache if it is enabled.
	 *
	 * @param userAccessRequest the user access request
	 */
	@Override
	public void cacheResult(UserAccessRequest userAccessRequest) {
		entityCache.putResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestImpl.class, userAccessRequest.getPrimaryKey(),
			userAccessRequest);

		userAccessRequest.resetOriginalValues();
	}

	/**
	 * Caches the user access requests in the entity cache if it is enabled.
	 *
	 * @param userAccessRequests the user access requests
	 */
	@Override
	public void cacheResult(List<UserAccessRequest> userAccessRequests) {
		for (UserAccessRequest userAccessRequest : userAccessRequests) {
			if (entityCache.getResult(
						UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
						UserAccessRequestImpl.class,
						userAccessRequest.getPrimaryKey()) == null) {
				cacheResult(userAccessRequest);
			}
			else {
				userAccessRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user access requests.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserAccessRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user access request.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserAccessRequest userAccessRequest) {
		entityCache.removeResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestImpl.class, userAccessRequest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserAccessRequest> userAccessRequests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserAccessRequest userAccessRequest : userAccessRequests) {
			entityCache.removeResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
				UserAccessRequestImpl.class, userAccessRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user access request with the primary key. Does not add the user access request to the database.
	 *
	 * @param requestId the primary key for the new user access request
	 * @return the new user access request
	 */
	@Override
	public UserAccessRequest create(long requestId) {
		UserAccessRequest userAccessRequest = new UserAccessRequestImpl();

		userAccessRequest.setNew(true);
		userAccessRequest.setPrimaryKey(requestId);

		String uuid = PortalUUIDUtil.generate();

		userAccessRequest.setUuid(uuid);

		userAccessRequest.setCompanyId(companyProvider.getCompanyId());

		return userAccessRequest;
	}

	/**
	 * Removes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the user access request
	 * @return the user access request that was removed
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest remove(long requestId)
		throws NoSuchUserAccessRequestException {
		return remove((Serializable)requestId);
	}

	/**
	 * Removes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user access request
	 * @return the user access request that was removed
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest remove(Serializable primaryKey)
		throws NoSuchUserAccessRequestException {
		Session session = null;

		try {
			session = openSession();

			UserAccessRequest userAccessRequest = (UserAccessRequest)session.get(UserAccessRequestImpl.class,
					primaryKey);

			if (userAccessRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserAccessRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userAccessRequest);
		}
		catch (NoSuchUserAccessRequestException nsee) {
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
	protected UserAccessRequest removeImpl(UserAccessRequest userAccessRequest) {
		userAccessRequest = toUnwrappedModel(userAccessRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userAccessRequest)) {
				userAccessRequest = (UserAccessRequest)session.get(UserAccessRequestImpl.class,
						userAccessRequest.getPrimaryKeyObj());
			}

			if (userAccessRequest != null) {
				session.delete(userAccessRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userAccessRequest != null) {
			clearCache(userAccessRequest);
		}

		return userAccessRequest;
	}

	@Override
	public UserAccessRequest updateImpl(UserAccessRequest userAccessRequest) {
		userAccessRequest = toUnwrappedModel(userAccessRequest);

		boolean isNew = userAccessRequest.isNew();

		UserAccessRequestModelImpl userAccessRequestModelImpl = (UserAccessRequestModelImpl)userAccessRequest;

		if (Validator.isNull(userAccessRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userAccessRequest.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userAccessRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				userAccessRequest.setCreateDate(now);
			}
			else {
				userAccessRequest.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!userAccessRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userAccessRequest.setModifiedDate(now);
			}
			else {
				userAccessRequest.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userAccessRequest.isNew()) {
				session.save(userAccessRequest);

				userAccessRequest.setNew(false);
			}
			else {
				userAccessRequest = (UserAccessRequest)session.merge(userAccessRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserAccessRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userAccessRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAccessRequestModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userAccessRequestModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userAccessRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAccessRequestModelImpl.getOriginalUuid(),
						userAccessRequestModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						userAccessRequestModelImpl.getUuid(),
						userAccessRequestModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((userAccessRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAccessRequestModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { userAccessRequestModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((userAccessRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAccessRequestModelImpl.getOriginalActiveState()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVESTATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATE,
					args);

				args = new Object[] { userAccessRequestModelImpl.getActiveState() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVESTATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATE,
					args);
			}
		}

		entityCache.putResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
			UserAccessRequestImpl.class, userAccessRequest.getPrimaryKey(),
			userAccessRequest, false);

		userAccessRequest.resetOriginalValues();

		return userAccessRequest;
	}

	protected UserAccessRequest toUnwrappedModel(
		UserAccessRequest userAccessRequest) {
		if (userAccessRequest instanceof UserAccessRequestImpl) {
			return userAccessRequest;
		}

		UserAccessRequestImpl userAccessRequestImpl = new UserAccessRequestImpl();

		userAccessRequestImpl.setNew(userAccessRequest.isNew());
		userAccessRequestImpl.setPrimaryKey(userAccessRequest.getPrimaryKey());

		userAccessRequestImpl.setUuid(userAccessRequest.getUuid());
		userAccessRequestImpl.setRequestId(userAccessRequest.getRequestId());
		userAccessRequestImpl.setUserId(userAccessRequest.getUserId());
		userAccessRequestImpl.setCompanyId(userAccessRequest.getCompanyId());
		userAccessRequestImpl.setCreatedById(userAccessRequest.getCreatedById());
		userAccessRequestImpl.setCreateDate(userAccessRequest.getCreateDate());
		userAccessRequestImpl.setModifiedDate(userAccessRequest.getModifiedDate());
		userAccessRequestImpl.setPortletAccess(userAccessRequest.getPortletAccess());
		userAccessRequestImpl.setRequestType(userAccessRequest.getRequestType());
		userAccessRequestImpl.setResponseType(userAccessRequest.getResponseType());
		userAccessRequestImpl.setResponseComment(userAccessRequest.getResponseComment());
		userAccessRequestImpl.setResponseUser(userAccessRequest.getResponseUser());
		userAccessRequestImpl.setActiveState(userAccessRequest.getActiveState());

		return userAccessRequestImpl;
	}

	/**
	 * Returns the user access request with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user access request
	 * @return the user access request
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserAccessRequestException {
		UserAccessRequest userAccessRequest = fetchByPrimaryKey(primaryKey);

		if (userAccessRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserAccessRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userAccessRequest;
	}

	/**
	 * Returns the user access request with the primary key or throws a {@link NoSuchUserAccessRequestException} if it could not be found.
	 *
	 * @param requestId the primary key of the user access request
	 * @return the user access request
	 * @throws NoSuchUserAccessRequestException if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest findByPrimaryKey(long requestId)
		throws NoSuchUserAccessRequestException {
		return findByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns the user access request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user access request
	 * @return the user access request, or <code>null</code> if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
				UserAccessRequestImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserAccessRequest userAccessRequest = (UserAccessRequest)serializable;

		if (userAccessRequest == null) {
			Session session = null;

			try {
				session = openSession();

				userAccessRequest = (UserAccessRequest)session.get(UserAccessRequestImpl.class,
						primaryKey);

				if (userAccessRequest != null) {
					cacheResult(userAccessRequest);
				}
				else {
					entityCache.putResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
						UserAccessRequestImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
					UserAccessRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userAccessRequest;
	}

	/**
	 * Returns the user access request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the user access request
	 * @return the user access request, or <code>null</code> if a user access request with the primary key could not be found
	 */
	@Override
	public UserAccessRequest fetchByPrimaryKey(long requestId) {
		return fetchByPrimaryKey((Serializable)requestId);
	}

	@Override
	public Map<Serializable, UserAccessRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserAccessRequest> map = new HashMap<Serializable, UserAccessRequest>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserAccessRequest userAccessRequest = fetchByPrimaryKey(primaryKey);

			if (userAccessRequest != null) {
				map.put(primaryKey, userAccessRequest);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
					UserAccessRequestImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserAccessRequest)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERACCESSREQUEST_WHERE_PKS_IN);

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

			for (UserAccessRequest userAccessRequest : (List<UserAccessRequest>)q.list()) {
				map.put(userAccessRequest.getPrimaryKeyObj(), userAccessRequest);

				cacheResult(userAccessRequest);

				uncachedPrimaryKeys.remove(userAccessRequest.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserAccessRequestModelImpl.ENTITY_CACHE_ENABLED,
					UserAccessRequestImpl.class, primaryKey, nullModel);
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
	 * Returns all the user access requests.
	 *
	 * @return the user access requests
	 */
	@Override
	public List<UserAccessRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user access requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @return the range of user access requests
	 */
	@Override
	public List<UserAccessRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user access requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user access requests
	 */
	@Override
	public List<UserAccessRequest> findAll(int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user access requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user access requests
	 * @param end the upper bound of the range of user access requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user access requests
	 */
	@Override
	public List<UserAccessRequest> findAll(int start, int end,
		OrderByComparator<UserAccessRequest> orderByComparator,
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

		List<UserAccessRequest> list = null;

		if (retrieveFromCache) {
			list = (List<UserAccessRequest>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERACCESSREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERACCESSREQUEST;

				if (pagination) {
					sql = sql.concat(UserAccessRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserAccessRequest>)QueryUtil.list(q,
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
	 * Removes all the user access requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserAccessRequest userAccessRequest : findAll()) {
			remove(userAccessRequest);
		}
	}

	/**
	 * Returns the number of user access requests.
	 *
	 * @return the number of user access requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERACCESSREQUEST);

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
		return UserAccessRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user access request persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserAccessRequestImpl.class.getName());
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
	private static final String _SQL_SELECT_USERACCESSREQUEST = "SELECT userAccessRequest FROM UserAccessRequest userAccessRequest";
	private static final String _SQL_SELECT_USERACCESSREQUEST_WHERE_PKS_IN = "SELECT userAccessRequest FROM UserAccessRequest userAccessRequest WHERE requestId IN (";
	private static final String _SQL_SELECT_USERACCESSREQUEST_WHERE = "SELECT userAccessRequest FROM UserAccessRequest userAccessRequest WHERE ";
	private static final String _SQL_COUNT_USERACCESSREQUEST = "SELECT COUNT(userAccessRequest) FROM UserAccessRequest userAccessRequest";
	private static final String _SQL_COUNT_USERACCESSREQUEST_WHERE = "SELECT COUNT(userAccessRequest) FROM UserAccessRequest userAccessRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userAccessRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserAccessRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserAccessRequest exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserAccessRequestPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}