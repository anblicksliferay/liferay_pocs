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

package com.ddt.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ddt.service.http.FAQSAshokServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ddt.service.http.FAQSAshokServiceSoap
 * @generated
 */
@ProviderType
public class FAQSAshokSoap implements Serializable {
	public static FAQSAshokSoap toSoapModel(FAQSAshok model) {
		FAQSAshokSoap soapModel = new FAQSAshokSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setFAQSContent(model.getFAQSContent());

		return soapModel;
	}

	public static FAQSAshokSoap[] toSoapModels(FAQSAshok[] models) {
		FAQSAshokSoap[] soapModels = new FAQSAshokSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQSAshokSoap[][] toSoapModels(FAQSAshok[][] models) {
		FAQSAshokSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQSAshokSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQSAshokSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQSAshokSoap[] toSoapModels(List<FAQSAshok> models) {
		List<FAQSAshokSoap> soapModels = new ArrayList<FAQSAshokSoap>(models.size());

		for (FAQSAshok model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQSAshokSoap[soapModels.size()]);
	}

	public FAQSAshokSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getFAQSContent() {
		return _FAQSContent;
	}

	public void setFAQSContent(String FAQSContent) {
		_FAQSContent = FAQSContent;
	}

	private String _uuid;
	private long _id;
	private String _FAQSContent;
}