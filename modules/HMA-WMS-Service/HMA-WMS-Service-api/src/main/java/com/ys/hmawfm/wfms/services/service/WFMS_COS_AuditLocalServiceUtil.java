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
 * Provides the local service utility for WFMS_COS_Audit. This utility wraps
 * {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_COS_AuditLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS_AuditLocalService
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_COS_AuditLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_COS_AuditLocalServiceImpl
 * @generated
 */
@ProviderType
public class WFMS_COS_AuditLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_COS_AuditLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the WFMS_COS_Audit to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos_Audit the WFMS_COS_Audit
	* @return the WFMS_COS_Audit that was added
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit addWFMS_COS_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit wfms_cos_Audit) {
		return getService().addWFMS_COS_Audit(wfms_cos_Audit);
	}

	/**
	* Creates a new WFMS_COS_Audit with the primary key. Does not add the WFMS_COS_Audit to the database.
	*
	* @param cosaId the primary key for the new WFMS_COS_Audit
	* @return the new WFMS_COS_Audit
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit createWFMS_COS_Audit(
		java.lang.String cosaId) {
		return getService().createWFMS_COS_Audit(cosaId);
	}

	/**
	* Deletes the WFMS_COS_Audit from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos_Audit the WFMS_COS_Audit
	* @return the WFMS_COS_Audit that was removed
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit deleteWFMS_COS_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit wfms_cos_Audit) {
		return getService().deleteWFMS_COS_Audit(wfms_cos_Audit);
	}

	/**
	* Deletes the WFMS_COS_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cosaId the primary key of the WFMS_COS_Audit
	* @return the WFMS_COS_Audit that was removed
	* @throws PortalException if a WFMS_COS_Audit with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit deleteWFMS_COS_Audit(
		java.lang.String cosaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWFMS_COS_Audit(cosaId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit fetchWFMS_COS_Audit(
		java.lang.String cosaId) {
		return getService().fetchWFMS_COS_Audit(cosaId);
	}

	/**
	* Returns the WFMS_COS_Audit with the primary key.
	*
	* @param cosaId the primary key of the WFMS_COS_Audit
	* @return the WFMS_COS_Audit
	* @throws PortalException if a WFMS_COS_Audit with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit getWFMS_COS_Audit(
		java.lang.String cosaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWFMS_COS_Audit(cosaId);
	}

	/**
	* Updates the WFMS_COS_Audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos_Audit the WFMS_COS_Audit
	* @return the WFMS_COS_Audit that was updated
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit updateWFMS_COS_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit wfms_cos_Audit) {
		return getService().updateWFMS_COS_Audit(wfms_cos_Audit);
	}

	/**
	* Returns the number of WFMS_COS_Audits.
	*
	* @return the number of WFMS_COS_Audits
	*/
	public static int getWFMS_COS_AuditsCount() {
		return getService().getWFMS_COS_AuditsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit> findByCosIdForAudit(
		java.lang.String cosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCosIdForAudit(cosId);
	}

	/**
	* Returns a range of all the WFMS_COS_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @return the range of WFMS_COS_Audits
	*/
	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit> getWFMS_COS_Audits(
		int start, int end) {
		return getService().getWFMS_COS_Audits(start, end);
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

	public static WFMS_COS_AuditLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_COS_AuditLocalService, WFMS_COS_AuditLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_COS_AuditLocalService.class);
}