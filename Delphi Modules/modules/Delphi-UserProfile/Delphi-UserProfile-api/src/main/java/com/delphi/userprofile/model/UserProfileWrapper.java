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
 * This class is a wrapper for {@link UserProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @generated
 */
@ProviderType
public class UserProfileWrapper implements UserProfile,
	ModelWrapper<UserProfile> {
	public UserProfileWrapper(UserProfile userProfile) {
		_userProfile = userProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return UserProfile.class;
	}

	@Override
	public String getModelClassName() {
		return UserProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("profileId", getProfileId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdById", getCreatedById());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("communicationPreferences", getCommunicationPreferences());
		attributes.put("region", getRegion());
		attributes.put("site", getSite());
		attributes.put("server", getServer());
		attributes.put("division", getDivision());
		attributes.put("language", getLanguage());
		attributes.put("timezone", getTimezone());
		attributes.put("workHours", getWorkHours());
		attributes.put("jobrole", getJobrole());
		attributes.put("interests", getInterests());
		attributes.put("portlets", getPortlets());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
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

		String communicationPreferences = (String)attributes.get(
				"communicationPreferences");

		if (communicationPreferences != null) {
			setCommunicationPreferences(communicationPreferences);
		}

		String region = (String)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		String site = (String)attributes.get("site");

		if (site != null) {
			setSite(site);
		}

		String server = (String)attributes.get("server");

		if (server != null) {
			setServer(server);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String timezone = (String)attributes.get("timezone");

		if (timezone != null) {
			setTimezone(timezone);
		}

		String workHours = (String)attributes.get("workHours");

		if (workHours != null) {
			setWorkHours(workHours);
		}

		String jobrole = (String)attributes.get("jobrole");

		if (jobrole != null) {
			setJobrole(jobrole);
		}

		String interests = (String)attributes.get("interests");

		if (interests != null) {
			setInterests(interests);
		}

		String portlets = (String)attributes.get("portlets");

		if (portlets != null) {
			setPortlets(portlets);
		}
	}

	@Override
	public UserProfile toEscapedModel() {
		return new UserProfileWrapper(_userProfile.toEscapedModel());
	}

	@Override
	public UserProfile toUnescapedModel() {
		return new UserProfileWrapper(_userProfile.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _userProfile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userProfile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userProfile.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userProfile.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserProfile> toCacheModel() {
		return _userProfile.toCacheModel();
	}

	@Override
	public int compareTo(UserProfile userProfile) {
		return _userProfile.compareTo(userProfile);
	}

	@Override
	public int hashCode() {
		return _userProfile.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userProfile.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserProfileWrapper((UserProfile)_userProfile.clone());
	}

	/**
	* Returns the communication preferences of this user profile.
	*
	* @return the communication preferences of this user profile
	*/
	@Override
	public java.lang.String getCommunicationPreferences() {
		return _userProfile.getCommunicationPreferences();
	}

	/**
	* Returns the division of this user profile.
	*
	* @return the division of this user profile
	*/
	@Override
	public java.lang.String getDivision() {
		return _userProfile.getDivision();
	}

	/**
	* Returns the interests of this user profile.
	*
	* @return the interests of this user profile
	*/
	@Override
	public java.lang.String getInterests() {
		return _userProfile.getInterests();
	}

	/**
	* Returns the jobrole of this user profile.
	*
	* @return the jobrole of this user profile
	*/
	@Override
	public java.lang.String getJobrole() {
		return _userProfile.getJobrole();
	}

	/**
	* Returns the language of this user profile.
	*
	* @return the language of this user profile
	*/
	@Override
	public java.lang.String getLanguage() {
		return _userProfile.getLanguage();
	}

	/**
	* Returns the portlets of this user profile.
	*
	* @return the portlets of this user profile
	*/
	@Override
	public java.lang.String getPortlets() {
		return _userProfile.getPortlets();
	}

	/**
	* Returns the region of this user profile.
	*
	* @return the region of this user profile
	*/
	@Override
	public java.lang.String getRegion() {
		return _userProfile.getRegion();
	}

	/**
	* Returns the server of this user profile.
	*
	* @return the server of this user profile
	*/
	@Override
	public java.lang.String getServer() {
		return _userProfile.getServer();
	}

	/**
	* Returns the site of this user profile.
	*
	* @return the site of this user profile
	*/
	@Override
	public java.lang.String getSite() {
		return _userProfile.getSite();
	}

	/**
	* Returns the timezone of this user profile.
	*
	* @return the timezone of this user profile
	*/
	@Override
	public java.lang.String getTimezone() {
		return _userProfile.getTimezone();
	}

	/**
	* Returns the user uuid of this user profile.
	*
	* @return the user uuid of this user profile
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userProfile.getUserUuid();
	}

	/**
	* Returns the uuid of this user profile.
	*
	* @return the uuid of this user profile
	*/
	@Override
	public java.lang.String getUuid() {
		return _userProfile.getUuid();
	}

	/**
	* Returns the work hours of this user profile.
	*
	* @return the work hours of this user profile
	*/
	@Override
	public java.lang.String getWorkHours() {
		return _userProfile.getWorkHours();
	}

	@Override
	public java.lang.String toString() {
		return _userProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userProfile.toXmlString();
	}

	/**
	* Returns the create date of this user profile.
	*
	* @return the create date of this user profile
	*/
	@Override
	public Date getCreateDate() {
		return _userProfile.getCreateDate();
	}

	/**
	* Returns the modified date of this user profile.
	*
	* @return the modified date of this user profile
	*/
	@Override
	public Date getModifiedDate() {
		return _userProfile.getModifiedDate();
	}

	/**
	* Returns the company ID of this user profile.
	*
	* @return the company ID of this user profile
	*/
	@Override
	public long getCompanyId() {
		return _userProfile.getCompanyId();
	}

	/**
	* Returns the created by ID of this user profile.
	*
	* @return the created by ID of this user profile
	*/
	@Override
	public long getCreatedById() {
		return _userProfile.getCreatedById();
	}

	/**
	* Returns the primary key of this user profile.
	*
	* @return the primary key of this user profile
	*/
	@Override
	public long getPrimaryKey() {
		return _userProfile.getPrimaryKey();
	}

	/**
	* Returns the profile ID of this user profile.
	*
	* @return the profile ID of this user profile
	*/
	@Override
	public long getProfileId() {
		return _userProfile.getProfileId();
	}

	/**
	* Returns the user ID of this user profile.
	*
	* @return the user ID of this user profile
	*/
	@Override
	public long getUserId() {
		return _userProfile.getUserId();
	}

	@Override
	public void persist() {
		_userProfile.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userProfile.setCachedModel(cachedModel);
	}

	/**
	* Sets the communication preferences of this user profile.
	*
	* @param communicationPreferences the communication preferences of this user profile
	*/
	@Override
	public void setCommunicationPreferences(
		java.lang.String communicationPreferences) {
		_userProfile.setCommunicationPreferences(communicationPreferences);
	}

	/**
	* Sets the company ID of this user profile.
	*
	* @param companyId the company ID of this user profile
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userProfile.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this user profile.
	*
	* @param createDate the create date of this user profile
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userProfile.setCreateDate(createDate);
	}

	/**
	* Sets the created by ID of this user profile.
	*
	* @param createdById the created by ID of this user profile
	*/
	@Override
	public void setCreatedById(long createdById) {
		_userProfile.setCreatedById(createdById);
	}

	/**
	* Sets the division of this user profile.
	*
	* @param division the division of this user profile
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_userProfile.setDivision(division);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userProfile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the interests of this user profile.
	*
	* @param interests the interests of this user profile
	*/
	@Override
	public void setInterests(java.lang.String interests) {
		_userProfile.setInterests(interests);
	}

	/**
	* Sets the jobrole of this user profile.
	*
	* @param jobrole the jobrole of this user profile
	*/
	@Override
	public void setJobrole(java.lang.String jobrole) {
		_userProfile.setJobrole(jobrole);
	}

	/**
	* Sets the language of this user profile.
	*
	* @param language the language of this user profile
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_userProfile.setLanguage(language);
	}

	/**
	* Sets the modified date of this user profile.
	*
	* @param modifiedDate the modified date of this user profile
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userProfile.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userProfile.setNew(n);
	}

	/**
	* Sets the portlets of this user profile.
	*
	* @param portlets the portlets of this user profile
	*/
	@Override
	public void setPortlets(java.lang.String portlets) {
		_userProfile.setPortlets(portlets);
	}

	/**
	* Sets the primary key of this user profile.
	*
	* @param primaryKey the primary key of this user profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userProfile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the profile ID of this user profile.
	*
	* @param profileId the profile ID of this user profile
	*/
	@Override
	public void setProfileId(long profileId) {
		_userProfile.setProfileId(profileId);
	}

	/**
	* Sets the region of this user profile.
	*
	* @param region the region of this user profile
	*/
	@Override
	public void setRegion(java.lang.String region) {
		_userProfile.setRegion(region);
	}

	/**
	* Sets the server of this user profile.
	*
	* @param server the server of this user profile
	*/
	@Override
	public void setServer(java.lang.String server) {
		_userProfile.setServer(server);
	}

	/**
	* Sets the site of this user profile.
	*
	* @param site the site of this user profile
	*/
	@Override
	public void setSite(java.lang.String site) {
		_userProfile.setSite(site);
	}

	/**
	* Sets the timezone of this user profile.
	*
	* @param timezone the timezone of this user profile
	*/
	@Override
	public void setTimezone(java.lang.String timezone) {
		_userProfile.setTimezone(timezone);
	}

	/**
	* Sets the user ID of this user profile.
	*
	* @param userId the user ID of this user profile
	*/
	@Override
	public void setUserId(long userId) {
		_userProfile.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user profile.
	*
	* @param userUuid the user uuid of this user profile
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userProfile.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this user profile.
	*
	* @param uuid the uuid of this user profile
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userProfile.setUuid(uuid);
	}

	/**
	* Sets the work hours of this user profile.
	*
	* @param workHours the work hours of this user profile
	*/
	@Override
	public void setWorkHours(java.lang.String workHours) {
		_userProfile.setWorkHours(workHours);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserProfileWrapper)) {
			return false;
		}

		UserProfileWrapper userProfileWrapper = (UserProfileWrapper)obj;

		if (Objects.equals(_userProfile, userProfileWrapper._userProfile)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _userProfile.getStagedModelType();
	}

	@Override
	public UserProfile getWrappedModel() {
		return _userProfile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userProfile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userProfile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userProfile.resetOriginalValues();
	}

	private final UserProfile _userProfile;
}