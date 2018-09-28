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

package com.astra.workflowservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.astra.workflowservice.exception.NoSuchRegistrationException;
import com.astra.workflowservice.model.Registration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.workflowservice.service.persistence.impl.RegistrationPersistenceImpl
 * @see RegistrationUtil
 * @generated
 */
@ProviderType
public interface RegistrationPersistence extends BasePersistence<Registration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistrationUtil} to access the registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching registrations
	*/
	public java.util.List<Registration> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @return the range of matching registrations
	*/
	public java.util.List<Registration> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching registrations
	*/
	public java.util.List<Registration> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns an ordered range of all the registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching registrations
	*/
	public java.util.List<Registration> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration
	* @throws NoSuchRegistrationException if a matching registration could not be found
	*/
	public Registration findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator)
		throws NoSuchRegistrationException;

	/**
	* Returns the first registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration, or <code>null</code> if a matching registration could not be found
	*/
	public Registration fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns the last registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration
	* @throws NoSuchRegistrationException if a matching registration could not be found
	*/
	public Registration findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator)
		throws NoSuchRegistrationException;

	/**
	* Returns the last registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration, or <code>null</code> if a matching registration could not be found
	*/
	public Registration fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns the registrations before and after the current registration in the ordered set where uuid = &#63;.
	*
	* @param RegistrationId the primary key of the current registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next registration
	* @throws NoSuchRegistrationException if a registration with the primary key could not be found
	*/
	public Registration[] findByUuid_PrevAndNext(long RegistrationId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator)
		throws NoSuchRegistrationException;

	/**
	* Removes all the registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching registrations
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the registrations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching registrations
	*/
	public java.util.List<Registration> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the registrations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @return the range of matching registrations
	*/
	public java.util.List<Registration> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the registrations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching registrations
	*/
	public java.util.List<Registration> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns an ordered range of all the registrations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching registrations
	*/
	public java.util.List<Registration> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration
	* @throws NoSuchRegistrationException if a matching registration could not be found
	*/
	public Registration findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator)
		throws NoSuchRegistrationException;

	/**
	* Returns the first registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching registration, or <code>null</code> if a matching registration could not be found
	*/
	public Registration fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns the last registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration
	* @throws NoSuchRegistrationException if a matching registration could not be found
	*/
	public Registration findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator)
		throws NoSuchRegistrationException;

	/**
	* Returns the last registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching registration, or <code>null</code> if a matching registration could not be found
	*/
	public Registration fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns the registrations before and after the current registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param RegistrationId the primary key of the current registration
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next registration
	* @throws NoSuchRegistrationException if a registration with the primary key could not be found
	*/
	public Registration[] findByUuid_C_PrevAndNext(long RegistrationId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator)
		throws NoSuchRegistrationException;

	/**
	* Removes all the registrations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of registrations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching registrations
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the registration in the entity cache if it is enabled.
	*
	* @param registration the registration
	*/
	public void cacheResult(Registration registration);

	/**
	* Caches the registrations in the entity cache if it is enabled.
	*
	* @param registrations the registrations
	*/
	public void cacheResult(java.util.List<Registration> registrations);

	/**
	* Creates a new registration with the primary key. Does not add the registration to the database.
	*
	* @param RegistrationId the primary key for the new registration
	* @return the new registration
	*/
	public Registration create(long RegistrationId);

	/**
	* Removes the registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param RegistrationId the primary key of the registration
	* @return the registration that was removed
	* @throws NoSuchRegistrationException if a registration with the primary key could not be found
	*/
	public Registration remove(long RegistrationId)
		throws NoSuchRegistrationException;

	public Registration updateImpl(Registration registration);

	/**
	* Returns the registration with the primary key or throws a {@link NoSuchRegistrationException} if it could not be found.
	*
	* @param RegistrationId the primary key of the registration
	* @return the registration
	* @throws NoSuchRegistrationException if a registration with the primary key could not be found
	*/
	public Registration findByPrimaryKey(long RegistrationId)
		throws NoSuchRegistrationException;

	/**
	* Returns the registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param RegistrationId the primary key of the registration
	* @return the registration, or <code>null</code> if a registration with the primary key could not be found
	*/
	public Registration fetchByPrimaryKey(long RegistrationId);

	@Override
	public java.util.Map<java.io.Serializable, Registration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the registrations.
	*
	* @return the registrations
	*/
	public java.util.List<Registration> findAll();

	/**
	* Returns a range of all the registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @return the range of registrations
	*/
	public java.util.List<Registration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of registrations
	*/
	public java.util.List<Registration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator);

	/**
	* Returns an ordered range of all the registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of registrations
	*/
	public java.util.List<Registration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Registration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of registrations.
	*
	* @return the number of registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}