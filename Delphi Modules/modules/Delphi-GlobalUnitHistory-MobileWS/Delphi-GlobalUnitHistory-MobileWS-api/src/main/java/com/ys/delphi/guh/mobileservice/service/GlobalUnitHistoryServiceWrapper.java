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

package com.ys.delphi.guh.mobileservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GlobalUnitHistoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see GlobalUnitHistoryService
 * @generated
 */
@ProviderType
public class GlobalUnitHistoryServiceWrapper implements GlobalUnitHistoryService,
	ServiceWrapper<GlobalUnitHistoryService> {
	public GlobalUnitHistoryServiceWrapper(
		GlobalUnitHistoryService globalUnitHistoryService) {
		_globalUnitHistoryService = globalUnitHistoryService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _globalUnitHistoryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String scannedBarCodeData(java.lang.String barCodeData) {
		return _globalUnitHistoryService.scannedBarCodeData(barCodeData);
	}

	@Override
	public GlobalUnitHistoryService getWrappedService() {
		return _globalUnitHistoryService;
	}

	@Override
	public void setWrappedService(
		GlobalUnitHistoryService globalUnitHistoryService) {
		_globalUnitHistoryService = globalUnitHistoryService;
	}

	private GlobalUnitHistoryService _globalUnitHistoryService;
}