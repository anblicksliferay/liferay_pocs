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

package com.externalservices.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.externalservices.service.http.leykartEnquiryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.externalservices.service.http.leykartEnquiryServiceSoap
 * @generated
 */
@ProviderType
public class leykartEnquirySoap implements Serializable {
	public static leykartEnquirySoap toSoapModel(leykartEnquiry model) {
		leykartEnquirySoap soapModel = new leykartEnquirySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEid(model.getEid());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setPartName(model.getPartName());
		soapModel.setPartNumber(model.getPartNumber());
		soapModel.setMessage(model.getMessage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static leykartEnquirySoap[] toSoapModels(leykartEnquiry[] models) {
		leykartEnquirySoap[] soapModels = new leykartEnquirySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static leykartEnquirySoap[][] toSoapModels(leykartEnquiry[][] models) {
		leykartEnquirySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new leykartEnquirySoap[models.length][models[0].length];
		}
		else {
			soapModels = new leykartEnquirySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static leykartEnquirySoap[] toSoapModels(List<leykartEnquiry> models) {
		List<leykartEnquirySoap> soapModels = new ArrayList<leykartEnquirySoap>(models.size());

		for (leykartEnquiry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new leykartEnquirySoap[soapModels.size()]);
	}

	public leykartEnquirySoap() {
	}

	public long getPrimaryKey() {
		return _Eid;
	}

	public void setPrimaryKey(long pk) {
		setEid(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEid() {
		return _Eid;
	}

	public void setEid(long Eid) {
		_Eid = Eid;
	}

	public String getFirstName() {
		return _FirstName;
	}

	public void setFirstName(String FirstName) {
		_FirstName = FirstName;
	}

	public String getLastName() {
		return _LastName;
	}

	public void setLastName(String LastName) {
		_LastName = LastName;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getContactNumber() {
		return _ContactNumber;
	}

	public void setContactNumber(String ContactNumber) {
		_ContactNumber = ContactNumber;
	}

	public String getPartName() {
		return _PartName;
	}

	public void setPartName(String PartName) {
		_PartName = PartName;
	}

	public String getPartNumber() {
		return _PartNumber;
	}

	public void setPartNumber(String PartNumber) {
		_PartNumber = PartNumber;
	}

	public String getMessage() {
		return _Message;
	}

	public void setMessage(String Message) {
		_Message = Message;
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
	private long _Eid;
	private String _FirstName;
	private String _LastName;
	private String _Email;
	private String _ContactNumber;
	private String _PartName;
	private String _PartNumber;
	private String _Message;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}