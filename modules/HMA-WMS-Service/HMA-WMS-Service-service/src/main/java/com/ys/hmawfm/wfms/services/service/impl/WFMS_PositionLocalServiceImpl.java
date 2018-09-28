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

package com.ys.hmawfm.wfms.services.service.impl;

import java.util.Date;
import java.util.List;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.base.WFMS_PositionLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_Position local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_PositionLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil
 */
public class WFMS_PositionLocalServiceImpl
	extends WFMS_PositionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil} to access the WFMS_Position local service.
	 */
	
public WFMS_Position addNewEmptyPosition() throws SystemException {
		
		WFMS_Position entry = wfms_PositionPersistence.create("TMP-"+counterLocalService.increment(WFMS_Position.class.getName()));
		return wfms_PositionPersistence.update(entry);
	}

	

	public WFMS_Position addNewPosition(String  pid,  String reqId, long companyId, long scopeGroupId, String createdBy, String status, 
			String positionDescription, String reportedTo, String isAutoGenerate, boolean isCriticalWorkSegment, 
			String division, String deptName, String deptNumber, String line, String ladder, String mpCatBugdet,
			String mpCatFilledWith,String positionClass,String type,String level,String leadershipAssignment,String category,
			String subCategory,String workforceCategory,String empCategory,String empCategoryDesc,String yearEst,String reasonsFor,
			String reavailuationDate,String associateName, String associateNumber,String associatetitle,String comments,
			String typicalJobTitle,String minJobKnowHow,String duties,String tasksPerformed,String lengthOfService,
			String degree,String reqSkills,String desiredSkills,String environment,String weeklyOvertime,String frequencyOfTravel,
			String history,String other,String deptManager, String divisionManager,String workflowConfigKey ,int workflowStep) throws SystemException, PortalException {

		WFMS_Position entry = new WFMS_PositionImpl();
		if(status.equalsIgnoreCase("Draft")){
			entry.setPId(pid.concat("-WFM"));
		}
		if(status.equalsIgnoreCase("Pending")){
			entry.setPId(pid);
		}
		
		entry.setWorkflowId(pid.concat("-WFM"));
		entry.setCompanyId(companyId);
		entry.setScopeGroupId(scopeGroupId);
		entry.setCreatedBy(createdBy);
		
		entry.setCreateDate(new java.util.Date());
		entry.setActive(false);
		entry.setAssociateName(createdBy);
		entry.setAssociateNumber(associateNumber);
		entry.setComments(comments);
		entry.setAssociateTitle(associateName);
		entry.setDepartmentNumber(deptNumber);
		entry.setStatus(status);
		entry.setDescription(positionDescription);
		entry.setReportsTo(reportedTo);
		entry.setAutoGenerateReq(isAutoGenerate);	
		entry.setCritical(isCriticalWorkSegment);
		entry.setDivision(division);
		entry.setDepartmentName(deptName);
		entry.setLine(line);
		entry.setLadder(ladder);
		entry.setMpCatBugdet(mpCatBugdet);
		entry.setMpCatFilledWith(mpCatFilledWith);
		entry.setPositionClass(positionClass);
		entry.setType(type);
		entry.setLevel(level);
		entry.setLeadershipAssignment(leadershipAssignment);
		entry.setCategory(category);
		entry.setSubCategory(subCategory);
		entry.setWorkforceCategory(workforceCategory);
		entry.setEmpCategory(empCategory);
		entry.setEmpCategoryDesc(empCategoryDesc);
		entry.setYearEst(yearEst);
		entry.setReasonsFor(reasonsFor);
		entry.setReavailuationDate(reavailuationDate);
		entry.setAssociateNumber(associateNumber);
		entry.setAssociateName(associateName);
		//pos.setAssociateTitle(associateTitle);
		entry.setComments(comments);
		entry.setTypicalJobTitle(typicalJobTitle);
		entry.setMinJobKnowHow(minJobKnowHow);
		entry.setDuties(duties);
		entry.setTasksPerformed(tasksPerformed);
		entry.setLengthOfService(lengthOfService);
		entry.setDegree(degree);
		entry.setReqSkills(reqSkills);
		entry.setDesiredSkills(desiredSkills);
		entry.setEnvironment(environment);
		entry.setWeeklyOvertime(weeklyOvertime);
		entry.setFrequencyOfTravel(frequencyOfTravel);
		entry.setHistory("");
		entry.setOther(other);
		entry.setDivisionManager(divisionManager);
		entry.setDepartmentManager(deptManager);
		entry.setDummy("0");
		entry.setRefPosId(pid);
		entry.setWorkflow(workflowConfigKey);
		entry.setWorkflowStep(0);
		//if auto generated requisition true create requisition with Draft status
		/*if(isAutoGenerate.equalsIgnoreCase("true")){
			//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<isAutoGeneratessssssssssssssssss3434343434>>>>>>>>>>>>>>>>>>>>>>>");
			status="Draft";
			WFMS_Requisition req = new WFMS_RequisitionImpl();
	      	req.setRwfId(reqId);
	      	req.setStatus(status);
	      	req.setRId(pid);
	      	req.setCompanyId(companyId);
	      	req.setScopeGroupId(scopeGroupId);
	      	req.setNumber(pid);
	      	req.setAssociatenumber(associateNumber);
	      	req.setAssociatename(associateName);
	      	req.setStatus(status);
	      	req.setDummy("0");
	      	req.setWorkflowStep(0);
	      	Date now = new Date();
	        req.setCreateDate(now);
	        //Sending mail about requsition details.
	      	WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req);
			HondaLogicUtil.auditLogsForReqAndCOS(reqId, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request, comments);

			
		}*/
	
		return wfms_PositionPersistence.update(entry);
	}
	
	
	public WFMS_Position addnewtempPosition(String positionId, String requisitonId,long companyId, long scopeGroupId, String createdBy, String status, 
			String positionDescription, String reportedTo, String isAutoGenerate, boolean isCriticalWorkSegment, 
			String division, String deptName, String deptNumber, String line, String ladder, String mpCatBugdet,
			String mpCatFilledWith,String positionClass,String type,String level,String leadershipAssignment,String category,
			String subCategory,String workforceCategory,String empCategory,String empCategoryDesc,String yearEst,String reasonsFor,
			String reavailuationDate,String associateName, String associateNumber,String associatetitle,String comments,
			String typicalJobTitle,String minJobKnowHow,String duties,String tasksPerformed,String lengthOfService,
			String degree,String reqSkills,String desiredSkills,String environment,String weeklyOvertime,String frequencyOfTravel,
			String history,String other,String deptManager, String divisionManager,String positionid ) throws SystemException
	{
							WFMS_Position entry = new WFMS_PositionImpl();
					entry.setPId(positionid.concat("-WFM"));
					//entry.setWorkflowId("");
					entry.setCompanyId(companyId);
					entry.setScopeGroupId(scopeGroupId);
					entry.setCreatedBy(createdBy);
					//entry.setCreateDate(new java.util.Date());
					entry.setActive(false);
					entry.setAssociateName(createdBy);
					entry.setAssociateNumber(associateNumber);
					entry.setComments(comments);
					entry.setAssociateTitle(associateName);
					entry.setDepartmentNumber(deptNumber);
					entry.setStatus(status);
					entry.setDescription(positionDescription);
					entry.setReportsTo(reportedTo);
					entry.setAutoGenerateReq(isAutoGenerate);	
					entry.setCritical(isCriticalWorkSegment);
					entry.setDivision(division);
					entry.setDepartmentName(deptName);
					entry.setLine(line);
					entry.setLadder(ladder);
					entry.setMpCatBugdet(mpCatBugdet);
					entry.setMpCatFilledWith(mpCatFilledWith);
					entry.setPositionClass(positionClass);
					entry.setType(type);
					entry.setLevel(level);
					entry.setLeadershipAssignment(leadershipAssignment);
					entry.setCategory(category);
					entry.setSubCategory(subCategory);
					entry.setWorkforceCategory(workforceCategory);
					entry.setEmpCategory(empCategory);
					entry.setEmpCategoryDesc(empCategoryDesc);
					entry.setYearEst(yearEst);
					entry.setReasonsFor(reasonsFor);
					entry.setReavailuationDate(reavailuationDate);
					entry.setAssociateNumber(associateNumber);
					entry.setAssociateName(associateName);
					//pos.setAssociateTitle(associateTitle);
					entry.setComments(comments);
					entry.setTypicalJobTitle(typicalJobTitle);
					entry.setMinJobKnowHow(minJobKnowHow);
					entry.setDuties(duties);
					entry.setTasksPerformed(tasksPerformed);
					entry.setLengthOfService(lengthOfService);
					entry.setDegree(degree);
					entry.setReqSkills(reqSkills);
					entry.setDesiredSkills(desiredSkills);
					entry.setEnvironment(environment);
					entry.setWeeklyOvertime(weeklyOvertime);
					entry.setFrequencyOfTravel(frequencyOfTravel);
					entry.setHistory("");
					entry.setOther(other);
					entry.setDivisionManager(divisionManager);
					entry.setDepartmentManager(deptManager);
					entry.setDummy("0");
					entry.setRefPosId(positionid);
					entry.setModifiedDate(new Date());
					
					//wfm
					//if auto generated requisition true create requisition with Draft status
								if(isAutoGenerate.equalsIgnoreCase("true")){
								status="Draft";
								WFMS_Requisition req = new WFMS_RequisitionImpl();
								
								
									req.setRwfId(requisitonId);
									req.setStatus(status);
									req.setRId(positionid);
									req.setCompanyId(companyId);
									req.setScopeGroupId(scopeGroupId);
									req.setNumber(positionid);
									req.setAssociatenumber(associateNumber);
									req.setAssociatename(associateName);
									req.setStatus(status);
									Date now = new Date();
								req.setCreateDate(now);
									WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req);
										
								}
						return wfms_PositionPersistence.update(entry);
	
	}
	public WFMS_Position updatePosition( String reqid,String positionId, String modifiedBy, String content, 
			String contentType,String status, String positionDescription, String reportedTo, String isAutoGenerate,
			boolean isCriticalWorkSegment, String division, String deptName, String deptNumber, String line, 
			String ladder, String mpCatBugdet,String mpCatFilledWith,String positionClass,String type,String level,
			String leadershipAssignment,String category,String subCategory,String workforceCategory,String empCategory,
			String empCategoryDesc,String yearEst,String reasonsFor,String reavailuationDate,String associateName, 
			String associateNumber,String associatetitle,String comments,String typicalJobTitle,String minJobKnowHow,
			String duties,String tasksPerformed,String lengthOfService,String degree,String reqSkills,String desiredSkills,
			String environment,String weeklyOvertime,String frequencyOfTravel,String history,String other,String deptManager, 
			String divisionManager,  long companyId, long scopeGroupId) throws SystemException {

		
		//WFMS_Position entry = new WFMS_PositionImpl();
		WFMS_Position entry = wfms_PositionPersistence.fetchByposition(positionId);
		if(entry.getWorkflowStep() == 0){
			entry.setPId(entry.getRefPosId());
		}else{
		entry.setPId(positionId);
		}
		entry.setModifiedBy(modifiedBy);
		entry.setModifiedDate(new java.util.Date());
		entry.setActive(false);
		entry.setAssociateName(associateName);
		entry.setAssociateNumber(associateNumber);;
		entry.setAssociateTitle(associatetitle);
		entry.setDepartmentName(deptName);
		entry.setDescription(positionDescription);
		entry.setReportsTo(reportedTo);
		entry.setAutoGenerateReq(isAutoGenerate);	
		entry.setCritical(isCriticalWorkSegment);
		entry.setDivision(division);
		entry.setDepartmentName(deptName);
		entry.setLine(line);
		entry.setLadder(ladder);
		entry.setMpCatBugdet(mpCatBugdet);
		entry.setMpCatFilledWith(mpCatFilledWith);
		entry.setPositionClass(positionClass);
		entry.setType(type);
		entry.setLevel(level);
		entry.setLeadershipAssignment(leadershipAssignment);
		entry.setCategory(category);
		entry.setSubCategory(subCategory);
		entry.setWorkforceCategory(workforceCategory);
		entry.setEmpCategory(empCategory);
		entry.setEmpCategoryDesc(empCategoryDesc);
		entry.setYearEst(yearEst);
		entry.setReasonsFor(reasonsFor);
		entry.setReavailuationDate(reavailuationDate);
		entry.setAssociateName(associateName);
		//pos.setAssociateTitle(associateTitle);
		entry.setComments(comments);
		entry.setTypicalJobTitle(typicalJobTitle);
		entry.setMinJobKnowHow(minJobKnowHow);
		entry.setDuties(duties);
		entry.setTasksPerformed(tasksPerformed);
		entry.setLengthOfService(lengthOfService);
		entry.setDegree(degree);
		entry.setReqSkills(reqSkills);
		entry.setStatus(status);
		entry.setDesiredSkills(desiredSkills);
		entry.setEnvironment(environment);
		entry.setWeeklyOvertime(weeklyOvertime);
		entry.setFrequencyOfTravel(frequencyOfTravel);
		entry.setHistory("");
		entry.setOther(other);
		entry.setDivisionManager(divisionManager);
		entry.setDepartmentManager(deptManager);
		entry.setDepartmentNumber(deptNumber);
		entry.setModifiedDate(new Date());
		String te="";
		String id="";
		
		if(isAutoGenerate.equalsIgnoreCase("true") && status.equalsIgnoreCase("Open")){
			//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<isAutoGenerate44444444444444444444>>>>>>>>>>>>>>>>>>>>>>>");
	
			status="Draft";
			WFMS_Requisition req = new WFMS_RequisitionImpl();
				
		/*	String reqid="";*/
		/*	if(Validator.isNotNull(deptNumber)){
				try {
					reqid = hondaLogicUtil.geneateRequisitionId(deptNumber);
				} catch (com.liferay.portal.kernel.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

			}*/
				req.setRwfId(reqid);
				req.setStatus(status);
				req.setRId(id);
				req.setCompanyId(companyId);
				req.setScopeGroupId(scopeGroupId);
				req.setNumber(id);
				req.setAssociatenumber(associateNumber);
				req.setAssociatename(associateName);
				req.setStatus(status);
				Date now = new Date();
			req.setCreateDate(now);
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req);
					
			}
		return wfms_PositionPersistence.update(entry);
	}

	public List<WFMS_Position> getAll() throws SystemException {
		return wfms_PositionPersistence.findAll();
	}
	
	public void clearCache() throws SystemException {
		wfms_PositionPersistence.clearCache();
	}
	
	public WFMS_Position getByPositionId(String positionId) throws SystemException {
		
		WFMS_Position positionObj = null;
		try {
			positionObj = wfms_PositionPersistence.findByPrimaryKey(positionId);
		} catch (NoSuchWFMS_PositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return positionObj;
	}
	
	public java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position> findByAssociateNumber(
			java.lang.String associateNumber)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_PositionPersistence.findByAssociateNumber(associateNumber);
		}
	
	public WFMS_Position getByAssociateNumber(String associateNumber)
			throws SystemException, NoSuchWFMS_PositionException {
		
		WFMS_Position positionObj1 = null;
		positionObj1 = (WFMS_Position) wfms_PositionPersistence.findByAssociateNumber(associateNumber);
		
		return positionObj1;
	}
	
	public WFMS_Position updatePositionEntry(WFMS_Position entry)
			throws SystemException {
		
		return wfms_PositionPersistence.update(entry);
	}

	public WFMS_Position deletePosition(String positionId)
			throws SystemException, NoSuchWFMS_PositionException {
		
		return wfms_PositionPersistence.remove(positionId);
	}
	
	public void removeAllPositions()
			throws SystemException, NoSuchWFMS_PositionException {
		
		wfms_PositionPersistence.removeAll();
	}
	
	public List<WFMS_Position> findByautoGenerateReq(String autoGenerateReq)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_PositionPersistence.findByautoGenerateReq(autoGenerateReq);
	}
	/**
	 * 
	 */
	public  WFMS_Position findByposition(
			java.lang.String pId)
			throws com.liferay.portal.kernel.exception.SystemException,
			NoSuchWFMS_PositionException {
			return wfms_PositionPersistence.findByposition(pId);
	}
	
	/**
	 * 
	 */
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position> findBypositionIdGetByStaus(
			java.lang.String status)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_PositionPersistence.findBypositionIdGetByStaus(status);
		}

	/**
	 * 
	 */
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position> findByDepartmentName(
			java.lang.String departmentName)
					throws com.liferay.portal.kernel.exception.SystemException {
		return wfms_PositionPersistence.findByDepartmentName(departmentName);
	}
	
	public List<WFMS_Position> findBydummy(String dummy)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_PositionPersistence.findBydummy(dummy);
	}

	
	public List<WFMS_Position> findByworkflowId(String workflowId)
			   throws com.liferay.portal.kernel.exception.SystemException {
			   return wfms_PositionPersistence.findByworkflowId(workflowId);
			 }
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position> findByrefPosId(
			java.lang.String refPosId)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_PositionPersistence.findByrefPosId(refPosId);
		}
	
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Position> findByReportsTo(
			java.lang.String reportsTo)
					throws com.liferay.portal.kernel.exception.SystemException {
		return wfms_PositionPersistence.findByReportsTo(reportsTo);
	}
	
	public List<WFMS_Position> findByNextApprover(String nextApprover)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_PositionPersistence.findByNextApprover(nextApprover);
	}   

	public WFMS_Position addnewtempPosition(long companyId, long scopeGroupId, String createdBy, String status,
			String positionDescription, String reportedTo, String isAutoGenerate, boolean isCriticalWorkSegment,
			String division, String deptName, String deptNumber, String line, String ladder, String mpCatBugdet,
			String mpCatFilledWith, String positionClass, String type, String level, String leadershipAssignment,
			String category, String subCategory, String workforceCategory, String empCategory, String empCategoryDesc,
			String yearEst, String reasonsFor, String reavailuationDate, String associateName, String associateNumber,
			String associatetitle, String comments, String typicalJobTitle, String minJobKnowHow, String duties,
			String tasksPerformed, String lengthOfService, String degree, String reqSkills, String desiredSkills,
			String environment, String weeklyOvertime, String frequencyOfTravel, String history, String other,
			String deptManager, String divisionManager) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}
}