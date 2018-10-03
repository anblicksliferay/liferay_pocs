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

package com.astra.anblicks.pdca.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.kpiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.kpiServiceSoap
 * @generated
 */
@ProviderType
public class kpiSoap implements Serializable {
	public static kpiSoap toSoapModel(kpi model) {
		kpiSoap soapModel = new kpiSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setKpiId(model.getKpiId());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setTipe(model.getTipe());
		soapModel.setWeight(model.getWeight());
		soapModel.setTarget(model.getTarget());
		soapModel.setYear(model.getYear());
		soapModel.setUnit(model.getUnit());
		soapModel.setAchivementFormula(model.getAchivementFormula());
		soapModel.setItemDescription(model.getItemDescription());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static kpiSoap[] toSoapModels(kpi[] models) {
		kpiSoap[] soapModels = new kpiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static kpiSoap[][] toSoapModels(kpi[][] models) {
		kpiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new kpiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new kpiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static kpiSoap[] toSoapModels(List<kpi> models) {
		List<kpiSoap> soapModels = new ArrayList<kpiSoap>(models.size());

		for (kpi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new kpiSoap[soapModels.size()]);
	}

	public kpiSoap() {
	}

	public long getPrimaryKey() {
		return _kpiId;
	}

	public void setPrimaryKey(long pk) {
		setKpiId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getKpiId() {
		return _kpiId;
	}

	public void setKpiId(long kpiId) {
		_kpiId = kpiId;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getTipe() {
		return _tipe;
	}

	public void setTipe(String tipe) {
		_tipe = tipe;
	}

	public String getWeight() {
		return _weight;
	}

	public void setWeight(String weight) {
		_weight = weight;
	}

	public String getTarget() {
		return _target;
	}

	public void setTarget(String target) {
		_target = target;
	}

	public String getYear() {
		return _year;
	}

	public void setYear(String year) {
		_year = year;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public String getAchivementFormula() {
		return _achivementFormula;
	}

	public void setAchivementFormula(String achivementFormula) {
		_achivementFormula = achivementFormula;
	}

	public String getItemDescription() {
		return _itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		_itemDescription = itemDescription;
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
	private long _kpiId;
	private String _companyName;
	private String _tipe;
	private String _weight;
	private String _target;
	private String _year;
	private String _unit;
	private String _achivementFormula;
	private String _itemDescription;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}