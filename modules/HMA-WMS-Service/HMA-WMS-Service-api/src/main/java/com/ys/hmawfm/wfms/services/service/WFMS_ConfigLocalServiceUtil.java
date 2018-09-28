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

package com.ys.hmawfm.wfms.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for WFMS_Config. This utility wraps
 * {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_ConfigLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_ConfigLocalService
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_ConfigLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_ConfigLocalServiceImpl
 * @generated
 */
@ProviderType
public class WFMS_ConfigLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_ConfigLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.ys.hmawfm.wfms.services.model.WFMS_Config addNewConfig(
		java.lang.String createdBy, java.lang.String configKey,
		java.lang.String configLabel, java.lang.String contentType,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNewConfig(createdBy, configKey, configLabel,
			contentType, content);
	}

	/**
	* Adds the WFMS_Configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Config the WFMS_Configuration
	* @return the WFMS_Configuration that was added
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Config addWFMS_Config(
		com.ys.hmawfm.wfms.services.model.WFMS_Config wfms_Config) {
		return getService().addWFMS_Config(wfms_Config);
	}

	/**
	* Creates a new WFMS_Configuration with the primary key. Does not add the WFMS_Configuration to the database.
	*
	* @param configId the primary key for the new WFMS_Configuration
	* @return the new WFMS_Configuration
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Config createWFMS_Config(
		long configId) {
		return getService().createWFMS_Config(configId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Config deleteConfig(
		long configId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException {
		return getService().deleteConfig(configId);
	}

	/**
	* Deletes the WFMS_Configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Config the WFMS_Configuration
	* @return the WFMS_Configuration that was removed
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Config deleteWFMS_Config(
		com.ys.hmawfm.wfms.services.model.WFMS_Config wfms_Config) {
		return getService().deleteWFMS_Config(wfms_Config);
	}

	/**
	* Deletes the WFMS_Configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration that was removed
	* @throws PortalException if a WFMS_Configuration with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Config deleteWFMS_Config(
		long configId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWFMS_Config(configId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Config fetchWFMS_Config(
		long configId) {
		return getService().fetchWFMS_Config(configId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Config getByConfigId(
		long configId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByConfigId(configId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Config getByConfigKey(
		java.lang.String configKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByConfigKey(configKey);
	}

	/**
	* Returns the WFMS_Configuration with the primary key.
	*
	* @param configId the primary key of the WFMS_Configuration
	* @return the WFMS_Configuration
	* @throws PortalException if a WFMS_Configuration with the primary key could not be found
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Config getWFMS_Config(
		long configId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWFMS_Config(configId);
	}

	public static com.ys.hmawfm.wfms.services.model.WFMS_Config updateConfig(
		long configId, java.lang.String modifiedBy, java.lang.String configKey,
		java.lang.String configLabel, java.lang.String contentType,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConfig(configId, modifiedBy, configKey, configLabel,
			contentType, content);
	}

	/**
	* Updates the WFMS_Configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Config the WFMS_Configuration
	* @return the WFMS_Configuration that was updated
	*/
	public static com.ys.hmawfm.wfms.services.model.WFMS_Config updateWFMS_Config(
		com.ys.hmawfm.wfms.services.model.WFMS_Config wfms_Config) {
		return getService().updateWFMS_Config(wfms_Config);
	}

	/**
	* Returns the number of WFMS_Configurations.
	*
	* @return the number of WFMS_Configurations
	*/
	public static int getWFMS_ConfigsCount() {
		return getService().getWFMS_ConfigsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Config> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	/**
	* Returns a range of all the WFMS_Configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Configurations
	* @param end the upper bound of the range of WFMS_Configurations (not inclusive)
	* @return the range of WFMS_Configurations
	*/
	public static java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Config> getWFMS_Configs(
		int start, int end) {
		return getService().getWFMS_Configs(start, end);
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

	public static WFMS_ConfigLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_ConfigLocalService, WFMS_ConfigLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_ConfigLocalService.class);
}