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
 * This class is a wrapper for {@link WFMS_COS_Audit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS_Audit
 * @generated
 */
@ProviderType
public class WFMS_COS_AuditWrapper implements WFMS_COS_Audit,
	ModelWrapper<WFMS_COS_Audit> {
	public WFMS_COS_AuditWrapper(WFMS_COS_Audit wfms_cos_Audit) {
		_wfms_cos_Audit = wfms_cos_Audit;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_COS_Audit.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_COS_Audit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cosaId", getCosaId());
		attributes.put("cosId", getCosId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("change", getChange());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String cosaId = (String)attributes.get("cosaId");

		if (cosaId != null) {
			setCosaId(cosaId);
		}

		String cosId = (String)attributes.get("cosId");

		if (cosId != null) {
			setCosId(cosId);
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
	public WFMS_COS_Audit toEscapedModel() {
		return new WFMS_COS_AuditWrapper(_wfms_cos_Audit.toEscapedModel());
	}

	@Override
	public WFMS_COS_Audit toUnescapedModel() {
		return new WFMS_COS_AuditWrapper(_wfms_cos_Audit.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_cos_Audit.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_cos_Audit.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_cos_Audit.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_cos_Audit.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_COS_Audit> toCacheModel() {
		return _wfms_cos_Audit.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_COS_Audit wfms_cos_Audit) {
		return _wfms_cos_Audit.compareTo(wfms_cos_Audit);
	}

	@Override
	public int hashCode() {
		return _wfms_cos_Audit.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_cos_Audit.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_COS_AuditWrapper((WFMS_COS_Audit)_wfms_cos_Audit.clone());
	}

	/**
	* Returns the change of this WFMS_COS_Audit.
	*
	* @return the change of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getChange() {
		return _wfms_cos_Audit.getChange();
	}

	/**
	* Returns the comments of this WFMS_COS_Audit.
	*
	* @return the comments of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_cos_Audit.getComments();
	}

	/**
	* Returns the cos ID of this WFMS_COS_Audit.
	*
	* @return the cos ID of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getCosId() {
		return _wfms_cos_Audit.getCosId();
	}

	/**
	* Returns the cosa ID of this WFMS_COS_Audit.
	*
	* @return the cosa ID of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getCosaId() {
		return _wfms_cos_Audit.getCosaId();
	}

	/**
	* Returns the created by of this WFMS_COS_Audit.
	*
	* @return the created by of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_cos_Audit.getCreatedBy();
	}

	/**
	* Returns the primary key of this WFMS_COS_Audit.
	*
	* @return the primary key of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_cos_Audit.getPrimaryKey();
	}

	/**
	* Returns the user uuid of this WFMS_COS_Audit.
	*
	* @return the user uuid of this WFMS_COS_Audit
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _wfms_cos_Audit.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_cos_Audit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_cos_Audit.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_COS_Audit.
	*
	* @return the create date of this WFMS_COS_Audit
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_cos_Audit.getCreateDate();
	}

	/**
	* Returns the user ID of this WFMS_COS_Audit.
	*
	* @return the user ID of this WFMS_COS_Audit
	*/
	@Override
	public long getUserId() {
		return _wfms_cos_Audit.getUserId();
	}

	@Override
	public void persist() {
		_wfms_cos_Audit.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_cos_Audit.setCachedModel(cachedModel);
	}

	/**
	* Sets the change of this WFMS_COS_Audit.
	*
	* @param change the change of this WFMS_COS_Audit
	*/
	@Override
	public void setChange(java.lang.String change) {
		_wfms_cos_Audit.setChange(change);
	}

	/**
	* Sets the comments of this WFMS_COS_Audit.
	*
	* @param comments the comments of this WFMS_COS_Audit
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_cos_Audit.setComments(comments);
	}

	/**
	* Sets the cos ID of this WFMS_COS_Audit.
	*
	* @param cosId the cos ID of this WFMS_COS_Audit
	*/
	@Override
	public void setCosId(java.lang.String cosId) {
		_wfms_cos_Audit.setCosId(cosId);
	}

	/**
	* Sets the cosa ID of this WFMS_COS_Audit.
	*
	* @param cosaId the cosa ID of this WFMS_COS_Audit
	*/
	@Override
	public void setCosaId(java.lang.String cosaId) {
		_wfms_cos_Audit.setCosaId(cosaId);
	}

	/**
	* Sets the create date of this WFMS_COS_Audit.
	*
	* @param createDate the create date of this WFMS_COS_Audit
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_cos_Audit.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_COS_Audit.
	*
	* @param createdBy the created by of this WFMS_COS_Audit
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_cos_Audit.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_cos_Audit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_cos_Audit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_cos_Audit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_cos_Audit.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_COS_Audit.
	*
	* @param primaryKey the primary key of this WFMS_COS_Audit
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_cos_Audit.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_cos_Audit.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this WFMS_COS_Audit.
	*
	* @param userId the user ID of this WFMS_COS_Audit
	*/
	@Override
	public void setUserId(long userId) {
		_wfms_cos_Audit.setUserId(userId);
	}

	/**
	* Sets the user uuid of this WFMS_COS_Audit.
	*
	* @param userUuid the user uuid of this WFMS_COS_Audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wfms_cos_Audit.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_COS_AuditWrapper)) {
			return false;
		}

		WFMS_COS_AuditWrapper wfms_cos_AuditWrapper = (WFMS_COS_AuditWrapper)obj;

		if (Objects.equals(_wfms_cos_Audit,
					wfms_cos_AuditWrapper._wfms_cos_Audit)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_COS_Audit getWrappedModel() {
		return _wfms_cos_Audit;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_cos_Audit.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_cos_Audit.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_cos_Audit.resetOriginalValues();
	}

	private final WFMS_COS_Audit _wfms_cos_Audit;
}