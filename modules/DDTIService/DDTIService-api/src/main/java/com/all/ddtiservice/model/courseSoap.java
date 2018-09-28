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
 * This class is used by SOAP remote services, specifically {@link com.all.ddtiservice.service.http.courseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.all.ddtiservice.service.http.courseServiceSoap
 * @generated
 */
@ProviderType
public class courseSoap implements Serializable {
	public static courseSoap toSoapModel(course model) {
		courseSoap soapModel = new courseSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setCourseName(model.getCourseName());
		soapModel.setFee(model.getFee());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setMaxseats(model.getMaxseats());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static courseSoap[] toSoapModels(course[] models) {
		courseSoap[] soapModels = new courseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static courseSoap[][] toSoapModels(course[][] models) {
		courseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new courseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new courseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static courseSoap[] toSoapModels(List<course> models) {
		List<courseSoap> soapModels = new ArrayList<courseSoap>(models.size());

		for (course model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new courseSoap[soapModels.size()]);
	}

	public courseSoap() {
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long pk) {
		setCourseId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public String getCourseName() {
		return _courseName;
	}

	public void setCourseName(String courseName) {
		_courseName = courseName;
	}

	public long getFee() {
		return _fee;
	}

	public void setFee(long fee) {
		_fee = fee;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getMaxseats() {
		return _maxseats;
	}

	public void setMaxseats(long maxseats) {
		_maxseats = maxseats;
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
	private long _courseId;
	private String _courseName;
	private long _fee;
	private Date _startDate;
	private Date _endDate;
	private long _maxseats;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}