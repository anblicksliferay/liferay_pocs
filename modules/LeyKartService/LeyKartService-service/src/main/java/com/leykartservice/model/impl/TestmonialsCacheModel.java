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

package com.leykartservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.leykartservice.model.Testmonials;

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
 * The cache model class for representing Testmonials in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Testmonials
 * @generated
 */
@ProviderType
public class TestmonialsCacheModel implements CacheModel<Testmonials>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestmonialsCacheModel)) {
			return false;
		}

		TestmonialsCacheModel testmonialsCacheModel = (TestmonialsCacheModel)obj;

		if (testmonialsId == testmonialsCacheModel.testmonialsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, testmonialsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", testmonialsId=");
		sb.append(testmonialsId);
		sb.append(", fullname=");
		sb.append(fullname);
		sb.append(", imagepath=");
		sb.append(imagepath);
		sb.append(", message=");
		sb.append(message);
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
	public Testmonials toEntityModel() {
		TestmonialsImpl testmonialsImpl = new TestmonialsImpl();

		if (uuid == null) {
			testmonialsImpl.setUuid(StringPool.BLANK);
		}
		else {
			testmonialsImpl.setUuid(uuid);
		}

		testmonialsImpl.setTestmonialsId(testmonialsId);

		if (fullname == null) {
			testmonialsImpl.setFullname(StringPool.BLANK);
		}
		else {
			testmonialsImpl.setFullname(fullname);
		}

		if (imagepath == null) {
			testmonialsImpl.setImagepath(StringPool.BLANK);
		}
		else {
			testmonialsImpl.setImagepath(imagepath);
		}

		if (message == null) {
			testmonialsImpl.setMessage(StringPool.BLANK);
		}
		else {
			testmonialsImpl.setMessage(message);
		}

		testmonialsImpl.setCompanyId(companyId);
		testmonialsImpl.setUserId(userId);

		if (userName == null) {
			testmonialsImpl.setUserName(StringPool.BLANK);
		}
		else {
			testmonialsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			testmonialsImpl.setCreateDate(null);
		}
		else {
			testmonialsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			testmonialsImpl.setModifiedDate(null);
		}
		else {
			testmonialsImpl.setModifiedDate(new Date(modifiedDate));
		}

		testmonialsImpl.resetOriginalValues();

		return testmonialsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		testmonialsId = objectInput.readLong();
		fullname = objectInput.readUTF();
		imagepath = objectInput.readUTF();
		message = objectInput.readUTF();

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

		objectOutput.writeLong(testmonialsId);

		if (fullname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullname);
		}

		if (imagepath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imagepath);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

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
	public long testmonialsId;
	public String fullname;
	public String imagepath;
	public String message;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}