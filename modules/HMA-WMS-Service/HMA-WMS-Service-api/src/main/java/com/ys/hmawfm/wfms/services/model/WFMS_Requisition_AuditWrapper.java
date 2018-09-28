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
 * This class is a wrapper for {@link WFMS_Requisition_Audit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_Audit
 * @generated
 */
@ProviderType
public class WFMS_Requisition_AuditWrapper implements WFMS_Requisition_Audit,
	ModelWrapper<WFMS_Requisition_Audit> {
	public WFMS_Requisition_AuditWrapper(
		WFMS_Requisition_Audit wfms_Requisition_Audit) {
		_wfms_Requisition_Audit = wfms_Requisition_Audit;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_Requisition_Audit.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_Requisition_Audit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reqaId", getReqaId());
		attributes.put("reqId", getReqId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("change", getChange());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String reqaId = (String)attributes.get("reqaId");

		if (reqaId != null) {
			setReqaId(reqaId);
		}

		String reqId = (String)attributes.get("reqId");

		if (reqId != null) {
			setReqId(reqId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String change = (String)attributes.get("change");

		if (change != null) {
			setChange(change);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public WFMS_Requisition_Audit toEscapedModel() {
		return new WFMS_Requisition_AuditWrapper(_wfms_Requisition_Audit.toEscapedModel());
	}

	@Override
	public WFMS_Requisition_Audit toUnescapedModel() {
		return new WFMS_Requisition_AuditWrapper(_wfms_Requisition_Audit.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_Requisition_Audit.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_Requisition_Audit.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_Requisition_Audit.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_Requisition_Audit.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_Requisition_Audit> toCacheModel() {
		return _wfms_Requisition_Audit.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_Requisition_Audit wfms_Requisition_Audit) {
		return _wfms_Requisition_Audit.compareTo(wfms_Requisition_Audit);
	}

	@Override
	public int hashCode() {
		return _wfms_Requisition_Audit.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_Requisition_Audit.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_Requisition_AuditWrapper((WFMS_Requisition_Audit)_wfms_Requisition_Audit.clone());
	}

	/**
	* Returns the change of this WFMS_Requisition_Audit.
	*
	* @return the change of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getChange() {
		return _wfms_Requisition_Audit.getChange();
	}

	/**
	* Returns the comments of this WFMS_Requisition_Audit.
	*
	* @return the comments of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_Requisition_Audit.getComments();
	}

	/**
	* Returns the created by of this WFMS_Requisition_Audit.
	*
	* @return the created by of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_Requisition_Audit.getCreatedBy();
	}

	/**
	* Returns the primary key of this WFMS_Requisition_Audit.
	*
	* @return the primary key of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_Requisition_Audit.getPrimaryKey();
	}

	/**
	* Returns the req ID of this WFMS_Requisition_Audit.
	*
	* @return the req ID of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getReqId() {
		return _wfms_Requisition_Audit.getReqId();
	}

	/**
	* Returns the reqa ID of this WFMS_Requisition_Audit.
	*
	* @return the reqa ID of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getReqaId() {
		return _wfms_Requisition_Audit.getReqaId();
	}

	/**
	* Returns the user uuid of this WFMS_Requisition_Audit.
	*
	* @return the user uuid of this WFMS_Requisition_Audit
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _wfms_Requisition_Audit.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_Requisition_Audit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_Requisition_Audit.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_Requisition_Audit.
	*
	* @return the create date of this WFMS_Requisition_Audit
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_Requisition_Audit.getCreateDate();
	}

	/**
	* Returns the user ID of this WFMS_Requisition_Audit.
	*
	* @return the user ID of this WFMS_Requisition_Audit
	*/
	@Override
	public long getUserId() {
		return _wfms_Requisition_Audit.getUserId();
	}

	@Override
	public void persist() {
		_wfms_Requisition_Audit.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_Requisition_Audit.setCachedModel(cachedModel);
	}

	/**
	* Sets the change of this WFMS_Requisition_Audit.
	*
	* @param change the change of this WFMS_Requisition_Audit
	*/
	@Override
	public void setChange(java.lang.String change) {
		_wfms_Requisition_Audit.setChange(change);
	}

	/**
	* Sets the comments of this WFMS_Requisition_Audit.
	*
	* @param comments the comments of this WFMS_Requisition_Audit
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_Requisition_Audit.setComments(comments);
	}

	/**
	* Sets the create date of this WFMS_Requisition_Audit.
	*
	* @param createDate the create date of this WFMS_Requisition_Audit
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_Requisition_Audit.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_Requisition_Audit.
	*
	* @param createdBy the created by of this WFMS_Requisition_Audit
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_Requisition_Audit.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_Requisition_Audit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_Requisition_Audit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_Requisition_Audit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_Requisition_Audit.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_Requisition_Audit.
	*
	* @param primaryKey the primary key of this WFMS_Requisition_Audit
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_Requisition_Audit.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_Requisition_Audit.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the req ID of this WFMS_Requisition_Audit.
	*
	* @param reqId the req ID of this WFMS_Requisition_Audit
	*/
	@Override
	public void setReqId(java.lang.String reqId) {
		_wfms_Requisition_Audit.setReqId(reqId);
	}

	/**
	* Sets the reqa ID of this WFMS_Requisition_Audit.
	*
	* @param reqaId the reqa ID of this WFMS_Requisition_Audit
	*/
	@Override
	public void setReqaId(java.lang.String reqaId) {
		_wfms_Requisition_Audit.setReqaId(reqaId);
	}

	/**
	* Sets the user ID of this WFMS_Requisition_Audit.
	*
	* @param userId the user ID of this WFMS_Requisition_Audit
	*/
	@Override
	public void setUserId(long userId) {
		_wfms_Requisition_Audit.setUserId(userId);
	}

	/**
	* Sets the user uuid of this WFMS_Requisition_Audit.
	*
	* @param userUuid the user uuid of this WFMS_Requisition_Audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wfms_Requisition_Audit.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_Requisition_AuditWrapper)) {
			return false;
		}

		WFMS_Requisition_AuditWrapper wfms_Requisition_AuditWrapper = (WFMS_Requisition_AuditWrapper)obj;

		if (Objects.equals(_wfms_Requisition_Audit,
					wfms_Requisition_AuditWrapper._wfms_Requisition_Audit)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_Requisition_Audit getWrappedModel() {
		return _wfms_Requisition_Audit;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_Requisition_Audit.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_Requisition_Audit.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_Requisition_Audit.resetOriginalValues();
	}

	private final WFMS_Requisition_Audit _wfms_Requisition_Audit;
}