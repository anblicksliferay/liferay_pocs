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

package ddtii.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for loc_cou_cat. This utility wraps
 * {@link ddtii.service.impl.loc_cou_catLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_catLocalService
 * @see ddtii.service.base.loc_cou_catLocalServiceBaseImpl
 * @see ddtii.service.impl.loc_cou_catLocalServiceImpl
 * @generated
 */
@ProviderType
public class loc_cou_catLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ddtii.service.impl.loc_cou_catLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
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
	* Adds the loc_cou_cat to the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_cat the loc_cou_cat
	* @return the loc_cou_cat that was added
	*/
	public static ddtii.model.loc_cou_cat addloc_cou_cat(
		ddtii.model.loc_cou_cat loc_cou_cat) {
		return getService().addloc_cou_cat(loc_cou_cat);
	}

	/**
	* Creates a new loc_cou_cat with the primary key. Does not add the loc_cou_cat to the database.
	*
	* @param loc_cou_catId the primary key for the new loc_cou_cat
	* @return the new loc_cou_cat
	*/
	public static ddtii.model.loc_cou_cat createloc_cou_cat(long loc_cou_catId) {
		return getService().createloc_cou_cat(loc_cou_catId);
	}

	/**
	* Deletes the loc_cou_cat from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_cat the loc_cou_cat
	* @return the loc_cou_cat that was removed
	*/
	public static ddtii.model.loc_cou_cat deleteloc_cou_cat(
		ddtii.model.loc_cou_cat loc_cou_cat) {
		return getService().deleteloc_cou_cat(loc_cou_cat);
	}

	/**
	* Deletes the loc_cou_cat with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat that was removed
	* @throws PortalException if a loc_cou_cat with the primary key could not be found
	*/
	public static ddtii.model.loc_cou_cat deleteloc_cou_cat(long loc_cou_catId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteloc_cou_cat(loc_cou_catId);
	}

	public static ddtii.model.loc_cou_cat fetchloc_cou_cat(long loc_cou_catId) {
		return getService().fetchloc_cou_cat(loc_cou_catId);
	}

	/**
	* Returns the loc_cou_cat with the primary key.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat
	* @throws PortalException if a loc_cou_cat with the primary key could not be found
	*/
	public static ddtii.model.loc_cou_cat getloc_cou_cat(long loc_cou_catId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getloc_cou_cat(loc_cou_catId);
	}

	/**
	* Updates the loc_cou_cat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_cat the loc_cou_cat
	* @return the loc_cou_cat that was updated
	*/
	public static ddtii.model.loc_cou_cat updateloc_cou_cat(
		ddtii.model.loc_cou_cat loc_cou_cat) {
		return getService().updateloc_cou_cat(loc_cou_cat);
	}

	/**
	* Returns the number of loc_cou_cats.
	*
	* @return the number of loc_cou_cats
	*/
	public static int getloc_cou_catsCount() {
		return getService().getloc_cou_catsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ddtii.model.impl.loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ddtii.model.impl.loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the loc_cou_cats.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ddtii.model.impl.loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_cou_cats
	* @param end the upper bound of the range of loc_cou_cats (not inclusive)
	* @return the range of loc_cou_cats
	*/
	public static java.util.List<ddtii.model.loc_cou_cat> getloc_cou_cats(
		int start, int end) {
		return getService().getloc_cou_cats(start, end);
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

	public static loc_cou_catLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<loc_cou_catLocalService, loc_cou_catLocalService> _serviceTracker =
		ServiceTrackerFactory.open(loc_cou_catLocalService.class);
}