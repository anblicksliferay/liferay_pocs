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

import com.ddt.exception.NoSuchFAQSAshokException;

import com.ddt.model.FAQSAshok;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the f a q s ashok service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ddt.service.persistence.impl.FAQSAshokPersistenceImpl
 * @see FAQSAshokUtil
 * @generated
 */
@ProviderType
public interface FAQSAshokPersistence extends BasePersistence<FAQSAshok> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FAQSAshokUtil} to access the f a q s ashok persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the f a q s ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the f a q s ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @return the range of matching f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the f a q s ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator);

	/**
	* Returns an ordered range of all the f a q s ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q s ashok
	* @throws NoSuchFAQSAshokException if a matching f a q s ashok could not be found
	*/
	public FAQSAshok findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator)
		throws NoSuchFAQSAshokException;

	/**
	* Returns the first f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q s ashok, or <code>null</code> if a matching f a q s ashok could not be found
	*/
	public FAQSAshok fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator);

	/**
	* Returns the last f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q s ashok
	* @throws NoSuchFAQSAshokException if a matching f a q s ashok could not be found
	*/
	public FAQSAshok findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator)
		throws NoSuchFAQSAshokException;

	/**
	* Returns the last f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q s ashok, or <code>null</code> if a matching f a q s ashok could not be found
	*/
	public FAQSAshok fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator);

	/**
	* Returns the f a q s ashoks before and after the current f a q s ashok in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current f a q s ashok
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next f a q s ashok
	* @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	*/
	public FAQSAshok[] findByUuid_PrevAndNext(long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator)
		throws NoSuchFAQSAshokException;

	/**
	* Removes all the f a q s ashoks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of f a q s ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching f a q s ashoks
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the f a q s ashok in the entity cache if it is enabled.
	*
	* @param faqsAshok the f a q s ashok
	*/
	public void cacheResult(FAQSAshok faqsAshok);

	/**
	* Caches the f a q s ashoks in the entity cache if it is enabled.
	*
	* @param faqsAshoks the f a q s ashoks
	*/
	public void cacheResult(java.util.List<FAQSAshok> faqsAshoks);

	/**
	* Creates a new f a q s ashok with the primary key. Does not add the f a q s ashok to the database.
	*
	* @param id the primary key for the new f a q s ashok
	* @return the new f a q s ashok
	*/
	public FAQSAshok create(long id);

	/**
	* Removes the f a q s ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok that was removed
	* @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	*/
	public FAQSAshok remove(long id) throws NoSuchFAQSAshokException;

	public FAQSAshok updateImpl(FAQSAshok faqsAshok);

	/**
	* Returns the f a q s ashok with the primary key or throws a {@link NoSuchFAQSAshokException} if it could not be found.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok
	* @throws NoSuchFAQSAshokException if a f a q s ashok with the primary key could not be found
	*/
	public FAQSAshok findByPrimaryKey(long id) throws NoSuchFAQSAshokException;

	/**
	* Returns the f a q s ashok with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the f a q s ashok
	* @return the f a q s ashok, or <code>null</code> if a f a q s ashok with the primary key could not be found
	*/
	public FAQSAshok fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, FAQSAshok> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the f a q s ashoks.
	*
	* @return the f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findAll();

	/**
	* Returns a range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @return the range of f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findAll(int start, int end);

	/**
	* Returns an ordered range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator);

	/**
	* Returns an ordered range of all the f a q s ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FAQSAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of f a q s ashoks
	* @param end the upper bound of the range of f a q s ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of f a q s ashoks
	*/
	public java.util.List<FAQSAshok> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQSAshok> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the f a q s ashoks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of f a q s ashoks.
	*
	* @return the number of f a q s ashoks
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}