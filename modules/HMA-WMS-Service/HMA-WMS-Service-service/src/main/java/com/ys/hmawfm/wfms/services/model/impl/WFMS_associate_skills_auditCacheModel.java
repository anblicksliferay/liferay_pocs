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

package com.ys.hmawfm.wfms.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_associate_skills_audit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_audit
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditCacheModel implements CacheModel<WFMS_associate_skills_audit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_associate_skills_auditCacheModel)) {
			return false;
		}

		WFMS_associate_skills_auditCacheModel wfms_associate_skills_auditCacheModel =
			(WFMS_associate_skills_auditCacheModel)obj;

		if (associate_log_id == wfms_associate_skills_auditCacheModel.associate_log_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, associate_log_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{associate_log_id=");
		sb.append(associate_log_id);
		sb.append(", associate_number=");
		sb.append(associate_number);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", change=");
		sb.append(change);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_associate_skills_audit toEntityModel() {
		WFMS_associate_skills_auditImpl wfms_associate_skills_auditImpl = new WFMS_associate_skills_auditImpl();

		wfms_associate_skills_auditImpl.setAssociate_log_id(associate_log_id);

		if (associate_number == null) {
			wfms_associate_skills_auditImpl.setAssociate_number(StringPool.BLANK);
		}
		else {
			wfms_associate_skills_auditImpl.setAssociate_number(associate_number);
		}

		wfms_associate_skills_auditImpl.setUserId(userId);

		if (createdBy == null) {
			wfms_associate_skills_auditImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_associate_skills_auditImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_associate_skills_auditImpl.setCreateDate(null);
		}
		else {
			wfms_associate_skills_auditImpl.setCreateDate(new Date(createDate));
		}

		if (change == null) {
			wfms_associate_skills_auditImpl.setChange(StringPool.BLANK);
		}
		else {
			wfms_associate_skills_auditImpl.setChange(change);
		}

		wfms_associate_skills_auditImpl.resetOriginalValues();

		return wfms_associate_skills_auditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		associate_log_id = objectInput.readLong();
		associate_number = objectInput.readUTF();

		userId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		change = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(associate_log_id);

		if (associate_number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associate_number);
		}

		objectOutput.writeLong(userId);

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createDate);

		if (change == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(change);
		}
	}

	public long associate_log_id;
	public String associate_number;
	public long userId;
	public String createdBy;
	public long createDate;
	public String change;
}