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

package com.astra.anblicks.pdca.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link kpi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see kpi
 * @generated
 */
@ProviderType
public class kpiWrapper implements kpi, ModelWrapper<kpi> {
	public kpiWrapper(kpi kpi) {
		_kpi = kpi;
	}

	@Override
	public Class<?> getModelClass() {
		return kpi.class;
	}

	@Override
	public String getModelClassName() {
		return kpi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("kpiId", getKpiId());
		attributes.put("companyName", getCompanyName());
		attributes.put("tipe", getTipe());
		attributes.put("weight", getWeight());
		attributes.put("target", getTarget());
		attributes.put("year", getYear());
		attributes.put("unit", getUnit());
		attributes.put("achivementFormula", getAchivementFormula());
		attributes.put("itemDescription", getItemDescription());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long kpiId = (Long)attributes.get("kpiId");

		if (kpiId != null) {
			setKpiId(kpiId);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String tipe = (String)attributes.get("tipe");

		if (tipe != null) {
			setTipe(tipe);
		}

		String weight = (String)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String target = (String)attributes.get("target");

		if (target != null) {
			setTarget(target);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		String achivementFormula = (String)attributes.get("achivementFormula");

		if (achivementFormula != null) {
			setAchivementFormula(achivementFormula);
		}

		String itemDescription = (String)attributes.get("itemDescription");

		if (itemDescription != null) {
			setItemDescription(itemDescription);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _kpi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _kpi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _kpi.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.kpi toEscapedModel() {
		return new kpiWrapper(_kpi.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.kpi toUnescapedModel() {
		return new kpiWrapper(_kpi.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _kpi.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.kpi> toCacheModel() {
		return _kpi.toCacheModel();
	}

	@Override
	public int compareTo(com.astra.anblicks.pdca.model.kpi kpi) {
		return _kpi.compareTo(kpi);
	}

	@Override
	public int hashCode() {
		return _kpi.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kpi.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new kpiWrapper((kpi)_kpi.clone());
	}

	/**
	* Returns the achivement formula of this kpi.
	*
	* @return the achivement formula of this kpi
	*/
	@Override
	public java.lang.String getAchivementFormula() {
		return _kpi.getAchivementFormula();
	}

	/**
	* Returns the company name of this kpi.
	*
	* @return the company name of this kpi
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _kpi.getCompanyName();
	}

	/**
	* Returns the item description of this kpi.
	*
	* @return the item description of this kpi
	*/
	@Override
	public java.lang.String getItemDescription() {
		return _kpi.getItemDescription();
	}

	/**
	* Returns the target of this kpi.
	*
	* @return the target of this kpi
	*/
	@Override
	public java.lang.String getTarget() {
		return _kpi.getTarget();
	}

	/**
	* Returns the tipe of this kpi.
	*
	* @return the tipe of this kpi
	*/
	@Override
	public java.lang.String getTipe() {
		return _kpi.getTipe();
	}

	/**
	* Returns the unit of this kpi.
	*
	* @return the unit of this kpi
	*/
	@Override
	public java.lang.String getUnit() {
		return _kpi.getUnit();
	}

	/**
	* Returns the user name of this kpi.
	*
	* @return the user name of this kpi
	*/
	@Override
	public java.lang.String getUserName() {
		return _kpi.getUserName();
	}

	/**
	* Returns the user uuid of this kpi.
	*
	* @return the user uuid of this kpi
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _kpi.getUserUuid();
	}

	/**
	* Returns the uuid of this kpi.
	*
	* @return the uuid of this kpi
	*/
	@Override
	public java.lang.String getUuid() {
		return _kpi.getUuid();
	}

	/**
	* Returns the weight of this kpi.
	*
	* @return the weight of this kpi
	*/
	@Override
	public java.lang.String getWeight() {
		return _kpi.getWeight();
	}

	/**
	* Returns the year of this kpi.
	*
	* @return the year of this kpi
	*/
	@Override
	public java.lang.String getYear() {
		return _kpi.getYear();
	}

	@Override
	public java.lang.String toString() {
		return _kpi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kpi.toXmlString();
	}

	/**
	* Returns the create date of this kpi.
	*
	* @return the create date of this kpi
	*/
	@Override
	public Date getCreateDate() {
		return _kpi.getCreateDate();
	}

	/**
	* Returns the modified date of this kpi.
	*
	* @return the modified date of this kpi
	*/
	@Override
	public Date getModifiedDate() {
		return _kpi.getModifiedDate();
	}

	/**
	* Returns the company ID of this kpi.
	*
	* @return the company ID of this kpi
	*/
	@Override
	public long getCompanyId() {
		return _kpi.getCompanyId();
	}

	/**
	* Returns the kpi ID of this kpi.
	*
	* @return the kpi ID of this kpi
	*/
	@Override
	public long getKpiId() {
		return _kpi.getKpiId();
	}

	/**
	* Returns the primary key of this kpi.
	*
	* @return the primary key of this kpi
	*/
	@Override
	public long getPrimaryKey() {
		return _kpi.getPrimaryKey();
	}

	/**
	* Returns the user ID of this kpi.
	*
	* @return the user ID of this kpi
	*/
	@Override
	public long getUserId() {
		return _kpi.getUserId();
	}

	@Override
	public void persist() {
		_kpi.persist();
	}

	/**
	* Sets the achivement formula of this kpi.
	*
	* @param achivementFormula the achivement formula of this kpi
	*/
	@Override
	public void setAchivementFormula(java.lang.String achivementFormula) {
		_kpi.setAchivementFormula(achivementFormula);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kpi.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this kpi.
	*
	* @param companyId the company ID of this kpi
	*/
	@Override
	public void setCompanyId(long companyId) {
		_kpi.setCompanyId(companyId);
	}

	/**
	* Sets the company name of this kpi.
	*
	* @param companyName the company name of this kpi
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_kpi.setCompanyName(companyName);
	}

	/**
	* Sets the create date of this kpi.
	*
	* @param createDate the create date of this kpi
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_kpi.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_kpi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_kpi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_kpi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the item description of this kpi.
	*
	* @param itemDescription the item description of this kpi
	*/
	@Override
	public void setItemDescription(java.lang.String itemDescription) {
		_kpi.setItemDescription(itemDescription);
	}

	/**
	* Sets the kpi ID of this kpi.
	*
	* @param kpiId the kpi ID of this kpi
	*/
	@Override
	public void setKpiId(long kpiId) {
		_kpi.setKpiId(kpiId);
	}

	/**
	* Sets the modified date of this kpi.
	*
	* @param modifiedDate the modified date of this kpi
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_kpi.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_kpi.setNew(n);
	}

	/**
	* Sets the primary key of this kpi.
	*
	* @param primaryKey the primary key of this kpi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kpi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_kpi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the target of this kpi.
	*
	* @param target the target of this kpi
	*/
	@Override
	public void setTarget(java.lang.String target) {
		_kpi.setTarget(target);
	}

	/**
	* Sets the tipe of this kpi.
	*
	* @param tipe the tipe of this kpi
	*/
	@Override
	public void setTipe(java.lang.String tipe) {
		_kpi.setTipe(tipe);
	}

	/**
	* Sets the unit of this kpi.
	*
	* @param unit the unit of this kpi
	*/
	@Override
	public void setUnit(java.lang.String unit) {
		_kpi.setUnit(unit);
	}

	/**
	* Sets the user ID of this kpi.
	*
	* @param userId the user ID of this kpi
	*/
	@Override
	public void setUserId(long userId) {
		_kpi.setUserId(userId);
	}

	/**
	* Sets the user name of this kpi.
	*
	* @param userName the user name of this kpi
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_kpi.setUserName(userName);
	}

	/**
	* Sets the user uuid of this kpi.
	*
	* @param userUuid the user uuid of this kpi
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_kpi.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this kpi.
	*
	* @param uuid the uuid of this kpi
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_kpi.setUuid(uuid);
	}

	/**
	* Sets the weight of this kpi.
	*
	* @param weight the weight of this kpi
	*/
	@Override
	public void setWeight(java.lang.String weight) {
		_kpi.setWeight(weight);
	}

	/**
	* Sets the year of this kpi.
	*
	* @param year the year of this kpi
	*/
	@Override
	public void setYear(java.lang.String year) {
		_kpi.setYear(year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kpiWrapper)) {
			return false;
		}

		kpiWrapper kpiWrapper = (kpiWrapper)obj;

		if (Objects.equals(_kpi, kpiWrapper._kpi)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _kpi.getStagedModelType();
	}

	@Override
	public kpi getWrappedModel() {
		return _kpi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _kpi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _kpi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_kpi.resetOriginalValues();
	}

	private final kpi _kpi;
}