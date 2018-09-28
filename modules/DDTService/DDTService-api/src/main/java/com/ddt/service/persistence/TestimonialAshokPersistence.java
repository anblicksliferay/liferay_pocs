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

import com.ddt.exception.NoSuchTestimonialAshokException;

import com.ddt.model.TestimonialAshok;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the testimonial ashok service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ddt.service.persistence.impl.TestimonialAshokPersistenceImpl
 * @see TestimonialAshokUtil
 * @generated
 */
@ProviderType
public interface TestimonialAshokPersistence extends BasePersistence<TestimonialAshok> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestimonialAshokUtil} to access the testimonial ashok persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the testimonial ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the testimonial ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @return the range of matching testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the testimonial ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator);

	/**
	* Returns an ordered range of all the testimonial ashoks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testimonial ashok
	* @throws NoSuchTestimonialAshokException if a matching testimonial ashok could not be found
	*/
	public TestimonialAshok findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator)
		throws NoSuchTestimonialAshokException;

	/**
	* Returns the first testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testimonial ashok, or <code>null</code> if a matching testimonial ashok could not be found
	*/
	public TestimonialAshok fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator);

	/**
	* Returns the last testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testimonial ashok
	* @throws NoSuchTestimonialAshokException if a matching testimonial ashok could not be found
	*/
	public TestimonialAshok findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator)
		throws NoSuchTestimonialAshokException;

	/**
	* Returns the last testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testimonial ashok, or <code>null</code> if a matching testimonial ashok could not be found
	*/
	public TestimonialAshok fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator);

	/**
	* Returns the testimonial ashoks before and after the current testimonial ashok in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current testimonial ashok
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testimonial ashok
	* @throws NoSuchTestimonialAshokException if a testimonial ashok with the primary key could not be found
	*/
	public TestimonialAshok[] findByUuid_PrevAndNext(long id,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator)
		throws NoSuchTestimonialAshokException;

	/**
	* Removes all the testimonial ashoks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of testimonial ashoks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching testimonial ashoks
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the testimonial ashok in the entity cache if it is enabled.
	*
	* @param testimonialAshok the testimonial ashok
	*/
	public void cacheResult(TestimonialAshok testimonialAshok);

	/**
	* Caches the testimonial ashoks in the entity cache if it is enabled.
	*
	* @param testimonialAshoks the testimonial ashoks
	*/
	public void cacheResult(java.util.List<TestimonialAshok> testimonialAshoks);

	/**
	* Creates a new testimonial ashok with the primary key. Does not add the testimonial ashok to the database.
	*
	* @param id the primary key for the new testimonial ashok
	* @return the new testimonial ashok
	*/
	public TestimonialAshok create(long id);

	/**
	* Removes the testimonial ashok with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok that was removed
	* @throws NoSuchTestimonialAshokException if a testimonial ashok with the primary key could not be found
	*/
	public TestimonialAshok remove(long id)
		throws NoSuchTestimonialAshokException;

	public TestimonialAshok updateImpl(TestimonialAshok testimonialAshok);

	/**
	* Returns the testimonial ashok with the primary key or throws a {@link NoSuchTestimonialAshokException} if it could not be found.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok
	* @throws NoSuchTestimonialAshokException if a testimonial ashok with the primary key could not be found
	*/
	public TestimonialAshok findByPrimaryKey(long id)
		throws NoSuchTestimonialAshokException;

	/**
	* Returns the testimonial ashok with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the testimonial ashok
	* @return the testimonial ashok, or <code>null</code> if a testimonial ashok with the primary key could not be found
	*/
	public TestimonialAshok fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, TestimonialAshok> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the testimonial ashoks.
	*
	* @return the testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findAll();

	/**
	* Returns a range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @return the range of testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findAll(int start, int end);

	/**
	* Returns an ordered range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator);

	/**
	* Returns an ordered range of all the testimonial ashoks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestimonialAshokModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testimonial ashoks
	* @param end the upper bound of the range of testimonial ashoks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of testimonial ashoks
	*/
	public java.util.List<TestimonialAshok> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TestimonialAshok> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the testimonial ashoks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of testimonial ashoks.
	*
	* @return the number of testimonial ashoks
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}