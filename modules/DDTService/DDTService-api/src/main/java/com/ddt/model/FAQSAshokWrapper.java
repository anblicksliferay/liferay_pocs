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
 * This class is a wrapper for {@link FAQSAshok}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FAQSAshok
 * @generated
 */
@ProviderType
public class FAQSAshokWrapper implements FAQSAshok, ModelWrapper<FAQSAshok> {
	public FAQSAshokWrapper(FAQSAshok faqsAshok) {
		_faqsAshok = faqsAshok;
	}

	@Override
	public Class<?> getModelClass() {
		return FAQSAshok.class;
	}

	@Override
	public String getModelClassName() {
		return FAQSAshok.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("FAQSContent", getFAQSContent());

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

		String FAQSContent = (String)attributes.get("FAQSContent");

		if (FAQSContent != null) {
			setFAQSContent(FAQSContent);
		}
	}

	@Override
	public FAQSAshok toEscapedModel() {
		return new FAQSAshokWrapper(_faqsAshok.toEscapedModel());
	}

	@Override
	public FAQSAshok toUnescapedModel() {
		return new FAQSAshokWrapper(_faqsAshok.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _faqsAshok.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _faqsAshok.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _faqsAshok.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _faqsAshok.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FAQSAshok> toCacheModel() {
		return _faqsAshok.toCacheModel();
	}

	@Override
	public int compareTo(FAQSAshok faqsAshok) {
		return _faqsAshok.compareTo(faqsAshok);
	}

	@Override
	public int hashCode() {
		return _faqsAshok.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _faqsAshok.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FAQSAshokWrapper((FAQSAshok)_faqsAshok.clone());
	}

	/**
	* Returns the f a q s content of this f a q s ashok.
	*
	* @return the f a q s content of this f a q s ashok
	*/
	@Override
	public java.lang.String getFAQSContent() {
		return _faqsAshok.getFAQSContent();
	}

	/**
	* Returns the uuid of this f a q s ashok.
	*
	* @return the uuid of this f a q s ashok
	*/
	@Override
	public java.lang.String getUuid() {
		return _faqsAshok.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _faqsAshok.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _faqsAshok.toXmlString();
	}

	/**
	* Returns the ID of this f a q s ashok.
	*
	* @return the ID of this f a q s ashok
	*/
	@Override
	public long getId() {
		return _faqsAshok.getId();
	}

	/**
	* Returns the primary key of this f a q s ashok.
	*
	* @return the primary key of this f a q s ashok
	*/
	@Override
	public long getPrimaryKey() {
		return _faqsAshok.getPrimaryKey();
	}

	@Override
	public void persist() {
		_faqsAshok.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_faqsAshok.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_faqsAshok.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_faqsAshok.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_faqsAshok.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the f a q s content of this f a q s ashok.
	*
	* @param FAQSContent the f a q s content of this f a q s ashok
	*/
	@Override
	public void setFAQSContent(java.lang.String FAQSContent) {
		_faqsAshok.setFAQSContent(FAQSContent);
	}

	/**
	* Sets the ID of this f a q s ashok.
	*
	* @param id the ID of this f a q s ashok
	*/
	@Override
	public void setId(long id) {
		_faqsAshok.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_faqsAshok.setNew(n);
	}

	/**
	* Sets the primary key of this f a q s ashok.
	*
	* @param primaryKey the primary key of this f a q s ashok
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_faqsAshok.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_faqsAshok.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this f a q s ashok.
	*
	* @param uuid the uuid of this f a q s ashok
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_faqsAshok.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FAQSAshokWrapper)) {
			return false;
		}

		FAQSAshokWrapper faqsAshokWrapper = (FAQSAshokWrapper)obj;

		if (Objects.equals(_faqsAshok, faqsAshokWrapper._faqsAshok)) {
			return true;
		}

		return false;
	}

	@Override
	public FAQSAshok getWrappedModel() {
		return _faqsAshok;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _faqsAshok.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _faqsAshok.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_faqsAshok.resetOriginalValues();
	}

	private final FAQSAshok _faqsAshok;
}