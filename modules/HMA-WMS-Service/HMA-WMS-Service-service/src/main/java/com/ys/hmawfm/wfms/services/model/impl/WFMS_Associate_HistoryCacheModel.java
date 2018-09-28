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

import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_Associate_History in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Associate_History
 * @generated
 */
@ProviderType
public class WFMS_Associate_HistoryCacheModel implements CacheModel<WFMS_Associate_History>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_Associate_HistoryCacheModel)) {
			return false;
		}

		WFMS_Associate_HistoryCacheModel wfms_Associate_HistoryCacheModel = (WFMS_Associate_HistoryCacheModel)obj;

		if (assocHistoryId == wfms_Associate_HistoryCacheModel.assocHistoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, assocHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{assocHistoryId=");
		sb.append(assocHistoryId);
		sb.append(", associateId=");
		sb.append(associateId);
		sb.append(", associateName=");
		sb.append(associateName);
		sb.append(", currentPosition=");
		sb.append(currentPosition);
		sb.append(", history=");
		sb.append(history);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_Associate_History toEntityModel() {
		WFMS_Associate_HistoryImpl wfms_Associate_HistoryImpl = new WFMS_Associate_HistoryImpl();

		wfms_Associate_HistoryImpl.setAssocHistoryId(assocHistoryId);

		if (associateId == null) {
			wfms_Associate_HistoryImpl.setAssociateId(StringPool.BLANK);
		}
		else {
			wfms_Associate_HistoryImpl.setAssociateId(associateId);
		}

		if (associateName == null) {
			wfms_Associate_HistoryImpl.setAssociateName(StringPool.BLANK);
		}
		else {
			wfms_Associate_HistoryImpl.setAssociateName(associateName);
		}

		if (currentPosition == null) {
			wfms_Associate_HistoryImpl.setCurrentPosition(StringPool.BLANK);
		}
		else {
			wfms_Associate_HistoryImpl.setCurrentPosition(currentPosition);
		}

		if (history == null) {
			wfms_Associate_HistoryImpl.setHistory(StringPool.BLANK);
		}
		else {
			wfms_Associate_HistoryImpl.setHistory(history);
		}

		if (createdBy == null) {
			wfms_Associate_HistoryImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_Associate_HistoryImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_Associate_HistoryImpl.setCreateDate(null);
		}
		else {
			wfms_Associate_HistoryImpl.setCreateDate(new Date(createDate));
		}

		wfms_Associate_HistoryImpl.resetOriginalValues();

		return wfms_Associate_HistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		assocHistoryId = objectInput.readInt();
		associateId = objectInput.readUTF();
		associateName = objectInput.readUTF();
		currentPosition = objectInput.readUTF();
		history = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(assocHistoryId);

		if (associateId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateId);
		}

		if (associateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateName);
		}

		if (currentPosition == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentPosition);
		}

		if (history == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(history);
		}

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createDate);
	}

	public int assocHistoryId;
	public String associateId;
	public String associateName;
	public String currentPosition;
	public String history;
	public String createdBy;
	public long createDate;
}