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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_routing_and_approversException;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_routing_and_approversPersistence;

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
 * The persistence implementation for the WFMS_routing_and_approvers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_routing_and_approversPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_routing_and_approversUtil
 * @generated
 */
@ProviderType
public class WFMS_routing_and_approversPersistenceImpl
	extends BasePersistenceImpl<WFMS_routing_and_approvers>
	implements WFMS_routing_and_approversPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_routing_and_approversUtil} to access the WFMS_routing_and_approvers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_routing_and_approversImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversModelImpl.FINDER_CACHE_ENABLED,
			WFMS_routing_and_approversImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversModelImpl.FINDER_CACHE_ENABLED,
			WFMS_routing_and_approversImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ROUTING = new FinderPath(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversModelImpl.FINDER_CACHE_ENABLED,
			WFMS_routing_and_approversImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByrouting", new String[] { String.class.getName() },
			WFMS_routing_and_approversModelImpl.RAPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROUTING = new FinderPath(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrouting", new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_routing_and_approvers where rapId = &#63; or throws a {@link NoSuchWFMS_routing_and_approversException} if it could not be found.
	 *
	 * @param rapId the rap ID
	 * @return the matching WFMS_routing_and_approvers
	 * @throws NoSuchWFMS_routing_and_approversException if a matching WFMS_routing_and_approvers could not be found
	 */
	@Override
	public WFMS_routing_and_approvers findByrouting(String rapId)
		throws NoSuchWFMS_routing_and_approversException {
		WFMS_routing_and_approvers wfms_routing_and_approvers = fetchByrouting(rapId);

		if (wfms_routing_and_approvers == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rapId=");
			msg.append(rapId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_routing_and_approversException(msg.toString());
		}

		return wfms_routing_and_approvers;
	}

	/**
	 * Returns the WFMS_routing_and_approvers where rapId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rapId the rap ID
	 * @return the matching WFMS_routing_and_approvers, or <code>null</code> if a matching WFMS_routing_and_approvers could not be found
	 */
	@Override
	public WFMS_routing_and_approvers fetchByrouting(String rapId) {
		return fetchByrouting(rapId, true);
	}

	/**
	 * Returns the WFMS_routing_and_approvers where rapId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rapId the rap ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_routing_and_approvers, or <code>null</code> if a matching WFMS_routing_and_approvers could not be found
	 */
	@Override
	public WFMS_routing_and_approvers fetchByrouting(String rapId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { rapId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ROUTING,
					finderArgs, this);
		}

		if (result instanceof WFMS_routing_and_approvers) {
			WFMS_routing_and_approvers wfms_routing_and_approvers = (WFMS_routing_and_approvers)result;

			if (!Objects.equals(rapId, wfms_routing_and_approvers.getRapId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_ROUTING_AND_APPROVERS_WHERE);

			boolean bindRapId = false;

			if (rapId == null) {
				query.append(_FINDER_COLUMN_ROUTING_RAPID_1);
			}
			else if (rapId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROUTING_RAPID_3);
			}
			else {
				bindRapId = true;

				query.append(_FINDER_COLUMN_ROUTING_RAPID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRapId) {
					qPos.add(rapId);
				}

				List<WFMS_routing_and_approvers> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ROUTING,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_routing_and_approversPersistenceImpl.fetchByrouting(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_routing_and_approvers wfms_routing_and_approvers = list.get(0);

					result = wfms_routing_and_approvers;

					cacheResult(wfms_routing_and_approvers);

					if ((wfms_routing_and_approvers.getRapId() == null) ||
							!wfms_routing_and_approvers.getRapId().equals(rapId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_ROUTING,
							finderArgs, wfms_routing_and_approvers);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ROUTING,
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
			return (WFMS_routing_and_approvers)result;
		}
	}

	/**
	 * Removes the WFMS_routing_and_approvers where rapId = &#63; from the database.
	 *
	 * @param rapId the rap ID
	 * @return the WFMS_routing_and_approvers that was removed
	 */
	@Override
	public WFMS_routing_and_approvers removeByrouting(String rapId)
		throws NoSuchWFMS_routing_and_approversException {
		WFMS_routing_and_approvers wfms_routing_and_approvers = findByrouting(rapId);

		return remove(wfms_routing_and_approvers);
	}

	/**
	 * Returns the number of WFMS_routing_and_approverses where rapId = &#63;.
	 *
	 * @param rapId the rap ID
	 * @return the number of matching WFMS_routing_and_approverses
	 */
	@Override
	public int countByrouting(String rapId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROUTING;

		Object[] finderArgs = new Object[] { rapId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_ROUTING_AND_APPROVERS_WHERE);

			boolean bindRapId = false;

			if (rapId == null) {
				query.append(_FINDER_COLUMN_ROUTING_RAPID_1);
			}
			else if (rapId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROUTING_RAPID_3);
			}
			else {
				bindRapId = true;

				query.append(_FINDER_COLUMN_ROUTING_RAPID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRapId) {
					qPos.add(rapId);
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

	private static final String _FINDER_COLUMN_ROUTING_RAPID_1 = "wfms_routing_and_approvers.rapId IS NULL";
	private static final String _FINDER_COLUMN_ROUTING_RAPID_2 = "wfms_routing_and_approvers.rapId = ?";
	private static final String _FINDER_COLUMN_ROUTING_RAPID_3 = "(wfms_routing_and_approvers.rapId IS NULL OR wfms_routing_and_approvers.rapId = '')";

	public WFMS_routing_and_approversPersistenceImpl() {
		setModelClass(WFMS_routing_and_approvers.class);
	}

	/**
	 * Caches the WFMS_routing_and_approvers in the entity cache if it is enabled.
	 *
	 * @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	 */
	@Override
	public void cacheResult(
		WFMS_routing_and_approvers wfms_routing_and_approvers) {
		entityCache.putResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversImpl.class,
			wfms_routing_and_approvers.getPrimaryKey(),
			wfms_routing_and_approvers);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ROUTING,
			new Object[] { wfms_routing_and_approvers.getRapId() },
			wfms_routing_and_approvers);

		wfms_routing_and_approvers.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_routing_and_approverses in the entity cache if it is enabled.
	 *
	 * @param wfms_routing_and_approverses the WFMS_routing_and_approverses
	 */
	@Override
	public void cacheResult(
		List<WFMS_routing_and_approvers> wfms_routing_and_approverses) {
		for (WFMS_routing_and_approvers wfms_routing_and_approvers : wfms_routing_and_approverses) {
			if (entityCache.getResult(
						WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_routing_and_approversImpl.class,
						wfms_routing_and_approvers.getPrimaryKey()) == null) {
				cacheResult(wfms_routing_and_approvers);
			}
			else {
				wfms_routing_and_approvers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_routing_and_approverses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_routing_and_approversImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_routing_and_approvers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		WFMS_routing_and_approvers wfms_routing_and_approvers) {
		entityCache.removeResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversImpl.class,
			wfms_routing_and_approvers.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_routing_and_approversModelImpl)wfms_routing_and_approvers,
			true);
	}

	@Override
	public void clearCache(
		List<WFMS_routing_and_approvers> wfms_routing_and_approverses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_routing_and_approvers wfms_routing_and_approvers : wfms_routing_and_approverses) {
			entityCache.removeResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_routing_and_approversImpl.class,
				wfms_routing_and_approvers.getPrimaryKey());

			clearUniqueFindersCache((WFMS_routing_and_approversModelImpl)wfms_routing_and_approvers,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_routing_and_approversModelImpl wfms_routing_and_approversModelImpl) {
		Object[] args = new Object[] {
				wfms_routing_and_approversModelImpl.getRapId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_ROUTING, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ROUTING, args,
			wfms_routing_and_approversModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_routing_and_approversModelImpl wfms_routing_and_approversModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					wfms_routing_and_approversModelImpl.getRapId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ROUTING, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ROUTING, args);
		}

		if ((wfms_routing_and_approversModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ROUTING.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_routing_and_approversModelImpl.getOriginalRapId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ROUTING, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ROUTING, args);
		}
	}

	/**
	 * Creates a new WFMS_routing_and_approvers with the primary key. Does not add the WFMS_routing_and_approvers to the database.
	 *
	 * @param rapId the primary key for the new WFMS_routing_and_approvers
	 * @return the new WFMS_routing_and_approvers
	 */
	@Override
	public WFMS_routing_and_approvers create(String rapId) {
		WFMS_routing_and_approvers wfms_routing_and_approvers = new WFMS_routing_and_approversImpl();

		wfms_routing_and_approvers.setNew(true);
		wfms_routing_and_approvers.setPrimaryKey(rapId);

		return wfms_routing_and_approvers;
	}

	/**
	 * Removes the WFMS_routing_and_approvers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rapId the primary key of the WFMS_routing_and_approvers
	 * @return the WFMS_routing_and_approvers that was removed
	 * @throws NoSuchWFMS_routing_and_approversException if a WFMS_routing_and_approvers with the primary key could not be found
	 */
	@Override
	public WFMS_routing_and_approvers remove(String rapId)
		throws NoSuchWFMS_routing_and_approversException {
		return remove((Serializable)rapId);
	}

	/**
	 * Removes the WFMS_routing_and_approvers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_routing_and_approvers
	 * @return the WFMS_routing_and_approvers that was removed
	 * @throws NoSuchWFMS_routing_and_approversException if a WFMS_routing_and_approvers with the primary key could not be found
	 */
	@Override
	public WFMS_routing_and_approvers remove(Serializable primaryKey)
		throws NoSuchWFMS_routing_and_approversException {
		Session session = null;

		try {
			session = openSession();

			WFMS_routing_and_approvers wfms_routing_and_approvers = (WFMS_routing_and_approvers)session.get(WFMS_routing_and_approversImpl.class,
					primaryKey);

			if (wfms_routing_and_approvers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_routing_and_approversException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_routing_and_approvers);
		}
		catch (NoSuchWFMS_routing_and_approversException nsee) {
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
	protected WFMS_routing_and_approvers removeImpl(
		WFMS_routing_and_approvers wfms_routing_and_approvers) {
		wfms_routing_and_approvers = toUnwrappedModel(wfms_routing_and_approvers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_routing_and_approvers)) {
				wfms_routing_and_approvers = (WFMS_routing_and_approvers)session.get(WFMS_routing_and_approversImpl.class,
						wfms_routing_and_approvers.getPrimaryKeyObj());
			}

			if (wfms_routing_and_approvers != null) {
				session.delete(wfms_routing_and_approvers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_routing_and_approvers != null) {
			clearCache(wfms_routing_and_approvers);
		}

		return wfms_routing_and_approvers;
	}

	@Override
	public WFMS_routing_and_approvers updateImpl(
		WFMS_routing_and_approvers wfms_routing_and_approvers) {
		wfms_routing_and_approvers = toUnwrappedModel(wfms_routing_and_approvers);

		boolean isNew = wfms_routing_and_approvers.isNew();

		WFMS_routing_and_approversModelImpl wfms_routing_and_approversModelImpl = (WFMS_routing_and_approversModelImpl)wfms_routing_and_approvers;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_routing_and_approvers.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_routing_and_approvers.setCreateDate(now);
			}
			else {
				wfms_routing_and_approvers.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!wfms_routing_and_approversModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_routing_and_approvers.setModifiedDate(now);
			}
			else {
				wfms_routing_and_approvers.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_routing_and_approvers.isNew()) {
				session.save(wfms_routing_and_approvers);

				wfms_routing_and_approvers.setNew(false);
			}
			else {
				wfms_routing_and_approvers = (WFMS_routing_and_approvers)session.merge(wfms_routing_and_approvers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_routing_and_approversModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_routing_and_approversImpl.class,
			wfms_routing_and_approvers.getPrimaryKey(),
			wfms_routing_and_approvers, false);

		clearUniqueFindersCache(wfms_routing_and_approversModelImpl, false);
		cacheUniqueFindersCache(wfms_routing_and_approversModelImpl);

		wfms_routing_and_approvers.resetOriginalValues();

		return wfms_routing_and_approvers;
	}

	protected WFMS_routing_and_approvers toUnwrappedModel(
		WFMS_routing_and_approvers wfms_routing_and_approvers) {
		if (wfms_routing_and_approvers instanceof WFMS_routing_and_approversImpl) {
			return wfms_routing_and_approvers;
		}

		WFMS_routing_and_approversImpl wfms_routing_and_approversImpl = new WFMS_routing_and_approversImpl();

		wfms_routing_and_approversImpl.setNew(wfms_routing_and_approvers.isNew());
		wfms_routing_and_approversImpl.setPrimaryKey(wfms_routing_and_approvers.getPrimaryKey());

		wfms_routing_and_approversImpl.setRapId(wfms_routing_and_approvers.getRapId());
		wfms_routing_and_approversImpl.setAction(wfms_routing_and_approvers.getAction());
		wfms_routing_and_approversImpl.setChangeDescription(wfms_routing_and_approvers.getChangeDescription());
		wfms_routing_and_approversImpl.setCurrentJobCodeORLeadership(wfms_routing_and_approvers.getCurrentJobCodeORLeadership());
		wfms_routing_and_approversImpl.setNewJobCodeORLeadership(wfms_routing_and_approvers.getNewJobCodeORLeadership());
		wfms_routing_and_approversImpl.setSameJobCode(wfms_routing_and_approvers.getSameJobCode());
		wfms_routing_and_approversImpl.setSameLeadership(wfms_routing_and_approvers.getSameLeadership());
		wfms_routing_and_approversImpl.setIsSameDept(wfms_routing_and_approvers.getIsSameDept());
		wfms_routing_and_approversImpl.setIsSameMgr(wfms_routing_and_approvers.getIsSameMgr());
		wfms_routing_and_approversImpl.setRoutingProcess(wfms_routing_and_approvers.getRoutingProcess());
		wfms_routing_and_approversImpl.setNotificationTo(wfms_routing_and_approvers.getNotificationTo());
		wfms_routing_and_approversImpl.setDeleteflag(wfms_routing_and_approvers.getDeleteflag());
		wfms_routing_and_approversImpl.setCreatedBy(wfms_routing_and_approvers.getCreatedBy());
		wfms_routing_and_approversImpl.setCreateDate(wfms_routing_and_approvers.getCreateDate());
		wfms_routing_and_approversImpl.setModifiedBy(wfms_routing_and_approvers.getModifiedBy());
		wfms_routing_and_approversImpl.setModifiedDate(wfms_routing_and_approvers.getModifiedDate());

		return wfms_routing_and_approversImpl;
	}

	/**
	 * Returns the WFMS_routing_and_approvers with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_routing_and_approvers
	 * @return the WFMS_routing_and_approvers
	 * @throws NoSuchWFMS_routing_and_approversException if a WFMS_routing_and_approvers with the primary key could not be found
	 */
	@Override
	public WFMS_routing_and_approvers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_routing_and_approversException {
		WFMS_routing_and_approvers wfms_routing_and_approvers = fetchByPrimaryKey(primaryKey);

		if (wfms_routing_and_approvers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_routing_and_approversException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_routing_and_approvers;
	}

	/**
	 * Returns the WFMS_routing_and_approvers with the primary key or throws a {@link NoSuchWFMS_routing_and_approversException} if it could not be found.
	 *
	 * @param rapId the primary key of the WFMS_routing_and_approvers
	 * @return the WFMS_routing_and_approvers
	 * @throws NoSuchWFMS_routing_and_approversException if a WFMS_routing_and_approvers with the primary key could not be found
	 */
	@Override
	public WFMS_routing_and_approvers findByPrimaryKey(String rapId)
		throws NoSuchWFMS_routing_and_approversException {
		return findByPrimaryKey((Serializable)rapId);
	}

	/**
	 * Returns the WFMS_routing_and_approvers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_routing_and_approvers
	 * @return the WFMS_routing_and_approvers, or <code>null</code> if a WFMS_routing_and_approvers with the primary key could not be found
	 */
	@Override
	public WFMS_routing_and_approvers fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_routing_and_approversImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_routing_and_approvers wfms_routing_and_approvers = (WFMS_routing_and_approvers)serializable;

		if (wfms_routing_and_approvers == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_routing_and_approvers = (WFMS_routing_and_approvers)session.get(WFMS_routing_and_approversImpl.class,
						primaryKey);

				if (wfms_routing_and_approvers != null) {
					cacheResult(wfms_routing_and_approvers);
				}
				else {
					entityCache.putResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_routing_and_approversImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_routing_and_approversImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_routing_and_approvers;
	}

	/**
	 * Returns the WFMS_routing_and_approvers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rapId the primary key of the WFMS_routing_and_approvers
	 * @return the WFMS_routing_and_approvers, or <code>null</code> if a WFMS_routing_and_approvers with the primary key could not be found
	 */
	@Override
	public WFMS_routing_and_approvers fetchByPrimaryKey(String rapId) {
		return fetchByPrimaryKey((Serializable)rapId);
	}

	@Override
	public Map<Serializable, WFMS_routing_and_approvers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_routing_and_approvers> map = new HashMap<Serializable, WFMS_routing_and_approvers>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_routing_and_approvers wfms_routing_and_approvers = fetchByPrimaryKey(primaryKey);

			if (wfms_routing_and_approvers != null) {
				map.put(primaryKey, wfms_routing_and_approvers);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_routing_and_approversImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_routing_and_approvers)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_ROUTING_AND_APPROVERS_WHERE_PKS_IN);

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

			for (WFMS_routing_and_approvers wfms_routing_and_approvers : (List<WFMS_routing_and_approvers>)q.list()) {
				map.put(wfms_routing_and_approvers.getPrimaryKeyObj(),
					wfms_routing_and_approvers);

				cacheResult(wfms_routing_and_approvers);

				uncachedPrimaryKeys.remove(wfms_routing_and_approvers.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_routing_and_approversModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_routing_and_approversImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_routing_and_approverses.
	 *
	 * @return the WFMS_routing_and_approverses
	 */
	@Override
	public List<WFMS_routing_and_approvers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_routing_and_approverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_routing_and_approverses
	 * @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	 * @return the range of WFMS_routing_and_approverses
	 */
	@Override
	public List<WFMS_routing_and_approvers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_routing_and_approverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_routing_and_approverses
	 * @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_routing_and_approverses
	 */
	@Override
	public List<WFMS_routing_and_approvers> findAll(int start, int end,
		OrderByComparator<WFMS_routing_and_approvers> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_routing_and_approverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_routing_and_approverses
	 * @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_routing_and_approverses
	 */
	@Override
	public List<WFMS_routing_and_approvers> findAll(int start, int end,
		OrderByComparator<WFMS_routing_and_approvers> orderByComparator,
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

		List<WFMS_routing_and_approvers> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_routing_and_approvers>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_ROUTING_AND_APPROVERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_ROUTING_AND_APPROVERS;

				if (pagination) {
					sql = sql.concat(WFMS_routing_and_approversModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_routing_and_approvers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_routing_and_approvers>)QueryUtil.list(q,
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
	 * Removes all the WFMS_routing_and_approverses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_routing_and_approvers wfms_routing_and_approvers : findAll()) {
			remove(wfms_routing_and_approvers);
		}
	}

	/**
	 * Returns the number of WFMS_routing_and_approverses.
	 *
	 * @return the number of WFMS_routing_and_approverses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_ROUTING_AND_APPROVERS);

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
		return WFMS_routing_and_approversModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_routing_and_approvers persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_routing_and_approversImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_ROUTING_AND_APPROVERS = "SELECT wfms_routing_and_approvers FROM WFMS_routing_and_approvers wfms_routing_and_approvers";
	private static final String _SQL_SELECT_WFMS_ROUTING_AND_APPROVERS_WHERE_PKS_IN =
		"SELECT wfms_routing_and_approvers FROM WFMS_routing_and_approvers wfms_routing_and_approvers WHERE rapId IN (";
	private static final String _SQL_SELECT_WFMS_ROUTING_AND_APPROVERS_WHERE = "SELECT wfms_routing_and_approvers FROM WFMS_routing_and_approvers wfms_routing_and_approvers WHERE ";
	private static final String _SQL_COUNT_WFMS_ROUTING_AND_APPROVERS = "SELECT COUNT(wfms_routing_and_approvers) FROM WFMS_routing_and_approvers wfms_routing_and_approvers";
	private static final String _SQL_COUNT_WFMS_ROUTING_AND_APPROVERS_WHERE = "SELECT COUNT(wfms_routing_and_approvers) FROM WFMS_routing_and_approvers wfms_routing_and_approvers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_routing_and_approvers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_routing_and_approvers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_routing_and_approvers exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_routing_and_approversPersistenceImpl.class);
}