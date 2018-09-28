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
 * This class is a wrapper for {@link TestimonialAshok}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestimonialAshok
 * @generated
 */
@ProviderType
public class TestimonialAshokWrapper implements TestimonialAshok,
	ModelWrapper<TestimonialAshok> {
	public TestimonialAshokWrapper(TestimonialAshok testimonialAshok) {
		_testimonialAshok = testimonialAshok;
	}

	@Override
	public Class<?> getModelClass() {
		return TestimonialAshok.class;
	}

	@Override
	public String getModelClassName() {
		return TestimonialAshok.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("TestimonialContent", getTestimonialContent());

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

		String TestimonialContent = (String)attributes.get("TestimonialContent");

		if (TestimonialContent != null) {
			setTestimonialContent(TestimonialContent);
		}
	}

	@Override
	public TestimonialAshok toEscapedModel() {
		return new TestimonialAshokWrapper(_testimonialAshok.toEscapedModel());
	}

	@Override
	public TestimonialAshok toUnescapedModel() {
		return new TestimonialAshokWrapper(_testimonialAshok.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _testimonialAshok.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _testimonialAshok.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _testimonialAshok.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _testimonialAshok.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TestimonialAshok> toCacheModel() {
		return _testimonialAshok.toCacheModel();
	}

	@Override
	public int compareTo(TestimonialAshok testimonialAshok) {
		return _testimonialAshok.compareTo(testimonialAshok);
	}

	@Override
	public int hashCode() {
		return _testimonialAshok.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testimonialAshok.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TestimonialAshokWrapper((TestimonialAshok)_testimonialAshok.clone());
	}

	/**
	* Returns the testimonial content of this testimonial ashok.
	*
	* @return the testimonial content of this testimonial ashok
	*/
	@Override
	public java.lang.String getTestimonialContent() {
		return _testimonialAshok.getTestimonialContent();
	}

	/**
	* Returns the uuid of this testimonial ashok.
	*
	* @return the uuid of this testimonial ashok
	*/
	@Override
	public java.lang.String getUuid() {
		return _testimonialAshok.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _testimonialAshok.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testimonialAshok.toXmlString();
	}

	/**
	* Returns the ID of this testimonial ashok.
	*
	* @return the ID of this testimonial ashok
	*/
	@Override
	public long getId() {
		return _testimonialAshok.getId();
	}

	/**
	* Returns the primary key of this testimonial ashok.
	*
	* @return the primary key of this testimonial ashok
	*/
	@Override
	public long getPrimaryKey() {
		return _testimonialAshok.getPrimaryKey();
	}

	@Override
	public void persist() {
		_testimonialAshok.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testimonialAshok.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_testimonialAshok.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_testimonialAshok.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_testimonialAshok.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this testimonial ashok.
	*
	* @param id the ID of this testimonial ashok
	*/
	@Override
	public void setId(long id) {
		_testimonialAshok.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_testimonialAshok.setNew(n);
	}

	/**
	* Sets the primary key of this testimonial ashok.
	*
	* @param primaryKey the primary key of this testimonial ashok
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_testimonialAshok.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_testimonialAshok.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the testimonial content of this testimonial ashok.
	*
	* @param TestimonialContent the testimonial content of this testimonial ashok
	*/
	@Override
	public void setTestimonialContent(java.lang.String TestimonialContent) {
		_testimonialAshok.setTestimonialContent(TestimonialContent);
	}

	/**
	* Sets the uuid of this testimonial ashok.
	*
	* @param uuid the uuid of this testimonial ashok
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_testimonialAshok.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestimonialAshokWrapper)) {
			return false;
		}

		TestimonialAshokWrapper testimonialAshokWrapper = (TestimonialAshokWrapper)obj;

		if (Objects.equals(_testimonialAshok,
					testimonialAshokWrapper._testimonialAshok)) {
			return true;
		}

		return false;
	}

	@Override
	public TestimonialAshok getWrappedModel() {
		return _testimonialAshok;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _testimonialAshok.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _testimonialAshok.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_testimonialAshok.resetOriginalValues();
	}

	private final TestimonialAshok _testimonialAshok;
}