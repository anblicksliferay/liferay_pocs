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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link loc_cou_catLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_catLocalService
 * @generated
 */
@ProviderType
public class loc_cou_catLocalServiceWrapper implements loc_cou_catLocalService,
	ServiceWrapper<loc_cou_catLocalService> {
	public loc_cou_catLocalServiceWrapper(
		loc_cou_catLocalService loc_cou_catLocalService) {
		_loc_cou_catLocalService = loc_cou_catLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _loc_cou_catLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loc_cou_catLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _loc_cou_catLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loc_cou_catLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loc_cou_catLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the loc_cou_cat to the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_cat the loc_cou_cat
	* @return the loc_cou_cat that was added
	*/
	@Override
	public ddtii.model.loc_cou_cat addloc_cou_cat(
		ddtii.model.loc_cou_cat loc_cou_cat) {
		return _loc_cou_catLocalService.addloc_cou_cat(loc_cou_cat);
	}

	/**
	* Creates a new loc_cou_cat with the primary key. Does not add the loc_cou_cat to the database.
	*
	* @param loc_cou_catId the primary key for the new loc_cou_cat
	* @return the new loc_cou_cat
	*/
	@Override
	public ddtii.model.loc_cou_cat createloc_cou_cat(long loc_cou_catId) {
		return _loc_cou_catLocalService.createloc_cou_cat(loc_cou_catId);
	}

	/**
	* Deletes the loc_cou_cat from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_cat the loc_cou_cat
	* @return the loc_cou_cat that was removed
	*/
	@Override
	public ddtii.model.loc_cou_cat deleteloc_cou_cat(
		ddtii.model.loc_cou_cat loc_cou_cat) {
		return _loc_cou_catLocalService.deleteloc_cou_cat(loc_cou_cat);
	}

	/**
	* Deletes the loc_cou_cat with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat that was removed
	* @throws PortalException if a loc_cou_cat with the primary key could not be found
	*/
	@Override
	public ddtii.model.loc_cou_cat deleteloc_cou_cat(long loc_cou_catId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loc_cou_catLocalService.deleteloc_cou_cat(loc_cou_catId);
	}

	@Override
	public ddtii.model.loc_cou_cat fetchloc_cou_cat(long loc_cou_catId) {
		return _loc_cou_catLocalService.fetchloc_cou_cat(loc_cou_catId);
	}

	/**
	* Returns the loc_cou_cat with the primary key.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat
	* @throws PortalException if a loc_cou_cat with the primary key could not be found
	*/
	@Override
	public ddtii.model.loc_cou_cat getloc_cou_cat(long loc_cou_catId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _loc_cou_catLocalService.getloc_cou_cat(loc_cou_catId);
	}

	/**
	* Updates the loc_cou_cat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_cat the loc_cou_cat
	* @return the loc_cou_cat that was updated
	*/
	@Override
	public ddtii.model.loc_cou_cat updateloc_cou_cat(
		ddtii.model.loc_cou_cat loc_cou_cat) {
		return _loc_cou_catLocalService.updateloc_cou_cat(loc_cou_cat);
	}

	/**
	* Returns the number of loc_cou_cats.
	*
	* @return the number of loc_cou_cats
	*/
	@Override
	public int getloc_cou_catsCount() {
		return _loc_cou_catLocalService.getloc_cou_catsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _loc_cou_catLocalService.getOSGiServiceIdentifier();
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
		return _loc_cou_catLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _loc_cou_catLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _loc_cou_catLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<ddtii.model.loc_cou_cat> getloc_cou_cats(int start,
		int end) {
		return _loc_cou_catLocalService.getloc_cou_cats(start, end);
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
		return _loc_cou_catLocalService.dynamicQueryCount(dynamicQuery);
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
		return _loc_cou_catLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public loc_cou_catLocalService getWrappedService() {
		return _loc_cou_catLocalService;
	}

	@Override
	public void setWrappedService(
		loc_cou_catLocalService loc_cou_catLocalService) {
		_loc_cou_catLocalService = loc_cou_catLocalService;
	}

	private loc_cou_catLocalService _loc_cou_catLocalService;
}