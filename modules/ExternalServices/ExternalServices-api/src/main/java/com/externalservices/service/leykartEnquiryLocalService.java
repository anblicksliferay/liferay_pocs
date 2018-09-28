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

package com.externalservices.service;

import aQute.bnd.annotation.ProviderType;

import com.externalservices.model.leykartEnquiry;

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
 * Provides the local service interface for leykartEnquiry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see leykartEnquiryLocalServiceUtil
 * @see com.externalservices.service.base.leykartEnquiryLocalServiceBaseImpl
 * @see com.externalservices.service.impl.leykartEnquiryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface leykartEnquiryLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link leykartEnquiryLocalServiceUtil} to access the leykart enquiry local service. Add custom service methods to {@link com.externalservices.service.impl.leykartEnquiryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the leykart enquiry to the database. Also notifies the appropriate model listeners.
	*
	* @param leykartEnquiry the leykart enquiry
	* @return the leykart enquiry that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public leykartEnquiry addleykartEnquiry(leykartEnquiry leykartEnquiry);

	/**
	* Creates a new leykart enquiry with the primary key. Does not add the leykart enquiry to the database.
	*
	* @param Eid the primary key for the new leykart enquiry
	* @return the new leykart enquiry
	*/
	public leykartEnquiry createleykartEnquiry(long Eid);

	/**
	* Deletes the leykart enquiry from the database. Also notifies the appropriate model listeners.
	*
	* @param leykartEnquiry the leykart enquiry
	* @return the leykart enquiry that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public leykartEnquiry deleteleykartEnquiry(leykartEnquiry leykartEnquiry);

	/**
	* Deletes the leykart enquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry that was removed
	* @throws PortalException if a leykart enquiry with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public leykartEnquiry deleteleykartEnquiry(long Eid)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public leykartEnquiry fetchleykartEnquiry(long Eid);

	/**
	* Returns the leykart enquiry with the matching UUID and company.
	*
	* @param uuid the leykart enquiry's UUID
	* @param companyId the primary key of the company
	* @return the matching leykart enquiry, or <code>null</code> if a matching leykart enquiry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public leykartEnquiry fetchleykartEnquiryByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns the leykart enquiry with the primary key.
	*
	* @param Eid the primary key of the leykart enquiry
	* @return the leykart enquiry
	* @throws PortalException if a leykart enquiry with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public leykartEnquiry getleykartEnquiry(long Eid) throws PortalException;

	/**
	* Returns the leykart enquiry with the matching UUID and company.
	*
	* @param uuid the leykart enquiry's UUID
	* @param companyId the primary key of the company
	* @return the matching leykart enquiry
	* @throws PortalException if a matching leykart enquiry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public leykartEnquiry getleykartEnquiryByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Updates the leykart enquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leykartEnquiry the leykart enquiry
	* @return the leykart enquiry that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public leykartEnquiry updateleykartEnquiry(leykartEnquiry leykartEnquiry);

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
	* Returns the number of leykart enquiries.
	*
	* @return the number of leykart enquiries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getleykartEnquiriesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.externalservices.model.impl.leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.externalservices.model.impl.leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the leykart enquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.externalservices.model.impl.leykartEnquiryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leykart enquiries
	* @param end the upper bound of the range of leykart enquiries (not inclusive)
	* @return the range of leykart enquiries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<leykartEnquiry> getleykartEnquiries(int start, int end);

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