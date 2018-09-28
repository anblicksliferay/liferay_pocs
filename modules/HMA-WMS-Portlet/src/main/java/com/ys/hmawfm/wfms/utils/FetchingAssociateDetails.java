package com.ys.hmawfm.wfms.utils;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.Validator;
import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.service.WFMS_Associate_HistoryLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_Associate_HistoryUtil;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_PositionUtil;
import com.ys.hmawfm.wfms.services.service.persistence.WFMS_RequisitionUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.vo.AssociateInformation;

public class FetchingAssociateDetails implements MessageListener {
	/**
	 * @author ChandraMouli S
	 *
	 */
	@Override
	public void receive(Message arg0) throws MessageListenerException {
		// TODO Auto-generated method stub
		 AssociateInformation associateInformation=new AssociateInformation();
			boolean isExist=false;
		_log.info("FetchingAssociateDetails");
		try 
		{
			//update position assoicate name and associate Title
			List<WFMS_Position> list=WFMS_PositionLocalServiceUtil.getAll();
       for(WFMS_Position val:list){
        	   WFMS_Position position=WFMS_PositionLocalServiceUtil.fetchWFMS_Position(val.getPId());
        	
				if(Validator.isNotNull(val.getAssociateNumber())){
					 isExist=HMAAssociateInfoService.checkAssociateNumberExist(val.getAssociateNumber().trim());
					if(isExist){
				associateInformation=HMAAssociateInfoService.fetchPositionOnAssociateNumber(val.getAssociateNumber().trim());
				position.setAssociateName(associateInformation.getAssociateName().trim());
				position.setAssociateTitle(associateInformation.getAssociateTitle().trim());
				WFMS_PositionLocalServiceUtil.updateWFMS_Position(position);
				WFMS_PositionUtil.clearCache();
					}
           }    	   
       }
       
     //update Requsition assoicate name and associate Title
       List<WFMS_Requisition> wfms_Requisitions=WFMS_RequisitionLocalServiceUtil.getWFMS_Requisitions(0,WFMS_RequisitionLocalServiceUtil.getWFMS_RequisitionsCount());
       for(WFMS_Requisition wfms_Requisition :wfms_Requisitions){
    		   WFMS_Requisition requisition=WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(wfms_Requisition.getRwfId());
        	  associateInformation=new AssociateInformation();
        		 isExist=false;
				if(Validator.isNotNull(requisition.getAssociatenumber())){
					 isExist=HMAAssociateInfoService.checkAssociateNumberExist(wfms_Requisition.getAssociatenumber().trim());
					if(isExist){
				associateInformation=HMAAssociateInfoService.fetchPositionOnAssociateNumber(wfms_Requisition.getAssociatenumber().trim());
				requisition.setAssociatename(associateInformation.getAssociateName().trim());
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(requisition);
				WFMS_RequisitionUtil.clearCache();
					}
           }    	   
       }
       
     //update Associate History assoicate name and associate Title
			List<WFMS_Associate_History> associate_HistoryList=WFMS_Associate_HistoryLocalServiceUtil.getWFMS_Associate_Histories(0, WFMS_Associate_HistoryLocalServiceUtil.getWFMS_Associate_HistoriesCount());
			for(WFMS_Associate_History associate_History:associate_HistoryList){
					 WFMS_Associate_History wfms_Associate_History=WFMS_Associate_HistoryLocalServiceUtil.fetchWFMS_Associate_History(associate_History.getAssocHistoryId());
		        	  associateInformation=new AssociateInformation();
		        		 isExist=false;
						if(Validator.isNotNull(associate_History.getAssociateId())){
							 isExist=HMAAssociateInfoService.checkAssociateNumberExist(associate_History.getAssociateId().trim());
							if(isExist){
						associateInformation=HMAAssociateInfoService.fetchPositionOnAssociateNumber(associate_History.getAssociateId().trim());
						wfms_Associate_History.setAssociateName(associateInformation.getAssociateName().trim());
						WFMS_Associate_HistoryLocalServiceUtil.updateWFMS_Associate_History(wfms_Associate_History);
						WFMS_Associate_HistoryUtil.clearCache();
							}
		           }    	   
			}
       
       
		} catch (Exception e) {
			_log.error(" error in FetchingAssociateDetails class " +e);
		}
		
		
		
	}

		private Log _log = LogFactoryUtil.getLog(FetchingAssociateDetails.class);

}
