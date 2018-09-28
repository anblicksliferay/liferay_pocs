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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.astra.workflowservice.service.http.WorkFlowConfigServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.workflowservice.service.http.WorkFlowConfigServiceSoap
 * @generated
 */
@ProviderType
public class WorkFlowConfigSoap implements Serializable {
	public static WorkFlowConfigSoap toSoapModel(WorkFlowConfig model) {
		WorkFlowConfigSoap soapModel = new WorkFlowConfigSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWfcId(model.getWfcId());
		soapModel.setConfigKey(model.getConfigKey());
		soapModel.setContent(model.getContent());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WorkFlowConfigSoap[] toSoapModels(WorkFlowConfig[] models) {
		WorkFlowConfigSoap[] soapModels = new WorkFlowConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkFlowConfigSoap[][] toSoapModels(WorkFlowConfig[][] models) {
		WorkFlowConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkFlowConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkFlowConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkFlowConfigSoap[] toSoapModels(List<WorkFlowConfig> models) {
		List<WorkFlowConfigSoap> soapModels = new ArrayList<WorkFlowConfigSoap>(models.size());

		for (WorkFlowConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkFlowConfigSoap[soapModels.size()]);
	}

	public WorkFlowConfigSoap() {
	}

	public long getPrimaryKey() {
		return _WfcId;
	}

	public void setPrimaryKey(long pk) {
		setWfcId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWfcId() {
		return _WfcId;
	}

	public void setWfcId(long WfcId) {
		_WfcId = WfcId;
	}

	public String getConfigKey() {
		return _ConfigKey;
	}

	public void setConfigKey(String ConfigKey) {
		_ConfigKey = ConfigKey;
	}

	public String getContent() {
		return _Content;
	}

	public void setContent(String Content) {
		_Content = Content;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _WfcId;
	private String _ConfigKey;
	private String _Content;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}