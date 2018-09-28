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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_ConfigImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_ConfigModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_ConfigPersistence;

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
 * The persistence implementation for the WFMS_Configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_ConfigPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_ConfigUtil
 * @generated
 */
@ProviderType
public class WFMS_ConfigPersistenceImpl extends BasePersistenceImpl<WFMS_Config>
	implements WFMS_ConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_ConfigUtil} to access the WFMS_Configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_ConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigModelImpl.FINDER_CACHE_ENABLED, WFMS_ConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigModelImpl.FINDER_CACHE_ENABLED, WFMS_ConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CONFIGKEY = new FinderPath(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigModelImpl.FINDER_CACHE_ENABLED, WFMS_ConfigImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByConfigKey",
			new String[] { String.class.getName() },
			WFMS_ConfigModelImpl.CONFIGKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONFIGKEY = new FinderPath(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConfigKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the WFMS_Configuration where configKey = &#63; or throws a {@link NoSuchWFMS_ConfigException} if it could not be found.
	 *
	 * @param configKey the config key
	 * @return the matching WFMS_Configuration
	 * @throws NoSuchWFMS_ConfigException if a matching WFMS_Configuration could not be found
	 */
	@Override
	public WFMS_Config findByConfigKey(String configKey)
		throws NoSuchWFMS_ConfigException {
		WFMS_Config wfms_Config = fetchByConfigKey(configKey);

		if (wfms_Config == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("configKey=");
			msg.append(configKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWFMS_ConfigException(msg.toString());
		}

		return wfms_Config;
	}

	/**
	 * Returns the WFMS_Configuration where configKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param configKey the config key
	 * @return the matching WFMS_Configuration, or <code>null</code> if a matching WFMS_Configuration could not be found
	 */
	@Override
	public WFMS_Config fetchByConfigKey(String configKey) {
		return fetchByConfigKey(configKey, true);
	}

	/**
	 * Returns the WFMS_Configuration where configKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param configKey the config key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching WFMS_Configuration, or <code>null</code> if a matching WFMS_Configuration could not be found
	 */
	@Override
	public WFMS_Config fetchByConfigKey(String configKey,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { configKey };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
					finderArgs, this);
		}

		if (result instanceof WFMS_Config) {
			WFMS_Config wfms_Config = (WFMS_Config)result;

			if (!Objects.equals(configKey, wfms_Config.getConfigKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WFMS_CONFIG_WHERE);

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

				List<WFMS_Config> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WFMS_ConfigPersistenceImpl.fetchByConfigKey(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WFMS_Config wfms_Config = list.get(0);

					result = wfms_Config;

					cacheResult(wfms_Config);

					if ((wfms_Config.getConfigKey() == null) ||
							!wfms_Config.getConfigKey().equals(configKey)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
							finderArgs, wfms_Config);
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
			return (WFMS_Config)result;
		}
	}

	/**
	 * Removes the WFMS_Configuration where configKey = &#63; from the database.
	 *
	 * @param configKey the config key
	 * @return the WFMS_Configuration that was removed
	 */
	@Override
	public WFMS_Config removeByConfigKey(String configKey)
		throws NoSuchWFMS_ConfigException {
		WFMS_Config wfms_Config = findByConfigKey(configKey);

		return remove(wfms_Config);
	}

	/**
	 * Returns the number of WFMS_Configurations where configKey = &#63;.
	 *
	 * @param configKey the config key
	 * @return the number of matching WFMS_Configurations
	 */
	@Override
	public int countByConfigKey(String configKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONFIGKEY;

		Object[] finderArgs = new Object[] { configKey };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WFMS_CONFIG_WHERE);

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

	private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1 = "wfms_Config.configKey IS NULL";
	private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2 = "wfms_Config.configKey = ?";
	private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3 = "(wfms_Config.configKey IS NULL OR wfms_Config.configKey = '')";

	public WFMS_ConfigPersistenceImpl() {
		setModelClass(WFMS_Config.class);
	}

	/**
	 * Caches the WFMS_Configuration in the entity cache if it is enabled.
	 *
	 * @param wfms_Config the WFMS_Configuration
	 */
	@Override
	public void cacheResult(WFMS_Config wfms_Config) {
		entityCache.putResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigImpl.class, wfms_Config.getPrimaryKey(), wfms_Config);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY,
			new Object[] { wfms_Config.getConfigKey() }, wfms_Config);

		wfms_Config.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_Configurations in the entity cache if it is enabled.
	 *
	 * @param wfms_Configs the WFMS_Configurations
	 */
	@Override
	public void cacheResult(List<WFMS_Config> wfms_Configs) {
		for (WFMS_Config wfms_Config : wfms_Configs) {
			if (entityCache.getResult(
						WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_ConfigImpl.class, wfms_Config.getPrimaryKey()) == null) {
				cacheResult(wfms_Config);
			}
			else {
				wfms_Config.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_Configurations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_ConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_Configuration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_Config wfms_Config) {
		entityCache.removeResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigImpl.class, wfms_Config.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WFMS_ConfigModelImpl)wfms_Config, true);
	}

	@Override
	public void clearCache(List<WFMS_Config> wfms_Configs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_Config wfms_Config : wfms_Configs) {
			entityCache.removeResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_ConfigImpl.class, wfms_Config.getPrimaryKey());

			clearUniqueFindersCache((WFMS_ConfigModelImpl)wfms_Config, true);
		}
	}

	protected void cacheUniqueFindersCache(
		WFMS_ConfigModelImpl wfms_ConfigModelImpl) {
		Object[] args = new Object[] { wfms_ConfigModelImpl.getConfigKey() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_CONFIGKEY, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CONFIGKEY, args,
			wfms_ConfigModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WFMS_ConfigModelImpl wfms_ConfigModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { wfms_ConfigModelImpl.getConfigKey() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CONFIGKEY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CONFIGKEY, args);
		}

		if ((wfms_ConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONFIGKEY.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wfms_ConfigModelImpl.getOriginalConfigKey()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CONFIGKEY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CONFIGKEY, args);
		}
	}

	/**
	 * Creates a new WFMS_Configuration with the primary key. Does not add the WFMS_Configuration to the database.
	 *
	 * @param configId the primary key for the new WFMS_Configuration
	 * @return the new WFMS_Configuration
	 */
	@Override
	public WFMS_Config create(long configId) {
		WFMS_Config wfms_Config = new WFMS_ConfigImpl();

		wfms_Config.setNew(true);
		wfms_Config.setPrimaryKey(configId);

		return wfms_Config;
	}

	/**
	 * Removes the WFMS_Configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the WFMS_Configuration
	 * @return the WFMS_Configuration that was removed
	 * @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	 */
	@Override
	public WFMS_Config remove(long configId) throws NoSuchWFMS_ConfigException {
		return remove((Serializable)configId);
	}

	/**
	 * Removes the WFMS_Configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_Configuration
	 * @return the WFMS_Configuration that was removed
	 * @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	 */
	@Override
	public WFMS_Config remove(Serializable primaryKey)
		throws NoSuchWFMS_ConfigException {
		Session session = null;

		try {
			session = openSession();

			WFMS_Config wfms_Config = (WFMS_Config)session.get(WFMS_ConfigImpl.class,
					primaryKey);

			if (wfms_Config == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_ConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_Config);
		}
		catch (NoSuchWFMS_ConfigException nsee) {
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
	protected WFMS_Config removeImpl(WFMS_Config wfms_Config) {
		wfms_Config = toUnwrappedModel(wfms_Config);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_Config)) {
				wfms_Config = (WFMS_Config)session.get(WFMS_ConfigImpl.class,
						wfms_Config.getPrimaryKeyObj());
			}

			if (wfms_Config != null) {
				session.delete(wfms_Config);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_Config != null) {
			clearCache(wfms_Config);
		}

		return wfms_Config;
	}

	@Override
	public WFMS_Config updateImpl(WFMS_Config wfms_Config) {
		wfms_Config = toUnwrappedModel(wfms_Config);

		boolean isNew = wfms_Config.isNew();

		WFMS_ConfigModelImpl wfms_ConfigModelImpl = (WFMS_ConfigModelImpl)wfms_Config;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_Config.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_Config.setCreateDate(now);
			}
			else {
				wfms_Config.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wfms_ConfigModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_Config.setModifiedDate(now);
			}
			else {
				wfms_Config.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_Config.isNew()) {
				session.save(wfms_Config);

				wfms_Config.setNew(false);
			}
			else {
				wfms_Config = (WFMS_Config)session.merge(wfms_Config);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WFMS_ConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_ConfigImpl.class, wfms_Config.getPrimaryKey(), wfms_Config,
			false);

		clearUniqueFindersCache(wfms_ConfigModelImpl, false);
		cacheUniqueFindersCache(wfms_ConfigModelImpl);

		wfms_Config.resetOriginalValues();

		return wfms_Config;
	}

	protected WFMS_Config toUnwrappedModel(WFMS_Config wfms_Config) {
		if (wfms_Config instanceof WFMS_ConfigImpl) {
			return wfms_Config;
		}

		WFMS_ConfigImpl wfms_ConfigImpl = new WFMS_ConfigImpl();

		wfms_ConfigImpl.setNew(wfms_Config.isNew());
		wfms_ConfigImpl.setPrimaryKey(wfms_Config.getPrimaryKey());

		wfms_ConfigImpl.setConfigId(wfms_Config.getConfigId());
		wfms_ConfigImpl.setCreatedBy(wfms_Config.getCreatedBy());
		wfms_ConfigImpl.setCreateDate(wfms_Config.getCreateDate());
		wfms_ConfigImpl.setModifiedBy(wfms_Config.getModifiedBy());
		wfms_ConfigImpl.setModifiedDate(wfms_Config.getModifiedDate());
		wfms_ConfigImpl.setConfigKey(wfms_Config.getConfigKey());
		wfms_ConfigImpl.setConfigLabel(wfms_Config.getConfigLabel());
		wfms_ConfigImpl.setContentType(wfms_Config.getContentType());
		wfms_ConfigImpl.setContent(wfms_Config.getContent());

		return wfms_ConfigImpl;
	}

	/**
	 * Returns the WFMS_Configuration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Configuration
	 * @return the WFMS_Configuration
	 * @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	 */
	@Override
	public WFMS_Config findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_ConfigException {
		WFMS_Config wfms_Config = fetchByPrimaryKey(primaryKey);

		if (wfms_Config == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_ConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_Config;
	}

	/**
	 * Returns the WFMS_Configuration with the primary key or throws a {@link NoSuchWFMS_ConfigException} if it could not be found.
	 *
	 * @param configId the primary key of the WFMS_Configuration
	 * @return the WFMS_Configuration
	 * @throws NoSuchWFMS_ConfigException if a WFMS_Configuration with the primary key could not be found
	 */
	@Override
	public WFMS_Config findByPrimaryKey(long configId)
		throws NoSuchWFMS_ConfigException {
		return findByPrimaryKey((Serializable)configId);
	}

	/**
	 * Returns the WFMS_Configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Configuration
	 * @return the WFMS_Configuration, or <code>null</code> if a WFMS_Configuration with the primary key could not be found
	 */
	@Override
	public WFMS_Config fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_ConfigImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_Config wfms_Config = (WFMS_Config)serializable;

		if (wfms_Config == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_Config = (WFMS_Config)session.get(WFMS_ConfigImpl.class,
						primaryKey);

				if (wfms_Config != null) {
					cacheResult(wfms_Config);
				}
				else {
					entityCache.putResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_ConfigImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_ConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_Config;
	}

	/**
	 * Returns the WFMS_Configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the WFMS_Configuration
	 * @return the WFMS_Configuration, or <code>null</code> if a WFMS_Configuration with the primary key could not be found
	 */
	@Override
	public WFMS_Config fetchByPrimaryKey(long configId) {
		return fetchByPrimaryKey((Serializable)configId);
	}

	@Override
	public Map<Serializable, WFMS_Config> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_Config> map = new HashMap<Serializable, WFMS_Config>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_Config wfms_Config = fetchByPrimaryKey(primaryKey);

			if (wfms_Config != null) {
				map.put(primaryKey, wfms_Config);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_ConfigImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_Config)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_CONFIG_WHERE_PKS_IN);

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

			for (WFMS_Config wfms_Config : (List<WFMS_Config>)q.list()) {
				map.put(wfms_Config.getPrimaryKeyObj(), wfms_Config);

				cacheResult(wfms_Config);

				uncachedPrimaryKeys.remove(wfms_Config.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_ConfigModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_ConfigImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_Configurations.
	 *
	 * @return the WFMS_Configurations
	 */
	@Override
	public List<WFMS_Config> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Configurations
	 * @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	 * @return the range of WFMS_Configurations
	 */
	@Override
	public List<WFMS_Config> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Configurations
	 * @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_Configurations
	 */
	@Override
	public List<WFMS_Config> findAll(int start, int end,
		OrderByComparator<WFMS_Config> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Configurations
	 * @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_Configurations
	 */
	@Override
	public List<WFMS_Config> findAll(int start, int end,
		OrderByComparator<WFMS_Config> orderByComparator,
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

		List<WFMS_Config> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Config>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_CONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_CONFIG;

				if (pagination) {
					sql = sql.concat(WFMS_ConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_Config>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Config>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the WFMS_Configurations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_Config wfms_Config : findAll()) {
			remove(wfms_Config);
		}
	}

	/**
	 * Returns the number of WFMS_Configurations.
	 *
	 * @return the number of WFMS_Configurations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_CONFIG);

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
		return WFMS_ConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_Configuration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_ConfigImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_CONFIG = "SELECT wfms_Config FROM WFMS_Config wfms_Config";
	private static final String _SQL_SELECT_WFMS_CONFIG_WHERE_PKS_IN = "SELECT wfms_Config FROM WFMS_Config wfms_Config WHERE configId IN (";
	private static final String _SQL_SELECT_WFMS_CONFIG_WHERE = "SELECT wfms_Config FROM WFMS_Config wfms_Config WHERE ";
	private static final String _SQL_COUNT_WFMS_CONFIG = "SELECT COUNT(wfms_Config) FROM WFMS_Config wfms_Config";
	private static final String _SQL_COUNT_WFMS_CONFIG_WHERE = "SELECT COUNT(wfms_Config) FROM WFMS_Config wfms_Config WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_Config.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_Config exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WFMS_Config exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_ConfigPersistenceImpl.class);
}