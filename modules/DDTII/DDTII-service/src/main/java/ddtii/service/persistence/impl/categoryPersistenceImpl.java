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

import ddtii.exception.NoSuchcategoryException;

import ddtii.model.category;

import ddtii.model.impl.categoryImpl;
import ddtii.model.impl.categoryModelImpl;

import ddtii.service.persistence.categoryPersistence;

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
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see categoryPersistence
 * @see ddtii.service.persistence.categoryUtil
 * @generated
 */
@ProviderType
public class categoryPersistenceImpl extends BasePersistenceImpl<category>
	implements categoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link categoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = categoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(categoryModelImpl.ENTITY_CACHE_ENABLED,
			categoryModelImpl.FINDER_CACHE_ENABLED, categoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(categoryModelImpl.ENTITY_CACHE_ENABLED,
			categoryModelImpl.FINDER_CACHE_ENABLED, categoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(categoryModelImpl.ENTITY_CACHE_ENABLED,
			categoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public categoryPersistenceImpl() {
		setModelClass(category.class);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	@Override
	public void cacheResult(category category) {
		entityCache.putResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
			categoryImpl.class, category.getPrimaryKey(), category);

		category.resetOriginalValues();
	}

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	@Override
	public void cacheResult(List<category> categories) {
		for (category category : categories) {
			if (entityCache.getResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
						categoryImpl.class, category.getPrimaryKey()) == null) {
				cacheResult(category);
			}
			else {
				category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all categories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(categoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(category category) {
		entityCache.removeResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
			categoryImpl.class, category.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<category> categories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (category category : categories) {
			entityCache.removeResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
				categoryImpl.class, category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public category create(long categoryId) {
		category category = new categoryImpl();

		category.setNew(true);
		category.setPrimaryKey(categoryId);

		category.setCompanyId(companyProvider.getCompanyId());

		return category;
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchcategoryException if a category with the primary key could not be found
	 */
	@Override
	public category remove(long categoryId) throws NoSuchcategoryException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchcategoryException if a category with the primary key could not be found
	 */
	@Override
	public category remove(Serializable primaryKey)
		throws NoSuchcategoryException {
		Session session = null;

		try {
			session = openSession();

			category category = (category)session.get(categoryImpl.class,
					primaryKey);

			if (category == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(category);
		}
		catch (NoSuchcategoryException nsee) {
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
	protected category removeImpl(category category) {
		category = toUnwrappedModel(category);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(category)) {
				category = (category)session.get(categoryImpl.class,
						category.getPrimaryKeyObj());
			}

			if (category != null) {
				session.delete(category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (category != null) {
			clearCache(category);
		}

		return category;
	}

	@Override
	public category updateImpl(category category) {
		category = toUnwrappedModel(category);

		boolean isNew = category.isNew();

		categoryModelImpl categoryModelImpl = (categoryModelImpl)category;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (category.getCreateDate() == null)) {
			if (serviceContext == null) {
				category.setCreateDate(now);
			}
			else {
				category.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!categoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				category.setModifiedDate(now);
			}
			else {
				category.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (category.isNew()) {
				session.save(category);

				category.setNew(false);
			}
			else {
				category = (category)session.merge(category);
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

		entityCache.putResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
			categoryImpl.class, category.getPrimaryKey(), category, false);

		category.resetOriginalValues();

		return category;
	}

	protected category toUnwrappedModel(category category) {
		if (category instanceof categoryImpl) {
			return category;
		}

		categoryImpl categoryImpl = new categoryImpl();

		categoryImpl.setNew(category.isNew());
		categoryImpl.setPrimaryKey(category.getPrimaryKey());

		categoryImpl.setCategoryId(category.getCategoryId());
		categoryImpl.setCategoryName(category.getCategoryName());
		categoryImpl.setCourseId(category.getCourseId());
		categoryImpl.setLocationId(category.getLocationId());
		categoryImpl.setCompanyId(category.getCompanyId());
		categoryImpl.setUserId(category.getUserId());
		categoryImpl.setUserName(category.getUserName());
		categoryImpl.setCreateDate(category.getCreateDate());
		categoryImpl.setModifiedDate(category.getModifiedDate());

		return categoryImpl;
	}

	/**
	 * Returns the category with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category
	 * @throws NoSuchcategoryException if a category with the primary key could not be found
	 */
	@Override
	public category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcategoryException {
		category category = fetchByPrimaryKey(primaryKey);

		if (category == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a {@link NoSuchcategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchcategoryException if a category with the primary key could not be found
	 */
	@Override
	public category findByPrimaryKey(long categoryId)
		throws NoSuchcategoryException {
		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	@Override
	public category fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
				categoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		category category = (category)serializable;

		if (category == null) {
			Session session = null;

			try {
				session = openSession();

				category = (category)session.get(categoryImpl.class, primaryKey);

				if (category != null) {
					cacheResult(category);
				}
				else {
					entityCache.putResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
						categoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
					categoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	@Override
	public category fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	@Override
	public Map<Serializable, category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, category> map = new HashMap<Serializable, category>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			category category = fetchByPrimaryKey(primaryKey);

			if (category != null) {
				map.put(primaryKey, category);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
					categoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (category)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CATEGORY_WHERE_PKS_IN);

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

			for (category category : (List<category>)q.list()) {
				map.put(category.getPrimaryKeyObj(), category);

				cacheResult(category);

				uncachedPrimaryKeys.remove(category.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(categoryModelImpl.ENTITY_CACHE_ENABLED,
					categoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	@Override
	public List<category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link categoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	@Override
	public List<category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link categoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	@Override
	public List<category> findAll(int start, int end,
		OrderByComparator<category> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link categoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of categories
	 */
	@Override
	public List<category> findAll(int start, int end,
		OrderByComparator<category> orderByComparator, boolean retrieveFromCache) {
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

		List<category> list = null;

		if (retrieveFromCache) {
			list = (List<category>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORY;

				if (pagination) {
					sql = sql.concat(categoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (category category : findAll()) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORY);

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
		return categoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(categoryImpl.class.getName());
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
	private static final String _SQL_SELECT_CATEGORY = "SELECT category FROM category category";
	private static final String _SQL_SELECT_CATEGORY_WHERE_PKS_IN = "SELECT category FROM category category WHERE categoryId IN (";
	private static final String _SQL_COUNT_CATEGORY = "SELECT COUNT(category) FROM category category";
	private static final String _ORDER_BY_ENTITY_ALIAS = "category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No category exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(categoryPersistenceImpl.class);
}