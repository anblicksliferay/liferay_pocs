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
 * Provides a wrapper for {@link WFMS_action_and_reasoncodeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_and_reasoncodeLocalService
 * @generated
 */
@ProviderType
public class WFMS_action_and_reasoncodeLocalServiceWrapper
	implements WFMS_action_and_reasoncodeLocalService,
		ServiceWrapper<WFMS_action_and_reasoncodeLocalService> {
	public WFMS_action_and_reasoncodeLocalServiceWrapper(
		WFMS_action_and_reasoncodeLocalService wfms_action_and_reasoncodeLocalService) {
		_wfms_action_and_reasoncodeLocalService = wfms_action_and_reasoncodeLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_action_and_reasoncodeLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_action_and_reasoncodeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_action_and_reasoncodeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_action_and_reasoncode to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_action_and_reasoncode the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode addWFMS_action_and_reasoncode(
		com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		return _wfms_action_and_reasoncodeLocalService.addWFMS_action_and_reasoncode(wfms_action_and_reasoncode);
	}

	/**
	* Creates a new WFMS_action_and_reasoncode with the primary key. Does not add the WFMS_action_and_reasoncode to the database.
	*
	* @param aarId the primary key for the new WFMS_action_and_reasoncode
	* @return the new WFMS_action_and_reasoncode
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode createWFMS_action_and_reasoncode(
		java.lang.String aarId) {
		return _wfms_action_and_reasoncodeLocalService.createWFMS_action_and_reasoncode(aarId);
	}

	/**
	* Deletes the WFMS_action_and_reasoncode from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_action_and_reasoncode the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode deleteWFMS_action_and_reasoncode(
		com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		return _wfms_action_and_reasoncodeLocalService.deleteWFMS_action_and_reasoncode(wfms_action_and_reasoncode);
	}

	/**
	* Deletes the WFMS_action_and_reasoncode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aarId the primary key of the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode that was removed
	* @throws PortalException if a WFMS_action_and_reasoncode with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode deleteWFMS_action_and_reasoncode(
		java.lang.String aarId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_action_and_reasoncodeLocalService.deleteWFMS_action_and_reasoncode(aarId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode fetchWFMS_action_and_reasoncode(
		java.lang.String aarId) {
		return _wfms_action_and_reasoncodeLocalService.fetchWFMS_action_and_reasoncode(aarId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode findByreasoncode(
		java.lang.String aarId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_action_and_reasoncodeException {
		return _wfms_action_and_reasoncodeLocalService.findByreasoncode(aarId);
	}

	/**
	* Returns the WFMS_action_and_reasoncode with the primary key.
	*
	* @param aarId the primary key of the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode
	* @throws PortalException if a WFMS_action_and_reasoncode with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode getWFMS_action_and_reasoncode(
		java.lang.String aarId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_action_and_reasoncodeLocalService.getWFMS_action_and_reasoncode(aarId);
	}

	/**
	* Updates the WFMS_action_and_reasoncode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_action_and_reasoncode the WFMS_action_and_reasoncode
	* @return the WFMS_action_and_reasoncode that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode updateWFMS_action_and_reasoncode(
		com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		return _wfms_action_and_reasoncodeLocalService.updateWFMS_action_and_reasoncode(wfms_action_and_reasoncode);
	}

	/**
	* Returns the number of WFMS_action_and_reasoncodes.
	*
	* @return the number of WFMS_action_and_reasoncodes
	*/
	@Override
	public int getWFMS_action_and_reasoncodesCount() {
		return _wfms_action_and_reasoncodeLocalService.getWFMS_action_and_reasoncodesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_action_and_reasoncodeLocalService.getOSGiServiceIdentifier();
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
		return _wfms_action_and_reasoncodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_action_and_reasoncodeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_action_and_reasoncodeLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the WFMS_action_and_reasoncodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_action_and_reasoncodes
	* @param end the upper bound of the range of WFMS_action_and_reasoncodes (not inclusive)
	* @return the range of WFMS_action_and_reasoncodes
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode> getWFMS_action_and_reasoncodes(
		int start, int end) {
		return _wfms_action_and_reasoncodeLocalService.getWFMS_action_and_reasoncodes(start,
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
		return _wfms_action_and_reasoncodeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_action_and_reasoncodeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_action_and_reasoncodeLocalService getWrappedService() {
		return _wfms_action_and_reasoncodeLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_action_and_reasoncodeLocalService wfms_action_and_reasoncodeLocalService) {
		_wfms_action_and_reasoncodeLocalService = wfms_action_and_reasoncodeLocalService;
	}

	private WFMS_action_and_reasoncodeLocalService _wfms_action_and_reasoncodeLocalService;
}