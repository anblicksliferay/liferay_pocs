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

import com.delphi.userprofile.model.AdminTasks;
import com.delphi.userprofile.service.persistence.AdminTasksPK;

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
 * The cache model class for representing AdminTasks in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasks
 * @generated
 */
@ProviderType
public class AdminTasksCacheModel implements CacheModel<AdminTasks>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdminTasksCacheModel)) {
			return false;
		}

		AdminTasksCacheModel adminTasksCacheModel = (AdminTasksCacheModel)obj;

		if (adminTasksPK.equals(adminTasksCacheModel.adminTasksPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, adminTasksPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", adminTaskId=");
		sb.append(adminTaskId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", systemAlert=");
		sb.append(systemAlert);
		sb.append(", messageText=");
		sb.append(messageText);
		sb.append(", postOnPortBanner=");
		sb.append(postOnPortBanner);
		sb.append(", siteAlert=");
		sb.append(siteAlert);
		sb.append(", siteName=");
		sb.append(siteName);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdById=");
		sb.append(createdById);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdminTasks toEntityModel() {
		AdminTasksImpl adminTasksImpl = new AdminTasksImpl();

		if (uuid == null) {
			adminTasksImpl.setUuid(StringPool.BLANK);
		}
		else {
			adminTasksImpl.setUuid(uuid);
		}

		adminTasksImpl.setAdminTaskId(adminTaskId);
		adminTasksImpl.setUserId(userId);
		adminTasksImpl.setSystemAlert(systemAlert);

		if (messageText == null) {
			adminTasksImpl.setMessageText(StringPool.BLANK);
		}
		else {
			adminTasksImpl.setMessageText(messageText);
		}

		adminTasksImpl.setPostOnPortBanner(postOnPortBanner);
		adminTasksImpl.setSiteAlert(siteAlert);

		if (siteName == null) {
			adminTasksImpl.setSiteName(StringPool.BLANK);
		}
		else {
			adminTasksImpl.setSiteName(siteName);
		}

		adminTasksImpl.setCompanyId(companyId);
		adminTasksImpl.setCreatedById(createdById);

		if (createDate == Long.MIN_VALUE) {
			adminTasksImpl.setCreateDate(null);
		}
		else {
			adminTasksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adminTasksImpl.setModifiedDate(null);
		}
		else {
			adminTasksImpl.setModifiedDate(new Date(modifiedDate));
		}

		adminTasksImpl.resetOriginalValues();

		return adminTasksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		adminTaskId = objectInput.readLong();

		userId = objectInput.readLong();

		systemAlert = objectInput.readBoolean();
		messageText = objectInput.readUTF();

		postOnPortBanner = objectInput.readBoolean();

		siteAlert = objectInput.readBoolean();
		siteName = objectInput.readUTF();

		companyId = objectInput.readLong();

		createdById = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		adminTasksPK = new AdminTasksPK(adminTaskId, userId);
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

		objectOutput.writeLong(adminTaskId);

		objectOutput.writeLong(userId);

		objectOutput.writeBoolean(systemAlert);

		if (messageText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageText);
		}

		objectOutput.writeBoolean(postOnPortBanner);

		objectOutput.writeBoolean(siteAlert);

		if (siteName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(siteName);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdById);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long adminTaskId;
	public long userId;
	public boolean systemAlert;
	public String messageText;
	public boolean postOnPortBanner;
	public boolean siteAlert;
	public String siteName;
	public long companyId;
	public long createdById;
	public long createDate;
	public long modifiedDate;
	public transient AdminTasksPK adminTasksPK;
}