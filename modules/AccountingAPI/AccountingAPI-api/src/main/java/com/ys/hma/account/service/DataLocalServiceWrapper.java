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

package com.ys.hma.account.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataLocalService
 * @generated
 */
@ProviderType
public class DataLocalServiceWrapper implements DataLocalService,
	ServiceWrapper<DataLocalService> {
	public DataLocalServiceWrapper(DataLocalService dataLocalService) {
		_dataLocalService = dataLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the data to the database. Also notifies the appropriate model listeners.
	*
	* @param data the data
	* @return the data that was added
	*/
	@Override
	public com.ys.hma.account.model.Data addData(
		com.ys.hma.account.model.Data data) {
		return _dataLocalService.addData(data);
	}

	/**
	* Creates a new data with the primary key. Does not add the data to the database.
	*
	* @param DataId the primary key for the new data
	* @return the new data
	*/
	@Override
	public com.ys.hma.account.model.Data createData(long DataId) {
		return _dataLocalService.createData(DataId);
	}

	/**
	* Deletes the data from the database. Also notifies the appropriate model listeners.
	*
	* @param data the data
	* @return the data that was removed
	*/
	@Override
	public com.ys.hma.account.model.Data deleteData(
		com.ys.hma.account.model.Data data) {
		return _dataLocalService.deleteData(data);
	}

	/**
	* Deletes the data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param DataId the primary key of the data
	* @return the data that was removed
	* @throws PortalException if a data with the primary key could not be found
	*/
	@Override
	public com.ys.hma.account.model.Data deleteData(long DataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.deleteData(DataId);
	}

	@Override
	public com.ys.hma.account.model.Data fetchData(long DataId) {
		return _dataLocalService.fetchData(DataId);
	}

	/**
	* Returns the data with the primary key.
	*
	* @param DataId the primary key of the data
	* @return the data
	* @throws PortalException if a data with the primary key could not be found
	*/
	@Override
	public com.ys.hma.account.model.Data getData(long DataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dataLocalService.getData(DataId);
	}

	/**
	* Updates the data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param data the data
	* @return the data that was updated
	*/
	@Override
	public com.ys.hma.account.model.Data updateData(
		com.ys.hma.account.model.Data data) {
		return _dataLocalService.updateData(data);
	}

	/**
	* Returns the number of datas.
	*
	* @return the number of datas
	*/
	@Override
	public int getDatasCount() {
		return _dataLocalService.getDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dataLocalService.getOSGiServiceIdentifier();
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
		return _dataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hma.account.model.impl.DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hma.account.model.impl.DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dataLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hma.account.model.impl.DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of datas
	* @param end the upper bound of the range of datas (not inclusive)
	* @return the range of datas
	*/
	@Override
	public java.util.List<com.ys.hma.account.model.Data> getDatas(int start,
		int end) {
		return _dataLocalService.getDatas(start, end);
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
		return _dataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dataLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public DataLocalService getWrappedService() {
		return _dataLocalService;
	}

	@Override
	public void setWrappedService(DataLocalService dataLocalService) {
		_dataLocalService = dataLocalService;
	}

	private DataLocalService _dataLocalService;
}