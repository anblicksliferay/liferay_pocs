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

package com.ddt.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ddt.service.http.Loc_Course_InfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ddt.service.http.Loc_Course_InfoServiceSoap
 * @generated
 */
@ProviderType
public class Loc_Course_InfoSoap implements Serializable {
	public static Loc_Course_InfoSoap toSoapModel(Loc_Course_Info model) {
		Loc_Course_InfoSoap soapModel = new Loc_Course_InfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setCouserId(model.getCouserId());
		soapModel.setLocationName(model.getLocationName());
		soapModel.setCouserName(model.getCouserName());
		soapModel.setMaxSeats(model.getMaxSeats());
		soapModel.setToDate(model.getToDate());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setFees(model.getFees());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static Loc_Course_InfoSoap[] toSoapModels(Loc_Course_Info[] models) {
		Loc_Course_InfoSoap[] soapModels = new Loc_Course_InfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Loc_Course_InfoSoap[][] toSoapModels(
		Loc_Course_Info[][] models) {
		Loc_Course_InfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Loc_Course_InfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Loc_Course_InfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Loc_Course_InfoSoap[] toSoapModels(
		List<Loc_Course_Info> models) {
		List<Loc_Course_InfoSoap> soapModels = new ArrayList<Loc_Course_InfoSoap>(models.size());

		for (Loc_Course_Info model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Loc_Course_InfoSoap[soapModels.size()]);
	}

	public Loc_Course_InfoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getCouserId() {
		return _couserId;
	}

	public void setCouserId(long couserId) {
		_couserId = couserId;
	}

	public String getLocationName() {
		return _locationName;
	}

	public void setLocationName(String locationName) {
		_locationName = locationName;
	}

	public String getCouserName() {
		return _couserName;
	}

	public void setCouserName(String couserName) {
		_couserName = couserName;
	}

	public long getMaxSeats() {
		return _maxSeats;
	}

	public void setMaxSeats(long maxSeats) {
		_maxSeats = maxSeats;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public long getFees() {
		return _Fees;
	}

	public void setFees(long Fees) {
		_Fees = Fees;
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
	private long _id;
	private long _locationId;
	private long _couserId;
	private String _locationName;
	private String _couserName;
	private long _maxSeats;
	private Date _toDate;
	private Date _fromDate;
	private long _Fees;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}