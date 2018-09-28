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

import com.MappingServices.exception.NoSuchEnquiryException;

import com.MappingServices.model.Enquiry;
import com.MappingServices.model.impl.EnquiryImpl;
import com.MappingServices.model.impl.EnquiryModelImpl;

import com.MappingServices.service.persistence.EnquiryPersistence;

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
 * The persistence implementation for the enquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnquiryPersistence
 * @see com.MappingServices.service.persistence.EnquiryUtil
 * @generated
 */
@ProviderType
public class EnquiryPersistenceImpl extends BasePersistenceImpl<Enquiry>
	implements EnquiryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnquiryUtil} to access the enquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnquiryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryModelImpl.FINDER_CACHE_ENABLED, EnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryModelImpl.FINDER_CACHE_ENABLED, EnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryModelImpl.FINDER_CACHE_ENABLED, EnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryModelImpl.FINDER_CACHE_ENABLED, EnquiryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EnquiryModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the enquiries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching enquiries
	 */
	@Override
	public List<Enquiry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enquiries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enquiries
	 * @param end the upper bound of the range of enquiries (not inclusive)
	 * @return the range of matching enquiries
	 */
	@Override
	public List<Enquiry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enquiries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enquiries
	 * @param end the upper bound of the range of enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enquiries
	 */
	@Override
	public List<Enquiry> findByUuid(String uuid, int start, int end,
		OrderByComparator<Enquiry> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the enquiries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of enquiries
	 * @param end the upper bound of the range of enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching enquiries
	 */
	@Override
	public List<Enquiry> findByUuid(String uuid, int start, int end,
		OrderByComparator<Enquiry> orderByComparator, boolean retrieveFromCache) {
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

		List<Enquiry> list = null;

		if (retrieveFromCache) {
			list = (List<Enquiry>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Enquiry enquiry : list) {
					if (!Objects.equals(uuid, enquiry.getUuid())) {
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

			query.append(_SQL_SELECT_ENQUIRY_WHERE);

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
				query.append(EnquiryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Enquiry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Enquiry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enquiry
	 * @throws NoSuchEnquiryException if a matching enquiry could not be found
	 */
	@Override
	public Enquiry findByUuid_First(String uuid,
		OrderByComparator<Enquiry> orderByComparator)
		throws NoSuchEnquiryException {
		Enquiry enquiry = fetchByUuid_First(uuid, orderByComparator);

		if (enquiry != null) {
			return enquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnquiryException(msg.toString());
	}

	/**
	 * Returns the first enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enquiry, or <code>null</code> if a matching enquiry could not be found
	 */
	@Override
	public Enquiry fetchByUuid_First(String uuid,
		OrderByComparator<Enquiry> orderByComparator) {
		List<Enquiry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enquiry
	 * @throws NoSuchEnquiryException if a matching enquiry could not be found
	 */
	@Override
	public Enquiry findByUuid_Last(String uuid,
		OrderByComparator<Enquiry> orderByComparator)
		throws NoSuchEnquiryException {
		Enquiry enquiry = fetchByUuid_Last(uuid, orderByComparator);

		if (enquiry != null) {
			return enquiry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnquiryException(msg.toString());
	}

	/**
	 * Returns the last enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enquiry, or <code>null</code> if a matching enquiry could not be found
	 */
	@Override
	public Enquiry fetchByUuid_Last(String uuid,
		OrderByComparator<Enquiry> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Enquiry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enquiries before and after the current enquiry in the ordered set where uuid = &#63;.
	 *
	 * @param Eid the primary key of the current enquiry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enquiry
	 * @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry[] findByUuid_PrevAndNext(long Eid, String uuid,
		OrderByComparator<Enquiry> orderByComparator)
		throws NoSuchEnquiryException {
		Enquiry enquiry = findByPrimaryKey(Eid);

		Session session = null;

		try {
			session = openSession();

			Enquiry[] array = new EnquiryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, enquiry, uuid,
					orderByComparator, true);

			array[1] = enquiry;

			array[2] = getByUuid_PrevAndNext(session, enquiry, uuid,
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

	protected Enquiry getByUuid_PrevAndNext(Session session, Enquiry enquiry,
		String uuid, OrderByComparator<Enquiry> orderByComparator,
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

		query.append(_SQL_SELECT_ENQUIRY_WHERE);

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
			query.append(EnquiryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(enquiry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Enquiry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enquiries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Enquiry enquiry : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(enquiry);
		}
	}

	/**
	 * Returns the number of enquiries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching enquiries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENQUIRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "enquiry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "enquiry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(enquiry.uuid IS NULL OR enquiry.uuid = '')";

	public EnquiryPersistenceImpl() {
		setModelClass(Enquiry.class);

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
	 * Caches the enquiry in the entity cache if it is enabled.
	 *
	 * @param enquiry the enquiry
	 */
	@Override
	public void cacheResult(Enquiry enquiry) {
		entityCache.putResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryImpl.class, enquiry.getPrimaryKey(), enquiry);

		enquiry.resetOriginalValues();
	}

	/**
	 * Caches the enquiries in the entity cache if it is enabled.
	 *
	 * @param enquiries the enquiries
	 */
	@Override
	public void cacheResult(List<Enquiry> enquiries) {
		for (Enquiry enquiry : enquiries) {
			if (entityCache.getResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
						EnquiryImpl.class, enquiry.getPrimaryKey()) == null) {
				cacheResult(enquiry);
			}
			else {
				enquiry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enquiries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EnquiryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enquiry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Enquiry enquiry) {
		entityCache.removeResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryImpl.class, enquiry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Enquiry> enquiries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Enquiry enquiry : enquiries) {
			entityCache.removeResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
				EnquiryImpl.class, enquiry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new enquiry with the primary key. Does not add the enquiry to the database.
	 *
	 * @param Eid the primary key for the new enquiry
	 * @return the new enquiry
	 */
	@Override
	public Enquiry create(long Eid) {
		Enquiry enquiry = new EnquiryImpl();

		enquiry.setNew(true);
		enquiry.setPrimaryKey(Eid);

		String uuid = PortalUUIDUtil.generate();

		enquiry.setUuid(uuid);

		return enquiry;
	}

	/**
	 * Removes the enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Eid the primary key of the enquiry
	 * @return the enquiry that was removed
	 * @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry remove(long Eid) throws NoSuchEnquiryException {
		return remove((Serializable)Eid);
	}

	/**
	 * Removes the enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enquiry
	 * @return the enquiry that was removed
	 * @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry remove(Serializable primaryKey)
		throws NoSuchEnquiryException {
		Session session = null;

		try {
			session = openSession();

			Enquiry enquiry = (Enquiry)session.get(EnquiryImpl.class, primaryKey);

			if (enquiry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enquiry);
		}
		catch (NoSuchEnquiryException nsee) {
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
	protected Enquiry removeImpl(Enquiry enquiry) {
		enquiry = toUnwrappedModel(enquiry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enquiry)) {
				enquiry = (Enquiry)session.get(EnquiryImpl.class,
						enquiry.getPrimaryKeyObj());
			}

			if (enquiry != null) {
				session.delete(enquiry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (enquiry != null) {
			clearCache(enquiry);
		}

		return enquiry;
	}

	@Override
	public Enquiry updateImpl(Enquiry enquiry) {
		enquiry = toUnwrappedModel(enquiry);

		boolean isNew = enquiry.isNew();

		EnquiryModelImpl enquiryModelImpl = (EnquiryModelImpl)enquiry;

		if (Validator.isNull(enquiry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			enquiry.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (enquiry.getCreateDate() == null)) {
			if (serviceContext == null) {
				enquiry.setCreateDate(now);
			}
			else {
				enquiry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!enquiryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				enquiry.setModifiedDate(now);
			}
			else {
				enquiry.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (enquiry.isNew()) {
				session.save(enquiry);

				enquiry.setNew(false);
			}
			else {
				enquiry = (Enquiry)session.merge(enquiry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EnquiryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { enquiryModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((enquiryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { enquiryModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { enquiryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
			EnquiryImpl.class, enquiry.getPrimaryKey(), enquiry, false);

		enquiry.resetOriginalValues();

		return enquiry;
	}

	protected Enquiry toUnwrappedModel(Enquiry enquiry) {
		if (enquiry instanceof EnquiryImpl) {
			return enquiry;
		}

		EnquiryImpl enquiryImpl = new EnquiryImpl();

		enquiryImpl.setNew(enquiry.isNew());
		enquiryImpl.setPrimaryKey(enquiry.getPrimaryKey());

		enquiryImpl.setUuid(enquiry.getUuid());
		enquiryImpl.setEid(enquiry.getEid());
		enquiryImpl.setFirstName(enquiry.getFirstName());
		enquiryImpl.setLastName(enquiry.getLastName());
		enquiryImpl.setEmail(enquiry.getEmail());
		enquiryImpl.setContactNumber(enquiry.getContactNumber());
		enquiryImpl.setPartName(enquiry.getPartName());
		enquiryImpl.setPartNumber(enquiry.getPartNumber());
		enquiryImpl.setMessage(enquiry.getMessage());
		enquiryImpl.setCreateDate(enquiry.getCreateDate());
		enquiryImpl.setModifiedDate(enquiry.getModifiedDate());

		return enquiryImpl;
	}

	/**
	 * Returns the enquiry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enquiry
	 * @return the enquiry
	 * @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnquiryException {
		Enquiry enquiry = fetchByPrimaryKey(primaryKey);

		if (enquiry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnquiryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return enquiry;
	}

	/**
	 * Returns the enquiry with the primary key or throws a {@link NoSuchEnquiryException} if it could not be found.
	 *
	 * @param Eid the primary key of the enquiry
	 * @return the enquiry
	 * @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry findByPrimaryKey(long Eid) throws NoSuchEnquiryException {
		return findByPrimaryKey((Serializable)Eid);
	}

	/**
	 * Returns the enquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enquiry
	 * @return the enquiry, or <code>null</code> if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
				EnquiryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Enquiry enquiry = (Enquiry)serializable;

		if (enquiry == null) {
			Session session = null;

			try {
				session = openSession();

				enquiry = (Enquiry)session.get(EnquiryImpl.class, primaryKey);

				if (enquiry != null) {
					cacheResult(enquiry);
				}
				else {
					entityCache.putResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
						EnquiryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
					EnquiryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return enquiry;
	}

	/**
	 * Returns the enquiry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Eid the primary key of the enquiry
	 * @return the enquiry, or <code>null</code> if a enquiry with the primary key could not be found
	 */
	@Override
	public Enquiry fetchByPrimaryKey(long Eid) {
		return fetchByPrimaryKey((Serializable)Eid);
	}

	@Override
	public Map<Serializable, Enquiry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Enquiry> map = new HashMap<Serializable, Enquiry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Enquiry enquiry = fetchByPrimaryKey(primaryKey);

			if (enquiry != null) {
				map.put(primaryKey, enquiry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
					EnquiryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Enquiry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ENQUIRY_WHERE_PKS_IN);

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

			for (Enquiry enquiry : (List<Enquiry>)q.list()) {
				map.put(enquiry.getPrimaryKeyObj(), enquiry);

				cacheResult(enquiry);

				uncachedPrimaryKeys.remove(enquiry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EnquiryModelImpl.ENTITY_CACHE_ENABLED,
					EnquiryImpl.class, primaryKey, nullModel);
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
	 * Returns all the enquiries.
	 *
	 * @return the enquiries
	 */
	@Override
	public List<Enquiry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enquiries
	 * @param end the upper bound of the range of enquiries (not inclusive)
	 * @return the range of enquiries
	 */
	@Override
	public List<Enquiry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enquiries
	 * @param end the upper bound of the range of enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enquiries
	 */
	@Override
	public List<Enquiry> findAll(int start, int end,
		OrderByComparator<Enquiry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the enquiries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enquiries
	 * @param end the upper bound of the range of enquiries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of enquiries
	 */
	@Override
	public List<Enquiry> findAll(int start, int end,
		OrderByComparator<Enquiry> orderByComparator, boolean retrieveFromCache) {
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

		List<Enquiry> list = null;

		if (retrieveFromCache) {
			list = (List<Enquiry>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ENQUIRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENQUIRY;

				if (pagination) {
					sql = sql.concat(EnquiryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Enquiry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Enquiry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the enquiries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Enquiry enquiry : findAll()) {
			remove(enquiry);
		}
	}

	/**
	 * Returns the number of enquiries.
	 *
	 * @return the number of enquiries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENQUIRY);

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
		return EnquiryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the enquiry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EnquiryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ENQUIRY = "SELECT enquiry FROM Enquiry enquiry";
	private static final String _SQL_SELECT_ENQUIRY_WHERE_PKS_IN = "SELECT enquiry FROM Enquiry enquiry WHERE Eid IN (";
	private static final String _SQL_SELECT_ENQUIRY_WHERE = "SELECT enquiry FROM Enquiry enquiry WHERE ";
	private static final String _SQL_COUNT_ENQUIRY = "SELECT COUNT(enquiry) FROM Enquiry enquiry";
	private static final String _SQL_COUNT_ENQUIRY_WHERE = "SELECT COUNT(enquiry) FROM Enquiry enquiry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enquiry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Enquiry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Enquiry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EnquiryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}