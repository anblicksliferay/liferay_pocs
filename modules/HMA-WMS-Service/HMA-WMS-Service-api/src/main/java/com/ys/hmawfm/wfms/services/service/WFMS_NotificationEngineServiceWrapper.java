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
 * Provides a wrapper for {@link WFMS_NotificationEngineService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NotificationEngineService
 * @generated
 */
@ProviderType
public class WFMS_NotificationEngineServiceWrapper
	implements WFMS_NotificationEngineService,
		ServiceWrapper<WFMS_NotificationEngineService> {
	public WFMS_NotificationEngineServiceWrapper(
		WFMS_NotificationEngineService wfms_NotificationEngineService) {
		_wfms_NotificationEngineService = wfms_NotificationEngineService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_NotificationEngineService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_NotificationEngineService getWrappedService() {
		return _wfms_NotificationEngineService;
	}

	@Override
	public void setWrappedService(
		WFMS_NotificationEngineService wfms_NotificationEngineService) {
		_wfms_NotificationEngineService = wfms_NotificationEngineService;
	}

	private WFMS_NotificationEngineService _wfms_NotificationEngineService;
}