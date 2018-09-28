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

package com.externalservices.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.externalservices.model.leykartEnquiry;

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
 * The cache model class for representing leykartEnquiry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see leykartEnquiry
 * @generated
 */
@ProviderType
public class leykartEnquiryCacheModel implements CacheModel<leykartEnquiry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof leykartEnquiryCacheModel)) {
			return false;
		}

		leykartEnquiryCacheModel leykartEnquiryCacheModel = (leykartEnquiryCacheModel)obj;

		if (Eid == leykartEnquiryCacheModel.Eid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Eid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", Eid=");
		sb.append(Eid);
		sb.append(", FirstName=");
		sb.append(FirstName);
		sb.append(", LastName=");
		sb.append(LastName);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", ContactNumber=");
		sb.append(ContactNumber);
		sb.append(", PartName=");
		sb.append(PartName);
		sb.append(", PartNumber=");
		sb.append(PartNumber);
		sb.append(", Message=");
		sb.append(Message);
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
	public leykartEnquiry toEntityModel() {
		leykartEnquiryImpl leykartEnquiryImpl = new leykartEnquiryImpl();

		if (uuid == null) {
			leykartEnquiryImpl.setUuid(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setUuid(uuid);
		}

		leykartEnquiryImpl.setEid(Eid);

		if (FirstName == null) {
			leykartEnquiryImpl.setFirstName(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setFirstName(FirstName);
		}

		if (LastName == null) {
			leykartEnquiryImpl.setLastName(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setLastName(LastName);
		}

		if (Email == null) {
			leykartEnquiryImpl.setEmail(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setEmail(Email);
		}

		if (ContactNumber == null) {
			leykartEnquiryImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setContactNumber(ContactNumber);
		}

		if (PartName == null) {
			leykartEnquiryImpl.setPartName(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setPartName(PartName);
		}

		if (PartNumber == null) {
			leykartEnquiryImpl.setPartNumber(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setPartNumber(PartNumber);
		}

		if (Message == null) {
			leykartEnquiryImpl.setMessage(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setMessage(Message);
		}

		leykartEnquiryImpl.setCompanyId(companyId);
		leykartEnquiryImpl.setUserId(userId);

		if (userName == null) {
			leykartEnquiryImpl.setUserName(StringPool.BLANK);
		}
		else {
			leykartEnquiryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			leykartEnquiryImpl.setCreateDate(null);
		}
		else {
			leykartEnquiryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leykartEnquiryImpl.setModifiedDate(null);
		}
		else {
			leykartEnquiryImpl.setModifiedDate(new Date(modifiedDate));
		}

		leykartEnquiryImpl.resetOriginalValues();

		return leykartEnquiryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		Eid = objectInput.readLong();
		FirstName = objectInput.readUTF();
		LastName = objectInput.readUTF();
		Email = objectInput.readUTF();
		ContactNumber = objectInput.readUTF();
		PartName = objectInput.readUTF();
		PartNumber = objectInput.readUTF();
		Message = objectInput.readUTF();

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

		objectOutput.writeLong(Eid);

		if (FirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FirstName);
		}

		if (LastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LastName);
		}

		if (Email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Email);
		}

		if (ContactNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ContactNumber);
		}

		if (PartName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PartName);
		}

		if (PartNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PartNumber);
		}

		if (Message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Message);
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
	public long Eid;
	public String FirstName;
	public String LastName;
	public String Email;
	public String ContactNumber;
	public String PartName;
	public String PartNumber;
	public String Message;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}