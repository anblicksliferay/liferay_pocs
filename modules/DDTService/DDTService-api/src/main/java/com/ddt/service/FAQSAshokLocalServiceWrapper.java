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

package com.ddt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FAQSAshokLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FAQSAshokLocalService
 * @generated
 */
@ProviderType
public class FAQSAshokLocalServiceWrapper implements FAQSAshokLocalService,
	ServiceWrapper<FAQSAshokLocalService> {
	public FAQSAshokLocalServiceWrapper(
		FAQSAshokLocalService faqsAshokLocalService) {
		_faqsAshokLocalService = faqsAshokLocalService;
	}

	/**
	* Adds the f a q s ashok to the database. Also notifies the appropriate model listeners.
	*
	* @param faqsAshok the f a q s ashok
	* @return the f a q s ashok that was added
	*/
	@Override
	public com.ddt.model.FAQSAshok addFAQSAshok(
		com.ddt.model.FAQSAshok faqsAshok) {
		return _faqsAshokLocalService.addFAQSAshok(faqsAshok);
	}

	/**
	* Creates a new f a q s ashok with the primary key. Does not add the f a q s ashok to the database.
	*
	* @param id the primary key for the new f a q s ashok
	* @return the new f a q s ashok
	*/
	@Override
	public com.ddt.model.FAQSAshok createFAQSAshok(long id) {
		return _faqsAshokLocalService.createFAQSAshok(id);
	}

	/**
	* Deletes the f a q s ashok from the database. Also notifies the appropriate model listeners.
	*
	* @param faqsAshok the f a q s ashok
	* @return the f a q s ashok that was removed
	*/
	@Override
	public com.ddt.model.FAQSAshok deleteFAQSAshok(
		com.ddt.model.FAQSAshok faqsAshok) {
		return _faqsAshokLocalService.deleteFAQSAshok(faqsAshok);
	}

	/**
	* Deletes the f a q s ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok that was removed
	* @throws PortalException if a f a q s ashok with the primary key could not be found
	*/
	@Override
	public com.ddt.model.FAQSAshok deleteFAQSAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqsAshokLocalService.deleteFAQSAshok(id);
	}

	@Override
	public com.ddt.model.FAQSAshok fetchFAQSAshok(long id) {
		return _faqsAshokLocalService.fetchFAQSAshok(id);
	}

	/**
	* Returns the f a q s ashok with the primary key.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok
	* @throws PortalException if a f a q s ashok with the primary key could not be found
	*/
	@Override
	public com.ddt.model.FAQSAshok getFAQSAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqsAshokLocalService.getFAQSAshok(id);
	}

	/**
	* Updates the f a q s ashok in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqsAshok the f a q s ashok
	* @return the f a q s ashok that was updated
	*/
	@Override
	public com.ddt.model.FAQSAshok updateFAQSAshok(
		com.ddt.model.FAQSAshok faqsAshok) {
		return _faqsAshokLocalService.updateFAQSAshok(faqsAshok);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _faqsAshokLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqsAshokLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _faqsAshokLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqsAshokLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqsAshokLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of f a q s ashoks.
	*
	* @return the number of f a q s ashoks
	*/
	@Override
	public int getFAQSAshoksCount() {
		return _faqsAshokLocalService.getFAQSAshoksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _faqsAshokLocalService.getOSGiServiceIdentifier();
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
		return _faqsAshokLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _faqsAshokLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _faqsAshokLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @return the range of f a q s ashoks
	*/
	@Override
	public java.util.List<com.ddt.model.FAQSAshok> getFAQSAshoks(int start,
		int end) {
		return _faqsAshokLocalService.getFAQSAshoks(start, end);
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
		return _faqsAshokLocalService.dynamicQueryCount(dynamicQuery);
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
		return _faqsAshokLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public FAQSAshokLocalService getWrappedService() {
		return _faqsAshokLocalService;
	}

	@Override
	public void setWrappedService(FAQSAshokLocalService faqsAshokLocalService) {
		_faqsAshokLocalService = faqsAshokLocalService;
	}

	private FAQSAshokLocalService _faqsAshokLocalService;
}