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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for WFMS_Position. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_PositionLocalServiceUtil
 * @see com.ys.hmawfm.wfms.services.service.base.WFMS_PositionLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.impl.WFMS_PositionLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WFMS_PositionLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_PositionLocalServiceUtil} to access the WFMS_Position local service. Add custom service methods to {@link com.ys.hmawfm.wfms.services.service.impl.WFMS_PositionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public WFMS_Position addNewEmptyPosition() throws SystemException;

	public WFMS_Position addNewPosition(java.lang.String pid,
		java.lang.String reqId, long companyId, long scopeGroupId,
		java.lang.String createdBy, java.lang.String status,
		java.lang.String positionDescription, java.lang.String reportedTo,
		java.lang.String isAutoGenerate, boolean isCriticalWorkSegment,
		java.lang.String division, java.lang.String deptName,
		java.lang.String deptNumber, java.lang.String line,
		java.lang.String ladder, java.lang.String mpCatBugdet,
		java.lang.String mpCatFilledWith, java.lang.String positionClass,
		java.lang.String type, java.lang.String level,
		java.lang.String leadershipAssignment, java.lang.String category,
		java.lang.String subCategory, java.lang.String workforceCategory,
		java.lang.String empCategory, java.lang.String empCategoryDesc,
		java.lang.String yearEst, java.lang.String reasonsFor,
		java.lang.String reavailuationDate, java.lang.String associateName,
		java.lang.String associateNumber, java.lang.String associatetitle,
		java.lang.String comments, java.lang.String typicalJobTitle,
		java.lang.String minJobKnowHow, java.lang.String duties,
		java.lang.String tasksPerformed, java.lang.String lengthOfService,
		java.lang.String degree, java.lang.String reqSkills,
		java.lang.String desiredSkills, java.lang.String environment,
		java.lang.String weeklyOvertime, java.lang.String frequencyOfTravel,
		java.lang.String history, java.lang.String other,
		java.lang.String deptManager, java.lang.String divisionManager,
		java.lang.String workflowConfigKey, int workflowStep)
		throws PortalException, SystemException;

	/**
	* Adds the WFMS_Position to the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Position the WFMS_Position
	* @return the WFMS_Position that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_Position addWFMS_Position(WFMS_Position wfms_Position);

	public WFMS_Position addnewtempPosition(java.lang.String positionId,
		java.lang.String requisitonId, long companyId, long scopeGroupId,
		java.lang.String createdBy, java.lang.String status,
		java.lang.String positionDescription, java.lang.String reportedTo,
		java.lang.String isAutoGenerate, boolean isCriticalWorkSegment,
		java.lang.String division, java.lang.String deptName,
		java.lang.String deptNumber, java.lang.String line,
		java.lang.String ladder, java.lang.String mpCatBugdet,
		java.lang.String mpCatFilledWith, java.lang.String positionClass,
		java.lang.String type, java.lang.String level,
		java.lang.String leadershipAssignment, java.lang.String category,
		java.lang.String subCategory, java.lang.String workforceCategory,
		java.lang.String empCategory, java.lang.String empCategoryDesc,
		java.lang.String yearEst, java.lang.String reasonsFor,
		java.lang.String reavailuationDate, java.lang.String associateName,
		java.lang.String associateNumber, java.lang.String associatetitle,
		java.lang.String comments, java.lang.String typicalJobTitle,
		java.lang.String minJobKnowHow, java.lang.String duties,
		java.lang.String tasksPerformed, java.lang.String lengthOfService,
		java.lang.String degree, java.lang.String reqSkills,
		java.lang.String desiredSkills, java.lang.String environment,
		java.lang.String weeklyOvertime, java.lang.String frequencyOfTravel,
		java.lang.String history, java.lang.String other,
		java.lang.String deptManager, java.lang.String divisionManager,
		java.lang.String positionid) throws SystemException;

	public WFMS_Position addnewtempPosition(long companyId, long scopeGroupId,
		java.lang.String createdBy, java.lang.String status,
		java.lang.String positionDescription, java.lang.String reportedTo,
		java.lang.String isAutoGenerate, boolean isCriticalWorkSegment,
		java.lang.String division, java.lang.String deptName,
		java.lang.String deptNumber, java.lang.String line,
		java.lang.String ladder, java.lang.String mpCatBugdet,
		java.lang.String mpCatFilledWith, java.lang.String positionClass,
		java.lang.String type, java.lang.String level,
		java.lang.String leadershipAssignment, java.lang.String category,
		java.lang.String subCategory, java.lang.String workforceCategory,
		java.lang.String empCategory, java.lang.String empCategoryDesc,
		java.lang.String yearEst, java.lang.String reasonsFor,
		java.lang.String reavailuationDate, java.lang.String associateName,
		java.lang.String associateNumber, java.lang.String associatetitle,
		java.lang.String comments, java.lang.String typicalJobTitle,
		java.lang.String minJobKnowHow, java.lang.String duties,
		java.lang.String tasksPerformed, java.lang.String lengthOfService,
		java.lang.String degree, java.lang.String reqSkills,
		java.lang.String desiredSkills, java.lang.String environment,
		java.lang.String weeklyOvertime, java.lang.String frequencyOfTravel,
		java.lang.String history, java.lang.String other,
		java.lang.String deptManager, java.lang.String divisionManager)
		throws SystemException;

	/**
	* Creates a new WFMS_Position with the primary key. Does not add the WFMS_Position to the database.
	*
	* @param pId the primary key for the new WFMS_Position
	* @return the new WFMS_Position
	*/
	public WFMS_Position createWFMS_Position(java.lang.String pId);

	public WFMS_Position deletePosition(java.lang.String positionId)
		throws SystemException, NoSuchWFMS_PositionException;

	/**
	* Deletes the WFMS_Position from the database. Also notifies the appropriate model listeners.
	*
	* @param wfms_Position the WFMS_Position
	* @return the WFMS_Position that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_Position deleteWFMS_Position(WFMS_Position wfms_Position);

	/**
	* Deletes the WFMS_Position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position that was removed
	* @throws PortalException if a WFMS_Position with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public WFMS_Position deleteWFMS_Position(java.lang.String pId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Position fetchWFMS_Position(java.lang.String pId);

	public WFMS_Position findByposition(java.lang.String pId)
		throws SystemException, NoSuchWFMS_PositionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Position getByAssociateNumber(java.lang.String associateNumber)
		throws SystemException, NoSuchWFMS_PositionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Position getByPositionId(java.lang.String positionId)
		throws SystemException;

	/**
	* Returns the WFMS_Position with the primary key.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position
	* @throws PortalException if a WFMS_Position with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WFMS_Position getWFMS_Position(java.lang.String pId)
		throws PortalException;

	public WFMS_Position updatePosition(java.lang.String reqid,
		java.lang.String positionId, java.lang.String modifiedBy,
		java.lang.String content, java.lang.String contentType,
		java.lang.String status, java.lang.String positionDescription,
		java.lang.String reportedTo, java.lang.String isAutoGenerate,
		boolean isCriticalWorkSegment, java.lang.String division,
		java.lang.String deptName, java.lang.String deptNumber,
		java.lang.String line, java.lang.String ladder,
		java.lang.String mpCatBugdet, java.lang.String mpCatFilledWith,
		java.lang.String positionClass, java.lang.String type,
		java.lang.String level, java.lang.String leadershipAssignment,
		java.lang.String category, java.lang.String subCategory,
		java.lang.String workforceCategory, java.lang.String empCategory,
		java.lang.String empCategoryDesc, java.lang.String yearEst,
		java.lang.String reasonsFor, java.lang.String reavailuationDate,
		java.lang.String associateName, java.lang.String associateNumber,
		java.lang.String associatetitle, java.lang.String comments,
		java.lang.String typicalJobTitle, java.lang.String minJobKnowHow,
		java.lang.String duties, java.lang.String tasksPerformed,
		java.lang.String lengthOfService, java.lang.String degree,
		java.lang.String reqSkills, java.lang.String desiredSkills,
		java.lang.String environment, java.lang.String weeklyOvertime,
		java.lang.String frequencyOfTravel, java.lang.String history,
		java.lang.String other, java.lang.String deptManager,
		java.lang.String divisionManager, long companyId, long scopeGroupId)
		throws SystemException;

	public WFMS_Position updatePositionEntry(WFMS_Position entry)
		throws SystemException;

	/**
	* Updates the WFMS_Position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wfms_Position the WFMS_Position
	* @return the WFMS_Position that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public WFMS_Position updateWFMS_Position(WFMS_Position wfms_Position);

	/**
	* Returns the number of WFMS_Positions.
	*
	* @return the number of WFMS_Positions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWFMS_PositionsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber) throws SystemException;

	public List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName) throws SystemException;

	public List<WFMS_Position> findByNextApprover(java.lang.String nextApprover)
		throws SystemException;

	public List<WFMS_Position> findByReportsTo(java.lang.String reportsTo)
		throws SystemException;

	public List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq) throws SystemException;

	public List<WFMS_Position> findBydummy(java.lang.String dummy)
		throws SystemException;

	public List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status) throws SystemException;

	public List<WFMS_Position> findByrefPosId(java.lang.String refPosId)
		throws SystemException;

	public List<WFMS_Position> findByworkflowId(java.lang.String workflowId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_Position> getAll() throws SystemException;

	/**
	* Returns a range of all the WFMS_Positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of WFMS_Positions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WFMS_Position> getWFMS_Positions(int start, int end);

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

	public void removeAllPositions()
		throws SystemException, NoSuchWFMS_PositionException;
}