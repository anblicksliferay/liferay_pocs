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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for registrationDetails. This utility wraps
 * {@link com.all.ddtiservice.service.impl.registrationDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsLocalService
 * @see com.all.ddtiservice.service.base.registrationDetailsLocalServiceBaseImpl
 * @see com.all.ddtiservice.service.impl.registrationDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class registrationDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.all.ddtiservice.service.impl.registrationDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean hascourseregistrationDetails(long courseId,
		long registrationId) {
		return getService()
				   .hascourseregistrationDetails(courseId, registrationId);
	}

	public static boolean hascourseregistrationDetailses(long courseId) {
		return getService().hascourseregistrationDetailses(courseId);
	}

	/**
	* Adds the registration details to the database. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was added
	*/
	public static com.all.ddtiservice.model.registrationDetails addregistrationDetails(
		com.all.ddtiservice.model.registrationDetails registrationDetails) {
		return getService().addregistrationDetails(registrationDetails);
	}

	/**
	* Creates a new registration details with the primary key. Does not add the registration details to the database.
	*
	* @param registrationId the primary key for the new registration details
	* @return the new registration details
	*/
	public static com.all.ddtiservice.model.registrationDetails createregistrationDetails(
		long registrationId) {
		return getService().createregistrationDetails(registrationId);
	}

	/**
	* Deletes the registration details from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was removed
	*/
	public static com.all.ddtiservice.model.registrationDetails deleteregistrationDetails(
		com.all.ddtiservice.model.registrationDetails registrationDetails) {
		return getService().deleteregistrationDetails(registrationDetails);
	}

	/**
	* Deletes the registration details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details that was removed
	* @throws PortalException if a registration details with the primary key could not be found
	*/
	public static com.all.ddtiservice.model.registrationDetails deleteregistrationDetails(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteregistrationDetails(registrationId);
	}

	public static com.all.ddtiservice.model.registrationDetails fetchregistrationDetails(
		long registrationId) {
		return getService().fetchregistrationDetails(registrationId);
	}

	/**
	* Returns the registration details matching the UUID and group.
	*
	* @param uuid the registration details's UUID
	* @param groupId the primary key of the group
	* @return the matching registration details, or <code>null</code> if a matching registration details could not be found
	*/
	public static com.all.ddtiservice.model.registrationDetails fetchregistrationDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService()
				   .fetchregistrationDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the registration details with the primary key.
	*
	* @param registrationId the primary key of the registration details
	* @return the registration details
	* @throws PortalException if a registration details with the primary key could not be found
	*/
	public static com.all.ddtiservice.model.registrationDetails getregistrationDetails(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getregistrationDetails(registrationId);
	}

	/**
	* Returns the registration details matching the UUID and group.
	*
	* @param uuid the registration details's UUID
	* @param groupId the primary key of the group
	* @return the matching registration details
	* @throws PortalException if a matching registration details could not be found
	*/
	public static com.all.ddtiservice.model.registrationDetails getregistrationDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getregistrationDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the registration details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param registrationDetails the registration details
	* @return the registration details that was updated
	*/
	public static com.all.ddtiservice.model.registrationDetails updateregistrationDetails(
		com.all.ddtiservice.model.registrationDetails registrationDetails) {
		return getService().updateregistrationDetails(registrationDetails);
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

	public static int getcourseregistrationDetailsesCount(long courseId) {
		return getService().getcourseregistrationDetailsesCount(courseId);
	}

	/**
	* Returns the number of registration detailses.
	*
	* @return the number of registration detailses
	*/
	public static int getregistrationDetailsesCount() {
		return getService().getregistrationDetailsesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.all.ddtiservice.model.registrationDetails> getcourseregistrationDetailses(
		long courseId) {
		return getService().getcourseregistrationDetailses(courseId);
	}

	public static java.util.List<com.all.ddtiservice.model.registrationDetails> getcourseregistrationDetailses(
		long courseId, int start, int end) {
		return getService().getcourseregistrationDetailses(courseId, start, end);
	}

	public static java.util.List<com.all.ddtiservice.model.registrationDetails> getcourseregistrationDetailses(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.registrationDetails> orderByComparator) {
		return getService()
				   .getcourseregistrationDetailses(courseId, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the registration detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.all.ddtiservice.model.impl.registrationDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @return the range of registration detailses
	*/
	public static java.util.List<com.all.ddtiservice.model.registrationDetails> getregistrationDetailses(
		int start, int end) {
		return getService().getregistrationDetailses(start, end);
	}

	/**
	* Returns all the registration detailses matching the UUID and company.
	*
	* @param uuid the UUID of the registration detailses
	* @param companyId the primary key of the company
	* @return the matching registration detailses, or an empty list if no matches were found
	*/
	public static java.util.List<com.all.ddtiservice.model.registrationDetails> getregistrationDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .getregistrationDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of registration detailses matching the UUID and company.
	*
	* @param uuid the UUID of the registration detailses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of registration detailses
	* @param end the upper bound of the range of registration detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching registration detailses, or an empty list if no matches were found
	*/
	public static java.util.List<com.all.ddtiservice.model.registrationDetails> getregistrationDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.all.ddtiservice.model.registrationDetails> orderByComparator) {
		return getService()
				   .getregistrationDetailsesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
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
	* Returns the courseIds of the courses associated with the registration details.
	*
	* @param registrationId the registrationId of the registration details
	* @return long[] the courseIds of courses associated with the registration details
	*/
	public static long[] getcoursePrimaryKeys(long registrationId) {
		return getService().getcoursePrimaryKeys(registrationId);
	}

	public static void addcourseregistrationDetails(long courseId,
		com.all.ddtiservice.model.registrationDetails registrationDetails) {
		getService().addcourseregistrationDetails(courseId, registrationDetails);
	}

	public static void addcourseregistrationDetails(long courseId,
		long registrationId) {
		getService().addcourseregistrationDetails(courseId, registrationId);
	}

	public static void addcourseregistrationDetailses(long courseId,
		java.util.List<com.all.ddtiservice.model.registrationDetails> registrationDetailses) {
		getService()
			.addcourseregistrationDetailses(courseId, registrationDetailses);
	}

	public static void addcourseregistrationDetailses(long courseId,
		long[] registrationIds) {
		getService().addcourseregistrationDetailses(courseId, registrationIds);
	}

	public static void clearcourseregistrationDetailses(long courseId) {
		getService().clearcourseregistrationDetailses(courseId);
	}

	public static void deletecourseregistrationDetails(long courseId,
		com.all.ddtiservice.model.registrationDetails registrationDetails) {
		getService()
			.deletecourseregistrationDetails(courseId, registrationDetails);
	}

	public static void deletecourseregistrationDetails(long courseId,
		long registrationId) {
		getService().deletecourseregistrationDetails(courseId, registrationId);
	}

	public static void deletecourseregistrationDetailses(long courseId,
		java.util.List<com.all.ddtiservice.model.registrationDetails> registrationDetailses) {
		getService()
			.deletecourseregistrationDetailses(courseId, registrationDetailses);
	}

	public static void deletecourseregistrationDetailses(long courseId,
		long[] registrationIds) {
		getService().deletecourseregistrationDetailses(courseId, registrationIds);
	}

	public static void setcourseregistrationDetailses(long courseId,
		long[] registrationIds) {
		getService().setcourseregistrationDetailses(courseId, registrationIds);
	}

	public static registrationDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<registrationDetailsLocalService, registrationDetailsLocalService> _serviceTracker =
		ServiceTrackerFactory.open(registrationDetailsLocalService.class);
}