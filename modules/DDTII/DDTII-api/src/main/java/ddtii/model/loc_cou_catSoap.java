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
 * This class is used by SOAP remote services, specifically {@link ddtii.service.http.loc_cou_catServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ddtii.service.http.loc_cou_catServiceSoap
 * @generated
 */
@ProviderType
public class loc_cou_catSoap implements Serializable {
	public static loc_cou_catSoap toSoapModel(loc_cou_cat model) {
		loc_cou_catSoap soapModel = new loc_cou_catSoap();

		soapModel.setLoc_cou_catId(model.getLoc_cou_catId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setDurationString(model.getDurationString());
		soapModel.setDurationLong(model.getDurationLong());
		soapModel.setStartDate_(model.getStartDate_());
		soapModel.setEndDate_(model.getEndDate_());
		soapModel.setMaxSeats(model.getMaxSeats());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static loc_cou_catSoap[] toSoapModels(loc_cou_cat[] models) {
		loc_cou_catSoap[] soapModels = new loc_cou_catSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static loc_cou_catSoap[][] toSoapModels(loc_cou_cat[][] models) {
		loc_cou_catSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new loc_cou_catSoap[models.length][models[0].length];
		}
		else {
			soapModels = new loc_cou_catSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static loc_cou_catSoap[] toSoapModels(List<loc_cou_cat> models) {
		List<loc_cou_catSoap> soapModels = new ArrayList<loc_cou_catSoap>(models.size());

		for (loc_cou_cat model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new loc_cou_catSoap[soapModels.size()]);
	}

	public loc_cou_catSoap() {
	}

	public long getPrimaryKey() {
		return _loc_cou_catId;
	}

	public void setPrimaryKey(long pk) {
		setLoc_cou_catId(pk);
	}

	public long getLoc_cou_catId() {
		return _loc_cou_catId;
	}

	public void setLoc_cou_catId(long loc_cou_catId) {
		_loc_cou_catId = loc_cou_catId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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

	public String getDurationString() {
		return _durationString;
	}

	public void setDurationString(String durationString) {
		_durationString = durationString;
	}

	public long getDurationLong() {
		return _durationLong;
	}

	public void setDurationLong(long durationLong) {
		_durationLong = durationLong;
	}

	public Date getStartDate_() {
		return _startDate_;
	}

	public void setStartDate_(Date startDate_) {
		_startDate_ = startDate_;
	}

	public Date getEndDate_() {
		return _endDate_;
	}

	public void setEndDate_(Date endDate_) {
		_endDate_ = endDate_;
	}

	public long getMaxSeats() {
		return _maxSeats;
	}

	public void setMaxSeats(long maxSeats) {
		_maxSeats = maxSeats;
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

	private long _loc_cou_catId;
	private long _categoryId;
	private long _courseId;
	private long _locationId;
	private String _durationString;
	private long _durationLong;
	private Date _startDate_;
	private Date _endDate_;
	private long _maxSeats;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}