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

import com.delphi.userprofile.exception.NoSuchUserProfileException;
import com.delphi.userprofile.model.UserProfile;
import com.delphi.userprofile.model.impl.UserProfileImpl;
import com.delphi.userprofile.model.impl.UserProfileModelImpl;
import com.delphi.userprofile.service.persistence.UserProfilePersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the user profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfilePersistence
 * @see com.delphi.userprofile.service.persistence.UserProfileUtil
 * @generated
 */
@ProviderType
public class UserProfilePersistenceImpl extends BasePersistenceImpl<UserProfile>
	implements UserProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserProfileUtil} to access the user profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserProfileModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @return the range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserProfile> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserProfile> orderByComparator,
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

		List<UserProfile> list = null;

		if (retrieveFromCache) {
			list = (List<UserProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserProfile userProfile : list) {
					if (!Objects.equals(uuid, userProfile.getUuid())) {
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

			query.append(_SQL_SELECT_USERPROFILE_WHERE);

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
				query.append(UserProfileModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByUuid_First(String uuid,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByUuid_First(uuid, orderByComparator);

		if (userProfile != null) {
			return userProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserProfileException(msg.toString());
	}

	/**
	 * Returns the first user profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByUuid_First(String uuid,
		OrderByComparator<UserProfile> orderByComparator) {
		List<UserProfile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByUuid_Last(String uuid,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByUuid_Last(uuid, orderByComparator);

		if (userProfile != null) {
			return userProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserProfileException(msg.toString());
	}

	/**
	 * Returns the last user profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByUuid_Last(String uuid,
		OrderByComparator<UserProfile> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserProfile> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user profiles before and after the current user profile in the ordered set where uuid = &#63;.
	 *
	 * @param profileId the primary key of the current user profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user profile
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile[] findByUuid_PrevAndNext(long profileId, String uuid,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = findByPrimaryKey(profileId);

		Session session = null;

		try {
			session = openSession();

			UserProfile[] array = new UserProfileImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userProfile, uuid,
					orderByComparator, true);

			array[1] = userProfile;

			array[2] = getByUuid_PrevAndNext(session, userProfile, uuid,
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

	protected UserProfile getByUuid_PrevAndNext(Session session,
		UserProfile userProfile, String uuid,
		OrderByComparator<UserProfile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERPROFILE_WHERE);

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
			query.append(UserProfileModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserProfile userProfile : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userProfile);
		}
	}

	/**
	 * Returns the number of user profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user profiles
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPROFILE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userProfile.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userProfile.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userProfile.uuid IS NULL OR userProfile.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			UserProfileModelImpl.UUID_COLUMN_BITMASK |
			UserProfileModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @return the range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<UserProfile> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<UserProfile> orderByComparator,
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

		List<UserProfile> list = null;

		if (retrieveFromCache) {
			list = (List<UserProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserProfile userProfile : list) {
					if (!Objects.equals(uuid, userProfile.getUuid()) ||
							(companyId != userProfile.getCompanyId())) {
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

			query.append(_SQL_SELECT_USERPROFILE_WHERE);

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
				query.append(UserProfileModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (userProfile != null) {
			return userProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserProfileException(msg.toString());
	}

	/**
	 * Returns the first user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserProfile> orderByComparator) {
		List<UserProfile> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (userProfile != null) {
			return userProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserProfileException(msg.toString());
	}

	/**
	 * Returns the last user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserProfile> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserProfile> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user profiles before and after the current user profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param profileId the primary key of the current user profile
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user profile
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile[] findByUuid_C_PrevAndNext(long profileId, String uuid,
		long companyId, OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = findByPrimaryKey(profileId);

		Session session = null;

		try {
			session = openSession();

			UserProfile[] array = new UserProfileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, userProfile, uuid,
					companyId, orderByComparator, true);

			array[1] = userProfile;

			array[2] = getByUuid_C_PrevAndNext(session, userProfile, uuid,
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

	protected UserProfile getByUuid_C_PrevAndNext(Session session,
		UserProfile userProfile, String uuid, long companyId,
		OrderByComparator<UserProfile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERPROFILE_WHERE);

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
			query.append(UserProfileModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserProfile userProfile : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userProfile);
		}
	}

	/**
	 * Returns the number of user profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user profiles
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPROFILE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userProfile.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userProfile.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userProfile.uuid IS NULL OR userProfile.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userProfile.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBROLE = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobRole",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBROLE =
		new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobRole",
			new String[] { String.class.getName() },
			UserProfileModelImpl.JOBROLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBROLE = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobRole",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user profiles where jobrole = &#63;.
	 *
	 * @param jobrole the jobrole
	 * @return the matching user profiles
	 */
	@Override
	public List<UserProfile> findByJobRole(String jobrole) {
		return findByJobRole(jobrole, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user profiles where jobrole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobrole the jobrole
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @return the range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByJobRole(String jobrole, int start, int end) {
		return findByJobRole(jobrole, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user profiles where jobrole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobrole the jobrole
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByJobRole(String jobrole, int start, int end,
		OrderByComparator<UserProfile> orderByComparator) {
		return findByJobRole(jobrole, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user profiles where jobrole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobrole the jobrole
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user profiles
	 */
	@Override
	public List<UserProfile> findByJobRole(String jobrole, int start, int end,
		OrderByComparator<UserProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBROLE;
			finderArgs = new Object[] { jobrole };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBROLE;
			finderArgs = new Object[] { jobrole, start, end, orderByComparator };
		}

		List<UserProfile> list = null;

		if (retrieveFromCache) {
			list = (List<UserProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserProfile userProfile : list) {
					if (!Objects.equals(jobrole, userProfile.getJobrole())) {
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

			query.append(_SQL_SELECT_USERPROFILE_WHERE);

			boolean bindJobrole = false;

			if (jobrole == null) {
				query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_1);
			}
			else if (jobrole.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_3);
			}
			else {
				bindJobrole = true;

				query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobrole) {
					qPos.add(jobrole);
				}

				if (!pagination) {
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user profile in the ordered set where jobrole = &#63;.
	 *
	 * @param jobrole the jobrole
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByJobRole_First(String jobrole,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByJobRole_First(jobrole,
				orderByComparator);

		if (userProfile != null) {
			return userProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobrole=");
		msg.append(jobrole);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserProfileException(msg.toString());
	}

	/**
	 * Returns the first user profile in the ordered set where jobrole = &#63;.
	 *
	 * @param jobrole the jobrole
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByJobRole_First(String jobrole,
		OrderByComparator<UserProfile> orderByComparator) {
		List<UserProfile> list = findByJobRole(jobrole, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user profile in the ordered set where jobrole = &#63;.
	 *
	 * @param jobrole the jobrole
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByJobRole_Last(String jobrole,
		OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByJobRole_Last(jobrole, orderByComparator);

		if (userProfile != null) {
			return userProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobrole=");
		msg.append(jobrole);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserProfileException(msg.toString());
	}

	/**
	 * Returns the last user profile in the ordered set where jobrole = &#63;.
	 *
	 * @param jobrole the jobrole
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByJobRole_Last(String jobrole,
		OrderByComparator<UserProfile> orderByComparator) {
		int count = countByJobRole(jobrole);

		if (count == 0) {
			return null;
		}

		List<UserProfile> list = findByJobRole(jobrole, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user profiles before and after the current user profile in the ordered set where jobrole = &#63;.
	 *
	 * @param profileId the primary key of the current user profile
	 * @param jobrole the jobrole
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user profile
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile[] findByJobRole_PrevAndNext(long profileId,
		String jobrole, OrderByComparator<UserProfile> orderByComparator)
		throws NoSuchUserProfileException {
		UserProfile userProfile = findByPrimaryKey(profileId);

		Session session = null;

		try {
			session = openSession();

			UserProfile[] array = new UserProfileImpl[3];

			array[0] = getByJobRole_PrevAndNext(session, userProfile, jobrole,
					orderByComparator, true);

			array[1] = userProfile;

			array[2] = getByJobRole_PrevAndNext(session, userProfile, jobrole,
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

	protected UserProfile getByJobRole_PrevAndNext(Session session,
		UserProfile userProfile, String jobrole,
		OrderByComparator<UserProfile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERPROFILE_WHERE);

		boolean bindJobrole = false;

		if (jobrole == null) {
			query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_1);
		}
		else if (jobrole.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_3);
		}
		else {
			bindJobrole = true;

			query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_2);
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
			query.append(UserProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobrole) {
			qPos.add(jobrole);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user profiles where jobrole = &#63; from the database.
	 *
	 * @param jobrole the jobrole
	 */
	@Override
	public void removeByJobRole(String jobrole) {
		for (UserProfile userProfile : findByJobRole(jobrole,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userProfile);
		}
	}

	/**
	 * Returns the number of user profiles where jobrole = &#63;.
	 *
	 * @param jobrole the jobrole
	 * @return the number of matching user profiles
	 */
	@Override
	public int countByJobRole(String jobrole) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBROLE;

		Object[] finderArgs = new Object[] { jobrole };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPROFILE_WHERE);

			boolean bindJobrole = false;

			if (jobrole == null) {
				query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_1);
			}
			else if (jobrole.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_3);
			}
			else {
				bindJobrole = true;

				query.append(_FINDER_COLUMN_JOBROLE_JOBROLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobrole) {
					qPos.add(jobrole);
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

	private static final String _FINDER_COLUMN_JOBROLE_JOBROLE_1 = "userProfile.jobrole IS NULL";
	private static final String _FINDER_COLUMN_JOBROLE_JOBROLE_2 = "userProfile.jobrole = ?";
	private static final String _FINDER_COLUMN_JOBROLE_JOBROLE_3 = "(userProfile.jobrole IS NULL OR userProfile.jobrole = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, UserProfileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			UserProfileModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user profile where userId = &#63; or throws a {@link NoSuchUserProfileException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user profile
	 * @throws NoSuchUserProfileException if a matching user profile could not be found
	 */
	@Override
	public UserProfile findByUserId(long userId)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByUserId(userId);

		if (userProfile == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserProfileException(msg.toString());
		}

		return userProfile;
	}

	/**
	 * Returns the user profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the user profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	 */
	@Override
	public UserProfile fetchByUserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof UserProfile) {
			UserProfile userProfile = (UserProfile)result;

			if ((userId != userProfile.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<UserProfile> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserProfilePersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserProfile userProfile = list.get(0);

					result = userProfile;

					cacheResult(userProfile);

					if ((userProfile.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userProfile);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, finderArgs);

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
			return (UserProfile)result;
		}
	}

	/**
	 * Removes the user profile where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user profile that was removed
	 */
	@Override
	public UserProfile removeByUserId(long userId)
		throws NoSuchUserProfileException {
		UserProfile userProfile = findByUserId(userId);

		return remove(userProfile);
	}

	/**
	 * Returns the number of user profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user profiles
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPROFILE_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userProfile.userId = ?";

	public UserProfilePersistenceImpl() {
		setModelClass(UserProfile.class);
	}

	/**
	 * Caches the user profile in the entity cache if it is enabled.
	 *
	 * @param userProfile the user profile
	 */
	@Override
	public void cacheResult(UserProfile userProfile) {
		entityCache.putResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileImpl.class, userProfile.getPrimaryKey(), userProfile);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { userProfile.getUserId() }, userProfile);

		userProfile.resetOriginalValues();
	}

	/**
	 * Caches the user profiles in the entity cache if it is enabled.
	 *
	 * @param userProfiles the user profiles
	 */
	@Override
	public void cacheResult(List<UserProfile> userProfiles) {
		for (UserProfile userProfile : userProfiles) {
			if (entityCache.getResult(
						UserProfileModelImpl.ENTITY_CACHE_ENABLED,
						UserProfileImpl.class, userProfile.getPrimaryKey()) == null) {
				cacheResult(userProfile);
			}
			else {
				userProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user profiles.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserProfileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user profile.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserProfile userProfile) {
		entityCache.removeResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileImpl.class, userProfile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserProfileModelImpl)userProfile, true);
	}

	@Override
	public void clearCache(List<UserProfile> userProfiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserProfile userProfile : userProfiles) {
			entityCache.removeResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
				UserProfileImpl.class, userProfile.getPrimaryKey());

			clearUniqueFindersCache((UserProfileModelImpl)userProfile, true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserProfileModelImpl userProfileModelImpl) {
		Object[] args = new Object[] { userProfileModelImpl.getUserId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
			userProfileModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserProfileModelImpl userProfileModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { userProfileModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}

		if ((userProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userProfileModelImpl.getOriginalUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new user profile with the primary key. Does not add the user profile to the database.
	 *
	 * @param profileId the primary key for the new user profile
	 * @return the new user profile
	 */
	@Override
	public UserProfile create(long profileId) {
		UserProfile userProfile = new UserProfileImpl();

		userProfile.setNew(true);
		userProfile.setPrimaryKey(profileId);

		String uuid = PortalUUIDUtil.generate();

		userProfile.setUuid(uuid);

		userProfile.setCompanyId(companyProvider.getCompanyId());

		return userProfile;
	}

	/**
	 * Removes the user profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileId the primary key of the user profile
	 * @return the user profile that was removed
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile remove(long profileId) throws NoSuchUserProfileException {
		return remove((Serializable)profileId);
	}

	/**
	 * Removes the user profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user profile
	 * @return the user profile that was removed
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile remove(Serializable primaryKey)
		throws NoSuchUserProfileException {
		Session session = null;

		try {
			session = openSession();

			UserProfile userProfile = (UserProfile)session.get(UserProfileImpl.class,
					primaryKey);

			if (userProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userProfile);
		}
		catch (NoSuchUserProfileException nsee) {
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
	protected UserProfile removeImpl(UserProfile userProfile) {
		userProfile = toUnwrappedModel(userProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userProfile)) {
				userProfile = (UserProfile)session.get(UserProfileImpl.class,
						userProfile.getPrimaryKeyObj());
			}

			if (userProfile != null) {
				session.delete(userProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userProfile != null) {
			clearCache(userProfile);
		}

		return userProfile;
	}

	@Override
	public UserProfile updateImpl(UserProfile userProfile) {
		userProfile = toUnwrappedModel(userProfile);

		boolean isNew = userProfile.isNew();

		UserProfileModelImpl userProfileModelImpl = (UserProfileModelImpl)userProfile;

		if (Validator.isNull(userProfile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userProfile.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userProfile.getCreateDate() == null)) {
			if (serviceContext == null) {
				userProfile.setCreateDate(now);
			}
			else {
				userProfile.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userProfileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userProfile.setModifiedDate(now);
			}
			else {
				userProfile.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userProfile.isNew()) {
				session.save(userProfile);

				userProfile.setNew(false);
			}
			else {
				userProfile = (UserProfile)session.merge(userProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userProfileModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userProfileModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userProfileModelImpl.getOriginalUuid(),
						userProfileModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						userProfileModelImpl.getUuid(),
						userProfileModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((userProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userProfileModelImpl.getOriginalJobrole()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_JOBROLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBROLE,
					args);

				args = new Object[] { userProfileModelImpl.getJobrole() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_JOBROLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBROLE,
					args);
			}
		}

		entityCache.putResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
			UserProfileImpl.class, userProfile.getPrimaryKey(), userProfile,
			false);

		clearUniqueFindersCache(userProfileModelImpl, false);
		cacheUniqueFindersCache(userProfileModelImpl);

		userProfile.resetOriginalValues();

		return userProfile;
	}

	protected UserProfile toUnwrappedModel(UserProfile userProfile) {
		if (userProfile instanceof UserProfileImpl) {
			return userProfile;
		}

		UserProfileImpl userProfileImpl = new UserProfileImpl();

		userProfileImpl.setNew(userProfile.isNew());
		userProfileImpl.setPrimaryKey(userProfile.getPrimaryKey());

		userProfileImpl.setUuid(userProfile.getUuid());
		userProfileImpl.setProfileId(userProfile.getProfileId());
		userProfileImpl.setUserId(userProfile.getUserId());
		userProfileImpl.setCompanyId(userProfile.getCompanyId());
		userProfileImpl.setCreatedById(userProfile.getCreatedById());
		userProfileImpl.setCreateDate(userProfile.getCreateDate());
		userProfileImpl.setModifiedDate(userProfile.getModifiedDate());
		userProfileImpl.setCommunicationPreferences(userProfile.getCommunicationPreferences());
		userProfileImpl.setRegion(userProfile.getRegion());
		userProfileImpl.setSite(userProfile.getSite());
		userProfileImpl.setServer(userProfile.getServer());
		userProfileImpl.setDivision(userProfile.getDivision());
		userProfileImpl.setLanguage(userProfile.getLanguage());
		userProfileImpl.setTimezone(userProfile.getTimezone());
		userProfileImpl.setWorkHours(userProfile.getWorkHours());
		userProfileImpl.setJobrole(userProfile.getJobrole());
		userProfileImpl.setInterests(userProfile.getInterests());
		userProfileImpl.setPortlets(userProfile.getPortlets());

		return userProfileImpl;
	}

	/**
	 * Returns the user profile with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user profile
	 * @return the user profile
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserProfileException {
		UserProfile userProfile = fetchByPrimaryKey(primaryKey);

		if (userProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userProfile;
	}

	/**
	 * Returns the user profile with the primary key or throws a {@link NoSuchUserProfileException} if it could not be found.
	 *
	 * @param profileId the primary key of the user profile
	 * @return the user profile
	 * @throws NoSuchUserProfileException if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile findByPrimaryKey(long profileId)
		throws NoSuchUserProfileException {
		return findByPrimaryKey((Serializable)profileId);
	}

	/**
	 * Returns the user profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user profile
	 * @return the user profile, or <code>null</code> if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
				UserProfileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserProfile userProfile = (UserProfile)serializable;

		if (userProfile == null) {
			Session session = null;

			try {
				session = openSession();

				userProfile = (UserProfile)session.get(UserProfileImpl.class,
						primaryKey);

				if (userProfile != null) {
					cacheResult(userProfile);
				}
				else {
					entityCache.putResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
						UserProfileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
					UserProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userProfile;
	}

	/**
	 * Returns the user profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profileId the primary key of the user profile
	 * @return the user profile, or <code>null</code> if a user profile with the primary key could not be found
	 */
	@Override
	public UserProfile fetchByPrimaryKey(long profileId) {
		return fetchByPrimaryKey((Serializable)profileId);
	}

	@Override
	public Map<Serializable, UserProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserProfile> map = new HashMap<Serializable, UserProfile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserProfile userProfile = fetchByPrimaryKey(primaryKey);

			if (userProfile != null) {
				map.put(primaryKey, userProfile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
					UserProfileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserProfile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERPROFILE_WHERE_PKS_IN);

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

			for (UserProfile userProfile : (List<UserProfile>)q.list()) {
				map.put(userProfile.getPrimaryKeyObj(), userProfile);

				cacheResult(userProfile);

				uncachedPrimaryKeys.remove(userProfile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserProfileModelImpl.ENTITY_CACHE_ENABLED,
					UserProfileImpl.class, primaryKey, nullModel);
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
	 * Returns all the user profiles.
	 *
	 * @return the user profiles
	 */
	@Override
	public List<UserProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @return the range of user profiles
	 */
	@Override
	public List<UserProfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user profiles
	 */
	@Override
	public List<UserProfile> findAll(int start, int end,
		OrderByComparator<UserProfile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user profiles
	 * @param end the upper bound of the range of user profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user profiles
	 */
	@Override
	public List<UserProfile> findAll(int start, int end,
		OrderByComparator<UserProfile> orderByComparator,
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

		List<UserProfile> list = null;

		if (retrieveFromCache) {
			list = (List<UserProfile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPROFILE;

				if (pagination) {
					sql = sql.concat(UserProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserProfile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserProfile userProfile : findAll()) {
			remove(userProfile);
		}
	}

	/**
	 * Returns the number of user profiles.
	 *
	 * @return the number of user profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPROFILE);

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
		return UserProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user profile persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserProfileImpl.class.getName());
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
	private static final String _SQL_SELECT_USERPROFILE = "SELECT userProfile FROM UserProfile userProfile";
	private static final String _SQL_SELECT_USERPROFILE_WHERE_PKS_IN = "SELECT userProfile FROM UserProfile userProfile WHERE profileId IN (";
	private static final String _SQL_SELECT_USERPROFILE_WHERE = "SELECT userProfile FROM UserProfile userProfile WHERE ";
	private static final String _SQL_COUNT_USERPROFILE = "SELECT COUNT(userProfile) FROM UserProfile userProfile";
	private static final String _SQL_COUNT_USERPROFILE_WHERE = "SELECT COUNT(userProfile) FROM UserProfile userProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserProfile exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserProfilePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}