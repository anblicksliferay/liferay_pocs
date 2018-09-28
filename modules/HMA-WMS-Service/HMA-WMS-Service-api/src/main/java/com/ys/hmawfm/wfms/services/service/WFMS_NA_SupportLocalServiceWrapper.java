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
 * Provides a wrapper for {@link WFMS_NA_SupportLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_SupportLocalService
 * @generated
 */
@ProviderType
public class WFMS_NA_SupportLocalServiceWrapper
	implements WFMS_NA_SupportLocalService,
		ServiceWrapper<WFMS_NA_SupportLocalService> {
	public WFMS_NA_SupportLocalServiceWrapper(
		WFMS_NA_SupportLocalService wfms_na_SupportLocalService) {
		_wfms_na_SupportLocalService = wfms_na_SupportLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wfms_na_SupportLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_na_SupportLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_na_SupportLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support addNewEmptyassociate()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_na_SupportLocalService.addNewEmptyassociate();
	}

	/**
	* Adds the WFMS_NA_Support to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	* @return the WFMS_NA_Support that was added
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support addWFMS_NA_Support(
		com.ys.hmawfm.wfms.services.model.WFMS_NA_Support wfms_na_Support) {
		return _wfms_na_SupportLocalService.addWFMS_NA_Support(wfms_na_Support);
	}

	/**
	* Creates a new WFMS_NA_Support with the primary key. Does not add the WFMS_NA_Support to the database.
	*
	* @param ASSOCIATE_NUMBER the primary key for the new WFMS_NA_Support
	* @return the new WFMS_NA_Support
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support createWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER) {
		return _wfms_na_SupportLocalService.createWFMS_NA_Support(ASSOCIATE_NUMBER);
	}

	/**
	* Deletes the WFMS_NA_Support from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	* @return the WFMS_NA_Support that was removed
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support deleteWFMS_NA_Support(
		com.ys.hmawfm.wfms.services.model.WFMS_NA_Support wfms_na_Support) {
		return _wfms_na_SupportLocalService.deleteWFMS_NA_Support(wfms_na_Support);
	}

	/**
	* Deletes the WFMS_NA_Support with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support that was removed
	* @throws PortalException if a WFMS_NA_Support with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support deleteWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_na_SupportLocalService.deleteWFMS_NA_Support(ASSOCIATE_NUMBER);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support fetchWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER) {
		return _wfms_na_SupportLocalService.fetchWFMS_NA_Support(ASSOCIATE_NUMBER);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support findBynaSupport(
		java.lang.String ASSOCIATE_NUMBER)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NA_SupportException {
		return _wfms_na_SupportLocalService.findBynaSupport(ASSOCIATE_NUMBER);
	}

	/**
	* Returns the WFMS_NA_Support with the primary key.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support
	* @throws PortalException if a WFMS_NA_Support with the primary key could not be found
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support getWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wfms_na_SupportLocalService.getWFMS_NA_Support(ASSOCIATE_NUMBER);
	}

	/**
	* Updates the WFMS_NA_Support in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	* @return the WFMS_NA_Support that was updated
	*/
	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support updateWFMS_NA_Support(
		com.ys.hmawfm.wfms.services.model.WFMS_NA_Support wfms_na_Support) {
		return _wfms_na_SupportLocalService.updateWFMS_NA_Support(wfms_na_Support);
	}

	@Override
	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support updateassociatedata(
		com.ys.hmawfm.wfms.services.model.WFMS_NA_Support entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wfms_na_SupportLocalService.updateassociatedata(entry);
	}

	/**
	* Returns the number of WFMS_NA_Supports.
	*
	* @return the number of WFMS_NA_Supports
	*/
	@Override
	public int getWFMS_NA_SupportsCount() {
		return _wfms_na_SupportLocalService.getWFMS_NA_SupportsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_na_SupportLocalService.getOSGiServiceIdentifier();
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
		return _wfms_na_SupportLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_na_SupportLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wfms_na_SupportLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the WFMS_NA_Supports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NA_Supports
	* @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	* @return the range of WFMS_NA_Supports
	*/
	@Override
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_NA_Support> getWFMS_NA_Supports(
		int start, int end) {
		return _wfms_na_SupportLocalService.getWFMS_NA_Supports(start, end);
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
		return _wfms_na_SupportLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wfms_na_SupportLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WFMS_NA_SupportLocalService getWrappedService() {
		return _wfms_na_SupportLocalService;
	}

	@Override
	public void setWrappedService(
		WFMS_NA_SupportLocalService wfms_na_SupportLocalService) {
		_wfms_na_SupportLocalService = wfms_na_SupportLocalService;
	}

	private WFMS_NA_SupportLocalService _wfms_na_SupportLocalService;
}