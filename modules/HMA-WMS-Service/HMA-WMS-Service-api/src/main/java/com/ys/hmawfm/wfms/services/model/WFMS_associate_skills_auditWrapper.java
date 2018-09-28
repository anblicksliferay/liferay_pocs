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
 * This class is a wrapper for {@link WFMS_associate_skills_audit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_audit
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditWrapper
	implements WFMS_associate_skills_audit,
		ModelWrapper<WFMS_associate_skills_audit> {
	public WFMS_associate_skills_auditWrapper(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		_wfms_associate_skills_audit = wfms_associate_skills_audit;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_associate_skills_audit.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_associate_skills_audit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("associate_log_id", getAssociate_log_id());
		attributes.put("associate_number", getAssociate_number());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("change", getChange());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long associate_log_id = (Long)attributes.get("associate_log_id");

		if (associate_log_id != null) {
			setAssociate_log_id(associate_log_id);
		}

		String associate_number = (String)attributes.get("associate_number");

		if (associate_number != null) {
			setAssociate_number(associate_number);
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
	}

	@Override
	public WFMS_associate_skills_audit toEscapedModel() {
		return new WFMS_associate_skills_auditWrapper(_wfms_associate_skills_audit.toEscapedModel());
	}

	@Override
	public WFMS_associate_skills_audit toUnescapedModel() {
		return new WFMS_associate_skills_auditWrapper(_wfms_associate_skills_audit.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_associate_skills_audit.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_associate_skills_audit.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_associate_skills_audit.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_associate_skills_audit.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_associate_skills_audit> toCacheModel() {
		return _wfms_associate_skills_audit.toCacheModel();
	}

	@Override
	public int compareTo(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		return _wfms_associate_skills_audit.compareTo(wfms_associate_skills_audit);
	}

	@Override
	public int hashCode() {
		return _wfms_associate_skills_audit.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_associate_skills_audit.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_associate_skills_auditWrapper((WFMS_associate_skills_audit)_wfms_associate_skills_audit.clone());
	}

	/**
	* Returns the associate_number of this WFMS_associate_skills_audit.
	*
	* @return the associate_number of this WFMS_associate_skills_audit
	*/
	@Override
	public java.lang.String getAssociate_number() {
		return _wfms_associate_skills_audit.getAssociate_number();
	}

	/**
	* Returns the change of this WFMS_associate_skills_audit.
	*
	* @return the change of this WFMS_associate_skills_audit
	*/
	@Override
	public java.lang.String getChange() {
		return _wfms_associate_skills_audit.getChange();
	}

	/**
	* Returns the created by of this WFMS_associate_skills_audit.
	*
	* @return the created by of this WFMS_associate_skills_audit
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_associate_skills_audit.getCreatedBy();
	}

	/**
	* Returns the user uuid of this WFMS_associate_skills_audit.
	*
	* @return the user uuid of this WFMS_associate_skills_audit
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _wfms_associate_skills_audit.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_associate_skills_audit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_associate_skills_audit.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_associate_skills_audit.
	*
	* @return the create date of this WFMS_associate_skills_audit
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_associate_skills_audit.getCreateDate();
	}

	/**
	* Returns the associate_log_id of this WFMS_associate_skills_audit.
	*
	* @return the associate_log_id of this WFMS_associate_skills_audit
	*/
	@Override
	public long getAssociate_log_id() {
		return _wfms_associate_skills_audit.getAssociate_log_id();
	}

	/**
	* Returns the primary key of this WFMS_associate_skills_audit.
	*
	* @return the primary key of this WFMS_associate_skills_audit
	*/
	@Override
	public long getPrimaryKey() {
		return _wfms_associate_skills_audit.getPrimaryKey();
	}

	/**
	* Returns the user ID of this WFMS_associate_skills_audit.
	*
	* @return the user ID of this WFMS_associate_skills_audit
	*/
	@Override
	public long getUserId() {
		return _wfms_associate_skills_audit.getUserId();
	}

	@Override
	public void persist() {
		_wfms_associate_skills_audit.persist();
	}

	/**
	* Sets the associate_log_id of this WFMS_associate_skills_audit.
	*
	* @param associate_log_id the associate_log_id of this WFMS_associate_skills_audit
	*/
	@Override
	public void setAssociate_log_id(long associate_log_id) {
		_wfms_associate_skills_audit.setAssociate_log_id(associate_log_id);
	}

	/**
	* Sets the associate_number of this WFMS_associate_skills_audit.
	*
	* @param associate_number the associate_number of this WFMS_associate_skills_audit
	*/
	@Override
	public void setAssociate_number(java.lang.String associate_number) {
		_wfms_associate_skills_audit.setAssociate_number(associate_number);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_associate_skills_audit.setCachedModel(cachedModel);
	}

	/**
	* Sets the change of this WFMS_associate_skills_audit.
	*
	* @param change the change of this WFMS_associate_skills_audit
	*/
	@Override
	public void setChange(java.lang.String change) {
		_wfms_associate_skills_audit.setChange(change);
	}

	/**
	* Sets the create date of this WFMS_associate_skills_audit.
	*
	* @param createDate the create date of this WFMS_associate_skills_audit
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_associate_skills_audit.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_associate_skills_audit.
	*
	* @param createdBy the created by of this WFMS_associate_skills_audit
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_associate_skills_audit.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_associate_skills_audit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_associate_skills_audit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_associate_skills_audit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_associate_skills_audit.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_associate_skills_audit.
	*
	* @param primaryKey the primary key of this WFMS_associate_skills_audit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wfms_associate_skills_audit.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_associate_skills_audit.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this WFMS_associate_skills_audit.
	*
	* @param userId the user ID of this WFMS_associate_skills_audit
	*/
	@Override
	public void setUserId(long userId) {
		_wfms_associate_skills_audit.setUserId(userId);
	}

	/**
	* Sets the user uuid of this WFMS_associate_skills_audit.
	*
	* @param userUuid the user uuid of this WFMS_associate_skills_audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wfms_associate_skills_audit.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_associate_skills_auditWrapper)) {
			return false;
		}

		WFMS_associate_skills_auditWrapper wfms_associate_skills_auditWrapper = (WFMS_associate_skills_auditWrapper)obj;

		if (Objects.equals(_wfms_associate_skills_audit,
					wfms_associate_skills_auditWrapper._wfms_associate_skills_audit)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_associate_skills_audit getWrappedModel() {
		return _wfms_associate_skills_audit;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_associate_skills_audit.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_associate_skills_audit.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_associate_skills_audit.resetOriginalValues();
	}

	private final WFMS_associate_skills_audit _wfms_associate_skills_audit;
}