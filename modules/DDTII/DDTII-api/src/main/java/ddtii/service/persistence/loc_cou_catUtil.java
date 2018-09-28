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

package ddtii.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import ddtii.model.loc_cou_cat;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the loc_cou_cat service. This utility wraps {@link ddtii.service.persistence.impl.loc_cou_catPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_catPersistence
 * @see ddtii.service.persistence.impl.loc_cou_catPersistenceImpl
 * @generated
 */
@ProviderType
public class loc_cou_catUtil {
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
	public static void clearCache(loc_cou_cat loc_cou_cat) {
		getPersistence().clearCache(loc_cou_cat);
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
	public static List<loc_cou_cat> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<loc_cou_cat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<loc_cou_cat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<loc_cou_cat> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static loc_cou_cat update(loc_cou_cat loc_cou_cat) {
		return getPersistence().update(loc_cou_cat);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static loc_cou_cat update(loc_cou_cat loc_cou_cat,
		ServiceContext serviceContext) {
		return getPersistence().update(loc_cou_cat, serviceContext);
	}

	/**
	* Caches the loc_cou_cat in the entity cache if it is enabled.
	*
	* @param loc_cou_cat the loc_cou_cat
	*/
	public static void cacheResult(loc_cou_cat loc_cou_cat) {
		getPersistence().cacheResult(loc_cou_cat);
	}

	/**
	* Caches the loc_cou_cats in the entity cache if it is enabled.
	*
	* @param loc_cou_cats the loc_cou_cats
	*/
	public static void cacheResult(List<loc_cou_cat> loc_cou_cats) {
		getPersistence().cacheResult(loc_cou_cats);
	}

	/**
	* Creates a new loc_cou_cat with the primary key. Does not add the loc_cou_cat to the database.
	*
	* @param loc_cou_catId the primary key for the new loc_cou_cat
	* @return the new loc_cou_cat
	*/
	public static loc_cou_cat create(long loc_cou_catId) {
		return getPersistence().create(loc_cou_catId);
	}

	/**
	* Removes the loc_cou_cat with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat that was removed
	* @throws NoSuchloc_cou_catException if a loc_cou_cat with the primary key could not be found
	*/
	public static loc_cou_cat remove(long loc_cou_catId)
		throws ddtii.exception.NoSuchloc_cou_catException {
		return getPersistence().remove(loc_cou_catId);
	}

	public static loc_cou_cat updateImpl(loc_cou_cat loc_cou_cat) {
		return getPersistence().updateImpl(loc_cou_cat);
	}

	/**
	* Returns the loc_cou_cat with the primary key or throws a {@link NoSuchloc_cou_catException} if it could not be found.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat
	* @throws NoSuchloc_cou_catException if a loc_cou_cat with the primary key could not be found
	*/
	public static loc_cou_cat findByPrimaryKey(long loc_cou_catId)
		throws ddtii.exception.NoSuchloc_cou_catException {
		return getPersistence().findByPrimaryKey(loc_cou_catId);
	}

	/**
	* Returns the loc_cou_cat with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loc_cou_catId the primary key of the loc_cou_cat
	* @return the loc_cou_cat, or <code>null</code> if a loc_cou_cat with the primary key could not be found
	*/
	public static loc_cou_cat fetchByPrimaryKey(long loc_cou_catId) {
		return getPersistence().fetchByPrimaryKey(loc_cou_catId);
	}

	public static java.util.Map<java.io.Serializable, loc_cou_cat> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the loc_cou_cats.
	*
	* @return the loc_cou_cats
	*/
	public static List<loc_cou_cat> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the loc_cou_cats.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_cou_cats
	* @param end the upper bound of the range of loc_cou_cats (not inclusive)
	* @return the range of loc_cou_cats
	*/
	public static List<loc_cou_cat> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the loc_cou_cats.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_cou_cats
	* @param end the upper bound of the range of loc_cou_cats (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loc_cou_cats
	*/
	public static List<loc_cou_cat> findAll(int start, int end,
		OrderByComparator<loc_cou_cat> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the loc_cou_cats.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link loc_cou_catModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_cou_cats
	* @param end the upper bound of the range of loc_cou_cats (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of loc_cou_cats
	*/
	public static List<loc_cou_cat> findAll(int start, int end,
		OrderByComparator<loc_cou_cat> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the loc_cou_cats from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loc_cou_cats.
	*
	* @return the number of loc_cou_cats
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static loc_cou_catPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<loc_cou_catPersistence, loc_cou_catPersistence> _serviceTracker =
		ServiceTrackerFactory.open(loc_cou_catPersistence.class);
}