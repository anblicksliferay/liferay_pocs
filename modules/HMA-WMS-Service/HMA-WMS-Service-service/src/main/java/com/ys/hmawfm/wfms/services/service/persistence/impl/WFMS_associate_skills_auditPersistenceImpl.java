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
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skills_auditException;
import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skills_auditImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skills_auditModelImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_associate_skills_auditPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the WFMS_associate_skills_audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_auditPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.WFMS_associate_skills_auditUtil
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditPersistenceImpl
	extends BasePersistenceImpl<WFMS_associate_skills_audit>
	implements WFMS_associate_skills_auditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WFMS_associate_skills_auditUtil} to access the WFMS_associate_skills_audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WFMS_associate_skills_auditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skills_auditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_associate_skills_auditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skills_auditModelImpl.FINDER_CACHE_ENABLED,
			WFMS_associate_skills_auditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skills_auditModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public WFMS_associate_skills_auditPersistenceImpl() {
		setModelClass(WFMS_associate_skills_audit.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("change", "change_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the WFMS_associate_skills_audit in the entity cache if it is enabled.
	 *
	 * @param wfms_associate_skills_audit the WFMS_associate_skills_audit
	 */
	@Override
	public void cacheResult(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		entityCache.putResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skills_auditImpl.class,
			wfms_associate_skills_audit.getPrimaryKey(),
			wfms_associate_skills_audit);

		wfms_associate_skills_audit.resetOriginalValues();
	}

	/**
	 * Caches the WFMS_associate_skills_audits in the entity cache if it is enabled.
	 *
	 * @param wfms_associate_skills_audits the WFMS_associate_skills_audits
	 */
	@Override
	public void cacheResult(
		List<WFMS_associate_skills_audit> wfms_associate_skills_audits) {
		for (WFMS_associate_skills_audit wfms_associate_skills_audit : wfms_associate_skills_audits) {
			if (entityCache.getResult(
						WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_associate_skills_auditImpl.class,
						wfms_associate_skills_audit.getPrimaryKey()) == null) {
				cacheResult(wfms_associate_skills_audit);
			}
			else {
				wfms_associate_skills_audit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WFMS_associate_skills_audits.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WFMS_associate_skills_auditImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WFMS_associate_skills_audit.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		entityCache.removeResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skills_auditImpl.class,
			wfms_associate_skills_audit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<WFMS_associate_skills_audit> wfms_associate_skills_audits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WFMS_associate_skills_audit wfms_associate_skills_audit : wfms_associate_skills_audits) {
			entityCache.removeResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_associate_skills_auditImpl.class,
				wfms_associate_skills_audit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WFMS_associate_skills_audit with the primary key. Does not add the WFMS_associate_skills_audit to the database.
	 *
	 * @param associate_log_id the primary key for the new WFMS_associate_skills_audit
	 * @return the new WFMS_associate_skills_audit
	 */
	@Override
	public WFMS_associate_skills_audit create(long associate_log_id) {
		WFMS_associate_skills_audit wfms_associate_skills_audit = new WFMS_associate_skills_auditImpl();

		wfms_associate_skills_audit.setNew(true);
		wfms_associate_skills_audit.setPrimaryKey(associate_log_id);

		return wfms_associate_skills_audit;
	}

	/**
	 * Removes the WFMS_associate_skills_audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param associate_log_id the primary key of the WFMS_associate_skills_audit
	 * @return the WFMS_associate_skills_audit that was removed
	 * @throws NoSuchWFMS_associate_skills_auditException if a WFMS_associate_skills_audit with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills_audit remove(long associate_log_id)
		throws NoSuchWFMS_associate_skills_auditException {
		return remove((Serializable)associate_log_id);
	}

	/**
	 * Removes the WFMS_associate_skills_audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WFMS_associate_skills_audit
	 * @return the WFMS_associate_skills_audit that was removed
	 * @throws NoSuchWFMS_associate_skills_auditException if a WFMS_associate_skills_audit with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills_audit remove(Serializable primaryKey)
		throws NoSuchWFMS_associate_skills_auditException {
		Session session = null;

		try {
			session = openSession();

			WFMS_associate_skills_audit wfms_associate_skills_audit = (WFMS_associate_skills_audit)session.get(WFMS_associate_skills_auditImpl.class,
					primaryKey);

			if (wfms_associate_skills_audit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWFMS_associate_skills_auditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wfms_associate_skills_audit);
		}
		catch (NoSuchWFMS_associate_skills_auditException nsee) {
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
	protected WFMS_associate_skills_audit removeImpl(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		wfms_associate_skills_audit = toUnwrappedModel(wfms_associate_skills_audit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wfms_associate_skills_audit)) {
				wfms_associate_skills_audit = (WFMS_associate_skills_audit)session.get(WFMS_associate_skills_auditImpl.class,
						wfms_associate_skills_audit.getPrimaryKeyObj());
			}

			if (wfms_associate_skills_audit != null) {
				session.delete(wfms_associate_skills_audit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wfms_associate_skills_audit != null) {
			clearCache(wfms_associate_skills_audit);
		}

		return wfms_associate_skills_audit;
	}

	@Override
	public WFMS_associate_skills_audit updateImpl(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		wfms_associate_skills_audit = toUnwrappedModel(wfms_associate_skills_audit);

		boolean isNew = wfms_associate_skills_audit.isNew();

		Session session = null;

		try {
			session = openSession();

			if (wfms_associate_skills_audit.isNew()) {
				session.save(wfms_associate_skills_audit);

				wfms_associate_skills_audit.setNew(false);
			}
			else {
				wfms_associate_skills_audit = (WFMS_associate_skills_audit)session.merge(wfms_associate_skills_audit);
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

		entityCache.putResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
			WFMS_associate_skills_auditImpl.class,
			wfms_associate_skills_audit.getPrimaryKey(),
			wfms_associate_skills_audit, false);

		wfms_associate_skills_audit.resetOriginalValues();

		return wfms_associate_skills_audit;
	}

	protected WFMS_associate_skills_audit toUnwrappedModel(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		if (wfms_associate_skills_audit instanceof WFMS_associate_skills_auditImpl) {
			return wfms_associate_skills_audit;
		}

		WFMS_associate_skills_auditImpl wfms_associate_skills_auditImpl = new WFMS_associate_skills_auditImpl();

		wfms_associate_skills_auditImpl.setNew(wfms_associate_skills_audit.isNew());
		wfms_associate_skills_auditImpl.setPrimaryKey(wfms_associate_skills_audit.getPrimaryKey());

		wfms_associate_skills_auditImpl.setAssociate_log_id(wfms_associate_skills_audit.getAssociate_log_id());
		wfms_associate_skills_auditImpl.setAssociate_number(wfms_associate_skills_audit.getAssociate_number());
		wfms_associate_skills_auditImpl.setUserId(wfms_associate_skills_audit.getUserId());
		wfms_associate_skills_auditImpl.setCreatedBy(wfms_associate_skills_audit.getCreatedBy());
		wfms_associate_skills_auditImpl.setCreateDate(wfms_associate_skills_audit.getCreateDate());
		wfms_associate_skills_auditImpl.setChange(wfms_associate_skills_audit.getChange());

		return wfms_associate_skills_auditImpl;
	}

	/**
	 * Returns the WFMS_associate_skills_audit with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_associate_skills_audit
	 * @return the WFMS_associate_skills_audit
	 * @throws NoSuchWFMS_associate_skills_auditException if a WFMS_associate_skills_audit with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills_audit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWFMS_associate_skills_auditException {
		WFMS_associate_skills_audit wfms_associate_skills_audit = fetchByPrimaryKey(primaryKey);

		if (wfms_associate_skills_audit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWFMS_associate_skills_auditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wfms_associate_skills_audit;
	}

	/**
	 * Returns the WFMS_associate_skills_audit with the primary key or throws a {@link NoSuchWFMS_associate_skills_auditException} if it could not be found.
	 *
	 * @param associate_log_id the primary key of the WFMS_associate_skills_audit
	 * @return the WFMS_associate_skills_audit
	 * @throws NoSuchWFMS_associate_skills_auditException if a WFMS_associate_skills_audit with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills_audit findByPrimaryKey(long associate_log_id)
		throws NoSuchWFMS_associate_skills_auditException {
		return findByPrimaryKey((Serializable)associate_log_id);
	}

	/**
	 * Returns the WFMS_associate_skills_audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WFMS_associate_skills_audit
	 * @return the WFMS_associate_skills_audit, or <code>null</code> if a WFMS_associate_skills_audit with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills_audit fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
				WFMS_associate_skills_auditImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WFMS_associate_skills_audit wfms_associate_skills_audit = (WFMS_associate_skills_audit)serializable;

		if (wfms_associate_skills_audit == null) {
			Session session = null;

			try {
				session = openSession();

				wfms_associate_skills_audit = (WFMS_associate_skills_audit)session.get(WFMS_associate_skills_auditImpl.class,
						primaryKey);

				if (wfms_associate_skills_audit != null) {
					cacheResult(wfms_associate_skills_audit);
				}
				else {
					entityCache.putResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
						WFMS_associate_skills_auditImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_associate_skills_auditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wfms_associate_skills_audit;
	}

	/**
	 * Returns the WFMS_associate_skills_audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param associate_log_id the primary key of the WFMS_associate_skills_audit
	 * @return the WFMS_associate_skills_audit, or <code>null</code> if a WFMS_associate_skills_audit with the primary key could not be found
	 */
	@Override
	public WFMS_associate_skills_audit fetchByPrimaryKey(long associate_log_id) {
		return fetchByPrimaryKey((Serializable)associate_log_id);
	}

	@Override
	public Map<Serializable, WFMS_associate_skills_audit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WFMS_associate_skills_audit> map = new HashMap<Serializable, WFMS_associate_skills_audit>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WFMS_associate_skills_audit wfms_associate_skills_audit = fetchByPrimaryKey(primaryKey);

			if (wfms_associate_skills_audit != null) {
				map.put(primaryKey, wfms_associate_skills_audit);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_associate_skills_auditImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(WFMS_associate_skills_audit)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WFMS_ASSOCIATE_SKILLS_AUDIT_WHERE_PKS_IN);

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

			for (WFMS_associate_skills_audit wfms_associate_skills_audit : (List<WFMS_associate_skills_audit>)q.list()) {
				map.put(wfms_associate_skills_audit.getPrimaryKeyObj(),
					wfms_associate_skills_audit);

				cacheResult(wfms_associate_skills_audit);

				uncachedPrimaryKeys.remove(wfms_associate_skills_audit.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WFMS_associate_skills_auditModelImpl.ENTITY_CACHE_ENABLED,
					WFMS_associate_skills_auditImpl.class, primaryKey, nullModel);
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
	 * Returns all the WFMS_associate_skills_audits.
	 *
	 * @return the WFMS_associate_skills_audits
	 */
	@Override
	public List<WFMS_associate_skills_audit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WFMS_associate_skills_audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_associate_skills_audits
	 * @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	 * @return the range of WFMS_associate_skills_audits
	 */
	@Override
	public List<WFMS_associate_skills_audit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WFMS_associate_skills_audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_associate_skills_audits
	 * @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WFMS_associate_skills_audits
	 */
	@Override
	public List<WFMS_associate_skills_audit> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills_audit> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the WFMS_associate_skills_audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WFMS_associate_skills_audits
	 * @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of WFMS_associate_skills_audits
	 */
	@Override
	public List<WFMS_associate_skills_audit> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills_audit> orderByComparator,
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

		List<WFMS_associate_skills_audit> list = null;

		if (retrieveFromCache) {
			list = (List<WFMS_associate_skills_audit>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WFMS_ASSOCIATE_SKILLS_AUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WFMS_ASSOCIATE_SKILLS_AUDIT;

				if (pagination) {
					sql = sql.concat(WFMS_associate_skills_auditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WFMS_associate_skills_audit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WFMS_associate_skills_audit>)QueryUtil.list(q,
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
	 * Removes all the WFMS_associate_skills_audits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WFMS_associate_skills_audit wfms_associate_skills_audit : findAll()) {
			remove(wfms_associate_skills_audit);
		}
	}

	/**
	 * Returns the number of WFMS_associate_skills_audits.
	 *
	 * @return the number of WFMS_associate_skills_audits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WFMS_ASSOCIATE_SKILLS_AUDIT);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WFMS_associate_skills_auditModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the WFMS_associate_skills_audit persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WFMS_associate_skills_auditImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WFMS_ASSOCIATE_SKILLS_AUDIT = "SELECT wfms_associate_skills_audit FROM WFMS_associate_skills_audit wfms_associate_skills_audit";
	private static final String _SQL_SELECT_WFMS_ASSOCIATE_SKILLS_AUDIT_WHERE_PKS_IN =
		"SELECT wfms_associate_skills_audit FROM WFMS_associate_skills_audit wfms_associate_skills_audit WHERE associate_log_id IN (";
	private static final String _SQL_COUNT_WFMS_ASSOCIATE_SKILLS_AUDIT = "SELECT COUNT(wfms_associate_skills_audit) FROM WFMS_associate_skills_audit wfms_associate_skills_audit";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wfms_associate_skills_audit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WFMS_associate_skills_audit exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WFMS_associate_skills_auditPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"change"
			});
}