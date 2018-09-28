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

package com.ys.hmawfm.wfms.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ys.hmawfm.wfms.services.model.WFMS_NotificationEngine;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_NotificationEngine service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_NotificationEnginePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_NotificationEnginePersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_NotificationEnginePersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_NotificationEngineUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		getPersistence().clearCache(wfms_NotificationEngine);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WFMS_NotificationEngine> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_NotificationEngine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_NotificationEngine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_NotificationEngine update(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		return getPersistence().update(wfms_NotificationEngine);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_NotificationEngine update(
		WFMS_NotificationEngine wfms_NotificationEngine,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_NotificationEngine, serviceContext);
	}

	/**
	* Returns all the WFMS_NotificationEngines where title = &#63;.
	*
	* @param title the title
	* @return the matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the WFMS_NotificationEngines where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @return the range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title, int start, int end) {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTitle(title, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByTitle_First(
		java.lang.String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByTitle_First(
		java.lang.String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByTitle_Last(
		java.lang.String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByTitle_Last(
		java.lang.String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine[] findByTitle_PrevAndNext(
		long templateId, java.lang.String title,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByTitle_PrevAndNext(templateId, title, orderByComparator);
	}

	/**
	* Removes all the WFMS_NotificationEngines where title = &#63; from the database.
	*
	* @param title the title
	*/
	public static void removeByTitle(java.lang.String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of WFMS_NotificationEngines where title = &#63;.
	*
	* @param title the title
	* @return the number of matching WFMS_NotificationEngines
	*/
	public static int countByTitle(java.lang.String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns all the WFMS_NotificationEngines where content = &#63;.
	*
	* @param content the content
	* @return the matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContent(
		java.lang.String content) {
		return getPersistence().findByContent(content);
	}

	/**
	* Returns a range of all the WFMS_NotificationEngines where content = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param content the content
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @return the range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContent(
		java.lang.String content, int start, int end) {
		return getPersistence().findByContent(content, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where content = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param content the content
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContent(
		java.lang.String content, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .findByContent(content, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where content = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param content the content
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContent(
		java.lang.String content, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByContent(content, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByContent_First(
		java.lang.String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence().findByContent_First(content, orderByComparator);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByContent_First(
		java.lang.String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence().fetchByContent_First(content, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByContent_Last(
		java.lang.String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence().findByContent_Last(content, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByContent_Last(
		java.lang.String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence().fetchByContent_Last(content, orderByComparator);
	}

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine[] findByContent_PrevAndNext(
		long templateId, java.lang.String content,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByContent_PrevAndNext(templateId, content,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_NotificationEngines where content = &#63; from the database.
	*
	* @param content the content
	*/
	public static void removeByContent(java.lang.String content) {
		getPersistence().removeByContent(content);
	}

	/**
	* Returns the number of WFMS_NotificationEngines where content = &#63;.
	*
	* @param content the content
	* @return the number of matching WFMS_NotificationEngines
	*/
	public static int countByContent(java.lang.String content) {
		return getPersistence().countByContent(content);
	}

	/**
	* Returns all the WFMS_NotificationEngines where contentType = &#63;.
	*
	* @param contentType the content type
	* @return the matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType) {
		return getPersistence().findByContentType(contentType);
	}

	/**
	* Returns a range of all the WFMS_NotificationEngines where contentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contentType the content type
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @return the range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType, int start, int end) {
		return getPersistence().findByContentType(contentType, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where contentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contentType the content type
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .findByContentType(contentType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where contentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contentType the content type
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByContentType(contentType, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByContentType_First(
		java.lang.String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByContentType_First(contentType, orderByComparator);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByContentType_First(
		java.lang.String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .fetchByContentType_First(contentType, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByContentType_Last(
		java.lang.String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByContentType_Last(contentType, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByContentType_Last(
		java.lang.String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .fetchByContentType_Last(contentType, orderByComparator);
	}

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine[] findByContentType_PrevAndNext(
		long templateId, java.lang.String contentType,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByContentType_PrevAndNext(templateId, contentType,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_NotificationEngines where contentType = &#63; from the database.
	*
	* @param contentType the content type
	*/
	public static void removeByContentType(java.lang.String contentType) {
		getPersistence().removeByContentType(contentType);
	}

	/**
	* Returns the number of WFMS_NotificationEngines where contentType = &#63;.
	*
	* @param contentType the content type
	* @return the number of matching WFMS_NotificationEngines
	*/
	public static int countByContentType(java.lang.String contentType) {
		return getPersistence().countByContentType(contentType);
	}

	/**
	* Returns all the WFMS_NotificationEngines where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy) {
		return getPersistence().findByCreatedBy(createdBy);
	}

	/**
	* Returns a range of all the WFMS_NotificationEngines where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @return the range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy, int start, int end) {
		return getPersistence().findByCreatedBy(createdBy, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .findByCreatedBy(createdBy, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCreatedBy(createdBy, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByCreatedBy_First(
		java.lang.String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByCreatedBy_First(createdBy, orderByComparator);
	}

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByCreatedBy_First(
		java.lang.String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .fetchByCreatedBy_First(createdBy, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine findByCreatedBy_Last(
		java.lang.String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByCreatedBy_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public static WFMS_NotificationEngine fetchByCreatedBy_Last(
		java.lang.String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence()
				   .fetchByCreatedBy_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine[] findByCreatedBy_PrevAndNext(
		long templateId, java.lang.String createdBy,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence()
				   .findByCreatedBy_PrevAndNext(templateId, createdBy,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_NotificationEngines where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	*/
	public static void removeByCreatedBy(java.lang.String createdBy) {
		getPersistence().removeByCreatedBy(createdBy);
	}

	/**
	* Returns the number of WFMS_NotificationEngines where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching WFMS_NotificationEngines
	*/
	public static int countByCreatedBy(java.lang.String createdBy) {
		return getPersistence().countByCreatedBy(createdBy);
	}

	/**
	* Caches the WFMS_NotificationEngine in the entity cache if it is enabled.
	*
	* @param wfms_NotificationEngine the WFMS_NotificationEngine
	*/
	public static void cacheResult(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		getPersistence().cacheResult(wfms_NotificationEngine);
	}

	/**
	* Caches the WFMS_NotificationEngines in the entity cache if it is enabled.
	*
	* @param wfms_NotificationEngines the WFMS_NotificationEngines
	*/
	public static void cacheResult(
		List<WFMS_NotificationEngine> wfms_NotificationEngines) {
		getPersistence().cacheResult(wfms_NotificationEngines);
	}

	/**
	* Creates a new WFMS_NotificationEngine with the primary key. Does not add the WFMS_NotificationEngine to the database.
	*
	* @param templateId the primary key for the new WFMS_NotificationEngine
	* @return the new WFMS_NotificationEngine
	*/
	public static WFMS_NotificationEngine create(long templateId) {
		return getPersistence().create(templateId);
	}

	/**
	* Removes the WFMS_NotificationEngine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the WFMS_NotificationEngine
	* @return the WFMS_NotificationEngine that was removed
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine remove(long templateId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence().remove(templateId);
	}

	public static WFMS_NotificationEngine updateImpl(
		WFMS_NotificationEngine wfms_NotificationEngine) {
		return getPersistence().updateImpl(wfms_NotificationEngine);
	}

	/**
	* Returns the WFMS_NotificationEngine with the primary key or throws a {@link NoSuchWFMS_NotificationEngineException} if it could not be found.
	*
	* @param templateId the primary key of the WFMS_NotificationEngine
	* @return the WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine findByPrimaryKey(long templateId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException {
		return getPersistence().findByPrimaryKey(templateId);
	}

	/**
	* Returns the WFMS_NotificationEngine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateId the primary key of the WFMS_NotificationEngine
	* @return the WFMS_NotificationEngine, or <code>null</code> if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public static WFMS_NotificationEngine fetchByPrimaryKey(long templateId) {
		return getPersistence().fetchByPrimaryKey(templateId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_NotificationEngine> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_NotificationEngines.
	*
	* @return the WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_NotificationEngines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @return the range of WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findAll(int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_NotificationEngines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_NotificationEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_NotificationEngines
	* @param end the upper bound of the range of WFMS_NotificationEngines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_NotificationEngines
	*/
	public static List<WFMS_NotificationEngine> findAll(int start, int end,
		OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_NotificationEngines from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_NotificationEngines.
	*
	* @return the number of WFMS_NotificationEngines
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WFMS_NotificationEnginePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_NotificationEnginePersistence, WFMS_NotificationEnginePersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_NotificationEnginePersistence.class);
}