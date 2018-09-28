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

import ddtii.model.category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing category in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see category
 * @generated
 */
@ProviderType
public class categoryCacheModel implements CacheModel<category>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof categoryCacheModel)) {
			return false;
		}

		categoryCacheModel categoryCacheModel = (categoryCacheModel)obj;

		if (categoryId == categoryCacheModel.categoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", locationId=");
		sb.append(locationId);
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
	public category toEntityModel() {
		categoryImpl categoryImpl = new categoryImpl();

		categoryImpl.setCategoryId(categoryId);

		if (categoryName == null) {
			categoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			categoryImpl.setCategoryName(categoryName);
		}

		categoryImpl.setCourseId(courseId);
		categoryImpl.setLocationId(locationId);
		categoryImpl.setCompanyId(companyId);
		categoryImpl.setUserId(userId);

		if (userName == null) {
			categoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			categoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryImpl.setCreateDate(null);
		}
		else {
			categoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryImpl.setModifiedDate(null);
		}
		else {
			categoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		categoryName = objectInput.readUTF();

		courseId = objectInput.readLong();

		locationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(categoryId);

		if (categoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		objectOutput.writeLong(courseId);

		objectOutput.writeLong(locationId);

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

	public long categoryId;
	public String categoryName;
	public long courseId;
	public long locationId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}