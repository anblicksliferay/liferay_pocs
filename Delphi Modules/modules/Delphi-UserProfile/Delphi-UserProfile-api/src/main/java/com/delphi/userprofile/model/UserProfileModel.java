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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserProfile service. Represents a row in the &quot;Delphi_UserProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.delphi.userprofile.model.impl.UserProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.delphi.userprofile.model.impl.UserProfileImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @see com.delphi.userprofile.model.impl.UserProfileImpl
 * @see com.delphi.userprofile.model.impl.UserProfileModelImpl
 * @generated
 */
@ProviderType
public interface UserProfileModel extends BaseModel<UserProfile>, ShardedModel,
	StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user profile model instance should use the {@link UserProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this user profile.
	 *
	 * @return the primary key of this user profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user profile.
	 *
	 * @param primaryKey the primary key of this user profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this user profile.
	 *
	 * @return the uuid of this user profile
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this user profile.
	 *
	 * @param uuid the uuid of this user profile
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the profile ID of this user profile.
	 *
	 * @return the profile ID of this user profile
	 */
	public long getProfileId();

	/**
	 * Sets the profile ID of this user profile.
	 *
	 * @param profileId the profile ID of this user profile
	 */
	public void setProfileId(long profileId);

	/**
	 * Returns the user ID of this user profile.
	 *
	 * @return the user ID of this user profile
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user profile.
	 *
	 * @param userId the user ID of this user profile
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user profile.
	 *
	 * @return the user uuid of this user profile
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this user profile.
	 *
	 * @param userUuid the user uuid of this user profile
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the company ID of this user profile.
	 *
	 * @return the company ID of this user profile
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this user profile.
	 *
	 * @param companyId the company ID of this user profile
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created by ID of this user profile.
	 *
	 * @return the created by ID of this user profile
	 */
	public long getCreatedById();

	/**
	 * Sets the created by ID of this user profile.
	 *
	 * @param createdById the created by ID of this user profile
	 */
	public void setCreatedById(long createdById);

	/**
	 * Returns the create date of this user profile.
	 *
	 * @return the create date of this user profile
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this user profile.
	 *
	 * @param createDate the create date of this user profile
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this user profile.
	 *
	 * @return the modified date of this user profile
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this user profile.
	 *
	 * @param modifiedDate the modified date of this user profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the communication preferences of this user profile.
	 *
	 * @return the communication preferences of this user profile
	 */
	@AutoEscape
	public String getCommunicationPreferences();

	/**
	 * Sets the communication preferences of this user profile.
	 *
	 * @param communicationPreferences the communication preferences of this user profile
	 */
	public void setCommunicationPreferences(String communicationPreferences);

	/**
	 * Returns the region of this user profile.
	 *
	 * @return the region of this user profile
	 */
	@AutoEscape
	public String getRegion();

	/**
	 * Sets the region of this user profile.
	 *
	 * @param region the region of this user profile
	 */
	public void setRegion(String region);

	/**
	 * Returns the site of this user profile.
	 *
	 * @return the site of this user profile
	 */
	@AutoEscape
	public String getSite();

	/**
	 * Sets the site of this user profile.
	 *
	 * @param site the site of this user profile
	 */
	public void setSite(String site);

	/**
	 * Returns the server of this user profile.
	 *
	 * @return the server of this user profile
	 */
	@AutoEscape
	public String getServer();

	/**
	 * Sets the server of this user profile.
	 *
	 * @param server the server of this user profile
	 */
	public void setServer(String server);

	/**
	 * Returns the division of this user profile.
	 *
	 * @return the division of this user profile
	 */
	@AutoEscape
	public String getDivision();

	/**
	 * Sets the division of this user profile.
	 *
	 * @param division the division of this user profile
	 */
	public void setDivision(String division);

	/**
	 * Returns the language of this user profile.
	 *
	 * @return the language of this user profile
	 */
	@AutoEscape
	public String getLanguage();

	/**
	 * Sets the language of this user profile.
	 *
	 * @param language the language of this user profile
	 */
	public void setLanguage(String language);

	/**
	 * Returns the timezone of this user profile.
	 *
	 * @return the timezone of this user profile
	 */
	@AutoEscape
	public String getTimezone();

	/**
	 * Sets the timezone of this user profile.
	 *
	 * @param timezone the timezone of this user profile
	 */
	public void setTimezone(String timezone);

	/**
	 * Returns the work hours of this user profile.
	 *
	 * @return the work hours of this user profile
	 */
	@AutoEscape
	public String getWorkHours();

	/**
	 * Sets the work hours of this user profile.
	 *
	 * @param workHours the work hours of this user profile
	 */
	public void setWorkHours(String workHours);

	/**
	 * Returns the jobrole of this user profile.
	 *
	 * @return the jobrole of this user profile
	 */
	@AutoEscape
	public String getJobrole();

	/**
	 * Sets the jobrole of this user profile.
	 *
	 * @param jobrole the jobrole of this user profile
	 */
	public void setJobrole(String jobrole);

	/**
	 * Returns the interests of this user profile.
	 *
	 * @return the interests of this user profile
	 */
	@AutoEscape
	public String getInterests();

	/**
	 * Sets the interests of this user profile.
	 *
	 * @param interests the interests of this user profile
	 */
	public void setInterests(String interests);

	/**
	 * Returns the portlets of this user profile.
	 *
	 * @return the portlets of this user profile
	 */
	@AutoEscape
	public String getPortlets();

	/**
	 * Sets the portlets of this user profile.
	 *
	 * @param portlets the portlets of this user profile
	 */
	public void setPortlets(String portlets);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(UserProfile userProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserProfile> toCacheModel();

	@Override
	public UserProfile toEscapedModel();

	@Override
	public UserProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}