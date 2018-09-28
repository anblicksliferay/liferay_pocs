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
 * This class is a wrapper for {@link WFMS_Associate_History}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Associate_History
 * @generated
 */
@ProviderType
public class WFMS_Associate_HistoryWrapper implements WFMS_Associate_History,
	ModelWrapper<WFMS_Associate_History> {
	public WFMS_Associate_HistoryWrapper(
		WFMS_Associate_History wfms_Associate_History) {
		_wfms_Associate_History = wfms_Associate_History;
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_Associate_History.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_Associate_History.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("assocHistoryId", getAssocHistoryId());
		attributes.put("associateId", getAssociateId());
		attributes.put("associateName", getAssociateName());
		attributes.put("currentPosition", getCurrentPosition());
		attributes.put("history", getHistory());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer assocHistoryId = (Integer)attributes.get("assocHistoryId");

		if (assocHistoryId != null) {
			setAssocHistoryId(assocHistoryId);
		}

		String associateId = (String)attributes.get("associateId");

		if (associateId != null) {
			setAssociateId(associateId);
		}

		String associateName = (String)attributes.get("associateName");

		if (associateName != null) {
			setAssociateName(associateName);
		}

		String currentPosition = (String)attributes.get("currentPosition");

		if (currentPosition != null) {
			setCurrentPosition(currentPosition);
		}

		String history = (String)attributes.get("history");

		if (history != null) {
			setHistory(history);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public WFMS_Associate_History toEscapedModel() {
		return new WFMS_Associate_HistoryWrapper(_wfms_Associate_History.toEscapedModel());
	}

	@Override
	public WFMS_Associate_History toUnescapedModel() {
		return new WFMS_Associate_HistoryWrapper(_wfms_Associate_History.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wfms_Associate_History.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wfms_Associate_History.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wfms_Associate_History.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wfms_Associate_History.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WFMS_Associate_History> toCacheModel() {
		return _wfms_Associate_History.toCacheModel();
	}

	@Override
	public int compareTo(WFMS_Associate_History wfms_Associate_History) {
		return _wfms_Associate_History.compareTo(wfms_Associate_History);
	}

	/**
	* Returns the assoc history ID of this WFMS_Associate_History.
	*
	* @return the assoc history ID of this WFMS_Associate_History
	*/
	@Override
	public int getAssocHistoryId() {
		return _wfms_Associate_History.getAssocHistoryId();
	}

	/**
	* Returns the primary key of this WFMS_Associate_History.
	*
	* @return the primary key of this WFMS_Associate_History
	*/
	@Override
	public int getPrimaryKey() {
		return _wfms_Associate_History.getPrimaryKey();
	}

	@Override
	public int hashCode() {
		return _wfms_Associate_History.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfms_Associate_History.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WFMS_Associate_HistoryWrapper((WFMS_Associate_History)_wfms_Associate_History.clone());
	}

	/**
	* Returns the associate ID of this WFMS_Associate_History.
	*
	* @return the associate ID of this WFMS_Associate_History
	*/
	@Override
	public java.lang.String getAssociateId() {
		return _wfms_Associate_History.getAssociateId();
	}

	/**
	* Returns the associate name of this WFMS_Associate_History.
	*
	* @return the associate name of this WFMS_Associate_History
	*/
	@Override
	public java.lang.String getAssociateName() {
		return _wfms_Associate_History.getAssociateName();
	}

	/**
	* Returns the created by of this WFMS_Associate_History.
	*
	* @return the created by of this WFMS_Associate_History
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _wfms_Associate_History.getCreatedBy();
	}

	/**
	* Returns the current position of this WFMS_Associate_History.
	*
	* @return the current position of this WFMS_Associate_History
	*/
	@Override
	public java.lang.String getCurrentPosition() {
		return _wfms_Associate_History.getCurrentPosition();
	}

	/**
	* Returns the history of this WFMS_Associate_History.
	*
	* @return the history of this WFMS_Associate_History
	*/
	@Override
	public java.lang.String getHistory() {
		return _wfms_Associate_History.getHistory();
	}

	@Override
	public java.lang.String toString() {
		return _wfms_Associate_History.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wfms_Associate_History.toXmlString();
	}

	/**
	* Returns the create date of this WFMS_Associate_History.
	*
	* @return the create date of this WFMS_Associate_History
	*/
	@Override
	public Date getCreateDate() {
		return _wfms_Associate_History.getCreateDate();
	}

	@Override
	public void persist() {
		_wfms_Associate_History.persist();
	}

	/**
	* Sets the assoc history ID of this WFMS_Associate_History.
	*
	* @param assocHistoryId the assoc history ID of this WFMS_Associate_History
	*/
	@Override
	public void setAssocHistoryId(int assocHistoryId) {
		_wfms_Associate_History.setAssocHistoryId(assocHistoryId);
	}

	/**
	* Sets the associate ID of this WFMS_Associate_History.
	*
	* @param associateId the associate ID of this WFMS_Associate_History
	*/
	@Override
	public void setAssociateId(java.lang.String associateId) {
		_wfms_Associate_History.setAssociateId(associateId);
	}

	/**
	* Sets the associate name of this WFMS_Associate_History.
	*
	* @param associateName the associate name of this WFMS_Associate_History
	*/
	@Override
	public void setAssociateName(java.lang.String associateName) {
		_wfms_Associate_History.setAssociateName(associateName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wfms_Associate_History.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this WFMS_Associate_History.
	*
	* @param createDate the create date of this WFMS_Associate_History
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wfms_Associate_History.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this WFMS_Associate_History.
	*
	* @param createdBy the created by of this WFMS_Associate_History
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_wfms_Associate_History.setCreatedBy(createdBy);
	}

	/**
	* Sets the current position of this WFMS_Associate_History.
	*
	* @param currentPosition the current position of this WFMS_Associate_History
	*/
	@Override
	public void setCurrentPosition(java.lang.String currentPosition) {
		_wfms_Associate_History.setCurrentPosition(currentPosition);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wfms_Associate_History.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wfms_Associate_History.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wfms_Associate_History.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the history of this WFMS_Associate_History.
	*
	* @param history the history of this WFMS_Associate_History
	*/
	@Override
	public void setHistory(java.lang.String history) {
		_wfms_Associate_History.setHistory(history);
	}

	@Override
	public void setNew(boolean n) {
		_wfms_Associate_History.setNew(n);
	}

	/**
	* Sets the primary key of this WFMS_Associate_History.
	*
	* @param primaryKey the primary key of this WFMS_Associate_History
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_wfms_Associate_History.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wfms_Associate_History.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_Associate_HistoryWrapper)) {
			return false;
		}

		WFMS_Associate_HistoryWrapper wfms_Associate_HistoryWrapper = (WFMS_Associate_HistoryWrapper)obj;

		if (Objects.equals(_wfms_Associate_History,
					wfms_Associate_HistoryWrapper._wfms_Associate_History)) {
			return true;
		}

		return false;
	}

	@Override
	public WFMS_Associate_History getWrappedModel() {
		return _wfms_Associate_History;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wfms_Associate_History.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wfms_Associate_History.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wfms_Associate_History.resetOriginalValues();
	}

	private final WFMS_Associate_History _wfms_Associate_History;
}