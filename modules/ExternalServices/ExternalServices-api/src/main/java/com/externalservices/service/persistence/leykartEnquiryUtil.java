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

package com.externalservices.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.externalservices.model.leykartEnquiry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leykart enquiry service. This utility wraps {@link com.externalservices.service.persistence.impl.leykartEnquiryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leykartEnquiryPersistence
 * @see com.externalservices.service.persistence.impl.leykartEnquiryPersistenceImpl
 * @generated
 */
@ProviderType
public class leykartEnquiryUtil {
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
	public static void clearCache(leykartEnquiry leykartEnquiry) {
		getPersistence().clearCache(leykartEnquiry);
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
	public static List<leykartEnquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<leykartEnquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<leykartEnquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static leykartEnquiry update(leykartEnquiry leykartEnquiry) {
		return getPersistence().update(leykartEnquiry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static leykartEnquiry update(leykartEnquiry leykartEnquiry,
		ServiceContext serviceContext) {
		return getPersistence().update(leykartEnquiry, serviceContext);
	}

	/**
	* Returns all the leykart enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the leykart enquiries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @return the range of matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the leykart enquiries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leykart enquiries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry findByUuid_First(java.lang.String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the leykart enquiries before and after the current leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param Eid the primary key of the current leykart enquiry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leykart enquiry
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public static leykartEnquiry[] findByUuid_PrevAndNext(long Eid,
		java.lang.String uuid,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(Eid, uuid, orderByComparator);
	}

	/**
	* Removes all the leykart enquiries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of leykart enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching leykart enquiries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @return the range of matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching leykart enquiries
	*/
	public static List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<leykartEnquiry> orderByComparator)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<leykartEnquiry> orderByComparator)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public static leykartEnquiry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the leykart enquiries before and after the current leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param Eid the primary key of the current leykart enquiry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leykart enquiry
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public static leykartEnquiry[] findByUuid_C_PrevAndNext(long Eid,
		java.lang.String uuid, long companyId,
		OrderByComparator<leykartEnquiry> orderByComparator)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(Eid, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the leykart enquiries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching leykart enquiries
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the leykart enquiry in the entity cache if it is enabled.
	*
	* @param leykartEnquiry the leykart enquiry
	*/
	public static void cacheResult(leykartEnquiry leykartEnquiry) {
		getPersistence().cacheResult(leykartEnquiry);
	}

	/**
	* Caches the leykart enquiries in the entity cache if it is enabled.
	*
	* @param leykartEnquiries the leykart enquiries
	*/
	public static void cacheResult(List<leykartEnquiry> leykartEnquiries) {
		getPersistence().cacheResult(leykartEnquiries);
	}

	/**
	* Creates a new leykart enquiry with the primary key. Does not add the leykart enquiry to the database.
	*
	* @param Eid the primary key for the new leykart enquiry
	* @return the new leykart enquiry
	*/
	public static leykartEnquiry create(long Eid) {
		return getPersistence().create(Eid);
	}

	/**
	* Removes the leykart enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry that was removed
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public static leykartEnquiry remove(long Eid)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence().remove(Eid);
	}

	public static leykartEnquiry updateImpl(leykartEnquiry leykartEnquiry) {
		return getPersistence().updateImpl(leykartEnquiry);
	}

	/**
	* Returns the leykart enquiry with the primary key or throws a {@link NoSuchleykartEnquiryException} if it could not be found.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public static leykartEnquiry findByPrimaryKey(long Eid)
		throws com.externalservices.exception.NoSuchleykartEnquiryException {
		return getPersistence().findByPrimaryKey(Eid);
	}

	/**
	* Returns the leykart enquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry, or <code>null</code> if a leykart enquiry with the primary key could not be found
	*/
	public static leykartEnquiry fetchByPrimaryKey(long Eid) {
		return getPersistence().fetchByPrimaryKey(Eid);
	}

	public static java.util.Map<java.io.Serializable, leykartEnquiry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leykart enquiries.
	*
	* @return the leykart enquiries
	*/
	public static List<leykartEnquiry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leykart enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @return the range of leykart enquiries
	*/
	public static List<leykartEnquiry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leykart enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leykart enquiries
	*/
	public static List<leykartEnquiry> findAll(int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leykart enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leykart enquiries
	*/
	public static List<leykartEnquiry> findAll(int start, int end,
		OrderByComparator<leykartEnquiry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leykart enquiries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leykart enquiries.
	*
	* @return the number of leykart enquiries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static leykartEnquiryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<leykartEnquiryPersistence, leykartEnquiryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(leykartEnquiryPersistence.class);
}