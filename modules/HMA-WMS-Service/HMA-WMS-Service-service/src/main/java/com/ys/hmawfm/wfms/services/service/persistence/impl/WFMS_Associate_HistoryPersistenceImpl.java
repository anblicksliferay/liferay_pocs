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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Associate_HistoryException;
import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_Associate_HistoryPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the WFMS_Associate_History service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Associate_HistoryPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_Associate_HistoryUtil
 * @generated
 */
@ProviderType
public class WFMS_Associate_HistoryPersistenceImpl extends BasePersistenceImpl<WFMS_Associate_History>
	implements WFMS_Associate_HistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_Associate_HistoryUtil} to access the WFMS_Associate_History persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_Associate_HistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Associate_HistoryModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Associate_HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Associate_HistoryModelImpl.FINDER_CACHE_ENABLED,
			WFMS_Associate_HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Associate_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WFMS_Associate_HistoryPersistenceImpl() {
		setModelClass(WFMS_Associate_History.class);
	}

	/**
	 * Caches the WFMS_Associate_History in the entity cache if it is enabled.
	 *
	 * @param wfms_Associate_History the WFMS_Associate_History
	 */
	@Override
	public void cacheResult(WFMS_Associate_History wfms_Associate_History) {
		entityCache.putResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Associate_HistoryImpl.class,
			wfms_Associate_History.getPrimaryKey(), wfms_Associate_History);

		wfms_Associate_History.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_Associate_Histories in the entity cache if it is enabled.
	 *
	 * @param wfms_Associate_Histories the WFMS_Associate_Histories
	 */
	@Override
	public void cacheResult(
		List<WFMS_Associate_History> wfms_Associate_Histories) {
		for (WFMS_Associate_History wfms_Associate_History : wfms_Associate_Histories) {
			if (entityCache.getResult(
						WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_Associate_HistoryImpl.class,
						wfms_Associate_History.getPrimaryKey()) == null) {
				cacheResult(wfms_Associate_History);
			}
			else {
				wfms_Associate_History.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_Associate_Histories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_Associate_HistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_Associate_History.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_Associate_History wfms_Associate_History) {
		entityCache.removeResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Associate_HistoryImpl.class,
			wfms_Associate_History.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<WFMS_Associate_History> wfms_Associate_Histories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_Associate_History wfms_Associate_History : wfms_Associate_Histories) {
			entityCache.removeResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_Associate_HistoryImpl.class,
				wfms_Associate_History.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_Associate_History with the primary key. Does not add the WFMS_Associate_History to the database.
	 *
	 * @param assocHistoryId the primary key for the new WFMS_Associate_History
	 * @return the new WFMS_Associate_History
	 */
	@Override
	public WFMS_Associate_History create(int assocHistoryId) {
		WFMS_Associate_History wfms_Associate_History = new WFMS_Associate_HistoryImpl();

		wfms_Associate_History.setNew(true);
		wfms_Associate_History.setPrimaryKey(assocHistoryId);

		return wfms_Associate_History;
	}

	/**
	 * Removes the WFMS_Associate_History with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assocHistoryId the primary key of the WFMS_Associate_History
	 * @return the WFMS_Associate_History that was removed
	 * @throws NoSuchWFMS_Associate_HistoryException if a WFMS_Associate_History with the primary key could not be found
	 */
	@Override
	public WFMS_Associate_History remove(int assocHistoryId)
		throws NoSuchWFMS_Associate_HistoryException {
		return remove((Serializable)assocHistoryId);
	}

	/**
	 * Removes the WFMS_Associate_History with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_Associate_History
	 * @return the WFMS_Associate_History that was removed
	 * @throws NoSuchWFMS_Associate_HistoryException if a WFMS_Associate_History with the primary key could not be found
	 */
	@Override
	public WFMS_Associate_History remove(Serializable primaryKey)
		throws NoSuchWFMS_Associate_HistoryException {
		Session session = null;

		try {
			session = openSession();

			WFMS_Associate_History wfms_Associate_History = (WFMS_Associate_History)session.get(WFMS_Associate_HistoryImpl.class,
					primaryKey);

			if (wfms_Associate_History == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_Associate_HistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_Associate_History);
		}
		catch (NoSuchWFMS_Associate_HistoryException nsee) {
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
	protected WFMS_Associate_History removeImpl(
		WFMS_Associate_History wfms_Associate_History) {
		wfms_Associate_History = toUnwrappedModel(wfms_Associate_History);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_Associate_History)) {
				wfms_Associate_History = (WFMS_Associate_History)session.get(WFMS_Associate_HistoryImpl.class,
						wfms_Associate_History.getPrimaryKeyObj());
			}

			if (wfms_Associate_History != null) {
				session.delete(wfms_Associate_History);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_Associate_History != null) {
			clearCache(wfms_Associate_History);
		}

		return wfms_Associate_History;
	}

	@Override
	public WFMS_Associate_History updateImpl(
		WFMS_Associate_History wfms_Associate_History) {
		wfms_Associate_History = toUnwrappedModel(wfms_Associate_History);

		boolean isNew = wfms_Associate_History.isNew();

		Session session = null;

		try {
			session = openSession();

			if (wfms_Associate_History.isNew()) {
				session.save(wfms_Associate_History);

				wfms_Associate_History.setNew(false);
			}
			else {
				wfms_Associate_History = (WFMS_Associate_History)session.merge(wfms_Associate_History);
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

		entityCache.putResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_Associate_HistoryImpl.class,
			wfms_Associate_History.getPrimaryKey(), wfms_Associate_History,
			false);

		wfms_Associate_History.resetOriginalValues();

		return wfms_Associate_History;
	}

	protected WFMS_Associate_History toUnwrappedModel(
		WFMS_Associate_History wfms_Associate_History) {
		if (wfms_Associate_History instanceof WFMS_Associate_HistoryImpl) {
			return wfms_Associate_History;
		}

		WFMS_Associate_HistoryImpl wfms_Associate_HistoryImpl = new WFMS_Associate_HistoryImpl();

		wfms_Associate_HistoryImpl.setNew(wfms_Associate_History.isNew());
		wfms_Associate_HistoryImpl.setPrimaryKey(wfms_Associate_History.getPrimaryKey());

		wfms_Associate_HistoryImpl.setAssocHistoryId(wfms_Associate_History.getAssocHistoryId());
		wfms_Associate_HistoryImpl.setAssociateId(wfms_Associate_History.getAssociateId());
		wfms_Associate_HistoryImpl.setAssociateName(wfms_Associate_History.getAssociateName());
		wfms_Associate_HistoryImpl.setCurrentPosition(wfms_Associate_History.getCurrentPosition());
		wfms_Associate_HistoryImpl.setHistory(wfms_Associate_History.getHistory());
		wfms_Associate_HistoryImpl.setCreatedBy(wfms_Associate_History.getCreatedBy());
		wfms_Associate_HistoryImpl.setCreateDate(wfms_Associate_History.getCreateDate());

		return wfms_Associate_HistoryImpl;
	}

	/**
	 * Returns the WFMS_Associate_History with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Associate_History
	 * @return the WFMS_Associate_History
	 * @throws NoSuchWFMS_Associate_HistoryException if a WFMS_Associate_History with the primary key could not be found
	 */
	@Override
	public WFMS_Associate_History findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_Associate_HistoryException {
		WFMS_Associate_History wfms_Associate_History = fetchByPrimaryKey(primaryKey);

		if (wfms_Associate_History == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_Associate_HistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_Associate_History;
	}

	/**
	 * Returns the WFMS_Associate_History with the primary key or throws a {@link NoSuchWFMS_Associate_HistoryException} if it could not be found.
	 *
	 * @param assocHistoryId the primary key of the WFMS_Associate_History
	 * @return the WFMS_Associate_History
	 * @throws NoSuchWFMS_Associate_HistoryException if a WFMS_Associate_History with the primary key could not be found
	 */
	@Override
	public WFMS_Associate_History findByPrimaryKey(int assocHistoryId)
		throws NoSuchWFMS_Associate_HistoryException {
		return findByPrimaryKey((Serializable)assocHistoryId);
	}

	/**
	 * Returns the WFMS_Associate_History with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_Associate_History
	 * @return the WFMS_Associate_History, or <code>null</code> if a WFMS_Associate_History with the primary key could not be found
	 */
	@Override
	public WFMS_Associate_History fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_Associate_HistoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_Associate_History wfms_Associate_History = (WFMS_Associate_History)serializable;

		if (wfms_Associate_History == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_Associate_History = (WFMS_Associate_History)session.get(WFMS_Associate_HistoryImpl.class,
						primaryKey);

				if (wfms_Associate_History != null) {
					cacheResult(wfms_Associate_History);
				}
				else {
					entityCache.putResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_Associate_HistoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Associate_HistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_Associate_History;
	}

	/**
	 * Returns the WFMS_Associate_History with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assocHistoryId the primary key of the WFMS_Associate_History
	 * @return the WFMS_Associate_History, or <code>null</code> if a WFMS_Associate_History with the primary key could not be found
	 */
	@Override
	public WFMS_Associate_History fetchByPrimaryKey(int assocHistoryId) {
		return fetchByPrimaryKey((Serializable)assocHistoryId);
	}

	@Override
	public Map<Serializable, WFMS_Associate_History> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_Associate_History> map = new HashMap<Serializable, WFMS_Associate_History>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_Associate_History wfms_Associate_History = fetchByPrimaryKey(primaryKey);

			if (wfms_Associate_History != null) {
				map.put(primaryKey, wfms_Associate_History);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Associate_HistoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_Associate_History)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_ASSOCIATE_HISTORY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (WFMS_Associate_History wfms_Associate_History : (List<WFMS_Associate_History>)q.list()) {
				map.put(wfms_Associate_History.getPrimaryKeyObj(),
					wfms_Associate_History);

				cacheResult(wfms_Associate_History);

				uncachedPrimaryKeys.remove(wfms_Associate_History.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_Associate_HistoryModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_Associate_HistoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_Associate_Histories.
	 *
	 * @return the WFMS_Associate_Histories
	 */
	@Override
	public List<WFMS_Associate_History> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_Associate_Histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Associate_Histories
	 * @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	 * @return the range of WFMS_Associate_Histories
	 */
	@Override
	public List<WFMS_Associate_History> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_Associate_Histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Associate_Histories
	 * @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_Associate_Histories
	 */
	@Override
	public List<WFMS_Associate_History> findAll(int start, int end,
		OrderByComparator<WFMS_Associate_History> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_Associate_Histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_Associate_Histories
	 * @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_Associate_Histories
	 */
	@Override
	public List<WFMS_Associate_History> findAll(int start, int end,
		OrderByComparator<WFMS_Associate_History> orderByComparator,
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

		List<WFMS_Associate_History> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_Associate_History>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_ASSOCIATE_HISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_ASSOCIATE_HISTORY;

				if (pagination) {
					sql = sql.concat(WFMS_Associate_HistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_Associate_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_Associate_History>)QueryUtil.list(q,
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
	 * Removes all the WFMS_Associate_Histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_Associate_History wfms_Associate_History : findAll()) {
			remove(wfms_Associate_History);
		}
	}

	/**
	 * Returns the number of WFMS_Associate_Histories.
	 *
	 * @return the number of WFMS_Associate_Histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_ASSOCIATE_HISTORY);

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
		return WFMS_Associate_HistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_Associate_History persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_Associate_HistoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_ASSOCIATE_HISTORY = "SELECT wfms_Associate_History FROM WFMS_Associate_History wfms_Associate_History";
	private static final String _SQL_SELECT_WFMS_ASSOCIATE_HISTORY_WHERE_PKS_IN = "SELECT wfms_Associate_History FROM WFMS_Associate_History wfms_Associate_History WHERE assocHistoryId IN (";
	private static final String _SQL_COUNT_WFMS_ASSOCIATE_HISTORY = "SELECT COUNT(wfms_Associate_History) FROM WFMS_Associate_History wfms_Associate_History";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_Associate_History.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_Associate_History exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_Associate_HistoryPersistenceImpl.class);
}