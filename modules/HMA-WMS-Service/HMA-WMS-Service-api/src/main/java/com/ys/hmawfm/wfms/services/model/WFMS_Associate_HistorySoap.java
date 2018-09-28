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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_Associate_HistoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_Associate_HistoryServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_Associate_HistorySoap implements Serializable {
	public static WFMS_Associate_HistorySoap toSoapModel(
		WFMS_Associate_History model) {
		WFMS_Associate_HistorySoap soapModel = new WFMS_Associate_HistorySoap();

		soapModel.setAssocHistoryId(model.getAssocHistoryId());
		soapModel.setAssociateId(model.getAssociateId());
		soapModel.setAssociateName(model.getAssociateName());
		soapModel.setCurrentPosition(model.getCurrentPosition());
		soapModel.setHistory(model.getHistory());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static WFMS_Associate_HistorySoap[] toSoapModels(
		WFMS_Associate_History[] models) {
		WFMS_Associate_HistorySoap[] soapModels = new WFMS_Associate_HistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_Associate_HistorySoap[][] toSoapModels(
		WFMS_Associate_History[][] models) {
		WFMS_Associate_HistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_Associate_HistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_Associate_HistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_Associate_HistorySoap[] toSoapModels(
		List<WFMS_Associate_History> models) {
		List<WFMS_Associate_HistorySoap> soapModels = new ArrayList<WFMS_Associate_HistorySoap>(models.size());

		for (WFMS_Associate_History model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_Associate_HistorySoap[soapModels.size()]);
	}

	public WFMS_Associate_HistorySoap() {
	}

	public int getPrimaryKey() {
		return _assocHistoryId;
	}

	public void setPrimaryKey(int pk) {
		setAssocHistoryId(pk);
	}

	public int getAssocHistoryId() {
		return _assocHistoryId;
	}

	public void setAssocHistoryId(int assocHistoryId) {
		_assocHistoryId = assocHistoryId;
	}

	public String getAssociateId() {
		return _associateId;
	}

	public void setAssociateId(String associateId) {
		_associateId = associateId;
	}

	public String getAssociateName() {
		return _associateName;
	}

	public void setAssociateName(String associateName) {
		_associateName = associateName;
	}

	public String getCurrentPosition() {
		return _currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		_currentPosition = currentPosition;
	}

	public String getHistory() {
		return _history;
	}

	public void setHistory(String history) {
		_history = history;
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

	private int _assocHistoryId;
	private String _associateId;
	private String _associateName;
	private String _currentPosition;
	private String _history;
	private String _createdBy;
	private Date _createDate;
}