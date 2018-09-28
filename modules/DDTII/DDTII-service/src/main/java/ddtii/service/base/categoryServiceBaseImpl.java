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

package ddtii.service.base;

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

import ddtii.model.category;

import ddtii.service.categoryService;

import ddtii.service.persistence.categoryPersistence;
import ddtii.service.persistence.coursePersistence;
import ddtii.service.persistence.loc_cou_catPersistence;
import ddtii.service.persistence.locationPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the category remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ddtii.service.impl.categoryServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ddtii.service.impl.categoryServiceImpl
 * @see ddtii.service.categoryServiceUtil
 * @generated
 */
public abstract class categoryServiceBaseImpl extends BaseServiceImpl
	implements categoryService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ddtii.service.categoryServiceUtil} to access the category remote service.
	 */

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public ddtii.service.categoryLocalService getcategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setcategoryLocalService(
		ddtii.service.categoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category remote service.
	 *
	 * @return the category remote service
	 */
	public categoryService getcategoryService() {
		return categoryService;
	}

	/**
	 * Sets the category remote service.
	 *
	 * @param categoryService the category remote service
	 */
	public void setcategoryService(categoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public categoryPersistence getcategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setcategoryPersistence(categoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the course local service.
	 *
	 * @return the course local service
	 */
	public ddtii.service.courseLocalService getcourseLocalService() {
		return courseLocalService;
	}

	/**
	 * Sets the course local service.
	 *
	 * @param courseLocalService the course local service
	 */
	public void setcourseLocalService(
		ddtii.service.courseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	/**
	 * Returns the course remote service.
	 *
	 * @return the course remote service
	 */
	public ddtii.service.courseService getcourseService() {
		return courseService;
	}

	/**
	 * Sets the course remote service.
	 *
	 * @param courseService the course remote service
	 */
	public void setcourseService(ddtii.service.courseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * Returns the course persistence.
	 *
	 * @return the course persistence
	 */
	public coursePersistence getcoursePersistence() {
		return coursePersistence;
	}

	/**
	 * Sets the course persistence.
	 *
	 * @param coursePersistence the course persistence
	 */
	public void setcoursePersistence(coursePersistence coursePersistence) {
		this.coursePersistence = coursePersistence;
	}

	/**
	 * Returns the loc_cou_cat local service.
	 *
	 * @return the loc_cou_cat local service
	 */
	public ddtii.service.loc_cou_catLocalService getloc_cou_catLocalService() {
		return loc_cou_catLocalService;
	}

	/**
	 * Sets the loc_cou_cat local service.
	 *
	 * @param loc_cou_catLocalService the loc_cou_cat local service
	 */
	public void setloc_cou_catLocalService(
		ddtii.service.loc_cou_catLocalService loc_cou_catLocalService) {
		this.loc_cou_catLocalService = loc_cou_catLocalService;
	}

	/**
	 * Returns the loc_cou_cat remote service.
	 *
	 * @return the loc_cou_cat remote service
	 */
	public ddtii.service.loc_cou_catService getloc_cou_catService() {
		return loc_cou_catService;
	}

	/**
	 * Sets the loc_cou_cat remote service.
	 *
	 * @param loc_cou_catService the loc_cou_cat remote service
	 */
	public void setloc_cou_catService(
		ddtii.service.loc_cou_catService loc_cou_catService) {
		this.loc_cou_catService = loc_cou_catService;
	}

	/**
	 * Returns the loc_cou_cat persistence.
	 *
	 * @return the loc_cou_cat persistence
	 */
	public loc_cou_catPersistence getloc_cou_catPersistence() {
		return loc_cou_catPersistence;
	}

	/**
	 * Sets the loc_cou_cat persistence.
	 *
	 * @param loc_cou_catPersistence the loc_cou_cat persistence
	 */
	public void setloc_cou_catPersistence(
		loc_cou_catPersistence loc_cou_catPersistence) {
		this.loc_cou_catPersistence = loc_cou_catPersistence;
	}

	/**
	 * Returns the location local service.
	 *
	 * @return the location local service
	 */
	public ddtii.service.locationLocalService getlocationLocalService() {
		return locationLocalService;
	}

	/**
	 * Sets the location local service.
	 *
	 * @param locationLocalService the location local service
	 */
	public void setlocationLocalService(
		ddtii.service.locationLocalService locationLocalService) {
		this.locationLocalService = locationLocalService;
	}

	/**
	 * Returns the location remote service.
	 *
	 * @return the location remote service
	 */
	public ddtii.service.locationService getlocationService() {
		return locationService;
	}

	/**
	 * Sets the location remote service.
	 *
	 * @param locationService the location remote service
	 */
	public void setlocationService(
		ddtii.service.locationService locationService) {
		this.locationService = locationService;
	}

	/**
	 * Returns the location persistence.
	 *
	 * @return the location persistence
	 */
	public locationPersistence getlocationPersistence() {
		return locationPersistence;
	}

	/**
	 * Sets the location persistence.
	 *
	 * @param locationPersistence the location persistence
	 */
	public void setlocationPersistence(locationPersistence locationPersistence) {
		this.locationPersistence = locationPersistence;
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
		return categoryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return category.class;
	}

	protected String getModelClassName() {
		return category.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = categoryPersistence.getDataSource();

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

	@BeanReference(type = ddtii.service.categoryLocalService.class)
	protected ddtii.service.categoryLocalService categoryLocalService;
	@BeanReference(type = categoryService.class)
	protected categoryService categoryService;
	@BeanReference(type = categoryPersistence.class)
	protected categoryPersistence categoryPersistence;
	@BeanReference(type = ddtii.service.courseLocalService.class)
	protected ddtii.service.courseLocalService courseLocalService;
	@BeanReference(type = ddtii.service.courseService.class)
	protected ddtii.service.courseService courseService;
	@BeanReference(type = coursePersistence.class)
	protected coursePersistence coursePersistence;
	@BeanReference(type = ddtii.service.loc_cou_catLocalService.class)
	protected ddtii.service.loc_cou_catLocalService loc_cou_catLocalService;
	@BeanReference(type = ddtii.service.loc_cou_catService.class)
	protected ddtii.service.loc_cou_catService loc_cou_catService;
	@BeanReference(type = loc_cou_catPersistence.class)
	protected loc_cou_catPersistence loc_cou_catPersistence;
	@BeanReference(type = ddtii.service.locationLocalService.class)
	protected ddtii.service.locationLocalService locationLocalService;
	@BeanReference(type = ddtii.service.locationService.class)
	protected ddtii.service.locationService locationService;
	@BeanReference(type = locationPersistence.class)
	protected locationPersistence locationPersistence;
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