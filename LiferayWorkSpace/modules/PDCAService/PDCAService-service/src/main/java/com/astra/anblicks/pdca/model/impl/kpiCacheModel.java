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

package com.astra.anblicks.pdca.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.model.kpi;

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
 * The cache model class for representing kpi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see kpi
 * @generated
 */
@ProviderType
public class kpiCacheModel implements CacheModel<kpi>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kpiCacheModel)) {
			return false;
		}

		kpiCacheModel kpiCacheModel = (kpiCacheModel)obj;

		if (kpiId == kpiCacheModel.kpiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, kpiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", kpiId=");
		sb.append(kpiId);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", tipe=");
		sb.append(tipe);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", target=");
		sb.append(target);
		sb.append(", year=");
		sb.append(year);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", achivementFormula=");
		sb.append(achivementFormula);
		sb.append(", itemDescription=");
		sb.append(itemDescription);
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
	public kpi toEntityModel() {
		kpiImpl kpiImpl = new kpiImpl();

		if (uuid == null) {
			kpiImpl.setUuid(StringPool.BLANK);
		}
		else {
			kpiImpl.setUuid(uuid);
		}

		kpiImpl.setKpiId(kpiId);

		if (companyName == null) {
			kpiImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			kpiImpl.setCompanyName(companyName);
		}

		if (tipe == null) {
			kpiImpl.setTipe(StringPool.BLANK);
		}
		else {
			kpiImpl.setTipe(tipe);
		}

		if (weight == null) {
			kpiImpl.setWeight(StringPool.BLANK);
		}
		else {
			kpiImpl.setWeight(weight);
		}

		if (target == null) {
			kpiImpl.setTarget(StringPool.BLANK);
		}
		else {
			kpiImpl.setTarget(target);
		}

		if (year == null) {
			kpiImpl.setYear(StringPool.BLANK);
		}
		else {
			kpiImpl.setYear(year);
		}

		if (unit == null) {
			kpiImpl.setUnit(StringPool.BLANK);
		}
		else {
			kpiImpl.setUnit(unit);
		}

		if (achivementFormula == null) {
			kpiImpl.setAchivementFormula(StringPool.BLANK);
		}
		else {
			kpiImpl.setAchivementFormula(achivementFormula);
		}

		if (itemDescription == null) {
			kpiImpl.setItemDescription(StringPool.BLANK);
		}
		else {
			kpiImpl.setItemDescription(itemDescription);
		}

		kpiImpl.setCompanyId(companyId);
		kpiImpl.setUserId(userId);

		if (userName == null) {
			kpiImpl.setUserName(StringPool.BLANK);
		}
		else {
			kpiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kpiImpl.setCreateDate(null);
		}
		else {
			kpiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kpiImpl.setModifiedDate(null);
		}
		else {
			kpiImpl.setModifiedDate(new Date(modifiedDate));
		}

		kpiImpl.resetOriginalValues();

		return kpiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		kpiId = objectInput.readLong();
		companyName = objectInput.readUTF();
		tipe = objectInput.readUTF();
		weight = objectInput.readUTF();
		target = objectInput.readUTF();
		year = objectInput.readUTF();
		unit = objectInput.readUTF();
		achivementFormula = objectInput.readUTF();
		itemDescription = objectInput.readUTF();

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

		objectOutput.writeLong(kpiId);

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (tipe == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipe);
		}

		if (weight == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(weight);
		}

		if (target == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(target);
		}

		if (year == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(year);
		}

		if (unit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unit);
		}

		if (achivementFormula == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(achivementFormula);
		}

		if (itemDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemDescription);
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
	public long kpiId;
	public String companyName;
	public String tipe;
	public String weight;
	public String target;
	public String year;
	public String unit;
	public String achivementFormula;
	public String itemDescription;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}