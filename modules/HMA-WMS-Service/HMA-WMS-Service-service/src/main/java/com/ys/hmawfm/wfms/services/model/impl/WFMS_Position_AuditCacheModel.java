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

import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_Position_Audit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position_Audit
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditCacheModel implements CacheModel<WFMS_Position_Audit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_Position_AuditCacheModel)) {
			return false;
		}

		WFMS_Position_AuditCacheModel wfms_Position_AuditCacheModel = (WFMS_Position_AuditCacheModel)obj;

		if (paId.equals(wfms_Position_AuditCacheModel.paId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{paId=");
		sb.append(paId);
		sb.append(", pId=");
		sb.append(pId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", associateId=");
		sb.append(associateId);
		sb.append(", change=");
		sb.append(change);
		sb.append(", fromPId=");
		sb.append(fromPId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_Position_Audit toEntityModel() {
		WFMS_Position_AuditImpl wfms_Position_AuditImpl = new WFMS_Position_AuditImpl();

		if (paId == null) {
			wfms_Position_AuditImpl.setPaId(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setPaId(paId);
		}

		if (pId == null) {
			wfms_Position_AuditImpl.setPId(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setPId(pId);
		}

		wfms_Position_AuditImpl.setUserId(userId);

		if (associateId == null) {
			wfms_Position_AuditImpl.setAssociateId(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setAssociateId(associateId);
		}

		if (change == null) {
			wfms_Position_AuditImpl.setChange(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setChange(change);
		}

		if (fromPId == null) {
			wfms_Position_AuditImpl.setFromPId(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setFromPId(fromPId);
		}

		if (comments == null) {
			wfms_Position_AuditImpl.setComments(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setComments(comments);
		}

		if (createdBy == null) {
			wfms_Position_AuditImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_Position_AuditImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_Position_AuditImpl.setCreateDate(null);
		}
		else {
			wfms_Position_AuditImpl.setCreateDate(new Date(createDate));
		}

		wfms_Position_AuditImpl.resetOriginalValues();

		return wfms_Position_AuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paId = objectInput.readUTF();
		pId = objectInput.readUTF();

		userId = objectInput.readLong();
		associateId = objectInput.readUTF();
		change = objectInput.readUTF();
		fromPId = objectInput.readUTF();
		comments = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (paId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paId);
		}

		if (pId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pId);
		}

		objectOutput.writeLong(userId);

		if (associateId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateId);
		}

		if (change == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(change);
		}

		if (fromPId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromPId);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createDate);
	}

	public String paId;
	public String pId;
	public long userId;
	public String associateId;
	public String change;
	public String fromPId;
	public String comments;
	public String createdBy;
	public long createDate;
}