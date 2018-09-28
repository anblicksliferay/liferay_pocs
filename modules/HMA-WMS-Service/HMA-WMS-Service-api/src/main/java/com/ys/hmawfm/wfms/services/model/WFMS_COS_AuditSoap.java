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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_COS_AuditServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_COS_AuditServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_COS_AuditSoap implements Serializable {
	public static WFMS_COS_AuditSoap toSoapModel(WFMS_COS_Audit model) {
		WFMS_COS_AuditSoap soapModel = new WFMS_COS_AuditSoap();

		soapModel.setCosaId(model.getCosaId());
		soapModel.setCosId(model.getCosId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setChange(model.getChange());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static WFMS_COS_AuditSoap[] toSoapModels(WFMS_COS_Audit[] models) {
		WFMS_COS_AuditSoap[] soapModels = new WFMS_COS_AuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_COS_AuditSoap[][] toSoapModels(WFMS_COS_Audit[][] models) {
		WFMS_COS_AuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_COS_AuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_COS_AuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_COS_AuditSoap[] toSoapModels(List<WFMS_COS_Audit> models) {
		List<WFMS_COS_AuditSoap> soapModels = new ArrayList<WFMS_COS_AuditSoap>(models.size());

		for (WFMS_COS_Audit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_COS_AuditSoap[soapModels.size()]);
	}

	public WFMS_COS_AuditSoap() {
	}

	public String getPrimaryKey() {
		return _cosaId;
	}

	public void setPrimaryKey(String pk) {
		setCosaId(pk);
	}

	public String getCosaId() {
		return _cosaId;
	}

	public void setCosaId(String cosaId) {
		_cosaId = cosaId;
	}

	public String getCosId() {
		return _cosId;
	}

	public void setCosId(String cosId) {
		_cosId = cosId;
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

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private String _cosaId;
	private String _cosId;
	private long _userId;
	private String _createdBy;
	private Date _createDate;
	private String _change;
	private String _comments;
}