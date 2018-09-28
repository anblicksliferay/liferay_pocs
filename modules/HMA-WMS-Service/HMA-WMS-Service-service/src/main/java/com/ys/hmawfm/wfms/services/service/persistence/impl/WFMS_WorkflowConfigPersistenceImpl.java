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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_WorkflowConfigPersistence;

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
 * The persistence implementation for the WFMS_WorkflowConfig service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfigPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_WorkflowConfigUtil
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigPersistenceImpl extends BasePersistenceImpl<WFMS_WorkflowConfig>
	implements WFMS_WorkflowConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_WorkflowConfigUtil} to access the WFMS_WorkflowConfig persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_WorkflowConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigModelImpl.FINDER_CACHE_ENABLED,
			WFMS_WorkflowConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigModelImpl.FINDER_CACHE_ENABLED,
			WFMS_WorkflowConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CONFIGKEY = new FinderPath(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigModelImpl.FINDER_CACHE_ENABLED,
			WFMS_WorkflowConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByConfigKey", new String[] { String.class.getName() },
			WFMS_WorkflowConfigModelImpl.CONFIGKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONFIGKEY = new FinderPath(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConfigKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_WorkflowConfig where configKey = &#63; or throws a {@link NoSuchWFMS_WorkflowConfigException} if it could not be found.
	 *
	 * @param configKey the config key
	 * @return the matching WFMS_WorkflowConfig
	 * @throws NoSuchWFMS_WorkflowConfigException if a matching WFMS_WorkflowConfig could not be found
	 */
	@Override
	public WFMS_WorkflowConfig findByConfigKey(String configKey)
		throws NoSuchWFMS_WorkflowConfigException {
		WFMS_WorkflowConfig wfms_WorkflowConfig = fetchByConfigKey(configKey);

		if (wfms_WorkflowConfig == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("configKey=");
			msg.append(configKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_WorkflowConfigException(msg.toString());
		}

		return wfms_WorkflowConfig;
	}

	/**
	 * Returns the WFMS_WorkflowConfig where configKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param configKey the config key
	 * @return the matching WFMS_WorkflowConfig, or <code>null</code> if a matching WFMS_WorkflowConfig could not be found
	 */
	@Override
	public WFMS_WorkflowConfig fetchByConfigKey(String configKey) {
		return fetchByConfigKey(configKey, true);
	}

	/**
	 * Returns the WFMS_WorkflowConfig where configKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param configKey the config key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_WorkflowConfig, or <code>null</code> if a matching WFMS_WorkflowConfig could not be found
	 */
	@Override
	public WFMS_WorkflowConfig fetchByConfigKey(String configKey,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { configKey };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
					finderArgs, this);
		}

		if (result instanceof WFMS_WorkflowConfig) {
			WFMS_WorkflowConfig wfms_WorkflowConfig = (WFMS_WorkflowConfig)result;

			if (!Objects.equals(configKey, wfms_WorkflowConfig.getConfigKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_WORKFLOWCONFIG_WHERE);

			boolean bindConfigKey = false;

			if (configKey == null) {
				query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1);
			}
			else if (configKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3);
			}
			else {
				bindConfigKey = true;

				query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindConfigKey) {
					qPos.add(configKey);
				}

				List<WFMS_WorkflowConfig> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_WorkflowConfigPersistenceImpl.fetchByConfigKey(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_WorkflowConfig wfms_WorkflowConfig = list.get(0);

					result = wfms_WorkflowConfig;

					cacheResult(wfms_WorkflowConfig);

					if ((wfms_WorkflowConfig.getConfigKey() == null) ||
							!wfms_WorkflowConfig.getConfigKey().equals(configKey)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
							finderArgs, wfms_WorkflowConfig);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
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
			return (WFMS_WorkflowConfig)result;
		}
	}

	/**
	 * Removes the WFMS_WorkflowConfig where configKey = &#63; from the database.
	 *
	 * @param configKey the config key
	 * @return the WFMS_WorkflowConfig that was removed
	 */
	@Override
	public WFMS_WorkflowConfig removeByConfigKey(String configKey)
		throws NoSuchWFMS_WorkflowConfigException {
		WFMS_WorkflowConfig wfms_WorkflowConfig = findByConfigKey(configKey);

		return remove(wfms_WorkflowConfig);
	}

	/**
	 * Returns the number of WFMS_WorkflowConfigs where configKey = &#63;.
	 *
	 * @param configKey the config key
	 * @return the number of matching WFMS_WorkflowConfigs
	 */
	@Override
	public int countByConfigKey(String configKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONFIGKEY;

		Object[] finderArgs = new Object[] { configKey };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_WORKFLOWCONFIG_WHERE);

			boolean bindConfigKey = false;

			if (configKey == null) {
				query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1);
			}
			else if (configKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3);
			}
			else {
				bindConfigKey = true;

				query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindConfigKey) {
					qPos.add(configKey);
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

	private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1 = "wfms_WorkflowConfig.configKey IS NULL";
	private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2 = "wfms_WorkflowConfig.configKey = ?";
	private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3 = "(wfms_WorkflowConfig.configKey IS NULL OR wfms_WorkflowConfig.configKey = '')";

	public WFMS_WorkflowConfigPersistenceImpl() {
		setModelClass(WFMS_WorkflowConfig.class);
	}

	/**
	 * Caches the WFMS_WorkflowConfig in the entity cache if it is enabled.
	 *
	 * @param wfms_WorkflowConfig the WFMS_WorkflowConfig
	 */
	@Override
	public void cacheResult(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		entityCache.putResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigImpl.class, wfms_WorkflowConfig.getPrimaryKey(),
			wfms_WorkflowConfig);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
			new Object[] { wfms_WorkflowConfig.getConfigKey() },
			wfms_WorkflowConfig);

		wfms_WorkflowConfig.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_WorkflowConfigs in the entity cache if it is enabled.
	 *
	 * @param wfms_WorkflowConfigs the WFMS_WorkflowConfigs
	 */
	@Override
	public void cacheResult(List<WFMS_WorkflowConfig> wfms_WorkflowConfigs) {
		for (WFMS_WorkflowConfig wfms_WorkflowConfig : wfms_WorkflowConfigs) {
			if (entityCache.getResult(
						WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_WorkflowConfigImpl.class,
						wfms_WorkflowConfig.getPrimaryKey()) == null) {
				cacheResult(wfms_WorkflowConfig);
			}
			else {
				wfms_WorkflowConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_WorkflowConfigs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_WorkflowConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_WorkflowConfig.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		entityCache.removeResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigImpl.class, wfms_WorkflowConfig.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_WorkflowConfigModelImpl)wfms_WorkflowConfig,
			true);
	}

	@Override
	public void clearCache(List<WFMS_WorkflowConfig> wfms_WorkflowConfigs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_WorkflowConfig wfms_WorkflowConfig : wfms_WorkflowConfigs) {
			entityCache.removeResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_WorkflowConfigImpl.class,
				wfms_WorkflowConfig.getPrimaryKey());

			clearUniqueFindersCache((WFMS_WorkflowConfigModelImpl)wfms_WorkflowConfig,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_WorkflowConfigModelImpl wfms_WorkflowConfigModelImpl) {
		Object[] args = new Object[] { wfms_WorkflowConfigModelImpl.getConfigKey() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_CONFIGKEY, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY, args,
			wfms_WorkflowConfigModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_WorkflowConfigModelImpl wfms_WorkflowConfigModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					wfms_WorkflowConfigModelImpl.getConfigKey()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CONFIGKEY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CONFIGKEY, args);
		}

		if ((wfms_WorkflowConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONFIGKEY.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_WorkflowConfigModelImpl.getOriginalConfigKey()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CONFIGKEY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CONFIGKEY, args);
		}
	}

	/**
	 * Creates a new WFMS_WorkflowConfig with the primary key. Does not add the WFMS_WorkflowConfig to the database.
	 *
	 * @param wfcId the primary key for the new WFMS_WorkflowConfig
	 * @return the new WFMS_WorkflowConfig
	 */
	@Override
	public WFMS_WorkflowConfig create(long wfcId) {
		WFMS_WorkflowConfig wfms_WorkflowConfig = new WFMS_WorkflowConfigImpl();

		wfms_WorkflowConfig.setNew(true);
		wfms_WorkflowConfig.setPrimaryKey(wfcId);

		return wfms_WorkflowConfig;
	}

	/**
	 * Removes the WFMS_WorkflowConfig with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wfcId the primary key of the WFMS_WorkflowConfig
	 * @return the WFMS_WorkflowConfig that was removed
	 * @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	 */
	@Override
	public WFMS_WorkflowConfig remove(long wfcId)
		throws NoSuchWFMS_WorkflowConfigException {
		return remove((Serializable)wfcId);
	}

	/**
	 * Removes the WFMS_WorkflowConfig with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_WorkflowConfig
	 * @return the WFMS_WorkflowConfig that was removed
	 * @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	 */
	@Override
	public WFMS_WorkflowConfig remove(Serializable primaryKey)
		throws NoSuchWFMS_WorkflowConfigException {
		Session session = null;

		try {
			session = openSession();

			WFMS_WorkflowConfig wfms_WorkflowConfig = (WFMS_WorkflowConfig)session.get(WFMS_WorkflowConfigImpl.class,
					primaryKey);

			if (wfms_WorkflowConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_WorkflowConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_WorkflowConfig);
		}
		catch (NoSuchWFMS_WorkflowConfigException nsee) {
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
	protected WFMS_WorkflowConfig removeImpl(
		WFMS_WorkflowConfig wfms_WorkflowConfig) {
		wfms_WorkflowConfig = toUnwrappedModel(wfms_WorkflowConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_WorkflowConfig)) {
				wfms_WorkflowConfig = (WFMS_WorkflowConfig)session.get(WFMS_WorkflowConfigImpl.class,
						wfms_WorkflowConfig.getPrimaryKeyObj());
			}

			if (wfms_WorkflowConfig != null) {
				session.delete(wfms_WorkflowConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_WorkflowConfig != null) {
			clearCache(wfms_WorkflowConfig);
		}

		return wfms_WorkflowConfig;
	}

	@Override
	public WFMS_WorkflowConfig updateImpl(
		WFMS_WorkflowConfig wfms_WorkflowConfig) {
		wfms_WorkflowConfig = toUnwrappedModel(wfms_WorkflowConfig);

		boolean isNew = wfms_WorkflowConfig.isNew();

		WFMS_WorkflowConfigModelImpl wfms_WorkflowConfigModelImpl = (WFMS_WorkflowConfigModelImpl)wfms_WorkflowConfig;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_WorkflowConfig.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_WorkflowConfig.setCreateDate(now);
			}
			else {
				wfms_WorkflowConfig.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!wfms_WorkflowConfigModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_WorkflowConfig.setModifiedDate(now);
			}
			else {
				wfms_WorkflowConfig.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_WorkflowConfig.isNew()) {
				session.save(wfms_WorkflowConfig);

				wfms_WorkflowConfig.setNew(false);
			}
			else {
				wfms_WorkflowConfig = (WFMS_WorkflowConfig)session.merge(wfms_WorkflowConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_WorkflowConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_WorkflowConfigImpl.class, wfms_WorkflowConfig.getPrimaryKey(),
			wfms_WorkflowConfig, false);

		clearUniqueFindersCache(wfms_WorkflowConfigModelImpl, false);
		cacheUniqueFindersCache(wfms_WorkflowConfigModelImpl);

		wfms_WorkflowConfig.resetOriginalValues();

		return wfms_WorkflowConfig;
	}

	protected WFMS_WorkflowConfig toUnwrappedModel(
		WFMS_WorkflowConfig wfms_WorkflowConfig) {
		if (wfms_WorkflowConfig instanceof WFMS_WorkflowConfigImpl) {
			return wfms_WorkflowConfig;
		}

		WFMS_WorkflowConfigImpl wfms_WorkflowConfigImpl = new WFMS_WorkflowConfigImpl();

		wfms_WorkflowConfigImpl.setNew(wfms_WorkflowConfig.isNew());
		wfms_WorkflowConfigImpl.setPrimaryKey(wfms_WorkflowConfig.getPrimaryKey());

		wfms_WorkflowConfigImpl.setWfcId(wfms_WorkflowConfig.getWfcId());
		wfms_WorkflowConfigImpl.setCreatedBy(wfms_WorkflowConfig.getCreatedBy());
		wfms_WorkflowConfigImpl.setCreateDate(wfms_WorkflowConfig.getCreateDate());
		wfms_WorkflowConfigImpl.setModifiedBy(wfms_WorkflowConfig.getModifiedBy());
		wfms_WorkflowConfigImpl.setModifiedDate(wfms_WorkflowConfig.getModifiedDate());
		wfms_WorkflowConfigImpl.setConfigKey(wfms_WorkflowConfig.getConfigKey());
		wfms_WorkflowConfigImpl.setConfigLabel(wfms_WorkflowConfig.getConfigLabel());
		wfms_WorkflowConfigImpl.setContentType(wfms_WorkflowConfig.getContentType());
		wfms_WorkflowConfigImpl.setContent(wfms_WorkflowConfig.getContent());

		return wfms_WorkflowConfigImpl;
	}

	/**
	 * Returns the WFMS_WorkflowConfig with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_WorkflowConfig
	 * @return the WFMS_WorkflowConfig
	 * @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	 */
	@Override
	public WFMS_WorkflowConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_WorkflowConfigException {
		WFMS_WorkflowConfig wfms_WorkflowConfig = fetchByPrimaryKey(primaryKey);

		if (wfms_WorkflowConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_WorkflowConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_WorkflowConfig;
	}

	/**
	 * Returns the WFMS_WorkflowConfig with the primary key or throws a {@link NoSuchWFMS_WorkflowConfigException} if it could not be found.
	 *
	 * @param wfcId the primary key of the WFMS_WorkflowConfig
	 * @return the WFMS_WorkflowConfig
	 * @throws NoSuchWFMS_WorkflowConfigException if a WFMS_WorkflowConfig with the primary key could not be found
	 */
	@Override
	public WFMS_WorkflowConfig findByPrimaryKey(long wfcId)
		throws NoSuchWFMS_WorkflowConfigException {
		return findByPrimaryKey((Serializable)wfcId);
	}

	/**
	 * Returns the WFMS_WorkflowConfig with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_WorkflowConfig
	 * @return the WFMS_WorkflowConfig, or <code>null</code> if a WFMS_WorkflowConfig with the primary key could not be found
	 */
	@Override
	public WFMS_WorkflowConfig fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_WorkflowConfigImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_WorkflowConfig wfms_WorkflowConfig = (WFMS_WorkflowConfig)serializable;

		if (wfms_WorkflowConfig == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_WorkflowConfig = (WFMS_WorkflowConfig)session.get(WFMS_WorkflowConfigImpl.class,
						primaryKey);

				if (wfms_WorkflowConfig != null) {
					cacheResult(wfms_WorkflowConfig);
				}
				else {
					entityCache.putResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_WorkflowConfigImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_WorkflowConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_WorkflowConfig;
	}

	/**
	 * Returns the WFMS_WorkflowConfig with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wfcId the primary key of the WFMS_WorkflowConfig
	 * @return the WFMS_WorkflowConfig, or <code>null</code> if a WFMS_WorkflowConfig with the primary key could not be found
	 */
	@Override
	public WFMS_WorkflowConfig fetchByPrimaryKey(long wfcId) {
		return fetchByPrimaryKey((Serializable)wfcId);
	}

	@Override
	public Map<Serializable, WFMS_WorkflowConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_WorkflowConfig> map = new HashMap<Serializable, WFMS_WorkflowConfig>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_WorkflowConfig wfms_WorkflowConfig = fetchByPrimaryKey(primaryKey);

			if (wfms_WorkflowConfig != null) {
				map.put(primaryKey, wfms_WorkflowConfig);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_WorkflowConfigImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_WorkflowConfig)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_WORKFLOWCONFIG_WHERE_PKS_IN);

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

			for (WFMS_WorkflowConfig wfms_WorkflowConfig : (List<WFMS_WorkflowConfig>)q.list()) {
				map.put(wfms_WorkflowConfig.getPrimaryKeyObj(),
					wfms_WorkflowConfig);

				cacheResult(wfms_WorkflowConfig);

				uncachedPrimaryKeys.remove(wfms_WorkflowConfig.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_WorkflowConfigModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_WorkflowConfigImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_WorkflowConfigs.
	 *
	 * @return the WFMS_WorkflowConfigs
	 */
	@Override
	public List<WFMS_WorkflowConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_WorkflowConfigs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_WorkflowConfigs
	 * @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	 * @return the range of WFMS_WorkflowConfigs
	 */
	@Override
	public List<WFMS_WorkflowConfig> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_WorkflowConfigs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_WorkflowConfigs
	 * @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_WorkflowConfigs
	 */
	@Override
	public List<WFMS_WorkflowConfig> findAll(int start, int end,
		OrderByComparator<WFMS_WorkflowConfig> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_WorkflowConfigs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_WorkflowConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_WorkflowConfigs
	 * @param end the upper bound of the range of WFMS_WorkflowConfigs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_WorkflowConfigs
	 */
	@Override
	public List<WFMS_WorkflowConfig> findAll(int start, int end,
		OrderByComparator<WFMS_WorkflowConfig> orderByComparator,
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

		List<WFMS_WorkflowConfig> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_WorkflowConfig>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_WORKFLOWCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_WORKFLOWCONFIG;

				if (pagination) {
					sql = sql.concat(WFMS_WorkflowConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_WorkflowConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_WorkflowConfig>)QueryUtil.list(q,
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
	 * Removes all the WFMS_WorkflowConfigs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_WorkflowConfig wfms_WorkflowConfig : findAll()) {
			remove(wfms_WorkflowConfig);
		}
	}

	/**
	 * Returns the number of WFMS_WorkflowConfigs.
	 *
	 * @return the number of WFMS_WorkflowConfigs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_WORKFLOWCONFIG);

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
		return WFMS_WorkflowConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_WorkflowConfig persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_WorkflowConfigImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_WORKFLOWCONFIG = "SELECT wfms_WorkflowConfig FROM WFMS_WorkflowConfig wfms_WorkflowConfig";
	private static final String _SQL_SELECT_WFMS_WORKFLOWCONFIG_WHERE_PKS_IN = "SELECT wfms_WorkflowConfig FROM WFMS_WorkflowConfig wfms_WorkflowConfig WHERE wfcId IN (";
	private static final String _SQL_SELECT_WFMS_WORKFLOWCONFIG_WHERE = "SELECT wfms_WorkflowConfig FROM WFMS_WorkflowConfig wfms_WorkflowConfig WHERE ";
	private static final String _SQL_COUNT_WFMS_WORKFLOWCONFIG = "SELECT COUNT(wfms_WorkflowConfig) FROM WFMS_WorkflowConfig wfms_WorkflowConfig";
	private static final String _SQL_COUNT_WFMS_WORKFLOWCONFIG_WHERE = "SELECT COUNT(wfms_WorkflowConfig) FROM WFMS_WorkflowConfig wfms_WorkflowConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_WorkflowConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_WorkflowConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_WorkflowConfig exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_WorkflowConfigPersistenceImpl.class);
}