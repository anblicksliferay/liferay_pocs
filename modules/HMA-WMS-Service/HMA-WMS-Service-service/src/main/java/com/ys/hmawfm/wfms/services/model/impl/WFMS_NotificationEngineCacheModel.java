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

import com.ys.hmawfm.wfms.services.model.WFMS_NotificationEngine;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_NotificationEngine in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NotificationEngine
 * @generated
 */
@ProviderType
public class WFMS_NotificationEngineCacheModel implements CacheModel<WFMS_NotificationEngine>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_NotificationEngineCacheModel)) {
			return false;
		}

		WFMS_NotificationEngineCacheModel wfms_NotificationEngineCacheModel = (WFMS_NotificationEngineCacheModel)obj;

		if (templateId == wfms_NotificationEngineCacheModel.templateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, templateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{templateId=");
		sb.append(templateId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", scopeGroupId=");
		sb.append(scopeGroupId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", contentType=");
		sb.append(contentType);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", timesUsed=");
		sb.append(timesUsed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_NotificationEngine toEntityModel() {
		WFMS_NotificationEngineImpl wfms_NotificationEngineImpl = new WFMS_NotificationEngineImpl();

		wfms_NotificationEngineImpl.setTemplateId(templateId);
		wfms_NotificationEngineImpl.setCompanyId(companyId);
		wfms_NotificationEngineImpl.setScopeGroupId(scopeGroupId);

		if (createdBy == null) {
			wfms_NotificationEngineImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_NotificationEngineImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_NotificationEngineImpl.setCreateDate(null);
		}
		else {
			wfms_NotificationEngineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_NotificationEngineImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_NotificationEngineImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_NotificationEngineImpl.setModifiedDate(null);
		}
		else {
			wfms_NotificationEngineImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			wfms_NotificationEngineImpl.setTitle(StringPool.BLANK);
		}
		else {
			wfms_NotificationEngineImpl.setTitle(title);
		}

		if (content == null) {
			wfms_NotificationEngineImpl.setContent(StringPool.BLANK);
		}
		else {
			wfms_NotificationEngineImpl.setContent(content);
		}

		if (contentType == null) {
			wfms_NotificationEngineImpl.setContentType(StringPool.BLANK);
		}
		else {
			wfms_NotificationEngineImpl.setContentType(contentType);
		}

		if (comments == null) {
			wfms_NotificationEngineImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_NotificationEngineImpl.setComments(comments);
		}

		wfms_NotificationEngineImpl.setTimesUsed(timesUsed);

		wfms_NotificationEngineImpl.resetOriginalValues();

		return wfms_NotificationEngineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		templateId = objectInput.readLong();

		companyId = objectInput.readLong();

		scopeGroupId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		contentType = objectInput.readUTF();
		comments = objectInput.readUTF();

		timesUsed = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(templateId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(scopeGroupId);

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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (contentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contentType);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeInt(timesUsed);
	}

	public long templateId;
	public long companyId;
	public long scopeGroupId;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
	public String title;
	public String content;
	public String contentType;
	public String comments;
	public int timesUsed;
}