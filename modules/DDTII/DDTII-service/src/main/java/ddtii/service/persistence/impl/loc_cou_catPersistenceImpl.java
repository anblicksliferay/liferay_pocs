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

package ddtii.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import ddtii.exception.NoSuchloc_cou_catException;

import ddtii.model.impl.loc_cou_catImpl;
import ddtii.model.impl.loc_cou_catModelImpl;

import ddtii.model.loc_cou_cat;

import ddtii.service.persistence.loc_cou_catPersistence;

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
 * The persistence implementation for the loc_cou_cat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_catPersistence
 * @see ddtii.service.persistence.loc_cou_catUtil
 * @generated
 */
@ProviderType
public class loc_cou_catPersistenceImpl extends BasePersistenceImpl<loc_cou_cat>
	implements loc_cou_catPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link loc_cou_catUtil} to access the loc_cou_cat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = loc_cou_catImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
			loc_cou_catModelImpl.FINDER_CACHE_ENABLED, loc_cou_catImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
			loc_cou_catModelImpl.FINDER_CACHE_ENABLED, loc_cou_catImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
			loc_cou_catModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public loc_cou_catPersistenceImpl() {
		setModelClass(loc_cou_cat.class);
	}

	/**
	 * Caches the loc_cou_cat in the entity cache if it is enabled.
	 *
	 * @param loc_cou_cat the loc_cou_cat
	 */
	@Override
	public void cacheResult(loc_cou_cat loc_cou_cat) {
		entityCache.putResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
			loc_cou_catImpl.class, loc_cou_cat.getPrimaryKey(), loc_cou_cat);

		loc_cou_cat.resetOriginalValues();
	}

	/**
	 * Caches the loc_cou_cats in the entity cache if it is enabled.
	 *
	 * @param loc_cou_cats the loc_cou_cats
	 */
	@Override
	public void cacheResult(List<loc_cou_cat> loc_cou_cats) {
		for (loc_cou_cat loc_cou_cat : loc_cou_cats) {
			if (entityCache.getResult(
						loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
						loc_cou_catImpl.class, loc_cou_cat.getPrimaryKey()) == null) {
				cacheResult(loc_cou_cat);
			}
			else {
				loc_cou_cat.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loc_cou_cats.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(loc_cou_catImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loc_cou_cat.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(loc_cou_cat loc_cou_cat) {
		entityCache.removeResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
			loc_cou_catImpl.class, loc_cou_cat.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<loc_cou_cat> loc_cou_cats) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (loc_cou_cat loc_cou_cat : loc_cou_cats) {
			entityCache.removeResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
				loc_cou_catImpl.class, loc_cou_cat.getPrimaryKey());
		}
	}

	/**
	 * Creates a new loc_cou_cat with the primary key. Does not add the loc_cou_cat to the database.
	 *
	 * @param loc_cou_catId the primary key for the new loc_cou_cat
	 * @return the new loc_cou_cat
	 */
	@Override
	public loc_cou_cat create(long loc_cou_catId) {
		loc_cou_cat loc_cou_cat = new loc_cou_catImpl();

		loc_cou_cat.setNew(true);
		loc_cou_cat.setPrimaryKey(loc_cou_catId);

		loc_cou_cat.setCompanyId(companyProvider.getCompanyId());

		return loc_cou_cat;
	}

	/**
	 * Removes the loc_cou_cat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loc_cou_catId the primary key of the loc_cou_cat
	 * @return the loc_cou_cat that was removed
	 * @throws NoSuchloc_cou_catException if a loc_cou_cat with the primary key could not be found
	 */
	@Override
	public loc_cou_cat remove(long loc_cou_catId)
		throws NoSuchloc_cou_catException {
		return remove((Serializable)loc_cou_catId);
	}

	/**
	 * Removes the loc_cou_cat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loc_cou_cat
	 * @return the loc_cou_cat that was removed
	 * @throws NoSuchloc_cou_catException if a loc_cou_cat with the primary key could not be found
	 */
	@Override
	public loc_cou_cat remove(Serializable primaryKey)
		throws NoSuchloc_cou_catException {
		Session session = null;

		try {
			session = openSession();

			loc_cou_cat loc_cou_cat = (loc_cou_cat)session.get(loc_cou_catImpl.class,
					primaryKey);

			if (loc_cou_cat == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchloc_cou_catException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loc_cou_cat);
		}
		catch (NoSuchloc_cou_catException nsee) {
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
	protected loc_cou_cat removeImpl(loc_cou_cat loc_cou_cat) {
		loc_cou_cat = toUnwrappedModel(loc_cou_cat);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loc_cou_cat)) {
				loc_cou_cat = (loc_cou_cat)session.get(loc_cou_catImpl.class,
						loc_cou_cat.getPrimaryKeyObj());
			}

			if (loc_cou_cat != null) {
				session.delete(loc_cou_cat);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loc_cou_cat != null) {
			clearCache(loc_cou_cat);
		}

		return loc_cou_cat;
	}

	@Override
	public loc_cou_cat updateImpl(loc_cou_cat loc_cou_cat) {
		loc_cou_cat = toUnwrappedModel(loc_cou_cat);

		boolean isNew = loc_cou_cat.isNew();

		loc_cou_catModelImpl loc_cou_catModelImpl = (loc_cou_catModelImpl)loc_cou_cat;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (loc_cou_cat.getCreateDate() == null)) {
			if (serviceContext == null) {
				loc_cou_cat.setCreateDate(now);
			}
			else {
				loc_cou_cat.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!loc_cou_catModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				loc_cou_cat.setModifiedDate(now);
			}
			else {
				loc_cou_cat.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (loc_cou_cat.isNew()) {
				session.save(loc_cou_cat);

				loc_cou_cat.setNew(false);
			}
			else {
				loc_cou_cat = (loc_cou_cat)session.merge(loc_cou_cat);
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
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
			loc_cou_catImpl.class, loc_cou_cat.getPrimaryKey(), loc_cou_cat,
			false);

		loc_cou_cat.resetOriginalValues();

		return loc_cou_cat;
	}

	protected loc_cou_cat toUnwrappedModel(loc_cou_cat loc_cou_cat) {
		if (loc_cou_cat instanceof loc_cou_catImpl) {
			return loc_cou_cat;
		}

		loc_cou_catImpl loc_cou_catImpl = new loc_cou_catImpl();

		loc_cou_catImpl.setNew(loc_cou_cat.isNew());
		loc_cou_catImpl.setPrimaryKey(loc_cou_cat.getPrimaryKey());

		loc_cou_catImpl.setLoc_cou_catId(loc_cou_cat.getLoc_cou_catId());
		loc_cou_catImpl.setCategoryId(loc_cou_cat.getCategoryId());
		loc_cou_catImpl.setCourseId(loc_cou_cat.getCourseId());
		loc_cou_catImpl.setLocationId(loc_cou_cat.getLocationId());
		loc_cou_catImpl.setDurationString(loc_cou_cat.getDurationString());
		loc_cou_catImpl.setDurationLong(loc_cou_cat.getDurationLong());
		loc_cou_catImpl.setStartDate_(loc_cou_cat.getStartDate_());
		loc_cou_catImpl.setEndDate_(loc_cou_cat.getEndDate_());
		loc_cou_catImpl.setMaxSeats(loc_cou_cat.getMaxSeats());
		loc_cou_catImpl.setCompanyId(loc_cou_cat.getCompanyId());
		loc_cou_catImpl.setUserId(loc_cou_cat.getUserId());
		loc_cou_catImpl.setUserName(loc_cou_cat.getUserName());
		loc_cou_catImpl.setCreateDate(loc_cou_cat.getCreateDate());
		loc_cou_catImpl.setModifiedDate(loc_cou_cat.getModifiedDate());

		return loc_cou_catImpl;
	}

	/**
	 * Returns the loc_cou_cat with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loc_cou_cat
	 * @return the loc_cou_cat
	 * @throws NoSuchloc_cou_catException if a loc_cou_cat with the primary key could not be found
	 */
	@Override
	public loc_cou_cat findByPrimaryKey(Serializable primaryKey)
		throws NoSuchloc_cou_catException {
		loc_cou_cat loc_cou_cat = fetchByPrimaryKey(primaryKey);

		if (loc_cou_cat == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchloc_cou_catException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loc_cou_cat;
	}

	/**
	 * Returns the loc_cou_cat with the primary key or throws a {@link NoSuchloc_cou_catException} if it could not be found.
	 *
	 * @param loc_cou_catId the primary key of the loc_cou_cat
	 * @return the loc_cou_cat
	 * @throws NoSuchloc_cou_catException if a loc_cou_cat with the primary key could not be found
	 */
	@Override
	public loc_cou_cat findByPrimaryKey(long loc_cou_catId)
		throws NoSuchloc_cou_catException {
		return findByPrimaryKey((Serializable)loc_cou_catId);
	}

	/**
	 * Returns the loc_cou_cat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loc_cou_cat
	 * @return the loc_cou_cat, or <code>null</code> if a loc_cou_cat with the primary key could not be found
	 */
	@Override
	public loc_cou_cat fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
				loc_cou_catImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		loc_cou_cat loc_cou_cat = (loc_cou_cat)serializable;

		if (loc_cou_cat == null) {
			Session session = null;

			try {
				session = openSession();

				loc_cou_cat = (loc_cou_cat)session.get(loc_cou_catImpl.class,
						primaryKey);

				if (loc_cou_cat != null) {
					cacheResult(loc_cou_cat);
				}
				else {
					entityCache.putResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
						loc_cou_catImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
					loc_cou_catImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loc_cou_cat;
	}

	/**
	 * Returns the loc_cou_cat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loc_cou_catId the primary key of the loc_cou_cat
	 * @return the loc_cou_cat, or <code>null</code> if a loc_cou_cat with the primary key could not be found
	 */
	@Override
	public loc_cou_cat fetchByPrimaryKey(long loc_cou_catId) {
		return fetchByPrimaryKey((Serializable)loc_cou_catId);
	}

	@Override
	public Map<Serializable, loc_cou_cat> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, loc_cou_cat> map = new HashMap<Serializable, loc_cou_cat>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			loc_cou_cat loc_cou_cat = fetchByPrimaryKey(primaryKey);

			if (loc_cou_cat != null) {
				map.put(primaryKey, loc_cou_cat);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
					loc_cou_catImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (loc_cou_cat)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOC_COU_CAT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (loc_cou_cat loc_cou_cat : (List<loc_cou_cat>)q.list()) {
				map.put(loc_cou_cat.getPrimaryKeyObj(), loc_cou_cat);

				cacheResult(loc_cou_cat);

				uncachedPrimaryKeys.remove(loc_cou_cat.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(loc_cou_catModelImpl.ENTITY_CACHE_ENABLED,
					loc_cou_catImpl.class, primaryKey, nullModel);
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
	 * Returns all the loc_cou_cats.
	 *
	 * @return the loc_cou_cats
	 */
	@Override
	public List<loc_cou_cat> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loc_cou_cats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loc_cou_cats
	 * @param end the upper bound of the range of loc_cou_cats (not inclusive)
	 * @return the range of loc_cou_cats
	 */
	@Override
	public List<loc_cou_cat> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loc_cou_cats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loc_cou_cats
	 * @param end the upper bound of the range of loc_cou_cats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loc_cou_cats
	 */
	@Override
	public List<loc_cou_cat> findAll(int start, int end,
		OrderByComparator<loc_cou_cat> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loc_cou_cats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loc_cou_cats
	 * @param end the upper bound of the range of loc_cou_cats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loc_cou_cats
	 */
	@Override
	public List<loc_cou_cat> findAll(int start, int end,
		OrderByComparator<loc_cou_cat> orderByComparator,
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

		List<loc_cou_cat> list = null;

		if (retrieveFromCache) {
			list = (List<loc_cou_cat>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOC_COU_CAT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOC_COU_CAT;

				if (pagination) {
					sql = sql.concat(loc_cou_catModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<loc_cou_cat>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<loc_cou_cat>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the loc_cou_cats from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (loc_cou_cat loc_cou_cat : findAll()) {
			remove(loc_cou_cat);
		}
	}

	/**
	 * Returns the number of loc_cou_cats.
	 *
	 * @return the number of loc_cou_cats
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOC_COU_CAT);

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
		return loc_cou_catModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the loc_cou_cat persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(loc_cou_catImpl.class.getName());
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
	private static final String _SQL_SELECT_LOC_COU_CAT = "SELECT loc_cou_cat FROM loc_cou_cat loc_cou_cat";
	private static final String _SQL_SELECT_LOC_COU_CAT_WHERE_PKS_IN = "SELECT loc_cou_cat FROM loc_cou_cat loc_cou_cat WHERE loc_cou_catId IN (";
	private static final String _SQL_COUNT_LOC_COU_CAT = "SELECT COUNT(loc_cou_cat) FROM loc_cou_cat loc_cou_cat";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loc_cou_cat.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No loc_cou_cat exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(loc_cou_catPersistenceImpl.class);
}