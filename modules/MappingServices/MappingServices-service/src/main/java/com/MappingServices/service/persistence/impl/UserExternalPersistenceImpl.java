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

package com.MappingServices.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.MappingServices.exception.NoSuchUserExternalException;

import com.MappingServices.model.UserExternal;
import com.MappingServices.model.impl.UserExternalImpl;
import com.MappingServices.model.impl.UserExternalModelImpl;

import com.MappingServices.service.persistence.UserExternalPersistence;

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
 * The persistence implementation for the user external service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalPersistence
 * @see com.MappingServices.service.persistence.UserExternalUtil
 * @generated
 */
@ProviderType
public class UserExternalPersistenceImpl extends BasePersistenceImpl<UserExternal>
	implements UserExternalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserExternalUtil} to access the user external persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserExternalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserExternalModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user externals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user externals
	 */
	@Override
	public List<UserExternal> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user externals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @return the range of matching user externals
	 */
	@Override
	public List<UserExternal> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user externals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user externals
	 */
	@Override
	public List<UserExternal> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserExternal> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user externals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user externals
	 */
	@Override
	public List<UserExternal> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserExternal> orderByComparator,
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

		List<UserExternal> list = null;

		if (retrieveFromCache) {
			list = (List<UserExternal>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserExternal userExternal : list) {
					if (!Objects.equals(uuid, userExternal.getUuid())) {
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

			query.append(_SQL_SELECT_USEREXTERNAL_WHERE);

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
				query.append(UserExternalModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user external in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user external
	 * @throws NoSuchUserExternalException if a matching user external could not be found
	 */
	@Override
	public UserExternal findByUuid_First(String uuid,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByUuid_First(uuid, orderByComparator);

		if (userExternal != null) {
			return userExternal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserExternalException(msg.toString());
	}

	/**
	 * Returns the first user external in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user external, or <code>null</code> if a matching user external could not be found
	 */
	@Override
	public UserExternal fetchByUuid_First(String uuid,
		OrderByComparator<UserExternal> orderByComparator) {
		List<UserExternal> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user external in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user external
	 * @throws NoSuchUserExternalException if a matching user external could not be found
	 */
	@Override
	public UserExternal findByUuid_Last(String uuid,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByUuid_Last(uuid, orderByComparator);

		if (userExternal != null) {
			return userExternal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserExternalException(msg.toString());
	}

	/**
	 * Returns the last user external in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user external, or <code>null</code> if a matching user external could not be found
	 */
	@Override
	public UserExternal fetchByUuid_Last(String uuid,
		OrderByComparator<UserExternal> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserExternal> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user externals before and after the current user external in the ordered set where uuid = &#63;.
	 *
	 * @param uid the primary key of the current user external
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal[] findByUuid_PrevAndNext(long uid, String uuid,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = findByPrimaryKey(uid);

		Session session = null;

		try {
			session = openSession();

			UserExternal[] array = new UserExternalImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userExternal, uuid,
					orderByComparator, true);

			array[1] = userExternal;

			array[2] = getByUuid_PrevAndNext(session, userExternal, uuid,
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

	protected UserExternal getByUuid_PrevAndNext(Session session,
		UserExternal userExternal, String uuid,
		OrderByComparator<UserExternal> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USEREXTERNAL_WHERE);

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
			query.append(UserExternalModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userExternal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserExternal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user externals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserExternal userExternal : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userExternal);
		}
	}

	/**
	 * Returns the number of user externals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user externals
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEREXTERNAL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userExternal.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userExternal.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userExternal.uuid IS NULL OR userExternal.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POLICYID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPolicyID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POLICYID =
		new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPolicyID",
			new String[] { String.class.getName() },
			UserExternalModelImpl.POLICYNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POLICYID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user externals where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @return the matching user externals
	 */
	@Override
	public List<UserExternal> findByPolicyID(String PolicyNumber) {
		return findByPolicyID(PolicyNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user externals where PolicyNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PolicyNumber the policy number
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @return the range of matching user externals
	 */
	@Override
	public List<UserExternal> findByPolicyID(String PolicyNumber, int start,
		int end) {
		return findByPolicyID(PolicyNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PolicyNumber the policy number
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user externals
	 */
	@Override
	public List<UserExternal> findByPolicyID(String PolicyNumber, int start,
		int end, OrderByComparator<UserExternal> orderByComparator) {
		return findByPolicyID(PolicyNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PolicyNumber the policy number
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user externals
	 */
	@Override
	public List<UserExternal> findByPolicyID(String PolicyNumber, int start,
		int end, OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POLICYID;
			finderArgs = new Object[] { PolicyNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POLICYID;
			finderArgs = new Object[] {
					PolicyNumber,
					
					start, end, orderByComparator
				};
		}

		List<UserExternal> list = null;

		if (retrieveFromCache) {
			list = (List<UserExternal>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserExternal userExternal : list) {
					if (!Objects.equals(PolicyNumber,
								userExternal.getPolicyNumber())) {
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

			query.append(_SQL_SELECT_USEREXTERNAL_WHERE);

			boolean bindPolicyNumber = false;

			if (PolicyNumber == null) {
				query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_1);
			}
			else if (PolicyNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserExternalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPolicyNumber) {
					qPos.add(PolicyNumber);
				}

				if (!pagination) {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user external
	 * @throws NoSuchUserExternalException if a matching user external could not be found
	 */
	@Override
	public UserExternal findByPolicyID_First(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByPolicyID_First(PolicyNumber,
				orderByComparator);

		if (userExternal != null) {
			return userExternal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PolicyNumber=");
		msg.append(PolicyNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserExternalException(msg.toString());
	}

	/**
	 * Returns the first user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user external, or <code>null</code> if a matching user external could not be found
	 */
	@Override
	public UserExternal fetchByPolicyID_First(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		List<UserExternal> list = findByPolicyID(PolicyNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user external
	 * @throws NoSuchUserExternalException if a matching user external could not be found
	 */
	@Override
	public UserExternal findByPolicyID_Last(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByPolicyID_Last(PolicyNumber,
				orderByComparator);

		if (userExternal != null) {
			return userExternal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PolicyNumber=");
		msg.append(PolicyNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserExternalException(msg.toString());
	}

	/**
	 * Returns the last user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user external, or <code>null</code> if a matching user external could not be found
	 */
	@Override
	public UserExternal fetchByPolicyID_Last(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		int count = countByPolicyID(PolicyNumber);

		if (count == 0) {
			return null;
		}

		List<UserExternal> list = findByPolicyID(PolicyNumber, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user externals before and after the current user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param uid the primary key of the current user external
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal[] findByPolicyID_PrevAndNext(long uid,
		String PolicyNumber, OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = findByPrimaryKey(uid);

		Session session = null;

		try {
			session = openSession();

			UserExternal[] array = new UserExternalImpl[3];

			array[0] = getByPolicyID_PrevAndNext(session, userExternal,
					PolicyNumber, orderByComparator, true);

			array[1] = userExternal;

			array[2] = getByPolicyID_PrevAndNext(session, userExternal,
					PolicyNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserExternal getByPolicyID_PrevAndNext(Session session,
		UserExternal userExternal, String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USEREXTERNAL_WHERE);

		boolean bindPolicyNumber = false;

		if (PolicyNumber == null) {
			query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_1);
		}
		else if (PolicyNumber.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_3);
		}
		else {
			bindPolicyNumber = true;

			query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_2);
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
			query.append(UserExternalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPolicyNumber) {
			qPos.add(PolicyNumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userExternal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserExternal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user externals where PolicyNumber = &#63; from the database.
	 *
	 * @param PolicyNumber the policy number
	 */
	@Override
	public void removeByPolicyID(String PolicyNumber) {
		for (UserExternal userExternal : findByPolicyID(PolicyNumber,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userExternal);
		}
	}

	/**
	 * Returns the number of user externals where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @return the number of matching user externals
	 */
	@Override
	public int countByPolicyID(String PolicyNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POLICYID;

		Object[] finderArgs = new Object[] { PolicyNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEREXTERNAL_WHERE);

			boolean bindPolicyNumber = false;

			if (PolicyNumber == null) {
				query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_1);
			}
			else if (PolicyNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				query.append(_FINDER_COLUMN_POLICYID_POLICYNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPolicyNumber) {
					qPos.add(PolicyNumber);
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

	private static final String _FINDER_COLUMN_POLICYID_POLICYNUMBER_1 = "userExternal.PolicyNumber IS NULL";
	private static final String _FINDER_COLUMN_POLICYID_POLICYNUMBER_2 = "userExternal.PolicyNumber = ?";
	private static final String _FINDER_COLUMN_POLICYID_POLICYNUMBER_3 = "(userExternal.PolicyNumber IS NULL OR userExternal.PolicyNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, UserExternalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPID",
			new String[] { String.class.getName() },
			UserExternalModelImpl.POLICYNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PID = new FinderPath(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user externals where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @return the matching user externals
	 */
	@Override
	public List<UserExternal> findByPID(String PolicyNumber) {
		return findByPID(PolicyNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user externals where PolicyNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PolicyNumber the policy number
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @return the range of matching user externals
	 */
	@Override
	public List<UserExternal> findByPID(String PolicyNumber, int start, int end) {
		return findByPID(PolicyNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PolicyNumber the policy number
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user externals
	 */
	@Override
	public List<UserExternal> findByPID(String PolicyNumber, int start,
		int end, OrderByComparator<UserExternal> orderByComparator) {
		return findByPID(PolicyNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user externals where PolicyNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PolicyNumber the policy number
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user externals
	 */
	@Override
	public List<UserExternal> findByPID(String PolicyNumber, int start,
		int end, OrderByComparator<UserExternal> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PID;
			finderArgs = new Object[] { PolicyNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PID;
			finderArgs = new Object[] {
					PolicyNumber,
					
					start, end, orderByComparator
				};
		}

		List<UserExternal> list = null;

		if (retrieveFromCache) {
			list = (List<UserExternal>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserExternal userExternal : list) {
					if (!Objects.equals(PolicyNumber,
								userExternal.getPolicyNumber())) {
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

			query.append(_SQL_SELECT_USEREXTERNAL_WHERE);

			boolean bindPolicyNumber = false;

			if (PolicyNumber == null) {
				query.append(_FINDER_COLUMN_PID_POLICYNUMBER_1);
			}
			else if (PolicyNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PID_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				query.append(_FINDER_COLUMN_PID_POLICYNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserExternalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPolicyNumber) {
					qPos.add(PolicyNumber);
				}

				if (!pagination) {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user external
	 * @throws NoSuchUserExternalException if a matching user external could not be found
	 */
	@Override
	public UserExternal findByPID_First(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByPID_First(PolicyNumber,
				orderByComparator);

		if (userExternal != null) {
			return userExternal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PolicyNumber=");
		msg.append(PolicyNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserExternalException(msg.toString());
	}

	/**
	 * Returns the first user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user external, or <code>null</code> if a matching user external could not be found
	 */
	@Override
	public UserExternal fetchByPID_First(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		List<UserExternal> list = findByPID(PolicyNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user external
	 * @throws NoSuchUserExternalException if a matching user external could not be found
	 */
	@Override
	public UserExternal findByPID_Last(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByPID_Last(PolicyNumber,
				orderByComparator);

		if (userExternal != null) {
			return userExternal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PolicyNumber=");
		msg.append(PolicyNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserExternalException(msg.toString());
	}

	/**
	 * Returns the last user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user external, or <code>null</code> if a matching user external could not be found
	 */
	@Override
	public UserExternal fetchByPID_Last(String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator) {
		int count = countByPID(PolicyNumber);

		if (count == 0) {
			return null;
		}

		List<UserExternal> list = findByPID(PolicyNumber, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user externals before and after the current user external in the ordered set where PolicyNumber = &#63;.
	 *
	 * @param uid the primary key of the current user external
	 * @param PolicyNumber the policy number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal[] findByPID_PrevAndNext(long uid, String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator)
		throws NoSuchUserExternalException {
		UserExternal userExternal = findByPrimaryKey(uid);

		Session session = null;

		try {
			session = openSession();

			UserExternal[] array = new UserExternalImpl[3];

			array[0] = getByPID_PrevAndNext(session, userExternal,
					PolicyNumber, orderByComparator, true);

			array[1] = userExternal;

			array[2] = getByPID_PrevAndNext(session, userExternal,
					PolicyNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserExternal getByPID_PrevAndNext(Session session,
		UserExternal userExternal, String PolicyNumber,
		OrderByComparator<UserExternal> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USEREXTERNAL_WHERE);

		boolean bindPolicyNumber = false;

		if (PolicyNumber == null) {
			query.append(_FINDER_COLUMN_PID_POLICYNUMBER_1);
		}
		else if (PolicyNumber.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PID_POLICYNUMBER_3);
		}
		else {
			bindPolicyNumber = true;

			query.append(_FINDER_COLUMN_PID_POLICYNUMBER_2);
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
			query.append(UserExternalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPolicyNumber) {
			qPos.add(PolicyNumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userExternal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserExternal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user externals where PolicyNumber = &#63; from the database.
	 *
	 * @param PolicyNumber the policy number
	 */
	@Override
	public void removeByPID(String PolicyNumber) {
		for (UserExternal userExternal : findByPID(PolicyNumber,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userExternal);
		}
	}

	/**
	 * Returns the number of user externals where PolicyNumber = &#63;.
	 *
	 * @param PolicyNumber the policy number
	 * @return the number of matching user externals
	 */
	@Override
	public int countByPID(String PolicyNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PID;

		Object[] finderArgs = new Object[] { PolicyNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEREXTERNAL_WHERE);

			boolean bindPolicyNumber = false;

			if (PolicyNumber == null) {
				query.append(_FINDER_COLUMN_PID_POLICYNUMBER_1);
			}
			else if (PolicyNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PID_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				query.append(_FINDER_COLUMN_PID_POLICYNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPolicyNumber) {
					qPos.add(PolicyNumber);
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

	private static final String _FINDER_COLUMN_PID_POLICYNUMBER_1 = "userExternal.PolicyNumber IS NULL";
	private static final String _FINDER_COLUMN_PID_POLICYNUMBER_2 = "userExternal.PolicyNumber = ?";
	private static final String _FINDER_COLUMN_PID_POLICYNUMBER_3 = "(userExternal.PolicyNumber IS NULL OR userExternal.PolicyNumber = '')";

	public UserExternalPersistenceImpl() {
		setModelClass(UserExternal.class);

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
	 * Caches the user external in the entity cache if it is enabled.
	 *
	 * @param userExternal the user external
	 */
	@Override
	public void cacheResult(UserExternal userExternal) {
		entityCache.putResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalImpl.class, userExternal.getPrimaryKey(), userExternal);

		userExternal.resetOriginalValues();
	}

	/**
	 * Caches the user externals in the entity cache if it is enabled.
	 *
	 * @param userExternals the user externals
	 */
	@Override
	public void cacheResult(List<UserExternal> userExternals) {
		for (UserExternal userExternal : userExternals) {
			if (entityCache.getResult(
						UserExternalModelImpl.ENTITY_CACHE_ENABLED,
						UserExternalImpl.class, userExternal.getPrimaryKey()) == null) {
				cacheResult(userExternal);
			}
			else {
				userExternal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user externals.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserExternalImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user external.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserExternal userExternal) {
		entityCache.removeResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalImpl.class, userExternal.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserExternal> userExternals) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserExternal userExternal : userExternals) {
			entityCache.removeResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
				UserExternalImpl.class, userExternal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user external with the primary key. Does not add the user external to the database.
	 *
	 * @param uid the primary key for the new user external
	 * @return the new user external
	 */
	@Override
	public UserExternal create(long uid) {
		UserExternal userExternal = new UserExternalImpl();

		userExternal.setNew(true);
		userExternal.setPrimaryKey(uid);

		String uuid = PortalUUIDUtil.generate();

		userExternal.setUuid(uuid);

		return userExternal;
	}

	/**
	 * Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uid the primary key of the user external
	 * @return the user external that was removed
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal remove(long uid) throws NoSuchUserExternalException {
		return remove((Serializable)uid);
	}

	/**
	 * Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user external
	 * @return the user external that was removed
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal remove(Serializable primaryKey)
		throws NoSuchUserExternalException {
		Session session = null;

		try {
			session = openSession();

			UserExternal userExternal = (UserExternal)session.get(UserExternalImpl.class,
					primaryKey);

			if (userExternal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserExternalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userExternal);
		}
		catch (NoSuchUserExternalException nsee) {
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
	protected UserExternal removeImpl(UserExternal userExternal) {
		userExternal = toUnwrappedModel(userExternal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userExternal)) {
				userExternal = (UserExternal)session.get(UserExternalImpl.class,
						userExternal.getPrimaryKeyObj());
			}

			if (userExternal != null) {
				session.delete(userExternal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userExternal != null) {
			clearCache(userExternal);
		}

		return userExternal;
	}

	@Override
	public UserExternal updateImpl(UserExternal userExternal) {
		userExternal = toUnwrappedModel(userExternal);

		boolean isNew = userExternal.isNew();

		UserExternalModelImpl userExternalModelImpl = (UserExternalModelImpl)userExternal;

		if (Validator.isNull(userExternal.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userExternal.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userExternal.getCreateDate() == null)) {
			if (serviceContext == null) {
				userExternal.setCreateDate(now);
			}
			else {
				userExternal.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userExternalModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userExternal.setModifiedDate(now);
			}
			else {
				userExternal.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userExternal.isNew()) {
				session.save(userExternal);

				userExternal.setNew(false);
			}
			else {
				userExternal = (UserExternal)session.merge(userExternal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UserExternalModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { userExternalModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { userExternalModelImpl.getPolicyNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POLICYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POLICYID,
				args);

			args = new Object[] { userExternalModelImpl.getPolicyNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((userExternalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userExternalModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userExternalModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userExternalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POLICYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userExternalModelImpl.getOriginalPolicyNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POLICYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POLICYID,
					args);

				args = new Object[] { userExternalModelImpl.getPolicyNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POLICYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POLICYID,
					args);
			}

			if ((userExternalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userExternalModelImpl.getOriginalPolicyNumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PID,
					args);

				args = new Object[] { userExternalModelImpl.getPolicyNumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PID,
					args);
			}
		}

		entityCache.putResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
			UserExternalImpl.class, userExternal.getPrimaryKey(), userExternal,
			false);

		userExternal.resetOriginalValues();

		return userExternal;
	}

	protected UserExternal toUnwrappedModel(UserExternal userExternal) {
		if (userExternal instanceof UserExternalImpl) {
			return userExternal;
		}

		UserExternalImpl userExternalImpl = new UserExternalImpl();

		userExternalImpl.setNew(userExternal.isNew());
		userExternalImpl.setPrimaryKey(userExternal.getPrimaryKey());

		userExternalImpl.setUuid(userExternal.getUuid());
		userExternalImpl.setUid(userExternal.getUid());
		userExternalImpl.setLocation(userExternal.getLocation());
		userExternalImpl.setPolicyNumber(userExternal.getPolicyNumber());
		userExternalImpl.setCreateDate(userExternal.getCreateDate());
		userExternalImpl.setModifiedDate(userExternal.getModifiedDate());

		return userExternalImpl;
	}

	/**
	 * Returns the user external with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user external
	 * @return the user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserExternalException {
		UserExternal userExternal = fetchByPrimaryKey(primaryKey);

		if (userExternal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserExternalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userExternal;
	}

	/**
	 * Returns the user external with the primary key or throws a {@link NoSuchUserExternalException} if it could not be found.
	 *
	 * @param uid the primary key of the user external
	 * @return the user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal findByPrimaryKey(long uid)
		throws NoSuchUserExternalException {
		return findByPrimaryKey((Serializable)uid);
	}

	/**
	 * Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user external
	 * @return the user external, or <code>null</code> if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
				UserExternalImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserExternal userExternal = (UserExternal)serializable;

		if (userExternal == null) {
			Session session = null;

			try {
				session = openSession();

				userExternal = (UserExternal)session.get(UserExternalImpl.class,
						primaryKey);

				if (userExternal != null) {
					cacheResult(userExternal);
				}
				else {
					entityCache.putResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
						UserExternalImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
					UserExternalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userExternal;
	}

	/**
	 * Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uid the primary key of the user external
	 * @return the user external, or <code>null</code> if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal fetchByPrimaryKey(long uid) {
		return fetchByPrimaryKey((Serializable)uid);
	}

	@Override
	public Map<Serializable, UserExternal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserExternal> map = new HashMap<Serializable, UserExternal>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserExternal userExternal = fetchByPrimaryKey(primaryKey);

			if (userExternal != null) {
				map.put(primaryKey, userExternal);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
					UserExternalImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserExternal)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USEREXTERNAL_WHERE_PKS_IN);

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

			for (UserExternal userExternal : (List<UserExternal>)q.list()) {
				map.put(userExternal.getPrimaryKeyObj(), userExternal);

				cacheResult(userExternal);

				uncachedPrimaryKeys.remove(userExternal.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserExternalModelImpl.ENTITY_CACHE_ENABLED,
					UserExternalImpl.class, primaryKey, nullModel);
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
	 * Returns all the user externals.
	 *
	 * @return the user externals
	 */
	@Override
	public List<UserExternal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @return the range of user externals
	 */
	@Override
	public List<UserExternal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user externals
	 */
	@Override
	public List<UserExternal> findAll(int start, int end,
		OrderByComparator<UserExternal> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user externals
	 */
	@Override
	public List<UserExternal> findAll(int start, int end,
		OrderByComparator<UserExternal> orderByComparator,
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

		List<UserExternal> list = null;

		if (retrieveFromCache) {
			list = (List<UserExternal>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USEREXTERNAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USEREXTERNAL;

				if (pagination) {
					sql = sql.concat(UserExternalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserExternal>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user externals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserExternal userExternal : findAll()) {
			remove(userExternal);
		}
	}

	/**
	 * Returns the number of user externals.
	 *
	 * @return the number of user externals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USEREXTERNAL);

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
		return UserExternalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user external persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserExternalImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USEREXTERNAL = "SELECT userExternal FROM UserExternal userExternal";
	private static final String _SQL_SELECT_USEREXTERNAL_WHERE_PKS_IN = "SELECT userExternal FROM UserExternal userExternal WHERE uid IN (";
	private static final String _SQL_SELECT_USEREXTERNAL_WHERE = "SELECT userExternal FROM UserExternal userExternal WHERE ";
	private static final String _SQL_COUNT_USEREXTERNAL = "SELECT COUNT(userExternal) FROM UserExternal userExternal";
	private static final String _SQL_COUNT_USEREXTERNAL_WHERE = "SELECT COUNT(userExternal) FROM UserExternal userExternal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userExternal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserExternal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserExternal exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserExternalPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}