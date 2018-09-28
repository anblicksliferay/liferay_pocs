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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.delphi.userprofile.service.http.UserAccessRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.delphi.userprofile.service.http.UserAccessRequestServiceSoap
 * @generated
 */
@ProviderType
public class UserAccessRequestSoap implements Serializable {
	public static UserAccessRequestSoap toSoapModel(UserAccessRequest model) {
		UserAccessRequestSoap soapModel = new UserAccessRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPortletAccess(model.getPortletAccess());
		soapModel.setRequestType(model.getRequestType());
		soapModel.setResponseType(model.getResponseType());
		soapModel.setResponseComment(model.getResponseComment());
		soapModel.setResponseUser(model.getResponseUser());
		soapModel.setActiveState(model.getActiveState());

		return soapModel;
	}

	public static UserAccessRequestSoap[] toSoapModels(
		UserAccessRequest[] models) {
		UserAccessRequestSoap[] soapModels = new UserAccessRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserAccessRequestSoap[][] toSoapModels(
		UserAccessRequest[][] models) {
		UserAccessRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserAccessRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserAccessRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserAccessRequestSoap[] toSoapModels(
		List<UserAccessRequest> models) {
		List<UserAccessRequestSoap> soapModels = new ArrayList<UserAccessRequestSoap>(models.size());

		for (UserAccessRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserAccessRequestSoap[soapModels.size()]);
	}

	public UserAccessRequestSoap() {
	}

	public long getPrimaryKey() {
		return _requestId;
	}

	public void setPrimaryKey(long pk) {
		setRequestId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getPortletAccess() {
		return _portletAccess;
	}

	public void setPortletAccess(String portletAccess) {
		_portletAccess = portletAccess;
	}

	public String getRequestType() {
		return _requestType;
	}

	public void setRequestType(String requestType) {
		_requestType = requestType;
	}

	public String getResponseType() {
		return _responseType;
	}

	public void setResponseType(String responseType) {
		_responseType = responseType;
	}

	public String getResponseComment() {
		return _responseComment;
	}

	public void setResponseComment(String responseComment) {
		_responseComment = responseComment;
	}

	public long getResponseUser() {
		return _responseUser;
	}

	public void setResponseUser(long responseUser) {
		_responseUser = responseUser;
	}

	public int getActiveState() {
		return _activeState;
	}

	public void setActiveState(int activeState) {
		_activeState = activeState;
	}

	private String _uuid;
	private long _requestId;
	private long _userId;
	private long _companyId;
	private long _createdById;
	private Date _createDate;
	private Date _modifiedDate;
	private String _portletAccess;
	private String _requestType;
	private String _responseType;
	private String _responseComment;
	private long _responseUser;
	private int _activeState;
}