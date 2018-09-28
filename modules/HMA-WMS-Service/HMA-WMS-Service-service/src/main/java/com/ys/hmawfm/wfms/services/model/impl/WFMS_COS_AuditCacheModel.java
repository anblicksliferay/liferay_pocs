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

import com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_COS_Audit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS_Audit
 * @generated
 */
@ProviderType
public class WFMS_COS_AuditCacheModel implements CacheModel<WFMS_COS_Audit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_COS_AuditCacheModel)) {
			return false;
		}

		WFMS_COS_AuditCacheModel wfms_cos_AuditCacheModel = (WFMS_COS_AuditCacheModel)obj;

		if (cosaId.equals(wfms_cos_AuditCacheModel.cosaId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cosaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{cosaId=");
		sb.append(cosaId);
		sb.append(", cosId=");
		sb.append(cosId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", change=");
		sb.append(change);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_COS_Audit toEntityModel() {
		WFMS_COS_AuditImpl wfms_cos_AuditImpl = new WFMS_COS_AuditImpl();

		if (cosaId == null) {
			wfms_cos_AuditImpl.setCosaId(StringPool.BLANK);
		}
		else {
			wfms_cos_AuditImpl.setCosaId(cosaId);
		}

		if (cosId == null) {
			wfms_cos_AuditImpl.setCosId(StringPool.BLANK);
		}
		else {
			wfms_cos_AuditImpl.setCosId(cosId);
		}

		wfms_cos_AuditImpl.setUserId(userId);

		if (createdBy == null) {
			wfms_cos_AuditImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_cos_AuditImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_cos_AuditImpl.setCreateDate(null);
		}
		else {
			wfms_cos_AuditImpl.setCreateDate(new Date(createDate));
		}

		if (change == null) {
			wfms_cos_AuditImpl.setChange(StringPool.BLANK);
		}
		else {
			wfms_cos_AuditImpl.setChange(change);
		}

		if (comments == null) {
			wfms_cos_AuditImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_cos_AuditImpl.setComments(comments);
		}

		wfms_cos_AuditImpl.resetOriginalValues();

		return wfms_cos_AuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cosaId = objectInput.readUTF();
		cosId = objectInput.readUTF();

		userId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		change = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (cosaId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cosaId);
		}

		if (cosId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cosId);
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

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public String cosaId;
	public String cosId;
	public long userId;
	public String createdBy;
	public long createDate;
	public String change;
	public String comments;
}