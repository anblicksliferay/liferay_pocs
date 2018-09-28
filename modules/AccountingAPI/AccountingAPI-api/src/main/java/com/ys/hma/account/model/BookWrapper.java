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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookWrapper implements Book, ModelWrapper<Book> {
	public BookWrapper(Book book) {
		_book = book;
	}

	@Override
	public Class<?> getModelClass() {
		return Book.class;
	}

	@Override
	public String getModelClassName() {
		return Book.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("bookName", getBookName());
		attributes.put("description", getDescription());
		attributes.put("authorName", getAuthorName());
		attributes.put("isbn", getIsbn());
		attributes.put("price", getPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String bookName = (String)attributes.get("bookName");

		if (bookName != null) {
			setBookName(bookName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String authorName = (String)attributes.get("authorName");

		if (authorName != null) {
			setAuthorName(authorName);
		}

		Integer isbn = (Integer)attributes.get("isbn");

		if (isbn != null) {
			setIsbn(isbn);
		}

		Integer price = (Integer)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}
	}

	@Override
	public Book toEscapedModel() {
		return new BookWrapper(_book.toEscapedModel());
	}

	@Override
	public Book toUnescapedModel() {
		return new BookWrapper(_book.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _book.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _book.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _book.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _book.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Book> toCacheModel() {
		return _book.toCacheModel();
	}

	@Override
	public int compareTo(Book book) {
		return _book.compareTo(book);
	}

	/**
	* Returns the isbn of this book.
	*
	* @return the isbn of this book
	*/
	@Override
	public int getIsbn() {
		return _book.getIsbn();
	}

	/**
	* Returns the price of this book.
	*
	* @return the price of this book
	*/
	@Override
	public int getPrice() {
		return _book.getPrice();
	}

	@Override
	public int hashCode() {
		return _book.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _book.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BookWrapper((Book)_book.clone());
	}

	/**
	* Returns the author name of this book.
	*
	* @return the author name of this book
	*/
	@Override
	public java.lang.String getAuthorName() {
		return _book.getAuthorName();
	}

	/**
	* Returns the book name of this book.
	*
	* @return the book name of this book
	*/
	@Override
	public java.lang.String getBookName() {
		return _book.getBookName();
	}

	/**
	* Returns the description of this book.
	*
	* @return the description of this book
	*/
	@Override
	public java.lang.String getDescription() {
		return _book.getDescription();
	}

	@Override
	public java.lang.String toString() {
		return _book.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _book.toXmlString();
	}

	/**
	* Returns the book ID of this book.
	*
	* @return the book ID of this book
	*/
	@Override
	public long getBookId() {
		return _book.getBookId();
	}

	/**
	* Returns the primary key of this book.
	*
	* @return the primary key of this book
	*/
	@Override
	public long getPrimaryKey() {
		return _book.getPrimaryKey();
	}

	@Override
	public void persist() {
		_book.persist();
	}

	/**
	* Sets the author name of this book.
	*
	* @param authorName the author name of this book
	*/
	@Override
	public void setAuthorName(java.lang.String authorName) {
		_book.setAuthorName(authorName);
	}

	/**
	* Sets the book ID of this book.
	*
	* @param bookId the book ID of this book
	*/
	@Override
	public void setBookId(long bookId) {
		_book.setBookId(bookId);
	}

	/**
	* Sets the book name of this book.
	*
	* @param bookName the book name of this book
	*/
	@Override
	public void setBookName(java.lang.String bookName) {
		_book.setBookName(bookName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_book.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this book.
	*
	* @param description the description of this book
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_book.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_book.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_book.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_book.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the isbn of this book.
	*
	* @param isbn the isbn of this book
	*/
	@Override
	public void setIsbn(int isbn) {
		_book.setIsbn(isbn);
	}

	@Override
	public void setNew(boolean n) {
		_book.setNew(n);
	}

	/**
	* Sets the price of this book.
	*
	* @param price the price of this book
	*/
	@Override
	public void setPrice(int price) {
		_book.setPrice(price);
	}

	/**
	* Sets the primary key of this book.
	*
	* @param primaryKey the primary key of this book
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_book.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_book.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookWrapper)) {
			return false;
		}

		BookWrapper bookWrapper = (BookWrapper)obj;

		if (Objects.equals(_book, bookWrapper._book)) {
			return true;
		}

		return false;
	}

	@Override
	public Book getWrappedModel() {
		return _book;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _book.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _book.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_book.resetOriginalValues();
	}

	private final Book _book;
}