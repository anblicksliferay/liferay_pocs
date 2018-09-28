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

package com.MappingServices.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.MappingServices.model.UserExternal;

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
 * The cache model class for representing UserExternal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternal
 * @generated
 */
@ProviderType
public class UserExternalCacheModel implements CacheModel<UserExternal>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserExternalCacheModel)) {
			return false;
		}

		UserExternalCacheModel userExternalCacheModel = (UserExternalCacheModel)obj;

		if (uid == userExternalCacheModel.uid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, uid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", uid=");
		sb.append(uid);
		sb.append(", Location=");
		sb.append(Location);
		sb.append(", PolicyNumber=");
		sb.append(PolicyNumber);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserExternal toEntityModel() {
		UserExternalImpl userExternalImpl = new UserExternalImpl();

		if (uuid == null) {
			userExternalImpl.setUuid(StringPool.BLANK);
		}
		else {
			userExternalImpl.setUuid(uuid);
		}

		userExternalImpl.setUid(uid);

		if (Location == null) {
			userExternalImpl.setLocation(StringPool.BLANK);
		}
		else {
			userExternalImpl.setLocation(Location);
		}

		if (PolicyNumber == null) {
			userExternalImpl.setPolicyNumber(StringPool.BLANK);
		}
		else {
			userExternalImpl.setPolicyNumber(PolicyNumber);
		}

		if (createDate == Long.MIN_VALUE) {
			userExternalImpl.setCreateDate(null);
		}
		else {
			userExternalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userExternalImpl.setModifiedDate(null);
		}
		else {
			userExternalImpl.setModifiedDate(new Date(modifiedDate));
		}

		userExternalImpl.resetOriginalValues();

		return userExternalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		uid = objectInput.readLong();
		Location = objectInput.readUTF();
		PolicyNumber = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(uid);

		if (Location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Location);
		}

		if (PolicyNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PolicyNumber);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long uid;
	public String Location;
	public String PolicyNumber;
	public long createDate;
	public long modifiedDate;
}