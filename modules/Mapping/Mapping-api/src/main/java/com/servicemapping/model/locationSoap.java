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

package com.servicemapping.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.servicemapping.service.http.locationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.servicemapping.service.http.locationServiceSoap
 * @generated
 */
@ProviderType
public class locationSoap implements Serializable {
	public static locationSoap toSoapModel(location model) {
		locationSoap soapModel = new locationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setLocationName(model.getLocationName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static locationSoap[] toSoapModels(location[] models) {
		locationSoap[] soapModels = new locationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static locationSoap[][] toSoapModels(location[][] models) {
		locationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new locationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new locationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static locationSoap[] toSoapModels(List<location> models) {
		List<locationSoap> soapModels = new ArrayList<locationSoap>(models.size());

		for (location model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new locationSoap[soapModels.size()]);
	}

	public locationSoap() {
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long pk) {
		setLocationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public String getLocationName() {
		return _locationName;
	}

	public void setLocationName(String locationName) {
		_locationName = locationName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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
	private long _locationId;
	private String _locationName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}