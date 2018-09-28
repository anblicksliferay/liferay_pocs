package com.ys.hmawfm.wfms.workflow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletModeException;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.json.JSONException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.EmailUtility;
import com.ys.hmawfm.wfms.utils.GenerateFrindlyURL;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.HondaPermissionKeys;

public class WorkflowControler {

	/* ---------------------- */
	/* WORKFLOW WFMS_Position */
	/* ---------------------- */
	
	public static WFMS_Position processWorkflow(WFMS_Position position, String processPoint,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException, IOException, JSONException {

		String workflowConfigKey = position.getWorkflow();
		int workflowStepNumber = position.getWorkflowStep();
		
		WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.getByConfigKey(workflowConfigKey);

		String config = wfms_config.getContent();
		Map<Integer, WorkflowStep> steps = WorkflowAdapter.convert(config).getSteps();
		
		WorkflowStep step = steps.get( workflowStepNumber );
		
		return processWorkflowStep(position, step, processPoint, request);
	}
	
	public static WFMS_Position processWorkflowStep(WFMS_Position position, WorkflowStep step, String processPoint,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException, IOException, JSONException {

		_log.debug("Inside WFMS_Position processWorkflowStep. processPoint:"+processPoint);
		_log.debug("Inside WFMS_Position processWorkflowStep. w/ step :"+step);
		
		List<Map<String,String>> processSteps = getProcessSteps(step, processPoint);
		
		if(null==processSteps) return position;
		
		for(int i = 0 ; i < processSteps.size(); i++){
			//_log.info(processSteps.get(i));
			processWorkflowStepAction(position, processSteps.get(i) ,request);
		}
	
		return position;
	}

	public static WFMS_Position processWorkflowStepAction(WFMS_Position position, Map<String,String> stepAction,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException, IOException, JSONException {

		for (Map.Entry<String, String> entry : stepAction.entrySet()) {
			if(entry.getKey().equalsIgnoreCase("setStatus")){
		    	position.setStatus(entry.getValue());
			} else if(entry.getKey().equalsIgnoreCase("setWorkflowStep")){
		    	position.setWorkflowStep(Integer.valueOf(entry.getValue()));
		    } else if (entry.getKey().equalsIgnoreCase("setNextApprover")) {
		    	//_log.info(entry.getValue());
		    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_DM) ){
		    	//	_log.info(entry.getValue());
		            //   try {
		            	   Map<String, String> ccmap= new HashMap<String, String>();
			               ccmap=	HondaLogicUtil.singleCallOnServieNow(position.getDepartmentNumber());
			          // 	_log.info(ccmap.get("deptMgrName"));
			               position.setNextApprover(ccmap.get("deptMgrName"));
				
		    	}
		    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_DMP) ){
		            
		               try {
		            	   Map<String, String> ccmap= new HashMap<String, String>();
			               ccmap=	HondaLogicUtil.singleCallOnServieNow(position.getDepartmentNumber());
			               position.setNextApprover(ccmap.get("mpwrrep_name"));
					} catch (Exception e) {
						// TODO: handle exception
					}
		    	}
		    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_DVM) ){
		            
		               try {
		            	   Map<String, String> ccmap= new HashMap<String, String>();
			               ccmap=	HondaLogicUtil.singleCallOnServieNow(position.getDepartmentNumber());
			               position.setNextApprover(ccmap.get("divMgrName"));
					} catch (Exception e) {
						// TODO: handle exception
					}
		    	}
		    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_STAFFING) || entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_PAYROLL) ){
		    	//	_log.info(entry.getValue());
		    	
		    		
		    	//(Validator.isNotNull(entry.getValue())){
		    		position.setNextApprover(  StringUtil.merge(HondaLogicUtil.listOfrolseusers("",request,entry.getValue()), "<br/>"));
		    		//}
		    	
			    		
		    	}
		    	
		    } else if (entry.getKey().equalsIgnoreCase("email")) {
		    	String deptNum=null;
				//_log.info("[Process Email] with value of " + entry.getValue());
				Map<String,String> emailMap = WorkflowAdapter.jsonToMap(entry.getValue());
				//processEmail(emailMap,"DEPARTMENT",request);
                String emailSubject="";
                String emailMessage="";
				//_log.info("APPROVE_ACTION_NOTICE----------"+emailMap.get("notificationName"));
				if(emailMap.get("notify")!=null){
					if(emailMap.get("notificationName")!=null){
						//APPROVE_ACTION_NOTICE_NEED_EMPCAT
						if(emailMap.get("notificationName").equalsIgnoreCase("APPROVE_ACTION_NOTICE_SUBMIT") ){
							 emailMessage="This position has been created and needs your approval.<br/>  Click the below link to access the position.";
							 emailSubject = "Department Manager: Position "+position.getPId()+" has been created and needs your approval.";
							HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_SUBMIT_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");

						}
						else if(emailMap.get("notificationName").equalsIgnoreCase("APPROVE_ACTION_NOTICE") ){
							
							// Notification: Hello <  > this Position < > is Approved
							  emailSubject =  "Staffing: Position "+ position.getPId() +" has been created and needs your approval.";
							  emailMessage="This position has been created and needs you to approve that the requisition data is acceptable. <br/>  Click the below link to access the position.";

					
							//System.out.print("if 1checked");
							HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_APPROVE_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");
						}
						else if(emailMap.get("notificationName").equalsIgnoreCase("APPROVE_ACTION_NOTICE_NEED_EMPCAT")){
							  emailSubject =  "Payroll: Position "+position.getPId()+" has been created and needs your approval.";
							  emailMessage="This position has been created and needs you to enter required data and confirm the business or technical ladder is appropriate.<br/>  Click the below link to access the position.";
							  //System.out.print("if 2checked");
							HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_APPROVE_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");
						}
						else if(emailMap.get("notificationName").equalsIgnoreCase("DISAPPROVE_ACTION_NOTICE")){
							
							WFMS_Position wfms_Position= WFMS_PositionLocalServiceUtil.getWFMS_Position(position.getPId());
							//System.out.println("comments:"+wfms_Position.getDisapproveComments());
							  emailMessage="This position has been disapproved. <br/> Disapproval Comments: "+ wfms_Position.getDisapproveComments() +" <br/>Click the below link to access the Position.";
							  emailSubject =  "Department Manpower Controller: "+position.getPId()+" Position has been disapproved.";
							  //System.out.print("if 3checked");
							 HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_DISAPPROVE_POSITION , WorkflowConstants.POSITION_ACTOIN , request,position.getDisapproveComments());
						}
						else{
							// emailMessage="This Position is Submitted, please click below link to proceed further";
							 emailMessage="This position has been created and needs your approval.<br/>  Click the below link to access the position.";
							 emailSubject = "Department Manager: Position "+position.getPId()+" has been created and  needs your approval.";
							 //System.out.print("if 4checked");
							 HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_APPROVE_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");
						}
					}
					else{
						// emailMessage="This Position is Submitted, please click below link to proceed further";
						emailMessage="This position has been created and needs you to enter required data. <br/>  Click the below link to access the position.";
						 emailSubject = "Department Manpower Controller: "+position.getPId()+" Position has been created.";
						 //System.out.print("else checked");
						 HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_SUBMIT_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");
					}
					 String url=	GenerateFrindlyURL.getHMAfrindlyURL( request, position.getPId());
					 emailMessage = emailMessage +"<br/>  <a href='"+url+"'>Click here to review the record</a>";
					
					 if(emailMap.get("notify").equalsIgnoreCase(HondaPermissionKeys.ROLE_DM) || emailMap.get("notify").equalsIgnoreCase(HondaPermissionKeys.ROLE_DMP)){
						 deptNum=position.getDepartmentNumber();
					 }
					 //_log.info("email notifier"+emailMap.get("notify"));
					 //_log.info("deptNum Number: ::: "+deptNum);
					 
					 //_log.info("emailSubject: "+emailSubject);
					 
					 //_log.info("emailMessage ::: "+emailMessage);
					EmailUtility.sendMailsNotify(emailMap.get("notify"), deptNum, request, emailSubject, emailMessage);
				}
		    } else if (entry.getKey().equalsIgnoreCase("persistence")) {    
		    	  if (entry.getValue().equalsIgnoreCase("DELETE")){
	               //WFMS_PositionLocalServiceUtil.deleteWFMS_Position(position.getPId());
	               // return position;
			      }
		    	  else if(entry.getValue().equalsIgnoreCase("UPDATE") || entry.getValue().equalsIgnoreCase("CREATE")){
				    	position = WFMS_PositionLocalServiceUtil.updatePositionEntry(position);
						// HondaLogicUtil.auditLogsForPosition(position.getPId(), "", WorkflowConstants.POSITION_SUBMIT_POSITION , WorkflowConstants.POSITION_ACTOIN , request);

				    }
		    }
		}
	    WFMS_PositionLocalServiceUtil.updateWFMS_Position(position);
		return position;
	}

	/* ------------------------- */
	/* WORKFLOW WFMS_Requisition */
	/* ------------------------- */
	
	public static WFMS_Requisition processWorkflow(WFMS_Requisition requisition, String processPoint ,String workflowConfigKey,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException {

		int workflowStepNumber = requisition.getWorkflowStep();
		
		WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.getByConfigKey(workflowConfigKey);

		String config = wfms_config.getContent();
		Map<Integer, WorkflowStep> steps = WorkflowAdapter.convert(config).getSteps();
		
		WorkflowStep step = steps.get( workflowStepNumber );
		
		return processWorkflowStep(requisition, step, processPoint ,request);
	}
	
	public static WFMS_Requisition processWorkflowStep(WFMS_Requisition requisition, WorkflowStep step, String processPoint ,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException {

		_log.debug("Inside WFMS_Position processWorkflowStep. processPoint:"+processPoint);
		_log.debug("Inside WFMS_Position processWorkflowStep. w/ step :"+step);
		
		List<Map<String,String>> processSteps = getProcessSteps(step, processPoint);
		
		if(null==processSteps) return requisition;
		
		for(int i = 0 ; i < processSteps.size(); i++){
			//_log.info(processSteps.get(i));
			processWorkflowStepAction(requisition, processSteps.get(i),request);
		}
	
		return requisition;
	}

	public static WFMS_Requisition processWorkflowStepAction(WFMS_Requisition requisition, Map<String,String> stepAction,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException {
		
	//	Date date= new Date();
		for (Map.Entry<String, String> entry : stepAction.entrySet()) {
			
		//_log.info("entry.getKey()"+entry.getKey());
			if(entry.getKey().equalsIgnoreCase("setStatus")){
				requisition.setStatus(entry.getValue());
				 if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.REQ_COMPLETE)){
					 requisition.setNextapprove("");
				 }
			} else if(entry.getKey().equalsIgnoreCase("setWorkflowStep")){
				requisition.setWorkflowStep(Integer.valueOf(entry.getValue()));
		    } else if (entry.getKey().equalsIgnoreCase("setNextApprover")) {
		    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_DMP)){
		    	     requisition.setNextapprove("");
		    	     requisition.setRoleOfApprover("");}
		    	else
		    	{
			    //	_log.info(entry.getValue());
			    	 requisition.setRoleOfApprover(entry.getValue());
			   // 	WFMS_Requisition wfms_Requisition=WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(requisition.getRwfId());
			    	WFMS_Position wfms_Position= WFMS_PositionLocalServiceUtil.getWFMS_Position(requisition.getRId());
			    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_DM) ){
			    	//	_log.info(entry.getValue());
			            //   try {
			            	   Map<String, String> ccmap= new HashMap<String, String>();
			            	   try {
					               ccmap=	HondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
						           	requisition.setNextapprove(ccmap.get("deptMgrName"));
							} catch (Exception e) {
								// TODO: handle exception
							}
				          // 	_log.info(ccmap.get("deptMgrName"));
			    	}
			    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_DVM) ){
			            
			               try {
			            	   Map<String, String> ccmap= new HashMap<String, String>();
				               ccmap=	HondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
				               requisition.setNextapprove(ccmap.get("divMgrName"));
						} catch (Exception e) {
							// TODO: handle exception
						}
			    	}
			    	if(entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_STAFFING) || entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP)
			    			||  entry.getValue().equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM)){
			    	///	_log.info(entry.getValue());
			    	
			    		
			    	//(Validator.isNotNull(entry.getValue())){
			    		requisition.setNextapprove(  StringUtil.merge(HondaLogicUtil.listOfrolseusers("",request,entry.getValue()), "<br/>"));
			    		//}
			    	
			    	}
			    	}
			    	
			    
		    } else if (entry.getKey().equalsIgnoreCase("setWorkflow")) {
		    	requisition.setWorkflow(entry.getValue());
		    } else if (entry.getKey().equalsIgnoreCase("email")) {
		    	WFMS_Requisition req = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(requisition.getRwfId());
				
		    	String deptNum=null;
		    	String emailSubject="";
				//_log.info("[Process Email] with value of " + entry.getValue());
				Map<String,String> emailMap = WorkflowAdapter.jsonToMap(entry.getValue());
				String emailMessage="";
			//	System.out.println(request.getParameter("Comments"));
				String comments=requisition.getDisapproveComments();
				if(emailMap.get("notify").equalsIgnoreCase(HondaPermissionKeys.ROLE_DMP)){
					emailMessage="This requisition has been disapproved.<br/> Disapproval Comments: "+ requisition.getDisapproveComments() +" <br/> Click the below link to access the requisition.";
			     	
			     	emailSubject =  "Department Manpower Controller: Manpower Requisition "+requisition.getRwfId()+" has been disapproved.";
			     	WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(req.getRId());
			     	deptNum=pos.getDepartmentNumber();
			  Map<String, String> map;
			try {
				map = HondaLogicUtil.singleCallOnServieNow(deptNum);
				  requisition.setNextapprove(map.get("mpwrrep_name"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     	HondaLogicUtil.auditLogsForReqAndCOS(requisition.getRwfId(),  WorkflowConstants.REQUISITION_DISAPPROVAL,WorkflowConstants.REQUISITION_ACTION, request, requisition.getDisapproveComments());
				}else if(emailMap.get("notify").equalsIgnoreCase(HondaPermissionKeys.ROLE_STAFFING)){

					if(emailMap.get("notificationName").equalsIgnoreCase("APPROVE_REQUISITION_ACTION_NOTICE")){
						emailMessage="The completion of this requisition has been disapproved. <br/> Disapproval Comments: "+ requisition.getDisapproveComments() +" <br/>Click the below link to access the Requisition.";
				     	
				       	emailSubject =  "Staffing: Manpower Requisition "+requisition.getRwfId()+"  that you completed was disapproved.";
					}
					else{
					emailMessage="This requisition has been submitted and needs to be filled. <br/>  Click the below link to access the requisition.";
					 emailSubject =  "Staffing: Manpower Requisition "+requisition.getRwfId()+" is now waiting on manpower.";
					 WFMS_Requisition requp = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(requisition.getRwfId());
					 //HondaLogicUtil.getDateFormat(requisition.getApprovedDate());
					 //System.out.print(HondaLogicUtil.getDateFormat(date));
					 requisition.setApprovedDate(new Date());
					 WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(requisition);
					 HondaLogicUtil.auditLogsForReqAndCOS(requisition.getRwfId(), WorkflowConstants.REQUISITION_APPROVAL, WorkflowConstants.REQUISITION_ACTION, request, "");
					}
				
				
				}else{
                    if(emailMap.get("notificationName").equalsIgnoreCase("APPROVE_REQUISITION_ACTION_NOTICE")){
                        emailSubject =  "Company Manpower Controller: Manpower Requisition "+requisition.getRwfId()+" has been submitted for your approval.";
                        emailMessage="This requisition has been submitted and needs your approval.<br/>  Click the below link to access the requisition.";
                   }
                   else{
                       if(emailMap.get("notify").equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP)){
                            emailSubject =  "Company Manpower Controller: Manpower Requisition "+requisition.getRwfId()+" has been submitted for your approval.";
                            emailMessage="This requisition has been submitted and needs your approval. <br/> Click the below link to access the requisition.";
                           
                       }
                       else if(emailMap.get("notify").equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM)){
                            emailSubject =  "SP Department Manager: Manpower Requisition "+requisition.getRwfId()+" has been submitted for your approval.";
                            emailMessage="This requisition has been submitted and needs your approval. <br/>  Click the below link to access the requisition.";
                       }
                       else{
                   /* emailSubject =  "Notification: Hello "+emailMap.get("notify")+" this Requisition "+requisition.getRwfId()+" is Approval";
                    emailMessage="This Requisition is Approval, please click below link to proceed further";*/
                  
                       }
                       HondaLogicUtil.auditLogsForReqAndCOS(requisition.getRwfId(), WorkflowConstants.REQUISITION_APPROVAL, WorkflowConstants.REQUISITION_ACTION, request, "");
                   
                   }
               }
				 String url=	GenerateFrindlyURL.getURLForRequisition( request, requisition.getRwfId());
				 emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
				EmailUtility.sendMailsNotify(emailMap.get("notify"), deptNum, request, emailSubject, emailMessage);
		    
		    } else if (entry.getKey().equalsIgnoreCase("persistence")) {
		    	if(entry.getValue().equalsIgnoreCase("UPDATE")){
		    		requisition = WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(requisition);
			    } else if (entry.getValue().equalsIgnoreCase("DELETE")){
			    	WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(requisition);
	                return null;
			    }
		    }
		}
		
		WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(requisition);
		return requisition;
	}
	
	/* ----------------- */
	/* WORKFLOW WFMS_COS */
	/* ----------------- */
	
	public static WFMS_COS processWorkflow(WFMS_COS cos, String processPoint,String workflowConfigKey,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException {

		
		int workflowStepNumber = cos.getWorkflowStep();
		
		WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.getByConfigKey(workflowConfigKey);

		String config = wfms_config.getContent();
		Map<Integer, WorkflowStep> steps = WorkflowAdapter.convert(config).getSteps();
		
		WorkflowStep step = steps.get( workflowStepNumber );
		
		return processWorkflowStep(cos, step, processPoint, request);
	}
	
	public static WFMS_COS processWorkflowStep(WFMS_COS cos, WorkflowStep step, String processPoint,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException {

		_log.debug("Inside WFMS_Position processWorkflowStep. processPoint:"+processPoint);
		_log.debug("Inside WFMS_Position processWorkflowStep. w/ step :"+step);
		
		List<Map<String,String>> processSteps = getProcessSteps(step, processPoint);
		
		if(null==processSteps) return cos;
		
		for(int i = 0 ; i < processSteps.size(); i++){
			//_log.info(processSteps.get(i));
			processWorkflowStepAction(cos, processSteps.get(i), request);
		}
	
		return cos;
	}

	public static WFMS_COS processWorkflowStepAction(WFMS_COS cos, Map<String,String> stepAction,ActionRequest request)
			throws SystemException, WindowStateException, PortletModeException, PortalException {

		for (Map.Entry<String, String> entry : stepAction.entrySet()) {
			if(entry.getKey().equalsIgnoreCase("setStatus")){
				cos.setStatus(entry.getValue());
			} else if(entry.getKey().equalsIgnoreCase("setWorkflowStep")){
				cos.setWorkflowStep(Integer.valueOf(entry.getValue()));
		    } else if (entry.getKey().equalsIgnoreCase("setNextApprover")) {
		    	cos.setNextApprover(entry.getValue());
		    } else if (entry.getKey().equalsIgnoreCase("email")) {
		    	
				//_log.info("[Process Email] with value of " + entry.getValue());
				Map<String,String> emailMap = WorkflowAdapter.jsonToMap(entry.getValue());
				processEmail(emailMap,"DEPARTMENT" ,request);
				
		    } else if (entry.getKey().equalsIgnoreCase("persistence")) {    
		    	if(entry.getValue().equalsIgnoreCase("UPDATE")){
		    		cos = WFMS_COSLocalServiceUtil.updateWFMS_COS(cos);
			    } else if (entry.getValue().equalsIgnoreCase("DELETE")){
			    	WFMS_COSLocalServiceUtil.deleteWFMS_COS(cos);
	                return null;
			    }
		    }
		}
		return cos;
	}

	public static List<Map<String,String>> getProcessSteps(WorkflowStep step, String processPoint){
		
		List<Map<String,String>> processSteps = new ArrayList<Map<String,String>>();
		
		if(processPoint.equalsIgnoreCase("onView")){
			processSteps = step.getOnView();
		}else if(processPoint.equalsIgnoreCase("onSave")){
			processSteps = step.getOnSave();
		}else if(processPoint.equalsIgnoreCase("onSubmit")){
			processSteps = step.getOnSubmit();
		}else if(processPoint.equalsIgnoreCase("onApprove")){
			processSteps = step.getOnApprove();
		}else if(processPoint.equalsIgnoreCase("onDisapprove")){
			processSteps = step.getOnDisapprove();
		}else if(processPoint.equalsIgnoreCase("onWorkflowStart")){
			processSteps = step.getOnWorkflowStart();
		}else if(processPoint.equalsIgnoreCase("onLastApproval")){
			processSteps = step.getOnLastApproval();
		}
		else if(processPoint.equalsIgnoreCase("onDiscard")){
			processSteps = step.getOnDiscard();
		}else{
			_log.error("WorkflowControler.getProcessSteps, Process "+processPoint+" not found!");
		}
		
		//_log.info("Returning "+processPoint+" processSteps with size of: "+processSteps.size());
		
		return processSteps;
	}
	

	public static void processEmailForRequisation(Map<String,String> emailContext, ActionRequest request,String recordId,String emailMessage) throws WindowStateException, PortletModeException, PortalException, SystemException{
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String emailSubject="";
	//	//_log.info("r.getRoleId():"+r.getRoleId());
		String groupName = emailContext.get("notify");
	
		if(groupName.equalsIgnoreCase(HondaPermissionKeys.ROLE_DMP)){
			////_log.info("enter to dmp loop:"+groupName);
			WFMS_Requisition req = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(recordId);
			WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(req.getRId());
			emailSubject =  "Notification for "+groupName+" Requisation Disapproved "+recordId;
			
			List<String> departmentNos= HMAAssociateInfoService.getDepartmentUsersByDPNumber(pos.getDepartmentNumber());
			
	   EmailUtility.sendMailsNotify(groupName, pos.getDepartmentNumber(), request, emailSubject, emailSubject);
		}
		else{
		
				if(groupName.equalsIgnoreCase(HondaPermissionKeys.ROLE_STAFFING)){
					 emailSubject =  "Notification for "+groupName+" requisition was Approved. "+recordId;
				}else {
					emailSubject =  "Notification for "+groupName+" Approval flow "+recordId;
				}
				 String url=	GenerateFrindlyURL.getURLForRequisition( request, recordId);
				    emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
				////_log.info("emailSubject"+emailSubject);
		 
		
		}
	}
public static void processEmail(Map<String,String> emailContext, String department,ActionRequest request) throws WindowStateException, PortletModeException, PortalException, SystemException{
		
		String emailFromName = "HMA Workforce Management System"; //TODO From Properties
		String emailFromAddress = "hmawfm@localhost.com"; //TODO From Properties

		String emailSubject =  "-- no subject --";
		String emailMessage =  "-- no message --";
		
		if(emailContext.containsKey("notificationName")){
			String templateId = emailContext.get("notificationName");
			emailSubject =  templateId; //TODO From Email Template
			emailMessage =  templateId; //TODO From Email Template
		}

		
		if(emailContext.containsKey("notify")){

			List<User> users = null;
			
			String groupName = emailContext.get("notify");
			if(groupName.equalsIgnoreCase("DM")||groupName.equalsIgnoreCase("DMP")){
				//_log.info("Get DM or DMP from department: "+department);
			} else {
				 
				try{
					long groupId = CompanyThreadLocal.getCompanyId();
					UserGroup group = UserGroupLocalServiceUtil.getUserGroup(groupId,groupName);
					users = UserLocalServiceUtil.getUserGroupUsers(group.getUserGroupId());
				}catch(PortalException pex){
					_log.error("PortalException found for WorkflowControler processEmail");
				}catch(SystemException pex){
					_log.error("SystemException found for WorkflowControler processEmail");
				}
			}

			//From User List
			if(null!=users){} 
		}
	}
	public static void runTest(){
		//_log.info("WorkflowControler.runTest()");
		String result = "";
		
		try{
			WFMS_Position position = WFMS_PositionLocalServiceUtil.getByPositionId("QA-038");
			//position.setWorkflow(); Currently not found in services
			int workflowStep = 10;
			
			WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.getByConfigKey("create-position");

			String config = wfms_config.getContent();
			
			Workflow workflow = WorkflowAdapter.convert(config);
			Map<Integer, WorkflowStep> steps = workflow.getSteps();
			
			WorkflowStep step = steps.get( workflowStep );
			//_log.info("Step "+workflowStep+"'s WorkflowStep is:");
			//_log.info(step.toString());
			
			String[] approvers = step.getApprovers();
			
			for( int i = 0; i <= approvers.length - 1; i++)
			{
				//_log.info("approver:"+approvers[i]);
			}
					
		//	position = processWorkflowStep(position, step, "onSubmit" );
			
			
		}catch(SystemException ex){
			//_log.info("Position Not Found");
		}

		//_log.info("result:"+result);
	}
	public static String processWorkflowStep(WFMS_Position position, String processPoint)
			throws SystemException {

		WFMS_WorkflowConfig workflowConfig = WFMS_WorkflowConfigLocalServiceUtil.getByConfigKey("create-position");
		
		//System.out.print("Inside WFMS_Position processWorkflowStep. processPoint:"+processPoint);
		
		return "";
	}

	public static String processWorkflowStep(WFMS_Requisition requisition, String processPoint)
			throws SystemException {
		
		//System.out.print("Inside WFMS_Requisition processWorkflowStep");

		return "";
	}
	
	public static String processWorkflowStep(WFMS_COS cos, String processPoint)
			throws SystemException {
		
		//System.out.print("Inside WFMS_COS processWorkflowStep");

		return "";
	}
	private static Log _log = LogFactoryUtil.getLog(WorkflowControler.class.getName());
}
