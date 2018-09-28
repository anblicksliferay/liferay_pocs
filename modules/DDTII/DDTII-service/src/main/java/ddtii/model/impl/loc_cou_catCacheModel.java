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

package ddtii.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import ddtii.model.loc_cou_cat;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing loc_cou_cat in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_cat
 * @generated
 */
@ProviderType
public class loc_cou_catCacheModel implements CacheModel<loc_cou_cat>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof loc_cou_catCacheModel)) {
			return false;
		}

		loc_cou_catCacheModel loc_cou_catCacheModel = (loc_cou_catCacheModel)obj;

		if (loc_cou_catId == loc_cou_catCacheModel.loc_cou_catId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loc_cou_catId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{loc_cou_catId=");
		sb.append(loc_cou_catId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", durationString=");
		sb.append(durationString);
		sb.append(", durationLong=");
		sb.append(durationLong);
		sb.append(", startDate_=");
		sb.append(startDate_);
		sb.append(", endDate_=");
		sb.append(endDate_);
		sb.append(", maxSeats=");
		sb.append(maxSeats);
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
	public loc_cou_cat toEntityModel() {
		loc_cou_catImpl loc_cou_catImpl = new loc_cou_catImpl();

		loc_cou_catImpl.setLoc_cou_catId(loc_cou_catId);
		loc_cou_catImpl.setCategoryId(categoryId);
		loc_cou_catImpl.setCourseId(courseId);
		loc_cou_catImpl.setLocationId(locationId);

		if (durationString == null) {
			loc_cou_catImpl.setDurationString(StringPool.BLANK);
		}
		else {
			loc_cou_catImpl.setDurationString(durationString);
		}

		loc_cou_catImpl.setDurationLong(durationLong);

		if (startDate_ == Long.MIN_VALUE) {
			loc_cou_catImpl.setStartDate_(null);
		}
		else {
			loc_cou_catImpl.setStartDate_(new Date(startDate_));
		}

		if (endDate_ == Long.MIN_VALUE) {
			loc_cou_catImpl.setEndDate_(null);
		}
		else {
			loc_cou_catImpl.setEndDate_(new Date(endDate_));
		}

		loc_cou_catImpl.setMaxSeats(maxSeats);
		loc_cou_catImpl.setCompanyId(companyId);
		loc_cou_catImpl.setUserId(userId);

		if (userName == null) {
			loc_cou_catImpl.setUserName(StringPool.BLANK);
		}
		else {
			loc_cou_catImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loc_cou_catImpl.setCreateDate(null);
		}
		else {
			loc_cou_catImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loc_cou_catImpl.setModifiedDate(null);
		}
		else {
			loc_cou_catImpl.setModifiedDate(new Date(modifiedDate));
		}

		loc_cou_catImpl.resetOriginalValues();

		return loc_cou_catImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loc_cou_catId = objectInput.readLong();

		categoryId = objectInput.readLong();

		courseId = objectInput.readLong();

		locationId = objectInput.readLong();
		durationString = objectInput.readUTF();

		durationLong = objectInput.readLong();
		startDate_ = objectInput.readLong();
		endDate_ = objectInput.readLong();

		maxSeats = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(loc_cou_catId);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(courseId);

		objectOutput.writeLong(locationId);

		if (durationString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(durationString);
		}

		objectOutput.writeLong(durationLong);
		objectOutput.writeLong(startDate_);
		objectOutput.writeLong(endDate_);

		objectOutput.writeLong(maxSeats);

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

	public long loc_cou_catId;
	public long categoryId;
	public long courseId;
	public long locationId;
	public String durationString;
	public long durationLong;
	public long startDate_;
	public long endDate_;
	public long maxSeats;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}