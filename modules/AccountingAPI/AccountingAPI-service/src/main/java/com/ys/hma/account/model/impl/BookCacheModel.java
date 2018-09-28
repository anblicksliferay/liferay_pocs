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

package com.ys.hma.account.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.ys.hma.account.model.Book;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookCacheModel implements CacheModel<Book>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookCacheModel)) {
			return false;
		}

		BookCacheModel bookCacheModel = (BookCacheModel)obj;

		if (bookId == bookCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", bookName=");
		sb.append(bookName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", authorName=");
		sb.append(authorName);
		sb.append(", isbn=");
		sb.append(isbn);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(bookId);

		if (bookName == null) {
			bookImpl.setBookName(StringPool.BLANK);
		}
		else {
			bookImpl.setBookName(bookName);
		}

		if (description == null) {
			bookImpl.setDescription(StringPool.BLANK);
		}
		else {
			bookImpl.setDescription(description);
		}

		if (authorName == null) {
			bookImpl.setAuthorName(StringPool.BLANK);
		}
		else {
			bookImpl.setAuthorName(authorName);
		}

		bookImpl.setIsbn(isbn);
		bookImpl.setPrice(price);

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readLong();
		bookName = objectInput.readUTF();
		description = objectInput.readUTF();
		authorName = objectInput.readUTF();

		isbn = objectInput.readInt();

		price = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookId);

		if (bookName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (authorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authorName);
		}

		objectOutput.writeInt(isbn);

		objectOutput.writeInt(price);
	}

	public long bookId;
	public String bookName;
	public String description;
	public String authorName;
	public int isbn;
	public int price;
}