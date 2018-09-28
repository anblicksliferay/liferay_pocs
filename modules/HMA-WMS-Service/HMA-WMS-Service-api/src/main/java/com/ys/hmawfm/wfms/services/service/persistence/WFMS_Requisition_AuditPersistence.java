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

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Requisition_AuditException;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit;

/**
 * The persistence interface for the WFMS_Requisition_Audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_Requisition_AuditPersistenceImpl
 * @see WFMS_Requisition_AuditUtil
 * @generated
 */
@ProviderType
public interface WFMS_Requisition_AuditPersistence extends BasePersistence<WFMS_Requisition_Audit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WFMS_Requisition_AuditUtil} to access the WFMS_Requisition_Audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WFMS_Requisition_Audits where reqId = &#63;.
	*
	* @param reqId the req ID
	* @return the matching WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findByReqIdForAudit(
		java.lang.String reqId);

	/**
	* Returns a range of all the WFMS_Requisition_Audits where reqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reqId the req ID
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @return the range of matching WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findByReqIdForAudit(
		java.lang.String reqId, int start, int end);

	/**
	* Returns an ordered range of all the WFMS_Requisition_Audits where reqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reqId the req ID
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findByReqIdForAudit(
		java.lang.String reqId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_Requisition_Audits where reqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reqId the req ID
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findByReqIdForAudit(
		java.lang.String reqId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	*
	* @param reqId the req ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition_Audit
	* @throws NoSuchWFMS_Requisition_AuditException if a matching WFMS_Requisition_Audit could not be found
	*/
	public WFMS_Requisition_Audit findByReqIdForAudit_First(
		java.lang.String reqId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator)
		throws NoSuchWFMS_Requisition_AuditException;

	/**
	* Returns the first WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	*
	* @param reqId the req ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Requisition_Audit, or <code>null</code> if a matching WFMS_Requisition_Audit could not be found
	*/
	public WFMS_Requisition_Audit fetchByReqIdForAudit_First(
		java.lang.String reqId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator);

	/**
	* Returns the last WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	*
	* @param reqId the req ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition_Audit
	* @throws NoSuchWFMS_Requisition_AuditException if a matching WFMS_Requisition_Audit could not be found
	*/
	public WFMS_Requisition_Audit findByReqIdForAudit_Last(
		java.lang.String reqId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator)
		throws NoSuchWFMS_Requisition_AuditException;

	/**
	* Returns the last WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	*
	* @param reqId the req ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Requisition_Audit, or <code>null</code> if a matching WFMS_Requisition_Audit could not be found
	*/
	public WFMS_Requisition_Audit fetchByReqIdForAudit_Last(
		java.lang.String reqId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator);

	/**
	* Returns the WFMS_Requisition_Audits before and after the current WFMS_Requisition_Audit in the ordered set where reqId = &#63;.
	*
	* @param reqaId the primary key of the current WFMS_Requisition_Audit
	* @param reqId the req ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Requisition_Audit
	* @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	*/
	public WFMS_Requisition_Audit[] findByReqIdForAudit_PrevAndNext(
		java.lang.String reqaId, java.lang.String reqId,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator)
		throws NoSuchWFMS_Requisition_AuditException;

	/**
	* Removes all the WFMS_Requisition_Audits where reqId = &#63; from the database.
	*
	* @param reqId the req ID
	*/
	public void removeByReqIdForAudit(java.lang.String reqId);

	/**
	* Returns the number of WFMS_Requisition_Audits where reqId = &#63;.
	*
	* @param reqId the req ID
	* @return the number of matching WFMS_Requisition_Audits
	*/
	public int countByReqIdForAudit(java.lang.String reqId);

	/**
	* Caches the WFMS_Requisition_Audit in the entity cache if it is enabled.
	*
	* @param wfms_Requisition_Audit the WFMS_Requisition_Audit
	*/
	public void cacheResult(WFMS_Requisition_Audit wfms_Requisition_Audit);

	/**
	* Caches the WFMS_Requisition_Audits in the entity cache if it is enabled.
	*
	* @param wfms_Requisition_Audits the WFMS_Requisition_Audits
	*/
	public void cacheResult(
		java.util.List<WFMS_Requisition_Audit> wfms_Requisition_Audits);

	/**
	* Creates a new WFMS_Requisition_Audit with the primary key. Does not add the WFMS_Requisition_Audit to the database.
	*
	* @param reqaId the primary key for the new WFMS_Requisition_Audit
	* @return the new WFMS_Requisition_Audit
	*/
	public WFMS_Requisition_Audit create(java.lang.String reqaId);

	/**
	* Removes the WFMS_Requisition_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reqaId the primary key of the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit that was removed
	* @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	*/
	public WFMS_Requisition_Audit remove(java.lang.String reqaId)
		throws NoSuchWFMS_Requisition_AuditException;

	public WFMS_Requisition_Audit updateImpl(
		WFMS_Requisition_Audit wfms_Requisition_Audit);

	/**
	* Returns the WFMS_Requisition_Audit with the primary key or throws a {@link NoSuchWFMS_Requisition_AuditException} if it could not be found.
	*
	* @param reqaId the primary key of the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit
	* @throws NoSuchWFMS_Requisition_AuditException if a WFMS_Requisition_Audit with the primary key could not be found
	*/
	public WFMS_Requisition_Audit findByPrimaryKey(java.lang.String reqaId)
		throws NoSuchWFMS_Requisition_AuditException;

	/**
	* Returns the WFMS_Requisition_Audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reqaId the primary key of the WFMS_Requisition_Audit
	* @return the WFMS_Requisition_Audit, or <code>null</code> if a WFMS_Requisition_Audit with the primary key could not be found
	*/
	public WFMS_Requisition_Audit fetchByPrimaryKey(java.lang.String reqaId);

	@Override
	public java.util.Map<java.io.Serializable, WFMS_Requisition_Audit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the WFMS_Requisition_Audits.
	*
	* @return the WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findAll();

	/**
	* Returns a range of all the WFMS_Requisition_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @return the range of WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findAll(int start, int end);

	/**
	* Returns an ordered range of all the WFMS_Requisition_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator);

	/**
	* Returns an ordered range of all the WFMS_Requisition_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Requisition_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Requisition_Audits
	* @param end the upper bound of the range of WFMS_Requisition_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Requisition_Audits
	*/
	public java.util.List<WFMS_Requisition_Audit> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WFMS_Requisition_Audit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the WFMS_Requisition_Audits from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of WFMS_Requisition_Audits.
	*
	* @return the number of WFMS_Requisition_Audits
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}