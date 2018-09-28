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
 * Provides the local service utility for WFMS_Associate_History. This utility wraps
 * {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_Associate_HistoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Associate_HistoryLocalService
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_Associate_HistoryLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_Associate_HistoryLocalServiceImpl
 * @generated
 */
@ProviderType
public class WFMS_Associate_HistoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_Associate_HistoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
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
	* Adds the WFMS_Associate_History to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	* @return the WFMS_Associate_History that was added
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History addWFMS_Associate_History(
		com.ys.hmawfm.wfms.services.model.WFMS_Associate_History wfms_Associate_History) {
		return getService().addWFMS_Associate_History(wfms_Associate_History);
	}

	/**
	* Creates a new WFMS_Associate_History with the primary key. Does not add the WFMS_Associate_History to the database.
	*
	* @param assocHistoryId the primary key for the new WFMS_Associate_History
	* @return the new WFMS_Associate_History
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History createWFMS_Associate_History(
		int assocHistoryId) {
		return getService().createWFMS_Associate_History(assocHistoryId);
	}

	/**
	* Deletes the WFMS_Associate_History from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	* @return the WFMS_Associate_History that was removed
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History deleteWFMS_Associate_History(
		com.ys.hmawfm.wfms.services.model.WFMS_Associate_History wfms_Associate_History) {
		return getService().deleteWFMS_Associate_History(wfms_Associate_History);
	}

	/**
	* Deletes the WFMS_Associate_History with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History that was removed
	* @throws PortalException if a WFMS_Associate_History with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History deleteWFMS_Associate_History(
		int assocHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWFMS_Associate_History(assocHistoryId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History fetchWFMS_Associate_History(
		int assocHistoryId) {
		return getService().fetchWFMS_Associate_History(assocHistoryId);
	}

	/**
	* Returns the WFMS_Associate_History with the primary key.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History
	* @throws PortalException if a WFMS_Associate_History with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History getWFMS_Associate_History(
		int assocHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWFMS_Associate_History(assocHistoryId);
	}

	/**
	* Updates the WFMS_Associate_History in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	* @return the WFMS_Associate_History that was updated
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Associate_History updateWFMS_Associate_History(
		com.ys.hmawfm.wfms.services.model.WFMS_Associate_History wfms_Associate_History) {
		return getService().updateWFMS_Associate_History(wfms_Associate_History);
	}

	/**
	* Returns the number of WFMS_Associate_Histories.
	*
	* @return the number of WFMS_Associate_Histories
	*/
	public static int getWFMS_Associate_HistoriesCount() {
		return getService().getWFMS_Associate_HistoriesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the WFMS_Associate_Histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Associate_Histories
	* @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	* @return the range of WFMS_Associate_Histories
	*/
	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Associate_History> getWFMS_Associate_Histories(
		int start, int end) {
		return getService().getWFMS_Associate_Histories(start, end);
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

	public static WFMS_Associate_HistoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_Associate_HistoryLocalService, WFMS_Associate_HistoryLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_Associate_HistoryLocalService.class);
}