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

package com.MappingServices.model;

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
 * This class is a wrapper for {@link Enquiry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Enquiry
 * @generated
 */
@ProviderType
public class EnquiryWrapper implements Enquiry, ModelWrapper<Enquiry> {
	public EnquiryWrapper(Enquiry enquiry) {
		_enquiry = enquiry;
	}

	@Override
	public Class<?> getModelClass() {
		return Enquiry.class;
	}

	@Override
	public String getModelClassName() {
		return Enquiry.class.getName();
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
	public Enquiry toEscapedModel() {
		return new EnquiryWrapper(_enquiry.toEscapedModel());
	}

	@Override
	public Enquiry toUnescapedModel() {
		return new EnquiryWrapper(_enquiry.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _enquiry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _enquiry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _enquiry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _enquiry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Enquiry> toCacheModel() {
		return _enquiry.toCacheModel();
	}

	@Override
	public int compareTo(Enquiry enquiry) {
		return _enquiry.compareTo(enquiry);
	}

	@Override
	public int hashCode() {
		return _enquiry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _enquiry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EnquiryWrapper((Enquiry)_enquiry.clone());
	}

	/**
	* Returns the contact number of this enquiry.
	*
	* @return the contact number of this enquiry
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _enquiry.getContactNumber();
	}

	/**
	* Returns the email of this enquiry.
	*
	* @return the email of this enquiry
	*/
	@Override
	public java.lang.String getEmail() {
		return _enquiry.getEmail();
	}

	/**
	* Returns the first name of this enquiry.
	*
	* @return the first name of this enquiry
	*/
	@Override
	public java.lang.String getFirstName() {
		return _enquiry.getFirstName();
	}

	/**
	* Returns the last name of this enquiry.
	*
	* @return the last name of this enquiry
	*/
	@Override
	public java.lang.String getLastName() {
		return _enquiry.getLastName();
	}

	/**
	* Returns the message of this enquiry.
	*
	* @return the message of this enquiry
	*/
	@Override
	public java.lang.String getMessage() {
		return _enquiry.getMessage();
	}

	/**
	* Returns the part name of this enquiry.
	*
	* @return the part name of this enquiry
	*/
	@Override
	public java.lang.String getPartName() {
		return _enquiry.getPartName();
	}

	/**
	* Returns the part number of this enquiry.
	*
	* @return the part number of this enquiry
	*/
	@Override
	public java.lang.String getPartNumber() {
		return _enquiry.getPartNumber();
	}

	/**
	* Returns the uuid of this enquiry.
	*
	* @return the uuid of this enquiry
	*/
	@Override
	public java.lang.String getUuid() {
		return _enquiry.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _enquiry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _enquiry.toXmlString();
	}

	/**
	* Returns the create date of this enquiry.
	*
	* @return the create date of this enquiry
	*/
	@Override
	public Date getCreateDate() {
		return _enquiry.getCreateDate();
	}

	/**
	* Returns the modified date of this enquiry.
	*
	* @return the modified date of this enquiry
	*/
	@Override
	public Date getModifiedDate() {
		return _enquiry.getModifiedDate();
	}

	/**
	* Returns the eid of this enquiry.
	*
	* @return the eid of this enquiry
	*/
	@Override
	public long getEid() {
		return _enquiry.getEid();
	}

	/**
	* Returns the primary key of this enquiry.
	*
	* @return the primary key of this enquiry
	*/
	@Override
	public long getPrimaryKey() {
		return _enquiry.getPrimaryKey();
	}

	@Override
	public void persist() {
		_enquiry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_enquiry.setCachedModel(cachedModel);
	}

	/**
	* Sets the contact number of this enquiry.
	*
	* @param ContactNumber the contact number of this enquiry
	*/
	@Override
	public void setContactNumber(java.lang.String ContactNumber) {
		_enquiry.setContactNumber(ContactNumber);
	}

	/**
	* Sets the create date of this enquiry.
	*
	* @param createDate the create date of this enquiry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_enquiry.setCreateDate(createDate);
	}

	/**
	* Sets the eid of this enquiry.
	*
	* @param Eid the eid of this enquiry
	*/
	@Override
	public void setEid(long Eid) {
		_enquiry.setEid(Eid);
	}

	/**
	* Sets the email of this enquiry.
	*
	* @param Email the email of this enquiry
	*/
	@Override
	public void setEmail(java.lang.String Email) {
		_enquiry.setEmail(Email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_enquiry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_enquiry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_enquiry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this enquiry.
	*
	* @param FirstName the first name of this enquiry
	*/
	@Override
	public void setFirstName(java.lang.String FirstName) {
		_enquiry.setFirstName(FirstName);
	}

	/**
	* Sets the last name of this enquiry.
	*
	* @param LastName the last name of this enquiry
	*/
	@Override
	public void setLastName(java.lang.String LastName) {
		_enquiry.setLastName(LastName);
	}

	/**
	* Sets the message of this enquiry.
	*
	* @param Message the message of this enquiry
	*/
	@Override
	public void setMessage(java.lang.String Message) {
		_enquiry.setMessage(Message);
	}

	/**
	* Sets the modified date of this enquiry.
	*
	* @param modifiedDate the modified date of this enquiry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_enquiry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_enquiry.setNew(n);
	}

	/**
	* Sets the part name of this enquiry.
	*
	* @param PartName the part name of this enquiry
	*/
	@Override
	public void setPartName(java.lang.String PartName) {
		_enquiry.setPartName(PartName);
	}

	/**
	* Sets the part number of this enquiry.
	*
	* @param PartNumber the part number of this enquiry
	*/
	@Override
	public void setPartNumber(java.lang.String PartNumber) {
		_enquiry.setPartNumber(PartNumber);
	}

	/**
	* Sets the primary key of this enquiry.
	*
	* @param primaryKey the primary key of this enquiry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_enquiry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_enquiry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this enquiry.
	*
	* @param uuid the uuid of this enquiry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_enquiry.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnquiryWrapper)) {
			return false;
		}

		EnquiryWrapper enquiryWrapper = (EnquiryWrapper)obj;

		if (Objects.equals(_enquiry, enquiryWrapper._enquiry)) {
			return true;
		}

		return false;
	}

	@Override
	public Enquiry getWrappedModel() {
		return _enquiry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _enquiry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _enquiry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_enquiry.resetOriginalValues();
	}

	private final Enquiry _enquiry;
}