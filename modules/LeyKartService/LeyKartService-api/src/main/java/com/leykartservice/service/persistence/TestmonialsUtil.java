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

package com.leykartservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.leykartservice.model.Testmonials;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the testmonials service. This utility wraps {@link com.leykartservice.service.persistence.impl.TestmonialsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestmonialsPersistence
 * @see com.leykartservice.service.persistence.impl.TestmonialsPersistenceImpl
 * @generated
 */
@ProviderType
public class TestmonialsUtil {
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
	public static void clearCache(Testmonials testmonials) {
		getPersistence().clearCache(testmonials);
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
	public static List<Testmonials> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Testmonials> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Testmonials> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Testmonials update(Testmonials testmonials) {
		return getPersistence().update(testmonials);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Testmonials update(Testmonials testmonials,
		ServiceContext serviceContext) {
		return getPersistence().update(testmonials, serviceContext);
	}

	/**
	* Returns all the testmonialses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching testmonialses
	*/
	public static List<Testmonials> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the testmonialses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @return the range of matching testmonialses
	*/
	public static List<Testmonials> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the testmonialses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testmonialses
	*/
	public static List<Testmonials> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the testmonialses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching testmonialses
	*/
	public static List<Testmonials> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public static Testmonials findByUuid_First(java.lang.String uuid,
		OrderByComparator<Testmonials> orderByComparator)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public static Testmonials fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public static Testmonials findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Testmonials> orderByComparator)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public static Testmonials fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the testmonialses before and after the current testmonials in the ordered set where uuid = &#63;.
	*
	* @param testmonialsId the primary key of the current testmonials
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testmonials
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public static Testmonials[] findByUuid_PrevAndNext(long testmonialsId,
		java.lang.String uuid, OrderByComparator<Testmonials> orderByComparator)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(testmonialsId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the testmonialses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of testmonialses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching testmonialses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching testmonialses
	*/
	public static List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @return the range of matching testmonialses
	*/
	public static List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testmonialses
	*/
	public static List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching testmonialses
	*/
	public static List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public static Testmonials findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Testmonials> orderByComparator)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public static Testmonials fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public static Testmonials findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Testmonials> orderByComparator)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public static Testmonials fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the testmonialses before and after the current testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param testmonialsId the primary key of the current testmonials
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testmonials
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public static Testmonials[] findByUuid_C_PrevAndNext(long testmonialsId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Testmonials> orderByComparator)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(testmonialsId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the testmonialses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching testmonialses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the testmonials in the entity cache if it is enabled.
	*
	* @param testmonials the testmonials
	*/
	public static void cacheResult(Testmonials testmonials) {
		getPersistence().cacheResult(testmonials);
	}

	/**
	* Caches the testmonialses in the entity cache if it is enabled.
	*
	* @param testmonialses the testmonialses
	*/
	public static void cacheResult(List<Testmonials> testmonialses) {
		getPersistence().cacheResult(testmonialses);
	}

	/**
	* Creates a new testmonials with the primary key. Does not add the testmonials to the database.
	*
	* @param testmonialsId the primary key for the new testmonials
	* @return the new testmonials
	*/
	public static Testmonials create(long testmonialsId) {
		return getPersistence().create(testmonialsId);
	}

	/**
	* Removes the testmonials with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials that was removed
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public static Testmonials remove(long testmonialsId)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence().remove(testmonialsId);
	}

	public static Testmonials updateImpl(Testmonials testmonials) {
		return getPersistence().updateImpl(testmonials);
	}

	/**
	* Returns the testmonials with the primary key or throws a {@link NoSuchTestmonialsException} if it could not be found.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public static Testmonials findByPrimaryKey(long testmonialsId)
		throws com.leykartservice.exception.NoSuchTestmonialsException {
		return getPersistence().findByPrimaryKey(testmonialsId);
	}

	/**
	* Returns the testmonials with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials, or <code>null</code> if a testmonials with the primary key could not be found
	*/
	public static Testmonials fetchByPrimaryKey(long testmonialsId) {
		return getPersistence().fetchByPrimaryKey(testmonialsId);
	}

	public static java.util.Map<java.io.Serializable, Testmonials> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the testmonialses.
	*
	* @return the testmonialses
	*/
	public static List<Testmonials> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the testmonialses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @return the range of testmonialses
	*/
	public static List<Testmonials> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the testmonialses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of testmonialses
	*/
	public static List<Testmonials> findAll(int start, int end,
		OrderByComparator<Testmonials> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the testmonialses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of testmonialses
	*/
	public static List<Testmonials> findAll(int start, int end,
		OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the testmonialses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of testmonialses.
	*
	* @return the number of testmonialses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TestmonialsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TestmonialsPersistence, TestmonialsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TestmonialsPersistence.class);
}