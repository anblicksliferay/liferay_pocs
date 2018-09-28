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

import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_ConfigException;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;
import com.ys.hmawfm.wfms.services.service.base.WFMS_ConfigLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_Configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_ConfigLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil
 */
public class WFMS_ConfigLocalServiceImpl extends WFMS_ConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil} to access the WFMS_Configuration local service.
	 */
	
public List<WFMS_Config> getAll() throws SystemException {
		
		return wfms_ConfigPersistence.findAll();
	}
	
	public WFMS_Config getByConfigId(long configId) throws SystemException {
		
		WFMS_Config configObj = null;
		try {
			configObj = wfms_ConfigPersistence.findByPrimaryKey(configId);
		} catch (NoSuchWFMS_ConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return configObj;
	}
	
	public WFMS_Config getByConfigKey(String configKey) throws SystemException {
		
		WFMS_Config configObj = null;
		try {
			configObj = wfms_ConfigPersistence.findByConfigKey(configKey);
		} catch (NoSuchWFMS_ConfigException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to find WFMS_Config with the configKey '"+configKey+"'");
			e.printStackTrace();
		}
		
		return configObj;
	}
	
	public WFMS_Config addNewConfig(String createdBy, String configKey, String configLabel, String contentType, String content) throws SystemException {
		
		WFMS_Config entry = wfms_ConfigPersistence.create(counterLocalService.increment(WFMS_Config.class.getName()));
		
		entry.setCreatedBy(createdBy);
		entry.setCreateDate(new java.util.Date());
		entry.setModifiedBy(createdBy);
		entry.setModifiedDate(new java.util.Date());
		entry.setConfigKey(configKey);
		entry.setConfigLabel(configLabel);
		entry.setContentType(contentType);
		entry.setContent(content);

		return wfms_ConfigPersistence.update(entry);
	}
	

	public WFMS_Config updateConfig(long configId, String modifiedBy, String configKey, String configLabel, String contentType, String content) throws SystemException {
	
		WFMS_Config entry = wfms_ConfigPersistence.fetchByPrimaryKey(configId);

		entry.setModifiedBy(modifiedBy);
		entry.setModifiedDate(new java.util.Date());
		entry.setConfigKey(configKey);
		entry.setConfigLabel(configLabel);
		entry.setContentType(contentType);
		entry.setContent(content);

		return wfms_ConfigPersistence.update(entry);
	}
	
	public WFMS_Config deleteConfig(long configId) throws SystemException, NoSuchWFMS_ConfigException {

		return wfms_ConfigPersistence.remove(configId);
	}
}