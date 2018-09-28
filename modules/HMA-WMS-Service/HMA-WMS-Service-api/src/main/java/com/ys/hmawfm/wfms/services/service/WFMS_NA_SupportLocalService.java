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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NA_SupportException;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for WFMS_NA_Support. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_SupportLocalServiceUtil
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_NA_SupportLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_NA_SupportLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WFMS_NA_SupportLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_NA_SupportLocalServiceUtil} to access the WFMS_NA_Support local service. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_NA_SupportLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public WFMS_NA_Support addNewEmptyassociate() throws SystemException;

	/**
	* Adds the WFMS_NA_Support to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	* @return the WFMS_NA_Support that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_NA_Support addWFMS_NA_Support(WFMS_NA_Support wfms_na_Support);

	/**
	* Creates a new WFMS_NA_Support with the primary key. Does not add the WFMS_NA_Support to the database.
	*
	* @param ASSOCIATE_NUMBER the primary key for the new WFMS_NA_Support
	* @return the new WFMS_NA_Support
	*/
	public WFMS_NA_Support createWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER);

	/**
	* Deletes the WFMS_NA_Support from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	* @return the WFMS_NA_Support that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_NA_Support deleteWFMS_NA_Support(
		WFMS_NA_Support wfms_na_Support);

	/**
	* Deletes the WFMS_NA_Support with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support that was removed
	* @throws PortalException if a WFMS_NA_Support with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_NA_Support deleteWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_NA_Support fetchWFMS_NA_Support(
		java.lang.String ASSOCIATE_NUMBER);

	public WFMS_NA_Support findBynaSupport(java.lang.String ASSOCIATE_NUMBER)
		throws SystemException, NoSuchWFMS_NA_SupportException;

	/**
	* Returns the WFMS_NA_Support with the primary key.
	*
	* @param ASSOCIATE_NUMBER the primary key of the WFMS_NA_Support
	* @return the WFMS_NA_Support
	* @throws PortalException if a WFMS_NA_Support with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_NA_Support getWFMS_NA_Support(java.lang.String ASSOCIATE_NUMBER)
		throws PortalException;

	/**
	* Updates the WFMS_NA_Support in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_na_Support the WFMS_NA_Support
	* @return the WFMS_NA_Support that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_NA_Support updateWFMS_NA_Support(
		WFMS_NA_Support wfms_na_Support);

	public WFMS_NA_Support updateassociatedata(WFMS_NA_Support entry)
		throws SystemException;

	/**
	* Returns the number of WFMS_NA_Supports.
	*
	* @return the number of WFMS_NA_Supports
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWFMS_NA_SupportsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the WFMS_NA_Supports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NA_Supports
	* @param end the upper bound of the range of WFMS_NA_Supports (not inclusive)
	* @return the range of WFMS_NA_Supports
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_NA_Support> getWFMS_NA_Supports(int start, int end);

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