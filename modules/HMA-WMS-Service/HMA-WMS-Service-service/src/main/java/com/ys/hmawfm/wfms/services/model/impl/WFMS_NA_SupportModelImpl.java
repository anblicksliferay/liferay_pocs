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

package com.ys.hmawfm.wfms.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_SupportModel;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_SupportSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the WFMS_NA_Support service. Represents a row in the &quot;WFMS_NA_Support&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link WFMS_NA_SupportModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WFMS_NA_SupportImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_SupportImpl
 * @see WFMS_NA_Support
 * @see WFMS_NA_SupportModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class WFMS_NA_SupportModelImpl extends BaseModelImpl<WFMS_NA_Support>
	implements WFMS_NA_SupportModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a WFMS_NA_Support model instance should use the {@link WFMS_NA_Support} interface instead.
	 */
	public static final String TABLE_NAME = "WFMS_NA_Support";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ASSOCIATE_NUMBER", Types.VARCHAR },
			{ "ASSOC_NO", Types.VARCHAR },
			{ "ASSOCIATE_DATE_OF_HIRE", Types.VARCHAR },
			{ "ASSOCIATE_NAME", Types.VARCHAR },
			{ "DEPT_NUMBER", Types.VARCHAR },
			{ "DEPT_NO", Types.INTEGER },
			{ "DEPT_NAME", Types.VARCHAR },
			{ "ASSOCIATE_TITLE", Types.VARCHAR },
			{ "SHIFT_CODE", Types.VARCHAR },
			{ "TEAM_NUMBER", Types.VARCHAR },
			{ "EFFDT", Types.VARCHAR },
			{ "TERMINATION_DT", Types.VARCHAR },
			{ "MANAGER_ASSOCIATE_NUMBER", Types.INTEGER },
			{ "ASSGN_TYPE", Types.VARCHAR },
			{ "LEADERSHIP_ASSIGNMENT", Types.VARCHAR },
			{ "EMAIL", Types.VARCHAR },
			{ "deleteflag", Types.INTEGER },
			{ "createdBy", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.VARCHAR },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ASSOCIATE_NUMBER", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ASSOC_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ASSOCIATE_DATE_OF_HIRE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ASSOCIATE_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DEPT_NUMBER", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DEPT_NO", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("DEPT_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ASSOCIATE_TITLE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SHIFT_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("TEAM_NUMBER", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("EFFDT", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("TERMINATION_DT", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MANAGER_ASSOCIATE_NUMBER", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("ASSGN_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("LEADERSHIP_ASSIGNMENT", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("EMAIL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deleteflag", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table WFMS_NA_Support (ASSOCIATE_NUMBER VARCHAR(75) not null primary key,ASSOC_NO VARCHAR(75) null,ASSOCIATE_DATE_OF_HIRE VARCHAR(75) null,ASSOCIATE_NAME VARCHAR(75) null,DEPT_NUMBER VARCHAR(75) null,DEPT_NO INTEGER,DEPT_NAME VARCHAR(75) null,ASSOCIATE_TITLE VARCHAR(75) null,SHIFT_CODE VARCHAR(75) null,TEAM_NUMBER VARCHAR(75) null,EFFDT VARCHAR(75) null,TERMINATION_DT VARCHAR(75) null,MANAGER_ASSOCIATE_NUMBER INTEGER,ASSGN_TYPE VARCHAR(75) null,LEADERSHIP_ASSIGNMENT VARCHAR(75) null,EMAIL VARCHAR(75) null,deleteflag INTEGER,createdBy VARCHAR(75) null,createDate DATE null,modifiedBy VARCHAR(75) null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table WFMS_NA_Support";
	public static final String ORDER_BY_JPQL = " ORDER BY wfms_na_Support.ASSOCIATE_NUMBER ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WFMS_NA_Support.ASSOCIATE_NUMBER ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ys.hmawfm.wfms.services.model.WFMS_NA_Support"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ys.hmawfm.wfms.services.model.WFMS_NA_Support"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ys.hmawfm.wfms.services.model.WFMS_NA_Support"),
			true);
	public static final long ASSOCIATE_NUMBER_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WFMS_NA_Support toModel(WFMS_NA_SupportSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WFMS_NA_Support model = new WFMS_NA_SupportImpl();

		model.setASSOCIATE_NUMBER(soapModel.getASSOCIATE_NUMBER());
		model.setASSOC_NO(soapModel.getASSOC_NO());
		model.setASSOCIATE_DATE_OF_HIRE(soapModel.getASSOCIATE_DATE_OF_HIRE());
		model.setASSOCIATE_NAME(soapModel.getASSOCIATE_NAME());
		model.setDEPT_NUMBER(soapModel.getDEPT_NUMBER());
		model.setDEPT_NO(soapModel.getDEPT_NO());
		model.setDEPT_NAME(soapModel.getDEPT_NAME());
		model.setASSOCIATE_TITLE(soapModel.getASSOCIATE_TITLE());
		model.setSHIFT_CODE(soapModel.getSHIFT_CODE());
		model.setTEAM_NUMBER(soapModel.getTEAM_NUMBER());
		model.setEFFDT(soapModel.getEFFDT());
		model.setTERMINATION_DT(soapModel.getTERMINATION_DT());
		model.setMANAGER_ASSOCIATE_NUMBER(soapModel.getMANAGER_ASSOCIATE_NUMBER());
		model.setASSGN_TYPE(soapModel.getASSGN_TYPE());
		model.setLEADERSHIP_ASSIGNMENT(soapModel.getLEADERSHIP_ASSIGNMENT());
		model.setEMAIL(soapModel.getEMAIL());
		model.setDeleteflag(soapModel.getDeleteflag());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedBy(soapModel.getModifiedBy());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WFMS_NA_Support> toModels(
		WFMS_NA_SupportSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WFMS_NA_Support> models = new ArrayList<WFMS_NA_Support>(soapModels.length);

		for (WFMS_NA_SupportSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"lock.expiration.time.com.ys.hmawfm.wfms.services.model.WFMS_NA_Support"));

	public WFMS_NA_SupportModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _ASSOCIATE_NUMBER;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setASSOCIATE_NUMBER(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ASSOCIATE_NUMBER;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getASSOCIATE_NUMBER() {
		if (_ASSOCIATE_NUMBER == null) {
			return StringPool.BLANK;
		}
		else {
			return _ASSOCIATE_NUMBER;
		}
	}

	@Override
	public void setASSOCIATE_NUMBER(String ASSOCIATE_NUMBER) {
		_columnBitmask |= ASSOCIATE_NUMBER_COLUMN_BITMASK;

		if (_originalASSOCIATE_NUMBER == null) {
			_originalASSOCIATE_NUMBER = _ASSOCIATE_NUMBER;
		}

		_ASSOCIATE_NUMBER = ASSOCIATE_NUMBER;
	}

	public String getOriginalASSOCIATE_NUMBER() {
		return GetterUtil.getString(_originalASSOCIATE_NUMBER);
	}

	@JSON
	@Override
	public String getASSOC_NO() {
		if (_ASSOC_NO == null) {
			return StringPool.BLANK;
		}
		else {
			return _ASSOC_NO;
		}
	}

	@Override
	public void setASSOC_NO(String ASSOC_NO) {
		_ASSOC_NO = ASSOC_NO;
	}

	@JSON
	@Override
	public String getASSOCIATE_DATE_OF_HIRE() {
		if (_ASSOCIATE_DATE_OF_HIRE == null) {
			return StringPool.BLANK;
		}
		else {
			return _ASSOCIATE_DATE_OF_HIRE;
		}
	}

	@Override
	public void setASSOCIATE_DATE_OF_HIRE(String ASSOCIATE_DATE_OF_HIRE) {
		_ASSOCIATE_DATE_OF_HIRE = ASSOCIATE_DATE_OF_HIRE;
	}

	@JSON
	@Override
	public String getASSOCIATE_NAME() {
		if (_ASSOCIATE_NAME == null) {
			return StringPool.BLANK;
		}
		else {
			return _ASSOCIATE_NAME;
		}
	}

	@Override
	public void setASSOCIATE_NAME(String ASSOCIATE_NAME) {
		_ASSOCIATE_NAME = ASSOCIATE_NAME;
	}

	@JSON
	@Override
	public String getDEPT_NUMBER() {
		if (_DEPT_NUMBER == null) {
			return StringPool.BLANK;
		}
		else {
			return _DEPT_NUMBER;
		}
	}

	@Override
	public void setDEPT_NUMBER(String DEPT_NUMBER) {
		_DEPT_NUMBER = DEPT_NUMBER;
	}

	@JSON
	@Override
	public int getDEPT_NO() {
		return _DEPT_NO;
	}

	@Override
	public void setDEPT_NO(int DEPT_NO) {
		_DEPT_NO = DEPT_NO;
	}

	@JSON
	@Override
	public String getDEPT_NAME() {
		if (_DEPT_NAME == null) {
			return StringPool.BLANK;
		}
		else {
			return _DEPT_NAME;
		}
	}

	@Override
	public void setDEPT_NAME(String DEPT_NAME) {
		_DEPT_NAME = DEPT_NAME;
	}

	@JSON
	@Override
	public String getASSOCIATE_TITLE() {
		if (_ASSOCIATE_TITLE == null) {
			return StringPool.BLANK;
		}
		else {
			return _ASSOCIATE_TITLE;
		}
	}

	@Override
	public void setASSOCIATE_TITLE(String ASSOCIATE_TITLE) {
		_ASSOCIATE_TITLE = ASSOCIATE_TITLE;
	}

	@JSON
	@Override
	public String getSHIFT_CODE() {
		if (_SHIFT_CODE == null) {
			return StringPool.BLANK;
		}
		else {
			return _SHIFT_CODE;
		}
	}

	@Override
	public void setSHIFT_CODE(String SHIFT_CODE) {
		_SHIFT_CODE = SHIFT_CODE;
	}

	@JSON
	@Override
	public String getTEAM_NUMBER() {
		if (_TEAM_NUMBER == null) {
			return StringPool.BLANK;
		}
		else {
			return _TEAM_NUMBER;
		}
	}

	@Override
	public void setTEAM_NUMBER(String TEAM_NUMBER) {
		_TEAM_NUMBER = TEAM_NUMBER;
	}

	@JSON
	@Override
	public String getEFFDT() {
		if (_EFFDT == null) {
			return StringPool.BLANK;
		}
		else {
			return _EFFDT;
		}
	}

	@Override
	public void setEFFDT(String EFFDT) {
		_EFFDT = EFFDT;
	}

	@JSON
	@Override
	public String getTERMINATION_DT() {
		if (_TERMINATION_DT == null) {
			return StringPool.BLANK;
		}
		else {
			return _TERMINATION_DT;
		}
	}

	@Override
	public void setTERMINATION_DT(String TERMINATION_DT) {
		_TERMINATION_DT = TERMINATION_DT;
	}

	@JSON
	@Override
	public int getMANAGER_ASSOCIATE_NUMBER() {
		return _MANAGER_ASSOCIATE_NUMBER;
	}

	@Override
	public void setMANAGER_ASSOCIATE_NUMBER(int MANAGER_ASSOCIATE_NUMBER) {
		_MANAGER_ASSOCIATE_NUMBER = MANAGER_ASSOCIATE_NUMBER;
	}

	@JSON
	@Override
	public String getASSGN_TYPE() {
		if (_ASSGN_TYPE == null) {
			return StringPool.BLANK;
		}
		else {
			return _ASSGN_TYPE;
		}
	}

	@Override
	public void setASSGN_TYPE(String ASSGN_TYPE) {
		_ASSGN_TYPE = ASSGN_TYPE;
	}

	@JSON
	@Override
	public String getLEADERSHIP_ASSIGNMENT() {
		if (_LEADERSHIP_ASSIGNMENT == null) {
			return StringPool.BLANK;
		}
		else {
			return _LEADERSHIP_ASSIGNMENT;
		}
	}

	@Override
	public void setLEADERSHIP_ASSIGNMENT(String LEADERSHIP_ASSIGNMENT) {
		_LEADERSHIP_ASSIGNMENT = LEADERSHIP_ASSIGNMENT;
	}

	@JSON
	@Override
	public String getEMAIL() {
		if (_EMAIL == null) {
			return StringPool.BLANK;
		}
		else {
			return _EMAIL;
		}
	}

	@Override
	public void setEMAIL(String EMAIL) {
		_EMAIL = EMAIL;
	}

	@JSON
	@Override
	public int getDeleteflag() {
		return _deleteflag;
	}

	@Override
	public void setDeleteflag(int deleteflag) {
		_deleteflag = deleteflag;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getModifiedBy() {
		if (_modifiedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _modifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public WFMS_NA_Support toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WFMS_NA_Support)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WFMS_NA_SupportImpl wfms_na_SupportImpl = new WFMS_NA_SupportImpl();

		wfms_na_SupportImpl.setASSOCIATE_NUMBER(getASSOCIATE_NUMBER());
		wfms_na_SupportImpl.setASSOC_NO(getASSOC_NO());
		wfms_na_SupportImpl.setASSOCIATE_DATE_OF_HIRE(getASSOCIATE_DATE_OF_HIRE());
		wfms_na_SupportImpl.setASSOCIATE_NAME(getASSOCIATE_NAME());
		wfms_na_SupportImpl.setDEPT_NUMBER(getDEPT_NUMBER());
		wfms_na_SupportImpl.setDEPT_NO(getDEPT_NO());
		wfms_na_SupportImpl.setDEPT_NAME(getDEPT_NAME());
		wfms_na_SupportImpl.setASSOCIATE_TITLE(getASSOCIATE_TITLE());
		wfms_na_SupportImpl.setSHIFT_CODE(getSHIFT_CODE());
		wfms_na_SupportImpl.setTEAM_NUMBER(getTEAM_NUMBER());
		wfms_na_SupportImpl.setEFFDT(getEFFDT());
		wfms_na_SupportImpl.setTERMINATION_DT(getTERMINATION_DT());
		wfms_na_SupportImpl.setMANAGER_ASSOCIATE_NUMBER(getMANAGER_ASSOCIATE_NUMBER());
		wfms_na_SupportImpl.setASSGN_TYPE(getASSGN_TYPE());
		wfms_na_SupportImpl.setLEADERSHIP_ASSIGNMENT(getLEADERSHIP_ASSIGNMENT());
		wfms_na_SupportImpl.setEMAIL(getEMAIL());
		wfms_na_SupportImpl.setDeleteflag(getDeleteflag());
		wfms_na_SupportImpl.setCreatedBy(getCreatedBy());
		wfms_na_SupportImpl.setCreateDate(getCreateDate());
		wfms_na_SupportImpl.setModifiedBy(getModifiedBy());
		wfms_na_SupportImpl.setModifiedDate(getModifiedDate());

		wfms_na_SupportImpl.resetOriginalValues();

		return wfms_na_SupportImpl;
	}

	@Override
	public int compareTo(WFMS_NA_Support wfms_na_Support) {
		String primaryKey = wfms_na_Support.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_NA_Support)) {
			return false;
		}

		WFMS_NA_Support wfms_na_Support = (WFMS_NA_Support)obj;

		String primaryKey = wfms_na_Support.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		WFMS_NA_SupportModelImpl wfms_na_SupportModelImpl = this;

		wfms_na_SupportModelImpl._originalASSOCIATE_NUMBER = wfms_na_SupportModelImpl._ASSOCIATE_NUMBER;

		wfms_na_SupportModelImpl._setModifiedDate = false;

		wfms_na_SupportModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WFMS_NA_Support> toCacheModel() {
		WFMS_NA_SupportCacheModel wfms_na_SupportCacheModel = new WFMS_NA_SupportCacheModel();

		wfms_na_SupportCacheModel.ASSOCIATE_NUMBER = getASSOCIATE_NUMBER();

		String ASSOCIATE_NUMBER = wfms_na_SupportCacheModel.ASSOCIATE_NUMBER;

		if ((ASSOCIATE_NUMBER != null) && (ASSOCIATE_NUMBER.length() == 0)) {
			wfms_na_SupportCacheModel.ASSOCIATE_NUMBER = null;
		}

		wfms_na_SupportCacheModel.ASSOC_NO = getASSOC_NO();

		String ASSOC_NO = wfms_na_SupportCacheModel.ASSOC_NO;

		if ((ASSOC_NO != null) && (ASSOC_NO.length() == 0)) {
			wfms_na_SupportCacheModel.ASSOC_NO = null;
		}

		wfms_na_SupportCacheModel.ASSOCIATE_DATE_OF_HIRE = getASSOCIATE_DATE_OF_HIRE();

		String ASSOCIATE_DATE_OF_HIRE = wfms_na_SupportCacheModel.ASSOCIATE_DATE_OF_HIRE;

		if ((ASSOCIATE_DATE_OF_HIRE != null) &&
				(ASSOCIATE_DATE_OF_HIRE.length() == 0)) {
			wfms_na_SupportCacheModel.ASSOCIATE_DATE_OF_HIRE = null;
		}

		wfms_na_SupportCacheModel.ASSOCIATE_NAME = getASSOCIATE_NAME();

		String ASSOCIATE_NAME = wfms_na_SupportCacheModel.ASSOCIATE_NAME;

		if ((ASSOCIATE_NAME != null) && (ASSOCIATE_NAME.length() == 0)) {
			wfms_na_SupportCacheModel.ASSOCIATE_NAME = null;
		}

		wfms_na_SupportCacheModel.DEPT_NUMBER = getDEPT_NUMBER();

		String DEPT_NUMBER = wfms_na_SupportCacheModel.DEPT_NUMBER;

		if ((DEPT_NUMBER != null) && (DEPT_NUMBER.length() == 0)) {
			wfms_na_SupportCacheModel.DEPT_NUMBER = null;
		}

		wfms_na_SupportCacheModel.DEPT_NO = getDEPT_NO();

		wfms_na_SupportCacheModel.DEPT_NAME = getDEPT_NAME();

		String DEPT_NAME = wfms_na_SupportCacheModel.DEPT_NAME;

		if ((DEPT_NAME != null) && (DEPT_NAME.length() == 0)) {
			wfms_na_SupportCacheModel.DEPT_NAME = null;
		}

		wfms_na_SupportCacheModel.ASSOCIATE_TITLE = getASSOCIATE_TITLE();

		String ASSOCIATE_TITLE = wfms_na_SupportCacheModel.ASSOCIATE_TITLE;

		if ((ASSOCIATE_TITLE != null) && (ASSOCIATE_TITLE.length() == 0)) {
			wfms_na_SupportCacheModel.ASSOCIATE_TITLE = null;
		}

		wfms_na_SupportCacheModel.SHIFT_CODE = getSHIFT_CODE();

		String SHIFT_CODE = wfms_na_SupportCacheModel.SHIFT_CODE;

		if ((SHIFT_CODE != null) && (SHIFT_CODE.length() == 0)) {
			wfms_na_SupportCacheModel.SHIFT_CODE = null;
		}

		wfms_na_SupportCacheModel.TEAM_NUMBER = getTEAM_NUMBER();

		String TEAM_NUMBER = wfms_na_SupportCacheModel.TEAM_NUMBER;

		if ((TEAM_NUMBER != null) && (TEAM_NUMBER.length() == 0)) {
			wfms_na_SupportCacheModel.TEAM_NUMBER = null;
		}

		wfms_na_SupportCacheModel.EFFDT = getEFFDT();

		String EFFDT = wfms_na_SupportCacheModel.EFFDT;

		if ((EFFDT != null) && (EFFDT.length() == 0)) {
			wfms_na_SupportCacheModel.EFFDT = null;
		}

		wfms_na_SupportCacheModel.TERMINATION_DT = getTERMINATION_DT();

		String TERMINATION_DT = wfms_na_SupportCacheModel.TERMINATION_DT;

		if ((TERMINATION_DT != null) && (TERMINATION_DT.length() == 0)) {
			wfms_na_SupportCacheModel.TERMINATION_DT = null;
		}

		wfms_na_SupportCacheModel.MANAGER_ASSOCIATE_NUMBER = getMANAGER_ASSOCIATE_NUMBER();

		wfms_na_SupportCacheModel.ASSGN_TYPE = getASSGN_TYPE();

		String ASSGN_TYPE = wfms_na_SupportCacheModel.ASSGN_TYPE;

		if ((ASSGN_TYPE != null) && (ASSGN_TYPE.length() == 0)) {
			wfms_na_SupportCacheModel.ASSGN_TYPE = null;
		}

		wfms_na_SupportCacheModel.LEADERSHIP_ASSIGNMENT = getLEADERSHIP_ASSIGNMENT();

		String LEADERSHIP_ASSIGNMENT = wfms_na_SupportCacheModel.LEADERSHIP_ASSIGNMENT;

		if ((LEADERSHIP_ASSIGNMENT != null) &&
				(LEADERSHIP_ASSIGNMENT.length() == 0)) {
			wfms_na_SupportCacheModel.LEADERSHIP_ASSIGNMENT = null;
		}

		wfms_na_SupportCacheModel.EMAIL = getEMAIL();

		String EMAIL = wfms_na_SupportCacheModel.EMAIL;

		if ((EMAIL != null) && (EMAIL.length() == 0)) {
			wfms_na_SupportCacheModel.EMAIL = null;
		}

		wfms_na_SupportCacheModel.deleteflag = getDeleteflag();

		wfms_na_SupportCacheModel.createdBy = getCreatedBy();

		String createdBy = wfms_na_SupportCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			wfms_na_SupportCacheModel.createdBy = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			wfms_na_SupportCacheModel.createDate = createDate.getTime();
		}
		else {
			wfms_na_SupportCacheModel.createDate = Long.MIN_VALUE;
		}

		wfms_na_SupportCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = wfms_na_SupportCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			wfms_na_SupportCacheModel.modifiedBy = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wfms_na_SupportCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wfms_na_SupportCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return wfms_na_SupportCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{ASSOCIATE_NUMBER=");
		sb.append(getASSOCIATE_NUMBER());
		sb.append(", ASSOC_NO=");
		sb.append(getASSOC_NO());
		sb.append(", ASSOCIATE_DATE_OF_HIRE=");
		sb.append(getASSOCIATE_DATE_OF_HIRE());
		sb.append(", ASSOCIATE_NAME=");
		sb.append(getASSOCIATE_NAME());
		sb.append(", DEPT_NUMBER=");
		sb.append(getDEPT_NUMBER());
		sb.append(", DEPT_NO=");
		sb.append(getDEPT_NO());
		sb.append(", DEPT_NAME=");
		sb.append(getDEPT_NAME());
		sb.append(", ASSOCIATE_TITLE=");
		sb.append(getASSOCIATE_TITLE());
		sb.append(", SHIFT_CODE=");
		sb.append(getSHIFT_CODE());
		sb.append(", TEAM_NUMBER=");
		sb.append(getTEAM_NUMBER());
		sb.append(", EFFDT=");
		sb.append(getEFFDT());
		sb.append(", TERMINATION_DT=");
		sb.append(getTERMINATION_DT());
		sb.append(", MANAGER_ASSOCIATE_NUMBER=");
		sb.append(getMANAGER_ASSOCIATE_NUMBER());
		sb.append(", ASSGN_TYPE=");
		sb.append(getASSGN_TYPE());
		sb.append(", LEADERSHIP_ASSIGNMENT=");
		sb.append(getLEADERSHIP_ASSIGNMENT());
		sb.append(", EMAIL=");
		sb.append(getEMAIL());
		sb.append(", deleteflag=");
		sb.append(getDeleteflag());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.ys.hmawfm.wfms.services.model.WFMS_NA_Support");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ASSOCIATE_NUMBER</column-name><column-value><![CDATA[");
		sb.append(getASSOCIATE_NUMBER());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ASSOC_NO</column-name><column-value><![CDATA[");
		sb.append(getASSOC_NO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ASSOCIATE_DATE_OF_HIRE</column-name><column-value><![CDATA[");
		sb.append(getASSOCIATE_DATE_OF_HIRE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ASSOCIATE_NAME</column-name><column-value><![CDATA[");
		sb.append(getASSOCIATE_NAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DEPT_NUMBER</column-name><column-value><![CDATA[");
		sb.append(getDEPT_NUMBER());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DEPT_NO</column-name><column-value><![CDATA[");
		sb.append(getDEPT_NO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DEPT_NAME</column-name><column-value><![CDATA[");
		sb.append(getDEPT_NAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ASSOCIATE_TITLE</column-name><column-value><![CDATA[");
		sb.append(getASSOCIATE_TITLE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SHIFT_CODE</column-name><column-value><![CDATA[");
		sb.append(getSHIFT_CODE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TEAM_NUMBER</column-name><column-value><![CDATA[");
		sb.append(getTEAM_NUMBER());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EFFDT</column-name><column-value><![CDATA[");
		sb.append(getEFFDT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TERMINATION_DT</column-name><column-value><![CDATA[");
		sb.append(getTERMINATION_DT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MANAGER_ASSOCIATE_NUMBER</column-name><column-value><![CDATA[");
		sb.append(getMANAGER_ASSOCIATE_NUMBER());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ASSGN_TYPE</column-name><column-value><![CDATA[");
		sb.append(getASSGN_TYPE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LEADERSHIP_ASSIGNMENT</column-name><column-value><![CDATA[");
		sb.append(getLEADERSHIP_ASSIGNMENT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EMAIL</column-name><column-value><![CDATA[");
		sb.append(getEMAIL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleteflag</column-name><column-value><![CDATA[");
		sb.append(getDeleteflag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = WFMS_NA_Support.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			WFMS_NA_Support.class
		};
	private String _ASSOCIATE_NUMBER;
	private String _originalASSOCIATE_NUMBER;
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
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private WFMS_NA_Support _escapedModel;
}