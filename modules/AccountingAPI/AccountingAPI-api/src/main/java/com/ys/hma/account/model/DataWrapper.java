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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Data}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
@ProviderType
public class DataWrapper implements Data, ModelWrapper<Data> {
	public DataWrapper(Data data) {
		_data = data;
	}

	@Override
	public Class<?> getModelClass() {
		return Data.class;
	}

	@Override
	public String getModelClassName() {
		return Data.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("DataId", getDataId());
		attributes.put("StartDate", getStartDate());
		attributes.put("EndDate", getEndDate());
		attributes.put("Exported", getExported());
		attributes.put("NotExported", getNotExported());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long DataId = (Long)attributes.get("DataId");

		if (DataId != null) {
			setDataId(DataId);
		}

		Date StartDate = (Date)attributes.get("StartDate");

		if (StartDate != null) {
			setStartDate(StartDate);
		}

		Date EndDate = (Date)attributes.get("EndDate");

		if (EndDate != null) {
			setEndDate(EndDate);
		}

		Integer Exported = (Integer)attributes.get("Exported");

		if (Exported != null) {
			setExported(Exported);
		}

		Integer NotExported = (Integer)attributes.get("NotExported");

		if (NotExported != null) {
			setNotExported(NotExported);
		}
	}

	@Override
	public Data toEscapedModel() {
		return new DataWrapper(_data.toEscapedModel());
	}

	@Override
	public Data toUnescapedModel() {
		return new DataWrapper(_data.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _data.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _data.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _data.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _data.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Data> toCacheModel() {
		return _data.toCacheModel();
	}

	@Override
	public int compareTo(Data data) {
		return _data.compareTo(data);
	}

	/**
	* Returns the exported of this data.
	*
	* @return the exported of this data
	*/
	@Override
	public int getExported() {
		return _data.getExported();
	}

	/**
	* Returns the not exported of this data.
	*
	* @return the not exported of this data
	*/
	@Override
	public int getNotExported() {
		return _data.getNotExported();
	}

	@Override
	public int hashCode() {
		return _data.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _data.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DataWrapper((Data)_data.clone());
	}

	@Override
	public java.lang.String toString() {
		return _data.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _data.toXmlString();
	}

	/**
	* Returns the end date of this data.
	*
	* @return the end date of this data
	*/
	@Override
	public Date getEndDate() {
		return _data.getEndDate();
	}

	/**
	* Returns the start date of this data.
	*
	* @return the start date of this data
	*/
	@Override
	public Date getStartDate() {
		return _data.getStartDate();
	}

	/**
	* Returns the data ID of this data.
	*
	* @return the data ID of this data
	*/
	@Override
	public long getDataId() {
		return _data.getDataId();
	}

	/**
	* Returns the primary key of this data.
	*
	* @return the primary key of this data
	*/
	@Override
	public long getPrimaryKey() {
		return _data.getPrimaryKey();
	}

	@Override
	public void persist() {
		_data.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_data.setCachedModel(cachedModel);
	}

	/**
	* Sets the data ID of this data.
	*
	* @param DataId the data ID of this data
	*/
	@Override
	public void setDataId(long DataId) {
		_data.setDataId(DataId);
	}

	/**
	* Sets the end date of this data.
	*
	* @param EndDate the end date of this data
	*/
	@Override
	public void setEndDate(Date EndDate) {
		_data.setEndDate(EndDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_data.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_data.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_data.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the exported of this data.
	*
	* @param Exported the exported of this data
	*/
	@Override
	public void setExported(int Exported) {
		_data.setExported(Exported);
	}

	@Override
	public void setNew(boolean n) {
		_data.setNew(n);
	}

	/**
	* Sets the not exported of this data.
	*
	* @param NotExported the not exported of this data
	*/
	@Override
	public void setNotExported(int NotExported) {
		_data.setNotExported(NotExported);
	}

	/**
	* Sets the primary key of this data.
	*
	* @param primaryKey the primary key of this data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_data.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_data.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this data.
	*
	* @param StartDate the start date of this data
	*/
	@Override
	public void setStartDate(Date StartDate) {
		_data.setStartDate(StartDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataWrapper)) {
			return false;
		}

		DataWrapper dataWrapper = (DataWrapper)obj;

		if (Objects.equals(_data, dataWrapper._data)) {
			return true;
		}

		return false;
	}

	@Override
	public Data getWrappedModel() {
		return _data;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _data.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _data.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_data.resetOriginalValues();
	}

	private final Data _data;
}