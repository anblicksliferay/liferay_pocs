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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_COSServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_COSServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_COSSoap implements Serializable {
	public static WFMS_COSSoap toSoapModel(WFMS_COS model) {
		WFMS_COSSoap soapModel = new WFMS_COSSoap();

		soapModel.setCosId(model.getCosId());
		soapModel.setAssoicateId(model.getAssoicateId());
		soapModel.setNewPositionNumber(model.getNewPositionNumber());
		soapModel.setAction(model.getAction());
		soapModel.setReasonCODE(model.getReasonCODE());
		soapModel.setDescription(model.getDescription());
		soapModel.setChangeDescription(model.getChangeDescription());
		soapModel.setNewJobCode(model.getNewJobCode());
		soapModel.setSameJobCode(model.getSameJobCode());
		soapModel.setSameLeadership(model.getSameLeadership());
		soapModel.setSameDept(model.getSameDept());
		soapModel.setSameMgr(model.getSameMgr());
		soapModel.setRoutingProcess(model.getRoutingProcess());
		soapModel.setNotificationTo(model.getNotificationTo());
		soapModel.setStatus(model.getStatus());
		soapModel.setType(model.getType());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setTeamNumber(model.getTeamNumber());
		soapModel.setShiftCode(model.getShiftCode());
		soapModel.setMgrAssociateNumber(model.getMgrAssociateNumber());
		soapModel.setManpowerCategiry(model.getManpowerCategiry());
		soapModel.setComments(model.getComments());
		soapModel.setLeadershipAssignment(model.getLeadershipAssignment());
		soapModel.setAssociateDateOfHire(model.getAssociateDateOfHire());
		soapModel.setNewDivision(model.getNewDivision());
		soapModel.setNewDivisionManager(model.getNewDivisionManager());
		soapModel.setNewDepartmentName(model.getNewDepartmentName());
		soapModel.setNewDepartmentNumber(model.getNewDepartmentNumber());
		soapModel.setNewDepartmentManager(model.getNewDepartmentManager());
		soapModel.setNewManagerName(model.getNewManagerName());
		soapModel.setNewManagerTitle(model.getNewManagerTitle());
		soapModel.setDeleteflagStatus(model.getDeleteflagStatus());
		soapModel.setRequistionId(model.getRequistionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setScopeGroupId(model.getScopeGroupId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAssociatename(model.getAssociatename());
		soapModel.setRelatesTo(model.getRelatesTo());
		soapModel.setNextApprover(model.getNextApprover());
		soapModel.setRoleOfApprover(model.getRoleOfApprover());
		soapModel.setApproverList(model.getApproverList());
		soapModel.setApproverStep(model.getApproverStep());
		soapModel.setWorkflow(model.getWorkflow());
		soapModel.setWorkflowStep(model.getWorkflowStep());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setDummy(model.getDummy());
		soapModel.setRefCosId(model.getRefCosId());
		soapModel.setSystemGenerated(model.getSystemGenerated());
		soapModel.setPositionNumber(model.getPositionNumber());
		soapModel.setCurrentJobCode(model.getCurrentJobCode());
		soapModel.setCurrentDivision(model.getCurrentDivision());
		soapModel.setCurrentDivisionManager(model.getCurrentDivisionManager());
		soapModel.setCurrentDepartmentName(model.getCurrentDepartmentName());
		soapModel.setCurrentDepartmentNumber(model.getCurrentDepartmentNumber());
		soapModel.setCurrentDepartmentManager(model.getCurrentDepartmentManager());
		soapModel.setCurrentManagerName(model.getCurrentManagerName());
		soapModel.setCurrentManagerTitle(model.getCurrentManagerTitle());
		soapModel.setCurrentTeamNumber(model.getCurrentTeamNumber());
		soapModel.setCurrentShiftCode(model.getCurrentShiftCode());
		soapModel.setCurrentLeadershipAssignment(model.getCurrentLeadershipAssignment());
		soapModel.setCurrentManpowerRep(model.getCurrentManpowerRep());
		soapModel.setCurrentManagerAssocNumber(model.getCurrentManagerAssocNumber());
		soapModel.setSortApprovedList(model.getSortApprovedList());
		soapModel.setDuplicateApprovedList(model.getDuplicateApprovedList());
		soapModel.setDuplicateApprovedListStartIndex(model.getDuplicateApprovedListStartIndex());
		soapModel.setDuplicateApprovedListEndIndex(model.getDuplicateApprovedListEndIndex());
		soapModel.setAnnounced(model.getAnnounced());
		soapModel.setCurrentPositionText(model.getCurrentPositionText());
		soapModel.setDuplicateCounter(model.getDuplicateCounter());

		return soapModel;
	}

	public static WFMS_COSSoap[] toSoapModels(WFMS_COS[] models) {
		WFMS_COSSoap[] soapModels = new WFMS_COSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_COSSoap[][] toSoapModels(WFMS_COS[][] models) {
		WFMS_COSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_COSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_COSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_COSSoap[] toSoapModels(List<WFMS_COS> models) {
		List<WFMS_COSSoap> soapModels = new ArrayList<WFMS_COSSoap>(models.size());

		for (WFMS_COS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_COSSoap[soapModels.size()]);
	}

	public WFMS_COSSoap() {
	}

	public String getPrimaryKey() {
		return _cosId;
	}

	public void setPrimaryKey(String pk) {
		setCosId(pk);
	}

	public String getCosId() {
		return _cosId;
	}

	public void setCosId(String cosId) {
		_cosId = cosId;
	}

	public String getAssoicateId() {
		return _assoicateId;
	}

	public void setAssoicateId(String assoicateId) {
		_assoicateId = assoicateId;
	}

	public String getNewPositionNumber() {
		return _newPositionNumber;
	}

	public void setNewPositionNumber(String newPositionNumber) {
		_newPositionNumber = newPositionNumber;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getReasonCODE() {
		return _reasonCODE;
	}

	public void setReasonCODE(String reasonCODE) {
		_reasonCODE = reasonCODE;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getChangeDescription() {
		return _changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		_changeDescription = changeDescription;
	}

	public String getNewJobCode() {
		return _newJobCode;
	}

	public void setNewJobCode(String newJobCode) {
		_newJobCode = newJobCode;
	}

	public String getSameJobCode() {
		return _sameJobCode;
	}

	public void setSameJobCode(String sameJobCode) {
		_sameJobCode = sameJobCode;
	}

	public String getSameLeadership() {
		return _sameLeadership;
	}

	public void setSameLeadership(String sameLeadership) {
		_sameLeadership = sameLeadership;
	}

	public String getSameDept() {
		return _sameDept;
	}

	public void setSameDept(String sameDept) {
		_sameDept = sameDept;
	}

	public String getSameMgr() {
		return _sameMgr;
	}

	public void setSameMgr(String sameMgr) {
		_sameMgr = sameMgr;
	}

	public String getRoutingProcess() {
		return _routingProcess;
	}

	public void setRoutingProcess(String routingProcess) {
		_routingProcess = routingProcess;
	}

	public String getNotificationTo() {
		return _notificationTo;
	}

	public void setNotificationTo(String notificationTo) {
		_notificationTo = notificationTo;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public String getTeamNumber() {
		return _teamNumber;
	}

	public void setTeamNumber(String teamNumber) {
		_teamNumber = teamNumber;
	}

	public String getShiftCode() {
		return _shiftCode;
	}

	public void setShiftCode(String shiftCode) {
		_shiftCode = shiftCode;
	}

	public String getMgrAssociateNumber() {
		return _mgrAssociateNumber;
	}

	public void setMgrAssociateNumber(String mgrAssociateNumber) {
		_mgrAssociateNumber = mgrAssociateNumber;
	}

	public String getManpowerCategiry() {
		return _manpowerCategiry;
	}

	public void setManpowerCategiry(String manpowerCategiry) {
		_manpowerCategiry = manpowerCategiry;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getLeadershipAssignment() {
		return _leadershipAssignment;
	}

	public void setLeadershipAssignment(String leadershipAssignment) {
		_leadershipAssignment = leadershipAssignment;
	}

	public String getAssociateDateOfHire() {
		return _associateDateOfHire;
	}

	public void setAssociateDateOfHire(String associateDateOfHire) {
		_associateDateOfHire = associateDateOfHire;
	}

	public String getNewDivision() {
		return _newDivision;
	}

	public void setNewDivision(String newDivision) {
		_newDivision = newDivision;
	}

	public String getNewDivisionManager() {
		return _newDivisionManager;
	}

	public void setNewDivisionManager(String newDivisionManager) {
		_newDivisionManager = newDivisionManager;
	}

	public String getNewDepartmentName() {
		return _newDepartmentName;
	}

	public void setNewDepartmentName(String newDepartmentName) {
		_newDepartmentName = newDepartmentName;
	}

	public String getNewDepartmentNumber() {
		return _newDepartmentNumber;
	}

	public void setNewDepartmentNumber(String newDepartmentNumber) {
		_newDepartmentNumber = newDepartmentNumber;
	}

	public String getNewDepartmentManager() {
		return _newDepartmentManager;
	}

	public void setNewDepartmentManager(String newDepartmentManager) {
		_newDepartmentManager = newDepartmentManager;
	}

	public String getNewManagerName() {
		return _newManagerName;
	}

	public void setNewManagerName(String newManagerName) {
		_newManagerName = newManagerName;
	}

	public String getNewManagerTitle() {
		return _newManagerTitle;
	}

	public void setNewManagerTitle(String newManagerTitle) {
		_newManagerTitle = newManagerTitle;
	}

	public int getDeleteflagStatus() {
		return _deleteflagStatus;
	}

	public void setDeleteflagStatus(int deleteflagStatus) {
		_deleteflagStatus = deleteflagStatus;
	}

	public String getRequistionId() {
		return _RequistionId;
	}

	public void setRequistionId(String RequistionId) {
		_RequistionId = RequistionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getScopeGroupId() {
		return _scopeGroupId;
	}

	public void setScopeGroupId(long scopeGroupId) {
		_scopeGroupId = scopeGroupId;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAssociatename() {
		return _associatename;
	}

	public void setAssociatename(String associatename) {
		_associatename = associatename;
	}

	public String getRelatesTo() {
		return _relatesTo;
	}

	public void setRelatesTo(String relatesTo) {
		_relatesTo = relatesTo;
	}

	public String getNextApprover() {
		return _nextApprover;
	}

	public void setNextApprover(String nextApprover) {
		_nextApprover = nextApprover;
	}

	public String getRoleOfApprover() {
		return _roleOfApprover;
	}

	public void setRoleOfApprover(String roleOfApprover) {
		_roleOfApprover = roleOfApprover;
	}

	public String getApproverList() {
		return _approverList;
	}

	public void setApproverList(String approverList) {
		_approverList = approverList;
	}

	public int getApproverStep() {
		return _approverStep;
	}

	public void setApproverStep(int approverStep) {
		_approverStep = approverStep;
	}

	public String getWorkflow() {
		return _workflow;
	}

	public void setWorkflow(String workflow) {
		_workflow = workflow;
	}

	public int getWorkflowStep() {
		return _workflowStep;
	}

	public void setWorkflowStep(int workflowStep) {
		_workflowStep = workflowStep;
	}

	public String getWorkflowId() {
		return _workflowId;
	}

	public void setWorkflowId(String workflowId) {
		_workflowId = workflowId;
	}

	public String getDummy() {
		return _dummy;
	}

	public void setDummy(String dummy) {
		_dummy = dummy;
	}

	public String getRefCosId() {
		return _refCosId;
	}

	public void setRefCosId(String refCosId) {
		_refCosId = refCosId;
	}

	public int getSystemGenerated() {
		return _systemGenerated;
	}

	public void setSystemGenerated(int systemGenerated) {
		_systemGenerated = systemGenerated;
	}

	public String getPositionNumber() {
		return _positionNumber;
	}

	public void setPositionNumber(String positionNumber) {
		_positionNumber = positionNumber;
	}

	public String getCurrentJobCode() {
		return _currentJobCode;
	}

	public void setCurrentJobCode(String currentJobCode) {
		_currentJobCode = currentJobCode;
	}

	public String getCurrentDivision() {
		return _currentDivision;
	}

	public void setCurrentDivision(String currentDivision) {
		_currentDivision = currentDivision;
	}

	public String getCurrentDivisionManager() {
		return _currentDivisionManager;
	}

	public void setCurrentDivisionManager(String currentDivisionManager) {
		_currentDivisionManager = currentDivisionManager;
	}

	public String getCurrentDepartmentName() {
		return _currentDepartmentName;
	}

	public void setCurrentDepartmentName(String currentDepartmentName) {
		_currentDepartmentName = currentDepartmentName;
	}

	public String getCurrentDepartmentNumber() {
		return _currentDepartmentNumber;
	}

	public void setCurrentDepartmentNumber(String currentDepartmentNumber) {
		_currentDepartmentNumber = currentDepartmentNumber;
	}

	public String getCurrentDepartmentManager() {
		return _currentDepartmentManager;
	}

	public void setCurrentDepartmentManager(String currentDepartmentManager) {
		_currentDepartmentManager = currentDepartmentManager;
	}

	public String getCurrentManagerName() {
		return _currentManagerName;
	}

	public void setCurrentManagerName(String currentManagerName) {
		_currentManagerName = currentManagerName;
	}

	public String getCurrentManagerTitle() {
		return _currentManagerTitle;
	}

	public void setCurrentManagerTitle(String currentManagerTitle) {
		_currentManagerTitle = currentManagerTitle;
	}

	public String getCurrentTeamNumber() {
		return _currentTeamNumber;
	}

	public void setCurrentTeamNumber(String currentTeamNumber) {
		_currentTeamNumber = currentTeamNumber;
	}

	public String getCurrentShiftCode() {
		return _currentShiftCode;
	}

	public void setCurrentShiftCode(String currentShiftCode) {
		_currentShiftCode = currentShiftCode;
	}

	public String getCurrentLeadershipAssignment() {
		return _currentLeadershipAssignment;
	}

	public void setCurrentLeadershipAssignment(
		String currentLeadershipAssignment) {
		_currentLeadershipAssignment = currentLeadershipAssignment;
	}

	public String getCurrentManpowerRep() {
		return _currentManpowerRep;
	}

	public void setCurrentManpowerRep(String currentManpowerRep) {
		_currentManpowerRep = currentManpowerRep;
	}

	public String getCurrentManagerAssocNumber() {
		return _currentManagerAssocNumber;
	}

	public void setCurrentManagerAssocNumber(String currentManagerAssocNumber) {
		_currentManagerAssocNumber = currentManagerAssocNumber;
	}

	public String getSortApprovedList() {
		return _sortApprovedList;
	}

	public void setSortApprovedList(String sortApprovedList) {
		_sortApprovedList = sortApprovedList;
	}

	public String getDuplicateApprovedList() {
		return _DuplicateApprovedList;
	}

	public void setDuplicateApprovedList(String DuplicateApprovedList) {
		_DuplicateApprovedList = DuplicateApprovedList;
	}

	public int getDuplicateApprovedListStartIndex() {
		return _DuplicateApprovedListStartIndex;
	}

	public void setDuplicateApprovedListStartIndex(
		int DuplicateApprovedListStartIndex) {
		_DuplicateApprovedListStartIndex = DuplicateApprovedListStartIndex;
	}

	public int getDuplicateApprovedListEndIndex() {
		return _DuplicateApprovedListEndIndex;
	}

	public void setDuplicateApprovedListEndIndex(
		int DuplicateApprovedListEndIndex) {
		_DuplicateApprovedListEndIndex = DuplicateApprovedListEndIndex;
	}

	public int getAnnounced() {
		return _announced;
	}

	public void setAnnounced(int announced) {
		_announced = announced;
	}

	public int getCurrentPositionText() {
		return _currentPositionText;
	}

	public void setCurrentPositionText(int currentPositionText) {
		_currentPositionText = currentPositionText;
	}

	public int getDuplicateCounter() {
		return _DuplicateCounter;
	}

	public void setDuplicateCounter(int DuplicateCounter) {
		_DuplicateCounter = DuplicateCounter;
	}

	private String _cosId;
	private String _assoicateId;
	private String _newPositionNumber;
	private String _action;
	private String _reasonCODE;
	private String _description;
	private String _changeDescription;
	private String _newJobCode;
	private String _sameJobCode;
	private String _sameLeadership;
	private String _sameDept;
	private String _sameMgr;
	private String _routingProcess;
	private String _notificationTo;
	private String _status;
	private String _type;
	private String _effectiveDate;
	private String _teamNumber;
	private String _shiftCode;
	private String _mgrAssociateNumber;
	private String _manpowerCategiry;
	private String _comments;
	private String _leadershipAssignment;
	private String _associateDateOfHire;
	private String _newDivision;
	private String _newDivisionManager;
	private String _newDepartmentName;
	private String _newDepartmentNumber;
	private String _newDepartmentManager;
	private String _newManagerName;
	private String _newManagerTitle;
	private int _deleteflagStatus;
	private String _RequistionId;
	private long _companyId;
	private long _scopeGroupId;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
	private String _associatename;
	private String _relatesTo;
	private String _nextApprover;
	private String _roleOfApprover;
	private String _approverList;
	private int _approverStep;
	private String _workflow;
	private int _workflowStep;
	private String _workflowId;
	private String _dummy;
	private String _refCosId;
	private int _systemGenerated;
	private String _positionNumber;
	private String _currentJobCode;
	private String _currentDivision;
	private String _currentDivisionManager;
	private String _currentDepartmentName;
	private String _currentDepartmentNumber;
	private String _currentDepartmentManager;
	private String _currentManagerName;
	private String _currentManagerTitle;
	private String _currentTeamNumber;
	private String _currentShiftCode;
	private String _currentLeadershipAssignment;
	private String _currentManpowerRep;
	private String _currentManagerAssocNumber;
	private String _sortApprovedList;
	private String _DuplicateApprovedList;
	private int _DuplicateApprovedListStartIndex;
	private int _DuplicateApprovedListEndIndex;
	private int _announced;
	private int _currentPositionText;
	private int _DuplicateCounter;
}