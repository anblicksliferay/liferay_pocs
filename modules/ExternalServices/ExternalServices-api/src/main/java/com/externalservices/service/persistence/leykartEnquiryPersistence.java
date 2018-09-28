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

import com.externalservices.exception.NoSuchleykartEnquiryException;

import com.externalservices.model.leykartEnquiry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the leykart enquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.externalservices.service.persistence.impl.leykartEnquiryPersistenceImpl
 * @see leykartEnquiryUtil
 * @generated
 */
@ProviderType
public interface leykartEnquiryPersistence extends BasePersistence<leykartEnquiry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link leykartEnquiryUtil} to access the leykart enquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leykart enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching leykart enquiries
	*/
	public java.util.List<leykartEnquiry> findByUuid(java.lang.String uuid);

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
	public java.util.List<leykartEnquiry> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<leykartEnquiry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

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
	public java.util.List<leykartEnquiry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException;

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException;

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

	/**
	* Returns the leykart enquiries before and after the current leykart enquiry in the ordered set where uuid = &#63;.
	*
	* @param Eid the primary key of the current leykart enquiry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leykart enquiry
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public leykartEnquiry[] findByUuid_PrevAndNext(long Eid,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException;

	/**
	* Removes all the leykart enquiries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of leykart enquiries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching leykart enquiries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching leykart enquiries
	*/
	public java.util.List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

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
	public java.util.List<leykartEnquiry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException;

	/**
	* Returns the first leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry
	* @throws NoSuchleykartEnquiryException if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException;

	/**
	* Returns the last leykart enquiry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	public leykartEnquiry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

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
	public leykartEnquiry[] findByUuid_C_PrevAndNext(long Eid,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator)
		throws NoSuchleykartEnquiryException;

	/**
	* Removes all the leykart enquiries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of leykart enquiries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching leykart enquiries
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the leykart enquiry in the entity cache if it is enabled.
	*
	* @param leykartEnquiry the leykart enquiry
	*/
	public void cacheResult(leykartEnquiry leykartEnquiry);

	/**
	* Caches the leykart enquiries in the entity cache if it is enabled.
	*
	* @param leykartEnquiries the leykart enquiries
	*/
	public void cacheResult(java.util.List<leykartEnquiry> leykartEnquiries);

	/**
	* Creates a new leykart enquiry with the primary key. Does not add the leykart enquiry to the database.
	*
	* @param Eid the primary key for the new leykart enquiry
	* @return the new leykart enquiry
	*/
	public leykartEnquiry create(long Eid);

	/**
	* Removes the leykart enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry that was removed
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public leykartEnquiry remove(long Eid) throws NoSuchleykartEnquiryException;

	public leykartEnquiry updateImpl(leykartEnquiry leykartEnquiry);

	/**
	* Returns the leykart enquiry with the primary key or throws a {@link NoSuchleykartEnquiryException} if it could not be found.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry
	* @throws NoSuchleykartEnquiryException if a leykart enquiry with the primary key could not be found
	*/
	public leykartEnquiry findByPrimaryKey(long Eid)
		throws NoSuchleykartEnquiryException;

	/**
	* Returns the leykart enquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry, or <code>null</code> if a leykart enquiry with the primary key could not be found
	*/
	public leykartEnquiry fetchByPrimaryKey(long Eid);

	@Override
	public java.util.Map<java.io.Serializable, leykartEnquiry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leykart enquiries.
	*
	* @return the leykart enquiries
	*/
	public java.util.List<leykartEnquiry> findAll();

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
	public java.util.List<leykartEnquiry> findAll(int start, int end);

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
	public java.util.List<leykartEnquiry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator);

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
	public java.util.List<leykartEnquiry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leykartEnquiry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leykart enquiries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leykart enquiries.
	*
	* @return the number of leykart enquiries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}