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
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_PositionImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_Position_AuditImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_RequisitionImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.ConfigUtility;
import com.ys.hmawfm.wfms.utils.DatagridDisplayManagerUtil;
import com.ys.hmawfm.wfms.utils.EmailUtility;
import com.ys.hmawfm.wfms.utils.GenerateFrindlyURL;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.HondaPermissionKeys;
import com.ys.hmawfm.wfms.utils.WMSUserAccessUtil;
import com.ys.hmawfm.wfms.vo.AssociateInformation;
import com.ys.hmawfm.wfms.workflow.ModifyPositionWorkflowContext;
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
        "javax.portlet.init-param.view-template=/html/position/managePosition.jsp",
        "javax.portlet.name=" + WorkflowConfigurationPortletKeys.Position,
        "com.liferay.portlet.instanceable=true",
        "com.liferay.portlet.single-page-application=true",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.display-name=WMS-Position"
       
    },
    service = Portlet.class
)
public class PositionPortlet extends MVCPortlet {

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		
		if (cmd.equals("reopenEvent")) {
			//checkReopenStatus(resourceRequest, resourceResponse);
		} else if (cmd.equals("LoadDivisionNames")) {
			//HMAMySQLConnection.getPositionsForCOS();
			getDivisionNameDeptName(resourceRequest, resourceResponse);
		} else if (cmd.equals("positionList")) {
			try {
				try {
					getPositionList(cmdType, resourceRequest, resourceResponse);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("closePositionEvent")) {
			try {
				closePositionAction(resourceRequest ,resourceResponse);
			} catch (NoSuchWFMS_RequisitionException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		else if (cmd.equalsIgnoreCase("Employecategory")) {
			try {
				empDescriptionOnchange(cmdType,resourceRequest, resourceResponse);
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
		} else if (cmd.equalsIgnoreCase("getAssName")) {
			try {
				getAssociateNameBydepId(cmdType ,resourceRequest, resourceResponse);
			} catch (Exception e) {
			e.printStackTrace();}
			}
		else if (cmd.equalsIgnoreCase("getAssNameForAddAssociate")) {
			try {
				getAssNameForAddAssociate(cmdType ,resourceRequest, resourceResponse);
			} catch (Exception e) {
			e.printStackTrace();}
			}
		else if (cmd.equalsIgnoreCase("CopyPosition")) {
			try {
			//	getAssNameForAddAssociate(cmdType ,resourceRequest, resourceResponse);
				getCopyPosition(resourceRequest,resourceResponse);
			} catch (Exception e) {
			e.printStackTrace();}
			}
		else {
			}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
			if (wfms_PositionList != null)
				request.setAttribute("wfms_PositionList", wfms_PositionList);
			Map<String,String> deptMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();

		} catch (SystemException e) {
			e.printStackTrace();
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			e.printStackTrace();
		}
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/html/position/managePosition.jsp");
		boolean loggedIn = themeDisplay.isSignedIn();
		if (!loggedIn){
			prd = getPortletContext().getRequestDispatcher("/html/signin.jsp");
		}
	
		prd.include(request, response);
	}

	/**
	 * @param path
	 * @param renderRequest
	 * @param renderResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void managePosition(ActionRequest request, ActionResponse response) throws Exception {
		try {
			List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
			if (wfms_PositionList != null)
				request.setAttribute("wfms_PositionList", wfms_PositionList);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/managePosition.jsp");
	}



	/* Redirected to createposition */
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void newPositions(ActionRequest request, ActionResponse response) throws Exception {
		try {
			List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
			if (wfms_PositionList != null)
				request.setAttribute("wfms_PositionList", wfms_PositionList);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/positionView.jsp");
	}

	/* Create position fields add to database */
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void createPosition(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		long companyId = user.getCompanyId();
		Group group = user.getGroup();
		long scopeGroupId = group.getGroupId();
		String deptNumber = request.getParameter("Deptid");
		Map<String, String> deptDivInfoMap=new HashMap<String, String>();
		HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();
		deptDivInfoMap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
		String depname= deptDivInfoMap.get("deptName") ;
		String division= deptDivInfoMap.get("divName") ;
		String deptManager= deptDivInfoMap.get("deptMgrName") ;
		String divisionManager= deptDivInfoMap.get("divMgrName") ;
		String mpCatBudget = request.getParameter("mpCatBudget");
    	String empCategory = request.getParameter("empCategory");
		String employeecatagorydescription = "";
		Map<String,String> shiftMap = new HashMap<String,String>();
		shiftMap=ConfigUtility.getInputValuesForMap("Employe-category");
		employeecatagorydescription  = shiftMap.get(empCategory);
		String resonchange = request.getParameter("reasonchange");
		String yearEst = request.getParameter("yearEst");
		String reevaluationDate = request.getParameter("reevaluationDate");
		String createPositionValue = request.getParameter("createPositionValue");
		String positionclass = request.getParameter("positionClass");
		String workforce = request.getParameter("workforceCategory");
		WFMS_Position wFMS_Position=null;
		
		try {
			  String    id=hondaLogicUtil.geneatePositionId(deptNumber);
			  String  reqid =hondaLogicUtil.geneateRequisitionId(deptNumber);
				if(Validator.isNotNull(createPositionValue) && createPositionValue.equalsIgnoreCase("save")){
					
					 wFMS_Position = WFMS_PositionLocalServiceUtil.addNewPosition(id,reqid,companyId, scopeGroupId, screenName,
							HondaPermissionKeys.POS_DRAFT, "", "", "", false, division, depname, deptNumber, "","", mpCatBudget, "",positionclass, "", "", "",
							"", "", "", empCategory, employeecatagorydescription, yearEst,resonchange, reevaluationDate, "", "", "", "",
							"", "", "", "", "", "","", "", "", "", "", "","",deptManager,divisionManager,WorkflowConstants.POSITION_CREATE_CONFIG_KEY,0);
					 HondaLogicUtil.auditLogsForPosition(wFMS_Position.getPId(), wFMS_Position.getAssociateNumber(), WorkflowConstants.POSITION_CREATE, WorkflowConstants.POSITION_ACTOIN,request,"");
					   
				    	 WorkflowControler.processWorkflow(wFMS_Position, "onSave" ,request);
				    	   //System.out.println(wFMS_Position.getPId());
					      WFMS_PositionLocalServiceUtil.clearCache();
					     response.sendRedirect("jspPage", "/html/position/managePosition.jsp");
				}
				
				if(Validator.isNotNull(createPositionValue) && createPositionValue.equalsIgnoreCase("submit")){
					
					 wFMS_Position = WFMS_PositionLocalServiceUtil.addNewPosition(id,reqid,companyId, scopeGroupId, screenName,
								HondaPermissionKeys.POS_PENDING, "", "", "", false, division, depname, deptNumber, "","", mpCatBudget, "", positionclass, "", "", "",
								"", "", "", empCategory, employeecatagorydescription, yearEst,resonchange, reevaluationDate, "", "", "", "",
								"", "", "", "", "", "","", "", "", "", "", "","",deptManager,divisionManager,WorkflowConstants.POSITION_CREATE_CONFIG_KEY,0);
				    WorkflowControler.processWorkflow(wFMS_Position, "onSubmit",request);
				    //System.out.println(wFMS_Position.getPId());
				 	//HondaLogicUtil.auditLogsForPosition(wFMS_Position.getPId(), wFMS_Position.getAssociateNumber(), WorkflowConstants.POSITION_CREATE, WorkflowConstants.POSITION_ACTOIN, request);
			    	WFMS_PositionLocalServiceUtil.clearCache();
			    	response.sendRedirect("jspPage", "/html/position/managePosition.jsp");
				}
			
		}
		
		catch (Exception e) {
                e.printStackTrace();		
				}
	
		
		}
	/* Redirect to update position with pos id */
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editPositionOnGenRequisition(ActionRequest request, ActionResponse response) throws Exception {
		try {
			    //System.out.print("-------------------------------Enter to editPosition action------------------------------------");
					String positionId = request.getParameter("positionId");
					List<WFMS_Position>  post= WFMS_PositionLocalServiceUtil.findByrefPosId(positionId);
					String tempStatus="";
					if(request.getParameter("autoReqAfterTerminate") != null){
						 request.setAttribute("autoReqAfterTerminate", request.getParameter("autoReqAfterTerminate"));
					}
					for(WFMS_Position obj:post)
					{
						tempStatus=	obj.getStatus();
					}
					  if(tempStatus.equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){
						  request.setAttribute("positionId", positionId.concat("-WFM"));
						  request.setAttribute("autoReqForTerminate", "autoReqForTerminate");
					  }
					  else {
						  request.setAttribute("positionId", positionId);
						  request.setAttribute("autoReqForTerminate", "autoReqForTerminate");
					  }
						
					
			    	
			}
		catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");
	}

	/* Redirect to update position with pos id */
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editPositionOnModifypoition(ActionRequest request, ActionResponse response) throws Exception {
		try {
					String positionId = request.getParameter("positionId");
					List<WFMS_Position>  post= WFMS_PositionLocalServiceUtil.findByrefPosId(positionId);
					String tempStatus="";
					if(request.getParameter("modifypositionalert") != null){
						 request.setAttribute("modifypositionalert", request.getParameter("modifypositionalert"));
					}
					for(WFMS_Position obj:post)
					{
						tempStatus=	obj.getStatus();
					}
					  if(tempStatus.equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){
						  request.setAttribute("positionId", positionId.concat("-WFM"));
						//  request.setAttribute("autoReqForTerminate", "autoReqForTerminate");
					  }
					  else {
						  request.setAttribute("positionId", positionId);
						  //request.setAttribute("autoReqForTerminate", "autoReqForTerminate");
					  }
						
					
			    	
			}
		catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");
	}

	
	/* Redirect to update position with pos id */
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editPosition(ActionRequest request, ActionResponse response) throws Exception {
		try {
					String positionId = request.getParameter("positionId");
					List<WFMS_Position>  post= WFMS_PositionLocalServiceUtil.findByrefPosId(positionId);
					String tempStatus="";
					if(request.getParameter("autoReqAfterTerminate") != null){
						 request.setAttribute("autoReqAfterTerminate", request.getParameter("autoReqAfterTerminate"));
					}
					for(WFMS_Position obj:post)
					{
						tempStatus=	obj.getStatus();
					}
					  if(tempStatus.equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){
						  request.setAttribute("positionId", positionId.concat("-WFM"));
					  }
					  else {
						  request.setAttribute("positionId", positionId);
					  }
						
					
			    	
			}
		catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");
	}

	/* Filter the values from manage position */
	/**
	 * 
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	public void newURL(ActionRequest req, ActionResponse res) throws Exception {
		String listsel = req.getParameter("listsel");
		
		req.setAttribute("listsel", listsel);
		res.sendRedirect("jspPage", "/html/position/managePosition.jsp");
	}
	
	
	/**
	 *  By ChandraMouli S
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws com.liferay.portal.kernel.exception.PortalException
	 */
	public void adddataPosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
	
		   String positionId = ParamUtil.getString(actionRequest, "pid");
		   try {
			   if(Validator.isNotNull(positionId)){
				   
			  WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.findByposition(positionId);
			  // TODo on Approve WorkFlow
				 WorkflowControler.processWorkflow(wfms_Position, "onDiscard",actionRequest);
			  actionRequest.setAttribute("positionId", positionId);
              actionRequest.setAttribute("addDataValue", "addDataValue");
              actionResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp"); 
		   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	/**
	 *  By ChandraMouli S
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws com.liferay.portal.kernel.exception.PortalException
	 */
	public void discardPosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
	       
		   String posid = ParamUtil.getString(actionRequest, "pid");
		   try {
			   if(Validator.isNotNull(posid)){
				   //System.out.print("posid>>>"+posid);
				  WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.getWFMS_Position(posid);
				  DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
				  wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(posid));
				  int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
				if(wfmPositionforTempcount > 0){
					  WorkflowControler.processWorkflow(wfms_Position, "onDiscard",actionRequest);
					  HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_Discard_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");   
					  
				   WFMS_PositionLocalServiceUtil.deleteWFMS_Position(posid);
				   
				   DynamicQuery wfmPositionAuditforTemp =WFMS_Position_AuditLocalServiceUtil.dynamicQuery();
				   wfmPositionAuditforTemp.add(PropertyFactoryUtil.forName("pId").eq(posid));
				  List<WFMS_Position_Audit> wfmPositionAuditList = WFMS_Position_AuditLocalServiceUtil.dynamicQuery(wfmPositionAuditforTemp);
					 for(WFMS_Position_Audit auditList:wfmPositionAuditList){ 
				           WFMS_Position_AuditLocalServiceUtil.deleteWFMS_Position_Audit(auditList.getPaId());
					 }
				}
				//actionRequest.setAttribute("positionId", posid);
	            //actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
	            //actionResponse.setRenderParameter("jspPage", "/html/position/managePosition.jsp"); 
		   }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void discardsecondPosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
	       
		   String posid = ParamUtil.getString(actionRequest, "pid");
		   ////System.out.println("discrad second position"+posid	  );
		   try {
			   if(Validator.isNotNull(posid)){
				   
			  WFMS_Position wfms_Position=WFMS_PositionLocalServiceUtil.findByposition(posid);
			  
			  DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
			  wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(posid+"-WFM"));
			  int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
				
			  if(wfmPositionforTempcount > 0){
			  WFMS_PositionLocalServiceUtil.deleteWFMS_Position(posid+"-WFM");
			  }
			  
			  wfms_Position.setDummy("0");
			  WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
			  if(wfms_Position.getWorkflowStep()==40){
			   HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_Discardsecondset, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");   
			  }
			  else{
				   HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_DiscardThirdset, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");   

			  }
			  // TODo on Approve WorkFlow
			  //actionRequest.setAttribute("positionId", posid);
          // actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
           actionResponse.setRenderParameter("jspPage", "/html/position/managePosition.jsp"); 
		   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 *  By ChandraMouli S
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws com.liferay.portal.kernel.exception.PortalException
	 */
	public void approvePosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
	
		   String posid = ParamUtil.getString(actionRequest, "pid");
		//   WFMS_Position wfms_Position=null;
		   String statusValue="";
		   try {
			   if(Validator.isNotNull(posid)){
				   
				   WFMS_Position  wfms_Position1=WFMS_PositionLocalServiceUtil.findByposition(posid);
			  // TODo on Approve WorkFlow
			     WFMS_Position  wfms_Position= WorkflowControler.processWorkflow(wfms_Position1, "onApprove",actionRequest);
				   	
		             if(wfms_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN) && wfms_Position.getAutoGenerateReq().equalsIgnoreCase("false")){
		           	  statusValue="openStatusValue"; 
		              actionRequest.setAttribute("statusValue", statusValue);
					  actionRequest.setAttribute("positionId", posid);
		              actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
		              actionResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp"); 
		              if(wfms_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN) && wfms_Position.getWorkflowStep()==80){
		             HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_APPROVE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");}
		             }
		             else{
			/*    actionRequest.setAttribute("positionId", posid);
                actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
                //HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_APPROVE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest);
                actionResponse.setRenderParameter("jspPage", "/html/position/managePosition.jsp"); 
             */   
		            	 actionResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(actionRequest));
		   }
			   }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	/**
	 *  By ChandraMouli S
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws com.liferay.portal.kernel.exception.PortalException
	 */
	public void disapprovePosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException{
		
		   String posid = ParamUtil.getString(actionRequest, "positionId");
		   String comments = ParamUtil.getString(actionRequest, "Comments");
		   WFMS_Position wfms_Position=null;
		   System.out.println(comments);
		   try {
			   if(Validator.isNotNull(posid)){
				   
			wfms_Position=WFMS_PositionLocalServiceUtil.findByposition(posid);
			wfms_Position.setDisapproveComments(comments);
			WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
			  //HondaLogicUtil.auditLogsForReqAndCOS(posid, WorkflowConstants.POSITION_DISAPPROVE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,comments);
              
			 // TODo on Disapprove WorkFlow
			 wfms_Position=	 WorkflowControler.processWorkflow(wfms_Position, "onDisapprove",actionRequest);
			
		
			  actionRequest.setAttribute("positionId", posid);
              actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
              actionResponse.setRenderParameter("jspPage", "/html/position/managePosition.jsp"); 
		   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

/**
 * Close Postion workFlow By ChandraMouli S
 * @param actionRequest
 * @param actionResponse
 * @throws SystemException
 * @throws com.liferay.portal.kernel.exception.PortalException
 * @throws PortletModeException 
 * @throws WindowStateException 
 * @throws IOException 
 */
public void closePosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, com.liferay.portal.kernel.exception.PortalException, WindowStateException, PortletModeException, IOException{
	
	
        String posid = ParamUtil.getString(actionRequest, "pid");
        String yesorno = ParamUtil.getString(actionRequest, "yesorno");
      	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if(yesorno.equalsIgnoreCase("yes")){
        	//_log.info("entered1");
        	try {
	     
	        
        	DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
	        dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(posid));
	        Criterion reqcriterion = null;
	        reqcriterion = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_CANCELLED);
	        reqcriterion = RestrictionsFactoryUtil.and(reqcriterion,
	        		RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_COMPLETE));
	        dynamicQueryForRequisation.add(reqcriterion);
	        List <WFMS_Requisition> requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation);
	        	WFMS_Requisition req_main=null;
	        	if (requisationList.size()>0 ) {
		        	WFMS_Requisition req_main_=null;
		        	if (requisationList.size()>0 ) {
			        	req_main=WFMS_RequisitionLocalServiceUtil.findByrequisition(requisationList.get(0).getRwfId());
			        	req_main.setStatus(HondaPermissionKeys.REQ_CANCELLED);
			        	req_main.setNextapprove("");
			        	try {
			        		req_main_=WFMS_RequisitionLocalServiceUtil.findByrequisition(requisationList.get(0).getRwfId()+"-WFM");
			        		req_main_.setStatus(HondaPermissionKeys.REQ_CANCELLED);
			        		req_main_.setNextapprove("");
			        		WFMS_RequisitionLocalServiceUtil.updateRequisition(req_main_);
			        		
						} catch (Exception e) {
							// TODO: handle exception
						}
		        	}
		        	WFMS_RequisitionLocalServiceUtil.updateRequisition(req_main);
		        	
	              	 HondaLogicUtil.auditLogsForReqAndCOS(requisationList.get(0).getRwfId(), WorkflowConstants.REQUISITION_CANCEL, WorkflowConstants.REQUISITION_ACTION, actionRequest, " Position Closed"); 
	              	// HondaLogicUtil.auditLogsForReqAndCOS(req_main_.getRwfId(), WorkflowConstants.REQUISITION_CANCEL, WorkflowConstants.REQUISITION_ACTION, actionRequest, "Position Closed");  
	        		long userId = themeDisplay.getUserId();
	              	User user = UserLocalServiceUtil.getUserById(userId);
					long companyId = user.getCompanyId();
					Role r;
					r = RoleLocalServiceUtil.getRole(companyId, "STAFFING");
					List<User> us = UserLocalServiceUtil
							.getRoleUsers(r.getRoleId());
					
					boolean dmLoggedIn = false;boolean cmpLoggedIn = false;boolean spdmLoggedIn = false;
					List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
					for(Role rS:userRoles){
						if(rS.getName().equals(HondaPermissionKeys.ROLE_CMP)){
							cmpLoggedIn = true;
						}
						if(rS.getName().equals(HondaPermissionKeys.ROLE_SPDM)){
							spdmLoggedIn = true;
						}
						
					}
			
					WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(req_main.getRId());
					String emailSubject = StringPool.BLANK;
					String emailMessage = StringPool.BLANK;
					String url = StringPool.BLANK;
					
						
						if(req_main.getRoleOfApprover().equalsIgnoreCase("")){
							//send DMP
							emailSubject = "Department Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);

						}
						
						if(req_main.getRoleOfApprover().equalsIgnoreCase("DM")){
							//send DM and dmp
							emailSubject = "Department Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Department Manager: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
						}
						if(req_main.getRoleOfApprover().equalsIgnoreCase("CMP")){
							//send DM,DM,CMP
							emailSubject = "Department Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +"<br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Department Manager: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Company Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP, null, actionRequest, emailSubject, emailMessage);
						}
						if(req_main.getRoleOfApprover().equalsIgnoreCase("SPDM")){
							//send DM,DM,CMP,SPDM
							emailSubject = "Department Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved as been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(),actionRequest , emailSubject, emailMessage);
							
							emailSubject = "Department Manager: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Company Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP, null, actionRequest, emailSubject, emailMessage);
							
							emailSubject = "SP Department Manager: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "This Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM,null, actionRequest, emailSubject, emailMessage);
							
						}
						if(req_main.getRoleOfApprover().equalsIgnoreCase("Staffing")){
							//send DM,DM,CMP,SPDM,STAFFING
						emailSubject = "Department Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Department Manager: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM,pos.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Company Manpower Controller: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "This Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,null, actionRequest, emailSubject, emailMessage);
							
							emailSubject = "SP Department Manager: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "This Requisition "+requisationList.get(0).getRwfId()+" has been cancelled.";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage =emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM, null , actionRequest, emailSubject, emailMessage);
							
							emailSubject = "Staffing: Manpower Requisition "+requisationList.get(0).getRwfId()+" for that you previously approved has been cancelled.";
							emailMessage = "This Requisition "+requisationList.get(0).getRwfId()+" has been cancelled. ";
							 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, requisationList.get(0).getRwfId());
							emailMessage = emailMessage +" <br/> Cancellation comments : Position Closed.<br/> <p><a href='"+url+"'>Click here to review the record</a></p>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING, null, actionRequest, emailSubject, emailMessage);
						}
						
				

	            }
	           WFMS_Position position =WFMS_PositionLocalServiceUtil.findByposition(posid);
	    	   position.setStatus(HondaPermissionKeys.POS_CLOSED);
	           WFMS_PositionLocalServiceUtil.updateWFMS_Position(position);
	           HondaLogicUtil.auditLogsForPosition(posid, position.getAssociateNumber(), WorkflowConstants.POSITION_CLOSE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
		    	actionResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(actionRequest));
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
        else{
			actionResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(actionRequest));
		
        }
      
}
        	

	public void reopenPosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
	    String posid = ParamUtil.getString(actionRequest, "pid");
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			 WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
			 ////_log.info("wfms_Position.getStatus()" +wfms_Position.getStatus());
			if (wfms_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_CLOSED)) {
				wfms_Position.setNextApprover("");
				wfms_Position.setStatus(HondaPermissionKeys.POS_OPEN);
				
			       HondaLogicUtil.auditLogsForPosition(posid, wfms_Position.getAssociateNumber(), WorkflowConstants.POSITION_REOPEN_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
				WFMS_PositionLocalServiceUtil.updatePositionEntry(wfms_Position);
				 if(wfms_Position.getAutoGenerateReq().equalsIgnoreCase("true")){
						long userId = themeDisplay.getUserId();
						User user = UserLocalServiceUtil.getUserById(userId);
						long companyId = user.getCompanyId();
						Group group = user.getGroup();
						long scopeGroupId = group.getGroupId();
					    ////_log.info("isAutoGenerate true:" + wfms_Position.getAutoGenerateReq());
						Date createDate = new Date();
						WFMS_Requisition entry = new WFMS_RequisitionImpl();
						String id = hondaLogicUtil.geneateRequisitionId(wfms_Position.getDepartmentNumber());	
						entry.setRwfId(id);
						entry.setStatus(HondaPermissionKeys.POS_DRAFT);
						entry.setRId(wfms_Position.getPId());
						entry.setCreateDate(createDate);
						entry.setDummy("0");
						entry.setCompanyId(companyId);
						entry.setScopeGroupId(scopeGroupId);
						entry.setCreatedBy(user.getFullName());
						Map<String, String>	hondamap=null;
						if(Validator.isNotNull(wfms_Position.getDepartmentNumber())){
						hondamap=hondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
						}
						entry.setNextapprove(hondamap.get("mpwrrep_name"));
						WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
						HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, actionRequest , "");
						String emailMessage="This requisition has been created and needs you to input the required information and submit. <br/>  Click the below link to access the requisition.";
						String emailSubject = "Department Manpower Controller: Manpower Requisition "+id+" has been created.";
						String url=GenerateFrindlyURL.getURLForRequisition( actionRequest, id);
						emailMessage = emailMessage +"<br/><a href='"+url+"'>Click here to review the record</a>";
						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_Position.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
						WFMS_RequisitionLocalServiceUtil.clearCache();
						
				 }
				
				}
			 WFMS_Position wfms_Position1 = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
			 SessionMessages.add(actionRequest, "request_processed", "Your request completed reopenPosition sucessfully");
		/*	 actionRequest.setAttribute("autoReqForTerminate", "autoReqForTerminate");
			 actionRequest.setAttribute("positionId", posid);
			 actionRequest.setAttribute("wfms_PositionObj", wfms_Position1);
			actionResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");*/
				Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
				PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
				portletURL.setWindowState(WindowState.NORMAL);
			    portletURL.setParameter("autoReqForTerminate", "autoReqForTerminate");
				portletURL.setParameter(ActionRequest.ACTION_NAME,"editPositionOnGenRequisition");
				portletURL.setParameter("positionId",posid);
				actionResponse.sendRedirect(portletURL.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	/**

	 * Add associate process By ChandraMouli S
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws NoSuch_RequisitionException 
	 */
	public void addAssociatePosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		
		
		        String posid = ParamUtil.getString(actionRequest, "pid");
		      
		        actionRequest.setAttribute("positionId", posid);
		        WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
		        try {
					if(Validator.isNotNull(wfms_Position)){
						actionResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(actionRequest));
                  	                            
					}
				} catch (Exception e) {
						e.printStackTrace();				}
		  
                   		 
	}
	
	public void mpCatBudgetForAsscociate(ActionRequest request, ActionResponse response) throws SystemException, PortalException, WindowStateException, IOException{
		String Pid= request.getParameter("posid");
		String mpCatfilled= request.getParameter("mpCatBudgetAss");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		WFMS_Position list=WFMS_PositionLocalServiceUtil.findByposition(Pid);
		request.setAttribute("positionId", Pid);
		request.setAttribute("wfms_PositionObj", list);
		request.setAttribute("addAssociate", "addAssociate");
		request.setAttribute("mpCatBudgetAss",mpCatfilled);
		response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");	
	/*	Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
		PortletURL portletURL = PortletURLFactoryUtil.create(request,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
		portletURL.setWindowState(WindowState.NORMAL);
	    portletURL.setParameter("addAssociate", "addAssociate");
		portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
		portletURL.setParameter("positionId",Pid);
		response.sendRedirect(portletURL.toString());*/
	}
	
	public void saveAssociatedata(ActionRequest request, ActionResponse response) throws NoSuchWFMS_PositionException, SystemException, SQLException{
		String Pid= request.getParameter("posid");
		String associatenumber= request.getParameter("associatenumber");
		String mpCatfilled= request.getParameter("mpCatBudgetAss");
		try {
			if(Validator.isNotNull(associatenumber)){
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

				//String associateId = null;
				String associateNumber = null;
				String associateName = null;
				String logForAddAssociate=StringPool.BLANK;
				
				
				WFMS_Position list=WFMS_PositionLocalServiceUtil.findByposition(Pid);
				
				
			
				AssociateInformation obj=HMAAssociateInfoService.fetchPositionOnAssociateNumber(associatenumber);
				list.setAssociateNumber(associatenumber);
				list.setAssociateName(obj.getAssociateName());
				list.setAssociateTitle(obj.getAssociateTitle());
				list.setMpCatFilledWith(mpCatfilled);
				list.setNextApprover("");
				list.setStatus(HondaPermissionKeys.POS_FILLED);
				
				WFMS_PositionLocalServiceUtil.updatePositionEntry(list);
				
				logForAddAssociate=obj.getAssociateName()+" ["+associatenumber+"] has been added to this position.";
				////_log.info(logForAddAssociate+"   logForAddAssociate-");
				HondaLogicUtil.auditLogsForPosition(Pid, associateName,logForAddAssociate , WorkflowConstants.POSITION_ACTOIN, request,"");
				HondaLogicUtil.auditLogsForPosition(Pid, associateNumber, WorkflowConstants.POSITION_FILLED, WorkflowConstants.POSITION_ACTOIN, request,"");
				  HondaLogicUtil.auditLogsForAssociateHistory(associatenumber,"Add Associate to position "+Pid,Pid, request);
				  
				/*	request.setAttribute("positionId", Pid);
					request.setAttribute("wfms_PositionObj", list);
					request.setAttribute("filledmodal", "filledmodal");
					request.setAttribute("associatenumber", associatenumber);
			     	response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");*/
					Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
					PortletURL portletURL = PortletURLFactoryUtil.create(request,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
					portletURL.setWindowState(WindowState.NORMAL);
				    portletURL.setParameter("filledmodal", "filledmodal");
					portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
					portletURL.setParameter("positionId",Pid);
					response.sendRedirect(portletURL.toString());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	public void updateForPosition(ActionRequest request, ActionResponse response) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		long companyId = user.getCompanyId();
		Group group = user.getGroup();
		long scopeGroupId = group.getGroupId();
		String autogenreq = request.getParameter("auto-gen-req");
		//boolean isAutoGenerate = Boolean.parseBoolean(autogenreq);
		String positionid = request.getParameter("positionid");
		//DynamicQuery wfmPositionCount =DynamicQueryFactoryUtil.forClass(WFMS_Position.class);
	//	wfmPositionCount.add(PropertyFactoryUtil.forName("pId").eq(positionid));
		//  int wfmPositionscount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionCount);
		  WFMS_Position wfmPositionscount_=WFMS_PositionLocalServiceUtil.getByPositionId(positionid);
		if(Validator.isNotNull(wfmPositionscount_)){
		WFMS_Position wfms_Positionlistforvalues=WFMS_PositionLocalServiceUtil.getByPositionId(positionid);
		String description = request.getParameter("positionDescription");
         if(Validator.isNotNull(description))
        	description=description.trim();
		String reportedTo = ParamUtil.getString(request, "reportsTo");
		String criticalwrk = request.getParameter("critical-wrk-seg");
		boolean criticalwrkseg = Boolean.parseBoolean(criticalwrk);
		String associateNumber =request.getParameter("associateNumber");
		String associateName = request.getParameter("associateName");
		String associatetitle = request.getParameter("associateTitle");
		String deptNumber =ParamUtil.getString(request, "Deptid");
		Map<String, String> deptDivInfoMap=new HashMap<String, String>();
		HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();
		deptDivInfoMap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
		String depname= deptDivInfoMap.get("deptName") ;
		String division= deptDivInfoMap.get("divName") ;
		String deptManager= deptDivInfoMap.get("deptMgrName") ;
		String divisionManager= deptDivInfoMap.get("divMgrName") ;
		String line = request.getParameter("line");
		String ladder = request.getParameter("ladder");
		String mpCatBudget = request.getParameter("mpCatBudget");
		String mpCatFilledWith=StringPool.BLANK;
		if(Validator.isNotNull(wfms_Positionlistforvalues.getMpCatFilledWith())){
			mpCatFilledWith=wfms_Positionlistforvalues.getMpCatFilledWith();
			if(wfms_Positionlistforvalues.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)){
				mpCatFilledWith = request.getParameter("mpCatFilledWith");
			}
		}
		String positionclass =  request.getParameter("positionClass");
		String positiontype = request.getParameter("positionType");
		String positionlevel = request.getParameter("positionLevel");
		String leadershipassignment = request.getParameter("leadershipassignment");
		String category =ParamUtil.getString(request,"category");
		String subCategory = request.getParameter("subCategory");
		//For workforce category and desc
		String workforce = request.getParameter("workforceCategory");
		String workforceCategorydb=""; 
		String workforceCategory="";
		Map<String,String> workforceCategorydesc = new HashMap<String,String>();
		workforceCategorydesc=ConfigUtility.getInputValuesForMap("workforce-category");
		workforceCategorydb = workforceCategorydesc.get(workforce);
		workforceCategory = workforce ;
			//	+ ":"+workforceCategorydb;
		  
		//For employee category and desc
		String empCategory = request.getParameter("empCategory");
		String employeecatagorydescription = "";
		Map<String,String> shiftMap = new HashMap<String,String>();
		shiftMap=ConfigUtility.getInputValuesForMap("Employe-category");
		employeecatagorydescription  = shiftMap.get(empCategory);
		
		//String empCategory = request.getParameter("empCategory");
		//String employeecatagorydescription = request.getParameter("employeecatagorydescription");
		String resonchange = request.getParameter("reasonchange");
		  if(Validator.isNotNull(resonchange))
			  resonchange=resonchange.trim();
		String yearEst = request.getParameter("yearEst");
		if(Validator.isNotNull(yearEst)) 
			yearEst=yearEst.trim();
		String reevaluationDate = request.getParameter("reevaluationDate");
		if(Validator.isNotNull(reevaluationDate))
			reevaluationDate=reevaluationDate.trim();
		String comments = ParamUtil.getString(request, "comments_updation");
		if(Validator.isNotNull(comments))
			comments=comments.trim();
		String typicaljobtitle = ParamUtil.getString(request, "typicaljobtitle");
		if(Validator.isNotNull(typicaljobtitle))
			typicaljobtitle=typicaljobtitle.trim();
	//	String comments =ParamUtil.getString(request, "comments_updation");
		String minimumjob = request.getParameter("minimumjob");
		if(Validator.isNotNull(minimumjob))
			minimumjob=minimumjob.trim();
		String prioritizedduties = request.getParameter("prioritizedduties");
		if(Validator.isNotNull(prioritizedduties))
			prioritizedduties=prioritizedduties.trim();
		String dailytask = request.getParameter("dailytask");
		if(Validator.isNotNull(dailytask))
			dailytask=dailytask.trim();
		String degreecertificate = request.getParameter("degreecertificate");
		if(Validator.isNotNull(degreecertificate))
			degreecertificate=degreecertificate.trim();
		String requiredskills = request.getParameter("requiredskills");
		if(Validator.isNotNull(requiredskills))
			requiredskills=requiredskills.trim();
		String desiredskills = request.getParameter("desiredskills");
		if(Validator.isNotNull(desiredskills))
			desiredskills=desiredskills.trim();
		String environmentassociate = request.getParameter("environmentassociate");
		if(Validator.isNotNull(environmentassociate))
			environmentassociate=environmentassociate.trim();
		String estimateweekly = request.getParameter("estimateweekly");
		if(Validator.isNotNull(estimateweekly))
			estimateweekly=estimateweekly.trim();
		String frequency = request.getParameter("frequency");
		if(Validator.isNotNull(frequency))
			frequency=frequency.trim();
		String status = request.getParameter("status");
		String history = "";
		String other= null;


		if(category.equalsIgnoreCase("Other"))
		{
		    other = request.getParameter("other");
		}
        String lengthofservices = request.getParameter("lengthofservices");
        if(Validator.isNotNull(lengthofservices))
        	lengthofservices=lengthofservices.trim();
		WFMS_Position wFMS_Position = WFMS_PositionLocalServiceUtil.getByPositionId(positionid);
		String modifyFlag=ParamUtil.getString(request,"buttonclickUpdate");
		//_log.info("<------modifyFlag value is >>>"+modifyFlag);
		//_log.info("<------modifyFlag value is >>>"+modifyFlag);
		if(HondaPermissionKeys.POS_MODFIED.equalsIgnoreCase(modifyFlag) || HondaPermissionKeys.SaveModify.equalsIgnoreCase(modifyFlag)){
			String changesList="";
			//DynamicQuery dynamicQueryForPosition = DynamicQueryFactoryUtil.forClass(WFMS_Position.class);
            //dynamicQueryForPosition.add(PropertyFactoryUtil.forName("pId").eq(positionid+"-WFM"));
            //List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForPosition);
            WFMS_Position getPosition = WFMS_PositionLocalServiceUtil.getByPositionId(positionid);
            String positionstatus="";
            positionstatus=HondaPermissionKeys.POS_MODFIED;
           

            if(!getPosition.getDepartmentNumber().equalsIgnoreCase(deptNumber))
	        	changesList+="<li>\"Department Number\" changed from \""+getPosition.getDepartmentNumber()+"\" To \""+deptNumber+"\"</li>";
	        
	        if(!getPosition.getMpCatBugdet().equalsIgnoreCase(mpCatBudget))
	        	changesList+="<li>\"MP Category Budget\" changed from \""+getPosition.getMpCatBugdet()+"\" To \""+mpCatBudget+"\"</li>";
	        
	        if(!getPosition.getPositionClass().equalsIgnoreCase(positionclass))
	        	changesList+="<li>\"Position Class\" changed from \""+getPosition.getPositionClass()+"\" To \""+positionclass+"\"</li>";
	        
	        if(!getPosition.getYearEst().equalsIgnoreCase(yearEst))
	        	changesList+="<li>\"Year Established\" changed from \""+getPosition.getYearEst()+"\" To \""+yearEst+"\"</li>";
	        
	        if(!getPosition.getReasonsFor().equalsIgnoreCase(resonchange))
	        	changesList+="<li>\"Reason for addition or change\" changed from \""+getPosition.getReasonsFor()+"\" To \""+resonchange+"\"</li>";
	        
	        if(!getPosition.getReavailuationDate().equalsIgnoreCase(reevaluationDate))
	        	changesList+="<li>\"Position Re-evaluation date\" changed from \""+getPosition.getReavailuationDate()+"\" To \""+reevaluationDate+"\"</li>";
	        
	        if(!getPosition.getAutoGenerateReq().equalsIgnoreCase(autogenreq)){
	        	String autoGenerateReq="",autogenreqStatus="";
		        	if(getPosition.getAutoGenerateReq().equalsIgnoreCase("true"))
		        		autoGenerateReq="Yes";
		        	else if(getPosition.getAutoGenerateReq().equalsIgnoreCase("false"))
		        		autoGenerateReq="No";
		        	if(autogenreq.equalsIgnoreCase("true"))
		        		autogenreqStatus="Yes";
		        	else if(autogenreq.equalsIgnoreCase("false"))
		        		autogenreqStatus="No";
	        	changesList+="<li>\"Auto Generate Requisition?\" changed from \""+autoGenerateReq+"\" To \""+autogenreqStatus+"\"</li>";
	        }
	        
	        if(getPosition.getCritical()!=criticalwrkseg){
	         	changesList+="<li>\"Is this a Critical Work Segment?\" changed from \""+getPosition.getCritical()+"\" To \""+criticalwrkseg+"\"</li>";
	        }
	       if(!getPosition.getReportsTo().equalsIgnoreCase(reportedTo))
	        	changesList+="<li>\"Position Reports to\" changed from \""+getPosition.getReportsTo()+"\" To \""+reportedTo+"\"</li>";
	        
	        if(!getPosition.getLine().equalsIgnoreCase(line))
	        	changesList+="<li>\"Line\" changed from \""+getPosition.getLine()+"\" To \""+line+"\"</li>";
	        
	        if(!getPosition.getLadder().equalsIgnoreCase(ladder))
	        	changesList+="<li>\"Ladder\" changed from \""+getPosition.getLadder()+"\" To \""+ladder+"\"</li>";
	        
	        if(!getPosition.getType().equalsIgnoreCase(positiontype))
	        	changesList+="<li>\"Type\" changed from \""+getPosition.getType()+"\" To \""+positiontype+"\"</li>";
	        
	        if(!getPosition.getLevel().equalsIgnoreCase(positionlevel))
	        	changesList+="<li>\"Level\" changed from \""+getPosition.getLevel()+"\" To \""+positionlevel+"\"</li>";
	        
	        if(!getPosition.getLeadershipAssignment().equalsIgnoreCase(leadershipassignment))
	        	changesList+="<li>\"Leadership Assignment\" changed from \""+getPosition.getLeadershipAssignment()+"\" To \""+leadershipassignment+"\"</li>";
	        
	        if(!getPosition.getCategory().equalsIgnoreCase(category))
	        	changesList+="<li>\"Category\" changed from \""+getPosition.getCategory()+"\" To \""+category+"\"</li>";
	        
	        if(!getPosition.getSubCategory().equalsIgnoreCase(subCategory))
	        	changesList+="<li>\"Subcategory\" changed from \""+getPosition.getSubCategory()+"\" To \""+subCategory+"\"</li>";
	        
	        if(!getPosition.getWorkforceCategory().equalsIgnoreCase(workforceCategory))
	        	changesList+="<li>\"Workforce Category\" changed from \""+getPosition.getWorkforceCategory()+"\" To \""+workforceCategory+"\"</li>";
	        
	        if(!getPosition.getDescription().equalsIgnoreCase(description))
	        	changesList+="<li>\"Position Description\" changed from \""+getPosition.getDescription()+"\" To \""+description+"\"</li>";
	        
	        if(!getPosition.getTypicalJobTitle().equalsIgnoreCase(typicaljobtitle))
	        	changesList+="<li>\"Typical Job Title\" changed from \""+getPosition.getTypicalJobTitle()+"\" To \""+typicaljobtitle+"\"</li>";
	        
	        if(!getPosition.getMinJobKnowHow().equalsIgnoreCase(minimumjob))
	        	changesList+="<li>\"Minimum Job Relevant Knowledge\" changed from \""+getPosition.getMinJobKnowHow()+"\" To \""+minimumjob+"\"</li>";
	        
	        if(!getPosition.getDuties().equalsIgnoreCase(prioritizedduties))
	        	changesList+="<li>\"Prioritized duties and Responsibilities\" changed from \""+getPosition.getDuties()+"\" To \""+prioritizedduties+"\"</li>";
	      
	        if(!getPosition.getTasksPerformed().equalsIgnoreCase(dailytask))
	        	changesList+="<li>\"Daily Tasks Performed\" changed from \""+getPosition.getTasksPerformed()+"\" To \""+dailytask+"</li>"; 
	       
	        if(!getPosition.getLengthOfService().equalsIgnoreCase(lengthofservices))
	        	changesList+="<li>\"Minimun Job Relevant Experience\" changed from \""+getPosition.getLengthOfService()+"\" To \""+lengthofservices+"\"</li>";
	        
	        if(!getPosition.getDegree().equalsIgnoreCase(degreecertificate))
	        	changesList+="<li>\"Degree or certification required\" changed from \""+getPosition.getDegree()+"\" To \""+degreecertificate+"\"</li>";

	        if(!getPosition.getReqSkills().equalsIgnoreCase(requiredskills))
	        	changesList+="<li>\"Required Skills\" changed from \""+getPosition.getReqSkills()+"\" To \""+requiredskills+"\"</li>";
	        
	        if(!getPosition.getDesiredSkills().equalsIgnoreCase(desiredskills))
	        	changesList+="<li>\"Desired Skills and Abilities\" changed from \""+getPosition.getDesiredSkills()+"\" To \""+desiredskills+"\"</li>";
	       
	        if(!getPosition.getEnvironment().equalsIgnoreCase(environmentassociate))
	        	changesList+="<li>\"Environment Associate will work in\" changed from \""+getPosition.getEnvironment()+"\" To \""+environmentassociate+"\"</li>";
	       
	        if(!getPosition.getWeeklyOvertime().equalsIgnoreCase(estimateweekly))
	        	changesList+="<li>\"Estimates Weekly Overtime\" changed from \""+getPosition.getWeeklyOvertime()+"\" To \""+estimateweekly+"\"</li>";
	        
	        if(!getPosition.getFrequencyOfTravel().equalsIgnoreCase(frequency))
	        	changesList+="<li>\"Frequency and Duration of Travel\" changed from \""+getPosition.getFrequencyOfTravel()+"\" To \""+frequency+"\"</li>";
	        
	        if(!getPosition.getEmpCategory().equalsIgnoreCase(empCategory))
	        	changesList+="<li>\"Employee Category\" changed from \""+getPosition.getEmpCategory()+"\" To \""+empCategory+"\"</li>";
	        
	        if(!getPosition.getComments().equalsIgnoreCase(comments))
	        	changesList+="<li>\"Comments\" changed from \""+getPosition.getComments()+"\" To \""+comments+"\"</li>";

	        if(!changesList.isEmpty()){
	        	//_log.info("enter to if");
	        	changesList="</br></br><ul class='changed-fields-list'>"+changesList+"</ul>";
	        	getPosition=WMSUserAccessUtil.createTempPositionForModify(positionid);
	        	 String requistionId = hondaLogicUtil.geneateRequisitionId(deptNumber);
	            WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.updatePosition(requistionId,positionid, screenName,
					"", "", positionstatus, description, reportedTo, autogenreq, criticalwrkseg, division,
					depname, deptNumber, line, ladder, mpCatBudget, mpCatFilledWith, positionclass, positiontype,
					positionlevel.toString(), leadershipassignment, category, subCategory, workforceCategory, empCategory,
					employeecatagorydescription, yearEst, resonchange, reevaluationDate, getPosition.getAssociateName(),
					getPosition.getAssociateNumber(), getPosition.getAssociateTitle(), comments, typicaljobtitle, minimumjob, prioritizedduties,
					dailytask, lengthofservices, degreecertificate, requiredskills, desiredskills,
					environmentassociate, estimateweekly, frequency, history,other, deptManager,divisionManager,companyId, scopeGroupId);
	        _log.info("------->Befor check record is modify or not<---------");
	        if(HondaPermissionKeys.POS_MODFIED.equalsIgnoreCase(modifyFlag)){
	        	_log.info("------->After check record is modify or not<---------");
				 ModifyPositionWorkflowContext.processModifyPosition(8, request, response);
				 _log.info("------->After workflow step completion<---------");
				 String date=HondaLogicUtil.getDateFormat(new Date());
				 String url=GenerateFrindlyURL.getHMAfrindlyURL(request, positionid);
				 String subject ="Department Manager: Position "+ positionid+" has been modified and needs your approval.";
					String body ="Position "+ positionid +" has been modified "+changesList+".<br/>Please click the link below to approve the position.<br/> <p><a href='"+url+"'> Click here to review the record</a></p>";
					
					EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_Position.getDepartmentNumber(), request,subject, body);
					subject ="Company Manpower Controller: Position " + positionid + " has been modified and needs your approval.";
					 body ="Position "+ positionid+" has been modified "+changesList+" .<br/>Please click the link below to approve the position.<br/> <p><a href='"+url+"'> Click here to review the record</a></p>";

					EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP, null, request,subject, body);
					subject ="SP Department Manager: Position " + positionid + " has been modified and needs your approval.";
					 body ="Position "+ positionid+" has been modified "+changesList+" .<br/>Please click the link below to approve the position.<br/> <p><a href='"+url+"'> Click here to review the record</a></p>";
					 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM, null, request,subject, body);
		         HondaLogicUtil.auditLogsForPosition(positionid, "", user.getFullName()+" submitted after Modifying Position on "+date+" for below fields" +changesList , WorkflowConstants.POSITION_ACTOIN , request,WorkflowConstants.POSITION_MODIFY_POSITION_SUBMIT);
			}
	      response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
	        }
	        else{
	        	//_log.info("enter to else");
	          /*  request.setAttribute("positionId", getPosition.getPId());
	        	request.setAttribute("wfms_PositionObj", getPosition);
	        	request.setAttribute("modifypositionalert", "As you have not modified any values over Position, the position status remains same.");
				response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");*/
	        	Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
				PortletURL portletURL = PortletURLFactoryUtil.create(request,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
				portletURL.setWindowState(WindowState.NORMAL);
			    portletURL.setParameter("modifypositionalert", "As you have not modified any values over Position, the position status remains same.");
				portletURL.setParameter(ActionRequest.ACTION_NAME,"editPositionOnModifypoition");
				portletURL.setParameter("positionId",getPosition.getPId());
				response.sendRedirect(portletURL.toString());
	        	
	      /*  	Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
				PortletURL portletURL = PortletURLFactoryUtil.create(request,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
				portletURL.setWindowState(WindowState.NORMAL);
				portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
				portletURL.setParameter("positionId",getPosition.getPId());
				portletURL.setParameter("modifypositionalert","As you have not modified any values over Position, the position status remains same.");
				response.sendRedirect(portletURL.toString());*/
		
	        }
			
			/*else{
				  HondaLogicUtil.auditLogsForPosition(positionid, "", WorkflowConstants.POSITION_MODIFY_POSITION_SAVE +changesList, WorkflowConstants.POSITION_ACTOIN , request,"");
			}*/
		    
		}else{
		

		//String lengthofservices = request.getParameter("lengthofservices");
		String reopenButton = request.getParameter("reopenButton");
		String genreqValueAction = request.getParameter("genreqValue");
		String saveonworkflow=request.getParameter("saveonworkflow");
		String autoreqGenForReopen=request.getParameter("autoreqGenForReopen");
		String yesOrNo = ParamUtil.getString(request, "auto-gen-req-choice");
		////_log.info("createPosition: yes or no:" + yesOrNo);
	
		//////_log.info( "genreqValueAction:" + genreqValueAction + "status" + status+"levels"+positionlevel.toString());
		WFMS_Position wfms_Positions=null;
		
		try {
			if(Validator.isNotNull(autoreqGenForReopen) && autoreqGenForReopen.equalsIgnoreCase("true") && !wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)){
				String pgositionid = request.getParameter("positionid");
				String gstatus = HondaPermissionKeys.REQ_DRAFT;
				Date createdate = new Date();
				WFMS_Position position=WFMS_PositionLocalServiceUtil.findByposition(pgositionid);
				List<WFMS_Requisition> findreq = WFMS_RequisitionLocalServiceUtil.findBypositionnumber(pgositionid);
							WFMS_Requisition entry = new WFMS_RequisitionImpl();
			              	String id = hondaLogicUtil.geneateRequisitionId(position.getDepartmentNumber());	
							entry.setRwfId(id);
						//	  //_log.info("Reqid for requisation complete id  :"+id);
							entry.setRwfId(id); 
							entry.setStatus(gstatus);
							entry.setRId(pgositionid);
							entry.setCreateDate(createdate);
							entry.setCompanyId(companyId);
							entry.setScopeGroupId(scopeGroupId);
							entry.setDummy("0");
							entry.setCreatedBy(user.getFullName());
							Map<String, String>	hondamap=null;
							if(Validator.isNotNull(position.getDepartmentNumber())){
							hondamap=hondaLogicUtil.singleCallOnServieNow(position.getDepartmentNumber());
							}
							entry.setNextapprove(hondamap.get("mpwrrep_name"));
						
							WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
							WFMS_RequisitionLocalServiceUtil.clearCache();
							HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE,WorkflowConstants.REQUISITION_ACTION, request, comments);
							//request.setAttribute("posid", pgositionid);
							WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(pgositionid);
							//request.setAttribute("reqcid", id);
							
							
							String emailMessage="This requisition has been created and needs you to input the required information and submit. <br/> Click the below link to access the requisition.";
							String emailSubject = "Department Manpower Controller: Manpower Requisition "+id+"  has been created.";
							String url=GenerateFrindlyURL.getURLForRequisition( request, id);
							emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_Position.getDepartmentNumber(), request, emailSubject, emailMessage);
								
							WFMS_RequisitionLocalServiceUtil.clearCache();
							PortletSession session = request.getPortletSession();
							session.setAttribute("posid", pgositionid,PortletSession.APPLICATION_SCOPE);
					/*	
							request.setAttribute("positionId", wfms_Position.getPId());
							request.setAttribute("requisitionId", id);
							request.setAttribute("wfms_PositionObj", wfms_Positions);
							request.setAttribute("create", "Create");
							response.setRenderParameter("jspPage","/html/requisition/manageRequisition.jsp");
							*/
							response.sendRedirect(GenerateFrindlyURL.getURLForRequisition(request, id));
							//response.setRenderParameter("jspPage", "/html/requisition/createRequisition.jsp");
			}
			else if(!wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING))
			{
				WFMS_Position poslist=WFMS_PositionLocalServiceUtil.findByposition(positionid);	
				poslist.setAssociateName("");
				poslist.setAssociateNumber("");
				poslist.setAssociateTitle("");
				WFMS_PositionLocalServiceUtil.updatePositionEntry(poslist);
				
				response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
			}
			
			if(Validator.isNotNull(saveonworkflow) && saveonworkflow.equalsIgnoreCase("save")){
				  String    positionId=HondaLogicUtil.geneatePositionId(deptNumber);
				  String  requisitionId =HondaLogicUtil.geneateRequisitionId(deptNumber);
				 WFMS_PositionLocalServiceUtil.addnewtempPosition( positionId,requisitionId,companyId, scopeGroupId, screenName,
						"save", description, reportedTo, autogenreq, criticalwrkseg, division, depname, deptNumber, line,
						ladder, mpCatBudget, mpCatFilledWith, positionclass, positiontype, positionlevel, leadershipassignment,
						category, subCategory, workforceCategory, empCategory, employeecatagorydescription, yearEst,
						resonchange, reevaluationDate, associateName, associateNumber, associatetitle, comments,
						typicaljobtitle, minimumjob, prioritizedduties, dailytask, lengthofservices, degreecertificate,
						requiredskills, desiredskills, environmentassociate, estimateweekly, frequency, history,other,deptManager,divisionManager,positionid);
				 WFMS_PositionLocalServiceUtil.clearCache();
				WFMS_Position posdummy = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(positionid);
				posdummy.setDummy("1");
				WFMS_PositionLocalServiceUtil.updatePositionEntry(posdummy);
				WFMS_PositionLocalServiceUtil.clearCache();
                HondaLogicUtil.auditLogsForPosition(positionid, associateNumber, WorkflowConstants.POSITION_SAVE_POSITION, WorkflowConstants.POSITION_ACTOIN, request,"");
                response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
			}
			if(Validator.isNotNull(saveonworkflow) && saveonworkflow.equalsIgnoreCase("update")){
				 String requistionId = hondaLogicUtil.geneateRequisitionId(deptNumber);

				WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.updatePosition(requistionId,positionid.concat("-WFM"), screenName,
						"", "", "save", description, reportedTo, autogenreq, criticalwrkseg, division,
						depname, deptNumber, line, ladder, mpCatBudget, mpCatFilledWith, positionclass, positiontype,
						positionlevel.toString(), leadershipassignment, category, subCategory, workforceCategory, empCategory,
						employeecatagorydescription, yearEst, resonchange, reevaluationDate, associateName,
						associateNumber, associatetitle, comments, typicaljobtitle, minimumjob, prioritizedduties,
						dailytask, lengthofservices, degreecertificate, requiredskills, desiredskills,
						environmentassociate, estimateweekly, frequency, history,other, deptManager,divisionManager,companyId, scopeGroupId);
				WFMS_PositionLocalServiceUtil.clearCache();
				
				if (wfms_Position != null) {
					List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
	                //HondaLogicUtil.auditLogsForPosition(positionid, associateNumber, WorkflowConstants.POSITION_MODIFY_POSITION, WorkflowConstants.POSITION_ACTOIN, request);
					//request.setAttribute("wfms_PositionList", wfms_PositionList);
					//response.setRenderParameter("jspPage", "/html/position/managePosition.jsp");
					response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
				}
			}
			if (reopenButton != null  && reopenButton.equalsIgnoreCase("reopenAction") && !wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)) {

				
				String perPosId = "";String dummy = "";
				List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(positionid);
				if(finalstep.size()!=0){
					for(WFMS_Position req:finalstep){
						perPosId = req.getPId();
						dummy = "0";
						req.setWorkflowId("0");
						 String requistionId = hondaLogicUtil.geneateRequisitionId(deptNumber);
						WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.updatePosition(requistionId,perPosId, screenName,
								"", "", HondaPermissionKeys.POS_PENDING, description, reportedTo, autogenreq, criticalwrkseg, division,
								depname, deptNumber, line, ladder, mpCatBudget, mpCatFilledWith, positionclass, positiontype,
								positionlevel.toString(), leadershipassignment, category, subCategory, workforceCategory, empCategory,
								employeecatagorydescription, yearEst, resonchange, reevaluationDate, associateName,
								associateNumber, associatetitle, comments, typicaljobtitle, minimumjob, prioritizedduties,
								dailytask, lengthofservices, degreecertificate, requiredskills, desiredskills,
								environmentassociate, estimateweekly, frequency, history,other, deptManager,divisionManager,companyId, scopeGroupId);
						 //ToDo on Submit workflow
						   WorkflowControler.processWorkflow(wfms_Position, "onSubmit",request);
						        WFMS_PositionLocalServiceUtil.clearCache();
						       
						        WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionid);
						        if (wfms_Position != null) {
									List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
									request.setAttribute("wfms_PositionList", wfms_PositionList);
					                //HondaLogicUtil.auditLogsForPosition(positionid, associateNumber, WorkflowConstants.POSITION_SUBMIT_POSITION, WorkflowConstants.POSITION_ACTOIN, request);
									response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
								}
					}
				}
				else if(!wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)){
					 String requistionId = hondaLogicUtil.geneateRequisitionId(deptNumber);
			       	WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.updatePosition(requistionId,positionid, screenName,
						"", "", HondaPermissionKeys.POS_PENDING, description, reportedTo, autogenreq, criticalwrkseg, division,
						depname, deptNumber, line, ladder, mpCatBudget, mpCatFilledWith, positionclass, positiontype,
						positionlevel.toString(), leadershipassignment, category, subCategory, workforceCategory, empCategory,
						employeecatagorydescription, yearEst, resonchange, reevaluationDate, associateName,
						associateNumber, associatetitle, comments, typicaljobtitle, minimumjob, prioritizedduties,
						dailytask, lengthofservices, degreecertificate, requiredskills, desiredskills,
						environmentassociate, estimateweekly, frequency, history,other, deptManager,divisionManager,companyId, scopeGroupId);
			        //ToDo on Submit workflow
			    	WFMS_Position wfms_P =    WorkflowControler.processWorkflow(wfms_Position, "onSubmit",request);
			 
				        WFMS_PositionLocalServiceUtil.clearCache();
				if (wfms_Position != null) {
					List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
					request.setAttribute("wfms_PositionList", wfms_PositionList);
					
	               // HondaLogicUtil.auditLogsForPosition(positionid, associateNumber, WorkflowConstants.POSITION_MODIFY_POSITION, WorkflowConstants.POSITION_ACTOIN, request);
					response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
				}
				}
			}
			PortletSession session = request.getPortletSession();

			if (genreqValueAction != null  && genreqValueAction.equalsIgnoreCase("generateReqValue") && (!wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING) && wFMS_Position.getWorkflowStep()!=80)) {
				
				String pgositionid = request.getParameter("positionid");
				String gstatus = HondaPermissionKeys.REQ_DRAFT;
				Date createdate = new Date();
                     
					WFMS_Requisition entry = new WFMS_RequisitionImpl();
	              	String id = hondaLogicUtil.geneateRequisitionId(deptNumber);	
					entry.setRwfId(id);
					entry.setStatus(gstatus);
					entry.setRId(pgositionid);
					entry.setCreateDate(createdate);
					entry.setDummy("0");
					entry.setCreatedBy(user.getFullName());
					Map<String, String>	hondamap=null;
					if(Validator.isNotNull(deptNumber)){
					hondamap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
					}
					entry.setNextapprove(hondamap.get("mpwrrep_name"));
					WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
					request.setAttribute("posid", pgositionid);
					request.setAttribute("reqcid", id);
					
					HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE,WorkflowConstants.REQUISITION_ACTION, request, comments);
					
					
					WFMS_Requisition req = WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(id);
					if (req != null) {
						WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
								.getByPositionId(req.getRId());
					String emailMessage="This requisition has been created and needs you to input the required information and submit.<br/> Click the below link to access the requisition.";
					String emailSubject = "Department Manpower Controller: Manpower Requisition "+id+" has been created.";
					String url=GenerateFrindlyURL.getURLForRequisition( request, id);
					emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
					EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_Position.getDepartmentNumber(), request, emailSubject, emailMessage);
						request.setAttribute("positionId", req.getRId());
						request.setAttribute("requisitionId", req.getRwfId());
						request.setAttribute("wfms_PositionObj", wfms_Position);
						request.setAttribute("create", "Create");
						//System.out.println(url);
						response.sendRedirect(url);
						///response.setRenderParameter("jspPage","/html/requisition/manageRequisition.jsp");
					//	response.sendRedirect(url.toString());
				}
					/*Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,"/requisition");
					PortletURL portletURL = PortletURLFactoryUtil.create(request,"Requisition",layout.getPlid(), ActionRequest.ACTION_PHASE);        
					portletURL.setWindowState(WindowState.NORMAL);
					portletURL.setParameter(ActionRequest.ACTION_NAME,"editRequisition");
					String positionId = request.getParameter("requisitionId");
					////_log.info("positionId:"+positionId);
					portletURL.setParameter("positionId",req.getRwfId());
					////_log.info("positionId:"+req.getRId());
					response.sendRedirect(portletURL.toString());*/
			//	response.setRenderParameter("jspPage","/html/requisition/manageRequisition.jsp");

			 }
			
            else if((wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING) || wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)) && genreqValueAction.equalsIgnoreCase("updatepositionValue") ) {
            	// ////_log.info("enter to  POS_PENDING if ");
				List<WFMS_Position> submitstep=WFMS_PositionLocalServiceUtil.findByworkflowId(positionid);
				if(wFMS_Position.getWorkflowStep()==80){
					//System.out.println("Enter to redirect action 1");
					
					
	                 wFMS_Position.setStatus(HondaPermissionKeys.POS_OPEN);
	                 wFMS_Position.setWorkflowStep(-1);
	                 wFMS_Position.setNextApprover("");
	                 wFMS_Position=WFMS_PositionLocalServiceUtil.updateWFMS_Position(wFMS_Position);
	                
	                  String emailSubject =  "Notification: Hello "+HondaPermissionKeys.ROLE_PAYROLL+" this Position "+wFMS_Position.getPId()+" is Approved";
	                  String emailMessage="A new position needs you to add the employee category  and approve.";
					  String url=	GenerateFrindlyURL.getHMAfrindlyURL( request, wFMS_Position.getPId());
						 emailMessage = emailMessage +" <br/>  <a href='"+url+"'>Click here to review the record</a>";
						 
						 
						 if(session.getAttribute("wfms_Pos_send_mail_"+positionid)==null){
							      session.setAttribute("wfms_Pos_send_mail_"+positionid,"wfms_Pos"+positionid);
						         // EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_PAYROLL, null, request, emailSubject, emailMessage);
						 }
						 else{
							 session.removeAttribute("wfms_Pos_send_mail_"+positionid);
						 }

					 
	                if(wFMS_Position.getAutoGenerateReq().equalsIgnoreCase("false")){
	                	//System.out.println("Enter to redirect action 2");
				                	if(session.getAttribute("wfms_Pos"+positionid)==null){
				                	session.setAttribute("wfms_Pos"+positionid,"wfms_Pos"+positionid);
				                	HondaLogicUtil.auditLogsForPosition(positionid, "", WorkflowConstants.POSITION_APPROVE_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");
				       //         	HondaLogicUtil.auditLogsForReqAndCOS(positionid, WorkflowConstants.POSITION_SUBMIT_POSITION,WorkflowConstants.POSITION_ACTOIN, request, null);
				                //	////_log.info("enter to  false if ");
				                    //  request.setAttribute("autoReqForTerminate", "autoReqForTerminate");
				                      request.setAttribute("positionId", positionid);
									  request.setAttribute("wfms_PositionObj", wFMS_Position);
									  response.sendRedirect(GenerateFrindlyURL.getHMAfrindlyURL(request, positionid));
				                	}
			                	else{
			                		//System.out.println("Enter to redirect action 3");
			                		  session.removeAttribute("wfms_Pos"+positionid);
			                		
			                		 // request.setAttribute("autoReqForTerminate", "autoReqForTerminate");
				                      request.setAttribute("positionId", positionid);
									  request.setAttribute("wfms_PositionObj", wFMS_Position);
									  response.sendRedirect(GenerateFrindlyURL.getHMAfrindlyURL(request, positionid));
			                		
			                	}
	                 }
	               
	              
				}
				else{
					
					// ////_log.info("enter to  else if 1233");
					String posNumber = "";
		    		String dummy = ""; 
				if(submitstep.size()!=0){
					for(WFMS_Position pos:submitstep){
						posNumber = pos.getPId();
						dummy = "0";
						pos.setWorkflowId("0");
						//System.out.print("posNumber:::>>"+posNumber);
			//System.out.print("positionclass:::>>"+positionclass);
		     //System.out.print("Before positionclass:::>>"+pos.getPositionClass());
						 String requistionId = hondaLogicUtil.geneateRequisitionId(deptNumber);
						wfms_Positions = WFMS_PositionLocalServiceUtil.updatePosition(requistionId,positionid, screenName,
								"", "", HondaPermissionKeys.POS_PENDING, description, reportedTo, autogenreq, criticalwrkseg, division,
								depname, deptNumber, line, ladder, mpCatBudget, "", positionclass, positiontype,
								positionlevel.toString(), leadershipassignment, category, subCategory, workforceCategory, empCategory,
								"", yearEst, resonchange, reevaluationDate, "",
								"", "", comments, typicaljobtitle, minimumjob, prioritizedduties,
								dailytask, lengthofservices, degreecertificate, requiredskills, desiredskills,
								environmentassociate, estimateweekly, frequency, history,other, deptManager,divisionManager , companyId, scopeGroupId);
					          WorkflowControler.processWorkflow(wfms_Positions, "onSubmit",request);
						        WFMS_PositionLocalServiceUtil.clearCache();
						        
						        
						        //System.out.print("Afetr positionclass:::>>"+wfms_Positions.getPositionClass());
						//HondaLogicUtil.auditLogsForPosition(positionid, associateNumber, WorkflowConstants.POSITION_SUBMIT_POSITION, WorkflowConstants.POSITION_ACTOIN, request);
						WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionid);
						List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
						//int currentStep=Validator.isNotNull(wfms_Position.getWorkflowStep())?wfms_Position.getWorkflowStep():0;
						//ModifyPositionWorkflowContext.processModifyPosition(currentStep, request, response);
					//	////_log.info("currentStep.........in submit state"+currentStep);
						if (wfms_Positions != null) {
							request.setAttribute("wfms_PositionList", wfms_PositionList);
			                //HondaLogicUtil.auditLogsForPosition(positionid, associateNumber, WorkflowConstants.POSITION_MODIFY_POSITION, WorkflowConstants.POSITION_ACTOIN, request);
							response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
						}
					}
					
					
				   }else if(wFMS_Position.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)){		
                            
					   wFMS_Position.setDummy("0");   
				       WFMS_PositionLocalServiceUtil.updateWFMS_Position(wFMS_Position);
				       String requistionId = hondaLogicUtil.geneateRequisitionId(deptNumber);
					wfms_Positions = WFMS_PositionLocalServiceUtil.updatePosition(requistionId,positionid, screenName,
							"", "", HondaPermissionKeys.POS_PENDING, description, reportedTo, autogenreq, criticalwrkseg, division,
							depname, deptNumber, line, ladder, mpCatBudget, mpCatFilledWith, positionclass, positiontype,
							positionlevel.toString(), leadershipassignment, category, subCategory, workforceCategory, empCategory,
							employeecatagorydescription, yearEst, resonchange, reevaluationDate, associateName,
							associateNumber, associatetitle, comments, typicaljobtitle, minimumjob, prioritizedduties,
							dailytask, lengthofservices, degreecertificate, requiredskills, desiredskills,
							environmentassociate, estimateweekly, frequency, history,other, deptManager,divisionManager , companyId, scopeGroupId);
					        WFMS_PositionLocalServiceUtil.clearCache();
					        WorkflowControler.processWorkflow(wfms_Positions, "onSubmit",request);
					        
					       // wFMS_Position.setDummy("0");   
					       // WFMS_PositionLocalServiceUtil.updateWFMS_Position(wFMS_Position);
					        
						//	List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
							
							DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
							wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionid+"-WFM"));
							int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
							
							if(wfmPositionforTempcount > 0){
							    WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionid+"-WFM");
							}
							wfms_Positions = WFMS_PositionLocalServiceUtil.getByPositionId(positionid);
							
							
							if(wfms_Positions.getWorkflowStep()==80){
								    //System.out.println("Enter to redirect action");
									request.setAttribute("positionId", wfms_Positions.getPId());
									request.setAttribute("wfms_PositionObj", wfms_Positions);
									//response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");
									//System.out.println("Enter to redirect action end");
									  response.sendRedirect(GenerateFrindlyURL.getHMAfrindlyURL(request,  wfms_Positions.getPId()));
							}
							else{
								request.setAttribute("positionId", positionid);
								request.setAttribute("wfms_PositionObj", wfms_Positions);
								response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
							}
				}
				
				}	

            } 
            else if (Validator.isNotNull(autogenreq) && Validator.isNotNull(yesOrNo) && autogenreq.equalsIgnoreCase("false") && yesOrNo.equalsIgnoreCase("false")) {
				////_log.info("isAutoGenerate false:" + isAutoGenerate);
				List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
				session.setAttribute("wfms_PositionList", wfms_PositionList);
				response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
			} else if ( Validator.isNotNull(autogenreq) && Validator.isNotNull(yesOrNo) && autogenreq.equalsIgnoreCase("false") && yesOrNo.equalsIgnoreCase("true") && wFMS_Position.getWorkflowStep()!=-1) {
			      //_log.info("isAutoGenerate true:" + isAutoGenerate);
				Date createDate = new Date();
				WFMS_Requisition entry = new WFMS_RequisitionImpl();
              	String id = hondaLogicUtil.geneateRequisitionId(deptNumber);	
				entry.setRwfId(id);
				entry.setStatus(HondaPermissionKeys.POS_DRAFT);
				entry.setRId(wfms_Positions.getPId());
				entry.setCreateDate(createDate);
				entry.setDummy("0");
				entry.setCreatedBy(user.getFullName());
				/*Mail send regards */	
				Map<String, String>	hondamap=null;
				if(Validator.isNotNull(deptNumber)){
				hondamap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
				}
				entry.setNextapprove(hondamap.get("mpwrrep_name"));
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
				HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request, comments);
				   WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(id);
				   String emailMessage="This requisition has been created and needs you to input the required information and submit.<br/> Click the below link to access the requisition.";
					String emailSubject = "Department Manpower Controller: Manpower Requisition "+id+" has been created.";
					String url=GenerateFrindlyURL.getURLForRequisition( request, id);
					emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
					EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, pos.getDepartmentNumber(), request, emailSubject, emailMessage);
					
			//	WFMS_RequisitionLocalServiceUtil.clearCache();
								
				///request.setAttribute("posid", wfms_Positions.getPId());
			//request.setAttribute("reqcid", id);
				//session.setAttribute("posid", wfms_Positions.getPId(),PortletSession.APPLICATION_SCOPE);
				
				request.setAttribute("positionId", wfms_Positions.getPId());
				request.setAttribute("requisitionId", id);
				request.setAttribute("wfms_PositionObj", wfms_Positions);
				request.setAttribute("create", "Create");
				response.setRenderParameter("jspPage","/html/requisition/manageRequisition.jsp");
				
			//	response.setRenderParameter("jspPage", "/html/requisition/createRequisition.jsp");
			}
			  
			  
			try {
				if(wfms_Positions.getAutoGenerateReq().equalsIgnoreCase("true") && wfms_Positions.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN) && wfms_Positions.getWorkflowStep()==-1 ){

               	 
                	DynamicQuery queryForreq =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
                	queryForreq.add(PropertyFactoryUtil.forName("rId").eq(positionid));
      	            long reqcount= WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(queryForreq);	
      	         // ////_log.info("reqcount "+reqcount);
      	            if(reqcount==0){
   	HondaLogicUtil.auditLogsForPosition(positionid, "", WorkflowConstants.POSITION_APPROVE_POSITION , WorkflowConstants.POSITION_ACTOIN , request,"");
	                	HondaLogicUtil.auditLogsForReqAndCOS(positionid, WorkflowConstants.POSITION_SUBMIT_POSITION,WorkflowConstants.POSITION_ACTOIN, request, null);
	                	////System.out.println("create requisitin method <<<<<<<<<<<<<<<<<<<<<<<ASDasdasd>>>>>>>>>>>>");
                	// ////_log.info("enter to  else if ");
                      String gstatus = HondaPermissionKeys.REQ_DRAFT;
                                  Date createddate = new Date();
                                  WFMS_Requisition entry = new WFMS_RequisitionImpl();
                                	String id = hondaLogicUtil.geneateRequisitionId(deptNumber);	
                                  entry.setRwfId(id);
                                  entry.setStatus(gstatus);
                                  entry.setRId(positionid);
                                  entry.setCreateDate(createddate);
                                  entry.setCompanyId(wFMS_Position.getCompanyId());
                                  entry.setScopeGroupId(wFMS_Position.getScopeGroupId());
                                  entry.setDummy("0");
                                  entry.setCreatedBy(user.getFullName());
                                  Map<String, String>	hondamap=null;
                  				if(Validator.isNotNull(deptNumber)){
                  				hondamap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
                  				}
                  				entry.setNextapprove(hondamap.get("mpwrrep_name"));
                                  WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
                                  //WFMS_RequisitionLocalServiceUtil.clearCache();
                                  HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE,WorkflowConstants.REQUISITION_ACTION, request, wFMS_Position.getComments());
                                //  //System.out.println("create requisitin method <<<<<<<<<<<<<<<<<<<<<<<Create mail>>>>>>>>>>>>");
                                  String emailMessage="This requisition has been created and needs you to input the required information and submit.<br/> Click the below link to access the requisition.";
          						String emailSubject = "Department Manpower Controller: Manpower Requisition "+id+" has been created.";
          						String url=GenerateFrindlyURL.getURLForRequisition( request, id);
          						emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
          						EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_Positions.getDepartmentNumber(), request, emailSubject, emailMessage);
          						WFMS_RequisitionLocalServiceUtil.clearCache();
                                  request.setAttribute("posid", positionid);
                                  request.setAttribute("reqcid", id);
                                  session.setAttribute("posid", positionid,PortletSession.APPLICATION_SCOPE);
                              	response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
      	                }
      	      	response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
					
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			}			
		
				catch (Exception e2) {
					e2.printStackTrace();
				}finally{
			
	 	}
		
	   }	
  	 }	
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void removePosition(ActionRequest request, ActionResponse response) throws Exception {
		String positionId = request.getParameter("redirectObj");
		if (positionId != null) {
			//long pId = Long.parseLong(positionId);
			// TODO - Needs to be disable active state, not a full delete.
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.deletePosition(positionId);
		}
		response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
	}

	
/*	public void manageRequisition(ActionRequest request, ActionResponse response){
		try{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,"/requisition");
		PortletURL portletURL = PortletURLFactoryUtil.create(request,"Requisition",layout.getPlid(), ActionRequest.ACTION_PHASE);        
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter(ActionRequest.ACTION_NAME,"editRequisition");
		String positionId = request.getParameter("requisitionId");
		////_log.info("positionId:"+positionId);
		portletURL.setParameter("positionId",positionId);
		response.sendRedirect(portletURL.toString());
		}
		catch(Exception e){
			_log.error("[approveCOS]" +e);
		}
		//response.setRenderParameter("jspPage","/html/requisition/manageRequisition.jsp");
	}*/
	
	
	/* Create Requisition */
	public void createRequisition(ActionRequest request, ActionResponse response)
			throws Exception {
          System.out.println("create requisitin method");
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		// String screenName = user.getScreenName();
		long companyId = user.getCompanyId();
		Group group = user.getGroup();
		long scopeGroupId = group.getGroupId();
		// Date createdate = new Date();
		// String modifiedDate = request.getParameter("modifiedDate");

		String positionId = request.getParameter("positionId");
		String reqcid = request.getParameter("reqcid");
		String associatenumber = request.getParameter("associatenumber");
		//System.out.println();
		// String associatename
		// =HMAAssociateInfoService.getAssNameByDeptNumner(associatenumber);
		String associatename = request.getParameter("associatename");

		String status = request.getParameter("status");
		String postingType = request.getParameter("postingType");
		String teamNumber = request.getParameter("teamNumber");
		String associatetype = request.getParameter("associatetype");
		String shiftAssign = request.getParameter("shiftAssign");
		// shift assigment saving

		String shiftassignmentdb = "";
		String shiftDesc = "";
		Map<String, String> shifassinmentMap = new HashMap<String, String>();
		shifassinmentMap = ConfigUtility
				.getInputValuesForMap("shift-assignment");
		shiftassignmentdb = shifassinmentMap.get(shiftAssign);
		shiftDesc = shiftAssign + ":" + shiftassignmentdb;
		String howAvailable = request.getParameter("howAvailable");
		String whoReplaced = request.getParameter("whoReplaced");
		String dateneeded = request.getParameter("dateneeded");
		String contactperson = request.getParameter("contactperson");
		String contactphonenumber = request.getParameter("contactphonenumber");
		String taleonumber = request.getParameter("taleonumber");
		String associateName = request.getParameter("associatename");

		String other = request.getParameter("other");
		String comments = request.getParameter("comments");
		String deptNumber = request.getParameter("Deptid");
		////_log.info("deptNumber update position:" + deptNumber);
		Map<String, String> deptDivInfoMap = new HashMap<String, String>();
		HondaLogicUtil hondaLogicUtil = new HondaLogicUtil();
		deptDivInfoMap = hondaLogicUtil.singleCallOnServieNow(deptNumber);
		String depname = deptDivInfoMap.get("deptName");
		String division = deptDivInfoMap.get("divName");
		String deptManager = deptDivInfoMap.get("deptMgrName");
		String divisionManager = deptDivInfoMap.get("divMgrName");

		// List<Map<String,String>> associateList =
		// HMAAssociateInfoService.getAssociateName(associatenumber);
		String associateNameNoNum = "";
		AssociateInformation assInfo = new AssociateInformation();
		if (associatenumber.equalsIgnoreCase("None")) {
			associateNameNoNum = associatename;
		}
		try {
			////_log.info("associatenumber :" + associatenumber);
			HMAAssociateInfoService service = new HMAAssociateInfoService();
			assInfo = service.createRequisition(associatenumber);
			if (assInfo.getAssociateName() != null) {
				associateNameNoNum = assInfo.getAssociateName();
			}
			/*
			 * if(assInfo.getAssociateTitle() != null){ associateNameNoNum =
			 * assInfo.getAssociateTitle(); }
			 */
			////_log.info("ASSOCIATE_NAME :" + assInfo.getAssociateName());
			////_log.info("ASSOCIATE_TITLE :" + assInfo.getAssociateTitle());

			/* Adding Temp data in database */
			String buttonclick = request.getParameter("buttonclick");
			/* First time workflow created with save status */
			if (buttonclick.equalsIgnoreCase("save")) {
				String temp_id = reqcid + "-WFM";
				//status = "save";
				WFMS_RequisitionLocalServiceUtil.addnewtempRequisition(temp_id,
						reqcid, companyId, scopeGroupId, positionId,
						associatenumber, associateNameNoNum, HondaPermissionKeys.REQ_DRAFT,
						postingType, teamNumber, associatetype, shiftDesc,
						howAvailable, whoReplaced, dateneeded, contactperson,
						contactphonenumber, taleonumber, other);

				String dummy = "1";
				WFMS_Requisition requp = WFMS_RequisitionLocalServiceUtil
						.fetchWFMS_Requisition(reqcid);
				requp.setDummy(dummy);
				requp.setRId("0");
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(requp);
				HondaLogicUtil.auditLogsForReqAndCOS(reqcid,
						WorkflowConstants.REQUISITION_SAVE,
						WorkflowConstants.REQUISITION_ACTION, request, "");

			}/*
			 * Avoiding duplicate for creating dummy variable passing and
			 * getting temp data for clicking 2nd time saving
			 */
			if (buttonclick.equalsIgnoreCase("Temp")) {
				//status = "save";
				// //System.out.println(status+reqcid);
				WFMS_RequisitionLocalServiceUtil.updateRequisition(reqcid,
						companyId, scopeGroupId, positionId, associatenumber,
						associateNameNoNum, HondaPermissionKeys.REQ_DRAFT, postingType, teamNumber,
						associatetype, shiftDesc, howAvailable, whoReplaced,
						dateneeded, contactperson, contactphonenumber,
						taleonumber, other, comments);
				String reqid = "";
				List<WFMS_Requisition> requp = WFMS_RequisitionLocalServiceUtil
						.findByworkflowId(reqcid);
				if (requp.size() > 0) {
					for (WFMS_Requisition req : requp) {
						reqid = req.getRwfId();
					}
				} else {
					reqid = reqcid;
				}
				HondaLogicUtil.auditLogsForReqAndCOS(reqid,
						WorkflowConstants.REQUISITION_SAVE,
						WorkflowConstants.REQUISITION_ACTION, request, "");
			}
			
			/*
			 * Temp id creating and checking the submit status or without temp
			 * id its move directly to submit
			 */

			if (buttonclick.equalsIgnoreCase("Submit")) {
				if (associatenumber != StringPool.BLANK
						&& postingType != StringPool.BLANK
						&& shiftDesc != StringPool.BLANK
						&& howAvailable != StringPool.BLANK
						&& whoReplaced != StringPool.BLANK
						&& dateneeded != StringPool.BLANK
						&& contactperson != StringPool.BLANK
						&& contactphonenumber != StringPool.BLANK
						&& taleonumber != StringPool.BLANK) {


					String reqnumber = "";
					String dummy = "";
					List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil
							.findByworkflowId(reqcid);
					if (finalstep.size() != 0) {
						for (WFMS_Requisition req : finalstep) {
							reqnumber = req.getRwfId();
							dummy = "0";
							req.setWorkflowId("0");
							req.setDummy(dummy);
							req.setCompanyId(companyId);
							req.setScopeGroupId(scopeGroupId);
							req.setRId(positionId);
							req.setNumber(positionId);

							req.setAssociatenumber(associatenumber);
							req.setAssociatename(associateNameNoNum);
							req.setStatus(HondaPermissionKeys.REQ_SUBMITTED);
							req.setPostingType(postingType);
							req.setTeamNumber(teamNumber);
							req.setAssociatetype(associatetype);
							req.setShiftAssign(shiftDesc);
							req.setHowAvailable(howAvailable);
							req.setWhoReplaced(whoReplaced);
							req.setDateneeded(dateneeded);
							req.setContactperson(contactperson);
							req.setContactphonenumber(contactphonenumber);
							req.setTaleonumber(taleonumber);
							req.setOther(other);
							WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req);
							// //System.out.println(reqcid+reqnumber);
							WFMS_RequisitionLocalServiceUtil
									.deleteWFMS_Requisition(reqcid);
							HondaLogicUtil.auditLogsForReqAndCOS(reqnumber,
									WorkflowConstants.REQUISITION_SAVE,
									WorkflowConstants.REQUISITION_ACTION, request, "");
							
						}
					} else {/* Directly moving the orginal to submit status. */
						WFMS_Requisition requp = WFMS_RequisitionLocalServiceUtil
								.fetchWFMS_Requisition(reqcid);
						
						dummy = "0";
						requp.setDummy(dummy);
						requp.setCompanyId(companyId);
						requp.setScopeGroupId(scopeGroupId);
						requp.setRId(positionId);
						requp.setNumber(positionId);
						requp.setAssociatenumber(associatenumber);
						requp.setAssociatename(associateNameNoNum);
						requp.setStatus(HondaPermissionKeys.REQ_SUBMITTED);
						requp.setPostingType(postingType);
						requp.setTeamNumber(teamNumber);
						requp.setAssociatetype(associatetype);
						requp.setShiftAssign(shiftDesc);
						requp.setHowAvailable(howAvailable);
						requp.setWhoReplaced(whoReplaced);
						requp.setDateneeded(dateneeded);
						requp.setContactperson(contactperson);
						requp.setContactphonenumber(contactphonenumber);
						requp.setTaleonumber(taleonumber);
						requp.setOther(other);
						requp.setComments(comments);
						WFMS_RequisitionLocalServiceUtil
								.updateWFMS_Requisition(requp);
						//HondaLogicUtil.auditLogsForReqAndCOS(reqcid,WorkflowConstants.REQUISITION_SUBMIT,WorkflowConstants.REQUISITION_ACTION,request, "");
						
						try {
							//r = RoleLocalServiceUtil.getRole(companyId, HondaPermissionKeys.ROLE_DMP);
							//List<User> us = UserLocalServiceUtil.getRoleUsers(r.getRoleId());
							WFMS_Position pos = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(positionId);
							String emailSubject = "This requisition was created Need to Fill the Requisition";
							String emailMessage = "This requisition was created Need to Fill the Requisition";
							//List<String> departmentNos= HMAAssociateInfoService.getDepartmentUsersByDPNumber(pos.getDepartmentNumber());
							emailMessage="This Requisition is Submitted, please click below link to proceed further";
							emailSubject = "Notification: Hello "+HondaPermissionKeys.ROLE_DMP+" this Requisition "+reqcid+" is Submitted";
							String url=GenerateFrindlyURL.getURLForRequisition( request, reqcid);
							 emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, pos.getDepartmentNumber(), request, emailSubject, emailMessage);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {/*
						 * Clicking the submit its checking the fields not
						 * filled its redirect to save.
						 */
					//status = "save";
					WFMS_RequisitionLocalServiceUtil.updateRequisition(reqcid,
							companyId, scopeGroupId, positionId,
							associatenumber, associateNameNoNum, HondaPermissionKeys.REQ_DRAFT,
							postingType, teamNumber, associatetype, shiftDesc,
							howAvailable, whoReplaced, dateneeded,
							contactperson, contactphonenumber, taleonumber,
							other, comments);
					HondaLogicUtil.auditLogsForReqAndCOS(reqcid,
							WorkflowConstants.REQUISITION_SAVEDATA,
							WorkflowConstants.REQUISITION_ACTION,
							request, "");
				}
			}
			if (associatenumber != null) {
				
				WFMS_RequisitionLocalServiceUtil.clearCache();
				
			}
			/*PortletSession session = request.getPortletSession();
			session.setAttribute("jspPage",
					"/html/position/managePosition.jsp",
					PortletSession.APPLICATION_SCOPE);*/
			response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletModeException 
	 * @throws WindowStateException 
	 */
	private static void getDivisionNameDeptName(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			   throws IOException, WindowStateException, PortletModeException {
			  String DeptNo = resourceRequest.getParameter("Deptid");
			  ////_log.info("DeptNo :"+DeptNo);
			  JSONObject json = JSONFactoryUtil.createJSONObject();
			  HondaLogicUtil hondaLogicUtil = new HondaLogicUtil();
			  Map<String,String> deptDivInfoMap = new HashMap<String,String>();
			  
			  try{ deptDivInfoMap=hondaLogicUtil.singleCallOnServieNow(DeptNo);		
				    json.put("DEPT_NAME", deptDivInfoMap.get("deptName") );
				    json.put("Division", deptDivInfoMap.get("divName") );
				    PrintWriter writer = resourceResponse.getWriter();
				    writer.print(json);
			  } catch (Exception e) {
			   e.printStackTrace();
			  }finally{
			   
			  }
			 }
	/**
	 * 
	 * @param type
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws SystemException 
	 * @throws JSONException 
	 * @throws PortalException 
	 */
	public static void getPositionList(String type, ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, PortalException, JSONException {
		try{
			//String listType = resourceRequest.getParameter("listType");
			JSONObject json = DatagridDisplayManagerUtil.getPositionList(type,resourceRequest);
			PrintWriter writer = resourceResponse.getWriter();
			writer.print( json );
		}catch(IOException | com.liferay.portal.kernel.json.JSONException ioex){
			ioex.printStackTrace();
		}
	}
	

	
	
	/**
	 * 
	 * @param type
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws SystemException
	 * @throws JSONException
	 * @throws PortalException 
	 * @throws PortletModeException 
	 * @throws WindowStateException 
	 */
	public static void empDescriptionOnchange(String type, ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
			throws IOException, SystemException, JSONException, PortalException, WindowStateException, PortletModeException {


		/*String url 	=GenerateFrindlyURL.getURLForRequisition(resourceRequest);
		
		EmailUtility.sendEmail(HondaPermissionKeys.EMAIL_FROM_MAIL, "mouli.siripurapu@gmail.com	",HondaPermissionKeys.EMAIL_FROM_MAIL, "mouli.siripurapu@gmail.com	",url,  url);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long[] roleIds = user.getRoleIds();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//System.out.println(themeDisplay.getPortletDisplay().getRootPortletId());
	//String url=	HondaLogicUtil.getWFMPortletUrl(themeDisplay.getPortletDisplay().getRootPortletId(), themeDisplay, "SUP-8901");
//	//System.out.println(url);
//	ADM-6701
	String url 	=GenerateFrindlyURL.getHMAfrindlyURL(resourceRequest);
	
	EmailUtility.sendEmail(HondaPermissionKeys.EMAIL_FROM_MAIL, "mouli.siripurapu@gmail.com	",HondaPermissionKeys.EMAIL_FROM_MAIL, "mouli.siripurapu@gmail.com	",url,  url);

    StringBuilder sb = new StringBuilder();
	List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
            String delim="";
		   for(WFMS_Position i:wfms_PositionList){
			   if(!(i.getAssociateNumber().equalsIgnoreCase("")) && !(i.getAssociateNumber().equalsIgnoreCase("None"))){
				   
				   sb.append(delim).append("'" + i.getAssociateNumber() + "'");
				     delim = ",";
			 
			   }
		 
	 }
 List<String> listofass =	HMAAssociateInfoService.getassNumberForAddAssociate(sb.toString());
 for(String ii:listofass)
 {
	 
	 //System.out.println(ii);
 }*/
	String empCategoryID = ParamUtil.getString(resourceRequest, "empCategoryID");
		Map<String, String> shiftMap=new HashMap<String, String>();
		JSONObject json = JSONFactoryUtil.createJSONObject();
		//PrintWriter writer = null;
		try {
			shiftMap=ConfigUtility.getInputValuesForMap(type);
			for(Map.Entry<String, String> entry : shiftMap.entrySet()){
				if(entry.getKey().equalsIgnoreCase(empCategoryID)){
					json.put("desc",  entry.getValue());
				}
			}
			PrintWriter writer = resourceResponse.getWriter();
			writer.print( json );
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws SystemException 
	 * @throws NoSuch_RequisitionException 
	 * @throws IOException 
	 */
	public static void closePositionAction( ResourceRequest resourceRequest ,ResourceResponse resourceResponse) throws NoSuchWFMS_RequisitionException, SystemException, IOException {
		String posid = resourceRequest.getParameter("pid");
		//String statusid = resourceRequest.getParameter("status");
		PrintWriter writer = resourceResponse.getWriter();
		JSONObject jsonUser = JSONFactoryUtil.createJSONObject();
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
	public static void getAssociateNameBydepId(String deptID, ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, SystemException, PortalException  {
		     JSONObject json = JSONFactoryUtil.createJSONObject();
		    String assName=HMAAssociateInfoService.getAssNameByDeptNumner(deptID);
		    json.put("AssName",  assName);
		    PrintWriter writer = resourceResponse.getWriter();
		    writer.print( json );
		
	}
	public static void getAssNameForAddAssociate(String deptID, ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, SQLException  {
	     JSONObject json = JSONFactoryUtil.createJSONObject();
	    AssociateInformation obj=HMAAssociateInfoService.fetchPositionOnAssociateNumber(deptID);
	    json.put("AssName",  obj.getAssociateName());
	    json.put("AssTitle",  obj.getAssociateTitle());
	    PrintWriter writer = resourceResponse.getWriter();
	    //System.out.println(json.toString());
	    writer.print( json );
	
}
	
	
	public static void getCopyPosition( ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, SQLException  {
	   //  //_log.info(resourceRequest.getParameter("Pid"));
	     JSONObject json = JSONFactoryUtil.createJSONObject();
	     ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			Date date = new Date();
			
	   String  pid=StringPool.BLANK;
	     try {
	    	 User user = UserLocalServiceUtil.getUserById(userId);
	    	 long companyId = user.getCompanyId();
				Group group = user.getGroup();
				long scopeGroupId = group.getGroupId();
				WFMS_Position copyPosition = null;
				copyPosition = new WFMS_PositionImpl();
			     WFMS_Position position=WFMS_PositionLocalServiceUtil.getByPositionId(resourceRequest.getParameter("Pid"));
	              Map<String, String> hondamap=HondaLogicUtil.singleCallOnServieNow(position.getDepartmentNumber());
		         pid=HondaLogicUtil.geneatePositionId(position.getDepartmentNumber());
		     //  HondaLogicUtil.geneatePositionId(  position.getDepartmentNumber());
           //   //_log.info(hondamap.get("abbreviation")+"-"+HondaLogicUtil.geneatePositionId( position.getDepartmentNumber()));
              // WFMS_Position copyPosition=WFMS_PositionLocalServiceUtil.getByPositionId(hondamap.get("abbreviation")+"-"+HondaLogicUtil.geneatePositionId(position.getDepartmentNumber()));
              copyPosition.setPId(pid+"-WFM");
         //     //_log.info(position.getWorkforceCategory()+">>>>>>>>>>>>position.getWorkforceCategory()");
              copyPosition.setDepartmentNumber(position.getDepartmentNumber());
              copyPosition.setDivision(position.getDivision());
              copyPosition.setDepartmentName(position.getDepartmentName());
              copyPosition.setMpCatBugdet(position.getMpCatBugdet());
              copyPosition.setPositionClass(position.getPositionClass());
              copyPosition.setYearEst(position.getYearEst());
              copyPosition.setReasonsFor(position.getReasonsFor());
              copyPosition.setReavailuationDate(position.getReavailuationDate());
              copyPosition.setWorkflowStep(0);
              copyPosition.setStatus(HondaPermissionKeys.POS_DRAFT);
              copyPosition.setDummy("0");
            //  copyPosition.setAssociateName(position.getAssociateName());
            //  copyPosition.setAssociateNumber(position.getAssociateNumber());
            //  copyPosition.setAssociateTitle(position.getAssociateTitle());
              copyPosition.setDepartmentManager(position.getDepartmentManager());
	          copyPosition.setDivisionManager(position.getDivisionManager());
              copyPosition.setCritical(position.getCritical());
              copyPosition.setActive(position.getActive());
              copyPosition.setLine(position.getLine());
              copyPosition.setCreateDate(date);
              copyPosition.setReportsTo(position.getReportsTo());
	          copyPosition.setCompanyId(companyId);
              copyPosition.setScopeGroupId(scopeGroupId);
              copyPosition.setCreatedBy(user.getFullName());
              copyPosition.setLadder(position.getLadder());
              copyPosition.setCategory(position.getCategory());
              copyPosition.setDescription(position.getDescription());
  //            copyPosition.setMpCatFilledWith(position.getMpCatFilledWith());
              copyPosition.setType(position.getType());
              copyPosition.setLevel(position.getLevel());
              copyPosition.setAutoGenerateReq(position.getAutoGenerateReq());
              copyPosition.setLeadershipAssignment(position.getLeadershipAssignment());
              copyPosition.setSubCategory(position.getSubCategory());
              copyPosition.setWorkforceCategory(position.getWorkforceCategory());
              copyPosition.setEmpCategory(position.getEmpCategory());
              copyPosition.setEmpCategoryDesc(position.getEmpCategoryDesc());
              copyPosition.setComments(position.getComments());
              copyPosition.setTypicalJobTitle(position.getTypicalJobTitle());
              copyPosition.setMinJobKnowHow(position.getMinJobKnowHow());
              copyPosition.setDuties(position.getDuties());
              copyPosition.setTasksPerformed(position.getTasksPerformed());
              copyPosition.setLengthOfService(position.getLengthOfService());
              copyPosition.setDegree(position.getDegree());
              copyPosition.setReqSkills(position.getReqSkills());
              copyPosition.setDesiredSkills(position.getDesiredSkills());
              copyPosition.setEnvironment(position.getEnvironment());
              copyPosition.setWeeklyOvertime(position.getWeeklyOvertime());
              copyPosition.setFrequencyOfTravel(position.getFrequencyOfTravel());
              copyPosition.setOther(position.getOther());
              if(Validator.isNull(position.getWorkflow()))  
            	  copyPosition.setWorkflow(WorkflowConstants.POSITION_CREATE_CONFIG_KEY);
              else   copyPosition.setWorkflow(position.getWorkflow());
        //      copyPosition.setIscopyPosition(true);
              copyPosition.setWorkflowId(pid+"-WFM");
              copyPosition.setRefPosId(pid);
               WFMS_PositionLocalServiceUtil.updateWFMS_Position(copyPosition);
            //  //_log.info("Copy Position"+copyPosition);
              WFMS_PositionLocalServiceUtil.clearCache();
              //WorkflowControler.processWorkflow(copyPosition, "onSubmit",request);
              json.put("sucess",  pid);
              json.put("link",  GenerateFrindlyURL.getHMAfrindlyURL(resourceRequest,pid));
         //     <a href='"+GenerateFrindlyURL.getHMAfrindlyURL(request, wfms_Position.getPId())+"'>Click here to review the record</a>
		} catch (Exception e) {
			System.out.println("getCopyPosition System Exception"+e);
			json.put("error", "false");
		}
	
	     PrintWriter writer = resourceResponse.getWriter();
		//    System.out.println(json.toString());
		    writer.print( json );
		
}
	//Move Associate Workflow 
		public void moveAssociate(ActionRequest actionRequest,ActionResponse actionResponse) throws PortletException, IOException, SystemException{
	        
			
			////System.out.println("moveAssociate");
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			//User userdat = UserLocalServiceUtil.getUserById(userId);
			//String screenName = userinfo.getScreenName();
			//long companyId = userinfo.getCompanyId();
			//Group group = userinfo.getGroup();
			//long scopeGroupId = group.getGroupId();
				Date createdate = new Date();
				String userFullName="";//userdat.getFirstName().concat(userdat.getLastName());
				////System.out.println(actionRequest.getParameter("moveassociateValue"));  
				String generateRequisation=actionRequest.getParameter("generateRequisation").trim();
				////System.out.println("generateRequisation:"+actionRequest.getParameter("generateRequisation"));  
				String movePositionId=actionRequest.getParameter("moveassociateValue");
		        String currentPosid = actionRequest.getParameter("posId");
		        
		       // String currentDeptNo =actionRequest.getParameter("currentdeptNumber");
		        String st1=StringPool.BLANK;
		        String st2=StringPool.BLANK;
		        String emailMessage=StringPool.BLANK;
		        String emailSubject=null;
		        
		        String moveDeptNo= StringPool.BLANK;
		        String currentDeptNo = StringPool.BLANK;
		      Map<String, String> emailMap= new HashMap<String, String>();
		        try{
		            
		            if(currentPosid!=null){
		          		
		                WFMS_Position currentPositionData=WFMS_PositionLocalServiceUtil.findByposition(currentPosid);
		      
		                WFMS_Position modifiedPositionData=WFMS_PositionLocalServiceUtil.findByposition(movePositionId);
		              // //System.out.println("movePositionId:"+movePositionId);
							String assocName = currentPositionData.getAssociateName();
							String assocTitle = currentPositionData.getAssociateTitle();
							String mpCategory = currentPositionData.getMpCatFilledWith();
							String assocNumber = currentPositionData.getAssociateNumber();
							currentDeptNo = currentPositionData.getDepartmentNumber();
							
							modifiedPositionData.setNextApprover("");
							modifiedPositionData.setAssociateName(assocName);
							modifiedPositionData.setAssociateTitle(assocTitle);
							modifiedPositionData.setMpCatFilledWith(mpCategory);
							modifiedPositionData.setAssociateNumber(assocNumber);
							modifiedPositionData.setModifiedDate(createdate);
							modifiedPositionData.setModifiedBy(userFullName);
							modifiedPositionData.setNextApprover("");
							modifiedPositionData.setStatus(HondaPermissionKeys.POS_FILLED);
							moveDeptNo =modifiedPositionData.getDepartmentNumber();
							
							 //POS_OPEN
							//emailMap=hondaLogicUtil.singleCallOnServieNow(modifiedPositionData.getDepartmentNumber());
							//st2=assocName+StringPool.OPEN_BRACKET+assocNumber+StringPool.CLOSE_BRACKET+"moved from position"+currentPosid+"to position"+movePositionId;
                             ////_log.info("mpwrrep_email <mpwrrep_email></mpwrrep_email>" +emailMap.get("mpwrrep_email"));
                            
						       	WFMS_PositionLocalServiceUtil.updateWFMS_Position(modifiedPositionData);
							     emailMessage="Position is Filled <br/>  <a href='"+GenerateFrindlyURL.getHMAfrindlyURL(actionRequest, modifiedPositionData.getPId())+"'>Click here to review the record</a>";
	                             emailSubject=currentPositionData.getPId()+HondaPermissionKeys.POS_FILLED+" While Move associate";
	                                   
	                             emailMessage="This Position " +movePositionId+" is Filled <br/>  <a href='"+GenerateFrindlyURL.getHMAfrindlyURL(actionRequest,movePositionId)+"'>Click here to review the record</a>";
	                             emailSubject= "This Position Number " +movePositionId+" is "+HondaPermissionKeys.POS_FILLED;
	                                
	                             //     Associate has been moved 
								// EmailUtility.sendEmail("DMP ", "DMP ", PortletProps.get("mail.config.verify.mail"), PortletProps.get("mail.config.verify.mail"), emailSubject, emailMessage);
	                             
	                            if(!currentDeptNo.equalsIgnoreCase(moveDeptNo)){ 
	                            	EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, modifiedPositionData.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
	   	                          	
	                           }
	                            else{
	                                
	                            }
	                            st1=assocName+StringPool.SPACE+StringPool.OPEN_BRACKET+assocNumber+StringPool.CLOSE_BRACKET+StringPool.SPACE+" moved from position "+StringPool.SPACE+currentPosid+StringPool.SPACE+" to position "+StringPool.SPACE+movePositionId;	 
							currentPositionData.setAssociateName("");
							currentPositionData.setAssociateTitle("");
							currentPositionData.setMpCatFilledWith("");
							currentPositionData.setAssociateNumber("");
							currentPositionData.setNextApprover("");
							currentPositionData.setStatus(HondaPermissionKeys.POS_OPEN);
							currentPositionData.setModifiedDate(createdate);
							currentPositionData.setModifiedBy(userFullName);
							WFMS_PositionLocalServiceUtil.updateWFMS_Position(currentPositionData);
							/*<mpwrrep_email>Todd_Sheats@hma.honda.com</mpwrrep_email>
							<mgr_email>Jay_Johnson@hma.honda.com</mgr_email> */
						//	emailMap=hondaLogicUtil.singleCallOnServieNow(currentPositionData.getDepartmentNumber());
							//st2=assocName+StringPool.OPEN_BRACKET+assocNumber+StringPool.CLOSE_BRACKET+"moved from position"+currentPosid+"to position"+movePositionId;
                             ////_log.info("mpwrrep_email <mpwrrep_email></mpwrrep_email>" +emailMap.get("mpwrrep_email"));
                            
                             emailMessage="This Position " +currentPosid+" is Open as  we have moved Associate <br/> Click the below link to access the position. <br/> <a href='"+GenerateFrindlyURL.getHMAfrindlyURL(actionRequest, currentPosid)+"'>Click here to review the record</a>";
                             //emailSubject= "This Position Number " +currentPosid+" is "+HondaPermissionKeys.POS_OPEN+" as Associate has been moved";
                             emailSubject = "Department Manpower Controller:Position "+movePositionId+" for "+assocNumber+","+assocName+" as associate has been moved";
                            
                             if(!currentDeptNo.equalsIgnoreCase(moveDeptNo)){ 
                                 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, currentPositionData.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
                                 
	                           }
                             else{
                            	 
                            }
						//	 EmailUtility.sendEmail("DMP ", "DMP ", PortletProps.get("mail.config.verify.mail"), PortletProps.get("mail.config.verify.mail"), emailSubject, emailMessage);
							//Audit log insert
							
							HondaLogicUtil.auditLogsForPosition(currentPosid, assocNumber, st1, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
							HondaLogicUtil.auditLogsForPosition(currentPosid, "", HondaPermissionKeys.POS_OPEN, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
							HondaLogicUtil.auditLogsForAssociateHistory(assocNumber,"Moved from position "+currentPosid+" to position "+movePositionId,movePositionId, actionRequest);
						    HondaLogicUtil.auditLogsForPositionwithTwoPid(movePositionId, assocNumber,currentPosid, st1, WorkflowConstants.POSITION_ACTOIN, actionRequest);
							HondaLogicUtil.auditLogsForPosition(movePositionId, "", HondaPermissionKeys.POS_FILLED, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
							
							DynamicQuery dynamicQueryForCos =WFMS_COSLocalServiceUtil.dynamicQuery();
							dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").eq(assocNumber));
							List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
							////System.out.println("cosList.size:"+cosList.size());
						   if(cosList.size()>0){
							   String cosId=cosList.get(0).getCosId();
							 //  //System.out.println("cosId:"+cosId);
							   HondaLogicUtil.auditLogsForReqAndCOS(cosId, st1, WorkflowConstants.CHANGE_OF_STATUS_ACTION, actionRequest, "Position "+currentPosid+" move to "+HondaPermissionKeys.POS_OPEN);
							   HondaLogicUtil.auditLogsForReqAndCOS(cosId, st1, WorkflowConstants.CHANGE_OF_STATUS_ACTION, actionRequest, "Position "+movePositionId+" move to "+HondaPermissionKeys.POS_FILLED);
							   //WFMS_COS cosData=WFMS_COSLocalServiceUtil.findBycos(cosId);
							   //cosData.setPositionNumber(movePositionId);
							  // WFMS_COSLocalServiceUtil.updateWFMS_COS(cosData);
						   }
							
	                  if(generateRequisation.equals("1")){
	                	//  //System.out.println("Entered");
							//////_log.info("isAutoGenerate true:" + isAutoGenerate);
	      				User user = UserLocalServiceUtil.getUserById(userId);
	      				long companyId = user.getCompanyId();
	      				Group group = user.getGroup();
	                	  HondaLogicUtil hondaLogicUtil = new HondaLogicUtil();
							WFMS_Requisition entry = new WFMS_RequisitionImpl();
							String id = hondaLogicUtil.geneateRequisitionId(currentPositionData.getDepartmentNumber());	
							entry.setRwfId(id);
							entry.setStatus(HondaPermissionKeys.POS_DRAFT);
							entry.setRId(currentPositionData.getPId());
							entry.setCreateDate(createdate);
							entry.setDummy("0");
							entry.setCreatedBy(user.getFullName());
							Map<String, String>	hondamap=null;
							if(Validator.isNotNull(currentPositionData.getDepartmentNumber())){
							hondamap=hondaLogicUtil.singleCallOnServieNow(currentPositionData.getDepartmentNumber());
							}
							entry.setNextapprove(hondamap.get("mpwrrep_name"));
							/*Mail send regards */	
							WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
							HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, actionRequest, currentPositionData.getComments());

							
							 emailMessage="This requisition has been created and needs you to input the required information and submit.<br/> Click the below link to access the requisition.";
							 emailSubject = "Department Manpower Controller: Manpower Requisition "+id+"  has been created.";
							String url=GenerateFrindlyURL.getURLForRequisition( actionRequest, id);
							emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
							EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, currentPositionData.getDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
							
							WFMS_RequisitionLocalServiceUtil.clearCache();
							//HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request, comments);
							PortletSession session = actionRequest.getPortletSession();
							//actionRequest.setAttribute("posid", currentPositionData.getPId());
							//actionRequest.setAttribute("reqcid", id);
							session.setAttribute("posid", currentPositionData.getPId(),PortletSession.APPLICATION_SCOPE);
							
							WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(currentPositionData.getPId());
						/*	actionRequest.setAttribute("positionId", wfms_Position.getPId());
							actionRequest.setAttribute("requisitionId", id);
							actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
							actionRequest.setAttribute("create", "Create");
							actionResponse.setRenderParameter("jspPage","/html/requisition/manageRequisition.jsp");
							*/
							Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/requisition");
							PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest,"Requisition",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
							portletURL.setWindowState(WindowState.NORMAL);
							portletURL.setParameter(ActionRequest.ACTION_NAME,"editRequisition");
							portletURL.setParameter("positionId",id);
							actionResponse.sendRedirect(portletURL.toString());
	                   }else{
	                	  // //System.out.println("NotEntered");
	                   }	
		           }
		                    
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		    
		    }
		//Swap Associate Workflow 
	
	public void swapAssociate(ActionRequest actionRequest,ActionResponse actionResponse) throws PortletException, IOException, SystemException{
        
        String currentPosid = actionRequest.getParameter("posId");
        String currentAssociateIds= actionRequest.getParameter("currentAssociateNumber");
        String newAssociateId= actionRequest.getParameter("selectedAssocId");
        String st1=StringPool.BLANK;
        String st2=StringPool.BLANK;
        try{
            
            if(currentPosid!=null){
          		//HondaLogicUtil.auditLogsForPosition( currentPosid, newAssocId, WorkflowConstants.POSITION_SWAP_ASSOCIATE,WorkflowConstants.POSITION_ACTOIN,actionRequest);
                List<WFMS_Position> new_position_list=WFMS_PositionLocalServiceUtil.findByAssociateNumber(newAssociateId);
                      int i=0;        
               for(WFMS_Position use:new_position_list){ i++;
               
					WFMS_Position requp = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(use.getPId());
					WFMS_Position requp1 = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(currentPosid);
					String assocName = requp1.getAssociateName();
					String assocTitle = requp1.getAssociateTitle();
					String mpCategory = requp1.getMpCatFilledWith();
					
					String assocName1 = requp.getAssociateName();
					String assocTitle1 = requp.getAssociateTitle();
					String mpCategory1 = requp.getMpCatFilledWith();
					
					 requp.setAssociateName(assocName);
					 requp.setAssociateTitle(assocTitle);
					 requp.setMpCatFilledWith(mpCategory);
					 requp.setAssociateNumber(currentAssociateIds); 
					 
					 st1=assocName+StringPool.SPACE+StringPool.OPEN_BRACKET+currentAssociateIds+StringPool.CLOSE_BRACKET+StringPool.SPACE+"swapped with"+StringPool.SPACE;
						
					 WFMS_PositionLocalServiceUtil.updateWFMS_Position(requp);
					 
					//Audit log insert
		             HondaLogicUtil.auditLogsForPositionwithTwoPid( use.getPId(), currentAssociateIds,requp1.getPId(), WorkflowConstants.POSITION_SWAP_ASSOCIATE,WorkflowConstants.POSITION_ACTOIN,actionRequest);
		    			
						 requp1.setAssociateName(assocName1);
						 requp1.setAssociateTitle(assocTitle1);
						 requp1.setMpCatFilledWith(mpCategory1);

					 requp1.setAssociateNumber(newAssociateId);
					 
					 st2=assocName1+StringPool.SPACE+StringPool.OPEN_BRACKET+newAssociateId+StringPool.CLOSE_BRACKET;
					 WFMS_PositionLocalServiceUtil.updateWFMS_Position(requp1);
					 //Audit log insert
					
					 HondaLogicUtil.auditLogsForAssociateHistory(currentAssociateIds,"Swapped from position "+requp1.getPId()+" to position "+use.getPId(),use.getPId(), actionRequest);
					 HondaLogicUtil.auditLogsForAssociateHistory(newAssociateId,"Swapped from position "+use.getPId()+" to position "+requp1.getPId(),requp1.getPId(), actionRequest);
					 
					 HondaLogicUtil.auditLogsForPositionwithTwoPid(requp1.getPId(), newAssociateId,use.getPId(), WorkflowConstants.POSITION_SWAP_ASSOCIATE,WorkflowConstants.POSITION_ACTOIN,actionRequest);
					 HondaLogicUtil.auditLogsForPositionwithTwoPid(requp1.getPId(), newAssociateId,use.getPId(), st1+st2,WorkflowConstants.POSITION_ACTOIN,actionRequest);
					 if(i==1) break;
				}
               actionResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(actionRequest));
           }
                    
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }


public void terminateAssociate(ActionRequest request, ActionResponse response)throws Exception{
		
		String associateId = null;
		String associateNumber = null;
		String associateName = null;
		Long companyId = null;
		String logForTerminate=StringPool.BLANK;
		String moveTodirect = StringPool.BLANK;
		WFMS_Position wfms_Position =null;
		String positionId = request.getParameter("positionId");
		String actionPosition = request.getParameter("actionposition");
		Map<String, String> emailMap=new HashMap<String, String>();
		String emailMessage=null;
		String emailSubject=null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		if(positionId == null || positionId.equals(""))
			associateNumber = (String)request.getAttribute("associateId");
		String YesOrNo = ParamUtil.getString(request, "modalvalue");
		if(YesOrNo == null || YesOrNo.equals("")){
		//String positionId = ParamUtil.getString(request, "positionId");
		try{
			if(null != request.getParameter("positionId"))
				wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
			else if(null != associateNumber){
				//wfms_Position=  WFMS_PositionLocalServiceUtil.getByAssociateNumber(associateNumber);
				DynamicQuery dynamicQuery = WFMS_PositionLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("associateNumber").eq(associateNumber));
				List<WFMS_Position> numberList;
					numberList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQuery);
					if (numberList.size() > 0) 
						 wfms_Position = numberList.get(0);
			}
			if(null != wfms_Position){
		associateId = wfms_Position.getAssociateNumber();
		associateName = wfms_Position.getAssociateName();
		companyId = wfms_Position.getCompanyId();
		wfms_Position.setAssociateNumber("");
		wfms_Position.setAssociateName("");
		wfms_Position.setAssociateTitle("");
		wfms_Position.setMpCatFilledWith("");
		wfms_Position.setNextApprover("");
		wfms_Position.setStatus(HondaPermissionKeys.POS_OPEN);
		
		logForTerminate=associateName+StringPool.SPACE+StringPool.OPEN_BRACKET+associateId+StringPool.CLOSE_BRACKET+StringPool.SPACE+" is Terminated "+StringPool.SPACE;
		
		WFMS_PositionLocalServiceUtil.updatePositionEntry(wfms_Position);
		emailMap=hondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
		//st2=assocName+StringPool.OPEN_BRACKET+assocNumber+StringPool.CLOSE_BRACKET+"moved from position"+currentPosid+"to position"+movePositionId;
         ////_log.info("mpwrrep_email <mpwrrep_email></mpwrrep_email>" +emailMap.get("mpwrrep_email"));
        
		    emailMessage="This Position is now Open because Associate " +wfms_Position.getAssociateNumber()+"  has been removed. <br/> Click the below link to access the position.<br/>  <a href='"+GenerateFrindlyURL.getHMAfrindlyURL(request, wfms_Position.getPId())+"'>Click here to review the record</a>";
             emailSubject= "Department Manpower Controller:Position "+wfms_Position.getPId()+" is now Open because "+associateName+","+associateId+" was removed.";
			 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_Position.getDepartmentNumber(), request, emailSubject, emailMessage);
			 

			    emailMessage="This Position is now Open because Associate " +wfms_Position.getAssociateNumber()+"  has been removed. <br/> Click the below link to access the position.<br/>  <a href='"+GenerateFrindlyURL.getHMAfrindlyURL(request, wfms_Position.getPId())+"'>Click here to review the record</a>";
	             emailSubject= "Department Manager:Position "+wfms_Position.getPId()+" is now Open because "+associateName+","+associateId+" was removed.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_Position.getDepartmentNumber(), request, emailSubject, emailMessage);
		
		if(positionId!=null)
		   HondaLogicUtil.auditLogsForAssociateHistory(associateId,"Terminated from position "+positionId,"", request);
			}
		}catch(SystemException e){
			_log.error("[terminateAssociate]" +e);
		}
		moveTodirect="This position is an open "+StringPool.OPEN_BRACKET+associateName+StringPool.CLOSE_BRACKET+StringPool.SPACE+StringPool.OPEN_BRACKET+associateId+StringPool.CLOSE_BRACKET+StringPool.SPACE+" has been moved to direct position "+StringPool.SPACE;
		
		WFMS_Position_Audit positionAudit = null;
	
		long posId = CounterLocalServiceUtil.increment(WFMS_Position_Audit.class.getName());
		String audId =String.valueOf(posId);
		positionAudit = new WFMS_Position_AuditImpl();
		positionAudit.setPaId(audId);
		if(wfms_Position.getPId() != null)
		positionAudit.setPId(wfms_Position.getPId());
		positionAudit.setUserId(userId);
		positionAudit.setAssociateId(associateId);
		if(associateNumber != null)
		positionAudit.setChange(moveTodirect);
		else if(positionId != null)
		positionAudit.setChange(logForTerminate);
		positionAudit.setCreateDate(new Date());
		positionAudit.setCreatedBy(user.getFullName());
		try{
		WFMS_Position_AuditLocalServiceUtil.addWFMS_Position_Audit(positionAudit);
		}catch(Exception e){
			_log.error("[terminateAssociate]" +e);
		}
		
		if (wfms_Position.getAutoGenerateReq().equalsIgnoreCase("true")) {
		String status = HondaPermissionKeys.POS_DRAFT;
		Date createDate = new Date();
		WFMS_Requisition entry = new WFMS_RequisitionImpl();
		String id =hondaLogicUtil.geneateRequisitionId(wfms_Position.getDepartmentNumber());	

		entry.setRwfId(id);
		entry.setStatus(status);
		if(wfms_Position.getPId() !=null )
			entry.setRId(wfms_Position.getPId());
		entry.setCreateDate(createDate);
		entry.setDummy("0");
		entry.setCreatedBy(user.getFullName());
		Map<String, String>	hondamap=null;
		if(Validator.isNotNull(wfms_Position.getDepartmentNumber())){
		hondamap=hondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
		}
		entry.setNextapprove(hondamap.get("mpwrrep_name"));
		WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
		HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request, null);
		}
		wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(wfms_Position.getPId());
		Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
		PortletURL portletURL = PortletURLFactoryUtil.create(request,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
		portletURL.setWindowState(WindowState.NORMAL);
		if(Validator.isNotNull(actionPosition)){
			portletURL.setParameter("autoReqAfterTerminate", "autoreqModal");
			}
		portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
		portletURL.setParameter("positionId", wfms_Position.getPId());
		/* Hide the redirect action to requisation edit page
		    response.sendRedirect(portletURL.toString());
		 */	
		}else if(YesOrNo.equals("true") || YesOrNo.equals("false")){
			PortletSession session = request.getPortletSession();
			String status;
			try{
				WFMS_Position wfmsPosition = WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
			if (wfmsPosition.getAutoGenerateReq().equalsIgnoreCase("false") && YesOrNo.equalsIgnoreCase("false")) {
				request.setAttribute("positionId", wfmsPosition.getPId());
				request.setAttribute("wfms_PositionObj", wfmsPosition);

				/* Hide the redirect action to requisation edit page 	
				   response.sendRedirect(GenerateFrindlyURL.getHMAfrindlyURL(request, wfmsPosition.getPId()));
			     */
			} else if (wfmsPosition.getAutoGenerateReq().equalsIgnoreCase("false") && YesOrNo.equalsIgnoreCase("true")) {
				WFMS_Position wfms_Pos = WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
				Date createDate = new Date();
				WFMS_Requisition entry = new WFMS_RequisitionImpl();
				String id=StringPool.BLANK;
				if(Validator.isNotNull(wfms_Pos.getDepartmentNumber())){
				 id = hondaLogicUtil.geneateRequisitionId(wfms_Pos.getDepartmentNumber());	
				}
				
				entry.setRwfId(id);
				entry.setStatus(HondaPermissionKeys.POS_DRAFT);
				entry.setRId(wfms_Pos.getPId());
				entry.setCreateDate(createDate);
				entry.setDummy("0");
				entry.setCreatedBy(user.getFullName());
				/*Mail send regards */	
				Map<String, String>	hondamap=null;
				if(Validator.isNotNull(wfms_Pos.getDepartmentNumber())){
				hondamap=hondaLogicUtil.singleCallOnServieNow(wfms_Pos.getDepartmentNumber());
				}
				entry.setNextapprove(hondamap.get("mpwrrep_name"));
			
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
				HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request, null);
				
				 emailMessage="This requisition has been created and needs you to input the required information and submit. <br/> Click the below link to access the requisition.";
				 emailSubject = "Department Manpower Controller: Manpower Requisition"+id+" has been created.";
				String url=GenerateFrindlyURL.getURLForRequisition( request, id);
				emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
				EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfmsPosition.getDepartmentNumber(), request, emailSubject, emailMessage);
				
				WFMS_RequisitionLocalServiceUtil.clearCache();
				long posid = (CounterLocalServiceUtil.increment(WFMS_Position.class.getName()));
				session.setAttribute("posid", posid,PortletSession.APPLICATION_SCOPE);
				Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/requisition");
				PortletURL portletURL = PortletURLFactoryUtil.create(request,"Requisition",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
				portletURL.setWindowState(WindowState.NORMAL);
				portletURL.setParameter(ActionRequest.ACTION_NAME,"editRequisition");
				portletURL.setParameter("positionId",id);
				
				/* Hide the redirect action to requisation edit page 
				   response.sendRedirect(portletURL.toString());
				 */
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			
		}
		}
	
	}

public void cancelPosition(ActionRequest req, ActionResponse res)
		throws PortletException, IOException, SystemException, PortalException {
	String positionid = req.getParameter("positionid");
	////_log.info("positionid:"+positionid);
	
	List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
	
	DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
	wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionid));
	int wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
	
	if(wfmPositionforTempcount > 0){
		////_log.info("enter tpo 3:");
	       WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionid);
	}
	wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
	wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionid+"-WFM"));
	wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);
	if(wfmPositionforTempcount > 0){
		////_log.info("enter tpo 1:");
		WFMS_Position wfmsPosition = WFMS_PositionLocalServiceUtil.getByPositionId(positionid+"-WFM");
		wfmsPosition.setDummy("0");
		wfmsPosition.setPId(positionid);
		wfmsPosition=WFMS_PositionLocalServiceUtil.updatePositionEntry(wfmsPosition);       
	    wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
		wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(positionid+"-WFM"));
		wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);	
		if(wfmPositionforTempcount > 0){
			////_log.info("enter tpo 4:");
		    WFMS_PositionLocalServiceUtil.deleteWFMS_Position(positionid+"-WFM");
		}
	    req.setAttribute("positionId", positionid);
	    req.setAttribute("wfms_PositionObj", wfmsPosition);
	}	
	res.sendRedirect(GenerateFrindlyURL.renderManagePosition(req));
}

public void gettingFormCOS(ActionRequest actionRequest,
		ActionResponse actionResponse) throws IOException, PortletException {
	// TODO Auto-generated method stub
	////_log.info("<<<<<:::gettingFormCOS:::::>>>>");
}
/*public void modifyPosition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, AddressException, PortalException, WindowStateException, PortletModeException{
	String posid = ParamUtil.getString(actionRequest, "pid");
    WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
	int currentStep=Validator.isNotNull(wfms_Position.getWorkflowStep())?wfms_Position.getWorkflowStep():0;
	//ModifyPositionWorkflowContext.processModifyPosition(currentStep, actionRequest, actionResponse);
	////_log.info(currentStep);
	
}*/
	public static void approvePositionForModify(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException, PortalException, AddressException, JSONException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//WFMS_Requisition req_main=null;
		long wfmReqcount=0;
		String posid = ParamUtil.getString(actionRequest, "positionId");
		WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
		int currentStep = Validator.isNotNull(wfms_Position.getWorkflowStep()) ? wfms_Position.getWorkflowStep() : 0;
		////_log.info("get current step:::" + currentStep);
		try {
			String keyValue = ModifyPositionWorkflowContext.processModifyPosition(currentStep, actionRequest, actionResponse);
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionRequest.setAttribute("positionId", wfms_Position.getPId());
		actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
		

		/*String changesList="";
		String url=GenerateFrindlyURL.getHMAfrindlyURL(actionRequest, posid);
		String subject ="Staffing: Position" + posid + "has been modified and needs your approval.";
		String body ="Position " + posid + " has been modified "+changesList+" .<br/> Please click the link below to approve the position.<br/> <p><a href='"+url+"'> Click here to review the record</a></p>";
		EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING, null, actionRequest,subject, body);*/
		
		
		DynamicQuery reqiseixt =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
		reqiseixt.add(PropertyFactoryUtil.forName("rId").eq(posid));
		List<WFMS_Requisition> listReq=WFMS_RequisitionLocalServiceUtil.dynamicQuery(reqiseixt);
		
		DynamicQuery wfmReq =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
		wfmReq.add(PropertyFactoryUtil.forName("rId").eq(posid));
		wfmReq.add(PropertyFactoryUtil.forName("status").ne(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER));
		wfmReqcount = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(wfmReq);
		WFMS_Requisition requisition= WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(posid);
////_log.info(listReq.size());
////_log.info(wfmReqcount);
		//	if(listReq.size()> 0 && wfmReqcount >0){
if(Validator.isNull(actionRequest.getAttribute("ModifyPosPopUpforReq"))){
		HondaLogicUtil.auditLogsForPosition(posid, null,WorkflowConstants.POSITION_APPROVE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
}
//  actionResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");

//actionResponse.sendRedirect(GenerateFrindlyURL.renderManagePosition(actionRequest));
/*
			if(listReq.size()>0 && wfmReqcount == 0){
				HondaLogicUtil.auditLogsForPosition(posid, null,WorkflowConstants.POSITION_APPROVE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,"");
			}*/
	}

	public void disapprovePositionForModify(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException, PortalException, AddressException, JSONException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String posid = ParamUtil.getString(actionRequest, "positionId");
		String comments = ParamUtil.getString(actionRequest, "Comments");
		WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);
		int currentStep = Validator.isNotNull(wfms_Position.getWorkflowStep()) ? wfms_Position.getWorkflowStep() : 0;		
		try {
			ModifyPositionWorkflowContext.processModifyPosition(currentStep,actionRequest, actionResponse);
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(posid);


		String emailMessage="Modifications to this position have been disapproved. <br/> Disapproval Comments: "+ comments  +" <br/>  Click the below link to access the position.";
		String emailSubject =  "Department Manpower Controller: Modifications to Position " +posid+" have been disapproved.";

		 String url=	GenerateFrindlyURL.getHMAfrindlyURL( actionRequest,posid);
		 emailMessage = emailMessage +"<br/>  <a href='"+url+"'>Click here to review the record</a>";
		String deptNum=wfms_Position.getDepartmentNumber();
		EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, deptNum, actionRequest, emailSubject, emailMessage);
		HondaLogicUtil.auditLogsForPosition(posid, null, WorkflowConstants.POSITION_DISAPPROVE_POSITION, WorkflowConstants.POSITION_ACTOIN, actionRequest,comments);
	}
	
	public void saveEmpIdForPosition(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException, PortalException, AddressException, JSONException {
		////_log.info("::: Inside saveEmpIdForPosition :::");
		String positionId = ParamUtil.getString(actionRequest, "posId");
		  //_log.info(positionId);
		String empCategoryStep = ParamUtil.getString(actionRequest, "empCategoryStep");
	    //_log.info(empCategoryStep);
	    
	    Map<String, String> shiftMap = new HashMap<String, String>();
		 String empcatDesc=StringPool.BLANK;
         try {
			shiftMap = ConfigUtility.getInputValuesForMap("Employe-category");
			Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
	         for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {	
	        	  if(entry.getKey().equalsIgnoreCase(empCategoryStep)){
	        		  empcatDesc=entry.getValue();            		  
	        	  }
	         }
		} catch (com.liferay.portal.kernel.json.JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
         WFMS_Position wfms_Position=null;
		////_log.info(empCategoryDesc);
         try {
     		 wfms_Position = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(positionId);
     		wfms_Position.setEmpCategory(empCategoryStep);
    	 	wfms_Position.setEmpCategoryDesc(empcatDesc);
    		wfms_Position.setWorkflowStep(21);
    		wfms_Position=WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);

		} catch (Exception e) {
			// TODO: handle exception
		}
         
		////_log.info("::: empCategoryStep :::"+empCategoryStep);
		actionRequest.setAttribute("positionId", positionId);
		actionRequest.setAttribute("wfms_PositionObj", wfms_Position);
		//request.setAttribute("autoReqAfterTerminate", "autoreqModal");
		//actionResponse.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");
		actionResponse.sendRedirect(GenerateFrindlyURL.getHMAfrindlyURL(actionRequest, positionId));
	}
	public void approvePositionForYes(ActionRequest req, ActionResponse res) throws SystemException, PortalException, IOException, JSONException, WindowStateException, PortletModeException{
		 String posid = ParamUtil.getString(req, "pid");
	    WFMS_Position  wfms_Position=WFMS_PositionLocalServiceUtil.findByposition(posid);
		 if(wfms_Position.getAutoGenerateReq().equalsIgnoreCase("true") ){
			 wfms_Position.setStatus(HondaPermissionKeys.POS_OPEN);
			 wfms_Position.setNextApprover(""); 
			 wfms_Position.setWorkflowStep(-1);
			 wfms_Position=WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_Position);
            
              String emailSubject =  "Notification: Hello "+HondaPermissionKeys.ROLE_PAYROLL+" this Position "+wfms_Position.getPId()+" is Approved";
              String emailMessage="A new position needs you to add the employee category  and approve.";
			  String url=	GenerateFrindlyURL.getHMAfrindlyURL( req, wfms_Position.getPId());
				 emailMessage = emailMessage +" <br/>  <a href='"+url+"'>Click here to review the record</a>";
			 ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
				long userId = themeDisplay.getUserId();
				User user = UserLocalServiceUtil.getUserById(userId);
				long companyId = user.getCompanyId();
				Group group = user.getGroup();
				long scopeGroupId = group.getGroupId();
			    ////_log.info("isAutoGenerate true:" + wfms_Position.getAutoGenerateReq());
				Date createDate = new Date();
				WFMS_Requisition entry = new WFMS_RequisitionImpl();
				String id=null;
				try {
					id = hondaLogicUtil.geneateRequisitionId(wfms_Position.getDepartmentNumber());
				} catch (com.liferay.portal.kernel.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				entry.setRwfId(id);
				entry.setStatus(HondaPermissionKeys.POS_DRAFT);
				entry.setRId(wfms_Position.getPId());
				entry.setCreateDate(createDate);
				entry.setDummy("0");
				entry.setCompanyId(companyId);
				entry.setScopeGroupId(scopeGroupId);
				entry.setCreatedBy(user.getFullName());
				Map<String, String>	hondamap=null;
				if(Validator.isNotNull(wfms_Position.getDepartmentNumber())){
				try {
					hondamap=hondaLogicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
				} catch (com.liferay.portal.kernel.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				entry.setNextapprove(hondamap.get("mpwrrep_name"));
			
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
				HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, req , "");
				 emailMessage="This requisition has been created and needs you to input the required information and submit.<br/> Click the below link to access the requisition.";
				 emailSubject = "Department Manpower Controller: Manpower Requisition "+id+" has been created.";
				 url=GenerateFrindlyURL.getURLForRequisition( req, id);
				emailMessage = emailMessage +"<br/> <a href='"+url+"'>Click here to review the record</a>";
				EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_Position.getDepartmentNumber(), req, emailSubject, emailMessage);
				WFMS_RequisitionLocalServiceUtil.clearCache();
				res.sendRedirect(GenerateFrindlyURL.renderManagePosition(req));


		 }
		
	}
	private static Log _log = LogFactoryUtil.getLog(PositionPortlet.class.getName());
	private static PrintWriter writer; 
	HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();

}
