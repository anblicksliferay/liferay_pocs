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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_PositionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_PositionServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_PositionSoap implements Serializable {
	public static WFMS_PositionSoap toSoapModel(WFMS_Position model) {
		WFMS_PositionSoap soapModel = new WFMS_PositionSoap();

		soapModel.setPId(model.getPId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setScopeGroupId(model.getScopeGroupId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());
		soapModel.setNumber(model.getNumber());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setReportsTo(model.getReportsTo());
		soapModel.setAutoGenerateReq(model.getAutoGenerateReq());
		soapModel.setCritical(model.getCritical());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartmentName(model.getDepartmentName());
		soapModel.setDepartmentNumber(model.getDepartmentNumber());
		soapModel.setLine(model.getLine());
		soapModel.setLadder(model.getLadder());
		soapModel.setMpCatBugdet(model.getMpCatBugdet());
		soapModel.setMpCatFilledWith(model.getMpCatFilledWith());
		soapModel.setPositionClass(model.getPositionClass());
		soapModel.setType(model.getType());
		soapModel.setLevel(model.getLevel());
		soapModel.setLeadershipAssignment(model.getLeadershipAssignment());
		soapModel.setCategory(model.getCategory());
		soapModel.setSubCategory(model.getSubCategory());
		soapModel.setWorkforceCategory(model.getWorkforceCategory());
		soapModel.setEmpCategory(model.getEmpCategory());
		soapModel.setEmpCategoryDesc(model.getEmpCategoryDesc());
		soapModel.setYearEst(model.getYearEst());
		soapModel.setReasonsFor(model.getReasonsFor());
		soapModel.setReavailuationDate(model.getReavailuationDate());
		soapModel.setAssociateNumber(model.getAssociateNumber());
		soapModel.setAssociateName(model.getAssociateName());
		soapModel.setAssociateTitle(model.getAssociateTitle());
		soapModel.setComments(model.getComments());
		soapModel.setTypicalJobTitle(model.getTypicalJobTitle());
		soapModel.setMinJobKnowHow(model.getMinJobKnowHow());
		soapModel.setDuties(model.getDuties());
		soapModel.setTasksPerformed(model.getTasksPerformed());
		soapModel.setLengthOfService(model.getLengthOfService());
		soapModel.setDegree(model.getDegree());
		soapModel.setReqSkills(model.getReqSkills());
		soapModel.setDesiredSkills(model.getDesiredSkills());
		soapModel.setEnvironment(model.getEnvironment());
		soapModel.setWeeklyOvertime(model.getWeeklyOvertime());
		soapModel.setFrequencyOfTravel(model.getFrequencyOfTravel());
		soapModel.setHistory(model.getHistory());
		soapModel.setOther(model.getOther());
		soapModel.setDepartmentManager(model.getDepartmentManager());
		soapModel.setDivisionManager(model.getDivisionManager());
		soapModel.setRelatesTo(model.getRelatesTo());
		soapModel.setNextApprover(model.getNextApprover());
		soapModel.setWorkflow(model.getWorkflow());
		soapModel.setWorkflowStep(model.getWorkflowStep());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setDummy(model.getDummy());
		soapModel.setRefPosId(model.getRefPosId());
		soapModel.setIsmodify(model.getIsmodify());
		soapModel.setDisapproveComments(model.getDisapproveComments());

		return soapModel;
	}

	public static WFMS_PositionSoap[] toSoapModels(WFMS_Position[] models) {
		WFMS_PositionSoap[] soapModels = new WFMS_PositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_PositionSoap[][] toSoapModels(WFMS_Position[][] models) {
		WFMS_PositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_PositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_PositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_PositionSoap[] toSoapModels(List<WFMS_Position> models) {
		List<WFMS_PositionSoap> soapModels = new ArrayList<WFMS_PositionSoap>(models.size());

		for (WFMS_Position model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_PositionSoap[soapModels.size()]);
	}

	public WFMS_PositionSoap() {
	}

	public String getPrimaryKey() {
		return _pId;
	}

	public void setPrimaryKey(String pk) {
		setPId(pk);
	}

	public String getPId() {
		return _pId;
	}

	public void setPId(String pId) {
		_pId = pId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getReportsTo() {
		return _reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		_reportsTo = reportsTo;
	}

	public String getAutoGenerateReq() {
		return _autoGenerateReq;
	}

	public void setAutoGenerateReq(String autoGenerateReq) {
		_autoGenerateReq = autoGenerateReq;
	}

	public boolean getCritical() {
		return _critical;
	}

	public boolean isCritical() {
		return _critical;
	}

	public void setCritical(boolean critical) {
		_critical = critical;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getDepartmentName() {
		return _departmentName;
	}

	public void setDepartmentName(String departmentName) {
		_departmentName = departmentName;
	}

	public String getDepartmentNumber() {
		return _departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		_departmentNumber = departmentNumber;
	}

	public String getLine() {
		return _line;
	}

	public void setLine(String line) {
		_line = line;
	}

	public String getLadder() {
		return _ladder;
	}

	public void setLadder(String ladder) {
		_ladder = ladder;
	}

	public String getMpCatBugdet() {
		return _mpCatBugdet;
	}

	public void setMpCatBugdet(String mpCatBugdet) {
		_mpCatBugdet = mpCatBugdet;
	}

	public String getMpCatFilledWith() {
		return _mpCatFilledWith;
	}

	public void setMpCatFilledWith(String mpCatFilledWith) {
		_mpCatFilledWith = mpCatFilledWith;
	}

	public String getPositionClass() {
		return _positionClass;
	}

	public void setPositionClass(String positionClass) {
		_positionClass = positionClass;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getLevel() {
		return _level;
	}

	public void setLevel(String level) {
		_level = level;
	}

	public String getLeadershipAssignment() {
		return _leadershipAssignment;
	}

	public void setLeadershipAssignment(String leadershipAssignment) {
		_leadershipAssignment = leadershipAssignment;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getSubCategory() {
		return _subCategory;
	}

	public void setSubCategory(String subCategory) {
		_subCategory = subCategory;
	}

	public String getWorkforceCategory() {
		return _workforceCategory;
	}

	public void setWorkforceCategory(String workforceCategory) {
		_workforceCategory = workforceCategory;
	}

	public String getEmpCategory() {
		return _empCategory;
	}

	public void setEmpCategory(String empCategory) {
		_empCategory = empCategory;
	}

	public String getEmpCategoryDesc() {
		return _empCategoryDesc;
	}

	public void setEmpCategoryDesc(String empCategoryDesc) {
		_empCategoryDesc = empCategoryDesc;
	}

	public String getYearEst() {
		return _yearEst;
	}

	public void setYearEst(String yearEst) {
		_yearEst = yearEst;
	}

	public String getReasonsFor() {
		return _reasonsFor;
	}

	public void setReasonsFor(String reasonsFor) {
		_reasonsFor = reasonsFor;
	}

	public String getReavailuationDate() {
		return _reavailuationDate;
	}

	public void setReavailuationDate(String reavailuationDate) {
		_reavailuationDate = reavailuationDate;
	}

	public String getAssociateNumber() {
		return _associateNumber;
	}

	public void setAssociateNumber(String associateNumber) {
		_associateNumber = associateNumber;
	}

	public String getAssociateName() {
		return _associateName;
	}

	public void setAssociateName(String associateName) {
		_associateName = associateName;
	}

	public String getAssociateTitle() {
		return _associateTitle;
	}

	public void setAssociateTitle(String associateTitle) {
		_associateTitle = associateTitle;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getTypicalJobTitle() {
		return _typicalJobTitle;
	}

	public void setTypicalJobTitle(String typicalJobTitle) {
		_typicalJobTitle = typicalJobTitle;
	}

	public String getMinJobKnowHow() {
		return _minJobKnowHow;
	}

	public void setMinJobKnowHow(String minJobKnowHow) {
		_minJobKnowHow = minJobKnowHow;
	}

	public String getDuties() {
		return _duties;
	}

	public void setDuties(String duties) {
		_duties = duties;
	}

	public String getTasksPerformed() {
		return _tasksPerformed;
	}

	public void setTasksPerformed(String tasksPerformed) {
		_tasksPerformed = tasksPerformed;
	}

	public String getLengthOfService() {
		return _lengthOfService;
	}

	public void setLengthOfService(String lengthOfService) {
		_lengthOfService = lengthOfService;
	}

	public String getDegree() {
		return _degree;
	}

	public void setDegree(String degree) {
		_degree = degree;
	}

	public String getReqSkills() {
		return _reqSkills;
	}

	public void setReqSkills(String reqSkills) {
		_reqSkills = reqSkills;
	}

	public String getDesiredSkills() {
		return _desiredSkills;
	}

	public void setDesiredSkills(String desiredSkills) {
		_desiredSkills = desiredSkills;
	}

	public String getEnvironment() {
		return _environment;
	}

	public void setEnvironment(String environment) {
		_environment = environment;
	}

	public String getWeeklyOvertime() {
		return _weeklyOvertime;
	}

	public void setWeeklyOvertime(String weeklyOvertime) {
		_weeklyOvertime = weeklyOvertime;
	}

	public String getFrequencyOfTravel() {
		return _frequencyOfTravel;
	}

	public void setFrequencyOfTravel(String frequencyOfTravel) {
		_frequencyOfTravel = frequencyOfTravel;
	}

	public String getHistory() {
		return _history;
	}

	public void setHistory(String history) {
		_history = history;
	}

	public String getOther() {
		return _other;
	}

	public void setOther(String other) {
		_other = other;
	}

	public String getDepartmentManager() {
		return _departmentManager;
	}

	public void setDepartmentManager(String departmentManager) {
		_departmentManager = departmentManager;
	}

	public String getDivisionManager() {
		return _divisionManager;
	}

	public void setDivisionManager(String divisionManager) {
		_divisionManager = divisionManager;
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

	public String getRefPosId() {
		return _refPosId;
	}

	public void setRefPosId(String refPosId) {
		_refPosId = refPosId;
	}

	public boolean getIsmodify() {
		return _ismodify;
	}

	public boolean isIsmodify() {
		return _ismodify;
	}

	public void setIsmodify(boolean ismodify) {
		_ismodify = ismodify;
	}

	public String getDisapproveComments() {
		return _disapproveComments;
	}

	public void setDisapproveComments(String disapproveComments) {
		_disapproveComments = disapproveComments;
	}

	private String _pId;
	private long _companyId;
	private long _scopeGroupId;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
	private boolean _active;
	private String _number;
	private String _description;
	private String _status;
	private String _reportsTo;
	private String _autoGenerateReq;
	private boolean _critical;
	private String _division;
	private String _departmentName;
	private String _departmentNumber;
	private String _line;
	private String _ladder;
	private String _mpCatBugdet;
	private String _mpCatFilledWith;
	private String _positionClass;
	private String _type;
	private String _level;
	private String _leadershipAssignment;
	private String _category;
	private String _subCategory;
	private String _workforceCategory;
	private String _empCategory;
	private String _empCategoryDesc;
	private String _yearEst;
	private String _reasonsFor;
	private String _reavailuationDate;
	private String _associateNumber;
	private String _associateName;
	private String _associateTitle;
	private String _comments;
	private String _typicalJobTitle;
	private String _minJobKnowHow;
	private String _duties;
	private String _tasksPerformed;
	private String _lengthOfService;
	private String _degree;
	private String _reqSkills;
	private String _desiredSkills;
	private String _environment;
	private String _weeklyOvertime;
	private String _frequencyOfTravel;
	private String _history;
	private String _other;
	private String _departmentManager;
	private String _divisionManager;
	private String _relatesTo;
	private String _nextApprover;
	private String _workflow;
	private int _workflowStep;
	private String _workflowId;
	private String _dummy;
	private String _refPosId;
	private boolean _ismodify;
	private String _disapproveComments;
}