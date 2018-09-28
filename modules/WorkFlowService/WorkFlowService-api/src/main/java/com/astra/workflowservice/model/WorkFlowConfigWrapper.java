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

package com.astra.workflowservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WorkFlowConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFlowConfig
 * @generated
 */
@ProviderType
public class WorkFlowConfigWrapper implements WorkFlowConfig,
	ModelWrapper<WorkFlowConfig> {
	public WorkFlowConfigWrapper(WorkFlowConfig workFlowConfig) {
		_workFlowConfig = workFlowConfig;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkFlowConfig.class;
	}

	@Override
	public String getModelClassName() {
		return WorkFlowConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("WfcId", getWfcId());
		attributes.put("ConfigKey", getConfigKey());
		attributes.put("Content", getContent());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long WfcId = (Long)attributes.get("WfcId");

		if (WfcId != null) {
			setWfcId(WfcId);
		}

		String ConfigKey = (String)attributes.get("ConfigKey");

		if (ConfigKey != null) {
			setConfigKey(ConfigKey);
		}

		String Content = (String)attributes.get("Content");

		if (Content != null) {
			setContent(Content);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public WorkFlowConfig toEscapedModel() {
		return new WorkFlowConfigWrapper(_workFlowConfig.toEscapedModel());
	}

	@Override
	public WorkFlowConfig toUnescapedModel() {
		return new WorkFlowConfigWrapper(_workFlowConfig.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _workFlowConfig.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workFlowConfig.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _workFlowConfig.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workFlowConfig.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorkFlowConfig> toCacheModel() {
		return _workFlowConfig.toCacheModel();
	}

	@Override
	public int compareTo(WorkFlowConfig workFlowConfig) {
		return _workFlowConfig.compareTo(workFlowConfig);
	}

	@Override
	public int hashCode() {
		return _workFlowConfig.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workFlowConfig.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WorkFlowConfigWrapper((WorkFlowConfig)_workFlowConfig.clone());
	}

	/**
	* Returns the config key of this work flow config.
	*
	* @return the config key of this work flow config
	*/
	@Override
	public java.lang.String getConfigKey() {
		return _workFlowConfig.getConfigKey();
	}

	/**
	* Returns the content of this work flow config.
	*
	* @return the content of this work flow config
	*/
	@Override
	public java.lang.String getContent() {
		return _workFlowConfig.getContent();
	}

	/**
	* Returns the user name of this work flow config.
	*
	* @return the user name of this work flow config
	*/
	@Override
	public java.lang.String getUserName() {
		return _workFlowConfig.getUserName();
	}

	/**
	* Returns the user uuid of this work flow config.
	*
	* @return the user uuid of this work flow config
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _workFlowConfig.getUserUuid();
	}

	/**
	* Returns the uuid of this work flow config.
	*
	* @return the uuid of this work flow config
	*/
	@Override
	public java.lang.String getUuid() {
		return _workFlowConfig.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _workFlowConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workFlowConfig.toXmlString();
	}

	/**
	* Returns the create date of this work flow config.
	*
	* @return the create date of this work flow config
	*/
	@Override
	public Date getCreateDate() {
		return _workFlowConfig.getCreateDate();
	}

	/**
	* Returns the modified date of this work flow config.
	*
	* @return the modified date of this work flow config
	*/
	@Override
	public Date getModifiedDate() {
		return _workFlowConfig.getModifiedDate();
	}

	/**
	* Returns the company ID of this work flow config.
	*
	* @return the company ID of this work flow config
	*/
	@Override
	public long getCompanyId() {
		return _workFlowConfig.getCompanyId();
	}

	/**
	* Returns the primary key of this work flow config.
	*
	* @return the primary key of this work flow config
	*/
	@Override
	public long getPrimaryKey() {
		return _workFlowConfig.getPrimaryKey();
	}

	/**
	* Returns the user ID of this work flow config.
	*
	* @return the user ID of this work flow config
	*/
	@Override
	public long getUserId() {
		return _workFlowConfig.getUserId();
	}

	/**
	* Returns the wfc ID of this work flow config.
	*
	* @return the wfc ID of this work flow config
	*/
	@Override
	public long getWfcId() {
		return _workFlowConfig.getWfcId();
	}

	@Override
	public void persist() {
		_workFlowConfig.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workFlowConfig.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this work flow config.
	*
	* @param companyId the company ID of this work flow config
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workFlowConfig.setCompanyId(companyId);
	}

	/**
	* Sets the config key of this work flow config.
	*
	* @param ConfigKey the config key of this work flow config
	*/
	@Override
	public void setConfigKey(java.lang.String ConfigKey) {
		_workFlowConfig.setConfigKey(ConfigKey);
	}

	/**
	* Sets the content of this work flow config.
	*
	* @param Content the content of this work flow config
	*/
	@Override
	public void setContent(java.lang.String Content) {
		_workFlowConfig.setContent(Content);
	}

	/**
	* Sets the create date of this work flow config.
	*
	* @param createDate the create date of this work flow config
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_workFlowConfig.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workFlowConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_workFlowConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workFlowConfig.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this work flow config.
	*
	* @param modifiedDate the modified date of this work flow config
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_workFlowConfig.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_workFlowConfig.setNew(n);
	}

	/**
	* Sets the primary key of this work flow config.
	*
	* @param primaryKey the primary key of this work flow config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workFlowConfig.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workFlowConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this work flow config.
	*
	* @param userId the user ID of this work flow config
	*/
	@Override
	public void setUserId(long userId) {
		_workFlowConfig.setUserId(userId);
	}

	/**
	* Sets the user name of this work flow config.
	*
	* @param userName the user name of this work flow config
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_workFlowConfig.setUserName(userName);
	}

	/**
	* Sets the user uuid of this work flow config.
	*
	* @param userUuid the user uuid of this work flow config
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workFlowConfig.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this work flow config.
	*
	* @param uuid the uuid of this work flow config
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_workFlowConfig.setUuid(uuid);
	}

	/**
	* Sets the wfc ID of this work flow config.
	*
	* @param WfcId the wfc ID of this work flow config
	*/
	@Override
	public void setWfcId(long WfcId) {
		_workFlowConfig.setWfcId(WfcId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkFlowConfigWrapper)) {
			return false;
		}

		WorkFlowConfigWrapper workFlowConfigWrapper = (WorkFlowConfigWrapper)obj;

		if (Objects.equals(_workFlowConfig,
					workFlowConfigWrapper._workFlowConfig)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _workFlowConfig.getStagedModelType();
	}

	@Override
	public WorkFlowConfig getWrappedModel() {
		return _workFlowConfig;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workFlowConfig.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workFlowConfig.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workFlowConfig.resetOriginalValues();
	}

	private final WorkFlowConfig _workFlowConfig;
}