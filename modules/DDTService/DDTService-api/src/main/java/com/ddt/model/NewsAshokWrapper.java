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

package com.ddt.model;

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
 * This class is a wrapper for {@link NewsAshok}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsAshok
 * @generated
 */
@ProviderType
public class NewsAshokWrapper implements NewsAshok, ModelWrapper<NewsAshok> {
	public NewsAshokWrapper(NewsAshok newsAshok) {
		_newsAshok = newsAshok;
	}

	@Override
	public Class<?> getModelClass() {
		return NewsAshok.class;
	}

	@Override
	public String getModelClassName() {
		return NewsAshok.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("Newscontent", getNewscontent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String Newscontent = (String)attributes.get("Newscontent");

		if (Newscontent != null) {
			setNewscontent(Newscontent);
		}
	}

	@Override
	public NewsAshok toEscapedModel() {
		return new NewsAshokWrapper(_newsAshok.toEscapedModel());
	}

	@Override
	public NewsAshok toUnescapedModel() {
		return new NewsAshokWrapper(_newsAshok.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _newsAshok.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _newsAshok.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _newsAshok.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _newsAshok.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<NewsAshok> toCacheModel() {
		return _newsAshok.toCacheModel();
	}

	@Override
	public int compareTo(NewsAshok newsAshok) {
		return _newsAshok.compareTo(newsAshok);
	}

	@Override
	public int hashCode() {
		return _newsAshok.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsAshok.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new NewsAshokWrapper((NewsAshok)_newsAshok.clone());
	}

	/**
	* Returns the newscontent of this news ashok.
	*
	* @return the newscontent of this news ashok
	*/
	@Override
	public java.lang.String getNewscontent() {
		return _newsAshok.getNewscontent();
	}

	/**
	* Returns the uuid of this news ashok.
	*
	* @return the uuid of this news ashok
	*/
	@Override
	public java.lang.String getUuid() {
		return _newsAshok.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _newsAshok.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _newsAshok.toXmlString();
	}

	/**
	* Returns the ID of this news ashok.
	*
	* @return the ID of this news ashok
	*/
	@Override
	public long getId() {
		return _newsAshok.getId();
	}

	/**
	* Returns the primary key of this news ashok.
	*
	* @return the primary key of this news ashok
	*/
	@Override
	public long getPrimaryKey() {
		return _newsAshok.getPrimaryKey();
	}

	@Override
	public void persist() {
		_newsAshok.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_newsAshok.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_newsAshok.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_newsAshok.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_newsAshok.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this news ashok.
	*
	* @param id the ID of this news ashok
	*/
	@Override
	public void setId(long id) {
		_newsAshok.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_newsAshok.setNew(n);
	}

	/**
	* Sets the newscontent of this news ashok.
	*
	* @param Newscontent the newscontent of this news ashok
	*/
	@Override
	public void setNewscontent(java.lang.String Newscontent) {
		_newsAshok.setNewscontent(Newscontent);
	}

	/**
	* Sets the primary key of this news ashok.
	*
	* @param primaryKey the primary key of this news ashok
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_newsAshok.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_newsAshok.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this news ashok.
	*
	* @param uuid the uuid of this news ashok
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_newsAshok.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsAshokWrapper)) {
			return false;
		}

		NewsAshokWrapper newsAshokWrapper = (NewsAshokWrapper)obj;

		if (Objects.equals(_newsAshok, newsAshokWrapper._newsAshok)) {
			return true;
		}

		return false;
	}

	@Override
	public NewsAshok getWrappedModel() {
		return _newsAshok;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _newsAshok.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _newsAshok.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_newsAshok.resetOriginalValues();
	}

	private final NewsAshok _newsAshok;
}