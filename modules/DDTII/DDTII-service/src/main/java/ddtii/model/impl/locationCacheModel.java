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

import ddtii.model.location;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing location in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see location
 * @generated
 */
@ProviderType
public class locationCacheModel implements CacheModel<location>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof locationCacheModel)) {
			return false;
		}

		locationCacheModel locationCacheModel = (locationCacheModel)obj;

		if (locationId == locationCacheModel.locationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, locationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", locationName=");
		sb.append(locationName);
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
	public location toEntityModel() {
		locationImpl locationImpl = new locationImpl();

		locationImpl.setLocationId(locationId);

		if (locationName == null) {
			locationImpl.setLocationName(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationName(locationName);
		}

		locationImpl.setCompanyId(companyId);
		locationImpl.setUserId(userId);

		if (userName == null) {
			locationImpl.setUserName(StringPool.BLANK);
		}
		else {
			locationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			locationImpl.setCreateDate(null);
		}
		else {
			locationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			locationImpl.setModifiedDate(null);
		}
		else {
			locationImpl.setModifiedDate(new Date(modifiedDate));
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locationId = objectInput.readLong();
		locationName = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(locationId);

		if (locationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationName);
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

	public long locationId;
	public String locationName;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}