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

package com.astra.anblicks.pdca.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.exception.NoSuchkpiException;
import com.astra.anblicks.pdca.model.kpi;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the kpi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.kpiPersistenceImpl
 * @see kpiUtil
 * @generated
 */
@ProviderType
public interface kpiPersistence extends BasePersistence<kpi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link kpiUtil} to access the kpi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the kpis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching kpis
	*/
	public java.util.List<kpi> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the kpis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @return the range of matching kpis
	*/
	public java.util.List<kpi> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the kpis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kpis
	*/
	public java.util.List<kpi> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns an ordered range of all the kpis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kpis
	*/
	public java.util.List<kpi> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kpi
	* @throws NoSuchkpiException if a matching kpi could not be found
	*/
	public kpi findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator)
		throws NoSuchkpiException;

	/**
	* Returns the first kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kpi, or <code>null</code> if a matching kpi could not be found
	*/
	public kpi fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns the last kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kpi
	* @throws NoSuchkpiException if a matching kpi could not be found
	*/
	public kpi findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator)
		throws NoSuchkpiException;

	/**
	* Returns the last kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kpi, or <code>null</code> if a matching kpi could not be found
	*/
	public kpi fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns the kpis before and after the current kpi in the ordered set where uuid = &#63;.
	*
	* @param kpiId the primary key of the current kpi
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kpi
	* @throws NoSuchkpiException if a kpi with the primary key could not be found
	*/
	public kpi[] findByUuid_PrevAndNext(long kpiId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator)
		throws NoSuchkpiException;

	/**
	* Removes all the kpis where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of kpis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching kpis
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the kpis where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching kpis
	*/
	public java.util.List<kpi> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the kpis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @return the range of matching kpis
	*/
	public java.util.List<kpi> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the kpis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kpis
	*/
	public java.util.List<kpi> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns an ordered range of all the kpis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kpis
	*/
	public java.util.List<kpi> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kpi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kpi
	* @throws NoSuchkpiException if a matching kpi could not be found
	*/
	public kpi findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator)
		throws NoSuchkpiException;

	/**
	* Returns the first kpi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kpi, or <code>null</code> if a matching kpi could not be found
	*/
	public kpi fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns the last kpi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kpi
	* @throws NoSuchkpiException if a matching kpi could not be found
	*/
	public kpi findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator)
		throws NoSuchkpiException;

	/**
	* Returns the last kpi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kpi, or <code>null</code> if a matching kpi could not be found
	*/
	public kpi fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns the kpis before and after the current kpi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param kpiId the primary key of the current kpi
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kpi
	* @throws NoSuchkpiException if a kpi with the primary key could not be found
	*/
	public kpi[] findByUuid_C_PrevAndNext(long kpiId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator)
		throws NoSuchkpiException;

	/**
	* Removes all the kpis where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of kpis where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching kpis
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the kpi in the entity cache if it is enabled.
	*
	* @param kpi the kpi
	*/
	public void cacheResult(kpi kpi);

	/**
	* Caches the kpis in the entity cache if it is enabled.
	*
	* @param kpis the kpis
	*/
	public void cacheResult(java.util.List<kpi> kpis);

	/**
	* Creates a new kpi with the primary key. Does not add the kpi to the database.
	*
	* @param kpiId the primary key for the new kpi
	* @return the new kpi
	*/
	public kpi create(long kpiId);

	/**
	* Removes the kpi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiId the primary key of the kpi
	* @return the kpi that was removed
	* @throws NoSuchkpiException if a kpi with the primary key could not be found
	*/
	public kpi remove(long kpiId) throws NoSuchkpiException;

	public kpi updateImpl(kpi kpi);

	/**
	* Returns the kpi with the primary key or throws a {@link NoSuchkpiException} if it could not be found.
	*
	* @param kpiId the primary key of the kpi
	* @return the kpi
	* @throws NoSuchkpiException if a kpi with the primary key could not be found
	*/
	public kpi findByPrimaryKey(long kpiId) throws NoSuchkpiException;

	/**
	* Returns the kpi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kpiId the primary key of the kpi
	* @return the kpi, or <code>null</code> if a kpi with the primary key could not be found
	*/
	public kpi fetchByPrimaryKey(long kpiId);

	@Override
	public java.util.Map<java.io.Serializable, kpi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the kpis.
	*
	* @return the kpis
	*/
	public java.util.List<kpi> findAll();

	/**
	* Returns a range of all the kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @return the range of kpis
	*/
	public java.util.List<kpi> findAll(int start, int end);

	/**
	* Returns an ordered range of all the kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kpis
	*/
	public java.util.List<kpi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator);

	/**
	* Returns an ordered range of all the kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of kpis
	*/
	public java.util.List<kpi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<kpi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the kpis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of kpis.
	*
	* @return the number of kpis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}