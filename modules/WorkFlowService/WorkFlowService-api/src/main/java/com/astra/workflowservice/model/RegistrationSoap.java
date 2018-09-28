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
 * This class is used by SOAP remote services, specifically {@link com.astra.workflowservice.service.http.RegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.workflowservice.service.http.RegistrationServiceSoap
 * @generated
 */
@ProviderType
public class RegistrationSoap implements Serializable {
	public static RegistrationSoap toSoapModel(Registration model) {
		RegistrationSoap soapModel = new RegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRegistrationId(model.getRegistrationId());
		soapModel.setFirstname(model.getFirstname());
		soapModel.setLastname(model.getLastname());
		soapModel.setCourse(model.getCourse());
		soapModel.setEmail(model.getEmail());
		soapModel.setLocation(model.getLocation());
		soapModel.setStatus(model.getStatus());
		soapModel.setComments(model.getComments());
		soapModel.setWorkflowstepnumber(model.getWorkflowstepnumber());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setCurrentApprover(model.getCurrentApprover());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static RegistrationSoap[] toSoapModels(Registration[] models) {
		RegistrationSoap[] soapModels = new RegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegistrationSoap[][] toSoapModels(Registration[][] models) {
		RegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegistrationSoap[] toSoapModels(List<Registration> models) {
		List<RegistrationSoap> soapModels = new ArrayList<RegistrationSoap>(models.size());

		for (Registration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegistrationSoap[soapModels.size()]);
	}

	public RegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _RegistrationId;
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
		return _RegistrationId;
	}

	public void setRegistrationId(long RegistrationId) {
		_RegistrationId = RegistrationId;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getCourse() {
		return _course;
	}

	public void setCourse(String course) {
		_course = course;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getWorkflowstepnumber() {
		return _Workflowstepnumber;
	}

	public void setWorkflowstepnumber(String Workflowstepnumber) {
		_Workflowstepnumber = Workflowstepnumber;
	}

	public String getWorkflowId() {
		return _WorkflowId;
	}

	public void setWorkflowId(String WorkflowId) {
		_WorkflowId = WorkflowId;
	}

	public String getCurrentApprover() {
		return _CurrentApprover;
	}

	public void setCurrentApprover(String CurrentApprover) {
		_CurrentApprover = CurrentApprover;
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
	private long _RegistrationId;
	private String _firstname;
	private String _lastname;
	private String _course;
	private String _email;
	private String _location;
	private String _status;
	private String _comments;
	private String _Workflowstepnumber;
	private String _WorkflowId;
	private String _CurrentApprover;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}