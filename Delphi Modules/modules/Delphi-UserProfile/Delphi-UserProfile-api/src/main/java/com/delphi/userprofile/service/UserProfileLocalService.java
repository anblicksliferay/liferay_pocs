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

package com.delphi.userprofile.service;

import aQute.bnd.annotation.ProviderType;

import com.delphi.userprofile.exception.NoSuchUserProfileException;
import com.delphi.userprofile.model.UserProfile;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for UserProfile. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserProfileLocalServiceUtil
 * @see com.delphi.userprofile.service.base.UserProfileLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.impl.UserProfileLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserProfileLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserProfileLocalServiceUtil} to access the user profile local service. Add custom service methods to {@link com.delphi.userprofile.service.impl.UserProfileLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the user profile to the database. Also notifies the appropriate model listeners.
	*
	* @param userProfile the user profile
	* @return the user profile that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserProfile addUserProfile(UserProfile userProfile);

	public UserProfile createNewUserProfile(long userId, long creatorUserId)
		throws NoSuchUserProfileException, SystemException;

	/**
	* Creates a new user profile with the primary key. Does not add the user profile to the database.
	*
	* @param profileId the primary key for the new user profile
	* @return the new user profile
	*/
	public UserProfile createUserProfile(long profileId);

	/**
	* Deletes the user profile from the database. Also notifies the appropriate model listeners.
	*
	* @param userProfile the user profile
	* @return the user profile that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserProfile deleteUserProfile(UserProfile userProfile);

	/**
	* Deletes the user profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile that was removed
	* @throws PortalException if a user profile with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserProfile deleteUserProfile(long profileId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserProfile fetchUserProfile(long profileId);

	/**
	* Returns the user profile with the matching UUID and company.
	*
	* @param uuid the user profile's UUID
	* @param companyId the primary key of the company
	* @return the matching user profile, or <code>null</code> if a matching user profile could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserProfile fetchUserProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	public UserProfile findUserProfileByUserId(long userId)
		throws NoSuchUserProfileException, SystemException;

	/**
	* Returns the user profile with the primary key.
	*
	* @param profileId the primary key of the user profile
	* @return the user profile
	* @throws PortalException if a user profile with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserProfile getUserProfile(long profileId) throws PortalException;

	/**
	* Returns the user profile with the matching UUID and company.
	*
	* @param uuid the user profile's UUID
	* @param companyId the primary key of the company
	* @return the matching user profile
	* @throws PortalException if a matching user profile could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserProfile getUserProfileByUuidAndCompanyId(java.lang.String uuid,
		long companyId) throws PortalException;

	/**
	* Updates the user profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userProfile the user profile
	* @return the user profile that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserProfile updateUserProfile(UserProfile userProfile);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of user profiles.
	*
	* @return the number of user profiles
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserProfilesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the user profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profiles
	* @param end the upper bound of the range of user profiles (not inclusive)
	* @return the range of user profiles
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserProfile> getUserProfiles(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}