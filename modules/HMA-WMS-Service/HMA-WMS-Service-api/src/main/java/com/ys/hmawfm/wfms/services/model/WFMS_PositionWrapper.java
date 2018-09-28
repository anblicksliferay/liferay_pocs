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
 * This class is a wrapper for {@link WFMS_Position}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position
 * @generated
 */
@ProviderType
public class WFMS_PositionWrapper implements WFMS_Position,
	ModelWrapper<WFMS_Position> {
	public WFMS_PositionWrapper(WFMS_Position wfms_Position) {
		_wfms_Position = wfms_Position;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_Position.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_Position.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pId", getPId());
		attributes.put("companyId", getCompanyId());
		attributes.put("scopeGroupId", getScopeGroupId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());
		attributes.put("number", getNumber());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("reportsTo", getReportsTo());
		attributes.put("autoGenerateReq", getAutoGenerateReq());
		attributes.put("critical", getCritical());
		attributes.put("division", getDivision());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("departmentNumber", getDepartmentNumber());
		attributes.put("line", getLine());
		attributes.put("ladder", getLadder());
		attributes.put("mpCatBugdet", getMpCatBugdet());
		attributes.put("mpCatFilledWith", getMpCatFilledWith());
		attributes.put("positionClass", getPositionClass());
		attributes.put("type", getType());
		attributes.put("level", getLevel());
		attributes.put("leadershipAssignment", getLeadershipAssignment());
		attributes.put("category", getCategory());
		attributes.put("subCategory", getSubCategory());
		attributes.put("workforceCategory", getWorkforceCategory());
		attributes.put("empCategory", getEmpCategory());
		attributes.put("empCategoryDesc", getEmpCategoryDesc());
		attributes.put("yearEst", getYearEst());
		attributes.put("reasonsFor", getReasonsFor());
		attributes.put("reavailuationDate", getReavailuationDate());
		attributes.put("associateNumber", getAssociateNumber());
		attributes.put("associateName", getAssociateName());
		attributes.put("associateTitle", getAssociateTitle());
		attributes.put("comments", getComments());
		attributes.put("typicalJobTitle", getTypicalJobTitle());
		attributes.put("minJobKnowHow", getMinJobKnowHow());
		attributes.put("duties", getDuties());
		attributes.put("tasksPerformed", getTasksPerformed());
		attributes.put("lengthOfService", getLengthOfService());
		attributes.put("degree", getDegree());
		attributes.put("reqSkills", getReqSkills());
		attributes.put("desiredSkills", getDesiredSkills());
		attributes.put("environment", getEnvironment());
		attributes.put("weeklyOvertime", getWeeklyOvertime());
		attributes.put("frequencyOfTravel", getFrequencyOfTravel());
		attributes.put("history", getHistory());
		attributes.put("other", getOther());
		attributes.put("departmentManager", getDepartmentManager());
		attributes.put("divisionManager", getDivisionManager());
		attributes.put("relatesTo", getRelatesTo());
		attributes.put("nextApprover", getNextApprover());
		attributes.put("workflow", getWorkflow());
		attributes.put("workflowStep", getWorkflowStep());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("dummy", getDummy());
		attributes.put("refPosId", getRefPosId());
		attributes.put("ismodify", getIsmodify());
		attributes.put("disapproveComments", getDisapproveComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String pId = (String)attributes.get("pId");

		if (pId != null) {
			setPId(pId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String reportsTo = (String)attributes.get("reportsTo");

		if (reportsTo != null) {
			setReportsTo(reportsTo);
		}

		String autoGenerateReq = (String)attributes.get("autoGenerateReq");

		if (autoGenerateReq != null) {
			setAutoGenerateReq(autoGenerateReq);
		}

		Boolean critical = (Boolean)attributes.get("critical");

		if (critical != null) {
			setCritical(critical);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String departmentNumber = (String)attributes.get("departmentNumber");

		if (departmentNumber != null) {
			setDepartmentNumber(departmentNumber);
		}

		String line = (String)attributes.get("line");

		if (line != null) {
			setLine(line);
		}

		String ladder = (String)attributes.get("ladder");

		if (ladder != null) {
			setLadder(ladder);
		}

		String mpCatBugdet = (String)attributes.get("mpCatBugdet");

		if (mpCatBugdet != null) {
			setMpCatBugdet(mpCatBugdet);
		}

		String mpCatFilledWith = (String)attributes.get("mpCatFilledWith");

		if (mpCatFilledWith != null) {
			setMpCatFilledWith(mpCatFilledWith);
		}

		String positionClass = (String)attributes.get("positionClass");

		if (positionClass != null) {
			setPositionClass(positionClass);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String level = (String)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String leadershipAssignment = (String)attributes.get(
				"leadershipAssignment");

		if (leadershipAssignment != null) {
			setLeadershipAssignment(leadershipAssignment);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String subCategory = (String)attributes.get("subCategory");

		if (subCategory != null) {
			setSubCategory(subCategory);
		}

		String workforceCategory = (String)attributes.get("workforceCategory");

		if (workforceCategory != null) {
			setWorkforceCategory(workforceCategory);
		}

		String empCategory = (String)attributes.get("empCategory");

		if (empCategory != null) {
			setEmpCategory(empCategory);
		}

		String empCategoryDesc = (String)attributes.get("empCategoryDesc");

		if (empCategoryDesc != null) {
			setEmpCategoryDesc(empCategoryDesc);
		}

		String yearEst = (String)attributes.get("yearEst");

		if (yearEst != null) {
			setYearEst(yearEst);
		}

		String reasonsFor = (String)attributes.get("reasonsFor");

		if (reasonsFor != null) {
			setReasonsFor(reasonsFor);
		}

		String reavailuationDate = (String)attributes.get("reavailuationDate");

		if (reavailuationDate != null) {
			setReavailuationDate(reavailuationDate);
		}

		String associateNumber = (String)attributes.get("associateNumber");

		if (associateNumber != null) {
			setAssociateNumber(associateNumber);
		}

		String associateName = (String)attributes.get("associateName");

		if (associateName != null) {
			setAssociateName(associateName);
		}

		String associateTitle = (String)attributes.get("associateTitle");

		if (associateTitle != null) {
			setAssociateTitle(associateTitle);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String typicalJobTitle = (String)attributes.get("typicalJobTitle");

		if (typicalJobTitle != null) {
			setTypicalJobTitle(typicalJobTitle);
		}

		String minJobKnowHow = (String)attributes.get("minJobKnowHow");

		if (minJobKnowHow != null) {
			setMinJobKnowHow(minJobKnowHow);
		}

		String duties = (String)attributes.get("duties");

		if (duties != null) {
			setDuties(duties);
		}

		String tasksPerformed = (String)attributes.get("tasksPerformed");

		if (tasksPerformed != null) {
			setTasksPerformed(tasksPerformed);
		}

		String lengthOfService = (String)attributes.get("lengthOfService");

		if (lengthOfService != null) {
			setLengthOfService(lengthOfService);
		}

		String degree = (String)attributes.get("degree");

		if (degree != null) {
			setDegree(degree);
		}

		String reqSkills = (String)attributes.get("reqSkills");

		if (reqSkills != null) {
			setReqSkills(reqSkills);
		}

		String desiredSkills = (String)attributes.get("desiredSkills");

		if (desiredSkills != null) {
			setDesiredSkills(desiredSkills);
		}

		String environment = (String)attributes.get("environment");

		if (environment != null) {
			setEnvironment(environment);
		}

		String weeklyOvertime = (String)attributes.get("weeklyOvertime");

		if (weeklyOvertime != null) {
			setWeeklyOvertime(weeklyOvertime);
		}

		String frequencyOfTravel = (String)attributes.get("frequencyOfTravel");

		if (frequencyOfTravel != null) {
			setFrequencyOfTravel(frequencyOfTravel);
		}

		String history = (String)attributes.get("history");

		if (history != null) {
			setHistory(history);
		}

		String other = (String)attributes.get("other");

		if (other != null) {
			setOther(other);
		}

		String departmentManager = (String)attributes.get("departmentManager");

		if (departmentManager != null) {
			setDepartmentManager(departmentManager);
		}

		String divisionManager = (String)attributes.get("divisionManager");

		if (divisionManager != null) {
			setDivisionManager(divisionManager);
		}

		String relatesTo = (String)attributes.get("relatesTo");

		if (relatesTo != null) {
			setRelatesTo(relatesTo);
		}

		String nextApprover = (String)attributes.get("nextApprover");

		if (nextApprover != null) {
			setNextApprover(nextApprover);
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

		String refPosId = (String)attributes.get("refPosId");

		if (refPosId != null) {
			setRefPosId(refPosId);
		}

		Boolean ismodify = (Boolean)attributes.get("ismodify");

		if (ismodify != null) {
			setIsmodify(ismodify);
		}

		String disapproveComments = (String)attributes.get("disapproveComments");

		if (disapproveComments != null) {
			setDisapproveComments(disapproveComments);
		}
	}

	@Override
	public WFMS_Position toEscapedModel() {
		return new WFMS_PositionWrapper(_wfms_Position.toEscapedModel());
	}

	@Override
	public WFMS_Position toUnescapedModel() {
		return new WFMS_PositionWrapper(_wfms_Position.toUnescapedModel());
	}

	/**
	* Returns the active of this WFMS_Position.
	*
	* @return the active of this WFMS_Position
	*/
	@Override
	public boolean getActive() {
		return _wfms_Position.getActive();
	}

	/**
	* Returns the critical of this WFMS_Position.
	*
	* @return the critical of this WFMS_Position
	*/
	@Override
	public boolean getCritical() {
		return _wfms_Position.getCritical();
	}

	/**
	* Returns the ismodify of this WFMS_Position.
	*
	* @return the ismodify of this WFMS_Position
	*/
	@Override
	public boolean getIsmodify() {
		return _wfms_Position.getIsmodify();
	}

	/**
	* Returns <code>true</code> if this WFMS_Position is active.
	*
	* @return <code>true</code> if this WFMS_Position is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _wfms_Position.isActive();
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_Position.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this WFMS_Position is critical.
	*
	* @return <code>true</code> if this WFMS_Position is critical; <code>false</code> otherwise
	*/
	@Override
	public boolean isCritical() {
		return _wfms_Position.isCritical();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_Position.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this WFMS_Position is ismodify.
	*
	* @return <code>true</code> if this WFMS_Position is ismodify; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsmodify() {
		return _wfms_Position.isIsmodify();
	}

	@Override
	public boolean isNew() {
		return _wfms_Position.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_Position.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_Position> toCacheModel() {
		return _wfms_Position.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_Position wfms_Position) {
		return _wfms_Position.compareTo(wfms_Position);
	}

	/**
	* Returns the workflow step of this WFMS_Position.
	*
	* @return the workflow step of this WFMS_Position
	*/
	@Override
	public int getWorkflowStep() {
		return _wfms_Position.getWorkflowStep();
	}

	@Override
	public int hashCode() {
		return _wfms_Position.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_Position.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_PositionWrapper((WFMS_Position)_wfms_Position.clone());
	}

	/**
	* Returns the associate name of this WFMS_Position.
	*
	* @return the associate name of this WFMS_Position
	*/
	@Override
	public java.lang.String getAssociateName() {
		return _wfms_Position.getAssociateName();
	}

	/**
	* Returns the associate number of this WFMS_Position.
	*
	* @return the associate number of this WFMS_Position
	*/
	@Override
	public java.lang.String getAssociateNumber() {
		return _wfms_Position.getAssociateNumber();
	}

	/**
	* Returns the associate title of this WFMS_Position.
	*
	* @return the associate title of this WFMS_Position
	*/
	@Override
	public java.lang.String getAssociateTitle() {
		return _wfms_Position.getAssociateTitle();
	}

	/**
	* Returns the auto generate req of this WFMS_Position.
	*
	* @return the auto generate req of this WFMS_Position
	*/
	@Override
	public java.lang.String getAutoGenerateReq() {
		return _wfms_Position.getAutoGenerateReq();
	}

	/**
	* Returns the category of this WFMS_Position.
	*
	* @return the category of this WFMS_Position
	*/
	@Override
	public java.lang.String getCategory() {
		return _wfms_Position.getCategory();
	}

	/**
	* Returns the comments of this WFMS_Position.
	*
	* @return the comments of this WFMS_Position
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_Position.getComments();
	}

	/**
	* Returns the created by of this WFMS_Position.
	*
	* @return the created by of this WFMS_Position
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_Position.getCreatedBy();
	}

	/**
	* Returns the degree of this WFMS_Position.
	*
	* @return the degree of this WFMS_Position
	*/
	@Override
	public java.lang.String getDegree() {
		return _wfms_Position.getDegree();
	}

	/**
	* Returns the department manager of this WFMS_Position.
	*
	* @return the department manager of this WFMS_Position
	*/
	@Override
	public java.lang.String getDepartmentManager() {
		return _wfms_Position.getDepartmentManager();
	}

	/**
	* Returns the department name of this WFMS_Position.
	*
	* @return the department name of this WFMS_Position
	*/
	@Override
	public java.lang.String getDepartmentName() {
		return _wfms_Position.getDepartmentName();
	}

	/**
	* Returns the department number of this WFMS_Position.
	*
	* @return the department number of this WFMS_Position
	*/
	@Override
	public java.lang.String getDepartmentNumber() {
		return _wfms_Position.getDepartmentNumber();
	}

	/**
	* Returns the description of this WFMS_Position.
	*
	* @return the description of this WFMS_Position
	*/
	@Override
	public java.lang.String getDescription() {
		return _wfms_Position.getDescription();
	}

	/**
	* Returns the desired skills of this WFMS_Position.
	*
	* @return the desired skills of this WFMS_Position
	*/
	@Override
	public java.lang.String getDesiredSkills() {
		return _wfms_Position.getDesiredSkills();
	}

	/**
	* Returns the disapprove comments of this WFMS_Position.
	*
	* @return the disapprove comments of this WFMS_Position
	*/
	@Override
	public java.lang.String getDisapproveComments() {
		return _wfms_Position.getDisapproveComments();
	}

	/**
	* Returns the division of this WFMS_Position.
	*
	* @return the division of this WFMS_Position
	*/
	@Override
	public java.lang.String getDivision() {
		return _wfms_Position.getDivision();
	}

	/**
	* Returns the division manager of this WFMS_Position.
	*
	* @return the division manager of this WFMS_Position
	*/
	@Override
	public java.lang.String getDivisionManager() {
		return _wfms_Position.getDivisionManager();
	}

	/**
	* Returns the dummy of this WFMS_Position.
	*
	* @return the dummy of this WFMS_Position
	*/
	@Override
	public java.lang.String getDummy() {
		return _wfms_Position.getDummy();
	}

	/**
	* Returns the duties of this WFMS_Position.
	*
	* @return the duties of this WFMS_Position
	*/
	@Override
	public java.lang.String getDuties() {
		return _wfms_Position.getDuties();
	}

	/**
	* Returns the emp category of this WFMS_Position.
	*
	* @return the emp category of this WFMS_Position
	*/
	@Override
	public java.lang.String getEmpCategory() {
		return _wfms_Position.getEmpCategory();
	}

	/**
	* Returns the emp category desc of this WFMS_Position.
	*
	* @return the emp category desc of this WFMS_Position
	*/
	@Override
	public java.lang.String getEmpCategoryDesc() {
		return _wfms_Position.getEmpCategoryDesc();
	}

	/**
	* Returns the environment of this WFMS_Position.
	*
	* @return the environment of this WFMS_Position
	*/
	@Override
	public java.lang.String getEnvironment() {
		return _wfms_Position.getEnvironment();
	}

	/**
	* Returns the frequency of travel of this WFMS_Position.
	*
	* @return the frequency of travel of this WFMS_Position
	*/
	@Override
	public java.lang.String getFrequencyOfTravel() {
		return _wfms_Position.getFrequencyOfTravel();
	}

	/**
	* Returns the history of this WFMS_Position.
	*
	* @return the history of this WFMS_Position
	*/
	@Override
	public java.lang.String getHistory() {
		return _wfms_Position.getHistory();
	}

	/**
	* Returns the ladder of this WFMS_Position.
	*
	* @return the ladder of this WFMS_Position
	*/
	@Override
	public java.lang.String getLadder() {
		return _wfms_Position.getLadder();
	}

	/**
	* Returns the leadership assignment of this WFMS_Position.
	*
	* @return the leadership assignment of this WFMS_Position
	*/
	@Override
	public java.lang.String getLeadershipAssignment() {
		return _wfms_Position.getLeadershipAssignment();
	}

	/**
	* Returns the length of service of this WFMS_Position.
	*
	* @return the length of service of this WFMS_Position
	*/
	@Override
	public java.lang.String getLengthOfService() {
		return _wfms_Position.getLengthOfService();
	}

	/**
	* Returns the level of this WFMS_Position.
	*
	* @return the level of this WFMS_Position
	*/
	@Override
	public java.lang.String getLevel() {
		return _wfms_Position.getLevel();
	}

	/**
	* Returns the line of this WFMS_Position.
	*
	* @return the line of this WFMS_Position
	*/
	@Override
	public java.lang.String getLine() {
		return _wfms_Position.getLine();
	}

	/**
	* Returns the min job know how of this WFMS_Position.
	*
	* @return the min job know how of this WFMS_Position
	*/
	@Override
	public java.lang.String getMinJobKnowHow() {
		return _wfms_Position.getMinJobKnowHow();
	}

	/**
	* Returns the modified by of this WFMS_Position.
	*
	* @return the modified by of this WFMS_Position
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_Position.getModifiedBy();
	}

	/**
	* Returns the mp cat bugdet of this WFMS_Position.
	*
	* @return the mp cat bugdet of this WFMS_Position
	*/
	@Override
	public java.lang.String getMpCatBugdet() {
		return _wfms_Position.getMpCatBugdet();
	}

	/**
	* Returns the mp cat filled with of this WFMS_Position.
	*
	* @return the mp cat filled with of this WFMS_Position
	*/
	@Override
	public java.lang.String getMpCatFilledWith() {
		return _wfms_Position.getMpCatFilledWith();
	}

	/**
	* Returns the next approver of this WFMS_Position.
	*
	* @return the next approver of this WFMS_Position
	*/
	@Override
	public java.lang.String getNextApprover() {
		return _wfms_Position.getNextApprover();
	}

	/**
	* Returns the number of this WFMS_Position.
	*
	* @return the number of this WFMS_Position
	*/
	@Override
	public java.lang.String getNumber() {
		return _wfms_Position.getNumber();
	}

	/**
	* Returns the other of this WFMS_Position.
	*
	* @return the other of this WFMS_Position
	*/
	@Override
	public java.lang.String getOther() {
		return _wfms_Position.getOther();
	}

	/**
	* Returns the p ID of this WFMS_Position.
	*
	* @return the p ID of this WFMS_Position
	*/
	@Override
	public java.lang.String getPId() {
		return _wfms_Position.getPId();
	}

	/**
	* Returns the position class of this WFMS_Position.
	*
	* @return the position class of this WFMS_Position
	*/
	@Override
	public java.lang.String getPositionClass() {
		return _wfms_Position.getPositionClass();
	}

	/**
	* Returns the primary key of this WFMS_Position.
	*
	* @return the primary key of this WFMS_Position
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_Position.getPrimaryKey();
	}

	/**
	* Returns the reasons for of this WFMS_Position.
	*
	* @return the reasons for of this WFMS_Position
	*/
	@Override
	public java.lang.String getReasonsFor() {
		return _wfms_Position.getReasonsFor();
	}

	/**
	* Returns the reavailuation date of this WFMS_Position.
	*
	* @return the reavailuation date of this WFMS_Position
	*/
	@Override
	public java.lang.String getReavailuationDate() {
		return _wfms_Position.getReavailuationDate();
	}

	/**
	* Returns the ref pos ID of this WFMS_Position.
	*
	* @return the ref pos ID of this WFMS_Position
	*/
	@Override
	public java.lang.String getRefPosId() {
		return _wfms_Position.getRefPosId();
	}

	/**
	* Returns the relates to of this WFMS_Position.
	*
	* @return the relates to of this WFMS_Position
	*/
	@Override
	public java.lang.String getRelatesTo() {
		return _wfms_Position.getRelatesTo();
	}

	/**
	* Returns the reports to of this WFMS_Position.
	*
	* @return the reports to of this WFMS_Position
	*/
	@Override
	public java.lang.String getReportsTo() {
		return _wfms_Position.getReportsTo();
	}

	/**
	* Returns the req skills of this WFMS_Position.
	*
	* @return the req skills of this WFMS_Position
	*/
	@Override
	public java.lang.String getReqSkills() {
		return _wfms_Position.getReqSkills();
	}

	/**
	* Returns the status of this WFMS_Position.
	*
	* @return the status of this WFMS_Position
	*/
	@Override
	public java.lang.String getStatus() {
		return _wfms_Position.getStatus();
	}

	/**
	* Returns the sub category of this WFMS_Position.
	*
	* @return the sub category of this WFMS_Position
	*/
	@Override
	public java.lang.String getSubCategory() {
		return _wfms_Position.getSubCategory();
	}

	/**
	* Returns the tasks performed of this WFMS_Position.
	*
	* @return the tasks performed of this WFMS_Position
	*/
	@Override
	public java.lang.String getTasksPerformed() {
		return _wfms_Position.getTasksPerformed();
	}

	/**
	* Returns the type of this WFMS_Position.
	*
	* @return the type of this WFMS_Position
	*/
	@Override
	public java.lang.String getType() {
		return _wfms_Position.getType();
	}

	/**
	* Returns the typical job title of this WFMS_Position.
	*
	* @return the typical job title of this WFMS_Position
	*/
	@Override
	public java.lang.String getTypicalJobTitle() {
		return _wfms_Position.getTypicalJobTitle();
	}

	/**
	* Returns the weekly overtime of this WFMS_Position.
	*
	* @return the weekly overtime of this WFMS_Position
	*/
	@Override
	public java.lang.String getWeeklyOvertime() {
		return _wfms_Position.getWeeklyOvertime();
	}

	/**
	* Returns the workflow of this WFMS_Position.
	*
	* @return the workflow of this WFMS_Position
	*/
	@Override
	public java.lang.String getWorkflow() {
		return _wfms_Position.getWorkflow();
	}

	/**
	* Returns the workflow ID of this WFMS_Position.
	*
	* @return the workflow ID of this WFMS_Position
	*/
	@Override
	public java.lang.String getWorkflowId() {
		return _wfms_Position.getWorkflowId();
	}

	/**
	* Returns the workforce category of this WFMS_Position.
	*
	* @return the workforce category of this WFMS_Position
	*/
	@Override
	public java.lang.String getWorkforceCategory() {
		return _wfms_Position.getWorkforceCategory();
	}

	/**
	* Returns the year est of this WFMS_Position.
	*
	* @return the year est of this WFMS_Position
	*/
	@Override
	public java.lang.String getYearEst() {
		return _wfms_Position.getYearEst();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_Position.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_Position.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_Position.
	*
	* @return the create date of this WFMS_Position
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_Position.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_Position.
	*
	* @return the modified date of this WFMS_Position
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_Position.getModifiedDate();
	}

	/**
	* Returns the company ID of this WFMS_Position.
	*
	* @return the company ID of this WFMS_Position
	*/
	@Override
	public long getCompanyId() {
		return _wfms_Position.getCompanyId();
	}

	/**
	* Returns the scope group ID of this WFMS_Position.
	*
	* @return the scope group ID of this WFMS_Position
	*/
	@Override
	public long getScopeGroupId() {
		return _wfms_Position.getScopeGroupId();
	}

	@Override
	public void persist() {
		_wfms_Position.persist();
	}

	/**
	* Sets whether this WFMS_Position is active.
	*
	* @param active the active of this WFMS_Position
	*/
	@Override
	public void setActive(boolean active) {
		_wfms_Position.setActive(active);
	}

	/**
	* Sets the associate name of this WFMS_Position.
	*
	* @param associateName the associate name of this WFMS_Position
	*/
	@Override
	public void setAssociateName(java.lang.String associateName) {
		_wfms_Position.setAssociateName(associateName);
	}

	/**
	* Sets the associate number of this WFMS_Position.
	*
	* @param associateNumber the associate number of this WFMS_Position
	*/
	@Override
	public void setAssociateNumber(java.lang.String associateNumber) {
		_wfms_Position.setAssociateNumber(associateNumber);
	}

	/**
	* Sets the associate title of this WFMS_Position.
	*
	* @param associateTitle the associate title of this WFMS_Position
	*/
	@Override
	public void setAssociateTitle(java.lang.String associateTitle) {
		_wfms_Position.setAssociateTitle(associateTitle);
	}

	/**
	* Sets the auto generate req of this WFMS_Position.
	*
	* @param autoGenerateReq the auto generate req of this WFMS_Position
	*/
	@Override
	public void setAutoGenerateReq(java.lang.String autoGenerateReq) {
		_wfms_Position.setAutoGenerateReq(autoGenerateReq);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_Position.setCachedModel(cachedModel);
	}

	/**
	* Sets the category of this WFMS_Position.
	*
	* @param category the category of this WFMS_Position
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_wfms_Position.setCategory(category);
	}

	/**
	* Sets the comments of this WFMS_Position.
	*
	* @param comments the comments of this WFMS_Position
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_Position.setComments(comments);
	}

	/**
	* Sets the company ID of this WFMS_Position.
	*
	* @param companyId the company ID of this WFMS_Position
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wfms_Position.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this WFMS_Position.
	*
	* @param createDate the create date of this WFMS_Position
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_Position.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_Position.
	*
	* @param createdBy the created by of this WFMS_Position
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_Position.setCreatedBy(createdBy);
	}

	/**
	* Sets whether this WFMS_Position is critical.
	*
	* @param critical the critical of this WFMS_Position
	*/
	@Override
	public void setCritical(boolean critical) {
		_wfms_Position.setCritical(critical);
	}

	/**
	* Sets the degree of this WFMS_Position.
	*
	* @param degree the degree of this WFMS_Position
	*/
	@Override
	public void setDegree(java.lang.String degree) {
		_wfms_Position.setDegree(degree);
	}

	/**
	* Sets the department manager of this WFMS_Position.
	*
	* @param departmentManager the department manager of this WFMS_Position
	*/
	@Override
	public void setDepartmentManager(java.lang.String departmentManager) {
		_wfms_Position.setDepartmentManager(departmentManager);
	}

	/**
	* Sets the department name of this WFMS_Position.
	*
	* @param departmentName the department name of this WFMS_Position
	*/
	@Override
	public void setDepartmentName(java.lang.String departmentName) {
		_wfms_Position.setDepartmentName(departmentName);
	}

	/**
	* Sets the department number of this WFMS_Position.
	*
	* @param departmentNumber the department number of this WFMS_Position
	*/
	@Override
	public void setDepartmentNumber(java.lang.String departmentNumber) {
		_wfms_Position.setDepartmentNumber(departmentNumber);
	}

	/**
	* Sets the description of this WFMS_Position.
	*
	* @param description the description of this WFMS_Position
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_wfms_Position.setDescription(description);
	}

	/**
	* Sets the desired skills of this WFMS_Position.
	*
	* @param desiredSkills the desired skills of this WFMS_Position
	*/
	@Override
	public void setDesiredSkills(java.lang.String desiredSkills) {
		_wfms_Position.setDesiredSkills(desiredSkills);
	}

	/**
	* Sets the disapprove comments of this WFMS_Position.
	*
	* @param disapproveComments the disapprove comments of this WFMS_Position
	*/
	@Override
	public void setDisapproveComments(java.lang.String disapproveComments) {
		_wfms_Position.setDisapproveComments(disapproveComments);
	}

	/**
	* Sets the division of this WFMS_Position.
	*
	* @param division the division of this WFMS_Position
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_wfms_Position.setDivision(division);
	}

	/**
	* Sets the division manager of this WFMS_Position.
	*
	* @param divisionManager the division manager of this WFMS_Position
	*/
	@Override
	public void setDivisionManager(java.lang.String divisionManager) {
		_wfms_Position.setDivisionManager(divisionManager);
	}

	/**
	* Sets the dummy of this WFMS_Position.
	*
	* @param dummy the dummy of this WFMS_Position
	*/
	@Override
	public void setDummy(java.lang.String dummy) {
		_wfms_Position.setDummy(dummy);
	}

	/**
	* Sets the duties of this WFMS_Position.
	*
	* @param duties the duties of this WFMS_Position
	*/
	@Override
	public void setDuties(java.lang.String duties) {
		_wfms_Position.setDuties(duties);
	}

	/**
	* Sets the emp category of this WFMS_Position.
	*
	* @param empCategory the emp category of this WFMS_Position
	*/
	@Override
	public void setEmpCategory(java.lang.String empCategory) {
		_wfms_Position.setEmpCategory(empCategory);
	}

	/**
	* Sets the emp category desc of this WFMS_Position.
	*
	* @param empCategoryDesc the emp category desc of this WFMS_Position
	*/
	@Override
	public void setEmpCategoryDesc(java.lang.String empCategoryDesc) {
		_wfms_Position.setEmpCategoryDesc(empCategoryDesc);
	}

	/**
	* Sets the environment of this WFMS_Position.
	*
	* @param environment the environment of this WFMS_Position
	*/
	@Override
	public void setEnvironment(java.lang.String environment) {
		_wfms_Position.setEnvironment(environment);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_Position.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_Position.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_Position.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the frequency of travel of this WFMS_Position.
	*
	* @param frequencyOfTravel the frequency of travel of this WFMS_Position
	*/
	@Override
	public void setFrequencyOfTravel(java.lang.String frequencyOfTravel) {
		_wfms_Position.setFrequencyOfTravel(frequencyOfTravel);
	}

	/**
	* Sets the history of this WFMS_Position.
	*
	* @param history the history of this WFMS_Position
	*/
	@Override
	public void setHistory(java.lang.String history) {
		_wfms_Position.setHistory(history);
	}

	/**
	* Sets whether this WFMS_Position is ismodify.
	*
	* @param ismodify the ismodify of this WFMS_Position
	*/
	@Override
	public void setIsmodify(boolean ismodify) {
		_wfms_Position.setIsmodify(ismodify);
	}

	/**
	* Sets the ladder of this WFMS_Position.
	*
	* @param ladder the ladder of this WFMS_Position
	*/
	@Override
	public void setLadder(java.lang.String ladder) {
		_wfms_Position.setLadder(ladder);
	}

	/**
	* Sets the leadership assignment of this WFMS_Position.
	*
	* @param leadershipAssignment the leadership assignment of this WFMS_Position
	*/
	@Override
	public void setLeadershipAssignment(java.lang.String leadershipAssignment) {
		_wfms_Position.setLeadershipAssignment(leadershipAssignment);
	}

	/**
	* Sets the length of service of this WFMS_Position.
	*
	* @param lengthOfService the length of service of this WFMS_Position
	*/
	@Override
	public void setLengthOfService(java.lang.String lengthOfService) {
		_wfms_Position.setLengthOfService(lengthOfService);
	}

	/**
	* Sets the level of this WFMS_Position.
	*
	* @param level the level of this WFMS_Position
	*/
	@Override
	public void setLevel(java.lang.String level) {
		_wfms_Position.setLevel(level);
	}

	/**
	* Sets the line of this WFMS_Position.
	*
	* @param line the line of this WFMS_Position
	*/
	@Override
	public void setLine(java.lang.String line) {
		_wfms_Position.setLine(line);
	}

	/**
	* Sets the min job know how of this WFMS_Position.
	*
	* @param minJobKnowHow the min job know how of this WFMS_Position
	*/
	@Override
	public void setMinJobKnowHow(java.lang.String minJobKnowHow) {
		_wfms_Position.setMinJobKnowHow(minJobKnowHow);
	}

	/**
	* Sets the modified by of this WFMS_Position.
	*
	* @param modifiedBy the modified by of this WFMS_Position
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_Position.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_Position.
	*
	* @param modifiedDate the modified date of this WFMS_Position
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_Position.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the mp cat bugdet of this WFMS_Position.
	*
	* @param mpCatBugdet the mp cat bugdet of this WFMS_Position
	*/
	@Override
	public void setMpCatBugdet(java.lang.String mpCatBugdet) {
		_wfms_Position.setMpCatBugdet(mpCatBugdet);
	}

	/**
	* Sets the mp cat filled with of this WFMS_Position.
	*
	* @param mpCatFilledWith the mp cat filled with of this WFMS_Position
	*/
	@Override
	public void setMpCatFilledWith(java.lang.String mpCatFilledWith) {
		_wfms_Position.setMpCatFilledWith(mpCatFilledWith);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_Position.setNew(n);
	}

	/**
	* Sets the next approver of this WFMS_Position.
	*
	* @param nextApprover the next approver of this WFMS_Position
	*/
	@Override
	public void setNextApprover(java.lang.String nextApprover) {
		_wfms_Position.setNextApprover(nextApprover);
	}

	/**
	* Sets the number of this WFMS_Position.
	*
	* @param number the number of this WFMS_Position
	*/
	@Override
	public void setNumber(java.lang.String number) {
		_wfms_Position.setNumber(number);
	}

	/**
	* Sets the other of this WFMS_Position.
	*
	* @param other the other of this WFMS_Position
	*/
	@Override
	public void setOther(java.lang.String other) {
		_wfms_Position.setOther(other);
	}

	/**
	* Sets the p ID of this WFMS_Position.
	*
	* @param pId the p ID of this WFMS_Position
	*/
	@Override
	public void setPId(java.lang.String pId) {
		_wfms_Position.setPId(pId);
	}

	/**
	* Sets the position class of this WFMS_Position.
	*
	* @param positionClass the position class of this WFMS_Position
	*/
	@Override
	public void setPositionClass(java.lang.String positionClass) {
		_wfms_Position.setPositionClass(positionClass);
	}

	/**
	* Sets the primary key of this WFMS_Position.
	*
	* @param primaryKey the primary key of this WFMS_Position
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_Position.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_Position.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reasons for of this WFMS_Position.
	*
	* @param reasonsFor the reasons for of this WFMS_Position
	*/
	@Override
	public void setReasonsFor(java.lang.String reasonsFor) {
		_wfms_Position.setReasonsFor(reasonsFor);
	}

	/**
	* Sets the reavailuation date of this WFMS_Position.
	*
	* @param reavailuationDate the reavailuation date of this WFMS_Position
	*/
	@Override
	public void setReavailuationDate(java.lang.String reavailuationDate) {
		_wfms_Position.setReavailuationDate(reavailuationDate);
	}

	/**
	* Sets the ref pos ID of this WFMS_Position.
	*
	* @param refPosId the ref pos ID of this WFMS_Position
	*/
	@Override
	public void setRefPosId(java.lang.String refPosId) {
		_wfms_Position.setRefPosId(refPosId);
	}

	/**
	* Sets the relates to of this WFMS_Position.
	*
	* @param relatesTo the relates to of this WFMS_Position
	*/
	@Override
	public void setRelatesTo(java.lang.String relatesTo) {
		_wfms_Position.setRelatesTo(relatesTo);
	}

	/**
	* Sets the reports to of this WFMS_Position.
	*
	* @param reportsTo the reports to of this WFMS_Position
	*/
	@Override
	public void setReportsTo(java.lang.String reportsTo) {
		_wfms_Position.setReportsTo(reportsTo);
	}

	/**
	* Sets the req skills of this WFMS_Position.
	*
	* @param reqSkills the req skills of this WFMS_Position
	*/
	@Override
	public void setReqSkills(java.lang.String reqSkills) {
		_wfms_Position.setReqSkills(reqSkills);
	}

	/**
	* Sets the scope group ID of this WFMS_Position.
	*
	* @param scopeGroupId the scope group ID of this WFMS_Position
	*/
	@Override
	public void setScopeGroupId(long scopeGroupId) {
		_wfms_Position.setScopeGroupId(scopeGroupId);
	}

	/**
	* Sets the status of this WFMS_Position.
	*
	* @param status the status of this WFMS_Position
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_wfms_Position.setStatus(status);
	}

	/**
	* Sets the sub category of this WFMS_Position.
	*
	* @param subCategory the sub category of this WFMS_Position
	*/
	@Override
	public void setSubCategory(java.lang.String subCategory) {
		_wfms_Position.setSubCategory(subCategory);
	}

	/**
	* Sets the tasks performed of this WFMS_Position.
	*
	* @param tasksPerformed the tasks performed of this WFMS_Position
	*/
	@Override
	public void setTasksPerformed(java.lang.String tasksPerformed) {
		_wfms_Position.setTasksPerformed(tasksPerformed);
	}

	/**
	* Sets the type of this WFMS_Position.
	*
	* @param type the type of this WFMS_Position
	*/
	@Override
	public void setType(java.lang.String type) {
		_wfms_Position.setType(type);
	}

	/**
	* Sets the typical job title of this WFMS_Position.
	*
	* @param typicalJobTitle the typical job title of this WFMS_Position
	*/
	@Override
	public void setTypicalJobTitle(java.lang.String typicalJobTitle) {
		_wfms_Position.setTypicalJobTitle(typicalJobTitle);
	}

	/**
	* Sets the weekly overtime of this WFMS_Position.
	*
	* @param weeklyOvertime the weekly overtime of this WFMS_Position
	*/
	@Override
	public void setWeeklyOvertime(java.lang.String weeklyOvertime) {
		_wfms_Position.setWeeklyOvertime(weeklyOvertime);
	}

	/**
	* Sets the workflow of this WFMS_Position.
	*
	* @param workflow the workflow of this WFMS_Position
	*/
	@Override
	public void setWorkflow(java.lang.String workflow) {
		_wfms_Position.setWorkflow(workflow);
	}

	/**
	* Sets the workflow ID of this WFMS_Position.
	*
	* @param workflowId the workflow ID of this WFMS_Position
	*/
	@Override
	public void setWorkflowId(java.lang.String workflowId) {
		_wfms_Position.setWorkflowId(workflowId);
	}

	/**
	* Sets the workflow step of this WFMS_Position.
	*
	* @param workflowStep the workflow step of this WFMS_Position
	*/
	@Override
	public void setWorkflowStep(int workflowStep) {
		_wfms_Position.setWorkflowStep(workflowStep);
	}

	/**
	* Sets the workforce category of this WFMS_Position.
	*
	* @param workforceCategory the workforce category of this WFMS_Position
	*/
	@Override
	public void setWorkforceCategory(java.lang.String workforceCategory) {
		_wfms_Position.setWorkforceCategory(workforceCategory);
	}

	/**
	* Sets the year est of this WFMS_Position.
	*
	* @param yearEst the year est of this WFMS_Position
	*/
	@Override
	public void setYearEst(java.lang.String yearEst) {
		_wfms_Position.setYearEst(yearEst);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_PositionWrapper)) {
			return false;
		}

		WFMS_PositionWrapper wfms_PositionWrapper = (WFMS_PositionWrapper)obj;

		if (Objects.equals(_wfms_Position, wfms_PositionWrapper._wfms_Position)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_Position getWrappedModel() {
		return _wfms_Position;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_Position.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_Position.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_Position.resetOriginalValues();
	}

	private final WFMS_Position _wfms_Position;
}