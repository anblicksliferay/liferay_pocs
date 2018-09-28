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
 * This class is used by SOAP remote services, specifically {@link com.delphi.userprofile.service.http.UserProfileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.delphi.userprofile.service.http.UserProfileServiceSoap
 * @generated
 */
@ProviderType
public class UserProfileSoap implements Serializable {
	public static UserProfileSoap toSoapModel(UserProfile model) {
		UserProfileSoap soapModel = new UserProfileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCommunicationPreferences(model.getCommunicationPreferences());
		soapModel.setRegion(model.getRegion());
		soapModel.setSite(model.getSite());
		soapModel.setServer(model.getServer());
		soapModel.setDivision(model.getDivision());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTimezone(model.getTimezone());
		soapModel.setWorkHours(model.getWorkHours());
		soapModel.setJobrole(model.getJobrole());
		soapModel.setInterests(model.getInterests());
		soapModel.setPortlets(model.getPortlets());

		return soapModel;
	}

	public static UserProfileSoap[] toSoapModels(UserProfile[] models) {
		UserProfileSoap[] soapModels = new UserProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserProfileSoap[][] toSoapModels(UserProfile[][] models) {
		UserProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserProfileSoap[] toSoapModels(List<UserProfile> models) {
		List<UserProfileSoap> soapModels = new ArrayList<UserProfileSoap>(models.size());

		for (UserProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserProfileSoap[soapModels.size()]);
	}

	public UserProfileSoap() {
	}

	public long getPrimaryKey() {
		return _profileId;
	}

	public void setPrimaryKey(long pk) {
		setProfileId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
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

	public String getCommunicationPreferences() {
		return _communicationPreferences;
	}

	public void setCommunicationPreferences(String communicationPreferences) {
		_communicationPreferences = communicationPreferences;
	}

	public String getRegion() {
		return _region;
	}

	public void setRegion(String region) {
		_region = region;
	}

	public String getSite() {
		return _site;
	}

	public void setSite(String site) {
		_site = site;
	}

	public String getServer() {
		return _server;
	}

	public void setServer(String server) {
		_server = server;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTimezone() {
		return _timezone;
	}

	public void setTimezone(String timezone) {
		_timezone = timezone;
	}

	public String getWorkHours() {
		return _workHours;
	}

	public void setWorkHours(String workHours) {
		_workHours = workHours;
	}

	public String getJobrole() {
		return _jobrole;
	}

	public void setJobrole(String jobrole) {
		_jobrole = jobrole;
	}

	public String getInterests() {
		return _interests;
	}

	public void setInterests(String interests) {
		_interests = interests;
	}

	public String getPortlets() {
		return _portlets;
	}

	public void setPortlets(String portlets) {
		_portlets = portlets;
	}

	private String _uuid;
	private long _profileId;
	private long _userId;
	private long _companyId;
	private long _createdById;
	private Date _createDate;
	private Date _modifiedDate;
	private String _communicationPreferences;
	private String _region;
	private String _site;
	private String _server;
	private String _division;
	private String _language;
	private String _timezone;
	private String _workHours;
	private String _jobrole;
	private String _interests;
	private String _portlets;
}