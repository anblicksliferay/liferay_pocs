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

package com.ys.hmawfm.wfms.services.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.service.base.WFMS_COSLocalServiceBaseImpl;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_COSUtil;

/**
 * The implementation of the WFMS_COS local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_COSLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil
 */
public class WFMS_COSLocalServiceImpl extends WFMS_COSLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil} to access the WFMS_COS local service.
	 */
	
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findBycosIdGetByPosId(
			java.lang.String positionNumber)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_cosPersistence.findBycosIdGetByPosId(positionNumber);
		}
	public List<WFMS_COS> getAll() throws SystemException {

		return wfms_cosPersistence.findAll();
	}

	private Date CreateDate;

	public com.ys.hmawfm.wfms.services.model.WFMS_COS findBycos(
			java.lang.String cosId)
			throws com.liferay.portal.kernel.exception.SystemException,
				NoSuchWFMS_COSException {
			return WFMS_COSUtil.findBycos(cosId);
		}
	
	public List<WFMS_COS> findBynewPositionNumber(String newPositionNumber)

            throws SystemException, NoSuchWFMS_COSException {

            return wfms_cosPersistence.findBynewPositionNumber(newPositionNumber);

    }

	public WFMS_Position getByPositionId(String positionId)
			throws SystemException {

		WFMS_Position positionObj = null;
		try {
			positionObj = wfms_PositionPersistence.findByPrimaryKey(positionId);
		} catch (NoSuchWFMS_PositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return positionObj;
	}

	/*public WFMS_COS getByAssociatenumber(String associatenumber)
			throws SystemException, NoSuchWFMS_PositionException {

		WFMS_COS cosObj1 = null;
		cosObj1 = (WFMS_COS) wfms_cosPersistence
				.findByAssociatenumber(associatenumber);

		return cosObj1;
	}*/

	public WFMS_COS getByCos(String cosId) throws SystemException,
			NoSuchWFMS_PositionException {

		WFMS_COS cosObj2 = null;
		try {
			cosObj2 = (WFMS_COS) wfms_cosPersistence.findBycos(cosId);
		} catch (NoSuchWFMS_COSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cosObj2;
	}

	public WFMS_COS getByCOSId(String cosId) throws SystemException {

		WFMS_COS cosObj = null;

		try {
			cosObj = WFMS_COSUtil.findByPrimaryKey(cosId);
		} catch (NoSuchWFMS_COSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cosObj;
	}

	public WFMS_COS addNewCos(long companyId, long scopeGroupId,
			String createdBy, String assoicateId, String comments)
			throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public WFMS_COS updateCos(WFMS_COS entry)
				throws SystemException {
		return wfms_cosPersistence.update(entry);
	}
	
	public WFMS_COS updateCos(String cosId, long companyId, long scopeGroupId,
			String createdBy, String action, String associatenumber,
			String comments, String associateTitle, String assoicateId,
			String departmentNumber, String positionNumber,
			String leadershipAssignment, String number, String status,
			String manpowerReq, String nextApprover, String routingProcess,
			String notificationTo) throws SystemException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public WFMS_COS getByCOSId(long cosId) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public WFMS_COS getByAssociatenumber(String associatenumber)
			throws SystemException, NoSuchWFMS_PositionException {
		// TODO Auto-generated method stub
		return null;
	}



	public List<WFMS_COS> findByAssociatenumber(String associatenumber)
			throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WFMS_COS> findByNextApprover(String nextApprover)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_cosPersistence.findByNextApprover(nextApprover);
	} 
	
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_COS> findBypositionIdGetByStaus(
			java.lang.String status)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_cosPersistence.findBypositionIdGetByStaus(status);
		}
	public  com.ys.hmawfm.wfms.services.model.WFMS_COS findByassociateId(
			java.lang.String assoicateId)
			throws com.liferay.portal.kernel.exception.SystemException,
				NoSuchWFMS_COSException {
			return wfms_cosPersistence.findByassociateId(assoicateId);
		}
	
	public List<WFMS_COS> findByRoleOfApprover(String roleOfApprover)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_cosPersistence.findByRoleOfApprover(roleOfApprover);
	}
}