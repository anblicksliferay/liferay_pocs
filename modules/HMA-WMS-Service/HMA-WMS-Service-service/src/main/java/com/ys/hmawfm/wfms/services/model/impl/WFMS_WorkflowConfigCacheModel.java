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

import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_WorkflowConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfig
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigCacheModel implements CacheModel<WFMS_WorkflowConfig>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_WorkflowConfigCacheModel)) {
			return false;
		}

		WFMS_WorkflowConfigCacheModel wfms_WorkflowConfigCacheModel = (WFMS_WorkflowConfigCacheModel)obj;

		if (wfcId == wfms_WorkflowConfigCacheModel.wfcId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wfcId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{wfcId=");
		sb.append(wfcId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", configKey=");
		sb.append(configKey);
		sb.append(", configLabel=");
		sb.append(configLabel);
		sb.append(", contentType=");
		sb.append(contentType);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_WorkflowConfig toEntityModel() {
		WFMS_WorkflowConfigImpl wfms_WorkflowConfigImpl = new WFMS_WorkflowConfigImpl();

		wfms_WorkflowConfigImpl.setWfcId(wfcId);

		if (createdBy == null) {
			wfms_WorkflowConfigImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_WorkflowConfigImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_WorkflowConfigImpl.setCreateDate(null);
		}
		else {
			wfms_WorkflowConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_WorkflowConfigImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_WorkflowConfigImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_WorkflowConfigImpl.setModifiedDate(null);
		}
		else {
			wfms_WorkflowConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (configKey == null) {
			wfms_WorkflowConfigImpl.setConfigKey(StringPool.BLANK);
		}
		else {
			wfms_WorkflowConfigImpl.setConfigKey(configKey);
		}

		if (configLabel == null) {
			wfms_WorkflowConfigImpl.setConfigLabel(StringPool.BLANK);
		}
		else {
			wfms_WorkflowConfigImpl.setConfigLabel(configLabel);
		}

		if (contentType == null) {
			wfms_WorkflowConfigImpl.setContentType(StringPool.BLANK);
		}
		else {
			wfms_WorkflowConfigImpl.setContentType(contentType);
		}

		if (content == null) {
			wfms_WorkflowConfigImpl.setContent(StringPool.BLANK);
		}
		else {
			wfms_WorkflowConfigImpl.setContent(content);
		}

		wfms_WorkflowConfigImpl.resetOriginalValues();

		return wfms_WorkflowConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		wfcId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		configKey = objectInput.readUTF();
		configLabel = objectInput.readUTF();
		contentType = objectInput.readUTF();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(wfcId);

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

		if (configKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(configKey);
		}

		if (configLabel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(configLabel);
		}

		if (contentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contentType);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long wfcId;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
	public String configKey;
	public String configLabel;
	public String contentType;
	public String content;
}