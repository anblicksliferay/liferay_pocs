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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ddtii.service.http.categoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ddtii.service.http.categoryServiceSoap
 * @generated
 */
@ProviderType
public class categorySoap implements Serializable {
	public static categorySoap toSoapModel(category model) {
		categorySoap soapModel = new categorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static categorySoap[] toSoapModels(category[] models) {
		categorySoap[] soapModels = new categorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static categorySoap[][] toSoapModels(category[][] models) {
		categorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new categorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new categorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static categorySoap[] toSoapModels(List<category> models) {
		List<categorySoap> soapModels = new ArrayList<categorySoap>(models.size());

		for (category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new categorySoap[soapModels.size()]);
	}

	public categorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _categoryId;
	private String _categoryName;
	private long _courseId;
	private long _locationId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}