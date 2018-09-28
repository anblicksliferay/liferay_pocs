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
 * Provides a wrapper for {@link FAQSAshokService}.
 *
 * @author Brian Wing Shun Chan
 * @see FAQSAshokService
 * @generated
 */
@ProviderType
public class FAQSAshokServiceWrapper implements FAQSAshokService,
	ServiceWrapper<FAQSAshokService> {
	public FAQSAshokServiceWrapper(FAQSAshokService faqsAshokService) {
		_faqsAshokService = faqsAshokService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _faqsAshokService.getOSGiServiceIdentifier();
	}

	@Override
	public FAQSAshokService getWrappedService() {
		return _faqsAshokService;
	}

	@Override
	public void setWrappedService(FAQSAshokService faqsAshokService) {
		_faqsAshokService = faqsAshokService;
	}

	private FAQSAshokService _faqsAshokService;
}