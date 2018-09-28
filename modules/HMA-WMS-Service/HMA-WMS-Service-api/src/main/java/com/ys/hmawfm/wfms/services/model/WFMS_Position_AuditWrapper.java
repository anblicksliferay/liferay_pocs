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
 * This class is a wrapper for {@link WFMS_Position_Audit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position_Audit
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditWrapper implements WFMS_Position_Audit,
	ModelWrapper<WFMS_Position_Audit> {
	public WFMS_Position_AuditWrapper(WFMS_Position_Audit wfms_Position_Audit) {
		_wfms_Position_Audit = wfms_Position_Audit;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_Position_Audit.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_Position_Audit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paId", getPaId());
		attributes.put("pId", getPId());
		attributes.put("userId", getUserId());
		attributes.put("associateId", getAssociateId());
		attributes.put("change", getChange());
		attributes.put("fromPId", getFromPId());
		attributes.put("comments", getComments());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String paId = (String)attributes.get("paId");

		if (paId != null) {
			setPaId(paId);
		}

		String pId = (String)attributes.get("pId");

		if (pId != null) {
			setPId(pId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String associateId = (String)attributes.get("associateId");

		if (associateId != null) {
			setAssociateId(associateId);
		}

		String change = (String)attributes.get("change");

		if (change != null) {
			setChange(change);
		}

		String fromPId = (String)attributes.get("fromPId");

		if (fromPId != null) {
			setFromPId(fromPId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public WFMS_Position_Audit toEscapedModel() {
		return new WFMS_Position_AuditWrapper(_wfms_Position_Audit.toEscapedModel());
	}

	@Override
	public WFMS_Position_Audit toUnescapedModel() {
		return new WFMS_Position_AuditWrapper(_wfms_Position_Audit.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_Position_Audit.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_Position_Audit.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_Position_Audit.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_Position_Audit.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_Position_Audit> toCacheModel() {
		return _wfms_Position_Audit.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_Position_Audit wfms_Position_Audit) {
		return _wfms_Position_Audit.compareTo(wfms_Position_Audit);
	}

	@Override
	public int hashCode() {
		return _wfms_Position_Audit.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_Position_Audit.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_Position_AuditWrapper((WFMS_Position_Audit)_wfms_Position_Audit.clone());
	}

	/**
	* Returns the associate ID of this WFMS_Position_Audit.
	*
	* @return the associate ID of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getAssociateId() {
		return _wfms_Position_Audit.getAssociateId();
	}

	/**
	* Returns the change of this WFMS_Position_Audit.
	*
	* @return the change of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getChange() {
		return _wfms_Position_Audit.getChange();
	}

	/**
	* Returns the comments of this WFMS_Position_Audit.
	*
	* @return the comments of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_Position_Audit.getComments();
	}

	/**
	* Returns the created by of this WFMS_Position_Audit.
	*
	* @return the created by of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_Position_Audit.getCreatedBy();
	}

	/**
	* Returns the from p ID of this WFMS_Position_Audit.
	*
	* @return the from p ID of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getFromPId() {
		return _wfms_Position_Audit.getFromPId();
	}

	/**
	* Returns the p ID of this WFMS_Position_Audit.
	*
	* @return the p ID of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getPId() {
		return _wfms_Position_Audit.getPId();
	}

	/**
	* Returns the pa ID of this WFMS_Position_Audit.
	*
	* @return the pa ID of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getPaId() {
		return _wfms_Position_Audit.getPaId();
	}

	/**
	* Returns the primary key of this WFMS_Position_Audit.
	*
	* @return the primary key of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_Position_Audit.getPrimaryKey();
	}

	/**
	* Returns the user uuid of this WFMS_Position_Audit.
	*
	* @return the user uuid of this WFMS_Position_Audit
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _wfms_Position_Audit.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_Position_Audit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_Position_Audit.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_Position_Audit.
	*
	* @return the create date of this WFMS_Position_Audit
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_Position_Audit.getCreateDate();
	}

	/**
	* Returns the user ID of this WFMS_Position_Audit.
	*
	* @return the user ID of this WFMS_Position_Audit
	*/
	@Override
	public long getUserId() {
		return _wfms_Position_Audit.getUserId();
	}

	@Override
	public void persist() {
		_wfms_Position_Audit.persist();
	}

	/**
	* Sets the associate ID of this WFMS_Position_Audit.
	*
	* @param associateId the associate ID of this WFMS_Position_Audit
	*/
	@Override
	public void setAssociateId(java.lang.String associateId) {
		_wfms_Position_Audit.setAssociateId(associateId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_Position_Audit.setCachedModel(cachedModel);
	}

	/**
	* Sets the change of this WFMS_Position_Audit.
	*
	* @param change the change of this WFMS_Position_Audit
	*/
	@Override
	public void setChange(java.lang.String change) {
		_wfms_Position_Audit.setChange(change);
	}

	/**
	* Sets the comments of this WFMS_Position_Audit.
	*
	* @param comments the comments of this WFMS_Position_Audit
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_Position_Audit.setComments(comments);
	}

	/**
	* Sets the create date of this WFMS_Position_Audit.
	*
	* @param createDate the create date of this WFMS_Position_Audit
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_Position_Audit.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_Position_Audit.
	*
	* @param createdBy the created by of this WFMS_Position_Audit
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_Position_Audit.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_Position_Audit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_Position_Audit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_Position_Audit.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from p ID of this WFMS_Position_Audit.
	*
	* @param fromPId the from p ID of this WFMS_Position_Audit
	*/
	@Override
	public void setFromPId(java.lang.String fromPId) {
		_wfms_Position_Audit.setFromPId(fromPId);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_Position_Audit.setNew(n);
	}

	/**
	* Sets the p ID of this WFMS_Position_Audit.
	*
	* @param pId the p ID of this WFMS_Position_Audit
	*/
	@Override
	public void setPId(java.lang.String pId) {
		_wfms_Position_Audit.setPId(pId);
	}

	/**
	* Sets the pa ID of this WFMS_Position_Audit.
	*
	* @param paId the pa ID of this WFMS_Position_Audit
	*/
	@Override
	public void setPaId(java.lang.String paId) {
		_wfms_Position_Audit.setPaId(paId);
	}

	/**
	* Sets the primary key of this WFMS_Position_Audit.
	*
	* @param primaryKey the primary key of this WFMS_Position_Audit
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_Position_Audit.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_Position_Audit.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this WFMS_Position_Audit.
	*
	* @param userId the user ID of this WFMS_Position_Audit
	*/
	@Override
	public void setUserId(long userId) {
		_wfms_Position_Audit.setUserId(userId);
	}

	/**
	* Sets the user uuid of this WFMS_Position_Audit.
	*
	* @param userUuid the user uuid of this WFMS_Position_Audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wfms_Position_Audit.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_Position_AuditWrapper)) {
			return false;
		}

		WFMS_Position_AuditWrapper wfms_Position_AuditWrapper = (WFMS_Position_AuditWrapper)obj;

		if (Objects.equals(_wfms_Position_Audit,
					wfms_Position_AuditWrapper._wfms_Position_Audit)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_Position_Audit getWrappedModel() {
		return _wfms_Position_Audit;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_Position_Audit.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_Position_Audit.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_Position_Audit.resetOriginalValues();
	}

	private final WFMS_Position_Audit _wfms_Position_Audit;
}