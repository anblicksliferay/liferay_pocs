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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserExternal. This utility wraps
 * {@link com.MappingServices.service.impl.UserExternalLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalLocalService
 * @see com.MappingServices.service.base.UserExternalLocalServiceBaseImpl
 * @see com.MappingServices.service.impl.UserExternalLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserExternalLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.MappingServices.service.impl.UserExternalLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user external to the database. Also notifies the appropriate model listeners.
	*
	* @param userExternal the user external
	* @return the user external that was added
	*/
	public static com.MappingServices.model.UserExternal addUserExternal(
		com.MappingServices.model.UserExternal userExternal) {
		return getService().addUserExternal(userExternal);
	}

	/**
	* Creates a new user external with the primary key. Does not add the user external to the database.
	*
	* @param uid the primary key for the new user external
	* @return the new user external
	*/
	public static com.MappingServices.model.UserExternal createUserExternal(
		long uid) {
		return getService().createUserExternal(uid);
	}

	/**
	* Deletes the user external from the database. Also notifies the appropriate model listeners.
	*
	* @param userExternal the user external
	* @return the user external that was removed
	*/
	public static com.MappingServices.model.UserExternal deleteUserExternal(
		com.MappingServices.model.UserExternal userExternal) {
		return getService().deleteUserExternal(userExternal);
	}

	/**
	* Deletes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uid the primary key of the user external
	* @return the user external that was removed
	* @throws PortalException if a user external with the primary key could not be found
	*/
	public static com.MappingServices.model.UserExternal deleteUserExternal(
		long uid) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserExternal(uid);
	}

	public static com.MappingServices.model.UserExternal fetchUserExternal(
		long uid) {
		return getService().fetchUserExternal(uid);
	}

	/**
	* Returns the user external with the primary key.
	*
	* @param uid the primary key of the user external
	* @return the user external
	* @throws PortalException if a user external with the primary key could not be found
	*/
	public static com.MappingServices.model.UserExternal getUserExternal(
		long uid) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserExternal(uid);
	}

	/**
	* Updates the user external in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userExternal the user external
	* @return the user external that was updated
	*/
	public static com.MappingServices.model.UserExternal updateUserExternal(
		com.MappingServices.model.UserExternal userExternal) {
		return getService().updateUserExternal(userExternal);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
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
	* Returns the number of user externals.
	*
	* @return the number of user externals
	*/
	public static int getUserExternalsCount() {
		return getService().getUserExternalsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.MappingServices.model.impl.UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.MappingServices.model.impl.UserExternalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.MappingServices.model.UserExternal> findByPolicyID(
		java.lang.String PolicyNumber) {
		return getService().findByPolicyID(PolicyNumber);
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
	public static java.util.List<com.MappingServices.model.UserExternal> getUserExternals(
		int start, int end) {
		return getService().getUserExternals(start, end);
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

	public static UserExternalLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserExternalLocalService, UserExternalLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserExternalLocalService.class);
}