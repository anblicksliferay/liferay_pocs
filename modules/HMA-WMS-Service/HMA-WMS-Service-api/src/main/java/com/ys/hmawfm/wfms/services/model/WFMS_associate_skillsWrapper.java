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

package com.ys.hmawfm.wfms.services.model;

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
 * This class is a wrapper for {@link WFMS_associate_skills}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills
 * @generated
 */
@ProviderType
public class WFMS_associate_skillsWrapper implements WFMS_associate_skills,
	ModelWrapper<WFMS_associate_skills> {
	public WFMS_associate_skillsWrapper(
		WFMS_associate_skills wfms_associate_skills) {
		_wfms_associate_skills = wfms_associate_skills;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_associate_skills.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_associate_skills.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("associate_number", getAssociate_number());
		attributes.put("skills", getSkills());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String associate_number = (String)attributes.get("associate_number");

		if (associate_number != null) {
			setAssociate_number(associate_number);
		}

		String skills = (String)attributes.get("skills");

		if (skills != null) {
			setSkills(skills);
		}
	}

	@Override
	public WFMS_associate_skills toEscapedModel() {
		return new WFMS_associate_skillsWrapper(_wfms_associate_skills.toEscapedModel());
	}

	@Override
	public WFMS_associate_skills toUnescapedModel() {
		return new WFMS_associate_skillsWrapper(_wfms_associate_skills.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_associate_skills.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_associate_skills.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_associate_skills.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_associate_skills.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_associate_skills> toCacheModel() {
		return _wfms_associate_skills.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_associate_skills wfms_associate_skills) {
		return _wfms_associate_skills.compareTo(wfms_associate_skills);
	}

	@Override
	public int hashCode() {
		return _wfms_associate_skills.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_associate_skills.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_associate_skillsWrapper((WFMS_associate_skills)_wfms_associate_skills.clone());
	}

	/**
	* Returns the associate_number of this WFMS_associate_skills.
	*
	* @return the associate_number of this WFMS_associate_skills
	*/
	@Override
	public java.lang.String getAssociate_number() {
		return _wfms_associate_skills.getAssociate_number();
	}

	/**
	* Returns the primary key of this WFMS_associate_skills.
	*
	* @return the primary key of this WFMS_associate_skills
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _wfms_associate_skills.getPrimaryKey();
	}

	/**
	* Returns the skills of this WFMS_associate_skills.
	*
	* @return the skills of this WFMS_associate_skills
	*/
	@Override
	public java.lang.String getSkills() {
		return _wfms_associate_skills.getSkills();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_associate_skills.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_associate_skills.toXmlString();
	}

	@Override
	public void persist() {
		_wfms_associate_skills.persist();
	}

	/**
	* Sets the associate_number of this WFMS_associate_skills.
	*
	* @param associate_number the associate_number of this WFMS_associate_skills
	*/
	@Override
	public void setAssociate_number(java.lang.String associate_number) {
		_wfms_associate_skills.setAssociate_number(associate_number);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_associate_skills.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_associate_skills.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_associate_skills.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_associate_skills.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_associate_skills.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_associate_skills.
	*
	* @param primaryKey the primary key of this WFMS_associate_skills
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_wfms_associate_skills.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_associate_skills.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the skills of this WFMS_associate_skills.
	*
	* @param skills the skills of this WFMS_associate_skills
	*/
	@Override
	public void setSkills(java.lang.String skills) {
		_wfms_associate_skills.setSkills(skills);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_associate_skillsWrapper)) {
			return false;
		}

		WFMS_associate_skillsWrapper wfms_associate_skillsWrapper = (WFMS_associate_skillsWrapper)obj;

		if (Objects.equals(_wfms_associate_skills,
					wfms_associate_skillsWrapper._wfms_associate_skills)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_associate_skills getWrappedModel() {
		return _wfms_associate_skills;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_associate_skills.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_associate_skills.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_associate_skills.resetOriginalValues();
	}

	private final WFMS_associate_skills _wfms_associate_skills;
}