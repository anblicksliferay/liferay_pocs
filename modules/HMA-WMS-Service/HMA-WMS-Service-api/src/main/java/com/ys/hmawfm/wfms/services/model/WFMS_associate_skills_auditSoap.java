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

package com.ys.hmawfm.wfms.services.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_associate_skills_auditServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_associate_skills_auditServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditSoap implements Serializable {
	public static WFMS_associate_skills_auditSoap toSoapModel(
		WFMS_associate_skills_audit model) {
		WFMS_associate_skills_auditSoap soapModel = new WFMS_associate_skills_auditSoap();

		soapModel.setAssociate_log_id(model.getAssociate_log_id());
		soapModel.setAssociate_number(model.getAssociate_number());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setChange(model.getChange());

		return soapModel;
	}

	public static WFMS_associate_skills_auditSoap[] toSoapModels(
		WFMS_associate_skills_audit[] models) {
		WFMS_associate_skills_auditSoap[] soapModels = new WFMS_associate_skills_auditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_associate_skills_auditSoap[][] toSoapModels(
		WFMS_associate_skills_audit[][] models) {
		WFMS_associate_skills_auditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_associate_skills_auditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_associate_skills_auditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_associate_skills_auditSoap[] toSoapModels(
		List<WFMS_associate_skills_audit> models) {
		List<WFMS_associate_skills_auditSoap> soapModels = new ArrayList<WFMS_associate_skills_auditSoap>(models.size());

		for (WFMS_associate_skills_audit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_associate_skills_auditSoap[soapModels.size()]);
	}

	public WFMS_associate_skills_auditSoap() {
	}

	public long getPrimaryKey() {
		return _associate_log_id;
	}

	public void setPrimaryKey(long pk) {
		setAssociate_log_id(pk);
	}

	public long getAssociate_log_id() {
		return _associate_log_id;
	}

	public void setAssociate_log_id(long associate_log_id) {
		_associate_log_id = associate_log_id;
	}

	public String getAssociate_number() {
		return _associate_number;
	}

	public void setAssociate_number(String associate_number) {
		_associate_number = associate_number;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getChange() {
		return _change;
	}

	public void setChange(String change) {
		_change = change;
	}

	private long _associate_log_id;
	private String _associate_number;
	private long _userId;
	private String _createdBy;
	private Date _createDate;
	private String _change;
}