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

import com.delphi.userprofile.exception.NoSuchUserAccessRequestException;
import com.delphi.userprofile.model.UserAccessRequest;

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
 * Provides the local service interface for UserAccessRequest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequestLocalServiceUtil
 * @see com.delphi.userprofile.service.base.UserAccessRequestLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.impl.UserAccessRequestLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserAccessRequestLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserAccessRequestLocalServiceUtil} to access the user access request local service. Add custom service methods to {@link com.delphi.userprofile.service.impl.UserAccessRequestLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the user access request to the database. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserAccessRequest addUserAccessRequest(
		UserAccessRequest userAccessRequest);

	public UserAccessRequest createNewUserAccessRequest(long userId,
		long creatorUserId)
		throws NoSuchUserAccessRequestException, SystemException;

	/**
	* Creates a new user access request with the primary key. Does not add the user access request to the database.
	*
	* @param requestId the primary key for the new user access request
	* @return the new user access request
	*/
	public UserAccessRequest createUserAccessRequest(long requestId);

	/**
	* Deletes the user access request from the database. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserAccessRequest deleteUserAccessRequest(
		UserAccessRequest userAccessRequest);

	/**
	* Deletes the user access request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request that was removed
	* @throws PortalException if a user access request with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserAccessRequest deleteUserAccessRequest(long requestId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserAccessRequest fetchUserAccessRequest(long requestId);

	/**
	* Returns the user access request with the matching UUID and company.
	*
	* @param uuid the user access request's UUID
	* @param companyId the primary key of the company
	* @return the matching user access request, or <code>null</code> if a matching user access request could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserAccessRequest fetchUserAccessRequestByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns the user access request with the primary key.
	*
	* @param requestId the primary key of the user access request
	* @return the user access request
	* @throws PortalException if a user access request with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserAccessRequest getUserAccessRequest(long requestId)
		throws PortalException;

	/**
	* Returns the user access request with the matching UUID and company.
	*
	* @param uuid the user access request's UUID
	* @param companyId the primary key of the company
	* @return the matching user access request
	* @throws PortalException if a matching user access request could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserAccessRequest getUserAccessRequestByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Updates the user access request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userAccessRequest the user access request
	* @return the user access request that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserAccessRequest updateUserAccessRequest(
		UserAccessRequest userAccessRequest);

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
	* Returns the number of user access requests.
	*
	* @return the number of user access requests
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserAccessRequestsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<UserAccessRequest> findUserAccessRequestByActiveState(
		int activeState)
		throws NoSuchUserAccessRequestException, SystemException;

	public List<UserAccessRequest> findUserAccessRequestsByUserId(long userId)
		throws NoSuchUserAccessRequestException, SystemException;

	/**
	* Returns a range of all the user access requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.delphi.userprofile.model.impl.UserAccessRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user access requests
	* @param end the upper bound of the range of user access requests (not inclusive)
	* @return the range of user access requests
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserAccessRequest> getUserAccessRequests(int start, int end);

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