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

package com.astra.workflowservice.model;

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
 * This class is a wrapper for {@link Registration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registration
 * @generated
 */
@ProviderType
public class RegistrationWrapper implements Registration,
	ModelWrapper<Registration> {
	public RegistrationWrapper(Registration registration) {
		_registration = registration;
	}

	@Override
	public Class<?> getModelClass() {
		return Registration.class;
	}

	@Override
	public String getModelClassName() {
		return Registration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("RegistrationId", getRegistrationId());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("course", getCourse());
		attributes.put("email", getEmail());
		attributes.put("location", getLocation());
		attributes.put("status", getStatus());
		attributes.put("comments", getComments());
		attributes.put("Workflowstepnumber", getWorkflowstepnumber());
		attributes.put("WorkflowId", getWorkflowId());
		attributes.put("CurrentApprover", getCurrentApprover());
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

		Long RegistrationId = (Long)attributes.get("RegistrationId");

		if (RegistrationId != null) {
			setRegistrationId(RegistrationId);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String course = (String)attributes.get("course");

		if (course != null) {
			setCourse(course);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String Workflowstepnumber = (String)attributes.get("Workflowstepnumber");

		if (Workflowstepnumber != null) {
			setWorkflowstepnumber(Workflowstepnumber);
		}

		String WorkflowId = (String)attributes.get("WorkflowId");

		if (WorkflowId != null) {
			setWorkflowId(WorkflowId);
		}

		String CurrentApprover = (String)attributes.get("CurrentApprover");

		if (CurrentApprover != null) {
			setCurrentApprover(CurrentApprover);
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
	public Registration toEscapedModel() {
		return new RegistrationWrapper(_registration.toEscapedModel());
	}

	@Override
	public Registration toUnescapedModel() {
		return new RegistrationWrapper(_registration.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _registration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _registration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _registration.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _registration.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Registration> toCacheModel() {
		return _registration.toCacheModel();
	}

	@Override
	public int compareTo(Registration registration) {
		return _registration.compareTo(registration);
	}

	@Override
	public int hashCode() {
		return _registration.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registration.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RegistrationWrapper((Registration)_registration.clone());
	}

	/**
	* Returns the comments of this registration.
	*
	* @return the comments of this registration
	*/
	@Override
	public java.lang.String getComments() {
		return _registration.getComments();
	}

	/**
	* Returns the course of this registration.
	*
	* @return the course of this registration
	*/
	@Override
	public java.lang.String getCourse() {
		return _registration.getCourse();
	}

	/**
	* Returns the current approver of this registration.
	*
	* @return the current approver of this registration
	*/
	@Override
	public java.lang.String getCurrentApprover() {
		return _registration.getCurrentApprover();
	}

	/**
	* Returns the email of this registration.
	*
	* @return the email of this registration
	*/
	@Override
	public java.lang.String getEmail() {
		return _registration.getEmail();
	}

	/**
	* Returns the firstname of this registration.
	*
	* @return the firstname of this registration
	*/
	@Override
	public java.lang.String getFirstname() {
		return _registration.getFirstname();
	}

	/**
	* Returns the lastname of this registration.
	*
	* @return the lastname of this registration
	*/
	@Override
	public java.lang.String getLastname() {
		return _registration.getLastname();
	}

	/**
	* Returns the location of this registration.
	*
	* @return the location of this registration
	*/
	@Override
	public java.lang.String getLocation() {
		return _registration.getLocation();
	}

	/**
	* Returns the status of this registration.
	*
	* @return the status of this registration
	*/
	@Override
	public java.lang.String getStatus() {
		return _registration.getStatus();
	}

	/**
	* Returns the user name of this registration.
	*
	* @return the user name of this registration
	*/
	@Override
	public java.lang.String getUserName() {
		return _registration.getUserName();
	}

	/**
	* Returns the user uuid of this registration.
	*
	* @return the user uuid of this registration
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _registration.getUserUuid();
	}

	/**
	* Returns the uuid of this registration.
	*
	* @return the uuid of this registration
	*/
	@Override
	public java.lang.String getUuid() {
		return _registration.getUuid();
	}

	/**
	* Returns the workflow ID of this registration.
	*
	* @return the workflow ID of this registration
	*/
	@Override
	public java.lang.String getWorkflowId() {
		return _registration.getWorkflowId();
	}

	/**
	* Returns the workflowstepnumber of this registration.
	*
	* @return the workflowstepnumber of this registration
	*/
	@Override
	public java.lang.String getWorkflowstepnumber() {
		return _registration.getWorkflowstepnumber();
	}

	@Override
	public java.lang.String toString() {
		return _registration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _registration.toXmlString();
	}

	/**
	* Returns the create date of this registration.
	*
	* @return the create date of this registration
	*/
	@Override
	public Date getCreateDate() {
		return _registration.getCreateDate();
	}

	/**
	* Returns the modified date of this registration.
	*
	* @return the modified date of this registration
	*/
	@Override
	public Date getModifiedDate() {
		return _registration.getModifiedDate();
	}

	/**
	* Returns the company ID of this registration.
	*
	* @return the company ID of this registration
	*/
	@Override
	public long getCompanyId() {
		return _registration.getCompanyId();
	}

	/**
	* Returns the primary key of this registration.
	*
	* @return the primary key of this registration
	*/
	@Override
	public long getPrimaryKey() {
		return _registration.getPrimaryKey();
	}

	/**
	* Returns the registration ID of this registration.
	*
	* @return the registration ID of this registration
	*/
	@Override
	public long getRegistrationId() {
		return _registration.getRegistrationId();
	}

	/**
	* Returns the user ID of this registration.
	*
	* @return the user ID of this registration
	*/
	@Override
	public long getUserId() {
		return _registration.getUserId();
	}

	@Override
	public void persist() {
		_registration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_registration.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this registration.
	*
	* @param comments the comments of this registration
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_registration.setComments(comments);
	}

	/**
	* Sets the company ID of this registration.
	*
	* @param companyId the company ID of this registration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_registration.setCompanyId(companyId);
	}

	/**
	* Sets the course of this registration.
	*
	* @param course the course of this registration
	*/
	@Override
	public void setCourse(java.lang.String course) {
		_registration.setCourse(course);
	}

	/**
	* Sets the create date of this registration.
	*
	* @param createDate the create date of this registration
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_registration.setCreateDate(createDate);
	}

	/**
	* Sets the current approver of this registration.
	*
	* @param CurrentApprover the current approver of this registration
	*/
	@Override
	public void setCurrentApprover(java.lang.String CurrentApprover) {
		_registration.setCurrentApprover(CurrentApprover);
	}

	/**
	* Sets the email of this registration.
	*
	* @param email the email of this registration
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_registration.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_registration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_registration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_registration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the firstname of this registration.
	*
	* @param firstname the firstname of this registration
	*/
	@Override
	public void setFirstname(java.lang.String firstname) {
		_registration.setFirstname(firstname);
	}

	/**
	* Sets the lastname of this registration.
	*
	* @param lastname the lastname of this registration
	*/
	@Override
	public void setLastname(java.lang.String lastname) {
		_registration.setLastname(lastname);
	}

	/**
	* Sets the location of this registration.
	*
	* @param location the location of this registration
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_registration.setLocation(location);
	}

	/**
	* Sets the modified date of this registration.
	*
	* @param modifiedDate the modified date of this registration
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_registration.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_registration.setNew(n);
	}

	/**
	* Sets the primary key of this registration.
	*
	* @param primaryKey the primary key of this registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_registration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_registration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the registration ID of this registration.
	*
	* @param RegistrationId the registration ID of this registration
	*/
	@Override
	public void setRegistrationId(long RegistrationId) {
		_registration.setRegistrationId(RegistrationId);
	}

	/**
	* Sets the status of this registration.
	*
	* @param status the status of this registration
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_registration.setStatus(status);
	}

	/**
	* Sets the user ID of this registration.
	*
	* @param userId the user ID of this registration
	*/
	@Override
	public void setUserId(long userId) {
		_registration.setUserId(userId);
	}

	/**
	* Sets the user name of this registration.
	*
	* @param userName the user name of this registration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_registration.setUserName(userName);
	}

	/**
	* Sets the user uuid of this registration.
	*
	* @param userUuid the user uuid of this registration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_registration.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this registration.
	*
	* @param uuid the uuid of this registration
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_registration.setUuid(uuid);
	}

	/**
	* Sets the workflow ID of this registration.
	*
	* @param WorkflowId the workflow ID of this registration
	*/
	@Override
	public void setWorkflowId(java.lang.String WorkflowId) {
		_registration.setWorkflowId(WorkflowId);
	}

	/**
	* Sets the workflowstepnumber of this registration.
	*
	* @param Workflowstepnumber the workflowstepnumber of this registration
	*/
	@Override
	public void setWorkflowstepnumber(java.lang.String Workflowstepnumber) {
		_registration.setWorkflowstepnumber(Workflowstepnumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegistrationWrapper)) {
			return false;
		}

		RegistrationWrapper registrationWrapper = (RegistrationWrapper)obj;

		if (Objects.equals(_registration, registrationWrapper._registration)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _registration.getStagedModelType();
	}

	@Override
	public Registration getWrappedModel() {
		return _registration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _registration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _registration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_registration.resetOriginalValues();
	}

	private final Registration _registration;
}