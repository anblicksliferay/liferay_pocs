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

package com.all.ddtiservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.all.ddtiservice.model.course;

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
 * The cache model class for representing course in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see course
 * @generated
 */
@ProviderType
public class courseCacheModel implements CacheModel<course>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof courseCacheModel)) {
			return false;
		}

		courseCacheModel courseCacheModel = (courseCacheModel)obj;

		if (courseId == courseCacheModel.courseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, courseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", courseName=");
		sb.append(courseName);
		sb.append(", fee=");
		sb.append(fee);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", maxseats=");
		sb.append(maxseats);
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
	public course toEntityModel() {
		courseImpl courseImpl = new courseImpl();

		if (uuid == null) {
			courseImpl.setUuid(StringPool.BLANK);
		}
		else {
			courseImpl.setUuid(uuid);
		}

		courseImpl.setCourseId(courseId);

		if (courseName == null) {
			courseImpl.setCourseName(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseName(courseName);
		}

		courseImpl.setFee(fee);

		if (startDate == Long.MIN_VALUE) {
			courseImpl.setStartDate(null);
		}
		else {
			courseImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			courseImpl.setEndDate(null);
		}
		else {
			courseImpl.setEndDate(new Date(endDate));
		}

		courseImpl.setMaxseats(maxseats);
		courseImpl.setGroupId(groupId);
		courseImpl.setCompanyId(companyId);
		courseImpl.setUserId(userId);

		if (userName == null) {
			courseImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseImpl.setCreateDate(null);
		}
		else {
			courseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseImpl.setModifiedDate(null);
		}
		else {
			courseImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		courseId = objectInput.readLong();
		courseName = objectInput.readUTF();

		fee = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		maxseats = objectInput.readLong();

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

		objectOutput.writeLong(courseId);

		if (courseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseName);
		}

		objectOutput.writeLong(fee);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeLong(maxseats);

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
	public long courseId;
	public String courseName;
	public long fee;
	public long startDate;
	public long endDate;
	public long maxseats;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}