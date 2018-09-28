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

package com.ys.hmawfm.wfms.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.ys.hmawfm.wfms.services.model.WFMS_Position;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_Position in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position
 * @generated
 */
@ProviderType
public class WFMS_PositionCacheModel implements CacheModel<WFMS_Position>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_PositionCacheModel)) {
			return false;
		}

		WFMS_PositionCacheModel wfms_PositionCacheModel = (WFMS_PositionCacheModel)obj;

		if (pId.equals(wfms_PositionCacheModel.pId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(123);

		sb.append("{pId=");
		sb.append(pId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", scopeGroupId=");
		sb.append(scopeGroupId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", number=");
		sb.append(number);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", reportsTo=");
		sb.append(reportsTo);
		sb.append(", autoGenerateReq=");
		sb.append(autoGenerateReq);
		sb.append(", critical=");
		sb.append(critical);
		sb.append(", division=");
		sb.append(division);
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append(", departmentNumber=");
		sb.append(departmentNumber);
		sb.append(", line=");
		sb.append(line);
		sb.append(", ladder=");
		sb.append(ladder);
		sb.append(", mpCatBugdet=");
		sb.append(mpCatBugdet);
		sb.append(", mpCatFilledWith=");
		sb.append(mpCatFilledWith);
		sb.append(", positionClass=");
		sb.append(positionClass);
		sb.append(", type=");
		sb.append(type);
		sb.append(", level=");
		sb.append(level);
		sb.append(", leadershipAssignment=");
		sb.append(leadershipAssignment);
		sb.append(", category=");
		sb.append(category);
		sb.append(", subCategory=");
		sb.append(subCategory);
		sb.append(", workforceCategory=");
		sb.append(workforceCategory);
		sb.append(", empCategory=");
		sb.append(empCategory);
		sb.append(", empCategoryDesc=");
		sb.append(empCategoryDesc);
		sb.append(", yearEst=");
		sb.append(yearEst);
		sb.append(", reasonsFor=");
		sb.append(reasonsFor);
		sb.append(", reavailuationDate=");
		sb.append(reavailuationDate);
		sb.append(", associateNumber=");
		sb.append(associateNumber);
		sb.append(", associateName=");
		sb.append(associateName);
		sb.append(", associateTitle=");
		sb.append(associateTitle);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", typicalJobTitle=");
		sb.append(typicalJobTitle);
		sb.append(", minJobKnowHow=");
		sb.append(minJobKnowHow);
		sb.append(", duties=");
		sb.append(duties);
		sb.append(", tasksPerformed=");
		sb.append(tasksPerformed);
		sb.append(", lengthOfService=");
		sb.append(lengthOfService);
		sb.append(", degree=");
		sb.append(degree);
		sb.append(", reqSkills=");
		sb.append(reqSkills);
		sb.append(", desiredSkills=");
		sb.append(desiredSkills);
		sb.append(", environment=");
		sb.append(environment);
		sb.append(", weeklyOvertime=");
		sb.append(weeklyOvertime);
		sb.append(", frequencyOfTravel=");
		sb.append(frequencyOfTravel);
		sb.append(", history=");
		sb.append(history);
		sb.append(", other=");
		sb.append(other);
		sb.append(", departmentManager=");
		sb.append(departmentManager);
		sb.append(", divisionManager=");
		sb.append(divisionManager);
		sb.append(", relatesTo=");
		sb.append(relatesTo);
		sb.append(", nextApprover=");
		sb.append(nextApprover);
		sb.append(", workflow=");
		sb.append(workflow);
		sb.append(", workflowStep=");
		sb.append(workflowStep);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", dummy=");
		sb.append(dummy);
		sb.append(", refPosId=");
		sb.append(refPosId);
		sb.append(", ismodify=");
		sb.append(ismodify);
		sb.append(", disapproveComments=");
		sb.append(disapproveComments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_Position toEntityModel() {
		WFMS_PositionImpl wfms_PositionImpl = new WFMS_PositionImpl();

		if (pId == null) {
			wfms_PositionImpl.setPId(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setPId(pId);
		}

		wfms_PositionImpl.setCompanyId(companyId);
		wfms_PositionImpl.setScopeGroupId(scopeGroupId);

		if (createdBy == null) {
			wfms_PositionImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_PositionImpl.setCreateDate(null);
		}
		else {
			wfms_PositionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_PositionImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_PositionImpl.setModifiedDate(null);
		}
		else {
			wfms_PositionImpl.setModifiedDate(new Date(modifiedDate));
		}

		wfms_PositionImpl.setActive(active);

		if (number == null) {
			wfms_PositionImpl.setNumber(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setNumber(number);
		}

		if (description == null) {
			wfms_PositionImpl.setDescription(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDescription(description);
		}

		if (status == null) {
			wfms_PositionImpl.setStatus(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setStatus(status);
		}

		if (reportsTo == null) {
			wfms_PositionImpl.setReportsTo(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setReportsTo(reportsTo);
		}

		if (autoGenerateReq == null) {
			wfms_PositionImpl.setAutoGenerateReq(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setAutoGenerateReq(autoGenerateReq);
		}

		wfms_PositionImpl.setCritical(critical);

		if (division == null) {
			wfms_PositionImpl.setDivision(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDivision(division);
		}

		if (departmentName == null) {
			wfms_PositionImpl.setDepartmentName(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDepartmentName(departmentName);
		}

		if (departmentNumber == null) {
			wfms_PositionImpl.setDepartmentNumber(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDepartmentNumber(departmentNumber);
		}

		if (line == null) {
			wfms_PositionImpl.setLine(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setLine(line);
		}

		if (ladder == null) {
			wfms_PositionImpl.setLadder(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setLadder(ladder);
		}

		if (mpCatBugdet == null) {
			wfms_PositionImpl.setMpCatBugdet(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setMpCatBugdet(mpCatBugdet);
		}

		if (mpCatFilledWith == null) {
			wfms_PositionImpl.setMpCatFilledWith(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setMpCatFilledWith(mpCatFilledWith);
		}

		if (positionClass == null) {
			wfms_PositionImpl.setPositionClass(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setPositionClass(positionClass);
		}

		if (type == null) {
			wfms_PositionImpl.setType(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setType(type);
		}

		if (level == null) {
			wfms_PositionImpl.setLevel(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setLevel(level);
		}

		if (leadershipAssignment == null) {
			wfms_PositionImpl.setLeadershipAssignment(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setLeadershipAssignment(leadershipAssignment);
		}

		if (category == null) {
			wfms_PositionImpl.setCategory(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setCategory(category);
		}

		if (subCategory == null) {
			wfms_PositionImpl.setSubCategory(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setSubCategory(subCategory);
		}

		if (workforceCategory == null) {
			wfms_PositionImpl.setWorkforceCategory(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setWorkforceCategory(workforceCategory);
		}

		if (empCategory == null) {
			wfms_PositionImpl.setEmpCategory(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setEmpCategory(empCategory);
		}

		if (empCategoryDesc == null) {
			wfms_PositionImpl.setEmpCategoryDesc(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setEmpCategoryDesc(empCategoryDesc);
		}

		if (yearEst == null) {
			wfms_PositionImpl.setYearEst(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setYearEst(yearEst);
		}

		if (reasonsFor == null) {
			wfms_PositionImpl.setReasonsFor(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setReasonsFor(reasonsFor);
		}

		if (reavailuationDate == null) {
			wfms_PositionImpl.setReavailuationDate(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setReavailuationDate(reavailuationDate);
		}

		if (associateNumber == null) {
			wfms_PositionImpl.setAssociateNumber(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setAssociateNumber(associateNumber);
		}

		if (associateName == null) {
			wfms_PositionImpl.setAssociateName(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setAssociateName(associateName);
		}

		if (associateTitle == null) {
			wfms_PositionImpl.setAssociateTitle(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setAssociateTitle(associateTitle);
		}

		if (comments == null) {
			wfms_PositionImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setComments(comments);
		}

		if (typicalJobTitle == null) {
			wfms_PositionImpl.setTypicalJobTitle(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setTypicalJobTitle(typicalJobTitle);
		}

		if (minJobKnowHow == null) {
			wfms_PositionImpl.setMinJobKnowHow(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setMinJobKnowHow(minJobKnowHow);
		}

		if (duties == null) {
			wfms_PositionImpl.setDuties(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDuties(duties);
		}

		if (tasksPerformed == null) {
			wfms_PositionImpl.setTasksPerformed(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setTasksPerformed(tasksPerformed);
		}

		if (lengthOfService == null) {
			wfms_PositionImpl.setLengthOfService(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setLengthOfService(lengthOfService);
		}

		if (degree == null) {
			wfms_PositionImpl.setDegree(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDegree(degree);
		}

		if (reqSkills == null) {
			wfms_PositionImpl.setReqSkills(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setReqSkills(reqSkills);
		}

		if (desiredSkills == null) {
			wfms_PositionImpl.setDesiredSkills(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDesiredSkills(desiredSkills);
		}

		if (environment == null) {
			wfms_PositionImpl.setEnvironment(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setEnvironment(environment);
		}

		if (weeklyOvertime == null) {
			wfms_PositionImpl.setWeeklyOvertime(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setWeeklyOvertime(weeklyOvertime);
		}

		if (frequencyOfTravel == null) {
			wfms_PositionImpl.setFrequencyOfTravel(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setFrequencyOfTravel(frequencyOfTravel);
		}

		if (history == null) {
			wfms_PositionImpl.setHistory(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setHistory(history);
		}

		if (other == null) {
			wfms_PositionImpl.setOther(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setOther(other);
		}

		if (departmentManager == null) {
			wfms_PositionImpl.setDepartmentManager(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDepartmentManager(departmentManager);
		}

		if (divisionManager == null) {
			wfms_PositionImpl.setDivisionManager(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDivisionManager(divisionManager);
		}

		if (relatesTo == null) {
			wfms_PositionImpl.setRelatesTo(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setRelatesTo(relatesTo);
		}

		if (nextApprover == null) {
			wfms_PositionImpl.setNextApprover(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setNextApprover(nextApprover);
		}

		if (workflow == null) {
			wfms_PositionImpl.setWorkflow(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setWorkflow(workflow);
		}

		wfms_PositionImpl.setWorkflowStep(workflowStep);

		if (workflowId == null) {
			wfms_PositionImpl.setWorkflowId(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setWorkflowId(workflowId);
		}

		if (dummy == null) {
			wfms_PositionImpl.setDummy(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDummy(dummy);
		}

		if (refPosId == null) {
			wfms_PositionImpl.setRefPosId(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setRefPosId(refPosId);
		}

		wfms_PositionImpl.setIsmodify(ismodify);

		if (disapproveComments == null) {
			wfms_PositionImpl.setDisapproveComments(StringPool.BLANK);
		}
		else {
			wfms_PositionImpl.setDisapproveComments(disapproveComments);
		}

		wfms_PositionImpl.resetOriginalValues();

		return wfms_PositionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pId = objectInput.readUTF();

		companyId = objectInput.readLong();

		scopeGroupId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		number = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		reportsTo = objectInput.readUTF();
		autoGenerateReq = objectInput.readUTF();

		critical = objectInput.readBoolean();
		division = objectInput.readUTF();
		departmentName = objectInput.readUTF();
		departmentNumber = objectInput.readUTF();
		line = objectInput.readUTF();
		ladder = objectInput.readUTF();
		mpCatBugdet = objectInput.readUTF();
		mpCatFilledWith = objectInput.readUTF();
		positionClass = objectInput.readUTF();
		type = objectInput.readUTF();
		level = objectInput.readUTF();
		leadershipAssignment = objectInput.readUTF();
		category = objectInput.readUTF();
		subCategory = objectInput.readUTF();
		workforceCategory = objectInput.readUTF();
		empCategory = objectInput.readUTF();
		empCategoryDesc = objectInput.readUTF();
		yearEst = objectInput.readUTF();
		reasonsFor = objectInput.readUTF();
		reavailuationDate = objectInput.readUTF();
		associateNumber = objectInput.readUTF();
		associateName = objectInput.readUTF();
		associateTitle = objectInput.readUTF();
		comments = objectInput.readUTF();
		typicalJobTitle = objectInput.readUTF();
		minJobKnowHow = objectInput.readUTF();
		duties = objectInput.readUTF();
		tasksPerformed = objectInput.readUTF();
		lengthOfService = objectInput.readUTF();
		degree = objectInput.readUTF();
		reqSkills = objectInput.readUTF();
		desiredSkills = objectInput.readUTF();
		environment = objectInput.readUTF();
		weeklyOvertime = objectInput.readUTF();
		frequencyOfTravel = objectInput.readUTF();
		history = objectInput.readUTF();
		other = objectInput.readUTF();
		departmentManager = objectInput.readUTF();
		divisionManager = objectInput.readUTF();
		relatesTo = objectInput.readUTF();
		nextApprover = objectInput.readUTF();
		workflow = objectInput.readUTF();

		workflowStep = objectInput.readInt();
		workflowId = objectInput.readUTF();
		dummy = objectInput.readUTF();
		refPosId = objectInput.readUTF();

		ismodify = objectInput.readBoolean();
		disapproveComments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (pId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pId);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(scopeGroupId);

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createDate);

		if (modifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(active);

		if (number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(number);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (reportsTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportsTo);
		}

		if (autoGenerateReq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(autoGenerateReq);
		}

		objectOutput.writeBoolean(critical);

		if (division == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (departmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentName);
		}

		if (departmentNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentNumber);
		}

		if (line == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(line);
		}

		if (ladder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ladder);
		}

		if (mpCatBugdet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpCatBugdet);
		}

		if (mpCatFilledWith == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpCatFilledWith);
		}

		if (positionClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionClass);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (level == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(level);
		}

		if (leadershipAssignment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leadershipAssignment);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (subCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subCategory);
		}

		if (workforceCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workforceCategory);
		}

		if (empCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(empCategory);
		}

		if (empCategoryDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(empCategoryDesc);
		}

		if (yearEst == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yearEst);
		}

		if (reasonsFor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonsFor);
		}

		if (reavailuationDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reavailuationDate);
		}

		if (associateNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateNumber);
		}

		if (associateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateName);
		}

		if (associateTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateTitle);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (typicalJobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typicalJobTitle);
		}

		if (minJobKnowHow == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minJobKnowHow);
		}

		if (duties == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duties);
		}

		if (tasksPerformed == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tasksPerformed);
		}

		if (lengthOfService == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lengthOfService);
		}

		if (degree == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(degree);
		}

		if (reqSkills == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reqSkills);
		}

		if (desiredSkills == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desiredSkills);
		}

		if (environment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(environment);
		}

		if (weeklyOvertime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(weeklyOvertime);
		}

		if (frequencyOfTravel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(frequencyOfTravel);
		}

		if (history == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(history);
		}

		if (other == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(other);
		}

		if (departmentManager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentManager);
		}

		if (divisionManager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(divisionManager);
		}

		if (relatesTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(relatesTo);
		}

		if (nextApprover == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nextApprover);
		}

		if (workflow == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflow);
		}

		objectOutput.writeInt(workflowStep);

		if (workflowId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowId);
		}

		if (dummy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dummy);
		}

		if (refPosId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(refPosId);
		}

		objectOutput.writeBoolean(ismodify);

		if (disapproveComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disapproveComments);
		}
	}

	public String pId;
	public long companyId;
	public long scopeGroupId;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
	public boolean active;
	public String number;
	public String description;
	public String status;
	public String reportsTo;
	public String autoGenerateReq;
	public boolean critical;
	public String division;
	public String departmentName;
	public String departmentNumber;
	public String line;
	public String ladder;
	public String mpCatBugdet;
	public String mpCatFilledWith;
	public String positionClass;
	public String type;
	public String level;
	public String leadershipAssignment;
	public String category;
	public String subCategory;
	public String workforceCategory;
	public String empCategory;
	public String empCategoryDesc;
	public String yearEst;
	public String reasonsFor;
	public String reavailuationDate;
	public String associateNumber;
	public String associateName;
	public String associateTitle;
	public String comments;
	public String typicalJobTitle;
	public String minJobKnowHow;
	public String duties;
	public String tasksPerformed;
	public String lengthOfService;
	public String degree;
	public String reqSkills;
	public String desiredSkills;
	public String environment;
	public String weeklyOvertime;
	public String frequencyOfTravel;
	public String history;
	public String other;
	public String departmentManager;
	public String divisionManager;
	public String relatesTo;
	public String nextApprover;
	public String workflow;
	public int workflowStep;
	public String workflowId;
	public String dummy;
	public String refPosId;
	public boolean ismodify;
	public String disapproveComments;
}