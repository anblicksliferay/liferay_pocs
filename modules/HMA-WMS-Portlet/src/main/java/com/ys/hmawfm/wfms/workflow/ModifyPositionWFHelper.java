package com.ys.hmawfm.wfms.workflow;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.json.JSONException;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.EmailUtility;
import com.ys.hmawfm.wfms.utils.GenerateFrindlyURL;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.HondaPermissionKeys;
import com.ys.hmawfm.wfms.vo.AssociateInformation;

public class ModifyPositionWFHelper {
	private static Log logger = LogFactoryUtil.getLog(ModifyPositionWFHelper.class.getName());
	//private static Log logger = LogFactoryUtil.getLog(ModifyPositionWFHelper.class.getName());
	// step:0
	public static boolean hasCOSOpen(ActionRequest portletRequest,
			ActionResponse portletResponse) throws SystemException,
	NoSuchWFMS_COSException {
		//logger.info("has cos Open for COS" +ParamUtil.getString(portletRequest, "positionid"));
		String posid = ParamUtil.getString(portletRequest, "positionid");
		List<WFMS_COS>  wfms_COSs=WFMS_COSLocalServiceUtil.findBycosIdGetByPosId(posid);
		 boolean cosVerify=true;
		 if(!wfms_COSs.isEmpty()){
			 cosVerify=(HondaPermissionKeys.COS_DRAFT.equalsIgnoreCase(wfms_COSs.get(0).getStatus())  || HondaPermissionKeys.COS_SUBMIT.equalsIgnoreCase(wfms_COSs.get(0).getStatus()));
		 }
		 return cosVerify;
	}
	//step:2
	public static void hasCOSOpenPopUpForCosOpen(ActionRequest portletRequest,
			ActionResponse portletResponse) throws SystemException,
	NoSuchWFMS_COSException {
		    String posid = ParamUtil.getString(portletRequest, "positionid");
		    WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
	        portletRequest.setAttribute("positionId", posid);
			portletRequest.setAttribute("wfms_PositionObj", wfms_Position);
		    logger.info(wfms_Position+"wfms_Position");
			portletRequest.setAttribute("ModifyPositionPopUpCOSOpen", "ModifyPositionPopUpCOSOpen");
			portletResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");	
	}
	public static void hasCOSOpenPopUpForRequisitionOpen(ActionRequest portletRequest,
			ActionResponse portletResponse) throws SystemException,
	NoSuchWFMS_COSException { 
			
	    	String posid = ParamUtil.getString(portletRequest, "positionid");
	    	_log.info("hasCOSOpenPopUpForRequisitionOpen");
	    	List<WFMS_Requisition> requisition=null;
	    	long wfmReqcount=0;
	    	try {
	    		
	    		DynamicQuery wfmReq =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
	    		wfmReq.add(PropertyFactoryUtil.forName("rId").eq(posid));
	    		wfmReq.add(PropertyFactoryUtil.forName("status").eq(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER));
				wfmReqcount = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(wfmReq);
				//if(wfmReqcount > 0){
	    		
	    		//requisition= WFMS_RequisitionLocalServiceUtil.findByStatus_Pid_Colllection(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER,posid);
	    		
	    		
	    		
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
	    //if(Validator.isNotNull(requisition))
		if(wfmReqcount > 0){
		   portletRequest.setAttribute("ModifyPosPopUpforReq", "ModifyPosPopUpforReq");
		   }
		portletResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");	
	    }
	
	//step:8
	public static void mailnotificationforModifyPosition(ActionRequest portletRequest,
			ActionResponse portletResponse) throws SystemException,
			PortalException, AddressException {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		//long companyId=themeDisplay.getCompanyId();
		//EmailUtility.sendMailsToUserRoles(HondaPermissionKeys.ROLE_CMP, null, portletRequest,"", "");
		//EmailUtility.sendMailsToUserRoles(HondaPermissionKeys.ROLE_CMP, null, portletRequest);
	}
	//step:9
		public static void sendMailNotificationToDMUser(ActionRequest portletRequest,
				ActionResponse portletResponse) throws SystemException,
				PortalException, AddressException, WindowStateException, PortletModeException {
			/*ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId=themeDisplay.getCompanyId();
		    Role DmRole= RoleLocalServiceUtil.getRole(companyId,HondaPermissionKeys.ROLE_DM);		  
			List<User> mailUsers=UserLocalServiceUtil.getRoleUsers(DmRole.getRoleId());
			InternetAddress[] internetAddresses=new InternetAddress[mailUsers.size()]; 
			for (int i=0;i<mailUsers.size();i++) {
				internetAddresses[i]=new InternetAddress(mailUsers.get(i).getEmailAddress());
			}*/
			String posid = ParamUtil.getString(portletRequest, "positionid");
			_log.info("enter to sendMailNotificationToDMUser function and pos No >>>"+posid);
			WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.findByposition(posid);
			/*String emailToAddress ="";
			String emailFromName = "Surya"; 
			String emailFromAddress = "testproject1886@gmail.com";
			String emailSubject = "This Position Is Modified "+posid;
			String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
			String emailMessage = "This Position is Modified please check once"+"    "+"check this position "+url;
			EmailUtility.sendMailsToUserRoles(HondaPermissionKeys.ROLE_CMP, null, portletRequest,"", "");*/
			/*String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);	
			
			String subject ="Department Manager: Position"+ posid+" has been modified and needs your approval.";
			String body ="Position " + posid+ " has been modified .<br/>Please click the link below to approve the position.<br/> <p><a href='"+url+"'> Click here to review the record</a></p>";
			
			EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_Position.getDepartmentNumber(), portletRequest,subject, body);
			subject ="Notification: Hello "+HondaPermissionKeys.ROLE_CMP+" this position "+ posid+" is modified";
			
			EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP, null, portletRequest,subject, body);
			subject ="Notification: Hello "+HondaPermissionKeys.ROLE_SPDM+" this position "+ posid+" is modified";
			
			EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM, null, portletRequest,subject, body);*/
			wfms_Position.setWorkflowStep(12);
			Map<String, String> hondamap=new HashMap<String, String>();
			wfms_Position=WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
			_log.info("-------->Record is updated with step 12<--------");
			try {
				hondamap = HondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
				wfms_Position.setNextApprover(hondamap.get("deptMgrName"));
				_log.info("-------->set NextApprover<--------"+hondamap.get("deptMgrName"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
			_log.info("-------->Record is updated with next approver<--------");
		}
	//step:14
	public static boolean isRequisitionActive(ActionRequest portletRequest,
			ActionResponse portletResponse) throws SystemException,
	NoSuchWFMS_COSException, NoSuchWFMS_RequisitionException {
		String positionId = ParamUtil.getString(portletRequest, "positionId");
		//logger.info("Position Ids :::: "+positionId);
		boolean activerequisition=false;
		try{
		WFMS_Requisition requisition=WFMS_RequisitionLocalServiceUtil.findByposition(positionId);
		//logger.info("Get Requesition Ids :::: "+requisition.getRwfId()+" Status is "+requisition.getStatus());
		
		DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
		   dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(positionId));
		   Long TotalRequisations = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
		   
		   Criterion reqcriterion = null;
		   reqcriterion = RestrictionsFactoryUtil.like("status",HondaPermissionKeys.REQ_CANCELLED);
		   reqcriterion = RestrictionsFactoryUtil.or(reqcriterion , RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_COMPLETE));
		   dynamicQueryForRequisation.add(reqcriterion);
		   Long requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
		   if(TotalRequisations!=requisationList){
			   activerequisition = true;
		   }
		   
		   
		/*if (HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER
				.equalsIgnoreCase(requisition.getStatus())
				|| HondaPermissionKeys.REQ_SUBMITTED
						.equalsIgnoreCase(requisition.getStatus())
				|| HondaPermissionKeys.REQ_COMPLETE_PENDING_APPROVAL
						.equalsIgnoreCase(requisition.getStatus())
				|| HondaPermissionKeys.REQ_ONHOLD.equalsIgnoreCase(requisition
						.getStatus())
				|| HondaPermissionKeys.REQ_DRAFT.equalsIgnoreCase(requisition
						.getStatus())
				|| HondaPermissionKeys.REQ_WAITINGONMANPOWER
						.equalsIgnoreCase(requisition.getStatus())) {
			activerequisition = true;

		}*/
		}catch(Exception e){
			logger.error("ERROR IN ::: "+e.getMessage());
		}
		return activerequisition;

	}
	
	//step:11
	//requisition
	public static boolean isRequisitionStatFilled(ActionRequest portletRequest,
			ActionResponse portletResponse) throws NoSuchWFMS_RequisitionException, SystemException{
		boolean reqFilled=false;
		String positionId = ParamUtil.getString(portletRequest, "positionId");
		DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
		dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(positionId));
		   Criterion reqcriterion = null;
		   reqcriterion = RestrictionsFactoryUtil.ne("status",HondaPermissionKeys.REQ_CANCELLED);
		   reqcriterion = RestrictionsFactoryUtil.and(reqcriterion , RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_COMPLETE));
		   dynamicQueryForRequisation.add(reqcriterion);
		   List<WFMS_Requisition> requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation);
		   if(requisationList.size()>0){
		     
		      String status=requisationList.get(0).getStatus();
		
		     if(status.equalsIgnoreCase(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER)){
		    	 reqFilled=true;
		     }
		   }
			return reqFilled;
	}
	//step:15
		//requisition
		public static void putRequisitionOnHold(ActionRequest portletRequest,
				ActionResponse portletResponse) throws SystemException, NoSuchWFMS_RequisitionException{
			String positionId = ParamUtil.getString(portletRequest, "positionId");
			
			
			
			DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
			dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(positionId));
			   Criterion reqcriterion = null;
			   reqcriterion = RestrictionsFactoryUtil.ne("status",HondaPermissionKeys.REQ_CANCELLED);
			   reqcriterion = RestrictionsFactoryUtil.and(reqcriterion , RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_COMPLETE));
			   dynamicQueryForRequisation.add(reqcriterion);
			   List<WFMS_Requisition> requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation);


			
			WFMS_Requisition requisition =WFMS_RequisitionLocalServiceUtil.findByrequisition(requisationList.get(0).getRwfId());
			try{
			   WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(requisationList.get(0).getRwfId()+"-WFM");
			}catch(Exception e){
				logger.error(e.getMessage());
			}
			String rwfId=requisationList.get(0).getRwfId();
			_log.info("rwfId"+rwfId);
			requisition.setRwfId(rwfId+"-WFM");
			requisition.setDummy("1");
			WFMS_Requisition dummy_wfms_Requisition=WFMS_RequisitionLocalServiceUtil.updateRequisition(requisition);
			
			//WFMS_Requisition dummy_wfms_Requisition=WFMS_RequisitionLocalServiceUtil.createWFMS_Requisition(requisition.getRwfId()+"-WFM");
			//dummy_wfms_Requisition.setStatus(requisition.getStatus());
			//dummy_wfms_Requisition.setRId(requisition.getRId());
			//dummy_wfms_Requisition.setDummy("1");
			//WFMS_RequisitionLocalServiceUtil.addWFMS_Requisition(dummy_wfms_Requisition);
			
			WFMS_Requisition mainRequisition=WFMS_RequisitionLocalServiceUtil.findByrequisition(rwfId);
			mainRequisition.setStatus(HondaPermissionKeys.REQ_ONHOLD);
			WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(mainRequisition);
			//logger.info("requisition"+requisition);
		}
		//step:19
		public static void sendMailNotificationToStaffingUser(ActionRequest portletRequest,
				ActionResponse portletResponse) throws SystemException,
				PortalException, AddressException, WindowStateException, PortletModeException, IOException {
			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId=themeDisplay.getCompanyId();
		    Role DmRole= RoleLocalServiceUtil.getRole(companyId,HondaPermissionKeys.ROLE_STAFFING);		  
			List<User> mailUsers=UserLocalServiceUtil.getRoleUsers(DmRole.getRoleId());
			InternetAddress[] internetAddresses=new InternetAddress[mailUsers.size()]; 
			for (int i=0;i<mailUsers.size();i++) {
				internetAddresses[i]=new InternetAddress(mailUsers.get(i).getEmailAddress());
			}
			String posid = ParamUtil.getString(portletRequest, "positionId");
			//logger.info("Positionid :: >>" + posid);
			
			/*String emailSubject = "This Position Is Modified "+posid;
			String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
			String emailMessage = "This Position is Modified please check once"+"    "+"check this position "+url;
			EmailUtility.sendMailsToUserRoles(HondaPermissionKeys.ROLE_CMP, null, portletRequest,emailSubject,emailMessage);*/
		//	EmailUtility.modifyPositionMailSender(portletRequest, posid,HondaPermissionKeys.ROLE_STAFFING);
			
	
			
			DynamicQuery studentQuery = WFMS_Position_AuditLocalServiceUtil.dynamicQuery();

					studentQuery.add(PropertyFactoryUtil.forName("comments").eq(WorkflowConstants.POSITION_MODIFY_POSITION_SUBMIT));

					studentQuery.add(PropertyFactoryUtil.forName("pId").eq(posid));
					List<WFMS_Position_Audit> list = WFMS_Position_AuditLocalServiceUtil.dynamicQuery(studentQuery);
					//System.out.println(list.size());
					String changelist = StringPool.BLANK;
					if(list.size()>0){
						for(WFMS_Position_Audit l:list){
							changelist = l.getChange();
						}
					}
					//System.out.println("changelist:"+changelist);
			
		
			String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
			String subject ="Staffing: Position "+ posid +" has been modified and needs your approval.";
			String body ="Position " + posid+ " has been modified " +changelist+ "  .<br/> Please click the link below to approve the position.<br/> <p><a href='"+url+"'> Click here to review the record</a></p>";
			EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING, null, portletRequest,subject, body);

			 WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(posid);
			 wfms_Position.setWorkflowStep(24);
			 wfms_Position.setNextApprover(StringUtil.merge(HondaLogicUtil.listOfrolseusers("", portletRequest, HondaPermissionKeys.ROLE_STAFFING),"<br/>"));			
			 WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
			 logger.info("Step 24 Completed");
			 portletResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(portletRequest));

		}
		
		//step:22
		public static void sendMailNotificationToPayrollUser(ActionRequest portletRequest,
				ActionResponse portletResponse) throws SystemException,
				PortalException, AddressException, WindowStateException, PortletModeException, IOException {
			/*ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId=themeDisplay.getCompanyId();*/
		   /* Role DmRole= RoleLocalServiceUtil.getRole(companyId,HondaPermissionKeys.ROLE_PAYROLL);		  
			List<User> mailUsers=UserLocalServiceUtil.getRoleUsers(DmRole.getRoleId());
			InternetAddress[] internetAddresses=new InternetAddress[mailUsers.size()]; 
			for (int i=0;i<mailUsers.size();i++) {
				internetAddresses[i]=new InternetAddress(mailUsers.get(i).getEmailAddress());
			}*/
			String posid = ParamUtil.getString(portletRequest, "positionId");
			/*String emailToAddress ="";
			String emailFromName = "Surya"; 
			String emailFromAddress = "testproject1886@gmail.com";
			String emailSubject = "This Position Is Modified "+posid;
			String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
			String emailMessage = "This Position is Modified please check once"+"    "+"check this position "+url;
			EmailUtility.sendMailsToUserRoles(HondaPermissionKeys.ROLE_CMP, null, portletRequest,"", "");*/
			String url=GenerateFrindlyURL.getHMAfrindlyURL(portletRequest, posid);
			String subject ="Payroll: Modifications to Position "+ posid +" have been Approved.";
			String body ="This Position " + posid+ "  which has been modified and submitted has been approved. <br/> Click the below link to access the Position. <br/> <p><a href='"+url+"'> Click here to review the record</a></p>";
			EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_PAYROLL, null, portletRequest,subject, body);
			
			
		//	EmailUtility.modifyPositionMailSender(portletRequest, posid,HondaPermissionKeys.ROLE_CMP);
			 WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.findByposition(posid);
			 wfms_Position.setWorkflowStep(18);
			 wfms_Position.setNextApprover(StringUtil.merge(HondaLogicUtil.listOfrolseusers("", portletRequest, HondaPermissionKeys.ROLE_PAYROLL),"<br/>"));
			 WFMS_Position wfms_Position2=WFMS_PositionLocalServiceUtil.updatePositionEntry(wfms_Position);
			 logger.info("::: Waiting for DM Approval :::" + wfms_Position2.getWorkflowStep() + " :::  > ");
			// ((StateAwareResponse) portletResponse).setRenderParameter("jspPage", "/html/position/managePosition.jsp");	
			// portletResponse.encodeURL(GenerateFrindlyURL.renderManageCOS(portletRequest));
			 portletResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(portletRequest));
		}	
		//step17
		public static void changePayrollEmployeeCategory(ActionRequest portletRequest,
				ActionResponse portletResponse) throws SystemException,
				PortalException, AddressException, WindowStateException, PortletModeException {
			
		}
		//step25
				public static boolean isPositionFilled(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException,
						PortalException, AddressException, WindowStateException, PortletModeException {
					
					
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					String empCategory=ParamUtil.getString(portletRequest, "empCategory");
					boolean isPOSFilled=false;
					WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
					WFMS_Position org_wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					if(wfms_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED) && !empCategory.equalsIgnoreCase("")){
							org_wfms_Position.setEmpCategory(empCategory);
							WFMS_PositionLocalServiceUtil.updateWFMS_Position(org_wfms_Position);
					}
					//logger.info("Status For Existing Position is ::: "+wfms_Position.getStatus());
					//logger.info("HondaPermissionKeys.POS_FILLED :::: "+HondaPermissionKeys.POS_FILLED);
					//logger.info("Is Position Filled ??? "+HondaPermissionKeys.POS_FILLED.equalsIgnoreCase(wfms_Position.getStatus()));
					if(HondaPermissionKeys.POS_FILLED.equalsIgnoreCase(wfms_Position.getStatus())){
						isPOSFilled=true;
					}
					return isPOSFilled;
				}
		       //step4
				public static void createModifyPosition(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException, PortalException{
					    String positionId=ParamUtil.getString(portletRequest, "positionId");
					//WFMS_Position org_wfms_Position=WFMS_PositionLocalServiceUtil.getWFMS_Position(positionId);
					
					
					//WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionId+"-WFM");
					
					
				//	updatePositionClone(org_wfms_Position, wfms_Position);
					
					DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
					wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionId));
					int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
					if(wfmPositionforTempcount > 0){
					       WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionId);
					}
					wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
					wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionId+"-WFM"));
					wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
					if(wfmPositionforTempcount > 0){
						WFMS_Position wfmsPosition = WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
						wfmsPosition.setDummy("0");
						wfmsPosition.setPId(positionId);
						wfmsPosition=WFMS_PositionLocalServiceUtil.updatePositionEntry(wfmsPosition);       
					    wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
						wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionId+"-WFM"));
						wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);	
						if(wfmPositionforTempcount > 0){
						       WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionId+"-WFM");
						}
					}
					try{
					List<WFMS_Requisition> wfms_RequisitionList=WFMS_RequisitionLocalServiceUtil.findBypositionId(positionId);
					
					for (WFMS_Requisition wfms_Requisition:wfms_RequisitionList) {
						if(wfms_Requisition.getStatus().equals(HondaPermissionKeys.REQ_ONHOLD)){
							String reqId= wfms_Requisition.getRwfId();
							
							WFMS_Requisition wfms_req=WFMS_RequisitionLocalServiceUtil.findByrequisition(reqId+"-WFM");
							wfms_Requisition.setStatus(wfms_req.getStatus());
							wfms_Requisition.setDummy("0");
     						WFMS_RequisitionLocalServiceUtil.updateRequisition(wfms_Requisition);
	                        WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(reqId+"-WFM");
								
						}
					}
					}catch(Exception e){
						logger.error(":: Cannot Find Dummy Requesition :: ");
					}
				}
				//step23
				public static boolean isLadderPosChanged(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException{
					boolean isModified=true;
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					WFMS_Position refPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
					wfms_Position.getLadder();
					wfms_Position.getDescription();
					wfms_Position.getType();
					if ((wfms_Position.getLadder()
							.equalsIgnoreCase(refPosition.getLadder()))
							&& (wfms_Position.getDescription().equalsIgnoreCase(refPosition
									.getDescription()))
							&& (wfms_Position.getType().equalsIgnoreCase(refPosition
									.getType()))) {
						
						isModified=false;
			
					}
					return isModified;
				}
				
				//step27
				public static boolean isLeadershipPosChanged(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException{
					boolean isModified=false;
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					WFMS_Position refPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
					/*wfms_Position.getLadder();
					wfms_Position.getDescription();
					wfms_Position.getType();*/
					boolean isLeadershipAssignment=wfms_Position.getLeadershipAssignment().equalsIgnoreCase(refPosition.getLeadershipAssignment());
					boolean isTypeModified=wfms_Position.getType().equalsIgnoreCase(refPosition.getType());
					boolean isLadderModified=wfms_Position.getLadder().equalsIgnoreCase(refPosition.getLadder());
					//logger.info(isLeadershipAssignment+" ::: "+isTypeModified+" :::: "+" ::: "+isLadderModified);
					/*if ((wfms_Position.getLeadershipAssignment()
							.equalsIgnoreCase(refPosition.getLeadershipAssignment()))
							|| (wfms_Position.getType().equalsIgnoreCase(refPosition
									.getType()) || (wfms_Position.getLadder()
											.equalsIgnoreCase(refPosition.getLadder())))
							) {*/
					if(!isLeadershipAssignment || !isTypeModified || !isLadderModified){
						isModified=true;
					}
					return isModified;
				}
				
				//step26
				public static void updatePositiontoRefPos(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException, PortalException{
					try{
						String positionId=ParamUtil.getString(portletRequest, "positionId");
						//logger.info("Position for COS ::: >>"+positionId);
						WFMS_Position modifyPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					//	System.out.println("enter to functiona for update111111>>>"+modifyPosition.getEmpCategory());
						if(HondaPermissionKeys.POS_MODFIED.equalsIgnoreCase(modifyPosition.getStatus())){
							
							WFMS_Position orgWfmsPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
							modifyPosition.setStatus(orgWfmsPosition.getStatus());
							modifyPosition.setNextApprover("");
							
							modifyPosition.setWorkflowStep(orgWfmsPosition.getWorkflowStep());
							modifyPosition=WFMS_PositionLocalServiceUtil.updatePositionEntry(modifyPosition);
					     	WFMS_PositionLocalServiceUtil.deleteWFMS_Position(orgWfmsPosition);
					    // 	System.out.println("enter to functiona for update");
					     //	System.out.println("enter to functiona for update>>>"+modifyPosition.getEmpCategory());
						}
					}catch(Exception exception){
						//logger.info(exception.getMessage());
					}
				}
				
				//step30
				public static boolean isReqOnHold(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException, PortalException{
					boolean isReqHold=false;
					try{
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					//WFMS_Requisition wfms_Requisition=WFMS_RequisitionLocalServiceUtil.findByposition(positionId);
					
                    List<WFMS_Requisition> wfms_RequisitionList=WFMS_RequisitionLocalServiceUtil.findBypositionId(positionId);
					
					for (WFMS_Requisition wfms_Requisition:wfms_RequisitionList) {
						if(wfms_Requisition.getStatus().equals(HondaPermissionKeys.REQ_ONHOLD)){
							WFMS_Requisition dummy_wfms_Requisition=WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(wfms_Requisition.getRwfId()+"-WFM");
								wfms_Requisition.setStatus(dummy_wfms_Requisition.getStatus());
								wfms_Requisition.setDummy("0");
								WFMS_RequisitionLocalServiceUtil.updateRequisition(wfms_Requisition);
								WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(dummy_wfms_Requisition);
						}
					}
					////logger.info("::: Present REQ Status::: "+ wfms_Requisition.getStatus());
					////logger.info("::: Dummy REQ Status::: "+ dummy_wfms_Requisition.getStatus());
					////logger.info("30) Requestion Status :: >> "+ HondaPermissionKeys.REQ_ONHOLD.equalsIgnoreCase(wfms_Requisition.getStatus()));
					
					}catch(Exception exception){
						logger.error(exception);
					}
					return isReqHold;
				}
				
				//step:32
				//requisition
				public static void releaseRequisition(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException, PortalException{
					
					//String positionId=ParamUtil.getString(portletRequest, "positionId");
									
					//logger.info("::: Workflow existed sucessfully ::: ");
				}
				
				//step13
				public static boolean isRequisitionModified(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException, PortalException{
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					boolean isModified=false;
					WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					WFMS_Position getPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
					
					
					if(!getPosition.getTypicalJobTitle().equalsIgnoreCase(wfms_Position.getTypicalJobTitle()))
						isModified=true;
			        
			        if(!getPosition.getMinJobKnowHow().equalsIgnoreCase(wfms_Position.getMinJobKnowHow()))
			        	isModified=true;
			        
			        if(!getPosition.getDuties().equalsIgnoreCase(wfms_Position.getDuties()))
			        	isModified=true;
			      
			        if(!getPosition.getTasksPerformed().equalsIgnoreCase(wfms_Position.getTasksPerformed()))
			        	isModified=true;
			       
			        if(!getPosition.getLengthOfService().equalsIgnoreCase(wfms_Position.getLengthOfService()))
			        	isModified=true;
			        
			        if(!getPosition.getDegree().equalsIgnoreCase(wfms_Position.getDegree()))
			        	isModified=true;

			        if(!getPosition.getReqSkills().equalsIgnoreCase(wfms_Position.getReqSkills()))
			        	isModified=true;
			        
			        if(!getPosition.getDesiredSkills().equalsIgnoreCase(wfms_Position.getDesiredSkills()))
			        	isModified=true;
			       
			        if(!getPosition.getEnvironment().equalsIgnoreCase(wfms_Position.getEnvironment()))
			        	isModified=true;
			       
			        if(!getPosition.getWeeklyOvertime().equalsIgnoreCase(wfms_Position.getWeeklyOvertime()))
			        	isModified=true;
			        
			        if(!getPosition.getFrequencyOfTravel().equalsIgnoreCase(wfms_Position.getFrequencyOfTravel()))
			        	isModified=true;
					
					
					//List<WFMS_Requisition> requisitionList=WFMS_RequisitionLocalServiceUtil.findBypositionId(positionId);
					/*DynamicQuery dynamicQueryForRequisation = DynamicQueryFactoryUtil.forClass(WFMS_Requisition.class);
					dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(positionId));
					Long TotalRequisations = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
					
					Criterion reqcriterion = null;
					reqcriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.REQ_CANCELLED);
					reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_COMPLETE));
					reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_SAVE));
					dynamicQueryForRequisation.add(reqcriterion);
					Long requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);*/
					
					
					
					
					//if(TotalRequisations!=requisationList){
						
					//}
						
					/*if(Validator.isNotNull(requisitionList.get(0).getModifiedDate()) && Validator.isNotNull(wfms_Position.getModifiedDate())){	
						int compare=wfms_Position.getModifiedDate().compareTo(requisitionList.get(0).getModifiedDate());
							if(compare<0){
								isModified=true;
							}
						}
					}
*/					return isModified;
				}
				//step28
				public static void updatePosWithStepRef(ActionRequest portletRequest,
					ActionResponse portletResponse,int step) throws SystemException, PortalException, JSONException, WindowStateException, PortletModeException, IOException{
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					wfms_Position.setWorkflowStep(step);
					wfms_Position.setNextApprover(HondaPermissionKeys.ROLE_WAITING_ON_COS);
					WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
					createCOSForPos(portletRequest, portletResponse);
				}
				
				public static void createCOSForPos(ActionRequest portletRequest,
					ActionResponse portletResponse) throws SystemException, PortalException, JSONException, WindowStateException, PortletModeException, IOException{

					   String emailMessage="";
				        String emailSubject = "";
				        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
						long userId = themeDisplay.getUserId();
						User user = UserLocalServiceUtil.getUserById(userId);
						 String Manager_email="";
					String positionId=ParamUtil.getString(portletRequest, "positionId");
					WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
					String id = StringPool.BLANK;
					long cosId = CounterLocalServiceUtil.increment(WFMS_COS.class.getName());
					int genId = HondaLogicUtil.getCurrentKi();
					Integer intObj = new Integer(genId);
					id = intObj + "-" + String.format("%04d", cosId);
					WFMS_COS wfms_cos=WFMS_COSLocalServiceUtil.createWFMS_COS(id);
					wfms_cos.setCosId(id);
					AssociateInformation obj=null;
					try {
						 obj=HMAAssociateInfoService.fetchPositionOnAssociateNumber(wfms_Position.getAssociateNumber());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					wfms_cos.setAssoicateId(wfms_Position.getAssociateNumber());
					wfms_cos.setAssociatename(wfms_Position.getAssociateName());
					wfms_cos.setSystemGenerated(2);
					wfms_cos.setNewDepartmentManager(wfms_Position.getDepartmentManager());
					wfms_cos.setNewDepartmentName(wfms_Position.getDepartmentName());
					wfms_cos.setNewDepartmentNumber(obj.getDeptNumber());
					Map<String, String>	hondamap=null; 
					if(Validator.isNotNull(wfms_Position.getDepartmentNumber())){
					hondamap=HondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
					}
					 wfms_cos.setNextApprover(hondamap.get("mpwrrep_name"));
					wfms_cos.setCompanyId(user.getUserId());
					wfms_cos.setCurrentManpowerRep(hondamap.get("mpwrrep_name"));
					wfms_cos.setNewDivision(wfms_Position.getDivision());
					wfms_cos.setNewDivisionManager(wfms_Position.getDivisionManager());
					wfms_cos.setNewPositionNumber(wfms_Position.getPId());
					wfms_cos.setPositionNumber(positionId);
					DynamicQuery wfmcurrentPosition =WFMS_PositionLocalServiceUtil.dynamicQuery();
					wfmcurrentPosition.add(PropertyFactoryUtil.forName("pId").eq(positionId+"-WFM"));
					int wfmcurrentPositioncount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmcurrentPosition);
					if(wfmcurrentPositioncount>0){
					    WFMS_Position wfms_current_Position=WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
					    wfms_cos.setCurrentLeadershipAssignment(wfms_current_Position.getLeadershipAssignment());
					}			
					
					wfms_cos.setLeadershipAssignment(wfms_Position.getLeadershipAssignment());
					wfms_cos.setStatus(HondaPermissionKeys.COS_DRAFT);
					wfms_cos.setCreateDate(new Date());
					WFMS_COSLocalServiceUtil.updateCos(wfms_cos);
				//	Manager_email = HondaLogicUtil.getDeptEmailDetailsforCOSApproval(wfms_Position.getDepartmentNumber(), HondaPermissionKeys.ROLE_DMP);	
					String  url     =GenerateFrindlyURL.getCOSfrindlyURL(portletRequest,id);

		   			 emailMessage="This change of status has been created and needs you to input data and submit.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Please click here to see the Change of status </a>";
					 emailSubject = "Department Manpower Controller: "+id+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename().trim()+" has been submitted for you to input data.";
			 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,wfms_Position.getDepartmentNumber(), portletRequest, emailSubject, emailMessage);
				//	 EmailUtility.sendEmail("Current DM Test", "Current DMP", PortletProps.get("mail.config.verify.mail"), PortletProps.get("mail.config.verify.mail"), emailSubject, emailMessage);

								
				
				}
				
				public static void convertTempToOrg(ActionRequest portletRequest,
						ActionResponse portletResponse) throws SystemException, PortalException{
						String positionId=ParamUtil.getString(portletRequest, "positionId");
						WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getWFMS_Position(positionId+"-WFM");
						wfms_Position.setPId(positionId);
						WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
						
				}
				
				public static void updatePositionClone(WFMS_Position org_wfms_Position,WFMS_Position wfms_Position) throws SystemException{
					
					
					
					org_wfms_Position.setCompanyId(wfms_Position.getCompanyId());            
					org_wfms_Position.setScopeGroupId(wfms_Position.getScopeGroupId());         
					org_wfms_Position.setCreatedBy(wfms_Position.getCreatedBy());            
					org_wfms_Position.setStatus(wfms_Position.getStatus());               
					org_wfms_Position.setDescription(wfms_Position.getDescription());          
					org_wfms_Position.setReportsTo(wfms_Position.getReportsTo());            
					org_wfms_Position.setAutoGenerateReq(wfms_Position.getAutoGenerateReq());      
					org_wfms_Position.setCritical(wfms_Position.getCritical());             
					org_wfms_Position.setDivision(wfms_Position.getDivision());             
					org_wfms_Position.setDepartmentName(wfms_Position.getDepartmentName());       
					org_wfms_Position.setDepartmentNumber(wfms_Position.getDepartmentNumber());     
					org_wfms_Position.setLine(wfms_Position.getLine());                 
					org_wfms_Position.setLadder(wfms_Position.getLadder());               
					org_wfms_Position.setMpCatBugdet(wfms_Position.getMpCatBugdet());          
					org_wfms_Position.setMpCatFilledWith(wfms_Position.getMpCatFilledWith());      
					org_wfms_Position.setSubCategory(wfms_Position.getPositionClass());        
					org_wfms_Position.setPositionClass(wfms_Position.getType());                 
					org_wfms_Position.setLevel(wfms_Position.getLevel());                
					org_wfms_Position.setCategory(wfms_Position.getLeadershipAssignment()); 
					org_wfms_Position.setCategory(wfms_Position.getCategory());             
					org_wfms_Position.setSubCategory(wfms_Position.getSubCategory());          
					org_wfms_Position.setEmpCategory(wfms_Position.getWorkforceCategory());    
					org_wfms_Position.setEmpCategory(wfms_Position.getEmpCategory());          
					org_wfms_Position.setEmpCategoryDesc(wfms_Position.getEmpCategoryDesc());      
					org_wfms_Position.setYearEst(wfms_Position.getYearEst());              
					org_wfms_Position.setReasonsFor(wfms_Position.getReasonsFor());           
					org_wfms_Position.setReavailuationDate(wfms_Position.getReavailuationDate());    
					org_wfms_Position.setAssociateName(wfms_Position.getAssociateName());        
					org_wfms_Position.setAssociateNumber(wfms_Position.getAssociateNumber());      
					org_wfms_Position.setAssociateTitle( wfms_Position.getAssociateTitle());       
					org_wfms_Position.setComments( wfms_Position.getComments());             
					org_wfms_Position.setTypicalJobTitle(wfms_Position.getTypicalJobTitle());      
					org_wfms_Position.setMinJobKnowHow(wfms_Position.getMinJobKnowHow());        
					org_wfms_Position.setDuties(wfms_Position.getDuties());               
					org_wfms_Position.setTasksPerformed(wfms_Position.getTasksPerformed());       
					org_wfms_Position.setLengthOfService(wfms_Position.getLengthOfService());      
					org_wfms_Position.setDegree(wfms_Position.getDegree());               
					org_wfms_Position.setReqSkills(wfms_Position.getReqSkills());            
					org_wfms_Position.setDesiredSkills( wfms_Position.getDesiredSkills());        
					org_wfms_Position.setEnvironment( wfms_Position.getEnvironment());          
					org_wfms_Position.setWeeklyOvertime( wfms_Position.getWeeklyOvertime());       
					org_wfms_Position.setFrequencyOfTravel( wfms_Position.getFrequencyOfTravel());    
					org_wfms_Position.setHistory( wfms_Position.getHistory());              
					org_wfms_Position.setOther( wfms_Position.getOther());                
					org_wfms_Position.setDepartmentManager( wfms_Position.getDepartmentManager());    
					org_wfms_Position.setDivisionManager( wfms_Position.getDivisionManager());  
					org_wfms_Position.setWorkflowStep( wfms_Position.getWorkflowStep());         
					WFMS_PositionLocalServiceUtil.updateWFMS_Position(org_wfms_Position);
				}
				
				
				public static void callModifyPositionOnCos(int workFlowStep,String positionId) throws SystemException {
					
					WFMS_Position modifyPosition=null;
					try {
						 modifyPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
						 if(HondaPermissionKeys.POS_MODFIED.equalsIgnoreCase(modifyPosition.getStatus())){
								WFMS_Position orgWfmsPosition=WFMS_PositionLocalServiceUtil.fetchWFMS_Position(positionId+"-WFM");
								modifyPosition.setStatus(orgWfmsPosition.getStatus());
								modifyPosition.setWorkflowStep(orgWfmsPosition.getWorkflowStep());
								WFMS_PositionLocalServiceUtil.updatePositionEntry(modifyPosition);
						     	WFMS_PositionLocalServiceUtil.deleteWFMS_Position(orgWfmsPosition);
							}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
					try{
					WFMS_Requisition wfms_Requisition=WFMS_RequisitionLocalServiceUtil.findByposition(positionId);
					WFMS_Requisition dummy_wfms_Requisition=WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(wfms_Requisition.getRwfId()+"-WFM");
					//logger.info("::: Present REQ Status::: "+ wfms_Requisition.getStatus());
					//logger.info("::: Dummy REQ Status::: "+ dummy_wfms_Requisition.getStatus());
					//logger.info("30) Requestion Status :: >> "+ HondaPermissionKeys.REQ_ONHOLD.equalsIgnoreCase(wfms_Requisition.getStatus()));
					if(HondaPermissionKeys.REQ_ONHOLD.equalsIgnoreCase(wfms_Requisition.getStatus())){
						wfms_Requisition.setStatus(dummy_wfms_Requisition.getStatus());
						WFMS_RequisitionLocalServiceUtil.updateRequisition(wfms_Requisition);
						WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(dummy_wfms_Requisition);
					}
					}catch(Exception exception){
						logger.error(exception);
					}
					
					
				}
				
				
				public static void  revertPosOnDisapproveCos(String positionId){
					//logger.info(":: Called Disapprove From COS :: "+positionId);
					try{
					//WFMS_Position org_wfms_Position=WFMS_PositionLocalServiceUtil.getWFMS_Position(positionId);
					//WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionId+"-WFM");
					
					//updatePositionClone(org_wfms_Position, wfms_Position);	
					
					
					DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
					wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionId));
					int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
					
					wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
					wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionId+"-WFM"));
					wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
					
					if(wfmPositionforTempcount > 0 && wfmPositionforTempcount > 0){
					       WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionId);
					}
					
					if(wfmPositionforTempcount > 0){
						WFMS_Position wfmsPosition = WFMS_PositionLocalServiceUtil.getByPositionId(positionId+"-WFM");
						wfmsPosition.setDummy("0");
						wfmsPosition.setPId(positionId);
						wfmsPosition=WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfmsPosition);
					    wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
						wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionId+"-WFM"));
						wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);	
						if(wfmPositionforTempcount > 0){
						       WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionId+"-WFM");
						}
					}
					
					 List<WFMS_Requisition> requisitions=WFMS_RequisitionLocalServiceUtil.findByStatus_Pid_Colllection(HondaPermissionKeys.REQ_ONHOLD,positionId);
					 for (Iterator iterator = requisitions.iterator(); iterator
							.hasNext();) {
						WFMS_Requisition wfms_Requisition = (WFMS_Requisition) iterator
								.next();
						WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(wfms_Requisition);
					}
					List<WFMS_Requisition> wfms_RequisitionList=WFMS_RequisitionLocalServiceUtil.findBypositionId(positionId);
					for (Iterator iterator = wfms_RequisitionList.iterator(); iterator
							.hasNext();) {
						WFMS_Requisition wfms_Requisition= (WFMS_Requisition) iterator
								.next();
						WFMS_Requisition requisition=WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(wfms_Requisition);
						String rwdId=StringUtil.replaceLast(requisition.getRwfId(),"-WFM",""); 
						requisition.setRwfId(rwdId);
						requisition.setDummy("0");
						WFMS_RequisitionLocalServiceUtil.updateRequisition(requisition);
					}
					}catch(Exception e){
						logger.error(":: Cannot Find Dummy Requesition :: ");
					}
				
				}
				static HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();	
				
				private static Log _log = LogFactoryUtil.getLog(ModifyPositionWFHelper.class);
		}