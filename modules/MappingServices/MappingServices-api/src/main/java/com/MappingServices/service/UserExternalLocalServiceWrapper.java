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

package com.MappingServices.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserExternalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalLocalService
 * @generated
 */
@ProviderType
public class UserExternalLocalServiceWrapper implements UserExternalLocalService,
	ServiceWrapper<UserExternalLocalService> {
	public UserExternalLocalServiceWrapper(
		UserExternalLocalService userExternalLocalService) {
		_userExternalLocalService = userExternalLocalService;
	}

	/**
	* Adds the user external to the database. Also notifies the appropriate model listeners.
	*
	* @param userExternal the user external
	* @return the user external that was added
	*/
	@Override
	public com.MappingServices.model.UserExternal addUserExternal(
		com.MappingServices.model.UserExternal userExternal) {
		return _userExternalLocalService.addUserExternal(userExternal);
	}

	/**
	* Creates a new user external with the primary key. Does not add the user external to the database.
	*
	* @param uid the primary key for the new user external
	* @return the new user external
	*/
	@Override
	public com.MappingServices.model.UserExternal createUserExternal(long uid) {
		return _userExternalLocalService.createUserExternal(uid);
	}

	/**
	* Deletes the user external from the database. Also notifies the appropriate model listeners.
	*
	* @param userExternal the user external
	* @return the user external that was removed
	*/
	@Override
	public com.MappingServices.model.UserExternal deleteUserExternal(
		com.MappingServices.model.UserExternal userExternal) {
		return _userExternalLocalService.deleteUserExternal(userExternal);
	}

	/**
	* Deletes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uid the primary key of the user external
	* @return the user external that was removed
	* @throws PortalException if a user external with the primary key could not be found
	*/
	@Override
	public com.MappingServices.model.UserExternal deleteUserExternal(long uid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userExternalLocalService.deleteUserExternal(uid);
	}

	@Override
	public com.MappingServices.model.UserExternal fetchUserExternal(long uid) {
		return _userExternalLocalService.fetchUserExternal(uid);
	}

	/**
	* Returns the user external with the primary key.
	*
	* @param uid the primary key of the user external
	* @return the user external
	* @throws PortalException if a user external with the primary key could not be found
	*/
	@Override
	public com.MappingServices.model.UserExternal getUserExternal(long uid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userExternalLocalService.getUserExternal(uid);
	}

	/**
	* Updates the user external in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userExternal the user external
	* @return the user external that was updated
	*/
	@Override
	public com.MappingServices.model.UserExternal updateUserExternal(
		com.MappingServices.model.UserExternal userExternal) {
		return _userExternalLocalService.updateUserExternal(userExternal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userExternalLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userExternalLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userExternalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userExternalLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userExternalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user externals.
	*
	* @return the number of user externals
	*/
	@Override
	public int getUserExternalsCount() {
		return _userExternalLocalService.getUserExternalsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userExternalLocalService.getOSGiServiceIdentifier();
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
		return _userExternalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.MappingServices.model.impl.UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userExternalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.MappingServices.model.impl.UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userExternalLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.MappingServices.model.UserExternal> findByPolicyID(
		java.lang.String PolicyNumber) {
		return _userExternalLocalService.findByPolicyID(PolicyNumber);
	}

	/**
	* Returns a range of all the user externals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.MappingServices.model.impl.UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user externals
	* @param end the upper bound of the range of user externals (not inclusive)
	* @return the range of user externals
	*/
	@Override
	public java.util.List<com.MappingServices.model.UserExternal> getUserExternals(
		int start, int end) {
		return _userExternalLocalService.getUserExternals(start, end);
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
		return _userExternalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userExternalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public UserExternalLocalService getWrappedService() {
		return _userExternalLocalService;
	}

	@Override
	public void setWrappedService(
		UserExternalLocalService userExternalLocalService) {
		_userExternalLocalService = userExternalLocalService;
	}

	private UserExternalLocalService _userExternalLocalService;
}