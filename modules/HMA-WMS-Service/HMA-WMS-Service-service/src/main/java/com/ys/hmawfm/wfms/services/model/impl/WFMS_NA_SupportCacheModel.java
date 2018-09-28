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

import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WFMS_NA_Support in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_Support
 * @generated
 */
@ProviderType
public class WFMS_NA_SupportCacheModel implements CacheModel<WFMS_NA_Support>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_NA_SupportCacheModel)) {
			return false;
		}

		WFMS_NA_SupportCacheModel wfms_na_SupportCacheModel = (WFMS_NA_SupportCacheModel)obj;

		if (ASSOCIATE_NUMBER.equals(wfms_na_SupportCacheModel.ASSOCIATE_NUMBER)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ASSOCIATE_NUMBER);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{ASSOCIATE_NUMBER=");
		sb.append(ASSOCIATE_NUMBER);
		sb.append(", ASSOC_NO=");
		sb.append(ASSOC_NO);
		sb.append(", ASSOCIATE_DATE_OF_HIRE=");
		sb.append(ASSOCIATE_DATE_OF_HIRE);
		sb.append(", ASSOCIATE_NAME=");
		sb.append(ASSOCIATE_NAME);
		sb.append(", DEPT_NUMBER=");
		sb.append(DEPT_NUMBER);
		sb.append(", DEPT_NO=");
		sb.append(DEPT_NO);
		sb.append(", DEPT_NAME=");
		sb.append(DEPT_NAME);
		sb.append(", ASSOCIATE_TITLE=");
		sb.append(ASSOCIATE_TITLE);
		sb.append(", SHIFT_CODE=");
		sb.append(SHIFT_CODE);
		sb.append(", TEAM_NUMBER=");
		sb.append(TEAM_NUMBER);
		sb.append(", EFFDT=");
		sb.append(EFFDT);
		sb.append(", TERMINATION_DT=");
		sb.append(TERMINATION_DT);
		sb.append(", MANAGER_ASSOCIATE_NUMBER=");
		sb.append(MANAGER_ASSOCIATE_NUMBER);
		sb.append(", ASSGN_TYPE=");
		sb.append(ASSGN_TYPE);
		sb.append(", LEADERSHIP_ASSIGNMENT=");
		sb.append(LEADERSHIP_ASSIGNMENT);
		sb.append(", EMAIL=");
		sb.append(EMAIL);
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
	public WFMS_NA_Support toEntityModel() {
		WFMS_NA_SupportImpl wfms_na_SupportImpl = new WFMS_NA_SupportImpl();

		if (ASSOCIATE_NUMBER == null) {
			wfms_na_SupportImpl.setASSOCIATE_NUMBER(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setASSOCIATE_NUMBER(ASSOCIATE_NUMBER);
		}

		if (ASSOC_NO == null) {
			wfms_na_SupportImpl.setASSOC_NO(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setASSOC_NO(ASSOC_NO);
		}

		if (ASSOCIATE_DATE_OF_HIRE == null) {
			wfms_na_SupportImpl.setASSOCIATE_DATE_OF_HIRE(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setASSOCIATE_DATE_OF_HIRE(ASSOCIATE_DATE_OF_HIRE);
		}

		if (ASSOCIATE_NAME == null) {
			wfms_na_SupportImpl.setASSOCIATE_NAME(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setASSOCIATE_NAME(ASSOCIATE_NAME);
		}

		if (DEPT_NUMBER == null) {
			wfms_na_SupportImpl.setDEPT_NUMBER(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setDEPT_NUMBER(DEPT_NUMBER);
		}

		wfms_na_SupportImpl.setDEPT_NO(DEPT_NO);

		if (DEPT_NAME == null) {
			wfms_na_SupportImpl.setDEPT_NAME(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setDEPT_NAME(DEPT_NAME);
		}

		if (ASSOCIATE_TITLE == null) {
			wfms_na_SupportImpl.setASSOCIATE_TITLE(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setASSOCIATE_TITLE(ASSOCIATE_TITLE);
		}

		if (SHIFT_CODE == null) {
			wfms_na_SupportImpl.setSHIFT_CODE(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setSHIFT_CODE(SHIFT_CODE);
		}

		if (TEAM_NUMBER == null) {
			wfms_na_SupportImpl.setTEAM_NUMBER(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setTEAM_NUMBER(TEAM_NUMBER);
		}

		if (EFFDT == null) {
			wfms_na_SupportImpl.setEFFDT(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setEFFDT(EFFDT);
		}

		if (TERMINATION_DT == null) {
			wfms_na_SupportImpl.setTERMINATION_DT(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setTERMINATION_DT(TERMINATION_DT);
		}

		wfms_na_SupportImpl.setMANAGER_ASSOCIATE_NUMBER(MANAGER_ASSOCIATE_NUMBER);

		if (ASSGN_TYPE == null) {
			wfms_na_SupportImpl.setASSGN_TYPE(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setASSGN_TYPE(ASSGN_TYPE);
		}

		if (LEADERSHIP_ASSIGNMENT == null) {
			wfms_na_SupportImpl.setLEADERSHIP_ASSIGNMENT(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setLEADERSHIP_ASSIGNMENT(LEADERSHIP_ASSIGNMENT);
		}

		if (EMAIL == null) {
			wfms_na_SupportImpl.setEMAIL(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setEMAIL(EMAIL);
		}

		wfms_na_SupportImpl.setDeleteflag(deleteflag);

		if (createdBy == null) {
			wfms_na_SupportImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			wfms_na_SupportImpl.setCreateDate(null);
		}
		else {
			wfms_na_SupportImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedBy == null) {
			wfms_na_SupportImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			wfms_na_SupportImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wfms_na_SupportImpl.setModifiedDate(null);
		}
		else {
			wfms_na_SupportImpl.setModifiedDate(new Date(modifiedDate));
		}

		wfms_na_SupportImpl.resetOriginalValues();

		return wfms_na_SupportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ASSOCIATE_NUMBER = objectInput.readUTF();
		ASSOC_NO = objectInput.readUTF();
		ASSOCIATE_DATE_OF_HIRE = objectInput.readUTF();
		ASSOCIATE_NAME = objectInput.readUTF();
		DEPT_NUMBER = objectInput.readUTF();

		DEPT_NO = objectInput.readInt();
		DEPT_NAME = objectInput.readUTF();
		ASSOCIATE_TITLE = objectInput.readUTF();
		SHIFT_CODE = objectInput.readUTF();
		TEAM_NUMBER = objectInput.readUTF();
		EFFDT = objectInput.readUTF();
		TERMINATION_DT = objectInput.readUTF();

		MANAGER_ASSOCIATE_NUMBER = objectInput.readInt();
		ASSGN_TYPE = objectInput.readUTF();
		LEADERSHIP_ASSIGNMENT = objectInput.readUTF();
		EMAIL = objectInput.readUTF();

		deleteflag = objectInput.readInt();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (ASSOCIATE_NUMBER == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ASSOCIATE_NUMBER);
		}

		if (ASSOC_NO == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ASSOC_NO);
		}

		if (ASSOCIATE_DATE_OF_HIRE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ASSOCIATE_DATE_OF_HIRE);
		}

		if (ASSOCIATE_NAME == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ASSOCIATE_NAME);
		}

		if (DEPT_NUMBER == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(DEPT_NUMBER);
		}

		objectOutput.writeInt(DEPT_NO);

		if (DEPT_NAME == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(DEPT_NAME);
		}

		if (ASSOCIATE_TITLE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ASSOCIATE_TITLE);
		}

		if (SHIFT_CODE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SHIFT_CODE);
		}

		if (TEAM_NUMBER == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TEAM_NUMBER);
		}

		if (EFFDT == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(EFFDT);
		}

		if (TERMINATION_DT == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TERMINATION_DT);
		}

		objectOutput.writeInt(MANAGER_ASSOCIATE_NUMBER);

		if (ASSGN_TYPE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ASSGN_TYPE);
		}

		if (LEADERSHIP_ASSIGNMENT == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(LEADERSHIP_ASSIGNMENT);
		}

		if (EMAIL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(EMAIL);
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

	public String ASSOCIATE_NUMBER;
	public String ASSOC_NO;
	public String ASSOCIATE_DATE_OF_HIRE;
	public String ASSOCIATE_NAME;
	public String DEPT_NUMBER;
	public int DEPT_NO;
	public String DEPT_NAME;
	public String ASSOCIATE_TITLE;
	public String SHIFT_CODE;
	public String TEAM_NUMBER;
	public String EFFDT;
	public String TERMINATION_DT;
	public int MANAGER_ASSOCIATE_NUMBER;
	public String ASSGN_TYPE;
	public String LEADERSHIP_ASSIGNMENT;
	public String EMAIL;
	public int deleteflag;
	public String createdBy;
	public long createDate;
	public String modifiedBy;
	public long modifiedDate;
}