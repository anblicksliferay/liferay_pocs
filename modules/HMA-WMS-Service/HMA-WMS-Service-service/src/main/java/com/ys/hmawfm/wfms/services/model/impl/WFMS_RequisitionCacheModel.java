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

import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_Requisition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition
 * @generated
 */
@ProviderType
public class WFMS_RequisitionCacheModel implements CacheModel<WFMS_Requisition>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_RequisitionCacheModel)) {
			return false;
		}

		WFMS_RequisitionCacheModel wfms_RequisitionCacheModel = (WFMS_RequisitionCacheModel)obj;

		if (rwfId.equals(wfms_RequisitionCacheModel.rwfId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rwfId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{rwfId=");
		sb.append(rwfId);
		sb.append(", rId=");
		sb.append(rId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", scopeGroupId=");
		sb.append(scopeGroupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ApprovedDate=");
		sb.append(ApprovedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", Number=");
		sb.append(Number);
		sb.append(", associatenumber=");
		sb.append(associatenumber);
		sb.append(", associatename=");
		sb.append(associatename);
		sb.append(", status=");
		sb.append(status);
		sb.append(", postingType=");
		sb.append(postingType);
		sb.append(", teamNumber=");
		sb.append(teamNumber);
		sb.append(", associatetype=");
		sb.append(associatetype);
		sb.append(", shiftAssign=");
		sb.append(shiftAssign);
		sb.append(", howAvailable=");
		sb.append(howAvailable);
		sb.append(", whoReplaced=");
		sb.append(whoReplaced);
		sb.append(", dateneeded=");
		sb.append(dateneeded);
		sb.append(", contactperson=");
		sb.append(contactperson);
		sb.append(", contactphonenumber=");
		sb.append(contactphonenumber);
		sb.append(", taleonumber=");
		sb.append(taleonumber);
		sb.append(", other=");
		sb.append(other);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", deleteflagStatus=");
		sb.append(deleteflagStatus);
		sb.append(", dummy=");
		sb.append(dummy);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", nextapprove=");
		sb.append(nextapprove);
		sb.append(", roleOfApprover=");
		sb.append(roleOfApprover);
		sb.append(", relatesTo=");
		sb.append(relatesTo);
		sb.append(", workflow=");
		sb.append(workflow);
		sb.append(", workflowStep=");
		sb.append(workflowStep);
		sb.append(", approverStep=");
		sb.append(approverStep);
		sb.append(", refReqId=");
		sb.append(refReqId);
		sb.append(", disapproveComments=");
		sb.append(disapproveComments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_Requisition toEntityModel() {
		WFMS_RequisitionImpl wfms_RequisitionImpl = new WFMS_RequisitionImpl();

		if (rwfId == null) {
			wfms_RequisitionImpl.setRwfId(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setRwfId(rwfId);
		}

		if (rId == null) {
			wfms_RequisitionImpl.setRId(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setRId(rId);
		}

		wfms_RequisitionImpl.setCompanyId(companyId);
		wfms_RequisitionImpl.setScopeGroupId(scopeGroupId);

		if (createDate == Long.MIN_VALUE) {
			wfms_RequisitionImpl.setCreateDate(null);
		}
		else {
			wfms_RequisitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_RequisitionImpl.setModifiedDate(null);
		}
		else {
			wfms_RequisitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ApprovedDate == Long.MIN_VALUE) {
			wfms_RequisitionImpl.setApprovedDate(null);
		}
		else {
			wfms_RequisitionImpl.setApprovedDate(new Date(ApprovedDate));
		}

		if (createdBy == null) {
			wfms_RequisitionImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setCreatedBy(createdBy);
		}

		if (Number == null) {
			wfms_RequisitionImpl.setNumber(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setNumber(Number);
		}

		if (associatenumber == null) {
			wfms_RequisitionImpl.setAssociatenumber(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setAssociatenumber(associatenumber);
		}

		if (associatename == null) {
			wfms_RequisitionImpl.setAssociatename(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setAssociatename(associatename);
		}

		if (status == null) {
			wfms_RequisitionImpl.setStatus(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setStatus(status);
		}

		if (postingType == null) {
			wfms_RequisitionImpl.setPostingType(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setPostingType(postingType);
		}

		if (teamNumber == null) {
			wfms_RequisitionImpl.setTeamNumber(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setTeamNumber(teamNumber);
		}

		if (associatetype == null) {
			wfms_RequisitionImpl.setAssociatetype(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setAssociatetype(associatetype);
		}

		if (shiftAssign == null) {
			wfms_RequisitionImpl.setShiftAssign(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setShiftAssign(shiftAssign);
		}

		if (howAvailable == null) {
			wfms_RequisitionImpl.setHowAvailable(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setHowAvailable(howAvailable);
		}

		if (whoReplaced == null) {
			wfms_RequisitionImpl.setWhoReplaced(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setWhoReplaced(whoReplaced);
		}

		if (dateneeded == null) {
			wfms_RequisitionImpl.setDateneeded(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setDateneeded(dateneeded);
		}

		if (contactperson == null) {
			wfms_RequisitionImpl.setContactperson(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setContactperson(contactperson);
		}

		if (contactphonenumber == null) {
			wfms_RequisitionImpl.setContactphonenumber(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setContactphonenumber(contactphonenumber);
		}

		if (taleonumber == null) {
			wfms_RequisitionImpl.setTaleonumber(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setTaleonumber(taleonumber);
		}

		if (other == null) {
			wfms_RequisitionImpl.setOther(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setOther(other);
		}

		if (comments == null) {
			wfms_RequisitionImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setComments(comments);
		}

		wfms_RequisitionImpl.setDeleteflagStatus(deleteflagStatus);

		if (dummy == null) {
			wfms_RequisitionImpl.setDummy(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setDummy(dummy);
		}

		if (workflowId == null) {
			wfms_RequisitionImpl.setWorkflowId(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setWorkflowId(workflowId);
		}

		if (nextapprove == null) {
			wfms_RequisitionImpl.setNextapprove(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setNextapprove(nextapprove);
		}

		if (roleOfApprover == null) {
			wfms_RequisitionImpl.setRoleOfApprover(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setRoleOfApprover(roleOfApprover);
		}

		if (relatesTo == null) {
			wfms_RequisitionImpl.setRelatesTo(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setRelatesTo(relatesTo);
		}

		if (workflow == null) {
			wfms_RequisitionImpl.setWorkflow(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setWorkflow(workflow);
		}

		wfms_RequisitionImpl.setWorkflowStep(workflowStep);
		wfms_RequisitionImpl.setApproverStep(approverStep);

		if (refReqId == null) {
			wfms_RequisitionImpl.setRefReqId(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setRefReqId(refReqId);
		}

		if (disapproveComments == null) {
			wfms_RequisitionImpl.setDisapproveComments(StringPool.BLANK);
		}
		else {
			wfms_RequisitionImpl.setDisapproveComments(disapproveComments);
		}

		wfms_RequisitionImpl.resetOriginalValues();

		return wfms_RequisitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rwfId = objectInput.readUTF();
		rId = objectInput.readUTF();

		companyId = objectInput.readLong();

		scopeGroupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ApprovedDate = objectInput.readLong();
		createdBy = objectInput.readUTF();
		Number = objectInput.readUTF();
		associatenumber = objectInput.readUTF();
		associatename = objectInput.readUTF();
		status = objectInput.readUTF();
		postingType = objectInput.readUTF();
		teamNumber = objectInput.readUTF();
		associatetype = objectInput.readUTF();
		shiftAssign = objectInput.readUTF();
		howAvailable = objectInput.readUTF();
		whoReplaced = objectInput.readUTF();
		dateneeded = objectInput.readUTF();
		contactperson = objectInput.readUTF();
		contactphonenumber = objectInput.readUTF();
		taleonumber = objectInput.readUTF();
		other = objectInput.readUTF();
		comments = objectInput.readUTF();

		deleteflagStatus = objectInput.readInt();
		dummy = objectInput.readUTF();
		workflowId = objectInput.readUTF();
		nextapprove = objectInput.readUTF();
		roleOfApprover = objectInput.readUTF();
		relatesTo = objectInput.readUTF();
		workflow = objectInput.readUTF();

		workflowStep = objectInput.readInt();

		approverStep = objectInput.readInt();
		refReqId = objectInput.readUTF();
		disapproveComments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (rwfId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rwfId);
		}

		if (rId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rId);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(scopeGroupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(ApprovedDate);

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (Number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Number);
		}

		if (associatenumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associatenumber);
		}

		if (associatename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associatename);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (postingType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postingType);
		}

		if (teamNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(teamNumber);
		}

		if (associatetype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associatetype);
		}

		if (shiftAssign == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shiftAssign);
		}

		if (howAvailable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(howAvailable);
		}

		if (whoReplaced == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(whoReplaced);
		}

		if (dateneeded == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dateneeded);
		}

		if (contactperson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactperson);
		}

		if (contactphonenumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactphonenumber);
		}

		if (taleonumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taleonumber);
		}

		if (other == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(other);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeInt(deleteflagStatus);

		if (dummy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dummy);
		}

		if (workflowId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowId);
		}

		if (nextapprove == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nextapprove);
		}

		if (roleOfApprover == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roleOfApprover);
		}

		if (relatesTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(relatesTo);
		}

		if (workflow == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflow);
		}

		objectOutput.writeInt(workflowStep);

		objectOutput.writeInt(approverStep);

		if (refReqId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(refReqId);
		}

		if (disapproveComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disapproveComments);
		}
	}

	public String rwfId;
	public String rId;
	public long companyId;
	public long scopeGroupId;
	public long createDate;
	public long modifiedDate;
	public long ApprovedDate;
	public String createdBy;
	public String Number;
	public String associatenumber;
	public String associatename;
	public String status;
	public String postingType;
	public String teamNumber;
	public String associatetype;
	public String shiftAssign;
	public String howAvailable;
	public String whoReplaced;
	public String dateneeded;
	public String contactperson;
	public String contactphonenumber;
	public String taleonumber;
	public String other;
	public String comments;
	public int deleteflagStatus;
	public String dummy;
	public String workflowId;
	public String nextapprove;
	public String roleOfApprover;
	public String relatesTo;
	public String workflow;
	public int workflowStep;
	public int approverStep;
	public String refReqId;
	public String disapproveComments;
}