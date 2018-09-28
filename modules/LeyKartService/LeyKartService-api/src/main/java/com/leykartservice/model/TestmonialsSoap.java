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

package com.leykartservice.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.leykartservice.service.http.TestmonialsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.leykartservice.service.http.TestmonialsServiceSoap
 * @generated
 */
@ProviderType
public class TestmonialsSoap implements Serializable {
	public static TestmonialsSoap toSoapModel(Testmonials model) {
		TestmonialsSoap soapModel = new TestmonialsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTestmonialsId(model.getTestmonialsId());
		soapModel.setFullname(model.getFullname());
		soapModel.setImagepath(model.getImagepath());
		soapModel.setMessage(model.getMessage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TestmonialsSoap[] toSoapModels(Testmonials[] models) {
		TestmonialsSoap[] soapModels = new TestmonialsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestmonialsSoap[][] toSoapModels(Testmonials[][] models) {
		TestmonialsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestmonialsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestmonialsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestmonialsSoap[] toSoapModels(List<Testmonials> models) {
		List<TestmonialsSoap> soapModels = new ArrayList<TestmonialsSoap>(models.size());

		for (Testmonials model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestmonialsSoap[soapModels.size()]);
	}

	public TestmonialsSoap() {
	}

	public long getPrimaryKey() {
		return _testmonialsId;
	}

	public void setPrimaryKey(long pk) {
		setTestmonialsId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTestmonialsId() {
		return _testmonialsId;
	}

	public void setTestmonialsId(long testmonialsId) {
		_testmonialsId = testmonialsId;
	}

	public String getFullname() {
		return _fullname;
	}

	public void setFullname(String fullname) {
		_fullname = fullname;
	}

	public String getImagepath() {
		return _imagepath;
	}

	public void setImagepath(String imagepath) {
		_imagepath = imagepath;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
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
	private long _testmonialsId;
	private String _fullname;
	private String _imagepath;
	private String _message;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}