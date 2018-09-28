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

package com.ys.hmawfm.wfms.services.service.impl;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_routing_and_approversException;

import com.ys.hmawfm.wfms.services.service.base.WFMS_routing_and_approversLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_routing_and_approvers local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_routing_and_approversLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil
 */
public class WFMS_routing_and_approversLocalServiceImpl
	extends WFMS_routing_and_approversLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil} to access the WFMS_routing_and_approvers local service.
	 */
	
	public com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers findByrouting(
			java.lang.String rapId)
			throws com.liferay.portal.kernel.exception.SystemException,
			NoSuchWFMS_routing_and_approversException {
			return wfms_routing_and_approversPersistence.findByrouting(rapId);
		}
}