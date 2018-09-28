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

package com.all.ddtiservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link registrationDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetails
 * @generated
 */
@ProviderType
public class registrationDetailsWrapper implements registrationDetails,
	ModelWrapper<registrationDetails> {
	public registrationDetailsWrapper(registrationDetails registrationDetails) {
		_registrationDetails = registrationDetails;
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

	/**
	* Returns the gender of this registration details.
	*
	* @return the gender of this registration details
	*/
	@Override
	public boolean getGender() {
		return _registrationDetails.getGender();
	}

	@Override
	public boolean isCachedModel() {
		return _registrationDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _registrationDetails.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this registration details is gender.
	*
	* @return <code>true</code> if this registration details is gender; <code>false</code> otherwise
	*/
	@Override
	public boolean isGender() {
		return _registrationDetails.isGender();
	}

	@Override
	public boolean isNew() {
		return _registrationDetails.isNew();
	}

	@Override
	public com.all.ddtiservice.model.registrationDetails toEscapedModel() {
		return new registrationDetailsWrapper(_registrationDetails.toEscapedModel());
	}

	@Override
	public com.all.ddtiservice.model.registrationDetails toUnescapedModel() {
		return new registrationDetailsWrapper(_registrationDetails.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _registrationDetails.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.all.ddtiservice.model.registrationDetails> toCacheModel() {
		return _registrationDetails.toCacheModel();
	}

	@Override
	public int compareTo(
		com.all.ddtiservice.model.registrationDetails registrationDetails) {
		return _registrationDetails.compareTo(registrationDetails);
	}

	@Override
	public int hashCode() {
		return _registrationDetails.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registrationDetails.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new registrationDetailsWrapper((registrationDetails)_registrationDetails.clone());
	}

	/**
	* Returns the address of this registration details.
	*
	* @return the address of this registration details
	*/
	@Override
	public java.lang.String getAddress() {
		return _registrationDetails.getAddress();
	}

	/**
	* Returns the first name of this registration details.
	*
	* @return the first name of this registration details
	*/
	@Override
	public java.lang.String getFirstName() {
		return _registrationDetails.getFirstName();
	}

	/**
	* Returns the imagepath of this registration details.
	*
	* @return the imagepath of this registration details
	*/
	@Override
	public java.lang.String getImagepath() {
		return _registrationDetails.getImagepath();
	}

	/**
	* Returns the last name of this registration details.
	*
	* @return the last name of this registration details
	*/
	@Override
	public java.lang.String getLastName() {
		return _registrationDetails.getLastName();
	}

	/**
	* Returns the sur name of this registration details.
	*
	* @return the sur name of this registration details
	*/
	@Override
	public java.lang.String getSurName() {
		return _registrationDetails.getSurName();
	}

	/**
	* Returns the user name of this registration details.
	*
	* @return the user name of this registration details
	*/
	@Override
	public java.lang.String getUserName() {
		return _registrationDetails.getUserName();
	}

	/**
	* Returns the user uuid of this registration details.
	*
	* @return the user uuid of this registration details
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _registrationDetails.getUserUuid();
	}

	/**
	* Returns the uuid of this registration details.
	*
	* @return the uuid of this registration details
	*/
	@Override
	public java.lang.String getUuid() {
		return _registrationDetails.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _registrationDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _registrationDetails.toXmlString();
	}

	/**
	* Returns the create date of this registration details.
	*
	* @return the create date of this registration details
	*/
	@Override
	public Date getCreateDate() {
		return _registrationDetails.getCreateDate();
	}

	/**
	* Returns the modified date of this registration details.
	*
	* @return the modified date of this registration details
	*/
	@Override
	public Date getModifiedDate() {
		return _registrationDetails.getModifiedDate();
	}

	/**
	* Returns the company ID of this registration details.
	*
	* @return the company ID of this registration details
	*/
	@Override
	public long getCompanyId() {
		return _registrationDetails.getCompanyId();
	}

	/**
	* Returns the contact number of this registration details.
	*
	* @return the contact number of this registration details
	*/
	@Override
	public long getContactNumber() {
		return _registrationDetails.getContactNumber();
	}

	/**
	* Returns the group ID of this registration details.
	*
	* @return the group ID of this registration details
	*/
	@Override
	public long getGroupId() {
		return _registrationDetails.getGroupId();
	}

	/**
	* Returns the primary key of this registration details.
	*
	* @return the primary key of this registration details
	*/
	@Override
	public long getPrimaryKey() {
		return _registrationDetails.getPrimaryKey();
	}

	/**
	* Returns the registration ID of this registration details.
	*
	* @return the registration ID of this registration details
	*/
	@Override
	public long getRegistrationId() {
		return _registrationDetails.getRegistrationId();
	}

	/**
	* Returns the user ID of this registration details.
	*
	* @return the user ID of this registration details
	*/
	@Override
	public long getUserId() {
		return _registrationDetails.getUserId();
	}

	@Override
	public void persist() {
		_registrationDetails.persist();
	}

	/**
	* Sets the address of this registration details.
	*
	* @param address the address of this registration details
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_registrationDetails.setAddress(address);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_registrationDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this registration details.
	*
	* @param companyId the company ID of this registration details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_registrationDetails.setCompanyId(companyId);
	}

	/**
	* Sets the contact number of this registration details.
	*
	* @param contactNumber the contact number of this registration details
	*/
	@Override
	public void setContactNumber(long contactNumber) {
		_registrationDetails.setContactNumber(contactNumber);
	}

	/**
	* Sets the create date of this registration details.
	*
	* @param createDate the create date of this registration details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_registrationDetails.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_registrationDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_registrationDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_registrationDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this registration details.
	*
	* @param firstName the first name of this registration details
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_registrationDetails.setFirstName(firstName);
	}

	/**
	* Sets whether this registration details is gender.
	*
	* @param gender the gender of this registration details
	*/
	@Override
	public void setGender(boolean gender) {
		_registrationDetails.setGender(gender);
	}

	/**
	* Sets the group ID of this registration details.
	*
	* @param groupId the group ID of this registration details
	*/
	@Override
	public void setGroupId(long groupId) {
		_registrationDetails.setGroupId(groupId);
	}

	/**
	* Sets the imagepath of this registration details.
	*
	* @param imagepath the imagepath of this registration details
	*/
	@Override
	public void setImagepath(java.lang.String imagepath) {
		_registrationDetails.setImagepath(imagepath);
	}

	/**
	* Sets the last name of this registration details.
	*
	* @param lastName the last name of this registration details
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_registrationDetails.setLastName(lastName);
	}

	/**
	* Sets the modified date of this registration details.
	*
	* @param modifiedDate the modified date of this registration details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_registrationDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_registrationDetails.setNew(n);
	}

	/**
	* Sets the primary key of this registration details.
	*
	* @param primaryKey the primary key of this registration details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_registrationDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_registrationDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the registration ID of this registration details.
	*
	* @param registrationId the registration ID of this registration details
	*/
	@Override
	public void setRegistrationId(long registrationId) {
		_registrationDetails.setRegistrationId(registrationId);
	}

	/**
	* Sets the sur name of this registration details.
	*
	* @param surName the sur name of this registration details
	*/
	@Override
	public void setSurName(java.lang.String surName) {
		_registrationDetails.setSurName(surName);
	}

	/**
	* Sets the user ID of this registration details.
	*
	* @param userId the user ID of this registration details
	*/
	@Override
	public void setUserId(long userId) {
		_registrationDetails.setUserId(userId);
	}

	/**
	* Sets the user name of this registration details.
	*
	* @param userName the user name of this registration details
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_registrationDetails.setUserName(userName);
	}

	/**
	* Sets the user uuid of this registration details.
	*
	* @param userUuid the user uuid of this registration details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_registrationDetails.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this registration details.
	*
	* @param uuid the uuid of this registration details
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_registrationDetails.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof registrationDetailsWrapper)) {
			return false;
		}

		registrationDetailsWrapper registrationDetailsWrapper = (registrationDetailsWrapper)obj;

		if (Objects.equals(_registrationDetails,
					registrationDetailsWrapper._registrationDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _registrationDetails.getStagedModelType();
	}

	@Override
	public registrationDetails getWrappedModel() {
		return _registrationDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _registrationDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _registrationDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_registrationDetails.resetOriginalValues();
	}

	private final registrationDetails _registrationDetails;
}