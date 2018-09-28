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

package com.ys.hma.account.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.ys.hma.account.model.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Data in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
@ProviderType
public class DataCacheModel implements CacheModel<Data>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataCacheModel)) {
			return false;
		}

		DataCacheModel dataCacheModel = (DataCacheModel)obj;

		if (DataId == dataCacheModel.DataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, DataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{DataId=");
		sb.append(DataId);
		sb.append(", StartDate=");
		sb.append(StartDate);
		sb.append(", EndDate=");
		sb.append(EndDate);
		sb.append(", Exported=");
		sb.append(Exported);
		sb.append(", NotExported=");
		sb.append(NotExported);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Data toEntityModel() {
		DataImpl dataImpl = new DataImpl();

		dataImpl.setDataId(DataId);

		if (StartDate == Long.MIN_VALUE) {
			dataImpl.setStartDate(null);
		}
		else {
			dataImpl.setStartDate(new Date(StartDate));
		}

		if (EndDate == Long.MIN_VALUE) {
			dataImpl.setEndDate(null);
		}
		else {
			dataImpl.setEndDate(new Date(EndDate));
		}

		dataImpl.setExported(Exported);
		dataImpl.setNotExported(NotExported);

		dataImpl.resetOriginalValues();

		return dataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		DataId = objectInput.readLong();
		StartDate = objectInput.readLong();
		EndDate = objectInput.readLong();

		Exported = objectInput.readInt();

		NotExported = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(DataId);
		objectOutput.writeLong(StartDate);
		objectOutput.writeLong(EndDate);

		objectOutput.writeInt(Exported);

		objectOutput.writeInt(NotExported);
	}

	public long DataId;
	public long StartDate;
	public long EndDate;
	public int Exported;
	public int NotExported;
}