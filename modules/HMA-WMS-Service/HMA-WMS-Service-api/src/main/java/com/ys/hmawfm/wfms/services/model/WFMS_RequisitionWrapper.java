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
 * This class is a wrapper for {@link WFMS_Requisition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition
 * @generated
 */
@ProviderType
public class WFMS_RequisitionWrapper implements WFMS_Requisition,
	ModelWrapper<WFMS_Requisition> {
	public WFMS_RequisitionWrapper(WFMS_Requisition wfms_Requisition) {
		_wfms_Requisition = wfms_Requisition;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_Requisition.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_Requisition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rwfId", getRwfId());
		attributes.put("rId", getRId());
		attributes.put("companyId", getCompanyId());
		attributes.put("scopeGroupId", getScopeGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ApprovedDate", getApprovedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("Number", getNumber());
		attributes.put("associatenumber", getAssociatenumber());
		attributes.put("associatename", getAssociatename());
		attributes.put("status", getStatus());
		attributes.put("postingType", getPostingType());
		attributes.put("teamNumber", getTeamNumber());
		attributes.put("associatetype", getAssociatetype());
		attributes.put("shiftAssign", getShiftAssign());
		attributes.put("howAvailable", getHowAvailable());
		attributes.put("whoReplaced", getWhoReplaced());
		attributes.put("dateneeded", getDateneeded());
		attributes.put("contactperson", getContactperson());
		attributes.put("contactphonenumber", getContactphonenumber());
		attributes.put("taleonumber", getTaleonumber());
		attributes.put("other", getOther());
		attributes.put("comments", getComments());
		attributes.put("deleteflagStatus", getDeleteflagStatus());
		attributes.put("dummy", getDummy());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("nextapprove", getNextapprove());
		attributes.put("roleOfApprover", getRoleOfApprover());
		attributes.put("relatesTo", getRelatesTo());
		attributes.put("workflow", getWorkflow());
		attributes.put("workflowStep", getWorkflowStep());
		attributes.put("approverStep", getApproverStep());
		attributes.put("refReqId", getRefReqId());
		attributes.put("disapproveComments", getDisapproveComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String rwfId = (String)attributes.get("rwfId");

		if (rwfId != null) {
			setRwfId(rwfId);
		}

		String rId = (String)attributes.get("rId");

		if (rId != null) {
			setRId(rId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long scopeGroupId = (Long)attributes.get("scopeGroupId");

		if (scopeGroupId != null) {
			setScopeGroupId(scopeGroupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date ApprovedDate = (Date)attributes.get("ApprovedDate");

		if (ApprovedDate != null) {
			setApprovedDate(ApprovedDate);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String Number = (String)attributes.get("Number");

		if (Number != null) {
			setNumber(Number);
		}

		String associatenumber = (String)attributes.get("associatenumber");

		if (associatenumber != null) {
			setAssociatenumber(associatenumber);
		}

		String associatename = (String)attributes.get("associatename");

		if (associatename != null) {
			setAssociatename(associatename);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String postingType = (String)attributes.get("postingType");

		if (postingType != null) {
			setPostingType(postingType);
		}

		String teamNumber = (String)attributes.get("teamNumber");

		if (teamNumber != null) {
			setTeamNumber(teamNumber);
		}

		String associatetype = (String)attributes.get("associatetype");

		if (associatetype != null) {
			setAssociatetype(associatetype);
		}

		String shiftAssign = (String)attributes.get("shiftAssign");

		if (shiftAssign != null) {
			setShiftAssign(shiftAssign);
		}

		String howAvailable = (String)attributes.get("howAvailable");

		if (howAvailable != null) {
			setHowAvailable(howAvailable);
		}

		String whoReplaced = (String)attributes.get("whoReplaced");

		if (whoReplaced != null) {
			setWhoReplaced(whoReplaced);
		}

		String dateneeded = (String)attributes.get("dateneeded");

		if (dateneeded != null) {
			setDateneeded(dateneeded);
		}

		String contactperson = (String)attributes.get("contactperson");

		if (contactperson != null) {
			setContactperson(contactperson);
		}

		String contactphonenumber = (String)attributes.get("contactphonenumber");

		if (contactphonenumber != null) {
			setContactphonenumber(contactphonenumber);
		}

		String taleonumber = (String)attributes.get("taleonumber");

		if (taleonumber != null) {
			setTaleonumber(taleonumber);
		}

		String other = (String)attributes.get("other");

		if (other != null) {
			setOther(other);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Integer deleteflagStatus = (Integer)attributes.get("deleteflagStatus");

		if (deleteflagStatus != null) {
			setDeleteflagStatus(deleteflagStatus);
		}

		String dummy = (String)attributes.get("dummy");

		if (dummy != null) {
			setDummy(dummy);
		}

		String workflowId = (String)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		String nextapprove = (String)attributes.get("nextapprove");

		if (nextapprove != null) {
			setNextapprove(nextapprove);
		}

		String roleOfApprover = (String)attributes.get("roleOfApprover");

		if (roleOfApprover != null) {
			setRoleOfApprover(roleOfApprover);
		}

		String relatesTo = (String)attributes.get("relatesTo");

		if (relatesTo != null) {
			setRelatesTo(relatesTo);
		}

		String workflow = (String)attributes.get("workflow");

		if (workflow != null) {
			setWorkflow(workflow);
		}

		Integer workflowStep = (Integer)attributes.get("workflowStep");

		if (workflowStep != null) {
			setWorkflowStep(workflowStep);
		}

		Integer approverStep = (Integer)attributes.get("approverStep");

		if (approverStep != null) {
			setApproverStep(approverStep);
		}

		String refReqId = (String)attributes.get("refReqId");

		if (refReqId != null) {
			setRefReqId(refReqId);
		}

		String disapproveComments = (String)attributes.get("disapproveComments");

		if (disapproveComments != null) {
			setDisapproveComments(disapproveComments);
		}
	}

	@Override
	public WFMS_Requisition toEscapedModel() {
		return new WFMS_RequisitionWrapper(_wfms_Requisition.toEscapedModel());
	}

	@Override
	public WFMS_Requisition toUnescapedModel() {
		return new WFMS_RequisitionWrapper(_wfms_Requisition.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_Requisition.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_Requisition.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_Requisition.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_Requisition.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_Requisition> toCacheModel() {
		return _wfms_Requisition.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_Requisition wfms_Requisition) {
		return _wfms_Requisition.compareTo(wfms_Requisition);
	}

	/**
	* Returns the approver step of this WFMS_Requisition.
	*
	* @return the approver step of this WFMS_Requisition
	*/
	@Override
	public int getApproverStep() {
		return _wfms_Requisition.getApproverStep();
	}

	/**
	* Returns the deleteflag status of this WFMS_Requisition.
	*
	* @return the deleteflag status of this WFMS_Requisition
	*/
	@Override
	public int getDeleteflagStatus() {
		return _wfms_Requisition.getDeleteflagStatus();
	}

	/**
	* Returns the workflow step of this WFMS_Requisition.
	*
	* @return the workflow step of this WFMS_Requisition
	*/
	@Override
	public int getWorkflowStep() {
		return _wfms_Requisition.getWorkflowStep();
	}

	@Override
	public int hashCode() {
		return _wfms_Requisition.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_Requisition.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_RequisitionWrapper((WFMS_Requisition)_wfms_Requisition.clone());
	}

	/**
	* Returns the associatename of this WFMS_Requisition.
	*
	* @return the associatename of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getAssociatename() {
		return _wfms_Requisition.getAssociatename();
	}

	/**
	* Returns the associatenumber of this WFMS_Requisition.
	*
	* @return the associatenumber of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getAssociatenumber() {
		return _wfms_Requisition.getAssociatenumber();
	}

	/**
	* Returns the associatetype of this WFMS_Requisition.
	*
	* @return the associatetype of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getAssociatetype() {
		return _wfms_Requisition.getAssociatetype();
	}

	/**
	* Returns the comments of this WFMS_Requisition.
	*
	* @return the comments of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_Requisition.getComments();
	}

	/**
	* Returns the contactperson of this WFMS_Requisition.
	*
	* @return the contactperson of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getContactperson() {
		return _wfms_Requisition.getContactperson();
	}

	/**
	* Returns the contactphonenumber of this WFMS_Requisition.
	*
	* @return the contactphonenumber of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getContactphonenumber() {
		return _wfms_Requisition.getContactphonenumber();
	}

	/**
	* Returns the created by of this WFMS_Requisition.
	*
	* @return the created by of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_Requisition.getCreatedBy();
	}

	/**
	* Returns the dateneeded of this WFMS_Requisition.
	*
	* @return the dateneeded of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getDateneeded() {
		return _wfms_Requisition.getDateneeded();
	}

	/**
	* Returns the disapprove comments of this WFMS_Requisition.
	*
	* @return the disapprove comments of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getDisapproveComments() {
		return _wfms_Requisition.getDisapproveComments();
	}

	/**
	* Returns the dummy of this WFMS_Requisition.
	*
	* @return the dummy of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getDummy() {
		return _wfms_Requisition.getDummy();
	}

	/**
	* Returns the how available of this WFMS_Requisition.
	*
	* @return the how available of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getHowAvailable() {
		return _wfms_Requisition.getHowAvailable();
	}

	/**
	* Returns the nextapprove of this WFMS_Requisition.
	*
	* @return the nextapprove of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getNextapprove() {
		return _wfms_Requisition.getNextapprove();
	}

	/**
	* Returns the number of this WFMS_Requisition.
	*
	* @return the number of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getNumber() {
		return _wfms_Requisition.getNumber();
	}

	/**
	* Returns the other of this WFMS_Requisition.
	*
	* @return the other of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getOther() {
		return _wfms_Requisition.getOther();
	}

	/**
	* Returns the posting type of this WFMS_Requisition.
	*
	* @return the posting type of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getPostingType() {
		return _wfms_Requisition.getPostingType();
	}

	/**
	* Returns the primary key of this WFMS_Requisition.
	*
	* @return the primary key of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_Requisition.getPrimaryKey();
	}

	/**
	* Returns the r ID of this WFMS_Requisition.
	*
	* @return the r ID of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getRId() {
		return _wfms_Requisition.getRId();
	}

	/**
	* Returns the ref req ID of this WFMS_Requisition.
	*
	* @return the ref req ID of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getRefReqId() {
		return _wfms_Requisition.getRefReqId();
	}

	/**
	* Returns the relates to of this WFMS_Requisition.
	*
	* @return the relates to of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getRelatesTo() {
		return _wfms_Requisition.getRelatesTo();
	}

	/**
	* Returns the role of approver of this WFMS_Requisition.
	*
	* @return the role of approver of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getRoleOfApprover() {
		return _wfms_Requisition.getRoleOfApprover();
	}

	/**
	* Returns the rwf ID of this WFMS_Requisition.
	*
	* @return the rwf ID of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getRwfId() {
		return _wfms_Requisition.getRwfId();
	}

	/**
	* Returns the shift assign of this WFMS_Requisition.
	*
	* @return the shift assign of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getShiftAssign() {
		return _wfms_Requisition.getShiftAssign();
	}

	/**
	* Returns the status of this WFMS_Requisition.
	*
	* @return the status of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getStatus() {
		return _wfms_Requisition.getStatus();
	}

	/**
	* Returns the taleonumber of this WFMS_Requisition.
	*
	* @return the taleonumber of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getTaleonumber() {
		return _wfms_Requisition.getTaleonumber();
	}

	/**
	* Returns the team number of this WFMS_Requisition.
	*
	* @return the team number of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getTeamNumber() {
		return _wfms_Requisition.getTeamNumber();
	}

	/**
	* Returns the who replaced of this WFMS_Requisition.
	*
	* @return the who replaced of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getWhoReplaced() {
		return _wfms_Requisition.getWhoReplaced();
	}

	/**
	* Returns the workflow of this WFMS_Requisition.
	*
	* @return the workflow of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getWorkflow() {
		return _wfms_Requisition.getWorkflow();
	}

	/**
	* Returns the workflow ID of this WFMS_Requisition.
	*
	* @return the workflow ID of this WFMS_Requisition
	*/
	@Override
	public java.lang.String getWorkflowId() {
		return _wfms_Requisition.getWorkflowId();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_Requisition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_Requisition.toXmlString();
	}

	/**
	* Returns the approved date of this WFMS_Requisition.
	*
	* @return the approved date of this WFMS_Requisition
	*/
	@Override
	public Date getApprovedDate() {
		return _wfms_Requisition.getApprovedDate();
	}

	/**
	* Returns the create date of this WFMS_Requisition.
	*
	* @return the create date of this WFMS_Requisition
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_Requisition.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_Requisition.
	*
	* @return the modified date of this WFMS_Requisition
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_Requisition.getModifiedDate();
	}

	/**
	* Returns the company ID of this WFMS_Requisition.
	*
	* @return the company ID of this WFMS_Requisition
	*/
	@Override
	public long getCompanyId() {
		return _wfms_Requisition.getCompanyId();
	}

	/**
	* Returns the scope group ID of this WFMS_Requisition.
	*
	* @return the scope group ID of this WFMS_Requisition
	*/
	@Override
	public long getScopeGroupId() {
		return _wfms_Requisition.getScopeGroupId();
	}

	@Override
	public void persist() {
		_wfms_Requisition.persist();
	}

	/**
	* Sets the approved date of this WFMS_Requisition.
	*
	* @param ApprovedDate the approved date of this WFMS_Requisition
	*/
	@Override
	public void setApprovedDate(Date ApprovedDate) {
		_wfms_Requisition.setApprovedDate(ApprovedDate);
	}

	/**
	* Sets the approver step of this WFMS_Requisition.
	*
	* @param approverStep the approver step of this WFMS_Requisition
	*/
	@Override
	public void setApproverStep(int approverStep) {
		_wfms_Requisition.setApproverStep(approverStep);
	}

	/**
	* Sets the associatename of this WFMS_Requisition.
	*
	* @param associatename the associatename of this WFMS_Requisition
	*/
	@Override
	public void setAssociatename(java.lang.String associatename) {
		_wfms_Requisition.setAssociatename(associatename);
	}

	/**
	* Sets the associatenumber of this WFMS_Requisition.
	*
	* @param associatenumber the associatenumber of this WFMS_Requisition
	*/
	@Override
	public void setAssociatenumber(java.lang.String associatenumber) {
		_wfms_Requisition.setAssociatenumber(associatenumber);
	}

	/**
	* Sets the associatetype of this WFMS_Requisition.
	*
	* @param associatetype the associatetype of this WFMS_Requisition
	*/
	@Override
	public void setAssociatetype(java.lang.String associatetype) {
		_wfms_Requisition.setAssociatetype(associatetype);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_Requisition.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this WFMS_Requisition.
	*
	* @param comments the comments of this WFMS_Requisition
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_Requisition.setComments(comments);
	}

	/**
	* Sets the company ID of this WFMS_Requisition.
	*
	* @param companyId the company ID of this WFMS_Requisition
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wfms_Requisition.setCompanyId(companyId);
	}

	/**
	* Sets the contactperson of this WFMS_Requisition.
	*
	* @param contactperson the contactperson of this WFMS_Requisition
	*/
	@Override
	public void setContactperson(java.lang.String contactperson) {
		_wfms_Requisition.setContactperson(contactperson);
	}

	/**
	* Sets the contactphonenumber of this WFMS_Requisition.
	*
	* @param contactphonenumber the contactphonenumber of this WFMS_Requisition
	*/
	@Override
	public void setContactphonenumber(java.lang.String contactphonenumber) {
		_wfms_Requisition.setContactphonenumber(contactphonenumber);
	}

	/**
	* Sets the create date of this WFMS_Requisition.
	*
	* @param createDate the create date of this WFMS_Requisition
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_Requisition.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_Requisition.
	*
	* @param createdBy the created by of this WFMS_Requisition
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_Requisition.setCreatedBy(createdBy);
	}

	/**
	* Sets the dateneeded of this WFMS_Requisition.
	*
	* @param dateneeded the dateneeded of this WFMS_Requisition
	*/
	@Override
	public void setDateneeded(java.lang.String dateneeded) {
		_wfms_Requisition.setDateneeded(dateneeded);
	}

	/**
	* Sets the deleteflag status of this WFMS_Requisition.
	*
	* @param deleteflagStatus the deleteflag status of this WFMS_Requisition
	*/
	@Override
	public void setDeleteflagStatus(int deleteflagStatus) {
		_wfms_Requisition.setDeleteflagStatus(deleteflagStatus);
	}

	/**
	* Sets the disapprove comments of this WFMS_Requisition.
	*
	* @param disapproveComments the disapprove comments of this WFMS_Requisition
	*/
	@Override
	public void setDisapproveComments(java.lang.String disapproveComments) {
		_wfms_Requisition.setDisapproveComments(disapproveComments);
	}

	/**
	* Sets the dummy of this WFMS_Requisition.
	*
	* @param dummy the dummy of this WFMS_Requisition
	*/
	@Override
	public void setDummy(java.lang.String dummy) {
		_wfms_Requisition.setDummy(dummy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_Requisition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_Requisition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_Requisition.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the how available of this WFMS_Requisition.
	*
	* @param howAvailable the how available of this WFMS_Requisition
	*/
	@Override
	public void setHowAvailable(java.lang.String howAvailable) {
		_wfms_Requisition.setHowAvailable(howAvailable);
	}

	/**
	* Sets the modified date of this WFMS_Requisition.
	*
	* @param modifiedDate the modified date of this WFMS_Requisition
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_Requisition.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_Requisition.setNew(n);
	}

	/**
	* Sets the nextapprove of this WFMS_Requisition.
	*
	* @param nextapprove the nextapprove of this WFMS_Requisition
	*/
	@Override
	public void setNextapprove(java.lang.String nextapprove) {
		_wfms_Requisition.setNextapprove(nextapprove);
	}

	/**
	* Sets the number of this WFMS_Requisition.
	*
	* @param Number the number of this WFMS_Requisition
	*/
	@Override
	public void setNumber(java.lang.String Number) {
		_wfms_Requisition.setNumber(Number);
	}

	/**
	* Sets the other of this WFMS_Requisition.
	*
	* @param other the other of this WFMS_Requisition
	*/
	@Override
	public void setOther(java.lang.String other) {
		_wfms_Requisition.setOther(other);
	}

	/**
	* Sets the posting type of this WFMS_Requisition.
	*
	* @param postingType the posting type of this WFMS_Requisition
	*/
	@Override
	public void setPostingType(java.lang.String postingType) {
		_wfms_Requisition.setPostingType(postingType);
	}

	/**
	* Sets the primary key of this WFMS_Requisition.
	*
	* @param primaryKey the primary key of this WFMS_Requisition
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_Requisition.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_Requisition.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the r ID of this WFMS_Requisition.
	*
	* @param rId the r ID of this WFMS_Requisition
	*/
	@Override
	public void setRId(java.lang.String rId) {
		_wfms_Requisition.setRId(rId);
	}

	/**
	* Sets the ref req ID of this WFMS_Requisition.
	*
	* @param refReqId the ref req ID of this WFMS_Requisition
	*/
	@Override
	public void setRefReqId(java.lang.String refReqId) {
		_wfms_Requisition.setRefReqId(refReqId);
	}

	/**
	* Sets the relates to of this WFMS_Requisition.
	*
	* @param relatesTo the relates to of this WFMS_Requisition
	*/
	@Override
	public void setRelatesTo(java.lang.String relatesTo) {
		_wfms_Requisition.setRelatesTo(relatesTo);
	}

	/**
	* Sets the role of approver of this WFMS_Requisition.
	*
	* @param roleOfApprover the role of approver of this WFMS_Requisition
	*/
	@Override
	public void setRoleOfApprover(java.lang.String roleOfApprover) {
		_wfms_Requisition.setRoleOfApprover(roleOfApprover);
	}

	/**
	* Sets the rwf ID of this WFMS_Requisition.
	*
	* @param rwfId the rwf ID of this WFMS_Requisition
	*/
	@Override
	public void setRwfId(java.lang.String rwfId) {
		_wfms_Requisition.setRwfId(rwfId);
	}

	/**
	* Sets the scope group ID of this WFMS_Requisition.
	*
	* @param scopeGroupId the scope group ID of this WFMS_Requisition
	*/
	@Override
	public void setScopeGroupId(long scopeGroupId) {
		_wfms_Requisition.setScopeGroupId(scopeGroupId);
	}

	/**
	* Sets the shift assign of this WFMS_Requisition.
	*
	* @param shiftAssign the shift assign of this WFMS_Requisition
	*/
	@Override
	public void setShiftAssign(java.lang.String shiftAssign) {
		_wfms_Requisition.setShiftAssign(shiftAssign);
	}

	/**
	* Sets the status of this WFMS_Requisition.
	*
	* @param status the status of this WFMS_Requisition
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_wfms_Requisition.setStatus(status);
	}

	/**
	* Sets the taleonumber of this WFMS_Requisition.
	*
	* @param taleonumber the taleonumber of this WFMS_Requisition
	*/
	@Override
	public void setTaleonumber(java.lang.String taleonumber) {
		_wfms_Requisition.setTaleonumber(taleonumber);
	}

	/**
	* Sets the team number of this WFMS_Requisition.
	*
	* @param teamNumber the team number of this WFMS_Requisition
	*/
	@Override
	public void setTeamNumber(java.lang.String teamNumber) {
		_wfms_Requisition.setTeamNumber(teamNumber);
	}

	/**
	* Sets the who replaced of this WFMS_Requisition.
	*
	* @param whoReplaced the who replaced of this WFMS_Requisition
	*/
	@Override
	public void setWhoReplaced(java.lang.String whoReplaced) {
		_wfms_Requisition.setWhoReplaced(whoReplaced);
	}

	/**
	* Sets the workflow of this WFMS_Requisition.
	*
	* @param workflow the workflow of this WFMS_Requisition
	*/
	@Override
	public void setWorkflow(java.lang.String workflow) {
		_wfms_Requisition.setWorkflow(workflow);
	}

	/**
	* Sets the workflow ID of this WFMS_Requisition.
	*
	* @param workflowId the workflow ID of this WFMS_Requisition
	*/
	@Override
	public void setWorkflowId(java.lang.String workflowId) {
		_wfms_Requisition.setWorkflowId(workflowId);
	}

	/**
	* Sets the workflow step of this WFMS_Requisition.
	*
	* @param workflowStep the workflow step of this WFMS_Requisition
	*/
	@Override
	public void setWorkflowStep(int workflowStep) {
		_wfms_Requisition.setWorkflowStep(workflowStep);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_RequisitionWrapper)) {
			return false;
		}

		WFMS_RequisitionWrapper wfms_RequisitionWrapper = (WFMS_RequisitionWrapper)obj;

		if (Objects.equals(_wfms_Requisition,
					wfms_RequisitionWrapper._wfms_Requisition)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_Requisition getWrappedModel() {
		return _wfms_Requisition;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_Requisition.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_Requisition.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_Requisition.resetOriginalValues();
	}

	private final WFMS_Requisition _wfms_Requisition;
}