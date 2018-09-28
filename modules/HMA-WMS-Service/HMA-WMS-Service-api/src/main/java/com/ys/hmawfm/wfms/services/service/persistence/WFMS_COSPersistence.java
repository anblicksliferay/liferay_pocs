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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;

/**
 * The persistence interface for the WFMS_COS service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_COSPersistenceImpl
 * @see WFMS_COSUtil
 * @generated
 */
@ProviderType
public interface WFMS_COSPersistence extends BasePersistence<WFMS_COS> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_COSUtil} to access the WFMS_COS persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WFMS_COSs where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId);

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
	public java.util.List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId, int start, int end);

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
	public java.util.List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findByAssoicateId(
		java.lang.String assoicateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByAssoicateId_First(java.lang.String assoicateId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByAssoicateId_First(java.lang.String assoicateId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByAssoicateId_Last(java.lang.String assoicateId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByAssoicateId_Last(java.lang.String assoicateId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where assoicateId = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param assoicateId the assoicate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findByAssoicateId_PrevAndNext(java.lang.String cosId,
		java.lang.String assoicateId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where assoicateId = &#63; from the database.
	*
	* @param assoicateId the assoicate ID
	*/
	public void removeByAssoicateId(java.lang.String assoicateId);

	/**
	* Returns the number of WFMS_COSs where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @return the number of matching WFMS_COSs
	*/
	public int countByAssoicateId(java.lang.String assoicateId);

	/**
	* Returns all the WFMS_COSs where action = &#63;.
	*
	* @param action the action
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findByAction(java.lang.String action);

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
	public java.util.List<WFMS_COS> findByAction(java.lang.String action,
		int start, int end);

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
	public java.util.List<WFMS_COS> findByAction(java.lang.String action,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findByAction(java.lang.String action,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByAction_First(java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByAction_First(java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByAction_Last(java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where action = &#63;.
	*
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByAction_Last(java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where action = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findByAction_PrevAndNext(java.lang.String cosId,
		java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where action = &#63; from the database.
	*
	* @param action the action
	*/
	public void removeByAction(java.lang.String action);

	/**
	* Returns the number of WFMS_COSs where action = &#63;.
	*
	* @param action the action
	* @return the number of matching WFMS_COSs
	*/
	public int countByAction(java.lang.String action);

	/**
	* Returns the WFMS_COS where cosId = &#63; or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	*
	* @param cosId the cos ID
	* @return the matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBycos(java.lang.String cosId)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the WFMS_COS where cosId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cosId the cos ID
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBycos(java.lang.String cosId);

	/**
	* Returns the WFMS_COS where cosId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cosId the cos ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBycos(java.lang.String cosId, boolean retrieveFromCache);

	/**
	* Removes the WFMS_COS where cosId = &#63; from the database.
	*
	* @param cosId the cos ID
	* @return the WFMS_COS that was removed
	*/
	public WFMS_COS removeBycos(java.lang.String cosId)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the number of WFMS_COSs where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @return the number of matching WFMS_COSs
	*/
	public int countBycos(java.lang.String cosId);

	/**
	* Returns all the WFMS_COSs where status = &#63;.
	*
	* @param status the status
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status);

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
	public java.util.List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end);

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
	public java.util.List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBypositionIdGetByStaus_First(java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBypositionIdGetByStaus_First(java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBypositionIdGetByStaus_Last(java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBypositionIdGetByStaus_Last(java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where status = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findBypositionIdGetByStaus_PrevAndNext(
		java.lang.String cosId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeBypositionIdGetByStaus(java.lang.String status);

	/**
	* Returns the number of WFMS_COSs where status = &#63;.
	*
	* @param status the status
	* @return the number of matching WFMS_COSs
	*/
	public int countBypositionIdGetByStaus(java.lang.String status);

	/**
	* Returns all the WFMS_COSs where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber);

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
	public java.util.List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber, int start, int end);

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
	public java.util.List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findBycosIdGetByPosId(
		java.lang.String positionNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBycosIdGetByPosId_First(
		java.lang.String positionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBycosIdGetByPosId_First(
		java.lang.String positionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBycosIdGetByPosId_Last(
		java.lang.String positionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBycosIdGetByPosId_Last(
		java.lang.String positionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where positionNumber = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param positionNumber the position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findBycosIdGetByPosId_PrevAndNext(
		java.lang.String cosId, java.lang.String positionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where positionNumber = &#63; from the database.
	*
	* @param positionNumber the position number
	*/
	public void removeBycosIdGetByPosId(java.lang.String positionNumber);

	/**
	* Returns the number of WFMS_COSs where positionNumber = &#63;.
	*
	* @param positionNumber the position number
	* @return the number of matching WFMS_COSs
	*/
	public int countBycosIdGetByPosId(java.lang.String positionNumber);

	/**
	* Returns the WFMS_COS where assoicateId = &#63; or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	*
	* @param assoicateId the assoicate ID
	* @return the matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByassociateId(java.lang.String assoicateId)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the WFMS_COS where assoicateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assoicateId the assoicate ID
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByassociateId(java.lang.String assoicateId);

	/**
	* Returns the WFMS_COS where assoicateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assoicateId the assoicate ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByassociateId(java.lang.String assoicateId,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_COS where assoicateId = &#63; from the database.
	*
	* @param assoicateId the assoicate ID
	* @return the WFMS_COS that was removed
	*/
	public WFMS_COS removeByassociateId(java.lang.String assoicateId)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the number of WFMS_COSs where assoicateId = &#63;.
	*
	* @param assoicateId the assoicate ID
	* @return the number of matching WFMS_COSs
	*/
	public int countByassociateId(java.lang.String assoicateId);

	/**
	* Returns all the WFMS_COSs where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber);

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
	public java.util.List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber, int start, int end);

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
	public java.util.List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findBynewPositionNumber(
		java.lang.String newPositionNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBynewPositionNumber_First(
		java.lang.String newPositionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBynewPositionNumber_First(
		java.lang.String newPositionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findBynewPositionNumber_Last(
		java.lang.String newPositionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchBynewPositionNumber_Last(
		java.lang.String newPositionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where newPositionNumber = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param newPositionNumber the new position number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findBynewPositionNumber_PrevAndNext(
		java.lang.String cosId, java.lang.String newPositionNumber,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where newPositionNumber = &#63; from the database.
	*
	* @param newPositionNumber the new position number
	*/
	public void removeBynewPositionNumber(java.lang.String newPositionNumber);

	/**
	* Returns the number of WFMS_COSs where newPositionNumber = &#63;.
	*
	* @param newPositionNumber the new position number
	* @return the number of matching WFMS_COSs
	*/
	public int countBynewPositionNumber(java.lang.String newPositionNumber);

	/**
	* Returns all the WFMS_COSs where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover);

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
	public java.util.List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover, int start, int end);

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
	public java.util.List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findByNextApprover(
		java.lang.String nextApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByNextApprover_First(java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByNextApprover_First(java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByNextApprover_Last(java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByNextApprover_Last(java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where nextApprover LIKE &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param nextApprover the next approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findByNextApprover_PrevAndNext(java.lang.String cosId,
		java.lang.String nextApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where nextApprover LIKE &#63; from the database.
	*
	* @param nextApprover the next approver
	*/
	public void removeByNextApprover(java.lang.String nextApprover);

	/**
	* Returns the number of WFMS_COSs where nextApprover LIKE &#63;.
	*
	* @param nextApprover the next approver
	* @return the number of matching WFMS_COSs
	*/
	public int countByNextApprover(java.lang.String nextApprover);

	/**
	* Returns all the WFMS_COSs where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the matching WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover);

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
	public java.util.List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end);

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
	public java.util.List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the first WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the last WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS
	* @throws NoSuchWFMS_COSException if a matching WFMS_COS could not be found
	*/
	public WFMS_COS findByRoleOfApprover_Last(java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the last WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS, or <code>null</code> if a matching WFMS_COS could not be found
	*/
	public WFMS_COS fetchByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

	/**
	* Returns the WFMS_COSs before and after the current WFMS_COS in the ordered set where roleOfApprover = &#63;.
	*
	* @param cosId the primary key of the current WFMS_COS
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS[] findByRoleOfApprover_PrevAndNext(java.lang.String cosId,
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator)
		throws NoSuchWFMS_COSException;

	/**
	* Removes all the WFMS_COSs where roleOfApprover = &#63; from the database.
	*
	* @param roleOfApprover the role of approver
	*/
	public void removeByRoleOfApprover(java.lang.String roleOfApprover);

	/**
	* Returns the number of WFMS_COSs where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the number of matching WFMS_COSs
	*/
	public int countByRoleOfApprover(java.lang.String roleOfApprover);

	/**
	* Caches the WFMS_COS in the entity cache if it is enabled.
	*
	* @param wfms_cos the WFMS_COS
	*/
	public void cacheResult(WFMS_COS wfms_cos);

	/**
	* Caches the WFMS_COSs in the entity cache if it is enabled.
	*
	* @param wfms_coses the WFMS_COSs
	*/
	public void cacheResult(java.util.List<WFMS_COS> wfms_coses);

	/**
	* Creates a new WFMS_COS with the primary key. Does not add the WFMS_COS to the database.
	*
	* @param cosId the primary key for the new WFMS_COS
	* @return the new WFMS_COS
	*/
	public WFMS_COS create(java.lang.String cosId);

	/**
	* Removes the WFMS_COS with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS that was removed
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS remove(java.lang.String cosId)
		throws NoSuchWFMS_COSException;

	public WFMS_COS updateImpl(WFMS_COS wfms_cos);

	/**
	* Returns the WFMS_COS with the primary key or throws a {@link NoSuchWFMS_COSException} if it could not be found.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS
	* @throws NoSuchWFMS_COSException if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS findByPrimaryKey(java.lang.String cosId)
		throws NoSuchWFMS_COSException;

	/**
	* Returns the WFMS_COS with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cosId the primary key of the WFMS_COS
	* @return the WFMS_COS, or <code>null</code> if a WFMS_COS with the primary key could not be found
	*/
	public WFMS_COS fetchByPrimaryKey(java.lang.String cosId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_COS> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_COSs.
	*
	* @return the WFMS_COSs
	*/
	public java.util.List<WFMS_COS> findAll();

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
	public java.util.List<WFMS_COS> findAll(int start, int end);

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
	public java.util.List<WFMS_COS> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator);

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
	public java.util.List<WFMS_COS> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_COS> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_COSs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_COSs.
	*
	* @return the number of WFMS_COSs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}