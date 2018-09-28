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
public class WFMS_routing_and_approversSoap implements Serializable {
	public static WFMS_routing_and_approversSoap toSoapModel(
		WFMS_routing_and_approvers model) {
		WFMS_routing_and_approversSoap soapModel = new WFMS_routing_and_approversSoap();

		soapModel.setRapId(model.getRapId());
		soapModel.setAction(model.getAction());
		soapModel.setChangeDescription(model.getChangeDescription());
		soapModel.setCurrentJobCodeORLeadership(model.getCurrentJobCodeORLeadership());
		soapModel.setNewJobCodeORLeadership(model.getNewJobCodeORLeadership());
		soapModel.setSameJobCode(model.getSameJobCode());
		soapModel.setSameLeadership(model.getSameLeadership());
		soapModel.setIsSameDept(model.getIsSameDept());
		soapModel.setIsSameMgr(model.getIsSameMgr());
		soapModel.setRoutingProcess(model.getRoutingProcess());
		soapModel.setNotificationTo(model.getNotificationTo());
		soapModel.setDeleteflag(model.getDeleteflag());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WFMS_routing_and_approversSoap[] toSoapModels(
		WFMS_routing_and_approvers[] models) {
		WFMS_routing_and_approversSoap[] soapModels = new WFMS_routing_and_approversSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_routing_and_approversSoap[][] toSoapModels(
		WFMS_routing_and_approvers[][] models) {
		WFMS_routing_and_approversSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_routing_and_approversSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_routing_and_approversSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_routing_and_approversSoap[] toSoapModels(
		List<WFMS_routing_and_approvers> models) {
		List<WFMS_routing_and_approversSoap> soapModels = new ArrayList<WFMS_routing_and_approversSoap>(models.size());

		for (WFMS_routing_and_approvers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_routing_and_approversSoap[soapModels.size()]);
	}

	public WFMS_routing_and_approversSoap() {
	}

	public String getPrimaryKey() {
		return _rapId;
	}

	public void setPrimaryKey(String pk) {
		setRapId(pk);
	}

	public String getRapId() {
		return _rapId;
	}

	public void setRapId(String rapId) {
		_rapId = rapId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getChangeDescription() {
		return _changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		_changeDescription = changeDescription;
	}

	public String getCurrentJobCodeORLeadership() {
		return _currentJobCodeORLeadership;
	}

	public void setCurrentJobCodeORLeadership(String currentJobCodeORLeadership) {
		_currentJobCodeORLeadership = currentJobCodeORLeadership;
	}

	public String getNewJobCodeORLeadership() {
		return _newJobCodeORLeadership;
	}

	public void setNewJobCodeORLeadership(String newJobCodeORLeadership) {
		_newJobCodeORLeadership = newJobCodeORLeadership;
	}

	public String getSameJobCode() {
		return _SameJobCode;
	}

	public void setSameJobCode(String SameJobCode) {
		_SameJobCode = SameJobCode;
	}

	public String getSameLeadership() {
		return _SameLeadership;
	}

	public void setSameLeadership(String SameLeadership) {
		_SameLeadership = SameLeadership;
	}

	public String getIsSameDept() {
		return _isSameDept;
	}

	public void setIsSameDept(String isSameDept) {
		_isSameDept = isSameDept;
	}

	public String getIsSameMgr() {
		return _isSameMgr;
	}

	public void setIsSameMgr(String isSameMgr) {
		_isSameMgr = isSameMgr;
	}

	public String getRoutingProcess() {
		return _routingProcess;
	}

	public void setRoutingProcess(String routingProcess) {
		_routingProcess = routingProcess;
	}

	public String getNotificationTo() {
		return _notificationTo;
	}

	public void setNotificationTo(String notificationTo) {
		_notificationTo = notificationTo;
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

	private String _rapId;
	private String _action;
	private String _changeDescription;
	private String _currentJobCodeORLeadership;
	private String _newJobCodeORLeadership;
	private String _SameJobCode;
	private String _SameLeadership;
	private String _isSameDept;
	private String _isSameMgr;
	private String _routingProcess;
	private String _notificationTo;
	private int _deleteflag;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
}