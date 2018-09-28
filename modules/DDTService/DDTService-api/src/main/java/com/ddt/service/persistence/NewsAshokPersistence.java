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

package com.ddt.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.ddt.exception.NoSuchNewsAshokException;

import com.ddt.model.NewsAshok;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the news ashok service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ddt.service.persistence.impl.NewsAshokPersistenceImpl
 * @see NewsAshokUtil
 * @generated
 */
@ProviderType
public interface NewsAshokPersistence extends BasePersistence<NewsAshok> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsAshokUtil} to access the news ashok persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the news ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching news ashoks
	*/
	public java.util.List<NewsAshok> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the news ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @return the range of matching news ashoks
	*/
	public java.util.List<NewsAshok> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the news ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching news ashoks
	*/
	public java.util.List<NewsAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator);

	/**
	* Returns an ordered range of all the news ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching news ashoks
	*/
	public java.util.List<NewsAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first news ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching news ashok
	* @throws NoSuchNewsAshokException if a matching news ashok could not be found
	*/
	public NewsAshok findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator)
		throws NoSuchNewsAshokException;

	/**
	* Returns the first news ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching news ashok, or <code>null</code> if a matching news ashok could not be found
	*/
	public NewsAshok fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator);

	/**
	* Returns the last news ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching news ashok
	* @throws NoSuchNewsAshokException if a matching news ashok could not be found
	*/
	public NewsAshok findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator)
		throws NoSuchNewsAshokException;

	/**
	* Returns the last news ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching news ashok, or <code>null</code> if a matching news ashok could not be found
	*/
	public NewsAshok fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator);

	/**
	* Returns the news ashoks before and after the current news ashok in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current news ashok
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next news ashok
	* @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	*/
	public NewsAshok[] findByUuid_PrevAndNext(long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator)
		throws NoSuchNewsAshokException;

	/**
	* Removes all the news ashoks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of news ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching news ashoks
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the news ashok in the entity cache if it is enabled.
	*
	* @param newsAshok the news ashok
	*/
	public void cacheResult(NewsAshok newsAshok);

	/**
	* Caches the news ashoks in the entity cache if it is enabled.
	*
	* @param newsAshoks the news ashoks
	*/
	public void cacheResult(java.util.List<NewsAshok> newsAshoks);

	/**
	* Creates a new news ashok with the primary key. Does not add the news ashok to the database.
	*
	* @param id the primary key for the new news ashok
	* @return the new news ashok
	*/
	public NewsAshok create(long id);

	/**
	* Removes the news ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the news ashok
	* @return the news ashok that was removed
	* @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	*/
	public NewsAshok remove(long id) throws NoSuchNewsAshokException;

	public NewsAshok updateImpl(NewsAshok newsAshok);

	/**
	* Returns the news ashok with the primary key or throws a {@link NoSuchNewsAshokException} if it could not be found.
	*
	* @param id the primary key of the news ashok
	* @return the news ashok
	* @throws NoSuchNewsAshokException if a news ashok with the primary key could not be found
	*/
	public NewsAshok findByPrimaryKey(long id) throws NoSuchNewsAshokException;

	/**
	* Returns the news ashok with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the news ashok
	* @return the news ashok, or <code>null</code> if a news ashok with the primary key could not be found
	*/
	public NewsAshok fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, NewsAshok> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the news ashoks.
	*
	* @return the news ashoks
	*/
	public java.util.List<NewsAshok> findAll();

	/**
	* Returns a range of all the news ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @return the range of news ashoks
	*/
	public java.util.List<NewsAshok> findAll(int start, int end);

	/**
	* Returns an ordered range of all the news ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of news ashoks
	*/
	public java.util.List<NewsAshok> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator);

	/**
	* Returns an ordered range of all the news ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news ashoks
	* @param end the upper bound of the range of news ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of news ashoks
	*/
	public java.util.List<NewsAshok> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsAshok> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the news ashoks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of news ashoks.
	*
	* @return the number of news ashoks
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}