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
 * Provides a wrapper for {@link WFMS_COSLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSLocalService
 * @generated
 */
@ProviderType
public class WFMS_COSLocalServiceWrapper implements WFMS_COSLocalService,
	ServiceWrapper<WFMS_COSLocalService> {
	public WFMS_COSLocalServiceWrapper(
		WFMS_COSLocalService wfms_cosLocalService) {
		_wfms_cosLocalService = wfms_cosLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_cosLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_cosLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_cosLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS addNewCos(
		long companyId, long scopeGroupId, java.lang.String createdBy,
		java.lang.String assoicateId, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.addNewCos(companyId, scopeGroupId,
			createdBy, assoicateId, comments);
	}

	/**
	* Adds the WFMS_COS to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos the WFMS_COS
	* @return the WFMS_COS that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS addWFMS_COS(
		com.ys.hmawfm.wfms.services.model.WFMS_COS wfms_cos) {
		return _wfms_cosLocalService.addWFMS_COS(wfms_cos);
	}

	/**
	* Creates a new WFMS_COS with the primary key. Does not add the WFMS_COS to the database.
	*
	* @param cosId the primary key for the new WFMS_COS
	* @return the new WFMS_COS
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS createWFMS_COS(
		java.lang.String cosId) {
		return _wfms_cosLocalService.createWFMS_COS(cosId);
	}

	/**
	* Deletes the WFMS_COS from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos the WFMS_COS
	* @return the WFMS_COS that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS deleteWFMS_COS(
		com.ys.hmawfm.wfms.services.model.WFMS_COS wfms_cos) {
		return _wfms_cosLocalService.deleteWFMS_COS(wfms_cos);
	}

	/**
	* Deletes the WFMS_COS with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS that was removed
	* @throws PortalException if a WFMS_COS with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS deleteWFMS_COS(
		java.lang.String cosId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_cosLocalService.deleteWFMS_COS(cosId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS fetchWFMS_COS(
		java.lang.String cosId) {
		return _wfms_cosLocalService.fetchWFMS_COS(cosId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS findByassociateId(
		java.lang.String assoicateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return _wfms_cosLocalService.findByassociateId(assoicateId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS findBycos(
		java.lang.String cosId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return _wfms_cosLocalService.findBycos(cosId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS getByAssociatenumber(
		java.lang.String associatenumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return _wfms_cosLocalService.getByAssociatenumber(associatenumber);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS getByCOSId(
		java.lang.String cosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.getByCOSId(cosId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS getByCOSId(long cosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.getByCOSId(cosId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS getByCos(
		java.lang.String cosId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return _wfms_cosLocalService.getByCos(cosId);
	}

	/**
	* Returns the WFMS_COS with the primary key.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS
	* @throws PortalException if a WFMS_COS with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS getWFMS_COS(
		java.lang.String cosId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_cosLocalService.getWFMS_COS(cosId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS updateCos(
		com.ys.hmawfm.wfms.services.model.WFMS_COS entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.updateCos(entry);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS updateCos(
		java.lang.String cosId, long companyId, long scopeGroupId,
		java.lang.String createdBy, java.lang.String action,
		java.lang.String associatenumber, java.lang.String comments,
		java.lang.String associateTitle, java.lang.String assoicateId,
		java.lang.String departmentNumber, java.lang.String positionNumber,
		java.lang.String leadershipAssignment, java.lang.String number,
		java.lang.String status, java.lang.String manpowerReq,
		java.lang.String nextApprover, java.lang.String routingProcess,
		java.lang.String notificationTo)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _wfms_cosLocalService.updateCos(cosId, companyId, scopeGroupId,
			createdBy, action, associatenumber, comments, associateTitle,
			assoicateId, departmentNumber, positionNumber,
			leadershipAssignment, number, status, manpowerReq, nextApprover,
			routingProcess, notificationTo);
	}

	/**
	* Updates the WFMS_COS in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos the WFMS_COS
	* @return the WFMS_COS that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_COS updateWFMS_COS(
		com.ys.hmawfm.wfms.services.model.WFMS_COS wfms_cos) {
		return _wfms_cosLocalService.updateWFMS_COS(wfms_cos);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position getByPositionId(
		java.lang.String positionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.getByPositionId(positionId);
	}

	/**
	* Returns the number of WFMS_COSs.
	*
	* @return the number of WFMS_COSs
	*/
	@Override
	public int getWFMS_COSsCount() {
		return _wfms_cosLocalService.getWFMS_COSsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_cosLocalService.getOSGiServiceIdentifier();
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
		return _wfms_cosLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_cosLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_cosLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findByAssociatenumber(
		java.lang.String associatenumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.findByAssociatenumber(associatenumber);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findByNextApprover(
		java.lang.String nextApprover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.findByNextApprover(nextApprover);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.findByRoleOfApprover(roleOfApprover);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.findBycosIdGetByPosId(positionNumber);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return _wfms_cosLocalService.findBynewPositionNumber(newPositionNumber);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.findBypositionIdGetByStaus(status);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_cosLocalService.getAll();
	}

	/**
	* Returns a range of all the WFMS_COSs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of WFMS_COSs
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> getWFMS_COSs(
		int start, int end) {
		return _wfms_cosLocalService.getWFMS_COSs(start, end);
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
		return _wfms_cosLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_cosLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public WFMS_COSLocalService getWrappedService() {
		return _wfms_cosLocalService;
	}

	@Override
	public void setWrappedService(WFMS_COSLocalService wfms_cosLocalService) {
		_wfms_cosLocalService = wfms_cosLocalService;
	}

	private WFMS_COSLocalService _wfms_cosLocalService;
}