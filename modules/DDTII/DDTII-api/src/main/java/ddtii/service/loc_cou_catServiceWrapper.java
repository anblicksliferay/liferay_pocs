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

package ddtii.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link loc_cou_catService}.
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_catService
 * @generated
 */
@ProviderType
public class loc_cou_catServiceWrapper implements loc_cou_catService,
	ServiceWrapper<loc_cou_catService> {
	public loc_cou_catServiceWrapper(loc_cou_catService loc_cou_catService) {
		_loc_cou_catService = loc_cou_catService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _loc_cou_catService.getOSGiServiceIdentifier();
	}

	@Override
	public loc_cou_catService getWrappedService() {
		return _loc_cou_catService;
	}

	@Override
	public void setWrappedService(loc_cou_catService loc_cou_catService) {
		_loc_cou_catService = loc_cou_catService;
	}

	private loc_cou_catService _loc_cou_catService;
}