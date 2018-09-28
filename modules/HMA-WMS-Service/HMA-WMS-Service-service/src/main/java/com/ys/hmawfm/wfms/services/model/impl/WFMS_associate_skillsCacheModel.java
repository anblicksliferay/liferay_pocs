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

import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WFMS_associate_skills in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills
 * @generated
 */
@ProviderType
public class WFMS_associate_skillsCacheModel implements CacheModel<WFMS_associate_skills>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_associate_skillsCacheModel)) {
			return false;
		}

		WFMS_associate_skillsCacheModel wfms_associate_skillsCacheModel = (WFMS_associate_skillsCacheModel)obj;

		if (associate_number.equals(
					wfms_associate_skillsCacheModel.associate_number)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, associate_number);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{associate_number=");
		sb.append(associate_number);
		sb.append(", skills=");
		sb.append(skills);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WFMS_associate_skills toEntityModel() {
		WFMS_associate_skillsImpl wfms_associate_skillsImpl = new WFMS_associate_skillsImpl();

		if (associate_number == null) {
			wfms_associate_skillsImpl.setAssociate_number(StringPool.BLANK);
		}
		else {
			wfms_associate_skillsImpl.setAssociate_number(associate_number);
		}

		if (skills == null) {
			wfms_associate_skillsImpl.setSkills(StringPool.BLANK);
		}
		else {
			wfms_associate_skillsImpl.setSkills(skills);
		}

		wfms_associate_skillsImpl.resetOriginalValues();

		return wfms_associate_skillsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		associate_number = objectInput.readUTF();
		skills = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (associate_number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associate_number);
		}

		if (skills == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skills);
		}
	}

	public String associate_number;
	public String skills;
}