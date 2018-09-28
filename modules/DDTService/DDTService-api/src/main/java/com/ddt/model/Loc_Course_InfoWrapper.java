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

package com.ddt.model;

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
 * This class is a wrapper for {@link Loc_Course_Info}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_Info
 * @generated
 */
@ProviderType
public class Loc_Course_InfoWrapper implements Loc_Course_Info,
	ModelWrapper<Loc_Course_Info> {
	public Loc_Course_InfoWrapper(Loc_Course_Info loc_Course_Info) {
		_loc_Course_Info = loc_Course_Info;
	}

	@Override
	public Class<?> getModelClass() {
		return Loc_Course_Info.class;
	}

	@Override
	public String getModelClassName() {
		return Loc_Course_Info.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("locationId", getLocationId());
		attributes.put("couserId", getCouserId());
		attributes.put("locationName", getLocationName());
		attributes.put("couserName", getCouserName());
		attributes.put("maxSeats", getMaxSeats());
		attributes.put("toDate", getToDate());
		attributes.put("fromDate", getFromDate());
		attributes.put("Fees", getFees());
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

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long couserId = (Long)attributes.get("couserId");

		if (couserId != null) {
			setCouserId(couserId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}

		String couserName = (String)attributes.get("couserName");

		if (couserName != null) {
			setCouserName(couserName);
		}

		Long maxSeats = (Long)attributes.get("maxSeats");

		if (maxSeats != null) {
			setMaxSeats(maxSeats);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Long Fees = (Long)attributes.get("Fees");

		if (Fees != null) {
			setFees(Fees);
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
	public Loc_Course_Info toEscapedModel() {
		return new Loc_Course_InfoWrapper(_loc_Course_Info.toEscapedModel());
	}

	@Override
	public Loc_Course_Info toUnescapedModel() {
		return new Loc_Course_InfoWrapper(_loc_Course_Info.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _loc_Course_Info.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _loc_Course_Info.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _loc_Course_Info.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _loc_Course_Info.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Loc_Course_Info> toCacheModel() {
		return _loc_Course_Info.toCacheModel();
	}

	@Override
	public int compareTo(Loc_Course_Info loc_Course_Info) {
		return _loc_Course_Info.compareTo(loc_Course_Info);
	}

	@Override
	public int hashCode() {
		return _loc_Course_Info.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loc_Course_Info.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Loc_Course_InfoWrapper((Loc_Course_Info)_loc_Course_Info.clone());
	}

	/**
	* Returns the couser name of this loc_ course_ info.
	*
	* @return the couser name of this loc_ course_ info
	*/
	@Override
	public java.lang.String getCouserName() {
		return _loc_Course_Info.getCouserName();
	}

	/**
	* Returns the location name of this loc_ course_ info.
	*
	* @return the location name of this loc_ course_ info
	*/
	@Override
	public java.lang.String getLocationName() {
		return _loc_Course_Info.getLocationName();
	}

	/**
	* Returns the user name of this loc_ course_ info.
	*
	* @return the user name of this loc_ course_ info
	*/
	@Override
	public java.lang.String getUserName() {
		return _loc_Course_Info.getUserName();
	}

	/**
	* Returns the user uuid of this loc_ course_ info.
	*
	* @return the user uuid of this loc_ course_ info
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _loc_Course_Info.getUserUuid();
	}

	/**
	* Returns the uuid of this loc_ course_ info.
	*
	* @return the uuid of this loc_ course_ info
	*/
	@Override
	public java.lang.String getUuid() {
		return _loc_Course_Info.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _loc_Course_Info.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loc_Course_Info.toXmlString();
	}

	/**
	* Returns the create date of this loc_ course_ info.
	*
	* @return the create date of this loc_ course_ info
	*/
	@Override
	public Date getCreateDate() {
		return _loc_Course_Info.getCreateDate();
	}

	/**
	* Returns the from date of this loc_ course_ info.
	*
	* @return the from date of this loc_ course_ info
	*/
	@Override
	public Date getFromDate() {
		return _loc_Course_Info.getFromDate();
	}

	/**
	* Returns the modified date of this loc_ course_ info.
	*
	* @return the modified date of this loc_ course_ info
	*/
	@Override
	public Date getModifiedDate() {
		return _loc_Course_Info.getModifiedDate();
	}

	/**
	* Returns the to date of this loc_ course_ info.
	*
	* @return the to date of this loc_ course_ info
	*/
	@Override
	public Date getToDate() {
		return _loc_Course_Info.getToDate();
	}

	/**
	* Returns the company ID of this loc_ course_ info.
	*
	* @return the company ID of this loc_ course_ info
	*/
	@Override
	public long getCompanyId() {
		return _loc_Course_Info.getCompanyId();
	}

	/**
	* Returns the couser ID of this loc_ course_ info.
	*
	* @return the couser ID of this loc_ course_ info
	*/
	@Override
	public long getCouserId() {
		return _loc_Course_Info.getCouserId();
	}

	/**
	* Returns the fees of this loc_ course_ info.
	*
	* @return the fees of this loc_ course_ info
	*/
	@Override
	public long getFees() {
		return _loc_Course_Info.getFees();
	}

	/**
	* Returns the ID of this loc_ course_ info.
	*
	* @return the ID of this loc_ course_ info
	*/
	@Override
	public long getId() {
		return _loc_Course_Info.getId();
	}

	/**
	* Returns the location ID of this loc_ course_ info.
	*
	* @return the location ID of this loc_ course_ info
	*/
	@Override
	public long getLocationId() {
		return _loc_Course_Info.getLocationId();
	}

	/**
	* Returns the max seats of this loc_ course_ info.
	*
	* @return the max seats of this loc_ course_ info
	*/
	@Override
	public long getMaxSeats() {
		return _loc_Course_Info.getMaxSeats();
	}

	/**
	* Returns the primary key of this loc_ course_ info.
	*
	* @return the primary key of this loc_ course_ info
	*/
	@Override
	public long getPrimaryKey() {
		return _loc_Course_Info.getPrimaryKey();
	}

	/**
	* Returns the user ID of this loc_ course_ info.
	*
	* @return the user ID of this loc_ course_ info
	*/
	@Override
	public long getUserId() {
		return _loc_Course_Info.getUserId();
	}

	@Override
	public void persist() {
		_loc_Course_Info.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loc_Course_Info.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this loc_ course_ info.
	*
	* @param companyId the company ID of this loc_ course_ info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_loc_Course_Info.setCompanyId(companyId);
	}

	/**
	* Sets the couser ID of this loc_ course_ info.
	*
	* @param couserId the couser ID of this loc_ course_ info
	*/
	@Override
	public void setCouserId(long couserId) {
		_loc_Course_Info.setCouserId(couserId);
	}

	/**
	* Sets the couser name of this loc_ course_ info.
	*
	* @param couserName the couser name of this loc_ course_ info
	*/
	@Override
	public void setCouserName(java.lang.String couserName) {
		_loc_Course_Info.setCouserName(couserName);
	}

	/**
	* Sets the create date of this loc_ course_ info.
	*
	* @param createDate the create date of this loc_ course_ info
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_loc_Course_Info.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_loc_Course_Info.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_loc_Course_Info.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_loc_Course_Info.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fees of this loc_ course_ info.
	*
	* @param Fees the fees of this loc_ course_ info
	*/
	@Override
	public void setFees(long Fees) {
		_loc_Course_Info.setFees(Fees);
	}

	/**
	* Sets the from date of this loc_ course_ info.
	*
	* @param fromDate the from date of this loc_ course_ info
	*/
	@Override
	public void setFromDate(Date fromDate) {
		_loc_Course_Info.setFromDate(fromDate);
	}

	/**
	* Sets the ID of this loc_ course_ info.
	*
	* @param id the ID of this loc_ course_ info
	*/
	@Override
	public void setId(long id) {
		_loc_Course_Info.setId(id);
	}

	/**
	* Sets the location ID of this loc_ course_ info.
	*
	* @param locationId the location ID of this loc_ course_ info
	*/
	@Override
	public void setLocationId(long locationId) {
		_loc_Course_Info.setLocationId(locationId);
	}

	/**
	* Sets the location name of this loc_ course_ info.
	*
	* @param locationName the location name of this loc_ course_ info
	*/
	@Override
	public void setLocationName(java.lang.String locationName) {
		_loc_Course_Info.setLocationName(locationName);
	}

	/**
	* Sets the max seats of this loc_ course_ info.
	*
	* @param maxSeats the max seats of this loc_ course_ info
	*/
	@Override
	public void setMaxSeats(long maxSeats) {
		_loc_Course_Info.setMaxSeats(maxSeats);
	}

	/**
	* Sets the modified date of this loc_ course_ info.
	*
	* @param modifiedDate the modified date of this loc_ course_ info
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_loc_Course_Info.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_loc_Course_Info.setNew(n);
	}

	/**
	* Sets the primary key of this loc_ course_ info.
	*
	* @param primaryKey the primary key of this loc_ course_ info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loc_Course_Info.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_loc_Course_Info.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the to date of this loc_ course_ info.
	*
	* @param toDate the to date of this loc_ course_ info
	*/
	@Override
	public void setToDate(Date toDate) {
		_loc_Course_Info.setToDate(toDate);
	}

	/**
	* Sets the user ID of this loc_ course_ info.
	*
	* @param userId the user ID of this loc_ course_ info
	*/
	@Override
	public void setUserId(long userId) {
		_loc_Course_Info.setUserId(userId);
	}

	/**
	* Sets the user name of this loc_ course_ info.
	*
	* @param userName the user name of this loc_ course_ info
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_loc_Course_Info.setUserName(userName);
	}

	/**
	* Sets the user uuid of this loc_ course_ info.
	*
	* @param userUuid the user uuid of this loc_ course_ info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_loc_Course_Info.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this loc_ course_ info.
	*
	* @param uuid the uuid of this loc_ course_ info
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_loc_Course_Info.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Loc_Course_InfoWrapper)) {
			return false;
		}

		Loc_Course_InfoWrapper loc_Course_InfoWrapper = (Loc_Course_InfoWrapper)obj;

		if (Objects.equals(_loc_Course_Info,
					loc_Course_InfoWrapper._loc_Course_Info)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _loc_Course_Info.getStagedModelType();
	}

	@Override
	public Loc_Course_Info getWrappedModel() {
		return _loc_Course_Info;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _loc_Course_Info.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _loc_Course_Info.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_loc_Course_Info.resetOriginalValues();
	}

	private final Loc_Course_Info _loc_Course_Info;
}