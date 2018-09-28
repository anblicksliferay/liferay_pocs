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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ys.hma.account.service.http.DataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hma.account.service.http.DataServiceSoap
 * @generated
 */
@ProviderType
public class DataSoap implements Serializable {
	public static DataSoap toSoapModel(Data model) {
		DataSoap soapModel = new DataSoap();

		soapModel.setDataId(model.getDataId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setExported(model.getExported());
		soapModel.setNotExported(model.getNotExported());

		return soapModel;
	}

	public static DataSoap[] toSoapModels(Data[] models) {
		DataSoap[] soapModels = new DataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataSoap[][] toSoapModels(Data[][] models) {
		DataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataSoap[] toSoapModels(List<Data> models) {
		List<DataSoap> soapModels = new ArrayList<DataSoap>(models.size());

		for (Data model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataSoap[soapModels.size()]);
	}

	public DataSoap() {
	}

	public long getPrimaryKey() {
		return _DataId;
	}

	public void setPrimaryKey(long pk) {
		setDataId(pk);
	}

	public long getDataId() {
		return _DataId;
	}

	public void setDataId(long DataId) {
		_DataId = DataId;
	}

	public Date getStartDate() {
		return _StartDate;
	}

	public void setStartDate(Date StartDate) {
		_StartDate = StartDate;
	}

	public Date getEndDate() {
		return _EndDate;
	}

	public void setEndDate(Date EndDate) {
		_EndDate = EndDate;
	}

	public int getExported() {
		return _Exported;
	}

	public void setExported(int Exported) {
		_Exported = Exported;
	}

	public int getNotExported() {
		return _NotExported;
	}

	public void setNotExported(int NotExported) {
		_NotExported = NotExported;
	}

	private long _DataId;
	private Date _StartDate;
	private Date _EndDate;
	private int _Exported;
	private int _NotExported;
}