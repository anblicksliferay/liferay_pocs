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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ys.hmawfm.wfms.services.service.http.WFMS_associate_skillsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.http.WFMS_associate_skillsServiceSoap
 * @generated
 */
@ProviderType
public class WFMS_associate_skillsSoap implements Serializable {
	public static WFMS_associate_skillsSoap toSoapModel(
		WFMS_associate_skills model) {
		WFMS_associate_skillsSoap soapModel = new WFMS_associate_skillsSoap();

		soapModel.setAssociate_number(model.getAssociate_number());
		soapModel.setSkills(model.getSkills());

		return soapModel;
	}

	public static WFMS_associate_skillsSoap[] toSoapModels(
		WFMS_associate_skills[] models) {
		WFMS_associate_skillsSoap[] soapModels = new WFMS_associate_skillsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WFMS_associate_skillsSoap[][] toSoapModels(
		WFMS_associate_skills[][] models) {
		WFMS_associate_skillsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WFMS_associate_skillsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WFMS_associate_skillsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WFMS_associate_skillsSoap[] toSoapModels(
		List<WFMS_associate_skills> models) {
		List<WFMS_associate_skillsSoap> soapModels = new ArrayList<WFMS_associate_skillsSoap>(models.size());

		for (WFMS_associate_skills model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WFMS_associate_skillsSoap[soapModels.size()]);
	}

	public WFMS_associate_skillsSoap() {
	}

	public String getPrimaryKey() {
		return _associate_number;
	}

	public void setPrimaryKey(String pk) {
		setAssociate_number(pk);
	}

	public String getAssociate_number() {
		return _associate_number;
	}

	public void setAssociate_number(String associate_number) {
		_associate_number = associate_number;
	}

	public String getSkills() {
		return _skills;
	}

	public void setSkills(String skills) {
		_skills = skills;
	}

	private String _associate_number;
	private String _skills;
}