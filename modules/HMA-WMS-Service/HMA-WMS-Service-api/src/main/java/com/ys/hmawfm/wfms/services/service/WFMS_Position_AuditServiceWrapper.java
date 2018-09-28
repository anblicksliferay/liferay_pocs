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
 * Provides a wrapper for {@link WFMS_Position_AuditService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position_AuditService
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditServiceWrapper
	implements WFMS_Position_AuditService,
		ServiceWrapper<WFMS_Position_AuditService> {
	public WFMS_Position_AuditServiceWrapper(
		WFMS_Position_AuditService wfms_Position_AuditService) {
		_wfms_Position_AuditService = wfms_Position_AuditService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_Position_AuditService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_Position_AuditService getWrappedService() {
		return _wfms_Position_AuditService;
	}

	@Override
	public void setWrappedService(
		WFMS_Position_AuditService wfms_Position_AuditService) {
		_wfms_Position_AuditService = wfms_Position_AuditService;
	}

	private WFMS_Position_AuditService _wfms_Position_AuditService;
}