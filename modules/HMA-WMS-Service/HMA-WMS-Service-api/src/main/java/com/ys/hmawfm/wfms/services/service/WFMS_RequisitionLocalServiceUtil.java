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
 * Provides the local service utility for WFMS_Requisition. This utility wraps
 * {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_RequisitionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_RequisitionLocalService
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_RequisitionLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_RequisitionLocalServiceImpl
 * @generated
 */
@ProviderType
public class WFMS_RequisitionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_RequisitionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the WFMS_Requisition to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was added
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition addWFMS_Requisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition wfms_Requisition) {
		return getService().addWFMS_Requisition(wfms_Requisition);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition addnewRequisition(
		java.lang.String rwfid, long companyId, long scopeGroupId,
		java.lang.String Number, java.lang.String associatenumber,
		java.lang.String associatename, java.lang.String status,
		java.lang.String postingType, java.lang.String teamNumber,
		java.lang.String associatetype, java.lang.String shiftDesc,
		java.lang.String howAvailable, java.lang.String whoReplaced,
		java.lang.String dateneeded, java.lang.String contactperson,
		java.lang.String contactphonenumber, java.lang.String taleonumber,
		java.lang.String other, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addnewRequisition(rwfid, companyId, scopeGroupId, Number,
			associatenumber, associatename, status, postingType, teamNumber,
			associatetype, shiftDesc, howAvailable, whoReplaced, dateneeded,
			contactperson, contactphonenumber, taleonumber, other, comments);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition addnewtempRequisition(
		java.lang.String rwfid, java.lang.String requisisionnumber,
		long companyId, long scopeGroupId, java.lang.String Number,
		java.lang.String associatenumber, java.lang.String associatename,
		java.lang.String status, java.lang.String postingType,
		java.lang.String teamNumber, java.lang.String associatetype,
		java.lang.String shiftDesc, java.lang.String howAvailable,
		java.lang.String whoReplaced, java.lang.String dateneeded,
		java.lang.String contactperson, java.lang.String contactphonenumber,
		java.lang.String taleonumber, java.lang.String other)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addnewtempRequisition(rwfid, requisisionnumber, companyId,
			scopeGroupId, Number, associatenumber, associatename, status,
			postingType, teamNumber, associatetype, shiftDesc, howAvailable,
			whoReplaced, dateneeded, contactperson, contactphonenumber,
			taleonumber, other);
	}

	/**
	* Creates a new WFMS_Requisition with the primary key. Does not add the WFMS_Requisition to the database.
	*
	* @param rwfId the primary key for the new WFMS_Requisition
	* @return the new WFMS_Requisition
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition createWFMS_Requisition(
		java.lang.String rwfId) {
		return getService().createWFMS_Requisition(rwfId);
	}

	/**
	* Deletes the WFMS_Requisition from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition deleteWFMS_Requisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition wfms_Requisition) {
		return getService().deleteWFMS_Requisition(wfms_Requisition);
	}

	/**
	* Deletes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	* @throws PortalException if a WFMS_Requisition with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition deleteWFMS_Requisition(
		java.lang.String rwfId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWFMS_Requisition(rwfId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition fetchWFMS_Requisition(
		java.lang.String rwfId) {
		return getService().fetchWFMS_Requisition(rwfId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition findByposition(
		java.lang.String rId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getService().findByposition(rId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition findBypositionassociate(
		java.lang.String Number, java.lang.String associatenumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getService().findBypositionassociate(Number, associatenumber);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition findByrequisition(
		java.lang.String rwfId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getService().findByrequisition(rwfId);
	}

	/**
	* Returns the WFMS_Requisition with the primary key.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition
	* @throws PortalException if a WFMS_Requisition with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition getWFMS_Requisition(
		java.lang.String rwfId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWFMS_Requisition(rwfId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition updateRequisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRequisition(entry);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition updateRequisition(
		java.lang.String requisisionnumber, long companyId, long scopeGroupId,
		java.lang.String number, java.lang.String associatenumber,
		java.lang.String associateNameNoNum, java.lang.String status,
		java.lang.String postingType, java.lang.String teamNumber,
		java.lang.String associatetype, java.lang.String shiftDesc,
		java.lang.String howAvilable, java.lang.String whoReplaced,
		java.lang.String dateneeded, java.lang.String contactperson,
		java.lang.String contactphonenumber, java.lang.String taleonumber,
		java.lang.String other, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRequisition(requisisionnumber, companyId,
			scopeGroupId, number, associatenumber, associateNameNoNum, status,
			postingType, teamNumber, associatetype, shiftDesc, howAvilable,
			whoReplaced, dateneeded, contactperson, contactphonenumber,
			taleonumber, other, comments);
	}

	/**
	* Updates the WFMS_Requisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was updated
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Requisition updateWFMS_Requisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition wfms_Requisition) {
		return getService().updateWFMS_Requisition(wfms_Requisition);
	}

	/**
	* Returns the number of WFMS_Requisitions.
	*
	* @return the number of WFMS_Requisitions
	*/
	public static int getWFMS_RequisitionsCount() {
		return getService().getWFMS_RequisitionsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByNextApprover(
		java.lang.String nextapprove)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByNextApprover(nextapprove);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleOfApprover(roleOfApprover);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus_Pid_Colllection(status, rId);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBydummy(
		java.lang.String dummy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBydummy(dummy);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionId(
		java.lang.String rId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getService().findBypositionId(rId);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBypositionIdGetByStaus(status);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionnumber(
		java.lang.String Number)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getService().findBypositionnumber(Number);
	}

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByworkflowId(workflowId);
	}

	/**
	* Returns a range of all the WFMS_Requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of WFMS_Requisitions
	*/
	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> getWFMS_Requisitions(
		int start, int end) {
		return getService().getWFMS_Requisitions(start, end);
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

	public static void clearCache()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearCache();
	}

	public static WFMS_RequisitionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_RequisitionLocalService, WFMS_RequisitionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_RequisitionLocalService.class);
}