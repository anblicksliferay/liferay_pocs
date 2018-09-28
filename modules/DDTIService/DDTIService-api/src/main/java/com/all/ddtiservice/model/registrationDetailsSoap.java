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

package com.all.ddtiservice.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.all.ddtiservice.service.http.registrationDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.all.ddtiservice.service.http.registrationDetailsServiceSoap
 * @generated
 */
@ProviderType
public class registrationDetailsSoap implements Serializable {
	public static registrationDetailsSoap toSoapModel(registrationDetails model) {
		registrationDetailsSoap soapModel = new registrationDetailsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRegistrationId(model.getRegistrationId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setSurName(model.getSurName());
		soapModel.setAddress(model.getAddress());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setGender(model.getGender());
		soapModel.setImagepath(model.getImagepath());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static registrationDetailsSoap[] toSoapModels(
		registrationDetails[] models) {
		registrationDetailsSoap[] soapModels = new registrationDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static registrationDetailsSoap[][] toSoapModels(
		registrationDetails[][] models) {
		registrationDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new registrationDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new registrationDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static registrationDetailsSoap[] toSoapModels(
		List<registrationDetails> models) {
		List<registrationDetailsSoap> soapModels = new ArrayList<registrationDetailsSoap>(models.size());

		for (registrationDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new registrationDetailsSoap[soapModels.size()]);
	}

	public registrationDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _registrationId;
	}

	public void setPrimaryKey(long pk) {
		setRegistrationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRegistrationId() {
		return _registrationId;
	}

	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getSurName() {
		return _surName;
	}

	public void setSurName(String surName) {
		_surName = surName;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public long getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		_contactNumber = contactNumber;
	}

	public boolean getGender() {
		return _gender;
	}

	public boolean isGender() {
		return _gender;
	}

	public void setGender(boolean gender) {
		_gender = gender;
	}

	public String getImagepath() {
		return _imagepath;
	}

	public void setImagepath(String imagepath) {
		_imagepath = imagepath;
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
	private long _registrationId;
	private String _firstName;
	private String _lastName;
	private String _surName;
	private String _address;
	private long _contactNumber;
	private boolean _gender;
	private String _imagepath;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}