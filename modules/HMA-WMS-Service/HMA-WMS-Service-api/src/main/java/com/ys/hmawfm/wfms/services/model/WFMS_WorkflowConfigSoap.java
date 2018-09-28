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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigSoap implements Serializable {
	public static WFMS_WorkflowConfigSoap toSoapModel(WFMS_WorkflowConfig model) {
		WFMS_WorkflowConfigSoap soapModel = new WFMS_WorkflowConfigSoap();

		soapModel.setWfcId(model.getWfcId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setConfigKey(model.getConfigKey());
		soapModel.setConfigLabel(model.getConfigLabel());
		soapModel.setContentType(model.getContentType());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static WFMS_WorkflowConfigSoap[] toSoapModels(
		WFMS_WorkflowConfig[] models) {
		WFMS_WorkflowConfigSoap[] soapModels = new WFMS_WorkflowConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_WorkflowConfigSoap[][] toSoapModels(
		WFMS_WorkflowConfig[][] models) {
		WFMS_WorkflowConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_WorkflowConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_WorkflowConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_WorkflowConfigSoap[] toSoapModels(
		List<WFMS_WorkflowConfig> models) {
		List<WFMS_WorkflowConfigSoap> soapModels = new ArrayList<WFMS_WorkflowConfigSoap>(models.size());

		for (WFMS_WorkflowConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_WorkflowConfigSoap[soapModels.size()]);
	}

	public WFMS_WorkflowConfigSoap() {
	}

	public long getPrimaryKey() {
		return _wfcId;
	}

	public void setPrimaryKey(long pk) {
		setWfcId(pk);
	}

	public long getWfcId() {
		return _wfcId;
	}

	public void setWfcId(long wfcId) {
		_wfcId = wfcId;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getConfigKey() {
		return _configKey;
	}

	public void setConfigKey(String configKey) {
		_configKey = configKey;
	}

	public String getConfigLabel() {
		return _configLabel;
	}

	public void setConfigLabel(String configLabel) {
		_configLabel = configLabel;
	}

	public String getContentType() {
		return _contentType;
	}

	public void setContentType(String contentType) {
		_contentType = contentType;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _wfcId;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
	private String _configKey;
	private String _configLabel;
	private String _contentType;
	private String _content;
}