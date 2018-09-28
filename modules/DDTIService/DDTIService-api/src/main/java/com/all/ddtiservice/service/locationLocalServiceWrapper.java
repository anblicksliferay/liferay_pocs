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

package com.all.ddtiservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link locationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see locationLocalService
 * @generated
 */
@ProviderType
public class locationLocalServiceWrapper implements locationLocalService,
	ServiceWrapper<locationLocalService> {
	public locationLocalServiceWrapper(
		locationLocalService locationLocalService) {
		_locationLocalService = locationLocalService;
	}

	@Override
	public boolean hascourselocation(long courseId, long locationId) {
		return _locationLocalService.hascourselocation(courseId, locationId);
	}

	@Override
	public boolean hascourselocations(long courseId) {
		return _locationLocalService.hascourselocations(courseId);
	}

	/**
	* Adds the location to the database. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was added
	*/
	@Override
	public com.all.ddtiservice.model.location addlocation(
		com.all.ddtiservice.model.location location) {
		return _locationLocalService.addlocation(location);
	}

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	@Override
	public com.all.ddtiservice.model.location createlocation(long locationId) {
		return _locationLocalService.createlocation(locationId);
	}

	/**
	* Deletes the location from the database. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was removed
	*/
	@Override
	public com.all.ddtiservice.model.location deletelocation(
		com.all.ddtiservice.model.location location) {
		return _locationLocalService.deletelocation(location);
	}

	/**
	* Deletes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws PortalException if a location with the primary key could not be found
	*/
	@Override
	public com.all.ddtiservice.model.location deletelocation(long locationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _locationLocalService.deletelocation(locationId);
	}

	@Override
	public com.all.ddtiservice.model.location fetchlocation(long locationId) {
		return _locationLocalService.fetchlocation(locationId);
	}

	/**
	* Returns the location matching the UUID and group.
	*
	* @param uuid the location's UUID
	* @param groupId the primary key of the group
	* @return the matching location, or <code>null</code> if a matching location could not be found
	*/
	@Override
	public com.all.ddtiservice.model.location fetchlocationByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _locationLocalService.fetchlocationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the location with the primary key.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws PortalException if a location with the primary key could not be found
	*/
	@Override
	public com.all.ddtiservice.model.location getlocation(long locationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _locationLocalService.getlocation(locationId);
	}

	/**
	* Returns the location matching the UUID and group.
	*
	* @param uuid the location's UUID
	* @param groupId the primary key of the group
	* @return the matching location
	* @throws PortalException if a matching location could not be found
	*/
	@Override
	public com.all.ddtiservice.model.location getlocationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _locationLocalService.getlocationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was updated
	*/
	@Override
	public com.all.ddtiservice.model.location updatelocation(
		com.all.ddtiservice.model.location location) {
		return _locationLocalService.updatelocation(location);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _locationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _locationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _locationLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _locationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _locationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _locationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getcourselocationsCount(long courseId) {
		return _locationLocalService.getcourselocationsCount(courseId);
	}

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	*/
	@Override
	public int getlocationsCount() {
		return _locationLocalService.getlocationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _locationLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _locationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _locationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _locationLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.all.ddtiservice.model.location> getcourselocations(
		long courseId) {
		return _locationLocalService.getcourselocations(courseId);
	}

	@Override
	public java.util.List<com.all.ddtiservice.model.location> getcourselocations(
		long courseId, int start, int end) {
		return _locationLocalService.getcourselocations(courseId, start, end);
	}

	@Override
	public java.util.List<com.all.ddtiservice.model.location> getcourselocations(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.location> orderByComparator) {
		return _locationLocalService.getcourselocations(courseId, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	*/
	@Override
	public java.util.List<com.all.ddtiservice.model.location> getlocations(
		int start, int end) {
		return _locationLocalService.getlocations(start, end);
	}

	/**
	* Returns all the locations matching the UUID and company.
	*
	* @param uuid the UUID of the locations
	* @param companyId the primary key of the company
	* @return the matching locations, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.all.ddtiservice.model.location> getlocationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _locationLocalService.getlocationsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of locations matching the UUID and company.
	*
	* @param uuid the UUID of the locations
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching locations, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.all.ddtiservice.model.location> getlocationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.location> orderByComparator) {
		return _locationLocalService.getlocationsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _locationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _locationLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the courseIds of the courses associated with the location.
	*
	* @param locationId the locationId of the location
	* @return long[] the courseIds of courses associated with the location
	*/
	@Override
	public long[] getcoursePrimaryKeys(long locationId) {
		return _locationLocalService.getcoursePrimaryKeys(locationId);
	}

	@Override
	public void addcourselocation(long courseId,
		com.all.ddtiservice.model.location location) {
		_locationLocalService.addcourselocation(courseId, location);
	}

	@Override
	public void addcourselocation(long courseId, long locationId) {
		_locationLocalService.addcourselocation(courseId, locationId);
	}

	@Override
	public void addcourselocations(long courseId,
		java.util.List<com.all.ddtiservice.model.location> locations) {
		_locationLocalService.addcourselocations(courseId, locations);
	}

	@Override
	public void addcourselocations(long courseId, long[] locationIds) {
		_locationLocalService.addcourselocations(courseId, locationIds);
	}

	@Override
	public void clearcourselocations(long courseId) {
		_locationLocalService.clearcourselocations(courseId);
	}

	@Override
	public void deletecourselocation(long courseId,
		com.all.ddtiservice.model.location location) {
		_locationLocalService.deletecourselocation(courseId, location);
	}

	@Override
	public void deletecourselocation(long courseId, long locationId) {
		_locationLocalService.deletecourselocation(courseId, locationId);
	}

	@Override
	public void deletecourselocations(long courseId,
		java.util.List<com.all.ddtiservice.model.location> locations) {
		_locationLocalService.deletecourselocations(courseId, locations);
	}

	@Override
	public void deletecourselocations(long courseId, long[] locationIds) {
		_locationLocalService.deletecourselocations(courseId, locationIds);
	}

	@Override
	public void setcourselocations(long courseId, long[] locationIds) {
		_locationLocalService.setcourselocations(courseId, locationIds);
	}

	@Override
	public locationLocalService getWrappedService() {
		return _locationLocalService;
	}

	@Override
	public void setWrappedService(locationLocalService locationLocalService) {
		_locationLocalService = locationLocalService;
	}

	private locationLocalService _locationLocalService;
}