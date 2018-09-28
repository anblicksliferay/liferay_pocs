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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the WFMS_associate_skills service. Represents a row in the &quot;WFMS_associate_skills&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsModelImpl
 * @generated
 */
@ProviderType
public interface WFMS_associate_skillsModel extends BaseModel<WFMS_associate_skills> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a WFMS_associate_skills model instance should use the {@link WFMS_associate_skills} interface instead.
	 */

	/**
	 * Returns the primary key of this WFMS_associate_skills.
	 *
	 * @return the primary key of this WFMS_associate_skills
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this WFMS_associate_skills.
	 *
	 * @param primaryKey the primary key of this WFMS_associate_skills
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the associate_number of this WFMS_associate_skills.
	 *
	 * @return the associate_number of this WFMS_associate_skills
	 */
	@AutoEscape
	public String getAssociate_number();

	/**
	 * Sets the associate_number of this WFMS_associate_skills.
	 *
	 * @param associate_number the associate_number of this WFMS_associate_skills
	 */
	public void setAssociate_number(String associate_number);

	/**
	 * Returns the skills of this WFMS_associate_skills.
	 *
	 * @return the skills of this WFMS_associate_skills
	 */
	@AutoEscape
	public String getSkills();

	/**
	 * Sets the skills of this WFMS_associate_skills.
	 *
	 * @param skills the skills of this WFMS_associate_skills
	 */
	public void setSkills(String skills);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(WFMS_associate_skills wfms_associate_skills);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WFMS_associate_skills> toCacheModel();

	@Override
	public WFMS_associate_skills toEscapedModel();

	@Override
	public WFMS_associate_skills toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}