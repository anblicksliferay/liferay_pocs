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

package com.ys.hma.account.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ys.hma.account.service.http.BookServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hma.account.service.http.BookServiceSoap
 * @generated
 */
@ProviderType
public class BookSoap implements Serializable {
	public static BookSoap toSoapModel(Book model) {
		BookSoap soapModel = new BookSoap();

		soapModel.setBookId(model.getBookId());
		soapModel.setBookName(model.getBookName());
		soapModel.setDescription(model.getDescription());
		soapModel.setAuthorName(model.getAuthorName());
		soapModel.setIsbn(model.getIsbn());
		soapModel.setPrice(model.getPrice());

		return soapModel;
	}

	public static BookSoap[] toSoapModels(Book[] models) {
		BookSoap[] soapModels = new BookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookSoap[][] toSoapModels(Book[][] models) {
		BookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookSoap[] toSoapModels(List<Book> models) {
		List<BookSoap> soapModels = new ArrayList<BookSoap>(models.size());

		for (Book model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookSoap[soapModels.size()]);
	}

	public BookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public String getBookName() {
		return _bookName;
	}

	public void setBookName(String bookName) {
		_bookName = bookName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAuthorName() {
		return _authorName;
	}

	public void setAuthorName(String authorName) {
		_authorName = authorName;
	}

	public int getIsbn() {
		return _isbn;
	}

	public void setIsbn(int isbn) {
		_isbn = isbn;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}

	private long _bookId;
	private String _bookName;
	private String _description;
	private String _authorName;
	private int _isbn;
	private int _price;
}