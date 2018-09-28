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

package com.ddt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Loc_Course_Info. This utility wraps
 * {@link com.ddt.service.impl.Loc_Course_InfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_InfoLocalService
 * @see com.ddt.service.base.Loc_Course_InfoLocalServiceBaseImpl
 * @see com.ddt.service.impl.Loc_Course_InfoLocalServiceImpl
 * @generated
 */
@ProviderType
public class Loc_Course_InfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ddt.service.impl.Loc_Course_InfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the loc_ course_ info to the database. Also notifies the appropriate model listeners.
	*
	* @param loc_Course_Info the loc_ course_ info
	* @return the loc_ course_ info that was added
	*/
	public static com.ddt.model.Loc_Course_Info addLoc_Course_Info(
		com.ddt.model.Loc_Course_Info loc_Course_Info) {
		return getService().addLoc_Course_Info(loc_Course_Info);
	}

	/**
	* Creates a new loc_ course_ info with the primary key. Does not add the loc_ course_ info to the database.
	*
	* @param id the primary key for the new loc_ course_ info
	* @return the new loc_ course_ info
	*/
	public static com.ddt.model.Loc_Course_Info createLoc_Course_Info(long id) {
		return getService().createLoc_Course_Info(id);
	}

	/**
	* Deletes the loc_ course_ info from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_Course_Info the loc_ course_ info
	* @return the loc_ course_ info that was removed
	*/
	public static com.ddt.model.Loc_Course_Info deleteLoc_Course_Info(
		com.ddt.model.Loc_Course_Info loc_Course_Info) {
		return getService().deleteLoc_Course_Info(loc_Course_Info);
	}

	/**
	* Deletes the loc_ course_ info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info that was removed
	* @throws PortalException if a loc_ course_ info with the primary key could not be found
	*/
	public static com.ddt.model.Loc_Course_Info deleteLoc_Course_Info(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLoc_Course_Info(id);
	}

	public static com.ddt.model.Loc_Course_Info fetchLoc_Course_Info(long id) {
		return getService().fetchLoc_Course_Info(id);
	}

	/**
	* Returns the loc_ course_ info with the matching UUID and company.
	*
	* @param uuid the loc_ course_ info's UUID
	* @param companyId the primary key of the company
	* @return the matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	public static com.ddt.model.Loc_Course_Info fetchLoc_Course_InfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .fetchLoc_Course_InfoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the loc_ course_ info with the primary key.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info
	* @throws PortalException if a loc_ course_ info with the primary key could not be found
	*/
	public static com.ddt.model.Loc_Course_Info getLoc_Course_Info(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLoc_Course_Info(id);
	}

	/**
	* Returns the loc_ course_ info with the matching UUID and company.
	*
	* @param uuid the loc_ course_ info's UUID
	* @param companyId the primary key of the company
	* @return the matching loc_ course_ info
	* @throws PortalException if a matching loc_ course_ info could not be found
	*/
	public static com.ddt.model.Loc_Course_Info getLoc_Course_InfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLoc_Course_InfoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the loc_ course_ info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loc_Course_Info the loc_ course_ info
	* @return the loc_ course_ info that was updated
	*/
	public static com.ddt.model.Loc_Course_Info updateLoc_Course_Info(
		com.ddt.model.Loc_Course_Info loc_Course_Info) {
		return getService().updateLoc_Course_Info(loc_Course_Info);
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
	* Returns the number of loc_ course_ infos.
	*
	* @return the number of loc_ course_ infos
	*/
	public static int getLoc_Course_InfosCount() {
		return getService().getLoc_Course_InfosCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the loc_ course_ infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @return the range of loc_ course_ infos
	*/
	public static java.util.List<com.ddt.model.Loc_Course_Info> getLoc_Course_Infos(
		int start, int end) {
		return getService().getLoc_Course_Infos(start, end);
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

	public static Loc_Course_InfoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Loc_Course_InfoLocalService, Loc_Course_InfoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Loc_Course_InfoLocalService.class);
}