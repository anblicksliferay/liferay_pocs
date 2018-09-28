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

import com.ddt.model.TestimonialAshok;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the testimonial ashok service. This utility wraps {@link com.ddt.service.persistence.impl.TestimonialAshokPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestimonialAshokPersistence
 * @see com.ddt.service.persistence.impl.TestimonialAshokPersistenceImpl
 * @generated
 */
@ProviderType
public class TestimonialAshokUtil {
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
	public static void clearCache(TestimonialAshok testimonialAshok) {
		getPersistence().clearCache(testimonialAshok);
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
	public static List<TestimonialAshok> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TestimonialAshok> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TestimonialAshok> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TestimonialAshok> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TestimonialAshok update(TestimonialAshok testimonialAshok) {
		return getPersistence().update(testimonialAshok);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TestimonialAshok update(TestimonialAshok testimonialAshok,
		ServiceContext serviceContext) {
		return getPersistence().update(testimonialAshok, serviceContext);
	}

	/**
	* Returns all the testimonial ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching testimonial ashoks
	*/
	public static List<TestimonialAshok> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the testimonial ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @return the range of matching testimonial ashoks
	*/
	public static List<TestimonialAshok> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the testimonial ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testimonial ashoks
	*/
	public static List<TestimonialAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<TestimonialAshok> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the testimonial ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching testimonial ashoks
	*/
	public static List<TestimonialAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<TestimonialAshok> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testimonial ashok
	* @throws NoSuchTestimonialAshokException if a matching testimonial ashok could not be found
	*/
	public static TestimonialAshok findByUuid_First(java.lang.String uuid,
		OrderByComparator<TestimonialAshok> orderByComparator)
		throws com.ddt.exception.NoSuchTestimonialAshokException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testimonial ashok, or <code>null</code> if a matching testimonial ashok could not be found
	*/
	public static TestimonialAshok fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<TestimonialAshok> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testimonial ashok
	* @throws NoSuchTestimonialAshokException if a matching testimonial ashok could not be found
	*/
	public static TestimonialAshok findByUuid_Last(java.lang.String uuid,
		OrderByComparator<TestimonialAshok> orderByComparator)
		throws com.ddt.exception.NoSuchTestimonialAshokException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testimonial ashok, or <code>null</code> if a matching testimonial ashok could not be found
	*/
	public static TestimonialAshok fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<TestimonialAshok> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the testimonial ashoks before and after the current testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current testimonial ashok
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testimonial ashok
	* @throws NoSuchTestimonialAshokException if a testimonial ashok with the primary key could not be found
	*/
	public static TestimonialAshok[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid,
		OrderByComparator<TestimonialAshok> orderByComparator)
		throws com.ddt.exception.NoSuchTestimonialAshokException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the testimonial ashoks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of testimonial ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching testimonial ashoks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the testimonial ashok in the entity cache if it is enabled.
	*
	* @param testimonialAshok the testimonial ashok
	*/
	public static void cacheResult(TestimonialAshok testimonialAshok) {
		getPersistence().cacheResult(testimonialAshok);
	}

	/**
	* Caches the testimonial ashoks in the entity cache if it is enabled.
	*
	* @param testimonialAshoks the testimonial ashoks
	*/
	public static void cacheResult(List<TestimonialAshok> testimonialAshoks) {
		getPersistence().cacheResult(testimonialAshoks);
	}

	/**
	* Creates a new testimonial ashok with the primary key. Does not add the testimonial ashok to the database.
	*
	* @param id the primary key for the new testimonial ashok
	* @return the new testimonial ashok
	*/
	public static TestimonialAshok create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the testimonial ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok that was removed
	* @throws NoSuchTestimonialAshokException if a testimonial ashok with the primary key could not be found
	*/
	public static TestimonialAshok remove(long id)
		throws com.ddt.exception.NoSuchTestimonialAshokException {
		return getPersistence().remove(id);
	}

	public static TestimonialAshok updateImpl(TestimonialAshok testimonialAshok) {
		return getPersistence().updateImpl(testimonialAshok);
	}

	/**
	* Returns the testimonial ashok with the primary key or throws a {@link NoSuchTestimonialAshokException} if it could not be found.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok
	* @throws NoSuchTestimonialAshokException if a testimonial ashok with the primary key could not be found
	*/
	public static TestimonialAshok findByPrimaryKey(long id)
		throws com.ddt.exception.NoSuchTestimonialAshokException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the testimonial ashok with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok, or <code>null</code> if a testimonial ashok with the primary key could not be found
	*/
	public static TestimonialAshok fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, TestimonialAshok> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the testimonial ashoks.
	*
	* @return the testimonial ashoks
	*/
	public static List<TestimonialAshok> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @return the range of testimonial ashoks
	*/
	public static List<TestimonialAshok> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of testimonial ashoks
	*/
	public static List<TestimonialAshok> findAll(int start, int end,
		OrderByComparator<TestimonialAshok> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of testimonial ashoks
	*/
	public static List<TestimonialAshok> findAll(int start, int end,
		OrderByComparator<TestimonialAshok> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the testimonial ashoks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of testimonial ashoks.
	*
	* @return the number of testimonial ashoks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TestimonialAshokPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TestimonialAshokPersistence, TestimonialAshokPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TestimonialAshokPersistence.class);
}