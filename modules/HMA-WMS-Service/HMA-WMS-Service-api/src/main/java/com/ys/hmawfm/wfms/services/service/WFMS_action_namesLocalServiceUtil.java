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

package com.ys.hmawfm.wfms.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for WFMS_action_names. This utility wraps
 * {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_action_namesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_namesLocalService
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_action_namesLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_action_namesLocalServiceImpl
 * @generated
 */
@ProviderType
public class WFMS_action_namesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_action_namesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
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
	* Adds the WFMS_action_names to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_action_names the WFMS_action_names
	* @return the WFMS_action_names that was added
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names addWFMS_action_names(
		com.ys.hmawfm.wfms.services.model.WFMS_action_names wfms_action_names) {
		return getService().addWFMS_action_names(wfms_action_names);
	}

	/**
	* Creates a new WFMS_action_names with the primary key. Does not add the WFMS_action_names to the database.
	*
	* @param actionId the primary key for the new WFMS_action_names
	* @return the new WFMS_action_names
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names createWFMS_action_names(
		java.lang.String actionId) {
		return getService().createWFMS_action_names(actionId);
	}

	/**
	* Deletes the WFMS_action_names from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_action_names the WFMS_action_names
	* @return the WFMS_action_names that was removed
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names deleteWFMS_action_names(
		com.ys.hmawfm.wfms.services.model.WFMS_action_names wfms_action_names) {
		return getService().deleteWFMS_action_names(wfms_action_names);
	}

	/**
	* Deletes the WFMS_action_names with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names that was removed
	* @throws PortalException if a WFMS_action_names with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names deleteWFMS_action_names(
		java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWFMS_action_names(actionId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names fetchWFMS_action_names(
		java.lang.String actionId) {
		return getService().fetchWFMS_action_names(actionId);
	}

	/**
	* Returns the WFMS_action_names with the primary key.
	*
	* @param actionId the primary key of the WFMS_action_names
	* @return the WFMS_action_names
	* @throws PortalException if a WFMS_action_names with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names getWFMS_action_names(
		java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWFMS_action_names(actionId);
	}

	/**
	* Updates the WFMS_action_names in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_action_names the WFMS_action_names
	* @return the WFMS_action_names that was updated
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_action_names updateWFMS_action_names(
		com.ys.hmawfm.wfms.services.model.WFMS_action_names wfms_action_names) {
		return getService().updateWFMS_action_names(wfms_action_names);
	}

	/**
	* Returns the number of WFMS_action_nameses.
	*
	* @return the number of WFMS_action_nameses
	*/
	public static int getWFMS_action_namesesCount() {
		return getService().getWFMS_action_namesesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the WFMS_action_nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_nameses
	* @param end the upper bound of the range of WFMS_action_nameses (not inclusive)
	* @return the range of WFMS_action_nameses
	*/
	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_action_names> getWFMS_action_nameses(
		int start, int end) {
		return getService().getWFMS_action_nameses(start, end);
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

	public static WFMS_action_namesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_action_namesLocalService, WFMS_action_namesLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_action_namesLocalService.class);
}