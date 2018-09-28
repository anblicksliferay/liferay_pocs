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

import com.ys.hmawfm.wfms.services.model.WFMS_Position;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_Position service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_PositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_PositionPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_PositionPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_PositionUtil {
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
	public static void clearCache(WFMS_Position wfms_Position) {
		getPersistence().clearCache(wfms_Position);
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
	public static List<WFMS_Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_Position update(WFMS_Position wfms_Position) {
		return getPersistence().update(wfms_Position);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_Position update(WFMS_Position wfms_Position,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_Position, serviceContext);
	}

	/**
	* Returns all the WFMS_Positions where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByrefPosId(java.lang.String refPosId) {
		return getPersistence().findByrefPosId(refPosId);
	}

	/**
	* Returns a range of all the WFMS_Positions where refPosId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param refPosId the ref pos ID
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId, int start, int end) {
		return getPersistence().findByrefPosId(refPosId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where refPosId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param refPosId the ref pos ID
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByrefPosId(refPosId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where refPosId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param refPosId the ref pos ID
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrefPosId(refPosId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByrefPosId_First(
		java.lang.String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByrefPosId_First(refPosId, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByrefPosId_First(
		java.lang.String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByrefPosId_First(refPosId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByrefPosId_Last(java.lang.String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByrefPosId_Last(refPosId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByrefPosId_Last(
		java.lang.String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().fetchByrefPosId_Last(refPosId, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByrefPosId_PrevAndNext(
		java.lang.String pId, java.lang.String refPosId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByrefPosId_PrevAndNext(pId, refPosId, orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where refPosId = &#63; from the database.
	*
	* @param refPosId the ref pos ID
	*/
	public static void removeByrefPosId(java.lang.String refPosId) {
		getPersistence().removeByrefPosId(refPosId);
	}

	/**
	* Returns the number of WFMS_Positions where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @return the number of matching WFMS_Positions
	*/
	public static int countByrefPosId(java.lang.String refPosId) {
		return getPersistence().countByrefPosId(refPosId);
	}

	/**
	* Returns all the WFMS_Positions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBydummy(java.lang.String dummy) {
		return getPersistence().findBydummy(dummy);
	}

	/**
	* Returns a range of all the WFMS_Positions where dummy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dummy the dummy
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBydummy(java.lang.String dummy,
		int start, int end) {
		return getPersistence().findBydummy(dummy, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where dummy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dummy the dummy
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBydummy(java.lang.String dummy,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().findBydummy(dummy, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where dummy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dummy the dummy
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBydummy(java.lang.String dummy,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydummy(dummy, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findBydummy_First(java.lang.String dummy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findBydummy_First(dummy, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchBydummy_First(java.lang.String dummy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().fetchBydummy_First(dummy, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findBydummy_Last(java.lang.String dummy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findBydummy_Last(dummy, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchBydummy_Last(java.lang.String dummy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().fetchBydummy_Last(dummy, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findBydummy_PrevAndNext(
		java.lang.String pId, java.lang.String dummy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findBydummy_PrevAndNext(pId, dummy, orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where dummy = &#63; from the database.
	*
	* @param dummy the dummy
	*/
	public static void removeBydummy(java.lang.String dummy) {
		getPersistence().removeBydummy(dummy);
	}

	/**
	* Returns the number of WFMS_Positions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the number of matching WFMS_Positions
	*/
	public static int countBydummy(java.lang.String dummy) {
		return getPersistence().countBydummy(dummy);
	}

	/**
	* Returns all the WFMS_Positions where number = &#63;.
	*
	* @param number the number
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNumber(java.lang.String number) {
		return getPersistence().findByNumber(number);
	}

	/**
	* Returns a range of all the WFMS_Positions where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNumber(java.lang.String number,
		int start, int end) {
		return getPersistence().findByNumber(number, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNumber(java.lang.String number,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByNumber(number, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNumber(java.lang.String number,
		int start, int end, OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByNumber(number, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByNumber_First(java.lang.String number,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByNumber_First(number, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByNumber_First(java.lang.String number,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().fetchByNumber_First(number, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByNumber_Last(java.lang.String number,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByNumber_Last(number, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByNumber_Last(java.lang.String number,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().fetchByNumber_Last(number, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where number = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByNumber_PrevAndNext(
		java.lang.String pId, java.lang.String number,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByNumber_PrevAndNext(pId, number, orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where number = &#63; from the database.
	*
	* @param number the number
	*/
	public static void removeByNumber(java.lang.String number) {
		getPersistence().removeByNumber(number);
	}

	/**
	* Returns the number of WFMS_Positions where number = &#63;.
	*
	* @param number the number
	* @return the number of matching WFMS_Positions
	*/
	public static int countByNumber(java.lang.String number) {
		return getPersistence().countByNumber(number);
	}

	/**
	* Returns all the WFMS_Positions where category = &#63;.
	*
	* @param category the category
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCategory(java.lang.String category) {
		return getPersistence().findByCategory(category);
	}

	/**
	* Returns a range of all the WFMS_Positions where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCategory(
		java.lang.String category, int start, int end) {
		return getPersistence().findByCategory(category, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCategory(
		java.lang.String category, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByCategory(category, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCategory(
		java.lang.String category, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCategory(category, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByCategory_First(
		java.lang.String category,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByCategory_First(category, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByCategory_First(
		java.lang.String category,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByCategory_First(category, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByCategory_Last(java.lang.String category,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByCategory_Last(category, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByCategory_Last(
		java.lang.String category,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().fetchByCategory_Last(category, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where category = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByCategory_PrevAndNext(
		java.lang.String pId, java.lang.String category,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByCategory_PrevAndNext(pId, category, orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where category = &#63; from the database.
	*
	* @param category the category
	*/
	public static void removeByCategory(java.lang.String category) {
		getPersistence().removeByCategory(category);
	}

	/**
	* Returns the number of WFMS_Positions where category = &#63;.
	*
	* @param category the category
	* @return the number of matching WFMS_Positions
	*/
	public static int countByCategory(java.lang.String category) {
		return getPersistence().countByCategory(category);
	}

	/**
	* Returns all the WFMS_Positions where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber) {
		return getPersistence().findByAssociateNumber(associateNumber);
	}

	/**
	* Returns a range of all the WFMS_Positions where associateNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param associateNumber the associate number
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber, int start, int end) {
		return getPersistence()
				   .findByAssociateNumber(associateNumber, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where associateNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param associateNumber the associate number
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByAssociateNumber(associateNumber, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where associateNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param associateNumber the associate number
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAssociateNumber(associateNumber, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByAssociateNumber_First(
		java.lang.String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByAssociateNumber_First(associateNumber,
			orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByAssociateNumber_First(
		java.lang.String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByAssociateNumber_First(associateNumber,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByAssociateNumber_Last(
		java.lang.String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByAssociateNumber_Last(associateNumber,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByAssociateNumber_Last(
		java.lang.String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByAssociateNumber_Last(associateNumber,
			orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByAssociateNumber_PrevAndNext(
		java.lang.String pId, java.lang.String associateNumber,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByAssociateNumber_PrevAndNext(pId, associateNumber,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where associateNumber = &#63; from the database.
	*
	* @param associateNumber the associate number
	*/
	public static void removeByAssociateNumber(java.lang.String associateNumber) {
		getPersistence().removeByAssociateNumber(associateNumber);
	}

	/**
	* Returns the number of WFMS_Positions where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @return the number of matching WFMS_Positions
	*/
	public static int countByAssociateNumber(java.lang.String associateNumber) {
		return getPersistence().countByAssociateNumber(associateNumber);
	}

	/**
	* Returns all the WFMS_Positions where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq) {
		return getPersistence().findByautoGenerateReq(autoGenerateReq);
	}

	/**
	* Returns a range of all the WFMS_Positions where autoGenerateReq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param autoGenerateReq the auto generate req
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq, int start, int end) {
		return getPersistence()
				   .findByautoGenerateReq(autoGenerateReq, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where autoGenerateReq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param autoGenerateReq the auto generate req
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByautoGenerateReq(autoGenerateReq, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where autoGenerateReq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param autoGenerateReq the auto generate req
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByautoGenerateReq(autoGenerateReq, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByautoGenerateReq_First(
		java.lang.String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByautoGenerateReq_First(autoGenerateReq,
			orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByautoGenerateReq_First(
		java.lang.String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByautoGenerateReq_First(autoGenerateReq,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByautoGenerateReq_Last(
		java.lang.String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByautoGenerateReq_Last(autoGenerateReq,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByautoGenerateReq_Last(
		java.lang.String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByautoGenerateReq_Last(autoGenerateReq,
			orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByautoGenerateReq_PrevAndNext(
		java.lang.String pId, java.lang.String autoGenerateReq,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByautoGenerateReq_PrevAndNext(pId, autoGenerateReq,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where autoGenerateReq = &#63; from the database.
	*
	* @param autoGenerateReq the auto generate req
	*/
	public static void removeByautoGenerateReq(java.lang.String autoGenerateReq) {
		getPersistence().removeByautoGenerateReq(autoGenerateReq);
	}

	/**
	* Returns the number of WFMS_Positions where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @return the number of matching WFMS_Positions
	*/
	public static int countByautoGenerateReq(java.lang.String autoGenerateReq) {
		return getPersistence().countByautoGenerateReq(autoGenerateReq);
	}

	/**
	* Returns all the WFMS_Positions where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy) {
		return getPersistence().findByCreatedBy(createdBy);
	}

	/**
	* Returns a range of all the WFMS_Positions where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy, int start, int end) {
		return getPersistence().findByCreatedBy(createdBy, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByCreatedBy(createdBy, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCreatedBy(createdBy, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByCreatedBy_First(
		java.lang.String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByCreatedBy_First(createdBy, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByCreatedBy_First(
		java.lang.String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByCreatedBy_First(createdBy, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByCreatedBy_Last(
		java.lang.String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByCreatedBy_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByCreatedBy_Last(
		java.lang.String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByCreatedBy_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByCreatedBy_PrevAndNext(
		java.lang.String pId, java.lang.String createdBy,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByCreatedBy_PrevAndNext(pId, createdBy,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	*/
	public static void removeByCreatedBy(java.lang.String createdBy) {
		getPersistence().removeByCreatedBy(createdBy);
	}

	/**
	* Returns the number of WFMS_Positions where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching WFMS_Positions
	*/
	public static int countByCreatedBy(java.lang.String createdBy) {
		return getPersistence().countByCreatedBy(createdBy);
	}

	/**
	* Returns the WFMS_Position where pId = &#63; or throws a {@link NoSuchWFMS_PositionException} if it could not be found.
	*
	* @param pId the p ID
	* @return the matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByposition(java.lang.String pId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByposition(pId);
	}

	/**
	* Returns the WFMS_Position where pId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pId the p ID
	* @return the matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByposition(java.lang.String pId) {
		return getPersistence().fetchByposition(pId);
	}

	/**
	* Returns the WFMS_Position where pId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pId the p ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByposition(java.lang.String pId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByposition(pId, retrieveFromCache);
	}

	/**
	* Removes the WFMS_Position where pId = &#63; from the database.
	*
	* @param pId the p ID
	* @return the WFMS_Position that was removed
	*/
	public static WFMS_Position removeByposition(java.lang.String pId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().removeByposition(pId);
	}

	/**
	* Returns the number of WFMS_Positions where pId = &#63;.
	*
	* @param pId the p ID
	* @return the number of matching WFMS_Positions
	*/
	public static int countByposition(java.lang.String pId) {
		return getPersistence().countByposition(pId);
	}

	/**
	* Returns all the WFMS_Positions where status = &#63;.
	*
	* @param status the status
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status) {
		return getPersistence().findBypositionIdGetByStaus(status);
	}

	/**
	* Returns a range of all the WFMS_Positions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end) {
		return getPersistence().findBypositionIdGetByStaus(status, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findBypositionIdGetByStaus(status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypositionIdGetByStaus(status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findBypositionIdGetByStaus_First(
		java.lang.String status,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findBypositionIdGetByStaus_First(status, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchBypositionIdGetByStaus_First(
		java.lang.String status,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchBypositionIdGetByStaus_First(status, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findBypositionIdGetByStaus_Last(
		java.lang.String status,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findBypositionIdGetByStaus_Last(status, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchBypositionIdGetByStaus_Last(
		java.lang.String status,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchBypositionIdGetByStaus_Last(status, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where status = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findBypositionIdGetByStaus_PrevAndNext(
		java.lang.String pId, java.lang.String status,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findBypositionIdGetByStaus_PrevAndNext(pId, status,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeBypositionIdGetByStaus(java.lang.String status) {
		getPersistence().removeBypositionIdGetByStaus(status);
	}

	/**
	* Returns the number of WFMS_Positions where status = &#63;.
	*
	* @param status the status
	* @return the number of matching WFMS_Positions
	*/
	public static int countBypositionIdGetByStaus(java.lang.String status) {
		return getPersistence().countBypositionIdGetByStaus(status);
	}

	/**
	* Returns all the WFMS_Positions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId) {
		return getPersistence().findByworkflowId(workflowId);
	}

	/**
	* Returns a range of all the WFMS_Positions where workflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workflowId the workflow ID
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId, int start, int end) {
		return getPersistence().findByworkflowId(workflowId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where workflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workflowId the workflow ID
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByworkflowId(workflowId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where workflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workflowId the workflow ID
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByworkflowId(workflowId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByworkflowId_First(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByworkflowId_First(workflowId, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByworkflowId_First(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByworkflowId_First(workflowId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByworkflowId_Last(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByworkflowId_Last(workflowId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByworkflowId_Last(
		java.lang.String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByworkflowId_Last(workflowId, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByworkflowId_PrevAndNext(
		java.lang.String pId, java.lang.String workflowId,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByworkflowId_PrevAndNext(pId, workflowId,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where workflowId = &#63; from the database.
	*
	* @param workflowId the workflow ID
	*/
	public static void removeByworkflowId(java.lang.String workflowId) {
		getPersistence().removeByworkflowId(workflowId);
	}

	/**
	* Returns the number of WFMS_Positions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the number of matching WFMS_Positions
	*/
	public static int countByworkflowId(java.lang.String workflowId) {
		return getPersistence().countByworkflowId(workflowId);
	}

	/**
	* Returns all the WFMS_Positions where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName) {
		return getPersistence().findByDepartmentName(departmentName);
	}

	/**
	* Returns a range of all the WFMS_Positions where departmentName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentName the department name
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName, int start, int end) {
		return getPersistence().findByDepartmentName(departmentName, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where departmentName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentName the department name
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByDepartmentName(departmentName, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where departmentName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentName the department name
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDepartmentName(departmentName, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByDepartmentName_First(
		java.lang.String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByDepartmentName_First(departmentName, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByDepartmentName_First(
		java.lang.String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByDepartmentName_First(departmentName,
			orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByDepartmentName_Last(
		java.lang.String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByDepartmentName_Last(departmentName, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByDepartmentName_Last(
		java.lang.String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByDepartmentName_Last(departmentName, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByDepartmentName_PrevAndNext(
		java.lang.String pId, java.lang.String departmentName,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByDepartmentName_PrevAndNext(pId, departmentName,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where departmentName = &#63; from the database.
	*
	* @param departmentName the department name
	*/
	public static void removeByDepartmentName(java.lang.String departmentName) {
		getPersistence().removeByDepartmentName(departmentName);
	}

	/**
	* Returns the number of WFMS_Positions where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @return the number of matching WFMS_Positions
	*/
	public static int countByDepartmentName(java.lang.String departmentName) {
		return getPersistence().countByDepartmentName(departmentName);
	}

	/**
	* Returns all the WFMS_Positions where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo) {
		return getPersistence().findByReportsTo(reportsTo);
	}

	/**
	* Returns a range of all the WFMS_Positions where reportsTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportsTo the reports to
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo, int start, int end) {
		return getPersistence().findByReportsTo(reportsTo, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where reportsTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportsTo the reports to
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByReportsTo(reportsTo, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where reportsTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportsTo the reports to
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByReportsTo(reportsTo, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByReportsTo_First(
		java.lang.String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByReportsTo_First(reportsTo, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByReportsTo_First(
		java.lang.String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByReportsTo_First(reportsTo, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByReportsTo_Last(
		java.lang.String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByReportsTo_Last(reportsTo, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByReportsTo_Last(
		java.lang.String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByReportsTo_Last(reportsTo, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByReportsTo_PrevAndNext(
		java.lang.String pId, java.lang.String reportsTo,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByReportsTo_PrevAndNext(pId, reportsTo,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where reportsTo = &#63; from the database.
	*
	* @param reportsTo the reports to
	*/
	public static void removeByReportsTo(java.lang.String reportsTo) {
		getPersistence().removeByReportsTo(reportsTo);
	}

	/**
	* Returns the number of WFMS_Positions where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @return the number of matching WFMS_Positions
	*/
	public static int countByReportsTo(java.lang.String reportsTo) {
		return getPersistence().countByReportsTo(reportsTo);
	}

	/**
	* Returns all the WFMS_Positions where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover) {
		return getPersistence().findByNextApprover(nextApprover);
	}

	/**
	* Returns a range of all the WFMS_Positions where nextApprover LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextApprover the next approver
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover, int start, int end) {
		return getPersistence().findByNextApprover(nextApprover, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where nextApprover LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextApprover the next approver
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .findByNextApprover(nextApprover, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions where nextApprover LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nextApprover the next approver
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Positions
	*/
	public static List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByNextApprover(nextApprover, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByNextApprover_First(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByNextApprover_First(nextApprover, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByNextApprover_First(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByNextApprover_First(nextApprover, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position findByNextApprover_Last(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByNextApprover_Last(nextApprover, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public static WFMS_Position fetchByNextApprover_Last(
		java.lang.String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence()
				   .fetchByNextApprover_Last(nextApprover, orderByComparator);
	}

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position[] findByNextApprover_PrevAndNext(
		java.lang.String pId, java.lang.String nextApprover,
		OrderByComparator<WFMS_Position> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence()
				   .findByNextApprover_PrevAndNext(pId, nextApprover,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_Positions where nextApprover LIKE &#63; from the database.
	*
	* @param nextApprover the next approver
	*/
	public static void removeByNextApprover(java.lang.String nextApprover) {
		getPersistence().removeByNextApprover(nextApprover);
	}

	/**
	* Returns the number of WFMS_Positions where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the number of matching WFMS_Positions
	*/
	public static int countByNextApprover(java.lang.String nextApprover) {
		return getPersistence().countByNextApprover(nextApprover);
	}

	/**
	* Caches the WFMS_Position in the entity cache if it is enabled.
	*
	* @param wfms_Position the WFMS_Position
	*/
	public static void cacheResult(WFMS_Position wfms_Position) {
		getPersistence().cacheResult(wfms_Position);
	}

	/**
	* Caches the WFMS_Positions in the entity cache if it is enabled.
	*
	* @param wfms_Positions the WFMS_Positions
	*/
	public static void cacheResult(List<WFMS_Position> wfms_Positions) {
		getPersistence().cacheResult(wfms_Positions);
	}

	/**
	* Creates a new WFMS_Position with the primary key. Does not add the WFMS_Position to the database.
	*
	* @param pId the primary key for the new WFMS_Position
	* @return the new WFMS_Position
	*/
	public static WFMS_Position create(java.lang.String pId) {
		return getPersistence().create(pId);
	}

	/**
	* Removes the WFMS_Position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position that was removed
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position remove(java.lang.String pId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().remove(pId);
	}

	public static WFMS_Position updateImpl(WFMS_Position wfms_Position) {
		return getPersistence().updateImpl(wfms_Position);
	}

	/**
	* Returns the WFMS_Position with the primary key or throws a {@link NoSuchWFMS_PositionException} if it could not be found.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position findByPrimaryKey(java.lang.String pId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException {
		return getPersistence().findByPrimaryKey(pId);
	}

	/**
	* Returns the WFMS_Position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position, or <code>null</code> if a WFMS_Position with the primary key could not be found
	*/
	public static WFMS_Position fetchByPrimaryKey(java.lang.String pId) {
		return getPersistence().fetchByPrimaryKey(pId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_Position> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_Positions.
	*
	* @return the WFMS_Positions
	*/
	public static List<WFMS_Position> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_Positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @return the range of WFMS_Positions
	*/
	public static List<WFMS_Position> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Positions
	*/
	public static List<WFMS_Position> findAll(int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Positions
	* @param end the upper bound of the range of WFMS_Positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Positions
	*/
	public static List<WFMS_Position> findAll(int start, int end,
		OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_Positions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_Positions.
	*
	* @return the number of WFMS_Positions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WFMS_PositionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_PositionPersistence, WFMS_PositionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_PositionPersistence.class);
}