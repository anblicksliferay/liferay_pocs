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

import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_action_and_reasoncode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_and_reasoncode
 * @generated
 */
@ProviderType
public class WFMS_action_and_reasoncodeCacheModel implements CacheModel<WFMS_action_and_reasoncode>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_action_and_reasoncodeCacheModel)) {
			return false;
		}

		WFMS_action_and_reasoncodeCacheModel wfms_action_and_reasoncodeCacheModel =
			(WFMS_action_and_reasoncodeCacheModel)obj;

		if (aarId.equals(wfms_action_and_reasoncodeCacheModel.aarId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, aarId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{aarId=");
		sb.append(aarId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", reasonCode=");
		sb.append(reasonCode);
		sb.append(", description=");
		sb.append(description);
		sb.append(", deleteflag=");
		sb.append(deleteflag);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_action_and_reasoncode toEntityModel() {
		WFMS_action_and_reasoncodeImpl wfms_action_and_reasoncodeImpl = new WFMS_action_and_reasoncodeImpl();

		if (aarId == null) {
			wfms_action_and_reasoncodeImpl.setAarId(StringPool.BLANK);
		}
		else {
			wfms_action_and_reasoncodeImpl.setAarId(aarId);
		}

		if (action == null) {
			wfms_action_and_reasoncodeImpl.setAction(StringPool.BLANK);
		}
		else {
			wfms_action_and_reasoncodeImpl.setAction(action);
		}

		if (reasonCode == null) {
			wfms_action_and_reasoncodeImpl.setReasonCode(StringPool.BLANK);
		}
		else {
			wfms_action_and_reasoncodeImpl.setReasonCode(reasonCode);
		}

		if (description == null) {
			wfms_action_and_reasoncodeImpl.setDescription(StringPool.BLANK);
		}
		else {
			wfms_action_and_reasoncodeImpl.setDescription(description);
		}

		wfms_action_and_reasoncodeImpl.setDeleteflag(deleteflag);

		if (createdBy == null) {
			wfms_action_and_reasoncodeImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_action_and_reasoncodeImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_action_and_reasoncodeImpl.setCreateDate(null);
		}
		else {
			wfms_action_and_reasoncodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_action_and_reasoncodeImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_action_and_reasoncodeImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_action_and_reasoncodeImpl.setModifiedDate(null);
		}
		else {
			wfms_action_and_reasoncodeImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		wfms_action_and_reasoncodeImpl.resetOriginalValues();

		return wfms_action_and_reasoncodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		aarId = objectInput.readUTF();
		action = objectInput.readUTF();
		reasonCode = objectInput.readUTF();
		description = objectInput.readUTF();

		deleteflag = objectInput.readInt();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (aarId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aarId);
		}

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (reasonCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonCode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(deleteflag);

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createDate);

		if (modifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeLong(modifiedDate);
	}

	public String aarId;
	public String action;
	public String reasonCode;
	public String description;
	public int deleteflag;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
}