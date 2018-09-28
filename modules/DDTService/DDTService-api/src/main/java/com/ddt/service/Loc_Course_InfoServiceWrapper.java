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

package com.ddt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Loc_Course_InfoService}.
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_InfoService
 * @generated
 */
@ProviderType
public class Loc_Course_InfoServiceWrapper implements Loc_Course_InfoService,
	ServiceWrapper<Loc_Course_InfoService> {
	public Loc_Course_InfoServiceWrapper(
		Loc_Course_InfoService loc_Course_InfoService) {
		_loc_Course_InfoService = loc_Course_InfoService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _loc_Course_InfoService.getOSGiServiceIdentifier();
	}

	@Override
	public Loc_Course_InfoService getWrappedService() {
		return _loc_Course_InfoService;
	}

	@Override
	public void setWrappedService(Loc_Course_InfoService loc_Course_InfoService) {
		_loc_Course_InfoService = loc_Course_InfoService;
	}

	private Loc_Course_InfoService _loc_Course_InfoService;
}