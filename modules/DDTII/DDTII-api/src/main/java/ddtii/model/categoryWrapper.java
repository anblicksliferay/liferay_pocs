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
 * This class is a wrapper for {@link category}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see category
 * @generated
 */
@ProviderType
public class categoryWrapper implements category, ModelWrapper<category> {
	public categoryWrapper(category category) {
		_category = category;
	}

	@Override
	public Class<?> getModelClass() {
		return category.class;
	}

	@Override
	public String getModelClassName() {
		return category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("courseId", getCourseId());
		attributes.put("locationId", getLocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
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
		return _category.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _category.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ddtii.model.category> toCacheModel() {
		return _category.toCacheModel();
	}

	@Override
	public ddtii.model.category toEscapedModel() {
		return new categoryWrapper(_category.toEscapedModel());
	}

	@Override
	public ddtii.model.category toUnescapedModel() {
		return new categoryWrapper(_category.toUnescapedModel());
	}

	@Override
	public int compareTo(ddtii.model.category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new categoryWrapper((category)_category.clone());
	}

	/**
	* Returns the category name of this category.
	*
	* @return the category name of this category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _category.getCategoryName();
	}

	/**
	* Returns the user name of this category.
	*
	* @return the user name of this category
	*/
	@Override
	public java.lang.String getUserName() {
		return _category.getUserName();
	}

	/**
	* Returns the user uuid of this category.
	*
	* @return the user uuid of this category
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _category.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	/**
	* Returns the create date of this category.
	*
	* @return the create date of this category
	*/
	@Override
	public Date getCreateDate() {
		return _category.getCreateDate();
	}

	/**
	* Returns the modified date of this category.
	*
	* @return the modified date of this category
	*/
	@Override
	public Date getModifiedDate() {
		return _category.getModifiedDate();
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	@Override
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Returns the company ID of this category.
	*
	* @return the company ID of this category
	*/
	@Override
	public long getCompanyId() {
		return _category.getCompanyId();
	}

	/**
	* Returns the course ID of this category.
	*
	* @return the course ID of this category
	*/
	@Override
	public long getCourseId() {
		return _category.getCourseId();
	}

	/**
	* Returns the location ID of this category.
	*
	* @return the location ID of this category
	*/
	@Override
	public long getLocationId() {
		return _category.getLocationId();
	}

	/**
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	@Override
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	/**
	* Returns the user ID of this category.
	*
	* @return the user ID of this category
	*/
	@Override
	public long getUserId() {
		return _category.getUserId();
	}

	@Override
	public void persist() {
		_category.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Sets the category name of this category.
	*
	* @param categoryName the category name of this category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_category.setCategoryName(categoryName);
	}

	/**
	* Sets the company ID of this category.
	*
	* @param companyId the company ID of this category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_category.setCompanyId(companyId);
	}

	/**
	* Sets the course ID of this category.
	*
	* @param courseId the course ID of this category
	*/
	@Override
	public void setCourseId(long courseId) {
		_category.setCourseId(courseId);
	}

	/**
	* Sets the create date of this category.
	*
	* @param createDate the create date of this category
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_category.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_category.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_category.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the location ID of this category.
	*
	* @param locationId the location ID of this category
	*/
	@Override
	public void setLocationId(long locationId) {
		_category.setLocationId(locationId);
	}

	/**
	* Sets the modified date of this category.
	*
	* @param modifiedDate the modified date of this category
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_category.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_category.setNew(n);
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this category.
	*
	* @param userId the user ID of this category
	*/
	@Override
	public void setUserId(long userId) {
		_category.setUserId(userId);
	}

	/**
	* Sets the user name of this category.
	*
	* @param userName the user name of this category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_category.setUserName(userName);
	}

	/**
	* Sets the user uuid of this category.
	*
	* @param userUuid the user uuid of this category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_category.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof categoryWrapper)) {
			return false;
		}

		categoryWrapper categoryWrapper = (categoryWrapper)obj;

		if (Objects.equals(_category, categoryWrapper._category)) {
			return true;
		}

		return false;
	}

	@Override
	public category getWrappedModel() {
		return _category;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _category.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _category.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private final category _category;
}