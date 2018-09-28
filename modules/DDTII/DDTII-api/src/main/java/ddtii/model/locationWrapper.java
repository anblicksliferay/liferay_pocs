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

package ddtii.model;

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
 * This class is a wrapper for {@link location}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see location
 * @generated
 */
@ProviderType
public class locationWrapper implements location, ModelWrapper<location> {
	public locationWrapper(location location) {
		_location = location;
	}

	@Override
	public Class<?> getModelClass() {
		return location.class;
	}

	@Override
	public String getModelClassName() {
		return location.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("locationName", getLocationName());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
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
		return _location.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _location.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _location.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _location.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ddtii.model.location> toCacheModel() {
		return _location.toCacheModel();
	}

	@Override
	public ddtii.model.location toEscapedModel() {
		return new locationWrapper(_location.toEscapedModel());
	}

	@Override
	public ddtii.model.location toUnescapedModel() {
		return new locationWrapper(_location.toUnescapedModel());
	}

	@Override
	public int compareTo(ddtii.model.location location) {
		return _location.compareTo(location);
	}

	@Override
	public int hashCode() {
		return _location.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _location.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new locationWrapper((location)_location.clone());
	}

	/**
	* Returns the location name of this location.
	*
	* @return the location name of this location
	*/
	@Override
	public java.lang.String getLocationName() {
		return _location.getLocationName();
	}

	/**
	* Returns the user name of this location.
	*
	* @return the user name of this location
	*/
	@Override
	public java.lang.String getUserName() {
		return _location.getUserName();
	}

	/**
	* Returns the user uuid of this location.
	*
	* @return the user uuid of this location
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _location.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _location.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _location.toXmlString();
	}

	/**
	* Returns the create date of this location.
	*
	* @return the create date of this location
	*/
	@Override
	public Date getCreateDate() {
		return _location.getCreateDate();
	}

	/**
	* Returns the modified date of this location.
	*
	* @return the modified date of this location
	*/
	@Override
	public Date getModifiedDate() {
		return _location.getModifiedDate();
	}

	/**
	* Returns the company ID of this location.
	*
	* @return the company ID of this location
	*/
	@Override
	public long getCompanyId() {
		return _location.getCompanyId();
	}

	/**
	* Returns the location ID of this location.
	*
	* @return the location ID of this location
	*/
	@Override
	public long getLocationId() {
		return _location.getLocationId();
	}

	/**
	* Returns the primary key of this location.
	*
	* @return the primary key of this location
	*/
	@Override
	public long getPrimaryKey() {
		return _location.getPrimaryKey();
	}

	/**
	* Returns the user ID of this location.
	*
	* @return the user ID of this location
	*/
	@Override
	public long getUserId() {
		return _location.getUserId();
	}

	@Override
	public void persist() {
		_location.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_location.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this location.
	*
	* @param companyId the company ID of this location
	*/
	@Override
	public void setCompanyId(long companyId) {
		_location.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this location.
	*
	* @param createDate the create date of this location
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_location.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_location.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_location.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_location.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the location ID of this location.
	*
	* @param locationId the location ID of this location
	*/
	@Override
	public void setLocationId(long locationId) {
		_location.setLocationId(locationId);
	}

	/**
	* Sets the location name of this location.
	*
	* @param locationName the location name of this location
	*/
	@Override
	public void setLocationName(java.lang.String locationName) {
		_location.setLocationName(locationName);
	}

	/**
	* Sets the modified date of this location.
	*
	* @param modifiedDate the modified date of this location
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_location.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_location.setNew(n);
	}

	/**
	* Sets the primary key of this location.
	*
	* @param primaryKey the primary key of this location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_location.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_location.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this location.
	*
	* @param userId the user ID of this location
	*/
	@Override
	public void setUserId(long userId) {
		_location.setUserId(userId);
	}

	/**
	* Sets the user name of this location.
	*
	* @param userName the user name of this location
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_location.setUserName(userName);
	}

	/**
	* Sets the user uuid of this location.
	*
	* @param userUuid the user uuid of this location
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_location.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof locationWrapper)) {
			return false;
		}

		locationWrapper locationWrapper = (locationWrapper)obj;

		if (Objects.equals(_location, locationWrapper._location)) {
			return true;
		}

		return false;
	}

	@Override
	public location getWrappedModel() {
		return _location;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _location.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _location.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_location.resetOriginalValues();
	}

	private final location _location;
}