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

import com.ys.hmawfm.wfms.services.model.WFMS_Config;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_Config in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Config
 * @generated
 */
@ProviderType
public class WFMS_ConfigCacheModel implements CacheModel<WFMS_Config>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_ConfigCacheModel)) {
			return false;
		}

		WFMS_ConfigCacheModel wfms_ConfigCacheModel = (WFMS_ConfigCacheModel)obj;

		if (configId == wfms_ConfigCacheModel.configId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, configId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{configId=");
		sb.append(configId);
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
	public WFMS_Config toEntityModel() {
		WFMS_ConfigImpl wfms_ConfigImpl = new WFMS_ConfigImpl();

		wfms_ConfigImpl.setConfigId(configId);

		if (createdBy == null) {
			wfms_ConfigImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_ConfigImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_ConfigImpl.setCreateDate(null);
		}
		else {
			wfms_ConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_ConfigImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_ConfigImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_ConfigImpl.setModifiedDate(null);
		}
		else {
			wfms_ConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (configKey == null) {
			wfms_ConfigImpl.setConfigKey(StringPool.BLANK);
		}
		else {
			wfms_ConfigImpl.setConfigKey(configKey);
		}

		if (configLabel == null) {
			wfms_ConfigImpl.setConfigLabel(StringPool.BLANK);
		}
		else {
			wfms_ConfigImpl.setConfigLabel(configLabel);
		}

		if (contentType == null) {
			wfms_ConfigImpl.setContentType(StringPool.BLANK);
		}
		else {
			wfms_ConfigImpl.setContentType(contentType);
		}

		if (content == null) {
			wfms_ConfigImpl.setContent(StringPool.BLANK);
		}
		else {
			wfms_ConfigImpl.setContent(content);
		}

		wfms_ConfigImpl.resetOriginalValues();

		return wfms_ConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		configId = objectInput.readLong();
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
		objectOutput.writeLong(configId);

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

	public long configId;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
	public String configKey;
	public String configLabel;
	public String contentType;
	public String content;
}