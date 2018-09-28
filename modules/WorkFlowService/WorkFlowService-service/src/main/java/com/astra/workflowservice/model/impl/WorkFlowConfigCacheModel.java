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

import com.astra.workflowservice.model.WorkFlowConfig;

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
 * The cache model class for representing WorkFlowConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFlowConfig
 * @generated
 */
@ProviderType
public class WorkFlowConfigCacheModel implements CacheModel<WorkFlowConfig>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkFlowConfigCacheModel)) {
			return false;
		}

		WorkFlowConfigCacheModel workFlowConfigCacheModel = (WorkFlowConfigCacheModel)obj;

		if (WfcId == workFlowConfigCacheModel.WfcId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, WfcId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", WfcId=");
		sb.append(WfcId);
		sb.append(", ConfigKey=");
		sb.append(ConfigKey);
		sb.append(", Content=");
		sb.append(Content);
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
	public WorkFlowConfig toEntityModel() {
		WorkFlowConfigImpl workFlowConfigImpl = new WorkFlowConfigImpl();

		if (uuid == null) {
			workFlowConfigImpl.setUuid(StringPool.BLANK);
		}
		else {
			workFlowConfigImpl.setUuid(uuid);
		}

		workFlowConfigImpl.setWfcId(WfcId);

		if (ConfigKey == null) {
			workFlowConfigImpl.setConfigKey(StringPool.BLANK);
		}
		else {
			workFlowConfigImpl.setConfigKey(ConfigKey);
		}

		if (Content == null) {
			workFlowConfigImpl.setContent(StringPool.BLANK);
		}
		else {
			workFlowConfigImpl.setContent(Content);
		}

		workFlowConfigImpl.setCompanyId(companyId);
		workFlowConfigImpl.setUserId(userId);

		if (userName == null) {
			workFlowConfigImpl.setUserName(StringPool.BLANK);
		}
		else {
			workFlowConfigImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workFlowConfigImpl.setCreateDate(null);
		}
		else {
			workFlowConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workFlowConfigImpl.setModifiedDate(null);
		}
		else {
			workFlowConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		workFlowConfigImpl.resetOriginalValues();

		return workFlowConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		WfcId = objectInput.readLong();
		ConfigKey = objectInput.readUTF();
		Content = objectInput.readUTF();

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

		objectOutput.writeLong(WfcId);

		if (ConfigKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ConfigKey);
		}

		if (Content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Content);
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
	public long WfcId;
	public String ConfigKey;
	public String Content;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}