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
 * This class is a wrapper for {@link course}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see course
 * @generated
 */
@ProviderType
public class courseWrapper implements course, ModelWrapper<course> {
	public courseWrapper(course course) {
		_course = course;
	}

	@Override
	public Class<?> getModelClass() {
		return course.class;
	}

	@Override
	public String getModelClassName() {
		return course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("courseId", getCourseId());
		attributes.put("courseName", getCourseName());
		attributes.put("fee", getFee());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("maxseats", getMaxseats());
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

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		String courseName = (String)attributes.get("courseName");

		if (courseName != null) {
			setCourseName(courseName);
		}

		Long fee = (Long)attributes.get("fee");

		if (fee != null) {
			setFee(fee);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long maxseats = (Long)attributes.get("maxseats");

		if (maxseats != null) {
			setMaxseats(maxseats);
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

	@Override
	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _course.isNew();
	}

	@Override
	public com.all.ddtiservice.model.course toEscapedModel() {
		return new courseWrapper(_course.toEscapedModel());
	}

	@Override
	public com.all.ddtiservice.model.course toUnescapedModel() {
		return new courseWrapper(_course.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.all.ddtiservice.model.course> toCacheModel() {
		return _course.toCacheModel();
	}

	@Override
	public int compareTo(com.all.ddtiservice.model.course course) {
		return _course.compareTo(course);
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new courseWrapper((course)_course.clone());
	}

	/**
	* Returns the course name of this course.
	*
	* @return the course name of this course
	*/
	@Override
	public java.lang.String getCourseName() {
		return _course.getCourseName();
	}

	/**
	* Returns the user name of this course.
	*
	* @return the user name of this course
	*/
	@Override
	public java.lang.String getUserName() {
		return _course.getUserName();
	}

	/**
	* Returns the user uuid of this course.
	*
	* @return the user uuid of this course
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _course.getUserUuid();
	}

	/**
	* Returns the uuid of this course.
	*
	* @return the uuid of this course
	*/
	@Override
	public java.lang.String getUuid() {
		return _course.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _course.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	/**
	* Returns the create date of this course.
	*
	* @return the create date of this course
	*/
	@Override
	public Date getCreateDate() {
		return _course.getCreateDate();
	}

	/**
	* Returns the end date of this course.
	*
	* @return the end date of this course
	*/
	@Override
	public Date getEndDate() {
		return _course.getEndDate();
	}

	/**
	* Returns the modified date of this course.
	*
	* @return the modified date of this course
	*/
	@Override
	public Date getModifiedDate() {
		return _course.getModifiedDate();
	}

	/**
	* Returns the start date of this course.
	*
	* @return the start date of this course
	*/
	@Override
	public Date getStartDate() {
		return _course.getStartDate();
	}

	/**
	* Returns the company ID of this course.
	*
	* @return the company ID of this course
	*/
	@Override
	public long getCompanyId() {
		return _course.getCompanyId();
	}

	/**
	* Returns the course ID of this course.
	*
	* @return the course ID of this course
	*/
	@Override
	public long getCourseId() {
		return _course.getCourseId();
	}

	/**
	* Returns the fee of this course.
	*
	* @return the fee of this course
	*/
	@Override
	public long getFee() {
		return _course.getFee();
	}

	/**
	* Returns the group ID of this course.
	*
	* @return the group ID of this course
	*/
	@Override
	public long getGroupId() {
		return _course.getGroupId();
	}

	/**
	* Returns the maxseats of this course.
	*
	* @return the maxseats of this course
	*/
	@Override
	public long getMaxseats() {
		return _course.getMaxseats();
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	@Override
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	/**
	* Returns the user ID of this course.
	*
	* @return the user ID of this course
	*/
	@Override
	public long getUserId() {
		return _course.getUserId();
	}

	@Override
	public void persist() {
		_course.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this course.
	*
	* @param companyId the company ID of this course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_course.setCompanyId(companyId);
	}

	/**
	* Sets the course ID of this course.
	*
	* @param courseId the course ID of this course
	*/
	@Override
	public void setCourseId(long courseId) {
		_course.setCourseId(courseId);
	}

	/**
	* Sets the course name of this course.
	*
	* @param courseName the course name of this course
	*/
	@Override
	public void setCourseName(java.lang.String courseName) {
		_course.setCourseName(courseName);
	}

	/**
	* Sets the create date of this course.
	*
	* @param createDate the create date of this course
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_course.setCreateDate(createDate);
	}

	/**
	* Sets the end date of this course.
	*
	* @param endDate the end date of this course
	*/
	@Override
	public void setEndDate(Date endDate) {
		_course.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_course.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_course.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fee of this course.
	*
	* @param fee the fee of this course
	*/
	@Override
	public void setFee(long fee) {
		_course.setFee(fee);
	}

	/**
	* Sets the group ID of this course.
	*
	* @param groupId the group ID of this course
	*/
	@Override
	public void setGroupId(long groupId) {
		_course.setGroupId(groupId);
	}

	/**
	* Sets the maxseats of this course.
	*
	* @param maxseats the maxseats of this course
	*/
	@Override
	public void setMaxseats(long maxseats) {
		_course.setMaxseats(maxseats);
	}

	/**
	* Sets the modified date of this course.
	*
	* @param modifiedDate the modified date of this course
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_course.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_course.setNew(n);
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this course.
	*
	* @param startDate the start date of this course
	*/
	@Override
	public void setStartDate(Date startDate) {
		_course.setStartDate(startDate);
	}

	/**
	* Sets the user ID of this course.
	*
	* @param userId the user ID of this course
	*/
	@Override
	public void setUserId(long userId) {
		_course.setUserId(userId);
	}

	/**
	* Sets the user name of this course.
	*
	* @param userName the user name of this course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_course.setUserName(userName);
	}

	/**
	* Sets the user uuid of this course.
	*
	* @param userUuid the user uuid of this course
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_course.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this course.
	*
	* @param uuid the uuid of this course
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_course.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof courseWrapper)) {
			return false;
		}

		courseWrapper courseWrapper = (courseWrapper)obj;

		if (Objects.equals(_course, courseWrapper._course)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _course.getStagedModelType();
	}

	@Override
	public course getWrappedModel() {
		return _course;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _course.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _course.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private final course _course;
}