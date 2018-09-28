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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import ddtii.exception.NoSuchcategoryException;

import ddtii.model.category;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ddtii.service.persistence.impl.categoryPersistenceImpl
 * @see categoryUtil
 * @generated
 */
@ProviderType
public interface categoryPersistence extends BasePersistence<category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link categoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public void cacheResult(category category);

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public void cacheResult(java.util.List<category> categories);

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public category create(long categoryId);

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws NoSuchcategoryException if a category with the primary key could not be found
	*/
	public category remove(long categoryId) throws NoSuchcategoryException;

	public category updateImpl(category category);

	/**
	* Returns the category with the primary key or throws a {@link NoSuchcategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws NoSuchcategoryException if a category with the primary key could not be found
	*/
	public category findByPrimaryKey(long categoryId)
		throws NoSuchcategoryException;

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	*/
	public category fetchByPrimaryKey(long categoryId);

	@Override
	public java.util.Map<java.io.Serializable, category> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the categories.
	*
	* @return the categories
	*/
	public java.util.List<category> findAll();

	/**
	* Returns a range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link categoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of categories
	*/
	public java.util.List<category> findAll(int start, int end);

	/**
	* Returns an ordered range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link categoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categories
	*/
	public java.util.List<category> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<category> orderByComparator);

	/**
	* Returns an ordered range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link categoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of categories
	*/
	public java.util.List<category> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<category> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the categories from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	*/
	public int countAll();
}