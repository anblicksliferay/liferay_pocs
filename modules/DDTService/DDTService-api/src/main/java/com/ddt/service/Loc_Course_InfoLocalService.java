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

package com.ddt.service;

import aQute.bnd.annotation.ProviderType;

import com.ddt.model.Loc_Course_Info;

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
 * Provides the local service interface for Loc_Course_Info. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_InfoLocalServiceUtil
 * @see com.ddt.service.base.Loc_Course_InfoLocalServiceBaseImpl
 * @see com.ddt.service.impl.Loc_Course_InfoLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface Loc_Course_InfoLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Loc_Course_InfoLocalServiceUtil} to access the loc_ course_ info local service. Add custom service methods to {@link com.ddt.service.impl.Loc_Course_InfoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the loc_ course_ info to the database. Also notifies the appropriate model listeners.
	*
	* @param loc_Course_Info the loc_ course_ info
	* @return the loc_ course_ info that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Loc_Course_Info addLoc_Course_Info(Loc_Course_Info loc_Course_Info);

	/**
	* Creates a new loc_ course_ info with the primary key. Does not add the loc_ course_ info to the database.
	*
	* @param id the primary key for the new loc_ course_ info
	* @return the new loc_ course_ info
	*/
	public Loc_Course_Info createLoc_Course_Info(long id);

	/**
	* Deletes the loc_ course_ info from the database. Also notifies the appropriate model listeners.
	*
	* @param loc_Course_Info the loc_ course_ info
	* @return the loc_ course_ info that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Loc_Course_Info deleteLoc_Course_Info(
		Loc_Course_Info loc_Course_Info);

	/**
	* Deletes the loc_ course_ info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info that was removed
	* @throws PortalException if a loc_ course_ info with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Loc_Course_Info deleteLoc_Course_Info(long id)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Loc_Course_Info fetchLoc_Course_Info(long id);

	/**
	* Returns the loc_ course_ info with the matching UUID and company.
	*
	* @param uuid the loc_ course_ info's UUID
	* @param companyId the primary key of the company
	* @return the matching loc_ course_ info, or <code>null</code> if a matching loc_ course_ info could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Loc_Course_Info fetchLoc_Course_InfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns the loc_ course_ info with the primary key.
	*
	* @param id the primary key of the loc_ course_ info
	* @return the loc_ course_ info
	* @throws PortalException if a loc_ course_ info with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Loc_Course_Info getLoc_Course_Info(long id)
		throws PortalException;

	/**
	* Returns the loc_ course_ info with the matching UUID and company.
	*
	* @param uuid the loc_ course_ info's UUID
	* @param companyId the primary key of the company
	* @return the matching loc_ course_ info
	* @throws PortalException if a matching loc_ course_ info could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Loc_Course_Info getLoc_Course_InfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Updates the loc_ course_ info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loc_Course_Info the loc_ course_ info
	* @return the loc_ course_ info that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Loc_Course_Info updateLoc_Course_Info(
		Loc_Course_Info loc_Course_Info);

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
	* Returns the number of loc_ course_ infos.
	*
	* @return the number of loc_ course_ infos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLoc_Course_InfosCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the loc_ course_ infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ddt.model.impl.Loc_Course_InfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loc_ course_ infos
	* @param end the upper bound of the range of loc_ course_ infos (not inclusive)
	* @return the range of loc_ course_ infos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Loc_Course_Info> getLoc_Course_Infos(int start, int end);

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