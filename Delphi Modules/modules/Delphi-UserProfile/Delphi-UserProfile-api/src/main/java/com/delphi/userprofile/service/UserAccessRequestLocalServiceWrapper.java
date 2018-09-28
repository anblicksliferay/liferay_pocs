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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserAccessRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequestLocalService
 * @generated
 */
@ProviderType
public class UserAccessRequestLocalServiceWrapper
	implements UserAccessRequestLocalService,
		ServiceWrapper<UserAccessRequestLocalService> {
	public UserAccessRequestLocalServiceWrapper(
		UserAccessRequestLocalService userAccessRequestLocalService) {
		_userAccessRequestLocalService = userAccessRequestLocalService;
	}

	/**
	* Adds the user access request to the database. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was added
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest addUserAccessRequest(
		com.delphi.userprofile.model.UserAccessRequest userAccessRequest) {
		return _userAccessRequestLocalService.addUserAccessRequest(userAccessRequest);
	}

	@Override
	public com.delphi.userprofile.model.UserAccessRequest createNewUserAccessRequest(
		long userId, long creatorUserId)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAccessRequestLocalService.createNewUserAccessRequest(userId,
			creatorUserId);
	}

	/**
	* Creates a new user access request with the primary key. Does not add the user access request to the database.
	*
	* @param requestId the primary key for the new user access request
	* @return the new user access request
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest createUserAccessRequest(
		long requestId) {
		return _userAccessRequestLocalService.createUserAccessRequest(requestId);
	}

	/**
	* Deletes the user access request from the database. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was removed
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest deleteUserAccessRequest(
		com.delphi.userprofile.model.UserAccessRequest userAccessRequest) {
		return _userAccessRequestLocalService.deleteUserAccessRequest(userAccessRequest);
	}

	/**
	* Deletes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request that was removed
	* @throws PortalException if a user access request with the primary key could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest deleteUserAccessRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userAccessRequestLocalService.deleteUserAccessRequest(requestId);
	}

	@Override
	public com.delphi.userprofile.model.UserAccessRequest fetchUserAccessRequest(
		long requestId) {
		return _userAccessRequestLocalService.fetchUserAccessRequest(requestId);
	}

	/**
	* Returns the user access request with the matching UUID and company.
	*
	* @param uuid the user access request's UUID
	* @param companyId the primary key of the company
	* @return the matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest fetchUserAccessRequestByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _userAccessRequestLocalService.fetchUserAccessRequestByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the user access request with the primary key.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request
	* @throws PortalException if a user access request with the primary key could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest getUserAccessRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userAccessRequestLocalService.getUserAccessRequest(requestId);
	}

	/**
	* Returns the user access request with the matching UUID and company.
	*
	* @param uuid the user access request's UUID
	* @param companyId the primary key of the company
	* @return the matching user access request
	* @throws PortalException if a matching user access request could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest getUserAccessRequestByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userAccessRequestLocalService.getUserAccessRequestByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the user access request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was updated
	*/
	@Override
	public com.delphi.userprofile.model.UserAccessRequest updateUserAccessRequest(
		com.delphi.userprofile.model.UserAccessRequest userAccessRequest) {
		return _userAccessRequestLocalService.updateUserAccessRequest(userAccessRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userAccessRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userAccessRequestLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _userAccessRequestLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userAccessRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userAccessRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userAccessRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user access requests.
	*
	* @return the number of user access requests
	*/
	@Override
	public int getUserAccessRequestsCount() {
		return _userAccessRequestLocalService.getUserAccessRequestsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userAccessRequestLocalService.getOSGiServiceIdentifier();
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
		return _userAccessRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userAccessRequestLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userAccessRequestLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.delphi.userprofile.model.UserAccessRequest> findUserAccessRequestByActiveState(
		int activeState)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAccessRequestLocalService.findUserAccessRequestByActiveState(activeState);
	}

	@Override
	public java.util.List<com.delphi.userprofile.model.UserAccessRequest> findUserAccessRequestsByUserId(
		long userId)
		throws com.delphi.userprofile.exception.NoSuchUserAccessRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAccessRequestLocalService.findUserAccessRequestsByUserId(userId);
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
	@Override
	public java.util.List<com.delphi.userprofile.model.UserAccessRequest> getUserAccessRequests(
		int start, int end) {
		return _userAccessRequestLocalService.getUserAccessRequests(start, end);
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
		return _userAccessRequestLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userAccessRequestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public UserAccessRequestLocalService getWrappedService() {
		return _userAccessRequestLocalService;
	}

	@Override
	public void setWrappedService(
		UserAccessRequestLocalService userAccessRequestLocalService) {
		_userAccessRequestLocalService = userAccessRequestLocalService;
	}

	private UserAccessRequestLocalService _userAccessRequestLocalService;
}