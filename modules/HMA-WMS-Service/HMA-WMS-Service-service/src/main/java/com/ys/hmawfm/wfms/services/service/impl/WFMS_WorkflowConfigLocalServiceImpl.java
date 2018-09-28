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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_WorkflowConfigException;
import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;
import com.ys.hmawfm.wfms.services.service.base.WFMS_WorkflowConfigLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_WorkflowConfig local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfigLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalServiceUtil
 */
public class WFMS_WorkflowConfigLocalServiceImpl
	extends WFMS_WorkflowConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalServiceUtil} to access the WFMS_WorkflowConfig local service.
	 */
	
public List<WFMS_WorkflowConfig> getAll() throws SystemException {
		
		return wfms_WorkflowConfigPersistence.findAll();
	}
	
	public WFMS_WorkflowConfig getByConfigId(long configId) throws SystemException {
		
		WFMS_WorkflowConfig configObj = null;
		try {
			configObj = wfms_WorkflowConfigPersistence.findByPrimaryKey(configId);
		} catch (NoSuchWFMS_WorkflowConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return configObj;
	}
	
	public WFMS_WorkflowConfig getByConfigKey(String configKey) throws SystemException {
		
		WFMS_WorkflowConfig configObj = null;
		try {
			configObj = wfms_WorkflowConfigPersistence.findByConfigKey(configKey);
		} catch (NoSuchWFMS_WorkflowConfigException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to find WFMS_WorkflowConfig with the configKey '"+configKey+"'");
			e.printStackTrace();
		}
		
		return configObj;
	}
	
	public WFMS_WorkflowConfig addNewConfig(String createdBy, String configKey, String configLabel, String contentType, String content) throws SystemException {
		
		WFMS_WorkflowConfig entry = wfms_WorkflowConfigPersistence.create(counterLocalService.increment(WFMS_WorkflowConfig.class.getName()));
		
		entry.setCreatedBy(createdBy);
		entry.setCreateDate(new java.util.Date());
		entry.setModifiedBy(createdBy);
		entry.setModifiedDate(new java.util.Date());
		entry.setConfigKey(configKey);
		entry.setConfigLabel(configLabel);
		entry.setContentType(contentType);
		entry.setContent(content);

		return wfms_WorkflowConfigPersistence.update(entry);
	}
	

	public WFMS_WorkflowConfig updateConfig(long configId, String modifiedBy, String configKey, String configLabel, String contentType, String content) throws SystemException {
	
		WFMS_WorkflowConfig entry = wfms_WorkflowConfigPersistence.fetchByPrimaryKey(configId);

		entry.setModifiedBy(modifiedBy);
		entry.setModifiedDate(new java.util.Date());
		entry.setConfigKey(configKey);
		entry.setConfigLabel(configLabel);
		entry.setContentType(contentType);
		entry.setContent(content);

		return wfms_WorkflowConfigPersistence.update(entry);
	}
	
	public WFMS_WorkflowConfig deleteConfig(long configId) throws SystemException, NoSuchWFMS_WorkflowConfigException {

		return wfms_WorkflowConfigPersistence.remove(configId);
	}
}