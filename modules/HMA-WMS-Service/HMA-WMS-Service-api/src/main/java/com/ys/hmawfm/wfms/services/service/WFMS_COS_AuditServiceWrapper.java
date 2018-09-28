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
 * Provides a wrapper for {@link WFMS_COS_AuditService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS_AuditService
 * @generated
 */
@ProviderType
public class WFMS_COS_AuditServiceWrapper implements WFMS_COS_AuditService,
	ServiceWrapper<WFMS_COS_AuditService> {
	public WFMS_COS_AuditServiceWrapper(
		WFMS_COS_AuditService wfms_cos_AuditService) {
		_wfms_cos_AuditService = wfms_cos_AuditService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_cos_AuditService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_COS_AuditService getWrappedService() {
		return _wfms_cos_AuditService;
	}

	@Override
	public void setWrappedService(WFMS_COS_AuditService wfms_cos_AuditService) {
		_wfms_cos_AuditService = wfms_cos_AuditService;
	}

	private WFMS_COS_AuditService _wfms_cos_AuditService;
}