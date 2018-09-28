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
 * This class is a wrapper for {@link WFMS_routing_and_approvers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_routing_and_approvers
 * @generated
 */
@ProviderType
public class WFMS_routing_and_approversWrapper
	implements WFMS_routing_and_approvers,
		ModelWrapper<WFMS_routing_and_approvers> {
	public WFMS_routing_and_approversWrapper(
		WFMS_routing_and_approvers wfms_routing_and_approvers) {
		_wfms_routing_and_approvers = wfms_routing_and_approvers;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_routing_and_approvers.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_routing_and_approvers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rapId", getRapId());
		attributes.put("action", getAction());
		attributes.put("changeDescription", getChangeDescription());
		attributes.put("currentJobCodeORLeadership",
			getCurrentJobCodeORLeadership());
		attributes.put("newJobCodeORLeadership", getNewJobCodeORLeadership());
		attributes.put("SameJobCode", getSameJobCode());
		attributes.put("SameLeadership", getSameLeadership());
		attributes.put("isSameDept", getIsSameDept());
		attributes.put("isSameMgr", getIsSameMgr());
		attributes.put("routingProcess", getRoutingProcess());
		attributes.put("notificationTo", getNotificationTo());
		attributes.put("deleteflag", getDeleteflag());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String rapId = (String)attributes.get("rapId");

		if (rapId != null) {
			setRapId(rapId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String changeDescription = (String)attributes.get("changeDescription");

		if (changeDescription != null) {
			setChangeDescription(changeDescription);
		}

		String currentJobCodeORLeadership = (String)attributes.get(
				"currentJobCodeORLeadership");

		if (currentJobCodeORLeadership != null) {
			setCurrentJobCodeORLeadership(currentJobCodeORLeadership);
		}

		String newJobCodeORLeadership = (String)attributes.get(
				"newJobCodeORLeadership");

		if (newJobCodeORLeadership != null) {
			setNewJobCodeORLeadership(newJobCodeORLeadership);
		}

		String SameJobCode = (String)attributes.get("SameJobCode");

		if (SameJobCode != null) {
			setSameJobCode(SameJobCode);
		}

		String SameLeadership = (String)attributes.get("SameLeadership");

		if (SameLeadership != null) {
			setSameLeadership(SameLeadership);
		}

		String isSameDept = (String)attributes.get("isSameDept");

		if (isSameDept != null) {
			setIsSameDept(isSameDept);
		}

		String isSameMgr = (String)attributes.get("isSameMgr");

		if (isSameMgr != null) {
			setIsSameMgr(isSameMgr);
		}

		String routingProcess = (String)attributes.get("routingProcess");

		if (routingProcess != null) {
			setRoutingProcess(routingProcess);
		}

		String notificationTo = (String)attributes.get("notificationTo");

		if (notificationTo != null) {
			setNotificationTo(notificationTo);
		}

		Integer deleteflag = (Integer)attributes.get("deleteflag");

		if (deleteflag != null) {
			setDeleteflag(deleteflag);
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
	}

	@Override
	public WFMS_routing_and_approvers toEscapedModel() {
		return new WFMS_routing_and_approversWrapper(_wfms_routing_and_approvers.toEscapedModel());
	}

	@Override
	public WFMS_routing_and_approvers toUnescapedModel() {
		return new WFMS_routing_and_approversWrapper(_wfms_routing_and_approvers.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_routing_and_approvers.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_routing_and_approvers.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_routing_and_approvers.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_routing_and_approvers.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_routing_and_approvers> toCacheModel() {
		return _wfms_routing_and_approvers.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_routing_and_approvers wfms_routing_and_approvers) {
		return _wfms_routing_and_approvers.compareTo(wfms_routing_and_approvers);
	}

	/**
	* Returns the deleteflag of this WFMS_routing_and_approvers.
	*
	* @return the deleteflag of this WFMS_routing_and_approvers
	*/
	@Override
	public int getDeleteflag() {
		return _wfms_routing_and_approvers.getDeleteflag();
	}

	@Override
	public int hashCode() {
		return _wfms_routing_and_approvers.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_routing_and_approvers.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_routing_and_approversWrapper((WFMS_routing_and_approvers)_wfms_routing_and_approvers.clone());
	}

	/**
	* Returns the action of this WFMS_routing_and_approvers.
	*
	* @return the action of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getAction() {
		return _wfms_routing_and_approvers.getAction();
	}

	/**
	* Returns the change description of this WFMS_routing_and_approvers.
	*
	* @return the change description of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getChangeDescription() {
		return _wfms_routing_and_approvers.getChangeDescription();
	}

	/**
	* Returns the created by of this WFMS_routing_and_approvers.
	*
	* @return the created by of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_routing_and_approvers.getCreatedBy();
	}

	/**
	* Returns the current job code or leadership of this WFMS_routing_and_approvers.
	*
	* @return the current job code or leadership of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getCurrentJobCodeORLeadership() {
		return _wfms_routing_and_approvers.getCurrentJobCodeORLeadership();
	}

	/**
	* Returns the is same dept of this WFMS_routing_and_approvers.
	*
	* @return the is same dept of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getIsSameDept() {
		return _wfms_routing_and_approvers.getIsSameDept();
	}

	/**
	* Returns the is same mgr of this WFMS_routing_and_approvers.
	*
	* @return the is same mgr of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getIsSameMgr() {
		return _wfms_routing_and_approvers.getIsSameMgr();
	}

	/**
	* Returns the modified by of this WFMS_routing_and_approvers.
	*
	* @return the modified by of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_routing_and_approvers.getModifiedBy();
	}

	/**
	* Returns the new job code or leadership of this WFMS_routing_and_approvers.
	*
	* @return the new job code or leadership of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getNewJobCodeORLeadership() {
		return _wfms_routing_and_approvers.getNewJobCodeORLeadership();
	}

	/**
	* Returns the notification to of this WFMS_routing_and_approvers.
	*
	* @return the notification to of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getNotificationTo() {
		return _wfms_routing_and_approvers.getNotificationTo();
	}

	/**
	* Returns the primary key of this WFMS_routing_and_approvers.
	*
	* @return the primary key of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_routing_and_approvers.getPrimaryKey();
	}

	/**
	* Returns the rap ID of this WFMS_routing_and_approvers.
	*
	* @return the rap ID of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getRapId() {
		return _wfms_routing_and_approvers.getRapId();
	}

	/**
	* Returns the routing process of this WFMS_routing_and_approvers.
	*
	* @return the routing process of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getRoutingProcess() {
		return _wfms_routing_and_approvers.getRoutingProcess();
	}

	/**
	* Returns the same job code of this WFMS_routing_and_approvers.
	*
	* @return the same job code of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getSameJobCode() {
		return _wfms_routing_and_approvers.getSameJobCode();
	}

	/**
	* Returns the same leadership of this WFMS_routing_and_approvers.
	*
	* @return the same leadership of this WFMS_routing_and_approvers
	*/
	@Override
	public java.lang.String getSameLeadership() {
		return _wfms_routing_and_approvers.getSameLeadership();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_routing_and_approvers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_routing_and_approvers.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_routing_and_approvers.
	*
	* @return the create date of this WFMS_routing_and_approvers
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_routing_and_approvers.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_routing_and_approvers.
	*
	* @return the modified date of this WFMS_routing_and_approvers
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_routing_and_approvers.getModifiedDate();
	}

	@Override
	public void persist() {
		_wfms_routing_and_approvers.persist();
	}

	/**
	* Sets the action of this WFMS_routing_and_approvers.
	*
	* @param action the action of this WFMS_routing_and_approvers
	*/
	@Override
	public void setAction(java.lang.String action) {
		_wfms_routing_and_approvers.setAction(action);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_routing_and_approvers.setCachedModel(cachedModel);
	}

	/**
	* Sets the change description of this WFMS_routing_and_approvers.
	*
	* @param changeDescription the change description of this WFMS_routing_and_approvers
	*/
	@Override
	public void setChangeDescription(java.lang.String changeDescription) {
		_wfms_routing_and_approvers.setChangeDescription(changeDescription);
	}

	/**
	* Sets the create date of this WFMS_routing_and_approvers.
	*
	* @param createDate the create date of this WFMS_routing_and_approvers
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_routing_and_approvers.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_routing_and_approvers.
	*
	* @param createdBy the created by of this WFMS_routing_and_approvers
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_routing_and_approvers.setCreatedBy(createdBy);
	}

	/**
	* Sets the current job code or leadership of this WFMS_routing_and_approvers.
	*
	* @param currentJobCodeORLeadership the current job code or leadership of this WFMS_routing_and_approvers
	*/
	@Override
	public void setCurrentJobCodeORLeadership(
		java.lang.String currentJobCodeORLeadership) {
		_wfms_routing_and_approvers.setCurrentJobCodeORLeadership(currentJobCodeORLeadership);
	}

	/**
	* Sets the deleteflag of this WFMS_routing_and_approvers.
	*
	* @param deleteflag the deleteflag of this WFMS_routing_and_approvers
	*/
	@Override
	public void setDeleteflag(int deleteflag) {
		_wfms_routing_and_approvers.setDeleteflag(deleteflag);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_routing_and_approvers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_routing_and_approvers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_routing_and_approvers.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is same dept of this WFMS_routing_and_approvers.
	*
	* @param isSameDept the is same dept of this WFMS_routing_and_approvers
	*/
	@Override
	public void setIsSameDept(java.lang.String isSameDept) {
		_wfms_routing_and_approvers.setIsSameDept(isSameDept);
	}

	/**
	* Sets the is same mgr of this WFMS_routing_and_approvers.
	*
	* @param isSameMgr the is same mgr of this WFMS_routing_and_approvers
	*/
	@Override
	public void setIsSameMgr(java.lang.String isSameMgr) {
		_wfms_routing_and_approvers.setIsSameMgr(isSameMgr);
	}

	/**
	* Sets the modified by of this WFMS_routing_and_approvers.
	*
	* @param modifiedBy the modified by of this WFMS_routing_and_approvers
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_routing_and_approvers.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_routing_and_approvers.
	*
	* @param modifiedDate the modified date of this WFMS_routing_and_approvers
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_routing_and_approvers.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_routing_and_approvers.setNew(n);
	}

	/**
	* Sets the new job code or leadership of this WFMS_routing_and_approvers.
	*
	* @param newJobCodeORLeadership the new job code or leadership of this WFMS_routing_and_approvers
	*/
	@Override
	public void setNewJobCodeORLeadership(
		java.lang.String newJobCodeORLeadership) {
		_wfms_routing_and_approvers.setNewJobCodeORLeadership(newJobCodeORLeadership);
	}

	/**
	* Sets the notification to of this WFMS_routing_and_approvers.
	*
	* @param notificationTo the notification to of this WFMS_routing_and_approvers
	*/
	@Override
	public void setNotificationTo(java.lang.String notificationTo) {
		_wfms_routing_and_approvers.setNotificationTo(notificationTo);
	}

	/**
	* Sets the primary key of this WFMS_routing_and_approvers.
	*
	* @param primaryKey the primary key of this WFMS_routing_and_approvers
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_routing_and_approvers.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_routing_and_approvers.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rap ID of this WFMS_routing_and_approvers.
	*
	* @param rapId the rap ID of this WFMS_routing_and_approvers
	*/
	@Override
	public void setRapId(java.lang.String rapId) {
		_wfms_routing_and_approvers.setRapId(rapId);
	}

	/**
	* Sets the routing process of this WFMS_routing_and_approvers.
	*
	* @param routingProcess the routing process of this WFMS_routing_and_approvers
	*/
	@Override
	public void setRoutingProcess(java.lang.String routingProcess) {
		_wfms_routing_and_approvers.setRoutingProcess(routingProcess);
	}

	/**
	* Sets the same job code of this WFMS_routing_and_approvers.
	*
	* @param SameJobCode the same job code of this WFMS_routing_and_approvers
	*/
	@Override
	public void setSameJobCode(java.lang.String SameJobCode) {
		_wfms_routing_and_approvers.setSameJobCode(SameJobCode);
	}

	/**
	* Sets the same leadership of this WFMS_routing_and_approvers.
	*
	* @param SameLeadership the same leadership of this WFMS_routing_and_approvers
	*/
	@Override
	public void setSameLeadership(java.lang.String SameLeadership) {
		_wfms_routing_and_approvers.setSameLeadership(SameLeadership);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_routing_and_approversWrapper)) {
			return false;
		}

		WFMS_routing_and_approversWrapper wfms_routing_and_approversWrapper = (WFMS_routing_and_approversWrapper)obj;

		if (Objects.equals(_wfms_routing_and_approvers,
					wfms_routing_and_approversWrapper._wfms_routing_and_approvers)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_routing_and_approvers getWrappedModel() {
		return _wfms_routing_and_approvers;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_routing_and_approvers.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_routing_and_approvers.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_routing_and_approvers.resetOriginalValues();
	}

	private final WFMS_routing_and_approvers _wfms_routing_and_approvers;
}