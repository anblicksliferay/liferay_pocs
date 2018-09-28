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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skillsException;
import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_associate_skillsPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the WFMS_associate_skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skillsPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_associate_skillsUtil
 * @generated
 */
@ProviderType
public class WFMS_associate_skillsPersistenceImpl extends BasePersistenceImpl<WFMS_associate_skills>
	implements WFMS_associate_skillsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_associate_skillsUtil} to access the WFMS_associate_skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_associate_skillsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skillsModelImpl.FINDER_CACHE_ENABLED,
			WFMS_associate_skillsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skillsModelImpl.FINDER_CACHE_ENABLED,
			WFMS_associate_skillsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skillsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WFMS_associate_skillsPersistenceImpl() {
		setModelClass(WFMS_associate_skills.class);
	}

	/**
	 * Caches the WFMS_associate_skills in the entity cache if it is enabled.
	 *
	 * @param wfms_associate_skills the WFMS_associate_skills
	 */
	@Override
	public void cacheResult(WFMS_associate_skills wfms_associate_skills) {
		entityCache.putResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skillsImpl.class,
			wfms_associate_skills.getPrimaryKey(), wfms_associate_skills);

		wfms_associate_skills.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_associate_skillses in the entity cache if it is enabled.
	 *
	 * @param wfms_associate_skillses the WFMS_associate_skillses
	 */
	@Override
	public void cacheResult(List<WFMS_associate_skills> wfms_associate_skillses) {
		for (WFMS_associate_skills wfms_associate_skills : wfms_associate_skillses) {
			if (entityCache.getResult(
						WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_associate_skillsImpl.class,
						wfms_associate_skills.getPrimaryKey()) == null) {
				cacheResult(wfms_associate_skills);
			}
			else {
				wfms_associate_skills.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_associate_skillses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_associate_skillsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_associate_skills.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WFMS_associate_skills wfms_associate_skills) {
		entityCache.removeResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skillsImpl.class,
			wfms_associate_skills.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WFMS_associate_skills> wfms_associate_skillses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_associate_skills wfms_associate_skills : wfms_associate_skillses) {
			entityCache.removeResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_associate_skillsImpl.class,
				wfms_associate_skills.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_associate_skills with the primary key. Does not add the WFMS_associate_skills to the database.
	 *
	 * @param associate_number the primary key for the new WFMS_associate_skills
	 * @return the new WFMS_associate_skills
	 */
	@Override
	public WFMS_associate_skills create(String associate_number) {
		WFMS_associate_skills wfms_associate_skills = new WFMS_associate_skillsImpl();

		wfms_associate_skills.setNew(true);
		wfms_associate_skills.setPrimaryKey(associate_number);

		return wfms_associate_skills;
	}

	/**
	 * Removes the WFMS_associate_skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param associate_number the primary key of the WFMS_associate_skills
	 * @return the WFMS_associate_skills that was removed
	 * @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills remove(String associate_number)
		throws NoSuchWFMS_associate_skillsException {
		return remove((Serializable)associate_number);
	}

	/**
	 * Removes the WFMS_associate_skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_associate_skills
	 * @return the WFMS_associate_skills that was removed
	 * @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills remove(Serializable primaryKey)
		throws NoSuchWFMS_associate_skillsException {
		Session session = null;

		try {
			session = openSession();

			WFMS_associate_skills wfms_associate_skills = (WFMS_associate_skills)session.get(WFMS_associate_skillsImpl.class,
					primaryKey);

			if (wfms_associate_skills == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_associate_skillsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_associate_skills);
		}
		catch (NoSuchWFMS_associate_skillsException nsee) {
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
	protected WFMS_associate_skills removeImpl(
		WFMS_associate_skills wfms_associate_skills) {
		wfms_associate_skills = toUnwrappedModel(wfms_associate_skills);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_associate_skills)) {
				wfms_associate_skills = (WFMS_associate_skills)session.get(WFMS_associate_skillsImpl.class,
						wfms_associate_skills.getPrimaryKeyObj());
			}

			if (wfms_associate_skills != null) {
				session.delete(wfms_associate_skills);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_associate_skills != null) {
			clearCache(wfms_associate_skills);
		}

		return wfms_associate_skills;
	}

	@Override
	public WFMS_associate_skills updateImpl(
		WFMS_associate_skills wfms_associate_skills) {
		wfms_associate_skills = toUnwrappedModel(wfms_associate_skills);

		boolean isNew = wfms_associate_skills.isNew();

		Session session = null;

		try {
			session = openSession();

			if (wfms_associate_skills.isNew()) {
				session.save(wfms_associate_skills);

				wfms_associate_skills.setNew(false);
			}
			else {
				wfms_associate_skills = (WFMS_associate_skills)session.merge(wfms_associate_skills);
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

		entityCache.putResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skillsImpl.class,
			wfms_associate_skills.getPrimaryKey(), wfms_associate_skills, false);

		wfms_associate_skills.resetOriginalValues();

		return wfms_associate_skills;
	}

	protected WFMS_associate_skills toUnwrappedModel(
		WFMS_associate_skills wfms_associate_skills) {
		if (wfms_associate_skills instanceof WFMS_associate_skillsImpl) {
			return wfms_associate_skills;
		}

		WFMS_associate_skillsImpl wfms_associate_skillsImpl = new WFMS_associate_skillsImpl();

		wfms_associate_skillsImpl.setNew(wfms_associate_skills.isNew());
		wfms_associate_skillsImpl.setPrimaryKey(wfms_associate_skills.getPrimaryKey());

		wfms_associate_skillsImpl.setAssociate_number(wfms_associate_skills.getAssociate_number());
		wfms_associate_skillsImpl.setSkills(wfms_associate_skills.getSkills());

		return wfms_associate_skillsImpl;
	}

	/**
	 * Returns the WFMS_associate_skills with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_associate_skills
	 * @return the WFMS_associate_skills
	 * @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_associate_skillsException {
		WFMS_associate_skills wfms_associate_skills = fetchByPrimaryKey(primaryKey);

		if (wfms_associate_skills == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_associate_skillsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_associate_skills;
	}

	/**
	 * Returns the WFMS_associate_skills with the primary key or throws a {@link NoSuchWFMS_associate_skillsException} if it could not be found.
	 *
	 * @param associate_number the primary key of the WFMS_associate_skills
	 * @return the WFMS_associate_skills
	 * @throws NoSuchWFMS_associate_skillsException if a WFMS_associate_skills with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills findByPrimaryKey(String associate_number)
		throws NoSuchWFMS_associate_skillsException {
		return findByPrimaryKey((Serializable)associate_number);
	}

	/**
	 * Returns the WFMS_associate_skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_associate_skills
	 * @return the WFMS_associate_skills, or <code>null</code> if a WFMS_associate_skills with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_associate_skillsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_associate_skills wfms_associate_skills = (WFMS_associate_skills)serializable;

		if (wfms_associate_skills == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_associate_skills = (WFMS_associate_skills)session.get(WFMS_associate_skillsImpl.class,
						primaryKey);

				if (wfms_associate_skills != null) {
					cacheResult(wfms_associate_skills);
				}
				else {
					entityCache.putResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_associate_skillsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_associate_skillsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_associate_skills;
	}

	/**
	 * Returns the WFMS_associate_skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param associate_number the primary key of the WFMS_associate_skills
	 * @return the WFMS_associate_skills, or <code>null</code> if a WFMS_associate_skills with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills fetchByPrimaryKey(String associate_number) {
		return fetchByPrimaryKey((Serializable)associate_number);
	}

	@Override
	public Map<Serializable, WFMS_associate_skills> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_associate_skills> map = new HashMap<Serializable, WFMS_associate_skills>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_associate_skills wfms_associate_skills = fetchByPrimaryKey(primaryKey);

			if (wfms_associate_skills != null) {
				map.put(primaryKey, wfms_associate_skills);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_associate_skillsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WFMS_associate_skills)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_ASSOCIATE_SKILLS_WHERE_PKS_IN);

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

			for (WFMS_associate_skills wfms_associate_skills : (List<WFMS_associate_skills>)q.list()) {
				map.put(wfms_associate_skills.getPrimaryKeyObj(),
					wfms_associate_skills);

				cacheResult(wfms_associate_skills);

				uncachedPrimaryKeys.remove(wfms_associate_skills.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_associate_skillsModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_associate_skillsImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_associate_skillses.
	 *
	 * @return the WFMS_associate_skillses
	 */
	@Override
	public List<WFMS_associate_skills> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_associate_skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_associate_skillses
	 * @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	 * @return the range of WFMS_associate_skillses
	 */
	@Override
	public List<WFMS_associate_skills> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_associate_skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_associate_skillses
	 * @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_associate_skillses
	 */
	@Override
	public List<WFMS_associate_skills> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_associate_skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skillsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_associate_skillses
	 * @param end the upper bound of the range of WFMS_associate_skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_associate_skillses
	 */
	@Override
	public List<WFMS_associate_skills> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills> orderByComparator,
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

		List<WFMS_associate_skills> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_associate_skills>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_ASSOCIATE_SKILLS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_ASSOCIATE_SKILLS;

				if (pagination) {
					sql = sql.concat(WFMS_associate_skillsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_associate_skills>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_associate_skills>)QueryUtil.list(q,
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
	 * Removes all the WFMS_associate_skillses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_associate_skills wfms_associate_skills : findAll()) {
			remove(wfms_associate_skills);
		}
	}

	/**
	 * Returns the number of WFMS_associate_skillses.
	 *
	 * @return the number of WFMS_associate_skillses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_ASSOCIATE_SKILLS);

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
		return WFMS_associate_skillsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_associate_skills persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_associate_skillsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_ASSOCIATE_SKILLS = "SELECT wfms_associate_skills FROM WFMS_associate_skills wfms_associate_skills";
	private static final String _SQL_SELECT_WFMS_ASSOCIATE_SKILLS_WHERE_PKS_IN = "SELECT wfms_associate_skills FROM WFMS_associate_skills wfms_associate_skills WHERE associate_number IN (";
	private static final String _SQL_COUNT_WFMS_ASSOCIATE_SKILLS = "SELECT COUNT(wfms_associate_skills) FROM WFMS_associate_skills wfms_associate_skills";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_associate_skills.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_associate_skills exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_associate_skillsPersistenceImpl.class);
}