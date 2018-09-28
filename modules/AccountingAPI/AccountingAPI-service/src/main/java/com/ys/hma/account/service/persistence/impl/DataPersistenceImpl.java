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

package com.ys.hma.account.service.persistence.impl;

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

import com.ys.hma.account.exception.NoSuchDataException;
import com.ys.hma.account.model.Data;
import com.ys.hma.account.model.impl.DataImpl;
import com.ys.hma.account.model.impl.DataModelImpl;
import com.ys.hma.account.service.persistence.DataPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPersistence
 * @see com.ys.hma.account.service.persistence.DataUtil
 * @generated
 */
@ProviderType
public class DataPersistenceImpl extends BasePersistenceImpl<Data>
	implements DataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DataUtil} to access the data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataModelImpl.FINDER_CACHE_ENABLED, DataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataModelImpl.FINDER_CACHE_ENABLED, DataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DataPersistenceImpl() {
		setModelClass(Data.class);
	}

	/**
	 * Caches the data in the entity cache if it is enabled.
	 *
	 * @param data the data
	 */
	@Override
	public void cacheResult(Data data) {
		entityCache.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataImpl.class, data.getPrimaryKey(), data);

		data.resetOriginalValues();
	}

	/**
	 * Caches the datas in the entity cache if it is enabled.
	 *
	 * @param datas the datas
	 */
	@Override
	public void cacheResult(List<Data> datas) {
		for (Data data : datas) {
			if (entityCache.getResult(DataModelImpl.ENTITY_CACHE_ENABLED,
						DataImpl.class, data.getPrimaryKey()) == null) {
				cacheResult(data);
			}
			else {
				data.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all datas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Data data) {
		entityCache.removeResult(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataImpl.class, data.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Data> datas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Data data : datas) {
			entityCache.removeResult(DataModelImpl.ENTITY_CACHE_ENABLED,
				DataImpl.class, data.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data with the primary key. Does not add the data to the database.
	 *
	 * @param DataId the primary key for the new data
	 * @return the new data
	 */
	@Override
	public Data create(long DataId) {
		Data data = new DataImpl();

		data.setNew(true);
		data.setPrimaryKey(DataId);

		return data;
	}

	/**
	 * Removes the data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param DataId the primary key of the data
	 * @return the data that was removed
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	@Override
	public Data remove(long DataId) throws NoSuchDataException {
		return remove((Serializable)DataId);
	}

	/**
	 * Removes the data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data
	 * @return the data that was removed
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	@Override
	public Data remove(Serializable primaryKey) throws NoSuchDataException {
		Session session = null;

		try {
			session = openSession();

			Data data = (Data)session.get(DataImpl.class, primaryKey);

			if (data == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(data);
		}
		catch (NoSuchDataException nsee) {
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
	protected Data removeImpl(Data data) {
		data = toUnwrappedModel(data);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(data)) {
				data = (Data)session.get(DataImpl.class, data.getPrimaryKeyObj());
			}

			if (data != null) {
				session.delete(data);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (data != null) {
			clearCache(data);
		}

		return data;
	}

	@Override
	public Data updateImpl(Data data) {
		data = toUnwrappedModel(data);

		boolean isNew = data.isNew();

		Session session = null;

		try {
			session = openSession();

			if (data.isNew()) {
				session.save(data);

				data.setNew(false);
			}
			else {
				data = (Data)session.merge(data);
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

		entityCache.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
			DataImpl.class, data.getPrimaryKey(), data, false);

		data.resetOriginalValues();

		return data;
	}

	protected Data toUnwrappedModel(Data data) {
		if (data instanceof DataImpl) {
			return data;
		}

		DataImpl dataImpl = new DataImpl();

		dataImpl.setNew(data.isNew());
		dataImpl.setPrimaryKey(data.getPrimaryKey());

		dataImpl.setDataId(data.getDataId());
		dataImpl.setStartDate(data.getStartDate());
		dataImpl.setEndDate(data.getEndDate());
		dataImpl.setExported(data.getExported());
		dataImpl.setNotExported(data.getNotExported());

		return dataImpl;
	}

	/**
	 * Returns the data with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the data
	 * @return the data
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	@Override
	public Data findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataException {
		Data data = fetchByPrimaryKey(primaryKey);

		if (data == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return data;
	}

	/**
	 * Returns the data with the primary key or throws a {@link NoSuchDataException} if it could not be found.
	 *
	 * @param DataId the primary key of the data
	 * @return the data
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	@Override
	public Data findByPrimaryKey(long DataId) throws NoSuchDataException {
		return findByPrimaryKey((Serializable)DataId);
	}

	/**
	 * Returns the data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data
	 * @return the data, or <code>null</code> if a data with the primary key could not be found
	 */
	@Override
	public Data fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DataModelImpl.ENTITY_CACHE_ENABLED,
				DataImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Data data = (Data)serializable;

		if (data == null) {
			Session session = null;

			try {
				session = openSession();

				data = (Data)session.get(DataImpl.class, primaryKey);

				if (data != null) {
					cacheResult(data);
				}
				else {
					entityCache.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
						DataImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DataModelImpl.ENTITY_CACHE_ENABLED,
					DataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return data;
	}

	/**
	 * Returns the data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param DataId the primary key of the data
	 * @return the data, or <code>null</code> if a data with the primary key could not be found
	 */
	@Override
	public Data fetchByPrimaryKey(long DataId) {
		return fetchByPrimaryKey((Serializable)DataId);
	}

	@Override
	public Map<Serializable, Data> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Data> map = new HashMap<Serializable, Data>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Data data = fetchByPrimaryKey(primaryKey);

			if (data != null) {
				map.put(primaryKey, data);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DataModelImpl.ENTITY_CACHE_ENABLED,
					DataImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Data)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DATA_WHERE_PKS_IN);

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

			for (Data data : (List<Data>)q.list()) {
				map.put(data.getPrimaryKeyObj(), data);

				cacheResult(data);

				uncachedPrimaryKeys.remove(data.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DataModelImpl.ENTITY_CACHE_ENABLED,
					DataImpl.class, primaryKey, nullModel);
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
	 * Returns all the datas.
	 *
	 * @return the datas
	 */
	@Override
	public List<Data> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @return the range of datas
	 */
	@Override
	public List<Data> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datas
	 */
	@Override
	public List<Data> findAll(int start, int end,
		OrderByComparator<Data> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of datas
	 */
	@Override
	public List<Data> findAll(int start, int end,
		OrderByComparator<Data> orderByComparator, boolean retrieveFromCache) {
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

		List<Data> list = null;

		if (retrieveFromCache) {
			list = (List<Data>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATA;

				if (pagination) {
					sql = sql.concat(DataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Data>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Data>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Data data : findAll()) {
			remove(data);
		}
	}

	/**
	 * Returns the number of datas.
	 *
	 * @return the number of datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATA);

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
		return DataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DATA = "SELECT data FROM Data data";
	private static final String _SQL_SELECT_DATA_WHERE_PKS_IN = "SELECT data FROM Data data WHERE DataId IN (";
	private static final String _SQL_COUNT_DATA = "SELECT COUNT(data) FROM Data data";
	private static final String _ORDER_BY_ENTITY_ALIAS = "data.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Data exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(DataPersistenceImpl.class);
}