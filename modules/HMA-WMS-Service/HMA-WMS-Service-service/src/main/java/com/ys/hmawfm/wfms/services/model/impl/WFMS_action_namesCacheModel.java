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

import com.ys.hmawfm.wfms.services.model.WFMS_action_names;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_action_names in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_names
 * @generated
 */
@ProviderType
public class WFMS_action_namesCacheModel implements CacheModel<WFMS_action_names>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_action_namesCacheModel)) {
			return false;
		}

		WFMS_action_namesCacheModel wfms_action_namesCacheModel = (WFMS_action_namesCacheModel)obj;

		if (actionId.equals(wfms_action_namesCacheModel.actionId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, actionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{actionId=");
		sb.append(actionId);
		sb.append(", actionName=");
		sb.append(actionName);
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
	public WFMS_action_names toEntityModel() {
		WFMS_action_namesImpl wfms_action_namesImpl = new WFMS_action_namesImpl();

		if (actionId == null) {
			wfms_action_namesImpl.setActionId(StringPool.BLANK);
		}
		else {
			wfms_action_namesImpl.setActionId(actionId);
		}

		if (actionName == null) {
			wfms_action_namesImpl.setActionName(StringPool.BLANK);
		}
		else {
			wfms_action_namesImpl.setActionName(actionName);
		}

		wfms_action_namesImpl.setDeleteflag(deleteflag);

		if (createdBy == null) {
			wfms_action_namesImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_action_namesImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_action_namesImpl.setCreateDate(null);
		}
		else {
			wfms_action_namesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_action_namesImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_action_namesImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_action_namesImpl.setModifiedDate(null);
		}
		else {
			wfms_action_namesImpl.setModifiedDate(new Date(modifiedDate));
		}

		wfms_action_namesImpl.resetOriginalValues();

		return wfms_action_namesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		actionId = objectInput.readUTF();
		actionName = objectInput.readUTF();

		deleteflag = objectInput.readInt();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (actionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionId);
		}

		if (actionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionName);
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

	public String actionId;
	public String actionName;
	public int deleteflag;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
}