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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;

/**
 * The persistence interface for the WFMS_Requisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_RequisitionPersistenceImpl
 * @see WFMS_RequisitionUtil
 * @generated
 */
@ProviderType
public interface WFMS_RequisitionPersistence extends BasePersistence<WFMS_Requisition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_RequisitionUtil} to access the WFMS_Requisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId);

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
	public java.util.List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId, int start, int end);

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
	public java.util.List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findByStatus_Pid_Colllection(
		java.lang.String status, java.lang.String rId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByStatus_Pid_Colllection_First(
		java.lang.String status, java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByStatus_Pid_Colllection_First(
		java.lang.String status, java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByStatus_Pid_Colllection_Last(
		java.lang.String status, java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByStatus_Pid_Colllection_Last(
		java.lang.String status, java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public WFMS_Requisition[] findByStatus_Pid_Colllection_PrevAndNext(
		java.lang.String rwfId, java.lang.String status, java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where status = &#63; and rId = &#63; from the database.
	*
	* @param status the status
	* @param rId the r ID
	*/
	public void removeByStatus_Pid_Colllection(java.lang.String status,
		java.lang.String rId);

	/**
	* Returns the number of WFMS_Requisitions where status = &#63; and rId = &#63;.
	*
	* @param status the status
	* @param rId the r ID
	* @return the number of matching WFMS_Requisitions
	*/
	public int countByStatus_Pid_Colllection(java.lang.String status,
		java.lang.String rId);

	/**
	* Returns the WFMS_Requisition where rwfId = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param rwfId the rwf ID
	* @return the matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByrequisition(java.lang.String rwfId)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the WFMS_Requisition where rwfId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rwfId the rwf ID
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByrequisition(java.lang.String rwfId);

	/**
	* Returns the WFMS_Requisition where rwfId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rwfId the rwf ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByrequisition(java.lang.String rwfId,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_Requisition where rwfId = &#63; from the database.
	*
	* @param rwfId the rwf ID
	* @return the WFMS_Requisition that was removed
	*/
	public WFMS_Requisition removeByrequisition(java.lang.String rwfId)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the number of WFMS_Requisitions where rwfId = &#63;.
	*
	* @param rwfId the rwf ID
	* @return the number of matching WFMS_Requisitions
	*/
	public int countByrequisition(java.lang.String rwfId);

	/**
	* Returns the WFMS_Requisition where rId = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param rId the r ID
	* @return the matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByposition(java.lang.String rId)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the WFMS_Requisition where rId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param rId the r ID
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByposition(java.lang.String rId);

	/**
	* Returns the WFMS_Requisition where rId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param rId the r ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByposition(java.lang.String rId,
		boolean retrieveFromCache);

	/**
	* Removes the WFMS_Requisition where rId = &#63; from the database.
	*
	* @param rId the r ID
	* @return the WFMS_Requisition that was removed
	*/
	public WFMS_Requisition removeByposition(java.lang.String rId)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the number of WFMS_Requisitions where rId = &#63;.
	*
	* @param rId the r ID
	* @return the number of matching WFMS_Requisitions
	*/
	public int countByposition(java.lang.String rId);

	/**
	* Returns all the WFMS_Requisitions where Number = &#63;.
	*
	* @param Number the number
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number);

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
	public java.util.List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number, int start, int end);

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
	public java.util.List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findBypositionnumber(
		java.lang.String Number, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionnumber_First(
		java.lang.String Number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionnumber_First(
		java.lang.String Number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionnumber_Last(java.lang.String Number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionnumber_Last(
		java.lang.String Number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where Number = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param Number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findBypositionnumber_PrevAndNext(
		java.lang.String rwfId, java.lang.String Number,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where Number = &#63; from the database.
	*
	* @param Number the number
	*/
	public void removeBypositionnumber(java.lang.String Number);

	/**
	* Returns the number of WFMS_Requisitions where Number = &#63;.
	*
	* @param Number the number
	* @return the number of matching WFMS_Requisitions
	*/
	public int countBypositionnumber(java.lang.String Number);

	/**
	* Returns all the WFMS_Requisitions where rId = &#63;.
	*
	* @param rId the r ID
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findBypositionId(
		java.lang.String rId);

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
	public java.util.List<WFMS_Requisition> findBypositionId(
		java.lang.String rId, int start, int end);

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
	public java.util.List<WFMS_Requisition> findBypositionId(
		java.lang.String rId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findBypositionId(
		java.lang.String rId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionId_First(java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionId_First(java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionId_Last(java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionId_Last(java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where rId = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param rId the r ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findBypositionId_PrevAndNext(
		java.lang.String rwfId, java.lang.String rId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where rId = &#63; from the database.
	*
	* @param rId the r ID
	*/
	public void removeBypositionId(java.lang.String rId);

	/**
	* Returns the number of WFMS_Requisitions where rId = &#63;.
	*
	* @param rId the r ID
	* @return the number of matching WFMS_Requisitions
	*/
	public int countBypositionId(java.lang.String rId);

	/**
	* Returns all the WFMS_Requisitions where status = &#63;.
	*
	* @param status the status
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status);

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
	public java.util.List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end);

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
	public java.util.List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findBypositionIdGetByStaus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionIdGetByStaus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionIdGetByStaus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionIdGetByStaus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionIdGetByStaus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where status = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findBypositionIdGetByStaus_PrevAndNext(
		java.lang.String rwfId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeBypositionIdGetByStaus(java.lang.String status);

	/**
	* Returns the number of WFMS_Requisitions where status = &#63;.
	*
	* @param status the status
	* @return the number of matching WFMS_Requisitions
	*/
	public int countBypositionIdGetByStaus(java.lang.String status);

	/**
	* Returns all the WFMS_Requisitions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findBydummy(java.lang.String dummy);

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
	public java.util.List<WFMS_Requisition> findBydummy(
		java.lang.String dummy, int start, int end);

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
	public java.util.List<WFMS_Requisition> findBydummy(
		java.lang.String dummy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findBydummy(
		java.lang.String dummy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBydummy_First(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBydummy_First(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBydummy_Last(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBydummy_Last(java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where dummy = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param dummy the dummy
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findBydummy_PrevAndNext(java.lang.String rwfId,
		java.lang.String dummy,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where dummy = &#63; from the database.
	*
	* @param dummy the dummy
	*/
	public void removeBydummy(java.lang.String dummy);

	/**
	* Returns the number of WFMS_Requisitions where dummy = &#63;.
	*
	* @param dummy the dummy
	* @return the number of matching WFMS_Requisitions
	*/
	public int countBydummy(java.lang.String dummy);

	/**
	* Returns all the WFMS_Requisitions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId);

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
	public java.util.List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId, int start, int end);

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
	public java.util.List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findByworkflowId(
		java.lang.String workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByworkflowId_First(
		java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByworkflowId_First(
		java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByworkflowId_Last(java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByworkflowId_Last(
		java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where workflowId = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param workflowId the workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findByworkflowId_PrevAndNext(
		java.lang.String rwfId, java.lang.String workflowId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where workflowId = &#63; from the database.
	*
	* @param workflowId the workflow ID
	*/
	public void removeByworkflowId(java.lang.String workflowId);

	/**
	* Returns the number of WFMS_Requisitions where workflowId = &#63;.
	*
	* @param workflowId the workflow ID
	* @return the number of matching WFMS_Requisitions
	*/
	public int countByworkflowId(java.lang.String workflowId);

	/**
	* Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber);

	/**
	* Returns the WFMS_Requisition where Number = &#63; and associatenumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber, boolean retrieveFromCache);

	/**
	* Removes the WFMS_Requisition where Number = &#63; and associatenumber = &#63; from the database.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the WFMS_Requisition that was removed
	*/
	public WFMS_Requisition removeBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the number of WFMS_Requisitions where Number = &#63; and associatenumber = &#63;.
	*
	* @param Number the number
	* @param associatenumber the associatenumber
	* @return the number of matching WFMS_Requisitions
	*/
	public int countBypositionassociate(java.lang.String Number,
		java.lang.String associatenumber);

	/**
	* Returns all the WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove);

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
	public java.util.List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove, int start, int end);

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
	public java.util.List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findByNextApprove(
		java.lang.String nextapprove, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByNextApprove_First(
		java.lang.String nextapprove,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByNextApprove_First(
		java.lang.String nextapprove,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByNextApprove_Last(
		java.lang.String nextapprove,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByNextApprove_Last(
		java.lang.String nextapprove,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where nextapprove LIKE &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param nextapprove the nextapprove
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findByNextApprove_PrevAndNext(
		java.lang.String rwfId, java.lang.String nextapprove,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where nextapprove LIKE &#63; from the database.
	*
	* @param nextapprove the nextapprove
	*/
	public void removeByNextApprove(java.lang.String nextapprove);

	/**
	* Returns the number of WFMS_Requisitions where nextapprove LIKE &#63;.
	*
	* @param nextapprove the nextapprove
	* @return the number of matching WFMS_Requisitions
	*/
	public int countByNextApprove(java.lang.String nextapprove);

	/**
	* Returns all the WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the matching WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover);

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
	public java.util.List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end);

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
	public java.util.List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findByRoleOfApprover(
		java.lang.String roleOfApprover, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the first WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByRoleOfApprover_First(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the last WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition findByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the last WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition, or <code>null</code> if a matching WFMS_Requisition could not be found
	*/
	public WFMS_Requisition fetchByRoleOfApprover_Last(
		java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

	/**
	* Returns the WFMS_Requisitions before and after the current WFMS_Requisition in the ordered set where roleOfApprover = &#63;.
	*
	* @param rwfId the primary key of the current WFMS_Requisition
	* @param roleOfApprover the role of approver
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition[] findByRoleOfApprover_PrevAndNext(
		java.lang.String rwfId, java.lang.String roleOfApprover,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Removes all the WFMS_Requisitions where roleOfApprover = &#63; from the database.
	*
	* @param roleOfApprover the role of approver
	*/
	public void removeByRoleOfApprover(java.lang.String roleOfApprover);

	/**
	* Returns the number of WFMS_Requisitions where roleOfApprover = &#63;.
	*
	* @param roleOfApprover the role of approver
	* @return the number of matching WFMS_Requisitions
	*/
	public int countByRoleOfApprover(java.lang.String roleOfApprover);

	/**
	* Caches the WFMS_Requisition in the entity cache if it is enabled.
	*
	* @param wfms_Requisition the WFMS_Requisition
	*/
	public void cacheResult(WFMS_Requisition wfms_Requisition);

	/**
	* Caches the WFMS_Requisitions in the entity cache if it is enabled.
	*
	* @param wfms_Requisitions the WFMS_Requisitions
	*/
	public void cacheResult(java.util.List<WFMS_Requisition> wfms_Requisitions);

	/**
	* Creates a new WFMS_Requisition with the primary key. Does not add the WFMS_Requisition to the database.
	*
	* @param rwfId the primary key for the new WFMS_Requisition
	* @return the new WFMS_Requisition
	*/
	public WFMS_Requisition create(java.lang.String rwfId);

	/**
	* Removes the WFMS_Requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition that was removed
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition remove(java.lang.String rwfId)
		throws NoSuchWFMS_RequisitionException;

	public WFMS_Requisition updateImpl(WFMS_Requisition wfms_Requisition);

	/**
	* Returns the WFMS_Requisition with the primary key or throws a {@link NoSuchWFMS_RequisitionException} if it could not be found.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition
	* @throws NoSuchWFMS_RequisitionException if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition findByPrimaryKey(java.lang.String rwfId)
		throws NoSuchWFMS_RequisitionException;

	/**
	* Returns the WFMS_Requisition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rwfId the primary key of the WFMS_Requisition
	* @return the WFMS_Requisition, or <code>null</code> if a WFMS_Requisition with the primary key could not be found
	*/
	public WFMS_Requisition fetchByPrimaryKey(java.lang.String rwfId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_Requisition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_Requisitions.
	*
	* @return the WFMS_Requisitions
	*/
	public java.util.List<WFMS_Requisition> findAll();

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
	public java.util.List<WFMS_Requisition> findAll(int start, int end);

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
	public java.util.List<WFMS_Requisition> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator);

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
	public java.util.List<WFMS_Requisition> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_Requisitions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_Requisitions.
	*
	* @return the number of WFMS_Requisitions
	*/
	public int countAll();
}