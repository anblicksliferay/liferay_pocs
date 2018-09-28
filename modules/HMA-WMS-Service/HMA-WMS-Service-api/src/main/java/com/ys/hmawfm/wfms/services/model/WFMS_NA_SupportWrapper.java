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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WFMS_NA_Support}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_Support
 * @generated
 */
@ProviderType
public class WFMS_NA_SupportWrapper implements WFMS_NA_Support,
	ModelWrapper<WFMS_NA_Support> {
	public WFMS_NA_SupportWrapper(WFMS_NA_Support wfms_na_Support) {
		_wfms_na_Support = wfms_na_Support;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_NA_Support.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_NA_Support.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ASSOCIATE_NUMBER", getASSOCIATE_NUMBER());
		attributes.put("ASSOC_NO", getASSOC_NO());
		attributes.put("ASSOCIATE_DATE_OF_HIRE", getASSOCIATE_DATE_OF_HIRE());
		attributes.put("ASSOCIATE_NAME", getASSOCIATE_NAME());
		attributes.put("DEPT_NUMBER", getDEPT_NUMBER());
		attributes.put("DEPT_NO", getDEPT_NO());
		attributes.put("DEPT_NAME", getDEPT_NAME());
		attributes.put("ASSOCIATE_TITLE", getASSOCIATE_TITLE());
		attributes.put("SHIFT_CODE", getSHIFT_CODE());
		attributes.put("TEAM_NUMBER", getTEAM_NUMBER());
		attributes.put("EFFDT", getEFFDT());
		attributes.put("TERMINATION_DT", getTERMINATION_DT());
		attributes.put("MANAGER_ASSOCIATE_NUMBER", getMANAGER_ASSOCIATE_NUMBER());
		attributes.put("ASSGN_TYPE", getASSGN_TYPE());
		attributes.put("LEADERSHIP_ASSIGNMENT", getLEADERSHIP_ASSIGNMENT());
		attributes.put("EMAIL", getEMAIL());
		attributes.put("deleteflag", getDeleteflag());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String ASSOCIATE_NUMBER = (String)attributes.get("ASSOCIATE_NUMBER");

		if (ASSOCIATE_NUMBER != null) {
			setASSOCIATE_NUMBER(ASSOCIATE_NUMBER);
		}

		String ASSOC_NO = (String)attributes.get("ASSOC_NO");

		if (ASSOC_NO != null) {
			setASSOC_NO(ASSOC_NO);
		}

		String ASSOCIATE_DATE_OF_HIRE = (String)attributes.get(
				"ASSOCIATE_DATE_OF_HIRE");

		if (ASSOCIATE_DATE_OF_HIRE != null) {
			setASSOCIATE_DATE_OF_HIRE(ASSOCIATE_DATE_OF_HIRE);
		}

		String ASSOCIATE_NAME = (String)attributes.get("ASSOCIATE_NAME");

		if (ASSOCIATE_NAME != null) {
			setASSOCIATE_NAME(ASSOCIATE_NAME);
		}

		String DEPT_NUMBER = (String)attributes.get("DEPT_NUMBER");

		if (DEPT_NUMBER != null) {
			setDEPT_NUMBER(DEPT_NUMBER);
		}

		Integer DEPT_NO = (Integer)attributes.get("DEPT_NO");

		if (DEPT_NO != null) {
			setDEPT_NO(DEPT_NO);
		}

		String DEPT_NAME = (String)attributes.get("DEPT_NAME");

		if (DEPT_NAME != null) {
			setDEPT_NAME(DEPT_NAME);
		}

		String ASSOCIATE_TITLE = (String)attributes.get("ASSOCIATE_TITLE");

		if (ASSOCIATE_TITLE != null) {
			setASSOCIATE_TITLE(ASSOCIATE_TITLE);
		}

		String SHIFT_CODE = (String)attributes.get("SHIFT_CODE");

		if (SHIFT_CODE != null) {
			setSHIFT_CODE(SHIFT_CODE);
		}

		String TEAM_NUMBER = (String)attributes.get("TEAM_NUMBER");

		if (TEAM_NUMBER != null) {
			setTEAM_NUMBER(TEAM_NUMBER);
		}

		String EFFDT = (String)attributes.get("EFFDT");

		if (EFFDT != null) {
			setEFFDT(EFFDT);
		}

		String TERMINATION_DT = (String)attributes.get("TERMINATION_DT");

		if (TERMINATION_DT != null) {
			setTERMINATION_DT(TERMINATION_DT);
		}

		Integer MANAGER_ASSOCIATE_NUMBER = (Integer)attributes.get(
				"MANAGER_ASSOCIATE_NUMBER");

		if (MANAGER_ASSOCIATE_NUMBER != null) {
			setMANAGER_ASSOCIATE_NUMBER(MANAGER_ASSOCIATE_NUMBER);
		}

		String ASSGN_TYPE = (String)attributes.get("ASSGN_TYPE");

		if (ASSGN_TYPE != null) {
			setASSGN_TYPE(ASSGN_TYPE);
		}

		String LEADERSHIP_ASSIGNMENT = (String)attributes.get(
				"LEADERSHIP_ASSIGNMENT");

		if (LEADERSHIP_ASSIGNMENT != null) {
			setLEADERSHIP_ASSIGNMENT(LEADERSHIP_ASSIGNMENT);
		}

		String EMAIL = (String)attributes.get("EMAIL");

		if (EMAIL != null) {
			setEMAIL(EMAIL);
		}

		Integer deleteflag = (Integer)attributes.get("deleteflag");

		if (deleteflag != null) {
			setDeleteflag(deleteflag);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public WFMS_NA_Support toEscapedModel() {
		return new WFMS_NA_SupportWrapper(_wfms_na_Support.toEscapedModel());
	}

	@Override
	public WFMS_NA_Support toUnescapedModel() {
		return new WFMS_NA_SupportWrapper(_wfms_na_Support.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_na_Support.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_na_Support.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_na_Support.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_na_Support.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_NA_Support> toCacheModel() {
		return _wfms_na_Support.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_NA_Support wfms_na_Support) {
		return _wfms_na_Support.compareTo(wfms_na_Support);
	}

	/**
	* Returns the dept_no of this WFMS_NA_Support.
	*
	* @return the dept_no of this WFMS_NA_Support
	*/
	@Override
	public int getDEPT_NO() {
		return _wfms_na_Support.getDEPT_NO();
	}

	/**
	* Returns the deleteflag of this WFMS_NA_Support.
	*
	* @return the deleteflag of this WFMS_NA_Support
	*/
	@Override
	public int getDeleteflag() {
		return _wfms_na_Support.getDeleteflag();
	}

	/**
	* Returns the manager_associate_number of this WFMS_NA_Support.
	*
	* @return the manager_associate_number of this WFMS_NA_Support
	*/
	@Override
	public int getMANAGER_ASSOCIATE_NUMBER() {
		return _wfms_na_Support.getMANAGER_ASSOCIATE_NUMBER();
	}

	@Override
	public int hashCode() {
		return _wfms_na_Support.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_na_Support.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_NA_SupportWrapper((WFMS_NA_Support)_wfms_na_Support.clone());
	}

	/**
	* Returns the assgn_type of this WFMS_NA_Support.
	*
	* @return the assgn_type of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getASSGN_TYPE() {
		return _wfms_na_Support.getASSGN_TYPE();
	}

	/**
	* Returns the associate_date_of_hire of this WFMS_NA_Support.
	*
	* @return the associate_date_of_hire of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getASSOCIATE_DATE_OF_HIRE() {
		return _wfms_na_Support.getASSOCIATE_DATE_OF_HIRE();
	}

	/**
	* Returns the associate_name of this WFMS_NA_Support.
	*
	* @return the associate_name of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getASSOCIATE_NAME() {
		return _wfms_na_Support.getASSOCIATE_NAME();
	}

	/**
	* Returns the associate_number of this WFMS_NA_Support.
	*
	* @return the associate_number of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getASSOCIATE_NUMBER() {
		return _wfms_na_Support.getASSOCIATE_NUMBER();
	}

	/**
	* Returns the associate_title of this WFMS_NA_Support.
	*
	* @return the associate_title of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getASSOCIATE_TITLE() {
		return _wfms_na_Support.getASSOCIATE_TITLE();
	}

	/**
	* Returns the assoc_no of this WFMS_NA_Support.
	*
	* @return the assoc_no of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getASSOC_NO() {
		return _wfms_na_Support.getASSOC_NO();
	}

	/**
	* Returns the created by of this WFMS_NA_Support.
	*
	* @return the created by of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_na_Support.getCreatedBy();
	}

	/**
	* Returns the dept_name of this WFMS_NA_Support.
	*
	* @return the dept_name of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getDEPT_NAME() {
		return _wfms_na_Support.getDEPT_NAME();
	}

	/**
	* Returns the dept_number of this WFMS_NA_Support.
	*
	* @return the dept_number of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getDEPT_NUMBER() {
		return _wfms_na_Support.getDEPT_NUMBER();
	}

	/**
	* Returns the effdt of this WFMS_NA_Support.
	*
	* @return the effdt of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getEFFDT() {
		return _wfms_na_Support.getEFFDT();
	}

	/**
	* Returns the email of this WFMS_NA_Support.
	*
	* @return the email of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getEMAIL() {
		return _wfms_na_Support.getEMAIL();
	}

	/**
	* Returns the leadership_assignment of this WFMS_NA_Support.
	*
	* @return the leadership_assignment of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getLEADERSHIP_ASSIGNMENT() {
		return _wfms_na_Support.getLEADERSHIP_ASSIGNMENT();
	}

	/**
	* Returns the modified by of this WFMS_NA_Support.
	*
	* @return the modified by of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_na_Support.getModifiedBy();
	}

	/**
	* Returns the primary key of this WFMS_NA_Support.
	*
	* @return the primary key of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_na_Support.getPrimaryKey();
	}

	/**
	* Returns the shift_code of this WFMS_NA_Support.
	*
	* @return the shift_code of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getSHIFT_CODE() {
		return _wfms_na_Support.getSHIFT_CODE();
	}

	/**
	* Returns the team_number of this WFMS_NA_Support.
	*
	* @return the team_number of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getTEAM_NUMBER() {
		return _wfms_na_Support.getTEAM_NUMBER();
	}

	/**
	* Returns the termination_dt of this WFMS_NA_Support.
	*
	* @return the termination_dt of this WFMS_NA_Support
	*/
	@Override
	public java.lang.String getTERMINATION_DT() {
		return _wfms_na_Support.getTERMINATION_DT();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_na_Support.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_na_Support.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_NA_Support.
	*
	* @return the create date of this WFMS_NA_Support
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_na_Support.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_NA_Support.
	*
	* @return the modified date of this WFMS_NA_Support
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_na_Support.getModifiedDate();
	}

	@Override
	public void persist() {
		_wfms_na_Support.persist();
	}

	/**
	* Sets the assgn_type of this WFMS_NA_Support.
	*
	* @param ASSGN_TYPE the assgn_type of this WFMS_NA_Support
	*/
	@Override
	public void setASSGN_TYPE(java.lang.String ASSGN_TYPE) {
		_wfms_na_Support.setASSGN_TYPE(ASSGN_TYPE);
	}

	/**
	* Sets the associate_date_of_hire of this WFMS_NA_Support.
	*
	* @param ASSOCIATE_DATE_OF_HIRE the associate_date_of_hire of this WFMS_NA_Support
	*/
	@Override
	public void setASSOCIATE_DATE_OF_HIRE(
		java.lang.String ASSOCIATE_DATE_OF_HIRE) {
		_wfms_na_Support.setASSOCIATE_DATE_OF_HIRE(ASSOCIATE_DATE_OF_HIRE);
	}

	/**
	* Sets the associate_name of this WFMS_NA_Support.
	*
	* @param ASSOCIATE_NAME the associate_name of this WFMS_NA_Support
	*/
	@Override
	public void setASSOCIATE_NAME(java.lang.String ASSOCIATE_NAME) {
		_wfms_na_Support.setASSOCIATE_NAME(ASSOCIATE_NAME);
	}

	/**
	* Sets the associate_number of this WFMS_NA_Support.
	*
	* @param ASSOCIATE_NUMBER the associate_number of this WFMS_NA_Support
	*/
	@Override
	public void setASSOCIATE_NUMBER(java.lang.String ASSOCIATE_NUMBER) {
		_wfms_na_Support.setASSOCIATE_NUMBER(ASSOCIATE_NUMBER);
	}

	/**
	* Sets the associate_title of this WFMS_NA_Support.
	*
	* @param ASSOCIATE_TITLE the associate_title of this WFMS_NA_Support
	*/
	@Override
	public void setASSOCIATE_TITLE(java.lang.String ASSOCIATE_TITLE) {
		_wfms_na_Support.setASSOCIATE_TITLE(ASSOCIATE_TITLE);
	}

	/**
	* Sets the assoc_no of this WFMS_NA_Support.
	*
	* @param ASSOC_NO the assoc_no of this WFMS_NA_Support
	*/
	@Override
	public void setASSOC_NO(java.lang.String ASSOC_NO) {
		_wfms_na_Support.setASSOC_NO(ASSOC_NO);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_na_Support.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this WFMS_NA_Support.
	*
	* @param createDate the create date of this WFMS_NA_Support
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_na_Support.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_NA_Support.
	*
	* @param createdBy the created by of this WFMS_NA_Support
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_na_Support.setCreatedBy(createdBy);
	}

	/**
	* Sets the dept_name of this WFMS_NA_Support.
	*
	* @param DEPT_NAME the dept_name of this WFMS_NA_Support
	*/
	@Override
	public void setDEPT_NAME(java.lang.String DEPT_NAME) {
		_wfms_na_Support.setDEPT_NAME(DEPT_NAME);
	}

	/**
	* Sets the dept_no of this WFMS_NA_Support.
	*
	* @param DEPT_NO the dept_no of this WFMS_NA_Support
	*/
	@Override
	public void setDEPT_NO(int DEPT_NO) {
		_wfms_na_Support.setDEPT_NO(DEPT_NO);
	}

	/**
	* Sets the dept_number of this WFMS_NA_Support.
	*
	* @param DEPT_NUMBER the dept_number of this WFMS_NA_Support
	*/
	@Override
	public void setDEPT_NUMBER(java.lang.String DEPT_NUMBER) {
		_wfms_na_Support.setDEPT_NUMBER(DEPT_NUMBER);
	}

	/**
	* Sets the deleteflag of this WFMS_NA_Support.
	*
	* @param deleteflag the deleteflag of this WFMS_NA_Support
	*/
	@Override
	public void setDeleteflag(int deleteflag) {
		_wfms_na_Support.setDeleteflag(deleteflag);
	}

	/**
	* Sets the effdt of this WFMS_NA_Support.
	*
	* @param EFFDT the effdt of this WFMS_NA_Support
	*/
	@Override
	public void setEFFDT(java.lang.String EFFDT) {
		_wfms_na_Support.setEFFDT(EFFDT);
	}

	/**
	* Sets the email of this WFMS_NA_Support.
	*
	* @param EMAIL the email of this WFMS_NA_Support
	*/
	@Override
	public void setEMAIL(java.lang.String EMAIL) {
		_wfms_na_Support.setEMAIL(EMAIL);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_na_Support.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_na_Support.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_na_Support.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the leadership_assignment of this WFMS_NA_Support.
	*
	* @param LEADERSHIP_ASSIGNMENT the leadership_assignment of this WFMS_NA_Support
	*/
	@Override
	public void setLEADERSHIP_ASSIGNMENT(java.lang.String LEADERSHIP_ASSIGNMENT) {
		_wfms_na_Support.setLEADERSHIP_ASSIGNMENT(LEADERSHIP_ASSIGNMENT);
	}

	/**
	* Sets the manager_associate_number of this WFMS_NA_Support.
	*
	* @param MANAGER_ASSOCIATE_NUMBER the manager_associate_number of this WFMS_NA_Support
	*/
	@Override
	public void setMANAGER_ASSOCIATE_NUMBER(int MANAGER_ASSOCIATE_NUMBER) {
		_wfms_na_Support.setMANAGER_ASSOCIATE_NUMBER(MANAGER_ASSOCIATE_NUMBER);
	}

	/**
	* Sets the modified by of this WFMS_NA_Support.
	*
	* @param modifiedBy the modified by of this WFMS_NA_Support
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_na_Support.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_NA_Support.
	*
	* @param modifiedDate the modified date of this WFMS_NA_Support
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_na_Support.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_na_Support.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_NA_Support.
	*
	* @param primaryKey the primary key of this WFMS_NA_Support
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_na_Support.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_na_Support.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the shift_code of this WFMS_NA_Support.
	*
	* @param SHIFT_CODE the shift_code of this WFMS_NA_Support
	*/
	@Override
	public void setSHIFT_CODE(java.lang.String SHIFT_CODE) {
		_wfms_na_Support.setSHIFT_CODE(SHIFT_CODE);
	}

	/**
	* Sets the team_number of this WFMS_NA_Support.
	*
	* @param TEAM_NUMBER the team_number of this WFMS_NA_Support
	*/
	@Override
	public void setTEAM_NUMBER(java.lang.String TEAM_NUMBER) {
		_wfms_na_Support.setTEAM_NUMBER(TEAM_NUMBER);
	}

	/**
	* Sets the termination_dt of this WFMS_NA_Support.
	*
	* @param TERMINATION_DT the termination_dt of this WFMS_NA_Support
	*/
	@Override
	public void setTERMINATION_DT(java.lang.String TERMINATION_DT) {
		_wfms_na_Support.setTERMINATION_DT(TERMINATION_DT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_NA_SupportWrapper)) {
			return false;
		}

		WFMS_NA_SupportWrapper wfms_na_SupportWrapper = (WFMS_NA_SupportWrapper)obj;

		if (Objects.equals(_wfms_na_Support,
					wfms_na_SupportWrapper._wfms_na_Support)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_NA_Support getWrappedModel() {
		return _wfms_na_Support;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_na_Support.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_na_Support.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_na_Support.resetOriginalValues();
	}

	private final WFMS_NA_Support _wfms_na_Support;
}