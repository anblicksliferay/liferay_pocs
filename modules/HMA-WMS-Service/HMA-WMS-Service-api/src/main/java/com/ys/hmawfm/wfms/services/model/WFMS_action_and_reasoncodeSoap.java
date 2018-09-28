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
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class WFMS_action_and_reasoncodeSoap implements Serializable {
	public static WFMS_action_and_reasoncodeSoap toSoapModel(
		WFMS_action_and_reasoncode model) {
		WFMS_action_and_reasoncodeSoap soapModel = new WFMS_action_and_reasoncodeSoap();

		soapModel.setAarId(model.getAarId());
		soapModel.setAction(model.getAction());
		soapModel.setReasonCode(model.getReasonCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setDeleteflag(model.getDeleteflag());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WFMS_action_and_reasoncodeSoap[] toSoapModels(
		WFMS_action_and_reasoncode[] models) {
		WFMS_action_and_reasoncodeSoap[] soapModels = new WFMS_action_and_reasoncodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_action_and_reasoncodeSoap[][] toSoapModels(
		WFMS_action_and_reasoncode[][] models) {
		WFMS_action_and_reasoncodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_action_and_reasoncodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_action_and_reasoncodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_action_and_reasoncodeSoap[] toSoapModels(
		List<WFMS_action_and_reasoncode> models) {
		List<WFMS_action_and_reasoncodeSoap> soapModels = new ArrayList<WFMS_action_and_reasoncodeSoap>(models.size());

		for (WFMS_action_and_reasoncode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_action_and_reasoncodeSoap[soapModels.size()]);
	}

	public WFMS_action_and_reasoncodeSoap() {
	}

	public String getPrimaryKey() {
		return _aarId;
	}

	public void setPrimaryKey(String pk) {
		setAarId(pk);
	}

	public String getAarId() {
		return _aarId;
	}

	public void setAarId(String aarId) {
		_aarId = aarId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getReasonCode() {
		return _reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		_reasonCode = reasonCode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getDeleteflag() {
		return _deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		_deleteflag = deleteflag;
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

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _aarId;
	private String _action;
	private String _reasonCode;
	private String _description;
	private int _deleteflag;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
}