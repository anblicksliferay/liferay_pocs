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
 * Provides a wrapper for {@link WFMS_Position_AuditLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position_AuditLocalService
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditLocalServiceWrapper
	implements WFMS_Position_AuditLocalService,
		ServiceWrapper<WFMS_Position_AuditLocalService> {
	public WFMS_Position_AuditLocalServiceWrapper(
		WFMS_Position_AuditLocalService wfms_Position_AuditLocalService) {
		_wfms_Position_AuditLocalService = wfms_Position_AuditLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_Position_AuditLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Position_AuditLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Position_AuditLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_Position_Audit to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Position_Audit the WFMS_Position_Audit
	* @return the WFMS_Position_Audit that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit addWFMS_Position_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit wfms_Position_Audit) {
		return _wfms_Position_AuditLocalService.addWFMS_Position_Audit(wfms_Position_Audit);
	}

	/**
	* Creates a new WFMS_Position_Audit with the primary key. Does not add the WFMS_Position_Audit to the database.
	*
	* @param paId the primary key for the new WFMS_Position_Audit
	* @return the new WFMS_Position_Audit
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit createWFMS_Position_Audit(
		java.lang.String paId) {
		return _wfms_Position_AuditLocalService.createWFMS_Position_Audit(paId);
	}

	/**
	* Deletes the WFMS_Position_Audit from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Position_Audit the WFMS_Position_Audit
	* @return the WFMS_Position_Audit that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit deleteWFMS_Position_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit wfms_Position_Audit) {
		return _wfms_Position_AuditLocalService.deleteWFMS_Position_Audit(wfms_Position_Audit);
	}

	/**
	* Deletes the WFMS_Position_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param paId the primary key of the WFMS_Position_Audit
	* @return the WFMS_Position_Audit that was removed
	* @throws PortalException if a WFMS_Position_Audit with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit deleteWFMS_Position_Audit(
		java.lang.String paId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Position_AuditLocalService.deleteWFMS_Position_Audit(paId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit fetchWFMS_Position_Audit(
		java.lang.String paId) {
		return _wfms_Position_AuditLocalService.fetchWFMS_Position_Audit(paId);
	}

	/**
	* Returns the WFMS_Position_Audit with the primary key.
	*
	* @param paId the primary key of the WFMS_Position_Audit
	* @return the WFMS_Position_Audit
	* @throws PortalException if a WFMS_Position_Audit with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit getWFMS_Position_Audit(
		java.lang.String paId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Position_AuditLocalService.getWFMS_Position_Audit(paId);
	}

	/**
	* Updates the WFMS_Position_Audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Position_Audit the WFMS_Position_Audit
	* @return the WFMS_Position_Audit that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit updateWFMS_Position_Audit(
		com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit wfms_Position_Audit) {
		return _wfms_Position_AuditLocalService.updateWFMS_Position_Audit(wfms_Position_Audit);
	}

	/**
	* Returns the number of WFMS_Position_Audits.
	*
	* @return the number of WFMS_Position_Audits
	*/
	@Override
	public int getWFMS_Position_AuditsCount() {
		return _wfms_Position_AuditLocalService.getWFMS_Position_AuditsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_Position_AuditLocalService.getOSGiServiceIdentifier();
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
		return _wfms_Position_AuditLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_Position_AuditLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_Position_AuditLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit> findByPosIdForAudit(
		java.lang.String pId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_Position_AuditLocalService.findByPosIdForAudit(pId);
	}

	/**
	* Returns a range of all the WFMS_Position_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @return the range of WFMS_Position_Audits
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit> getWFMS_Position_Audits(
		int start, int end) {
		return _wfms_Position_AuditLocalService.getWFMS_Position_Audits(start,
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
		return _wfms_Position_AuditLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_Position_AuditLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_Position_AuditLocalService getWrappedService() {
		return _wfms_Position_AuditLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_Position_AuditLocalService wfms_Position_AuditLocalService) {
		_wfms_Position_AuditLocalService = wfms_Position_AuditLocalService;
	}

	private WFMS_Position_AuditLocalService _wfms_Position_AuditLocalService;
}