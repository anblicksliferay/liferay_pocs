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
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_namesException;
import com.ys.hmawfm.wfms.services.model.WFMS_action_names;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_action_namesPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the WFMS_action_names service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_namesPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_action_namesUtil
 * @generated
 */
@ProviderType
public class WFMS_action_namesPersistenceImpl extends BasePersistenceImpl<WFMS_action_names>
	implements WFMS_action_namesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_action_namesUtil} to access the WFMS_action_names persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_action_namesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_namesModelImpl.FINDER_CACHE_ENABLED,
			WFMS_action_namesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_namesModelImpl.FINDER_CACHE_ENABLED,
			WFMS_action_namesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_namesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WFMS_action_namesPersistenceImpl() {
		setModelClass(WFMS_action_names.class);
	}

	/**
	 * Caches the WFMS_action_names in the entity cache if it is enabled.
	 *
	 * @param wfms_action_names the WFMS_action_names
	 */
	@Override
	public void cacheResult(WFMS_action_names wfms_action_names) {
		entityCache.putResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_namesImpl.class, wfms_action_names.getPrimaryKey(),
			wfms_action_names);

		wfms_action_names.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_action_nameses in the entity cache if it is enabled.
	 *
	 * @param wfms_action_nameses the WFMS_action_nameses
	 */
	@Override
	public void cacheResult(List<WFMS_action_names> wfms_action_nameses) {
		for (WFMS_action_names wfms_action_names : wfms_action_nameses) {
			if (entityCache.getResult(
						WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_action_namesImpl.class,
						wfms_action_names.getPrimaryKey()) == null) {
				cacheResult(wfms_action_names);
			}
			else {
				wfms_action_names.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_action_nameses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_action_namesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_action_names.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_action_names wfms_action_names) {
		entityCache.removeResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_namesImpl.class, wfms_action_names.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WFMS_action_names> wfms_action_nameses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_action_names wfms_action_names : wfms_action_nameses) {
			entityCache.removeResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_action_namesImpl.class, wfms_action_names.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_action_names with the primary key. Does not add the WFMS_action_names to the database.
	 *
	 * @param actionId the primary key for the new WFMS_action_names
	 * @return the new WFMS_action_names
	 */
	@Override
	public WFMS_action_names create(String actionId) {
		WFMS_action_names wfms_action_names = new WFMS_action_namesImpl();

		wfms_action_names.setNew(true);
		wfms_action_names.setPrimaryKey(actionId);

		return wfms_action_names;
	}

	/**
	 * Removes the WFMS_action_names with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the WFMS_action_names
	 * @return the WFMS_action_names that was removed
	 * @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	 */
	@Override
	public WFMS_action_names remove(String actionId)
		throws NoSuchWFMS_action_namesException {
		return remove((Serializable)actionId);
	}

	/**
	 * Removes the WFMS_action_names with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_action_names
	 * @return the WFMS_action_names that was removed
	 * @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	 */
	@Override
	public WFMS_action_names remove(Serializable primaryKey)
		throws NoSuchWFMS_action_namesException {
		Session session = null;

		try {
			session = openSession();

			WFMS_action_names wfms_action_names = (WFMS_action_names)session.get(WFMS_action_namesImpl.class,
					primaryKey);

			if (wfms_action_names == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_action_namesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_action_names);
		}
		catch (NoSuchWFMS_action_namesException nsee) {
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
	protected WFMS_action_names removeImpl(WFMS_action_names wfms_action_names) {
		wfms_action_names = toUnwrappedModel(wfms_action_names);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_action_names)) {
				wfms_action_names = (WFMS_action_names)session.get(WFMS_action_namesImpl.class,
						wfms_action_names.getPrimaryKeyObj());
			}

			if (wfms_action_names != null) {
				session.delete(wfms_action_names);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_action_names != null) {
			clearCache(wfms_action_names);
		}

		return wfms_action_names;
	}

	@Override
	public WFMS_action_names updateImpl(WFMS_action_names wfms_action_names) {
		wfms_action_names = toUnwrappedModel(wfms_action_names);

		boolean isNew = wfms_action_names.isNew();

		WFMS_action_namesModelImpl wfms_action_namesModelImpl = (WFMS_action_namesModelImpl)wfms_action_names;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wfms_action_names.getCreateDate() == null)) {
			if (serviceContext == null) {
				wfms_action_names.setCreateDate(now);
			}
			else {
				wfms_action_names.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!wfms_action_namesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wfms_action_names.setModifiedDate(now);
			}
			else {
				wfms_action_names.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wfms_action_names.isNew()) {
				session.save(wfms_action_names);

				wfms_action_names.setNew(false);
			}
			else {
				wfms_action_names = (WFMS_action_names)session.merge(wfms_action_names);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_action_namesImpl.class, wfms_action_names.getPrimaryKey(),
			wfms_action_names, false);

		wfms_action_names.resetOriginalValues();

		return wfms_action_names;
	}

	protected WFMS_action_names toUnwrappedModel(
		WFMS_action_names wfms_action_names) {
		if (wfms_action_names instanceof WFMS_action_namesImpl) {
			return wfms_action_names;
		}

		WFMS_action_namesImpl wfms_action_namesImpl = new WFMS_action_namesImpl();

		wfms_action_namesImpl.setNew(wfms_action_names.isNew());
		wfms_action_namesImpl.setPrimaryKey(wfms_action_names.getPrimaryKey());

		wfms_action_namesImpl.setActionId(wfms_action_names.getActionId());
		wfms_action_namesImpl.setActionName(wfms_action_names.getActionName());
		wfms_action_namesImpl.setDeleteflag(wfms_action_names.getDeleteflag());
		wfms_action_namesImpl.setCreatedBy(wfms_action_names.getCreatedBy());
		wfms_action_namesImpl.setCreateDate(wfms_action_names.getCreateDate());
		wfms_action_namesImpl.setModifiedBy(wfms_action_names.getModifiedBy());
		wfms_action_namesImpl.setModifiedDate(wfms_action_names.getModifiedDate());

		return wfms_action_namesImpl;
	}

	/**
	 * Returns the WFMS_action_names with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_action_names
	 * @return the WFMS_action_names
	 * @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	 */
	@Override
	public WFMS_action_names findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_action_namesException {
		WFMS_action_names wfms_action_names = fetchByPrimaryKey(primaryKey);

		if (wfms_action_names == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_action_namesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_action_names;
	}

	/**
	 * Returns the WFMS_action_names with the primary key or throws a {@link NoSuchWFMS_action_namesException} if it could not be found.
	 *
	 * @param actionId the primary key of the WFMS_action_names
	 * @return the WFMS_action_names
	 * @throws NoSuchWFMS_action_namesException if a WFMS_action_names with the primary key could not be found
	 */
	@Override
	public WFMS_action_names findByPrimaryKey(String actionId)
		throws NoSuchWFMS_action_namesException {
		return findByPrimaryKey((Serializable)actionId);
	}

	/**
	 * Returns the WFMS_action_names with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_action_names
	 * @return the WFMS_action_names, or <code>null</code> if a WFMS_action_names with the primary key could not be found
	 */
	@Override
	public WFMS_action_names fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_action_namesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_action_names wfms_action_names = (WFMS_action_names)serializable;

		if (wfms_action_names == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_action_names = (WFMS_action_names)session.get(WFMS_action_namesImpl.class,
						primaryKey);

				if (wfms_action_names != null) {
					cacheResult(wfms_action_names);
				}
				else {
					entityCache.putResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_action_namesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_action_namesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_action_names;
	}

	/**
	 * Returns the WFMS_action_names with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the WFMS_action_names
	 * @return the WFMS_action_names, or <code>null</code> if a WFMS_action_names with the primary key could not be found
	 */
	@Override
	public WFMS_action_names fetchByPrimaryKey(String actionId) {
		return fetchByPrimaryKey((Serializable)actionId);
	}

	@Override
	public Map<Serializable, WFMS_action_names> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_action_names> map = new HashMap<Serializable, WFMS_action_names>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_action_names wfms_action_names = fetchByPrimaryKey(primaryKey);

			if (wfms_action_names != null) {
				map.put(primaryKey, wfms_action_names);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_action_namesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_action_names)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_ACTION_NAMES_WHERE_PKS_IN);

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

			for (WFMS_action_names wfms_action_names : (List<WFMS_action_names>)q.list()) {
				map.put(wfms_action_names.getPrimaryKeyObj(), wfms_action_names);

				cacheResult(wfms_action_names);

				uncachedPrimaryKeys.remove(wfms_action_names.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_action_namesModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_action_namesImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_action_nameses.
	 *
	 * @return the WFMS_action_nameses
	 */
	@Override
	public List<WFMS_action_names> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_action_nameses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_action_nameses
	 * @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	 * @return the range of WFMS_action_nameses
	 */
	@Override
	public List<WFMS_action_names> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_action_nameses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_action_nameses
	 * @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_action_nameses
	 */
	@Override
	public List<WFMS_action_names> findAll(int start, int end,
		OrderByComparator<WFMS_action_names> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_action_nameses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_action_nameses
	 * @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_action_nameses
	 */
	@Override
	public List<WFMS_action_names> findAll(int start, int end,
		OrderByComparator<WFMS_action_names> orderByComparator,
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

		List<WFMS_action_names> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_action_names>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_ACTION_NAMES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_ACTION_NAMES;

				if (pagination) {
					sql = sql.concat(WFMS_action_namesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_action_names>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_action_names>)QueryUtil.list(q,
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
	 * Removes all the WFMS_action_nameses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_action_names wfms_action_names : findAll()) {
			remove(wfms_action_names);
		}
	}

	/**
	 * Returns the number of WFMS_action_nameses.
	 *
	 * @return the number of WFMS_action_nameses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_ACTION_NAMES);

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
		return WFMS_action_namesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_action_names persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_action_namesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_ACTION_NAMES = "SELECT wfms_action_names FROM WFMS_action_names wfms_action_names";
	private static final String _SQL_SELECT_WFMS_ACTION_NAMES_WHERE_PKS_IN = "SELECT wfms_action_names FROM WFMS_action_names wfms_action_names WHERE actionId IN (";
	private static final String _SQL_COUNT_WFMS_ACTION_NAMES = "SELECT COUNT(wfms_action_names) FROM WFMS_action_names wfms_action_names";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_action_names.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_action_names exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_action_namesPersistenceImpl.class);
}