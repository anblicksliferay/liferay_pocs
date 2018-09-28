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

package com.astra.workflowservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalService
 * @generated
 */
@ProviderType
public class RegistrationLocalServiceWrapper implements RegistrationLocalService,
	ServiceWrapper<RegistrationLocalService> {
	public RegistrationLocalServiceWrapper(
		RegistrationLocalService registrationLocalService) {
		_registrationLocalService = registrationLocalService;
	}

	/**
	* Adds the registration to the database. Also notifies the appropriate model listeners.
	*
	* @param registration the registration
	* @return the registration that was added
	*/
	@Override
	public com.astra.workflowservice.model.Registration addRegistration(
		com.astra.workflowservice.model.Registration registration) {
		return _registrationLocalService.addRegistration(registration);
	}

	/**
	* Creates a new registration with the primary key. Does not add the registration to the database.
	*
	* @param RegistrationId the primary key for the new registration
	* @return the new registration
	*/
	@Override
	public com.astra.workflowservice.model.Registration createRegistration(
		long RegistrationId) {
		return _registrationLocalService.createRegistration(RegistrationId);
	}

	/**
	* Deletes the registration from the database. Also notifies the appropriate model listeners.
	*
	* @param registration the registration
	* @return the registration that was removed
	*/
	@Override
	public com.astra.workflowservice.model.Registration deleteRegistration(
		com.astra.workflowservice.model.Registration registration) {
		return _registrationLocalService.deleteRegistration(registration);
	}

	/**
	* Deletes the registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param RegistrationId the primary key of the registration
	* @return the registration that was removed
	* @throws PortalException if a registration with the primary key could not be found
	*/
	@Override
	public com.astra.workflowservice.model.Registration deleteRegistration(
		long RegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.deleteRegistration(RegistrationId);
	}

	@Override
	public com.astra.workflowservice.model.Registration fetchRegistration(
		long RegistrationId) {
		return _registrationLocalService.fetchRegistration(RegistrationId);
	}

	/**
	* Returns the registration with the matching UUID and company.
	*
	* @param uuid the registration's UUID
	* @param companyId the primary key of the company
	* @return the matching registration, or <code>null</code> if a matching registration could not be found
	*/
	@Override
	public com.astra.workflowservice.model.Registration fetchRegistrationByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _registrationLocalService.fetchRegistrationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the registration with the primary key.
	*
	* @param RegistrationId the primary key of the registration
	* @return the registration
	* @throws PortalException if a registration with the primary key could not be found
	*/
	@Override
	public com.astra.workflowservice.model.Registration getRegistration(
		long RegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.getRegistration(RegistrationId);
	}

	/**
	* Returns the registration with the matching UUID and company.
	*
	* @param uuid the registration's UUID
	* @param companyId the primary key of the company
	* @return the matching registration
	* @throws PortalException if a matching registration could not be found
	*/
	@Override
	public com.astra.workflowservice.model.Registration getRegistrationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.getRegistrationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param registration the registration
	* @return the registration that was updated
	*/
	@Override
	public com.astra.workflowservice.model.Registration updateRegistration(
		com.astra.workflowservice.model.Registration registration) {
		return _registrationLocalService.updateRegistration(registration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _registrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registrationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _registrationLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _registrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of registrations.
	*
	* @return the number of registrations
	*/
	@Override
	public int getRegistrationsCount() {
		return _registrationLocalService.getRegistrationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _registrationLocalService.getOSGiServiceIdentifier();
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
		return _registrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.workflowservice.model.impl.RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _registrationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.workflowservice.model.impl.RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _registrationLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.workflowservice.model.impl.RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @return the range of registrations
	*/
	@Override
	public java.util.List<com.astra.workflowservice.model.Registration> getRegistrations(
		int start, int end) {
		return _registrationLocalService.getRegistrations(start, end);
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
		return _registrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _registrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public RegistrationLocalService getWrappedService() {
		return _registrationLocalService;
	}

	@Override
	public void setWrappedService(
		RegistrationLocalService registrationLocalService) {
		_registrationLocalService = registrationLocalService;
	}

	private RegistrationLocalService _registrationLocalService;
}