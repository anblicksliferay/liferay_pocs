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

package com.leykartservice.model;

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
 * This class is a wrapper for {@link Testmonials}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Testmonials
 * @generated
 */
@ProviderType
public class TestmonialsWrapper implements Testmonials,
	ModelWrapper<Testmonials> {
	public TestmonialsWrapper(Testmonials testmonials) {
		_testmonials = testmonials;
	}

	@Override
	public Class<?> getModelClass() {
		return Testmonials.class;
	}

	@Override
	public String getModelClassName() {
		return Testmonials.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("testmonialsId", getTestmonialsId());
		attributes.put("fullname", getFullname());
		attributes.put("imagepath", getImagepath());
		attributes.put("message", getMessage());
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

		Long testmonialsId = (Long)attributes.get("testmonialsId");

		if (testmonialsId != null) {
			setTestmonialsId(testmonialsId);
		}

		String fullname = (String)attributes.get("fullname");

		if (fullname != null) {
			setFullname(fullname);
		}

		String imagepath = (String)attributes.get("imagepath");

		if (imagepath != null) {
			setImagepath(imagepath);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
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
	public Testmonials toEscapedModel() {
		return new TestmonialsWrapper(_testmonials.toEscapedModel());
	}

	@Override
	public Testmonials toUnescapedModel() {
		return new TestmonialsWrapper(_testmonials.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _testmonials.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _testmonials.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _testmonials.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _testmonials.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Testmonials> toCacheModel() {
		return _testmonials.toCacheModel();
	}

	@Override
	public int compareTo(Testmonials testmonials) {
		return _testmonials.compareTo(testmonials);
	}

	@Override
	public int hashCode() {
		return _testmonials.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testmonials.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TestmonialsWrapper((Testmonials)_testmonials.clone());
	}

	/**
	* Returns the fullname of this testmonials.
	*
	* @return the fullname of this testmonials
	*/
	@Override
	public java.lang.String getFullname() {
		return _testmonials.getFullname();
	}

	/**
	* Returns the imagepath of this testmonials.
	*
	* @return the imagepath of this testmonials
	*/
	@Override
	public java.lang.String getImagepath() {
		return _testmonials.getImagepath();
	}

	/**
	* Returns the message of this testmonials.
	*
	* @return the message of this testmonials
	*/
	@Override
	public java.lang.String getMessage() {
		return _testmonials.getMessage();
	}

	/**
	* Returns the user name of this testmonials.
	*
	* @return the user name of this testmonials
	*/
	@Override
	public java.lang.String getUserName() {
		return _testmonials.getUserName();
	}

	/**
	* Returns the user uuid of this testmonials.
	*
	* @return the user uuid of this testmonials
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _testmonials.getUserUuid();
	}

	/**
	* Returns the uuid of this testmonials.
	*
	* @return the uuid of this testmonials
	*/
	@Override
	public java.lang.String getUuid() {
		return _testmonials.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _testmonials.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testmonials.toXmlString();
	}

	/**
	* Returns the create date of this testmonials.
	*
	* @return the create date of this testmonials
	*/
	@Override
	public Date getCreateDate() {
		return _testmonials.getCreateDate();
	}

	/**
	* Returns the modified date of this testmonials.
	*
	* @return the modified date of this testmonials
	*/
	@Override
	public Date getModifiedDate() {
		return _testmonials.getModifiedDate();
	}

	/**
	* Returns the company ID of this testmonials.
	*
	* @return the company ID of this testmonials
	*/
	@Override
	public long getCompanyId() {
		return _testmonials.getCompanyId();
	}

	/**
	* Returns the primary key of this testmonials.
	*
	* @return the primary key of this testmonials
	*/
	@Override
	public long getPrimaryKey() {
		return _testmonials.getPrimaryKey();
	}

	/**
	* Returns the testmonials ID of this testmonials.
	*
	* @return the testmonials ID of this testmonials
	*/
	@Override
	public long getTestmonialsId() {
		return _testmonials.getTestmonialsId();
	}

	/**
	* Returns the user ID of this testmonials.
	*
	* @return the user ID of this testmonials
	*/
	@Override
	public long getUserId() {
		return _testmonials.getUserId();
	}

	@Override
	public void persist() {
		_testmonials.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testmonials.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this testmonials.
	*
	* @param companyId the company ID of this testmonials
	*/
	@Override
	public void setCompanyId(long companyId) {
		_testmonials.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this testmonials.
	*
	* @param createDate the create date of this testmonials
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_testmonials.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_testmonials.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_testmonials.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_testmonials.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fullname of this testmonials.
	*
	* @param fullname the fullname of this testmonials
	*/
	@Override
	public void setFullname(java.lang.String fullname) {
		_testmonials.setFullname(fullname);
	}

	/**
	* Sets the imagepath of this testmonials.
	*
	* @param imagepath the imagepath of this testmonials
	*/
	@Override
	public void setImagepath(java.lang.String imagepath) {
		_testmonials.setImagepath(imagepath);
	}

	/**
	* Sets the message of this testmonials.
	*
	* @param message the message of this testmonials
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_testmonials.setMessage(message);
	}

	/**
	* Sets the modified date of this testmonials.
	*
	* @param modifiedDate the modified date of this testmonials
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_testmonials.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_testmonials.setNew(n);
	}

	/**
	* Sets the primary key of this testmonials.
	*
	* @param primaryKey the primary key of this testmonials
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_testmonials.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_testmonials.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the testmonials ID of this testmonials.
	*
	* @param testmonialsId the testmonials ID of this testmonials
	*/
	@Override
	public void setTestmonialsId(long testmonialsId) {
		_testmonials.setTestmonialsId(testmonialsId);
	}

	/**
	* Sets the user ID of this testmonials.
	*
	* @param userId the user ID of this testmonials
	*/
	@Override
	public void setUserId(long userId) {
		_testmonials.setUserId(userId);
	}

	/**
	* Sets the user name of this testmonials.
	*
	* @param userName the user name of this testmonials
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_testmonials.setUserName(userName);
	}

	/**
	* Sets the user uuid of this testmonials.
	*
	* @param userUuid the user uuid of this testmonials
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_testmonials.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this testmonials.
	*
	* @param uuid the uuid of this testmonials
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_testmonials.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestmonialsWrapper)) {
			return false;
		}

		TestmonialsWrapper testmonialsWrapper = (TestmonialsWrapper)obj;

		if (Objects.equals(_testmonials, testmonialsWrapper._testmonials)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _testmonials.getStagedModelType();
	}

	@Override
	public Testmonials getWrappedModel() {
		return _testmonials;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _testmonials.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _testmonials.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_testmonials.resetOriginalValues();
	}

	private final Testmonials _testmonials;
}