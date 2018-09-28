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

package com.astra.workflowservice.service.base;

import com.astra.workflowservice.model.WorkFlowConfig;
import com.astra.workflowservice.service.WorkFlowConfigService;
import com.astra.workflowservice.service.persistence.RegistrationPersistence;
import com.astra.workflowservice.service.persistence.WorkFlowConfigPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the work flow config remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.astra.workflowservice.service.impl.WorkFlowConfigServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.workflowservice.service.impl.WorkFlowConfigServiceImpl
 * @see com.astra.workflowservice.service.WorkFlowConfigServiceUtil
 * @generated
 */
public abstract class WorkFlowConfigServiceBaseImpl extends BaseServiceImpl
	implements WorkFlowConfigService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.astra.workflowservice.service.WorkFlowConfigServiceUtil} to access the work flow config remote service.
	 */

	/**
	 * Returns the registration local service.
	 *
	 * @return the registration local service
	 */
	public com.astra.workflowservice.service.RegistrationLocalService getRegistrationLocalService() {
		return registrationLocalService;
	}

	/**
	 * Sets the registration local service.
	 *
	 * @param registrationLocalService the registration local service
	 */
	public void setRegistrationLocalService(
		com.astra.workflowservice.service.RegistrationLocalService registrationLocalService) {
		this.registrationLocalService = registrationLocalService;
	}

	/**
	 * Returns the registration remote service.
	 *
	 * @return the registration remote service
	 */
	public com.astra.workflowservice.service.RegistrationService getRegistrationService() {
		return registrationService;
	}

	/**
	 * Sets the registration remote service.
	 *
	 * @param registrationService the registration remote service
	 */
	public void setRegistrationService(
		com.astra.workflowservice.service.RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	/**
	 * Returns the registration persistence.
	 *
	 * @return the registration persistence
	 */
	public RegistrationPersistence getRegistrationPersistence() {
		return registrationPersistence;
	}

	/**
	 * Sets the registration persistence.
	 *
	 * @param registrationPersistence the registration persistence
	 */
	public void setRegistrationPersistence(
		RegistrationPersistence registrationPersistence) {
		this.registrationPersistence = registrationPersistence;
	}

	/**
	 * Returns the work flow config local service.
	 *
	 * @return the work flow config local service
	 */
	public com.astra.workflowservice.service.WorkFlowConfigLocalService getWorkFlowConfigLocalService() {
		return workFlowConfigLocalService;
	}

	/**
	 * Sets the work flow config local service.
	 *
	 * @param workFlowConfigLocalService the work flow config local service
	 */
	public void setWorkFlowConfigLocalService(
		com.astra.workflowservice.service.WorkFlowConfigLocalService workFlowConfigLocalService) {
		this.workFlowConfigLocalService = workFlowConfigLocalService;
	}

	/**
	 * Returns the work flow config remote service.
	 *
	 * @return the work flow config remote service
	 */
	public WorkFlowConfigService getWorkFlowConfigService() {
		return workFlowConfigService;
	}

	/**
	 * Sets the work flow config remote service.
	 *
	 * @param workFlowConfigService the work flow config remote service
	 */
	public void setWorkFlowConfigService(
		WorkFlowConfigService workFlowConfigService) {
		this.workFlowConfigService = workFlowConfigService;
	}

	/**
	 * Returns the work flow config persistence.
	 *
	 * @return the work flow config persistence
	 */
	public WorkFlowConfigPersistence getWorkFlowConfigPersistence() {
		return workFlowConfigPersistence;
	}

	/**
	 * Sets the work flow config persistence.
	 *
	 * @param workFlowConfigPersistence the work flow config persistence
	 */
	public void setWorkFlowConfigPersistence(
		WorkFlowConfigPersistence workFlowConfigPersistence) {
		this.workFlowConfigPersistence = workFlowConfigPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return WorkFlowConfigService.class.getName();
	}

	protected Class<?> getModelClass() {
		return WorkFlowConfig.class;
	}

	protected String getModelClassName() {
		return WorkFlowConfig.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = workFlowConfigPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.astra.workflowservice.service.RegistrationLocalService.class)
	protected com.astra.workflowservice.service.RegistrationLocalService registrationLocalService;
	@BeanReference(type = com.astra.workflowservice.service.RegistrationService.class)
	protected com.astra.workflowservice.service.RegistrationService registrationService;
	@BeanReference(type = RegistrationPersistence.class)
	protected RegistrationPersistence registrationPersistence;
	@BeanReference(type = com.astra.workflowservice.service.WorkFlowConfigLocalService.class)
	protected com.astra.workflowservice.service.WorkFlowConfigLocalService workFlowConfigLocalService;
	@BeanReference(type = WorkFlowConfigService.class)
	protected WorkFlowConfigService workFlowConfigService;
	@BeanReference(type = WorkFlowConfigPersistence.class)
	protected WorkFlowConfigPersistence workFlowConfigPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}