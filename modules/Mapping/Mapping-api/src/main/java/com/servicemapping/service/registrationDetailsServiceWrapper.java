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

package com.servicemapping.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link registrationDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see registrationDetailsService
 * @generated
 */
@ProviderType
public class registrationDetailsServiceWrapper
	implements registrationDetailsService,
		ServiceWrapper<registrationDetailsService> {
	public registrationDetailsServiceWrapper(
		registrationDetailsService registrationDetailsService) {
		_registrationDetailsService = registrationDetailsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _registrationDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public registrationDetailsService getWrappedService() {
		return _registrationDetailsService;
	}

	@Override
	public void setWrappedService(
		registrationDetailsService registrationDetailsService) {
		_registrationDetailsService = registrationDetailsService;
	}

	private registrationDetailsService _registrationDetailsService;
}