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

package com.MappingServices.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.MappingServices.model.Enquiry;

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
 * The cache model class for representing Enquiry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Enquiry
 * @generated
 */
@ProviderType
public class EnquiryCacheModel implements CacheModel<Enquiry>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnquiryCacheModel)) {
			return false;
		}

		EnquiryCacheModel enquiryCacheModel = (EnquiryCacheModel)obj;

		if (Eid == enquiryCacheModel.Eid) {
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
		StringBundler sb = new StringBundler(23);

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
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Enquiry toEntityModel() {
		EnquiryImpl enquiryImpl = new EnquiryImpl();

		if (uuid == null) {
			enquiryImpl.setUuid(StringPool.BLANK);
		}
		else {
			enquiryImpl.setUuid(uuid);
		}

		enquiryImpl.setEid(Eid);

		if (FirstName == null) {
			enquiryImpl.setFirstName(StringPool.BLANK);
		}
		else {
			enquiryImpl.setFirstName(FirstName);
		}

		if (LastName == null) {
			enquiryImpl.setLastName(StringPool.BLANK);
		}
		else {
			enquiryImpl.setLastName(LastName);
		}

		if (Email == null) {
			enquiryImpl.setEmail(StringPool.BLANK);
		}
		else {
			enquiryImpl.setEmail(Email);
		}

		if (ContactNumber == null) {
			enquiryImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			enquiryImpl.setContactNumber(ContactNumber);
		}

		if (PartName == null) {
			enquiryImpl.setPartName(StringPool.BLANK);
		}
		else {
			enquiryImpl.setPartName(PartName);
		}

		if (PartNumber == null) {
			enquiryImpl.setPartNumber(StringPool.BLANK);
		}
		else {
			enquiryImpl.setPartNumber(PartNumber);
		}

		if (Message == null) {
			enquiryImpl.setMessage(StringPool.BLANK);
		}
		else {
			enquiryImpl.setMessage(Message);
		}

		if (createDate == Long.MIN_VALUE) {
			enquiryImpl.setCreateDate(null);
		}
		else {
			enquiryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enquiryImpl.setModifiedDate(null);
		}
		else {
			enquiryImpl.setModifiedDate(new Date(modifiedDate));
		}

		enquiryImpl.resetOriginalValues();

		return enquiryImpl;
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
	public long createDate;
	public long modifiedDate;
}