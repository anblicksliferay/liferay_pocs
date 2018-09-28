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

package com.delphi.userprofile.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.delphi.userprofile.model.UserProfile;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @generated
 */
@ProviderType
public class UserProfileCacheModel implements CacheModel<UserProfile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserProfileCacheModel)) {
			return false;
		}

		UserProfileCacheModel userProfileCacheModel = (UserProfileCacheModel)obj;

		if (profileId == userProfileCacheModel.profileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, profileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", profileId=");
		sb.append(profileId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdById=");
		sb.append(createdById);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", communicationPreferences=");
		sb.append(communicationPreferences);
		sb.append(", region=");
		sb.append(region);
		sb.append(", site=");
		sb.append(site);
		sb.append(", server=");
		sb.append(server);
		sb.append(", division=");
		sb.append(division);
		sb.append(", language=");
		sb.append(language);
		sb.append(", timezone=");
		sb.append(timezone);
		sb.append(", workHours=");
		sb.append(workHours);
		sb.append(", jobrole=");
		sb.append(jobrole);
		sb.append(", interests=");
		sb.append(interests);
		sb.append(", portlets=");
		sb.append(portlets);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserProfile toEntityModel() {
		UserProfileImpl userProfileImpl = new UserProfileImpl();

		if (uuid == null) {
			userProfileImpl.setUuid(StringPool.BLANK);
		}
		else {
			userProfileImpl.setUuid(uuid);
		}

		userProfileImpl.setProfileId(profileId);
		userProfileImpl.setUserId(userId);
		userProfileImpl.setCompanyId(companyId);
		userProfileImpl.setCreatedById(createdById);

		if (createDate == Long.MIN_VALUE) {
			userProfileImpl.setCreateDate(null);
		}
		else {
			userProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userProfileImpl.setModifiedDate(null);
		}
		else {
			userProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (communicationPreferences == null) {
			userProfileImpl.setCommunicationPreferences(StringPool.BLANK);
		}
		else {
			userProfileImpl.setCommunicationPreferences(communicationPreferences);
		}

		if (region == null) {
			userProfileImpl.setRegion(StringPool.BLANK);
		}
		else {
			userProfileImpl.setRegion(region);
		}

		if (site == null) {
			userProfileImpl.setSite(StringPool.BLANK);
		}
		else {
			userProfileImpl.setSite(site);
		}

		if (server == null) {
			userProfileImpl.setServer(StringPool.BLANK);
		}
		else {
			userProfileImpl.setServer(server);
		}

		if (division == null) {
			userProfileImpl.setDivision(StringPool.BLANK);
		}
		else {
			userProfileImpl.setDivision(division);
		}

		if (language == null) {
			userProfileImpl.setLanguage(StringPool.BLANK);
		}
		else {
			userProfileImpl.setLanguage(language);
		}

		if (timezone == null) {
			userProfileImpl.setTimezone(StringPool.BLANK);
		}
		else {
			userProfileImpl.setTimezone(timezone);
		}

		if (workHours == null) {
			userProfileImpl.setWorkHours(StringPool.BLANK);
		}
		else {
			userProfileImpl.setWorkHours(workHours);
		}

		if (jobrole == null) {
			userProfileImpl.setJobrole(StringPool.BLANK);
		}
		else {
			userProfileImpl.setJobrole(jobrole);
		}

		if (interests == null) {
			userProfileImpl.setInterests(StringPool.BLANK);
		}
		else {
			userProfileImpl.setInterests(interests);
		}

		if (portlets == null) {
			userProfileImpl.setPortlets(StringPool.BLANK);
		}
		else {
			userProfileImpl.setPortlets(portlets);
		}

		userProfileImpl.resetOriginalValues();

		return userProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		profileId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdById = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		communicationPreferences = objectInput.readUTF();
		region = objectInput.readUTF();
		site = objectInput.readUTF();
		server = objectInput.readUTF();
		division = objectInput.readUTF();
		language = objectInput.readUTF();
		timezone = objectInput.readUTF();
		workHours = objectInput.readUTF();
		jobrole = objectInput.readUTF();
		interests = objectInput.readUTF();
		portlets = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(profileId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdById);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (communicationPreferences == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(communicationPreferences);
		}

		if (region == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(region);
		}

		if (site == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(site);
		}

		if (server == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(server);
		}

		if (division == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (language == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (timezone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timezone);
		}

		if (workHours == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workHours);
		}

		if (jobrole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobrole);
		}

		if (interests == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(interests);
		}

		if (portlets == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portlets);
		}
	}

	public String uuid;
	public long profileId;
	public long userId;
	public long companyId;
	public long createdById;
	public long createDate;
	public long modifiedDate;
	public String communicationPreferences;
	public String region;
	public String site;
	public String server;
	public String division;
	public String language;
	public String timezone;
	public String workHours;
	public String jobrole;
	public String interests;
	public String portlets;
}