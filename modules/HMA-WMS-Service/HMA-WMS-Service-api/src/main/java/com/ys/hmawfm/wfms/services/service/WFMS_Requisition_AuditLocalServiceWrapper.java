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
 * Provides a wrapper for {@link WFMS_Requisition_AuditLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_AuditLocalService
 * @generated
 */
@ProviderType
public class WFMS_Requisition_AuditLocalServiceWrapper
	implements WFMS_Requisition_AuditLocalService,
		ServiceWrapper<WFMS_Requisition_AuditLocalService> {
	public WFMS_Requisition_AuditLocalServiceWrapper(
		WFMS_Requisition_AuditLocalService wfms_Requisition_AuditLocalService) {
		_wfms_Requisition_AuditLocalService = wfms_Requisition_AuditLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_Requisition_AuditLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Requisition_AuditLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Requisition_AuditLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_Requisition_Audit to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition_Audit the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit addWFMS_Requisition_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit wfms_Requisition_Audit) {
		return _wfms_Requisition_AuditLocalService.addWFMS_Requisition_Audit(wfms_Requisition_Audit);
	}

	/**
	* Creates a new WFMS_Requisition_Audit with the primary key. Does not add the WFMS_Requisition_Audit to the database.
	*
	* @param reqaId the primary key for the new WFMS_Requisition_Audit
	* @return the new WFMS_Requisition_Audit
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit createWFMS_Requisition_Audit(
		java.lang.String reqaId) {
		return _wfms_Requisition_AuditLocalService.createWFMS_Requisition_Audit(reqaId);
	}

	/**
	* Deletes the WFMS_Requisition_Audit from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition_Audit the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit deleteWFMS_Requisition_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit wfms_Requisition_Audit) {
		return _wfms_Requisition_AuditLocalService.deleteWFMS_Requisition_Audit(wfms_Requisition_Audit);
	}

	/**
	* Deletes the WFMS_Requisition_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reqaId the primary key of the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit that was removed
	* @throws PortalException if a WFMS_Requisition_Audit with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit deleteWFMS_Requisition_Audit(
		java.lang.String reqaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Requisition_AuditLocalService.deleteWFMS_Requisition_Audit(reqaId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit fetchWFMS_Requisition_Audit(
		java.lang.String reqaId) {
		return _wfms_Requisition_AuditLocalService.fetchWFMS_Requisition_Audit(reqaId);
	}

	/**
	* Returns the WFMS_Requisition_Audit with the primary key.
	*
	* @param reqaId the primary key of the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit
	* @throws PortalException if a WFMS_Requisition_Audit with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit getWFMS_Requisition_Audit(
		java.lang.String reqaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Requisition_AuditLocalService.getWFMS_Requisition_Audit(reqaId);
	}

	/**
	* Updates the WFMS_Requisition_Audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition_Audit the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit updateWFMS_Requisition_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit wfms_Requisition_Audit) {
		return _wfms_Requisition_AuditLocalService.updateWFMS_Requisition_Audit(wfms_Requisition_Audit);
	}

	/**
	* Returns the number of WFMS_Requisition_Audits.
	*
	* @return the number of WFMS_Requisition_Audits
	*/
	@Override
	public int getWFMS_Requisition_AuditsCount() {
		return _wfms_Requisition_AuditLocalService.getWFMS_Requisition_AuditsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_Requisition_AuditLocalService.getOSGiServiceIdentifier();
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
		return _wfms_Requisition_AuditLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_Requisition_AuditLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_Requisition_AuditLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit> findByReqIdForAudit(
		java.lang.String reqId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_Requisition_AuditLocalService.findByReqIdForAudit(reqId);
	}

	/**
	* Returns a range of all the WFMS_Requisition_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @return the range of WFMS_Requisition_Audits
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit> getWFMS_Requisition_Audits(
		int start, int end) {
		return _wfms_Requisition_AuditLocalService.getWFMS_Requisition_Audits(start,
			end);
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
		return _wfms_Requisition_AuditLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_Requisition_AuditLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_Requisition_AuditLocalService getWrappedService() {
		return _wfms_Requisition_AuditLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_Requisition_AuditLocalService wfms_Requisition_AuditLocalService) {
		_wfms_Requisition_AuditLocalService = wfms_Requisition_AuditLocalService;
	}

	private WFMS_Requisition_AuditLocalService _wfms_Requisition_AuditLocalService;
}