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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_NotificationEngineException;
import com.ys.hmawfm.wfms.services.model.WFMS_NotificationEngine;

/**
 * The persistence interface for the WFMS_NotificationEngine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_NotificationEnginePersistenceImpl
 * @see WFMS_NotificationEngineUtil
 * @generated
 */
@ProviderType
public interface WFMS_NotificationEnginePersistence extends BasePersistence<WFMS_NotificationEngine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_NotificationEngineUtil} to access the WFMS_NotificationEngine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WFMS_NotificationEngines where title = &#63;.
	*
	* @param title the title
	* @return the matching WFMS_NotificationEngines
	*/
	public java.util.List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title);

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
	public java.util.List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title, int start, int end);

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
	public java.util.List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

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
	public java.util.List<WFMS_NotificationEngine> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByTitle_First(java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByTitle_First(java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByTitle_Last(java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByTitle_Last(java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where title = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine[] findByTitle_PrevAndNext(long templateId,
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Removes all the WFMS_NotificationEngines where title = &#63; from the database.
	*
	* @param title the title
	*/
	public void removeByTitle(java.lang.String title);

	/**
	* Returns the number of WFMS_NotificationEngines where title = &#63;.
	*
	* @param title the title
	* @return the number of matching WFMS_NotificationEngines
	*/
	public int countByTitle(java.lang.String title);

	/**
	* Returns all the WFMS_NotificationEngines where content = &#63;.
	*
	* @param content the content
	* @return the matching WFMS_NotificationEngines
	*/
	public java.util.List<WFMS_NotificationEngine> findByContent(
		java.lang.String content);

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
	public java.util.List<WFMS_NotificationEngine> findByContent(
		java.lang.String content, int start, int end);

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
	public java.util.List<WFMS_NotificationEngine> findByContent(
		java.lang.String content, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

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
	public java.util.List<WFMS_NotificationEngine> findByContent(
		java.lang.String content, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByContent_First(
		java.lang.String content,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByContent_First(
		java.lang.String content,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByContent_Last(
		java.lang.String content,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByContent_Last(
		java.lang.String content,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where content = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param content the content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine[] findByContent_PrevAndNext(
		long templateId, java.lang.String content,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Removes all the WFMS_NotificationEngines where content = &#63; from the database.
	*
	* @param content the content
	*/
	public void removeByContent(java.lang.String content);

	/**
	* Returns the number of WFMS_NotificationEngines where content = &#63;.
	*
	* @param content the content
	* @return the number of matching WFMS_NotificationEngines
	*/
	public int countByContent(java.lang.String content);

	/**
	* Returns all the WFMS_NotificationEngines where contentType = &#63;.
	*
	* @param contentType the content type
	* @return the matching WFMS_NotificationEngines
	*/
	public java.util.List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType);

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
	public java.util.List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType, int start, int end);

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
	public java.util.List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

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
	public java.util.List<WFMS_NotificationEngine> findByContentType(
		java.lang.String contentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByContentType_First(
		java.lang.String contentType,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByContentType_First(
		java.lang.String contentType,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByContentType_Last(
		java.lang.String contentType,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByContentType_Last(
		java.lang.String contentType,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where contentType = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param contentType the content type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine[] findByContentType_PrevAndNext(
		long templateId, java.lang.String contentType,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Removes all the WFMS_NotificationEngines where contentType = &#63; from the database.
	*
	* @param contentType the content type
	*/
	public void removeByContentType(java.lang.String contentType);

	/**
	* Returns the number of WFMS_NotificationEngines where contentType = &#63;.
	*
	* @param contentType the content type
	* @return the number of matching WFMS_NotificationEngines
	*/
	public int countByContentType(java.lang.String contentType);

	/**
	* Returns all the WFMS_NotificationEngines where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching WFMS_NotificationEngines
	*/
	public java.util.List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy);

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
	public java.util.List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy, int start, int end);

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
	public java.util.List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

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
	public java.util.List<WFMS_NotificationEngine> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByCreatedBy_First(
		java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the first WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByCreatedBy_First(
		java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine findByCreatedBy_Last(
		java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the last WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_NotificationEngine, or <code>null</code> if a matching WFMS_NotificationEngine could not be found
	*/
	public WFMS_NotificationEngine fetchByCreatedBy_Last(
		java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

	/**
	* Returns the WFMS_NotificationEngines before and after the current WFMS_NotificationEngine in the ordered set where createdBy = &#63;.
	*
	* @param templateId the primary key of the current WFMS_NotificationEngine
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine[] findByCreatedBy_PrevAndNext(
		long templateId, java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Removes all the WFMS_NotificationEngines where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	*/
	public void removeByCreatedBy(java.lang.String createdBy);

	/**
	* Returns the number of WFMS_NotificationEngines where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching WFMS_NotificationEngines
	*/
	public int countByCreatedBy(java.lang.String createdBy);

	/**
	* Caches the WFMS_NotificationEngine in the entity cache if it is enabled.
	*
	* @param wfms_NotificationEngine the WFMS_NotificationEngine
	*/
	public void cacheResult(WFMS_NotificationEngine wfms_NotificationEngine);

	/**
	* Caches the WFMS_NotificationEngines in the entity cache if it is enabled.
	*
	* @param wfms_NotificationEngines the WFMS_NotificationEngines
	*/
	public void cacheResult(
		java.util.List<WFMS_NotificationEngine> wfms_NotificationEngines);

	/**
	* Creates a new WFMS_NotificationEngine with the primary key. Does not add the WFMS_NotificationEngine to the database.
	*
	* @param templateId the primary key for the new WFMS_NotificationEngine
	* @return the new WFMS_NotificationEngine
	*/
	public WFMS_NotificationEngine create(long templateId);

	/**
	* Removes the WFMS_NotificationEngine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the WFMS_NotificationEngine
	* @return the WFMS_NotificationEngine that was removed
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine remove(long templateId)
		throws NoSuchWFMS_NotificationEngineException;

	public WFMS_NotificationEngine updateImpl(
		WFMS_NotificationEngine wfms_NotificationEngine);

	/**
	* Returns the WFMS_NotificationEngine with the primary key or throws a {@link NoSuchWFMS_NotificationEngineException} if it could not be found.
	*
	* @param templateId the primary key of the WFMS_NotificationEngine
	* @return the WFMS_NotificationEngine
	* @throws NoSuchWFMS_NotificationEngineException if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine findByPrimaryKey(long templateId)
		throws NoSuchWFMS_NotificationEngineException;

	/**
	* Returns the WFMS_NotificationEngine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateId the primary key of the WFMS_NotificationEngine
	* @return the WFMS_NotificationEngine, or <code>null</code> if a WFMS_NotificationEngine with the primary key could not be found
	*/
	public WFMS_NotificationEngine fetchByPrimaryKey(long templateId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_NotificationEngine> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_NotificationEngines.
	*
	* @return the WFMS_NotificationEngines
	*/
	public java.util.List<WFMS_NotificationEngine> findAll();

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
	public java.util.List<WFMS_NotificationEngine> findAll(int start, int end);

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
	public java.util.List<WFMS_NotificationEngine> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator);

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
	public java.util.List<WFMS_NotificationEngine> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_NotificationEngine> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_NotificationEngines from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_NotificationEngines.
	*
	* @return the number of WFMS_NotificationEngines
	*/
	public int countAll();
}