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

package com.leykartservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TestmonialsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TestmonialsLocalService
 * @generated
 */
@ProviderType
public class TestmonialsLocalServiceWrapper implements TestmonialsLocalService,
	ServiceWrapper<TestmonialsLocalService> {
	public TestmonialsLocalServiceWrapper(
		TestmonialsLocalService testmonialsLocalService) {
		_testmonialsLocalService = testmonialsLocalService;
	}

	/**
	* Adds the testmonials to the database. Also notifies the appropriate model listeners.
	*
	* @param testmonials the testmonials
	* @return the testmonials that was added
	*/
	@Override
	public com.leykartservice.model.Testmonials addTestmonials(
		com.leykartservice.model.Testmonials testmonials) {
		return _testmonialsLocalService.addTestmonials(testmonials);
	}

	/**
	* Creates a new testmonials with the primary key. Does not add the testmonials to the database.
	*
	* @param testmonialsId the primary key for the new testmonials
	* @return the new testmonials
	*/
	@Override
	public com.leykartservice.model.Testmonials createTestmonials(
		long testmonialsId) {
		return _testmonialsLocalService.createTestmonials(testmonialsId);
	}

	/**
	* Deletes the testmonials from the database. Also notifies the appropriate model listeners.
	*
	* @param testmonials the testmonials
	* @return the testmonials that was removed
	*/
	@Override
	public com.leykartservice.model.Testmonials deleteTestmonials(
		com.leykartservice.model.Testmonials testmonials) {
		return _testmonialsLocalService.deleteTestmonials(testmonials);
	}

	/**
	* Deletes the testmonials with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials that was removed
	* @throws PortalException if a testmonials with the primary key could not be found
	*/
	@Override
	public com.leykartservice.model.Testmonials deleteTestmonials(
		long testmonialsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testmonialsLocalService.deleteTestmonials(testmonialsId);
	}

	@Override
	public com.leykartservice.model.Testmonials fetchTestmonials(
		long testmonialsId) {
		return _testmonialsLocalService.fetchTestmonials(testmonialsId);
	}

	/**
	* Returns the testmonials with the matching UUID and company.
	*
	* @param uuid the testmonials's UUID
	* @param companyId the primary key of the company
	* @return the matching testmonials, or <code>null</code> if a matching testmonials could not be found
	*/
	@Override
	public com.leykartservice.model.Testmonials fetchTestmonialsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _testmonialsLocalService.fetchTestmonialsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the testmonials with the primary key.
	*
	* @param testmonialsId the primary key of the testmonials
	* @return the testmonials
	* @throws PortalException if a testmonials with the primary key could not be found
	*/
	@Override
	public com.leykartservice.model.Testmonials getTestmonials(
		long testmonialsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testmonialsLocalService.getTestmonials(testmonialsId);
	}

	/**
	* Returns the testmonials with the matching UUID and company.
	*
	* @param uuid the testmonials's UUID
	* @param companyId the primary key of the company
	* @return the matching testmonials
	* @throws PortalException if a matching testmonials could not be found
	*/
	@Override
	public com.leykartservice.model.Testmonials getTestmonialsByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testmonialsLocalService.getTestmonialsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the testmonials in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testmonials the testmonials
	* @return the testmonials that was updated
	*/
	@Override
	public com.leykartservice.model.Testmonials updateTestmonials(
		com.leykartservice.model.Testmonials testmonials) {
		return _testmonialsLocalService.updateTestmonials(testmonials);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _testmonialsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testmonialsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _testmonialsLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _testmonialsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testmonialsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testmonialsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of testmonialses.
	*
	* @return the number of testmonialses
	*/
	@Override
	public int getTestmonialsesCount() {
		return _testmonialsLocalService.getTestmonialsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _testmonialsLocalService.getOSGiServiceIdentifier();
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
		return _testmonialsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leykartservice.model.impl.TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testmonialsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leykartservice.model.impl.TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testmonialsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the testmonialses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leykartservice.model.impl.TestmonialsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testmonialses
	* @param end the upper bound of the range of testmonialses (not inclusive)
	* @return the range of testmonialses
	*/
	@Override
	public java.util.List<com.leykartservice.model.Testmonials> getTestmonialses(
		int start, int end) {
		return _testmonialsLocalService.getTestmonialses(start, end);
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
		return _testmonialsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _testmonialsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TestmonialsLocalService getWrappedService() {
		return _testmonialsLocalService;
	}

	@Override
	public void setWrappedService(
		TestmonialsLocalService testmonialsLocalService) {
		_testmonialsLocalService = testmonialsLocalService;
	}

	private TestmonialsLocalService _testmonialsLocalService;
}