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
 * Provides a wrapper for {@link WFMS_Associate_HistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Associate_HistoryLocalService
 * @generated
 */
@ProviderType
public class WFMS_Associate_HistoryLocalServiceWrapper
	implements WFMS_Associate_HistoryLocalService,
		ServiceWrapper<WFMS_Associate_HistoryLocalService> {
	public WFMS_Associate_HistoryLocalServiceWrapper(
		WFMS_Associate_HistoryLocalService wfms_Associate_HistoryLocalService) {
		_wfms_Associate_HistoryLocalService = wfms_Associate_HistoryLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _wfms_Associate_HistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_Associate_HistoryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _wfms_Associate_HistoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Associate_HistoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Associate_HistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the WFMS_Associate_History to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	* @return the WFMS_Associate_History that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History addWFMS_Associate_History(
		com.ys.hmawfm.wfms.services.model.WFMS_Associate_History wfms_Associate_History) {
		return _wfms_Associate_HistoryLocalService.addWFMS_Associate_History(wfms_Associate_History);
	}

	/**
	* Creates a new WFMS_Associate_History with the primary key. Does not add the WFMS_Associate_History to the database.
	*
	* @param assocHistoryId the primary key for the new WFMS_Associate_History
	* @return the new WFMS_Associate_History
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History createWFMS_Associate_History(
		int assocHistoryId) {
		return _wfms_Associate_HistoryLocalService.createWFMS_Associate_History(assocHistoryId);
	}

	/**
	* Deletes the WFMS_Associate_History from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	* @return the WFMS_Associate_History that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History deleteWFMS_Associate_History(
		com.ys.hmawfm.wfms.services.model.WFMS_Associate_History wfms_Associate_History) {
		return _wfms_Associate_HistoryLocalService.deleteWFMS_Associate_History(wfms_Associate_History);
	}

	/**
	* Deletes the WFMS_Associate_History with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History that was removed
	* @throws PortalException if a WFMS_Associate_History with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History deleteWFMS_Associate_History(
		int assocHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Associate_HistoryLocalService.deleteWFMS_Associate_History(assocHistoryId);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History fetchWFMS_Associate_History(
		int assocHistoryId) {
		return _wfms_Associate_HistoryLocalService.fetchWFMS_Associate_History(assocHistoryId);
	}

	/**
	* Returns the WFMS_Associate_History with the primary key.
	*
	* @param assocHistoryId the primary key of the WFMS_Associate_History
	* @return the WFMS_Associate_History
	* @throws PortalException if a WFMS_Associate_History with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History getWFMS_Associate_History(
		int assocHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_Associate_HistoryLocalService.getWFMS_Associate_History(assocHistoryId);
	}

	/**
	* Updates the WFMS_Associate_History in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Associate_History the WFMS_Associate_History
	* @return the WFMS_Associate_History that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_Associate_History updateWFMS_Associate_History(
		com.ys.hmawfm.wfms.services.model.WFMS_Associate_History wfms_Associate_History) {
		return _wfms_Associate_HistoryLocalService.updateWFMS_Associate_History(wfms_Associate_History);
	}

	/**
	* Returns the number of WFMS_Associate_Histories.
	*
	* @return the number of WFMS_Associate_Histories
	*/
	@Override
	public int getWFMS_Associate_HistoriesCount() {
		return _wfms_Associate_HistoryLocalService.getWFMS_Associate_HistoriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_Associate_HistoryLocalService.getOSGiServiceIdentifier();
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
		return _wfms_Associate_HistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_Associate_HistoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_Associate_HistoryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the WFMS_Associate_Histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Associate_Histories
	* @param end the upper bound of the range of WFMS_Associate_Histories (not inclusive)
	* @return the range of WFMS_Associate_Histories
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Associate_History> getWFMS_Associate_Histories(
		int start, int end) {
		return _wfms_Associate_HistoryLocalService.getWFMS_Associate_Histories(start,
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
		return _wfms_Associate_HistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_Associate_HistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_Associate_HistoryLocalService getWrappedService() {
		return _wfms_Associate_HistoryLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_Associate_HistoryLocalService wfms_Associate_HistoryLocalService) {
		_wfms_Associate_HistoryLocalService = wfms_Associate_HistoryLocalService;
	}

	private WFMS_Associate_HistoryLocalService _wfms_Associate_HistoryLocalService;
}