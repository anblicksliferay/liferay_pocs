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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_routing_and_approversException;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for WFMS_routing_and_approvers. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_routing_and_approversLocalServiceUtil
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_routing_and_approversLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_routing_and_approversLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WFMS_routing_and_approversLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_routing_and_approversLocalServiceUtil} to access the WFMS_routing_and_approvers local service. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_routing_and_approversLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public DynamicQuery dynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the WFMS_routing_and_approvers to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_routing_and_approvers addWFMS_routing_and_approvers(
		WFMS_routing_and_approvers wfms_routing_and_approvers);

	/**
	* Creates a new WFMS_routing_and_approvers with the primary key. Does not add the WFMS_routing_and_approvers to the database.
	*
	* @param rapId the primary key for the new WFMS_routing_and_approvers
	* @return the new WFMS_routing_and_approvers
	*/
	public WFMS_routing_and_approvers createWFMS_routing_and_approvers(
		java.lang.String rapId);

	/**
	* Deletes the WFMS_routing_and_approvers from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_routing_and_approvers deleteWFMS_routing_and_approvers(
		WFMS_routing_and_approvers wfms_routing_and_approvers);

	/**
	* Deletes the WFMS_routing_and_approvers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was removed
	* @throws PortalException if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_routing_and_approvers deleteWFMS_routing_and_approvers(
		java.lang.String rapId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_routing_and_approvers fetchWFMS_routing_and_approvers(
		java.lang.String rapId);

	public WFMS_routing_and_approvers findByrouting(java.lang.String rapId)
		throws SystemException, NoSuchWFMS_routing_and_approversException;

	/**
	* Returns the WFMS_routing_and_approvers with the primary key.
	*
	* @param rapId the primary key of the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers
	* @throws PortalException if a WFMS_routing_and_approvers with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_routing_and_approvers getWFMS_routing_and_approvers(
		java.lang.String rapId) throws PortalException;

	/**
	* Updates the WFMS_routing_and_approvers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_routing_and_approvers the WFMS_routing_and_approvers
	* @return the WFMS_routing_and_approvers that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_routing_and_approvers updateWFMS_routing_and_approvers(
		WFMS_routing_and_approvers wfms_routing_and_approvers);

	/**
	* Returns the number of WFMS_routing_and_approverses.
	*
	* @return the number of WFMS_routing_and_approverses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWFMS_routing_and_approversesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the WFMS_routing_and_approverses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_routing_and_approverses
	* @param end the upper bound of the range of WFMS_routing_and_approverses (not inclusive)
	* @return the range of WFMS_routing_and_approverses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_routing_and_approvers> getWFMS_routing_and_approverses(
		int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}