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
 * Provides a wrapper for {@link TestimonialAshokLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TestimonialAshokLocalService
 * @generated
 */
@ProviderType
public class TestimonialAshokLocalServiceWrapper
	implements TestimonialAshokLocalService,
		ServiceWrapper<TestimonialAshokLocalService> {
	public TestimonialAshokLocalServiceWrapper(
		TestimonialAshokLocalService testimonialAshokLocalService) {
		_testimonialAshokLocalService = testimonialAshokLocalService;
	}

	/**
	* Adds the testimonial ashok to the database. Also notifies the appropriate model listeners.
	*
	* @param testimonialAshok the testimonial ashok
	* @return the testimonial ashok that was added
	*/
	@Override
	public com.ddt.model.TestimonialAshok addTestimonialAshok(
		com.ddt.model.TestimonialAshok testimonialAshok) {
		return _testimonialAshokLocalService.addTestimonialAshok(testimonialAshok);
	}

	/**
	* Creates a new testimonial ashok with the primary key. Does not add the testimonial ashok to the database.
	*
	* @param id the primary key for the new testimonial ashok
	* @return the new testimonial ashok
	*/
	@Override
	public com.ddt.model.TestimonialAshok createTestimonialAshok(long id) {
		return _testimonialAshokLocalService.createTestimonialAshok(id);
	}

	/**
	* Deletes the testimonial ashok from the database. Also notifies the appropriate model listeners.
	*
	* @param testimonialAshok the testimonial ashok
	* @return the testimonial ashok that was removed
	*/
	@Override
	public com.ddt.model.TestimonialAshok deleteTestimonialAshok(
		com.ddt.model.TestimonialAshok testimonialAshok) {
		return _testimonialAshokLocalService.deleteTestimonialAshok(testimonialAshok);
	}

	/**
	* Deletes the testimonial ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok that was removed
	* @throws PortalException if a testimonial ashok with the primary key could not be found
	*/
	@Override
	public com.ddt.model.TestimonialAshok deleteTestimonialAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testimonialAshokLocalService.deleteTestimonialAshok(id);
	}

	@Override
	public com.ddt.model.TestimonialAshok fetchTestimonialAshok(long id) {
		return _testimonialAshokLocalService.fetchTestimonialAshok(id);
	}

	/**
	* Returns the testimonial ashok with the primary key.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok
	* @throws PortalException if a testimonial ashok with the primary key could not be found
	*/
	@Override
	public com.ddt.model.TestimonialAshok getTestimonialAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testimonialAshokLocalService.getTestimonialAshok(id);
	}

	/**
	* Updates the testimonial ashok in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testimonialAshok the testimonial ashok
	* @return the testimonial ashok that was updated
	*/
	@Override
	public com.ddt.model.TestimonialAshok updateTestimonialAshok(
		com.ddt.model.TestimonialAshok testimonialAshok) {
		return _testimonialAshokLocalService.updateTestimonialAshok(testimonialAshok);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _testimonialAshokLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testimonialAshokLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _testimonialAshokLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testimonialAshokLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testimonialAshokLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of testimonial ashoks.
	*
	* @return the number of testimonial ashoks
	*/
	@Override
	public int getTestimonialAshoksCount() {
		return _testimonialAshokLocalService.getTestimonialAshoksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _testimonialAshokLocalService.getOSGiServiceIdentifier();
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
		return _testimonialAshokLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testimonialAshokLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testimonialAshokLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @return the range of testimonial ashoks
	*/
	@Override
	public java.util.List<com.ddt.model.TestimonialAshok> getTestimonialAshoks(
		int start, int end) {
		return _testimonialAshokLocalService.getTestimonialAshoks(start, end);
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
		return _testimonialAshokLocalService.dynamicQueryCount(dynamicQuery);
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
		return _testimonialAshokLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TestimonialAshokLocalService getWrappedService() {
		return _testimonialAshokLocalService;
	}

	@Override
	public void setWrappedService(
		TestimonialAshokLocalService testimonialAshokLocalService) {
		_testimonialAshokLocalService = testimonialAshokLocalService;
	}

	private TestimonialAshokLocalService _testimonialAshokLocalService;
}