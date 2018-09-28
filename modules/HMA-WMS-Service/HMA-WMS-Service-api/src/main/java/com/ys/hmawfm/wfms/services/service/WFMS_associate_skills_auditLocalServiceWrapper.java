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
 * Provides a wrapper for {@link WFMS_associate_skills_auditLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_auditLocalService
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditLocalServiceWrapper
	implements WFMS_associate_skills_auditLocalService,
		ServiceWrapper<WFMS_associate_skills_auditLocalService> {
	public WFMS_associate_skills_auditLocalServiceWrapper(
		WFMS_associate_skills_auditLocalService wfms_associate_skills_auditLocalService) {
		_wfms_associate_skills_auditLocalService = wfms_associate_skills_auditLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _wfms_associate_skills_auditLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_associate_skills_auditLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _wfms_associate_skills_auditLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_associate_skills_auditLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_associate_skills_auditLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_associate_skills_audit to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_associate_skills_audit the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit addWFMS_associate_skills_audit(
		com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit wfms_associate_skills_audit) {
		return _wfms_associate_skills_auditLocalService.addWFMS_associate_skills_audit(wfms_associate_skills_audit);
	}

	/**
	* Creates a new WFMS_associate_skills_audit with the primary key. Does not add the WFMS_associate_skills_audit to the database.
	*
	* @param associate_log_id the primary key for the new WFMS_associate_skills_audit
	* @return the new WFMS_associate_skills_audit
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit createWFMS_associate_skills_audit(
		long associate_log_id) {
		return _wfms_associate_skills_auditLocalService.createWFMS_associate_skills_audit(associate_log_id);
	}

	/**
	* Deletes the WFMS_associate_skills_audit from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_associate_skills_audit the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit deleteWFMS_associate_skills_audit(
		com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit wfms_associate_skills_audit) {
		return _wfms_associate_skills_auditLocalService.deleteWFMS_associate_skills_audit(wfms_associate_skills_audit);
	}

	/**
	* Deletes the WFMS_associate_skills_audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associate_log_id the primary key of the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit that was removed
	* @throws PortalException if a WFMS_associate_skills_audit with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit deleteWFMS_associate_skills_audit(
		long associate_log_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_associate_skills_auditLocalService.deleteWFMS_associate_skills_audit(associate_log_id);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit fetchWFMS_associate_skills_audit(
		long associate_log_id) {
		return _wfms_associate_skills_auditLocalService.fetchWFMS_associate_skills_audit(associate_log_id);
	}

	/**
	* Returns the WFMS_associate_skills_audit with the primary key.
	*
	* @param associate_log_id the primary key of the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit
	* @throws PortalException if a WFMS_associate_skills_audit with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit getWFMS_associate_skills_audit(
		long associate_log_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_associate_skills_auditLocalService.getWFMS_associate_skills_audit(associate_log_id);
	}

	/**
	* Updates the WFMS_associate_skills_audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_associate_skills_audit the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit updateWFMS_associate_skills_audit(
		com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit wfms_associate_skills_audit) {
		return _wfms_associate_skills_auditLocalService.updateWFMS_associate_skills_audit(wfms_associate_skills_audit);
	}

	/**
	* Returns the number of WFMS_associate_skills_audits.
	*
	* @return the number of WFMS_associate_skills_audits
	*/
	@Override
	public int getWFMS_associate_skills_auditsCount() {
		return _wfms_associate_skills_auditLocalService.getWFMS_associate_skills_auditsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_associate_skills_auditLocalService.getOSGiServiceIdentifier();
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
		return _wfms_associate_skills_auditLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_associate_skills_auditLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_associate_skills_auditLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the WFMS_associate_skills_audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skills_audits
	* @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	* @return the range of WFMS_associate_skills_audits
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit> getWFMS_associate_skills_audits(
		int start, int end) {
		return _wfms_associate_skills_auditLocalService.getWFMS_associate_skills_audits(start,
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
		return _wfms_associate_skills_auditLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_associate_skills_auditLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_associate_skills_auditLocalService getWrappedService() {
		return _wfms_associate_skills_auditLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_associate_skills_auditLocalService wfms_associate_skills_auditLocalService) {
		_wfms_associate_skills_auditLocalService = wfms_associate_skills_auditLocalService;
	}

	private WFMS_associate_skills_auditLocalService _wfms_associate_skills_auditLocalService;
}