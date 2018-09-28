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
 * This class is a wrapper for {@link UserAccessRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequest
 * @generated
 */
@ProviderType
public class UserAccessRequestWrapper implements UserAccessRequest,
	ModelWrapper<UserAccessRequest> {
	public UserAccessRequestWrapper(UserAccessRequest userAccessRequest) {
		_userAccessRequest = userAccessRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return UserAccessRequest.class;
	}

	@Override
	public String getModelClassName() {
		return UserAccessRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("requestId", getRequestId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdById", getCreatedById());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("portletAccess", getPortletAccess());
		attributes.put("requestType", getRequestType());
		attributes.put("responseType", getResponseType());
		attributes.put("responseComment", getResponseComment());
		attributes.put("responseUser", getResponseUser());
		attributes.put("activeState", getActiveState());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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

		String portletAccess = (String)attributes.get("portletAccess");

		if (portletAccess != null) {
			setPortletAccess(portletAccess);
		}

		String requestType = (String)attributes.get("requestType");

		if (requestType != null) {
			setRequestType(requestType);
		}

		String responseType = (String)attributes.get("responseType");

		if (responseType != null) {
			setResponseType(responseType);
		}

		String responseComment = (String)attributes.get("responseComment");

		if (responseComment != null) {
			setResponseComment(responseComment);
		}

		Long responseUser = (Long)attributes.get("responseUser");

		if (responseUser != null) {
			setResponseUser(responseUser);
		}

		Integer activeState = (Integer)attributes.get("activeState");

		if (activeState != null) {
			setActiveState(activeState);
		}
	}

	@Override
	public UserAccessRequest toEscapedModel() {
		return new UserAccessRequestWrapper(_userAccessRequest.toEscapedModel());
	}

	@Override
	public UserAccessRequest toUnescapedModel() {
		return new UserAccessRequestWrapper(_userAccessRequest.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _userAccessRequest.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userAccessRequest.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userAccessRequest.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userAccessRequest.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserAccessRequest> toCacheModel() {
		return _userAccessRequest.toCacheModel();
	}

	@Override
	public int compareTo(UserAccessRequest userAccessRequest) {
		return _userAccessRequest.compareTo(userAccessRequest);
	}

	/**
	* Returns the active state of this user access request.
	*
	* @return the active state of this user access request
	*/
	@Override
	public int getActiveState() {
		return _userAccessRequest.getActiveState();
	}

	@Override
	public int hashCode() {
		return _userAccessRequest.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userAccessRequest.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserAccessRequestWrapper((UserAccessRequest)_userAccessRequest.clone());
	}

	/**
	* Returns the portlet access of this user access request.
	*
	* @return the portlet access of this user access request
	*/
	@Override
	public java.lang.String getPortletAccess() {
		return _userAccessRequest.getPortletAccess();
	}

	/**
	* Returns the request type of this user access request.
	*
	* @return the request type of this user access request
	*/
	@Override
	public java.lang.String getRequestType() {
		return _userAccessRequest.getRequestType();
	}

	/**
	* Returns the response comment of this user access request.
	*
	* @return the response comment of this user access request
	*/
	@Override
	public java.lang.String getResponseComment() {
		return _userAccessRequest.getResponseComment();
	}

	/**
	* Returns the response type of this user access request.
	*
	* @return the response type of this user access request
	*/
	@Override
	public java.lang.String getResponseType() {
		return _userAccessRequest.getResponseType();
	}

	/**
	* Returns the user uuid of this user access request.
	*
	* @return the user uuid of this user access request
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userAccessRequest.getUserUuid();
	}

	/**
	* Returns the uuid of this user access request.
	*
	* @return the uuid of this user access request
	*/
	@Override
	public java.lang.String getUuid() {
		return _userAccessRequest.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userAccessRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userAccessRequest.toXmlString();
	}

	/**
	* Returns the create date of this user access request.
	*
	* @return the create date of this user access request
	*/
	@Override
	public Date getCreateDate() {
		return _userAccessRequest.getCreateDate();
	}

	/**
	* Returns the modified date of this user access request.
	*
	* @return the modified date of this user access request
	*/
	@Override
	public Date getModifiedDate() {
		return _userAccessRequest.getModifiedDate();
	}

	/**
	* Returns the company ID of this user access request.
	*
	* @return the company ID of this user access request
	*/
	@Override
	public long getCompanyId() {
		return _userAccessRequest.getCompanyId();
	}

	/**
	* Returns the created by ID of this user access request.
	*
	* @return the created by ID of this user access request
	*/
	@Override
	public long getCreatedById() {
		return _userAccessRequest.getCreatedById();
	}

	/**
	* Returns the primary key of this user access request.
	*
	* @return the primary key of this user access request
	*/
	@Override
	public long getPrimaryKey() {
		return _userAccessRequest.getPrimaryKey();
	}

	/**
	* Returns the request ID of this user access request.
	*
	* @return the request ID of this user access request
	*/
	@Override
	public long getRequestId() {
		return _userAccessRequest.getRequestId();
	}

	/**
	* Returns the response user of this user access request.
	*
	* @return the response user of this user access request
	*/
	@Override
	public long getResponseUser() {
		return _userAccessRequest.getResponseUser();
	}

	/**
	* Returns the user ID of this user access request.
	*
	* @return the user ID of this user access request
	*/
	@Override
	public long getUserId() {
		return _userAccessRequest.getUserId();
	}

	@Override
	public void persist() {
		_userAccessRequest.persist();
	}

	/**
	* Sets the active state of this user access request.
	*
	* @param activeState the active state of this user access request
	*/
	@Override
	public void setActiveState(int activeState) {
		_userAccessRequest.setActiveState(activeState);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userAccessRequest.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this user access request.
	*
	* @param companyId the company ID of this user access request
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userAccessRequest.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this user access request.
	*
	* @param createDate the create date of this user access request
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userAccessRequest.setCreateDate(createDate);
	}

	/**
	* Sets the created by ID of this user access request.
	*
	* @param createdById the created by ID of this user access request
	*/
	@Override
	public void setCreatedById(long createdById) {
		_userAccessRequest.setCreatedById(createdById);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userAccessRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userAccessRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userAccessRequest.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this user access request.
	*
	* @param modifiedDate the modified date of this user access request
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userAccessRequest.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userAccessRequest.setNew(n);
	}

	/**
	* Sets the portlet access of this user access request.
	*
	* @param portletAccess the portlet access of this user access request
	*/
	@Override
	public void setPortletAccess(java.lang.String portletAccess) {
		_userAccessRequest.setPortletAccess(portletAccess);
	}

	/**
	* Sets the primary key of this user access request.
	*
	* @param primaryKey the primary key of this user access request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userAccessRequest.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userAccessRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the request ID of this user access request.
	*
	* @param requestId the request ID of this user access request
	*/
	@Override
	public void setRequestId(long requestId) {
		_userAccessRequest.setRequestId(requestId);
	}

	/**
	* Sets the request type of this user access request.
	*
	* @param requestType the request type of this user access request
	*/
	@Override
	public void setRequestType(java.lang.String requestType) {
		_userAccessRequest.setRequestType(requestType);
	}

	/**
	* Sets the response comment of this user access request.
	*
	* @param responseComment the response comment of this user access request
	*/
	@Override
	public void setResponseComment(java.lang.String responseComment) {
		_userAccessRequest.setResponseComment(responseComment);
	}

	/**
	* Sets the response type of this user access request.
	*
	* @param responseType the response type of this user access request
	*/
	@Override
	public void setResponseType(java.lang.String responseType) {
		_userAccessRequest.setResponseType(responseType);
	}

	/**
	* Sets the response user of this user access request.
	*
	* @param responseUser the response user of this user access request
	*/
	@Override
	public void setResponseUser(long responseUser) {
		_userAccessRequest.setResponseUser(responseUser);
	}

	/**
	* Sets the user ID of this user access request.
	*
	* @param userId the user ID of this user access request
	*/
	@Override
	public void setUserId(long userId) {
		_userAccessRequest.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user access request.
	*
	* @param userUuid the user uuid of this user access request
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userAccessRequest.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this user access request.
	*
	* @param uuid the uuid of this user access request
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userAccessRequest.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserAccessRequestWrapper)) {
			return false;
		}

		UserAccessRequestWrapper userAccessRequestWrapper = (UserAccessRequestWrapper)obj;

		if (Objects.equals(_userAccessRequest,
					userAccessRequestWrapper._userAccessRequest)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _userAccessRequest.getStagedModelType();
	}

	@Override
	public UserAccessRequest getWrappedModel() {
		return _userAccessRequest;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userAccessRequest.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userAccessRequest.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userAccessRequest.resetOriginalValues();
	}

	private final UserAccessRequest _userAccessRequest;
}