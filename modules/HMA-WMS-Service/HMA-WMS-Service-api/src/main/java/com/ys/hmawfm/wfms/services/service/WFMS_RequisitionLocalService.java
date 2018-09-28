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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for WFMS_Requisition. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_RequisitionLocalServiceUtil
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_RequisitionLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_RequisitionLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WFMS_RequisitionLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_RequisitionLocalServiceUtil} to access the WFMS_Requisition local service. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_RequisitionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Adds the WFMS_Requisition to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_Requisition addWFMS_Requisition(
		WFMS_Requisition wfms_Requisition);

	public WFMS_Requisition addnewRequisition(java.lang.String rwfid,
		long companyId, long scopeGroupId, java.lang.String Number,
		java.lang.String associatenumber, java.lang.String associatename,
		java.lang.String status, java.lang.String postingType,
		java.lang.String teamNumber, java.lang.String associatetype,
		java.lang.String shiftDesc, java.lang.String howAvailable,
		java.lang.String whoReplaced, java.lang.String dateneeded,
		java.lang.String contactperson, java.lang.String contactphonenumber,
		java.lang.String taleonumber, java.lang.String other,
		java.lang.String comments) throws SystemException;

	public WFMS_Requisition addnewtempRequisition(java.lang.String rwfid,
		java.lang.String requisisionnumber, long companyId, long scopeGroupId,
		java.lang.String Number, java.lang.String associatenumber,
		java.lang.String associatename, java.lang.String status,
		java.lang.String postingType, java.lang.String teamNumber,
		java.lang.String associatetype, java.lang.String shiftDesc,
		java.lang.String howAvailable, java.lang.String whoReplaced,
		java.lang.String dateneeded, java.lang.String contactperson,
		java.lang.String contactphonenumber, java.lang.String taleonumber,
		java.lang.String other) throws SystemException;

	/**
	* Creates a new WFMS_Requisition with the primary key. Does not add the WFMS_Requisition to the database.
	*
	* @param rwfId the primary key for the new WFMS_Requisition
	* @return the new WFMS_Requisition
	*/
	public WFMS_Requisition createWFMS_Requisition(java.lang.String rwfId);

	/**
	* Deletes the WFMS_Requisition from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_Requisition deleteWFMS_Requisition(
		WFMS_Requisition wfms_Requisition);

	/**
	* Deletes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	* @throws PortalException if a WFMS_Requisition with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_Requisition deleteWFMS_Requisition(java.lang.String rwfId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Requisition fetchWFMS_Requisition(java.lang.String rwfId);

	public WFMS_Requisition findByposition(java.lang.String rId)
		throws SystemException, NoSuchWFMS_RequisitionException;

	public WFMS_Requisition findBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber)
		throws SystemException, NoSuchWFMS_RequisitionException;

	public WFMS_Requisition findByrequisition(java.lang.String rwfId)
		throws SystemException, NoSuchWFMS_RequisitionException;

	/**
	* Returns the WFMS_Requisition with the primary key.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition
	* @throws PortalException if a WFMS_Requisition with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Requisition getWFMS_Requisition(java.lang.String rwfId)
		throws PortalException;

	public WFMS_Requisition updateRequisition(WFMS_Requisition entry)
		throws SystemException;

	public WFMS_Requisition updateRequisition(
		java.lang.String requisisionnumber, long companyId, long scopeGroupId,
		java.lang.String number, java.lang.String associatenumber,
		java.lang.String associateNameNoNum, java.lang.String status,
		java.lang.String postingType, java.lang.String teamNumber,
		java.lang.String associatetype, java.lang.String shiftDesc,
		java.lang.String howAvilable, java.lang.String whoReplaced,
		java.lang.String dateneeded, java.lang.String contactperson,
		java.lang.String contactphonenumber, java.lang.String taleonumber,
		java.lang.String other, java.lang.String comments)
		throws SystemException;

	/**
	* Updates the WFMS_Requisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Requisition the WFMS_Requisition
	* @return the WFMS_Requisition that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_Requisition updateWFMS_Requisition(
		WFMS_Requisition wfms_Requisition);

	/**
	* Returns the number of WFMS_Requisitions.
	*
	* @return the number of WFMS_Requisitions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWFMS_RequisitionsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<WFMS_Requisition> findByNextApprover(
		java.lang.String nextapprove) throws SystemException;

	public List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover) throws SystemException;

	public List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId)
		throws SystemException;

	public List<WFMS_Requisition> findBydummy(java.lang.String dummy)
		throws SystemException;

	public List<WFMS_Requisition> findBypositionId(java.lang.String rId)
		throws SystemException, NoSuchWFMS_RequisitionException;

	public List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status) throws SystemException;

	public List<WFMS_Requisition> findBypositionnumber(java.lang.String Number)
		throws SystemException, NoSuchWFMS_RequisitionException;

	public List<WFMS_Requisition> findByworkflowId(java.lang.String workflowId)
		throws SystemException;

	/**
	* Returns a range of all the WFMS_Requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of WFMS_Requisitions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_Requisition> getWFMS_Requisitions(int start, int end);

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

	public void clearCache() throws SystemException;
}