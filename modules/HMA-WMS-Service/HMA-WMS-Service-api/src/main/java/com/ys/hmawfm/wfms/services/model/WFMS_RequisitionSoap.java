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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_RequisitionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_RequisitionServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_RequisitionSoap implements Serializable {
	public static WFMS_RequisitionSoap toSoapModel(WFMS_Requisition model) {
		WFMS_RequisitionSoap soapModel = new WFMS_RequisitionSoap();

		soapModel.setRwfId(model.getRwfId());
		soapModel.setRId(model.getRId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setScopeGroupId(model.getScopeGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setNumber(model.getNumber());
		soapModel.setAssociatenumber(model.getAssociatenumber());
		soapModel.setAssociatename(model.getAssociatename());
		soapModel.setStatus(model.getStatus());
		soapModel.setPostingType(model.getPostingType());
		soapModel.setTeamNumber(model.getTeamNumber());
		soapModel.setAssociatetype(model.getAssociatetype());
		soapModel.setShiftAssign(model.getShiftAssign());
		soapModel.setHowAvailable(model.getHowAvailable());
		soapModel.setWhoReplaced(model.getWhoReplaced());
		soapModel.setDateneeded(model.getDateneeded());
		soapModel.setContactperson(model.getContactperson());
		soapModel.setContactphonenumber(model.getContactphonenumber());
		soapModel.setTaleonumber(model.getTaleonumber());
		soapModel.setOther(model.getOther());
		soapModel.setComments(model.getComments());
		soapModel.setDeleteflagStatus(model.getDeleteflagStatus());
		soapModel.setDummy(model.getDummy());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setNextapprove(model.getNextapprove());
		soapModel.setRoleOfApprover(model.getRoleOfApprover());
		soapModel.setRelatesTo(model.getRelatesTo());
		soapModel.setWorkflow(model.getWorkflow());
		soapModel.setWorkflowStep(model.getWorkflowStep());
		soapModel.setApproverStep(model.getApproverStep());
		soapModel.setRefReqId(model.getRefReqId());
		soapModel.setDisapproveComments(model.getDisapproveComments());

		return soapModel;
	}

	public static WFMS_RequisitionSoap[] toSoapModels(WFMS_Requisition[] models) {
		WFMS_RequisitionSoap[] soapModels = new WFMS_RequisitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_RequisitionSoap[][] toSoapModels(
		WFMS_Requisition[][] models) {
		WFMS_RequisitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_RequisitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_RequisitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_RequisitionSoap[] toSoapModels(
		List<WFMS_Requisition> models) {
		List<WFMS_RequisitionSoap> soapModels = new ArrayList<WFMS_RequisitionSoap>(models.size());

		for (WFMS_Requisition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_RequisitionSoap[soapModels.size()]);
	}

	public WFMS_RequisitionSoap() {
	}

	public String getPrimaryKey() {
		return _rwfId;
	}

	public void setPrimaryKey(String pk) {
		setRwfId(pk);
	}

	public String getRwfId() {
		return _rwfId;
	}

	public void setRwfId(String rwfId) {
		_rwfId = rwfId;
	}

	public String getRId() {
		return _rId;
	}

	public void setRId(String rId) {
		_rId = rId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getApprovedDate() {
		return _ApprovedDate;
	}

	public void setApprovedDate(Date ApprovedDate) {
		_ApprovedDate = ApprovedDate;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public String getNumber() {
		return _Number;
	}

	public void setNumber(String Number) {
		_Number = Number;
	}

	public String getAssociatenumber() {
		return _associatenumber;
	}

	public void setAssociatenumber(String associatenumber) {
		_associatenumber = associatenumber;
	}

	public String getAssociatename() {
		return _associatename;
	}

	public void setAssociatename(String associatename) {
		_associatename = associatename;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getPostingType() {
		return _postingType;
	}

	public void setPostingType(String postingType) {
		_postingType = postingType;
	}

	public String getTeamNumber() {
		return _teamNumber;
	}

	public void setTeamNumber(String teamNumber) {
		_teamNumber = teamNumber;
	}

	public String getAssociatetype() {
		return _associatetype;
	}

	public void setAssociatetype(String associatetype) {
		_associatetype = associatetype;
	}

	public String getShiftAssign() {
		return _shiftAssign;
	}

	public void setShiftAssign(String shiftAssign) {
		_shiftAssign = shiftAssign;
	}

	public String getHowAvailable() {
		return _howAvailable;
	}

	public void setHowAvailable(String howAvailable) {
		_howAvailable = howAvailable;
	}

	public String getWhoReplaced() {
		return _whoReplaced;
	}

	public void setWhoReplaced(String whoReplaced) {
		_whoReplaced = whoReplaced;
	}

	public String getDateneeded() {
		return _dateneeded;
	}

	public void setDateneeded(String dateneeded) {
		_dateneeded = dateneeded;
	}

	public String getContactperson() {
		return _contactperson;
	}

	public void setContactperson(String contactperson) {
		_contactperson = contactperson;
	}

	public String getContactphonenumber() {
		return _contactphonenumber;
	}

	public void setContactphonenumber(String contactphonenumber) {
		_contactphonenumber = contactphonenumber;
	}

	public String getTaleonumber() {
		return _taleonumber;
	}

	public void setTaleonumber(String taleonumber) {
		_taleonumber = taleonumber;
	}

	public String getOther() {
		return _other;
	}

	public void setOther(String other) {
		_other = other;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public int getDeleteflagStatus() {
		return _deleteflagStatus;
	}

	public void setDeleteflagStatus(int deleteflagStatus) {
		_deleteflagStatus = deleteflagStatus;
	}

	public String getDummy() {
		return _dummy;
	}

	public void setDummy(String dummy) {
		_dummy = dummy;
	}

	public String getWorkflowId() {
		return _workflowId;
	}

	public void setWorkflowId(String workflowId) {
		_workflowId = workflowId;
	}

	public String getNextapprove() {
		return _nextapprove;
	}

	public void setNextapprove(String nextapprove) {
		_nextapprove = nextapprove;
	}

	public String getRoleOfApprover() {
		return _roleOfApprover;
	}

	public void setRoleOfApprover(String roleOfApprover) {
		_roleOfApprover = roleOfApprover;
	}

	public String getRelatesTo() {
		return _relatesTo;
	}

	public void setRelatesTo(String relatesTo) {
		_relatesTo = relatesTo;
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

	public int getApproverStep() {
		return _approverStep;
	}

	public void setApproverStep(int approverStep) {
		_approverStep = approverStep;
	}

	public String getRefReqId() {
		return _refReqId;
	}

	public void setRefReqId(String refReqId) {
		_refReqId = refReqId;
	}

	public String getDisapproveComments() {
		return _disapproveComments;
	}

	public void setDisapproveComments(String disapproveComments) {
		_disapproveComments = disapproveComments;
	}

	private String _rwfId;
	private String _rId;
	private long _companyId;
	private long _scopeGroupId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _ApprovedDate;
	private String _createdBy;
	private String _Number;
	private String _associatenumber;
	private String _associatename;
	private String _status;
	private String _postingType;
	private String _teamNumber;
	private String _associatetype;
	private String _shiftAssign;
	private String _howAvailable;
	private String _whoReplaced;
	private String _dateneeded;
	private String _contactperson;
	private String _contactphonenumber;
	private String _taleonumber;
	private String _other;
	private String _comments;
	private int _deleteflagStatus;
	private String _dummy;
	private String _workflowId;
	private String _nextapprove;
	private String _roleOfApprover;
	private String _relatesTo;
	private String _workflow;
	private int _workflowStep;
	private int _approverStep;
	private String _refReqId;
	private String _disapproveComments;
}