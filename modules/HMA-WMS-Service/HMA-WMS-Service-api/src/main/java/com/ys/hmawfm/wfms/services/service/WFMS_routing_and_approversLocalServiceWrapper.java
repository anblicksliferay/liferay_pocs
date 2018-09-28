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
 * Provides a wrapper for {@link WFMS_routing_and_approversLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_routing_and_approversLocalService
 * @generated
 */
@ProviderType
public class WFMS_routing_and_approversLocalServiceWrapper
	implements WFMS_routing_and_approversLocalService,
		ServiceWrapper<WFMS_routing_and_approversLocalService> {
	public WFMS_routing_and_approversLocalServiceWrapper(
		WFMS_routing_and_approversLocalService wfms_routing_and_approversLocalService) {
		_wfms_routing_and_approversLocalService = wfms_routing_and_approversLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_routing_and_approversLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_routing_and_approversLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_routing_and_approversLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_routing_and_approvers to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers addWFMS_routing_and_approvers(
		com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers wfms_routing_and_approvers) {
		return _wfms_routing_and_approversLocalService.addWFMS_routing_and_approvers(wfms_routing_and_approvers);
	}

	/**
	* Creates a new WFMS_routing_and_approvers with the primary key. Does not add the WFMS_routing_and_approvers to the database.
	*
	* @param rapId the primary key for the new WFMS_routing_and_approvers
	* @return the new WFMS_routing_and_approvers
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers createWFMS_routing_and_approvers(
		java.lang.String rapId) {
		return _wfms_routing_and_approversLocalService.createWFMS_routing_and_approvers(rapId);
	}

	/**
	* Deletes the WFMS_routing_and_approvers from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers deleteWFMS_routing_and_approvers(
		com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers wfms_routing_and_approvers) {
		return _wfms_routing_and_approversLocalService.deleteWFMS_routing_and_approvers(wfms_routing_and_approvers);
	}

	/**
	* Deletes the WFMS_routing_and_approvers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was removed
	* @throws PortalException if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers deleteWFMS_routing_and_approvers(
		java.lang.String rapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_routing_and_approversLocalService.deleteWFMS_routing_and_approvers(rapId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers fetchWFMS_routing_and_approvers(
		java.lang.String rapId) {
		return _wfms_routing_and_approversLocalService.fetchWFMS_routing_and_approvers(rapId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers findByrouting(
		java.lang.String rapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_routing_and_approversException {
		return _wfms_routing_and_approversLocalService.findByrouting(rapId);
	}

	/**
	* Returns the WFMS_routing_and_approvers with the primary key.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers
	* @throws PortalException if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers getWFMS_routing_and_approvers(
		java.lang.String rapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_routing_and_approversLocalService.getWFMS_routing_and_approvers(rapId);
	}

	/**
	* Updates the WFMS_routing_and_approvers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers updateWFMS_routing_and_approvers(
		com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers wfms_routing_and_approvers) {
		return _wfms_routing_and_approversLocalService.updateWFMS_routing_and_approvers(wfms_routing_and_approvers);
	}

	/**
	* Returns the number of WFMS_routing_and_approverses.
	*
	* @return the number of WFMS_routing_and_approverses
	*/
	@Override
	public int getWFMS_routing_and_approversesCount() {
		return _wfms_routing_and_approversLocalService.getWFMS_routing_and_approversesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_routing_and_approversLocalService.getOSGiServiceIdentifier();
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
		return _wfms_routing_and_approversLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_routing_and_approversLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_routing_and_approversLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the WFMS_routing_and_approverses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_routing_and_approverses
	* @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	* @return the range of WFMS_routing_and_approverses
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers> getWFMS_routing_and_approverses(
		int start, int end) {
		return _wfms_routing_and_approversLocalService.getWFMS_routing_and_approverses(start,
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
		return _wfms_routing_and_approversLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_routing_and_approversLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_routing_and_approversLocalService getWrappedService() {
		return _wfms_routing_and_approversLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_routing_and_approversLocalService wfms_routing_and_approversLocalService) {
		_wfms_routing_and_approversLocalService = wfms_routing_and_approversLocalService;
	}

	private WFMS_routing_and_approversLocalService _wfms_routing_and_approversLocalService;
}