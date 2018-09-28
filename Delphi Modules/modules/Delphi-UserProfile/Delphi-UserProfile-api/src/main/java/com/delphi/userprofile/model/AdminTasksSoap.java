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

package com.delphi.userprofile.model;

import aQute.bnd.annotation.ProviderType;

import com.delphi.userprofile.service.persistence.AdminTasksPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.delphi.userprofile.service.http.AdminTasksServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.delphi.userprofile.service.http.AdminTasksServiceSoap
 * @generated
 */
@ProviderType
public class AdminTasksSoap implements Serializable {
	public static AdminTasksSoap toSoapModel(AdminTasks model) {
		AdminTasksSoap soapModel = new AdminTasksSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAdminTaskId(model.getAdminTaskId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSystemAlert(model.getSystemAlert());
		soapModel.setMessageText(model.getMessageText());
		soapModel.setPostOnPortBanner(model.getPostOnPortBanner());
		soapModel.setSiteAlert(model.getSiteAlert());
		soapModel.setSiteName(model.getSiteName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AdminTasksSoap[] toSoapModels(AdminTasks[] models) {
		AdminTasksSoap[] soapModels = new AdminTasksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdminTasksSoap[][] toSoapModels(AdminTasks[][] models) {
		AdminTasksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdminTasksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdminTasksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdminTasksSoap[] toSoapModels(List<AdminTasks> models) {
		List<AdminTasksSoap> soapModels = new ArrayList<AdminTasksSoap>(models.size());

		for (AdminTasks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdminTasksSoap[soapModels.size()]);
	}

	public AdminTasksSoap() {
	}

	public AdminTasksPK getPrimaryKey() {
		return new AdminTasksPK(_adminTaskId, _userId);
	}

	public void setPrimaryKey(AdminTasksPK pk) {
		setAdminTaskId(pk.adminTaskId);
		setUserId(pk.userId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAdminTaskId() {
		return _adminTaskId;
	}

	public void setAdminTaskId(long adminTaskId) {
		_adminTaskId = adminTaskId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public boolean getSystemAlert() {
		return _systemAlert;
	}

	public boolean isSystemAlert() {
		return _systemAlert;
	}

	public void setSystemAlert(boolean systemAlert) {
		_systemAlert = systemAlert;
	}

	public String getMessageText() {
		return _messageText;
	}

	public void setMessageText(String messageText) {
		_messageText = messageText;
	}

	public boolean getPostOnPortBanner() {
		return _postOnPortBanner;
	}

	public boolean isPostOnPortBanner() {
		return _postOnPortBanner;
	}

	public void setPostOnPortBanner(boolean postOnPortBanner) {
		_postOnPortBanner = postOnPortBanner;
	}

	public boolean getSiteAlert() {
		return _siteAlert;
	}

	public boolean isSiteAlert() {
		return _siteAlert;
	}

	public void setSiteAlert(boolean siteAlert) {
		_siteAlert = siteAlert;
	}

	public String getSiteName() {
		return _siteName;
	}

	public void setSiteName(String siteName) {
		_siteName = siteName;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreatedById() {
		return _createdById;
	}

	public void setCreatedById(long createdById) {
		_createdById = createdById;
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
	private long _adminTaskId;
	private long _userId;
	private boolean _systemAlert;
	private String _messageText;
	private boolean _postOnPortBanner;
	private boolean _siteAlert;
	private String _siteName;
	private long _companyId;
	private long _createdById;
	private Date _createDate;
	private Date _modifiedDate;
}