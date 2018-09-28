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

package com.all.ddtiservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.all.ddtiservice.model.registrationDetails;
import com.all.ddtiservice.model.registrationDetailsModel;
import com.all.ddtiservice.model.registrationDetailsSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the registrationDetails service. Represents a row in the &quot;DDTI_registrationDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link registrationDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link registrationDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsImpl
 * @see registrationDetails
 * @see registrationDetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class registrationDetailsModelImpl extends BaseModelImpl<registrationDetails>
	implements registrationDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a registration details model instance should use the {@link registrationDetails} interface instead.
	 */
	public static final String TABLE_NAME = "DDTI_registrationDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "registrationId", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "surName", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "contactNumber", Types.BIGINT },
			{ "gender", Types.BOOLEAN },
			{ "imagepath", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("registrationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("surName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("gender", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("imagepath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table DDTI_registrationDetails (uuid_ VARCHAR(75) null,registrationId LONG not null primary key,firstName VARCHAR(75) null,lastName VARCHAR(75) null,surName VARCHAR(75) null,address VARCHAR(75) null,contactNumber LONG,gender BOOLEAN,imagepath VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table DDTI_registrationDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY registrationDetails.registrationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DDTI_registrationDetails.registrationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.all.ddtiservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.all.ddtiservice.model.registrationDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.all.ddtiservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.all.ddtiservice.model.registrationDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.all.ddtiservice.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.all.ddtiservice.model.registrationDetails"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long REGISTRATIONID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static registrationDetails toModel(registrationDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		registrationDetails model = new registrationDetailsImpl();

		model.setUuid(soapModel.getUuid());
		model.setRegistrationId(soapModel.getRegistrationId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setSurName(soapModel.getSurName());
		model.setAddress(soapModel.getAddress());
		model.setContactNumber(soapModel.getContactNumber());
		model.setGender(soapModel.getGender());
		model.setImagepath(soapModel.getImagepath());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<registrationDetails> toModels(
		registrationDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<registrationDetails> models = new ArrayList<registrationDetails>(soapModels.length);

		for (registrationDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_DDTI_REGISTRATIONDETAILS_COURSE_NAME =
		"DDTI_registrationDetails_course";
	public static final Object[][] MAPPING_TABLE_DDTI_REGISTRATIONDETAILS_COURSE_COLUMNS =
		{
			{ "companyId", Types.BIGINT },
			{ "courseId", Types.BIGINT },
			{ "registrationId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_DDTI_REGISTRATIONDETAILS_COURSE_SQL_CREATE =
		"create table DDTI_registrationDetails_course (companyId LONG not null,courseId LONG not null,registrationId LONG not null,primary key (courseId, registrationId))";
	public static final boolean FINDER_CACHE_ENABLED_DDTI_REGISTRATIONDETAILS_COURSE =
		GetterUtil.getBoolean(com.all.ddtiservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.DDTI_registrationDetails_course"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.all.ddtiservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.all.ddtiservice.model.registrationDetails"));

	public registrationDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _registrationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegistrationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registrationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return registrationDetails.class;
	}

	@Override
	public String getModelClassName() {
		return registrationDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("registrationId", getRegistrationId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("surName", getSurName());
		attributes.put("address", getAddress());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("gender", getGender());
		attributes.put("imagepath", getImagepath());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String surName = (String)attributes.get("surName");

		if (surName != null) {
			setSurName(surName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Long contactNumber = (Long)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		Boolean gender = (Boolean)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String imagepath = (String)attributes.get("imagepath");

		if (imagepath != null) {
			setImagepath(imagepath);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getRegistrationId() {
		return _registrationId;
	}

	@Override
	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getSurName() {
		if (_surName == null) {
			return StringPool.BLANK;
		}
		else {
			return _surName;
		}
	}

	@Override
	public void setSurName(String surName) {
		_surName = surName;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public long getContactNumber() {
		return _contactNumber;
	}

	@Override
	public void setContactNumber(long contactNumber) {
		_contactNumber = contactNumber;
	}

	@JSON
	@Override
	public boolean getGender() {
		return _gender;
	}

	@JSON
	@Override
	public boolean isGender() {
		return _gender;
	}

	@Override
	public void setGender(boolean gender) {
		_gender = gender;
	}

	@JSON
	@Override
	public String getImagepath() {
		if (_imagepath == null) {
			return StringPool.BLANK;
		}
		else {
			return _imagepath;
		}
	}

	@Override
	public void setImagepath(String imagepath) {
		_imagepath = imagepath;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
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

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				registrationDetails.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			registrationDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public registrationDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (registrationDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		registrationDetailsImpl registrationDetailsImpl = new registrationDetailsImpl();

		registrationDetailsImpl.setUuid(getUuid());
		registrationDetailsImpl.setRegistrationId(getRegistrationId());
		registrationDetailsImpl.setFirstName(getFirstName());
		registrationDetailsImpl.setLastName(getLastName());
		registrationDetailsImpl.setSurName(getSurName());
		registrationDetailsImpl.setAddress(getAddress());
		registrationDetailsImpl.setContactNumber(getContactNumber());
		registrationDetailsImpl.setGender(getGender());
		registrationDetailsImpl.setImagepath(getImagepath());
		registrationDetailsImpl.setGroupId(getGroupId());
		registrationDetailsImpl.setCompanyId(getCompanyId());
		registrationDetailsImpl.setUserId(getUserId());
		registrationDetailsImpl.setUserName(getUserName());
		registrationDetailsImpl.setCreateDate(getCreateDate());
		registrationDetailsImpl.setModifiedDate(getModifiedDate());

		registrationDetailsImpl.resetOriginalValues();

		return registrationDetailsImpl;
	}

	@Override
	public int compareTo(registrationDetails registrationDetails) {
		long primaryKey = registrationDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof registrationDetails)) {
			return false;
		}

		registrationDetails registrationDetails = (registrationDetails)obj;

		long primaryKey = registrationDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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
		registrationDetailsModelImpl registrationDetailsModelImpl = this;

		registrationDetailsModelImpl._originalUuid = registrationDetailsModelImpl._uuid;

		registrationDetailsModelImpl._originalGroupId = registrationDetailsModelImpl._groupId;

		registrationDetailsModelImpl._setOriginalGroupId = false;

		registrationDetailsModelImpl._originalCompanyId = registrationDetailsModelImpl._companyId;

		registrationDetailsModelImpl._setOriginalCompanyId = false;

		registrationDetailsModelImpl._setModifiedDate = false;

		registrationDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<registrationDetails> toCacheModel() {
		registrationDetailsCacheModel registrationDetailsCacheModel = new registrationDetailsCacheModel();

		registrationDetailsCacheModel.uuid = getUuid();

		String uuid = registrationDetailsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			registrationDetailsCacheModel.uuid = null;
		}

		registrationDetailsCacheModel.registrationId = getRegistrationId();

		registrationDetailsCacheModel.firstName = getFirstName();

		String firstName = registrationDetailsCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			registrationDetailsCacheModel.firstName = null;
		}

		registrationDetailsCacheModel.lastName = getLastName();

		String lastName = registrationDetailsCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			registrationDetailsCacheModel.lastName = null;
		}

		registrationDetailsCacheModel.surName = getSurName();

		String surName = registrationDetailsCacheModel.surName;

		if ((surName != null) && (surName.length() == 0)) {
			registrationDetailsCacheModel.surName = null;
		}

		registrationDetailsCacheModel.address = getAddress();

		String address = registrationDetailsCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			registrationDetailsCacheModel.address = null;
		}

		registrationDetailsCacheModel.contactNumber = getContactNumber();

		registrationDetailsCacheModel.gender = getGender();

		registrationDetailsCacheModel.imagepath = getImagepath();

		String imagepath = registrationDetailsCacheModel.imagepath;

		if ((imagepath != null) && (imagepath.length() == 0)) {
			registrationDetailsCacheModel.imagepath = null;
		}

		registrationDetailsCacheModel.groupId = getGroupId();

		registrationDetailsCacheModel.companyId = getCompanyId();

		registrationDetailsCacheModel.userId = getUserId();

		registrationDetailsCacheModel.userName = getUserName();

		String userName = registrationDetailsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			registrationDetailsCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			registrationDetailsCacheModel.createDate = createDate.getTime();
		}
		else {
			registrationDetailsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			registrationDetailsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			registrationDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return registrationDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", registrationId=");
		sb.append(getRegistrationId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", surName=");
		sb.append(getSurName());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", imagepath=");
		sb.append(getImagepath());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.all.ddtiservice.model.registrationDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationId</column-name><column-value><![CDATA[");
		sb.append(getRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surName</column-name><column-value><![CDATA[");
		sb.append(getSurName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imagepath</column-name><column-value><![CDATA[");
		sb.append(getImagepath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = registrationDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			registrationDetails.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _registrationId;
	private String _firstName;
	private String _lastName;
	private String _surName;
	private String _address;
	private long _contactNumber;
	private boolean _gender;
	private String _imagepath;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private registrationDetails _escapedModel;
}