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

package com.astra.workflowservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.workflowservice.model.Registration;

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
 * The cache model class for representing Registration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Registration
 * @generated
 */
@ProviderType
public class RegistrationCacheModel implements CacheModel<Registration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegistrationCacheModel)) {
			return false;
		}

		RegistrationCacheModel registrationCacheModel = (RegistrationCacheModel)obj;

		if (RegistrationId == registrationCacheModel.RegistrationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, RegistrationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", RegistrationId=");
		sb.append(RegistrationId);
		sb.append(", firstname=");
		sb.append(firstname);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", course=");
		sb.append(course);
		sb.append(", email=");
		sb.append(email);
		sb.append(", location=");
		sb.append(location);
		sb.append(", status=");
		sb.append(status);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", Workflowstepnumber=");
		sb.append(Workflowstepnumber);
		sb.append(", WorkflowId=");
		sb.append(WorkflowId);
		sb.append(", CurrentApprover=");
		sb.append(CurrentApprover);
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
	public Registration toEntityModel() {
		RegistrationImpl registrationImpl = new RegistrationImpl();

		if (uuid == null) {
			registrationImpl.setUuid(StringPool.BLANK);
		}
		else {
			registrationImpl.setUuid(uuid);
		}

		registrationImpl.setRegistrationId(RegistrationId);

		if (firstname == null) {
			registrationImpl.setFirstname(StringPool.BLANK);
		}
		else {
			registrationImpl.setFirstname(firstname);
		}

		if (lastname == null) {
			registrationImpl.setLastname(StringPool.BLANK);
		}
		else {
			registrationImpl.setLastname(lastname);
		}

		if (course == null) {
			registrationImpl.setCourse(StringPool.BLANK);
		}
		else {
			registrationImpl.setCourse(course);
		}

		if (email == null) {
			registrationImpl.setEmail(StringPool.BLANK);
		}
		else {
			registrationImpl.setEmail(email);
		}

		if (location == null) {
			registrationImpl.setLocation(StringPool.BLANK);
		}
		else {
			registrationImpl.setLocation(location);
		}

		if (status == null) {
			registrationImpl.setStatus(StringPool.BLANK);
		}
		else {
			registrationImpl.setStatus(status);
		}

		if (comments == null) {
			registrationImpl.setComments(StringPool.BLANK);
		}
		else {
			registrationImpl.setComments(comments);
		}

		if (Workflowstepnumber == null) {
			registrationImpl.setWorkflowstepnumber(StringPool.BLANK);
		}
		else {
			registrationImpl.setWorkflowstepnumber(Workflowstepnumber);
		}

		if (WorkflowId == null) {
			registrationImpl.setWorkflowId(StringPool.BLANK);
		}
		else {
			registrationImpl.setWorkflowId(WorkflowId);
		}

		if (CurrentApprover == null) {
			registrationImpl.setCurrentApprover(StringPool.BLANK);
		}
		else {
			registrationImpl.setCurrentApprover(CurrentApprover);
		}

		registrationImpl.setCompanyId(companyId);
		registrationImpl.setUserId(userId);

		if (userName == null) {
			registrationImpl.setUserName(StringPool.BLANK);
		}
		else {
			registrationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			registrationImpl.setCreateDate(null);
		}
		else {
			registrationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registrationImpl.setModifiedDate(null);
		}
		else {
			registrationImpl.setModifiedDate(new Date(modifiedDate));
		}

		registrationImpl.resetOriginalValues();

		return registrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		RegistrationId = objectInput.readLong();
		firstname = objectInput.readUTF();
		lastname = objectInput.readUTF();
		course = objectInput.readUTF();
		email = objectInput.readUTF();
		location = objectInput.readUTF();
		status = objectInput.readUTF();
		comments = objectInput.readUTF();
		Workflowstepnumber = objectInput.readUTF();
		WorkflowId = objectInput.readUTF();
		CurrentApprover = objectInput.readUTF();

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

		objectOutput.writeLong(RegistrationId);

		if (firstname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstname);
		}

		if (lastname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (course == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(course);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (Workflowstepnumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Workflowstepnumber);
		}

		if (WorkflowId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(WorkflowId);
		}

		if (CurrentApprover == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CurrentApprover);
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
	public long RegistrationId;
	public String firstname;
	public String lastname;
	public String course;
	public String email;
	public String location;
	public String status;
	public String comments;
	public String Workflowstepnumber;
	public String WorkflowId;
	public String CurrentApprover;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}