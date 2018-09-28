/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ys.hmawfm.wfms.portlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_COSImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.ConfigUtility;
import com.ys.hmawfm.wfms.utils.DatagridDisplayManagerUtil;
import com.ys.hmawfm.wfms.utils.EmailUtility;
import com.ys.hmawfm.wfms.utils.GenerateFrindlyURL;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.HondaPermissionKeys;
import com.ys.hmawfm.wfms.vo.AssociateInformation;
import com.ys.hmawfm.wfms.workflow.WorkflowConstants;
import com.ys.hmawfm.wfms.workflow.WorkflowControler;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;



@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=HMA-WMS",
        "com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.add-process-action-success-action=false",
        "javax.portlet.init-param.view-template=/html/requisition/list.jsp",
		"javax.portlet.name=" + WorkflowConfigurationPortletKeys.Requisition,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.display-name=WMS-Requisition"
    },
    service = Portlet.class
)
public class RequisitionPortlet extends MVCPortlet {

	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
			PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/html/requisition/list.jsp");
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		boolean loggedIn = themeDisplay.isSignedIn();
		if (!loggedIn) {
			prd = getPortletContext().getRequestDispatcher("/html/signin.jsp");
		}

		prd.include(request, response);
	}

	/**
	 * 
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	public void selectURL(ActionRequest req, ActionResponse res)
			throws Exception {
		String listsel = req.getParameter("listsel");
		//_log.info("listsel :" + listsel);
		req.setAttribute("listsel", listsel);
		res.sendRedirect("jspPage", "/html/requisition/list.jsp");
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void printRequisition(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = UserLocalServiceUtil.getUserById(themeDisplay.getUserId());
		request.getPortletSession().setAttribute("ScreenName", user.getScreenName());
		/*Below line used for print option*/
		response.setRenderParameter("printRequisition","printRequisition");
		response.setRenderParameter("jspPage",	"/html/requisition/print-requisition.jsp");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editRequisition(ActionRequest request, ActionResponse response)
			throws Exception {

		try {
			// String positionId = request.getParameter("positionId");
			String reqid = request.getParameter("positionId");
			// WFMS_Position wfms_Position =
			// WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
			WFMS_Requisition req = WFMS_RequisitionLocalServiceUtil
					.getWFMS_Requisition(reqid);
			if (req != null) {
				WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
						.getByPositionId(req.getRId());
				request.setAttribute("positionId", req.getRId());
				request.setAttribute("requisitionId", req.getRwfId());
				request.setAttribute("wfms_PositionObj", wfms_Position);
				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);
				long userId = themeDisplay.getUserId();
				User user = UserLocalServiceUtil.getUserById(userId);

			}

		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage",
				"/html/requisition/manageRequisition.jsp");
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void manageRequisition(ActionRequest request, ActionResponse response)
			throws Exception {

		
	//System.out.println("entered to manageRequisition action");
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		long companyId = user.getCompanyId();
		Group group = user.getGroup();
		long scopeGroupId = group.getGroupId();
		Date createdate = new Date();
		// String modifiedDate = request.getParameter("modifiedDate");
		String number = request.getParameter("Number");
		/**
		 * DateFormat format = new SimpleDateFormat("MMMM d, yyyy"); Date
		 * condate = format.parse(date); Date conmodifydate =
		 * format.parse(modifiedDate);
		 **/
		String createDate = request.getParameter("createDate");
		String requisisionnumber = request.getParameter("requisisionnumber");
		String associatenumber = request.getParameter("associatenumber");
		String associatename = request.getParameter("associatename");

		// String associatename =
		// HMAAssociateInfoService.getAssNameByDeptNumner(associatenumber);
		String status = request.getParameter("status");
		String postingType = "";
		 postingType = request.getParameter("postingType");
		////_log.info("<<<<<<<<<<<postingType>>>>>>>>>>>>>>>>"+postingType);
		String teamNumber = request.getParameter("teamNumber");
		String associatetype = request.getParameter("associatetype");
		String shiftAssign = request.getParameter("shiftAssign");
		// shift assigment saving
		String shiftassigndb = "";
		String shiftDesc = "";
		if (shiftAssign == StringPool.BLANK) {
			shiftDesc = StringPool.BLANK;
		} else {
			Map<String, String> shifassignMap = new HashMap<String, String>();
			shifassignMap = ConfigUtility
					.getInputValuesForMap("shift-assignment");
			shiftassigndb = shifassignMap.get(shiftAssign);
			shiftDesc = shiftAssign + ":" + shiftassigndb;
		}
		String howAvilable = request.getParameter("howAvailable");
		String whoReplaced = request.getParameter("whoReplaced");
		//System.out.println("whoReplaced" + whoReplaced);
		String dateneeded = request.getParameter("dateneeded");
		String contactperson = (request.getParameter("contactperson"));
		String contactphonenumber = (request.getParameter("contactphonenumber"));
		String taleonumber = (request.getParameter("taleonumber"));
		String other = request.getParameter("other").trim();
		//_log.info("check.other:" + other);
		String comments = request.getParameter("comments");
		String buttonclick = request.getParameter("buttonclick");
		//_log.info("buttonclick:" + buttonclick);
		String associateNameNoNum = "";
		AssociateInformation assInfo = new AssociateInformation();
		if (Validator.isNotNull(associatenumber)) {
			if (associatenumber.equalsIgnoreCase("None")) {
				associateNameNoNum = associatename;
			} else {
				HMAAssociateInfoService service = new HMAAssociateInfoService();
				assInfo = service.createRequisition(associatenumber);
				if (assInfo.getAssociateName() != null) {
					associateNameNoNum = assInfo.getAssociateName();
				}
			}
		}
		WFMS_Requisition wFMS_Requisition = WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(requisisionnumber);
		/* Adding Temp data in database */
		PortletSession session = request.getPortletSession();
	//	if (Validator.isNotNull(buttonclick) && session.getAttribute("handelAction")==null) {
		//	session.setAttribute("handelAction", "1");
			if (buttonclick.equalsIgnoreCase("modifyrequisitionSave")) {
				
				// draft save button updating the data
				//status = WorkflowConstants.REQUISITION_SAVE;
                 WFMS_Requisition mainreq = WFMS_RequisitionLocalServiceUtil.findByrequisition(requisisionnumber);
                 mainreq.setDummy("1");
                 WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(mainreq);
                  List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil.findByworkflowId(requisisionnumber+"-WFM");
                  WFMS_Requisition requp =new WFMS_RequisitionImpl();
				if(finalstep.size()>0){
					requp = WFMS_RequisitionLocalServiceUtil.findByrequisition(requisisionnumber+"-WFM");
				}	
				else{
					 requp = new WFMS_RequisitionImpl();
					 
					 requp.setRwfId(requisisionnumber+"-WFM");
				}
				 requp.setStatus(wFMS_Requisition.getStatus());
				 requp.setRId(number);
				 requp.setNumber(number);
			//	 requp.setNextapprove(wFMS_Requisition.getNextapprove());
				 requp.setWorkflow(wFMS_Requisition.getWorkflow());
				 requp.setWorkflowStep(wFMS_Requisition.getWorkflowStep());
				 requp.setCreateDate(wFMS_Requisition.getCreateDate());
				 requp.setAssociatenumber(associatenumber);
				 requp.setAssociatename(associateNameNoNum);
				 requp.setAssociatetype(associatetype);
				 requp.setPostingType(postingType);
				 requp.setTeamNumber(teamNumber);
				 requp.setShiftAssign(shiftDesc);
				 requp.setHowAvailable(howAvilable);
				 requp.setWhoReplaced(whoReplaced);
				 requp.setDateneeded(dateneeded);
				 requp.setContactperson(contactperson);
				 requp.setContactphonenumber(contactphonenumber);
				 requp.setTaleonumber(taleonumber);
				 requp.setOther(other);
				 requp.setComments(comments);
				 requp.setCreatedBy(wFMS_Requisition.getCreatedBy());
				 //requp.setCreateDate(createddate);
				 requp.setCompanyId(companyId);
				 requp.setScopeGroupId(scopeGroupId);
				 requp.setDummy("0");
                 WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(requp);
				 HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,WorkflowConstants.REQUISITION_SAVEDATA,WorkflowConstants.REQUISITION_ACTION, request,comments);

			}
			if (buttonclick.equalsIgnoreCase("modifyrequisitionOnWaitingOnmanpower")) {
				//System.out.println("requisisionnumber:"+requisisionnumber);
				// here not updating values
				WFMS_RequisitionLocalServiceUtil.updateRequisition(
						requisisionnumber, companyId, scopeGroupId, number,
						associatenumber, associateNameNoNum, HondaPermissionKeys.REQ_WAITINGONMANPOWER,
						postingType, teamNumber, associatetype, shiftDesc,
						howAvilable, whoReplaced, dateneeded, contactperson,
						contactphonenumber, taleonumber, other, comments);
				HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,"Requisition Modified Submitted",
								WorkflowConstants.REQUISITION_ACTION, request,
								comments);
			}
			
			// Complete requisiiton started here
			
			if (buttonclick.equalsIgnoreCase(HondaPermissionKeys.REQ_COMPLETE)) {
				List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil
						.findByworkflowId(requisisionnumber);
				WFMS_Requisition numberList = null;
				String associateName = "";
				AssociateInformation asInfo = new AssociateInformation();
				if (Validator.isNotNull(associatenumber)) {
					if (associatenumber.equalsIgnoreCase("None")) {
						associateName = associatename;
					} else {
						HMAAssociateInfoService service = new HMAAssociateInfoService();
						asInfo = service.createRequisition(associatenumber);
						if (asInfo.getAssociateName() != null) {
							associateName = asInfo.getAssociateName();
						}
					}
				}
				if (finalstep.size() != 0) {
					for (WFMS_Requisition req : finalstep) {
						numberList = WFMS_RequisitionLocalServiceUtil
								.fetchWFMS_Requisition(req.getRwfId());
						numberList.setAssociatename(associateName);
						numberList.setAssociatenumber(associatenumber);
						WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(numberList);
						
						
						WFMS_Requisition processworkflow= WorkflowControler.processWorkflow(numberList, "onSubmit", "complete-requisition", request);
						//System.out.println("working");
						HondaLogicUtil.auditLogsForReqAndCOS(req.getRwfId(),
								WorkflowConstants.REQUISITION_COMPLETE,
								WorkflowConstants.REQUISITION_ACTION, request,
								"");

					}
				} else {
					numberList = WFMS_RequisitionLocalServiceUtil
							.fetchWFMS_Requisition(requisisionnumber);
					numberList.setAssociatename(associateName);
					numberList.setAssociatenumber(associatenumber);
					WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(numberList);
					//System.out.println(numberList.getWorkflowStep()+"=-==-=-=====-=-=-=-=-=-=-=-=-");
					WFMS_Requisition processworkflow= WorkflowControler.processWorkflow(numberList, "onSubmit", "complete-requisition", request);
					HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,
							WorkflowConstants.REQUISITION_COMPLETE,
							WorkflowConstants.REQUISITION_ACTION, request, "");

				}
			
				
			}

			// Complete requisition ended here

			if (buttonclick.equalsIgnoreCase("modifyrequisitionSubmit")) {

				
				//	if(session.getAttribute("entertomodifyrequisitionSubmit-"+requisisionnumber)==null){
					//	session.setAttribute("entertomodifyrequisitionSubmit-"+requisisionnumber, "1");
						String dummy = "";
						WFMS_Requisition req= WFMS_RequisitionLocalServiceUtil.findByrequisition(requisisionnumber);
						if (req !=null) {
						////System.out.println("Workflow Controler step:" + req.getWorkflowStep());
						
						////System.out.println("Enter to if requisisionnumber:" + requisisionnumber);
							_log.info(associatenumber+"associatenumber---------");
							dummy = "0";
							req.setWorkflowId("");
							req.setDummy(dummy);
							req.setCompanyId(companyId);
							req.setScopeGroupId(scopeGroupId);
							req.setRId(number);
							req.setNumber(number);
							req.setAssociatenumber(associatenumber);
							req.setAssociatename(associateNameNoNum);
							req.setStatus(HondaPermissionKeys.REQ_SUBMITTED);
							req.setPostingType(postingType);
							req.setTeamNumber(teamNumber);
							req.setAssociatetype(associatetype);
							req.setShiftAssign(shiftDesc);
							req.setHowAvailable(howAvilable);
							req.setWhoReplaced(whoReplaced);
							req.setDateneeded(dateneeded);
							req.setModifiedDate(new Date());
							req.setContactperson(contactperson);
							req.setContactphonenumber(contactphonenumber);
							req.setTaleonumber(taleonumber);
							req.setOther(other);
							WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req);
							
							/*List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil.findByworkflowId(requisisionnumber+"-WFM");
							if(finalstep.size()>0){
								WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(requisisionnumber+"-WFM");
							}	*/
							DynamicQuery wfmreqforTemp =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
							wfmreqforTemp.add(PropertyFactoryUtil.forName("rwfId").eq(requisisionnumber+"-WFM"));
							int wfmReqforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmreqforTemp);	
							//_log.info("wfmReqforTempcount"+wfmReqforTempcount);
							if(wfmReqforTempcount > 0){
								WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(requisisionnumber+"-WFM");
							}
						
							
							
							try {
								if(req.getWorkflowStep()==0){
									WorkflowControler.processWorkflow(req, "onSubmit", "approve-requisition",request);
									WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(req.getRId());
									//List<String> departmentNos= HMAAssociateInfoService.getDepartmentUsersByDPNumber(pos.getDepartmentNumber());
									String emailMessage="This requisition has been submitted and needs your approval. Click the below link to access the requisition.";
									String emailSubject = "Department Manager: Manpower Requisition "+requisisionnumber+"  has been submitted for your approval.";
									 String url=GenerateFrindlyURL.getURLForRequisition( request, requisisionnumber);
									 emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
									 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), request, emailSubject, emailMessage);
									 HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,WorkflowConstants.REQUISITION_SUBMIT,WorkflowConstants.REQUISITION_ACTION, request, "");
								}else{
								      HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,WorkflowConstants.REQUISITION_MODIFY,WorkflowConstants.REQUISITION_ACTION, request, "");
								}
								
							} catch (Exception e) {
								e.printStackTrace();
							}
					   } 
				//	}
				
					/*else {
						//System.out.println("Enter to else requisisionnumber:" + requisisionnumber);
						WFMS_RequisitionLocalServiceUtil.updateRequisition(
								requisisionnumber, companyId, scopeGroupId, number,
								associatenumber, associateNameNoNum,
								HondaPermissionKeys.REQ_SUBMITTED, postingType,
								teamNumber, associatetype, shiftDesc, howAvilable,
								whoReplaced, dateneeded, contactperson,
								contactphonenumber, taleonumber, other, comments);
						//System.out.println(requisisionnumber + reqnumber);
						HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,
								WorkflowConstants.REQUISITION_SUBMIT,
								WorkflowConstants.REQUISITION_ACTION, request, "");
							try {
								WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(requisisionnumber);
								//List<String> departmentNos= HMAAssociateInfoService.getDepartmentUsersByDPNumber(pos.getDepartmentNumber());
								String emailSubject = "";
								String emailMessage = "";
								
								emailMessage="This Requisition is Submitted, please click below link to proceed further";
								emailSubject = "Notification: Hello "+HondaPermissionKeys.ROLE_DM+" this Requisition "+requisisionnumber+" is Submitted";
								 
								 
								 
								 String url=GenerateFrindlyURL.getURLForRequisition( request, requisisionnumber);
								 emailMessage = emailMessage +"<p><a href='"+url+"'>Click here to review the record</a></p>";
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,null, request, emailSubject, emailMessage);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}*/
				
			}
			
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void createRequisition(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		long companyId = user.getCompanyId();
		Group group = user.getGroup();
		long scopeGroupId = group.getGroupId();
		// Date createdate = new Date();
		// String modifiedDate = request.getParameter("modifiedDate");
		String number = request.getParameter("Number");
		/**
		 * DateFormat format = new SimpleDateFormat("MMMM d, yyyy"); Date
		 * condate = format.parse(date); Date conmodifydate =
		 * format.parse(modifiedDate);
		 **/
		// System.out.print("check");
		String requisisionnumber = request.getParameter("requisisionnumber");
		String associatenumber = request.getParameter("associatenumber");
		String associatename = HMAAssociateInfoService
				.getAssNameByDeptNumner(associatenumber);
		String status = request.getParameter("status");
		String postingType = request.getParameter("postingType");
		String teamNumber = request.getParameter("teamNumber");
		String associatetype = request.getParameter("associatetype");
		String shiftAssign = request.getParameter("shiftAssign");
		String shiftassignmentdb = "";
		String shiftDesc = "";
		Map<String, String> shifassinmentMap = new HashMap<String, String>();
		shifassinmentMap = ConfigUtility
				.getInputValuesForMap("Shift-Assignment");
		shiftassignmentdb = shifassinmentMap.get(shiftAssign);
		shiftDesc = shiftAssign + ":" + shiftassignmentdb;
		String howAvailable = request.getParameter("howAvailable");
		String whoReplaced = request.getParameter("whoReplaced").trim();
		String dateneeded = request.getParameter("dateneeded");
		String contactperson = request.getParameter("contactperson");
		String contactphonenumber = request.getParameter("contactphonenumber");
		String taleonumber = request.getParameter("taleonumber").trim();
		String other = request.getParameter("other").trim();
		//_log.info("Other :" + other);
		String comments = request.getParameter("comments");

		WFMS_RequisitionLocalServiceUtil.addnewRequisition(requisisionnumber, companyId, scopeGroupId,
						number, associatenumber, associatename, status,
						postingType, teamNumber, associatetype, shiftDesc,
						howAvailable, whoReplaced, dateneeded, contactperson,
						contactphonenumber, taleonumber, other, comments);
		if(request.getParameter("status").equalsIgnoreCase(""))
		HondaLogicUtil.auditLogsForReqAndCOS(requisisionnumber,
				WorkflowConstants.REQUISITION_CREATE,
				WorkflowConstants.REQUISITION_ACTION, request, "");

		/*
		 * if(wFMS_Requisition!=null){ SessionMessages.add(request,
		 * "request_processed", "Your request completed sucessfully"); } else{
		 * SessionErrors.add(request, "request_processed",
		 * "Your request failed to complete"); }
		 */
		// WFMS_RequisitionLocalServiceUtil.clearCache();
		List<WFMS_Requisition> wfms_RequisitionList = WFMS_RequisitionLocalServiceUtil
				.getWFMS_Requisitions(-1, -1);
		WFMS_Requisition requisition= WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(requisisionnumber);
		if(requisition.getWorkflowStep()==0){
			WFMS_Requisition processWorkflow = WorkflowControler.processWorkflow(requisition, "onSubmit", "approve-requisition",request);
		}
		PortletSession session = request.getPortletSession();
		if (wfms_RequisitionList != null) {
			session.setAttribute("wfms_RequisitionList", wfms_RequisitionList);
		}
		session.setAttribute("jspPage", "/html/requisition/list.jsp",
				PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * @param Approved
	 *            Requisition functionality
	 * @throws PortalException 
	 */

	
	
	public void approveRequisition(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();

		String requisitionId = actionRequest.getParameter("requisitionId");
		WFMS_Requisition requisition= WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(requisitionId);
		if(requisition.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED))
			WorkflowControler.processWorkflow(requisition, "onApprove", "approve-requisition",actionRequest);
		else
		    WorkflowControler.processWorkflow(requisition, "onApprove", "complete-requisition",actionRequest);
		
		SessionMessages.add(actionRequest, "approvedSuccess");
	actionResponse.sendRedirect(GenerateFrindlyURL.renderManageRequisition(actionRequest));
	}
	/**
	 * @param Disapproved  Requisition functionality
	 * @throws PortalException 
	 */
	public void disapproveRequisition(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException, PortalException {

		String requisitionId = actionRequest.getParameter("reqid");
		String comments = actionRequest.getParameter("Comments");
		
		WFMS_Requisition requisition = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(requisitionId);
		requisition.setDisapproveComments(comments);
		WFMS_RequisitionLocalServiceUtil.updateRequisition(requisition);
		if(requisition.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED))
		     WorkflowControler.processWorkflow(requisition, "onDisapprove", "approve-requisition",actionRequest);
		else
			 WorkflowControler.processWorkflow(requisition, "onDisapprove", "complete-requisition",actionRequest);
		SessionMessages.add(actionRequest, "disapprovedSuccess");
	}
	public void discardRequisation(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
	       
		   String posid = ParamUtil.getString(actionRequest, "pid");
		   
		   ////System.out.println("discard posid:"+posid);
		   try {
			   if(Validator.isNotNull(posid)){
				   
			  WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getWFMS_Position(posid);
			  
			  DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
			  wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(posid));
			  int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
				
			if(wfmPositionforTempcount > 0){
			   WFMS_PositionLocalServiceUtil.deleteWFMS_Position(posid);
			}   
			  // TODo on Approve WorkFlow
				 WorkflowControler.processWorkflow(wfms_Position, "onDiscard",actionRequest);
			  actionRequest.setAttribute("positionId", posid);
           actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
           actionResponse.setRenderParameter("jspPage", "/html/position/managePosition.jsp"); 
        
		   }
			   HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_Discard_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");   

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	/* Handle the Resource URLS */
	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		//_log.info("serveResource called");
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		//_log.info("serveResource command is: " + cmd		+ " with cmdType(optional): " + cmdType);

		if (cmd.equals("positionList")) {
			try {
				try {
					getRequisitionList(cmdType, resourceRequest, resourceResponse);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchWFMS_RequisitionException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else if (cmd.equalsIgnoreCase("getAssName")) {
			try {
				getAssociateNameBydepId(cmdType, resourceRequest,
						resourceResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void discardsecondRequisation(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
	       
		   String reqId = ParamUtil.getString(actionRequest, "reqId");
		   
		   //_log.info("enter to discardsecondRequisation:"+reqId);
		   ////System.out.println("discrad second position"+posid	  );
		   try {
			   if(Validator.isNotNull(reqId)){
				   //_log.info("enter to discardsecondRequisation:"+reqId);
			  WFMS_Requisition wfms_Requisition=WFMS_RequisitionLocalServiceUtil.findByrequisition(reqId);
			  //_log.info("enter to discardsecondRequisation:"+wfms_Requisition.getRefReqId());
			  DynamicQuery wfmRequisitionforTemp =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
			  wfmRequisitionforTemp.add(PropertyFactoryUtil.forName("rwfId").eq(reqId+"-WFM"));
			  int wfmRequisitionforTempcount = (int) WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(wfmRequisitionforTemp);
			  //_log.info("wfmRequisitionforTempcount count:"+wfmRequisitionforTempcount);
			  if(wfmRequisitionforTempcount > 0){
				  WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(reqId+"-WFM");
				  //_log.info("record deleted :"+reqId+"-WFM");
			  }
			  wfms_Requisition.setDummy("0");
			  wfms_Requisition=WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(wfms_Requisition);
				   HondaLogicUtil.auditLogsForReqAndCOS(reqId, WorkflowConstants.Requisition_DiscardThirdset, WorkflowConstants.REQUISITION_ACTION, actionRequest,"");
			   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	// Passing Status From waiting on manpower to Cancelled   and Changed By ChandraMouli S
	public void cancelRequisition(ActionRequest req, ActionResponse res)
			throws PortletException, IOException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String reqid = req.getParameter("reqid");
		String Comments = req.getParameter("Comments");
		String CancelStatus = req.getParameter("CancelStatus");
		String emailSubject = StringPool.BLANK;
		String emailMessage = StringPool.BLANK;
				String url = StringPool.BLANK;
				WFMS_Requisition requisition= null;
		try {
			DynamicQuery wfmreqforTemp =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
				wfmreqforTemp.add(PropertyFactoryUtil.forName("rwfId").eq(reqid+"-WFM"));
				int wfmReqforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmreqforTemp);	
				//_log.info("wfmReqforTempcount"+wfmReqforTempcount);
				if(wfmReqforTempcount > 0){
					WFMS_RequisitionLocalServiceUtil.deleteWFMS_Requisition(reqid+"-WFM");
				}
				try{
				if (Validator.isNotNull(reqid)) {
					requisition=WFMS_RequisitionLocalServiceUtil.findByrequisition(reqid);
					requisition.setStatus(HondaPermissionKeys.REQ_CANCELLED);
					requisition.setDummy("0");
					requisition.setNextapprove("");
					WFMS_RequisitionLocalServiceUtil.updateRequisition(requisition);
					HondaLogicUtil.auditLogsForReqAndCOS(reqid,WorkflowConstants.REQUISITION_CANCEL,WorkflowConstants.REQUISITION_ACTION, req,Comments);
					}
				}
				 catch (Exception e) {
						e.printStackTrace();
					}
				
			
				User user = UserLocalServiceUtil.getUserById(userId);
				long companyId = user.getCompanyId();
				 
				WFMS_Requisition requisition_Dept= WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(reqid);

				WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(requisition_Dept.getRId());
				
					
					if(requisition.getRoleOfApprover().equalsIgnoreCase("")){
						//send DMP
						emailSubject = "Department Manpower Controller: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), req, emailSubject, emailMessage);

					}
					
					if(requisition.getRoleOfApprover().equalsIgnoreCase("DM")){
						//send DM and dmp
						emailSubject = "Department Manpower Controller: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Department Manager: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
					}
					if(requisition.getRoleOfApprover().equalsIgnoreCase("CMP")){
						//send DM,DM,CMP
						emailSubject = "Department Manpower Controller: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Department Manager: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Company Manpower Controller: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP, null, req, emailSubject, emailMessage);
					}
					if(requisition.getRoleOfApprover().equalsIgnoreCase("SPDM")){
						//send DM,DM,CMP,SPDM
						emailSubject = "Department Manpower Controller: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Department Manager: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Company Manpower Controller: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP, null, req, emailSubject, emailMessage);
						
						emailSubject = "SP Department Manager: Manpower Requisition "+reqid+" that you previously approved has been cancelled.";
						emailMessage = "This Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM,null, req, emailSubject, emailMessage);
						
					}
					if(requisition.getRoleOfApprover().equalsIgnoreCase("Staffing")){
						//send DM,DM,CMP,SPDM,STAFFING
					emailSubject = "Department Manpower Controller: Manpower Requisition "+reqid+" for that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Department Manager: Manpower Requisition "+reqid+" for that you previously approved has been cancelled.";
						emailMessage = "Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), req, emailSubject, emailMessage);
						
						emailSubject = "Company Manpower Controller: Manpower Requisition "+reqid+" for that you previously approved has been cancelled.";
						emailMessage = "This Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,null, req, emailSubject, emailMessage);
						
						emailSubject = "SP Department Manager: Manpower Requisition "+reqid+" for that you previously approved has been cancelled.";
						emailMessage = "This Requisition "+reqid+" has been cancelled.";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM, null , req, emailSubject, emailMessage);
						
						emailSubject = "Staffing: Manpower Requisition "+reqid+" for that you previously approved has been cancelled.";
						emailMessage = "This Requisition "+reqid+" has been cancelled. ";
						 url=	GenerateFrindlyURL.getURLForRequisition( req, reqid);
						emailMessage = emailMessage +"<br/> Cancellation comments : "+Comments+". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING, null, req, emailSubject, emailMessage);
					}
					
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Passing Status From waiting on manpower to Cancelled end */
	/* passing status disapprove to waiting on manpower */
	public void disapprovecomplete(ActionRequest req, ActionResponse res)
			throws PortletException, IOException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String reqid = req.getParameter("reqid");
		String Comments = req.getParameter("Comments");

		try {

			if (Validator.isNotNull(reqid)) {
				User user = UserLocalServiceUtil.getUserById(userId);
				String req_id = "";
				List<WFMS_Requisition> wfms_requisition = WFMS_RequisitionLocalServiceUtil.findByworkflowId(reqid);
				if (wfms_requisition.size() != 0) {
					for (WFMS_Requisition wfms_req : wfms_requisition) {
						req_id = wfms_req.getRwfId();
						WFMS_Requisition requisition = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(req_id);
						/*Removing the associate number and name*/
						requisition.setAssociatenumber(StringPool.BLANK);
						requisition.setAssociatename(StringPool.BLANK);
						requisition.setDisapproveComments(Comments);
						WFMS_RequisitionLocalServiceUtil
								.updateWFMS_Requisition(requisition);
						WFMS_Requisition processworkflow= WorkflowControler.processWorkflow(wfms_req, "onDisapprove", "complete-requisition", req);
						
					}
				} else {
					req_id = reqid;
					WFMS_Requisition requisition = WFMS_RequisitionLocalServiceUtil
							.fetchWFMS_Requisition(req_id);
					/*Removing the associate number and name*/
					requisition.setAssociatenumber(StringPool.BLANK);
					requisition.setAssociatename(StringPool.BLANK);
					requisition.setDisapproveComments(Comments);
					WFMS_RequisitionLocalServiceUtil
							.updateWFMS_Requisition(requisition);
					WFMS_Requisition processworkflow= WorkflowControler.processWorkflow(requisition, "onDisapprove", "complete-requisition", req);
				}
				HondaLogicUtil.auditLogsForReqAndCOS(req_id,
						WorkflowConstants.REQUISITION_DISAPPROVAL,
						WorkflowConstants.REQUISITION_ACTION, req, Comments);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Complete requisition disapprove end here */

	/* Complete requisition approve starts here */
	public void approvecomplete(ActionRequest req, ActionResponse res)
			throws Exception {
		String id = null;
		String reqid = req.getParameter("reqid");
		String Comments = req.getParameter("Comments");
		String positionId = req.getParameter("positionId");
		////System.out.println(positionId);
		String mpCatFilledWith = req.getParameter("mpCatFilledWith");
		String autogencos = req.getParameter("auto-gen-cos");
		////System.out.println(autogencos);
		Date now = new Date();
		WFMS_Requisition req_data = null;
		WFMS_Position pos = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		 User user = UserLocalServiceUtil.getUserById(userId);
		try {
			if (autogencos.equals("true")) {
				String currentPosid="";
				WFMS_COS wfms_COSList = null;
				wfms_COSList = new WFMS_COSImpl();
				pos = WFMS_PositionLocalServiceUtil
						.fetchWFMS_Position(positionId);
				req_data = WFMS_RequisitionLocalServiceUtil
						.fetchWFMS_Requisition(reqid);
				 List<WFMS_Position> poslistOnAssociatId=WFMS_PositionLocalServiceUtil.findByAssociateNumber(req_data.getAssociatenumber());
				 if(poslistOnAssociatId.size()>0) {  
					 WFMS_Position wFMS_pos = poslistOnAssociatId.get(0);
					 if(Validator.isNotNull(wFMS_pos.getPId())){
						 currentPosid=	wFMS_pos.getPId();
					 }
				 }
				 
				pos.setMpCatFilledWith(mpCatFilledWith);
				WFMS_PositionLocalServiceUtil.updateWFMS_Position(pos);
				wfms_COSList = new WFMS_COSImpl();
				long cosId = CounterLocalServiceUtil.increment(WFMS_COS.class.getName());
				int genId = HondaLogicUtil.getCurrentKi();
				Integer intObj = new Integer(genId);
				id = intObj + "-" + String.format("%04d", cosId);
				wfms_COSList.setCosId(id);
				wfms_COSList.setPositionNumber(currentPosid);
				wfms_COSList.setNewPositionNumber(positionId);
				wfms_COSList.setStatus(HondaPermissionKeys.COS_DRAFT);
				wfms_COSList.setCreateDate(now);
				wfms_COSList.setSystemGenerated(1);
				wfms_COSList.setAssociatename(req_data.getAssociatename());
				wfms_COSList.setAssoicateId(req_data.getAssociatenumber());
				wfms_COSList.setCompanyId(user.getUserId());
				wfms_COSList.setRequistionId(reqid);
				AssociateInformation assoInfo=null;
				assoInfo = HMAAssociateInfoService.fetchPositionOnAssociateNumber(req_data.getAssociatenumber());
				
				
				 HondaLogicUtil logicUtil=new HondaLogicUtil();
					Map<String,String> deptMap = logicUtil.singleCallOnServieNow(assoInfo.getDeptNumber().trim());
					wfms_COSList.setCurrentDepartmentManager(deptMap.get("deptMgrName"));
					wfms_COSList.setCurrentDivisionManager(deptMap.get("divMgrName"));
					wfms_COSList.setCurrentDivision(deptMap.get("divName"));
					wfms_COSList.setCurrentJobCode(assoInfo.getAssociateTitle().trim());
					wfms_COSList.setCurrentTeamNumber(assoInfo.getTeamNumber().trim());
					wfms_COSList.setCurrentShiftCode(assoInfo.getShiftCode().trim());
					wfms_COSList.setLeadershipAssignment(pos.getLeadershipAssignment());
					String leadership="";
					String assDateofHire="";
					assDateofHire=assoInfo.getAssociateDateOfHire();
					 if(assoInfo.getLeaderAssignment().equalsIgnoreCase("")) 
						 leadership="None";
					 else
						 leadership=assoInfo.getLeaderAssignment();
					
					wfms_COSList.setCurrentLeadershipAssignment(leadership);
					wfms_COSList.setAssociateDateOfHire(assDateofHire);
					wfms_COSList.setCurrentManagerAssocNumber(assoInfo.getMgrAssociateNo());
					
					AssociateInformation depManagerInfo=null;
					depManagerInfo = HMAAssociateInfoService.fetchDepManagerInfo(assoInfo.getMgrAssociateNo());
                    if(Validator.isNotNull(depManagerInfo.getAssociateTitle()))
					   wfms_COSList.setCurrentManagerTitle(depManagerInfo.getAssociateTitle());
                    else
                    	wfms_COSList.setCurrentManagerTitle("Not Found");
                    if(Validator.isNotNull(depManagerInfo.getAssociateName()))  
					    wfms_COSList.setCurrentManagerName(depManagerInfo.getAssociateName());
                     else
                    	wfms_COSList.setCurrentManagerName("Not Found");
                    
					wfms_COSList.setCurrentDepartmentName(assoInfo.getDeptName().trim());
					wfms_COSList.setCurrentDepartmentNumber(assoInfo.getDeptNumber().trim());
	                wfms_COSList.setCurrentManpowerRep(deptMap.get("mpwrrep_name"));
	                wfms_COSList.setNextApprover(StringUtil.merge(HondaLogicUtil.listOfrolseusers("", req, HondaPermissionKeys.ROLE_STAFFING),"<br/>"));
				WFMS_COSLocalServiceUtil.addWFMS_COS(wfms_COSList);
				HondaLogicUtil.auditLogsForReqAndCOS(id,
						WorkflowConstants.CHANGE_OF_STATUS_CREATE,
						WorkflowConstants.CHANGE_OF_STATUS_ACTION, req, Comments);
				
				String emailMessage="This change of status has been created and needs you to input data and submit. Click the below link to access the change of status.";
				String emailSubject = "Staffing: Change of Status "+id+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename().trim()+" has been submitted for you to input data.";
				
				String url=StringPool.BLANK;
				if(Validator.isNotNull(id)){
				 url=GenerateFrindlyURL.getCOSfrindlyURL(req, id);}
				emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
				EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,"", req, emailSubject, emailMessage);
				 HondaLogicUtil.auditLogsForAssociateHistory(req_data.getAssociatenumber(),"Completed Requisition to position "+req_data.getRId(),req_data.getRId(), req);
				
			}
			if (autogencos.equals("false")) {
				req_data = WFMS_RequisitionLocalServiceUtil
						.fetchWFMS_Requisition(reqid);
				String associateNameNoNum = null;
				String associateTitle = null;
				String associatenumber = req_data.getAssociatenumber();
				AssociateInformation assInfo = new AssociateInformation();
				if (associatenumber.equalsIgnoreCase("None")) {
					associateNameNoNum = req_data.getAssociatename();
				}
				HMAAssociateInfoService service = new HMAAssociateInfoService();
				assInfo = service.createRequisition(associatenumber);
				if (assInfo.getAssociateName() != null) {
					associateNameNoNum = assInfo.getAssociateName();
					associateTitle = assInfo.getAssociateTitle();
				}
			pos = WFMS_PositionLocalServiceUtil
						.fetchWFMS_Position(positionId);
				pos.setMpCatFilledWith(mpCatFilledWith);
				pos.setAssociateName(associateNameNoNum);
				pos.setAssociateTitle(associateTitle);
				pos.setAssociateNumber(associatenumber);
				pos.setNextApprover("");
				pos.setStatus(HondaPermissionKeys.POS_FILLED);
				WFMS_PositionLocalServiceUtil.updateWFMS_Position(pos);
				WFMS_RequisitionLocalServiceUtil
						.updateWFMS_Requisition(req_data);
				WFMS_Requisition processworkflow= WorkflowControler.processWorkflow(req_data, "onApprove", "complete-requisition", req);
				processworkflow.setNextapprove("");
		     	WFMS_RequisitionLocalServiceUtil.updateRequisition(processworkflow);
		     	HondaLogicUtil.auditLogsForPosition(positionId, null, WorkflowConstants.POSITION_FILLED, WorkflowConstants.POSITION_ACTOIN, req,"");   
		       
		        HondaLogicUtil.auditLogsForReqAndCOS(reqid,	WorkflowConstants.REQUISITION_COMPLETE,	WorkflowConstants.REQUISITION_ACTION, req, Comments);
		
			}
			
				
		} catch (NullPointerException e) {

		}
	}
	public void fillRequisition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
		//System.out.println("fillRequisition 222222233");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        User user = UserLocalServiceUtil.getUserById(userId);
        String rwfId = ParamUtil.getString(actionRequest, "rwfId");
        
        try {
					//System.out.println("requisisionnumber:"+rwfId);
					List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil
							.findByworkflowId(rwfId);
					String req_id = "";
					if (finalstep.size() != 0) {
						for (WFMS_Requisition req : finalstep) {
							req_id = req.getRwfId();
						}
					} else {
						req_id = rwfId;
					}
					WFMS_Requisition numberList = WFMS_RequisitionLocalServiceUtil
							.fetchWFMS_Requisition(req_id);
					numberList
							.setStatus(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER);
					WFMS_RequisitionLocalServiceUtil
							.updateWFMS_Requisition(numberList);
					HondaLogicUtil.auditLogsForReqAndCOS(req_id,
							WorkflowConstants.REQUISITION_FILL,
							WorkflowConstants.REQUISITION_ACTION, actionRequest,
							"");
        } catch (NullPointerException e) {

		}
	}


	/**
	 * 
	 * @param deptID
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	private static void getAssociateNameBydepId(String deptID,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, SystemException, PortalException {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String assName = HMAAssociateInfoService.getAssNameByDeptNumner(deptID);
		json.put("AssName", assName);
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(json);
	}

	/**
	 * 
	 * @param type
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 * @throws JSONException 
	 */
	private static void getRequisitionList(String type,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws SystemException, NumberFormatException, PortalException, JSONException {

		try {
			JSONObject json = DatagridDisplayManagerUtil.getRequisitionList(
					type, resourceRequest);
			PrintWriter writer = resourceResponse.getWriter();
			writer.print(json);
		} catch (IOException | com.liferay.portal.kernel.json.JSONException ioex) {
			// _log.error("IOException on Get Requisition List",ioex);
			ioex.printStackTrace();
		}
	}

	private Log _log = LogFactoryUtil
			.getLog(RequisitionPortlet.class.getName());
}