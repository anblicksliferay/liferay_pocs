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

package com.delphi.userprofile.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserAccessRequest. This utility wraps
 * {@link com.delphi.userprofile.service.impl.UserAccessRequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequestLocalService
 * @see com.delphi.userprofile.service.base.UserAccessRequestLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.impl.UserAccessRequestLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserAccessRequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.delphi.userprofile.service.impl.UserAccessRequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user access request to the database. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was added
	*/
	public static com.delphi.userprofile.model.UserAccessRequest addUserAccessRequest(
		com.delphi.userprofile.model.UserAccessRequest userAccessRequest) {
		return getService().addUserAccessRequest(userAccessRequest);
	}

	public static com.delphi.userprofile.model.UserAccessRequest createNewUserAccessRequest(
		long userId, long creatorUserId)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().createNewUserAccessRequest(userId, creatorUserId);
	}

	/**
	* Creates a new user access request with the primary key. Does not add the user access request to the database.
	*
	* @param requestId the primary key for the new user access request
	* @return the new user access request
	*/
	public static com.delphi.userprofile.model.UserAccessRequest createUserAccessRequest(
		long requestId) {
		return getService().createUserAccessRequest(requestId);
	}

	/**
	* Deletes the user access request from the database. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was removed
	*/
	public static com.delphi.userprofile.model.UserAccessRequest deleteUserAccessRequest(
		com.delphi.userprofile.model.UserAccessRequest userAccessRequest) {
		return getService().deleteUserAccessRequest(userAccessRequest);
	}

	/**
	* Deletes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request that was removed
	* @throws PortalException if a user access request with the primary key could not be found
	*/
	public static com.delphi.userprofile.model.UserAccessRequest deleteUserAccessRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserAccessRequest(requestId);
	}

	public static com.delphi.userprofile.model.UserAccessRequest fetchUserAccessRequest(
		long requestId) {
		return getService().fetchUserAccessRequest(requestId);
	}

	/**
	* Returns the user access request with the matching UUID and company.
	*
	* @param uuid the user access request's UUID
	* @param companyId the primary key of the company
	* @return the matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	public static com.delphi.userprofile.model.UserAccessRequest fetchUserAccessRequestByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .fetchUserAccessRequestByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the user access request with the primary key.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request
	* @throws PortalException if a user access request with the primary key could not be found
	*/
	public static com.delphi.userprofile.model.UserAccessRequest getUserAccessRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserAccessRequest(requestId);
	}

	/**
	* Returns the user access request with the matching UUID and company.
	*
	* @param uuid the user access request's UUID
	* @param companyId the primary key of the company
	* @return the matching user access request
	* @throws PortalException if a matching user access request could not be found
	*/
	public static com.delphi.userprofile.model.UserAccessRequest getUserAccessRequestByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getUserAccessRequestByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the user access request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was updated
	*/
	public static com.delphi.userprofile.model.UserAccessRequest updateUserAccessRequest(
		com.delphi.userprofile.model.UserAccessRequest userAccessRequest) {
		return getService().updateUserAccessRequest(userAccessRequest);
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
	* Returns the number of user access requests.
	*
	* @return the number of user access requests
	*/
	public static int getUserAccessRequestsCount() {
		return getService().getUserAccessRequestsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.delphi.userprofile.model.UserAccessRequest> findUserAccessRequestByActiveState(
		int activeState)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findUserAccessRequestByActiveState(activeState);
	}

	public static java.util.List<com.delphi.userprofile.model.UserAccessRequest> findUserAccessRequestsByUserId(
		long userId)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findUserAccessRequestsByUserId(userId);
	}

	/**
	* Returns a range of all the user access requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of user access requests
	*/
	public static java.util.List<com.delphi.userprofile.model.UserAccessRequest> getUserAccessRequests(
		int start, int end) {
		return getService().getUserAccessRequests(start, end);
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

	public static UserAccessRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserAccessRequestLocalService, UserAccessRequestLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserAccessRequestLocalService.class);
}