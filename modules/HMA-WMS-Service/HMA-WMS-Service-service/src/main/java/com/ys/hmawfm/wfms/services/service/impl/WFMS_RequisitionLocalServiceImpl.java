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

import java.util.Date;
import java.util.List;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.base.WFMS_RequisitionLocalServiceBaseImpl;

/**
 * The implementation of the WFMS_Requisition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_RequisitionLocalServiceBaseImpl
 * @see com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil
 */
public class WFMS_RequisitionLocalServiceImpl
	extends WFMS_RequisitionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil} to access the WFMS_Requisition local service.
	 */
	
private Date CreateDate;
	
	public  com.ys.hmawfm.wfms.services.model.WFMS_Requisition findByrequisition(
			java.lang.String rwfId)
			throws com.liferay.portal.kernel.exception.SystemException,
				NoSuchWFMS_RequisitionException {
			return wfms_RequisitionPersistence.findByrequisition(rwfId);
		}	
	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findByStatus_Pid_Colllection(
			java.lang.String status, java.lang.String rId)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_RequisitionPersistence.findByStatus_Pid_Colllection(status, rId);
		}
	public WFMS_Requisition findByposition(String rId)

            throws SystemException,NoSuchWFMS_RequisitionException {

            return wfms_RequisitionPersistence.findByposition(rId);

    }
	
	public WFMS_Requisition findBypositionassociate(String Number,String associatenumber)

            throws SystemException,NoSuchWFMS_RequisitionException {

            return wfms_RequisitionPersistence.findBypositionassociate(Number,associatenumber);

    }

	public List<WFMS_Requisition> findBypositionnumber(String Number)

            throws SystemException,NoSuchWFMS_RequisitionException {

            return wfms_RequisitionPersistence.findBypositionnumber(Number);

    }
	public List<WFMS_Requisition> findBypositionId(String rId)

            throws SystemException,NoSuchWFMS_RequisitionException {

            return wfms_RequisitionPersistence.findBypositionId(rId);

    }
	public List<WFMS_Requisition> findBydummy(String dummy)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_RequisitionPersistence.findBydummy(dummy);
	}
	
	public List<WFMS_Requisition> findByworkflowId(String workflowId)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_RequisitionPersistence.findByworkflowId(workflowId);
	}
	
	public List<WFMS_Requisition> findByNextApprover(String nextapprove)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_RequisitionPersistence.findByNextApprove(nextapprove);
	} 
	
	public WFMS_Requisition addnewRequisition(String rwfid,long companyId, long scopeGroupId, String Number, String associatenumber, String associatename, String status, String postingType, String  teamNumber, String associatetype, String shiftDesc, String howAvailable,  String whoReplaced, String dateneeded, String contactperson, String contactphonenumber, String taleonumber, String other,String comments)  throws SystemException {
		
		Date createDate = new Date();
		WFMS_Requisition entry = wfms_RequisitionPersistence.fetchByPrimaryKey(rwfid);
		WFMS_Position pos = WFMS_PositionLocalServiceUtil.getByPositionId(Number);
		
		entry.setCompanyId(companyId);
		entry.setScopeGroupId(scopeGroupId);
		entry.setRId(Number);
		entry.setNumber(Number);
		entry.setAssociatenumber(associatenumber);
		entry.setAssociatename(associatename);
		entry.setStatus(status);
		entry.setCreateDate(createDate);
		entry.setModifiedDate(createDate);
		entry.setPostingType(postingType);
		entry.setTeamNumber(teamNumber);
		entry.setAssociatetype(associatetype);
		entry.setShiftAssign(shiftDesc);
		entry.setHowAvailable(howAvailable);
		entry.setWhoReplaced(whoReplaced);
		entry.setDateneeded(dateneeded);
		entry.setContactperson(contactperson);
		entry.setContactphonenumber(contactphonenumber);
		entry.setTaleonumber(taleonumber);
		entry.setOther(other);
		return wfms_RequisitionPersistence.update(entry);
		
		}
	
	public WFMS_Requisition addnewtempRequisition(String rwfid,String requisisionnumber,long companyId, long scopeGroupId, String Number, String associatenumber, String associatename, String status, String postingType, String  teamNumber, String associatetype, String shiftDesc, String howAvailable,  String whoReplaced, String dateneeded, String contactperson, String contactphonenumber, String taleonumber, String other)  throws SystemException {
		WFMS_Requisition main_data = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(requisisionnumber);
		main_data.setWorkflowId(rwfid);
		WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(main_data);
		WFMS_Requisition temp_data = new WFMS_RequisitionImpl();
		temp_data.setRwfId(rwfid);
		temp_data.setWorkflowId(requisisionnumber);
		Date createDate = new Date();
		temp_data.setCompanyId(companyId);
		temp_data.setScopeGroupId(scopeGroupId);
		temp_data.setRId(Number);
		temp_data.setNumber(Number);
		temp_data.setCreateDate(main_data.getCreateDate());
		temp_data.setAssociatenumber(associatenumber);
		temp_data.setAssociatename(associatename);
		temp_data.setStatus(status);
		temp_data.setModifiedDate(createDate);
		temp_data.setPostingType(postingType);
		temp_data.setTeamNumber(teamNumber);
		temp_data.setAssociatetype(associatetype);
		temp_data.setShiftAssign(shiftDesc);
		temp_data.setHowAvailable(howAvailable);
		temp_data.setWhoReplaced(whoReplaced);
		temp_data.setDateneeded(dateneeded);
		temp_data.setContactperson(contactperson);
		temp_data.setContactphonenumber(contactphonenumber);
		temp_data.setTaleonumber(taleonumber);
		temp_data.setOther(other);
		String dummy = "0";
		temp_data.setDummy(dummy);
		return wfms_RequisitionPersistence.update(temp_data);
	}
	
	public WFMS_Requisition updateRequisition(WFMS_Requisition entry)
				throws SystemException {
		return wfms_RequisitionPersistence.update(entry);
	}
			
	public WFMS_Requisition updateRequisition(String requisisionnumber, long companyId,
			long scopeGroupId, String number, String associatenumber,
			String associateNameNoNum, String status, String postingType,
			String teamNumber, String associatetype, String shiftDesc,
			String howAvilable, String whoReplaced, String dateneeded,
			String contactperson, String contactphonenumber,
			String taleonumber, String other,String comments)  throws SystemException {
		WFMS_Requisition entry = wfms_RequisitionPersistence.fetchByPrimaryKey(requisisionnumber);
		WFMS_Position posidetails = WFMS_PositionLocalServiceUtil.getByPositionId(number);
		//String te = posidetails.getDepartmentName().substring(0, 3).toUpperCase();
		
		
		entry.setCompanyId(companyId);
		entry.setScopeGroupId(scopeGroupId);
		entry.setRId(number);
		entry.setNumber(number);
	//	entry.setCreateDate(posidetails.getCreateDate());
		entry.setAssociatenumber(associatenumber);
		entry.setAssociatename(associateNameNoNum);
		entry.setStatus(status);
		entry.setPostingType(postingType);
		entry.setTeamNumber(teamNumber);
		entry.setAssociatetype(associatetype);
		entry.setShiftAssign(shiftDesc);
		entry.setHowAvailable(howAvilable);
		entry.setWhoReplaced(whoReplaced);
		entry.setDateneeded(dateneeded);
		entry.setContactperson(contactperson);
		entry.setContactphonenumber(contactphonenumber);
		entry.setTaleonumber(taleonumber);
		entry.setOther(other);
		entry.setModifiedDate(new Date());
		return wfms_RequisitionPersistence.update(entry);
		
		}
	
	public void clearCache() throws SystemException {
		wfms_RequisitionPersistence.clearCache();
	}

	public  java.util.List<com.ys.hmawfm.wfms.services.model.WFMS_Requisition> findBypositionIdGetByStaus(
			java.lang.String status)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_RequisitionPersistence.findBypositionIdGetByStaus(status);
		}
	
	public List<WFMS_Requisition> findByRoleOfApprover(String roleOfApprover)
			throws com.liferay.portal.kernel.exception.SystemException {
			return wfms_RequisitionPersistence.findByRoleOfApprover(roleOfApprover);
	}
}