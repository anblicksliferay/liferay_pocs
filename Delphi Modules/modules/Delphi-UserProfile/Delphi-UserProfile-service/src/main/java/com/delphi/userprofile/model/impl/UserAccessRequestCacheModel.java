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

import com.delphi.userprofile.model.UserAccessRequest;

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
 * The cache model class for representing UserAccessRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequest
 * @generated
 */
@ProviderType
public class UserAccessRequestCacheModel implements CacheModel<UserAccessRequest>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserAccessRequestCacheModel)) {
			return false;
		}

		UserAccessRequestCacheModel userAccessRequestCacheModel = (UserAccessRequestCacheModel)obj;

		if (requestId == userAccessRequestCacheModel.requestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, requestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", requestId=");
		sb.append(requestId);
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
		sb.append(", portletAccess=");
		sb.append(portletAccess);
		sb.append(", requestType=");
		sb.append(requestType);
		sb.append(", responseType=");
		sb.append(responseType);
		sb.append(", responseComment=");
		sb.append(responseComment);
		sb.append(", responseUser=");
		sb.append(responseUser);
		sb.append(", activeState=");
		sb.append(activeState);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserAccessRequest toEntityModel() {
		UserAccessRequestImpl userAccessRequestImpl = new UserAccessRequestImpl();

		if (uuid == null) {
			userAccessRequestImpl.setUuid(StringPool.BLANK);
		}
		else {
			userAccessRequestImpl.setUuid(uuid);
		}

		userAccessRequestImpl.setRequestId(requestId);
		userAccessRequestImpl.setUserId(userId);
		userAccessRequestImpl.setCompanyId(companyId);
		userAccessRequestImpl.setCreatedById(createdById);

		if (createDate == Long.MIN_VALUE) {
			userAccessRequestImpl.setCreateDate(null);
		}
		else {
			userAccessRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userAccessRequestImpl.setModifiedDate(null);
		}
		else {
			userAccessRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (portletAccess == null) {
			userAccessRequestImpl.setPortletAccess(StringPool.BLANK);
		}
		else {
			userAccessRequestImpl.setPortletAccess(portletAccess);
		}

		if (requestType == null) {
			userAccessRequestImpl.setRequestType(StringPool.BLANK);
		}
		else {
			userAccessRequestImpl.setRequestType(requestType);
		}

		if (responseType == null) {
			userAccessRequestImpl.setResponseType(StringPool.BLANK);
		}
		else {
			userAccessRequestImpl.setResponseType(responseType);
		}

		if (responseComment == null) {
			userAccessRequestImpl.setResponseComment(StringPool.BLANK);
		}
		else {
			userAccessRequestImpl.setResponseComment(responseComment);
		}

		userAccessRequestImpl.setResponseUser(responseUser);
		userAccessRequestImpl.setActiveState(activeState);

		userAccessRequestImpl.resetOriginalValues();

		return userAccessRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		requestId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdById = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		portletAccess = objectInput.readUTF();
		requestType = objectInput.readUTF();
		responseType = objectInput.readUTF();
		responseComment = objectInput.readUTF();

		responseUser = objectInput.readLong();

		activeState = objectInput.readInt();
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

		objectOutput.writeLong(requestId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdById);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (portletAccess == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletAccess);
		}

		if (requestType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestType);
		}

		if (responseType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(responseType);
		}

		if (responseComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(responseComment);
		}

		objectOutput.writeLong(responseUser);

		objectOutput.writeInt(activeState);
	}

	public String uuid;
	public long requestId;
	public long userId;
	public long companyId;
	public long createdById;
	public long createDate;
	public long modifiedDate;
	public String portletAccess;
	public String requestType;
	public String responseType;
	public String responseComment;
	public long responseUser;
	public int activeState;
}