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

import com.ys.hmawfm.wfms.services.model.WFMS_COS;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_COS in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS
 * @generated
 */
@ProviderType
public class WFMS_COSCacheModel implements CacheModel<WFMS_COS>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_COSCacheModel)) {
			return false;
		}

		WFMS_COSCacheModel wfms_cosCacheModel = (WFMS_COSCacheModel)obj;

		if (cosId.equals(wfms_cosCacheModel.cosId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cosId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(145);

		sb.append("{cosId=");
		sb.append(cosId);
		sb.append(", assoicateId=");
		sb.append(assoicateId);
		sb.append(", newPositionNumber=");
		sb.append(newPositionNumber);
		sb.append(", action=");
		sb.append(action);
		sb.append(", reasonCODE=");
		sb.append(reasonCODE);
		sb.append(", description=");
		sb.append(description);
		sb.append(", changeDescription=");
		sb.append(changeDescription);
		sb.append(", newJobCode=");
		sb.append(newJobCode);
		sb.append(", sameJobCode=");
		sb.append(sameJobCode);
		sb.append(", sameLeadership=");
		sb.append(sameLeadership);
		sb.append(", sameDept=");
		sb.append(sameDept);
		sb.append(", sameMgr=");
		sb.append(sameMgr);
		sb.append(", routingProcess=");
		sb.append(routingProcess);
		sb.append(", notificationTo=");
		sb.append(notificationTo);
		sb.append(", status=");
		sb.append(status);
		sb.append(", type=");
		sb.append(type);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", teamNumber=");
		sb.append(teamNumber);
		sb.append(", shiftCode=");
		sb.append(shiftCode);
		sb.append(", mgrAssociateNumber=");
		sb.append(mgrAssociateNumber);
		sb.append(", manpowerCategiry=");
		sb.append(manpowerCategiry);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", leadershipAssignment=");
		sb.append(leadershipAssignment);
		sb.append(", associateDateOfHire=");
		sb.append(associateDateOfHire);
		sb.append(", newDivision=");
		sb.append(newDivision);
		sb.append(", newDivisionManager=");
		sb.append(newDivisionManager);
		sb.append(", newDepartmentName=");
		sb.append(newDepartmentName);
		sb.append(", newDepartmentNumber=");
		sb.append(newDepartmentNumber);
		sb.append(", newDepartmentManager=");
		sb.append(newDepartmentManager);
		sb.append(", newManagerName=");
		sb.append(newManagerName);
		sb.append(", newManagerTitle=");
		sb.append(newManagerTitle);
		sb.append(", deleteflagStatus=");
		sb.append(deleteflagStatus);
		sb.append(", RequistionId=");
		sb.append(RequistionId);
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
		sb.append(", associatename=");
		sb.append(associatename);
		sb.append(", relatesTo=");
		sb.append(relatesTo);
		sb.append(", nextApprover=");
		sb.append(nextApprover);
		sb.append(", roleOfApprover=");
		sb.append(roleOfApprover);
		sb.append(", approverList=");
		sb.append(approverList);
		sb.append(", approverStep=");
		sb.append(approverStep);
		sb.append(", workflow=");
		sb.append(workflow);
		sb.append(", workflowStep=");
		sb.append(workflowStep);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", dummy=");
		sb.append(dummy);
		sb.append(", refCosId=");
		sb.append(refCosId);
		sb.append(", systemGenerated=");
		sb.append(systemGenerated);
		sb.append(", positionNumber=");
		sb.append(positionNumber);
		sb.append(", currentJobCode=");
		sb.append(currentJobCode);
		sb.append(", currentDivision=");
		sb.append(currentDivision);
		sb.append(", currentDivisionManager=");
		sb.append(currentDivisionManager);
		sb.append(", currentDepartmentName=");
		sb.append(currentDepartmentName);
		sb.append(", currentDepartmentNumber=");
		sb.append(currentDepartmentNumber);
		sb.append(", currentDepartmentManager=");
		sb.append(currentDepartmentManager);
		sb.append(", currentManagerName=");
		sb.append(currentManagerName);
		sb.append(", currentManagerTitle=");
		sb.append(currentManagerTitle);
		sb.append(", currentTeamNumber=");
		sb.append(currentTeamNumber);
		sb.append(", currentShiftCode=");
		sb.append(currentShiftCode);
		sb.append(", currentLeadershipAssignment=");
		sb.append(currentLeadershipAssignment);
		sb.append(", currentManpowerRep=");
		sb.append(currentManpowerRep);
		sb.append(", currentManagerAssocNumber=");
		sb.append(currentManagerAssocNumber);
		sb.append(", sortApprovedList=");
		sb.append(sortApprovedList);
		sb.append(", DuplicateApprovedList=");
		sb.append(DuplicateApprovedList);
		sb.append(", DuplicateApprovedListStartIndex=");
		sb.append(DuplicateApprovedListStartIndex);
		sb.append(", DuplicateApprovedListEndIndex=");
		sb.append(DuplicateApprovedListEndIndex);
		sb.append(", announced=");
		sb.append(announced);
		sb.append(", currentPositionText=");
		sb.append(currentPositionText);
		sb.append(", DuplicateCounter=");
		sb.append(DuplicateCounter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_COS toEntityModel() {
		WFMS_COSImpl wfms_cosImpl = new WFMS_COSImpl();

		if (cosId == null) {
			wfms_cosImpl.setCosId(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCosId(cosId);
		}

		if (assoicateId == null) {
			wfms_cosImpl.setAssoicateId(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setAssoicateId(assoicateId);
		}

		if (newPositionNumber == null) {
			wfms_cosImpl.setNewPositionNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewPositionNumber(newPositionNumber);
		}

		if (action == null) {
			wfms_cosImpl.setAction(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setAction(action);
		}

		if (reasonCODE == null) {
			wfms_cosImpl.setReasonCODE(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setReasonCODE(reasonCODE);
		}

		if (description == null) {
			wfms_cosImpl.setDescription(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setDescription(description);
		}

		if (changeDescription == null) {
			wfms_cosImpl.setChangeDescription(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setChangeDescription(changeDescription);
		}

		if (newJobCode == null) {
			wfms_cosImpl.setNewJobCode(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewJobCode(newJobCode);
		}

		if (sameJobCode == null) {
			wfms_cosImpl.setSameJobCode(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setSameJobCode(sameJobCode);
		}

		if (sameLeadership == null) {
			wfms_cosImpl.setSameLeadership(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setSameLeadership(sameLeadership);
		}

		if (sameDept == null) {
			wfms_cosImpl.setSameDept(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setSameDept(sameDept);
		}

		if (sameMgr == null) {
			wfms_cosImpl.setSameMgr(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setSameMgr(sameMgr);
		}

		if (routingProcess == null) {
			wfms_cosImpl.setRoutingProcess(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setRoutingProcess(routingProcess);
		}

		if (notificationTo == null) {
			wfms_cosImpl.setNotificationTo(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNotificationTo(notificationTo);
		}

		if (status == null) {
			wfms_cosImpl.setStatus(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setStatus(status);
		}

		if (type == null) {
			wfms_cosImpl.setType(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setType(type);
		}

		if (effectiveDate == null) {
			wfms_cosImpl.setEffectiveDate(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setEffectiveDate(effectiveDate);
		}

		if (teamNumber == null) {
			wfms_cosImpl.setTeamNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setTeamNumber(teamNumber);
		}

		if (shiftCode == null) {
			wfms_cosImpl.setShiftCode(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setShiftCode(shiftCode);
		}

		if (mgrAssociateNumber == null) {
			wfms_cosImpl.setMgrAssociateNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setMgrAssociateNumber(mgrAssociateNumber);
		}

		if (manpowerCategiry == null) {
			wfms_cosImpl.setManpowerCategiry(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setManpowerCategiry(manpowerCategiry);
		}

		if (comments == null) {
			wfms_cosImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setComments(comments);
		}

		if (leadershipAssignment == null) {
			wfms_cosImpl.setLeadershipAssignment(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setLeadershipAssignment(leadershipAssignment);
		}

		if (associateDateOfHire == null) {
			wfms_cosImpl.setAssociateDateOfHire(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setAssociateDateOfHire(associateDateOfHire);
		}

		if (newDivision == null) {
			wfms_cosImpl.setNewDivision(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewDivision(newDivision);
		}

		if (newDivisionManager == null) {
			wfms_cosImpl.setNewDivisionManager(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewDivisionManager(newDivisionManager);
		}

		if (newDepartmentName == null) {
			wfms_cosImpl.setNewDepartmentName(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewDepartmentName(newDepartmentName);
		}

		if (newDepartmentNumber == null) {
			wfms_cosImpl.setNewDepartmentNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewDepartmentNumber(newDepartmentNumber);
		}

		if (newDepartmentManager == null) {
			wfms_cosImpl.setNewDepartmentManager(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewDepartmentManager(newDepartmentManager);
		}

		if (newManagerName == null) {
			wfms_cosImpl.setNewManagerName(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewManagerName(newManagerName);
		}

		if (newManagerTitle == null) {
			wfms_cosImpl.setNewManagerTitle(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNewManagerTitle(newManagerTitle);
		}

		wfms_cosImpl.setDeleteflagStatus(deleteflagStatus);

		if (RequistionId == null) {
			wfms_cosImpl.setRequistionId(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setRequistionId(RequistionId);
		}

		wfms_cosImpl.setCompanyId(companyId);
		wfms_cosImpl.setScopeGroupId(scopeGroupId);

		if (createdBy == null) {
			wfms_cosImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_cosImpl.setCreateDate(null);
		}
		else {
			wfms_cosImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_cosImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_cosImpl.setModifiedDate(null);
		}
		else {
			wfms_cosImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (associatename == null) {
			wfms_cosImpl.setAssociatename(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setAssociatename(associatename);
		}

		if (relatesTo == null) {
			wfms_cosImpl.setRelatesTo(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setRelatesTo(relatesTo);
		}

		if (nextApprover == null) {
			wfms_cosImpl.setNextApprover(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setNextApprover(nextApprover);
		}

		if (roleOfApprover == null) {
			wfms_cosImpl.setRoleOfApprover(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setRoleOfApprover(roleOfApprover);
		}

		if (approverList == null) {
			wfms_cosImpl.setApproverList(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setApproverList(approverList);
		}

		wfms_cosImpl.setApproverStep(approverStep);

		if (workflow == null) {
			wfms_cosImpl.setWorkflow(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setWorkflow(workflow);
		}

		wfms_cosImpl.setWorkflowStep(workflowStep);

		if (workflowId == null) {
			wfms_cosImpl.setWorkflowId(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setWorkflowId(workflowId);
		}

		if (dummy == null) {
			wfms_cosImpl.setDummy(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setDummy(dummy);
		}

		if (refCosId == null) {
			wfms_cosImpl.setRefCosId(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setRefCosId(refCosId);
		}

		wfms_cosImpl.setSystemGenerated(systemGenerated);

		if (positionNumber == null) {
			wfms_cosImpl.setPositionNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setPositionNumber(positionNumber);
		}

		if (currentJobCode == null) {
			wfms_cosImpl.setCurrentJobCode(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentJobCode(currentJobCode);
		}

		if (currentDivision == null) {
			wfms_cosImpl.setCurrentDivision(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentDivision(currentDivision);
		}

		if (currentDivisionManager == null) {
			wfms_cosImpl.setCurrentDivisionManager(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentDivisionManager(currentDivisionManager);
		}

		if (currentDepartmentName == null) {
			wfms_cosImpl.setCurrentDepartmentName(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentDepartmentName(currentDepartmentName);
		}

		if (currentDepartmentNumber == null) {
			wfms_cosImpl.setCurrentDepartmentNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentDepartmentNumber(currentDepartmentNumber);
		}

		if (currentDepartmentManager == null) {
			wfms_cosImpl.setCurrentDepartmentManager(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentDepartmentManager(currentDepartmentManager);
		}

		if (currentManagerName == null) {
			wfms_cosImpl.setCurrentManagerName(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentManagerName(currentManagerName);
		}

		if (currentManagerTitle == null) {
			wfms_cosImpl.setCurrentManagerTitle(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentManagerTitle(currentManagerTitle);
		}

		if (currentTeamNumber == null) {
			wfms_cosImpl.setCurrentTeamNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentTeamNumber(currentTeamNumber);
		}

		if (currentShiftCode == null) {
			wfms_cosImpl.setCurrentShiftCode(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentShiftCode(currentShiftCode);
		}

		if (currentLeadershipAssignment == null) {
			wfms_cosImpl.setCurrentLeadershipAssignment(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentLeadershipAssignment(currentLeadershipAssignment);
		}

		if (currentManpowerRep == null) {
			wfms_cosImpl.setCurrentManpowerRep(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentManpowerRep(currentManpowerRep);
		}

		if (currentManagerAssocNumber == null) {
			wfms_cosImpl.setCurrentManagerAssocNumber(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setCurrentManagerAssocNumber(currentManagerAssocNumber);
		}

		if (sortApprovedList == null) {
			wfms_cosImpl.setSortApprovedList(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setSortApprovedList(sortApprovedList);
		}

		if (DuplicateApprovedList == null) {
			wfms_cosImpl.setDuplicateApprovedList(StringPool.BLANK);
		}
		else {
			wfms_cosImpl.setDuplicateApprovedList(DuplicateApprovedList);
		}

		wfms_cosImpl.setDuplicateApprovedListStartIndex(DuplicateApprovedListStartIndex);
		wfms_cosImpl.setDuplicateApprovedListEndIndex(DuplicateApprovedListEndIndex);
		wfms_cosImpl.setAnnounced(announced);
		wfms_cosImpl.setCurrentPositionText(currentPositionText);
		wfms_cosImpl.setDuplicateCounter(DuplicateCounter);

		wfms_cosImpl.resetOriginalValues();

		return wfms_cosImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cosId = objectInput.readUTF();
		assoicateId = objectInput.readUTF();
		newPositionNumber = objectInput.readUTF();
		action = objectInput.readUTF();
		reasonCODE = objectInput.readUTF();
		description = objectInput.readUTF();
		changeDescription = objectInput.readUTF();
		newJobCode = objectInput.readUTF();
		sameJobCode = objectInput.readUTF();
		sameLeadership = objectInput.readUTF();
		sameDept = objectInput.readUTF();
		sameMgr = objectInput.readUTF();
		routingProcess = objectInput.readUTF();
		notificationTo = objectInput.readUTF();
		status = objectInput.readUTF();
		type = objectInput.readUTF();
		effectiveDate = objectInput.readUTF();
		teamNumber = objectInput.readUTF();
		shiftCode = objectInput.readUTF();
		mgrAssociateNumber = objectInput.readUTF();
		manpowerCategiry = objectInput.readUTF();
		comments = objectInput.readUTF();
		leadershipAssignment = objectInput.readUTF();
		associateDateOfHire = objectInput.readUTF();
		newDivision = objectInput.readUTF();
		newDivisionManager = objectInput.readUTF();
		newDepartmentName = objectInput.readUTF();
		newDepartmentNumber = objectInput.readUTF();
		newDepartmentManager = objectInput.readUTF();
		newManagerName = objectInput.readUTF();
		newManagerTitle = objectInput.readUTF();

		deleteflagStatus = objectInput.readInt();
		RequistionId = objectInput.readUTF();

		companyId = objectInput.readLong();

		scopeGroupId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		associatename = objectInput.readUTF();
		relatesTo = objectInput.readUTF();
		nextApprover = objectInput.readUTF();
		roleOfApprover = objectInput.readUTF();
		approverList = objectInput.readUTF();

		approverStep = objectInput.readInt();
		workflow = objectInput.readUTF();

		workflowStep = objectInput.readInt();
		workflowId = objectInput.readUTF();
		dummy = objectInput.readUTF();
		refCosId = objectInput.readUTF();

		systemGenerated = objectInput.readInt();
		positionNumber = objectInput.readUTF();
		currentJobCode = objectInput.readUTF();
		currentDivision = objectInput.readUTF();
		currentDivisionManager = objectInput.readUTF();
		currentDepartmentName = objectInput.readUTF();
		currentDepartmentNumber = objectInput.readUTF();
		currentDepartmentManager = objectInput.readUTF();
		currentManagerName = objectInput.readUTF();
		currentManagerTitle = objectInput.readUTF();
		currentTeamNumber = objectInput.readUTF();
		currentShiftCode = objectInput.readUTF();
		currentLeadershipAssignment = objectInput.readUTF();
		currentManpowerRep = objectInput.readUTF();
		currentManagerAssocNumber = objectInput.readUTF();
		sortApprovedList = objectInput.readUTF();
		DuplicateApprovedList = objectInput.readUTF();

		DuplicateApprovedListStartIndex = objectInput.readInt();

		DuplicateApprovedListEndIndex = objectInput.readInt();

		announced = objectInput.readInt();

		currentPositionText = objectInput.readInt();

		DuplicateCounter = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (cosId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cosId);
		}

		if (assoicateId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assoicateId);
		}

		if (newPositionNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newPositionNumber);
		}

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (reasonCODE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonCODE);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (changeDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(changeDescription);
		}

		if (newJobCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newJobCode);
		}

		if (sameJobCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sameJobCode);
		}

		if (sameLeadership == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sameLeadership);
		}

		if (sameDept == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sameDept);
		}

		if (sameMgr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sameMgr);
		}

		if (routingProcess == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(routingProcess);
		}

		if (notificationTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notificationTo);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (effectiveDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(effectiveDate);
		}

		if (teamNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(teamNumber);
		}

		if (shiftCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shiftCode);
		}

		if (mgrAssociateNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mgrAssociateNumber);
		}

		if (manpowerCategiry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(manpowerCategiry);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (leadershipAssignment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leadershipAssignment);
		}

		if (associateDateOfHire == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateDateOfHire);
		}

		if (newDivision == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newDivision);
		}

		if (newDivisionManager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newDivisionManager);
		}

		if (newDepartmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newDepartmentName);
		}

		if (newDepartmentNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newDepartmentNumber);
		}

		if (newDepartmentManager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newDepartmentManager);
		}

		if (newManagerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newManagerName);
		}

		if (newManagerTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newManagerTitle);
		}

		objectOutput.writeInt(deleteflagStatus);

		if (RequistionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(RequistionId);
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

		if (associatename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associatename);
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

		if (roleOfApprover == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roleOfApprover);
		}

		if (approverList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(approverList);
		}

		objectOutput.writeInt(approverStep);

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

		if (refCosId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(refCosId);
		}

		objectOutput.writeInt(systemGenerated);

		if (positionNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionNumber);
		}

		if (currentJobCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentJobCode);
		}

		if (currentDivision == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDivision);
		}

		if (currentDivisionManager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDivisionManager);
		}

		if (currentDepartmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDepartmentName);
		}

		if (currentDepartmentNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDepartmentNumber);
		}

		if (currentDepartmentManager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDepartmentManager);
		}

		if (currentManagerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentManagerName);
		}

		if (currentManagerTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentManagerTitle);
		}

		if (currentTeamNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentTeamNumber);
		}

		if (currentShiftCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentShiftCode);
		}

		if (currentLeadershipAssignment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentLeadershipAssignment);
		}

		if (currentManpowerRep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentManpowerRep);
		}

		if (currentManagerAssocNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentManagerAssocNumber);
		}

		if (sortApprovedList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sortApprovedList);
		}

		if (DuplicateApprovedList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(DuplicateApprovedList);
		}

		objectOutput.writeInt(DuplicateApprovedListStartIndex);

		objectOutput.writeInt(DuplicateApprovedListEndIndex);

		objectOutput.writeInt(announced);

		objectOutput.writeInt(currentPositionText);

		objectOutput.writeInt(DuplicateCounter);
	}

	public String cosId;
	public String assoicateId;
	public String newPositionNumber;
	public String action;
	public String reasonCODE;
	public String description;
	public String changeDescription;
	public String newJobCode;
	public String sameJobCode;
	public String sameLeadership;
	public String sameDept;
	public String sameMgr;
	public String routingProcess;
	public String notificationTo;
	public String status;
	public String type;
	public String effectiveDate;
	public String teamNumber;
	public String shiftCode;
	public String mgrAssociateNumber;
	public String manpowerCategiry;
	public String comments;
	public String leadershipAssignment;
	public String associateDateOfHire;
	public String newDivision;
	public String newDivisionManager;
	public String newDepartmentName;
	public String newDepartmentNumber;
	public String newDepartmentManager;
	public String newManagerName;
	public String newManagerTitle;
	public int deleteflagStatus;
	public String RequistionId;
	public long companyId;
	public long scopeGroupId;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
	public String associatename;
	public String relatesTo;
	public String nextApprover;
	public String roleOfApprover;
	public String approverList;
	public int approverStep;
	public String workflow;
	public int workflowStep;
	public String workflowId;
	public String dummy;
	public String refCosId;
	public int systemGenerated;
	public String positionNumber;
	public String currentJobCode;
	public String currentDivision;
	public String currentDivisionManager;
	public String currentDepartmentName;
	public String currentDepartmentNumber;
	public String currentDepartmentManager;
	public String currentManagerName;
	public String currentManagerTitle;
	public String currentTeamNumber;
	public String currentShiftCode;
	public String currentLeadershipAssignment;
	public String currentManpowerRep;
	public String currentManagerAssocNumber;
	public String sortApprovedList;
	public String DuplicateApprovedList;
	public int DuplicateApprovedListStartIndex;
	public int DuplicateApprovedListEndIndex;
	public int announced;
	public int currentPositionText;
	public int DuplicateCounter;
}