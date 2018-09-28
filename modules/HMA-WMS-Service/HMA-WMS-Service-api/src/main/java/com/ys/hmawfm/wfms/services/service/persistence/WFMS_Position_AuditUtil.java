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

import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_Position_Audit service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_Position_AuditPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Position_AuditPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_Position_AuditPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_Position_AuditUtil {
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
	public static void clearCache(WFMS_Position_Audit wfms_Position_Audit) {
		getPersistence().clearCache(wfms_Position_Audit);
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
	public static List<WFMS_Position_Audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_Position_Audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_Position_Audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_Position_Audit update(
		WFMS_Position_Audit wfms_Position_Audit) {
		return getPersistence().update(wfms_Position_Audit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_Position_Audit update(
		WFMS_Position_Audit wfms_Position_Audit, ServiceContext serviceContext) {
		return getPersistence().update(wfms_Position_Audit, serviceContext);
	}

	/**
	* Returns all the WFMS_Position_Audits where pId = &#63;.
	*
	* @param pId the p ID
	* @return the matching WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findByPosIdForAudit(
		java.lang.String pId) {
		return getPersistence().findByPosIdForAudit(pId);
	}

	/**
	* Returns a range of all the WFMS_Position_Audits where pId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pId the p ID
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @return the range of matching WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findByPosIdForAudit(
		java.lang.String pId, int start, int end) {
		return getPersistence().findByPosIdForAudit(pId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Position_Audits where pId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pId the p ID
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findByPosIdForAudit(
		java.lang.String pId, int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return getPersistence()
				   .findByPosIdForAudit(pId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Position_Audits where pId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pId the p ID
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findByPosIdForAudit(
		java.lang.String pId, int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPosIdForAudit(pId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_Position_Audit in the ordered set where pId = &#63;.
	*
	* @param pId the p ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position_Audit
	* @throws NoSuchWFMS_Position_AuditException if a matching WFMS_Position_Audit could not be found
	*/
	public static WFMS_Position_Audit findByPosIdForAudit_First(
		java.lang.String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Position_AuditException {
		return getPersistence().findByPosIdForAudit_First(pId, orderByComparator);
	}

	/**
	* Returns the first WFMS_Position_Audit in the ordered set where pId = &#63;.
	*
	* @param pId the p ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_Position_Audit, or <code>null</code> if a matching WFMS_Position_Audit could not be found
	*/
	public static WFMS_Position_Audit fetchByPosIdForAudit_First(
		java.lang.String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return getPersistence()
				   .fetchByPosIdForAudit_First(pId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position_Audit in the ordered set where pId = &#63;.
	*
	* @param pId the p ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position_Audit
	* @throws NoSuchWFMS_Position_AuditException if a matching WFMS_Position_Audit could not be found
	*/
	public static WFMS_Position_Audit findByPosIdForAudit_Last(
		java.lang.String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Position_AuditException {
		return getPersistence().findByPosIdForAudit_Last(pId, orderByComparator);
	}

	/**
	* Returns the last WFMS_Position_Audit in the ordered set where pId = &#63;.
	*
	* @param pId the p ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_Position_Audit, or <code>null</code> if a matching WFMS_Position_Audit could not be found
	*/
	public static WFMS_Position_Audit fetchByPosIdForAudit_Last(
		java.lang.String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return getPersistence().fetchByPosIdForAudit_Last(pId, orderByComparator);
	}

	/**
	* Returns the WFMS_Position_Audits before and after the current WFMS_Position_Audit in the ordered set where pId = &#63;.
	*
	* @param paId the primary key of the current WFMS_Position_Audit
	* @param pId the p ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_Position_Audit
	* @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	*/
	public static WFMS_Position_Audit[] findByPosIdForAudit_PrevAndNext(
		java.lang.String paId, java.lang.String pId,
		OrderByComparator<WFMS_Position_Audit> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Position_AuditException {
		return getPersistence()
				   .findByPosIdForAudit_PrevAndNext(paId, pId, orderByComparator);
	}

	/**
	* Removes all the WFMS_Position_Audits where pId = &#63; from the database.
	*
	* @param pId the p ID
	*/
	public static void removeByPosIdForAudit(java.lang.String pId) {
		getPersistence().removeByPosIdForAudit(pId);
	}

	/**
	* Returns the number of WFMS_Position_Audits where pId = &#63;.
	*
	* @param pId the p ID
	* @return the number of matching WFMS_Position_Audits
	*/
	public static int countByPosIdForAudit(java.lang.String pId) {
		return getPersistence().countByPosIdForAudit(pId);
	}

	/**
	* Caches the WFMS_Position_Audit in the entity cache if it is enabled.
	*
	* @param wfms_Position_Audit the WFMS_Position_Audit
	*/
	public static void cacheResult(WFMS_Position_Audit wfms_Position_Audit) {
		getPersistence().cacheResult(wfms_Position_Audit);
	}

	/**
	* Caches the WFMS_Position_Audits in the entity cache if it is enabled.
	*
	* @param wfms_Position_Audits the WFMS_Position_Audits
	*/
	public static void cacheResult(
		List<WFMS_Position_Audit> wfms_Position_Audits) {
		getPersistence().cacheResult(wfms_Position_Audits);
	}

	/**
	* Creates a new WFMS_Position_Audit with the primary key. Does not add the WFMS_Position_Audit to the database.
	*
	* @param paId the primary key for the new WFMS_Position_Audit
	* @return the new WFMS_Position_Audit
	*/
	public static WFMS_Position_Audit create(java.lang.String paId) {
		return getPersistence().create(paId);
	}

	/**
	* Removes the WFMS_Position_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param paId the primary key of the WFMS_Position_Audit
	* @return the WFMS_Position_Audit that was removed
	* @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	*/
	public static WFMS_Position_Audit remove(java.lang.String paId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Position_AuditException {
		return getPersistence().remove(paId);
	}

	public static WFMS_Position_Audit updateImpl(
		WFMS_Position_Audit wfms_Position_Audit) {
		return getPersistence().updateImpl(wfms_Position_Audit);
	}

	/**
	* Returns the WFMS_Position_Audit with the primary key or throws a {@link NoSuchWFMS_Position_AuditException} if it could not be found.
	*
	* @param paId the primary key of the WFMS_Position_Audit
	* @return the WFMS_Position_Audit
	* @throws NoSuchWFMS_Position_AuditException if a WFMS_Position_Audit with the primary key could not be found
	*/
	public static WFMS_Position_Audit findByPrimaryKey(java.lang.String paId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_Position_AuditException {
		return getPersistence().findByPrimaryKey(paId);
	}

	/**
	* Returns the WFMS_Position_Audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param paId the primary key of the WFMS_Position_Audit
	* @return the WFMS_Position_Audit, or <code>null</code> if a WFMS_Position_Audit with the primary key could not be found
	*/
	public static WFMS_Position_Audit fetchByPrimaryKey(java.lang.String paId) {
		return getPersistence().fetchByPrimaryKey(paId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_Position_Audit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_Position_Audits.
	*
	* @return the WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_Position_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @return the range of WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_Position_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_Position_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_Position_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_Position_Audits
	* @param end the upper bound of the range of WFMS_Position_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_Position_Audits
	*/
	public static List<WFMS_Position_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_Position_Audit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_Position_Audits from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_Position_Audits.
	*
	* @return the number of WFMS_Position_Audits
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WFMS_Position_AuditPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_Position_AuditPersistence, WFMS_Position_AuditPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_Position_AuditPersistence.class);
}