package com.ys.hmawfm.wfms.workflow;

import java.io.IOException;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.json.JSONException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
// test
public class ModifyPositionWorkflowContext {
	private static Log logger = LogFactoryUtil.getLog(ModifyPositionWorkflowContext.class.getName());
	public static String processModifyPosition(int i,ActionRequest portletRequest,ActionResponse portletResponse) throws SystemException, JSONException, IOException, PortalException, AddressException, WindowStateException, PortletModeException{
		String returnValue="";
		switch (i) {
		case 0:
			processModifyPosition(4,portletRequest,portletResponse);
			break;
		case 1:
			//logger.info("------->Enter to case 1<---------");
			break;
		case 2:
			ModifyPositionWFHelper.hasCOSOpenPopUpForCosOpen(portletRequest, portletResponse);
			//returnValue="Cannot Make Chages at the time of an open COS";
			//logger.info("------->Enter to case 2<---------");
			break;
		case 3:
			//logger.info("------->Enter to case 3<---------");
		    ModifyPositionWFHelper.hasCOSOpenPopUpForRequisitionOpen(portletRequest, portletResponse);
			returnValue="3";
			break;
		case 4:
			//logger.info("------->Enter to case 4<---------");
			//if(ParamUtil.getBoolean(portletRequest,"onSubmit"))
			
			ModifyPositionWFHelper.createModifyPosition(portletRequest, portletResponse);
			//processModifyPosition(8,portletRequest,portletResponse);
			break;
		case 5:
			//logger.info("------->Enter to case 5<---------");
			processModifyPosition(4,portletRequest,portletResponse);
			break;
		case 6:
			//logger.info("------->Enter to case 6<---------");
			processModifyPosition(4,portletRequest,portletResponse);
			break;
		case 7:
			//logger.info("------->Enter to case 7<---------");
			processModifyPosition(4,portletRequest,portletResponse);
			break;
		case 8:
			//logger.info("------->Enter to case 8<---------");
			ModifyPositionWFHelper.mailnotificationforModifyPosition(portletRequest, portletResponse);
			processModifyPosition(9,portletRequest,portletResponse);
			break;
		case 9:
			//logger.info("------->Enter to case 9<---------");
			ModifyPositionWFHelper.sendMailNotificationToDMUser(portletRequest, portletResponse);
			//processModifyPosition(12,portletRequest,portletResponse);
			break;
		case 10:
			//logger.info("------->Enter to case 10<---------");
			processModifyPosition(6,portletRequest,portletResponse);
			break;
		case 11:
			//logger.info("------->Enter to case 11<---------");
			if(ModifyPositionWFHelper.isRequisitionStatFilled(portletRequest, portletResponse)){
				processModifyPosition(3,portletRequest,portletResponse);
			}else{
				processModifyPosition(15,portletRequest,portletResponse);
			}
			
			break;
		case 12:
			//logger.info("------->Enter to case 12<---------");
			if(ParamUtil.getBoolean(portletRequest,"flowControl")){
				processModifyPosition(13,portletRequest,portletResponse);
			}else{
				processModifyPosition(6,portletRequest,portletResponse);
			}
			
			break;
		case 13:
			//logger.info("------->Enter to case 13<---------");
			if(ModifyPositionWFHelper.isRequisitionModified(portletRequest, portletResponse)){
				processModifyPosition(14,portletRequest,portletResponse);
			}else{
				processModifyPosition(23,portletRequest,portletResponse);
			}
			break;
		case 14:
			
			boolean verify=ModifyPositionWFHelper.isRequisitionActive(portletRequest, portletResponse);
			//logger.info("------->Enter to case 14<---------");
			if(verify){
				processModifyPosition(11,portletRequest,portletResponse);
			}else{
				processModifyPosition(19,portletRequest,portletResponse);
			}
			break;
		case 15:
			//logger.info("------->Enter to case 15<---------");
			ModifyPositionWFHelper.putRequisitionOnHold(portletRequest, portletResponse);
			processModifyPosition(19,portletRequest,portletResponse);
			break;
		case 16:
			//logger.info("------->Enter to case 16<---------");
			processModifyPosition(7,portletRequest,portletResponse);
			break;
		case 17:
			//logger.info("------->Enter to case 17<---------");
			processModifyPosition(21,portletRequest,portletResponse);
			break;
		case 18:
			//logger.info("------->Enter to case 18<---------");
			//if(true){
				processModifyPosition(25,portletRequest,portletResponse);
			//}else{
				//processModifyPosition(17,portletRequest,portletResponse);
			//}
			break;
		case 19:
			//logger.info("------->Enter to case 19<---------");
			ModifyPositionWFHelper.sendMailNotificationToStaffingUser(portletRequest, portletResponse);
			//processModifyPosition(24,portletRequest,portletResponse);
			break;
		case 20:
			//logger.info("------->Enter to case 20<---------");
			processModifyPosition(6,portletRequest,portletResponse);
			break;
		case 21:
			//logger.info("------->Enter to case 21<---------");
			if(ParamUtil.getBoolean(portletRequest,"flowControl")){
				processModifyPosition(25,portletRequest,portletResponse);
			}else{
				processModifyPosition(16,portletRequest,portletResponse);
			}
			break;
		case 22:
			//logger.info("------->Enter to case 22<---------");
			ModifyPositionWFHelper.sendMailNotificationToPayrollUser(portletRequest, portletResponse);
			//need write mail notification to payroll
			//processModifyPosition(18,portletRequest,portletResponse);
			break;
		case 23:
			//logger.info("------->Enter to case 23<---------");
			if(ModifyPositionWFHelper.isLadderPosChanged(portletRequest, portletResponse)){
				processModifyPosition(22,portletRequest,portletResponse);
			}else{
				processModifyPosition(25,portletRequest,portletResponse);
			}
			break;
		case 24:
			//logger.info("------->Enter to case 24<---------");
			if(ParamUtil.getBoolean(portletRequest,"flowControl")){
				processModifyPosition(23,portletRequest,portletResponse);
			}else{
				processModifyPosition(6,portletRequest,portletResponse);
			}
			break;
		case 25:
			//logger.info("------->Enter to case 25<---------");
			if(ModifyPositionWFHelper.isPositionFilled(portletRequest, portletResponse)){
				processModifyPosition(27,portletRequest,portletResponse);
			}else{
				processModifyPosition(26,portletRequest,portletResponse);
			}
			break;
		case 26:
			//logger.info("------->Enter to case 26<---------");
			ModifyPositionWFHelper.updatePositiontoRefPos(portletRequest, portletResponse);
			processModifyPosition(30,portletRequest,portletResponse);
			break;
		case 27:
			//logger.info("------->Enter to case 27<---------");
			if(ModifyPositionWFHelper.isLeadershipPosChanged(portletRequest, portletResponse)){
				processModifyPosition(28,portletRequest,portletResponse);
			}else{
				processModifyPosition(26,portletRequest,portletResponse);
			}
			break;
		case 28:
			//logger.info("------->Enter to case 28<---------");
			ModifyPositionWFHelper.updatePosWithStepRef(portletRequest, portletResponse, 28);
			break;
		case 29:
			//logger.info("------->Enter to case 29<---------");
			processModifyPosition(32,portletRequest,portletResponse);
			break;
		case 30:
			//logger.info("------->Enter to case 30<---------");
			if(ModifyPositionWFHelper.isReqOnHold(portletRequest, portletResponse)){
				processModifyPosition(29,portletRequest,portletResponse);
			}else{
				processModifyPosition(33,portletRequest,portletResponse);
			}
			break;
		case 31:
			//logger.info("------->Enter to case 31<---------");
			processModifyPosition(26,portletRequest,portletResponse);
			break;
		case 32:
			//logger.info("------->Enter to case 32<---------");
			processModifyPosition(33,portletRequest,portletResponse);
			break;
		case 33:
			//logger.info("------->Enter to case 33<---------");
			processModifyPosition(34,portletRequest,portletResponse);
			break;
		case 34:
			//logger.info("------->Enter to case 34<---------");
			break;
		default:
			break;
		}
		
		return returnValue;
	}
	
}
