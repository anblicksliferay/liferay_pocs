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

package com.externalservices.model;

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
 * This class is a wrapper for {@link leykartEnquiry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leykartEnquiry
 * @generated
 */
@ProviderType
public class leykartEnquiryWrapper implements leykartEnquiry,
	ModelWrapper<leykartEnquiry> {
	public leykartEnquiryWrapper(leykartEnquiry leykartEnquiry) {
		_leykartEnquiry = leykartEnquiry;
	}

	@Override
	public Class<?> getModelClass() {
		return leykartEnquiry.class;
	}

	@Override
	public String getModelClassName() {
		return leykartEnquiry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Eid", getEid());
		attributes.put("FirstName", getFirstName());
		attributes.put("LastName", getLastName());
		attributes.put("Email", getEmail());
		attributes.put("ContactNumber", getContactNumber());
		attributes.put("PartName", getPartName());
		attributes.put("PartNumber", getPartNumber());
		attributes.put("Message", getMessage());
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

		Long Eid = (Long)attributes.get("Eid");

		if (Eid != null) {
			setEid(Eid);
		}

		String FirstName = (String)attributes.get("FirstName");

		if (FirstName != null) {
			setFirstName(FirstName);
		}

		String LastName = (String)attributes.get("LastName");

		if (LastName != null) {
			setLastName(LastName);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String ContactNumber = (String)attributes.get("ContactNumber");

		if (ContactNumber != null) {
			setContactNumber(ContactNumber);
		}

		String PartName = (String)attributes.get("PartName");

		if (PartName != null) {
			setPartName(PartName);
		}

		String PartNumber = (String)attributes.get("PartNumber");

		if (PartNumber != null) {
			setPartNumber(PartNumber);
		}

		String Message = (String)attributes.get("Message");

		if (Message != null) {
			setMessage(Message);
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

	@Override
	public boolean isCachedModel() {
		return _leykartEnquiry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leykartEnquiry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _leykartEnquiry.isNew();
	}

	@Override
	public com.externalservices.model.leykartEnquiry toEscapedModel() {
		return new leykartEnquiryWrapper(_leykartEnquiry.toEscapedModel());
	}

	@Override
	public com.externalservices.model.leykartEnquiry toUnescapedModel() {
		return new leykartEnquiryWrapper(_leykartEnquiry.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leykartEnquiry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.externalservices.model.leykartEnquiry> toCacheModel() {
		return _leykartEnquiry.toCacheModel();
	}

	@Override
	public int compareTo(
		com.externalservices.model.leykartEnquiry leykartEnquiry) {
		return _leykartEnquiry.compareTo(leykartEnquiry);
	}

	@Override
	public int hashCode() {
		return _leykartEnquiry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leykartEnquiry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new leykartEnquiryWrapper((leykartEnquiry)_leykartEnquiry.clone());
	}

	/**
	* Returns the contact number of this leykart enquiry.
	*
	* @return the contact number of this leykart enquiry
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _leykartEnquiry.getContactNumber();
	}

	/**
	* Returns the email of this leykart enquiry.
	*
	* @return the email of this leykart enquiry
	*/
	@Override
	public java.lang.String getEmail() {
		return _leykartEnquiry.getEmail();
	}

	/**
	* Returns the first name of this leykart enquiry.
	*
	* @return the first name of this leykart enquiry
	*/
	@Override
	public java.lang.String getFirstName() {
		return _leykartEnquiry.getFirstName();
	}

	/**
	* Returns the last name of this leykart enquiry.
	*
	* @return the last name of this leykart enquiry
	*/
	@Override
	public java.lang.String getLastName() {
		return _leykartEnquiry.getLastName();
	}

	/**
	* Returns the message of this leykart enquiry.
	*
	* @return the message of this leykart enquiry
	*/
	@Override
	public java.lang.String getMessage() {
		return _leykartEnquiry.getMessage();
	}

	/**
	* Returns the part name of this leykart enquiry.
	*
	* @return the part name of this leykart enquiry
	*/
	@Override
	public java.lang.String getPartName() {
		return _leykartEnquiry.getPartName();
	}

	/**
	* Returns the part number of this leykart enquiry.
	*
	* @return the part number of this leykart enquiry
	*/
	@Override
	public java.lang.String getPartNumber() {
		return _leykartEnquiry.getPartNumber();
	}

	/**
	* Returns the user name of this leykart enquiry.
	*
	* @return the user name of this leykart enquiry
	*/
	@Override
	public java.lang.String getUserName() {
		return _leykartEnquiry.getUserName();
	}

	/**
	* Returns the user uuid of this leykart enquiry.
	*
	* @return the user uuid of this leykart enquiry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _leykartEnquiry.getUserUuid();
	}

	/**
	* Returns the uuid of this leykart enquiry.
	*
	* @return the uuid of this leykart enquiry
	*/
	@Override
	public java.lang.String getUuid() {
		return _leykartEnquiry.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _leykartEnquiry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leykartEnquiry.toXmlString();
	}

	/**
	* Returns the create date of this leykart enquiry.
	*
	* @return the create date of this leykart enquiry
	*/
	@Override
	public Date getCreateDate() {
		return _leykartEnquiry.getCreateDate();
	}

	/**
	* Returns the modified date of this leykart enquiry.
	*
	* @return the modified date of this leykart enquiry
	*/
	@Override
	public Date getModifiedDate() {
		return _leykartEnquiry.getModifiedDate();
	}

	/**
	* Returns the company ID of this leykart enquiry.
	*
	* @return the company ID of this leykart enquiry
	*/
	@Override
	public long getCompanyId() {
		return _leykartEnquiry.getCompanyId();
	}

	/**
	* Returns the eid of this leykart enquiry.
	*
	* @return the eid of this leykart enquiry
	*/
	@Override
	public long getEid() {
		return _leykartEnquiry.getEid();
	}

	/**
	* Returns the primary key of this leykart enquiry.
	*
	* @return the primary key of this leykart enquiry
	*/
	@Override
	public long getPrimaryKey() {
		return _leykartEnquiry.getPrimaryKey();
	}

	/**
	* Returns the user ID of this leykart enquiry.
	*
	* @return the user ID of this leykart enquiry
	*/
	@Override
	public long getUserId() {
		return _leykartEnquiry.getUserId();
	}

	@Override
	public void persist() {
		_leykartEnquiry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leykartEnquiry.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this leykart enquiry.
	*
	* @param companyId the company ID of this leykart enquiry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leykartEnquiry.setCompanyId(companyId);
	}

	/**
	* Sets the contact number of this leykart enquiry.
	*
	* @param ContactNumber the contact number of this leykart enquiry
	*/
	@Override
	public void setContactNumber(java.lang.String ContactNumber) {
		_leykartEnquiry.setContactNumber(ContactNumber);
	}

	/**
	* Sets the create date of this leykart enquiry.
	*
	* @param createDate the create date of this leykart enquiry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_leykartEnquiry.setCreateDate(createDate);
	}

	/**
	* Sets the eid of this leykart enquiry.
	*
	* @param Eid the eid of this leykart enquiry
	*/
	@Override
	public void setEid(long Eid) {
		_leykartEnquiry.setEid(Eid);
	}

	/**
	* Sets the email of this leykart enquiry.
	*
	* @param Email the email of this leykart enquiry
	*/
	@Override
	public void setEmail(java.lang.String Email) {
		_leykartEnquiry.setEmail(Email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leykartEnquiry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leykartEnquiry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leykartEnquiry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this leykart enquiry.
	*
	* @param FirstName the first name of this leykart enquiry
	*/
	@Override
	public void setFirstName(java.lang.String FirstName) {
		_leykartEnquiry.setFirstName(FirstName);
	}

	/**
	* Sets the last name of this leykart enquiry.
	*
	* @param LastName the last name of this leykart enquiry
	*/
	@Override
	public void setLastName(java.lang.String LastName) {
		_leykartEnquiry.setLastName(LastName);
	}

	/**
	* Sets the message of this leykart enquiry.
	*
	* @param Message the message of this leykart enquiry
	*/
	@Override
	public void setMessage(java.lang.String Message) {
		_leykartEnquiry.setMessage(Message);
	}

	/**
	* Sets the modified date of this leykart enquiry.
	*
	* @param modifiedDate the modified date of this leykart enquiry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_leykartEnquiry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_leykartEnquiry.setNew(n);
	}

	/**
	* Sets the part name of this leykart enquiry.
	*
	* @param PartName the part name of this leykart enquiry
	*/
	@Override
	public void setPartName(java.lang.String PartName) {
		_leykartEnquiry.setPartName(PartName);
	}

	/**
	* Sets the part number of this leykart enquiry.
	*
	* @param PartNumber the part number of this leykart enquiry
	*/
	@Override
	public void setPartNumber(java.lang.String PartNumber) {
		_leykartEnquiry.setPartNumber(PartNumber);
	}

	/**
	* Sets the primary key of this leykart enquiry.
	*
	* @param primaryKey the primary key of this leykart enquiry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leykartEnquiry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leykartEnquiry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this leykart enquiry.
	*
	* @param userId the user ID of this leykart enquiry
	*/
	@Override
	public void setUserId(long userId) {
		_leykartEnquiry.setUserId(userId);
	}

	/**
	* Sets the user name of this leykart enquiry.
	*
	* @param userName the user name of this leykart enquiry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_leykartEnquiry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this leykart enquiry.
	*
	* @param userUuid the user uuid of this leykart enquiry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leykartEnquiry.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this leykart enquiry.
	*
	* @param uuid the uuid of this leykart enquiry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_leykartEnquiry.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof leykartEnquiryWrapper)) {
			return false;
		}

		leykartEnquiryWrapper leykartEnquiryWrapper = (leykartEnquiryWrapper)obj;

		if (Objects.equals(_leykartEnquiry,
					leykartEnquiryWrapper._leykartEnquiry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _leykartEnquiry.getStagedModelType();
	}

	@Override
	public leykartEnquiry getWrappedModel() {
		return _leykartEnquiry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leykartEnquiry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leykartEnquiry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leykartEnquiry.resetOriginalValues();
	}

	private final leykartEnquiry _leykartEnquiry;
}