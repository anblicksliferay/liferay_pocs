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
 * This class is a wrapper for {@link WFMS_Config}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Config
 * @generated
 */
@ProviderType
public class WFMS_ConfigWrapper implements WFMS_Config,
	ModelWrapper<WFMS_Config> {
	public WFMS_ConfigWrapper(WFMS_Config wfms_Config) {
		_wfms_Config = wfms_Config;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_Config.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_Config.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configId", getConfigId());
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
		Long configId = (Long)attributes.get("configId");

		if (configId != null) {
			setConfigId(configId);
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
	public WFMS_Config toEscapedModel() {
		return new WFMS_ConfigWrapper(_wfms_Config.toEscapedModel());
	}

	@Override
	public WFMS_Config toUnescapedModel() {
		return new WFMS_ConfigWrapper(_wfms_Config.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_Config.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_Config.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_Config.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_Config.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_Config> toCacheModel() {
		return _wfms_Config.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_Config wfms_Config) {
		return _wfms_Config.compareTo(wfms_Config);
	}

	@Override
	public int hashCode() {
		return _wfms_Config.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_Config.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_ConfigWrapper((WFMS_Config)_wfms_Config.clone());
	}

	/**
	* Returns the config key of this WFMS_Configuration.
	*
	* @return the config key of this WFMS_Configuration
	*/
	@Override
	public java.lang.String getConfigKey() {
		return _wfms_Config.getConfigKey();
	}

	/**
	* Returns the config label of this WFMS_Configuration.
	*
	* @return the config label of this WFMS_Configuration
	*/
	@Override
	public java.lang.String getConfigLabel() {
		return _wfms_Config.getConfigLabel();
	}

	/**
	* Returns the content of this WFMS_Configuration.
	*
	* @return the content of this WFMS_Configuration
	*/
	@Override
	public java.lang.String getContent() {
		return _wfms_Config.getContent();
	}

	/**
	* Returns the content type of this WFMS_Configuration.
	*
	* @return the content type of this WFMS_Configuration
	*/
	@Override
	public java.lang.String getContentType() {
		return _wfms_Config.getContentType();
	}

	/**
	* Returns the created by of this WFMS_Configuration.
	*
	* @return the created by of this WFMS_Configuration
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_Config.getCreatedBy();
	}

	/**
	* Returns the modified by of this WFMS_Configuration.
	*
	* @return the modified by of this WFMS_Configuration
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_Config.getModifiedBy();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_Config.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_Config.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_Configuration.
	*
	* @return the create date of this WFMS_Configuration
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_Config.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_Configuration.
	*
	* @return the modified date of this WFMS_Configuration
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_Config.getModifiedDate();
	}

	/**
	* Returns the config ID of this WFMS_Configuration.
	*
	* @return the config ID of this WFMS_Configuration
	*/
	@Override
	public long getConfigId() {
		return _wfms_Config.getConfigId();
	}

	/**
	* Returns the primary key of this WFMS_Configuration.
	*
	* @return the primary key of this WFMS_Configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _wfms_Config.getPrimaryKey();
	}

	@Override
	public void persist() {
		_wfms_Config.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_Config.setCachedModel(cachedModel);
	}

	/**
	* Sets the config ID of this WFMS_Configuration.
	*
	* @param configId the config ID of this WFMS_Configuration
	*/
	@Override
	public void setConfigId(long configId) {
		_wfms_Config.setConfigId(configId);
	}

	/**
	* Sets the config key of this WFMS_Configuration.
	*
	* @param configKey the config key of this WFMS_Configuration
	*/
	@Override
	public void setConfigKey(java.lang.String configKey) {
		_wfms_Config.setConfigKey(configKey);
	}

	/**
	* Sets the config label of this WFMS_Configuration.
	*
	* @param configLabel the config label of this WFMS_Configuration
	*/
	@Override
	public void setConfigLabel(java.lang.String configLabel) {
		_wfms_Config.setConfigLabel(configLabel);
	}

	/**
	* Sets the content of this WFMS_Configuration.
	*
	* @param content the content of this WFMS_Configuration
	*/
	@Override
	public void setContent(java.lang.String content) {
		_wfms_Config.setContent(content);
	}

	/**
	* Sets the content type of this WFMS_Configuration.
	*
	* @param contentType the content type of this WFMS_Configuration
	*/
	@Override
	public void setContentType(java.lang.String contentType) {
		_wfms_Config.setContentType(contentType);
	}

	/**
	* Sets the create date of this WFMS_Configuration.
	*
	* @param createDate the create date of this WFMS_Configuration
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_Config.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_Configuration.
	*
	* @param createdBy the created by of this WFMS_Configuration
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_Config.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_Config.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_Config.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_Config.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this WFMS_Configuration.
	*
	* @param modifiedBy the modified by of this WFMS_Configuration
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_Config.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_Configuration.
	*
	* @param modifiedDate the modified date of this WFMS_Configuration
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_Config.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_Config.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_Configuration.
	*
	* @param primaryKey the primary key of this WFMS_Configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wfms_Config.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_Config.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_ConfigWrapper)) {
			return false;
		}

		WFMS_ConfigWrapper wfms_ConfigWrapper = (WFMS_ConfigWrapper)obj;

		if (Objects.equals(_wfms_Config, wfms_ConfigWrapper._wfms_Config)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_Config getWrappedModel() {
		return _wfms_Config;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_Config.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_Config.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_Config.resetOriginalValues();
	}

	private final WFMS_Config _wfms_Config;
}