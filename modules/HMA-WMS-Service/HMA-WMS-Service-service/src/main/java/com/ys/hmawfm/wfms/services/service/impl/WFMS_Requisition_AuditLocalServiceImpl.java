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

import com.ys.hmawfm.wfms.services.service.base.WFMS_Requisition_AuditLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_Requisition_Audit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_AuditLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalServiceUtil
 */
public class WFMS_Requisition_AuditLocalServiceImpl
	extends WFMS_Requisition_AuditLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalServiceUtil} to access the WFMS_Requisition_Audit local service.
	 */
	
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit> findByReqIdForAudit(
			java.lang.String reqId)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_Requisition_AuditPersistence.findByReqIdForAudit(reqId);
		}
}