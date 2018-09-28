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

package com.delphi.userprofile.model;

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
 * This class is a wrapper for {@link AdminTasks}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasks
 * @generated
 */
@ProviderType
public class AdminTasksWrapper implements AdminTasks, ModelWrapper<AdminTasks> {
	public AdminTasksWrapper(AdminTasks adminTasks) {
		_adminTasks = adminTasks;
	}

	@Override
	public Class<?> getModelClass() {
		return AdminTasks.class;
	}

	@Override
	public String getModelClassName() {
		return AdminTasks.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("adminTaskId", getAdminTaskId());
		attributes.put("userId", getUserId());
		attributes.put("systemAlert", getSystemAlert());
		attributes.put("messageText", getMessageText());
		attributes.put("postOnPortBanner", getPostOnPortBanner());
		attributes.put("siteAlert", getSiteAlert());
		attributes.put("siteName", getSiteName());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdById", getCreatedById());
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

		Long adminTaskId = (Long)attributes.get("adminTaskId");

		if (adminTaskId != null) {
			setAdminTaskId(adminTaskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean systemAlert = (Boolean)attributes.get("systemAlert");

		if (systemAlert != null) {
			setSystemAlert(systemAlert);
		}

		String messageText = (String)attributes.get("messageText");

		if (messageText != null) {
			setMessageText(messageText);
		}

		Boolean postOnPortBanner = (Boolean)attributes.get("postOnPortBanner");

		if (postOnPortBanner != null) {
			setPostOnPortBanner(postOnPortBanner);
		}

		Boolean siteAlert = (Boolean)attributes.get("siteAlert");

		if (siteAlert != null) {
			setSiteAlert(siteAlert);
		}

		String siteName = (String)attributes.get("siteName");

		if (siteName != null) {
			setSiteName(siteName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdById = (Long)attributes.get("createdById");

		if (createdById != null) {
			setCreatedById(createdById);
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
	public AdminTasks toEscapedModel() {
		return new AdminTasksWrapper(_adminTasks.toEscapedModel());
	}

	@Override
	public AdminTasks toUnescapedModel() {
		return new AdminTasksWrapper(_adminTasks.toUnescapedModel());
	}

	/**
	* Returns the post on port banner of this admin tasks.
	*
	* @return the post on port banner of this admin tasks
	*/
	@Override
	public boolean getPostOnPortBanner() {
		return _adminTasks.getPostOnPortBanner();
	}

	/**
	* Returns the site alert of this admin tasks.
	*
	* @return the site alert of this admin tasks
	*/
	@Override
	public boolean getSiteAlert() {
		return _adminTasks.getSiteAlert();
	}

	/**
	* Returns the system alert of this admin tasks.
	*
	* @return the system alert of this admin tasks
	*/
	@Override
	public boolean getSystemAlert() {
		return _adminTasks.getSystemAlert();
	}

	@Override
	public boolean isCachedModel() {
		return _adminTasks.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _adminTasks.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _adminTasks.isNew();
	}

	/**
	* Returns <code>true</code> if this admin tasks is post on port banner.
	*
	* @return <code>true</code> if this admin tasks is post on port banner; <code>false</code> otherwise
	*/
	@Override
	public boolean isPostOnPortBanner() {
		return _adminTasks.isPostOnPortBanner();
	}

	/**
	* Returns <code>true</code> if this admin tasks is site alert.
	*
	* @return <code>true</code> if this admin tasks is site alert; <code>false</code> otherwise
	*/
	@Override
	public boolean isSiteAlert() {
		return _adminTasks.isSiteAlert();
	}

	/**
	* Returns <code>true</code> if this admin tasks is system alert.
	*
	* @return <code>true</code> if this admin tasks is system alert; <code>false</code> otherwise
	*/
	@Override
	public boolean isSystemAlert() {
		return _adminTasks.isSystemAlert();
	}

	/**
	* Returns the primary key of this admin tasks.
	*
	* @return the primary key of this admin tasks
	*/
	@Override
	public com.delphi.userprofile.service.persistence.AdminTasksPK getPrimaryKey() {
		return _adminTasks.getPrimaryKey();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _adminTasks.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AdminTasks> toCacheModel() {
		return _adminTasks.toCacheModel();
	}

	@Override
	public int compareTo(AdminTasks adminTasks) {
		return _adminTasks.compareTo(adminTasks);
	}

	@Override
	public int hashCode() {
		return _adminTasks.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _adminTasks.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AdminTasksWrapper((AdminTasks)_adminTasks.clone());
	}

	/**
	* Returns the message text of this admin tasks.
	*
	* @return the message text of this admin tasks
	*/
	@Override
	public java.lang.String getMessageText() {
		return _adminTasks.getMessageText();
	}

	/**
	* Returns the site name of this admin tasks.
	*
	* @return the site name of this admin tasks
	*/
	@Override
	public java.lang.String getSiteName() {
		return _adminTasks.getSiteName();
	}

	/**
	* Returns the user uuid of this admin tasks.
	*
	* @return the user uuid of this admin tasks
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _adminTasks.getUserUuid();
	}

	/**
	* Returns the uuid of this admin tasks.
	*
	* @return the uuid of this admin tasks
	*/
	@Override
	public java.lang.String getUuid() {
		return _adminTasks.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _adminTasks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adminTasks.toXmlString();
	}

	/**
	* Returns the create date of this admin tasks.
	*
	* @return the create date of this admin tasks
	*/
	@Override
	public Date getCreateDate() {
		return _adminTasks.getCreateDate();
	}

	/**
	* Returns the modified date of this admin tasks.
	*
	* @return the modified date of this admin tasks
	*/
	@Override
	public Date getModifiedDate() {
		return _adminTasks.getModifiedDate();
	}

	/**
	* Returns the admin task ID of this admin tasks.
	*
	* @return the admin task ID of this admin tasks
	*/
	@Override
	public long getAdminTaskId() {
		return _adminTasks.getAdminTaskId();
	}

	/**
	* Returns the company ID of this admin tasks.
	*
	* @return the company ID of this admin tasks
	*/
	@Override
	public long getCompanyId() {
		return _adminTasks.getCompanyId();
	}

	/**
	* Returns the created by ID of this admin tasks.
	*
	* @return the created by ID of this admin tasks
	*/
	@Override
	public long getCreatedById() {
		return _adminTasks.getCreatedById();
	}

	/**
	* Returns the user ID of this admin tasks.
	*
	* @return the user ID of this admin tasks
	*/
	@Override
	public long getUserId() {
		return _adminTasks.getUserId();
	}

	@Override
	public void persist() {
		_adminTasks.persist();
	}

	/**
	* Sets the admin task ID of this admin tasks.
	*
	* @param adminTaskId the admin task ID of this admin tasks
	*/
	@Override
	public void setAdminTaskId(long adminTaskId) {
		_adminTasks.setAdminTaskId(adminTaskId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adminTasks.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this admin tasks.
	*
	* @param companyId the company ID of this admin tasks
	*/
	@Override
	public void setCompanyId(long companyId) {
		_adminTasks.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this admin tasks.
	*
	* @param createDate the create date of this admin tasks
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_adminTasks.setCreateDate(createDate);
	}

	/**
	* Sets the created by ID of this admin tasks.
	*
	* @param createdById the created by ID of this admin tasks
	*/
	@Override
	public void setCreatedById(long createdById) {
		_adminTasks.setCreatedById(createdById);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_adminTasks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_adminTasks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_adminTasks.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the message text of this admin tasks.
	*
	* @param messageText the message text of this admin tasks
	*/
	@Override
	public void setMessageText(java.lang.String messageText) {
		_adminTasks.setMessageText(messageText);
	}

	/**
	* Sets the modified date of this admin tasks.
	*
	* @param modifiedDate the modified date of this admin tasks
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_adminTasks.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_adminTasks.setNew(n);
	}

	/**
	* Sets whether this admin tasks is post on port banner.
	*
	* @param postOnPortBanner the post on port banner of this admin tasks
	*/
	@Override
	public void setPostOnPortBanner(boolean postOnPortBanner) {
		_adminTasks.setPostOnPortBanner(postOnPortBanner);
	}

	/**
	* Sets the primary key of this admin tasks.
	*
	* @param primaryKey the primary key of this admin tasks
	*/
	@Override
	public void setPrimaryKey(
		com.delphi.userprofile.service.persistence.AdminTasksPK primaryKey) {
		_adminTasks.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_adminTasks.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this admin tasks is site alert.
	*
	* @param siteAlert the site alert of this admin tasks
	*/
	@Override
	public void setSiteAlert(boolean siteAlert) {
		_adminTasks.setSiteAlert(siteAlert);
	}

	/**
	* Sets the site name of this admin tasks.
	*
	* @param siteName the site name of this admin tasks
	*/
	@Override
	public void setSiteName(java.lang.String siteName) {
		_adminTasks.setSiteName(siteName);
	}

	/**
	* Sets whether this admin tasks is system alert.
	*
	* @param systemAlert the system alert of this admin tasks
	*/
	@Override
	public void setSystemAlert(boolean systemAlert) {
		_adminTasks.setSystemAlert(systemAlert);
	}

	/**
	* Sets the user ID of this admin tasks.
	*
	* @param userId the user ID of this admin tasks
	*/
	@Override
	public void setUserId(long userId) {
		_adminTasks.setUserId(userId);
	}

	/**
	* Sets the user uuid of this admin tasks.
	*
	* @param userUuid the user uuid of this admin tasks
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_adminTasks.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this admin tasks.
	*
	* @param uuid the uuid of this admin tasks
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_adminTasks.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdminTasksWrapper)) {
			return false;
		}

		AdminTasksWrapper adminTasksWrapper = (AdminTasksWrapper)obj;

		if (Objects.equals(_adminTasks, adminTasksWrapper._adminTasks)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _adminTasks.getStagedModelType();
	}

	@Override
	public AdminTasks getWrappedModel() {
		return _adminTasks;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _adminTasks.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _adminTasks.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_adminTasks.resetOriginalValues();
	}

	private final AdminTasks _adminTasks;
}