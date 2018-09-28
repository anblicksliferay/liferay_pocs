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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WFMS_RequisitionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_RequisitionLocalService
 * @generated
 */
@ProviderType
public class WFMS_RequisitionLocalServiceWrapper
	implements WFMS_RequisitionLocalService,
		ServiceWrapper<WFMS_RequisitionLocalService> {
	public WFMS_RequisitionLocalServiceWrapper(
		WFMS_RequisitionLocalService wfms_RequisitionLocalService) {
		_wfms_RequisitionLocalService = wfms_RequisitionLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_RequisitionLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_RequisitionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_RequisitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_Requisition to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition addWFMS_Requisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition wfms_Requisition) {
		return _wfms_RequisitionLocalService.addWFMS_Requisition(wfms_Requisition);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition addnewRequisition(
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
		return _wfms_RequisitionLocalService.addnewRequisition(rwfid,
			companyId, scopeGroupId, Number, associatenumber, associatename,
			status, postingType, teamNumber, associatetype, shiftDesc,
			howAvailable, whoReplaced, dateneeded, contactperson,
			contactphonenumber, taleonumber, other, comments);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition addnewtempRequisition(
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
		return _wfms_RequisitionLocalService.addnewtempRequisition(rwfid,
			requisisionnumber, companyId, scopeGroupId, Number,
			associatenumber, associatename, status, postingType, teamNumber,
			associatetype, shiftDesc, howAvailable, whoReplaced, dateneeded,
			contactperson, contactphonenumber, taleonumber, other);
	}

	/**
	* Creates a new WFMS_Requisition with the primary key. Does not add the WFMS_Requisition to the database.
	*
	* @param rwfId the primary key for the new WFMS_Requisition
	* @return the new WFMS_Requisition
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition createWFMS_Requisition(
		java.lang.String rwfId) {
		return _wfms_RequisitionLocalService.createWFMS_Requisition(rwfId);
	}

	/**
	* Deletes the WFMS_Requisition from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition deleteWFMS_Requisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition wfms_Requisition) {
		return _wfms_RequisitionLocalService.deleteWFMS_Requisition(wfms_Requisition);
	}

	/**
	* Deletes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	* @throws PortalException if a WFMS_Requisition with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition deleteWFMS_Requisition(
		java.lang.String rwfId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_RequisitionLocalService.deleteWFMS_Requisition(rwfId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition fetchWFMS_Requisition(
		java.lang.String rwfId) {
		return _wfms_RequisitionLocalService.fetchWFMS_Requisition(rwfId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition findByposition(
		java.lang.String rId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return _wfms_RequisitionLocalService.findByposition(rId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition findBypositionassociate(
		java.lang.String Number, java.lang.String associatenumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return _wfms_RequisitionLocalService.findBypositionassociate(Number,
			associatenumber);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition findByrequisition(
		java.lang.String rwfId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return _wfms_RequisitionLocalService.findByrequisition(rwfId);
	}

	/**
	* Returns the WFMS_Requisition with the primary key.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition
	* @throws PortalException if a WFMS_Requisition with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition getWFMS_Requisition(
		java.lang.String rwfId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_RequisitionLocalService.getWFMS_Requisition(rwfId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition updateRequisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.updateRequisition(entry);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition updateRequisition(
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
		return _wfms_RequisitionLocalService.updateRequisition(requisisionnumber,
			companyId, scopeGroupId, number, associatenumber,
			associateNameNoNum, status, postingType, teamNumber, associatetype,
			shiftDesc, howAvilable, whoReplaced, dateneeded, contactperson,
			contactphonenumber, taleonumber, other, comments);
	}

	/**
	* Updates the WFMS_Requisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition updateWFMS_Requisition(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition wfms_Requisition) {
		return _wfms_RequisitionLocalService.updateWFMS_Requisition(wfms_Requisition);
	}

	/**
	* Returns the number of WFMS_Requisitions.
	*
	* @return the number of WFMS_Requisitions
	*/
	@Override
	public int getWFMS_RequisitionsCount() {
		return _wfms_RequisitionLocalService.getWFMS_RequisitionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_RequisitionLocalService.getOSGiServiceIdentifier();
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
		return _wfms_RequisitionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _wfms_RequisitionLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _wfms_RequisitionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByNextApprover(
		java.lang.String nextapprove)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.findByNextApprover(nextapprove);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.findByRoleOfApprover(roleOfApprover);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.findByStatus_Pid_Colllection(status,
			rId);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBydummy(
		java.lang.String dummy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.findBydummy(dummy);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionId(
		java.lang.String rId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return _wfms_RequisitionLocalService.findBypositionId(rId);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.findBypositionIdGetByStaus(status);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionnumber(
		java.lang.String Number)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return _wfms_RequisitionLocalService.findBypositionnumber(Number);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_RequisitionLocalService.findByworkflowId(workflowId);
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
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> getWFMS_Requisitions(
		int start, int end) {
		return _wfms_RequisitionLocalService.getWFMS_Requisitions(start, end);
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
		return _wfms_RequisitionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_RequisitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public void clearCache()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wfms_RequisitionLocalService.clearCache();
	}

	@Override
	public WFMS_RequisitionLocalService getWrappedService() {
		return _wfms_RequisitionLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_RequisitionLocalService wfms_RequisitionLocalService) {
		_wfms_RequisitionLocalService = wfms_RequisitionLocalService;
	}

	private WFMS_RequisitionLocalService _wfms_RequisitionLocalService;
}