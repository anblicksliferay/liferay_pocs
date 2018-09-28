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

import java.util.List;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException;
import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.model.WFMS_NotificationEngine;
import com.ys.hmawfm.wfms.services.service.base.WFMS_NotificationEngineLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_NotificationEngine local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_NotificationEngineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NotificationEngineLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_NotificationEngineLocalServiceUtil
 */
public class WFMS_NotificationEngineLocalServiceImpl
	extends WFMS_NotificationEngineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_NotificationEngineLocalServiceUtil} to access the WFMS_NotificationEngine local service.
	 */
	
	public WFMS_NotificationEngine addNewNotifications(long companyId, long scopeGroupId, String createdBy, String content, String contentType, String comments, String title, int timesUsed) throws SystemException {

		WFMS_NotificationEngine entry = wfms_NotificationEnginePersistence.create(counterLocalService.increment(WFMS_NotificationEngine.class.getName()));

		entry.setCompanyId(companyId);
		entry.setScopeGroupId(scopeGroupId);
		entry.setCreatedBy(createdBy);
		entry.setCreateDate(new java.util.Date());
		entry.setTitle(title);
		entry.setContent(content);
		entry.setContentType(contentType);
		entry.setComments(comments);
		entry.setTimesUsed(timesUsed);
		
		return wfms_NotificationEnginePersistence.update(entry);
	}
	
	public WFMS_NotificationEngine updateNotifications(long templateId, String modifiedBy, String content, String contentType, String comments, String title, int timesUsed) throws SystemException {

		WFMS_NotificationEngine entry = wfms_NotificationEnginePersistence.fetchByPrimaryKey(templateId);

		entry.setModifiedBy(modifiedBy);
		entry.setModifiedDate(new java.util.Date());
		entry.setTitle(title);
		entry.setContent(content);
		entry.setContentType(contentType);
		entry.setComments(comments);
		entry.setTimesUsed(timesUsed);
		
		return wfms_NotificationEnginePersistence.update(entry);
	}
	
	public List<WFMS_NotificationEngine> getAll() throws SystemException {
		
		return wfms_NotificationEnginePersistence.findAll();
	}
	
	public WFMS_NotificationEngine getByNotificationId(long notificationId) throws SystemException {
		
		WFMS_NotificationEngine notificationObj = null;
		try {
			notificationObj = wfms_NotificationEnginePersistence.findByPrimaryKey(notificationId);
		} catch (NoSuchWFMS_NotificationEngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notificationObj;
	}
}