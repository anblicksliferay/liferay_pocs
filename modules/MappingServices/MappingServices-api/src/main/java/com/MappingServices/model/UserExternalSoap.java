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

package com.MappingServices.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.MappingServices.service.http.UserExternalServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.MappingServices.service.http.UserExternalServiceSoap
 * @generated
 */
@ProviderType
public class UserExternalSoap implements Serializable {
	public static UserExternalSoap toSoapModel(UserExternal model) {
		UserExternalSoap soapModel = new UserExternalSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUid(model.getUid());
		soapModel.setLocation(model.getLocation());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserExternalSoap[] toSoapModels(UserExternal[] models) {
		UserExternalSoap[] soapModels = new UserExternalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserExternalSoap[][] toSoapModels(UserExternal[][] models) {
		UserExternalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserExternalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserExternalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserExternalSoap[] toSoapModels(List<UserExternal> models) {
		List<UserExternalSoap> soapModels = new ArrayList<UserExternalSoap>(models.size());

		for (UserExternal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserExternalSoap[soapModels.size()]);
	}

	public UserExternalSoap() {
	}

	public long getPrimaryKey() {
		return _uid;
	}

	public void setPrimaryKey(long pk) {
		setUid(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUid() {
		return _uid;
	}

	public void setUid(long uid) {
		_uid = uid;
	}

	public String getLocation() {
		return _Location;
	}

	public void setLocation(String Location) {
		_Location = Location;
	}

	public String getPolicyNumber() {
		return _PolicyNumber;
	}

	public void setPolicyNumber(String PolicyNumber) {
		_PolicyNumber = PolicyNumber;
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
	private long _uid;
	private String _Location;
	private String _PolicyNumber;
	private Date _createDate;
	private Date _modifiedDate;
}