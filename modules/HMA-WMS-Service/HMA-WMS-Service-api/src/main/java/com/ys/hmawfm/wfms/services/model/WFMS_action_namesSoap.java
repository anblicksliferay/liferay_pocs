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
public class WFMS_action_namesSoap implements Serializable {
	public static WFMS_action_namesSoap toSoapModel(WFMS_action_names model) {
		WFMS_action_namesSoap soapModel = new WFMS_action_namesSoap();

		soapModel.setActionId(model.getActionId());
		soapModel.setActionName(model.getActionName());
		soapModel.setDeleteflag(model.getDeleteflag());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WFMS_action_namesSoap[] toSoapModels(
		WFMS_action_names[] models) {
		WFMS_action_namesSoap[] soapModels = new WFMS_action_namesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_action_namesSoap[][] toSoapModels(
		WFMS_action_names[][] models) {
		WFMS_action_namesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_action_namesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_action_namesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_action_namesSoap[] toSoapModels(
		List<WFMS_action_names> models) {
		List<WFMS_action_namesSoap> soapModels = new ArrayList<WFMS_action_namesSoap>(models.size());

		for (WFMS_action_names model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_action_namesSoap[soapModels.size()]);
	}

	public WFMS_action_namesSoap() {
	}

	public String getPrimaryKey() {
		return _actionId;
	}

	public void setPrimaryKey(String pk) {
		setActionId(pk);
	}

	public String getActionId() {
		return _actionId;
	}

	public void setActionId(String actionId) {
		_actionId = actionId;
	}

	public String getActionName() {
		return _actionName;
	}

	public void setActionName(String actionName) {
		_actionName = actionName;
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

	private String _actionId;
	private String _actionName;
	private int _deleteflag;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
}