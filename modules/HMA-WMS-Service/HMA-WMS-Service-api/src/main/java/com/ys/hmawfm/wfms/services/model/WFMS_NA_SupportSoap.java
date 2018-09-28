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
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_NA_SupportServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_NA_SupportServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_NA_SupportSoap implements Serializable {
	public static WFMS_NA_SupportSoap toSoapModel(WFMS_NA_Support model) {
		WFMS_NA_SupportSoap soapModel = new WFMS_NA_SupportSoap();

		soapModel.setASSOCIATE_NUMBER(model.getASSOCIATE_NUMBER());
		soapModel.setASSOC_NO(model.getASSOC_NO());
		soapModel.setASSOCIATE_DATE_OF_HIRE(model.getASSOCIATE_DATE_OF_HIRE());
		soapModel.setASSOCIATE_NAME(model.getASSOCIATE_NAME());
		soapModel.setDEPT_NUMBER(model.getDEPT_NUMBER());
		soapModel.setDEPT_NO(model.getDEPT_NO());
		soapModel.setDEPT_NAME(model.getDEPT_NAME());
		soapModel.setASSOCIATE_TITLE(model.getASSOCIATE_TITLE());
		soapModel.setSHIFT_CODE(model.getSHIFT_CODE());
		soapModel.setTEAM_NUMBER(model.getTEAM_NUMBER());
		soapModel.setEFFDT(model.getEFFDT());
		soapModel.setTERMINATION_DT(model.getTERMINATION_DT());
		soapModel.setMANAGER_ASSOCIATE_NUMBER(model.getMANAGER_ASSOCIATE_NUMBER());
		soapModel.setASSGN_TYPE(model.getASSGN_TYPE());
		soapModel.setLEADERSHIP_ASSIGNMENT(model.getLEADERSHIP_ASSIGNMENT());
		soapModel.setEMAIL(model.getEMAIL());
		soapModel.setDeleteflag(model.getDeleteflag());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WFMS_NA_SupportSoap[] toSoapModels(WFMS_NA_Support[] models) {
		WFMS_NA_SupportSoap[] soapModels = new WFMS_NA_SupportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_NA_SupportSoap[][] toSoapModels(
		WFMS_NA_Support[][] models) {
		WFMS_NA_SupportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_NA_SupportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_NA_SupportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_NA_SupportSoap[] toSoapModels(
		List<WFMS_NA_Support> models) {
		List<WFMS_NA_SupportSoap> soapModels = new ArrayList<WFMS_NA_SupportSoap>(models.size());

		for (WFMS_NA_Support model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_NA_SupportSoap[soapModels.size()]);
	}

	public WFMS_NA_SupportSoap() {
	}

	public String getPrimaryKey() {
		return _ASSOCIATE_NUMBER;
	}

	public void setPrimaryKey(String pk) {
		setASSOCIATE_NUMBER(pk);
	}

	public String getASSOCIATE_NUMBER() {
		return _ASSOCIATE_NUMBER;
	}

	public void setASSOCIATE_NUMBER(String ASSOCIATE_NUMBER) {
		_ASSOCIATE_NUMBER = ASSOCIATE_NUMBER;
	}

	public String getASSOC_NO() {
		return _ASSOC_NO;
	}

	public void setASSOC_NO(String ASSOC_NO) {
		_ASSOC_NO = ASSOC_NO;
	}

	public String getASSOCIATE_DATE_OF_HIRE() {
		return _ASSOCIATE_DATE_OF_HIRE;
	}

	public void setASSOCIATE_DATE_OF_HIRE(String ASSOCIATE_DATE_OF_HIRE) {
		_ASSOCIATE_DATE_OF_HIRE = ASSOCIATE_DATE_OF_HIRE;
	}

	public String getASSOCIATE_NAME() {
		return _ASSOCIATE_NAME;
	}

	public void setASSOCIATE_NAME(String ASSOCIATE_NAME) {
		_ASSOCIATE_NAME = ASSOCIATE_NAME;
	}

	public String getDEPT_NUMBER() {
		return _DEPT_NUMBER;
	}

	public void setDEPT_NUMBER(String DEPT_NUMBER) {
		_DEPT_NUMBER = DEPT_NUMBER;
	}

	public int getDEPT_NO() {
		return _DEPT_NO;
	}

	public void setDEPT_NO(int DEPT_NO) {
		_DEPT_NO = DEPT_NO;
	}

	public String getDEPT_NAME() {
		return _DEPT_NAME;
	}

	public void setDEPT_NAME(String DEPT_NAME) {
		_DEPT_NAME = DEPT_NAME;
	}

	public String getASSOCIATE_TITLE() {
		return _ASSOCIATE_TITLE;
	}

	public void setASSOCIATE_TITLE(String ASSOCIATE_TITLE) {
		_ASSOCIATE_TITLE = ASSOCIATE_TITLE;
	}

	public String getSHIFT_CODE() {
		return _SHIFT_CODE;
	}

	public void setSHIFT_CODE(String SHIFT_CODE) {
		_SHIFT_CODE = SHIFT_CODE;
	}

	public String getTEAM_NUMBER() {
		return _TEAM_NUMBER;
	}

	public void setTEAM_NUMBER(String TEAM_NUMBER) {
		_TEAM_NUMBER = TEAM_NUMBER;
	}

	public String getEFFDT() {
		return _EFFDT;
	}

	public void setEFFDT(String EFFDT) {
		_EFFDT = EFFDT;
	}

	public String getTERMINATION_DT() {
		return _TERMINATION_DT;
	}

	public void setTERMINATION_DT(String TERMINATION_DT) {
		_TERMINATION_DT = TERMINATION_DT;
	}

	public int getMANAGER_ASSOCIATE_NUMBER() {
		return _MANAGER_ASSOCIATE_NUMBER;
	}

	public void setMANAGER_ASSOCIATE_NUMBER(int MANAGER_ASSOCIATE_NUMBER) {
		_MANAGER_ASSOCIATE_NUMBER = MANAGER_ASSOCIATE_NUMBER;
	}

	public String getASSGN_TYPE() {
		return _ASSGN_TYPE;
	}

	public void setASSGN_TYPE(String ASSGN_TYPE) {
		_ASSGN_TYPE = ASSGN_TYPE;
	}

	public String getLEADERSHIP_ASSIGNMENT() {
		return _LEADERSHIP_ASSIGNMENT;
	}

	public void setLEADERSHIP_ASSIGNMENT(String LEADERSHIP_ASSIGNMENT) {
		_LEADERSHIP_ASSIGNMENT = LEADERSHIP_ASSIGNMENT;
	}

	public String getEMAIL() {
		return _EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		_EMAIL = EMAIL;
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

	private String _ASSOCIATE_NUMBER;
	private String _ASSOC_NO;
	private String _ASSOCIATE_DATE_OF_HIRE;
	private String _ASSOCIATE_NAME;
	private String _DEPT_NUMBER;
	private int _DEPT_NO;
	private String _DEPT_NAME;
	private String _ASSOCIATE_TITLE;
	private String _SHIFT_CODE;
	private String _TEAM_NUMBER;
	private String _EFFDT;
	private String _TERMINATION_DT;
	private int _MANAGER_ASSOCIATE_NUMBER;
	private String _ASSGN_TYPE;
	private String _LEADERSHIP_ASSIGNMENT;
	private String _EMAIL;
	private int _deleteflag;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
}