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

import com.ddt.model.TestimonialAshok;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TestimonialAshok in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TestimonialAshok
 * @generated
 */
@ProviderType
public class TestimonialAshokCacheModel implements CacheModel<TestimonialAshok>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestimonialAshokCacheModel)) {
			return false;
		}

		TestimonialAshokCacheModel testimonialAshokCacheModel = (TestimonialAshokCacheModel)obj;

		if (id == testimonialAshokCacheModel.id) {
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
		sb.append(", TestimonialContent=");
		sb.append(TestimonialContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TestimonialAshok toEntityModel() {
		TestimonialAshokImpl testimonialAshokImpl = new TestimonialAshokImpl();

		if (uuid == null) {
			testimonialAshokImpl.setUuid(StringPool.BLANK);
		}
		else {
			testimonialAshokImpl.setUuid(uuid);
		}

		testimonialAshokImpl.setId(id);

		if (TestimonialContent == null) {
			testimonialAshokImpl.setTestimonialContent(StringPool.BLANK);
		}
		else {
			testimonialAshokImpl.setTestimonialContent(TestimonialContent);
		}

		testimonialAshokImpl.resetOriginalValues();

		return testimonialAshokImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		TestimonialContent = objectInput.readUTF();
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

		if (TestimonialContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TestimonialContent);
		}
	}

	public String uuid;
	public long id;
	public String TestimonialContent;
}