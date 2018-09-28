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

package com.ddt.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.ddt.model.FAQSAshok;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the f a q s ashok service. This utility wraps {@link com.ddt.service.persistence.impl.FAQSAshokPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FAQSAshokPersistence
 * @see com.ddt.service.persistence.impl.FAQSAshokPersistenceImpl
 * @generated
 */
@ProviderType
public class FAQSAshokUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FAQSAshok faqsAshok) {
		getPersistence().clearCache(faqsAshok);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FAQSAshok> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FAQSAshok> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FAQSAshok> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FAQSAshok update(FAQSAshok faqsAshok) {
		return getPersistence().update(faqsAshok);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FAQSAshok update(FAQSAshok faqsAshok,
		ServiceContext serviceContext) {
		return getPersistence().update(faqsAshok, serviceContext);
	}

	/**
	* Returns all the f a q s ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching f a q s ashoks
	*/
	public static List<FAQSAshok> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the f a q s ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @return the range of matching f a q s ashoks
	*/
	public static List<FAQSAshok> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the f a q s ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching f a q s ashoks
	*/
	public static List<FAQSAshok> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<FAQSAshok> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the f a q s ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching f a q s ashoks
	*/
	public static List<FAQSAshok> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<FAQSAshok> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q s ashok
	* @throws NoSuchFAQSAshokException if a matching f a q s ashok could not be found
	*/
	public static FAQSAshok findByUuid_First(java.lang.String uuid,
		OrderByComparator<FAQSAshok> orderByComparator)
		throws com.ddt.exception.NoSuchFAQSAshokException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q s ashok, or <code>null</code> if a matching f a q s ashok could not be found
	*/
	public static FAQSAshok fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<FAQSAshok> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q s ashok
	* @throws NoSuchFAQSAshokException if a matching f a q s ashok could not be found
	*/
	public static FAQSAshok findByUuid_Last(java.lang.String uuid,
		OrderByComparator<FAQSAshok> orderByComparator)
		throws com.ddt.exception.NoSuchFAQSAshokException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q s ashok, or <code>null</code> if a matching f a q s ashok could not be found
	*/
	public static FAQSAshok fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<FAQSAshok> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the f a q s ashoks before and after the current f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current f a q s ashok
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next f a q s ashok
	* @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	*/
	public static FAQSAshok[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid, OrderByComparator<FAQSAshok> orderByComparator)
		throws com.ddt.exception.NoSuchFAQSAshokException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the f a q s ashoks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of f a q s ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching f a q s ashoks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the f a q s ashok in the entity cache if it is enabled.
	*
	* @param faqsAshok the f a q s ashok
	*/
	public static void cacheResult(FAQSAshok faqsAshok) {
		getPersistence().cacheResult(faqsAshok);
	}

	/**
	* Caches the f a q s ashoks in the entity cache if it is enabled.
	*
	* @param faqsAshoks the f a q s ashoks
	*/
	public static void cacheResult(List<FAQSAshok> faqsAshoks) {
		getPersistence().cacheResult(faqsAshoks);
	}

	/**
	* Creates a new f a q s ashok with the primary key. Does not add the f a q s ashok to the database.
	*
	* @param id the primary key for the new f a q s ashok
	* @return the new f a q s ashok
	*/
	public static FAQSAshok create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the f a q s ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok that was removed
	* @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	*/
	public static FAQSAshok remove(long id)
		throws com.ddt.exception.NoSuchFAQSAshokException {
		return getPersistence().remove(id);
	}

	public static FAQSAshok updateImpl(FAQSAshok faqsAshok) {
		return getPersistence().updateImpl(faqsAshok);
	}

	/**
	* Returns the f a q s ashok with the primary key or throws a {@link NoSuchFAQSAshokException} if it could not be found.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok
	* @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	*/
	public static FAQSAshok findByPrimaryKey(long id)
		throws com.ddt.exception.NoSuchFAQSAshokException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the f a q s ashok with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok, or <code>null</code> if a f a q s ashok with the primary key could not be found
	*/
	public static FAQSAshok fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, FAQSAshok> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the f a q s ashoks.
	*
	* @return the f a q s ashoks
	*/
	public static List<FAQSAshok> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @return the range of f a q s ashoks
	*/
	public static List<FAQSAshok> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of f a q s ashoks
	*/
	public static List<FAQSAshok> findAll(int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of f a q s ashoks
	*/
	public static List<FAQSAshok> findAll(int start, int end,
		OrderByComparator<FAQSAshok> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the f a q s ashoks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of f a q s ashoks.
	*
	* @return the number of f a q s ashoks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FAQSAshokPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FAQSAshokPersistence, FAQSAshokPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FAQSAshokPersistence.class);
}