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
 * This class is a wrapper for {@link WFMS_WorkflowConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfig
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigWrapper implements WFMS_WorkflowConfig,
	ModelWrapper<WFMS_WorkflowConfig> {
	public WFMS_WorkflowConfigWrapper(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		_wfms_WorkflowConfig = wfms_WorkflowConfig;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_WorkflowConfig.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_WorkflowConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wfcId", getWfcId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("configKey", getConfigKey());
		attributes.put("configLabel", getConfigLabel());
		attributes.put("contentType", getContentType());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wfcId = (Long)attributes.get("wfcId");

		if (wfcId != null) {
			setWfcId(wfcId);
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

		String configKey = (String)attributes.get("configKey");

		if (configKey != null) {
			setConfigKey(configKey);
		}

		String configLabel = (String)attributes.get("configLabel");

		if (configLabel != null) {
			setConfigLabel(configLabel);
		}

		String contentType = (String)attributes.get("contentType");

		if (contentType != null) {
			setContentType(contentType);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public WFMS_WorkflowConfig toEscapedModel() {
		return new WFMS_WorkflowConfigWrapper(_wfms_WorkflowConfig.toEscapedModel());
	}

	@Override
	public WFMS_WorkflowConfig toUnescapedModel() {
		return new WFMS_WorkflowConfigWrapper(_wfms_WorkflowConfig.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_WorkflowConfig.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_WorkflowConfig.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_WorkflowConfig.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_WorkflowConfig.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_WorkflowConfig> toCacheModel() {
		return _wfms_WorkflowConfig.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		return _wfms_WorkflowConfig.compareTo(wfms_WorkflowConfig);
	}

	@Override
	public int hashCode() {
		return _wfms_WorkflowConfig.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_WorkflowConfig.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_WorkflowConfigWrapper((WFMS_WorkflowConfig)_wfms_WorkflowConfig.clone());
	}

	/**
	* Returns the config key of this WFMS_WorkflowConfig.
	*
	* @return the config key of this WFMS_WorkflowConfig
	*/
	@Override
	public java.lang.String getConfigKey() {
		return _wfms_WorkflowConfig.getConfigKey();
	}

	/**
	* Returns the config label of this WFMS_WorkflowConfig.
	*
	* @return the config label of this WFMS_WorkflowConfig
	*/
	@Override
	public java.lang.String getConfigLabel() {
		return _wfms_WorkflowConfig.getConfigLabel();
	}

	/**
	* Returns the content of this WFMS_WorkflowConfig.
	*
	* @return the content of this WFMS_WorkflowConfig
	*/
	@Override
	public java.lang.String getContent() {
		return _wfms_WorkflowConfig.getContent();
	}

	/**
	* Returns the content type of this WFMS_WorkflowConfig.
	*
	* @return the content type of this WFMS_WorkflowConfig
	*/
	@Override
	public java.lang.String getContentType() {
		return _wfms_WorkflowConfig.getContentType();
	}

	/**
	* Returns the created by of this WFMS_WorkflowConfig.
	*
	* @return the created by of this WFMS_WorkflowConfig
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_WorkflowConfig.getCreatedBy();
	}

	/**
	* Returns the modified by of this WFMS_WorkflowConfig.
	*
	* @return the modified by of this WFMS_WorkflowConfig
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_WorkflowConfig.getModifiedBy();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_WorkflowConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_WorkflowConfig.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_WorkflowConfig.
	*
	* @return the create date of this WFMS_WorkflowConfig
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_WorkflowConfig.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_WorkflowConfig.
	*
	* @return the modified date of this WFMS_WorkflowConfig
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_WorkflowConfig.getModifiedDate();
	}

	/**
	* Returns the primary key of this WFMS_WorkflowConfig.
	*
	* @return the primary key of this WFMS_WorkflowConfig
	*/
	@Override
	public long getPrimaryKey() {
		return _wfms_WorkflowConfig.getPrimaryKey();
	}

	/**
	* Returns the wfc ID of this WFMS_WorkflowConfig.
	*
	* @return the wfc ID of this WFMS_WorkflowConfig
	*/
	@Override
	public long getWfcId() {
		return _wfms_WorkflowConfig.getWfcId();
	}

	@Override
	public void persist() {
		_wfms_WorkflowConfig.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_WorkflowConfig.setCachedModel(cachedModel);
	}

	/**
	* Sets the config key of this WFMS_WorkflowConfig.
	*
	* @param configKey the config key of this WFMS_WorkflowConfig
	*/
	@Override
	public void setConfigKey(java.lang.String configKey) {
		_wfms_WorkflowConfig.setConfigKey(configKey);
	}

	/**
	* Sets the config label of this WFMS_WorkflowConfig.
	*
	* @param configLabel the config label of this WFMS_WorkflowConfig
	*/
	@Override
	public void setConfigLabel(java.lang.String configLabel) {
		_wfms_WorkflowConfig.setConfigLabel(configLabel);
	}

	/**
	* Sets the content of this WFMS_WorkflowConfig.
	*
	* @param content the content of this WFMS_WorkflowConfig
	*/
	@Override
	public void setContent(java.lang.String content) {
		_wfms_WorkflowConfig.setContent(content);
	}

	/**
	* Sets the content type of this WFMS_WorkflowConfig.
	*
	* @param contentType the content type of this WFMS_WorkflowConfig
	*/
	@Override
	public void setContentType(java.lang.String contentType) {
		_wfms_WorkflowConfig.setContentType(contentType);
	}

	/**
	* Sets the create date of this WFMS_WorkflowConfig.
	*
	* @param createDate the create date of this WFMS_WorkflowConfig
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_WorkflowConfig.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_WorkflowConfig.
	*
	* @param createdBy the created by of this WFMS_WorkflowConfig
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_WorkflowConfig.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_WorkflowConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_WorkflowConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_WorkflowConfig.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this WFMS_WorkflowConfig.
	*
	* @param modifiedBy the modified by of this WFMS_WorkflowConfig
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_WorkflowConfig.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_WorkflowConfig.
	*
	* @param modifiedDate the modified date of this WFMS_WorkflowConfig
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_WorkflowConfig.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_WorkflowConfig.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_WorkflowConfig.
	*
	* @param primaryKey the primary key of this WFMS_WorkflowConfig
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wfms_WorkflowConfig.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_WorkflowConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the wfc ID of this WFMS_WorkflowConfig.
	*
	* @param wfcId the wfc ID of this WFMS_WorkflowConfig
	*/
	@Override
	public void setWfcId(long wfcId) {
		_wfms_WorkflowConfig.setWfcId(wfcId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_WorkflowConfigWrapper)) {
			return false;
		}

		WFMS_WorkflowConfigWrapper wfms_WorkflowConfigWrapper = (WFMS_WorkflowConfigWrapper)obj;

		if (Objects.equals(_wfms_WorkflowConfig,
					wfms_WorkflowConfigWrapper._wfms_WorkflowConfig)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_WorkflowConfig getWrappedModel() {
		return _wfms_WorkflowConfig;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_WorkflowConfig.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_WorkflowConfig.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_WorkflowConfig.resetOriginalValues();
	}

	private final WFMS_WorkflowConfig _wfms_WorkflowConfig;
}