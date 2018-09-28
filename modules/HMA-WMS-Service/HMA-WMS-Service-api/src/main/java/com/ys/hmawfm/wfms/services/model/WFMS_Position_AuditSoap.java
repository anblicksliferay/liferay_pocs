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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_Position_AuditServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_Position_AuditServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditSoap implements Serializable {
	public static WFMS_Position_AuditSoap toSoapModel(WFMS_Position_Audit model) {
		WFMS_Position_AuditSoap soapModel = new WFMS_Position_AuditSoap();

		soapModel.setPaId(model.getPaId());
		soapModel.setPId(model.getPId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAssociateId(model.getAssociateId());
		soapModel.setChange(model.getChange());
		soapModel.setFromPId(model.getFromPId());
		soapModel.setComments(model.getComments());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static WFMS_Position_AuditSoap[] toSoapModels(
		WFMS_Position_Audit[] models) {
		WFMS_Position_AuditSoap[] soapModels = new WFMS_Position_AuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_Position_AuditSoap[][] toSoapModels(
		WFMS_Position_Audit[][] models) {
		WFMS_Position_AuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_Position_AuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_Position_AuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_Position_AuditSoap[] toSoapModels(
		List<WFMS_Position_Audit> models) {
		List<WFMS_Position_AuditSoap> soapModels = new ArrayList<WFMS_Position_AuditSoap>(models.size());

		for (WFMS_Position_Audit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_Position_AuditSoap[soapModels.size()]);
	}

	public WFMS_Position_AuditSoap() {
	}

	public String getPrimaryKey() {
		return _paId;
	}

	public void setPrimaryKey(String pk) {
		setPaId(pk);
	}

	public String getPaId() {
		return _paId;
	}

	public void setPaId(String paId) {
		_paId = paId;
	}

	public String getPId() {
		return _pId;
	}

	public void setPId(String pId) {
		_pId = pId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAssociateId() {
		return _associateId;
	}

	public void setAssociateId(String associateId) {
		_associateId = associateId;
	}

	public String getChange() {
		return _change;
	}

	public void setChange(String change) {
		_change = change;
	}

	public String getFromPId() {
		return _fromPId;
	}

	public void setFromPId(String fromPId) {
		_fromPId = fromPId;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
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

	private String _paId;
	private String _pId;
	private long _userId;
	private String _associateId;
	private String _change;
	private String _fromPId;
	private String _comments;
	private String _createdBy;
	private Date _createDate;
}