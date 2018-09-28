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

package com.externalservices.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link leykartEnquiryService}.
 *
 * @author Brian Wing Shun Chan
 * @see leykartEnquiryService
 * @generated
 */
@ProviderType
public class leykartEnquiryServiceWrapper implements leykartEnquiryService,
	ServiceWrapper<leykartEnquiryService> {
	public leykartEnquiryServiceWrapper(
		leykartEnquiryService leykartEnquiryService) {
		_leykartEnquiryService = leykartEnquiryService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _leykartEnquiryService.getOSGiServiceIdentifier();
	}

	@Override
	public leykartEnquiryService getWrappedService() {
		return _leykartEnquiryService;
	}

	@Override
	public void setWrappedService(leykartEnquiryService leykartEnquiryService) {
		_leykartEnquiryService = leykartEnquiryService;
	}

	private leykartEnquiryService _leykartEnquiryService;
}