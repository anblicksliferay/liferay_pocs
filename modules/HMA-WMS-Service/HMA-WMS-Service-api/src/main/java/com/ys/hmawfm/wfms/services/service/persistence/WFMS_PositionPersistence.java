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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;

/**
 * The persistence interface for the WFMS_Position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_PositionPersistenceImpl
 * @see WFMS_PositionUtil
 * @generated
 */
@ProviderType
public interface WFMS_PositionPersistence extends BasePersistence<WFMS_Position> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_PositionUtil} to access the WFMS_Position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WFMS_Positions where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId);

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
	public java.util.List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId, int start, int end);

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
	public java.util.List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByrefPosId(
		java.lang.String refPosId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByrefPosId_First(java.lang.String refPosId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByrefPosId_First(java.lang.String refPosId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByrefPosId_Last(java.lang.String refPosId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByrefPosId_Last(java.lang.String refPosId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where refPosId = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param refPosId the ref pos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByrefPosId_PrevAndNext(java.lang.String pId,
		java.lang.String refPosId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where refPosId = &#63; from the database.
	*
	* @param refPosId the ref pos ID
	*/
	public void removeByrefPosId(java.lang.String refPosId);

	/**
	* Returns the number of WFMS_Positions where refPosId = &#63;.
	*
	* @param refPosId the ref pos ID
	* @return the number of matching WFMS_Positions
	*/
	public int countByrefPosId(java.lang.String refPosId);

	/**
	* Returns all the WFMS_Positions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findBydummy(java.lang.String dummy);

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
	public java.util.List<WFMS_Position> findBydummy(java.lang.String dummy,
		int start, int end);

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
	public java.util.List<WFMS_Position> findBydummy(java.lang.String dummy,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findBydummy(java.lang.String dummy,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findBydummy_First(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchBydummy_First(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findBydummy_Last(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchBydummy_Last(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where dummy = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findBydummy_PrevAndNext(java.lang.String pId,
		java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where dummy = &#63; from the database.
	*
	* @param dummy the dummy
	*/
	public void removeBydummy(java.lang.String dummy);

	/**
	* Returns the number of WFMS_Positions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the number of matching WFMS_Positions
	*/
	public int countBydummy(java.lang.String dummy);

	/**
	* Returns all the WFMS_Positions where number = &#63;.
	*
	* @param number the number
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByNumber(java.lang.String number);

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
	public java.util.List<WFMS_Position> findByNumber(java.lang.String number,
		int start, int end);

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
	public java.util.List<WFMS_Position> findByNumber(java.lang.String number,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByNumber(java.lang.String number,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByNumber_First(java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByNumber_First(java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByNumber_Last(java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByNumber_Last(java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where number = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByNumber_PrevAndNext(java.lang.String pId,
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where number = &#63; from the database.
	*
	* @param number the number
	*/
	public void removeByNumber(java.lang.String number);

	/**
	* Returns the number of WFMS_Positions where number = &#63;.
	*
	* @param number the number
	* @return the number of matching WFMS_Positions
	*/
	public int countByNumber(java.lang.String number);

	/**
	* Returns all the WFMS_Positions where category = &#63;.
	*
	* @param category the category
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByCategory(
		java.lang.String category);

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
	public java.util.List<WFMS_Position> findByCategory(
		java.lang.String category, int start, int end);

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
	public java.util.List<WFMS_Position> findByCategory(
		java.lang.String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByCategory(
		java.lang.String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByCategory_First(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByCategory_First(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByCategory_Last(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByCategory_Last(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where category = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByCategory_PrevAndNext(java.lang.String pId,
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where category = &#63; from the database.
	*
	* @param category the category
	*/
	public void removeByCategory(java.lang.String category);

	/**
	* Returns the number of WFMS_Positions where category = &#63;.
	*
	* @param category the category
	* @return the number of matching WFMS_Positions
	*/
	public int countByCategory(java.lang.String category);

	/**
	* Returns all the WFMS_Positions where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber);

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
	public java.util.List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber, int start, int end);

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
	public java.util.List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByAssociateNumber(
		java.lang.String associateNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByAssociateNumber_First(
		java.lang.String associateNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByAssociateNumber_First(
		java.lang.String associateNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByAssociateNumber_Last(
		java.lang.String associateNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByAssociateNumber_Last(
		java.lang.String associateNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where associateNumber = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param associateNumber the associate number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByAssociateNumber_PrevAndNext(
		java.lang.String pId, java.lang.String associateNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where associateNumber = &#63; from the database.
	*
	* @param associateNumber the associate number
	*/
	public void removeByAssociateNumber(java.lang.String associateNumber);

	/**
	* Returns the number of WFMS_Positions where associateNumber = &#63;.
	*
	* @param associateNumber the associate number
	* @return the number of matching WFMS_Positions
	*/
	public int countByAssociateNumber(java.lang.String associateNumber);

	/**
	* Returns all the WFMS_Positions where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq);

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
	public java.util.List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq, int start, int end);

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
	public java.util.List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByautoGenerateReq(
		java.lang.String autoGenerateReq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByautoGenerateReq_First(
		java.lang.String autoGenerateReq,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByautoGenerateReq_First(
		java.lang.String autoGenerateReq,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByautoGenerateReq_Last(
		java.lang.String autoGenerateReq,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByautoGenerateReq_Last(
		java.lang.String autoGenerateReq,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where autoGenerateReq = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param autoGenerateReq the auto generate req
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByautoGenerateReq_PrevAndNext(
		java.lang.String pId, java.lang.String autoGenerateReq,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where autoGenerateReq = &#63; from the database.
	*
	* @param autoGenerateReq the auto generate req
	*/
	public void removeByautoGenerateReq(java.lang.String autoGenerateReq);

	/**
	* Returns the number of WFMS_Positions where autoGenerateReq = &#63;.
	*
	* @param autoGenerateReq the auto generate req
	* @return the number of matching WFMS_Positions
	*/
	public int countByautoGenerateReq(java.lang.String autoGenerateReq);

	/**
	* Returns all the WFMS_Positions where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy);

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
	public java.util.List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy, int start, int end);

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
	public java.util.List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByCreatedBy(
		java.lang.String createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByCreatedBy_First(java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByCreatedBy_First(java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByCreatedBy_Last(java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByCreatedBy_Last(java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where createdBy = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByCreatedBy_PrevAndNext(java.lang.String pId,
		java.lang.String createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	*/
	public void removeByCreatedBy(java.lang.String createdBy);

	/**
	* Returns the number of WFMS_Positions where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching WFMS_Positions
	*/
	public int countByCreatedBy(java.lang.String createdBy);

	/**
	* Returns the WFMS_Position where pId = &#63; or throws a {@link NoSuchWFMS_PositionException} if it could not be found.
	*
	* @param pId the p ID
	* @return the matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByposition(java.lang.String pId)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the WFMS_Position where pId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pId the p ID
	* @return the matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByposition(java.lang.String pId);

	/**
	* Returns the WFMS_Position where pId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pId the p ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByposition(java.lang.String pId,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_Position where pId = &#63; from the database.
	*
	* @param pId the p ID
	* @return the WFMS_Position that was removed
	*/
	public WFMS_Position removeByposition(java.lang.String pId)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the number of WFMS_Positions where pId = &#63;.
	*
	* @param pId the p ID
	* @return the number of matching WFMS_Positions
	*/
	public int countByposition(java.lang.String pId);

	/**
	* Returns all the WFMS_Positions where status = &#63;.
	*
	* @param status the status
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status);

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
	public java.util.List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end);

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
	public java.util.List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findBypositionIdGetByStaus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchBypositionIdGetByStaus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findBypositionIdGetByStaus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchBypositionIdGetByStaus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where status = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findBypositionIdGetByStaus_PrevAndNext(
		java.lang.String pId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeBypositionIdGetByStaus(java.lang.String status);

	/**
	* Returns the number of WFMS_Positions where status = &#63;.
	*
	* @param status the status
	* @return the number of matching WFMS_Positions
	*/
	public int countBypositionIdGetByStaus(java.lang.String status);

	/**
	* Returns all the WFMS_Positions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId);

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
	public java.util.List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId, int start, int end);

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
	public java.util.List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByworkflowId_First(java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByworkflowId_First(java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByworkflowId_Last(java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByworkflowId_Last(java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where workflowId = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByworkflowId_PrevAndNext(java.lang.String pId,
		java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where workflowId = &#63; from the database.
	*
	* @param workflowId the workflow ID
	*/
	public void removeByworkflowId(java.lang.String workflowId);

	/**
	* Returns the number of WFMS_Positions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the number of matching WFMS_Positions
	*/
	public int countByworkflowId(java.lang.String workflowId);

	/**
	* Returns all the WFMS_Positions where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName);

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
	public java.util.List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName, int start, int end);

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
	public java.util.List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByDepartmentName(
		java.lang.String departmentName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByDepartmentName_First(
		java.lang.String departmentName,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByDepartmentName_First(
		java.lang.String departmentName,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByDepartmentName_Last(
		java.lang.String departmentName,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByDepartmentName_Last(
		java.lang.String departmentName,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where departmentName = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByDepartmentName_PrevAndNext(
		java.lang.String pId, java.lang.String departmentName,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where departmentName = &#63; from the database.
	*
	* @param departmentName the department name
	*/
	public void removeByDepartmentName(java.lang.String departmentName);

	/**
	* Returns the number of WFMS_Positions where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @return the number of matching WFMS_Positions
	*/
	public int countByDepartmentName(java.lang.String departmentName);

	/**
	* Returns all the WFMS_Positions where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo);

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
	public java.util.List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo, int start, int end);

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
	public java.util.List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByReportsTo(
		java.lang.String reportsTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByReportsTo_First(java.lang.String reportsTo,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByReportsTo_First(java.lang.String reportsTo,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByReportsTo_Last(java.lang.String reportsTo,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByReportsTo_Last(java.lang.String reportsTo,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where reportsTo = &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param reportsTo the reports to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByReportsTo_PrevAndNext(java.lang.String pId,
		java.lang.String reportsTo,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where reportsTo = &#63; from the database.
	*
	* @param reportsTo the reports to
	*/
	public void removeByReportsTo(java.lang.String reportsTo);

	/**
	* Returns the number of WFMS_Positions where reportsTo = &#63;.
	*
	* @param reportsTo the reports to
	* @return the number of matching WFMS_Positions
	*/
	public int countByReportsTo(java.lang.String reportsTo);

	/**
	* Returns all the WFMS_Positions where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the matching WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover);

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
	public java.util.List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover, int start, int end);

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
	public java.util.List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByNextApprover_First(
		java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the first WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByNextApprover_First(
		java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the last WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position
	* @throws NoSuchWFMS_PositionException if a matching WFMS_Position could not be found
	*/
	public WFMS_Position findByNextApprover_Last(
		java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the last WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position, or <code>null</code> if a matching WFMS_Position could not be found
	*/
	public WFMS_Position fetchByNextApprover_Last(
		java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

	/**
	* Returns the WFMS_Positions before and after the current WFMS_Position in the ordered set where nextApprover LIKE &#63;.
	*
	* @param pId the primary key of the current WFMS_Position
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position[] findByNextApprover_PrevAndNext(
		java.lang.String pId, java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator)
		throws NoSuchWFMS_PositionException;

	/**
	* Removes all the WFMS_Positions where nextApprover LIKE &#63; from the database.
	*
	* @param nextApprover the next approver
	*/
	public void removeByNextApprover(java.lang.String nextApprover);

	/**
	* Returns the number of WFMS_Positions where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the number of matching WFMS_Positions
	*/
	public int countByNextApprover(java.lang.String nextApprover);

	/**
	* Caches the WFMS_Position in the entity cache if it is enabled.
	*
	* @param wfms_Position the WFMS_Position
	*/
	public void cacheResult(WFMS_Position wfms_Position);

	/**
	* Caches the WFMS_Positions in the entity cache if it is enabled.
	*
	* @param wfms_Positions the WFMS_Positions
	*/
	public void cacheResult(java.util.List<WFMS_Position> wfms_Positions);

	/**
	* Creates a new WFMS_Position with the primary key. Does not add the WFMS_Position to the database.
	*
	* @param pId the primary key for the new WFMS_Position
	* @return the new WFMS_Position
	*/
	public WFMS_Position create(java.lang.String pId);

	/**
	* Removes the WFMS_Position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position that was removed
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position remove(java.lang.String pId)
		throws NoSuchWFMS_PositionException;

	public WFMS_Position updateImpl(WFMS_Position wfms_Position);

	/**
	* Returns the WFMS_Position with the primary key or throws a {@link NoSuchWFMS_PositionException} if it could not be found.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position
	* @throws NoSuchWFMS_PositionException if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position findByPrimaryKey(java.lang.String pId)
		throws NoSuchWFMS_PositionException;

	/**
	* Returns the WFMS_Position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pId the primary key of the WFMS_Position
	* @return the WFMS_Position, or <code>null</code> if a WFMS_Position with the primary key could not be found
	*/
	public WFMS_Position fetchByPrimaryKey(java.lang.String pId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_Position> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_Positions.
	*
	* @return the WFMS_Positions
	*/
	public java.util.List<WFMS_Position> findAll();

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
	public java.util.List<WFMS_Position> findAll(int start, int end);

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
	public java.util.List<WFMS_Position> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator);

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
	public java.util.List<WFMS_Position> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Position> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_Positions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_Positions.
	*
	* @return the number of WFMS_Positions
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}