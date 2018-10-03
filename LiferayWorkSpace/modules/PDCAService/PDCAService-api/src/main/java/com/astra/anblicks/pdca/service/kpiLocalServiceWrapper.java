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

package com.astra.anblicks.pdca.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link kpiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see kpiLocalService
 * @generated
 */
@ProviderType
public class kpiLocalServiceWrapper implements kpiLocalService,
	ServiceWrapper<kpiLocalService> {
	public kpiLocalServiceWrapper(kpiLocalService kpiLocalService) {
		_kpiLocalService = kpiLocalService;
	}

	/**
	* Adds the kpi to the database. Also notifies the appropriate model listeners.
	*
	* @param kpi the kpi
	* @return the kpi that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi addkpi(
		com.astra.anblicks.pdca.model.kpi kpi) {
		return _kpiLocalService.addkpi(kpi);
	}

	/**
	* Creates a new kpi with the primary key. Does not add the kpi to the database.
	*
	* @param kpiId the primary key for the new kpi
	* @return the new kpi
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi createkpi(long kpiId) {
		return _kpiLocalService.createkpi(kpiId);
	}

	/**
	* Deletes the kpi from the database. Also notifies the appropriate model listeners.
	*
	* @param kpi the kpi
	* @return the kpi that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi deletekpi(
		com.astra.anblicks.pdca.model.kpi kpi) {
		return _kpiLocalService.deletekpi(kpi);
	}

	/**
	* Deletes the kpi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiId the primary key of the kpi
	* @return the kpi that was removed
	* @throws PortalException if a kpi with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi deletekpi(long kpiId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kpiLocalService.deletekpi(kpiId);
	}

	@Override
	public com.astra.anblicks.pdca.model.kpi fetchkpi(long kpiId) {
		return _kpiLocalService.fetchkpi(kpiId);
	}

	/**
	* Returns the kpi with the matching UUID and company.
	*
	* @param uuid the kpi's UUID
	* @param companyId the primary key of the company
	* @return the matching kpi, or <code>null</code> if a matching kpi could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi fetchkpiByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _kpiLocalService.fetchkpiByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the kpi with the primary key.
	*
	* @param kpiId the primary key of the kpi
	* @return the kpi
	* @throws PortalException if a kpi with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi getkpi(long kpiId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kpiLocalService.getkpi(kpiId);
	}

	/**
	* Returns the kpi with the matching UUID and company.
	*
	* @param uuid the kpi's UUID
	* @param companyId the primary key of the company
	* @return the matching kpi
	* @throws PortalException if a matching kpi could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi getkpiByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kpiLocalService.getkpiByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the kpi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kpi the kpi
	* @return the kpi that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.kpi updatekpi(
		com.astra.anblicks.pdca.model.kpi kpi) {
		return _kpiLocalService.updatekpi(kpi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _kpiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kpiLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _kpiLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _kpiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kpiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kpiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of kpis.
	*
	* @return the number of kpis
	*/
	@Override
	public int getkpisCount() {
		return _kpiLocalService.getkpisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _kpiLocalService.getOSGiServiceIdentifier();
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
		return _kpiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kpiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kpiLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpis
	* @param end the upper bound of the range of kpis (not inclusive)
	* @return the range of kpis
	*/
	@Override
	public java.util.List<com.astra.anblicks.pdca.model.kpi> getkpis(
		int start, int end) {
		return _kpiLocalService.getkpis(start, end);
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
		return _kpiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kpiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public kpiLocalService getWrappedService() {
		return _kpiLocalService;
	}

	@Override
	public void setWrappedService(kpiLocalService kpiLocalService) {
		_kpiLocalService = kpiLocalService;
	}

	private kpiLocalService _kpiLocalService;
}