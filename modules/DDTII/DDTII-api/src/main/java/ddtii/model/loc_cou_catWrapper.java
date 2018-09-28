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
 * This class is a wrapper for {@link loc_cou_cat}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_cat
 * @generated
 */
@ProviderType
public class loc_cou_catWrapper implements loc_cou_cat,
	ModelWrapper<loc_cou_cat> {
	public loc_cou_catWrapper(loc_cou_cat loc_cou_cat) {
		_loc_cou_cat = loc_cou_cat;
	}

	@Override
	public Class<?> getModelClass() {
		return loc_cou_cat.class;
	}

	@Override
	public String getModelClassName() {
		return loc_cou_cat.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loc_cou_catId", getLoc_cou_catId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("courseId", getCourseId());
		attributes.put("locationId", getLocationId());
		attributes.put("durationString", getDurationString());
		attributes.put("durationLong", getDurationLong());
		attributes.put("startDate_", getStartDate_());
		attributes.put("endDate_", getEndDate_());
		attributes.put("maxSeats", getMaxSeats());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long loc_cou_catId = (Long)attributes.get("loc_cou_catId");

		if (loc_cou_catId != null) {
			setLoc_cou_catId(loc_cou_catId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String durationString = (String)attributes.get("durationString");

		if (durationString != null) {
			setDurationString(durationString);
		}

		Long durationLong = (Long)attributes.get("durationLong");

		if (durationLong != null) {
			setDurationLong(durationLong);
		}

		Date startDate_ = (Date)attributes.get("startDate_");

		if (startDate_ != null) {
			setStartDate_(startDate_);
		}

		Date endDate_ = (Date)attributes.get("endDate_");

		if (endDate_ != null) {
			setEndDate_(endDate_);
		}

		Long maxSeats = (Long)attributes.get("maxSeats");

		if (maxSeats != null) {
			setMaxSeats(maxSeats);
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
		return _loc_cou_cat.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _loc_cou_cat.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _loc_cou_cat.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _loc_cou_cat.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ddtii.model.loc_cou_cat> toCacheModel() {
		return _loc_cou_cat.toCacheModel();
	}

	@Override
	public ddtii.model.loc_cou_cat toEscapedModel() {
		return new loc_cou_catWrapper(_loc_cou_cat.toEscapedModel());
	}

	@Override
	public ddtii.model.loc_cou_cat toUnescapedModel() {
		return new loc_cou_catWrapper(_loc_cou_cat.toUnescapedModel());
	}

	@Override
	public int compareTo(ddtii.model.loc_cou_cat loc_cou_cat) {
		return _loc_cou_cat.compareTo(loc_cou_cat);
	}

	@Override
	public int hashCode() {
		return _loc_cou_cat.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loc_cou_cat.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new loc_cou_catWrapper((loc_cou_cat)_loc_cou_cat.clone());
	}

	/**
	* Returns the duration string of this loc_cou_cat.
	*
	* @return the duration string of this loc_cou_cat
	*/
	@Override
	public java.lang.String getDurationString() {
		return _loc_cou_cat.getDurationString();
	}

	/**
	* Returns the user name of this loc_cou_cat.
	*
	* @return the user name of this loc_cou_cat
	*/
	@Override
	public java.lang.String getUserName() {
		return _loc_cou_cat.getUserName();
	}

	/**
	* Returns the user uuid of this loc_cou_cat.
	*
	* @return the user uuid of this loc_cou_cat
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _loc_cou_cat.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _loc_cou_cat.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loc_cou_cat.toXmlString();
	}

	/**
	* Returns the create date of this loc_cou_cat.
	*
	* @return the create date of this loc_cou_cat
	*/
	@Override
	public Date getCreateDate() {
		return _loc_cou_cat.getCreateDate();
	}

	/**
	* Returns the end date_ of this loc_cou_cat.
	*
	* @return the end date_ of this loc_cou_cat
	*/
	@Override
	public Date getEndDate_() {
		return _loc_cou_cat.getEndDate_();
	}

	/**
	* Returns the modified date of this loc_cou_cat.
	*
	* @return the modified date of this loc_cou_cat
	*/
	@Override
	public Date getModifiedDate() {
		return _loc_cou_cat.getModifiedDate();
	}

	/**
	* Returns the start date_ of this loc_cou_cat.
	*
	* @return the start date_ of this loc_cou_cat
	*/
	@Override
	public Date getStartDate_() {
		return _loc_cou_cat.getStartDate_();
	}

	/**
	* Returns the category ID of this loc_cou_cat.
	*
	* @return the category ID of this loc_cou_cat
	*/
	@Override
	public long getCategoryId() {
		return _loc_cou_cat.getCategoryId();
	}

	/**
	* Returns the company ID of this loc_cou_cat.
	*
	* @return the company ID of this loc_cou_cat
	*/
	@Override
	public long getCompanyId() {
		return _loc_cou_cat.getCompanyId();
	}

	/**
	* Returns the course ID of this loc_cou_cat.
	*
	* @return the course ID of this loc_cou_cat
	*/
	@Override
	public long getCourseId() {
		return _loc_cou_cat.getCourseId();
	}

	/**
	* Returns the duration long of this loc_cou_cat.
	*
	* @return the duration long of this loc_cou_cat
	*/
	@Override
	public long getDurationLong() {
		return _loc_cou_cat.getDurationLong();
	}

	/**
	* Returns the loc_cou_cat ID of this loc_cou_cat.
	*
	* @return the loc_cou_cat ID of this loc_cou_cat
	*/
	@Override
	public long getLoc_cou_catId() {
		return _loc_cou_cat.getLoc_cou_catId();
	}

	/**
	* Returns the location ID of this loc_cou_cat.
	*
	* @return the location ID of this loc_cou_cat
	*/
	@Override
	public long getLocationId() {
		return _loc_cou_cat.getLocationId();
	}

	/**
	* Returns the max seats of this loc_cou_cat.
	*
	* @return the max seats of this loc_cou_cat
	*/
	@Override
	public long getMaxSeats() {
		return _loc_cou_cat.getMaxSeats();
	}

	/**
	* Returns the primary key of this loc_cou_cat.
	*
	* @return the primary key of this loc_cou_cat
	*/
	@Override
	public long getPrimaryKey() {
		return _loc_cou_cat.getPrimaryKey();
	}

	/**
	* Returns the user ID of this loc_cou_cat.
	*
	* @return the user ID of this loc_cou_cat
	*/
	@Override
	public long getUserId() {
		return _loc_cou_cat.getUserId();
	}

	@Override
	public void persist() {
		_loc_cou_cat.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loc_cou_cat.setCachedModel(cachedModel);
	}

	/**
	* Sets the category ID of this loc_cou_cat.
	*
	* @param categoryId the category ID of this loc_cou_cat
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_loc_cou_cat.setCategoryId(categoryId);
	}

	/**
	* Sets the company ID of this loc_cou_cat.
	*
	* @param companyId the company ID of this loc_cou_cat
	*/
	@Override
	public void setCompanyId(long companyId) {
		_loc_cou_cat.setCompanyId(companyId);
	}

	/**
	* Sets the course ID of this loc_cou_cat.
	*
	* @param courseId the course ID of this loc_cou_cat
	*/
	@Override
	public void setCourseId(long courseId) {
		_loc_cou_cat.setCourseId(courseId);
	}

	/**
	* Sets the create date of this loc_cou_cat.
	*
	* @param createDate the create date of this loc_cou_cat
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_loc_cou_cat.setCreateDate(createDate);
	}

	/**
	* Sets the duration long of this loc_cou_cat.
	*
	* @param durationLong the duration long of this loc_cou_cat
	*/
	@Override
	public void setDurationLong(long durationLong) {
		_loc_cou_cat.setDurationLong(durationLong);
	}

	/**
	* Sets the duration string of this loc_cou_cat.
	*
	* @param durationString the duration string of this loc_cou_cat
	*/
	@Override
	public void setDurationString(java.lang.String durationString) {
		_loc_cou_cat.setDurationString(durationString);
	}

	/**
	* Sets the end date_ of this loc_cou_cat.
	*
	* @param endDate_ the end date_ of this loc_cou_cat
	*/
	@Override
	public void setEndDate_(Date endDate_) {
		_loc_cou_cat.setEndDate_(endDate_);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_loc_cou_cat.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_loc_cou_cat.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_loc_cou_cat.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the loc_cou_cat ID of this loc_cou_cat.
	*
	* @param loc_cou_catId the loc_cou_cat ID of this loc_cou_cat
	*/
	@Override
	public void setLoc_cou_catId(long loc_cou_catId) {
		_loc_cou_cat.setLoc_cou_catId(loc_cou_catId);
	}

	/**
	* Sets the location ID of this loc_cou_cat.
	*
	* @param locationId the location ID of this loc_cou_cat
	*/
	@Override
	public void setLocationId(long locationId) {
		_loc_cou_cat.setLocationId(locationId);
	}

	/**
	* Sets the max seats of this loc_cou_cat.
	*
	* @param maxSeats the max seats of this loc_cou_cat
	*/
	@Override
	public void setMaxSeats(long maxSeats) {
		_loc_cou_cat.setMaxSeats(maxSeats);
	}

	/**
	* Sets the modified date of this loc_cou_cat.
	*
	* @param modifiedDate the modified date of this loc_cou_cat
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_loc_cou_cat.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_loc_cou_cat.setNew(n);
	}

	/**
	* Sets the primary key of this loc_cou_cat.
	*
	* @param primaryKey the primary key of this loc_cou_cat
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loc_cou_cat.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_loc_cou_cat.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date_ of this loc_cou_cat.
	*
	* @param startDate_ the start date_ of this loc_cou_cat
	*/
	@Override
	public void setStartDate_(Date startDate_) {
		_loc_cou_cat.setStartDate_(startDate_);
	}

	/**
	* Sets the user ID of this loc_cou_cat.
	*
	* @param userId the user ID of this loc_cou_cat
	*/
	@Override
	public void setUserId(long userId) {
		_loc_cou_cat.setUserId(userId);
	}

	/**
	* Sets the user name of this loc_cou_cat.
	*
	* @param userName the user name of this loc_cou_cat
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_loc_cou_cat.setUserName(userName);
	}

	/**
	* Sets the user uuid of this loc_cou_cat.
	*
	* @param userUuid the user uuid of this loc_cou_cat
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_loc_cou_cat.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof loc_cou_catWrapper)) {
			return false;
		}

		loc_cou_catWrapper loc_cou_catWrapper = (loc_cou_catWrapper)obj;

		if (Objects.equals(_loc_cou_cat, loc_cou_catWrapper._loc_cou_cat)) {
			return true;
		}

		return false;
	}

	@Override
	public loc_cou_cat getWrappedModel() {
		return _loc_cou_cat;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _loc_cou_cat.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _loc_cou_cat.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_loc_cou_cat.resetOriginalValues();
	}

	private final loc_cou_cat _loc_cou_cat;
}