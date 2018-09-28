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

package ddtii.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the category service. Represents a row in the &quot;DDTII_category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ddtii.model.impl.categoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ddtii.model.impl.categoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see category
 * @see ddtii.model.impl.categoryImpl
 * @see ddtii.model.impl.categoryModelImpl
 * @generated
 */
@ProviderType
public interface categoryModel extends AuditedModel, BaseModel<category>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category model instance should use the {@link category} interface instead.
	 */

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the category name of this category.
	 *
	 * @return the category name of this category
	 */
	@AutoEscape
	public String getCategoryName();

	/**
	 * Sets the category name of this category.
	 *
	 * @param categoryName the category name of this category
	 */
	public void setCategoryName(String categoryName);

	/**
	 * Returns the course ID of this category.
	 *
	 * @return the course ID of this category
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this category.
	 *
	 * @param courseId the course ID of this category
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the location ID of this category.
	 *
	 * @return the location ID of this category
	 */
	public long getLocationId();

	/**
	 * Sets the location ID of this category.
	 *
	 * @param locationId the location ID of this category
	 */
	public void setLocationId(long locationId);

	/**
	 * Returns the company ID of this category.
	 *
	 * @return the company ID of this category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this category.
	 *
	 * @param companyId the company ID of this category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this category.
	 *
	 * @return the user ID of this category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this category.
	 *
	 * @param userId the user ID of this category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this category.
	 *
	 * @return the user uuid of this category
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this category.
	 *
	 * @param userUuid the user uuid of this category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this category.
	 *
	 * @return the user name of this category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this category.
	 *
	 * @param userName the user name of this category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this category.
	 *
	 * @return the create date of this category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this category.
	 *
	 * @param createDate the create date of this category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this category.
	 *
	 * @return the modified date of this category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this category.
	 *
	 * @param modifiedDate the modified date of this category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

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
	public int compareTo(ddtii.model.category category);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ddtii.model.category> toCacheModel();

	@Override
	public ddtii.model.category toEscapedModel();

	@Override
	public ddtii.model.category toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}