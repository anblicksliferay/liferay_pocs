package com.ys.hmawfm.wfms.utils;

import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.DateUtil;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_COS_AuditImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_COS_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalServiceUtil;

public class DeleteAgedRecords implements MessageListener {

	@Override
	public void receive(Message arg0) throws MessageListenerException {
	//	_log.info("Delete Aged Records for Requisition Portlet");
		
		String[]  values = ConfigUtility.getInputValuesFromConfig("delete-old-records");
		int deleteRecordDuration = Integer.parseInt(values[0]);	 
		int flag=1;
		int deleteStatus = 0;
		DateUtil dateUtil=new DateUtil();
		Date todate   = DateUtil.newDate();	
		
		DynamicQuery dynamicANDQuery = WFMS_COSLocalServiceUtil.dynamicQuery();
		Junction junctionAND = RestrictionsFactoryUtil.conjunction();
		dynamicANDQuery.add(PropertyFactoryUtil.forName("status").eq("Draft"));
		dynamicANDQuery.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(deleteStatus));
	    
		dynamicANDQuery.add(junctionAND);
		String cosId="";
		List<WFMS_COS> wfms_List;
		String change="delete aged records";
		
		WFMS_COS_Audit cos_Audit = null;
		cos_Audit = new WFMS_COS_AuditImpl();
		
		try {
			wfms_List = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicANDQuery);		
			
			for (WFMS_COS wfms_cos : wfms_List) {				
				Date fromDate = wfms_cos.getCreateDate();		
							
				int t= dateUtil.getDaysBetween(fromDate, todate);				
				
				if(t > deleteRecordDuration){
				_log.info("delete aged records no of days"+t);
				
				cosId = wfms_cos.getCosId();
				wfms_cos.setDeleteflagStatus(flag);
				
				
				WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_cos);
				
				long aid = CounterLocalServiceUtil.increment(WFMS_COS_Audit.class.getName());
				String auditId =String.valueOf(aid);
				
			   cos_Audit.setCosaId(auditId);
			   cos_Audit.setCosId(cosId);
			   cos_Audit.setCreateDate(new Date());
			   cos_Audit.setChange(change);
			   WFMS_COS_AuditLocalServiceUtil.updateWFMS_COS_Audit(cos_Audit);
				
				
			//	_log.info("delete aged records"+wfms_cos);
				}
			}
			
		        
		} catch (SystemException e) {
			_log.info("SystemException " + e);

		}
		
		DynamicQuery dynamicANDQuery1 = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
		Junction junctionAND1 = RestrictionsFactoryUtil.conjunction();
		dynamicANDQuery1.add(PropertyFactoryUtil.forName("status").eq("Draft"));
		dynamicANDQuery1.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(deleteStatus));
	    
		dynamicANDQuery1.add(junctionAND1);
		String RCid="";

		List<WFMS_Requisition> wfms_List1;
		
		WFMS_Requisition_Audit requisition_Audit = null;
		requisition_Audit = new WFMS_Requisition_AuditImpl();
		
		try {		        
			wfms_List1 = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicANDQuery1);
			
			for (WFMS_Requisition wfms_Requisition : wfms_List1) {
				
				Date fromDate_r = wfms_Requisition.getCreateDate();			
				int t1= dateUtil.getDaysBetween(fromDate_r, todate);
				
				if(t1 > deleteRecordDuration){
				_log.info("delete aged records no of days"+t1);
				
				RCid = wfms_Requisition.getRwfId();
				wfms_Requisition.setDeleteflagStatus(flag);
								
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(wfms_Requisition);
				
				long aid = CounterLocalServiceUtil.increment(WFMS_Requisition_Audit.class.getName());
				String auditId =String.valueOf(aid);
				
			   requisition_Audit.setReqaId(auditId);
			   requisition_Audit.setReqId(RCid);
			   requisition_Audit.setCreateDate(new Date());
			   requisition_Audit.setChange(change);
			   
			   WFMS_Requisition_AuditLocalServiceUtil.updateWFMS_Requisition_Audit(requisition_Audit);
				
				_log.info("delete aged records"+wfms_Requisition);
				}
			}
		        
		} catch (SystemException e) {
			_log.info("SystemException " + e);

		}

	}
	
	
	

	private Log _log = LogFactoryUtil.getLog(DeleteAgedRecords.class);

}
