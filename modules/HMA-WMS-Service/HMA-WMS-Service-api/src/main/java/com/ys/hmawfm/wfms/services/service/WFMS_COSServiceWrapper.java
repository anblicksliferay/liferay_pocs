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
 * Provides a wrapper for {@link WFMS_COSService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSService
 * @generated
 */
@ProviderType
public class WFMS_COSServiceWrapper implements WFMS_COSService,
	ServiceWrapper<WFMS_COSService> {
	public WFMS_COSServiceWrapper(WFMS_COSService wfms_cosService) {
		_wfms_cosService = wfms_cosService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_cosService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_COSService getWrappedService() {
		return _wfms_cosService;
	}

	@Override
	public void setWrappedService(WFMS_COSService wfms_cosService) {
		_wfms_cosService = wfms_cosService;
	}

	private WFMS_COSService _wfms_cosService;
}