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

package com.servicemapping.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.servicemapping.model.registrationDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing registrationDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetails
 * @generated
 */
@ProviderType
public class registrationDetailsCacheModel implements CacheModel<registrationDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof registrationDetailsCacheModel)) {
			return false;
		}

		registrationDetailsCacheModel registrationDetailsCacheModel = (registrationDetailsCacheModel)obj;

		if (registrationId == registrationDetailsCacheModel.registrationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registrationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", registrationId=");
		sb.append(registrationId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", surName=");
		sb.append(surName);
		sb.append(", address=");
		sb.append(address);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", imagepath=");
		sb.append(imagepath);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public registrationDetails toEntityModel() {
		registrationDetailsImpl registrationDetailsImpl = new registrationDetailsImpl();

		if (uuid == null) {
			registrationDetailsImpl.setUuid(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setUuid(uuid);
		}

		registrationDetailsImpl.setRegistrationId(registrationId);

		if (firstName == null) {
			registrationDetailsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			registrationDetailsImpl.setLastName(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setLastName(lastName);
		}

		if (surName == null) {
			registrationDetailsImpl.setSurName(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setSurName(surName);
		}

		if (address == null) {
			registrationDetailsImpl.setAddress(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setAddress(address);
		}

		registrationDetailsImpl.setContactNumber(contactNumber);
		registrationDetailsImpl.setGender(gender);

		if (imagepath == null) {
			registrationDetailsImpl.setImagepath(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setImagepath(imagepath);
		}

		registrationDetailsImpl.setGroupId(groupId);
		registrationDetailsImpl.setCompanyId(companyId);
		registrationDetailsImpl.setUserId(userId);

		if (userName == null) {
			registrationDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			registrationDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			registrationDetailsImpl.setCreateDate(null);
		}
		else {
			registrationDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registrationDetailsImpl.setModifiedDate(null);
		}
		else {
			registrationDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		registrationDetailsImpl.resetOriginalValues();

		return registrationDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		registrationId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		surName = objectInput.readUTF();
		address = objectInput.readUTF();

		contactNumber = objectInput.readLong();

		gender = objectInput.readBoolean();
		imagepath = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
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

		objectOutput.writeLong(registrationId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (surName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surName);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(contactNumber);

		objectOutput.writeBoolean(gender);

		if (imagepath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imagepath);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long registrationId;
	public String firstName;
	public String lastName;
	public String surName;
	public String address;
	public long contactNumber;
	public boolean gender;
	public String imagepath;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}