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

import com.MappingServices.exception.NoSuchEnquiryException;

import com.MappingServices.model.Enquiry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the enquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.MappingServices.service.persistence.impl.EnquiryPersistenceImpl
 * @see EnquiryUtil
 * @generated
 */
@ProviderType
public interface EnquiryPersistence extends BasePersistence<Enquiry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnquiryUtil} to access the enquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching enquiries
	*/
	public java.util.List<Enquiry> findByUuid(java.lang.String uuid);

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
	public java.util.List<Enquiry> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Enquiry> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator);

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
	public java.util.List<Enquiry> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enquiry
	* @throws NoSuchEnquiryException if a matching enquiry could not be found
	*/
	public Enquiry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator)
		throws NoSuchEnquiryException;

	/**
	* Returns the first enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching enquiry, or <code>null</code> if a matching enquiry could not be found
	*/
	public Enquiry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator);

	/**
	* Returns the last enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enquiry
	* @throws NoSuchEnquiryException if a matching enquiry could not be found
	*/
	public Enquiry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator)
		throws NoSuchEnquiryException;

	/**
	* Returns the last enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching enquiry, or <code>null</code> if a matching enquiry could not be found
	*/
	public Enquiry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator);

	/**
	* Returns the enquiries before and after the current enquiry in the ordered set where uuid = &#63;.
	*
	* @param Eid the primary key of the current enquiry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next enquiry
	* @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	*/
	public Enquiry[] findByUuid_PrevAndNext(long Eid, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator)
		throws NoSuchEnquiryException;

	/**
	* Removes all the enquiries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching enquiries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the enquiry in the entity cache if it is enabled.
	*
	* @param enquiry the enquiry
	*/
	public void cacheResult(Enquiry enquiry);

	/**
	* Caches the enquiries in the entity cache if it is enabled.
	*
	* @param enquiries the enquiries
	*/
	public void cacheResult(java.util.List<Enquiry> enquiries);

	/**
	* Creates a new enquiry with the primary key. Does not add the enquiry to the database.
	*
	* @param Eid the primary key for the new enquiry
	* @return the new enquiry
	*/
	public Enquiry create(long Eid);

	/**
	* Removes the enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Eid the primary key of the enquiry
	* @return the enquiry that was removed
	* @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	*/
	public Enquiry remove(long Eid) throws NoSuchEnquiryException;

	public Enquiry updateImpl(Enquiry enquiry);

	/**
	* Returns the enquiry with the primary key or throws a {@link NoSuchEnquiryException} if it could not be found.
	*
	* @param Eid the primary key of the enquiry
	* @return the enquiry
	* @throws NoSuchEnquiryException if a enquiry with the primary key could not be found
	*/
	public Enquiry findByPrimaryKey(long Eid) throws NoSuchEnquiryException;

	/**
	* Returns the enquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Eid the primary key of the enquiry
	* @return the enquiry, or <code>null</code> if a enquiry with the primary key could not be found
	*/
	public Enquiry fetchByPrimaryKey(long Eid);

	@Override
	public java.util.Map<java.io.Serializable, Enquiry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the enquiries.
	*
	* @return the enquiries
	*/
	public java.util.List<Enquiry> findAll();

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
	public java.util.List<Enquiry> findAll(int start, int end);

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
	public java.util.List<Enquiry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator);

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
	public java.util.List<Enquiry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Enquiry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the enquiries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of enquiries.
	*
	* @return the number of enquiries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}