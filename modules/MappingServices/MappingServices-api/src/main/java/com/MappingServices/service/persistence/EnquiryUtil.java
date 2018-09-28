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

package com.MappingServices.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.MappingServices.model.Enquiry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the enquiry service. This utility wraps {@link com.MappingServices.service.persistence.impl.EnquiryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnquiryPersistence
 * @see com.MappingServices.service.persistence.impl.EnquiryPersistenceImpl
 * @generated
 */
@ProviderType
public class EnquiryUtil {
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
	public static void clearCache(Enquiry enquiry) {
		getPersistence().clearCache(enquiry);
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
	public static List<Enquiry> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Enquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Enquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Enquiry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Enquiry update(Enquiry enquiry) {
		return getPersistence().update(enquiry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Enquiry update(Enquiry enquiry, ServiceContext serviceContext) {
		return getPersistence().update(enquiry, serviceContext);
	}

	/**
	* Returns all the enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching enquiries
	*/
	public static List<Enquiry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the enquiries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of enquiries
	* @param end the upper bound of the range of enquiries (not inclusive)
	* @return the range of matching enquiries
	*/
	public static List<Enquiry> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the enquiries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of enquiries
	* @param end the upper bound of the range of enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching enquiries
	*/
	public static List<Enquiry> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Enquiry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the enquiries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of enquiries
	* @param end the upper bound of the range of enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching enquiries
	*/
	public static List<Enquiry> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Enquiry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enquiry
	* @throws NoSuchEnquiryException if a matching enquiry could not be found
	*/
	public static Enquiry findByUuid_First(java.lang.String uuid,
		OrderByComparator<Enquiry> orderByComparator)
		throws com.MappingServices.exception.NoSuchEnquiryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enquiry, or <code>null</code> if a matching enquiry could not be found
	*/
	public static Enquiry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Enquiry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enquiry
	* @throws NoSuchEnquiryException if a matching enquiry could not be found
	*/
	public static Enquiry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Enquiry> orderByComparator)
		throws com.MappingServices.exception.NoSuchEnquiryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enquiry, or <code>null</code> if a matching enquiry could not be found
	*/
	public static Enquiry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Enquiry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the enquiries before and after the current enquiry in the ordered set where uuid = &#63;.
	*
	* @param Eid the primary key of the current enquiry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next enquiry
	* @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	*/
	public static Enquiry[] findByUuid_PrevAndNext(long Eid,
		java.lang.String uuid, OrderByComparator<Enquiry> orderByComparator)
		throws com.MappingServices.exception.NoSuchEnquiryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(Eid, uuid, orderByComparator);
	}

	/**
	* Removes all the enquiries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching enquiries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the enquiry in the entity cache if it is enabled.
	*
	* @param enquiry the enquiry
	*/
	public static void cacheResult(Enquiry enquiry) {
		getPersistence().cacheResult(enquiry);
	}

	/**
	* Caches the enquiries in the entity cache if it is enabled.
	*
	* @param enquiries the enquiries
	*/
	public static void cacheResult(List<Enquiry> enquiries) {
		getPersistence().cacheResult(enquiries);
	}

	/**
	* Creates a new enquiry with the primary key. Does not add the enquiry to the database.
	*
	* @param Eid the primary key for the new enquiry
	* @return the new enquiry
	*/
	public static Enquiry create(long Eid) {
		return getPersistence().create(Eid);
	}

	/**
	* Removes the enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Eid the primary key of the enquiry
	* @return the enquiry that was removed
	* @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	*/
	public static Enquiry remove(long Eid)
		throws com.MappingServices.exception.NoSuchEnquiryException {
		return getPersistence().remove(Eid);
	}

	public static Enquiry updateImpl(Enquiry enquiry) {
		return getPersistence().updateImpl(enquiry);
	}

	/**
	* Returns the enquiry with the primary key or throws a {@link NoSuchEnquiryException} if it could not be found.
	*
	* @param Eid the primary key of the enquiry
	* @return the enquiry
	* @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	*/
	public static Enquiry findByPrimaryKey(long Eid)
		throws com.MappingServices.exception.NoSuchEnquiryException {
		return getPersistence().findByPrimaryKey(Eid);
	}

	/**
	* Returns the enquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Eid the primary key of the enquiry
	* @return the enquiry, or <code>null</code> if a enquiry with the primary key could not be found
	*/
	public static Enquiry fetchByPrimaryKey(long Eid) {
		return getPersistence().fetchByPrimaryKey(Eid);
	}

	public static java.util.Map<java.io.Serializable, Enquiry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the enquiries.
	*
	* @return the enquiries
	*/
	public static List<Enquiry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enquiries
	* @param end the upper bound of the range of enquiries (not inclusive)
	* @return the range of enquiries
	*/
	public static List<Enquiry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enquiries
	* @param end the upper bound of the range of enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enquiries
	*/
	public static List<Enquiry> findAll(int start, int end,
		OrderByComparator<Enquiry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enquiries
	* @param end the upper bound of the range of enquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of enquiries
	*/
	public static List<Enquiry> findAll(int start, int end,
		OrderByComparator<Enquiry> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the enquiries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enquiries.
	*
	* @return the number of enquiries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EnquiryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EnquiryPersistence, EnquiryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(EnquiryPersistence.class);
}