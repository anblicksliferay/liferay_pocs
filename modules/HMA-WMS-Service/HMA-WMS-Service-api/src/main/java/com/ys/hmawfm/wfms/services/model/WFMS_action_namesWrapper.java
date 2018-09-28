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
 * This class is a wrapper for {@link WFMS_action_names}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_names
 * @generated
 */
@ProviderType
public class WFMS_action_namesWrapper implements WFMS_action_names,
	ModelWrapper<WFMS_action_names> {
	public WFMS_action_namesWrapper(WFMS_action_names wfms_action_names) {
		_wfms_action_names = wfms_action_names;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_action_names.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_action_names.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionId", getActionId());
		attributes.put("actionName", getActionName());
		attributes.put("deleteflag", getDeleteflag());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String actionId = (String)attributes.get("actionId");

		if (actionId != null) {
			setActionId(actionId);
		}

		String actionName = (String)attributes.get("actionName");

		if (actionName != null) {
			setActionName(actionName);
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
	public WFMS_action_names toEscapedModel() {
		return new WFMS_action_namesWrapper(_wfms_action_names.toEscapedModel());
	}

	@Override
	public WFMS_action_names toUnescapedModel() {
		return new WFMS_action_namesWrapper(_wfms_action_names.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_action_names.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_action_names.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_action_names.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_action_names.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_action_names> toCacheModel() {
		return _wfms_action_names.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_action_names wfms_action_names) {
		return _wfms_action_names.compareTo(wfms_action_names);
	}

	/**
	* Returns the deleteflag of this WFMS_action_names.
	*
	* @return the deleteflag of this WFMS_action_names
	*/
	@Override
	public int getDeleteflag() {
		return _wfms_action_names.getDeleteflag();
	}

	@Override
	public int hashCode() {
		return _wfms_action_names.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_action_names.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_action_namesWrapper((WFMS_action_names)_wfms_action_names.clone());
	}

	/**
	* Returns the action ID of this WFMS_action_names.
	*
	* @return the action ID of this WFMS_action_names
	*/
	@Override
	public java.lang.String getActionId() {
		return _wfms_action_names.getActionId();
	}

	/**
	* Returns the action name of this WFMS_action_names.
	*
	* @return the action name of this WFMS_action_names
	*/
	@Override
	public java.lang.String getActionName() {
		return _wfms_action_names.getActionName();
	}

	/**
	* Returns the created by of this WFMS_action_names.
	*
	* @return the created by of this WFMS_action_names
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_action_names.getCreatedBy();
	}

	/**
	* Returns the modified by of this WFMS_action_names.
	*
	* @return the modified by of this WFMS_action_names
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_action_names.getModifiedBy();
	}

	/**
	* Returns the primary key of this WFMS_action_names.
	*
	* @return the primary key of this WFMS_action_names
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_action_names.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_action_names.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_action_names.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_action_names.
	*
	* @return the create date of this WFMS_action_names
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_action_names.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_action_names.
	*
	* @return the modified date of this WFMS_action_names
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_action_names.getModifiedDate();
	}

	@Override
	public void persist() {
		_wfms_action_names.persist();
	}

	/**
	* Sets the action ID of this WFMS_action_names.
	*
	* @param actionId the action ID of this WFMS_action_names
	*/
	@Override
	public void setActionId(java.lang.String actionId) {
		_wfms_action_names.setActionId(actionId);
	}

	/**
	* Sets the action name of this WFMS_action_names.
	*
	* @param actionName the action name of this WFMS_action_names
	*/
	@Override
	public void setActionName(java.lang.String actionName) {
		_wfms_action_names.setActionName(actionName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_action_names.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this WFMS_action_names.
	*
	* @param createDate the create date of this WFMS_action_names
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_action_names.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_action_names.
	*
	* @param createdBy the created by of this WFMS_action_names
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_action_names.setCreatedBy(createdBy);
	}

	/**
	* Sets the deleteflag of this WFMS_action_names.
	*
	* @param deleteflag the deleteflag of this WFMS_action_names
	*/
	@Override
	public void setDeleteflag(int deleteflag) {
		_wfms_action_names.setDeleteflag(deleteflag);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_action_names.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_action_names.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_action_names.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this WFMS_action_names.
	*
	* @param modifiedBy the modified by of this WFMS_action_names
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_action_names.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_action_names.
	*
	* @param modifiedDate the modified date of this WFMS_action_names
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_action_names.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_action_names.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_action_names.
	*
	* @param primaryKey the primary key of this WFMS_action_names
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_action_names.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_action_names.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_action_namesWrapper)) {
			return false;
		}

		WFMS_action_namesWrapper wfms_action_namesWrapper = (WFMS_action_namesWrapper)obj;

		if (Objects.equals(_wfms_action_names,
					wfms_action_namesWrapper._wfms_action_names)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_action_names getWrappedModel() {
		return _wfms_action_names;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_action_names.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_action_names.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_action_names.resetOriginalValues();
	}

	private final WFMS_action_names _wfms_action_names;
}