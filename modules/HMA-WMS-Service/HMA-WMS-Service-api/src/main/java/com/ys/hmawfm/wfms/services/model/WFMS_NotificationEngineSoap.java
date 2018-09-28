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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_NotificationEngineServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_NotificationEngineServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_NotificationEngineSoap implements Serializable {
	public static WFMS_NotificationEngineSoap toSoapModel(
		WFMS_NotificationEngine model) {
		WFMS_NotificationEngineSoap soapModel = new WFMS_NotificationEngineSoap();

		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setScopeGroupId(model.getScopeGroupId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setContentType(model.getContentType());
		soapModel.setComments(model.getComments());
		soapModel.setTimesUsed(model.getTimesUsed());

		return soapModel;
	}

	public static WFMS_NotificationEngineSoap[] toSoapModels(
		WFMS_NotificationEngine[] models) {
		WFMS_NotificationEngineSoap[] soapModels = new WFMS_NotificationEngineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_NotificationEngineSoap[][] toSoapModels(
		WFMS_NotificationEngine[][] models) {
		WFMS_NotificationEngineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_NotificationEngineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_NotificationEngineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_NotificationEngineSoap[] toSoapModels(
		List<WFMS_NotificationEngine> models) {
		List<WFMS_NotificationEngineSoap> soapModels = new ArrayList<WFMS_NotificationEngineSoap>(models.size());

		for (WFMS_NotificationEngine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_NotificationEngineSoap[soapModels.size()]);
	}

	public WFMS_NotificationEngineSoap() {
	}

	public long getPrimaryKey() {
		return _templateId;
	}

	public void setPrimaryKey(long pk) {
		setTemplateId(pk);
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getScopeGroupId() {
		return _scopeGroupId;
	}

	public void setScopeGroupId(long scopeGroupId) {
		_scopeGroupId = scopeGroupId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getContentType() {
		return _contentType;
	}

	public void setContentType(String contentType) {
		_contentType = contentType;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public int getTimesUsed() {
		return _timesUsed;
	}

	public void setTimesUsed(int timesUsed) {
		_timesUsed = timesUsed;
	}

	private long _templateId;
	private long _companyId;
	private long _scopeGroupId;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
	private String _title;
	private String _content;
	private String _contentType;
	private String _comments;
	private int _timesUsed;
}