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

package com.ddt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.ddt.model.Loc_Course_Info;

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
 * The cache model class for representing Loc_Course_Info in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_Info
 * @generated
 */
@ProviderType
public class Loc_Course_InfoCacheModel implements CacheModel<Loc_Course_Info>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Loc_Course_InfoCacheModel)) {
			return false;
		}

		Loc_Course_InfoCacheModel loc_Course_InfoCacheModel = (Loc_Course_InfoCacheModel)obj;

		if (id == loc_Course_InfoCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", couserId=");
		sb.append(couserId);
		sb.append(", locationName=");
		sb.append(locationName);
		sb.append(", couserName=");
		sb.append(couserName);
		sb.append(", maxSeats=");
		sb.append(maxSeats);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", Fees=");
		sb.append(Fees);
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
	public Loc_Course_Info toEntityModel() {
		Loc_Course_InfoImpl loc_Course_InfoImpl = new Loc_Course_InfoImpl();

		if (uuid == null) {
			loc_Course_InfoImpl.setUuid(StringPool.BLANK);
		}
		else {
			loc_Course_InfoImpl.setUuid(uuid);
		}

		loc_Course_InfoImpl.setId(id);
		loc_Course_InfoImpl.setLocationId(locationId);
		loc_Course_InfoImpl.setCouserId(couserId);

		if (locationName == null) {
			loc_Course_InfoImpl.setLocationName(StringPool.BLANK);
		}
		else {
			loc_Course_InfoImpl.setLocationName(locationName);
		}

		if (couserName == null) {
			loc_Course_InfoImpl.setCouserName(StringPool.BLANK);
		}
		else {
			loc_Course_InfoImpl.setCouserName(couserName);
		}

		loc_Course_InfoImpl.setMaxSeats(maxSeats);

		if (toDate == Long.MIN_VALUE) {
			loc_Course_InfoImpl.setToDate(null);
		}
		else {
			loc_Course_InfoImpl.setToDate(new Date(toDate));
		}

		if (fromDate == Long.MIN_VALUE) {
			loc_Course_InfoImpl.setFromDate(null);
		}
		else {
			loc_Course_InfoImpl.setFromDate(new Date(fromDate));
		}

		loc_Course_InfoImpl.setFees(Fees);
		loc_Course_InfoImpl.setCompanyId(companyId);
		loc_Course_InfoImpl.setUserId(userId);

		if (userName == null) {
			loc_Course_InfoImpl.setUserName(StringPool.BLANK);
		}
		else {
			loc_Course_InfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loc_Course_InfoImpl.setCreateDate(null);
		}
		else {
			loc_Course_InfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loc_Course_InfoImpl.setModifiedDate(null);
		}
		else {
			loc_Course_InfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		loc_Course_InfoImpl.resetOriginalValues();

		return loc_Course_InfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		locationId = objectInput.readLong();

		couserId = objectInput.readLong();
		locationName = objectInput.readUTF();
		couserName = objectInput.readUTF();

		maxSeats = objectInput.readLong();
		toDate = objectInput.readLong();
		fromDate = objectInput.readLong();

		Fees = objectInput.readLong();

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

		objectOutput.writeLong(id);

		objectOutput.writeLong(locationId);

		objectOutput.writeLong(couserId);

		if (locationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationName);
		}

		if (couserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(couserName);
		}

		objectOutput.writeLong(maxSeats);
		objectOutput.writeLong(toDate);
		objectOutput.writeLong(fromDate);

		objectOutput.writeLong(Fees);

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
	public long id;
	public long locationId;
	public long couserId;
	public String locationName;
	public String couserName;
	public long maxSeats;
	public long toDate;
	public long fromDate;
	public long Fees;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}