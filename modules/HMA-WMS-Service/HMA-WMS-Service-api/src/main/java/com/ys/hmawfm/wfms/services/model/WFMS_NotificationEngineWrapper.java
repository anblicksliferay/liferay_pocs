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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WFMS_NotificationEngine}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NotificationEngine
 * @generated
 */
@ProviderType
public class WFMS_NotificationEngineWrapper implements WFMS_NotificationEngine,
	ModelWrapper<WFMS_NotificationEngine> {
	public WFMS_NotificationEngineWrapper(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		_wfms_NotificationEngine = wfms_NotificationEngine;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_NotificationEngine.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_NotificationEngine.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("scopeGroupId", getScopeGroupId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("contentType", getContentType());
		attributes.put("comments", getComments());
		attributes.put("timesUsed", getTimesUsed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long scopeGroupId = (Long)attributes.get("scopeGroupId");

		if (scopeGroupId != null) {
			setScopeGroupId(scopeGroupId);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String contentType = (String)attributes.get("contentType");

		if (contentType != null) {
			setContentType(contentType);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Integer timesUsed = (Integer)attributes.get("timesUsed");

		if (timesUsed != null) {
			setTimesUsed(timesUsed);
		}
	}

	@Override
	public WFMS_NotificationEngine toEscapedModel() {
		return new WFMS_NotificationEngineWrapper(_wfms_NotificationEngine.toEscapedModel());
	}

	@Override
	public WFMS_NotificationEngine toUnescapedModel() {
		return new WFMS_NotificationEngineWrapper(_wfms_NotificationEngine.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_NotificationEngine.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_NotificationEngine.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_NotificationEngine.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_NotificationEngine.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_NotificationEngine> toCacheModel() {
		return _wfms_NotificationEngine.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_NotificationEngine wfms_NotificationEngine) {
		return _wfms_NotificationEngine.compareTo(wfms_NotificationEngine);
	}

	/**
	* Returns the times used of this WFMS_NotificationEngine.
	*
	* @return the times used of this WFMS_NotificationEngine
	*/
	@Override
	public int getTimesUsed() {
		return _wfms_NotificationEngine.getTimesUsed();
	}

	@Override
	public int hashCode() {
		return _wfms_NotificationEngine.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_NotificationEngine.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_NotificationEngineWrapper((WFMS_NotificationEngine)_wfms_NotificationEngine.clone());
	}

	/**
	* Returns the comments of this WFMS_NotificationEngine.
	*
	* @return the comments of this WFMS_NotificationEngine
	*/
	@Override
	public java.lang.String getComments() {
		return _wfms_NotificationEngine.getComments();
	}

	/**
	* Returns the content of this WFMS_NotificationEngine.
	*
	* @return the content of this WFMS_NotificationEngine
	*/
	@Override
	public java.lang.String getContent() {
		return _wfms_NotificationEngine.getContent();
	}

	/**
	* Returns the content type of this WFMS_NotificationEngine.
	*
	* @return the content type of this WFMS_NotificationEngine
	*/
	@Override
	public java.lang.String getContentType() {
		return _wfms_NotificationEngine.getContentType();
	}

	/**
	* Returns the created by of this WFMS_NotificationEngine.
	*
	* @return the created by of this WFMS_NotificationEngine
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_NotificationEngine.getCreatedBy();
	}

	/**
	* Returns the modified by of this WFMS_NotificationEngine.
	*
	* @return the modified by of this WFMS_NotificationEngine
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _wfms_NotificationEngine.getModifiedBy();
	}

	/**
	* Returns the title of this WFMS_NotificationEngine.
	*
	* @return the title of this WFMS_NotificationEngine
	*/
	@Override
	public java.lang.String getTitle() {
		return _wfms_NotificationEngine.getTitle();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_NotificationEngine.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_NotificationEngine.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_NotificationEngine.
	*
	* @return the create date of this WFMS_NotificationEngine
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_NotificationEngine.getCreateDate();
	}

	/**
	* Returns the modified date of this WFMS_NotificationEngine.
	*
	* @return the modified date of this WFMS_NotificationEngine
	*/
	@Override
	public Date getModifiedDate() {
		return _wfms_NotificationEngine.getModifiedDate();
	}

	/**
	* Returns the company ID of this WFMS_NotificationEngine.
	*
	* @return the company ID of this WFMS_NotificationEngine
	*/
	@Override
	public long getCompanyId() {
		return _wfms_NotificationEngine.getCompanyId();
	}

	/**
	* Returns the primary key of this WFMS_NotificationEngine.
	*
	* @return the primary key of this WFMS_NotificationEngine
	*/
	@Override
	public long getPrimaryKey() {
		return _wfms_NotificationEngine.getPrimaryKey();
	}

	/**
	* Returns the scope group ID of this WFMS_NotificationEngine.
	*
	* @return the scope group ID of this WFMS_NotificationEngine
	*/
	@Override
	public long getScopeGroupId() {
		return _wfms_NotificationEngine.getScopeGroupId();
	}

	/**
	* Returns the template ID of this WFMS_NotificationEngine.
	*
	* @return the template ID of this WFMS_NotificationEngine
	*/
	@Override
	public long getTemplateId() {
		return _wfms_NotificationEngine.getTemplateId();
	}

	@Override
	public void persist() {
		_wfms_NotificationEngine.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_NotificationEngine.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this WFMS_NotificationEngine.
	*
	* @param comments the comments of this WFMS_NotificationEngine
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_wfms_NotificationEngine.setComments(comments);
	}

	/**
	* Sets the company ID of this WFMS_NotificationEngine.
	*
	* @param companyId the company ID of this WFMS_NotificationEngine
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wfms_NotificationEngine.setCompanyId(companyId);
	}

	/**
	* Sets the content of this WFMS_NotificationEngine.
	*
	* @param content the content of this WFMS_NotificationEngine
	*/
	@Override
	public void setContent(java.lang.String content) {
		_wfms_NotificationEngine.setContent(content);
	}

	/**
	* Sets the content type of this WFMS_NotificationEngine.
	*
	* @param contentType the content type of this WFMS_NotificationEngine
	*/
	@Override
	public void setContentType(java.lang.String contentType) {
		_wfms_NotificationEngine.setContentType(contentType);
	}

	/**
	* Sets the create date of this WFMS_NotificationEngine.
	*
	* @param createDate the create date of this WFMS_NotificationEngine
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_NotificationEngine.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_NotificationEngine.
	*
	* @param createdBy the created by of this WFMS_NotificationEngine
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_NotificationEngine.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_NotificationEngine.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_NotificationEngine.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_NotificationEngine.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this WFMS_NotificationEngine.
	*
	* @param modifiedBy the modified by of this WFMS_NotificationEngine
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_wfms_NotificationEngine.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this WFMS_NotificationEngine.
	*
	* @param modifiedDate the modified date of this WFMS_NotificationEngine
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wfms_NotificationEngine.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_NotificationEngine.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_NotificationEngine.
	*
	* @param primaryKey the primary key of this WFMS_NotificationEngine
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wfms_NotificationEngine.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_NotificationEngine.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the scope group ID of this WFMS_NotificationEngine.
	*
	* @param scopeGroupId the scope group ID of this WFMS_NotificationEngine
	*/
	@Override
	public void setScopeGroupId(long scopeGroupId) {
		_wfms_NotificationEngine.setScopeGroupId(scopeGroupId);
	}

	/**
	* Sets the template ID of this WFMS_NotificationEngine.
	*
	* @param templateId the template ID of this WFMS_NotificationEngine
	*/
	@Override
	public void setTemplateId(long templateId) {
		_wfms_NotificationEngine.setTemplateId(templateId);
	}

	/**
	* Sets the times used of this WFMS_NotificationEngine.
	*
	* @param timesUsed the times used of this WFMS_NotificationEngine
	*/
	@Override
	public void setTimesUsed(int timesUsed) {
		_wfms_NotificationEngine.setTimesUsed(timesUsed);
	}

	/**
	* Sets the title of this WFMS_NotificationEngine.
	*
	* @param title the title of this WFMS_NotificationEngine
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_wfms_NotificationEngine.setTitle(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_NotificationEngineWrapper)) {
			return false;
		}

		WFMS_NotificationEngineWrapper wfms_NotificationEngineWrapper = (WFMS_NotificationEngineWrapper)obj;

		if (Objects.equals(_wfms_NotificationEngine,
					wfms_NotificationEngineWrapper._wfms_NotificationEngine)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_NotificationEngine getWrappedModel() {
		return _wfms_NotificationEngine;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_NotificationEngine.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_NotificationEngine.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_NotificationEngine.resetOriginalValues();
	}

	private final WFMS_NotificationEngine _wfms_NotificationEngine;
}