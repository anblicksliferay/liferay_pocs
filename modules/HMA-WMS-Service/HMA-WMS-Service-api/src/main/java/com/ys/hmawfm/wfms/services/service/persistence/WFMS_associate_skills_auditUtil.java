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

import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the WFMS_associate_skills_audit service. This utility wraps {@link com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_associate_skills_auditPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_auditPersistence
 * @see com.ys.hmawfm.wfms.services.service.persistence.impl.WFMS_associate_skills_auditPersistenceImpl
 * @generated
 */
@ProviderType
public class WFMS_associate_skills_auditUtil {
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
	public static void clearCache(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		getPersistence().clearCache(wfms_associate_skills_audit);
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
	public static List<WFMS_associate_skills_audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WFMS_associate_skills_audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WFMS_associate_skills_audit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WFMS_associate_skills_audit> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WFMS_associate_skills_audit update(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		return getPersistence().update(wfms_associate_skills_audit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WFMS_associate_skills_audit update(
		WFMS_associate_skills_audit wfms_associate_skills_audit,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(wfms_associate_skills_audit, serviceContext);
	}

	/**
	* Caches the WFMS_associate_skills_audit in the entity cache if it is enabled.
	*
	* @param wfms_associate_skills_audit the WFMS_associate_skills_audit
	*/
	public static void cacheResult(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		getPersistence().cacheResult(wfms_associate_skills_audit);
	}

	/**
	* Caches the WFMS_associate_skills_audits in the entity cache if it is enabled.
	*
	* @param wfms_associate_skills_audits the WFMS_associate_skills_audits
	*/
	public static void cacheResult(
		List<WFMS_associate_skills_audit> wfms_associate_skills_audits) {
		getPersistence().cacheResult(wfms_associate_skills_audits);
	}

	/**
	* Creates a new WFMS_associate_skills_audit with the primary key. Does not add the WFMS_associate_skills_audit to the database.
	*
	* @param associate_log_id the primary key for the new WFMS_associate_skills_audit
	* @return the new WFMS_associate_skills_audit
	*/
	public static WFMS_associate_skills_audit create(long associate_log_id) {
		return getPersistence().create(associate_log_id);
	}

	/**
	* Removes the WFMS_associate_skills_audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param associate_log_id the primary key of the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit that was removed
	* @throws NoSuchWFMS_associate_skills_auditException if a WFMS_associate_skills_audit with the primary key could not be found
	*/
	public static WFMS_associate_skills_audit remove(long associate_log_id)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skills_auditException {
		return getPersistence().remove(associate_log_id);
	}

	public static WFMS_associate_skills_audit updateImpl(
		WFMS_associate_skills_audit wfms_associate_skills_audit) {
		return getPersistence().updateImpl(wfms_associate_skills_audit);
	}

	/**
	* Returns the WFMS_associate_skills_audit with the primary key or throws a {@link NoSuchWFMS_associate_skills_auditException} if it could not be found.
	*
	* @param associate_log_id the primary key of the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit
	* @throws NoSuchWFMS_associate_skills_auditException if a WFMS_associate_skills_audit with the primary key could not be found
	*/
	public static WFMS_associate_skills_audit findByPrimaryKey(
		long associate_log_id)
		throws com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_associate_skills_auditException {
		return getPersistence().findByPrimaryKey(associate_log_id);
	}

	/**
	* Returns the WFMS_associate_skills_audit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param associate_log_id the primary key of the WFMS_associate_skills_audit
	* @return the WFMS_associate_skills_audit, or <code>null</code> if a WFMS_associate_skills_audit with the primary key could not be found
	*/
	public static WFMS_associate_skills_audit fetchByPrimaryKey(
		long associate_log_id) {
		return getPersistence().fetchByPrimaryKey(associate_log_id);
	}

	public static java.util.Map<java.io.Serializable, WFMS_associate_skills_audit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the WFMS_associate_skills_audits.
	*
	* @return the WFMS_associate_skills_audits
	*/
	public static List<WFMS_associate_skills_audit> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WFMS_associate_skills_audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skills_audits
	* @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	* @return the range of WFMS_associate_skills_audits
	*/
	public static List<WFMS_associate_skills_audit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WFMS_associate_skills_audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skills_audits
	* @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WFMS_associate_skills_audits
	*/
	public static List<WFMS_associate_skills_audit> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills_audit> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the WFMS_associate_skills_audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WFMS_associate_skills_auditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WFMS_associate_skills_audits
	* @param end the upper bound of the range of WFMS_associate_skills_audits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of WFMS_associate_skills_audits
	*/
	public static List<WFMS_associate_skills_audit> findAll(int start, int end,
		OrderByComparator<WFMS_associate_skills_audit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the WFMS_associate_skills_audits from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WFMS_associate_skills_audits.
	*
	* @return the number of WFMS_associate_skills_audits
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WFMS_associate_skills_auditPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WFMS_associate_skills_auditPersistence, WFMS_associate_skills_auditPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WFMS_associate_skills_auditPersistence.class);
}