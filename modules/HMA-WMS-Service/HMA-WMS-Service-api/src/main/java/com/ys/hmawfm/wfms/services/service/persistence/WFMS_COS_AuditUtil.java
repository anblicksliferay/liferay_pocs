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

import com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_COS_Audit service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_COS_AuditPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COS_AuditPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_COS_AuditPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_COS_AuditUtil {
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
	public static void clearCache(WFMS_COS_Audit wfms_cos_Audit) {
		getPersistence().clearCache(wfms_cos_Audit);
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
	public static List<WFMS_COS_Audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_COS_Audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_COS_Audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_COS_Audit> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_COS_Audit update(WFMS_COS_Audit wfms_cos_Audit) {
		return getPersistence().update(wfms_cos_Audit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_COS_Audit update(WFMS_COS_Audit wfms_cos_Audit,
		ServiceContext serviceContext) {
		return getPersistence().update(wfms_cos_Audit, serviceContext);
	}

	/**
	* Returns all the WFMS_COS_Audits where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @return the matching WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findByCosIdForAudit(
		java.lang.String cosId) {
		return getPersistence().findByCosIdForAudit(cosId);
	}

	/**
	* Returns a range of all the WFMS_COS_Audits where cosId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cosId the cos ID
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @return the range of matching WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findByCosIdForAudit(
		java.lang.String cosId, int start, int end) {
		return getPersistence().findByCosIdForAudit(cosId, start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COS_Audits where cosId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cosId the cos ID
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findByCosIdForAudit(
		java.lang.String cosId, int start, int end,
		OrderByComparator<WFMS_COS_Audit> orderByComparator) {
		return getPersistence()
				   .findByCosIdForAudit(cosId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COS_Audits where cosId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cosId the cos ID
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findByCosIdForAudit(
		java.lang.String cosId, int start, int end,
		OrderByComparator<WFMS_COS_Audit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCosIdForAudit(cosId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first WFMS_COS_Audit in the ordered set where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS_Audit
	* @throws NoSuchWFMS_COS_AuditException if a matching WFMS_COS_Audit could not be found
	*/
	public static WFMS_COS_Audit findByCosIdForAudit_First(
		java.lang.String cosId,
		OrderByComparator<WFMS_COS_Audit> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COS_AuditException {
		return getPersistence()
				   .findByCosIdForAudit_First(cosId, orderByComparator);
	}

	/**
	* Returns the first WFMS_COS_Audit in the ordered set where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WFMS_COS_Audit, or <code>null</code> if a matching WFMS_COS_Audit could not be found
	*/
	public static WFMS_COS_Audit fetchByCosIdForAudit_First(
		java.lang.String cosId,
		OrderByComparator<WFMS_COS_Audit> orderByComparator) {
		return getPersistence()
				   .fetchByCosIdForAudit_First(cosId, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS_Audit in the ordered set where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS_Audit
	* @throws NoSuchWFMS_COS_AuditException if a matching WFMS_COS_Audit could not be found
	*/
	public static WFMS_COS_Audit findByCosIdForAudit_Last(
		java.lang.String cosId,
		OrderByComparator<WFMS_COS_Audit> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COS_AuditException {
		return getPersistence()
				   .findByCosIdForAudit_Last(cosId, orderByComparator);
	}

	/**
	* Returns the last WFMS_COS_Audit in the ordered set where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WFMS_COS_Audit, or <code>null</code> if a matching WFMS_COS_Audit could not be found
	*/
	public static WFMS_COS_Audit fetchByCosIdForAudit_Last(
		java.lang.String cosId,
		OrderByComparator<WFMS_COS_Audit> orderByComparator) {
		return getPersistence()
				   .fetchByCosIdForAudit_Last(cosId, orderByComparator);
	}

	/**
	* Returns the WFMS_COS_Audits before and after the current WFMS_COS_Audit in the ordered set where cosId = &#63;.
	*
	* @param cosaId the primary key of the current WFMS_COS_Audit
	* @param cosId the cos ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WFMS_COS_Audit
	* @throws NoSuchWFMS_COS_AuditException if a WFMS_COS_Audit with the primary key could not be found
	*/
	public static WFMS_COS_Audit[] findByCosIdForAudit_PrevAndNext(
		java.lang.String cosaId, java.lang.String cosId,
		OrderByComparator<WFMS_COS_Audit> orderByComparator)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COS_AuditException {
		return getPersistence()
				   .findByCosIdForAudit_PrevAndNext(cosaId, cosId,
			orderByComparator);
	}

	/**
	* Removes all the WFMS_COS_Audits where cosId = &#63; from the database.
	*
	* @param cosId the cos ID
	*/
	public static void removeByCosIdForAudit(java.lang.String cosId) {
		getPersistence().removeByCosIdForAudit(cosId);
	}

	/**
	* Returns the number of WFMS_COS_Audits where cosId = &#63;.
	*
	* @param cosId the cos ID
	* @return the number of matching WFMS_COS_Audits
	*/
	public static int countByCosIdForAudit(java.lang.String cosId) {
		return getPersistence().countByCosIdForAudit(cosId);
	}

	/**
	* Caches the WFMS_COS_Audit in the entity cache if it is enabled.
	*
	* @param wfms_cos_Audit the WFMS_COS_Audit
	*/
	public static void cacheResult(WFMS_COS_Audit wfms_cos_Audit) {
		getPersistence().cacheResult(wfms_cos_Audit);
	}

	/**
	* Caches the WFMS_COS_Audits in the entity cache if it is enabled.
	*
	* @param wfms_cos_Audits the WFMS_COS_Audits
	*/
	public static void cacheResult(List<WFMS_COS_Audit> wfms_cos_Audits) {
		getPersistence().cacheResult(wfms_cos_Audits);
	}

	/**
	* Creates a new WFMS_COS_Audit with the primary key. Does not add the WFMS_COS_Audit to the database.
	*
	* @param cosaId the primary key for the new WFMS_COS_Audit
	* @return the new WFMS_COS_Audit
	*/
	public static WFMS_COS_Audit create(java.lang.String cosaId) {
		return getPersistence().create(cosaId);
	}

	/**
	* Removes the WFMS_COS_Audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cosaId the primary key of the WFMS_COS_Audit
	* @return the WFMS_COS_Audit that was removed
	* @throws NoSuchWFMS_COS_AuditException if a WFMS_COS_Audit with the primary key could not be found
	*/
	public static WFMS_COS_Audit remove(java.lang.String cosaId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COS_AuditException {
		return getPersistence().remove(cosaId);
	}

	public static WFMS_COS_Audit updateImpl(WFMS_COS_Audit wfms_cos_Audit) {
		return getPersistence().updateImpl(wfms_cos_Audit);
	}

	/**
	* Returns the WFMS_COS_Audit with the primary key or throws a {@link NoSuchWFMS_COS_AuditException} if it could not be found.
	*
	* @param cosaId the primary key of the WFMS_COS_Audit
	* @return the WFMS_COS_Audit
	* @throws NoSuchWFMS_COS_AuditException if a WFMS_COS_Audit with the primary key could not be found
	*/
	public static WFMS_COS_Audit findByPrimaryKey(java.lang.String cosaId)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COS_AuditException {
		return getPersistence().findByPrimaryKey(cosaId);
	}

	/**
	* Returns the WFMS_COS_Audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cosaId the primary key of the WFMS_COS_Audit
	* @return the WFMS_COS_Audit, or <code>null</code> if a WFMS_COS_Audit with the primary key could not be found
	*/
	public static WFMS_COS_Audit fetchByPrimaryKey(java.lang.String cosaId) {
		return getPersistence().fetchByPrimaryKey(cosaId);
	}

	public static java.util.Map<java.io.Serializable, WFMS_COS_Audit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_COS_Audits.
	*
	* @return the WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_COS_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @return the range of WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_COS_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_COS_Audit> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_COS_Audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_COS_AuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_COS_Audits
	* @param end the upper bound of the range of WFMS_COS_Audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_COS_Audits
	*/
	public static List<WFMS_COS_Audit> findAll(int start, int end,
		OrderByComparator<WFMS_COS_Audit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_COS_Audits from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_COS_Audits.
	*
	* @return the number of WFMS_COS_Audits
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WFMS_COS_AuditPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_COS_AuditPersistence, WFMS_COS_AuditPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_COS_AuditPersistence.class);
}