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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for WFMS_COS. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSLocalServiceUtil
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_COSLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_COSLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WFMS_COSLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_COSLocalServiceUtil} to access the WFMS_COS local service. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_COSLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public WFMS_COS addNewCos(long companyId, long scopeGroupId,
		java.lang.String createdBy, java.lang.String assoicateId,
		java.lang.String comments) throws SystemException;

	/**
	* Adds the WFMS_COS to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos the WFMS_COS
	* @return the WFMS_COS that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_COS addWFMS_COS(WFMS_COS wfms_cos);

	/**
	* Creates a new WFMS_COS with the primary key. Does not add the WFMS_COS to the database.
	*
	* @param cosId the primary key for the new WFMS_COS
	* @return the new WFMS_COS
	*/
	public WFMS_COS createWFMS_COS(java.lang.String cosId);

	/**
	* Deletes the WFMS_COS from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos the WFMS_COS
	* @return the WFMS_COS that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_COS deleteWFMS_COS(WFMS_COS wfms_cos);

	/**
	* Deletes the WFMS_COS with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS that was removed
	* @throws PortalException if a WFMS_COS with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_COS deleteWFMS_COS(java.lang.String cosId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_COS fetchWFMS_COS(java.lang.String cosId);

	public WFMS_COS findByassociateId(java.lang.String assoicateId)
		throws SystemException, NoSuchWFMS_COSException;

	public WFMS_COS findBycos(java.lang.String cosId)
		throws SystemException, NoSuchWFMS_COSException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_COS getByAssociatenumber(java.lang.String associatenumber)
		throws SystemException, NoSuchWFMS_PositionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_COS getByCOSId(java.lang.String cosId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_COS getByCOSId(long cosId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_COS getByCos(java.lang.String cosId)
		throws SystemException, NoSuchWFMS_PositionException;

	/**
	* Returns the WFMS_COS with the primary key.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS
	* @throws PortalException if a WFMS_COS with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_COS getWFMS_COS(java.lang.String cosId)
		throws PortalException;

	public WFMS_COS updateCos(WFMS_COS entry) throws SystemException;

	public WFMS_COS updateCos(java.lang.String cosId, long companyId,
		long scopeGroupId, java.lang.String createdBy, java.lang.String action,
		java.lang.String associatenumber, java.lang.String comments,
		java.lang.String associateTitle, java.lang.String assoicateId,
		java.lang.String departmentNumber, java.lang.String positionNumber,
		java.lang.String leadershipAssignment, java.lang.String number,
		java.lang.String status, java.lang.String manpowerReq,
		java.lang.String nextApprover, java.lang.String routingProcess,
		java.lang.String notificationTo) throws SystemException, IOException;

	/**
	* Updates the WFMS_COS in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_cos the WFMS_COS
	* @return the WFMS_COS that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_COS updateWFMS_COS(WFMS_COS wfms_cos);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Position getByPositionId(java.lang.String positionId)
		throws SystemException;

	/**
	* Returns the number of WFMS_COSs.
	*
	* @return the number of WFMS_COSs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWFMS_COSsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<WFMS_COS> findByAssociatenumber(
		java.lang.String associatenumber) throws SystemException;

	public List<WFMS_COS> findByNextApprover(java.lang.String nextApprover)
		throws SystemException;

	public List<WFMS_COS> findByRoleOfApprover(java.lang.String roleOfApprover)
		throws SystemException;

	public List<WFMS_COS> findBycosIdGetByPosId(java.lang.String positionNumber)
		throws SystemException;

	public List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber)
		throws SystemException, NoSuchWFMS_COSException;

	public List<WFMS_COS> findBypositionIdGetByStaus(java.lang.String status)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_COS> getAll() throws SystemException;

	/**
	* Returns a range of all the WFMS_COSs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of WFMS_COSs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_COS> getWFMS_COSs(int start, int end);

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