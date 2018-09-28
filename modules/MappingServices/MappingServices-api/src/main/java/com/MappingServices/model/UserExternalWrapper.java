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
 * This class is a wrapper for {@link UserExternal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserExternal
 * @generated
 */
@ProviderType
public class UserExternalWrapper implements UserExternal,
	ModelWrapper<UserExternal> {
	public UserExternalWrapper(UserExternal userExternal) {
		_userExternal = userExternal;
	}

	@Override
	public Class<?> getModelClass() {
		return UserExternal.class;
	}

	@Override
	public String getModelClassName() {
		return UserExternal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("uid", getUid());
		attributes.put("Location", getLocation());
		attributes.put("PolicyNumber", getPolicyNumber());
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

		Long uid = (Long)attributes.get("uid");

		if (uid != null) {
			setUid(uid);
		}

		String Location = (String)attributes.get("Location");

		if (Location != null) {
			setLocation(Location);
		}

		String PolicyNumber = (String)attributes.get("PolicyNumber");

		if (PolicyNumber != null) {
			setPolicyNumber(PolicyNumber);
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
	public UserExternal toEscapedModel() {
		return new UserExternalWrapper(_userExternal.toEscapedModel());
	}

	@Override
	public UserExternal toUnescapedModel() {
		return new UserExternalWrapper(_userExternal.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _userExternal.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userExternal.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userExternal.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userExternal.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserExternal> toCacheModel() {
		return _userExternal.toCacheModel();
	}

	@Override
	public int compareTo(UserExternal userExternal) {
		return _userExternal.compareTo(userExternal);
	}

	@Override
	public int hashCode() {
		return _userExternal.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userExternal.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserExternalWrapper((UserExternal)_userExternal.clone());
	}

	/**
	* Returns the location of this user external.
	*
	* @return the location of this user external
	*/
	@Override
	public java.lang.String getLocation() {
		return _userExternal.getLocation();
	}

	/**
	* Returns the policy number of this user external.
	*
	* @return the policy number of this user external
	*/
	@Override
	public java.lang.String getPolicyNumber() {
		return _userExternal.getPolicyNumber();
	}

	/**
	* Returns the uuid of this user external.
	*
	* @return the uuid of this user external
	*/
	@Override
	public java.lang.String getUuid() {
		return _userExternal.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userExternal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userExternal.toXmlString();
	}

	/**
	* Returns the create date of this user external.
	*
	* @return the create date of this user external
	*/
	@Override
	public Date getCreateDate() {
		return _userExternal.getCreateDate();
	}

	/**
	* Returns the modified date of this user external.
	*
	* @return the modified date of this user external
	*/
	@Override
	public Date getModifiedDate() {
		return _userExternal.getModifiedDate();
	}

	/**
	* Returns the primary key of this user external.
	*
	* @return the primary key of this user external
	*/
	@Override
	public long getPrimaryKey() {
		return _userExternal.getPrimaryKey();
	}

	/**
	* Returns the uid of this user external.
	*
	* @return the uid of this user external
	*/
	@Override
	public long getUid() {
		return _userExternal.getUid();
	}

	@Override
	public void persist() {
		_userExternal.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userExternal.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this user external.
	*
	* @param createDate the create date of this user external
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userExternal.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userExternal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userExternal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userExternal.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the location of this user external.
	*
	* @param Location the location of this user external
	*/
	@Override
	public void setLocation(java.lang.String Location) {
		_userExternal.setLocation(Location);
	}

	/**
	* Sets the modified date of this user external.
	*
	* @param modifiedDate the modified date of this user external
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userExternal.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userExternal.setNew(n);
	}

	/**
	* Sets the policy number of this user external.
	*
	* @param PolicyNumber the policy number of this user external
	*/
	@Override
	public void setPolicyNumber(java.lang.String PolicyNumber) {
		_userExternal.setPolicyNumber(PolicyNumber);
	}

	/**
	* Sets the primary key of this user external.
	*
	* @param primaryKey the primary key of this user external
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userExternal.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userExternal.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uid of this user external.
	*
	* @param uid the uid of this user external
	*/
	@Override
	public void setUid(long uid) {
		_userExternal.setUid(uid);
	}

	/**
	* Sets the uuid of this user external.
	*
	* @param uuid the uuid of this user external
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userExternal.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserExternalWrapper)) {
			return false;
		}

		UserExternalWrapper userExternalWrapper = (UserExternalWrapper)obj;

		if (Objects.equals(_userExternal, userExternalWrapper._userExternal)) {
			return true;
		}

		return false;
	}

	@Override
	public UserExternal getWrappedModel() {
		return _userExternal;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userExternal.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userExternal.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userExternal.resetOriginalValues();
	}

	private final UserExternal _userExternal;
}