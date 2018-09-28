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

package com.servicemapping.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for location. This utility wraps
 * {@link com.servicemapping.service.impl.locationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see locationLocalService
 * @see com.servicemapping.service.base.locationLocalServiceBaseImpl
 * @see com.servicemapping.service.impl.locationLocalServiceImpl
 * @generated
 */
@ProviderType
public class locationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.servicemapping.service.impl.locationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean hascourselocation(long courseId, long locationId) {
		return getService().hascourselocation(courseId, locationId);
	}

	public static boolean hascourselocations(long courseId) {
		return getService().hascourselocations(courseId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the location to the database. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was added
	*/
	public static com.servicemapping.model.location addlocation(
		com.servicemapping.model.location location) {
		return getService().addlocation(location);
	}

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public static com.servicemapping.model.location createlocation(
		long locationId) {
		return getService().createlocation(locationId);
	}

	/**
	* Deletes the location from the database. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was removed
	*/
	public static com.servicemapping.model.location deletelocation(
		com.servicemapping.model.location location) {
		return getService().deletelocation(location);
	}

	/**
	* Deletes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws PortalException if a location with the primary key could not be found
	*/
	public static com.servicemapping.model.location deletelocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletelocation(locationId);
	}

	public static com.servicemapping.model.location fetchlocation(
		long locationId) {
		return getService().fetchlocation(locationId);
	}

	/**
	* Returns the location matching the UUID and group.
	*
	* @param uuid the location's UUID
	* @param groupId the primary key of the group
	* @return the matching location, or <code>null</code> if a matching location could not be found
	*/
	public static com.servicemapping.model.location fetchlocationByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchlocationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the location with the primary key.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws PortalException if a location with the primary key could not be found
	*/
	public static com.servicemapping.model.location getlocation(long locationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getlocation(locationId);
	}

	/**
	* Returns the location matching the UUID and group.
	*
	* @param uuid the location's UUID
	* @param groupId the primary key of the group
	* @return the matching location
	* @throws PortalException if a matching location could not be found
	*/
	public static com.servicemapping.model.location getlocationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getlocationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was updated
	*/
	public static com.servicemapping.model.location updatelocation(
		com.servicemapping.model.location location) {
		return getService().updatelocation(location);
	}

	public static int getcourselocationsCount(long courseId) {
		return getService().getcourselocationsCount(courseId);
	}

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	*/
	public static int getlocationsCount() {
		return getService().getlocationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.servicemapping.model.location> getcourselocations(
		long courseId) {
		return getService().getcourselocations(courseId);
	}

	public static java.util.List<com.servicemapping.model.location> getcourselocations(
		long courseId, int start, int end) {
		return getService().getcourselocations(courseId, start, end);
	}

	public static java.util.List<com.servicemapping.model.location> getcourselocations(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.location> orderByComparator) {
		return getService()
				   .getcourselocations(courseId, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.servicemapping.model.impl.locationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	*/
	public static java.util.List<com.servicemapping.model.location> getlocations(
		int start, int end) {
		return getService().getlocations(start, end);
	}

	/**
	* Returns all the locations matching the UUID and company.
	*
	* @param uuid the UUID of the locations
	* @param companyId the primary key of the company
	* @return the matching locations, or an empty list if no matches were found
	*/
	public static java.util.List<com.servicemapping.model.location> getlocationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getlocationsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.servicemapping.model.location> getlocationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.servicemapping.model.location> orderByComparator) {
		return getService()
				   .getlocationsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the courseIds of the courses associated with the location.
	*
	* @param locationId the locationId of the location
	* @return long[] the courseIds of courses associated with the location
	*/
	public static long[] getcoursePrimaryKeys(long locationId) {
		return getService().getcoursePrimaryKeys(locationId);
	}

	public static void addcourselocation(long courseId,
		com.servicemapping.model.location location) {
		getService().addcourselocation(courseId, location);
	}

	public static void addcourselocation(long courseId, long locationId) {
		getService().addcourselocation(courseId, locationId);
	}

	public static void addcourselocations(long courseId,
		java.util.List<com.servicemapping.model.location> locations) {
		getService().addcourselocations(courseId, locations);
	}

	public static void addcourselocations(long courseId, long[] locationIds) {
		getService().addcourselocations(courseId, locationIds);
	}

	public static void clearcourselocations(long courseId) {
		getService().clearcourselocations(courseId);
	}

	public static void deletecourselocation(long courseId,
		com.servicemapping.model.location location) {
		getService().deletecourselocation(courseId, location);
	}

	public static void deletecourselocation(long courseId, long locationId) {
		getService().deletecourselocation(courseId, locationId);
	}

	public static void deletecourselocations(long courseId,
		java.util.List<com.servicemapping.model.location> locations) {
		getService().deletecourselocations(courseId, locations);
	}

	public static void deletecourselocations(long courseId, long[] locationIds) {
		getService().deletecourselocations(courseId, locationIds);
	}

	public static void setcourselocations(long courseId, long[] locationIds) {
		getService().setcourselocations(courseId, locationIds);
	}

	public static locationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<locationLocalService, locationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(locationLocalService.class);
}