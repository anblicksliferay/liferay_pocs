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
 * Provides a wrapper for {@link UserProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserProfileLocalService
 * @generated
 */
@ProviderType
public class UserProfileLocalServiceWrapper implements UserProfileLocalService,
	ServiceWrapper<UserProfileLocalService> {
	public UserProfileLocalServiceWrapper(
		UserProfileLocalService userProfileLocalService) {
		_userProfileLocalService = userProfileLocalService;
	}

	/**
	* Adds the user profile to the database. Also notifies the appropriate model listeners.
	*
	* @param userProfile the user profile
	* @return the user profile that was added
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile addUserProfile(
		com.delphi.userprofile.model.UserProfile userProfile) {
		return _userProfileLocalService.addUserProfile(userProfile);
	}

	@Override
	public com.delphi.userprofile.model.UserProfile createNewUserProfile(
		long userId, long creatorUserId)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userProfileLocalService.createNewUserProfile(userId,
			creatorUserId);
	}

	/**
	* Creates a new user profile with the primary key. Does not add the user profile to the database.
	*
	* @param profileId the primary key for the new user profile
	* @return the new user profile
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile createUserProfile(
		long profileId) {
		return _userProfileLocalService.createUserProfile(profileId);
	}

	/**
	* Deletes the user profile from the database. Also notifies the appropriate model listeners.
	*
	* @param userProfile the user profile
	* @return the user profile that was removed
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile deleteUserProfile(
		com.delphi.userprofile.model.UserProfile userProfile) {
		return _userProfileLocalService.deleteUserProfile(userProfile);
	}

	/**
	* Deletes the user profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile that was removed
	* @throws PortalException if a user profile with the primary key could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile deleteUserProfile(
		long profileId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileLocalService.deleteUserProfile(profileId);
	}

	@Override
	public com.delphi.userprofile.model.UserProfile fetchUserProfile(
		long profileId) {
		return _userProfileLocalService.fetchUserProfile(profileId);
	}

	/**
	* Returns the user profile with the matching UUID and company.
	*
	* @param uuid the user profile's UUID
	* @param companyId the primary key of the company
	* @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile fetchUserProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _userProfileLocalService.fetchUserProfileByUuidAndCompanyId(uuid,
			companyId);
	}

	@Override
	public com.delphi.userprofile.model.UserProfile findUserProfileByUserId(
		long userId)
		throws com.delphi.userprofile.exception.NoSuchUserProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userProfileLocalService.findUserProfileByUserId(userId);
	}

	/**
	* Returns the user profile with the primary key.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile
	* @throws PortalException if a user profile with the primary key could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile getUserProfile(
		long profileId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileLocalService.getUserProfile(profileId);
	}

	/**
	* Returns the user profile with the matching UUID and company.
	*
	* @param uuid the user profile's UUID
	* @param companyId the primary key of the company
	* @return the matching user profile
	* @throws PortalException if a matching user profile could not be found
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile getUserProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileLocalService.getUserProfileByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the user profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userProfile the user profile
	* @return the user profile that was updated
	*/
	@Override
	public com.delphi.userprofile.model.UserProfile updateUserProfile(
		com.delphi.userprofile.model.UserProfile userProfile) {
		return _userProfileLocalService.updateUserProfile(userProfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userProfileLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userProfileLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _userProfileLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userProfileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user profiles.
	*
	* @return the number of user profiles
	*/
	@Override
	public int getUserProfilesCount() {
		return _userProfileLocalService.getUserProfilesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userProfileLocalService.getOSGiServiceIdentifier();
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
		return _userProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userProfileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userProfileLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the user profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @return the range of user profiles
	*/
	@Override
	public java.util.List<com.delphi.userprofile.model.UserProfile> getUserProfiles(
		int start, int end) {
		return _userProfileLocalService.getUserProfiles(start, end);
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
		return _userProfileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userProfileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public UserProfileLocalService getWrappedService() {
		return _userProfileLocalService;
	}

	@Override
	public void setWrappedService(
		UserProfileLocalService userProfileLocalService) {
		_userProfileLocalService = userProfileLocalService;
	}

	private UserProfileLocalService _userProfileLocalService;
}