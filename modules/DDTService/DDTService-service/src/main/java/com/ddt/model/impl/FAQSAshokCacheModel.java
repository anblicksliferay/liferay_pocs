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

package com.ddt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.ddt.model.FAQSAshok;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FAQSAshok in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FAQSAshok
 * @generated
 */
@ProviderType
public class FAQSAshokCacheModel implements CacheModel<FAQSAshok>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FAQSAshokCacheModel)) {
			return false;
		}

		FAQSAshokCacheModel faqsAshokCacheModel = (FAQSAshokCacheModel)obj;

		if (id == faqsAshokCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", FAQSContent=");
		sb.append(FAQSContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FAQSAshok toEntityModel() {
		FAQSAshokImpl faqsAshokImpl = new FAQSAshokImpl();

		if (uuid == null) {
			faqsAshokImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqsAshokImpl.setUuid(uuid);
		}

		faqsAshokImpl.setId(id);

		if (FAQSContent == null) {
			faqsAshokImpl.setFAQSContent(StringPool.BLANK);
		}
		else {
			faqsAshokImpl.setFAQSContent(FAQSContent);
		}

		faqsAshokImpl.resetOriginalValues();

		return faqsAshokImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		FAQSContent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (FAQSContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FAQSContent);
		}
	}

	public String uuid;
	public long id;
	public String FAQSContent;
}