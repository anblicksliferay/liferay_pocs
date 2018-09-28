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

package com.ys.hmawfm.wfms.services.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WFMS_COS}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS
 * @generated
 */
@ProviderType
public class WFMS_COSWrapper implements WFMS_COS, ModelWrapper<WFMS_COS> {
	public WFMS_COSWrapper(WFMS_COS wfms_cos) {
		_wfms_cos = wfms_cos;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_COS.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_COS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cosId", getCosId());
		attributes.put("assoicateId", getAssoicateId());
		attributes.put("newPositionNumber", getNewPositionNumber());
		attributes.put("action", getAction());
		attributes.put("reasonCODE", getReasonCODE());
		attributes.put("description", getDescription());
		attributes.put("changeDescription", getChangeDescription());
		attributes.put("newJobCode", getNewJobCode());
		attributes.put("sameJobCode", getSameJobCode());
		attributes.put("sameLeadership", getSameLeadership());
		attributes.put("sameDept", getSameDept());
		attributes.put("sameMgr", getSameMgr());
		attributes.put("routingProcess", getRoutingProcess());
		attributes.put("notificationTo", getNotificationTo());
		attributes.put("status", getStatus());
		attributes.put("type", getType());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("teamNumber", getTeamNumber());
		attributes.put("shiftCode", getShiftCode());
		attributes.put("mgrAssociateNumber", getMgrAssociateNumber());
		attributes.put("manpowerCategiry", getManpowerCategiry());
		attributes.put("comments", getComments());
		attributes.put("leadershipAssignment", getLeadershipAssignment());
		attributes.put("associateDateOfHire", getAssociateDateOfHire());
		attributes.put("newDivision", getNewDivision());
		attributes.put("newDivisionManager", getNewDivisionManager());
		attributes.put("newDepartmentName", getNewDepartmentName());
		attributes.put("newDepartmentNumber", getNewDepartmentNumber());
		attributes.put("newDepartmentManager", getNewDepartmentManager());
		attributes.put("newManagerName", getNewManagerName());
		attributes.put("newManagerTitle", getNewManagerTitle());
		attributes.put("deleteflagStatus", getDeleteflagStatus());
		attributes.put("RequistionId", getRequistionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("scopeGroupId", getScopeGroupId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("associatename", getAssociatename());
		attributes.put("relatesTo", getRelatesTo());
		attributes.put("nextApprover", getNextApprover());
		attributes.put("roleOfApprover", getRoleOfApprover());
		attributes.put("approverList", getApproverList());
		attributes.put("approverStep", getApproverStep());
		attributes.put("workflow", getWorkflow());
		attributes.put("workflowStep", getWorkflowStep());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("dummy", getDummy());
		attributes.put("refCosId", getRefCosId());
		attributes.put("systemGenerated", getSystemGenerated());
		attributes.put("positionNumber", getPositionNumber());
		attributes.put("currentJobCode", getCurrentJobCode());
		attributes.put("currentDivision", getCurrentDivision());
		attributes.put("currentDivisionManager", getCurrentDivisionManager());
		attributes.put("currentDepartmentName", getCurrentDepartmentName());
		attributes.put("currentDepartmentNumber", getCurrentDepartmentNumber());
		attributes.put("currentDepartmentManager", getCurrentDepartmentManager());
		attributes.put("currentManagerName", getCurrentManagerName());
		attributes.put("currentManagerTitle", getCurrentManagerTitle());
		attributes.put("currentTeamNumber", getCurrentTeamNumber());
		attributes.put("currentShiftCode", getCurrentShiftCode());
		attributes.put("currentLeadershipAssignment",
			getCurrentLeadershipAssignment());
		attributes.put("currentManpowerRep", getCurrentManpowerRep());
		attributes.put("currentManagerAssocNumber",
			getCurrentManagerAssocNumber());
		attributes.put("sortApprovedList", getSortApprovedList());
		attributes.put("DuplicateApprovedList", getDuplicateApprovedList());
		attributes.put("DuplicateApprovedListStartIndex",
			getDuplicateApprovedListStartIndex());
		attributes.put("DuplicateApprovedListEndIndex",
			getDuplicateApprovedListEndIndex());
		attributes.put("announced", getAnnounced());
		attributes.put("currentPositionText", getCurrentPositionText());
		attributes.put("DuplicateCounter", getDuplicateCounter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String cosId = (String)attributes.get("cosId");

		if (cosId != null) {
			setCosId(cosId);
		}

		String assoicateId = (String)attributes.get("assoicateId");

		if (assoicateId != null) {
			setAssoicateId(assoicateId);
		}

		String newPositionNumber = (String)attributes.get("newPositionNumber");

		if (newPositionNumber != null) {
			setNewPositionNumber(newPositionNumber);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String reasonCODE = (String)attributes.get("reasonCODE");

		if (reasonCODE != null) {
			setReasonCODE(reasonCODE);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String changeDescription = (String)attributes.get("changeDescription");

		if (changeDescription != null) {
			setChangeDescription(changeDescription);
		}

		String newJobCode = (String)attributes.get("newJobCode");

		if (newJobCode != null) {
			setNewJobCode(newJobCode);
		}

		String sameJobCode = (String)attributes.get("sameJobCode");

		if (sameJobCode != null) {
			setSameJobCode(sameJobCode);
		}

		String sameLeadership = (String)attributes.get("sameLeadership");

		if (sameLeadership != null) {
			setSameLeadership(sameLeadership);
		}

		String sameDept = (String)attributes.get("sameDept");

		if (sameDept != null) {
			setSameDept(sameDept);
		}

		String sameMgr = (String)attributes.get("sameMgr");

		if (sameMgr != null) {
			setSameMgr(sameMgr);
		}

		String routingProcess = (String)attributes.get("routingProcess");

		if (routingProcess != null) {
			setRoutingProcess(routingProcess);
		}

		String notificationTo = (String)attributes.get("notificationTo");

		if (notificationTo != null) {
			setNotificationTo(notificationTo);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String effectiveDate = (String)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		String teamNumber = (String)attributes.get("teamNumber");

		if (teamNumber != null) {
			setTeamNumber(teamNumber);
		}

		String shiftCode = (String)attributes.get("shiftCode");

		if (shiftCode != null) {
			setShiftCode(shiftCode);
		}

		String mgrAssociateNumber = (String)attributes.get("mgrAssociateNumber");

		if (mgrAssociateNumber != null) {
			setMgrAssociateNumber(mgrAssociateNumber);
		}

		String manpowerCategiry = (String)attributes.get("manpowerCategiry");

		if (manpowerCategiry != null) {
			setManpowerCategiry(manpowerCategiry);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String leadershipAssignment = (String)attributes.get(
				"leadershipAssignment");

		if (leadershipAssignment != null) {
			setLeadershipAssignment(leadershipAssignment);
		}

		String associateDateOfHire = (String)attributes.get(
				"associateDateOfHire");

		if (associateDateOfHire != null) {
			setAssociateDateOfHire(associateDateOfHire);
		}

		String newDivision = (String)attributes.get("newDivision");

		if (newDivision != null) {
			setNewDivision(newDivision);
		}

		String newDivisionManager = (String)attributes.get("newDivisionManager");

		if (newDivisionManager != null) {
			setNewDivisionManager(newDivisionManager);
		}

		String newDepartmentName = (String)attributes.get("newDepartmentName");

		if (newDepartmentName != null) {
			setNewDepartmentName(newDepartmentName);
		}

		String newDepartmentNumber = (String)attributes.get(
				"newDepartmentNumber");

		if (newDepartmentNumber != null) {
			setNewDepartmentNumber(newDepartmentNumber);
		}

		String newDepartmentManager = (String)attributes.get(
				"newDepartmentManager");

		if (newDepartmentManager != null) {
			setNewDepartmentManager(newDepartmentManager);
		}

		String newManagerName = (String)attributes.get("newManagerName");

		if (newManagerName != null) {
			setNewManagerName(newManagerName);
		}

		String newManagerTitle = (String)attributes.get("newManagerTitle");

		if (newManagerTitle != null) {
			setNewManagerTitle(newManagerTitle);
		}

		Integer deleteflagStatus = (Integer)attributes.get("deleteflagStatus");

		if (deleteflagStatus != null) {
			setDeleteflagStatus(deleteflagStatus);
		}

		String RequistionId = (String)attributes.get("RequistionId");

		if (RequistionId != null) {
			setRequistionId(RequistionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long scopeGroupId = (Long)attributes.get("scopeGroupId");

		if (scopeGroupId != null) {
			setScopeGroupId(scopeGroupId);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String associatename = (String)attributes.get("associatename");

		if (associatename != null) {
			setAssociatename(associatename);
		}

		String relatesTo = (String)attributes.get("relatesTo");

		if (relatesTo != null) {
			setRelatesTo(relatesTo);
		}

		String nextApprover = (String)attributes.get("nextApprover");

		if (nextApprover != null) {
			setNextApprover(nextApprover);
		}

		String roleOfApprover = (String)attributes.get("roleOfApprover");

		if (roleOfApprover != null) {
			setRoleOfApprover(roleOfApprover);
		}

		String approverList = (String)attributes.get("approverList");

		if (approverList != null) {
			setApproverList(approverList);
		}

		Integer approverStep = (Integer)attributes.get("approverStep");

		if (approverStep != null) {
			setApproverStep(approverStep);
		}

		String workflow = (String)attributes.get("workflow");

		if (workflow != null) {
			setWorkflow(workflow);
		}

		Integer workflowStep = (Integer)attributes.get("workflowStep");

		if (workflowStep != null) {
			setWorkflowStep(workflowStep);
		}

		String workflowId = (String)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		String dummy = (String)attributes.get("dummy");

		if (dummy != null) {
			setDummy(dummy);
		}

		String refCosId = (String)attributes.get("refCosId");

		if (refCosId != null) {
			setRefCosId(refCosId);
		}

		Integer systemGenerated = (Integer)attributes.get("systemGenerated");

		if (systemGenerated != null) {
			setSystemGenerated(systemGenerated);
		}

		String positionNumber = (String)attributes.get("positionNumber");

		if (positionNumber != null) {
			setPositionNumber(positionNumber);
		}

		String currentJobCode = (String)attributes.get("currentJobCode");

		if (currentJobCode != null) {
			setCurrentJobCode(currentJobCode);
		}

		String currentDivision = (String)attributes.get("currentDivision");

		if (currentDivision != null) {
			setCurrentDivision(currentDivision);
		}

		String currentDivisionManager = (String)attributes.get(
				"currentDivisionManager");

		if (currentDivisionManager != null) {
			setCurrentDivisionManager(currentDivisionManager);
		}

		String currentDepartmentName = (String)attributes.get(
				"currentDepartmentName");

		if (currentDepartmentName != null) {
			setCurrentDepartmentName(currentDepartmentName);
		}

		String currentDepartmentNumber = (String)attributes.get(
				"currentDepartmentNumber");

		if (currentDepartmentNumber != null) {
			setCurrentDepartmentNumber(currentDepartmentNumber);
		}

		String currentDepartmentManager = (String)attributes.get(
				"currentDepartmentManager");

		if (currentDepartmentManager != null) {
			setCurrentDepartmentManager(currentDepartmentManager);
		}

		String currentManagerName = (String)attributes.get("currentManagerName");

		if (currentManagerName != null) {
			setCurrentManagerName(currentManagerName);
		}

		String currentManagerTitle = (String)attributes.get(
				"currentManagerTitle");

		if (currentManagerTitle != null) {
			setCurrentManagerTitle(currentManagerTitle);
		}

		String currentTeamNumber = (String)attributes.get("currentTeamNumber");

		if (currentTeamNumber != null) {
			setCurrentTeamNumber(currentTeamNumber);
		}

		String currentShiftCode = (String)attributes.get("currentShiftCode");

		if (currentShiftCode != null) {
			setCurrentShiftCode(currentShiftCode);
		}

		String currentLeadershipAssignment = (String)attributes.get(
				"currentLeadershipAssignment");

		if (currentLeadershipAssignment != null) {
			setCurrentLeadershipAssignment(currentLeadershipAssignment);
		}

		String currentManpowerRep = (String)attributes.get("currentManpowerRep");

		if (currentManpowerRep != null) {
			setCurrentManpowerRep(currentManpowerRep);
		}

		String currentManagerAssocNumber = (String)attributes.get(
				"currentManagerAssocNumber");

		if (currentManagerAssocNumber != null) {
			setCurrentManagerAssocNumber(currentManagerAssocNumber);
		}

		String sortApprovedList = (String)attributes.get("sortApprovedList");

		if (sortApprovedList != null) {
			setSortApprovedList(sortApprovedList);
		}

		String DuplicateApprovedList = (String)attributes.get(
				"DuplicateApprovedList");

		if (DuplicateApprovedList != null) {
			setDuplicateApprovedList(DuplicateApprovedList);
		}

		Integer DuplicateApprovedListStartIndex = (Integer)attributes.get(
				"DuplicateApprovedListStartIndex");

		if (DuplicateApprovedListStartIndex != null) {
			setDuplicateApprovedListStartIndex(DuplicateApprovedListStartIndex);
		}

		Integer DuplicateApprovedListEndIndex = (Integer)attributes.get(
				"DuplicateApprovedListEndIndex");

		if (DuplicateApprovedListEndIndex != null) {
			setDuplicateApprovedListEndIndex(DuplicateApprovedListEndIndex);
		}

		Integer announced = (Integer)attributes.get("announced");

		if (announced != null) {
			setAnnounced(announced);
		}

		Integer currentPositionText = (Integer)attributes.get(
				"currentPositionText");

		if (currentPositionText != null) {
			setCurrentPositionText(currentPositionText);
		}

		Integer DuplicateCounter = (Integer)attributes.get("DuplicateCounter");

		if (DuplicateCounter != null) {
			setDuplicateCounter(DuplicateCounter);
		}
	}

	@Override
	public WFMS_COS toEscapedModel() {
		return new WFMS_COSWrapper(_wfms_cos.toEscapedModel());
	}

	@Override
	public WFMS_COS toUnescapedModel() {
		return new WFMS_COSWrapper(_wfms_cos.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_cos.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_cos.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_cos.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_cos.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_COS> toCacheModel() {
		return _wfms_cos.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_COS wfms_cos) {
		return _wfms_cos.compareTo(wfms_cos);
	}

	/**
	* Returns the announced of this WFMS_COS.
	*
	* @return the announced of this WFMS_COS
	*/
	@Override
	public int getAnnounced() {
		return _wfms_cos.getAnnounced();
	}

	/**
	* Returns the approver step of this WFMS_COS.
	*
	* @return the approver step of this WFMS_COS
	*/
	@Override
	public int getApproverStep() {
		return _wfms_cos.getApproverStep();
	}

	/**
	* Returns the current position text of this WFMS_COS.
	*
	* @return the current position text of this WFMS_COS
	*/
	@Override
	public int getCurrentPositionText() {
		return _wfms_cos.getCurrentPositionText();
	}

	/**
	* Returns the deleteflag status of this WFMS_COS.
	*
	* @return the deleteflag status of this WFMS_COS
	*/
	@Override
	public int getDeleteflagStatus() {
		return _wfms_cos.getDeleteflagStatus();
	}

	/**
	* Returns the duplicate approved list end index of this WFMS_COS.
	*
	* @return the duplicate approved list end index of this WFMS_COS
	*/
	@Override
	public int getDuplicateApprovedListEndIndex() {
		return _wfms_cos.getDuplicateApprovedListEndIndex();
	}

	/**
	* Returns the duplicate approved list start index of this WFMS_COS.
	*
	* @return the duplicate approved list start index of this WFMS_COS
	*/
	@Override
	public int getDuplicateApprovedListStartIndex() {
		return _wfms_cos.getDuplicateApprovedListStartIndex();
	}

	/**
	* Returns the duplicate counter of this WFMS_COS.
	*
	* @return the duplicate counter of this WFMS_COS
	*/
	@Override
	public int getDuplicateCounter() {
		return _wfms_cos.getDuplicateCounter();
	}

	/**
	* Returns the system generated of this WFMS_COS.
	*
	* @return the system generated of this WFMS_COS
	*/
	@Override
	public int getSystemGenerated() {
		return _wfms_cos.getSystemGenerated();
	}

	/**
	* Returns the workflow step of this WFMS_COS.
	*
	* @return the workflow step of this WFMS_COS
	*/
	@Override
	public int getWorkflowStep() {
		return _wfms_cos.getWorkflowStep();
	}

	@Override
	public int hashCode() {
		return _wfms_cos.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_cos.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_COSWrapper((WFMS_COS)_wfms_cos.clone());
	}

	/**
	* Returns the action of this WFMS_COS.
	*
	* @return the action of this WFMS_COS
	*/
	@Override
	public java.lang.String getAction() {
		return _wfms_cos.getAction();
	}

	/**
	* Returns the approver list of this WFMS_COS.
	*
	* @return the approver list of this WFMS_COS
	*/
	@Override
	public java.lang.String getApproverList() {
		return _wfms_cos.getApproverList();
	}

	/**
	* Returns the associate date of hire of this WFMS_COS.
	*
	* @return the associate date of hire of this WFMS_COS
	*/
	@Override
	public java.lang.String getAssociateDateOfHire() {
		return _wfms_cos.getAssociateDateOfHire();
	}

	/**
	* Returns the associatename of this WFMS_COS.
	*
	* @return the associatename of this WFMS_COS
	*/
	@Override
	public java.lang.String getAssociatename() {
		return _wfms_cos.getAssociatename();
	}

	/**
	* Returns the assoicate ID of this WFMS_COS.
	*
	* @return the assoicate ID of this WFMS_COS
	*/
	@Override
	public java.lang.String getAssoicateId() {
		return _wfms_cos.getAssoicateId();
	}

	/**
	* Returns the change description of this WFMS_COS.
	*
	* @return the change description of this WFMS_COS
	*/
	@Override
	public java.lang.String getChangeDescription() {
		return _wfms_cos.getChangeDescription();
	}

	/**
	* Returns the comments of this WFMS_COS.
	*
	* @return the comments of this WFMS_COS
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_cos.getComments();
	}

	/**
	* Returns the cos ID of this WFMS_COS.
	*
	* @return the cos ID of this WFMS_COS
	*/
	@Override
	public java.lang.String getCosId() {
		return _wfms_cos.getCosId();
	}

	/**
	* Returns the created by of this WFMS_COS.
	*
	* @return the created by of this WFMS_COS
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_cos.getCreatedBy();
	}

	/**
	* Returns the current department manager of this WFMS_COS.
	*
	* @return the current department manager of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentDepartmentManager() {
		return _wfms_cos.getCurrentDepartmentManager();
	}

	/**
	* Returns the current department name of this WFMS_COS.
	*
	* @return the current department name of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentDepartmentName() {
		return _wfms_cos.getCurrentDepartmentName();
	}

	/**
	* Returns the current department number of this WFMS_COS.
	*
	* @return the current department number of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentDepartmentNumber() {
		return _wfms_cos.getCurrentDepartmentNumber();
	}

	/**
	* Returns the current division of this WFMS_COS.
	*
	* @return the current division of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentDivision() {
		return _wfms_cos.getCurrentDivision();
	}

	/**
	* Returns the current division manager of this WFMS_COS.
	*
	* @return the current division manager of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentDivisionManager() {
		return _wfms_cos.getCurrentDivisionManager();
	}

	/**
	* Returns the current job code of this WFMS_COS.
	*
	* @return the current job code of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentJobCode() {
		return _wfms_cos.getCurrentJobCode();
	}

	/**
	* Returns the current leadership assignment of this WFMS_COS.
	*
	* @return the current leadership assignment of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentLeadershipAssignment() {
		return _wfms_cos.getCurrentLeadershipAssignment();
	}

	/**
	* Returns the current manager assoc number of this WFMS_COS.
	*
	* @return the current manager assoc number of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentManagerAssocNumber() {
		return _wfms_cos.getCurrentManagerAssocNumber();
	}

	/**
	* Returns the current manager name of this WFMS_COS.
	*
	* @return the current manager name of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentManagerName() {
		return _wfms_cos.getCurrentManagerName();
	}

	/**
	* Returns the current manager title of this WFMS_COS.
	*
	* @return the current manager title of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentManagerTitle() {
		return _wfms_cos.getCurrentManagerTitle();
	}

	/**
	* Returns the current manpower rep of this WFMS_COS.
	*
	* @return the current manpower rep of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentManpowerRep() {
		return _wfms_cos.getCurrentManpowerRep();
	}

	/**
	* Returns the current shift code of this WFMS_COS.
	*
	* @return the current shift code of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentShiftCode() {
		return _wfms_cos.getCurrentShiftCode();
	}

	/**
	* Returns the current team number of this WFMS_COS.
	*
	* @return the current team number of this WFMS_COS
	*/
	@Override
	public java.lang.String getCurrentTeamNumber() {
		return _wfms_cos.getCurrentTeamNumber();
	}

	/**
	* Returns the description of this WFMS_COS.
	*
	* @return the description of this WFMS_COS
	*/
	@Override
	public java.lang.String getDescription() {
		return _wfms_cos.getDescription();
	}

	/**
	* Returns the dummy of this WFMS_COS.
	*
	* @return the dummy of this WFMS_COS
	*/
	@Override
	public java.lang.String getDummy() {
		return _wfms_cos.getDummy();
	}

	/**
	* Returns the duplicate approved list of this WFMS_COS.
	*
	* @return the duplicate approved list of this WFMS_COS
	*/
	@Override
	public java.lang.String getDuplicateApprovedList() {
		return _wfms_cos.getDuplicateApprovedList();
	}

	/**
	* Returns the effective date of this WFMS_COS.
	*
	* @return the effective date of this WFMS_COS
	*/
	@Override
	public java.lang.String getEffectiveDate() {
		return _wfms_cos.getEffectiveDate();
	}

	/**
	* Returns the leadership assignment of this WFMS_COS.
	*
	* @return the leadership assignment of this WFMS_COS
	*/
	@Override
	public java.lang.String getLeadershipAssignment() {
		return _wfms_cos.getLeadershipAssignment();
	}

	/**
	* Returns the manpower categiry of this WFMS_COS.
	*
	* @return the manpower categiry of this WFMS_COS
	*/
	@Override
	public java.lang.String getManpowerCategiry() {
		return _wfms_cos.getManpowerCategiry();
	}

	/**
	* Returns the mgr associate number of this WFMS_COS.
	*
	* @return the mgr associate number of this WFMS_COS
	*/
	@Override
	public java.lang.String getMgrAssociateNumber() {
		return _wfms_cos.getMgrAssociateNumber();
	}

	/**
	* Returns the modified by of this WFMS_COS.
	*
	* @return the modified by of this WFMS_COS
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_cos.getModifiedBy();
	}

	/**
	* Returns the new department manager of this WFMS_COS.
	*
	* @return the new department manager of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewDepartmentManager() {
		return _wfms_cos.getNewDepartmentManager();
	}

	/**
	* Returns the new department name of this WFMS_COS.
	*
	* @return the new department name of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewDepartmentName() {
		return _wfms_cos.getNewDepartmentName();
	}

	/**
	* Returns the new department number of this WFMS_COS.
	*
	* @return the new department number of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewDepartmentNumber() {
		return _wfms_cos.getNewDepartmentNumber();
	}

	/**
	* Returns the new division of this WFMS_COS.
	*
	* @return the new division of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewDivision() {
		return _wfms_cos.getNewDivision();
	}

	/**
	* Returns the new division manager of this WFMS_COS.
	*
	* @return the new division manager of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewDivisionManager() {
		return _wfms_cos.getNewDivisionManager();
	}

	/**
	* Returns the new job code of this WFMS_COS.
	*
	* @return the new job code of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewJobCode() {
		return _wfms_cos.getNewJobCode();
	}

	/**
	* Returns the new manager name of this WFMS_COS.
	*
	* @return the new manager name of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewManagerName() {
		return _wfms_cos.getNewManagerName();
	}

	/**
	* Returns the new manager title of this WFMS_COS.
	*
	* @return the new manager title of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewManagerTitle() {
		return _wfms_cos.getNewManagerTitle();
	}

	/**
	* Returns the new position number of this WFMS_COS.
	*
	* @return the new position number of this WFMS_COS
	*/
	@Override
	public java.lang.String getNewPositionNumber() {
		return _wfms_cos.getNewPositionNumber();
	}

	/**
	* Returns the next approver of this WFMS_COS.
	*
	* @return the next approver of this WFMS_COS
	*/
	@Override
	public java.lang.String getNextApprover() {
		return _wfms_cos.getNextApprover();
	}

	/**
	* Returns the notification to of this WFMS_COS.
	*
	* @return the notification to of this WFMS_COS
	*/
	@Override
	public java.lang.String getNotificationTo() {
		return _wfms_cos.getNotificationTo();
	}

	/**
	* Returns the position number of this WFMS_COS.
	*
	* @return the position number of this WFMS_COS
	*/
	@Override
	public java.lang.String getPositionNumber() {
		return _wfms_cos.getPositionNumber();
	}

	/**
	* Returns the primary key of this WFMS_COS.
	*
	* @return the primary key of this WFMS_COS
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_cos.getPrimaryKey();
	}

	/**
	* Returns the reason code of this WFMS_COS.
	*
	* @return the reason code of this WFMS_COS
	*/
	@Override
	public java.lang.String getReasonCODE() {
		return _wfms_cos.getReasonCODE();
	}

	/**
	* Returns the ref cos ID of this WFMS_COS.
	*
	* @return the ref cos ID of this WFMS_COS
	*/
	@Override
	public java.lang.String getRefCosId() {
		return _wfms_cos.getRefCosId();
	}

	/**
	* Returns the relates to of this WFMS_COS.
	*
	* @return the relates to of this WFMS_COS
	*/
	@Override
	public java.lang.String getRelatesTo() {
		return _wfms_cos.getRelatesTo();
	}

	/**
	* Returns the requistion ID of this WFMS_COS.
	*
	* @return the requistion ID of this WFMS_COS
	*/
	@Override
	public java.lang.String getRequistionId() {
		return _wfms_cos.getRequistionId();
	}

	/**
	* Returns the role of approver of this WFMS_COS.
	*
	* @return the role of approver of this WFMS_COS
	*/
	@Override
	public java.lang.String getRoleOfApprover() {
		return _wfms_cos.getRoleOfApprover();
	}

	/**
	* Returns the routing process of this WFMS_COS.
	*
	* @return the routing process of this WFMS_COS
	*/
	@Override
	public java.lang.String getRoutingProcess() {
		return _wfms_cos.getRoutingProcess();
	}

	/**
	* Returns the same dept of this WFMS_COS.
	*
	* @return the same dept of this WFMS_COS
	*/
	@Override
	public java.lang.String getSameDept() {
		return _wfms_cos.getSameDept();
	}

	/**
	* Returns the same job code of this WFMS_COS.
	*
	* @return the same job code of this WFMS_COS
	*/
	@Override
	public java.lang.String getSameJobCode() {
		return _wfms_cos.getSameJobCode();
	}

	/**
	* Returns the same leadership of this WFMS_COS.
	*
	* @return the same leadership of this WFMS_COS
	*/
	@Override
	public java.lang.String getSameLeadership() {
		return _wfms_cos.getSameLeadership();
	}

	/**
	* Returns the same mgr of this WFMS_COS.
	*
	* @return the same mgr of this WFMS_COS
	*/
	@Override
	public java.lang.String getSameMgr() {
		return _wfms_cos.getSameMgr();
	}

	/**
	* Returns the shift code of this WFMS_COS.
	*
	* @return the shift code of this WFMS_COS
	*/
	@Override
	public java.lang.String getShiftCode() {
		return _wfms_cos.getShiftCode();
	}

	/**
	* Returns the sort approved list of this WFMS_COS.
	*
	* @return the sort approved list of this WFMS_COS
	*/
	@Override
	public java.lang.String getSortApprovedList() {
		return _wfms_cos.getSortApprovedList();
	}

	/**
	* Returns the status of this WFMS_COS.
	*
	* @return the status of this WFMS_COS
	*/
	@Override
	public java.lang.String getStatus() {
		return _wfms_cos.getStatus();
	}

	/**
	* Returns the team number of this WFMS_COS.
	*
	* @return the team number of this WFMS_COS
	*/
	@Override
	public java.lang.String getTeamNumber() {
		return _wfms_cos.getTeamNumber();
	}

	/**
	* Returns the type of this WFMS_COS.
	*
	* @return the type of this WFMS_COS
	*/
	@Override
	public java.lang.String getType() {
		return _wfms_cos.getType();
	}

	/**
	* Returns the workflow of this WFMS_COS.
	*
	* @return the workflow of this WFMS_COS
	*/
	@Override
	public java.lang.String getWorkflow() {
		return _wfms_cos.getWorkflow();
	}

	/**
	* Returns the workflow ID of this WFMS_COS.
	*
	* @return the workflow ID of this WFMS_COS
	*/
	@Override
	public java.lang.String getWorkflowId() {
		return _wfms_cos.getWorkflowId();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_cos.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_cos.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_COS.
	*
	* @return the create date of this WFMS_COS
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_cos.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_COS.
	*
	* @return the modified date of this WFMS_COS
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_cos.getModifiedDate();
	}

	/**
	* Returns the company ID of this WFMS_COS.
	*
	* @return the company ID of this WFMS_COS
	*/
	@Override
	public long getCompanyId() {
		return _wfms_cos.getCompanyId();
	}

	/**
	* Returns the scope group ID of this WFMS_COS.
	*
	* @return the scope group ID of this WFMS_COS
	*/
	@Override
	public long getScopeGroupId() {
		return _wfms_cos.getScopeGroupId();
	}

	@Override
	public void persist() {
		_wfms_cos.persist();
	}

	/**
	* Sets the action of this WFMS_COS.
	*
	* @param action the action of this WFMS_COS
	*/
	@Override
	public void setAction(java.lang.String action) {
		_wfms_cos.setAction(action);
	}

	/**
	* Sets the announced of this WFMS_COS.
	*
	* @param announced the announced of this WFMS_COS
	*/
	@Override
	public void setAnnounced(int announced) {
		_wfms_cos.setAnnounced(announced);
	}

	/**
	* Sets the approver list of this WFMS_COS.
	*
	* @param approverList the approver list of this WFMS_COS
	*/
	@Override
	public void setApproverList(java.lang.String approverList) {
		_wfms_cos.setApproverList(approverList);
	}

	/**
	* Sets the approver step of this WFMS_COS.
	*
	* @param approverStep the approver step of this WFMS_COS
	*/
	@Override
	public void setApproverStep(int approverStep) {
		_wfms_cos.setApproverStep(approverStep);
	}

	/**
	* Sets the associate date of hire of this WFMS_COS.
	*
	* @param associateDateOfHire the associate date of hire of this WFMS_COS
	*/
	@Override
	public void setAssociateDateOfHire(java.lang.String associateDateOfHire) {
		_wfms_cos.setAssociateDateOfHire(associateDateOfHire);
	}

	/**
	* Sets the associatename of this WFMS_COS.
	*
	* @param associatename the associatename of this WFMS_COS
	*/
	@Override
	public void setAssociatename(java.lang.String associatename) {
		_wfms_cos.setAssociatename(associatename);
	}

	/**
	* Sets the assoicate ID of this WFMS_COS.
	*
	* @param assoicateId the assoicate ID of this WFMS_COS
	*/
	@Override
	public void setAssoicateId(java.lang.String assoicateId) {
		_wfms_cos.setAssoicateId(assoicateId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_cos.setCachedModel(cachedModel);
	}

	/**
	* Sets the change description of this WFMS_COS.
	*
	* @param changeDescription the change description of this WFMS_COS
	*/
	@Override
	public void setChangeDescription(java.lang.String changeDescription) {
		_wfms_cos.setChangeDescription(changeDescription);
	}

	/**
	* Sets the comments of this WFMS_COS.
	*
	* @param comments the comments of this WFMS_COS
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_cos.setComments(comments);
	}

	/**
	* Sets the company ID of this WFMS_COS.
	*
	* @param companyId the company ID of this WFMS_COS
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wfms_cos.setCompanyId(companyId);
	}

	/**
	* Sets the cos ID of this WFMS_COS.
	*
	* @param cosId the cos ID of this WFMS_COS
	*/
	@Override
	public void setCosId(java.lang.String cosId) {
		_wfms_cos.setCosId(cosId);
	}

	/**
	* Sets the create date of this WFMS_COS.
	*
	* @param createDate the create date of this WFMS_COS
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_cos.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_COS.
	*
	* @param createdBy the created by of this WFMS_COS
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_cos.setCreatedBy(createdBy);
	}

	/**
	* Sets the current department manager of this WFMS_COS.
	*
	* @param currentDepartmentManager the current department manager of this WFMS_COS
	*/
	@Override
	public void setCurrentDepartmentManager(
		java.lang.String currentDepartmentManager) {
		_wfms_cos.setCurrentDepartmentManager(currentDepartmentManager);
	}

	/**
	* Sets the current department name of this WFMS_COS.
	*
	* @param currentDepartmentName the current department name of this WFMS_COS
	*/
	@Override
	public void setCurrentDepartmentName(java.lang.String currentDepartmentName) {
		_wfms_cos.setCurrentDepartmentName(currentDepartmentName);
	}

	/**
	* Sets the current department number of this WFMS_COS.
	*
	* @param currentDepartmentNumber the current department number of this WFMS_COS
	*/
	@Override
	public void setCurrentDepartmentNumber(
		java.lang.String currentDepartmentNumber) {
		_wfms_cos.setCurrentDepartmentNumber(currentDepartmentNumber);
	}

	/**
	* Sets the current division of this WFMS_COS.
	*
	* @param currentDivision the current division of this WFMS_COS
	*/
	@Override
	public void setCurrentDivision(java.lang.String currentDivision) {
		_wfms_cos.setCurrentDivision(currentDivision);
	}

	/**
	* Sets the current division manager of this WFMS_COS.
	*
	* @param currentDivisionManager the current division manager of this WFMS_COS
	*/
	@Override
	public void setCurrentDivisionManager(
		java.lang.String currentDivisionManager) {
		_wfms_cos.setCurrentDivisionManager(currentDivisionManager);
	}

	/**
	* Sets the current job code of this WFMS_COS.
	*
	* @param currentJobCode the current job code of this WFMS_COS
	*/
	@Override
	public void setCurrentJobCode(java.lang.String currentJobCode) {
		_wfms_cos.setCurrentJobCode(currentJobCode);
	}

	/**
	* Sets the current leadership assignment of this WFMS_COS.
	*
	* @param currentLeadershipAssignment the current leadership assignment of this WFMS_COS
	*/
	@Override
	public void setCurrentLeadershipAssignment(
		java.lang.String currentLeadershipAssignment) {
		_wfms_cos.setCurrentLeadershipAssignment(currentLeadershipAssignment);
	}

	/**
	* Sets the current manager assoc number of this WFMS_COS.
	*
	* @param currentManagerAssocNumber the current manager assoc number of this WFMS_COS
	*/
	@Override
	public void setCurrentManagerAssocNumber(
		java.lang.String currentManagerAssocNumber) {
		_wfms_cos.setCurrentManagerAssocNumber(currentManagerAssocNumber);
	}

	/**
	* Sets the current manager name of this WFMS_COS.
	*
	* @param currentManagerName the current manager name of this WFMS_COS
	*/
	@Override
	public void setCurrentManagerName(java.lang.String currentManagerName) {
		_wfms_cos.setCurrentManagerName(currentManagerName);
	}

	/**
	* Sets the current manager title of this WFMS_COS.
	*
	* @param currentManagerTitle the current manager title of this WFMS_COS
	*/
	@Override
	public void setCurrentManagerTitle(java.lang.String currentManagerTitle) {
		_wfms_cos.setCurrentManagerTitle(currentManagerTitle);
	}

	/**
	* Sets the current manpower rep of this WFMS_COS.
	*
	* @param currentManpowerRep the current manpower rep of this WFMS_COS
	*/
	@Override
	public void setCurrentManpowerRep(java.lang.String currentManpowerRep) {
		_wfms_cos.setCurrentManpowerRep(currentManpowerRep);
	}

	/**
	* Sets the current position text of this WFMS_COS.
	*
	* @param currentPositionText the current position text of this WFMS_COS
	*/
	@Override
	public void setCurrentPositionText(int currentPositionText) {
		_wfms_cos.setCurrentPositionText(currentPositionText);
	}

	/**
	* Sets the current shift code of this WFMS_COS.
	*
	* @param currentShiftCode the current shift code of this WFMS_COS
	*/
	@Override
	public void setCurrentShiftCode(java.lang.String currentShiftCode) {
		_wfms_cos.setCurrentShiftCode(currentShiftCode);
	}

	/**
	* Sets the current team number of this WFMS_COS.
	*
	* @param currentTeamNumber the current team number of this WFMS_COS
	*/
	@Override
	public void setCurrentTeamNumber(java.lang.String currentTeamNumber) {
		_wfms_cos.setCurrentTeamNumber(currentTeamNumber);
	}

	/**
	* Sets the deleteflag status of this WFMS_COS.
	*
	* @param deleteflagStatus the deleteflag status of this WFMS_COS
	*/
	@Override
	public void setDeleteflagStatus(int deleteflagStatus) {
		_wfms_cos.setDeleteflagStatus(deleteflagStatus);
	}

	/**
	* Sets the description of this WFMS_COS.
	*
	* @param description the description of this WFMS_COS
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_wfms_cos.setDescription(description);
	}

	/**
	* Sets the dummy of this WFMS_COS.
	*
	* @param dummy the dummy of this WFMS_COS
	*/
	@Override
	public void setDummy(java.lang.String dummy) {
		_wfms_cos.setDummy(dummy);
	}

	/**
	* Sets the duplicate approved list of this WFMS_COS.
	*
	* @param DuplicateApprovedList the duplicate approved list of this WFMS_COS
	*/
	@Override
	public void setDuplicateApprovedList(java.lang.String DuplicateApprovedList) {
		_wfms_cos.setDuplicateApprovedList(DuplicateApprovedList);
	}

	/**
	* Sets the duplicate approved list end index of this WFMS_COS.
	*
	* @param DuplicateApprovedListEndIndex the duplicate approved list end index of this WFMS_COS
	*/
	@Override
	public void setDuplicateApprovedListEndIndex(
		int DuplicateApprovedListEndIndex) {
		_wfms_cos.setDuplicateApprovedListEndIndex(DuplicateApprovedListEndIndex);
	}

	/**
	* Sets the duplicate approved list start index of this WFMS_COS.
	*
	* @param DuplicateApprovedListStartIndex the duplicate approved list start index of this WFMS_COS
	*/
	@Override
	public void setDuplicateApprovedListStartIndex(
		int DuplicateApprovedListStartIndex) {
		_wfms_cos.setDuplicateApprovedListStartIndex(DuplicateApprovedListStartIndex);
	}

	/**
	* Sets the duplicate counter of this WFMS_COS.
	*
	* @param DuplicateCounter the duplicate counter of this WFMS_COS
	*/
	@Override
	public void setDuplicateCounter(int DuplicateCounter) {
		_wfms_cos.setDuplicateCounter(DuplicateCounter);
	}

	/**
	* Sets the effective date of this WFMS_COS.
	*
	* @param effectiveDate the effective date of this WFMS_COS
	*/
	@Override
	public void setEffectiveDate(java.lang.String effectiveDate) {
		_wfms_cos.setEffectiveDate(effectiveDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_cos.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_cos.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_cos.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the leadership assignment of this WFMS_COS.
	*
	* @param leadershipAssignment the leadership assignment of this WFMS_COS
	*/
	@Override
	public void setLeadershipAssignment(java.lang.String leadershipAssignment) {
		_wfms_cos.setLeadershipAssignment(leadershipAssignment);
	}

	/**
	* Sets the manpower categiry of this WFMS_COS.
	*
	* @param manpowerCategiry the manpower categiry of this WFMS_COS
	*/
	@Override
	public void setManpowerCategiry(java.lang.String manpowerCategiry) {
		_wfms_cos.setManpowerCategiry(manpowerCategiry);
	}

	/**
	* Sets the mgr associate number of this WFMS_COS.
	*
	* @param mgrAssociateNumber the mgr associate number of this WFMS_COS
	*/
	@Override
	public void setMgrAssociateNumber(java.lang.String mgrAssociateNumber) {
		_wfms_cos.setMgrAssociateNumber(mgrAssociateNumber);
	}

	/**
	* Sets the modified by of this WFMS_COS.
	*
	* @param modifiedBy the modified by of this WFMS_COS
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_cos.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_COS.
	*
	* @param modifiedDate the modified date of this WFMS_COS
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_cos.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_cos.setNew(n);
	}

	/**
	* Sets the new department manager of this WFMS_COS.
	*
	* @param newDepartmentManager the new department manager of this WFMS_COS
	*/
	@Override
	public void setNewDepartmentManager(java.lang.String newDepartmentManager) {
		_wfms_cos.setNewDepartmentManager(newDepartmentManager);
	}

	/**
	* Sets the new department name of this WFMS_COS.
	*
	* @param newDepartmentName the new department name of this WFMS_COS
	*/
	@Override
	public void setNewDepartmentName(java.lang.String newDepartmentName) {
		_wfms_cos.setNewDepartmentName(newDepartmentName);
	}

	/**
	* Sets the new department number of this WFMS_COS.
	*
	* @param newDepartmentNumber the new department number of this WFMS_COS
	*/
	@Override
	public void setNewDepartmentNumber(java.lang.String newDepartmentNumber) {
		_wfms_cos.setNewDepartmentNumber(newDepartmentNumber);
	}

	/**
	* Sets the new division of this WFMS_COS.
	*
	* @param newDivision the new division of this WFMS_COS
	*/
	@Override
	public void setNewDivision(java.lang.String newDivision) {
		_wfms_cos.setNewDivision(newDivision);
	}

	/**
	* Sets the new division manager of this WFMS_COS.
	*
	* @param newDivisionManager the new division manager of this WFMS_COS
	*/
	@Override
	public void setNewDivisionManager(java.lang.String newDivisionManager) {
		_wfms_cos.setNewDivisionManager(newDivisionManager);
	}

	/**
	* Sets the new job code of this WFMS_COS.
	*
	* @param newJobCode the new job code of this WFMS_COS
	*/
	@Override
	public void setNewJobCode(java.lang.String newJobCode) {
		_wfms_cos.setNewJobCode(newJobCode);
	}

	/**
	* Sets the new manager name of this WFMS_COS.
	*
	* @param newManagerName the new manager name of this WFMS_COS
	*/
	@Override
	public void setNewManagerName(java.lang.String newManagerName) {
		_wfms_cos.setNewManagerName(newManagerName);
	}

	/**
	* Sets the new manager title of this WFMS_COS.
	*
	* @param newManagerTitle the new manager title of this WFMS_COS
	*/
	@Override
	public void setNewManagerTitle(java.lang.String newManagerTitle) {
		_wfms_cos.setNewManagerTitle(newManagerTitle);
	}

	/**
	* Sets the new position number of this WFMS_COS.
	*
	* @param newPositionNumber the new position number of this WFMS_COS
	*/
	@Override
	public void setNewPositionNumber(java.lang.String newPositionNumber) {
		_wfms_cos.setNewPositionNumber(newPositionNumber);
	}

	/**
	* Sets the next approver of this WFMS_COS.
	*
	* @param nextApprover the next approver of this WFMS_COS
	*/
	@Override
	public void setNextApprover(java.lang.String nextApprover) {
		_wfms_cos.setNextApprover(nextApprover);
	}

	/**
	* Sets the notification to of this WFMS_COS.
	*
	* @param notificationTo the notification to of this WFMS_COS
	*/
	@Override
	public void setNotificationTo(java.lang.String notificationTo) {
		_wfms_cos.setNotificationTo(notificationTo);
	}

	/**
	* Sets the position number of this WFMS_COS.
	*
	* @param positionNumber the position number of this WFMS_COS
	*/
	@Override
	public void setPositionNumber(java.lang.String positionNumber) {
		_wfms_cos.setPositionNumber(positionNumber);
	}

	/**
	* Sets the primary key of this WFMS_COS.
	*
	* @param primaryKey the primary key of this WFMS_COS
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_cos.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_cos.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reason code of this WFMS_COS.
	*
	* @param reasonCODE the reason code of this WFMS_COS
	*/
	@Override
	public void setReasonCODE(java.lang.String reasonCODE) {
		_wfms_cos.setReasonCODE(reasonCODE);
	}

	/**
	* Sets the ref cos ID of this WFMS_COS.
	*
	* @param refCosId the ref cos ID of this WFMS_COS
	*/
	@Override
	public void setRefCosId(java.lang.String refCosId) {
		_wfms_cos.setRefCosId(refCosId);
	}

	/**
	* Sets the relates to of this WFMS_COS.
	*
	* @param relatesTo the relates to of this WFMS_COS
	*/
	@Override
	public void setRelatesTo(java.lang.String relatesTo) {
		_wfms_cos.setRelatesTo(relatesTo);
	}

	/**
	* Sets the requistion ID of this WFMS_COS.
	*
	* @param RequistionId the requistion ID of this WFMS_COS
	*/
	@Override
	public void setRequistionId(java.lang.String RequistionId) {
		_wfms_cos.setRequistionId(RequistionId);
	}

	/**
	* Sets the role of approver of this WFMS_COS.
	*
	* @param roleOfApprover the role of approver of this WFMS_COS
	*/
	@Override
	public void setRoleOfApprover(java.lang.String roleOfApprover) {
		_wfms_cos.setRoleOfApprover(roleOfApprover);
	}

	/**
	* Sets the routing process of this WFMS_COS.
	*
	* @param routingProcess the routing process of this WFMS_COS
	*/
	@Override
	public void setRoutingProcess(java.lang.String routingProcess) {
		_wfms_cos.setRoutingProcess(routingProcess);
	}

	/**
	* Sets the same dept of this WFMS_COS.
	*
	* @param sameDept the same dept of this WFMS_COS
	*/
	@Override
	public void setSameDept(java.lang.String sameDept) {
		_wfms_cos.setSameDept(sameDept);
	}

	/**
	* Sets the same job code of this WFMS_COS.
	*
	* @param sameJobCode the same job code of this WFMS_COS
	*/
	@Override
	public void setSameJobCode(java.lang.String sameJobCode) {
		_wfms_cos.setSameJobCode(sameJobCode);
	}

	/**
	* Sets the same leadership of this WFMS_COS.
	*
	* @param sameLeadership the same leadership of this WFMS_COS
	*/
	@Override
	public void setSameLeadership(java.lang.String sameLeadership) {
		_wfms_cos.setSameLeadership(sameLeadership);
	}

	/**
	* Sets the same mgr of this WFMS_COS.
	*
	* @param sameMgr the same mgr of this WFMS_COS
	*/
	@Override
	public void setSameMgr(java.lang.String sameMgr) {
		_wfms_cos.setSameMgr(sameMgr);
	}

	/**
	* Sets the scope group ID of this WFMS_COS.
	*
	* @param scopeGroupId the scope group ID of this WFMS_COS
	*/
	@Override
	public void setScopeGroupId(long scopeGroupId) {
		_wfms_cos.setScopeGroupId(scopeGroupId);
	}

	/**
	* Sets the shift code of this WFMS_COS.
	*
	* @param shiftCode the shift code of this WFMS_COS
	*/
	@Override
	public void setShiftCode(java.lang.String shiftCode) {
		_wfms_cos.setShiftCode(shiftCode);
	}

	/**
	* Sets the sort approved list of this WFMS_COS.
	*
	* @param sortApprovedList the sort approved list of this WFMS_COS
	*/
	@Override
	public void setSortApprovedList(java.lang.String sortApprovedList) {
		_wfms_cos.setSortApprovedList(sortApprovedList);
	}

	/**
	* Sets the status of this WFMS_COS.
	*
	* @param status the status of this WFMS_COS
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_wfms_cos.setStatus(status);
	}

	/**
	* Sets the system generated of this WFMS_COS.
	*
	* @param systemGenerated the system generated of this WFMS_COS
	*/
	@Override
	public void setSystemGenerated(int systemGenerated) {
		_wfms_cos.setSystemGenerated(systemGenerated);
	}

	/**
	* Sets the team number of this WFMS_COS.
	*
	* @param teamNumber the team number of this WFMS_COS
	*/
	@Override
	public void setTeamNumber(java.lang.String teamNumber) {
		_wfms_cos.setTeamNumber(teamNumber);
	}

	/**
	* Sets the type of this WFMS_COS.
	*
	* @param type the type of this WFMS_COS
	*/
	@Override
	public void setType(java.lang.String type) {
		_wfms_cos.setType(type);
	}

	/**
	* Sets the workflow of this WFMS_COS.
	*
	* @param workflow the workflow of this WFMS_COS
	*/
	@Override
	public void setWorkflow(java.lang.String workflow) {
		_wfms_cos.setWorkflow(workflow);
	}

	/**
	* Sets the workflow ID of this WFMS_COS.
	*
	* @param workflowId the workflow ID of this WFMS_COS
	*/
	@Override
	public void setWorkflowId(java.lang.String workflowId) {
		_wfms_cos.setWorkflowId(workflowId);
	}

	/**
	* Sets the workflow step of this WFMS_COS.
	*
	* @param workflowStep the workflow step of this WFMS_COS
	*/
	@Override
	public void setWorkflowStep(int workflowStep) {
		_wfms_cos.setWorkflowStep(workflowStep);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_COSWrapper)) {
			return false;
		}

		WFMS_COSWrapper wfms_cosWrapper = (WFMS_COSWrapper)obj;

		if (Objects.equals(_wfms_cos, wfms_cosWrapper._wfms_cos)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_COS getWrappedModel() {
		return _wfms_cos;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_cos.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_cos.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_cos.resetOriginalValues();
	}

	private final WFMS_COS _wfms_cos;
}