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

import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NA_SupportException;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.service.base.WFMS_NA_SupportLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_NA_Support local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NA_SupportLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil
 */
public class WFMS_NA_SupportLocalServiceImpl
	extends WFMS_NA_SupportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil} to access the WFMS_NA_Support local service.
	 */
	
public WFMS_NA_Support addNewEmptyassociate() throws SystemException {
		
	    WFMS_NA_Support entry = wfms_na_SupportPersistence.create("TMP-"+counterLocalService.increment(WFMS_NA_Support.class.getName()));

			return wfms_na_SupportPersistence.update(entry);
		}

	public WFMS_NA_Support updateassociatedata(WFMS_NA_Support entry)
			throws SystemException {
		
		return wfms_na_SupportPersistence.update(entry);
	}

	public com.ys.hmawfm.wfms.services.model.WFMS_NA_Support findBynaSupport(
			java.lang.String ASSOCIATE_NUMBER)
			throws com.liferay.portal.kernel.exception.SystemException,
			NoSuchWFMS_NA_SupportException {
			return wfms_na_SupportPersistence.findBynaSupport(ASSOCIATE_NUMBER);
		}
}