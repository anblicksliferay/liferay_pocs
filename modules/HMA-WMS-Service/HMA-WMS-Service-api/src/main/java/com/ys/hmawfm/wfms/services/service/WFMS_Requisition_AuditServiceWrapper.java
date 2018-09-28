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
 * Provides a wrapper for {@link WFMS_Requisition_AuditService}.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_AuditService
 * @generated
 */
@ProviderType
public class WFMS_Requisition_AuditServiceWrapper
	implements WFMS_Requisition_AuditService,
		ServiceWrapper<WFMS_Requisition_AuditService> {
	public WFMS_Requisition_AuditServiceWrapper(
		WFMS_Requisition_AuditService wfms_Requisition_AuditService) {
		_wfms_Requisition_AuditService = wfms_Requisition_AuditService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wfms_Requisition_AuditService.getOSGiServiceIdentifier();
	}

	@Override
	public WFMS_Requisition_AuditService getWrappedService() {
		return _wfms_Requisition_AuditService;
	}

	@Override
	public void setWrappedService(
		WFMS_Requisition_AuditService wfms_Requisition_AuditService) {
		_wfms_Requisition_AuditService = wfms_Requisition_AuditService;
	}

	private WFMS_Requisition_AuditService _wfms_Requisition_AuditService;
}