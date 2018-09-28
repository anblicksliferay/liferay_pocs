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
 * This class is a wrapper for {@link WFMS_action_and_reasoncode}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_and_reasoncode
 * @generated
 */
@ProviderType
public class WFMS_action_and_reasoncodeWrapper
	implements WFMS_action_and_reasoncode,
		ModelWrapper<WFMS_action_and_reasoncode> {
	public WFMS_action_and_reasoncodeWrapper(
		WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		_wfms_action_and_reasoncode = wfms_action_and_reasoncode;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_action_and_reasoncode.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_action_and_reasoncode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("aarId", getAarId());
		attributes.put("action", getAction());
		attributes.put("reasonCode", getReasonCode());
		attributes.put("description", getDescription());
		attributes.put("deleteflag", getDeleteflag());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String aarId = (String)attributes.get("aarId");

		if (aarId != null) {
			setAarId(aarId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String reasonCode = (String)attributes.get("reasonCode");

		if (reasonCode != null) {
			setReasonCode(reasonCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	public WFMS_action_and_reasoncode toEscapedModel() {
		return new WFMS_action_and_reasoncodeWrapper(_wfms_action_and_reasoncode.toEscapedModel());
	}

	@Override
	public WFMS_action_and_reasoncode toUnescapedModel() {
		return new WFMS_action_and_reasoncodeWrapper(_wfms_action_and_reasoncode.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_action_and_reasoncode.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_action_and_reasoncode.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_action_and_reasoncode.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_action_and_reasoncode.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_action_and_reasoncode> toCacheModel() {
		return _wfms_action_and_reasoncode.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
		return _wfms_action_and_reasoncode.compareTo(wfms_action_and_reasoncode);
	}

	/**
	* Returns the deleteflag of this WFMS_action_and_reasoncode.
	*
	* @return the deleteflag of this WFMS_action_and_reasoncode
	*/
	@Override
	public int getDeleteflag() {
		return _wfms_action_and_reasoncode.getDeleteflag();
	}

	@Override
	public int hashCode() {
		return _wfms_action_and_reasoncode.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_action_and_reasoncode.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_action_and_reasoncodeWrapper((WFMS_action_and_reasoncode)_wfms_action_and_reasoncode.clone());
	}

	/**
	* Returns the aar ID of this WFMS_action_and_reasoncode.
	*
	* @return the aar ID of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getAarId() {
		return _wfms_action_and_reasoncode.getAarId();
	}

	/**
	* Returns the action of this WFMS_action_and_reasoncode.
	*
	* @return the action of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getAction() {
		return _wfms_action_and_reasoncode.getAction();
	}

	/**
	* Returns the created by of this WFMS_action_and_reasoncode.
	*
	* @return the created by of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_action_and_reasoncode.getCreatedBy();
	}

	/**
	* Returns the description of this WFMS_action_and_reasoncode.
	*
	* @return the description of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getDescription() {
		return _wfms_action_and_reasoncode.getDescription();
	}

	/**
	* Returns the modified by of this WFMS_action_and_reasoncode.
	*
	* @return the modified by of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_action_and_reasoncode.getModifiedBy();
	}

	/**
	* Returns the primary key of this WFMS_action_and_reasoncode.
	*
	* @return the primary key of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_action_and_reasoncode.getPrimaryKey();
	}

	/**
	* Returns the reason code of this WFMS_action_and_reasoncode.
	*
	* @return the reason code of this WFMS_action_and_reasoncode
	*/
	@Override
	public java.lang.String getReasonCode() {
		return _wfms_action_and_reasoncode.getReasonCode();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_action_and_reasoncode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_action_and_reasoncode.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_action_and_reasoncode.
	*
	* @return the create date of this WFMS_action_and_reasoncode
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_action_and_reasoncode.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_action_and_reasoncode.
	*
	* @return the modified date of this WFMS_action_and_reasoncode
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_action_and_reasoncode.getModifiedDate();
	}

	@Override
	public void persist() {
		_wfms_action_and_reasoncode.persist();
	}

	/**
	* Sets the aar ID of this WFMS_action_and_reasoncode.
	*
	* @param aarId the aar ID of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setAarId(java.lang.String aarId) {
		_wfms_action_and_reasoncode.setAarId(aarId);
	}

	/**
	* Sets the action of this WFMS_action_and_reasoncode.
	*
	* @param action the action of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setAction(java.lang.String action) {
		_wfms_action_and_reasoncode.setAction(action);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_action_and_reasoncode.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this WFMS_action_and_reasoncode.
	*
	* @param createDate the create date of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_action_and_reasoncode.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_action_and_reasoncode.
	*
	* @param createdBy the created by of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_action_and_reasoncode.setCreatedBy(createdBy);
	}

	/**
	* Sets the deleteflag of this WFMS_action_and_reasoncode.
	*
	* @param deleteflag the deleteflag of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setDeleteflag(int deleteflag) {
		_wfms_action_and_reasoncode.setDeleteflag(deleteflag);
	}

	/**
	* Sets the description of this WFMS_action_and_reasoncode.
	*
	* @param description the description of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_wfms_action_and_reasoncode.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_action_and_reasoncode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_action_and_reasoncode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_action_and_reasoncode.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this WFMS_action_and_reasoncode.
	*
	* @param modifiedBy the modified by of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_action_and_reasoncode.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_action_and_reasoncode.
	*
	* @param modifiedDate the modified date of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_action_and_reasoncode.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_action_and_reasoncode.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_action_and_reasoncode.
	*
	* @param primaryKey the primary key of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_action_and_reasoncode.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_action_and_reasoncode.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reason code of this WFMS_action_and_reasoncode.
	*
	* @param reasonCode the reason code of this WFMS_action_and_reasoncode
	*/
	@Override
	public void setReasonCode(java.lang.String reasonCode) {
		_wfms_action_and_reasoncode.setReasonCode(reasonCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_action_and_reasoncodeWrapper)) {
			return false;
		}

		WFMS_action_and_reasoncodeWrapper wfms_action_and_reasoncodeWrapper = (WFMS_action_and_reasoncodeWrapper)obj;

		if (Objects.equals(_wfms_action_and_reasoncode,
					wfms_action_and_reasoncodeWrapper._wfms_action_and_reasoncode)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_action_and_reasoncode getWrappedModel() {
		return _wfms_action_and_reasoncode;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_action_and_reasoncode.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_action_and_reasoncode.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_action_and_reasoncode.resetOriginalValues();
	}

	private final WFMS_action_and_reasoncode _wfms_action_and_reasoncode;
}