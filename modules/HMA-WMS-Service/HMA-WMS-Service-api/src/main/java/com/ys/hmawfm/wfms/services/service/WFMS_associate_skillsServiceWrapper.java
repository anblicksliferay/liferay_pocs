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
 * Provides a wrapper for {@link WFMS_associate_skillsService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skillsService
 * @generated
 */
@ProviderType
public class WFMS_associate_skillsServiceWrapper
	implements WFMS_associate_skillsService,
		ServiceWrapper<WFMS_associate_skillsService> {
	public WFMS_associate_skillsServiceWrapper(
		WFMS_associate_skillsService wfms_associate_skillsService) {
		_wfms_associate_skillsService = wfms_associate_skillsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_associate_skillsService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_associate_skillsService getWrappedService() {
		return _wfms_associate_skillsService;
	}

	@Override
	public void setWrappedService(
		WFMS_associate_skillsService wfms_associate_skillsService) {
		_wfms_associate_skillsService = wfms_associate_skillsService;
	}

	private WFMS_associate_skillsService _wfms_associate_skillsService;
}