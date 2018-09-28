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
public class WFMS_ConfigSoap implements Serializable {
	public static WFMS_ConfigSoap toSoapModel(WFMS_Config model) {
		WFMS_ConfigSoap soapModel = new WFMS_ConfigSoap();

		soapModel.setConfigId(model.getConfigId());
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

	public static WFMS_ConfigSoap[] toSoapModels(WFMS_Config[] models) {
		WFMS_ConfigSoap[] soapModels = new WFMS_ConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_ConfigSoap[][] toSoapModels(WFMS_Config[][] models) {
		WFMS_ConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_ConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_ConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_ConfigSoap[] toSoapModels(List<WFMS_Config> models) {
		List<WFMS_ConfigSoap> soapModels = new ArrayList<WFMS_ConfigSoap>(models.size());

		for (WFMS_Config model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_ConfigSoap[soapModels.size()]);
	}

	public WFMS_ConfigSoap() {
	}

	public long getPrimaryKey() {
		return _configId;
	}

	public void setPrimaryKey(long pk) {
		setConfigId(pk);
	}

	public long getConfigId() {
		return _configId;
	}

	public void setConfigId(long configId) {
		_configId = configId;
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

	private long _configId;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
	private String _configKey;
	private String _configLabel;
	private String _contentType;
	private String _content;
}