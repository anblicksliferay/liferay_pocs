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

import com.leykartservice.exception.NoSuchTestmonialsException;

import com.leykartservice.model.Testmonials;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the testmonials service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.leykartservice.service.persistence.impl.TestmonialsPersistenceImpl
 * @see TestmonialsUtil
 * @generated
 */
@ProviderType
public interface TestmonialsPersistence extends BasePersistence<Testmonials> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestmonialsUtil} to access the testmonials persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the testmonialses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching testmonialses
	*/
	public java.util.List<Testmonials> findByUuid(java.lang.String uuid);

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
	public java.util.List<Testmonials> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<Testmonials> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

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
	public java.util.List<Testmonials> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public Testmonials findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException;

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public Testmonials fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public Testmonials findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException;

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public Testmonials fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

	/**
	* Returns the testmonialses before and after the current testmonials in the ordered set where uuid = &#63;.
	*
	* @param testmonialsId the primary key of the current testmonials
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testmonials
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public Testmonials[] findByUuid_PrevAndNext(long testmonialsId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException;

	/**
	* Removes all the testmonialses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of testmonialses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching testmonialses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching testmonialses
	*/
	public java.util.List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

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
	public java.util.List<Testmonials> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public Testmonials findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException;

	/**
	* Returns the first testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public Testmonials fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials
	* @throws NoSuchTestmonialsException if a matching testmonials could not be found
	*/
	public Testmonials findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException;

	/**
	* Returns the last testmonials in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	public Testmonials fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

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
	public Testmonials[] findByUuid_C_PrevAndNext(long testmonialsId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator)
		throws NoSuchTestmonialsException;

	/**
	* Removes all the testmonialses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of testmonialses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching testmonialses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the testmonials in the entity cache if it is enabled.
	*
	* @param testmonials the testmonials
	*/
	public void cacheResult(Testmonials testmonials);

	/**
	* Caches the testmonialses in the entity cache if it is enabled.
	*
	* @param testmonialses the testmonialses
	*/
	public void cacheResult(java.util.List<Testmonials> testmonialses);

	/**
	* Creates a new testmonials with the primary key. Does not add the testmonials to the database.
	*
	* @param testmonialsId the primary key for the new testmonials
	* @return the new testmonials
	*/
	public Testmonials create(long testmonialsId);

	/**
	* Removes the testmonials with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials that was removed
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public Testmonials remove(long testmonialsId)
		throws NoSuchTestmonialsException;

	public Testmonials updateImpl(Testmonials testmonials);

	/**
	* Returns the testmonials with the primary key or throws a {@link NoSuchTestmonialsException} if it could not be found.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials
	* @throws NoSuchTestmonialsException if a testmonials with the primary key could not be found
	*/
	public Testmonials findByPrimaryKey(long testmonialsId)
		throws NoSuchTestmonialsException;

	/**
	* Returns the testmonials with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials, or <code>null</code> if a testmonials with the primary key could not be found
	*/
	public Testmonials fetchByPrimaryKey(long testmonialsId);

	@Override
	public java.util.Map<java.io.Serializable, Testmonials> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the testmonialses.
	*
	* @return the testmonialses
	*/
	public java.util.List<Testmonials> findAll();

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
	public java.util.List<Testmonials> findAll(int start, int end);

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
	public java.util.List<Testmonials> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator);

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
	public java.util.List<Testmonials> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Testmonials> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the testmonialses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of testmonialses.
	*
	* @return the number of testmonialses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}