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

package com.externalservices.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.externalservices.exception.NoSuchleykartEnquiryException;

import com.externalservices.model.impl.leykartEnquiryImpl;
import com.externalservices.model.impl.leykartEnquiryModelImpl;
import com.externalservices.model.leykartEnquiry;

import com.externalservices.service.persistence.leykartEnquiryPersistence;

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
 * The persistence implementation for the leykart enquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leykartEnquiryPersistence
 * @see com.externalservices.service.persistence.leykartEnquiryUtil
 * @generated
 */
@ProviderType
public class leykartEnquiryPersistenceImpl extends BasePersistenceImpl<leykartEnquiry>
	implements leykartEnquiryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link leykartEnquiryUtil} to access the leykart enquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = leykartEnquiryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED,
			leykartEnquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED,
			leykartEnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED,
			leykartEnquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED,
			leykartEnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			leykartEnquiryModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the leykart enquiries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leykart enquiries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @return the range of matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leykart enquiries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid(String uuid, int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leykart enquiries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid(String uuid, int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator,
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

		List<leykartEnquiry> list = null;

		if (retrieveFromCache) {
			list = (List<leykartEnquiry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leykartEnquiry leykartEnquiry : list) {
					if (!Objects.equals(uuid, leykartEnquiry.getUuid())) {
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

			query.append(_SQL_SELECT_LEYKARTENQUIRY_WHERE);

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
				query.append(leykartEnquiryModelImpl.ORDER_BY_JPQL);
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
					list = (List<leykartEnquiry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<leykartEnquiry>)QueryUtil.list(q,
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
	 * Returns the first leykart enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry findByUuid_First(String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = fetchByUuid_First(uuid,
				orderByComparator);

		if (leykartEnquiry != null) {
			return leykartEnquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchleykartEnquiryException(msg.toString());
	}

	/**
	 * Returns the first leykart enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry fetchByUuid_First(String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		List<leykartEnquiry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leykart enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry findByUuid_Last(String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = fetchByUuid_Last(uuid, orderByComparator);

		if (leykartEnquiry != null) {
			return leykartEnquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchleykartEnquiryException(msg.toString());
	}

	/**
	 * Returns the last leykart enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry fetchByUuid_Last(String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<leykartEnquiry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leykart enquiries before and after the current leykart enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param Eid the primary key of the current leykart enquiry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry[] findByUuid_PrevAndNext(long Eid, String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = findByPrimaryKey(Eid);

		Session session = null;

		try {
			session = openSession();

			leykartEnquiry[] array = new leykartEnquiryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, leykartEnquiry, uuid,
					orderByComparator, true);

			array[1] = leykartEnquiry;

			array[2] = getByUuid_PrevAndNext(session, leykartEnquiry, uuid,
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

	protected leykartEnquiry getByUuid_PrevAndNext(Session session,
		leykartEnquiry leykartEnquiry, String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEYKARTENQUIRY_WHERE);

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
			query.append(leykartEnquiryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(leykartEnquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<leykartEnquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leykart enquiries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (leykartEnquiry leykartEnquiry : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leykartEnquiry);
		}
	}

	/**
	 * Returns the number of leykart enquiries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leykart enquiries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEYKARTENQUIRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "leykartEnquiry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "leykartEnquiry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(leykartEnquiry.uuid IS NULL OR leykartEnquiry.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED,
			leykartEnquiryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED,
			leykartEnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			leykartEnquiryModelImpl.UUID_COLUMN_BITMASK |
			leykartEnquiryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @return the range of matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<leykartEnquiry> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator,
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

		List<leykartEnquiry> list = null;

		if (retrieveFromCache) {
			list = (List<leykartEnquiry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leykartEnquiry leykartEnquiry : list) {
					if (!Objects.equals(uuid, leykartEnquiry.getUuid()) ||
							(companyId != leykartEnquiry.getCompanyId())) {
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

			query.append(_SQL_SELECT_LEYKARTENQUIRY_WHERE);

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
				query.append(leykartEnquiryModelImpl.ORDER_BY_JPQL);
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
					list = (List<leykartEnquiry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<leykartEnquiry>)QueryUtil.list(q,
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
	 * Returns the first leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (leykartEnquiry != null) {
			return leykartEnquiry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchleykartEnquiryException(msg.toString());
	}

	/**
	 * Returns the first leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		List<leykartEnquiry> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (leykartEnquiry != null) {
			return leykartEnquiry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchleykartEnquiryException(msg.toString());
	}

	/**
	 * Returns the last leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	 */
	@Override
	public leykartEnquiry fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<leykartEnquiry> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leykart enquiries before and after the current leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Eid the primary key of the current leykart enquiry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry[] findByUuid_C_PrevAndNext(long Eid, String uuid,
		long companyId, OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = findByPrimaryKey(Eid);

		Session session = null;

		try {
			session = openSession();

			leykartEnquiry[] array = new leykartEnquiryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, leykartEnquiry, uuid,
					companyId, orderByComparator, true);

			array[1] = leykartEnquiry;

			array[2] = getByUuid_C_PrevAndNext(session, leykartEnquiry, uuid,
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

	protected leykartEnquiry getByUuid_C_PrevAndNext(Session session,
		leykartEnquiry leykartEnquiry, String uuid, long companyId,
		OrderByComparator<leykartEnquiry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEYKARTENQUIRY_WHERE);

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
			query.append(leykartEnquiryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(leykartEnquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<leykartEnquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leykart enquiries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (leykartEnquiry leykartEnquiry : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leykartEnquiry);
		}
	}

	/**
	 * Returns the number of leykart enquiries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leykart enquiries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEYKARTENQUIRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "leykartEnquiry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "leykartEnquiry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(leykartEnquiry.uuid IS NULL OR leykartEnquiry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "leykartEnquiry.companyId = ?";

	public leykartEnquiryPersistenceImpl() {
		setModelClass(leykartEnquiry.class);

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
	 * Caches the leykart enquiry in the entity cache if it is enabled.
	 *
	 * @param leykartEnquiry the leykart enquiry
	 */
	@Override
	public void cacheResult(leykartEnquiry leykartEnquiry) {
		entityCache.putResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryImpl.class, leykartEnquiry.getPrimaryKey(),
			leykartEnquiry);

		leykartEnquiry.resetOriginalValues();
	}

	/**
	 * Caches the leykart enquiries in the entity cache if it is enabled.
	 *
	 * @param leykartEnquiries the leykart enquiries
	 */
	@Override
	public void cacheResult(List<leykartEnquiry> leykartEnquiries) {
		for (leykartEnquiry leykartEnquiry : leykartEnquiries) {
			if (entityCache.getResult(
						leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
						leykartEnquiryImpl.class, leykartEnquiry.getPrimaryKey()) == null) {
				cacheResult(leykartEnquiry);
			}
			else {
				leykartEnquiry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leykart enquiries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(leykartEnquiryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leykart enquiry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(leykartEnquiry leykartEnquiry) {
		entityCache.removeResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryImpl.class, leykartEnquiry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<leykartEnquiry> leykartEnquiries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (leykartEnquiry leykartEnquiry : leykartEnquiries) {
			entityCache.removeResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
				leykartEnquiryImpl.class, leykartEnquiry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leykart enquiry with the primary key. Does not add the leykart enquiry to the database.
	 *
	 * @param Eid the primary key for the new leykart enquiry
	 * @return the new leykart enquiry
	 */
	@Override
	public leykartEnquiry create(long Eid) {
		leykartEnquiry leykartEnquiry = new leykartEnquiryImpl();

		leykartEnquiry.setNew(true);
		leykartEnquiry.setPrimaryKey(Eid);

		String uuid = PortalUUIDUtil.generate();

		leykartEnquiry.setUuid(uuid);

		leykartEnquiry.setCompanyId(companyProvider.getCompanyId());

		return leykartEnquiry;
	}

	/**
	 * Removes the leykart enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Eid the primary key of the leykart enquiry
	 * @return the leykart enquiry that was removed
	 * @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry remove(long Eid) throws NoSuchleykartEnquiryException {
		return remove((Serializable)Eid);
	}

	/**
	 * Removes the leykart enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leykart enquiry
	 * @return the leykart enquiry that was removed
	 * @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry remove(Serializable primaryKey)
		throws NoSuchleykartEnquiryException {
		Session session = null;

		try {
			session = openSession();

			leykartEnquiry leykartEnquiry = (leykartEnquiry)session.get(leykartEnquiryImpl.class,
					primaryKey);

			if (leykartEnquiry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchleykartEnquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leykartEnquiry);
		}
		catch (NoSuchleykartEnquiryException nsee) {
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
	protected leykartEnquiry removeImpl(leykartEnquiry leykartEnquiry) {
		leykartEnquiry = toUnwrappedModel(leykartEnquiry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leykartEnquiry)) {
				leykartEnquiry = (leykartEnquiry)session.get(leykartEnquiryImpl.class,
						leykartEnquiry.getPrimaryKeyObj());
			}

			if (leykartEnquiry != null) {
				session.delete(leykartEnquiry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leykartEnquiry != null) {
			clearCache(leykartEnquiry);
		}

		return leykartEnquiry;
	}

	@Override
	public leykartEnquiry updateImpl(leykartEnquiry leykartEnquiry) {
		leykartEnquiry = toUnwrappedModel(leykartEnquiry);

		boolean isNew = leykartEnquiry.isNew();

		leykartEnquiryModelImpl leykartEnquiryModelImpl = (leykartEnquiryModelImpl)leykartEnquiry;

		if (Validator.isNull(leykartEnquiry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leykartEnquiry.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (leykartEnquiry.getCreateDate() == null)) {
			if (serviceContext == null) {
				leykartEnquiry.setCreateDate(now);
			}
			else {
				leykartEnquiry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!leykartEnquiryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leykartEnquiry.setModifiedDate(now);
			}
			else {
				leykartEnquiry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (leykartEnquiry.isNew()) {
				session.save(leykartEnquiry);

				leykartEnquiry.setNew(false);
			}
			else {
				leykartEnquiry = (leykartEnquiry)session.merge(leykartEnquiry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!leykartEnquiryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { leykartEnquiryModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					leykartEnquiryModelImpl.getUuid(),
					leykartEnquiryModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((leykartEnquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leykartEnquiryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { leykartEnquiryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((leykartEnquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leykartEnquiryModelImpl.getOriginalUuid(),
						leykartEnquiryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						leykartEnquiryModelImpl.getUuid(),
						leykartEnquiryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
			leykartEnquiryImpl.class, leykartEnquiry.getPrimaryKey(),
			leykartEnquiry, false);

		leykartEnquiry.resetOriginalValues();

		return leykartEnquiry;
	}

	protected leykartEnquiry toUnwrappedModel(leykartEnquiry leykartEnquiry) {
		if (leykartEnquiry instanceof leykartEnquiryImpl) {
			return leykartEnquiry;
		}

		leykartEnquiryImpl leykartEnquiryImpl = new leykartEnquiryImpl();

		leykartEnquiryImpl.setNew(leykartEnquiry.isNew());
		leykartEnquiryImpl.setPrimaryKey(leykartEnquiry.getPrimaryKey());

		leykartEnquiryImpl.setUuid(leykartEnquiry.getUuid());
		leykartEnquiryImpl.setEid(leykartEnquiry.getEid());
		leykartEnquiryImpl.setFirstName(leykartEnquiry.getFirstName());
		leykartEnquiryImpl.setLastName(leykartEnquiry.getLastName());
		leykartEnquiryImpl.setEmail(leykartEnquiry.getEmail());
		leykartEnquiryImpl.setContactNumber(leykartEnquiry.getContactNumber());
		leykartEnquiryImpl.setPartName(leykartEnquiry.getPartName());
		leykartEnquiryImpl.setPartNumber(leykartEnquiry.getPartNumber());
		leykartEnquiryImpl.setMessage(leykartEnquiry.getMessage());
		leykartEnquiryImpl.setCompanyId(leykartEnquiry.getCompanyId());
		leykartEnquiryImpl.setUserId(leykartEnquiry.getUserId());
		leykartEnquiryImpl.setUserName(leykartEnquiry.getUserName());
		leykartEnquiryImpl.setCreateDate(leykartEnquiry.getCreateDate());
		leykartEnquiryImpl.setModifiedDate(leykartEnquiry.getModifiedDate());

		return leykartEnquiryImpl;
	}

	/**
	 * Returns the leykart enquiry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leykart enquiry
	 * @return the leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchleykartEnquiryException {
		leykartEnquiry leykartEnquiry = fetchByPrimaryKey(primaryKey);

		if (leykartEnquiry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchleykartEnquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leykartEnquiry;
	}

	/**
	 * Returns the leykart enquiry with the primary key or throws a {@link NoSuchleykartEnquiryException} if it could not be found.
	 *
	 * @param Eid the primary key of the leykart enquiry
	 * @return the leykart enquiry
	 * @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry findByPrimaryKey(long Eid)
		throws NoSuchleykartEnquiryException {
		return findByPrimaryKey((Serializable)Eid);
	}

	/**
	 * Returns the leykart enquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leykart enquiry
	 * @return the leykart enquiry, or <code>null</code> if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
				leykartEnquiryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		leykartEnquiry leykartEnquiry = (leykartEnquiry)serializable;

		if (leykartEnquiry == null) {
			Session session = null;

			try {
				session = openSession();

				leykartEnquiry = (leykartEnquiry)session.get(leykartEnquiryImpl.class,
						primaryKey);

				if (leykartEnquiry != null) {
					cacheResult(leykartEnquiry);
				}
				else {
					entityCache.putResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
						leykartEnquiryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
					leykartEnquiryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leykartEnquiry;
	}

	/**
	 * Returns the leykart enquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Eid the primary key of the leykart enquiry
	 * @return the leykart enquiry, or <code>null</code> if a leykart enquiry with the primary key could not be found
	 */
	@Override
	public leykartEnquiry fetchByPrimaryKey(long Eid) {
		return fetchByPrimaryKey((Serializable)Eid);
	}

	@Override
	public Map<Serializable, leykartEnquiry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, leykartEnquiry> map = new HashMap<Serializable, leykartEnquiry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			leykartEnquiry leykartEnquiry = fetchByPrimaryKey(primaryKey);

			if (leykartEnquiry != null) {
				map.put(primaryKey, leykartEnquiry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
					leykartEnquiryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (leykartEnquiry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEYKARTENQUIRY_WHERE_PKS_IN);

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

			for (leykartEnquiry leykartEnquiry : (List<leykartEnquiry>)q.list()) {
				map.put(leykartEnquiry.getPrimaryKeyObj(), leykartEnquiry);

				cacheResult(leykartEnquiry);

				uncachedPrimaryKeys.remove(leykartEnquiry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(leykartEnquiryModelImpl.ENTITY_CACHE_ENABLED,
					leykartEnquiryImpl.class, primaryKey, nullModel);
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
	 * Returns all the leykart enquiries.
	 *
	 * @return the leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leykart enquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @return the range of leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leykart enquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findAll(int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leykart enquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leykart enquiries
	 * @param end the upper bound of the range of leykart enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leykart enquiries
	 */
	@Override
	public List<leykartEnquiry> findAll(int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator,
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

		List<leykartEnquiry> list = null;

		if (retrieveFromCache) {
			list = (List<leykartEnquiry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEYKARTENQUIRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEYKARTENQUIRY;

				if (pagination) {
					sql = sql.concat(leykartEnquiryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<leykartEnquiry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<leykartEnquiry>)QueryUtil.list(q,
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
	 * Removes all the leykart enquiries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (leykartEnquiry leykartEnquiry : findAll()) {
			remove(leykartEnquiry);
		}
	}

	/**
	 * Returns the number of leykart enquiries.
	 *
	 * @return the number of leykart enquiries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEYKARTENQUIRY);

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
		return leykartEnquiryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leykart enquiry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(leykartEnquiryImpl.class.getName());
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
	private static final String _SQL_SELECT_LEYKARTENQUIRY = "SELECT leykartEnquiry FROM leykartEnquiry leykartEnquiry";
	private static final String _SQL_SELECT_LEYKARTENQUIRY_WHERE_PKS_IN = "SELECT leykartEnquiry FROM leykartEnquiry leykartEnquiry WHERE Eid IN (";
	private static final String _SQL_SELECT_LEYKARTENQUIRY_WHERE = "SELECT leykartEnquiry FROM leykartEnquiry leykartEnquiry WHERE ";
	private static final String _SQL_COUNT_LEYKARTENQUIRY = "SELECT COUNT(leykartEnquiry) FROM leykartEnquiry leykartEnquiry";
	private static final String _SQL_COUNT_LEYKARTENQUIRY_WHERE = "SELECT COUNT(leykartEnquiry) FROM leykartEnquiry leykartEnquiry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leykartEnquiry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No leykartEnquiry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No leykartEnquiry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(leykartEnquiryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}