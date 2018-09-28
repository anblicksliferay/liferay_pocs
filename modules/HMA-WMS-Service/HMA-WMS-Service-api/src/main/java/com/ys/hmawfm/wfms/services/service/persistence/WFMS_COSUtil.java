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

import com.ys.hmawfm.wfms.services.model.WFMS_COS;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_COS service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_COSPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_COSPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_COSUtil {
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
	public static void clearCache(WFMS_COS wfms_cos) {
		getPersistence().clearCache(wfms_cos);
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
	public static List<WFMS_COS> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_COS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_COS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_COS update(WFMS_COS wfms_cos) {
		return getPersistence().update(wfms_cos);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_COS update(WFMS_COS wfms_cos,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_cos, serviceContext);
	}

	/**
	* Returns all the WFMS_COSs where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAssoicateId(java.lang.String assoicateId) {
		return getPersistence().findByAssoicateId(assoicateId);
	}

	/**
	* Returns a range of all the WFMS_COSs where assoicateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assoicateId the assoicate ID
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId, int start, int end) {
		return getPersistence().findByAssoicateId(assoicateId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where assoicateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assoicateId the assoicate ID
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findByAssoicateId(assoicateId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where assoicateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assoicateId the assoicate ID
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByAssoicateId(assoicateId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByAssoicateId_First(
		java.lang.String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByAssoicateId_First(assoicateId, orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByAssoicateId_First(
		java.lang.String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchByAssoicateId_First(assoicateId, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByAssoicateId_Last(
		java.lang.String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByAssoicateId_Last(assoicateId, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByAssoicateId_Last(
		java.lang.String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchByAssoicateId_Last(assoicateId, orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findByAssoicateId_PrevAndNext(
		java.lang.String cosId, java.lang.String assoicateId,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByAssoicateId_PrevAndNext(cosId, assoicateId,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where assoicateId = &#63; from the database.
	*
	* @param assoicateId the assoicate ID
	*/
	public static void removeByAssoicateId(java.lang.String assoicateId) {
		getPersistence().removeByAssoicateId(assoicateId);
	}

	/**
	* Returns the number of WFMS_COSs where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @return the number of matching WFMS_COSs
	*/
	public static int countByAssoicateId(java.lang.String assoicateId) {
		return getPersistence().countByAssoicateId(assoicateId);
	}

	/**
	* Returns all the WFMS_COSs where action = &#63;.
	*
	* @param action the action
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAction(java.lang.String action) {
		return getPersistence().findByAction(action);
	}

	/**
	* Returns a range of all the WFMS_COSs where action = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAction(java.lang.String action,
		int start, int end) {
		return getPersistence().findByAction(action, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where action = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAction(java.lang.String action,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findByAction(action, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where action = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param action the action
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByAction(java.lang.String action,
		int start, int end, OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAction(action, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByAction_First(java.lang.String action,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().findByAction_First(action, orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByAction_First(java.lang.String action,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence().fetchByAction_First(action, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByAction_Last(java.lang.String action,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().findByAction_Last(action, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByAction_Last(java.lang.String action,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence().fetchByAction_Last(action, orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where action = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findByAction_PrevAndNext(java.lang.String cosId,
		java.lang.String action, OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByAction_PrevAndNext(cosId, action, orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where action = &#63; from the database.
	*
	* @param action the action
	*/
	public static void removeByAction(java.lang.String action) {
		getPersistence().removeByAction(action);
	}

	/**
	* Returns the number of WFMS_COSs where action = &#63;.
	*
	* @param action the action
	* @return the number of matching WFMS_COSs
	*/
	public static int countByAction(java.lang.String action) {
		return getPersistence().countByAction(action);
	}

	/**
	* Returns the WFMS_COS where cosId = &#63; or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	*
	* @param cosId the cos ID
	* @return the matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBycos(java.lang.String cosId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().findBycos(cosId);
	}

	/**
	* Returns the WFMS_COS where cosId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cosId the cos ID
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBycos(java.lang.String cosId) {
		return getPersistence().fetchBycos(cosId);
	}

	/**
	* Returns the WFMS_COS where cosId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cosId the cos ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBycos(java.lang.String cosId,
		boolean retrieveFromCache) {
		return getPersistence().fetchBycos(cosId, retrieveFromCache);
	}

	/**
	* Removes the WFMS_COS where cosId = &#63; from the database.
	*
	* @param cosId the cos ID
	* @return the WFMS_COS that was removed
	*/
	public static WFMS_COS removeBycos(java.lang.String cosId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().removeBycos(cosId);
	}

	/**
	* Returns the number of WFMS_COSs where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @return the number of matching WFMS_COSs
	*/
	public static int countBycos(java.lang.String cosId) {
		return getPersistence().countBycos(cosId);
	}

	/**
	* Returns all the WFMS_COSs where status = &#63;.
	*
	* @param status the status
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status) {
		return getPersistence().findBypositionIdGetByStaus(status);
	}

	/**
	* Returns a range of all the WFMS_COSs where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end) {
		return getPersistence().findBypositionIdGetByStaus(status, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findBypositionIdGetByStaus(status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBypositionIdGetByStaus(status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBypositionIdGetByStaus_First(
		java.lang.String status, OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBypositionIdGetByStaus_First(status, orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBypositionIdGetByStaus_First(
		java.lang.String status, OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchBypositionIdGetByStaus_First(status, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBypositionIdGetByStaus_Last(
		java.lang.String status, OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBypositionIdGetByStaus_Last(status, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBypositionIdGetByStaus_Last(
		java.lang.String status, OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchBypositionIdGetByStaus_Last(status, orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where status = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findBypositionIdGetByStaus_PrevAndNext(
		java.lang.String cosId, java.lang.String status,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBypositionIdGetByStaus_PrevAndNext(cosId, status,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeBypositionIdGetByStaus(java.lang.String status) {
		getPersistence().removeBypositionIdGetByStaus(status);
	}

	/**
	* Returns the number of WFMS_COSs where status = &#63;.
	*
	* @param status the status
	* @return the number of matching WFMS_COSs
	*/
	public static int countBypositionIdGetByStaus(java.lang.String status) {
		return getPersistence().countBypositionIdGetByStaus(status);
	}

	/**
	* Returns all the WFMS_COSs where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber) {
		return getPersistence().findBycosIdGetByPosId(positionNumber);
	}

	/**
	* Returns a range of all the WFMS_COSs where positionNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param positionNumber the position number
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber, int start, int end) {
		return getPersistence().findBycosIdGetByPosId(positionNumber, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where positionNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param positionNumber the position number
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findBycosIdGetByPosId(positionNumber, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where positionNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param positionNumber the position number
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBycosIdGetByPosId(positionNumber, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBycosIdGetByPosId_First(
		java.lang.String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBycosIdGetByPosId_First(positionNumber,
			orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBycosIdGetByPosId_First(
		java.lang.String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchBycosIdGetByPosId_First(positionNumber,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBycosIdGetByPosId_Last(
		java.lang.String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBycosIdGetByPosId_Last(positionNumber, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBycosIdGetByPosId_Last(
		java.lang.String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchBycosIdGetByPosId_Last(positionNumber,
			orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findBycosIdGetByPosId_PrevAndNext(
		java.lang.String cosId, java.lang.String positionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBycosIdGetByPosId_PrevAndNext(cosId, positionNumber,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where positionNumber = &#63; from the database.
	*
	* @param positionNumber the position number
	*/
	public static void removeBycosIdGetByPosId(java.lang.String positionNumber) {
		getPersistence().removeBycosIdGetByPosId(positionNumber);
	}

	/**
	* Returns the number of WFMS_COSs where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @return the number of matching WFMS_COSs
	*/
	public static int countBycosIdGetByPosId(java.lang.String positionNumber) {
		return getPersistence().countBycosIdGetByPosId(positionNumber);
	}

	/**
	* Returns the WFMS_COS where assoicateId = &#63; or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	*
	* @param assoicateId the assoicate ID
	* @return the matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByassociateId(java.lang.String assoicateId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().findByassociateId(assoicateId);
	}

	/**
	* Returns the WFMS_COS where assoicateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assoicateId the assoicate ID
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByassociateId(java.lang.String assoicateId) {
		return getPersistence().fetchByassociateId(assoicateId);
	}

	/**
	* Returns the WFMS_COS where assoicateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assoicateId the assoicate ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByassociateId(java.lang.String assoicateId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByassociateId(assoicateId, retrieveFromCache);
	}

	/**
	* Removes the WFMS_COS where assoicateId = &#63; from the database.
	*
	* @param assoicateId the assoicate ID
	* @return the WFMS_COS that was removed
	*/
	public static WFMS_COS removeByassociateId(java.lang.String assoicateId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().removeByassociateId(assoicateId);
	}

	/**
	* Returns the number of WFMS_COSs where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @return the number of matching WFMS_COSs
	*/
	public static int countByassociateId(java.lang.String assoicateId) {
		return getPersistence().countByassociateId(assoicateId);
	}

	/**
	* Returns all the WFMS_COSs where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber) {
		return getPersistence().findBynewPositionNumber(newPositionNumber);
	}

	/**
	* Returns a range of all the WFMS_COSs where newPositionNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param newPositionNumber the new position number
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber, int start, int end) {
		return getPersistence()
				   .findBynewPositionNumber(newPositionNumber, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where newPositionNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param newPositionNumber the new position number
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findBynewPositionNumber(newPositionNumber, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where newPositionNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param newPositionNumber the new position number
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBynewPositionNumber(newPositionNumber, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBynewPositionNumber_First(
		java.lang.String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBynewPositionNumber_First(newPositionNumber,
			orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBynewPositionNumber_First(
		java.lang.String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchBynewPositionNumber_First(newPositionNumber,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findBynewPositionNumber_Last(
		java.lang.String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBynewPositionNumber_Last(newPositionNumber,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchBynewPositionNumber_Last(
		java.lang.String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchBynewPositionNumber_Last(newPositionNumber,
			orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findBynewPositionNumber_PrevAndNext(
		java.lang.String cosId, java.lang.String newPositionNumber,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findBynewPositionNumber_PrevAndNext(cosId,
			newPositionNumber, orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where newPositionNumber = &#63; from the database.
	*
	* @param newPositionNumber the new position number
	*/
	public static void removeBynewPositionNumber(
		java.lang.String newPositionNumber) {
		getPersistence().removeBynewPositionNumber(newPositionNumber);
	}

	/**
	* Returns the number of WFMS_COSs where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @return the number of matching WFMS_COSs
	*/
	public static int countBynewPositionNumber(
		java.lang.String newPositionNumber) {
		return getPersistence().countBynewPositionNumber(newPositionNumber);
	}

	/**
	* Returns all the WFMS_COSs where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover) {
		return getPersistence().findByNextApprover(nextApprover);
	}

	/**
	* Returns a range of all the WFMS_COSs where nextApprover LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextApprover the next approver
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover, int start, int end) {
		return getPersistence().findByNextApprover(nextApprover, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where nextApprover LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextApprover the next approver
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findByNextApprover(nextApprover, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where nextApprover LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextApprover the next approver
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByNextApprover(nextApprover, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByNextApprover_First(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByNextApprover_First(nextApprover, orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByNextApprover_First(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchByNextApprover_First(nextApprover, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByNextApprover_Last(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByNextApprover_Last(nextApprover, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByNextApprover_Last(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchByNextApprover_Last(nextApprover, orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findByNextApprover_PrevAndNext(
		java.lang.String cosId, java.lang.String nextApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByNextApprover_PrevAndNext(cosId, nextApprover,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where nextApprover LIKE &#63; from the database.
	*
	* @param nextApprover the next approver
	*/
	public static void removeByNextApprover(java.lang.String nextApprover) {
		getPersistence().removeByNextApprover(nextApprover);
	}

	/**
	* Returns the number of WFMS_COSs where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the number of matching WFMS_COSs
	*/
	public static int countByNextApprover(java.lang.String nextApprover) {
		return getPersistence().countByNextApprover(nextApprover);
	}

	/**
	* Returns all the WFMS_COSs where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover) {
		return getPersistence().findByRoleOfApprover(roleOfApprover);
	}

	/**
	* Returns a range of all the WFMS_COSs where roleOfApprover = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleOfApprover the role of approver
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end) {
		return getPersistence().findByRoleOfApprover(roleOfApprover, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where roleOfApprover = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleOfApprover the role of approver
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .findByRoleOfApprover(roleOfApprover, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs where roleOfApprover = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleOfApprover the role of approver
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COSs
	*/
	public static List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByRoleOfApprover(roleOfApprover, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByRoleOfApprover_First(roleOfApprover, orderByComparator);
	}

	/**
	* Returns the first WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchByRoleOfApprover_First(roleOfApprover,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS findByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByRoleOfApprover_Last(roleOfApprover, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public static WFMS_COS fetchByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence()
				   .fetchByRoleOfApprover_Last(roleOfApprover, orderByComparator);
	}

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS[] findByRoleOfApprover_PrevAndNext(
		java.lang.String cosId, java.lang.String roleOfApprover,
		OrderByComparator<WFMS_COS> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence()
				   .findByRoleOfApprover_PrevAndNext(cosId, roleOfApprover,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_COSs where roleOfApprover = &#63; from the database.
	*
	* @param roleOfApprover the role of approver
	*/
	public static void removeByRoleOfApprover(java.lang.String roleOfApprover) {
		getPersistence().removeByRoleOfApprover(roleOfApprover);
	}

	/**
	* Returns the number of WFMS_COSs where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the number of matching WFMS_COSs
	*/
	public static int countByRoleOfApprover(java.lang.String roleOfApprover) {
		return getPersistence().countByRoleOfApprover(roleOfApprover);
	}

	/**
	* Caches the WFMS_COS in the entity cache if it is enabled.
	*
	* @param wfms_cos the WFMS_COS
	*/
	public static void cacheResult(WFMS_COS wfms_cos) {
		getPersistence().cacheResult(wfms_cos);
	}

	/**
	* Caches the WFMS_COSs in the entity cache if it is enabled.
	*
	* @param wfms_coses the WFMS_COSs
	*/
	public static void cacheResult(List<WFMS_COS> wfms_coses) {
		getPersistence().cacheResult(wfms_coses);
	}

	/**
	* Creates a new WFMS_COS with the primary key. Does not add the WFMS_COS to the database.
	*
	* @param cosId the primary key for the new WFMS_COS
	* @return the new WFMS_COS
	*/
	public static WFMS_COS create(java.lang.String cosId) {
		return getPersistence().create(cosId);
	}

	/**
	* Removes the WFMS_COS with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS that was removed
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS remove(java.lang.String cosId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().remove(cosId);
	}

	public static WFMS_COS updateImpl(WFMS_COS wfms_cos) {
		return getPersistence().updateImpl(wfms_cos);
	}

	/**
	* Returns the WFMS_COS with the primary key or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS findByPrimaryKey(java.lang.String cosId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException {
		return getPersistence().findByPrimaryKey(cosId);
	}

	/**
	* Returns the WFMS_COS with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS, or <code>null</code> if a WFMS_COS with the primary key could not be found
	*/
	public static WFMS_COS fetchByPrimaryKey(java.lang.String cosId) {
		return getPersistence().fetchByPrimaryKey(cosId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_COS> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_COSs.
	*
	* @return the WFMS_COSs
	*/
	public static List<WFMS_COS> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_COSs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @return the range of WFMS_COSs
	*/
	public static List<WFMS_COS> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_COSs
	*/
	public static List<WFMS_COS> findAll(int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COSs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COSs
	* @param end the upper bound of the range of WFMS_COSs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_COSs
	*/
	public static List<WFMS_COS> findAll(int start, int end,
		OrderByComparator<WFMS_COS> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_COSs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_COSs.
	*
	* @return the number of WFMS_COSs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WFMS_COSPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_COSPersistence, WFMS_COSPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_COSPersistence.class);
}