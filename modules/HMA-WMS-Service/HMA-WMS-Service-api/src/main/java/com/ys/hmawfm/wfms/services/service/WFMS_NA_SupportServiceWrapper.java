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
 * Provides a wrapper for {@link WFMS_NA_SupportService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_SupportService
 * @generated
 */
@ProviderType
public class WFMS_NA_SupportServiceWrapper implements WFMS_NA_SupportService,
	ServiceWrapper<WFMS_NA_SupportService> {
	public WFMS_NA_SupportServiceWrapper(
		WFMS_NA_SupportService wfms_na_SupportService) {
		_wfms_na_SupportService = wfms_na_SupportService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_na_SupportService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_NA_SupportService getWrappedService() {
		return _wfms_na_SupportService;
	}

	@Override
	public void setWrappedService(WFMS_NA_SupportService wfms_na_SupportService) {
		_wfms_na_SupportService = wfms_na_SupportService;
	}

	private WFMS_NA_SupportService _wfms_na_SupportService;
}