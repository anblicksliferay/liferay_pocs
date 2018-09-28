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

package com.ys.hmawfm.wfms.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WFMS_associate_skills_auditService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_auditService
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditServiceWrapper
	implements WFMS_associate_skills_auditService,
		ServiceWrapper<WFMS_associate_skills_auditService> {
	public WFMS_associate_skills_auditServiceWrapper(
		WFMS_associate_skills_auditService wfms_associate_skills_auditService) {
		_wfms_associate_skills_auditService = wfms_associate_skills_auditService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_associate_skills_auditService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_associate_skills_auditService getWrappedService() {
		return _wfms_associate_skills_auditService;
	}

	@Override
	public void setWrappedService(
		WFMS_associate_skills_auditService wfms_associate_skills_auditService) {
		_wfms_associate_skills_auditService = wfms_associate_skills_auditService;
	}

	private WFMS_associate_skills_auditService _wfms_associate_skills_auditService;
}