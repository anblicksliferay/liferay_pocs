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

import com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_Requisition_Audit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_Audit
 * @generated
 */
@ProviderType
public class WFMS_Requisition_AuditCacheModel implements CacheModel<WFMS_Requisition_Audit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_Requisition_AuditCacheModel)) {
			return false;
		}

		WFMS_Requisition_AuditCacheModel wfms_Requisition_AuditCacheModel = (WFMS_Requisition_AuditCacheModel)obj;

		if (reqaId.equals(wfms_Requisition_AuditCacheModel.reqaId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, reqaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{reqaId=");
		sb.append(reqaId);
		sb.append(", reqId=");
		sb.append(reqId);
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
	public WFMS_Requisition_Audit toEntityModel() {
		WFMS_Requisition_AuditImpl wfms_Requisition_AuditImpl = new WFMS_Requisition_AuditImpl();

		if (reqaId == null) {
			wfms_Requisition_AuditImpl.setReqaId(StringPool.BLANK);
		}
		else {
			wfms_Requisition_AuditImpl.setReqaId(reqaId);
		}

		if (reqId == null) {
			wfms_Requisition_AuditImpl.setReqId(StringPool.BLANK);
		}
		else {
			wfms_Requisition_AuditImpl.setReqId(reqId);
		}

		wfms_Requisition_AuditImpl.setUserId(userId);

		if (createdBy == null) {
			wfms_Requisition_AuditImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_Requisition_AuditImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_Requisition_AuditImpl.setCreateDate(null);
		}
		else {
			wfms_Requisition_AuditImpl.setCreateDate(new Date(createDate));
		}

		if (change == null) {
			wfms_Requisition_AuditImpl.setChange(StringPool.BLANK);
		}
		else {
			wfms_Requisition_AuditImpl.setChange(change);
		}

		if (comments == null) {
			wfms_Requisition_AuditImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_Requisition_AuditImpl.setComments(comments);
		}

		wfms_Requisition_AuditImpl.resetOriginalValues();

		return wfms_Requisition_AuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reqaId = objectInput.readUTF();
		reqId = objectInput.readUTF();

		userId = objectInput.readLong();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		change = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (reqaId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reqaId);
		}

		if (reqId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reqId);
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

	public String reqaId;
	public String reqId;
	public long userId;
	public String createdBy;
	public long createDate;
	public String change;
	public String comments;
}