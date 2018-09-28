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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NA_SupportException;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_NA_SupportPersistence;

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
 * The persistence implementation for the WFMS_NA_Support service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_SupportPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_NA_SupportUtil
 * @generated
 */
@ProviderType
public class WFMS_NA_SupportPersistenceImpl extends BasePersistenceImpl<WFMS_NA_Support>
	implements WFMS_NA_SupportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_NA_SupportUtil} to access the WFMS_NA_Support persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_NA_SupportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NA_SupportImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NA_SupportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NASUPPORT = new FinderPath(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportModelImpl.FINDER_CACHE_ENABLED,
			WFMS_NA_SupportImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBynaSupport", new String[] { String.class.getName() },
			WFMS_NA_SupportModelImpl.ASSOCIATE_NUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NASUPPORT = new FinderPath(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynaSupport",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; or throws a {@link NoSuchWFMS_NA_SupportException} if it could not be found.
	 *
	 * @param ASSOCIATE_NUMBER the associate_number
	 * @return the matching WFMS_NA_Support
	 * @throws NoSuchWFMS_NA_SupportException if a matching WFMS_NA_Support could not be found
	 */
	@Override
	public WFMS_NA_Support findBynaSupport(String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException {
		WFMS_NA_Support wfms_na_Support = fetchBynaSupport(ASSOCIATE_NUMBER);

		if (wfms_na_Support == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ASSOCIATE_NUMBER=");
			msg.append(ASSOCIATE_NUMBER);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_NA_SupportException(msg.toString());
		}

		return wfms_na_Support;
	}

	/**
	 * Returns the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ASSOCIATE_NUMBER the associate_number
	 * @return the matching WFMS_NA_Support, or <code>null</code> if a matching WFMS_NA_Support could not be found
	 */
	@Override
	public WFMS_NA_Support fetchBynaSupport(String ASSOCIATE_NUMBER) {
		return fetchBynaSupport(ASSOCIATE_NUMBER, true);
	}

	/**
	 * Returns the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ASSOCIATE_NUMBER the associate_number
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_NA_Support, or <code>null</code> if a matching WFMS_NA_Support could not be found
	 */
	@Override
	public WFMS_NA_Support fetchBynaSupport(String ASSOCIATE_NUMBER,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { ASSOCIATE_NUMBER };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NASUPPORT,
					finderArgs, this);
		}

		if (result instanceof WFMS_NA_Support) {
			WFMS_NA_Support wfms_na_Support = (WFMS_NA_Support)result;

			if (!Objects.equals(ASSOCIATE_NUMBER,
						wfms_na_Support.getASSOCIATE_NUMBER())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_NA_SUPPORT_WHERE);

			boolean bindASSOCIATE_NUMBER = false;

			if (ASSOCIATE_NUMBER == null) {
				query.append(_FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_1);
			}
			else if (ASSOCIATE_NUMBER.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_3);
			}
			else {
				bindASSOCIATE_NUMBER = true;

				query.append(_FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindASSOCIATE_NUMBER) {
					qPos.add(ASSOCIATE_NUMBER);
				}

				List<WFMS_NA_Support> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NASUPPORT,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_NA_SupportPersistenceImpl.fetchBynaSupport(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_NA_Support wfms_na_Support = list.get(0);

					result = wfms_na_Support;

					cacheResult(wfms_na_Support);

					if ((wfms_na_Support.getASSOCIATE_NUMBER() == null) ||
							!wfms_na_Support.getASSOCIATE_NUMBER()
												.equals(ASSOCIATE_NUMBER)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NASUPPORT,
							finderArgs, wfms_na_Support);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NASUPPORT,
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
			return (WFMS_NA_Support)result;
		}
	}

	/**
	 * Removes the WFMS_NA_Support where ASSOCIATE_NUMBER = &#63; from the database.
	 *
	 * @param ASSOCIATE_NUMBER the associate_number
	 * @return the WFMS_NA_Support that was removed
	 */
	@Override
	public WFMS_NA_Support removeBynaSupport(String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException {
		WFMS_NA_Support wfms_na_Support = findBynaSupport(ASSOCIATE_NUMBER);

		return remove(wfms_na_Support);
	}

	/**
	 * Returns the number of WFMS_NA_Supports where ASSOCIATE_NUMBER = &#63;.
	 *
	 * @param ASSOCIATE_NUMBER the associate_number
	 * @return the number of matching WFMS_NA_Supports
	 */
	@Override
	public int countBynaSupport(String ASSOCIATE_NUMBER) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NASUPPORT;

		Object[] finderArgs = new Object[] { ASSOCIATE_NUMBER };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_NA_SUPPORT_WHERE);

			boolean bindASSOCIATE_NUMBER = false;

			if (ASSOCIATE_NUMBER == null) {
				query.append(_FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_1);
			}
			else if (ASSOCIATE_NUMBER.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_3);
			}
			else {
				bindASSOCIATE_NUMBER = true;

				query.append(_FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindASSOCIATE_NUMBER) {
					qPos.add(ASSOCIATE_NUMBER);
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

	private static final String _FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_1 = "wfms_na_Support.ASSOCIATE_NUMBER IS NULL";
	private static final String _FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_2 = "wfms_na_Support.ASSOCIATE_NUMBER = ?";
	private static final String _FINDER_COLUMN_NASUPPORT_ASSOCIATE_NUMBER_3 = "(wfms_na_Support.ASSOCIATE_NUMBER IS NULL OR wfms_na_Support.ASSOCIATE_NUMBER = '')";

	public WFMS_NA_SupportPersistenceImpl() {
		setModelClass(WFMS_NA_Support.class);
	}

	/**
	 * Caches the WFMS_NA_Support in the entity cache if it is enabled.
	 *
	 * @param wfms_na_Support the WFMS_NA_Support
	 */
	@Override
	public void cacheResult(WFMS_NA_Support wfms_na_Support) {
		entityCache.putResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportImpl.class, wfms_na_Support.getPrimaryKey(),
			wfms_na_Support);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NASUPPORT,
			new Object[] { wfms_na_Support.getASSOCIATE_NUMBER() },
			wfms_na_Support);

		wfms_na_Support.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_NA_Supports in the entity cache if it is enabled.
	 *
	 * @param wfms_na_Supports the WFMS_NA_Supports
	 */
	@Override
	public void cacheResult(List<WFMS_NA_Support> wfms_na_Supports) {
		for (WFMS_NA_Support wfms_na_Support : wfms_na_Supports) {
			if (entityCache.getResult(
						WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_NA_SupportImpl.class,
						wfms_na_Support.getPrimaryKey()) == null) {
				cacheResult(wfms_na_Support);
			}
			else {
				wfms_na_Support.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_NA_Supports.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_NA_SupportImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_NA_Support.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_NA_Support wfms_na_Support) {
		entityCache.removeResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportImpl.class, wfms_na_Support.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_NA_SupportModelImpl)wfms_na_Support, true);
	}

	@Override
	public void clearCache(List<WFMS_NA_Support> wfms_na_Supports) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_NA_Support wfms_na_Support : wfms_na_Supports) {
			entityCache.removeResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_NA_SupportImpl.class, wfms_na_Support.getPrimaryKey());

			clearUniqueFindersCache((WFMS_NA_SupportModelImpl)wfms_na_Support,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_NA_SupportModelImpl wfms_na_SupportModelImpl) {
		Object[] args = new Object[] {
				wfms_na_SupportModelImpl.getASSOCIATE_NUMBER()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_NASUPPORT, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_NASUPPORT, args,
			wfms_na_SupportModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_NA_SupportModelImpl wfms_na_SupportModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					wfms_na_SupportModelImpl.getASSOCIATE_NUMBER()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NASUPPORT, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NASUPPORT, args);
		}

		if ((wfms_na_SupportModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NASUPPORT.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_na_SupportModelImpl.getOriginalASSOCIATE_NUMBER()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NASUPPORT, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NASUPPORT, args);
		}
	}

	/**
	 * Creates a new WFMS_NA_Support with the primary key. Does not add the WFMS_NA_Support to the database.
	 *
	 * @param ASSOCIATE_NUMBER the primary key for the new WFMS_NA_Support
	 * @return the new WFMS_NA_Support
	 */
	@Override
	public WFMS_NA_Support create(String ASSOCIATE_NUMBER) {
		WFMS_NA_Support wfms_na_Support = new WFMS_NA_SupportImpl();

		wfms_na_Support.setNew(true);
		wfms_na_Support.setPrimaryKey(ASSOCIATE_NUMBER);

		return wfms_na_Support;
	}

	/**
	 * Removes the WFMS_NA_Support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	 * @return the WFMS_NA_Support that was removed
	 * @throws NoSuchWFMS_NA_SupportException if a WFMS_NA_Support with the primary key could not be found
	 */
	@Override
	public WFMS_NA_Support remove(String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException {
		return remove((Serializable)ASSOCIATE_NUMBER);
	}

	/**
	 * Removes the WFMS_NA_Support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_NA_Support
	 * @return the WFMS_NA_Support that was removed
	 * @throws NoSuchWFMS_NA_SupportException if a WFMS_NA_Support with the primary key could not be found
	 */
	@Override
	public WFMS_NA_Support remove(Serializable primaryKey)
		throws NoSuchWFMS_NA_SupportException {
		Session session = null;

		try {
			session = openSession();

			WFMS_NA_Support wfms_na_Support = (WFMS_NA_Support)session.get(WFMS_NA_SupportImpl.class,
					primaryKey);

			if (wfms_na_Support == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_NA_SupportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_na_Support);
		}
		catch (NoSuchWFMS_NA_SupportException nsee) {
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
	protected WFMS_NA_Support removeImpl(WFMS_NA_Support wfms_na_Support) {
		wfms_na_Support = toUnwrappedModel(wfms_na_Support);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_na_Support)) {
				wfms_na_Support = (WFMS_NA_Support)session.get(WFMS_NA_SupportImpl.class,
						wfms_na_Support.getPrimaryKeyObj());
			}

			if (wfms_na_Support != null) {
				session.delete(wfms_na_Support);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_na_Support != null) {
			clearCache(wfms_na_Support);
		}

		return wfms_na_Support;
	}

	@Override
	public WFMS_NA_Support updateImpl(WFMS_NA_Support wfms_na_Support) {
		wfms_na_Support = toUnwrappedModel(wfms_na_Support);

		boolean isNew = wfms_na_Support.isNew();

		WFMS_NA_SupportModelImpl wfms_na_SupportModelImpl = (WFMS_NA_SupportModelImpl)wfms_na_Support;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_na_Support.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_na_Support.setCreateDate(now);
			}
			else {
				wfms_na_Support.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wfms_na_SupportModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_na_Support.setModifiedDate(now);
			}
			else {
				wfms_na_Support.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_na_Support.isNew()) {
				session.save(wfms_na_Support);

				wfms_na_Support.setNew(false);
			}
			else {
				wfms_na_Support = (WFMS_NA_Support)session.merge(wfms_na_Support);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_NA_SupportModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_NA_SupportImpl.class, wfms_na_Support.getPrimaryKey(),
			wfms_na_Support, false);

		clearUniqueFindersCache(wfms_na_SupportModelImpl, false);
		cacheUniqueFindersCache(wfms_na_SupportModelImpl);

		wfms_na_Support.resetOriginalValues();

		return wfms_na_Support;
	}

	protected WFMS_NA_Support toUnwrappedModel(WFMS_NA_Support wfms_na_Support) {
		if (wfms_na_Support instanceof WFMS_NA_SupportImpl) {
			return wfms_na_Support;
		}

		WFMS_NA_SupportImpl wfms_na_SupportImpl = new WFMS_NA_SupportImpl();

		wfms_na_SupportImpl.setNew(wfms_na_Support.isNew());
		wfms_na_SupportImpl.setPrimaryKey(wfms_na_Support.getPrimaryKey());

		wfms_na_SupportImpl.setASSOCIATE_NUMBER(wfms_na_Support.getASSOCIATE_NUMBER());
		wfms_na_SupportImpl.setASSOC_NO(wfms_na_Support.getASSOC_NO());
		wfms_na_SupportImpl.setASSOCIATE_DATE_OF_HIRE(wfms_na_Support.getASSOCIATE_DATE_OF_HIRE());
		wfms_na_SupportImpl.setASSOCIATE_NAME(wfms_na_Support.getASSOCIATE_NAME());
		wfms_na_SupportImpl.setDEPT_NUMBER(wfms_na_Support.getDEPT_NUMBER());
		wfms_na_SupportImpl.setDEPT_NO(wfms_na_Support.getDEPT_NO());
		wfms_na_SupportImpl.setDEPT_NAME(wfms_na_Support.getDEPT_NAME());
		wfms_na_SupportImpl.setASSOCIATE_TITLE(wfms_na_Support.getASSOCIATE_TITLE());
		wfms_na_SupportImpl.setSHIFT_CODE(wfms_na_Support.getSHIFT_CODE());
		wfms_na_SupportImpl.setTEAM_NUMBER(wfms_na_Support.getTEAM_NUMBER());
		wfms_na_SupportImpl.setEFFDT(wfms_na_Support.getEFFDT());
		wfms_na_SupportImpl.setTERMINATION_DT(wfms_na_Support.getTERMINATION_DT());
		wfms_na_SupportImpl.setMANAGER_ASSOCIATE_NUMBER(wfms_na_Support.getMANAGER_ASSOCIATE_NUMBER());
		wfms_na_SupportImpl.setASSGN_TYPE(wfms_na_Support.getASSGN_TYPE());
		wfms_na_SupportImpl.setLEADERSHIP_ASSIGNMENT(wfms_na_Support.getLEADERSHIP_ASSIGNMENT());
		wfms_na_SupportImpl.setEMAIL(wfms_na_Support.getEMAIL());
		wfms_na_SupportImpl.setDeleteflag(wfms_na_Support.getDeleteflag());
		wfms_na_SupportImpl.setCreatedBy(wfms_na_Support.getCreatedBy());
		wfms_na_SupportImpl.setCreateDate(wfms_na_Support.getCreateDate());
		wfms_na_SupportImpl.setModifiedBy(wfms_na_Support.getModifiedBy());
		wfms_na_SupportImpl.setModifiedDate(wfms_na_Support.getModifiedDate());

		return wfms_na_SupportImpl;
	}

	/**
	 * Returns the WFMS_NA_Support with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_NA_Support
	 * @return the WFMS_NA_Support
	 * @throws NoSuchWFMS_NA_SupportException if a WFMS_NA_Support with the primary key could not be found
	 */
	@Override
	public WFMS_NA_Support findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_NA_SupportException {
		WFMS_NA_Support wfms_na_Support = fetchByPrimaryKey(primaryKey);

		if (wfms_na_Support == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_NA_SupportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_na_Support;
	}

	/**
	 * Returns the WFMS_NA_Support with the primary key or throws a {@link NoSuchWFMS_NA_SupportException} if it could not be found.
	 *
	 * @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	 * @return the WFMS_NA_Support
	 * @throws NoSuchWFMS_NA_SupportException if a WFMS_NA_Support with the primary key could not be found
	 */
	@Override
	public WFMS_NA_Support findByPrimaryKey(String ASSOCIATE_NUMBER)
		throws NoSuchWFMS_NA_SupportException {
		return findByPrimaryKey((Serializable)ASSOCIATE_NUMBER);
	}

	/**
	 * Returns the WFMS_NA_Support with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_NA_Support
	 * @return the WFMS_NA_Support, or <code>null</code> if a WFMS_NA_Support with the primary key could not be found
	 */
	@Override
	public WFMS_NA_Support fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_NA_SupportImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_NA_Support wfms_na_Support = (WFMS_NA_Support)serializable;

		if (wfms_na_Support == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_na_Support = (WFMS_NA_Support)session.get(WFMS_NA_SupportImpl.class,
						primaryKey);

				if (wfms_na_Support != null) {
					cacheResult(wfms_na_Support);
				}
				else {
					entityCache.putResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_NA_SupportImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_NA_SupportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_na_Support;
	}

	/**
	 * Returns the WFMS_NA_Support with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	 * @return the WFMS_NA_Support, or <code>null</code> if a WFMS_NA_Support with the primary key could not be found
	 */
	@Override
	public WFMS_NA_Support fetchByPrimaryKey(String ASSOCIATE_NUMBER) {
		return fetchByPrimaryKey((Serializable)ASSOCIATE_NUMBER);
	}

	@Override
	public Map<Serializable, WFMS_NA_Support> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_NA_Support> map = new HashMap<Serializable, WFMS_NA_Support>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_NA_Support wfms_na_Support = fetchByPrimaryKey(primaryKey);

			if (wfms_na_Support != null) {
				map.put(primaryKey, wfms_na_Support);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_NA_SupportImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_NA_Support)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_NA_SUPPORT_WHERE_PKS_IN);

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

			for (WFMS_NA_Support wfms_na_Support : (List<WFMS_NA_Support>)q.list()) {
				map.put(wfms_na_Support.getPrimaryKeyObj(), wfms_na_Support);

				cacheResult(wfms_na_Support);

				uncachedPrimaryKeys.remove(wfms_na_Support.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_NA_SupportModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_NA_SupportImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_NA_Supports.
	 *
	 * @return the WFMS_NA_Supports
	 */
	@Override
	public List<WFMS_NA_Support> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_NA_Supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_NA_Supports
	 * @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	 * @return the range of WFMS_NA_Supports
	 */
	@Override
	public List<WFMS_NA_Support> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_NA_Supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_NA_Supports
	 * @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_NA_Supports
	 */
	@Override
	public List<WFMS_NA_Support> findAll(int start, int end,
		OrderByComparator<WFMS_NA_Support> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_NA_Supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_NA_Supports
	 * @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_NA_Supports
	 */
	@Override
	public List<WFMS_NA_Support> findAll(int start, int end,
		OrderByComparator<WFMS_NA_Support> orderByComparator,
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

		List<WFMS_NA_Support> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_NA_Support>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_NA_SUPPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_NA_SUPPORT;

				if (pagination) {
					sql = sql.concat(WFMS_NA_SupportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_NA_Support>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_NA_Support>)QueryUtil.list(q,
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
	 * Removes all the WFMS_NA_Supports from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_NA_Support wfms_na_Support : findAll()) {
			remove(wfms_na_Support);
		}
	}

	/**
	 * Returns the number of WFMS_NA_Supports.
	 *
	 * @return the number of WFMS_NA_Supports
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_NA_SUPPORT);

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
		return WFMS_NA_SupportModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_NA_Support persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_NA_SupportImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_NA_SUPPORT = "SELECT wfms_na_Support FROM WFMS_NA_Support wfms_na_Support";
	private static final String _SQL_SELECT_WFMS_NA_SUPPORT_WHERE_PKS_IN = "SELECT wfms_na_Support FROM WFMS_NA_Support wfms_na_Support WHERE ASSOCIATE_NUMBER IN (";
	private static final String _SQL_SELECT_WFMS_NA_SUPPORT_WHERE = "SELECT wfms_na_Support FROM WFMS_NA_Support wfms_na_Support WHERE ";
	private static final String _SQL_COUNT_WFMS_NA_SUPPORT = "SELECT COUNT(wfms_na_Support) FROM WFMS_NA_Support wfms_na_Support";
	private static final String _SQL_COUNT_WFMS_NA_SUPPORT_WHERE = "SELECT COUNT(wfms_na_Support) FROM WFMS_NA_Support wfms_na_Support WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_na_Support.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_NA_Support exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_NA_Support exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_NA_SupportPersistenceImpl.class);
}