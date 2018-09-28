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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_and_reasoncodeException;
import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_action_and_reasoncodePersistence;

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
 * The persistence implementation for the WFMS_action_and_reasoncode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_and_reasoncodePersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_action_and_reasoncodeUtil
 * @generated
 */
@ProviderType
public class WFMS_action_and_reasoncodePersistenceImpl
	extends BasePersistenceImpl<WFMS_action_and_reasoncode>
	implements WFMS_action_and_reasoncodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_action_and_reasoncodeUtil} to access the WFMS_action_and_reasoncode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_action_and_reasoncodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeModelImpl.FINDER_CACHE_ENABLED,
			WFMS_action_and_reasoncodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeModelImpl.FINDER_CACHE_ENABLED,
			WFMS_action_and_reasoncodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_REASONCODE = new FinderPath(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeModelImpl.FINDER_CACHE_ENABLED,
			WFMS_action_and_reasoncodeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByreasoncode", new String[] { String.class.getName() },
			WFMS_action_and_reasoncodeModelImpl.AARID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REASONCODE = new FinderPath(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByreasoncode", new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_action_and_reasoncode where aarId = &#63; or throws a {@link NoSuchWFMS_action_and_reasoncodeException} if it could not be found.
	 *
	 * @param aarId the aar ID
	 * @return the matching WFMS_action_and_reasoncode
	 * @throws NoSuchWFMS_action_and_reasoncodeException if a matching WFMS_action_and_reasoncode could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode findByreasoncode(String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException {
		WFMS_action_and_reasoncode wfms_action_and_reasoncode = fetchByreasoncode(aarId);

		if (wfms_action_and_reasoncode == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("aarId=");
			msg.append(aarId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_action_and_reasoncodeException(msg.toString());
		}

		return wfms_action_and_reasoncode;
	}

	/**
	 * Returns the WFMS_action_and_reasoncode where aarId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param aarId the aar ID
	 * @return the matching WFMS_action_and_reasoncode, or <code>null</code> if a matching WFMS_action_and_reasoncode could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode fetchByreasoncode(String aarId) {
		return fetchByreasoncode(aarId, true);
	}

	/**
	 * Returns the WFMS_action_and_reasoncode where aarId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param aarId the aar ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_action_and_reasoncode, or <code>null</code> if a matching WFMS_action_and_reasoncode could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode fetchByreasoncode(String aarId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { aarId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_REASONCODE,
					finderArgs, this);
		}

		if (result instanceof WFMS_action_and_reasoncode) {
			WFMS_action_and_reasoncode wfms_action_and_reasoncode = (WFMS_action_and_reasoncode)result;

			if (!Objects.equals(aarId, wfms_action_and_reasoncode.getAarId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_ACTION_AND_REASONCODE_WHERE);

			boolean bindAarId = false;

			if (aarId == null) {
				query.append(_FINDER_COLUMN_REASONCODE_AARID_1);
			}
			else if (aarId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REASONCODE_AARID_3);
			}
			else {
				bindAarId = true;

				query.append(_FINDER_COLUMN_REASONCODE_AARID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAarId) {
					qPos.add(aarId);
				}

				List<WFMS_action_and_reasoncode> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_REASONCODE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_action_and_reasoncodePersistenceImpl.fetchByreasoncode(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_action_and_reasoncode wfms_action_and_reasoncode = list.get(0);

					result = wfms_action_and_reasoncode;

					cacheResult(wfms_action_and_reasoncode);

					if ((wfms_action_and_reasoncode.getAarId() == null) ||
							!wfms_action_and_reasoncode.getAarId().equals(aarId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_REASONCODE,
							finderArgs, wfms_action_and_reasoncode);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_REASONCODE,
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
			return (WFMS_action_and_reasoncode)result;
		}
	}

	/**
	 * Removes the WFMS_action_and_reasoncode where aarId = &#63; from the database.
	 *
	 * @param aarId the aar ID
	 * @return the WFMS_action_and_reasoncode that was removed
	 */
	@Override
	public WFMS_action_and_reasoncode removeByreasoncode(String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException {
		WFMS_action_and_reasoncode wfms_action_and_reasoncode = findByreasoncode(aarId);

		return remove(wfms_action_and_reasoncode);
	}

	/**
	 * Returns the number of WFMS_action_and_reasoncodes where aarId = &#63;.
	 *
	 * @param aarId the aar ID
	 * @return the number of matching WFMS_action_and_reasoncodes
	 */
	@Override
	public int countByreasoncode(String aarId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REASONCODE;

		Object[] finderArgs = new Object[] { aarId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_ACTION_AND_REASONCODE_WHERE);

			boolean bindAarId = false;

			if (aarId == null) {
				query.append(_FINDER_COLUMN_REASONCODE_AARID_1);
			}
			else if (aarId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REASONCODE_AARID_3);
			}
			else {
				bindAarId = true;

				query.append(_FINDER_COLUMN_REASONCODE_AARID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAarId) {
					qPos.add(aarId);
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

	private static final String _FINDER_COLUMN_REASONCODE_AARID_1 = "wfms_action_and_reasoncode.aarId IS NULL";
	private static final String _FINDER_COLUMN_REASONCODE_AARID_2 = "wfms_action_and_reasoncode.aarId = ?";
	private static final String _FINDER_COLUMN_REASONCODE_AARID_3 = "(wfms_action_and_reasoncode.aarId IS NULL OR wfms_action_and_reasoncode.aarId = '')";

	public WFMS_action_and_reasoncodePersistenceImpl() {
		setModelClass(WFMS_action_and_reasoncode.class);
	}

	/**
	 * Caches the WFMS_action_and_reasoncode in the entity cache if it is enabled.
	 *
	 * @param wfms_action_and_reasoncode the WFMS_action_and_reasoncode
	 */
	@Override
	public void cacheResult(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		entityCache.putResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeImpl.class,
			wfms_action_and_reasoncode.getPrimaryKey(),
			wfms_action_and_reasoncode);

		finderCache.putResult(FINDER_PATH_FETCH_BY_REASONCODE,
			new Object[] { wfms_action_and_reasoncode.getAarId() },
			wfms_action_and_reasoncode);

		wfms_action_and_reasoncode.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_action_and_reasoncodes in the entity cache if it is enabled.
	 *
	 * @param wfms_action_and_reasoncodes the WFMS_action_and_reasoncodes
	 */
	@Override
	public void cacheResult(
		List<WFMS_action_and_reasoncode> wfms_action_and_reasoncodes) {
		for (WFMS_action_and_reasoncode wfms_action_and_reasoncode : wfms_action_and_reasoncodes) {
			if (entityCache.getResult(
						WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_action_and_reasoncodeImpl.class,
						wfms_action_and_reasoncode.getPrimaryKey()) == null) {
				cacheResult(wfms_action_and_reasoncode);
			}
			else {
				wfms_action_and_reasoncode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_action_and_reasoncodes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_action_and_reasoncodeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_action_and_reasoncode.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		entityCache.removeResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeImpl.class,
			wfms_action_and_reasoncode.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_action_and_reasoncodeModelImpl)wfms_action_and_reasoncode,
			true);
	}

	@Override
	public void clearCache(
		List<WFMS_action_and_reasoncode> wfms_action_and_reasoncodes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_action_and_reasoncode wfms_action_and_reasoncode : wfms_action_and_reasoncodes) {
			entityCache.removeResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_action_and_reasoncodeImpl.class,
				wfms_action_and_reasoncode.getPrimaryKey());

			clearUniqueFindersCache((WFMS_action_and_reasoncodeModelImpl)wfms_action_and_reasoncode,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_action_and_reasoncodeModelImpl wfms_action_and_reasoncodeModelImpl) {
		Object[] args = new Object[] {
				wfms_action_and_reasoncodeModelImpl.getAarId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_REASONCODE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_REASONCODE, args,
			wfms_action_and_reasoncodeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_action_and_reasoncodeModelImpl wfms_action_and_reasoncodeModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					wfms_action_and_reasoncodeModelImpl.getAarId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REASONCODE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_REASONCODE, args);
		}

		if ((wfms_action_and_reasoncodeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REASONCODE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_action_and_reasoncodeModelImpl.getOriginalAarId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REASONCODE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_REASONCODE, args);
		}
	}

	/**
	 * Creates a new WFMS_action_and_reasoncode with the primary key. Does not add the WFMS_action_and_reasoncode to the database.
	 *
	 * @param aarId the primary key for the new WFMS_action_and_reasoncode
	 * @return the new WFMS_action_and_reasoncode
	 */
	@Override
	public WFMS_action_and_reasoncode create(String aarId) {
		WFMS_action_and_reasoncode wfms_action_and_reasoncode = new WFMS_action_and_reasoncodeImpl();

		wfms_action_and_reasoncode.setNew(true);
		wfms_action_and_reasoncode.setPrimaryKey(aarId);

		return wfms_action_and_reasoncode;
	}

	/**
	 * Removes the WFMS_action_and_reasoncode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aarId the primary key of the WFMS_action_and_reasoncode
	 * @return the WFMS_action_and_reasoncode that was removed
	 * @throws NoSuchWFMS_action_and_reasoncodeException if a WFMS_action_and_reasoncode with the primary key could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode remove(String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException {
		return remove((Serializable)aarId);
	}

	/**
	 * Removes the WFMS_action_and_reasoncode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_action_and_reasoncode
	 * @return the WFMS_action_and_reasoncode that was removed
	 * @throws NoSuchWFMS_action_and_reasoncodeException if a WFMS_action_and_reasoncode with the primary key could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode remove(Serializable primaryKey)
		throws NoSuchWFMS_action_and_reasoncodeException {
		Session session = null;

		try {
			session = openSession();

			WFMS_action_and_reasoncode wfms_action_and_reasoncode = (WFMS_action_and_reasoncode)session.get(WFMS_action_and_reasoncodeImpl.class,
					primaryKey);

			if (wfms_action_and_reasoncode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_action_and_reasoncodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_action_and_reasoncode);
		}
		catch (NoSuchWFMS_action_and_reasoncodeException nsee) {
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
	protected WFMS_action_and_reasoncode removeImpl(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		wfms_action_and_reasoncode = toUnwrappedModel(wfms_action_and_reasoncode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_action_and_reasoncode)) {
				wfms_action_and_reasoncode = (WFMS_action_and_reasoncode)session.get(WFMS_action_and_reasoncodeImpl.class,
						wfms_action_and_reasoncode.getPrimaryKeyObj());
			}

			if (wfms_action_and_reasoncode != null) {
				session.delete(wfms_action_and_reasoncode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_action_and_reasoncode != null) {
			clearCache(wfms_action_and_reasoncode);
		}

		return wfms_action_and_reasoncode;
	}

	@Override
	public WFMS_action_and_reasoncode updateImpl(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		wfms_action_and_reasoncode = toUnwrappedModel(wfms_action_and_reasoncode);

		boolean isNew = wfms_action_and_reasoncode.isNew();

		WFMS_action_and_reasoncodeModelImpl wfms_action_and_reasoncodeModelImpl = (WFMS_action_and_reasoncodeModelImpl)wfms_action_and_reasoncode;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_action_and_reasoncode.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_action_and_reasoncode.setCreateDate(now);
			}
			else {
				wfms_action_and_reasoncode.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!wfms_action_and_reasoncodeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_action_and_reasoncode.setModifiedDate(now);
			}
			else {
				wfms_action_and_reasoncode.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_action_and_reasoncode.isNew()) {
				session.save(wfms_action_and_reasoncode);

				wfms_action_and_reasoncode.setNew(false);
			}
			else {
				wfms_action_and_reasoncode = (WFMS_action_and_reasoncode)session.merge(wfms_action_and_reasoncode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_action_and_reasoncodeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_and_reasoncodeImpl.class,
			wfms_action_and_reasoncode.getPrimaryKey(),
			wfms_action_and_reasoncode, false);

		clearUniqueFindersCache(wfms_action_and_reasoncodeModelImpl, false);
		cacheUniqueFindersCache(wfms_action_and_reasoncodeModelImpl);

		wfms_action_and_reasoncode.resetOriginalValues();

		return wfms_action_and_reasoncode;
	}

	protected WFMS_action_and_reasoncode toUnwrappedModel(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		if (wfms_action_and_reasoncode instanceof WFMS_action_and_reasoncodeImpl) {
			return wfms_action_and_reasoncode;
		}

		WFMS_action_and_reasoncodeImpl wfms_action_and_reasoncodeImpl = new WFMS_action_and_reasoncodeImpl();

		wfms_action_and_reasoncodeImpl.setNew(wfms_action_and_reasoncode.isNew());
		wfms_action_and_reasoncodeImpl.setPrimaryKey(wfms_action_and_reasoncode.getPrimaryKey());

		wfms_action_and_reasoncodeImpl.setAarId(wfms_action_and_reasoncode.getAarId());
		wfms_action_and_reasoncodeImpl.setAction(wfms_action_and_reasoncode.getAction());
		wfms_action_and_reasoncodeImpl.setReasonCode(wfms_action_and_reasoncode.getReasonCode());
		wfms_action_and_reasoncodeImpl.setDescription(wfms_action_and_reasoncode.getDescription());
		wfms_action_and_reasoncodeImpl.setDeleteflag(wfms_action_and_reasoncode.getDeleteflag());
		wfms_action_and_reasoncodeImpl.setCreatedBy(wfms_action_and_reasoncode.getCreatedBy());
		wfms_action_and_reasoncodeImpl.setCreateDate(wfms_action_and_reasoncode.getCreateDate());
		wfms_action_and_reasoncodeImpl.setModifiedBy(wfms_action_and_reasoncode.getModifiedBy());
		wfms_action_and_reasoncodeImpl.setModifiedDate(wfms_action_and_reasoncode.getModifiedDate());

		return wfms_action_and_reasoncodeImpl;
	}

	/**
	 * Returns the WFMS_action_and_reasoncode with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_action_and_reasoncode
	 * @return the WFMS_action_and_reasoncode
	 * @throws NoSuchWFMS_action_and_reasoncodeException if a WFMS_action_and_reasoncode with the primary key could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_action_and_reasoncodeException {
		WFMS_action_and_reasoncode wfms_action_and_reasoncode = fetchByPrimaryKey(primaryKey);

		if (wfms_action_and_reasoncode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_action_and_reasoncodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_action_and_reasoncode;
	}

	/**
	 * Returns the WFMS_action_and_reasoncode with the primary key or throws a {@link NoSuchWFMS_action_and_reasoncodeException} if it could not be found.
	 *
	 * @param aarId the primary key of the WFMS_action_and_reasoncode
	 * @return the WFMS_action_and_reasoncode
	 * @throws NoSuchWFMS_action_and_reasoncodeException if a WFMS_action_and_reasoncode with the primary key could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode findByPrimaryKey(String aarId)
		throws NoSuchWFMS_action_and_reasoncodeException {
		return findByPrimaryKey((Serializable)aarId);
	}

	/**
	 * Returns the WFMS_action_and_reasoncode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_action_and_reasoncode
	 * @return the WFMS_action_and_reasoncode, or <code>null</code> if a WFMS_action_and_reasoncode with the primary key could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_action_and_reasoncodeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_action_and_reasoncode wfms_action_and_reasoncode = (WFMS_action_and_reasoncode)serializable;

		if (wfms_action_and_reasoncode == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_action_and_reasoncode = (WFMS_action_and_reasoncode)session.get(WFMS_action_and_reasoncodeImpl.class,
						primaryKey);

				if (wfms_action_and_reasoncode != null) {
					cacheResult(wfms_action_and_reasoncode);
				}
				else {
					entityCache.putResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_action_and_reasoncodeImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_action_and_reasoncodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_action_and_reasoncode;
	}

	/**
	 * Returns the WFMS_action_and_reasoncode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aarId the primary key of the WFMS_action_and_reasoncode
	 * @return the WFMS_action_and_reasoncode, or <code>null</code> if a WFMS_action_and_reasoncode with the primary key could not be found
	 */
	@Override
	public WFMS_action_and_reasoncode fetchByPrimaryKey(String aarId) {
		return fetchByPrimaryKey((Serializable)aarId);
	}

	@Override
	public Map<Serializable, WFMS_action_and_reasoncode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_action_and_reasoncode> map = new HashMap<Serializable, WFMS_action_and_reasoncode>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_action_and_reasoncode wfms_action_and_reasoncode = fetchByPrimaryKey(primaryKey);

			if (wfms_action_and_reasoncode != null) {
				map.put(primaryKey, wfms_action_and_reasoncode);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_action_and_reasoncodeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_action_and_reasoncode)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_ACTION_AND_REASONCODE_WHERE_PKS_IN);

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

			for (WFMS_action_and_reasoncode wfms_action_and_reasoncode : (List<WFMS_action_and_reasoncode>)q.list()) {
				map.put(wfms_action_and_reasoncode.getPrimaryKeyObj(),
					wfms_action_and_reasoncode);

				cacheResult(wfms_action_and_reasoncode);

				uncachedPrimaryKeys.remove(wfms_action_and_reasoncode.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_action_and_reasoncodeModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_action_and_reasoncodeImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_action_and_reasoncodes.
	 *
	 * @return the WFMS_action_and_reasoncodes
	 */
	@Override
	public List<WFMS_action_and_reasoncode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_action_and_reasoncodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_action_and_reasoncodes
	 * @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	 * @return the range of WFMS_action_and_reasoncodes
	 */
	@Override
	public List<WFMS_action_and_reasoncode> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_action_and_reasoncodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_action_and_reasoncodes
	 * @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_action_and_reasoncodes
	 */
	@Override
	public List<WFMS_action_and_reasoncode> findAll(int start, int end,
		OrderByComparator<WFMS_action_and_reasoncode> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_action_and_reasoncodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_action_and_reasoncodes
	 * @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_action_and_reasoncodes
	 */
	@Override
	public List<WFMS_action_and_reasoncode> findAll(int start, int end,
		OrderByComparator<WFMS_action_and_reasoncode> orderByComparator,
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

		List<WFMS_action_and_reasoncode> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_action_and_reasoncode>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_ACTION_AND_REASONCODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_ACTION_AND_REASONCODE;

				if (pagination) {
					sql = sql.concat(WFMS_action_and_reasoncodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_action_and_reasoncode>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_action_and_reasoncode>)QueryUtil.list(q,
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
	 * Removes all the WFMS_action_and_reasoncodes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_action_and_reasoncode wfms_action_and_reasoncode : findAll()) {
			remove(wfms_action_and_reasoncode);
		}
	}

	/**
	 * Returns the number of WFMS_action_and_reasoncodes.
	 *
	 * @return the number of WFMS_action_and_reasoncodes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_ACTION_AND_REASONCODE);

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
		return WFMS_action_and_reasoncodeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_action_and_reasoncode persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_action_and_reasoncodeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_ACTION_AND_REASONCODE = "SELECT wfms_action_and_reasoncode FROM WFMS_action_and_reasoncode wfms_action_and_reasoncode";
	private static final String _SQL_SELECT_WFMS_ACTION_AND_REASONCODE_WHERE_PKS_IN =
		"SELECT wfms_action_and_reasoncode FROM WFMS_action_and_reasoncode wfms_action_and_reasoncode WHERE aarId IN (";
	private static final String _SQL_SELECT_WFMS_ACTION_AND_REASONCODE_WHERE = "SELECT wfms_action_and_reasoncode FROM WFMS_action_and_reasoncode wfms_action_and_reasoncode WHERE ";
	private static final String _SQL_COUNT_WFMS_ACTION_AND_REASONCODE = "SELECT COUNT(wfms_action_and_reasoncode) FROM WFMS_action_and_reasoncode wfms_action_and_reasoncode";
	private static final String _SQL_COUNT_WFMS_ACTION_AND_REASONCODE_WHERE = "SELECT COUNT(wfms_action_and_reasoncode) FROM WFMS_action_and_reasoncode wfms_action_and_reasoncode WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_action_and_reasoncode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_action_and_reasoncode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_action_and_reasoncode exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_action_and_reasoncodePersistenceImpl.class);
}