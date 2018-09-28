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

import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_routing_and_approvers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_routing_and_approvers
 * @generated
 */
@ProviderType
public class WFMS_routing_and_approversCacheModel implements CacheModel<WFMS_routing_and_approvers>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_routing_and_approversCacheModel)) {
			return false;
		}

		WFMS_routing_and_approversCacheModel wfms_routing_and_approversCacheModel =
			(WFMS_routing_and_approversCacheModel)obj;

		if (rapId.equals(wfms_routing_and_approversCacheModel.rapId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rapId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{rapId=");
		sb.append(rapId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", changeDescription=");
		sb.append(changeDescription);
		sb.append(", currentJobCodeORLeadership=");
		sb.append(currentJobCodeORLeadership);
		sb.append(", newJobCodeORLeadership=");
		sb.append(newJobCodeORLeadership);
		sb.append(", SameJobCode=");
		sb.append(SameJobCode);
		sb.append(", SameLeadership=");
		sb.append(SameLeadership);
		sb.append(", isSameDept=");
		sb.append(isSameDept);
		sb.append(", isSameMgr=");
		sb.append(isSameMgr);
		sb.append(", routingProcess=");
		sb.append(routingProcess);
		sb.append(", notificationTo=");
		sb.append(notificationTo);
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
	public WFMS_routing_and_approvers toEntityModel() {
		WFMS_routing_and_approversImpl wfms_routing_and_approversImpl = new WFMS_routing_and_approversImpl();

		if (rapId == null) {
			wfms_routing_and_approversImpl.setRapId(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setRapId(rapId);
		}

		if (action == null) {
			wfms_routing_and_approversImpl.setAction(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setAction(action);
		}

		if (changeDescription == null) {
			wfms_routing_and_approversImpl.setChangeDescription(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setChangeDescription(changeDescription);
		}

		if (currentJobCodeORLeadership == null) {
			wfms_routing_and_approversImpl.setCurrentJobCodeORLeadership(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setCurrentJobCodeORLeadership(currentJobCodeORLeadership);
		}

		if (newJobCodeORLeadership == null) {
			wfms_routing_and_approversImpl.setNewJobCodeORLeadership(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setNewJobCodeORLeadership(newJobCodeORLeadership);
		}

		if (SameJobCode == null) {
			wfms_routing_and_approversImpl.setSameJobCode(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setSameJobCode(SameJobCode);
		}

		if (SameLeadership == null) {
			wfms_routing_and_approversImpl.setSameLeadership(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setSameLeadership(SameLeadership);
		}

		if (isSameDept == null) {
			wfms_routing_and_approversImpl.setIsSameDept(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setIsSameDept(isSameDept);
		}

		if (isSameMgr == null) {
			wfms_routing_and_approversImpl.setIsSameMgr(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setIsSameMgr(isSameMgr);
		}

		if (routingProcess == null) {
			wfms_routing_and_approversImpl.setRoutingProcess(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setRoutingProcess(routingProcess);
		}

		if (notificationTo == null) {
			wfms_routing_and_approversImpl.setNotificationTo(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setNotificationTo(notificationTo);
		}

		wfms_routing_and_approversImpl.setDeleteflag(deleteflag);

		if (createdBy == null) {
			wfms_routing_and_approversImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_routing_and_approversImpl.setCreateDate(null);
		}
		else {
			wfms_routing_and_approversImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_routing_and_approversImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_routing_and_approversImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_routing_and_approversImpl.setModifiedDate(null);
		}
		else {
			wfms_routing_and_approversImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		wfms_routing_and_approversImpl.resetOriginalValues();

		return wfms_routing_and_approversImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rapId = objectInput.readUTF();
		action = objectInput.readUTF();
		changeDescription = objectInput.readUTF();
		currentJobCodeORLeadership = objectInput.readUTF();
		newJobCodeORLeadership = objectInput.readUTF();
		SameJobCode = objectInput.readUTF();
		SameLeadership = objectInput.readUTF();
		isSameDept = objectInput.readUTF();
		isSameMgr = objectInput.readUTF();
		routingProcess = objectInput.readUTF();
		notificationTo = objectInput.readUTF();

		deleteflag = objectInput.readInt();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (rapId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rapId);
		}

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (changeDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(changeDescription);
		}

		if (currentJobCodeORLeadership == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentJobCodeORLeadership);
		}

		if (newJobCodeORLeadership == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newJobCodeORLeadership);
		}

		if (SameJobCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SameJobCode);
		}

		if (SameLeadership == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SameLeadership);
		}

		if (isSameDept == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isSameDept);
		}

		if (isSameMgr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isSameMgr);
		}

		if (routingProcess == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(routingProcess);
		}

		if (notificationTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notificationTo);
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

	public String rapId;
	public String action;
	public String changeDescription;
	public String currentJobCodeORLeadership;
	public String newJobCodeORLeadership;
	public String SameJobCode;
	public String SameLeadership;
	public String isSameDept;
	public String isSameMgr;
	public String routingProcess;
	public String notificationTo;
	public int deleteflag;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
}