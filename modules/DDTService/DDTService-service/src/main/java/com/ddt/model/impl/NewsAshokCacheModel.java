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

import com.ddt.model.NewsAshok;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NewsAshok in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NewsAshok
 * @generated
 */
@ProviderType
public class NewsAshokCacheModel implements CacheModel<NewsAshok>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsAshokCacheModel)) {
			return false;
		}

		NewsAshokCacheModel newsAshokCacheModel = (NewsAshokCacheModel)obj;

		if (id == newsAshokCacheModel.id) {
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
		sb.append(", Newscontent=");
		sb.append(Newscontent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NewsAshok toEntityModel() {
		NewsAshokImpl newsAshokImpl = new NewsAshokImpl();

		if (uuid == null) {
			newsAshokImpl.setUuid(StringPool.BLANK);
		}
		else {
			newsAshokImpl.setUuid(uuid);
		}

		newsAshokImpl.setId(id);

		if (Newscontent == null) {
			newsAshokImpl.setNewscontent(StringPool.BLANK);
		}
		else {
			newsAshokImpl.setNewscontent(Newscontent);
		}

		newsAshokImpl.resetOriginalValues();

		return newsAshokImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		Newscontent = objectInput.readUTF();
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

		if (Newscontent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Newscontent);
		}
	}

	public String uuid;
	public long id;
	public String Newscontent;
}