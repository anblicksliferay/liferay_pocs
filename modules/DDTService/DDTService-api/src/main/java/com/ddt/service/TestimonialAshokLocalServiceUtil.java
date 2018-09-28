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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TestimonialAshok. This utility wraps
 * {@link com.ddt.service.impl.TestimonialAshokLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TestimonialAshokLocalService
 * @see com.ddt.service.base.TestimonialAshokLocalServiceBaseImpl
 * @see com.ddt.service.impl.TestimonialAshokLocalServiceImpl
 * @generated
 */
@ProviderType
public class TestimonialAshokLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ddt.service.impl.TestimonialAshokLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the testimonial ashok to the database. Also notifies the appropriate model listeners.
	*
	* @param testimonialAshok the testimonial ashok
	* @return the testimonial ashok that was added
	*/
	public static com.ddt.model.TestimonialAshok addTestimonialAshok(
		com.ddt.model.TestimonialAshok testimonialAshok) {
		return getService().addTestimonialAshok(testimonialAshok);
	}

	/**
	* Creates a new testimonial ashok with the primary key. Does not add the testimonial ashok to the database.
	*
	* @param id the primary key for the new testimonial ashok
	* @return the new testimonial ashok
	*/
	public static com.ddt.model.TestimonialAshok createTestimonialAshok(long id) {
		return getService().createTestimonialAshok(id);
	}

	/**
	* Deletes the testimonial ashok from the database. Also notifies the appropriate model listeners.
	*
	* @param testimonialAshok the testimonial ashok
	* @return the testimonial ashok that was removed
	*/
	public static com.ddt.model.TestimonialAshok deleteTestimonialAshok(
		com.ddt.model.TestimonialAshok testimonialAshok) {
		return getService().deleteTestimonialAshok(testimonialAshok);
	}

	/**
	* Deletes the testimonial ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok that was removed
	* @throws PortalException if a testimonial ashok with the primary key could not be found
	*/
	public static com.ddt.model.TestimonialAshok deleteTestimonialAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTestimonialAshok(id);
	}

	public static com.ddt.model.TestimonialAshok fetchTestimonialAshok(long id) {
		return getService().fetchTestimonialAshok(id);
	}

	/**
	* Returns the testimonial ashok with the primary key.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok
	* @throws PortalException if a testimonial ashok with the primary key could not be found
	*/
	public static com.ddt.model.TestimonialAshok getTestimonialAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTestimonialAshok(id);
	}

	/**
	* Updates the testimonial ashok in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testimonialAshok the testimonial ashok
	* @return the testimonial ashok that was updated
	*/
	public static com.ddt.model.TestimonialAshok updateTestimonialAshok(
		com.ddt.model.TestimonialAshok testimonialAshok) {
		return getService().updateTestimonialAshok(testimonialAshok);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of testimonial ashoks.
	*
	* @return the number of testimonial ashoks
	*/
	public static int getTestimonialAshoksCount() {
		return getService().getTestimonialAshoksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<com.ddt.model.TestimonialAshok> getTestimonialAshoks(
		int start, int end) {
		return getService().getTestimonialAshoks(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TestimonialAshokLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TestimonialAshokLocalService, TestimonialAshokLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TestimonialAshokLocalService.class);
}