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

import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_Requisition service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_RequisitionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_RequisitionPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_RequisitionPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_RequisitionUtil {
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
	public static void clearCache(WFMS_Requisition wfms_Requisition) {
		getPersistence().clearCache(wfms_Requisition);
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
	public static List<WFMS_Requisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_Requisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_Requisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_Requisition update(WFMS_Requisition wfms_Requisition) {
		return getPersistence().update(wfms_Requisition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_Requisition update(WFMS_Requisition wfms_Requisition,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_Requisition, serviceContext);
	}

	/**
	* Returns all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId) {
		return getPersistence().findByStatus_Pid_Colllection(status, rId);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param rId the r ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId, int start, int end) {
		return getPersistence()
				   .findByStatus_Pid_Colllection(status, rId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param rId the r ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findByStatus_Pid_Colllection(status, rId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param rId the r ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatus_Pid_Colllection(status, rId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByStatus_Pid_Colllection_First(
		java.lang.String status, java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByStatus_Pid_Colllection_First(status, rId,
			orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByStatus_Pid_Colllection_First(
		java.lang.String status, java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByStatus_Pid_Colllection_First(status, rId,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByStatus_Pid_Colllection_Last(
		java.lang.String status, java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByStatus_Pid_Colllection_Last(status, rId,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByStatus_Pid_Colllection_Last(
		java.lang.String status, java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByStatus_Pid_Colllection_Last(status, rId,
			orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findByStatus_Pid_Colllection_PrevAndNext(
		java.lang.String rwfId, java.lang.String status, java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByStatus_Pid_Colllection_PrevAndNext(rwfId, status,
			rId, orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where status = &#63; and rId = &#63; from the database.
	*
	* @param status the status
	* @param rId the r ID
	*/
	public static void removeByStatus_Pid_Colllection(java.lang.String status,
		java.lang.String rId) {
		getPersistence().removeByStatus_Pid_Colllection(status, rId);
	}

	/**
	* Returns the number of WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countByStatus_Pid_Colllection(java.lang.String status,
		java.lang.String rId) {
		return getPersistence().countByStatus_Pid_Colllection(status, rId);
	}

	/**
	* Returns the WFMS_Requisition where rwfId = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param rwfId the rwf ID
	* @return the matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByrequisition(java.lang.String rwfId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findByrequisition(rwfId);
	}

	/**
	* Returns the WFMS_Requisition where rwfId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rwfId the rwf ID
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByrequisition(java.lang.String rwfId) {
		return getPersistence().fetchByrequisition(rwfId);
	}

	/**
	* Returns the WFMS_Requisition where rwfId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rwfId the rwf ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByrequisition(java.lang.String rwfId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByrequisition(rwfId, retrieveFromCache);
	}

	/**
	* Removes the WFMS_Requisition where rwfId = &#63; from the database.
	*
	* @param rwfId the rwf ID
	* @return the WFMS_Requisition that was removed
	*/
	public static WFMS_Requisition removeByrequisition(java.lang.String rwfId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().removeByrequisition(rwfId);
	}

	/**
	* Returns the number of WFMS_Requisitions where rwfId = &#63;.
	*
	* @param rwfId the rwf ID
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countByrequisition(java.lang.String rwfId) {
		return getPersistence().countByrequisition(rwfId);
	}

	/**
	* Returns the WFMS_Requisition where rId = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param rId the r ID
	* @return the matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByposition(java.lang.String rId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findByposition(rId);
	}

	/**
	* Returns the WFMS_Requisition where rId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rId the r ID
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByposition(java.lang.String rId) {
		return getPersistence().fetchByposition(rId);
	}

	/**
	* Returns the WFMS_Requisition where rId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rId the r ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByposition(java.lang.String rId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByposition(rId, retrieveFromCache);
	}

	/**
	* Removes the WFMS_Requisition where rId = &#63; from the database.
	*
	* @param rId the r ID
	* @return the WFMS_Requisition that was removed
	*/
	public static WFMS_Requisition removeByposition(java.lang.String rId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().removeByposition(rId);
	}

	/**
	* Returns the number of WFMS_Requisitions where rId = &#63;.
	*
	* @param rId the r ID
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countByposition(java.lang.String rId) {
		return getPersistence().countByposition(rId);
	}

	/**
	* Returns all the WFMS_Requisitions where Number = &#63;.
	*
	* @param Number the number
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number) {
		return getPersistence().findBypositionnumber(Number);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where Number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Number the number
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number, int start, int end) {
		return getPersistence().findBypositionnumber(Number, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where Number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Number the number
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findBypositionnumber(Number, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where Number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param Number the number
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypositionnumber(Number, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionnumber_First(
		java.lang.String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionnumber_First(Number, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionnumber_First(
		java.lang.String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchBypositionnumber_First(Number, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionnumber_Last(
		java.lang.String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionnumber_Last(Number, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionnumber_Last(
		java.lang.String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchBypositionnumber_Last(Number, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findBypositionnumber_PrevAndNext(
		java.lang.String rwfId, java.lang.String Number,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionnumber_PrevAndNext(rwfId, Number,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where Number = &#63; from the database.
	*
	* @param Number the number
	*/
	public static void removeBypositionnumber(java.lang.String Number) {
		getPersistence().removeBypositionnumber(Number);
	}

	/**
	* Returns the number of WFMS_Requisitions where Number = &#63;.
	*
	* @param Number the number
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countBypositionnumber(java.lang.String Number) {
		return getPersistence().countBypositionnumber(Number);
	}

	/**
	* Returns all the WFMS_Requisitions where rId = &#63;.
	*
	* @param rId the r ID
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionId(java.lang.String rId) {
		return getPersistence().findBypositionId(rId);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where rId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rId the r ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionId(
		java.lang.String rId, int start, int end) {
		return getPersistence().findBypositionId(rId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where rId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rId the r ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionId(
		java.lang.String rId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findBypositionId(rId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where rId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rId the r ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionId(
		java.lang.String rId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypositionId(rId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionId_First(
		java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findBypositionId_First(rId, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionId_First(
		java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence().fetchBypositionId_First(rId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionId_Last(java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findBypositionId_Last(rId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionId_Last(
		java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence().fetchBypositionId_Last(rId, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findBypositionId_PrevAndNext(
		java.lang.String rwfId, java.lang.String rId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionId_PrevAndNext(rwfId, rId, orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where rId = &#63; from the database.
	*
	* @param rId the r ID
	*/
	public static void removeBypositionId(java.lang.String rId) {
		getPersistence().removeBypositionId(rId);
	}

	/**
	* Returns the number of WFMS_Requisitions where rId = &#63;.
	*
	* @param rId the r ID
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countBypositionId(java.lang.String rId) {
		return getPersistence().countBypositionId(rId);
	}

	/**
	* Returns all the WFMS_Requisitions where status = &#63;.
	*
	* @param status the status
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status) {
		return getPersistence().findBypositionIdGetByStaus(status);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end) {
		return getPersistence().findBypositionIdGetByStaus(status, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findBypositionIdGetByStaus(status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypositionIdGetByStaus(status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionIdGetByStaus_First(
		java.lang.String status,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionIdGetByStaus_First(status, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionIdGetByStaus_First(
		java.lang.String status,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchBypositionIdGetByStaus_First(status, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionIdGetByStaus_Last(
		java.lang.String status,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionIdGetByStaus_Last(status, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionIdGetByStaus_Last(
		java.lang.String status,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchBypositionIdGetByStaus_Last(status, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findBypositionIdGetByStaus_PrevAndNext(
		java.lang.String rwfId, java.lang.String status,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBypositionIdGetByStaus_PrevAndNext(rwfId, status,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeBypositionIdGetByStaus(java.lang.String status) {
		getPersistence().removeBypositionIdGetByStaus(status);
	}

	/**
	* Returns the number of WFMS_Requisitions where status = &#63;.
	*
	* @param status the status
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countBypositionIdGetByStaus(java.lang.String status) {
		return getPersistence().countBypositionIdGetByStaus(status);
	}

	/**
	* Returns all the WFMS_Requisitions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBydummy(java.lang.String dummy) {
		return getPersistence().findBydummy(dummy);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where dummy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dummy the dummy
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBydummy(java.lang.String dummy,
		int start, int end) {
		return getPersistence().findBydummy(dummy, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where dummy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dummy the dummy
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBydummy(java.lang.String dummy,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence().findBydummy(dummy, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where dummy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dummy the dummy
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findBydummy(java.lang.String dummy,
		int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydummy(dummy, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBydummy_First(java.lang.String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findBydummy_First(dummy, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBydummy_First(java.lang.String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence().fetchBydummy_First(dummy, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBydummy_Last(java.lang.String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findBydummy_Last(dummy, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBydummy_Last(java.lang.String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence().fetchBydummy_Last(dummy, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findBydummy_PrevAndNext(
		java.lang.String rwfId, java.lang.String dummy,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findBydummy_PrevAndNext(rwfId, dummy, orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where dummy = &#63; from the database.
	*
	* @param dummy the dummy
	*/
	public static void removeBydummy(java.lang.String dummy) {
		getPersistence().removeBydummy(dummy);
	}

	/**
	* Returns the number of WFMS_Requisitions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countBydummy(java.lang.String dummy) {
		return getPersistence().countBydummy(dummy);
	}

	/**
	* Returns all the WFMS_Requisitions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId) {
		return getPersistence().findByworkflowId(workflowId);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where workflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workflowId the workflow ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId, int start, int end) {
		return getPersistence().findByworkflowId(workflowId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where workflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workflowId the workflow ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findByworkflowId(workflowId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where workflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workflowId the workflow ID
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByworkflowId(workflowId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByworkflowId_First(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByworkflowId_First(workflowId, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByworkflowId_First(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByworkflowId_First(workflowId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByworkflowId_Last(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByworkflowId_Last(workflowId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByworkflowId_Last(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByworkflowId_Last(workflowId, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findByworkflowId_PrevAndNext(
		java.lang.String rwfId, java.lang.String workflowId,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByworkflowId_PrevAndNext(rwfId, workflowId,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where workflowId = &#63; from the database.
	*
	* @param workflowId the workflow ID
	*/
	public static void removeByworkflowId(java.lang.String workflowId) {
		getPersistence().removeByworkflowId(workflowId);
	}

	/**
	* Returns the number of WFMS_Requisitions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countByworkflowId(java.lang.String workflowId) {
		return getPersistence().countByworkflowId(workflowId);
	}

	/**
	* Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findBypositionassociate(
		java.lang.String Number, java.lang.String associatenumber)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findBypositionassociate(Number, associatenumber);
	}

	/**
	* Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionassociate(
		java.lang.String Number, java.lang.String associatenumber) {
		return getPersistence().fetchBypositionassociate(Number, associatenumber);
	}

	/**
	* Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchBypositionassociate(
		java.lang.String Number, java.lang.String associatenumber,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBypositionassociate(Number, associatenumber,
			retrieveFromCache);
	}

	/**
	* Removes the WFMS_Requisition where Number = &#63; and associatenumber = &#63; from the database.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the WFMS_Requisition that was removed
	*/
	public static WFMS_Requisition removeBypositionassociate(
		java.lang.String Number, java.lang.String associatenumber)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .removeBypositionassociate(Number, associatenumber);
	}

	/**
	* Returns the number of WFMS_Requisitions where Number = &#63; and associatenumber = &#63;.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber) {
		return getPersistence().countBypositionassociate(Number, associatenumber);
	}

	/**
	* Returns all the WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove) {
		return getPersistence().findByNextApprove(nextapprove);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextapprove the nextapprove
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove, int start, int end) {
		return getPersistence().findByNextApprove(nextapprove, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextapprove the nextapprove
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findByNextApprove(nextapprove, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextapprove the nextapprove
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByNextApprove(nextapprove, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByNextApprove_First(
		java.lang.String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByNextApprove_First(nextapprove, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByNextApprove_First(
		java.lang.String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByNextApprove_First(nextapprove, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByNextApprove_Last(
		java.lang.String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByNextApprove_Last(nextapprove, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByNextApprove_Last(
		java.lang.String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByNextApprove_Last(nextapprove, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findByNextApprove_PrevAndNext(
		java.lang.String rwfId, java.lang.String nextapprove,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByNextApprove_PrevAndNext(rwfId, nextapprove,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where nextapprove LIKE &#63; from the database.
	*
	* @param nextapprove the nextapprove
	*/
	public static void removeByNextApprove(java.lang.String nextapprove) {
		getPersistence().removeByNextApprove(nextapprove);
	}

	/**
	* Returns the number of WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countByNextApprove(java.lang.String nextapprove) {
		return getPersistence().countByNextApprove(nextapprove);
	}

	/**
	* Returns all the WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover) {
		return getPersistence().findByRoleOfApprover(roleOfApprover);
	}

	/**
	* Returns a range of all the WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleOfApprover the role of approver
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end) {
		return getPersistence().findByRoleOfApprover(roleOfApprover, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleOfApprover the role of approver
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .findByRoleOfApprover(roleOfApprover, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleOfApprover the role of approver
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRoleOfApprover(roleOfApprover, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByRoleOfApprover_First(roleOfApprover, orderByComparator);
	}

	/**
	* Returns the first WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByRoleOfApprover_First(roleOfApprover,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition findByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByRoleOfApprover_Last(roleOfApprover, orderByComparator);
	}

	/**
	* Returns the last WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public static WFMS_Requisition fetchByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence()
				   .fetchByRoleOfApprover_Last(roleOfApprover, orderByComparator);
	}

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition[] findByRoleOfApprover_PrevAndNext(
		java.lang.String rwfId, java.lang.String roleOfApprover,
		OrderByComparator<WFMS_Requisition> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence()
				   .findByRoleOfApprover_PrevAndNext(rwfId, roleOfApprover,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Requisitions where roleOfApprover = &#63; from the database.
	*
	* @param roleOfApprover the role of approver
	*/
	public static void removeByRoleOfApprover(java.lang.String roleOfApprover) {
		getPersistence().removeByRoleOfApprover(roleOfApprover);
	}

	/**
	* Returns the number of WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the number of matching WFMS_Requisitions
	*/
	public static int countByRoleOfApprover(java.lang.String roleOfApprover) {
		return getPersistence().countByRoleOfApprover(roleOfApprover);
	}

	/**
	* Caches the WFMS_Requisition in the entity cache if it is enabled.
	*
	* @param wfms_Requisition the WFMS_Requisition
	*/
	public static void cacheResult(WFMS_Requisition wfms_Requisition) {
		getPersistence().cacheResult(wfms_Requisition);
	}

	/**
	* Caches the WFMS_Requisitions in the entity cache if it is enabled.
	*
	* @param wfms_Requisitions the WFMS_Requisitions
	*/
	public static void cacheResult(List<WFMS_Requisition> wfms_Requisitions) {
		getPersistence().cacheResult(wfms_Requisitions);
	}

	/**
	* Creates a new WFMS_Requisition with the primary key. Does not add the WFMS_Requisition to the database.
	*
	* @param rwfId the primary key for the new WFMS_Requisition
	* @return the new WFMS_Requisition
	*/
	public static WFMS_Requisition create(java.lang.String rwfId) {
		return getPersistence().create(rwfId);
	}

	/**
	* Removes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition remove(java.lang.String rwfId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().remove(rwfId);
	}

	public static WFMS_Requisition updateImpl(WFMS_Requisition wfms_Requisition) {
		return getPersistence().updateImpl(wfms_Requisition);
	}

	/**
	* Returns the WFMS_Requisition with the primary key or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition findByPrimaryKey(java.lang.String rwfId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException {
		return getPersistence().findByPrimaryKey(rwfId);
	}

	/**
	* Returns the WFMS_Requisition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition, or <code>null</code> if a WFMS_Requisition with the primary key could not be found
	*/
	public static WFMS_Requisition fetchByPrimaryKey(java.lang.String rwfId) {
		return getPersistence().fetchByPrimaryKey(rwfId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_Requisition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_Requisitions.
	*
	* @return the WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_Requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @return the range of WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findAll(int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_RequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisitions
	* @param end the upper bound of the range of WFMS_Requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Requisitions
	*/
	public static List<WFMS_Requisition> findAll(int start, int end,
		OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_Requisitions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_Requisitions.
	*
	* @return the number of WFMS_Requisitions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WFMS_RequisitionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_RequisitionPersistence, WFMS_RequisitionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_RequisitionPersistence.class);
}