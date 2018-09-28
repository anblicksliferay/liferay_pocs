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

package ddtii.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import ddtii.exception.NoSuchlocationException;

import ddtii.model.location;

/**
 * The persistence interface for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ddtii.service.persistence.impl.locationPersistenceImpl
 * @see locationUtil
 * @generated
 */
@ProviderType
public interface locationPersistence extends BasePersistence<location> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link locationUtil} to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the location in the entity cache if it is enabled.
	*
	* @param location the location
	*/
	public void cacheResult(location location);

	/**
	* Caches the locations in the entity cache if it is enabled.
	*
	* @param locations the locations
	*/
	public void cacheResult(java.util.List<location> locations);

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public location create(long locationId);

	/**
	* Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public location remove(long locationId) throws NoSuchlocationException;

	public location updateImpl(location location);

	/**
	* Returns the location with the primary key or throws a {@link NoSuchlocationException} if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws NoSuchlocationException if a location with the primary key could not be found
	*/
	public location findByPrimaryKey(long locationId)
		throws NoSuchlocationException;

	/**
	* Returns the location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location, or <code>null</code> if a location with the primary key could not be found
	*/
	public location fetchByPrimaryKey(long locationId);

	@Override
	public java.util.Map<java.io.Serializable, location> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the locations.
	*
	* @return the locations
	*/
	public java.util.List<location> findAll();

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	*/
	public java.util.List<location> findAll(int start, int end);

	/**
	* Returns an ordered range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locations
	*/
	public java.util.List<location> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator);

	/**
	* Returns an ordered range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of locations
	*/
	public java.util.List<location> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<location> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the locations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	*/
	public int countAll();
}