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
 * Provides a wrapper for {@link NewsAshokLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NewsAshokLocalService
 * @generated
 */
@ProviderType
public class NewsAshokLocalServiceWrapper implements NewsAshokLocalService,
	ServiceWrapper<NewsAshokLocalService> {
	public NewsAshokLocalServiceWrapper(
		NewsAshokLocalService newsAshokLocalService) {
		_newsAshokLocalService = newsAshokLocalService;
	}

	/**
	* Adds the news ashok to the database. Also notifies the appropriate model listeners.
	*
	* @param newsAshok the news ashok
	* @return the news ashok that was added
	*/
	@Override
	public com.ddt.model.NewsAshok addNewsAshok(
		com.ddt.model.NewsAshok newsAshok) {
		return _newsAshokLocalService.addNewsAshok(newsAshok);
	}

	/**
	* Creates a new news ashok with the primary key. Does not add the news ashok to the database.
	*
	* @param id the primary key for the new news ashok
	* @return the new news ashok
	*/
	@Override
	public com.ddt.model.NewsAshok createNewsAshok(long id) {
		return _newsAshokLocalService.createNewsAshok(id);
	}

	/**
	* Deletes the news ashok from the database. Also notifies the appropriate model listeners.
	*
	* @param newsAshok the news ashok
	* @return the news ashok that was removed
	*/
	@Override
	public com.ddt.model.NewsAshok deleteNewsAshok(
		com.ddt.model.NewsAshok newsAshok) {
		return _newsAshokLocalService.deleteNewsAshok(newsAshok);
	}

	/**
	* Deletes the news ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the news ashok
	* @return the news ashok that was removed
	* @throws PortalException if a news ashok with the primary key could not be found
	*/
	@Override
	public com.ddt.model.NewsAshok deleteNewsAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsAshokLocalService.deleteNewsAshok(id);
	}

	@Override
	public com.ddt.model.NewsAshok fetchNewsAshok(long id) {
		return _newsAshokLocalService.fetchNewsAshok(id);
	}

	/**
	* Returns the news ashok with the primary key.
	*
	* @param id the primary key of the news ashok
	* @return the news ashok
	* @throws PortalException if a news ashok with the primary key could not be found
	*/
	@Override
	public com.ddt.model.NewsAshok getNewsAshok(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsAshokLocalService.getNewsAshok(id);
	}

	/**
	* Updates the news ashok in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsAshok the news ashok
	* @return the news ashok that was updated
	*/
	@Override
	public com.ddt.model.NewsAshok updateNewsAshok(
		com.ddt.model.NewsAshok newsAshok) {
		return _newsAshokLocalService.updateNewsAshok(newsAshok);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _newsAshokLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _newsAshokLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _newsAshokLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsAshokLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsAshokLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of news ashoks.
	*
	* @return the number of news ashoks
	*/
	@Override
	public int getNewsAshoksCount() {
		return _newsAshokLocalService.getNewsAshoksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _newsAshokLocalService.getOSGiServiceIdentifier();
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
		return _newsAshokLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _newsAshokLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _newsAshokLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the news ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @return the range of news ashoks
	*/
	@Override
	public java.util.List<com.ddt.model.NewsAshok> getNewsAshoks(int start,
		int end) {
		return _newsAshokLocalService.getNewsAshoks(start, end);
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
		return _newsAshokLocalService.dynamicQueryCount(dynamicQuery);
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
		return _newsAshokLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public NewsAshokLocalService getWrappedService() {
		return _newsAshokLocalService;
	}

	@Override
	public void setWrappedService(NewsAshokLocalService newsAshokLocalService) {
		_newsAshokLocalService = newsAshokLocalService;
	}

	private NewsAshokLocalService _newsAshokLocalService;
}